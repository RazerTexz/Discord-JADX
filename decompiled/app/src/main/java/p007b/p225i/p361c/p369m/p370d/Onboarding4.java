package p007b.p225i.p361c.p369m.p370d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.Objects;
import java.util.concurrent.Executor;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p369m.p370d.p373k.CommonUtils;
import p007b.p225i.p361c.p369m.p370d.p373k.DataCollectionArbiter;
import p007b.p225i.p361c.p369m.p370d.p373k.DeliveryMechanism;
import p007b.p225i.p361c.p369m.p370d.p373k.IdManager;
import p007b.p225i.p361c.p369m.p370d.p377n.HttpRequestFactory;
import p007b.p225i.p361c.p369m.p370d.p384s.SettingsController;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppRequestData;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.CreateAppSpiCall;
import p007b.p225i.p361c.p369m.p370d.p384s.p386i.UpdateAppSpiCall;

/* JADX INFO: renamed from: b.i.c.m.d.h, reason: use source file name */
/* JADX INFO: compiled from: Onboarding.java */
/* JADX INFO: loaded from: classes3.dex */
public class Onboarding4 {

    /* JADX INFO: renamed from: a */
    public final HttpRequestFactory f12234a = new HttpRequestFactory();

    /* JADX INFO: renamed from: b */
    public final FirebaseApp2 f12235b;

    /* JADX INFO: renamed from: c */
    public final Context f12236c;

    /* JADX INFO: renamed from: d */
    public PackageManager f12237d;

    /* JADX INFO: renamed from: e */
    public String f12238e;

    /* JADX INFO: renamed from: f */
    public PackageInfo f12239f;

    /* JADX INFO: renamed from: g */
    public String f12240g;

    /* JADX INFO: renamed from: h */
    public String f12241h;

    /* JADX INFO: renamed from: i */
    public String f12242i;

    /* JADX INFO: renamed from: j */
    public String f12243j;

    /* JADX INFO: renamed from: k */
    public String f12244k;

    /* JADX INFO: renamed from: l */
    public IdManager f12245l;

    /* JADX INFO: renamed from: m */
    public DataCollectionArbiter f12246m;

    public Onboarding4(FirebaseApp2 firebaseApp2, Context context, IdManager idManager, DataCollectionArbiter dataCollectionArbiter) {
        this.f12235b = firebaseApp2;
        this.f12236c = context;
        this.f12245l = idManager;
        this.f12246m = dataCollectionArbiter;
    }

    /* JADX INFO: renamed from: a */
    public static void m6383a(Onboarding4 onboarding4, AppSettingsData appSettingsData, String str, SettingsController settingsController, Executor executor, boolean z2) throws Throwable {
        Objects.requireNonNull(onboarding4);
        if ("new".equals(appSettingsData.f12749a)) {
            if (new CreateAppSpiCall(onboarding4.m6385c(), appSettingsData.f12750b, onboarding4.f12234a, "17.3.0").m6691d(onboarding4.m6384b(appSettingsData.f12753e, str), z2)) {
                settingsController.m6686d(2, executor);
                return;
            } else {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "Failed to create app with Crashlytics service.", null);
                    return;
                }
                return;
            }
        }
        if ("configured".equals(appSettingsData.f12749a)) {
            settingsController.m6686d(2, executor);
        } else if (appSettingsData.f12754f) {
            Logger3.f12227a.m6371b("Server says an update is required - forcing a full App update.");
            new UpdateAppSpiCall(onboarding4.m6385c(), appSettingsData.f12750b, onboarding4.f12234a, "17.3.0").m6691d(onboarding4.m6384b(appSettingsData.f12753e, str), z2);
        }
    }

    /* JADX INFO: renamed from: b */
    public final AppRequestData m6384b(String str, String str2) {
        return new AppRequestData(str, str2, this.f12245l.f12411e, this.f12241h, this.f12240g, CommonUtils.m6412f(CommonUtils.m6418l(this.f12236c), str2, this.f12241h, this.f12240g), this.f12243j, DeliveryMechanism.m6452f(this.f12242i).m6453g(), this.f12244k, "0");
    }

    /* JADX INFO: renamed from: c */
    public String m6385c() {
        Context context = this.f12236c;
        int iM6420n = CommonUtils.m6420n(context, "com.crashlytics.ApiEndpoint", "string");
        return iM6420n > 0 ? context.getString(iM6420n) : "";
    }
}
