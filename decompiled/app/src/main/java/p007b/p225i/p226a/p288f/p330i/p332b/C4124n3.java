package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.os.EnvironmentCompat;
import com.google.android.gms.common.C10800R;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3295h;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p313h.p325l.C3630da;
import p007b.p225i.p226a.p288f.p313h.p325l.C3701ib;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3741lb;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.n3 */
/* loaded from: classes3.dex */
public final class C4124n3 extends AbstractC3974a5 {

    /* renamed from: c */
    public String f10979c;

    /* renamed from: d */
    public String f10980d;

    /* renamed from: e */
    public int f10981e;

    /* renamed from: f */
    public String f10982f;

    /* renamed from: g */
    public long f10983g;

    /* renamed from: h */
    public long f10984h;

    /* renamed from: i */
    public List<String> f10985i;

    /* renamed from: j */
    public int f10986j;

    /* renamed from: k */
    public String f10987k;

    /* renamed from: l */
    public String f10988l;

    /* renamed from: m */
    public String f10989m;

    public C4124n3(C4202u4 c4202u4, long j) {
        super(c4202u4);
        this.f10984h = j;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC3974a5
    /* renamed from: v */
    public final boolean mo5499v() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x02c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0188  */
    /* renamed from: w */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m5760w() throws Resources.NotFoundException {
        Status status;
        boolean z2;
        Integer numValueOf;
        String installerPackageName = EnvironmentCompat.MEDIA_UNKNOWN;
        String str = "Unknown";
        String packageName = this.f11202a.f11254b.getPackageName();
        PackageManager packageManager = this.f11202a.f11254b.getPackageManager();
        int i = Integer.MIN_VALUE;
        if (packageManager == null) {
            mo5726g().f11141f.m5861b("PackageManager is null, app identity information might be inaccurate. appId", C4157q3.m5788s(packageName));
        } else {
            try {
                installerPackageName = packageManager.getInstallerPackageName(packageName);
            } catch (IllegalArgumentException unused) {
                mo5726g().f11141f.m5861b("Error retrieving app installer package name. appId", C4157q3.m5788s(packageName));
            }
            if (installerPackageName == null) {
                installerPackageName = "manual_install";
            } else if ("com.android.vending".equals(installerPackageName)) {
                installerPackageName = "";
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(this.f11202a.f11254b.getPackageName(), 0);
                if (packageInfo != null) {
                    CharSequence applicationLabel = packageManager.getApplicationLabel(packageInfo.applicationInfo);
                    if (!TextUtils.isEmpty(applicationLabel)) {
                        applicationLabel.toString();
                    }
                    str = packageInfo.versionName;
                    i = packageInfo.versionCode;
                }
            } catch (PackageManager.NameNotFoundException unused2) {
                mo5726g().f11141f.m5862c("Error retrieving package info. appId, appName", C4157q3.m5788s(packageName), "Unknown");
            }
        }
        this.f10979c = packageName;
        this.f10982f = installerPackageName;
        this.f10980d = str;
        this.f10981e = i;
        this.f10983g = 0L;
        Context context = this.f11202a.f11254b;
        Object obj = C3295h.f9421a;
        AnimatableValueParser.m595z(context, "Context must not be null.");
        synchronized (C3295h.f9421a) {
            if (C3295h.f9422b == null) {
                C3295h.f9422b = new C3295h(context);
            }
            status = C3295h.f9422b.f9424d;
        }
        boolean z3 = true;
        boolean z4 = status != null && status.m9030w0();
        boolean z5 = !TextUtils.isEmpty(this.f11202a.f11255c) && "am".equals(this.f11202a.f11256d);
        boolean z6 = z4 | z5;
        if (!z6) {
            if (status == null) {
                mo5726g().f11142g.m5860a("GoogleService failed to initialize (no status)");
            } else {
                mo5726g().f11142g.m5862c("GoogleService failed to initialize, status", Integer.valueOf(status.f20495p), status.f20496q);
            }
        }
        if (z6) {
            int iM5941e = this.f11202a.m5941e();
            switch (iM5941e) {
                case 0:
                    mo5726g().f11149n.m5860a("App measurement collection enabled");
                    break;
                case 1:
                    mo5726g().f11147l.m5860a("App measurement deactivated via the manifest");
                    break;
                case 2:
                    mo5726g().f11149n.m5860a("App measurement deactivated via the init parameters");
                    break;
                case 3:
                    mo5726g().f11147l.m5860a("App measurement disabled by setAnalyticsCollectionEnabled(false)");
                    break;
                case 4:
                    mo5726g().f11147l.m5860a("App measurement disabled via the manifest");
                    break;
                case 5:
                    mo5726g().f11149n.m5860a("App measurement disabled via the init parameters");
                    break;
                case 6:
                    mo5726g().f11146k.m5860a("App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics");
                    break;
                case 7:
                    mo5726g().f11147l.m5860a("App measurement disabled via the global data collection setting");
                    break;
                case 8:
                    mo5726g().f11147l.m5860a("App measurement disabled due to denied storage consent");
                    break;
                default:
                    mo5726g().f11147l.m5860a("App measurement disabled");
                    mo5726g().f11142g.m5860a("Invalid scion state in identity");
                    break;
            }
            z2 = iM5941e == 0;
        }
        this.f10987k = "";
        this.f10988l = "";
        this.f10989m = "";
        if (z5) {
            this.f10988l = this.f11202a.f11255c;
        }
        List<String> listAsList = null;
        try {
            String strM4254V1 = (((InterfaceC3741lb) C3701ib.f10013j.mo4555a()).mo5029a() && this.f11202a.f11260h.m5526o(C4142p.f11025C0)) ? C3404f.m4254V1(this.f11202a.f11254b, "google_app_id") : C3295h.m4105a("getGoogleAppId").f9423c;
            this.f10987k = TextUtils.isEmpty(strM4254V1) ? "" : strM4254V1;
            if (C3630da.m4644b() && this.f11202a.f11260h.m5526o(C4142p.f11080j0)) {
                Context context2 = this.f11202a.f11254b;
                Objects.requireNonNull(context2, "null reference");
                Resources resources = context2.getResources();
                String resourcePackageName = resources.getResourcePackageName(C10800R.a.common_google_play_services_unknown_issue);
                int identifier = resources.getIdentifier("ga_app_id", "string", resourcePackageName);
                String string = identifier == 0 ? null : resources.getString(identifier);
                this.f10989m = TextUtils.isEmpty(string) ? "" : string;
                if (!TextUtils.isEmpty(strM4254V1) || !TextUtils.isEmpty(string)) {
                    int identifier2 = resources.getIdentifier("admob_app_id", "string", resourcePackageName);
                    this.f10988l = identifier2 == 0 ? null : resources.getString(identifier2);
                }
            } else if (!TextUtils.isEmpty(strM4254V1)) {
                Context context3 = this.f11202a.f11254b;
                Objects.requireNonNull(context3, "null reference");
                Resources resources2 = context3.getResources();
                int identifier3 = resources2.getIdentifier("admob_app_id", "string", resources2.getResourcePackageName(C10800R.a.common_google_play_services_unknown_issue));
                this.f10988l = identifier3 == 0 ? null : resources2.getString(identifier3);
            }
            if (z2) {
                mo5726g().f11149n.m5862c("App measurement enabled for app package, google app id", this.f10979c, TextUtils.isEmpty(this.f10987k) ? this.f10988l : this.f10987k);
            }
        } catch (IllegalStateException e) {
            mo5726g().f11141f.m5862c("Fetching Google App Id failed with exception. appId", C4157q3.m5788s(packageName), e);
        }
        this.f10985i = null;
        C3992c c3992c = this.f11202a.f11260h;
        Objects.requireNonNull(c3992c);
        AnimatableValueParser.m583w("analytics.safelisted_events");
        Bundle bundleM5522D = c3992c.m5522D();
        if (bundleM5522D != null) {
            if (bundleM5522D.containsKey("analytics.safelisted_events")) {
                numValueOf = Integer.valueOf(bundleM5522D.getInt("analytics.safelisted_events"));
            }
            if (numValueOf != null) {
                try {
                    String[] stringArray = c3992c.f11202a.f11254b.getResources().getStringArray(numValueOf.intValue());
                    if (stringArray != null) {
                        listAsList = Arrays.asList(stringArray);
                    }
                } catch (Resources.NotFoundException e2) {
                    c3992c.mo5726g().f11141f.m5861b("Failed to load string array from metadata: resource not found", e2);
                }
            }
            if (listAsList != null) {
                if (listAsList.size() == 0) {
                    mo5726g().f11146k.m5860a("Safelisted event list is empty. Ignoring");
                } else {
                    Iterator<String> it = listAsList.iterator();
                    while (it.hasNext()) {
                        if (!m5866e().m5915m0("safelisted event", it.next())) {
                        }
                    }
                }
                z3 = false;
            }
            if (z3) {
                this.f10985i = listAsList;
            }
            if (packageManager == null) {
                this.f10986j = C3404f.m4202E0(this.f11202a.f11254b) ? 1 : 0;
                return;
            } else {
                this.f10986j = 0;
                return;
            }
        }
        c3992c.mo5726g().f11141f.m5860a("Failed to load metadata: Metadata bundle is null");
        numValueOf = null;
        if (numValueOf != null) {
        }
        if (listAsList != null) {
        }
        if (z3) {
        }
        if (packageManager == null) {
        }
    }
}
