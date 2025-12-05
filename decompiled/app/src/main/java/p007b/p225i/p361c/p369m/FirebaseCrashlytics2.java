package p007b.p225i.p361c.p369m;

import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.FilenameFilter;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p369m.p370d.Onboarding;
import p007b.p225i.p361c.p369m.p370d.Onboarding2;
import p007b.p225i.p361c.p369m.p370d.Onboarding4;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsCore2;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsCore3;
import p007b.p225i.p361c.p369m.p370d.p373k.Utils3;
import p007b.p225i.p361c.p369m.p370d.p373k.Utils5;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;

/* compiled from: FirebaseCrashlytics.java */
/* renamed from: b.i.c.m.c, reason: use source file name */
/* loaded from: classes3.dex */
public class FirebaseCrashlytics2 implements Callable<Void> {

    /* renamed from: j */
    public final /* synthetic */ Onboarding4 f12222j;

    /* renamed from: k */
    public final /* synthetic */ ExecutorService f12223k;

    /* renamed from: l */
    public final /* synthetic */ SettingsController f12224l;

    /* renamed from: m */
    public final /* synthetic */ boolean f12225m;

    /* renamed from: n */
    public final /* synthetic */ CrashlyticsCore3 f12226n;

    public FirebaseCrashlytics2(Onboarding4 onboarding4, ExecutorService executorService, SettingsController settingsController, boolean z2, CrashlyticsCore3 crashlyticsCore3) {
        this.f12222j = onboarding4;
        this.f12223k = executorService;
        this.f12224l = settingsController;
        this.f12225m = z2;
        this.f12226n = crashlyticsCore3;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        Onboarding4 onboarding4 = this.f12222j;
        ExecutorService executorService = this.f12223k;
        SettingsController settingsController = this.f12224l;
        FirebaseApp2 firebaseApp2 = onboarding4.f12235b;
        firebaseApp2.m6330a();
        onboarding4.f12246m.m6451c().mo6023r(executorService, new Onboarding2(onboarding4, settingsController)).mo6023r(executorService, new Onboarding(onboarding4, firebaseApp2.f12120f.f12135b, settingsController, executorService));
        if (!this.f12225m) {
            return null;
        }
        CrashlyticsCore3 crashlyticsCore3 = this.f12226n;
        SettingsController settingsController2 = this.f12224l;
        ExecutorService executorService2 = crashlyticsCore3.f12340l;
        CrashlyticsCore2 crashlyticsCore2 = new CrashlyticsCore2(crashlyticsCore3, settingsController2);
        FilenameFilter filenameFilter = Utils3.f12313a;
        executorService2.execute(new Utils5(crashlyticsCore2, new TaskCompletionSource()));
        return null;
    }
}
