package p007b.p008a.p020e;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.e.b, reason: use source file name */
/* JADX INFO: compiled from: Backgrounded.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Backgrounded2 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Function1 f595j;

    public Backgrounded2(Function1 function1) {
        this.f595j = function1;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Backgrounded4 backgrounded4 = Backgrounded4.f600d;
        Function1 function1 = this.f595j;
        Observable<T> observableM11111q = new ScalarSynchronousObservable(Boolean.TRUE).m11111q(2000L, TimeUnit.MILLISECONDS);
        Backgrounded3 backgrounded3 = new Backgrounded3(new Backgrounded(backgrounded4));
        Object backgrounded32 = function1;
        if (function1 != null) {
            backgrounded32 = new Backgrounded3(function1);
        }
        Backgrounded4.f599c = observableM11111q.m11097W(backgrounded3, (Action1) backgrounded32);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Backgrounded4 backgrounded4 = Backgrounded4.f600d;
        Backgrounded4.f597a = false;
        Subscription subscription = Backgrounded4.f599c;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Backgrounded4.f598b.onNext(Boolean.FALSE);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(bundle, "bundle");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }
}
