package p007b.p225i.p226a.p288f.p298d;

import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: renamed from: b.i.a.f.d.l */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3237l implements Runnable {

    /* JADX INFO: renamed from: j */
    public final ServiceConnectionC3232g f9272j;

    /* JADX INFO: renamed from: k */
    public final IBinder f9273k;

    public RunnableC3237l(ServiceConnectionC3232g serviceConnectionC3232g, IBinder iBinder) {
        this.f9272j = serviceConnectionC3232g;
        this.f9273k = iBinder;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ServiceConnectionC3232g serviceConnectionC3232g = this.f9272j;
        IBinder iBinder = this.f9273k;
        synchronized (serviceConnectionC3232g) {
            try {
                if (iBinder == null) {
                    serviceConnectionC3232g.m4003a(0, "Null service connection");
                    return;
                }
                try {
                    serviceConnectionC3232g.f9265l = new C3241p(iBinder);
                    serviceConnectionC3232g.f9263j = 2;
                    serviceConnectionC3232g.f9268o.f9260c.execute(new RunnableC3236k(serviceConnectionC3232g));
                } catch (RemoteException e) {
                    serviceConnectionC3232g.m4003a(0, e.getMessage());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
