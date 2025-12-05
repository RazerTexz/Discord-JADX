package com.discord.stores;

import com.discord.api.message.Message;
import com.discord.models.domain.ModelMessageDelete;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p580t._Sets;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: StoreMessageState.kt */
/* loaded from: classes2.dex */
public final class StoreMessageState {
    private final Dispatcher dispatcher;
    private final BehaviorSubject<Map<Long, State>> messageStateSubject;

    /* compiled from: StoreMessageState.kt */
    public static final /* data */ class State {
        private final Map<Integer, Set<String>> visibleSpoilerEmbedMap;
        private final Set<Integer> visibleSpoilerNodeIndices;

        public State() {
            this(null, null, 3, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public State(Set<Integer> set, Map<Integer, ? extends Set<String>> map) {
            Intrinsics3.checkNotNullParameter(set, "visibleSpoilerNodeIndices");
            Intrinsics3.checkNotNullParameter(map, "visibleSpoilerEmbedMap");
            this.visibleSpoilerNodeIndices = set;
            this.visibleSpoilerEmbedMap = map;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.visibleSpoilerNodeIndices;
            }
            if ((i & 2) != 0) {
                map = state.visibleSpoilerEmbedMap;
            }
            return state.copy(set, map);
        }

        public final Set<Integer> component1() {
            return this.visibleSpoilerNodeIndices;
        }

        public final Map<Integer, Set<String>> component2() {
            return this.visibleSpoilerEmbedMap;
        }

        public final State copy(Set<Integer> visibleSpoilerNodeIndices, Map<Integer, ? extends Set<String>> visibleSpoilerEmbedMap) {
            Intrinsics3.checkNotNullParameter(visibleSpoilerNodeIndices, "visibleSpoilerNodeIndices");
            Intrinsics3.checkNotNullParameter(visibleSpoilerEmbedMap, "visibleSpoilerEmbedMap");
            return new State(visibleSpoilerNodeIndices, visibleSpoilerEmbedMap);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.visibleSpoilerNodeIndices, state.visibleSpoilerNodeIndices) && Intrinsics3.areEqual(this.visibleSpoilerEmbedMap, state.visibleSpoilerEmbedMap);
        }

        public final Map<Integer, Set<String>> getVisibleSpoilerEmbedMap() {
            return this.visibleSpoilerEmbedMap;
        }

        public final Set<Integer> getVisibleSpoilerNodeIndices() {
            return this.visibleSpoilerNodeIndices;
        }

        public int hashCode() {
            Set<Integer> set = this.visibleSpoilerNodeIndices;
            int iHashCode = (set != null ? set.hashCode() : 0) * 31;
            Map<Integer, Set<String>> map = this.visibleSpoilerEmbedMap;
            return iHashCode + (map != null ? map.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("State(visibleSpoilerNodeIndices=");
            sbM833U.append(this.visibleSpoilerNodeIndices);
            sbM833U.append(", visibleSpoilerEmbedMap=");
            return outline.m825M(sbM833U, this.visibleSpoilerEmbedMap, ")");
        }

        public /* synthetic */ State(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? Sets5.emptySet() : set, (i & 2) != 0 ? Maps6.emptyMap() : map);
        }
    }

    /* compiled from: StoreMessageState.kt */
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1 */
    public static final class C62211 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerIndex;

        /* compiled from: StoreMessageState.kt */
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<State, State> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, _Sets.plus(state.getVisibleSpoilerNodeIndices(), Integer.valueOf(C62211.this.$spoilerIndex)), null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62211(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new AnonymousClass1());
        }
    }

    /* compiled from: StoreMessageState.kt */
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1 */
    public static final class C62221 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* compiled from: StoreMessageState.kt */
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<State, State> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, null, Maps6.plus(state.getVisibleSpoilerEmbedMap(), Tuples.m10073to(Integer.valueOf(C62221.this.$spoilerEmbedIndex), Sets5.emptySet())), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62221(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new AnonymousClass1());
        }
    }

    /* compiled from: StoreMessageState.kt */
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1 */
    public static final class C62231 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* compiled from: StoreMessageState.kt */
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<State, State> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                Intrinsics3.checkNotNullParameter(state, "currentState");
                Set<String> setEmptySet = state.getVisibleSpoilerEmbedMap().get(Integer.valueOf(C62231.this.$spoilerEmbedIndex));
                if (setEmptySet == null) {
                    setEmptySet = Sets5.emptySet();
                }
                return State.copy$default(state, null, Maps6.plus(state.getVisibleSpoilerEmbedMap(), Tuples.m10073to(Integer.valueOf(C62231.this.$spoilerEmbedIndex), _Sets.plus(setEmptySet, C62231.this.$key))), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C62231(long j, int i, String str) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
            this.$key = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new AnonymousClass1());
        }
    }

    public StoreMessageState(Dispatcher dispatcher) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        BehaviorSubject<Map<Long, State>> behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(Maps6.emptyMap());
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(emptyMap())");
        this.messageStateSubject = behaviorSubjectM11130l0;
    }

    public static final /* synthetic */ void access$updateState(StoreMessageState storeMessageState, long j, Function1 function1) {
        storeMessageState.updateState(j, function1);
    }

    @Store3
    private final void resetState(List<Long> messagesList) {
        Map<Long, State> mapM11132n0 = this.messageStateSubject.m11132n0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : messagesList) {
            long jLongValue = ((Number) obj).longValue();
            Intrinsics3.checkNotNullExpressionValue(mapM11132n0, "messageStateMap");
            if (mapM11132n0.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        Intrinsics3.checkNotNullExpressionValue(mapM11132n0, "messageStateMap");
        behaviorSubject.onNext(Maps6.minus((Map) mapM11132n0, (Iterable) arrayList));
    }

    @Store3
    private final void updateState(long messageId, Function1<? super State, State> updateFunction) {
        Map<Long, State> mapM11132n0 = this.messageStateSubject.m11132n0();
        State state = mapM11132n0.get(Long.valueOf(messageId));
        if (state == null) {
            state = new State(null, null, 3, null);
        }
        State stateInvoke = updateFunction.invoke(state);
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        Intrinsics3.checkNotNullExpressionValue(mapM11132n0, "messageStateMap");
        behaviorSubject.onNext(Maps6.plus(mapM11132n0, Tuples.m10073to(Long.valueOf(messageId), stateInvoke)));
    }

    public final Observable<Map<Long, State>> getMessageState() {
        Observable<Map<Long, State>> observableM11112r = this.messageStateSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "messageStateSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    @Store3
    public final void handleChannelSelected() {
        this.messageStateSubject.onNext(Maps6.emptyMap());
    }

    @Store3
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        Intrinsics3.checkNotNullParameter(messageDelete, "messageDelete");
        List<Long> messageIds = messageDelete.getMessageIds();
        Intrinsics3.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        resetState(messageIds);
    }

    @Store3
    public final void handleMessageUpdate(Message message) {
        Intrinsics3.checkNotNullParameter(message, "message");
        resetState(CollectionsJVM.listOf(Long.valueOf(message.getId())));
    }

    public final void revealSpoiler(long messageId, int spoilerIndex) {
        if (spoilerIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new C62211(messageId, spoilerIndex));
    }

    public final void revealSpoilerEmbed(long messageId, int spoilerEmbedIndex) {
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new C62221(messageId, spoilerEmbedIndex));
    }

    public final void revealSpoilerEmbedData(long messageId, int spoilerEmbedIndex, String key) {
        Intrinsics3.checkNotNullParameter(key, "key");
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new C62231(messageId, spoilerEmbedIndex, key));
    }
}
