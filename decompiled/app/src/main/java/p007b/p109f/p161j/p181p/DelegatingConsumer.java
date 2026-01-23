package p007b.p109f.p161j.p181p;

/* JADX INFO: renamed from: b.f.j.p.p, reason: use source file name */
/* JADX INFO: compiled from: DelegatingConsumer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {

    /* JADX INFO: renamed from: b */
    public final Consumer2<O> f4179b;

    public DelegatingConsumer(Consumer2<O> consumer2) {
        this.f4179b = consumer2;
    }

    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: g */
    public void mo1318g() {
        this.f4179b.mo1426d();
    }

    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: h */
    public void mo1319h(Throwable th) {
        this.f4179b.mo1425c(th);
    }

    @Override // p007b.p109f.p161j.p181p.BaseConsumer
    /* JADX INFO: renamed from: j */
    public void mo1321j(float f) {
        this.f4179b.mo1423a(f);
    }
}
