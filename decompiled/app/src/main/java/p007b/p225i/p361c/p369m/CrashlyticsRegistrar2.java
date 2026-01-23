package p007b.p225i.p361c.p369m;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.lang.Thread;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentFactory;
import p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.MissingNativeComponent;
import p007b.p225i.p361c.p369m.p370d.Onboarding3;
import p007b.p225i.p361c.p369m.p370d.Onboarding4;
import p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventLogger;
import p007b.p225i.p361c.p369m.p370d.p371i.BlockingAnalyticsEventLogger;
import p007b.p225i.p361c.p369m.p370d.p371i.BreadcrumbAnalyticsEventReceiver;
import p007b.p225i.p361c.p369m.p370d.p371i.CrashlyticsOriginAnalyticsEventLogger;
import p007b.p225i.p361c.p369m.p370d.p371i.UnavailableAnalyticsEventLogger;
import p007b.p225i.p361c.p369m.p370d.p372j.BreadcrumbSource;
import p007b.p225i.p361c.p369m.p370d.p372j.DisabledBreadcrumbSource;
import p007b.p225i.p361c.p369m.p370d.p373k.AppData;
import p007b.p225i.p361c.p369m.p370d.p373k.C4611b0;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p373k.CallableC4651r;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsCore3;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsCore4;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsFileMarker;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsUncaughtExceptionHandler;
import p007b.p225i.p361c.p369m.p370d.p373k.DataCollectionArbiter;
import p007b.p225i.p361c.p369m.p370d.p373k.DeliveryMechanism;
import p007b.p225i.p361c.p369m.p370d.p373k.IdManager;
import p007b.p225i.p361c.p369m.p370d.p373k.SystemCurrentTimeProvider;
import p007b.p225i.p361c.p369m.p370d.p373k.Utils3;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p378o.FileStoreImpl;
import p007b.p225i.p361c.p369m.p370d.p384s.CachedSettingsIo;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsJsonParser;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.SettingsRequest;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.DefaultSettingsSpiCall;
import p007b.p225i.p361c.p369m.p370d.p388u.ResourceUnityVersionProvider;
import p007b.p225i.p361c.p401u.InterfaceC4843g;

