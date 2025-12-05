package com.discord.widgets.status;

import androidx.annotation.MainThread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.subjects.BehaviorSubject;

/* compiled from: WidgetGlobalStatusIndicatorState.kt */
/* loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicatorState {

    /* renamed from: Provider, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final WidgetGlobalStatusIndicatorState callIndicatorState = new WidgetGlobalStatusIndicatorState();
    private final BehaviorSubject<State> stateSubject = BehaviorSubject.m11129k0();

    /* compiled from: WidgetGlobalStatusIndicatorState.kt */
    /* renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicatorState$Provider, reason: from kotlin metadata */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetGlobalStatusIndicatorState get() {
            return WidgetGlobalStatusIndicatorState.access$getCallIndicatorState$cp();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGlobalStatusIndicatorState.kt */
    public static final /* data */ class State {
        private final boolean isCustomBackground;
        private final boolean isViewingCall;
        private final boolean isVisible;

        public State(boolean z2, boolean z3, boolean z4) {
            this.isVisible = z2;
            this.isCustomBackground = z3;
            this.isViewingCall = z4;
        }

        public static /* synthetic */ State copy$default(State state, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = state.isVisible;
            }
            if ((i & 2) != 0) {
                z3 = state.isCustomBackground;
            }
            if ((i & 4) != 0) {
                z4 = state.isViewingCall;
            }
            return state.copy(z2, z3, z4);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getIsCustomBackground() {
            return this.isCustomBackground;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsViewingCall() {
            return this.isViewingCall;
        }

        public final State copy(boolean isVisible, boolean isCustomBackground, boolean isViewingCall) {
            return new State(isVisible, isCustomBackground, isViewingCall);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof State)) {
                return false;
            }
            State state = (State) other;
            return this.isVisible == state.isVisible && this.isCustomBackground == state.isCustomBackground && this.isViewingCall == state.isViewingCall;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
        public int hashCode() {
            boolean z2 = this.isVisible;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            ?? r2 = this.isCustomBackground;
            int i2 = r2;
            if (r2 != 0) {
                i2 = 1;
            }
            int i3 = (i + i2) * 31;
            boolean z3 = this.isViewingCall;
            return i3 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public final boolean isCustomBackground() {
            return this.isCustomBackground;
        }

        public final boolean isViewingCall() {
            return this.isViewingCall;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("State(isVisible=");
            sbM833U.append(this.isVisible);
            sbM833U.append(", isCustomBackground=");
            sbM833U.append(this.isCustomBackground);
            sbM833U.append(", isViewingCall=");
            return outline.m827O(sbM833U, this.isViewingCall, ")");
        }
    }

    public static final /* synthetic */ WidgetGlobalStatusIndicatorState access$getCallIndicatorState$cp() {
        return callIndicatorState;
    }

    public static /* synthetic */ void updateState$default(WidgetGlobalStatusIndicatorState widgetGlobalStatusIndicatorState, boolean z2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            BehaviorSubject<State> behaviorSubject = widgetGlobalStatusIndicatorState.stateSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "stateSubject");
            State stateM11132n0 = behaviorSubject.m11132n0();
            z2 = stateM11132n0 != null ? stateM11132n0.isVisible() : false;
        }
        if ((i & 2) != 0) {
            BehaviorSubject<State> behaviorSubject2 = widgetGlobalStatusIndicatorState.stateSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject2, "stateSubject");
            State stateM11132n02 = behaviorSubject2.m11132n0();
            z3 = stateM11132n02 != null ? stateM11132n02.isCustomBackground() : false;
        }
        if ((i & 4) != 0) {
            BehaviorSubject<State> behaviorSubject3 = widgetGlobalStatusIndicatorState.stateSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject3, "stateSubject");
            State stateM11132n03 = behaviorSubject3.m11132n0();
            z4 = stateM11132n03 != null ? stateM11132n03.isViewingCall() : false;
        }
        widgetGlobalStatusIndicatorState.updateState(z2, z3, z4);
    }

    public final Observable<State> observeState() {
        Observable<State> observableM11112r = this.stateSubject.m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "stateSubject.distinctUntilChanged()");
        return observableM11112r;
    }

    @MainThread
    public final void updateState(boolean isVisible, boolean isPrimaryBackground, boolean isViewingCall) {
        this.stateSubject.onNext(new State(isVisible, isPrimaryBackground, isViewingCall));
    }
}
