package p007b.p225i.p226a.p288f.p298d;

/* compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* renamed from: b.i.a.f.d.i */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3234i implements Runnable {

    /* renamed from: j */
    public final ServiceConnectionC3232g f9269j;

    public RunnableC3234i(ServiceConnectionC3232g serviceConnectionC3232g) {
        this.f9269j = serviceConnectionC3232g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ServiceConnectionC3232g serviceConnectionC3232g = this.f9269j;
        synchronized (serviceConnectionC3232g) {
            if (serviceConnectionC3232g.f9263j == 1) {
                serviceConnectionC3232g.m4003a(1, "Timed out while binding");
            }
        }
    }
}
