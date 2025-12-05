package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Result3;
import p507d0.p584w.p585h.Intrinsics2;
import p507d0.p584w.p586i.p587a.ContinuationImpl6;
import p507d0.p584w.p586i.p587a.DebugMetadata;
import p507d0.p592z.p594d.Intrinsics3;
import p659s.p660a.Dispatchers;
import p659s.p660a.p661a.MainDispatchers;

/* compiled from: Lifecycle.kt */
/* renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl, reason: use source file name */
/* loaded from: classes.dex */
public final class Lifecycle3 extends Lifecycle2 implements LifecycleEventObserver {
    private final CoroutineContext coroutineContext;
    private final Lifecycle lifecycle;

    /* compiled from: Lifecycle.kt */
    @DebugMetadata(m10084c = "androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1", m10085f = "Lifecycle.kt", m10086l = {}, m10087m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScopeImpl$register$1 */
    public static final class C04411 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        public int label;

        public C04411(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            C04411 c04411 = Lifecycle3.this.new C04411(continuation);
            c04411.L$0 = obj;
            return c04411;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C04411) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            if (Lifecycle3.this.getLifecycle().getCurrentState().compareTo(Lifecycle.State.INITIALIZED) >= 0) {
                Lifecycle3.this.getLifecycle().addObserver(Lifecycle3.this);
            } else {
                C3404f.m4339s(coroutineScope.getCoroutineContext(), null, 1, null);
            }
            return Unit.f27425a;
        }
    }

    public Lifecycle3(Lifecycle lifecycle, CoroutineContext coroutineContext) {
        Intrinsics3.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics3.checkNotNullParameter(coroutineContext, "coroutineContext");
        this.lifecycle = lifecycle;
        this.coroutineContext = coroutineContext;
        if (getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
            C3404f.m4339s(getCoroutineContext(), null, 1, null);
        }
    }

    @Override // androidx.view.Lifecycle2, kotlinx.coroutines.CoroutineScope
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }

    @Override // androidx.view.Lifecycle2
    /* renamed from: getLifecycle$lifecycle_runtime_ktx_release, reason: from getter */
    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    @Override // androidx.view.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        Intrinsics3.checkNotNullParameter(source, "source");
        Intrinsics3.checkNotNullParameter(event, "event");
        if (getLifecycle().getCurrentState().compareTo(Lifecycle.State.DESTROYED) <= 0) {
            getLifecycle().removeObserver(this);
            C3404f.m4339s(getCoroutineContext(), null, 1, null);
        }
    }

    public final void register() {
        CoroutineDispatcher coroutineDispatcher = Dispatchers.f27866a;
        C3404f.m4211H0(this, MainDispatchers.f27700b.mo11194H(), null, new C04411(null), 2, null);
    }
}
