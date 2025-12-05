package p007b.p225i.p226a.p288f.p298d;

import android.util.Log;
import com.google.android.gms.cloudmessaging.zzp;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.m */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3238m implements Runnable {

    /* renamed from: j */
    public final ServiceConnectionC3232g f9274j;

    /* renamed from: k */
    public final AbstractC3242q f9275k;

    public RunnableC3238m(ServiceConnectionC3232g serviceConnectionC3232g, AbstractC3242q abstractC3242q) {
        this.f9274j = serviceConnectionC3232g;
        this.f9275k = abstractC3242q;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ServiceConnectionC3232g serviceConnectionC3232g = this.f9274j;
        int i = this.f9275k.f9279a;
        synchronized (serviceConnectionC3232g) {
            AbstractC3242q<?> abstractC3242q = serviceConnectionC3232g.f9267n.get(i);
            if (abstractC3242q != null) {
                StringBuilder sb = new StringBuilder(31);
                sb.append("Timing out request: ");
                sb.append(i);
                Log.w("MessengerIpcClient", sb.toString());
                serviceConnectionC3232g.f9267n.remove(i);
                abstractC3242q.m4008b(new zzp(3, "Timed out waiting for response"));
                serviceConnectionC3232g.m4005c();
            }
        }
    }
}