/* JADX INFO: renamed from: b.i.c.m.b, reason: use source file name */
/* JADX INFO: compiled from: CrashlyticsRegistrar.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class CrashlyticsRegistrar2 implements ComponentFactory {

    /* JADX INFO: renamed from: a */
    public final CrashlyticsRegistrar f12221a;

    public CrashlyticsRegistrar2(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f12221a = crashlyticsRegistrar;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x026b  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03a0  */
    @Override // p007b.p225i.p361c.p368l.ComponentFactory
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo6341a(ComponentContainer componentContainer) {
        BreadcrumbSource disabledBreadcrumbSource;
        AnalyticsEventLogger unavailableAnalyticsEventLogger;
        boolean z2;
        String str;
        boolean z3;
        ExecutorService executorService;
        boolean z4;
        FileStoreImpl fileStoreImpl;
        HttpRequestFactory httpRequestFactory;
        ResourceUnityVersionProvider resourceUnityVersionProvider;
        String packageName;
        String strM6457c;
        String string;
        String str2;
        boolean zExists;
        AnalyticsEventLogger analyticsEventLogger;
        BreadcrumbSource disabledBreadcrumbSource2;
        Objects.requireNonNull(this.f12221a);
        FirebaseApp2 firebaseApp2 = (FirebaseApp2) componentContainer.mo6346a(FirebaseApp2.class);
        CrashlyticsNativeComponent crashlyticsNativeComponent = (CrashlyticsNativeComponent) componentContainer.mo6346a(CrashlyticsNativeComponent.class);
        InterfaceC4549a interfaceC4549a = (InterfaceC4549a) componentContainer.mo6346a(InterfaceC4549a.class);
        InterfaceC4843g interfaceC4843g = (InterfaceC4843g) componentContainer.mo6346a(InterfaceC4843g.class);
        firebaseApp2.m6330a();
        Context context = firebaseApp2.f12118d;
        IdManager idManager = new IdManager(context, context.getPackageName(), interfaceC4843g);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp2);
        CrashlyticsNativeComponent missingNativeComponent = crashlyticsNativeComponent == null ? new MissingNativeComponent() : crashlyticsNativeComponent;
        Onboarding4 onboarding4 = new Onboarding4(firebaseApp2, context, idManager, dataCollectionArbiter);
        if (interfaceC4549a != null) {
            Logger3 logger3 = Logger3.f12227a;
            logger3.m6371b("Firebase Analytics is available.");
            CrashlyticsOriginAnalyticsEventLogger crashlyticsOriginAnalyticsEventLogger = new CrashlyticsOriginAnalyticsEventLogger(interfaceC4549a);
            CrashlyticsAnalyticsListener crashlyticsAnalyticsListener = new CrashlyticsAnalyticsListener();
            InterfaceC4549a.a aVarMo6340c = interfaceC4549a.mo6340c("clx", crashlyticsAnalyticsListener);
            if (aVarMo6340c == null) {
                logger3.m6371b("Could not register AnalyticsConnectorListener with Crashlytics origin.");
                aVarMo6340c = interfaceC4549a.mo6340c("crash", crashlyticsAnalyticsListener);
                if (aVarMo6340c != null) {
                    logger3.m6376g("A new version of the Google Analytics for Firebase SDK is now available. For improved performance and compatibility with Crashlytics, please update to the latest version.");
                }
            }
            if (aVarMo6340c != null) {
                logger3.m6371b("Firebase Analytics listener registered successfully.");
                BreadcrumbAnalyticsEventReceiver breadcrumbAnalyticsEventReceiver = new BreadcrumbAnalyticsEventReceiver();
                BlockingAnalyticsEventLogger blockingAnalyticsEventLogger = new BlockingAnalyticsEventLogger(crashlyticsOriginAnalyticsEventLogger, 500, TimeUnit.MILLISECONDS);
                crashlyticsAnalyticsListener.f12220b = breadcrumbAnalyticsEventReceiver;
                crashlyticsAnalyticsListener.f12219a = blockingAnalyticsEventLogger;
                analyticsEventLogger = blockingAnalyticsEventLogger;
                disabledBreadcrumbSource2 = breadcrumbAnalyticsEventReceiver;
            } else {
                logger3.m6371b("Firebase Analytics listener registration failed.");
                disabledBreadcrumbSource2 = new DisabledBreadcrumbSource();
                analyticsEventLogger = crashlyticsOriginAnalyticsEventLogger;
            }
            disabledBreadcrumbSource = disabledBreadcrumbSource2;
            unavailableAnalyticsEventLogger = analyticsEventLogger;
        } else {
            Logger3.f12227a.m6371b("Firebase Analytics is unavailable.");
            disabledBreadcrumbSource = new DisabledBreadcrumbSource();
            unavailableAnalyticsEventLogger = new UnavailableAnalyticsEventLogger();
        }
        CrashlyticsCore3 crashlyticsCore3 = new CrashlyticsCore3(firebaseApp2, idManager, missingNativeComponent, dataCollectionArbiter, disabledBreadcrumbSource, unavailableAnalyticsEventLogger, C3404f.m4319n("Crashlytics Exception Handler"));
        try {
            onboarding4.f12242i = onboarding4.f12245l.m6457c();
            onboarding4.f12237d = context.getPackageManager();
            String packageName2 = context.getPackageName();
            onboarding4.f12238e = packageName2;
            PackageInfo packageInfo = onboarding4.f12237d.getPackageInfo(packageName2, 0);
            onboarding4.f12239f = packageInfo;
            onboarding4.f12240g = Integer.toString(packageInfo.versionCode);
            String str3 = onboarding4.f12239f.versionName;
            if (str3 == null) {
                str3 = "0.0";
            }
            onboarding4.f12241h = str3;
            onboarding4.f12243j = onboarding4.f12237d.getApplicationLabel(context.getApplicationInfo()).toString();
            onboarding4.f12244k = Integer.toString(context.getApplicationInfo().targetSdkVersion);
            z2 = true;
        } catch (PackageManager.NameNotFoundException e) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Failed init", e);
            }
            z2 = false;
        }
        if (!z2) {
            Logger3.f12227a.m6373d("Unable to start Crashlytics.");
            return null;
        }
        ExecutorService executorServiceM4319n = C3404f.m4319n("com.google.firebase.crashlytics.startup");
        firebaseApp2.m6330a();
        String str4 = firebaseApp2.f12120f.f12135b;
        IdManager idManager2 = onboarding4.f12245l;
        HttpRequestFactory httpRequestFactory2 = onboarding4.f12234a;
        String str5 = onboarding4.f12240g;
        String str6 = onboarding4.f12241h;
        String strM6385c = onboarding4.m6385c();
        DataCollectionArbiter dataCollectionArbiter2 = onboarding4.f12246m;
        String strM6457c2 = idManager2.m6457c();
        SystemCurrentTimeProvider systemCurrentTimeProvider = new SystemCurrentTimeProvider();
        SettingsJsonParser settingsJsonParser = new SettingsJsonParser(systemCurrentTimeProvider);
        CachedSettingsIo cachedSettingsIo = new CachedSettingsIo(context);
        Locale locale = Locale.US;
        SettingsController settingsController = new SettingsController(context, new SettingsRequest(str4, String.format(locale, "%s/%s", idManager2.m6459e(Build.MANUFACTURER), idManager2.m6459e(Build.MODEL)), idManager2.m6459e(Build.VERSION.INCREMENTAL), idManager2.m6459e(Build.VERSION.RELEASE), idManager2, CommonUtils.m6412f(CommonUtils.m6418l(context), str4, str6, str5), str6, str5, DeliveryMechanism.m6452f(strM6457c2).m6453g()), systemCurrentTimeProvider, settingsJsonParser, cachedSettingsIo, new DefaultSettingsSpiCall(strM6385c, String.format(locale, "https://firebase-settings.crashlytics.com/spi/v2/platforms/android/gmp/%s/settings", str4), httpRequestFactory2), dataCollectionArbiter2);
        settingsController.m6686d(1, executorServiceM4319n).mo6014i(executorServiceM4319n, new Onboarding3(onboarding4));
        String strM6418l = CommonUtils.m6418l(crashlyticsCore3.f12329a);
        Logger3 logger32 = Logger3.f12227a;
        outline.m868o0("Mapping file ID is: ", strM6418l, logger32);
        if (CommonUtils.m6416j(crashlyticsCore3.f12329a, "com.crashlytics.RequireBuildId", true)) {
            if (CommonUtils.m6426t(strM6418l)) {
                str = "FirebaseCrashlytics";
                Log.e(str, ".");
                Log.e(str, ".     |  | ");
                Log.e(str, ".     |  |");
                Log.e(str, ".     |  |");
                Log.e(str, ".   \\ |  | /");
                Log.e(str, ".    \\    /");
                Log.e(str, ".     \\  /");
                Log.e(str, ".      \\/");
                Log.e(str, ".");
                Log.e(str, "The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
                Log.e(str, ".");
                Log.e(str, ".      /\\");
                Log.e(str, ".     /  \\");
                Log.e(str, ".    /    \\");
                Log.e(str, ".   / |  | \\");
                Log.e(str, ".     |  |");
                Log.e(str, ".     |  |");
                Log.e(str, ".     |  |");
                Log.e(str, ".");
                z3 = false;
            }
            if (z3) {
                throw new IllegalStateException("The Crashlytics build ID is missing. This occurs when Crashlytics tooling is absent from your app's build configuration. Please review Crashlytics onboarding instructions and ensure you have a valid Crashlytics account.");
            }
            FirebaseApp2 firebaseApp22 = crashlyticsCore3.f12330b;
            firebaseApp22.m6330a();
            String str7 = firebaseApp22.f12120f.f12135b;
            try {
                logger32.m6375f("Initializing Crashlytics 17.3.0");
                Context context2 = crashlyticsCore3.f12329a;
                fileStoreImpl = new FileStoreImpl(context2);
                crashlyticsCore3.f12334f = new CrashlyticsFileMarker("crash_marker", fileStoreImpl);
                crashlyticsCore3.f12333e = new CrashlyticsFileMarker("initialization_marker", fileStoreImpl);
                httpRequestFactory = new HttpRequestFactory();
                resourceUnityVersionProvider = new ResourceUnityVersionProvider(context2);
                IdManager idManager3 = crashlyticsCore3.f12337i;
                packageName = context2.getPackageName();
                strM6457c = idManager3.m6457c();
                PackageInfo packageInfo2 = context2.getPackageManager().getPackageInfo(packageName, 0);
                string = Integer.toString(packageInfo2.versionCode);
                str2 = packageInfo2.versionName;
                if (str2 == null) {
                    str2 = "0.0";
                }
                executorService = executorServiceM4319n;
            } catch (Exception e2) {
                e = e2;
                executorService = executorServiceM4319n;
            }
            try {
                AppData appData = new AppData(str7, strM6418l, strM6457c, packageName, string, str2, resourceUnityVersionProvider);
                logger32.m6371b("Installer package name is: " + strM6457c);
                crashlyticsCore3.f12336h = new C4663x(crashlyticsCore3.f12329a, crashlyticsCore3.f12341m, httpRequestFactory, crashlyticsCore3.f12337i, crashlyticsCore3.f12331c, fileStoreImpl, crashlyticsCore3.f12334f, appData, null, null, crashlyticsCore3.f12342n, crashlyticsCore3.f12339k, settingsController);
                zExists = crashlyticsCore3.f12333e.m6445b().exists();
                try {
                    crashlyticsCore3.f12335g = Boolean.TRUE.equals((Boolean) Utils3.m6432a(crashlyticsCore3.f12341m.m6437b(new CrashlyticsCore4(crashlyticsCore3))));
                } catch (Exception unused) {
                    crashlyticsCore3.f12335g = false;
                }
                C4663x c4663x = crashlyticsCore3.f12336h;
                Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
                c4663x.f12433m.m6437b(new CallableC4651r(c4663x));
                CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new C4611b0(c4663x), settingsController, defaultUncaughtExceptionHandler);
                c4663x.f12423B = crashlyticsUncaughtExceptionHandler;
                Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
            } catch (Exception e3) {
                e = e3;
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e(str, "Crashlytics was not started due to an exception during initialization", e);
                }
                crashlyticsCore3.f12336h = null;
            }
            if (!zExists || !CommonUtils.m6408b(crashlyticsCore3.f12329a)) {
                Logger3.f12227a.m6371b("Exception handling initialization successful");
                z4 = true;
                C3404f.m4323o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
                return new FirebaseCrashlytics(crashlyticsCore3);
            }
            Logger3.f12227a.m6371b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
            crashlyticsCore3.m6440b(settingsController);
            z4 = false;
            C3404f.m4323o(executorService, new FirebaseCrashlytics2(onboarding4, executorService, settingsController, z4, crashlyticsCore3));
            return new FirebaseCrashlytics(crashlyticsCore3);
        }
        logger32.m6371b("Configured not to require a build ID.");
        z3 = true;
        str = "FirebaseCrashlytics";
        if (z3) {
        }
    }
}
