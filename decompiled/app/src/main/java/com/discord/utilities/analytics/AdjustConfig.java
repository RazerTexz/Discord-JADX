package com.discord.utilities.analytics;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.OnDeviceIdsRead;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: AdjustConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AdjustConfig {
    private static final String ADJUST_APP_TOKEN = "d8fcx8xdmrr4";
    public static final AdjustConfig INSTANCE = new AdjustConfig();
    private static final String ADJUST_ENVIRONMENT = "production";

    /* JADX INFO: compiled from: AdjustConfig.kt */
    public static final class AdjustLifecycleListener implements Application.ActivityLifecycleCallbacks {
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
            Adjust.onPause();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Adjust.onResume();
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

    /* JADX INFO: renamed from: com.discord.utilities.analytics.AdjustConfig$init$2 */
    /* JADX INFO: compiled from: AdjustConfig.kt */
    public static final class C66662 implements OnDeviceIdsRead {
        public static final C66662 INSTANCE = new C66662();

        @Override // com.adjust.sdk.OnDeviceIdsRead
        public final void onGoogleAdIdRead(String str) {
            if (str != null) {
                AnalyticSuperProperties.INSTANCE.setAdvertiserId(str);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.analytics.AdjustConfig$init$3 */
    /* JADX INFO: compiled from: AdjustConfig.kt */
    public static final class C66673 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Application $application;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66673(Application application) {
            super(1);
            this.$application = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "referrerUrl");
            Adjust.setReferrer(str, this.$application);
            AnalyticSuperProperties.INSTANCE.setCampaignProperties(str);
        }
    }

    private AdjustConfig() {
    }

    public final void init(Application application, boolean isUnderTest) {
        Intrinsics3.checkNotNullParameter(application, "application");
        if (isUnderTest) {
            return;
        }
        com.adjust.sdk.AdjustConfig adjustConfig = new com.adjust.sdk.AdjustConfig(application, ADJUST_APP_TOKEN, ADJUST_ENVIRONMENT);
        adjustConfig.setOnAttributionChangedListener(AdjustConfig2.INSTANCE);
        Adjust.onCreate(adjustConfig);
        Adjust.getGoogleAdId(application, C66662.INSTANCE);
        InstallReferrer.INSTANCE.init(new C66673(application));
        application.registerActivityLifecycleCallbacks(new AdjustLifecycleListener());
    }
}
