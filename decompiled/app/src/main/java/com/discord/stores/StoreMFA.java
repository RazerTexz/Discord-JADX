package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.stores.updates.ObservationDeck;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* compiled from: StoreMFA.kt */
/* loaded from: classes2.dex */
public final class StoreMFA extends StoreV2 {
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private State state;
    private final StoreStream stream;

    /* compiled from: StoreMFA.kt */
    public enum MFAActivationState {
        PENDING_ENABLED,
        PENDING_DISABLED,
        NONE
    }

    /* compiled from: StoreMFA.kt */
    public static final /* data */ class State {
        private final MFAActivationState activationState;
        private final boolean isTogglingSMSBackup;

        public State(MFAActivationState mFAActivationState, boolean z2) {
            Intrinsics3.checkNotNullParameter(mFAActivationState, "activationState");
            this.activationState = mFAActivationState;
            this.isTogglingSMSBackup = z2;
        }

        public static /* synthetic */ State copy$default(State state, MFAActivationState mFAActivationState, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                mFAActivationState = state.activationState;
            }
            if ((i & 2) != 0) {
                z2 = state.isTogglingSMSBackup;
            }
            return state.copy(mFAActivationState, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final MFAActivationState getActivationState() {
            return this.activationState;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsTogglingSMSBackup() {
            return this.isTogglingSMSBackup;
        }

        public final State copy(MFAActivationState activationState, boolean isTogglingSMSBackup) {
            Intrinsics3.checkNotNullParameter(activationState, "activationState");
            return new State(activationState, isTogglingSMSBackup);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return Intrinsics3.areEqual(this.activationState, state.activationState) && this.isTogglingSMSBackup == state.isTogglingSMSBackup;
        }

        public final MFAActivationState getActivationState() {
            return this.activationState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MFAActivationState mFAActivationState = this.activationState;
            int iHashCode = (mFAActivationState != null ? mFAActivationState.hashCode() : 0) * 31;
            boolean z2 = this.isTogglingSMSBackup;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            return iHashCode + i;
        }

        public final boolean isTogglingSMSBackup() {
            return this.isTogglingSMSBackup;
        }

        public String toString() {
            StringBuilder sbU = outline.U("State(activationState=");
            sbU.append(this.activationState);
            sbU.append(", isTogglingSMSBackup=");
            return outline.O(sbU, this.isTogglingSMSBackup, ")");
        }
    }

    /* compiled from: StoreMFA.kt */
    /* renamed from: com.discord.stores.StoreMFA$observeState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<State> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ State invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final State invoke() {
            return StoreMFA.access$getState$p(StoreMFA.this);
        }
    }

    /* compiled from: StoreMFA.kt */
    /* renamed from: com.discord.stores.StoreMFA$togglingSMSBackup$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            StoreMFA.access$setState$p(storeMFA, State.copy$default(StoreMFA.access$getState$p(storeMFA), null, true, 1, null));
            StoreMFA.this.markChanged();
        }
    }

    /* compiled from: StoreMFA.kt */
    /* renamed from: com.discord.stores.StoreMFA$updatePendingMFAState$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ MFAActivationState $newActivationState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(MFAActivationState mFAActivationState) {
            super(0);
            this.$newActivationState = mFAActivationState;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreMFA storeMFA = StoreMFA.this;
            StoreMFA.access$setState$p(storeMFA, State.copy$default(StoreMFA.access$getState$p(storeMFA), this.$newActivationState, false, 2, null));
            StoreMFA.this.markChanged();
        }
    }

    public StoreMFA(StoreStream storeStream, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.state = new State(MFAActivationState.NONE, false);
    }

    public static final /* synthetic */ State access$getState$p(StoreMFA storeMFA) {
        return storeMFA.state;
    }

    public static final /* synthetic */ void access$setState$p(StoreMFA storeMFA, State state) {
        storeMFA.state = state;
    }

    @Store3
    public final void handleUserUpdated(User user) {
        Intrinsics3.checkNotNullParameter(user, "user");
        if (user.getId() == this.stream.getUsers().getMe().getId()) {
            this.state = new State(MFAActivationState.NONE, false);
            markChanged();
        }
    }

    public final Observable<State> observeState() {
        Observable<State> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void togglingSMSBackup() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final void updatePendingMFAState(MFAActivationState newActivationState) {
        Intrinsics3.checkNotNullParameter(newActivationState, "newActivationState");
        this.dispatcher.schedule(new AnonymousClass1(newActivationState));
    }
}
