package androidx.view;

import androidx.annotation.MainThread;
import androidx.view.Lifecycle;
import b.i.a.f.e.o.f;
import d0.z.d.m;
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
        m.checkNotNullParameter(lifecycle, "lifecycle");
        m.checkNotNullParameter(state, "minState");
        m.checkNotNullParameter(dispatchQueue, "dispatchQueue");
        m.checkNotNullParameter(job, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleController$observer$1 lifecycleController$observer$1 = new LifecycleController$observer$1(this, job);
        this.observer = lifecycleController$observer$1;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleController$observer$1);
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
