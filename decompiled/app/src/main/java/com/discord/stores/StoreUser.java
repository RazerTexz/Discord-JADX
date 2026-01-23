package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.user.UserRequestManager;
import com.discord.utilities.user.UserUtils;
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
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p512d0._Ranges;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.MapsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: StoreUser.kt */
/* JADX INFO: loaded from: classes2.dex */
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ObservationDeck.UpdateSource MeUpdate = new StoreUser2();
    private static final ObservationDeck.UpdateSource UsersUpdate = new StoreUser3();
    private static final MeUser EMPTY_ME_USER = new MeUser(0, "EMPTY_USERNAME", null, null, false, false, 0, PremiumTier.NONE, null, false, false, null, 0, 0, null, NsfwAllowance.UNKNOWN, null, null, 204800, null);

    /* JADX INFO: compiled from: StoreUser.kt */
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

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$fetchUsers$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65491 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ List $users;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C65491(List list) {
            super(0);
            this.$users = list;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreUser storeUser = StoreUser.this;
            StoreUser.access$fetchMissing(storeUser, this.$users, storeUser.getUsers().keySet());
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeAllUsers$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65501 extends Lambda implements Function0<Map<Long, ? extends com.discord.models.user.User>> {
        public C65501() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.user.User> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends com.discord.models.user.User> invoke2() {
            return StoreUser.this.getUsers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMe$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65511 extends Lambda implements Function0<MeUser> {
        public C65511() {
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

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMe$2 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65522<T, R> implements Func1<MeUser, Boolean> {
        public final /* synthetic */ boolean $emitEmpty;

        public C65522(boolean z2) {
            this.$emitEmpty = z2;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            return Boolean.valueOf(meUser != StoreUser.access$getEMPTY_ME_USER$cp() || this.$emitEmpty);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeMeId$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65531 extends Lambda implements Function0<Long> {
        public C65531() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreUser.access$getMe$p(StoreUser.this).getId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeUser$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65541<T, R> implements Func1<Map<Long, ? extends com.discord.models.user.User>, com.discord.models.user.User> {
        public final /* synthetic */ long $userId;

        public C65541(long j) {
            this.$userId = j;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ com.discord.models.user.User call(Map<Long, ? extends com.discord.models.user.User> map) {
            return call2(map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final com.discord.models.user.User call2(Map<Long, ? extends com.discord.models.user.User> map) {
            Intrinsics3.checkNotNullParameter(map, "user");
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeUsernames$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65551 extends Lambda implements Function1<com.discord.models.user.User, String> {
        public static final C65551 INSTANCE = new C65551();

        public C65551() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ String invoke(com.discord.models.user.User user) {
            return invoke2(user);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final String invoke2(com.discord.models.user.User user) {
            Intrinsics3.checkNotNull(user);
            return user.getUsername();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreUser$observeUsers$1 */
    /* JADX INFO: compiled from: StoreUser.kt */
    public static final class C65561<T> implements Action1<Map<Long, ? extends com.discord.models.user.User>> {
        public final /* synthetic */ boolean $fetchUserIfMissing;
        public final /* synthetic */ Collection $userIds;

        public C65561(boolean z2, Collection collection) {
            this.$fetchUserIfMissing = z2;
            this.$userIds = collection;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Map<Long, ? extends com.discord.models.user.User> map) {
            call2(map);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Map<Long, ? extends com.discord.models.user.User> map) {
            if (this.$fetchUserIfMissing) {
                StoreUser.access$fetchMissing(StoreUser.this, this.$userIds, map.keySet());
            }
        }
    }

    public /* synthetic */ StoreUser(Function1 function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister persister, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function1, dispatcher, (i & 4) != 0 ? ObservationDeck4.get() : observationDeck, (i & 8) != 0 ? new Persister("STORE_USERS_ME_V13", EMPTY_ME_USER) : persister);
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

    @Store3
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

    @Store3
    private final void updateUser(User user) {
        CoreUser coreUser = new CoreUser(user);
        if (!Intrinsics3.areEqual(coreUser, this.users.get(Long.valueOf(user.getId())))) {
            this.users.put(Long.valueOf(user.getId()), coreUser);
            markChanged(UsersUpdate);
        }
    }

    public final void fetchUsers(List<Long> users) {
        Intrinsics3.checkNotNullParameter(users, "users");
        this.dispatcher.schedule(new C65491(users));
    }

    /* JADX INFO: renamed from: getMe, reason: from getter */
    public final MeUser getMeSnapshot() {
        return this.meSnapshot;
    }

    @Store3
    /* JADX INFO: renamed from: getMeInternal$app_productionGoogleRelease, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final Map<Long, com.discord.models.user.User> getUsers() {
        return this.usersSnapshot;
    }

    @Store3
    public final Map<Long, com.discord.models.user.User> getUsersInternal$app_productionGoogleRelease() {
        return this.users;
    }

    @Store3
    public final void handleAuthToken(String authToken) {
        if (authToken == null) {
            markChanged(MeUpdate);
            this.me = EMPTY_ME_USER;
        }
    }

    @Store3
    public final void handleChannelCreated(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        List<User> listM7659z = channel.m7659z();
        if (listM7659z != null) {
            Iterator<T> it = listM7659z.iterator();
            while (it.hasNext()) {
                updateUser((User) it.next());
            }
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        this.users.clear();
        User me2 = payload.getMe();
        Intrinsics3.checkNotNullExpressionValue(me2, "payload.me");
        MeUser meUser = new MeUser(me2);
        this.me = meUser;
        this.users.put(Long.valueOf(meUser.getId()), meUser);
        for (Channel channel : payload.getPrivateChannels()) {
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            for (com.discord.models.user.User user : ChannelUtils.m7683g(channel)) {
                this.users.put(Long.valueOf(user.getId()), user);
            }
        }
        for (ModelUserRelationship modelUserRelationship : payload.getRelationships()) {
            Intrinsics3.checkNotNullExpressionValue(modelUserRelationship, "relationship");
            if (modelUserRelationship.getUser() != null) {
                SnowflakePartitionMap.CopiablePartitionMap<com.discord.models.user.User> copiablePartitionMap = this.users;
                Long lValueOf = Long.valueOf(modelUserRelationship.getUser().getId());
                User user2 = modelUserRelationship.getUser();
                Intrinsics3.checkNotNullExpressionValue(user2, "relationship.user");
                copiablePartitionMap.put(lValueOf, new CoreUser(user2));
            }
        }
        Iterator<Guild> it = payload.getGuilds().iterator();
        while (it.hasNext()) {
            List<GuildMember> listM7875v = it.next().m7875v();
            if (listM7875v != null) {
                for (GuildMember guildMember : listM7875v) {
                    this.users.put(Long.valueOf(guildMember.getUser().getId()), new CoreUser(guildMember.getUser()));
                }
            }
        }
        StringBuilder sbM833U = outline.m833U("Discovered ");
        sbM833U.append(this.users.size());
        sbM833U.append(" initial users.");
        AppLog.m8358i(sbM833U.toString());
        AppLog.m8357g(Long.valueOf(meUser.getId()), meUser.getEmail(), meUser.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(meUser));
        markChanged(MeUpdate, UsersUpdate);
    }

    @Store3
    public final void handleFriendSuggestionCreate(FriendSuggestion suggestion) {
        Intrinsics3.checkNotNullParameter(suggestion, "suggestion");
        updateUser(suggestion.getSuggestedUser());
    }

    @Store3
    public final void handleFriendSuggestionsLoaded(List<FriendSuggestion> loadedSuggestions) {
        Intrinsics3.checkNotNullParameter(loadedSuggestions, "loadedSuggestions");
        Iterator<T> it = loadedSuggestions.iterator();
        while (it.hasNext()) {
            updateUser(((FriendSuggestion) it.next()).getSuggestedUser());
        }
    }

    @Store3
    public final void handleGuildAddOrSync(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        List<GuildMember> listM7875v = guild.m7875v();
        if (listM7875v != null) {
            Iterator<T> it = listM7875v.iterator();
            while (it.hasNext()) {
                updateUser(((GuildMember) it.next()).getUser());
            }
        }
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        updateUser(member.getUser());
    }

    @Store3
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
        Iterator<GuildMember> it = chunk.m7932b().iterator();
        while (it.hasNext()) {
            updateUser(it.next().getUser());
        }
    }

    @Store3
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers) {
        Intrinsics3.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            User userM7969c = ((ApiGuildScheduledEventUser) it.next()).getUser();
            if (userM7969c != null) {
                updateUser(userM7969c);
            }
        }
    }

    @Store3
    public final void handleMessageCreateOrUpdate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        List<User> listM8047t = message.m8047t();
        if (listM8047t != null) {
            Iterator<T> it = listM8047t.iterator();
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

    @Store3
    public final void handleMessagesLoaded(StoreMessagesLoader.ChannelChunk chunk) {
        Intrinsics3.checkNotNullParameter(chunk, "chunk");
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

    @Store3
    public final void handlePresenceUpdate(Presence presence) {
        Intrinsics3.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if ((user != null ? user.getDiscriminator() : null) != null) {
            updateUser(user);
        }
    }

    @Store3
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        Intrinsics3.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listM8266b = threadMemberListUpdate.m8266b();
        if (listM8266b != null) {
            for (ThreadListMember threadListMember : listM8266b) {
                GuildMember guildMemberM8253a = threadListMember.getMember();
                if (guildMemberM8253a != null) {
                    updateUser(guildMemberM8253a.getUser());
                }
                Presence presenceM8254b = threadListMember.getPresence();
                User user = presenceM8254b != null ? presenceM8254b.getUser() : null;
                if (user != null) {
                    updateUser(user);
                }
            }
        }
    }

    @Store3
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        Intrinsics3.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
        if (listM8275a != null) {
            for (AugmentedThreadMember augmentedThreadMember : listM8275a) {
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

    @Store3
    public final void handleUserRelationshipAdd(ModelUserRelationship relationship) {
        Intrinsics3.checkNotNullParameter(relationship, "relationship");
        User user = relationship.getUser();
        Intrinsics3.checkNotNullExpressionValue(user, "relationship.user");
        updateUser(user);
    }

    @Store3
    public final void handleUserUpdated(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        updateUser(user);
        if (this.me.getId() == user.getId()) {
            this.me = MeUser.INSTANCE.merge(this.me, user);
            markChanged(MeUpdate);
        }
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        super.init(context);
        this.me = this.meCache.get();
        markChanged(MeUpdate);
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeAllUsers() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65501(), 14, null);
    }

    public final Observable<MeUser> observeMe() {
        return observeMe$default(this, false, 1, null);
    }

    public final Observable<MeUser> observeMe(boolean emitEmpty) {
        Observable<MeUser> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new C65511(), 14, null).m11118y(new C65522(emitEmpty)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> observeMeId() {
        Observable<Long> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{MeUpdate}, false, null, null, new C65531(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<com.discord.models.user.User> observeUser(long userId) {
        Observable<com.discord.models.user.User> observableM11112r = observeAllUsers().m11083G(new C65541(userId)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeAllUsers()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, String>> observeUsernames(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable observableM11108k = observeAllUsers().m11108k(C0879o.m176b(userIds, C65551.INSTANCE));
        Intrinsics3.checkNotNullExpressionValue(observableM11108k, "observeAllUsers()\n      …er!!.username }\n        )");
        return observableM11108k;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        return observeUsers(userIds, false);
    }

    @Override // com.discord.stores.StoreV2
    @Store3
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
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Map<Long, ? extends com.discord.models.user.User> map = this.usersSnapshot;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = userIds.iterator();
        while (it.hasNext()) {
            com.discord.models.user.User user = map.get(Long.valueOf(((Number) it.next()).longValue()));
            if (user != null) {
                arrayList.add(user);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((com.discord.models.user.User) obj).getId()), obj);
        }
        if (fetchUserIfMissing) {
            fetchMissing(userIds, linkedHashMap.keySet());
        }
        return linkedHashMap;
    }

    public final Observable<Map<Long, com.discord.models.user.User>> observeUsers(Collection<Long> userIds, boolean fetchUserIfMissing) {
        Intrinsics3.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, com.discord.models.user.User>> observableM11115u = observeAllUsers().m11108k(C0879o.m175a(userIds)).m11115u(new C65561(fetchUserIfMissing, userIds));
        Intrinsics3.checkNotNullExpressionValue(observableM11115u, "observeAllUsers()\n      …ys)\n          }\n        }");
        return observableM11115u;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreUser(Function1<? super User, Unit> function1, Dispatcher dispatcher, ObservationDeck observationDeck, Persister<MeUser> persister) {
        Intrinsics3.checkNotNullParameter(function1, "notifyUserUpdated");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(persister, "meCache");
        this.notifyUserUpdated = function1;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.meCache = persister;
        MeUser meUser = EMPTY_ME_USER;
        this.me = meUser;
        this.users = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.meSnapshot = meUser;
        this.usersSnapshot = Maps6.emptyMap();
        this.userRequestManager = new UserRequestManager(new StoreUser4(this));
    }
}
