package com.discord.stores;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.domain.ModelPayload;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.persister.Persister;
import d0.d0.f;
import d0.t.g0;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserRelationships.kt */
/* loaded from: classes2.dex */
public final class StoreUserRelationships extends StoreV2 {
    private final ObservationDeck observationDeck;
    private final Persister<Map<Long, Integer>> relationshipsCache;
    private UserRelationshipsState relationshipsState;
    private UserRelationshipsState relationshipsStateSnapshot;

    /* compiled from: StoreUserRelationships.kt */
    public static abstract class UserRelationshipsState {

        /* compiled from: StoreUserRelationships.kt */
        public static final /* data */ class Loaded extends UserRelationshipsState {
            private final Map<Long, Integer> relationships;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Map<Long, Integer> map) {
                super(null);
                m.checkNotNullParameter(map, "relationships");
                this.relationships = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.relationships;
                }
                return loaded.copy(map);
            }

            public final Map<Long, Integer> component1() {
                return this.relationships;
            }

            public final Loaded copy(Map<Long, Integer> relationships) {
                m.checkNotNullParameter(relationships, "relationships");
                return new Loaded(relationships);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && m.areEqual(this.relationships, ((Loaded) other).relationships);
                }
                return true;
            }

            public final Map<Long, Integer> getRelationships() {
                return this.relationships;
            }

            public int hashCode() {
                Map<Long, Integer> map = this.relationships;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return a.M(a.U("Loaded(relationships="), this.relationships, ")");
            }
        }

        /* compiled from: StoreUserRelationships.kt */
        public static final class Unloaded extends UserRelationshipsState {
            public static final Unloaded INSTANCE = new Unloaded();

            private Unloaded() {
                super(null);
            }
        }

        private UserRelationshipsState() {
        }

        public /* synthetic */ UserRelationshipsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    /* renamed from: com.discord.stores.StoreUserRelationships$observe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Integer>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Integer> invoke2() {
            UserRelationshipsState userRelationshipsStateAccess$getRelationshipsStateSnapshot$p = StoreUserRelationships.access$getRelationshipsStateSnapshot$p(StoreUserRelationships.this);
            if (m.areEqual(userRelationshipsStateAccess$getRelationshipsStateSnapshot$p, UserRelationshipsState.Unloaded.INSTANCE)) {
                return h0.emptyMap();
            }
            if (!(userRelationshipsStateAccess$getRelationshipsStateSnapshot$p instanceof UserRelationshipsState.Loaded)) {
                throw new NoWhenBranchMatchedException();
            }
            UserRelationshipsState userRelationshipsStateAccess$getRelationshipsStateSnapshot$p2 = StoreUserRelationships.access$getRelationshipsStateSnapshot$p(StoreUserRelationships.this);
            Objects.requireNonNull(userRelationshipsStateAccess$getRelationshipsStateSnapshot$p2, "null cannot be cast to non-null type com.discord.stores.StoreUserRelationships.UserRelationshipsState.Loaded");
            return ((UserRelationshipsState.Loaded) userRelationshipsStateAccess$getRelationshipsStateSnapshot$p2).getRelationships();
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    /* renamed from: com.discord.stores.StoreUserRelationships$observe$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>> {
        public final /* synthetic */ Collection $userIds;

        public AnonymousClass2(Collection collection) {
            this.$userIds = collection;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Integer> call2(Map<Long, Integer> map) {
            m.checkNotNullExpressionValue(map, "it");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (this.$userIds.contains(Long.valueOf(entry.getKey().longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    /* renamed from: com.discord.stores.StoreUserRelationships$observe$3, reason: invalid class name */
    public static final class AnonymousClass3<T, R> implements b<Map<Long, ? extends Integer>, Integer> {
        public final /* synthetic */ long $userId;

        public AnonymousClass3(long j) {
            this.$userId = j;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Integer call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Integer call2(Map<Long, Integer> map) {
            return map.get(Long.valueOf(this.$userId));
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    /* renamed from: com.discord.stores.StoreUserRelationships$observeForType$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Map<Long, ? extends Integer>, Map<Long, ? extends Integer>> {
        public final /* synthetic */ int $relationshipType;

        public AnonymousClass1(int i) {
            this.$relationshipType = i;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Map<Long, ? extends Integer> call(Map<Long, ? extends Integer> map) {
            return call2((Map<Long, Integer>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Map<Long, Integer> call2(Map<Long, Integer> map) {
            m.checkNotNullExpressionValue(map, "relationships");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry<Long, Integer> entry : map.entrySet()) {
                if (entry.getValue().intValue() == this.$relationshipType) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    /* compiled from: StoreUserRelationships.kt */
    /* renamed from: com.discord.stores.StoreUserRelationships$observeUserRelationshipsState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<UserRelationshipsState> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserRelationshipsState invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserRelationshipsState invoke() {
            return StoreUserRelationships.this.getRelationshipsStateSnapshot();
        }
    }

    public StoreUserRelationships() {
        this(null, 1, null);
    }

    public /* synthetic */ StoreUserRelationships(ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    public static final /* synthetic */ UserRelationshipsState access$getRelationshipsStateSnapshot$p(StoreUserRelationships storeUserRelationships) {
        return storeUserRelationships.relationshipsStateSnapshot;
    }

    public static final /* synthetic */ void access$setRelationshipsStateSnapshot$p(StoreUserRelationships storeUserRelationships, UserRelationshipsState userRelationshipsState) {
        storeUserRelationships.relationshipsStateSnapshot = userRelationshipsState;
    }

    @StoreThread
    private final UserRelationshipsState.Loaded ensureRelationshipLoaded() {
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        if (loaded == null) {
            loaded = new UserRelationshipsState.Loaded(h0.emptyMap());
        }
        this.relationshipsState = loaded;
        return loaded;
    }

    public final Map<Long, Integer> getRelationships() {
        Map<Long, Integer> relationships;
        UserRelationshipsState userRelationshipsState = this.relationshipsStateSnapshot;
        if (!(userRelationshipsState instanceof UserRelationshipsState.Loaded)) {
            userRelationshipsState = null;
        }
        UserRelationshipsState.Loaded loaded = (UserRelationshipsState.Loaded) userRelationshipsState;
        return (loaded == null || (relationships = loaded.getRelationships()) == null) ? h0.emptyMap() : relationships;
    }

    /* renamed from: getRelationshipsState, reason: from getter */
    public final UserRelationshipsState getRelationshipsStateSnapshot() {
        return this.relationshipsStateSnapshot;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<ModelUserRelationship> relationships = payload.getRelationships();
        m.checkNotNullExpressionValue(relationships, "payload\n        .relationships");
        LinkedHashMap linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(d0.t.o.collectionSizeOrDefault(relationships, 10)), 16));
        for (ModelUserRelationship modelUserRelationship : relationships) {
            m.checkNotNullExpressionValue(modelUserRelationship, "it");
            Long lValueOf = Long.valueOf(modelUserRelationship.getId());
            m.checkNotNullExpressionValue(modelUserRelationship, "it");
            linkedHashMap.put(lValueOf, Integer.valueOf(modelUserRelationship.getType()));
        }
        this.relationshipsState = new UserRelationshipsState.Loaded(linkedHashMap);
        markChanged();
    }

    @StoreThread
    public final void handlePreLogout() {
        this.relationshipsState = UserRelationshipsState.Unloaded.INSTANCE;
        markChanged();
    }

    @StoreThread
    public final void handleRelationshipAdd(ModelUserRelationship relationship) {
        m.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = h0.toMutableMap(ensureRelationshipLoaded().getRelationships());
        Integer num = (Integer) mutableMap.get(Long.valueOf(relationship.getId()));
        int type = relationship.getType();
        if (num != null && num.intValue() == type) {
            return;
        }
        mutableMap.put(Long.valueOf(relationship.getId()), Integer.valueOf(relationship.getType()));
        this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
        markChanged();
    }

    @StoreThread
    public final void handleRelationshipRemove(ModelUserRelationship relationship) {
        m.checkNotNullParameter(relationship, "relationship");
        Map mutableMap = h0.toMutableMap(ensureRelationshipLoaded().getRelationships());
        if (mutableMap.remove(Long.valueOf(relationship.getId())) != null) {
            this.relationshipsState = new UserRelationshipsState.Loaded(mutableMap);
            markChanged();
        }
    }

    public final void init() {
        Map<Long, Integer> map = this.relationshipsCache.get();
        if (!m.areEqual(map, StoreUserRelationshipsKt.access$getUNLOADED_RELATIONSHIPS_SENTINEL$p())) {
            this.relationshipsState = new UserRelationshipsState.Loaded(map);
            markChanged();
        }
    }

    public final Observable<Map<Long, Integer>> observe() {
        Observable<Map<Long, Integer>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Integer>> observeForType(int relationshipType) {
        Observable<Map<Long, Integer>> observableR = observe().G(new AnonymousClass1(relationshipType)).r();
        m.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<UserRelationshipsState> observeUserRelationshipsState() {
        Observable<UserRelationshipsState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        UserRelationshipsState loaded;
        super.snapshotData();
        UserRelationshipsState userRelationshipsState = this.relationshipsState;
        if (userRelationshipsState instanceof UserRelationshipsState.Loaded) {
            HashMap map = new HashMap(((UserRelationshipsState.Loaded) userRelationshipsState).getRelationships());
            Persister.set$default(this.relationshipsCache, map, false, 2, null);
            loaded = new UserRelationshipsState.Loaded(map);
        } else {
            Persister.clear$default(this.relationshipsCache, false, 1, null);
            loaded = UserRelationshipsState.Unloaded.INSTANCE;
        }
        this.relationshipsStateSnapshot = loaded;
    }

    public StoreUserRelationships(ObservationDeck observationDeck) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.observationDeck = observationDeck;
        UserRelationshipsState.Unloaded unloaded = UserRelationshipsState.Unloaded.INSTANCE;
        this.relationshipsState = unloaded;
        this.relationshipsStateSnapshot = unloaded;
        this.relationshipsCache = new Persister<>("STORE_USER_RELATIONSHIPS_V9", StoreUserRelationshipsKt.access$getUNLOADED_RELATIONSHIPS_SENTINEL$p());
    }

    public final Observable<Map<Long, Integer>> observe(Collection<Long> userIds) {
        m.checkNotNullParameter(userIds, "userIds");
        Observable<Map<Long, Integer>> observableR = observe().G(new AnonymousClass2(userIds)).r();
        m.checkNotNullExpressionValue(observableR, "observe()\n          .map…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Integer> observe(long userId) {
        Observable observableG = observe().G(new AnonymousClass3(userId));
        m.checkNotNullExpressionValue(observableG, "observe()\n          .map…> relationships[userId] }");
        return observableG;
    }
}
