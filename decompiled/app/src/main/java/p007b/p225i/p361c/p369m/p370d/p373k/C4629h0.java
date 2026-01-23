package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import androidx.annotation.NonNull;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p361c.p369m.p370d.p380q.ReportUploader;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.CompositeCreateReportSpiCall;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.DefaultCreateReportSpiCall;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.NativeCreateReportSpiCall;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* JADX INFO: renamed from: b.i.c.m.d.k.h0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4629h0 implements ReportUploader.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4663x f12312a;

    public C4629h0(C4663x c4663x) {
        this.f12312a = c4663x;
    }

    /* JADX INFO: renamed from: a */
    public ReportUploader m6431a(@NonNull AppSettingsData appSettingsData) {
        String str = appSettingsData.f12751c;
        String str2 = appSettingsData.f12752d;
        String str3 = appSettingsData.f12753e;
        C4663x c4663x = this.f12312a;
        Context context = c4663x.f12429i;
        int iM6420n = CommonUtils.m6420n(context, "com.crashlytics.ApiEndpoint", "string");
        String string = iM6420n > 0 ? context.getString(iM6420n) : "";
        CompositeCreateReportSpiCall compositeCreateReportSpiCall = new CompositeCreateReportSpiCall(new DefaultCreateReportSpiCall(string, str, c4663x.f12434n, "17.3.0"), new NativeCreateReportSpiCall(string, str2, c4663x.f12434n, "17.3.0"));
        String str4 = this.f12312a.f12437q.f12259a;
        int iM763m = C1563b.m763m(appSettingsData);
        C4663x c4663x2 = this.f12312a;
        return new ReportUploader(str3, str4, iM763m, c4663x2.f12441u, compositeCreateReportSpiCall, c4663x2.f12442v);
    }
}
