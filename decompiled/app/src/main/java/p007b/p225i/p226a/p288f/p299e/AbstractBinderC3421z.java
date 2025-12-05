package p007b.p225i.p226a.p288f.p299e;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* renamed from: b.i.a.f.e.z */
/* loaded from: classes3.dex */
public abstract class AbstractBinderC3421z extends AbstractBinderC3419x {

    /* renamed from: c */
    public static final WeakReference<byte[]> f9613c = new WeakReference<>(null);

    /* renamed from: d */
    public WeakReference<byte[]> f9614d;

    public AbstractBinderC3421z(byte[] bArr) {
        super(bArr);
        this.f9614d = f9613c;
    }

    @Override // p007b.p225i.p226a.p288f.p299e.AbstractBinderC3419x
    /* renamed from: g */
    public final byte[] mo4379g() {
        byte[] bArrMo4377t0;
        synchronized (this) {
            bArrMo4377t0 = this.f9614d.get();
            if (bArrMo4377t0 == null) {
                bArrMo4377t0 = mo4377t0();
                this.f9614d = new WeakReference<>(bArrMo4377t0);
            }
        }
        return bArrMo4377t0;
    }

    /* renamed from: t0 */
    public abstract byte[] mo4377t0();
}
