package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.Objects;
import p007b.p225i.p226a.p288f.p330i.p332b.BinderC4257z4;
import p007b.p225i.p226a.p288f.p330i.p332b.C4097k9;
import p007b.p225i.p226a.p288f.p330i.p332b.C4151p8;
import p007b.p225i.p226a.p288f.p330i.p332b.C4157q3;
import p007b.p225i.p226a.p288f.p330i.p332b.C4202u4;
import p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4184s8;
import p007b.p225i.p226a.p288f.p330i.p332b.RunnableC4206u8;

/* compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* loaded from: classes3.dex */
public final class AppMeasurementService extends Service implements InterfaceC4195t8 {

    /* renamed from: j */
    public C4151p8<AppMeasurementService> f20658j;

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* renamed from: a */
    public final void mo5868a(JobParameters jobParameters, boolean z2) {
        throw new UnsupportedOperationException();
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* renamed from: b */
    public final void mo5869b(Intent intent) {
        WakefulBroadcastReceiver.completeWakefulIntent(intent);
    }

    /* renamed from: c */
    public final C4151p8<AppMeasurementService> m9110c() {
        if (this.f20658j == null) {
            this.f20658j = new C4151p8<>(this);
        }
        return this.f20658j;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.InterfaceC4195t8
    /* renamed from: f */
    public final boolean mo5870f(int i) {
        return stopSelfResult(i);
    }

    @Override // android.app.Service
    @MainThread
    public final IBinder onBind(Intent intent) {
        C4151p8<AppMeasurementService> c4151p8M9110c = m9110c();
        Objects.requireNonNull(c4151p8M9110c);
        if (intent == null) {
            c4151p8M9110c.m5786b().f11141f.m5860a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new BinderC4257z4(C4097k9.m5698b(c4151p8M9110c.f11131a));
        }
        c4151p8M9110c.m5786b().f11144i.m5861b("onBind received unknown action", action);
        return null;
    }

    @Override // android.app.Service
    @MainThread
    public final void onCreate() {
        super.onCreate();
        C4202u4.m5933b(m9110c().f11131a, null, null).mo5726g().f11149n.m5860a("Local AppMeasurementService is starting up");
    }

    @Override // android.app.Service
    @MainThread
    public final void onDestroy() {
        C4202u4.m5933b(m9110c().f11131a, null, null).mo5726g().f11149n.m5860a("Local AppMeasurementService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    @MainThread
    public final void onRebind(Intent intent) {
        m9110c().m5787c(intent);
    }

    @Override // android.app.Service
    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) throws IllegalStateException {
        C4151p8<AppMeasurementService> c4151p8M9110c = m9110c();
        C4157q3 c4157q3Mo5726g = C4202u4.m5933b(c4151p8M9110c.f11131a, null, null).mo5726g();
        if (intent == null) {
            c4157q3Mo5726g.f11144i.m5860a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c4157q3Mo5726g.f11149n.m5862c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            return 2;
        }
        RunnableC4184s8 runnableC4184s8 = new RunnableC4184s8(c4151p8M9110c, i2, c4157q3Mo5726g, intent);
        C4097k9 c4097k9M5698b = C4097k9.m5698b(c4151p8M9110c.f11131a);
        c4097k9M5698b.mo5725f().m5852v(new RunnableC4206u8(c4097k9M5698b, runnableC4184s8));
        return 2;
    }

    @Override // android.app.Service
    @MainThread
    public final boolean onUnbind(Intent intent) {
        m9110c().m5785a(intent);
        return true;
    }
}
