package p007b.p225i.p361c.p369m.p370d.p373k;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.util.List;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p380q.ReportUploader;
import p007b.p225i.p361c.p369m.p370d.p380q.ReportUploader.d;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* JADX INFO: renamed from: b.i.c.m.d.k.f0 */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4623f0 implements InterfaceC4362f<AppSettingsData, Void> {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ List f12286a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f12287b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Executor f12288c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ CallableC4626g0 f12289d;

    public C4623f0(CallableC4626g0 callableC4626g0, List list, boolean z2, Executor executor) {
        this.f12289d = callableC4626g0;
        this.f12286a = list;
        this.f12287b = z2;
        this.f12288c = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* JADX INFO: renamed from: a */
    public Task<Void> mo4013a(@Nullable AppSettingsData appSettingsData) throws Exception {
        AppSettingsData appSettingsData2 = appSettingsData;
        if (appSettingsData2 == null) {
            Logger3.f12227a.m6376g("Received null app settings, cannot send reports during app startup.");
            return C3404f.m4264Z(null);
        }
        for (Report2 report2 : this.f12286a) {
            if (report2.mo6675d() == 1) {
                C4663x.m6463c(appSettingsData2.f12753e, report2.mo6674c());
            }
        }
        C4663x.m6462b(C4663x.this);
        ReportUploader reportUploaderM6431a = ((C4629h0) C4663x.this.f12438r).m6431a(appSettingsData2);
        List list = this.f12286a;
        boolean z2 = this.f12287b;
        float f = this.f12289d.f12295k.f12448b;
        synchronized (reportUploaderM6431a) {
            if (reportUploaderM6431a.f12704h != null) {
                Logger3.f12227a.m6371b("Report upload has already been started.");
            } else {
                Thread thread = new Thread(reportUploaderM6431a.new d(list, z2, f), "Crashlytics Report Uploader");
                reportUploaderM6431a.f12704h = thread;
                thread.start();
            }
        }
        C4663x.this.f12422A.m6400b(this.f12288c, C1563b.m763m(appSettingsData2));
        C4663x.this.f12426E.m9126b(null);
        return C3404f.m4264Z(null);
    }
}
