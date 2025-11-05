package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.friendsuggestions.FriendSuggestion;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.message.Message;
import com.discord.api.premium.PremiumTier;
import com.discord.api.presence.Presence;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.NsfwAllowance;
import com.discord.api.user.User;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.user.CoreUser;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMessagesLoader;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.user.UserRequestManager;
import com.discord.utilities.user.UserUtils;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: StoreUser.kt */
/* loaded from: classes2.dex */
public final class StoreUser extends StoreV2 {
    private final Dispatcher dispatcher;
    private MeUser me;
    private final Persister<MeUser> meCache;
    private MeUser meSnapshot;
    private final Function1<User, Unit> notifyUserUpdated;
    private final ObservationDeck observationDeck;
    private final UserRequestManager userRequestManager;
    private final SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> users;
    private Map<Long, ? extends com.discord.models.user.User> usersSnapshot;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource MeUpdate = new StoreUser$Companion$MeUpdate$1();
    private static final ObservationDeck.UpdateSource UsersUpdate = new StoreUser$Companion$UsersUpdate$1();
    private static final MeUser EMPTY_ME_USER = new MeUser(0, "EMPTY_USERNAME", null, null, false, false, 0, PremiumTier.NONE, null, false, false, null, 0, 0, null, NsfwAllowance.UNKNOWN, null, null, 204800, null);

    /* compiled from: StoreUser.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ObservationDeck.UpdateSource getMeUpdate() {
            return StoreUser.access$getMeUpdate$cp();
        }

        public final ObservationDeck.UpdateSource getUsersUpdate() {
            return StoreUser.access$getUsersUpdate$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$fetchUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ List $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list) {
            super(0);
            this.$users = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser storeUser = StoreUser.this;
            StoreUser.access$fetchMissing(storeUser, this.$users, storeUser.getUsers().keySet());
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeAllUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends com.discord.models.user.User>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.user.User> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends com.discord.models.user.User> invoke2() {
            return StoreUser.this.getUsers();
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeMe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<MeUser> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ MeUser invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MeUser invoke() {
            return StoreUser.access$getMe$p(StoreUser.this);
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeMe$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<MeUser, Boolean> {
        public final /* synthetic */ boolean $emitEmpty;

