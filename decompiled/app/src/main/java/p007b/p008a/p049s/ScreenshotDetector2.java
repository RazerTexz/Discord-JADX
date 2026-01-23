package p007b.p008a.p049s;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.appcompat.widget.ActivityChooserModel;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.s.a, reason: use source file name */
/* JADX INFO: compiled from: ScreenshotDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ScreenshotDetector2 implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: j */
    public boolean f1877j;

    /* JADX INFO: renamed from: k */
    public final ScreenshotContentObserver f1878k;

    public ScreenshotDetector2(ScreenshotContentObserver screenshotContentObserver) {
        Intrinsics3.checkNotNullParameter(screenshotContentObserver, "observer");
        this.f1878k = screenshotContentObserver;
    }

    /* JADX INFO: renamed from: a */
    public final void m364a(boolean z2) {
        if (!z2 && this.f1877j) {
            ScreenshotContentObserver screenshotContentObserver = this.f1878k;
            screenshotContentObserver.f1882d.unregisterContentObserver(screenshotContentObserver);
            this.f1877j = false;
        }
        if (!z2 || this.f1877j) {
            return;
        }
        ScreenshotContentObserver screenshotContentObserver2 = this.f1878k;
        screenshotContentObserver2.f1882d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, screenshotContentObserver2);
        this.f1877j = true;
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
        if (this.f1877j) {
            ScreenshotContentObserver screenshotContentObserver = this.f1878k;
            screenshotContentObserver.f1882d.unregisterContentObserver(screenshotContentObserver);
            this.f1877j = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        if (this.f1877j) {
            return;
        }
        ScreenshotContentObserver screenshotContentObserver = this.f1878k;
        screenshotContentObserver.f1882d.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true, screenshotContentObserver);
        this.f1877j = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(bundle, "outState");
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
