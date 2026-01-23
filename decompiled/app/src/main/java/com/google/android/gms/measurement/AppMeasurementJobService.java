package com.google.android.gms.measurement;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.MainThread;
import p007b.p225i.p226a.p288f.p330i.p332b.C4097k9;
import p007b.p225i.p226a.p288f.p330i.p332b.C4151p8;
import p007b.p225i.p226a.p288f.p330i.p332b.C4157q3;
import p007b.p225i.p226a.p288f.p330i.p332b.C4202u4;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4173r8;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4206u8;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@TargetApi(24)
public final class AppMeasurementJobService extends JobService implements InterfaceC4195t8 {

    /* JADX INFO: renamed from: j */
    public C4151p8<AppMeasurementJobService> f20656j;

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    @TargetApi(24)
    /* JADX INFO: renamed from: a */
    public final void mo5868a(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* JADX INFO: renamed from: b */
    public final void mo5869b(Intent intent) {
    }

    /* JADX INFO: renamed from: c */
    public final C4151p8<AppMeasurementJobService> m9109c() {
        if (this.f20656j == null) {
            this.f20656j = new C4151p8<>(this);
        }
        return this.f20656j;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* JADX INFO: renamed from: f */
    public final boolean mo5870f(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        C4202u4.m5933b(m9109c().f11131a, null, null).mo5726g().f11149n.m5860a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        C4202u4.m5933b(m9109c().f11131a, null, null).mo5726g().f11149n.m5860a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        m9109c().m5787c(intent);
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        C4151p8<AppMeasurementJobService> c4151p8M9109c = m9109c();
        C4157q3 c4157q3Mo5726g = C4202u4.m5933b(c4151p8M9109c.f11131a, null, null).mo5726g();
        String string = jobParameters.getExtras().getString("action");
        c4157q3Mo5726g.f11149n.m5861b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        RunnableC4173r8 runnableC4173r8 = new RunnableC4173r8(c4151p8M9109c, c4157q3Mo5726g, jobParameters);
        C4097k9 c4097k9M5698b = C4097k9.m5698b(c4151p8M9109c.f11131a);
        c4097k9M5698b.mo5725f().m5852v(new RunnableC4206u8(c4097k9M5698b, runnableC4173r8));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        m9109c().m5785a(intent);
        return true;
    }
}
