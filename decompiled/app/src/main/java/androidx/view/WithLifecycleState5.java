package androidx.view;

import androidx.view.Lifecycle;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineDispatcher;
import p507d0.p584w.CoroutineContextImpl4;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3, reason: use source file name */
/* JADX INFO: compiled from: WithLifecycleState.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WithLifecycleState5 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ Function0 $block$inlined;
    public final /* synthetic */ boolean $dispatchNeeded$inlined;
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    public final /* synthetic */ WithLifecycleState3 $observer;
    public final /* synthetic */ Lifecycle.State $state$inlined;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    /* JADX INFO: renamed from: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: WithLifecycleState.kt */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            WithLifecycleState5 withLifecycleState5 = WithLifecycleState5.this;
            withLifecycleState5.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(withLifecycleState5.$observer);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WithLifecycleState5(WithLifecycleState3 withLifecycleState3, Lifecycle lifecycle, Lifecycle.State state, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
        super(1);
        this.$observer = withLifecycleState3;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z2;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CoroutineDispatcher coroutineDispatcher = this.$lifecycleDispatcher$inlined;
        CoroutineContextImpl4 coroutineContextImpl4 = CoroutineContextImpl4.f25237j;
        if (coroutineDispatcher.isDispatchNeeded(coroutineContextImpl4)) {
            this.$lifecycleDispatcher$inlined.dispatch(coroutineContextImpl4, new AnonymousClass1());
        } else {
            this.$this_suspendWithStateAtLeastUnchecked$inlined.removeObserver(this.$observer);
        }
    }
}
