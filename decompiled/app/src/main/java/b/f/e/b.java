package b.f.e;

/* compiled from: AbstractDataSource.java */
/* loaded from: classes.dex */
public class b implements Runnable {
    public final /* synthetic */ f j;
    public final /* synthetic */ c k;

    public b(c cVar, f fVar) {
        this.k = cVar;
        this.j = fVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.j.onProgressUpdate(this.k);
    }
}
