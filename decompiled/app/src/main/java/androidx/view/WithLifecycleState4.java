package androidx.view;

import androidx.view.Lifecycle;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: WithLifecycleState.kt */
/* renamed from: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$$inlined$suspendCancellableCoroutine$lambda$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WithLifecycleState4 implements Runnable {
    public final /* synthetic */ Function0 $block$inlined;
    public final /* synthetic */ boolean $dispatchNeeded$inlined;
    public final /* synthetic */ CoroutineDispatcher $lifecycleDispatcher$inlined;
    public final /* synthetic */ WithLifecycleState3 $observer;
    public final /* synthetic */ Lifecycle.State $state$inlined;
    public final /* synthetic */ Lifecycle $this_suspendWithStateAtLeastUnchecked$inlined;

    public WithLifecycleState4(WithLifecycleState3 withLifecycleState3, Lifecycle lifecycle, Lifecycle.State state, Function0 function0, boolean z2, CoroutineDispatcher coroutineDispatcher) {
        this.$observer = withLifecycleState3;
        this.$this_suspendWithStateAtLeastUnchecked$inlined = lifecycle;
        this.$state$inlined = state;
        this.$block$inlined = function0;
        this.$dispatchNeeded$inlined = z2;
        this.$lifecycleDispatcher$inlined = coroutineDispatcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$this_suspendWithStateAtLeastUnchecked$inlined.addObserver(this.$observer);
    }
}
