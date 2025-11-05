package com.discord.utilities.analytics;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import com.adjust.sdk.Adjust;
import com.adjust.sdk.OnDeviceIdsRead;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: AdjustConfig.kt */
/* loaded from: classes2.dex */
public final class AdjustConfig {
    private static final String ADJUST_APP_TOKEN = "d8fcx8xdmrr4";
    public static final AdjustConfig INSTANCE = new AdjustConfig();
    private static final String ADJUST_ENVIRONMENT = "production";

    /* compiled from: AdjustConfig.kt */
    public static final class AdjustLifecycleListener implements Application.ActivityLifecycleCallbacks {
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Adjust.onPause();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Adjust.onResume();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            m.checkNotNullParameter(bundle, "bundle");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        }
    }

    /* compiled from: AdjustConfig.kt */
    /* renamed from: com.discord.utilities.analytics.AdjustConfig$init$2, reason: invalid class name */
    public static final class AnonymousClass2 implements OnDeviceIdsRead {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // com.adjust.sdk.OnDeviceIdsRead
        public final void onGoogleAdIdRead(String str) {
            if (str != null) {
                AnalyticSuperProperties.INSTANCE.setAdvertiserId(str);
            }
        }
    }

    /* compiled from: AdjustConfig.kt */
    /* renamed from: com.discord.utilities.analytics.AdjustConfig$init$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<String, Unit> {
        public final /* synthetic */ Application $application;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Application application) {
            super(1);
            this.$application = application;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "referrerUrl");
            Adjust.setReferrer(str, this.$application);
            AnalyticSuperProperties.INSTANCE.setCampaignProperties(str);
        }
    }

    private AdjustConfig() {
    }

    public final void init(Application application, boolean isUnderTest) {
        m.checkNotNullParameter(application, "application");
        if (isUnderTest) {
            return;
        }
        com.adjust.sdk.AdjustConfig adjustConfig = new com.adjust.sdk.AdjustConfig(application, ADJUST_APP_TOKEN, ADJUST_ENVIRONMENT);
        adjustConfig.setOnAttributionChangedListener(AdjustConfig$init$1$1.INSTANCE);
        Adjust.onCreate(adjustConfig);
        Adjust.getGoogleAdId(application, AnonymousClass2.INSTANCE);
        InstallReferrer.INSTANCE.init(new AnonymousClass3(application));
        application.registerActivityLifecycleCallbacks(new AdjustLifecycleListener());
    }
}
