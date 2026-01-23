package p007b.p008a.p041q;

/* JADX INFO: renamed from: b.a.q.d, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineExecutorService.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineExecutorService2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ IllegalStateException f1612j;

    public MediaEngineExecutorService2(IllegalStateException illegalStateException) {
        this.f1612j = illegalStateException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw this.f1612j;
    }
}
