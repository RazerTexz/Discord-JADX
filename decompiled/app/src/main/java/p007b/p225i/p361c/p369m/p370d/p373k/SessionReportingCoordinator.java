package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p340n.InterfaceC4353a;
import p007b.p225i.p361c.p369m.p370d.Logger3;

/* JADX INFO: renamed from: b.i.c.m.d.k.b1, reason: use source file name */
/* JADX INFO: compiled from: SessionReportingCoordinator.java */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class SessionReportingCoordinator implements InterfaceC4353a {

    /* JADX INFO: renamed from: a */
    public final SessionReportingCoordinator3 f12267a;

    public SessionReportingCoordinator(SessionReportingCoordinator3 sessionReportingCoordinator3) {
        this.f12267a = sessionReportingCoordinator3;
    }

    @Override // p007b.p225i.p226a.p288f.p340n.InterfaceC4353a
    /* JADX INFO: renamed from: a */
    public Object mo4012a(Task task) {
        boolean z2;
        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.f12267a;
        Objects.requireNonNull(sessionReportingCoordinator3);
        if (task.mo6021p()) {
            CrashlyticsReportWithSessionId crashlyticsReportWithSessionId = (CrashlyticsReportWithSessionId) task.mo6017l();
            Logger3 logger3 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Crashlytics report successfully enqueued to DataTransport: ");
            sbM833U.append(crashlyticsReportWithSessionId.mo6397b());
            logger3.m6371b(sbM833U.toString());
            sessionReportingCoordinator3.f12279b.m6633c(crashlyticsReportWithSessionId.mo6397b());
            z2 = true;
        } else {
            Logger3 logger32 = Logger3.f12227a;
            Exception excMo6016k = task.mo6016k();
            if (logger32.m6370a(3)) {
                Log.d("FirebaseCrashlytics", "Crashlytics report could not be enqueued to DataTransport", excMo6016k);
            }
            z2 = false;
        }
        return Boolean.valueOf(z2);
    }
}
