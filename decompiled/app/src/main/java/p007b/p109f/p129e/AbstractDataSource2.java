package p007b.p109f.p129e;

/* JADX INFO: renamed from: b.f.e.b, reason: use source file name */
/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class AbstractDataSource2 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ DataSubscriber f3150j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractDataSource3 f3151k;

    public AbstractDataSource2(AbstractDataSource3 abstractDataSource3, DataSubscriber dataSubscriber) {
        this.f3151k = abstractDataSource3;
        this.f3150j = dataSubscriber;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3150j.onProgressUpdate(this.f3151k);
    }
}
