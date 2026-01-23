package p007b.p225i.p361c.p369m.p370d.p380q;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p373k.BackgroundPriorityRunnable;
import p007b.p225i.p361c.p369m.p370d.p373k.C4663x;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.CreateReportRequest;
import p007b.p225i.p361c.p369m.p370d.p380q.p381c.Report2;
import p007b.p225i.p361c.p369m.p370d.p380q.p382d.CreateReportSpiCall;

/* JADX INFO: renamed from: b.i.c.m.d.q.b, reason: use source file name */
/* JADX INFO: compiled from: ReportUploader.java */
/* JADX INFO: loaded from: classes3.dex */
public class ReportUploader {

    /* JADX INFO: renamed from: a */
    public static final short[] f12697a = {10, 20, 30, 60, 120, 300};

    /* JADX INFO: renamed from: b */
    public final CreateReportSpiCall f12698b;

    /* JADX INFO: renamed from: c */
    @Nullable
    public final String f12699c;

    /* JADX INFO: renamed from: d */
    public final String f12700d;

    /* JADX INFO: renamed from: e */
    public final int f12701e;

    /* JADX INFO: renamed from: f */
    public final ReportManager f12702f;

    /* JADX INFO: renamed from: g */
    public final a f12703g;

    /* JADX INFO: renamed from: h */
    public Thread f12704h;

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$a */
    /* JADX INFO: compiled from: ReportUploader.java */
    public interface a {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$b */
    /* JADX INFO: compiled from: ReportUploader.java */
    public interface b {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$c */
    /* JADX INFO: compiled from: ReportUploader.java */
    public interface c {
    }

    /* JADX INFO: renamed from: b.i.c.m.d.q.b$d */
    /* JADX INFO: compiled from: ReportUploader.java */
    public class d extends BackgroundPriorityRunnable {

        /* JADX INFO: renamed from: j */
        public final List<Report2> f12705j;

        /* JADX INFO: renamed from: k */
        public final boolean f12706k;

        /* JADX INFO: renamed from: l */
        public final float f12707l;

        public d(List<Report2> list, boolean z2, float f) {
            this.f12705j = list;
            this.f12706k = z2;
            this.f12707l = f;
        }

        @Override // p007b.p225i.p361c.p369m.p370d.p373k.BackgroundPriorityRunnable
        /* JADX INFO: renamed from: a */
        public void mo6398a() {
            try {
                m6671b(this.f12705j, this.f12706k);
            } catch (Exception e) {
                if (Logger3.f12227a.m6370a(6)) {
                    Log.e("FirebaseCrashlytics", "An unexpected error occurred while attempting to upload crash reports.", e);
                }
            }
            ReportUploader.this.f12704h = null;
        }

        /* JADX INFO: renamed from: b */
        public final void m6671b(List<Report2> list, boolean z2) {
            Logger3 logger3 = Logger3.f12227a;
            StringBuilder sbM833U = outline.m833U("Starting report processing in ");
            sbM833U.append(this.f12707l);
            sbM833U.append(" second(s)...");
            logger3.m6371b(sbM833U.toString());
            float f = this.f12707l;
            if (f > 0.0f) {
                try {
                    Thread.sleep((long) (f * 1000.0f));
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            if (C4663x.this.m6479p()) {
                return;
            }
            int i = 0;
            while (list.size() > 0 && !C4663x.this.m6479p()) {
                Logger3 logger32 = Logger3.f12227a;
                StringBuilder sbM833U2 = outline.m833U("Attempting to send ");
                sbM833U2.append(list.size());
                sbM833U2.append(" report(s)");
                logger32.m6371b(sbM833U2.toString());
                ArrayList arrayList = new ArrayList();
                for (Report2 report2 : list) {
                    if (!ReportUploader.this.m6670a(report2, z2)) {
                        arrayList.add(report2);
                    }
                }
                if (arrayList.size() > 0) {
                    int i2 = i + 1;
                    long j = ReportUploader.f12697a[Math.min(i, r8.length - 1)];
                    Logger3.f12227a.m6371b("Report submission: scheduling delayed retry in " + j + " seconds");
                    try {
                        Thread.sleep(j * 1000);
                        i = i2;
                    } catch (InterruptedException unused2) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                list = arrayList;
            }
        }
    }

    public ReportUploader(@Nullable String str, String str2, int i, ReportManager reportManager, CreateReportSpiCall createReportSpiCall, a aVar) {
        if (createReportSpiCall == null) {
            throw new IllegalArgumentException("createReportCall must not be null.");
        }
        this.f12698b = createReportSpiCall;
        this.f12699c = str;
        this.f12700d = str2;
        this.f12701e = i;
        this.f12702f = reportManager;
        this.f12703g = aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0053 A[Catch: Exception -> 0x005c, TRY_LEAVE, TryCatch #0 {Exception -> 0x005c, blocks: (B:3:0x0001, B:6:0x0011, B:19:0x0053, B:9:0x001a, B:11:0x0020, B:13:0x0027, B:17:0x0040), top: B:25:0x0001 }] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m6670a(Report2 report2, boolean z2) {
        CreateReportRequest createReportRequest;
        int i;
        boolean zMo6678a;
        try {
            createReportRequest = new CreateReportRequest(this.f12699c, this.f12700d, report2);
            i = this.f12701e;
        } catch (Exception e) {
            Logger3.f12227a.m6374e("Error occurred sending report " + report2, e);
        }
        if (i == 3) {
            Logger3.f12227a.m6371b("Report configured to be sent via DataTransport.");
        } else {
            if (i != 2 || report2.mo6675d() != 1) {
                zMo6678a = this.f12698b.mo6678a(createReportRequest, z2);
                Logger3 logger3 = Logger3.f12227a;
                StringBuilder sb = new StringBuilder();
                sb.append("Crashlytics Reports Endpoint upload ");
                sb.append(zMo6678a ? "complete: " : "FAILED: ");
                sb.append(report2.mo6672a());
                logger3.m6375f(sb.toString());
                if (zMo6678a) {
                    Objects.requireNonNull(this.f12702f);
                    report2.remove();
                    return true;
                }
                return false;
            }
            Logger3.f12227a.m6371b("Report configured to be sent via DataTransport.");
        }
        zMo6678a = true;
        if (zMo6678a) {
        }
        return false;
    }
}
