package com.discord.stores;

import a0.a.a.b;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.d.b.a.a;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityEmoji;
import com.discord.api.activity.ActivityType;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.ClientStatuses;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.user.User;
import com.discord.models.domain.ModelCustomStatusSetting;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelSession;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.presence.ActivityUtilsKt;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.TimeUtils;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreUserPresence.kt */
/* loaded from: classes2.dex */
public final class StoreUserPresence extends StoreV2 {
    private static final StoreUserPresence$Companion$LocalPresenceUpdateSource$1 LocalPresenceUpdateSource = new StoreUserPresence$Companion$LocalPresenceUpdateSource$1();
    private final Clock clock;
    private Presence localPresence;
    private Presence localPresenceSnapshot;
    private MeUser meUser;
    private final ObservationDeck observationDeck;
    private final SnowflakePartitionMap.CopiablePartitionMap<Presence> presences;
    private Map<Long, Presence> presencesSnapshot;
    private final StoreStream stream;
    private final HashMap<Long, Map<Long, TimestampedPresence>> userGuildPresences;

    /* compiled from: StoreUserPresence.kt */
    public static final /* data */ class TimestampedPresence {
        private final Presence presence;
        private final long timestamp;

        public TimestampedPresence(Presence presence, long j) {
            m.checkNotNullParameter(presence, "presence");
            this.presence = presence;
            this.timestamp = j;
        }

        public static /* synthetic */ TimestampedPresence copy$default(TimestampedPresence timestampedPresence, Presence presence, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                presence = timestampedPresence.presence;
            }
            if ((i & 2) != 0) {
                j = timestampedPresence.timestamp;
            }
            return timestampedPresence.copy(presence, j);
        }

