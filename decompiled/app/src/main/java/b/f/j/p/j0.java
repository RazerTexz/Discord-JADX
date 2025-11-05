package b.f.j.p;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.CancellationSignal;
import android.util.Size;
import androidx.annotation.RequiresApi;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: LocalThumbnailBitmapProducer.java */
@RequiresApi(29)
/* loaded from: classes3.dex */
public class j0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f618b;

    /* compiled from: LocalThumbnailBitmapProducer.java */
    public class a extends e1<CloseableReference<b.f.j.j.c>> {
        public final /* synthetic */ z0 o;
        public final /* synthetic */ x0 p;
        public final /* synthetic */ ImageRequest q;
        public final /* synthetic */ CancellationSignal r;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, z0 z0Var, x0 x0Var, String str, z0 z0Var2, x0 x0Var2, ImageRequest imageRequest, CancellationSignal cancellationSignal) {
            super(lVar, z0Var, x0Var, str);
            this.o = z0Var2;
            this.p = x0Var2;
            this.q = imageRequest;
            this.r = cancellationSignal;
        }

        @Override // b.f.j.p.e1
        public void b(CloseableReference<b.f.j.j.c> closeableReference) {
            CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReference2 != null) {
                closeableReference2.close();
            }
        }

        @Override // b.f.j.p.e1
        public Map c(CloseableReference<b.f.j.j.c> closeableReference) {
            return b.f.d.d.f.of("createdThumbnail", String.valueOf(closeableReference != null));
        }

        @Override // b.f.j.p.e1
        public CloseableReference<b.f.j.j.c> d() throws Exception {
            ContentResolver contentResolver = j0.this.f618b;
            Uri uri = this.q.c;
            b.f.j.d.e eVar = this.q.j;
            Bitmap bitmapLoadThumbnail = contentResolver.loadThumbnail(uri, new Size(eVar != null ? eVar.a : 2048, eVar != null ? eVar.f566b : 2048), this.r);
            if (bitmapLoadThumbnail == null) {
                return null;
            }
            b.f.j.j.d dVar = new b.f.j.j.d(bitmapLoadThumbnail, b.f.j.b.b.a(), b.f.j.j.h.a, 0);
            this.p.d("image_format", "thumbnail");
            dVar.e(this.p.a());
            return CloseableReference.A(dVar);
        }

        @Override // b.f.j.p.e1
        public void e() {
            super.e();
            this.r.cancel();
        }

        @Override // b.f.j.p.e1
        public void f(Exception exc) {
            super.f(exc);
            this.o.c(this.p, "LocalThumbnailBitmapProducer", false);
            this.p.n("local");
        }

        @Override // b.f.j.p.e1
        public void g(CloseableReference<b.f.j.j.c> closeableReference) {
            CloseableReference<b.f.j.j.c> closeableReference2 = closeableReference;
            super.g(closeableReference2);
            this.o.c(this.p, "LocalThumbnailBitmapProducer", closeableReference2 != null);
            this.p.n("local");
        }
    }

    /* compiled from: LocalThumbnailBitmapProducer.java */
    public class b extends e {
        public final /* synthetic */ e1 a;

        public b(j0 j0Var, e1 e1Var) {
            this.a = e1Var;
        }

        @Override // b.f.j.p.y0
        public void a() {
            this.a.a();
        }
    }

    public j0(Executor executor, ContentResolver contentResolver) {
        this.a = executor;
        this.f618b = contentResolver;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", "thumbnail_bitmap");
        a aVar = new a(lVar, z0VarO, x0Var, "LocalThumbnailBitmapProducer", z0VarO, x0Var, imageRequestE, new CancellationSignal());
        x0Var.f(new b(this, aVar));
        this.a.execute(aVar);
    }
}
