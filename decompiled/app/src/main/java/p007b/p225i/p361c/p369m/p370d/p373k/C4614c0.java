package p007b.p225i.p361c.p369m.p370d.p373k;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.Executor;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4362f;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p380q.ReportUploader;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.SessionReport;
import p007b.p225i.p361c.p369m.p370d.p384s.p385h.AppSettingsData;

/* compiled from: CrashlyticsController.java */
/* renamed from: b.i.c.m.d.k.c0 */
/* loaded from: classes3.dex */
public class C4614c0 implements InterfaceC4362f<AppSettingsData, Void> {

    /* renamed from: a */
    public final /* synthetic */ Executor f12270a;

    /* renamed from: b */
    public final /* synthetic */ CallableC4617d0 f12271b;

    public C4614c0(CallableC4617d0 callableC4617d0, Executor executor) {
        this.f12271b = callableC4617d0;
        this.f12270a = executor;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4362f
    @NonNull
    /* renamed from: a */
    public Task<Void> mo4013a(@Nullable AppSettingsData appSettingsData) throws Exception {
        AppSettingsData appSettingsData2 = appSettingsData;
        if (appSettingsData2 == null) {
            Logger3.f12227a.m6376g("Received null app settings, cannot send reports at crash time.");
            return C3404f.m4264Z(null);
        }
        C4663x c4663x = this.f12271b.f12277n;
        Context context = c4663x.f12429i;
        ReportUploader reportUploaderM6431a = ((C4629h0) c4663x.f12438r).m6431a(appSettingsData2);
        for (File file : c4663x.m6480q()) {
            C4663x.m6463c(appSettingsData2.f12753e, file);
            SessionReport sessionReport = new SessionReport(file, C4663x.f12420f);
            CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = c4663x.f12433m;
            crashlyticsBackgroundWorker.m6437b(new CrashlyticsBackgroundWorker2(crashlyticsBackgroundWorker, new C4663x.m(context, sessionReport, reportUploaderM6431a, true)));
        }
        return C3404f.m4194B1(Arrays.asList(C4663x.m6462b(this.f12271b.f12277n), this.f12271b.f12277n.f12422A.m6400b(this.f12270a, C1563b.m763m(appSettingsData2))));
    }
}
