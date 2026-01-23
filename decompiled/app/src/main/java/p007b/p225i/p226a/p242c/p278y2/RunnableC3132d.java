package p007b.p225i.p226a.p242c.p278y2;

/* JADX INFO: renamed from: b.i.a.c.y2.d */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC3132d implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AsynchronousMediaCodecCallback f9049j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Runnable f9050k;

    public /* synthetic */ RunnableC3132d(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback, Runnable runnable) {
        this.f9049j = asynchronousMediaCodecCallback;
        this.f9050k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.f9049j;
        Runnable runnable = this.f9050k;
        synchronized (asynchronousMediaCodecCallback.f9083a) {
            if (!asynchronousMediaCodecCallback.f9094l) {
                long j = asynchronousMediaCodecCallback.f9093k - 1;
                asynchronousMediaCodecCallback.f9093k = j;
                if (j <= 0) {
                    if (j < 0) {
                        asynchronousMediaCodecCallback.m3855c(new IllegalStateException());
                    } else {
                        asynchronousMediaCodecCallback.m3853a();
                        try {
                            runnable.run();
                        } catch (IllegalStateException e) {
                            asynchronousMediaCodecCallback.m3855c(e);
                        } catch (Exception e2) {
                            asynchronousMediaCodecCallback.m3855c(new IllegalStateException(e2));
                        }
                    }
                }
            }
        }
    }
}
