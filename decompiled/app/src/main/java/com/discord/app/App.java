package com.discord.app;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;
import b.a.k.a;
import com.discord.BuildConfig;
import com.discord.R;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.experiments.domain.Experiment;
import com.discord.stores.StoreStream;
import com.discord.utilities.analytics.AdjustConfig;
import com.discord.utilities.analytics.AnalyticsDeviceResourceUsageMonitor;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.buildutils.BuildUtils;
import com.discord.utilities.cache.SharedPreferencesProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.debug.DebugPrintableCollection;
import com.discord.utilities.error.Error;
import com.discord.utilities.fcm.NotificationClient;
import com.discord.utilities.images.MGImagesConfig;
import com.discord.utilities.lifecycle.ActivityProvider;
import com.discord.utilities.lifecycle.ApplicationProvider;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.logging.LoggingProvider;
import com.discord.utilities.persister.PersisterConfig;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.surveys.SurveyUtils;
import com.discord.utilities.systemlog.SystemLogUtils;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import d0.g0.w;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Map;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: App.kt */
/* loaded from: classes.dex */
public class App extends Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final boolean IS_LOCAL = w.contains$default((CharSequence) BuildConfig.FLAVOR, (CharSequence) "local", false, 2, (Object) null);
    private final boolean isUnderTest;

    /* compiled from: App.kt */
    /* renamed from: com.discord.app.App$a, reason: from kotlin metadata */
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: App.kt */
    public static final class b extends o implements Function1<Throwable, Unit> {
        public static final b j = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            m.checkNotNullParameter(th2, "throwable");
            Logger.e$default(AppLog.g, "Subscription error in backgrounded delay, " + th2, null, null, 6, null);
            return Unit.a;
        }
    }

    /* compiled from: App.kt */
    public static final class c extends o implements Function0<Integer> {
        public static final c j = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Integer invoke() {
            return Integer.valueOf(ColorCompat.getThemedColor(ActivityProvider.INSTANCE.getActivity(), R.attr.colorTextLink));
        }
    }

    /* compiled from: App.kt */
    public static final class d extends o implements Function2<String, View, Unit> {
        public static final d j = new d();

        public d() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(String str, View view) {
            String str2 = str;
            View view2 = view;
            m.checkNotNullParameter(str2, "url");
            m.checkNotNullParameter(view2, "view");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view2.getContext();
            m.checkNotNullExpressionValue(context, "view.context");
            UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
            return Unit.a;
        }
    }

    /* compiled from: App.kt */
    public static final /* synthetic */ class e extends k implements Function3<String, Throwable, Map<String, ? extends String>, Unit> {
        public e(AppLog appLog) {
            super(3, appLog, AppLog.class, "e", "e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/util/Map;)V", 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function3
        public Unit invoke(String str, Throwable th, Map<String, ? extends String> map) {
            String str2 = str;
            m.checkNotNullParameter(str2, "p1");
            ((AppLog) this.receiver).e(str2, th, map);
            return Unit.a;
        }
    }

    /* compiled from: App.kt */
    public static final class f extends o implements Function2<View, String, Unit> {
        public static final f j = new f();

        public f() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(View view, String str) {
            View view2 = view;
            String str2 = str;
            m.checkNotNullParameter(view2, "textView");
            m.checkNotNullParameter(str2, "url");
            UriHandler uriHandler = UriHandler.INSTANCE;
            Context context = view2.getContext();
            m.checkNotNullExpressionValue(context, "textView.context");
            UriHandler.handle$default(uriHandler, context, str2, false, false, null, 28, null);
            return Unit.a;
        }
    }

    /* compiled from: App.kt */
    public static final class g extends o implements Function1<Experiment, Unit> {
        public static final g j = new g();

        public g() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Experiment experiment) {
            return Unit.a;
        }
    }

    public static final /* synthetic */ boolean access$getIS_LOCAL$cp() {
        return IS_LOCAL;
    }

    public void initializeFlipper() {
        m.checkNotNullParameter(this, "context");
    }

    public void initializeRLottie() {
        System.loadLibrary("dsti");
    }

    /* renamed from: isUnderTest, reason: from getter */
    public boolean getIsUnderTest() {
        return this.isUnderTest;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        SharedPreferencesProvider.INSTANCE.init(this);
        ApplicationProvider.INSTANCE.init(this);
        ActivityProvider.INSTANCE.init(this);
        ClockFactory.INSTANCE.init(this);
        int i = AppLog.minLoggingPriority;
        m.checkNotNullParameter(this, "application");
        AppLog.initCalled = true;
        AppLog.minLoggingPriority = 0;
        AppLog.cache = PreferenceManager.getDefaultSharedPreferences(this);
        LoggingProvider loggingProvider = LoggingProvider.INSTANCE;
        AppLog appLog = AppLog.g;
        loggingProvider.init(appLog);
        b.i.c.c.e(this);
        if (BuildUtils.INSTANCE.isValidBuildVersionName(BuildConfig.VERSION_NAME)) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true);
        } else {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(false);
            Logger.w$default(appLog, "Disable crashlytics logging, likely modified client detected.", null, 2, null);
        }
        SystemLogUtils.INSTANCE.initSystemLogCapture();
        Objects.requireNonNull(appLog);
        Bundle bundle = getPackageManager().getApplicationInfo(getPackageName(), 128).metaData;
        String string = bundle != null ? bundle.getString("libdiscord_version") : null;
        if (string == null) {
            string = "Unknown";
        }
        appLog.recordBreadcrumb(string, "libdiscord_version");
        DebugPrintableCollection.INSTANCE.initialize(string);
        AdjustConfig.INSTANCE.init(this, getIsUnderTest());
        b.a.e.d dVar = b.a.e.d.d;
        b bVar = b.j;
        m.checkNotNullParameter(this, "application");
        m.checkNotNullParameter(bVar, "onError");
        registerActivityLifecycleCallbacks(new b.a.e.b(bVar));
        PersisterConfig.INSTANCE.init(this, ClockFactory.get());
        b.a.k.g.d dVar2 = b.a.k.g.d.f247b;
        b.a.k.g.d dVar3 = (b.a.k.g.d) b.a.k.g.d.a.getValue();
        c cVar = c.j;
        d dVar4 = d.j;
        m.checkNotNullParameter(dVar3, "formattingParserProvider");
        m.checkNotNullParameter(cVar, "defaultClickableTextColorProvider");
        m.checkNotNullParameter(dVar4, "defaultUrlOnClick");
        a aVar = a.d;
        m.checkNotNullParameter(dVar3, "formattingParserProvider");
        m.checkNotNullParameter(cVar, "defaultClickableTextColorProvider");
        m.checkNotNullParameter(dVar4, "defaultUrlOnClick");
        a.a = dVar3;
        a.f245b = cVar;
        a.c = dVar4;
        RestAPI.INSTANCE.init(this);
        NotificationClient.INSTANCE.init(this);
        MGImagesConfig.INSTANCE.init(this);
        Error.init(new b.a.d.a(new e(appLog)));
        LinkifiedTextView.INSTANCE.init(f.j);
        ModelEmojiCustom.setCdnUri(BuildConfig.HOST_CDN);
        SurveyUtils.INSTANCE.init(this);
        AppCompatDelegate.setDefaultNightMode(1);
        initializeFlipper();
        initializeRLottie();
        Objects.requireNonNull(appLog);
        if (FirebaseCrashlytics.getInstance().didCrashOnPreviousExecution()) {
            AnalyticsTracker.INSTANCE.appCrashed();
        }
        AnalyticsDeviceResourceUsageMonitor.INSTANCE.start();
        Observable<R> observableG = StoreStream.INSTANCE.getExperiments().observeUserExperiment("2022-01_rna_rollout_experiment_validation", true).y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableZ = observableG.Z(1);
        m.checkNotNullExpressionValue(observableZ, "StoreStream.getExperimen…erNull()\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(observableZ, getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, g.j, 62, (Object) null);
        AppLog.i("Application initialized.");
    }

    @Override // android.app.Application, android.content.ComponentCallbacks2
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        MGImagesConfig.INSTANCE.onTrimMemory(level);
    }
}
