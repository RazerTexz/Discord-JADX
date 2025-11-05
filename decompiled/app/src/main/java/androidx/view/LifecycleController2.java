package androidx.view;

import androidx.view.Lifecycle;
import b.i.a.f.e.o.f;
import d0.z.d.Intrinsics3;
import kotlinx.coroutines.Job;

/* compiled from: LifecycleController.kt */
/* renamed from: androidx.lifecycle.LifecycleController$observer$1, reason: use source file name */
/* loaded from: classes.dex */
public final class LifecycleController2 implements LifecycleEventObserver {
    public final /* synthetic */ Job $parentJob;
    public final /* synthetic */ LifecycleController this$0;

    public LifecycleController2(LifecycleController lifecycleController, Job job) {
        this.this$0 = lifecycleController;
        this.$parentJob = job;
    }

    @Override // androidx.view.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Intrinsics3.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics3.checkNotNullParameter(event, "<anonymous parameter 1>");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "source.lifecycle");
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            LifecycleController lifecycleController = this.this$0;
            f.t(this.$parentJob, null, 1, null);
            lifecycleController.finish();
        } else {
            Lifecycle lifecycle2 = lifecycleOwner.getLifecycle();
            Intrinsics3.checkNotNullExpressionValue(lifecycle2, "source.lifecycle");
            if (lifecycle2.getCurrentState().compareTo(LifecycleController.access$getMinState$p(this.this$0)) < 0) {
                LifecycleController.access$getDispatchQueue$p(this.this$0).pause();
            } else {
                LifecycleController.access$getDispatchQueue$p(this.this$0).resume();
            }
        }
    }
}
