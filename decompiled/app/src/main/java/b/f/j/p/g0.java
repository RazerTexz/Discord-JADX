package b.f.j.p;

import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* compiled from: LocalFetchProducer.java */
/* loaded from: classes3.dex */
public abstract class g0 implements w0<b.f.j.j.e> {
    public final Executor a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.d.g.g f612b;

    /* compiled from: LocalFetchProducer.java */
    public class a extends e1<b.f.j.j.e> {
        public final /* synthetic */ ImageRequest o;
        public final /* synthetic */ z0 p;
        public final /* synthetic */ x0 q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, z0 z0Var, x0 x0Var, String str, ImageRequest imageRequest, z0 z0Var2, x0 x0Var2) {
            super(lVar, z0Var, x0Var, str);
            this.o = imageRequest;
            this.p = z0Var2;
            this.q = x0Var2;
        }

        @Override // b.f.j.p.e1
        public void b(b.f.j.j.e eVar) {
            b.f.j.j.e eVar2 = eVar;
            if (eVar2 != null) {
                eVar2.close();
            }
        }

        @Override // b.f.j.p.e1
        public b.f.j.j.e d() throws Exception {
            b.f.j.j.e eVarD = g0.this.d(this.o);
            if (eVarD == null) {
                this.p.c(this.q, g0.this.e(), false);
                this.q.n("local");
                return null;
            }
            eVarD.q();
            this.p.c(this.q, g0.this.e(), true);
            this.q.n("local");
            return eVarD;
        }
    }

    /* compiled from: LocalFetchProducer.java */
    public class b extends e {
        public final /* synthetic */ e1 a;

        public b(g0 g0Var, e1 e1Var) {
            this.a = e1Var;
        }

        @Override // b.f.j.p.y0
        public void a() {
            this.a.a();
        }
    }

    public g0(Executor executor, b.f.d.g.g gVar) {
        this.a = executor;
        this.f612b = gVar;
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        ImageRequest imageRequestE = x0Var.e();
        x0Var.i("local", "fetch");
        a aVar = new a(lVar, z0VarO, x0Var, e(), imageRequestE, z0VarO, x0Var);
        x0Var.f(new b(this, aVar));
        this.a.execute(aVar);
    }

    public b.f.j.j.e c(InputStream inputStream, int i) throws IOException {
        CloseableReference closeableReferenceA = null;
        try {
            closeableReferenceA = i <= 0 ? CloseableReference.A(this.f612b.c(inputStream)) : CloseableReference.A(this.f612b.d(inputStream, i));
            b.f.j.j.e eVar = new b.f.j.j.e(closeableReferenceA);
            b.f.d.d.a.b(inputStream);
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            return eVar;
        } catch (Throwable th) {
            b.f.d.d.a.b(inputStream);
            Class<CloseableReference> cls = CloseableReference.j;
            if (closeableReferenceA != null) {
                closeableReferenceA.close();
            }
            throw th;
        }
    }

    public abstract b.f.j.j.e d(ImageRequest imageRequest) throws IOException;

    public abstract String e();
}
