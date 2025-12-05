package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p371i.AnalyticsEventLogger;
import p007b.p225i.p361c.p369m.p370d.p372j.BreadcrumbSource;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsDataProvider;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.Settings2;

/* compiled from: CrashlyticsCore.java */
/* renamed from: b.i.c.m.d.k.k0, reason: use source file name */
/* loaded from: classes3.dex */
public class CrashlyticsCore3 {

    /* renamed from: a */
    public final Context f12329a;

    /* renamed from: b */
    public final FirebaseApp2 f12330b;

    /* renamed from: c */
    public final DataCollectionArbiter f12331c;

    /* renamed from: d */
    public final long f12332d;

    /* renamed from: e */
    public CrashlyticsFileMarker f12333e;

    /* renamed from: f */
    public CrashlyticsFileMarker f12334f;

    /* renamed from: g */
    public boolean f12335g;

    /* renamed from: h */
    public C4663x f12336h;

    /* renamed from: i */
    public final IdManager f12337i;

    /* renamed from: j */
    public final BreadcrumbSource f12338j;

    /* renamed from: k */
    public final AnalyticsEventLogger f12339k;

    /* renamed from: l */
    public ExecutorService f12340l;

    /* renamed from: m */
    public CrashlyticsBackgroundWorker f12341m;

    /* renamed from: n */
    public CrashlyticsNativeComponent f12342n;

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: b.i.c.m.d.k.k0$a */
    public class a implements Runnable {

        /* renamed from: j */
        public final /* synthetic */ SettingsDataProvider f12343j;

        public a(SettingsDataProvider settingsDataProvider) {
            this.f12343j = settingsDataProvider;
        }

        @Override // java.lang.Runnable
        public void run() {
            CrashlyticsCore3.m6439a(CrashlyticsCore3.this, this.f12343j);
        }
    }

