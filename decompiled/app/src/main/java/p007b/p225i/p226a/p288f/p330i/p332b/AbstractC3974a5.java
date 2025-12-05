package p007b.p225i.p226a.p288f.p330i.p332b;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* renamed from: b.i.a.f.i.b.a5 */
/* loaded from: classes3.dex */
public abstract class AbstractC3974a5 extends C4254z1 {

    /* renamed from: b */
    public boolean f10542b;

    public AbstractC3974a5(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11202a.f11251F++;
    }

    /* renamed from: t */
    public final void m5497t() {
        if (!this.f10542b) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* renamed from: u */
    public final void m5498u() {
        if (this.f10542b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo5499v()) {
            return;
        }
        this.f11202a.f11252G.incrementAndGet();
        this.f10542b = true;
    }

    /* renamed from: v */
    public abstract boolean mo5499v();
}
