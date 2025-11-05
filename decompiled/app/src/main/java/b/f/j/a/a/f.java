package b.f.j.a.a;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import java.util.List;

/* compiled from: AnimatedImageResultBuilder.java */
/* loaded from: classes2.dex */
public class f {
    public final c a;

    /* renamed from: b, reason: collision with root package name */
    public CloseableReference<Bitmap> f545b;
    public List<CloseableReference<Bitmap>> c;
    public int d;
    public b.f.j.t.a e;

    public f(c cVar) {
        this.a = cVar;
    }

    public e a() {
        try {
            e eVar = new e(this);
            CloseableReference<Bitmap> closeableReference = this.f545b;
            if (closeableReference != null) {
                closeableReference.close();
            }
            this.f545b = null;
            CloseableReference.t(this.c);
            this.c = null;
            return eVar;
        } catch (Throwable th) {
            CloseableReference<Bitmap> closeableReference2 = this.f545b;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
            this.f545b = null;
            CloseableReference.t(this.c);
            this.c = null;
            throw th;
        }
    }
}