    /* compiled from: CrashlyticsCore.java */
    /* renamed from: b.i.c.m.d.k.k0$b */
    public class b implements Callable<Boolean> {
        public b() {
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            try {
                boolean zDelete = CrashlyticsCore3.this.f12333e.m6445b().delete();
                Logger3.f12227a.m6371b("Initialization marker file removed: " + zDelete);
                return Boolean.valueOf(zDelete);
            } catch (Exception e) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Problem encountered deleting Crashlytics initialization marker.", e);
                }
                return Boolean.FALSE;
            }
        }
    }

    public CrashlyticsCore3(FirebaseApp2 firebaseApp2, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, ExecutorService executorService) {
        this.f12330b = firebaseApp2;
        this.f12331c = dataCollectionArbiter;
        firebaseApp2.m6330a();
        this.f12329a = firebaseApp2.f12118d;
        this.f12337i = idManager;
        this.f12342n = crashlyticsNativeComponent;
        this.f12338j = breadcrumbSource;
        this.f12339k = analyticsEventLogger;
        this.f12340l = executorService;
        this.f12341m = new CrashlyticsBackgroundWorker(executorService);
        this.f12332d = System.currentTimeMillis();
    }

    /* renamed from: a */
    public static Task m6439a(CrashlyticsCore3 crashlyticsCore3, SettingsDataProvider settingsDataProvider) {
        Task<Void> taskM4261Y;
        crashlyticsCore3.f12341m.m6436a();
        crashlyticsCore3.f12333e.m6444a();
        Logger3 logger3 = Logger3.f12227a;
        logger3.m6371b("Initialization marker file created.");
        C4663x c4663x = crashlyticsCore3.f12336h;
        CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = c4663x.f12433m;
        crashlyticsBackgroundWorker.m6437b(new CrashlyticsBackgroundWorker2(crashlyticsBackgroundWorker, new RunnableC4653s(c4663x)));
        try {
            try {
                crashlyticsCore3.f12338j.mo6389a(new CrashlyticsCore(crashlyticsCore3));
                SettingsController settingsController = (SettingsController) settingsDataProvider;
                Settings2 settings2M6685c = settingsController.m6685c();
                if (settings2M6685c.mo6689a().f12757a) {
                    if (!crashlyticsCore3.f12336h.m6473h(settings2M6685c.mo6690b().f12758a)) {
                        logger3.m6371b("Could not finalize previous sessions.");
                    }
                    taskM4261Y = crashlyticsCore3.f12336h.m6482u(1.0f, settingsController.m6683a());
                } else {
                    logger3.m6371b("Collection of crash reports disabled in Crashlytics settings.");
                    taskM4261Y = C3404f.m4261Y(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
                }
            } catch (Exception e) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Crashlytics encountered a problem during asynchronous initialization.", e);
                }
                taskM4261Y = C3404f.m4261Y(e);
            }
            return taskM4261Y;
        } finally {
            crashlyticsCore3.m6441c();
        }
    }

    /* renamed from: b */
    public final void m6440b(SettingsDataProvider settingsDataProvider) {
        Future<?> futureSubmit = this.f12340l.submit(new a(settingsDataProvider));
        Logger3.f12227a.m6371b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            futureSubmit.get(4L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics was interrupted during initialization.", e);
            }
        } catch (ExecutionException e2) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Problem encountered during Crashlytics initialization.", e2);
            }
        } catch (TimeoutException e3) {
            if (Logger3.f12227a.m6370a(6)) {
                Log.e("FirebaseCrashlytics", "Crashlytics timed out during initialization.", e3);
            }
        }
    }

    /* renamed from: c */
    public void m6441c() {
        this.f12341m.m6437b(new b());
    }

    /* renamed from: d */
    public void m6442d(@Nullable Boolean bool) {
        Boolean boolM6449a;
        DataCollectionArbiter dataCollectionArbiter = this.f12331c;
        synchronized (dataCollectionArbiter) {
            if (bool != null) {
                try {
                    dataCollectionArbiter.f12376f = false;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (bool != null) {
                boolM6449a = bool;
            } else {
                FirebaseApp2 firebaseApp2 = dataCollectionArbiter.f12372b;
                firebaseApp2.m6330a();
                boolM6449a = dataCollectionArbiter.m6449a(firebaseApp2.f12118d);
            }
            dataCollectionArbiter.f12377g = boolM6449a;
            SharedPreferences.Editor editorEdit = dataCollectionArbiter.f12371a.edit();
            if (bool != null) {
                editorEdit.putBoolean("firebase_crashlytics_collection_enabled", bool.booleanValue());
            } else {
                editorEdit.remove("firebase_crashlytics_collection_enabled");
            }
            editorEdit.commit();
            synchronized (dataCollectionArbiter.f12373c) {
                if (dataCollectionArbiter.m6450b()) {
                    if (!dataCollectionArbiter.f12375e) {
                        dataCollectionArbiter.f12374d.m9126b(null);
                        dataCollectionArbiter.f12375e = true;
                    }
                } else if (dataCollectionArbiter.f12375e) {
                    dataCollectionArbiter.f12374d = new TaskCompletionSource<>();
                    dataCollectionArbiter.f12375e = false;
                }
            }
        }
    }

    /* renamed from: e */
    public void m6443e(String str, String str2) {
        C4663x c4663x = this.f12336h;
        Objects.requireNonNull(c4663x);
        try {
            c4663x.f12432l.m6405c(str, str2);
            c4663x.f12433m.m6437b(new CallableC4649q(c4663x, c4663x.f12432l.m6404a()));
        } catch (IllegalArgumentException e) {
            Context context = c4663x.f12429i;
            if (context != null) {
                if ((context.getApplicationInfo().flags & 2) != 0) {
                    throw e;
                }
            }
            Logger3.f12227a.m6373d("Attempting to set custom attribute with null key, ignoring.");
        }
    }
}
