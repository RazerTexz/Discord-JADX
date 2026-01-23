package p007b.p225i.p361c.p369m.p370d.p383r;

import com.google.android.gms.tasks.TaskCompletionSource;
import p007b.p225i.p226a.p228b.TransportScheduleCallback;
import p007b.p225i.p361c.p369m.p370d.p373k.CrashlyticsReportWithSessionId;
import p007b.p225i.p361c.p369m.p370d.p375m.p376x.CrashlyticsReportJsonTransform8;

/* JADX INFO: renamed from: b.i.c.m.d.r.a, reason: use source file name */
/* JADX INFO: compiled from: DataTransportCrashlyticsReportSender.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class DataTransportCrashlyticsReportSender implements TransportScheduleCallback {

    /* JADX INFO: renamed from: a */
    public final TaskCompletionSource f12720a;

    /* JADX INFO: renamed from: b */
    public final CrashlyticsReportWithSessionId f12721b;

    public DataTransportCrashlyticsReportSender(TaskCompletionSource taskCompletionSource, CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        this.f12720a = taskCompletionSource;
        this.f12721b = crashlyticsReportWithSessionId;
    }

    @Override // p007b.p225i.p226a.p228b.TransportScheduleCallback
    /* JADX INFO: renamed from: a */
    public void mo2292a(Exception exc) {
        TaskCompletionSource taskCompletionSource = this.f12720a;
        CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = this.f12721b;
        CrashlyticsReportJsonTransform8 crashlyticsReportJsonTransform8 = DataTransportCrashlyticsReportSender3.f12723a;
        if (exc != null) {
            taskCompletionSource.m9125a(exc);
        } else {
            taskCompletionSource.m9126b(crashlyticsReportWithSessionId);
        }
    }
}
