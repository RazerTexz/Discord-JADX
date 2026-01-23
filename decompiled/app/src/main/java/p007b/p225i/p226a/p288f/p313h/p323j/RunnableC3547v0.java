package p007b.p225i.p226a.p288f.p313h.p323j;

import android.app.job.JobParameters;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.f.h.j.v0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3547v0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final C3543t0 f9808j;

    /* JADX INFO: renamed from: k */
    public final C3529m0 f9809k;

    /* JADX INFO: renamed from: l */
    public final JobParameters f9810l;

    public RunnableC3547v0(C3543t0 c3543t0, C3529m0 c3529m0, JobParameters jobParameters) {
        this.f9808j = c3543t0;
        this.f9809k = c3529m0;
        this.f9810l = jobParameters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3543t0 c3543t0 = this.f9808j;
        C3529m0 c3529m0 = this.f9809k;
        JobParameters jobParameters = this.f9810l;
        Objects.requireNonNull(c3543t0);
        c3529m0.m4427C("AnalyticsJobService processed last dispatch request");
        c3543t0.f9802c.mo4503a(jobParameters, false);
    }
}
