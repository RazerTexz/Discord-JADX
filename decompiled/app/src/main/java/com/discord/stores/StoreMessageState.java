package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.message.Message;
import com.discord.models.domain.ModelMessageDelete;
import d0.t.h0;
import d0.t.n0;
import d0.t.o0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

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
            m.checkNotNullParameter(set, "visibleSpoilerNodeIndices");
            m.checkNotNullParameter(map, "visibleSpoilerEmbedMap");
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
            m.checkNotNullParameter(visibleSpoilerNodeIndices, "visibleSpoilerNodeIndices");
            m.checkNotNullParameter(visibleSpoilerEmbedMap, "visibleSpoilerEmbedMap");
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
            return m.areEqual(this.visibleSpoilerNodeIndices, state.visibleSpoilerNodeIndices) && m.areEqual(this.visibleSpoilerEmbedMap, state.visibleSpoilerEmbedMap);
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
            StringBuilder sbU = a.U("State(visibleSpoilerNodeIndices=");
            sbU.append(this.visibleSpoilerNodeIndices);
            sbU.append(", visibleSpoilerEmbedMap=");
            return a.M(sbU, this.visibleSpoilerEmbedMap, ")");
        }

        public /* synthetic */ State(Set set, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? n0.emptySet() : set, (i & 2) != 0 ? h0.emptyMap() : map);
        }
    }

    /* compiled from: StoreMessageState.kt */
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerIndex;

        /* compiled from: StoreMessageState.kt */
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoiler$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02741 extends o implements Function1<State, State> {
            public C02741() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                m.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, o0.plus(state.getVisibleSpoilerNodeIndices(), Integer.valueOf(AnonymousClass1.this.$spoilerIndex)), null, 2, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new C02741());
        }
    }

    /* compiled from: StoreMessageState.kt */
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* compiled from: StoreMessageState.kt */
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbed$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02751 extends o implements Function1<State, State> {
            public C02751() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                m.checkNotNullParameter(state, "currentState");
                return State.copy$default(state, null, h0.plus(state.getVisibleSpoilerEmbedMap(), d0.o.to(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex), n0.emptySet())), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new C02751());
        }
    }

    /* compiled from: StoreMessageState.kt */
    /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ String $key;
        public final /* synthetic */ long $messageId;
        public final /* synthetic */ int $spoilerEmbedIndex;

        /* compiled from: StoreMessageState.kt */
        /* renamed from: com.discord.stores.StoreMessageState$revealSpoilerEmbedData$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02761 extends o implements Function1<State, State> {
            public C02761() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ State invoke(State state) {
                return invoke2(state);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final State invoke2(State state) {
                m.checkNotNullParameter(state, "currentState");
                Set<String> setEmptySet = state.getVisibleSpoilerEmbedMap().get(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex));
                if (setEmptySet == null) {
                    setEmptySet = n0.emptySet();
                }
                return State.copy$default(state, null, h0.plus(state.getVisibleSpoilerEmbedMap(), d0.o.to(Integer.valueOf(AnonymousClass1.this.$spoilerEmbedIndex), o0.plus(setEmptySet, AnonymousClass1.this.$key))), 1, null);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, int i, String str) {
            super(0);
            this.$messageId = j;
            this.$spoilerEmbedIndex = i;
            this.$key = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMessageState.access$updateState(StoreMessageState.this, this.$messageId, new C02761());
        }
    }

    public StoreMessageState(Dispatcher dispatcher) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        this.dispatcher = dispatcher;
        BehaviorSubject<Map<Long, State>> behaviorSubjectL0 = BehaviorSubject.l0(h0.emptyMap());
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(emptyMap())");
        this.messageStateSubject = behaviorSubjectL0;
    }

    public static final /* synthetic */ void access$updateState(StoreMessageState storeMessageState, long j, Function1 function1) {
        storeMessageState.updateState(j, function1);
    }

    @StoreThread
    private final void resetState(List<Long> messagesList) {
        Map<Long, State> mapN0 = this.messageStateSubject.n0();
        ArrayList arrayList = new ArrayList();
        for (Object obj : messagesList) {
            long jLongValue = ((Number) obj).longValue();
            m.checkNotNullExpressionValue(mapN0, "messageStateMap");
            if (mapN0.containsKey(Long.valueOf(jLongValue))) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        m.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(h0.minus((Map) mapN0, (Iterable) arrayList));
    }

    @StoreThread
    private final void updateState(long messageId, Function1<? super State, State> updateFunction) {
        Map<Long, State> mapN0 = this.messageStateSubject.n0();
        State state = mapN0.get(Long.valueOf(messageId));
        if (state == null) {
            state = new State(null, null, 3, null);
        }
        State stateInvoke = updateFunction.invoke(state);
        BehaviorSubject<Map<Long, State>> behaviorSubject = this.messageStateSubject;
        m.checkNotNullExpressionValue(mapN0, "messageStateMap");
        behaviorSubject.onNext(h0.plus(mapN0, d0.o.to(Long.valueOf(messageId), stateInvoke)));
    }

    public final Observable<Map<Long, State>> getMessageState() {
        Observable<Map<Long, State>> observableR = this.messageStateSubject.r();
        m.checkNotNullExpressionValue(observableR, "messageStateSubject.distinctUntilChanged()");
        return observableR;
    }

    @StoreThread
    public final void handleChannelSelected() {
        this.messageStateSubject.onNext(h0.emptyMap());
    }

    @StoreThread
    public final void handleMessageDelete(ModelMessageDelete messageDelete) {
        m.checkNotNullParameter(messageDelete, "messageDelete");
        List<Long> messageIds = messageDelete.getMessageIds();
        m.checkNotNullExpressionValue(messageIds, "messageDelete.messageIds");
        resetState(messageIds);
    }

    @StoreThread
    public final void handleMessageUpdate(Message message) {
        m.checkNotNullParameter(message, "message");
        resetState(d0.t.m.listOf(Long.valueOf(message.getId())));
    }

    public final void revealSpoiler(long messageId, int spoilerIndex) {
        if (spoilerIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerIndex));
    }

    public final void revealSpoilerEmbed(long messageId, int spoilerEmbedIndex) {
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerEmbedIndex));
    }

    public final void revealSpoilerEmbedData(long messageId, int spoilerEmbedIndex, String key) {
        m.checkNotNullParameter(key, "key");
        if (spoilerEmbedIndex < 0) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(messageId, spoilerEmbedIndex, key));
    }
}
