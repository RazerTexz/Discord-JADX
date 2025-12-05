package p007b.p225i.p226a.p242c.p265v2;

/* compiled from: Buffer.java */
/* renamed from: b.i.a.c.v2.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class Buffer2 {

    /* renamed from: j */
    public int f7901j;

    /* renamed from: j */
    public final void m3551j(int i) {
        this.f7901j = i | this.f7901j;
    }

    /* renamed from: k */
    public final boolean m3552k(int i) {
        return (this.f7901j & i) == i;
    }

    /* renamed from: l */
    public final boolean m3553l() {
        return m3552k(268435456);
    }

    /* renamed from: m */
    public final boolean m3554m() {
        return m3552k(Integer.MIN_VALUE);
    }

    /* renamed from: n */
    public final boolean m3555n() {
        return m3552k(4);
    }

    /* renamed from: o */
    public final boolean m3556o() {
        return m3552k(1);
    }
}
