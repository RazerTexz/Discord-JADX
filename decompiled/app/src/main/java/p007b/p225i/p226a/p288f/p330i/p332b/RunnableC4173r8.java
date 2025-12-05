package p007b.p225i.p226a.p288f.p330i.p332b;

import android.app.job.JobParameters;
import java.util.Objects;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* renamed from: b.i.a.f.i.b.r8 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC4173r8 implements Runnable {

    /* renamed from: j */
    public final C4151p8 f11186j;

    /* renamed from: k */
    public final C4157q3 f11187k;

    /* renamed from: l */
    public final JobParameters f11188l;

    public RunnableC4173r8(C4151p8 c4151p8, C4157q3 c4157q3, JobParameters jobParameters) {
        this.f11186j = c4151p8;
        this.f11187k = c4157q3;
        this.f11188l = jobParameters;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C4151p8 c4151p8 = this.f11186j;
        C4157q3 c4157q3 = this.f11187k;
        JobParameters jobParameters = this.f11188l;
        Objects.requireNonNull(c4151p8);
        c4157q3.f11149n.m5860a("AppMeasurementJobService processed last upload request.");
        c4151p8.f11131a.mo5868a(jobParameters, false);
    }
}
