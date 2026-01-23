package p007b.p225i.p361c.p398s;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p226a.p288f.p340n.C4358c0;
import p007b.p225i.p226a.p288f.p340n.C4374r;
import p007b.p225i.p361c.p398s.ServiceConnectionC4812d0;

/* JADX INFO: renamed from: b.i.c.s.f */
/* JADX INFO: compiled from: com.google.firebase:firebase-iid@@21.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public class C4815f {

    /* JADX INFO: renamed from: a */
    public static final Object f12861a = new Object();

    /* JADX INFO: renamed from: b */
    public static ServiceConnectionC4812d0 f12862b;

    /* JADX INFO: renamed from: c */
    public final Context f12863c;

    /* JADX INFO: renamed from: d */
    public final Executor f12864d;

    public C4815f(Context context) {
        this.f12863c = context;
        this.f12864d = ExecutorC4805a.f12843j;
    }

    /* JADX INFO: renamed from: a */
    public static Task<Integer> m6724a(Context context, Intent intent) {
        ServiceConnectionC4812d0 serviceConnectionC4812d0;
        C4358c0<Void> c4358c0;
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Binding to service");
        }
        synchronized (f12861a) {
            if (f12862b == null) {
                f12862b = new ServiceConnectionC4812d0(context, "com.google.firebase.MESSAGING_EVENT");
            }
            serviceConnectionC4812d0 = f12862b;
        }
        synchronized (serviceConnectionC4812d0) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
            }
            ServiceConnectionC4812d0.a aVar = new ServiceConnectionC4812d0.a(intent);
            ScheduledExecutorService scheduledExecutorService = serviceConnectionC4812d0.f12854l;
            ScheduledFuture<?> scheduledFutureSchedule = scheduledExecutorService.schedule(new RunnableC4808b0(aVar), 9000L, TimeUnit.MILLISECONDS);
            C4358c0<Void> c4358c02 = aVar.f12859b.f20845a;
            c4358c02.f11472b.m6031a(new C4374r(scheduledExecutorService, new C4810c0(scheduledFutureSchedule)));
            c4358c02.m6028w();
            serviceConnectionC4812d0.f12855m.add(aVar);
            serviceConnectionC4812d0.m6721b();
            c4358c0 = aVar.f12859b.f20845a;
        }
        Executor executor = C4817h.f12866a;
        return c4358c0.mo6014i(ExecutorC4816g.f12865j, C4811d.f12851a);
    }

    /* JADX INFO: renamed from: b */
    public Task<Integer> m6725b(Intent intent) {
        String stringExtra = intent.getStringExtra("gcm.rawData64");
        if (stringExtra != null) {
            intent.putExtra("rawData", Base64.decode(stringExtra, 0));
            intent.removeExtra("gcm.rawData64");
        }
        Context context = this.f12863c;
        return (!(C3404f.m4190A0() && context.getApplicationInfo().targetSdkVersion >= 26) || ((intent.getFlags() & 268435456) != 0)) ? C3404f.m4323o(this.f12864d, new CallableC4807b(context, intent)).mo6015j(this.f12864d, new C4809c(context, intent)) : m6724a(context, intent);
    }

    public C4815f(Context context, ExecutorService executorService) {
        this.f12863c = context;
        this.f12864d = executorService;
    }
}
