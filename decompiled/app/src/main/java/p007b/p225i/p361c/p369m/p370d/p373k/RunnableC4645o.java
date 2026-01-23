package p007b.p225i.p361c.p369m.p370d.p373k;

import android.util.Log;
import java.util.Date;
import java.util.Objects;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p361c.p369m.p370d.Logger3;
import p007b.p225i.p361c.p369m.p370d.p379p.ClsFileOutputStream;
import p007b.p225i.p361c.p369m.p370d.p379p.CodedOutputStream2;

/* JADX INFO: renamed from: b.i.c.m.d.k.o */
/* JADX INFO: compiled from: CrashlyticsController.java */
/* JADX INFO: loaded from: classes3.dex */
public class RunnableC4645o implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Date f12359j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Throwable f12360k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Thread f12361l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4663x f12362m;

    public RunnableC4645o(C4663x c4663x, Date date, Throwable th, Thread thread) {
        this.f12362m = c4663x;
        this.f12359j = date;
        this.f12360k = th;
        this.f12361l = thread;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // java.lang.Runnable
    public void run() throws Throwable {
        String str;
        ClsFileOutputStream clsFileOutputStream;
        ClsFileOutputStream clsFileOutputStream2;
        int i;
        CodedOutputStream2 codedOutputStream2M6646i;
        ClsFileOutputStream clsFileOutputStream3;
        int i2;
        if (this.f12362m.m6479p()) {
            return;
        }
        long time = this.f12359j.getTime() / 1000;
        String strM6474i = this.f12362m.m6474i();
        if (strM6474i == null) {
            Logger3.f12227a.m6371b("Tried to write a non-fatal exception while no session was open.");
            return;
        }
        SessionReportingCoordinator3 sessionReportingCoordinator3 = this.f12362m.f12422A;
        Throwable th = this.f12360k;
        Thread thread = this.f12361l;
        String strReplaceAll = strM6474i.replaceAll("-", "");
        Objects.requireNonNull(sessionReportingCoordinator3);
        Logger3 logger3 = Logger3.f12227a;
        outline.m868o0("Persisting non-fatal event for session ", strReplaceAll, logger3);
        sessionReportingCoordinator3.m6399a(th, thread, strReplaceAll, "error", time, false);
        C4663x c4663x = this.f12362m;
        Thread thread2 = this.f12361l;
        Throwable th2 = this.f12360k;
        Objects.requireNonNull(c4663x);
        CodedOutputStream2 codedOutputStream2 = null;
        try {
            logger3.m6371b("Crashlytics is logging non-fatal exception \"" + th2 + "\" from thread " + thread2.getName());
            ClsFileOutputStream clsFileOutputStream4 = new ClsFileOutputStream(c4663x.m6476l(), strM6474i + "SessionEvent" + CommonUtils.m6428v(c4663x.f12428h.getAndIncrement()));
            try {
                codedOutputStream2M6646i = CodedOutputStream2.m6646i(clsFileOutputStream4);
                i2 = 6;
                clsFileOutputStream2 = clsFileOutputStream4;
                str = "Failed to flush to non-fatal file.";
            } catch (Exception e) {
                e = e;
                clsFileOutputStream2 = clsFileOutputStream4;
                str = "Failed to flush to non-fatal file.";
                i2 = 6;
            } catch (Throwable th3) {
                th = th3;
                clsFileOutputStream2 = clsFileOutputStream4;
                str = "Failed to flush to non-fatal file.";
                codedOutputStream2M6646i = codedOutputStream2;
                clsFileOutputStream = clsFileOutputStream2;
                codedOutputStream2 = codedOutputStream2M6646i;
                CommonUtils.m6414h(codedOutputStream2, str);
                CommonUtils.m6409c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Exception e2) {
            e = e2;
            str = "Failed to flush to non-fatal file.";
            clsFileOutputStream2 = null;
            i = 6;
        } catch (Throwable th4) {
            th = th4;
            str = "Failed to flush to non-fatal file.";
            clsFileOutputStream = null;
            CommonUtils.m6414h(codedOutputStream2, str);
            CommonUtils.m6409c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw th;
        }
        try {
            c4663x.m6485y(codedOutputStream2M6646i, thread2, th2, time, "error", false);
            clsFileOutputStream3 = clsFileOutputStream2;
            codedOutputStream2 = codedOutputStream2M6646i;
            i = 6;
        } catch (Exception e3) {
            e = e3;
            codedOutputStream2 = codedOutputStream2M6646i;
            i = i2;
            try {
                if (Logger3.f12227a.m6370a(i)) {
                    Log.e("FirebaseCrashlytics", "An error occurred in the non-fatal exception logger", e);
                }
                clsFileOutputStream3 = clsFileOutputStream2;
            } catch (Throwable th5) {
                th = th5;
                codedOutputStream2M6646i = codedOutputStream2;
                clsFileOutputStream = clsFileOutputStream2;
                codedOutputStream2 = codedOutputStream2M6646i;
                CommonUtils.m6414h(codedOutputStream2, str);
                CommonUtils.m6409c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            clsFileOutputStream = clsFileOutputStream2;
            codedOutputStream2 = codedOutputStream2M6646i;
            CommonUtils.m6414h(codedOutputStream2, str);
            CommonUtils.m6409c(clsFileOutputStream, "Failed to close non-fatal file output stream.");
            throw th;
        }
        CommonUtils.m6414h(codedOutputStream2, str);
        CommonUtils.m6409c(clsFileOutputStream3, "Failed to close non-fatal file output stream.");
        try {
            c4663x.m6483v(strM6474i, 64);
        } catch (Exception e4) {
            if (Logger3.f12227a.m6370a(i)) {
                Log.e("FirebaseCrashlytics", "An error occurred when trimming non-fatal files.", e4);
            }
        }
    }
}
