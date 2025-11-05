package com.discord.stores;

import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityParty;
import com.discord.api.guild.Guild;
import com.discord.api.presence.ClientStatus;
import com.discord.api.presence.Presence;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.models.domain.ModelPayload;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import d0.t.g0;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreGameParty.kt */
/* loaded from: classes2.dex */
public final class StoreGameParty extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final HashMap<String, HashSet<Long>> parties;
    private HashMap<String, HashSet<Long>> partiesSnapshot;
    private final StoreUser storeUser;
    private final StoreUserPresence storeUserPresence;
    private final HashMap<Long, HashMap<Long, String>> userParties;

    /* compiled from: StoreGameParty.kt */
    /* renamed from: com.discord.stores.StoreGameParty$observeUsersForPartyId$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends User>> {
        public final /* synthetic */ String $partyId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str) {
            super(0);
            this.$partyId = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends User> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends User> invoke2() {
            List listEmptyList;
            HashSet hashSet = (HashSet) StoreGameParty.access$getPartiesSnapshot$p(StoreGameParty.this).get(this.$partyId);
            StoreUser storeUser = StoreGameParty.this.getStoreUser();
            if (hashSet == null || (listEmptyList = u.toList(hashSet)) == null) {
                listEmptyList = n.emptyList();
            }
            SortedMap sortedMap = g0.toSortedMap(storeUser.getUsers(listEmptyList, false));
            Objects.requireNonNull(sortedMap, "null cannot be cast to non-null type kotlin.collections.Map<com.discord.primitives.UserId /* = kotlin.Long */, com.discord.models.user.User>");
            return sortedMap;
        }
    }

    public StoreGameParty(ObservationDeck observationDeck, StoreUserPresence storeUserPresence, StoreUser storeUser) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storeUserPresence, "storeUserPresence");
        m.checkNotNullParameter(storeUser, "storeUser");
        this.observationDeck = observationDeck;
        this.storeUserPresence = storeUserPresence;
        this.storeUser = storeUser;
        this.userParties = new HashMap<>();
        this.parties = new HashMap<>();
        this.partiesSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getPartiesSnapshot$p(StoreGameParty storeGameParty) {
        return storeGameParty.partiesSnapshot;
    }

    public static final /* synthetic */ void access$setPartiesSnapshot$p(StoreGameParty storeGameParty, HashMap map) {
        storeGameParty.partiesSnapshot = map;
    }

    @StoreThread
    private final void addUserToParty(long userId, long guildId, String partyId) {
        if (partyId != null) {
            if (guildId > 0) {
                HashMap<Long, HashMap<Long, String>> map = this.userParties;
                Long lValueOf = Long.valueOf(userId);
                HashMap<Long, String> map2 = map.get(lValueOf);
                if (map2 == null) {
                    map2 = new HashMap<>();
                    map.put(lValueOf, map2);
                }
                map2.put(Long.valueOf(guildId), partyId);
            }
            HashSet<Long> hashSet = this.parties.get(partyId);
            HashSet<Long> hashSet2 = hashSet != null ? new HashSet<>(hashSet) : new HashSet<>();
            hashSet2.add(Long.valueOf(userId));
            this.parties.put(partyId, hashSet2);
            markChanged();
        }
    }

    public static /* synthetic */ void handlePresenceUpdate$default(StoreGameParty storeGameParty, Presence presence, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            Long guildId = presence.getGuildId();
            j = guildId != null ? guildId.longValue() : 0L;
        }
        storeGameParty.handlePresenceUpdate(presence, j);
    }

    @StoreThread
    private final void handlePresences(List<Presence> presences) {
        for (Presence presence : presences) {
            Long guildId = presence.getGuildId();
            updateParty(presence, guildId != null ? guildId.longValue() : 0L);
        }
    }

    @StoreThread
    private final void removeUserFromParty(long userId, long guildId) {
        String strRemove;
        HashMap<Long, String> map = this.userParties.get(Long.valueOf(userId));
        if (map == null || (strRemove = map.remove(Long.valueOf(guildId))) == null) {
            return;
        }
        m.checkNotNullExpressionValue(strRemove, "userParties[userId]?.remove(guildId) ?: return");
        HashSet<Long> hashSet = this.parties.get(strRemove);
        if (hashSet != null) {
            if (hashSet.size() != 1) {
                HashMap<String, HashSet<Long>> map2 = this.parties;
                HashSet<Long> hashSet2 = new HashSet<>(hashSet);
                hashSet2.remove(Long.valueOf(userId));
                map2.put(strRemove, hashSet2);
            } else {
                this.parties.remove(strRemove);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void updateParty(Presence presence, long guildId) {
        List<Activity> listEmptyList;
        boolean z2;
        Object next;
        ActivityParty party;
        com.discord.api.user.User user = presence.getUser();
        if (user != null) {
            HashMap<Long, String> map = this.userParties.get(Long.valueOf(user.getId()));
            String id2 = null;
            String str = map != null ? map.get(Long.valueOf(guildId)) : null;
            Map<Long, com.discord.models.presence.Presence> mapM19getPresences = this.storeUserPresence.m19getPresences();
            com.discord.api.user.User user2 = presence.getUser();
            com.discord.models.presence.Presence presence2 = mapM19getPresences.get(user2 != null ? Long.valueOf(user2.getId()) : null);
            if (presence2 == null || (listEmptyList = presence2.getActivities()) == null) {
                listEmptyList = n.emptyList();
            }
            Iterator<T> it = listEmptyList.iterator();
            while (true) {
                z2 = false;
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                ActivityParty party2 = ((Activity) next).getParty();
                if ((party2 != null ? party2.getId() : null) != null) {
                    break;
                }
            }
            Activity activity = (Activity) next;
            if (activity != null && (party = activity.getParty()) != null) {
                id2 = party.getId();
            }
            String str2 = id2;
            if (str2 != null && presence.getStatus() != ClientStatus.OFFLINE) {
                z2 = true;
            }
            if (!z2) {
                removeUserFromParty(user.getId(), guildId);
                return;
            }
            if (!m.areEqual(str, str2)) {
                removeUserFromParty(user.getId(), guildId);
            }
            addUserToParty(user.getId(), guildId, str2);
        }
    }

    public final ObservationDeck getObservationDeck() {
        return this.observationDeck;
    }

    public final StoreUser getStoreUser() {
        return this.storeUser;
    }

    public final StoreUserPresence getStoreUserPresence() {
        return this.storeUserPresence;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<Presence> presences = payload.getPresences();
        if (presences != null) {
            handlePresences(presences);
        }
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            handleGuildCreateOrSync((Guild) it.next());
        }
    }

    @StoreThread
    public final void handleGuildCreateOrSync(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<Presence> listD = guild.D();
        if (listD != null) {
            handlePresences(listD);
        }
    }

    @StoreThread
    public final void handlePresenceReplace(List<Presence> presences) {
        m.checkNotNullParameter(presences, "presences");
        handlePresences(presences);
    }

    @StoreThread
    public final void handlePresenceUpdate(Presence presence) {
        handlePresenceUpdate$default(this, presence, 0L, 2, null);
    }

    @StoreThread
    public final void handlePresenceUpdate(Presence presence, long guildId) {
        m.checkNotNullParameter(presence, "presence");
        updateParty(presence, guildId);
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        List<ThreadListMember> listB = threadMemberListUpdate.b();
        if (listB != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listB.iterator();
            while (it.hasNext()) {
                Presence presence = ((ThreadListMember) it.next()).getPresence();
                if (presence != null) {
                    arrayList.add(presence);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                updateParty((Presence) it2.next(), threadMemberListUpdate.getGuildId());
            }
        }
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        List<AugmentedThreadMember> listA = threadMembersUpdate.a();
        if (listA != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listA.iterator();
            while (it.hasNext()) {
                Presence presence = ((AugmentedThreadMember) it.next()).getPresence();
                if (presence != null) {
                    arrayList.add(presence);
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                updateParty((Presence) it2.next(), threadMembersUpdate.getGuildId());
            }
        }
    }

    public final Observable<Map<Long, User>> observeUsersForPartyId(String partyId) {
        Observable<Map<Long, User>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this, StoreUser.INSTANCE.getUsersUpdate()}, false, null, null, new AnonymousClass1(partyId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.partiesSnapshot = new HashMap<>();
        for (Map.Entry<String, HashSet<Long>> entry : this.parties.entrySet()) {
            this.partiesSnapshot.put(entry.getKey(), new HashSet<>(entry.getValue()));
        }
    }
}
