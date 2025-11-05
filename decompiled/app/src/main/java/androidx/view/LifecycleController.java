package androidx.view;

import androidx.annotation.MainThread;
import androidx.view.Lifecycle;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlinx.coroutines.Job;

/* compiled from: LifecycleController.kt */
@MainThread
/* loaded from: classes.dex */
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, Job job) {
        Intrinsics3.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics3.checkNotNullParameter(state, "minState");
        Intrinsics3.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        Intrinsics3.checkNotNullParameter(job, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleController2 lifecycleController2 = new LifecycleController2(this, job);
        this.observer = lifecycleController2;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleController2);
        } else {
            f.t(job, null, 1, null);
            finish();
        }
    }

    public static final /* synthetic */ DispatchQueue access$getDispatchQueue$p(LifecycleController lifecycleController) {
        return lifecycleController.dispatchQueue;
    }

    public static final /* synthetic */ Lifecycle.State access$getMinState$p(LifecycleController lifecycleController) {
        return lifecycleController.minState;
    }

    public static final /* synthetic */ void access$handleDestroy(LifecycleController lifecycleController, Job job) {
        lifecycleController.handleDestroy(job);
    }

    private final void handleDestroy(Job parentJob) {
        f.t(parentJob, null, 1, null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
