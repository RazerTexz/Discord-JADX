package p007b.p109f.p129e;

/* JADX INFO: renamed from: b.f.e.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractDataSource.java */
/* JADX INFO: loaded from: classes.dex */
public class AbstractDataSource implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f3146j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ DataSubscriber f3147k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ boolean f3148l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ AbstractDataSource3 f3149m;

    public AbstractDataSource(AbstractDataSource3 abstractDataSource3, boolean z2, DataSubscriber dataSubscriber, boolean z3) {
        this.f3149m = abstractDataSource3;
        this.f3146j = z2;
        this.f3147k = dataSubscriber;
        this.f3148l = z3;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3146j) {
            this.f3147k.onFailure(this.f3149m);
        } else if (this.f3148l) {
            this.f3147k.onCancellation(this.f3149m);
        } else {
            this.f3147k.onNewResult(this.f3149m);
        }
    }
}
