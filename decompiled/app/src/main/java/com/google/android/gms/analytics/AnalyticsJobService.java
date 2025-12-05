package com.google.android.gms.analytics;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import androidx.annotation.RequiresPermission;
import p007b.p225i.p226a.p288f.p313h.p323j.C3515g;
import p007b.p225i.p226a.p288f.p313h.p323j.C3529m0;
import p007b.p225i.p226a.p288f.p313h.p323j.C3543t0;
import p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0;
import p007b.p225i.p226a.p288f.p313h.p323j.RunnableC3547v0;

@TargetApi(24)
/* loaded from: classes3.dex */
public final class AnalyticsJobService extends JobService implements InterfaceC3551x0 {

    /* renamed from: j */
    public C3543t0<AnalyticsJobService> f20386j;

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0
    @TargetApi(24)
    /* renamed from: a */
    public final void mo4503a(JobParameters jobParameters, boolean z2) {
        jobFinished(jobParameters, false);
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p323j.InterfaceC3551x0
    /* renamed from: b */
    public final boolean mo4504b(int i) {
        return stopSelfResult(i);
    }

    /* renamed from: c */
    public final C3543t0<AnalyticsJobService> m9007c() {
        if (this.f20386j == null) {
            this.f20386j = new C3543t0<>(this);
        }
        return this.f20386j;
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onCreate() {
        super.onCreate();
        C3515g.m4450b(m9007c().f9802c).m4451c().m4427C("Local AnalyticsService is starting up");
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final void onDestroy() {
        C3515g.m4450b(m9007c().f9802c).m4451c().m4427C("Local AnalyticsService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @RequiresPermission(allOf = {"android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE"})
    public final int onStartCommand(Intent intent, int i, int i2) {
        m9007c().m4501a(intent, i2);
        return 2;
    }

    @Override // android.app.job.JobService
    public final boolean onStartJob(JobParameters jobParameters) {
        C3543t0<AnalyticsJobService> c3543t0M9007c = m9007c();
        C3529m0 c3529m0M4451c = C3515g.m4450b(c3543t0M9007c.f9802c).m4451c();
        String string = jobParameters.getExtras().getString("action");
        c3529m0M4451c.m4431b("Local AnalyticsJobService called. action", string);
        if (!"com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(string)) {
            return true;
        }
        c3543t0M9007c.m4502b(new RunnableC3547v0(c3543t0M9007c, c3529m0M4451c, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public final boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
