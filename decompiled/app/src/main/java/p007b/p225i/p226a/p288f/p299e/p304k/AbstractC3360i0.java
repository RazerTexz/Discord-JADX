package p007b.p225i.p226a.p288f.p299e.p304k;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.k.i0 */
/* loaded from: classes3.dex */
public abstract class AbstractC3360i0<TListener> {

    /* renamed from: a */
    @Nullable
    public TListener f9524a;

    /* renamed from: b */
    public boolean f9525b = false;

    /* renamed from: c */
    public final /* synthetic */ AbstractC3345b f9526c;

    public AbstractC3360i0(AbstractC3345b abstractC3345b, TListener tlistener) {
        this.f9526c = abstractC3345b;
        this.f9524a = tlistener;
    }

    /* renamed from: a */
    public abstract void mo4159a();

    /* renamed from: b */
    public abstract void mo4160b(TListener tlistener);

    /* renamed from: c */
    public final void m4161c() {
        synchronized (this) {
            this.f9524a = null;
        }
        synchronized (this.f9526c.f9488m) {
            this.f9526c.f9488m.remove(this);
        }
    }
}