        public AnonymousClass2(boolean z2) {
            this.$emitEmpty = z2;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            return Boolean.valueOf(meUser != StoreUser.access$getEMPTY_ME_USER$cp() || this.$emitEmpty);
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeMeId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreUser.access$getMe$p(StoreUser.this).getId();
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends com.discord.models.user.User>, com.discord.models.user.User> {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ com.discord.models.user.User call(Map<Long, ? extends com.discord.models.user.User> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final com.discord.models.user.User call2(Map<Long, ? extends com.discord.models.user.User> map) {
            m.checkNotNullParameter(map, "user");
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeUsernames$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<com.discord.models.user.User, String> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(com.discord.models.user.User user) {
            return invoke2(user);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(com.discord.models.user.User user) {
            m.checkNotNull(user);
            return user.getUsername();
        }
    }

    /* compiled from: StoreUser.kt */
    /* renamed from: com.discord.stores.StoreUser$observeUsers$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Map<Long, ? extends com.discord.models.user.User>> {
        public final /* synthetic */ boolean $fetchUserIfMissing;
        public final /* synthetic */ Collection $userIds;

        public AnonymousClass1(boolean z2, Collection collection) {
            this.$fetchUserIfMissing = z2;
            this.$userIds = collection;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Map<Long, ? extends com.discord.models.user.User> map) {
            call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Map<Long, ? extends com.discord.models.user.User> map) {
            if (this.$fetchUserIfMissing) {
                StoreUser.access$fetchMissing(StoreUser.this, this.$userIds, map.keySet());
            }
        }
    }

    public /* synthetic */ StoreUser(Function1 function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 8) != 0 ? new Persister("STORE_USERS_ME_V13", EMPTY_ME_USER) : persister);
    }

    public static final /* synthetic */ void access$fetchMissing(StoreUser storeUser, Collection collection, Set set) {
        storeUser.fetchMissing(collection, set);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUser storeUser) {
        return storeUser.dispatcher;
    }

    public static final /* synthetic */ MeUser access$getEMPTY_ME_USER$cp() {
        return EMPTY_ME_USER;
    }

    public static final /* synthetic */ MeUser access$getMe$p(StoreUser storeUser) {
        return storeUser.me;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getMeUpdate$cp() {
        return MeUpdate;
    }

    public static final /* synthetic */ Function1 access$getNotifyUserUpdated$p(StoreUser storeUser) {
        return storeUser.notifyUserUpdated;
    }

    public static final /* synthetic */ ObservationDeck.UpdateSource access$getUsersUpdate$cp() {
        return UsersUpdate;
    }

    public static final /* synthetic */ void access$setMe$p(StoreUser storeUser, MeUser meUser) {
        storeUser.me = meUser;
    }

    @StoreThread
    private final void fetchMissing(Collection<Long> totalUserIds, Set<Long> existingUserIds) {
        HashSet hashSet = new HashSet();
        Iterator<Long> it = totalUserIds.iterator();
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (!existingUserIds.contains(Long.valueOf(jLongValue))) {
                hashSet.add(Long.valueOf(jLongValue));
            }
        }
        this.userRequestManager.requestUsers(hashSet);
    }

    public static /* synthetic */ Observable observeMe$default(StoreUser storeUser, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        return storeUser.observeMe(z2);
    }

    @StoreThread
    private final void updateUser(User user) {
        CoreUser coreUser = new CoreUser(user);
        if (!m.areEqual(coreUser, this.users.get(Long.valueOf(user.getId())))) {
            this.users.put(Long.valueOf(user.getId()), coreUser);
            markChanged(UsersUpdate);
        }
    }

    public final void fetchUsers(List<Long> users) {
        m.checkNotNullParameter(users, "users");
        this.dispatcher.schedule(new AnonymousClass1(users));
    }

    /* renamed from: getMe, reason: from getter */
    public final MeUser getMeSnapshot() {
        return this.meSnapshot;
    }

    @StoreThread
    /* renamed from: getMeInternal$app_productionGoogleRelease, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final Map<Long, com.discord.models.user.User> getUsers() {
        return this.usersSnapshot;
    }

    @StoreThread
    public final Map<Long, com.discord.models.user.User> getUsersInternal$app_productionGoogleRelease() {
        return this.users;
    }

    @StoreThread
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            markChanged(MeUpdate);
            this.me = EMPTY_ME_USER;
        }
    }

    @StoreThread
    public final void handleChannelCreated(Channel channel) {
        m.checkNotNullParameter(channel, "channel");
        List<User> listZ = channel.z();
        if (listZ != null) {
            Iterator<T> it = listZ.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.users.clear();
        User me2 = payload.getMe();
        m.checkNotNullExpressionValue(me2, "payload.me");
        MeUser meUser = new MeUser(me2);
        this.me = meUser;
        this.users.put(Long.valueOf(meUser.getId()), meUser);
        for (Channel channel : payload.getPrivateChannels()) {
            m.checkNotNullExpressionValue(channel, "channel");
            for (com.discord.models.user.User user : ChannelUtils.g(channel)) {
                this.users.put(Long.valueOf(user.getId()), user);
            }
        }
        for (ModelUserRelationship modelUserRelationship : payload.getRelationships()) {
            m.checkNotNullExpressionValue(modelUserRelationship, "relationship");
            if (modelUserRelationship.getUser() != null) {
                SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> copiablePartitionMap = this.users;
                Long lValueOf = Long.valueOf(modelUserRelationship.getUser().getId());
                User user2 = modelUserRelationship.getUser();
                m.checkNotNullExpressionValue(user2, "relationship.user");
                copiablePartitionMap.put(lValueOf, new CoreUser(user2));
            }
        }
        Iterator<Guild> it = payload.getGuilds().iterator();
        while (it.hasNext()) {
            List<GuildMember> listV = it.next().v();
            if (listV != null) {
                for (GuildMember guildMember : listV) {
                    this.users.put(Long.valueOf(guildMember.getUser().getId()), new CoreUser(guildMember.getUser()));
                }
            }
        }
        StringBuilder sbU = a.U("Discovered ");
        sbU.append(this.users.size());
        sbU.append(" initial users.");
        AppLog.i(sbU.toString());
        AppLog.g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(meUser));
        markChanged(MeUpdate, UsersUpdate);
    }

    @StoreThread
    public final void handleFriendSuggestionCreate(FriendSuggestion suggestion) {
        m.checkNotNullParameter(suggestion, "suggestion");
        updateUser(suggestion.getSuggestedUser());
    }

    @StoreThread
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> loadedSuggestions) {
        m.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        Iterator<T> it = loadedSuggestions.iterator();
        while (it.hasNext()) {
            updateUser(((FriendSuggestion) it.next()).getSuggestedUser());
        }
    }

    @StoreThread
    public final void handleGuildAddOrSync(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<GuildMember> listV = guild.v();
        if (listV != null) {
            Iterator<T> it = listV.iterator();
            while (it.hasNext()) {
                updateUser(((GuildMember) it.next()).getUser());
            }
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        m.checkNotNullParameter(member, "member");
        updateUser(member.getUser());
    }

    @StoreThread
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        m.checkNotNullParameter(chunk, "chunk");
        Iterator<GuildMember> it = chunk.b().iterator();
        while (it.hasNext()) {
            updateUser(it.next().getUser());
        }
    }

    @StoreThread
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers) {
        m.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            User userC = ((ApiGuildScheduledEventUser) it.next()).getUser();
            if (userC != null) {
                updateUser(userC);
            }
        }
    }

    @StoreThread
    public final void handleMessageCreateOrUpdate(Message message) {
        m.checkNotNullParameter(message, "message");
        List<User> listT = message.t();
        if (listT != null) {
            Iterator<T> it = listT.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
        Long flags = message.getFlags();
        if (((flags != null ? flags.longValue() : 0L) & 16) != 0) {
            this.me = MeUser.copy$default(this.me, 0L, null, null, null, false, false, 0, null, null, false, false, null, this.me.getFlags() | 8192, 0, null, null, null, null, 258047, null);
            markChanged(MeUpdate);
        }
    }

    @StoreThread
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        m.checkNotNullParameter(chunk, "chunk");
        for (com.discord.models.message.Message message : chunk.getMessages()) {
            User author = message.getAuthor();
            if (author != null) {
                updateUser(author);
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    updateUser((User) it.next());
                }
            }
        }
    }

    @StoreThread
    public final void handlePresenceUpdate(Presence presence) {
        m.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if ((user != null ? user.getDiscriminator() : null) != null) {
            updateUser(user);
        }
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            for (ThreadListMember threadListMember : listB) {
                GuildMember guildMemberA = threadListMember.getMember();
                if (guildMemberA != null) {
                    updateUser(guildMemberA.getUser());
                }
                Presence presenceB = threadListMember.getPresence();
                User user = presenceB != null ? presenceB.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            for (AugmentedThreadMember augmentedThreadMember : listA) {
                GuildMember member = augmentedThreadMember.getMember();
                if (member != null) {
                    updateUser(member.getUser());
                }
                Presence presence = augmentedThreadMember.getPresence();
                User user = presence != null ? presence.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @StoreThread
    public final void handleUserRelationshipAdd(ModelUserRelationship relationship) {
        m.checkNotNullParameter(relationship, "relationship");
        User user = relationship.getUser();
        m.checkNotNullExpressionValue(user, "relationship.user");
        updateUser(user);
    }

    @StoreThread
    public final void handleUserUpdated(User user) {
        m.checkNotNullParameter(user, "user");
        updateUser(user);
        if (this.me.getId() == user.getId()) {
            this.me = MeUser.INSTANCE.merge(this.me, user);
            markChanged(MeUpdate);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        m.checkNotNullParameter(context, "context");
        super.init(context);
        this.me = this.meCache.get();
        markChanged(MeUpdate);
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeAllUsers() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<MeUser> observeMe() {
        return observeMe$default(this, false, 1, null);
    }

    public final Observable<MeUser> observeMe(boolean emitEmpty) {
        Observable<MeUser> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new AnonymousClass1(), 14, null).y(new AnonymousClass2(emitEmpty)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Long> observeMeId() {
        Observable<Long> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<com.discord.models.user.User> observeUser(long userId) {
        Observable<com.discord.models.user.User> observableR = observeAllUsers().G(new AnonymousClass1(userId)).r();
        m.checkNotNullExpressionValue(observableR, "observeAllUsers()\n      …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, String>> observeUsernames(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable observableK = observeAllUsers().k(b.a.d.o.b(userIds, AnonymousClass1.INSTANCE));
        m.checkNotNullExpressionValue(observableK, "observeAllUsers()\n      …er!!.username }\n        )");
        return observableK;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        return observeUsers(userIds, false);
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        if (getUpdateSources().contains(UsersUpdate)) {
            this.usersSnapshot = this.users.fastCopy();
        }
        if (getUpdateSources().contains(MeUpdate)) {
            MeUser meUser = this.me;
            this.meSnapshot = meUser;
            Persister.set$default(this.meCache, meUser, false, 2, null);
        }
    }

    public final Map<Long, com.discord.models.user.User> getUsers(Collection<Long> userIds, boolean fetchUserIfMissing) {
        m.checkNotNullParameter(userIds, "userIds");
        Map<Long, ? extends com.discord.models.user.User> map = this.usersSnapshot;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            com.discord.models.user.User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((com.discord.models.user.User) obj).getId()), obj);
        }
        if (fetchUserIfMissing) {
            fetchMissing(userIds, linkedHashMap.keySet());
        }
        return linkedHashMap;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds, boolean fetchUserIfMissing) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, com.discord.models.user.User>> observableU = observeAllUsers().k(b.a.d.o.a(userIds)).u(new AnonymousClass1(fetchUserIfMissing, userIds));
        m.checkNotNullExpressionValue(observableU, "observeAllUsers()\n      …ys)\n          }\n        }");
        return observableU;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUser(Function1<? super User, Unit> function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister<MeUser> persister) {
        m.checkNotNullParameter(function1, "notifyUserUpdated");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(persister, "meCache");
        this.notifyUserUpdated = function1;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.meCache = persister;
        MeUser meUser = EMPTY_ME_USER;
        this.me = meUser;
        this.users = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.meSnapshot = meUser;
        this.usersSnapshot = h0.emptyMap();
        this.userRequestManager = new UserRequestManager(new StoreUser$userRequestManager$1(this));
    }
}
