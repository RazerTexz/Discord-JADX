package p007b.p225i.p226a.p288f.p298d;

/* JADX INFO: renamed from: b.i.a.f.d.n */
/* JADX INFO: compiled from: com.google.android.gms:play-services-cloud-messaging@@16.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3239n implements Runnable {

    /* JADX INFO: renamed from: j */
    public final ServiceConnectionC3232g f9276j;

    public RunnableC3239n(ServiceConnectionC3232g serviceConnectionC3232g) {
        this.f9276j = serviceConnectionC3232g;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f9276j.m4003a(2, "Service disconnected");
    }
}
