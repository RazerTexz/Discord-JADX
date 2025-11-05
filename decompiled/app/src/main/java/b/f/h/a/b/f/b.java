package b.f.h.a.b.f;

import android.graphics.Bitmap;
import b.f.h.a.b.c;
import b.f.j.a.c.d;
import com.facebook.common.references.CloseableReference;

/* compiled from: AnimatedDrawableBackendFrameRenderer.java */
/* loaded from: classes.dex */
public class b implements c {
    public final b.f.h.a.b.b a;

    /* renamed from: b, reason: collision with root package name */
    public b.f.j.a.a.a f531b;
    public d c;
    public final d.a d;

    /* compiled from: AnimatedDrawableBackendFrameRenderer.java */
    public class a implements d.a {
        public a() {
        }

        @Override // b.f.j.a.c.d.a
        public void a(int i, Bitmap bitmap) {
        }

        @Override // b.f.j.a.c.d.a
        public CloseableReference<Bitmap> b(int i) {
            return b.this.a.d(i);
        }
    }

    public b(b.f.h.a.b.b bVar, b.f.j.a.a.a aVar) {
        a aVar2 = new a();
        this.d = aVar2;
        this.a = bVar;
        this.f531b = aVar;
        this.c = new d(aVar, aVar2);
    }

    public boolean a(int i, Bitmap bitmap) {
        try {
            this.c.d(i, bitmap);
            return true;
        } catch (IllegalStateException e) {
            b.f.d.e.a.d(b.class, e, "Rendering of frame unsuccessful. Frame number: %d", Integer.valueOf(i));
            return false;
        }
    }
}
