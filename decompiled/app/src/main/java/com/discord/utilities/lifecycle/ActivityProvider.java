package com.discord.utilities.lifecycle;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.annotation.MainThread;
import androidx.appcompat.widget.ActivityChooserModel;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ActivityProvider.kt */
/* loaded from: classes2.dex */
public final class ActivityProvider implements Application.ActivityLifecycleCallbacks {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @SuppressLint({"StaticFieldLeak"})
    private static ActivityProvider INSTANCE;
    private Activity currentActivity;

    /* compiled from: ActivityProvider.kt */
    public static final class Companion {
        private Companion() {
        }

        @MainThread
        public final Activity getActivity() {
            ActivityProvider activityProviderAccess$getINSTANCE$cp = ActivityProvider.access$getINSTANCE$cp();
            if (activityProviderAccess$getINSTANCE$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("INSTANCE");
            }
            return activityProviderAccess$getINSTANCE$cp.getCurrentActivity();
        }

        public final void init(Application application) {
            Intrinsics3.checkNotNullParameter(application, "application");
            ActivityProvider.access$setINSTANCE$cp(new ActivityProvider());
            ActivityProvider activityProviderAccess$getINSTANCE$cp = ActivityProvider.access$getINSTANCE$cp();
            if (activityProviderAccess$getINSTANCE$cp == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("INSTANCE");
            }
            application.registerActivityLifecycleCallbacks(activityProviderAccess$getINSTANCE$cp);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static final /* synthetic */ Activity access$getCurrentActivity$p(ActivityProvider activityProvider) {
        return activityProvider.currentActivity;
    }

    public static final /* synthetic */ ActivityProvider access$getINSTANCE$cp() {
        return INSTANCE;
    }

    public static final /* synthetic */ void access$setCurrentActivity$p(ActivityProvider activityProvider, Activity activity) {
        activityProvider.currentActivity = activity;
    }

    public static final /* synthetic */ void access$setINSTANCE$cp(ActivityProvider activityProvider) {
        INSTANCE = activityProvider;
    }

    public final Activity getCurrentActivity() {
        return this.currentActivity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPostStarted(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPrePaused(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPreStopped(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Intrinsics3.checkNotNullParameter(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        this.currentActivity = activity;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        int iHashCode = activity.hashCode();
        Activity activity2 = this.currentActivity;
        if (activity2 == null || iHashCode != activity2.hashCode()) {
            return;
        }
        this.currentActivity = null;
    }
}
