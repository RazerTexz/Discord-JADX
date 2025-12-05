package p007b.p109f.p129e;

/* compiled from: AbstractDataSource.java */
/* renamed from: b.f.e.a, reason: use source file name */
/* loaded from: classes.dex */
public class AbstractDataSource implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ boolean f3146j;

    /* renamed from: k */
    public final /* synthetic */ DataSubscriber f3147k;

    /* renamed from: l */
    public final /* synthetic */ boolean f3148l;

    /* renamed from: m */
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
