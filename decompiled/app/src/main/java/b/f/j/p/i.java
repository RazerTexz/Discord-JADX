package b.f.j.p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.Objects;

/* compiled from: BitmapPrepareProducer.java */
/* loaded from: classes3.dex */
public class i implements w0<CloseableReference<b.f.j.j.c>> {
    public final w0<CloseableReference<b.f.j.j.c>> a;

    /* renamed from: b, reason: collision with root package name */
    public final int f615b;
    public final int c;
    public final boolean d;

    /* compiled from: BitmapPrepareProducer.java */
    public static class a extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
        public final int c;
        public final int d;

        public a(l<CloseableReference<b.f.j.j.c>> lVar, int i, int i2) {
            super(lVar);
            this.c = i;
            this.d = i2;
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            Bitmap bitmap;
            CloseableReference closeableReference = (CloseableReference) obj;
            if (closeableReference != null && closeableReference.x()) {
                b.f.j.j.c cVar = (b.f.j.j.c) closeableReference.u();
                if (!cVar.isClosed() && (cVar instanceof b.f.j.j.d) && (bitmap = ((b.f.j.j.d) cVar).m) != null) {
                    int height = bitmap.getHeight() * bitmap.getRowBytes();
                    if (height >= this.c && height <= this.d) {
                        bitmap.prepareToDraw();
                    }
                }
            }
            this.f632b.b(closeableReference, i);
        }
    }

    public i(w0<CloseableReference<b.f.j.j.c>> w0Var, int i, int i2, boolean z2) {
        b.c.a.a0.d.i(Boolean.valueOf(i <= i2));
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.f615b = i;
        this.c = i2;
        this.d = z2;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        if (!x0Var.k() || this.d) {
            this.a.b(new a(lVar, this.f615b, this.c), x0Var);
        } else {
            this.a.b(lVar, x0Var);
        }
    }
}
