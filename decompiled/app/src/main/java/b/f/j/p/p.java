package b.f.j.p;

/* compiled from: DelegatingConsumer.java */
/* loaded from: classes3.dex */
public abstract class p<I, O> extends b<I> {

    /* renamed from: b, reason: collision with root package name */
    public final l<O> f632b;

    public p(l<O> lVar) {
        this.f632b = lVar;
    }

    @Override // b.f.j.p.b
    public void g() {
        this.f632b.d();
    }

    @Override // b.f.j.p.b
    public void h(Throwable th) {
        this.f632b.c(th);
    }

    @Override // b.f.j.p.b
    public void j(float f) {
        this.f632b.a(f);
    }
}
