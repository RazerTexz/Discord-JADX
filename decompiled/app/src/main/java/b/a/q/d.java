package b.a.q;

/* compiled from: MediaEngineExecutorService.kt */
/* loaded from: classes.dex */
public final class d implements Runnable {
    public final /* synthetic */ IllegalStateException j;

    public d(IllegalStateException illegalStateException) {
        this.j = illegalStateException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        throw this.j;
    }
}
