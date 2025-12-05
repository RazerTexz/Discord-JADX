package p007b.p225i.p226a.p288f.p313h.p323j;

/* renamed from: b.i.a.f.h.j.e */
/* loaded from: classes3.dex */
public abstract class AbstractC3509e extends C3506d {

    /* renamed from: k */
    public boolean f9685k;

    public AbstractC3509e(C3515g c3515g) {
        super(c3515g);
    }

    /* renamed from: I */
    public final boolean m4442I() {
        return this.f9685k;
    }

    /* renamed from: J */
    public final void m4443J() {
        mo4414L();
        this.f9685k = true;
    }

    /* renamed from: L */
    public abstract void mo4414L();

    /* renamed from: N */
    public final void m4444N() {
        if (!m4442I()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
