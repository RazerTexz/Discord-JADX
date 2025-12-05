package androidx.view;

import androidx.view.Lifecycle;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p585h.IntrinsicsJvm;
import p507d0.p584w.p586i.p587a.DebugProbes;
import p507d0.p592z.p594d.InlineMarker;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p659s.p660a.CancellableContinuationImpl5;
import p659s.p660a.Dispatchers;
import p659s.p660a.MainCoroutineDispatcher;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: WithLifecycleState.kt */
/* renamed from: androidx.lifecycle.WithLifecycleStateKt, reason: use source file name */
/* loaded from: classes.dex */
public final class WithLifecycleState2 {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: WithLifecycleState.kt */
    /* renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2 */
    public static final class C04572<R> extends Lambda implements Function0<R> {
        public final /* synthetic */ Function0 $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C04572(Function0 function0) {
            super(0);
            this.$block = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public final R invoke() {
            return (R) this.$block.invoke();
        }
    }

    public static final <R> Object suspendWithStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, boolean z2, CoroutineDispatcher coroutineDispatcher, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CancellableContinuationImpl5 cancellableContinuationImpl5 = new CancellableContinuationImpl5(IntrinsicsJvm.intercepted(continuation), 1);
        cancellableContinuationImpl5.m11318A();
        WithLifecycleState3 withLifecycleState3 = new WithLifecycleState3(cancellableContinuationImpl5, lifecycle, state, function0, z2, coroutineDispatcher);
        if (z2) {
            coroutineDispatcher.dispatch(CoroutineContextImpl4.f25237j, new WithLifecycleState4(withLifecycleState3, lifecycle, state, function0, z2, coroutineDispatcher));
        } else {
            lifecycle.addObserver(withLifecycleState3);
        }
        cancellableContinuationImpl5.mo10902f(new WithLifecycleState5(withLifecycleState3, lifecycle, state, function0, z2, coroutineDispatcher));
        Object objM11326u = cancellableContinuationImpl5.m11326u();
        if (objM11326u == Intrinsics2.getCOROUTINE_SUSPENDED()) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return objM11326u;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    private static final Object withCreated$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    private static final Object withResumed$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    private static final Object withStarted$$forInline(Lifecycle lifecycle, Function0 function0, Continuation continuation) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    private static final Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
            MainDispatchers.f27700b.mo11194H();
            InlineMarker.mark(3);
            throw null;
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new WithLifecycleState();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return function0.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    private static final Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, Function0 function0, Continuation continuation) {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withCreated$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withResumed$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withStarted$$forInline(LifecycleOwner lifecycleOwner, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    private static final Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0 function0, Continuation continuation) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
        }
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainDispatchers.f27700b.mo11194H();
        InlineMarker.mark(3);
        throw null;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new WithLifecycleState();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new WithLifecycleState();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
        boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return function0.invoke();
                }
            } else {
                throw new WithLifecycleState();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, Function0<? extends R> function0, Continuation<? super R> continuation) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
            MainCoroutineDispatcher mainCoroutineDispatcherMo11194H = MainDispatchers.f27700b.mo11194H();
            boolean zIsDispatchNeeded = mainCoroutineDispatcherMo11194H.isDispatchNeeded(continuation.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return function0.invoke();
                    }
                } else {
                    throw new WithLifecycleState();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, mainCoroutineDispatcherMo11194H, new C04572(function0), continuation);
        }
        throw new IllegalArgumentException(("target state must be CREATED or greater, found " + state).toString());
    }
}