        /* renamed from: component1, reason: from getter */
        public final Presence getPresence() {
            return this.presence;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimestamp() {
            return this.timestamp;
        }

        public final TimestampedPresence copy(Presence presence, long timestamp) {
            m.checkNotNullParameter(presence, "presence");
            return new TimestampedPresence(presence, timestamp);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TimestampedPresence)) {
                return false;
            }
            TimestampedPresence timestampedPresence = (TimestampedPresence) other;
            return m.areEqual(this.presence, timestampedPresence.presence) && this.timestamp == timestampedPresence.timestamp;
        }

        public final Presence getPresence() {
            return this.presence;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }

        public int hashCode() {
            Presence presence = this.presence;
            return b.a(this.timestamp) + ((presence != null ? presence.hashCode() : 0) * 31);
        }

        public String toString() {
            StringBuilder sbU = a.U("TimestampedPresence(presence=");
            sbU.append(this.presence);
            sbU.append(", timestamp=");
            return a.C(sbU, this.timestamp, ")");
        }
    }

    /* compiled from: StoreUserPresence.kt */
    /* renamed from: com.discord.stores.StoreUserPresence$observeAllPresences$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Presence>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Presence> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Presence> invoke2() {
            return StoreUserPresence.this.m19getPresences();
        }
    }

    /* compiled from: StoreUserPresence.kt */
    /* renamed from: com.discord.stores.StoreUserPresence$observeApplicationActivity$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Presence, Activity> {
        public final /* synthetic */ long $applicationId;

        public AnonymousClass1(long j) {
            this.$applicationId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Activity call(Presence presence) {
            return call2(presence);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Activity call2(Presence presence) {
            List<Activity> activities;
            Activity activity = null;
            if (presence == null || (activities = presence.getActivities()) == null) {
                return null;
            }
            Iterator<T> it = activities.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                Long applicationId = ((Activity) next).getApplicationId();
                if (applicationId != null && applicationId.longValue() == this.$applicationId) {
                    activity = next;
                    break;
                }
            }
            return activity;
        }
    }

    /* compiled from: StoreUserPresence.kt */
    /* renamed from: com.discord.stores.StoreUserPresence$observeLocalPresence$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Presence> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Presence invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Presence invoke() {
            return StoreUserPresence.access$getLocalPresenceSnapshot$p(StoreUserPresence.this);
        }
    }

    /* compiled from: StoreUserPresence.kt */
    /* renamed from: com.discord.stores.StoreUserPresence$observePresenceForUser$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Map<Long, ? extends Presence>, Presence> {
        public final /* synthetic */ long $userId;

        public AnonymousClass1(long j) {
            this.$userId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Presence call(Map<Long, ? extends Presence> map) {
            return call2((Map<Long, Presence>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Presence call2(Map<Long, Presence> map) {
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreUserPresence.kt */
    /* renamed from: com.discord.stores.StoreUserPresence$observePresencesForUsers$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Map<Long, ? extends Presence>, Map<Long, ? extends Presence>> {
        public final /* synthetic */ Collection $userIds;

        public AnonymousClass1(Collection collection) {
            this.$userIds = collection;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends Presence> call(Map<Long, ? extends Presence> map) {
            return call2((Map<Long, Presence>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Presence> call2(Map<Long, Presence> map) {
            m.checkNotNullExpressionValue(map, "it");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Presence> entry : map.entrySet()) {
                if (this.$userIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    public StoreUserPresence(Clock clock, StoreStream storeStream, ObservationDeck observationDeck) {
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeStream, "stream");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.clock = clock;
        this.stream = storeStream;
        this.observationDeck = observationDeck;
        this.presences = new SnowflakePartitionMap.CopiablePartitionMap<>(0, 1, null);
        this.userGuildPresences = new HashMap<>();
        this.presencesSnapshot = new HashMap();
        ClientStatus clientStatus = ClientStatus.ONLINE;
        ClientStatus clientStatus2 = ClientStatus.OFFLINE;
        Presence presence = new Presence(clientStatus, new ClientStatuses(clientStatus2, clientStatus2, clientStatus), null);
        this.localPresence = presence;
        this.localPresenceSnapshot = Presence.copy$default(presence, null, null, null, 7, null);
    }

    public static final /* synthetic */ Presence access$getLocalPresenceSnapshot$p(StoreUserPresence storeUserPresence) {
        return storeUserPresence.localPresenceSnapshot;
    }

    public static final /* synthetic */ void access$setLocalPresenceSnapshot$p(StoreUserPresence storeUserPresence, Presence presence) {
        storeUserPresence.localPresenceSnapshot = presence;
    }

    @StoreThread
    private final void clearPresences(long guildId) {
        HashMap<Long, Map<Long, TimestampedPresence>> map = this.userGuildPresences;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<Long, TimestampedPresence>> entry : map.entrySet()) {
            if (entry.getValue().remove(Long.valueOf(guildId)) != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            flattenPresence(((Number) ((Map.Entry) it.next()).getKey()).longValue());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    @StoreThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void flattenPresence(long userId) {
        Presence presence;
        ClientStatus status;
        List<Activity> activities;
        List listSortedWith;
        Collection<TimestampedPresence> collectionValues;
        Object next;
        Map<Long, TimestampedPresence> map = this.userGuildPresences.get(Long.valueOf(userId));
        if (map == null || (collectionValues = map.values()) == null) {
            presence = null;
        } else {
            Iterator<T> it = collectionValues.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    long timestamp = ((TimestampedPresence) next).getTimestamp();
                    do {
                        Object next2 = it.next();
                        long timestamp2 = ((TimestampedPresence) next2).getTimestamp();
                        if (timestamp < timestamp2) {
                            next = next2;
                            timestamp = timestamp2;
                        }
                    } while (it.hasNext());
                }
            } else {
                next = null;
            }
            TimestampedPresence timestampedPresence = (TimestampedPresence) next;
            if (timestampedPresence != null) {
                presence = timestampedPresence.getPresence();
            }
        }
        if (presence == null || (status = presence.getStatus()) == null) {
            status = ClientStatus.OFFLINE;
        }
        List listReversed = (presence == null || (activities = presence.getActivities()) == null || (listSortedWith = u.sortedWith(activities, PresenceUtils.INSTANCE.getACTIVITY_COMPARATOR$app_productionGoogleRelease())) == null) ? null : u.reversed(listSortedWith);
        ClientStatuses clientStatuses = presence != null ? presence.getClientStatuses() : null;
        ClientStatus clientStatus = ClientStatus.OFFLINE;
        if (status == clientStatus) {
            this.userGuildPresences.remove(Long.valueOf(userId));
            if (this.presences.remove(Long.valueOf(userId)) != null) {
                markChanged();
                return;
            }
            return;
        }
        Presence presence2 = this.presences.get(Long.valueOf(userId));
        if ((presence2 != null ? presence2.getStatus() : null) != status || (!m.areEqual(presence2.getActivities(), listReversed)) || (!m.areEqual(presence2.getClientStatuses(), clientStatuses))) {
            SnowflakePartitionMap.CopiablePartitionMap<Presence> copiablePartitionMap = this.presences;
            Long lValueOf = Long.valueOf(userId);
            if (clientStatuses == null) {
                clientStatuses = new ClientStatuses(clientStatus, clientStatus, clientStatus);
            }
            copiablePartitionMap.put(lValueOf, new Presence(status, clientStatuses, listReversed));
            markChanged();
        }
    }

    @StoreThread
    private final Activity getCustomStatusActivityFromSetting(ModelCustomStatusSetting customStatusSetting) {
        ActivityEmoji activityEmoji = null;
        if (customStatusSetting == ModelCustomStatusSetting.INSTANCE.getCLEAR()) {
            return null;
        }
        if (customStatusSetting.getExpiresAt() != null && TimeUtils.parseUTCDate(customStatusSetting.getExpiresAt()) - this.clock.currentTimeMillis() <= 0) {
            return null;
        }
        if (customStatusSetting.getEmojiId() != null) {
            StoreEmoji emojis = this.stream.getEmojis();
            Long emojiId = customStatusSetting.getEmojiId();
            m.checkNotNull(emojiId);
            ModelEmojiCustom customEmojiInternal = emojis.getCustomEmojiInternal(emojiId.longValue());
            if (customEmojiInternal != null) {
                activityEmoji = new ActivityEmoji(String.valueOf(customEmojiInternal.getId()), customEmojiInternal.getName(), customEmojiInternal.isAnimated());
            }
        } else if (customStatusSetting.getEmojiName() != null) {
            Map<String, ModelEmojiUnicode> unicodeEmojiSurrogateMap = this.stream.getEmojis().getUnicodeEmojiSurrogateMap();
            String emojiName = customStatusSetting.getEmojiName();
            m.checkNotNull(emojiName);
            ModelEmojiUnicode modelEmojiUnicode = unicodeEmojiSurrogateMap.get(emojiName);
            if (modelEmojiUnicode != null) {
                activityEmoji = new ActivityEmoji(null, modelEmojiUnicode.getSurrogates(), false);
            }
        }
        return ActivityUtilsKt.createCustomStatusActivity(customStatusSetting.getText(), activityEmoji, this.clock.currentTimeMillis());
    }

    private final List<Activity> removeActivityInList(ActivityType type, List<Activity> oldActivities) {
        List<Activity> arrayList;
        int i;
        if (oldActivities == null || (arrayList = u.toMutableList((Collection) oldActivities)) == null) {
            arrayList = new ArrayList<>();
        }
        if (oldActivities != null) {
            Iterator<Activity> it = oldActivities.iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getType() == type) {
                    break;
                }
                i++;
            }
            i = -1;
        } else {
            i = -1;
        }
        if (i != -1) {
            arrayList.remove(i);
        }
        return arrayList;
    }

    private final List<Activity> replaceActivityInList(Activity newActivity, List<Activity> oldActivities) {
        List<Activity> listRemoveActivityInList = removeActivityInList(newActivity.getType(), oldActivities);
        listRemoveActivityInList.add(newActivity);
        return listRemoveActivityInList;
    }

    public static /* synthetic */ void updateActivity$default(StoreUserPresence storeUserPresence, ActivityType activityType, Activity activity, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeUserPresence.updateActivity(activityType, activity, z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0045  */
    @StoreThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void updateSelfPresence(ModelUserSettings userSettings, List<? extends ModelSession> sessions, boolean sendGateway) {
        ClientStatus status;
        List<Activity> list;
        List<Activity> activities;
        Object next;
        MeUser meUser = this.meUser;
        if (meUser != null) {
            long id2 = meUser.getId();
            if (userSettings == null || (status = userSettings.getStatus()) == null) {
                status = this.localPresence.getStatus();
            }
            ClientStatus clientStatus = status;
            m.checkNotNullExpressionValue(clientStatus, "userSettings?.status\n   …  ?: localPresence.status");
            if (sessions != null) {
                Iterator<T> it = sessions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    } else {
                        next = it.next();
                        if (((ModelSession) next).isActive()) {
                            break;
                        }
                    }
                }
                ModelSession modelSession = (ModelSession) next;
                if (modelSession == null || (activities = modelSession.getActivities()) == null) {
                    Presence presence = this.presences.get(Long.valueOf(id2));
                    if (presence != null) {
                        List<Activity> activities2 = presence.getActivities();
                        list = activities2;
                    } else {
                        list = null;
                    }
                } else {
                    list = activities2;
                }
            }
            ModelCustomStatusSetting customStatus = userSettings != null ? userSettings.getCustomStatus() : null;
            if (customStatus != null) {
                Activity customStatusActivityFromSetting = getCustomStatusActivityFromSetting(customStatus);
                activities = customStatusActivityFromSetting != null ? replaceActivityInList(customStatusActivityFromSetting, this.localPresence.getActivities()) : removeActivityInList(ActivityType.CUSTOM_STATUS, this.localPresence.getActivities());
            } else {
                activities = this.localPresence.getActivities();
            }
            if (clientStatus != this.localPresence.getStatus() || (!m.areEqual(activities, this.localPresence.getActivities()))) {
                this.localPresence = new Presence(clientStatus, null, activities);
                markChanged(LocalPresenceUpdateSource);
            }
            handlePresenceUpdate(RecyclerView.FOREVER_NS, id2, clientStatus, null, list);
            if (sendGateway || PresenceUtils.INSTANCE.getCustomStatusActivity(this.localPresence) != null) {
                return;
            }
            markUnchanged(LocalPresenceUpdateSource);
        }
    }

    public final Activity getApplicationActivity(long userId, long applicationId) {
        List<Activity> activities;
        Presence presence = this.presencesSnapshot.get(Long.valueOf(userId));
        Object obj = null;
        if (presence == null || (activities = presence.getActivities()) == null) {
            return null;
        }
        Iterator<T> it = activities.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long applicationId2 = ((Activity) next).getApplicationId();
            if (applicationId2 != null && applicationId2.longValue() == applicationId) {
                obj = next;
                break;
            }
        }
        return (Activity) obj;
    }

    /* renamed from: getLocalPresence, reason: from getter */
    public final Presence getLocalPresenceSnapshot() {
        return this.localPresenceSnapshot;
    }

    /* renamed from: getLocalPresence$app_productionGoogleRelease, reason: from getter */
    public final Presence getLocalPresence() {
        return this.localPresence;
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final SnowflakePartitionMap.CopiablePartitionMap<Presence> getPresences() {
        return this.presences;
    }

    public final StoreStream getStream() {
        return this.stream;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.userGuildPresences.clear();
        this.presences.clear();
        User me2 = payload.getMe();
        m.checkNotNullExpressionValue(me2, "payload.me");
        this.meUser = new MeUser(me2);
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            handleGuildAdd((Guild) it.next());
        }
        List<com.discord.api.presence.Presence> presences = payload.getPresences();
        m.checkNotNullExpressionValue(presences, "payload.presences");
        for (com.discord.api.presence.Presence presence : presences) {
            User user = presence.getUser();
            if (user != null) {
                handlePresenceUpdate(RecyclerView.FOREVER_NS, user.getId(), presence.getStatus(), presence.getClientStatus(), presence.b());
            }
        }
        updateSelfPresence(payload.getUserSettings(), payload.getSessions(), false);
        markChanged();
    }

    @StoreThread
    public final void handleGuildAdd(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<com.discord.api.presence.Presence> listD = guild.D();
        if (listD != null) {
            for (com.discord.api.presence.Presence presence : listD) {
                User user = presence.getUser();
                if (user != null) {
                    handlePresenceUpdate(guild.getId(), user.getId(), presence.getStatus(), presence.getClientStatus(), presence.b());
                }
            }
        }
    }

    @StoreThread
    public final void handleGuildMemberRemove(long guildId, long userId) {
        Map<Long, TimestampedPresence> map = this.userGuildPresences.get(Long.valueOf(userId));
        if ((map != null ? map.remove(Long.valueOf(guildId)) : null) != null) {
            flattenPresence(userId);
        }
    }

    @StoreThread
    public final void handleGuildRemove(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        clearPresences(guild.getId());
    }

    @StoreThread
    public final void handlePresenceReplace(List<com.discord.api.presence.Presence> presencesList) {
        m.checkNotNullParameter(presencesList, "presencesList");
        clearPresences(RecyclerView.FOREVER_NS);
        for (com.discord.api.presence.Presence presence : presencesList) {
            User user = presence.getUser();
            if (user != null) {
                long id2 = user.getId();
                ClientStatus status = presence.getStatus();
                ClientStatuses clientStatus = presence.getClientStatus();
                if (clientStatus == null) {
                    ClientStatus clientStatus2 = ClientStatus.OFFLINE;
                    clientStatus = new ClientStatuses(clientStatus2, clientStatus2, clientStatus2);
                }
                handlePresenceUpdate(RecyclerView.FOREVER_NS, id2, status, clientStatus, presence.b());
            }
        }
    }

    @StoreThread
    public final void handlePresenceUpdate(long guildId, com.discord.api.presence.Presence presence) {
        m.checkNotNullParameter(presence, "presence");
        User user = presence.getUser();
        if (user != null) {
            handlePresenceUpdate(guildId, user.getId(), presence.getStatus(), presence.getClientStatus(), presence.b());
        }
    }

    @StoreThread
    public final void handleSessionsReplace(List<? extends ModelSession> sessions) {
        m.checkNotNullParameter(sessions, "sessions");
        updateSelfPresence(null, sessions, true);
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            for (ThreadListMember threadListMember : listB) {
                com.discord.api.presence.Presence presenceB = threadListMember.getPresence();
                if (presenceB != null) {
                    handlePresenceUpdate(threadMemberListUpdate.getGuildId(), threadListMember.getUserId(), presenceB.getStatus(), presenceB.getClientStatus(), presenceB.b());
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
                com.discord.api.presence.Presence presence = augmentedThreadMember.getPresence();
                if (presence != null) {
                    handlePresenceUpdate(threadMembersUpdate.getGuildId(), augmentedThreadMember.getUserId(), presence.getStatus(), presence.getClientStatus(), presence.b());
                }
            }
        }
    }

    @StoreThread
    public final void handleUserSettingsUpdate(ModelUserSettings userSettings) {
        m.checkNotNullParameter(userSettings, "userSettings");
        updateSelfPresence(userSettings, null, true);
    }

    public final Observable<Map<Long, Presence>> observeAllPresences() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Activity> observeApplicationActivity(long userId, long applicationId) {
        Observable<Activity> observableR = observePresenceForUser(userId).G(new AnonymousClass1(applicationId)).r();
        m.checkNotNullExpressionValue(observableR, "observePresenceForUser(u…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Presence> observeLocalPresence() {
        Observable<Presence> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{LocalPresenceUpdateSource}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck\n      .c…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Presence> observePresenceForUser(long userId) {
        Observable<Presence> observableR = observeAllPresences().G(new AnonymousClass1(userId)).r();
        m.checkNotNullExpressionValue(observableR, "observeAllPresences()\n  …  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Presence>> observePresencesForUsers(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Presence>> observableR = observeAllPresences().G(new AnonymousClass1(userIds)).r();
        m.checkNotNullExpressionValue(observableR, "observeAllPresences()\n  …  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        this.presencesSnapshot = this.presences.fastCopy();
        Presence presence = this.localPresence;
        List<Activity> activities = presence.getActivities();
        this.localPresenceSnapshot = Presence.copy$default(presence, null, null, activities != null ? u.toList(activities) : null, 3, null);
        if (getUpdateSources().contains(LocalPresenceUpdateSource)) {
            StoreGatewayConnection.presenceUpdate$default(StoreStream.INSTANCE.getGatewaySocket(), this.localPresence.getStatus(), null, this.localPresence.getActivities(), null, 10, null);
        }
    }

    @StoreThread
    public final void updateActivity(ActivityType type, Activity activity, boolean forceDirty) {
        Activity activity2;
        Object next;
        m.checkNotNullParameter(type, "type");
        if (!forceDirty) {
            List<Activity> activities = this.localPresence.getActivities();
            if (activities != null) {
                Iterator<T> it = activities.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (((Activity) next).getType() == (activity != null ? activity.getType() : null)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                activity2 = (Activity) next;
            } else {
                activity2 = null;
            }
            if (!(!m.areEqual(activity, activity2))) {
                return;
            }
        }
        List<Activity> listReplaceActivityInList = activity != null ? replaceActivityInList(activity, this.localPresence.getActivities()) : removeActivityInList(type, this.localPresence.getActivities());
        ArrayList arrayList = new ArrayList();
        for (Object obj : listReplaceActivityInList) {
            if (((Activity) obj).getType() != ActivityType.UNKNOWN) {
                arrayList.add(obj);
            }
        }
        this.localPresence = new Presence(this.localPresence.getStatus(), null, arrayList);
        markChanged(LocalPresenceUpdateSource);
        MeUser meUser = this.meUser;
        if (meUser != null) {
            long id2 = meUser.getId();
            if (!m.areEqual(this.presences.get(Long.valueOf(id2)), this.localPresence)) {
                this.presences.put(Long.valueOf(id2), this.localPresence);
                markChanged();
            }
        }
    }

    /* renamed from: getPresences, reason: collision with other method in class */
    public final Map<Long, Presence> m19getPresences() {
        return this.presencesSnapshot;
    }

    @StoreThread
    public final void handlePresenceUpdate(long guildId, long userId, ClientStatus status, ClientStatuses clientStatuses, List<Activity> activities) {
        m.checkNotNullParameter(status, "status");
        if (guildId == 0) {
            guildId = Long.MAX_VALUE;
        }
        MeUser meUser = this.meUser;
        if (meUser == null || meUser.getId() != userId || guildId == RecyclerView.FOREVER_NS) {
            HashMap<Long, Map<Long, TimestampedPresence>> map = this.userGuildPresences;
            Long lValueOf = Long.valueOf(userId);
            Map<Long, TimestampedPresence> map2 = map.get(lValueOf);
            if (map2 == null) {
                map2 = new HashMap<>();
                map.put(lValueOf, map2);
            }
            map2.put(Long.valueOf(guildId), new TimestampedPresence(new Presence(status, clientStatuses, activities), this.clock.currentTimeMillis()));
            flattenPresence(userId);
        }
    }
}
