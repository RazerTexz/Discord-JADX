package b.f.j.p;

import android.os.SystemClock;
import b.f.j.p.a0;
import b.f.j.p.o0;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: NetworkFetchProducer.java */
/* loaded from: classes3.dex */
public class n0 implements w0<b.f.j.j.e> {
    public final b.f.d.g.g a;

    /* renamed from: b, reason: collision with root package name */
    public final b.f.d.g.a f629b;
    public final o0 c;

    /* compiled from: NetworkFetchProducer.java */
    public class a implements o0.a {
        public final /* synthetic */ x a;

        public a(x xVar) {
            this.a = xVar;
        }

        public void a(Throwable th) {
            n0 n0Var = n0.this;
            x xVar = this.a;
            Objects.requireNonNull(n0Var);
            xVar.a().k(xVar.f642b, "NetworkFetchProducer", th, null);
            xVar.a().c(xVar.f642b, "NetworkFetchProducer", false);
            xVar.f642b.n("network");
            xVar.a.c(th);
        }

        public void b(InputStream inputStream, int i) throws Throwable {
            b.f.j.r.b.b();
            n0 n0Var = n0.this;
            x xVar = this.a;
            b.f.d.g.i iVarE = i > 0 ? n0Var.a.e(i) : n0Var.a.a();
            byte[] bArr = n0Var.f629b.get(16384);
            while (true) {
                try {
                    int i2 = inputStream.read(bArr);
                    if (i2 < 0) {
                        o0 o0Var = n0Var.c;
                        int i3 = ((MemoryPooledByteBufferOutputStream) iVarE).l;
                        a0 a0Var = (a0) o0Var;
                        Objects.requireNonNull(a0Var);
                        ((a0.a) xVar).f = a0Var.c.now();
                        n0Var.c(iVarE, xVar);
                        n0Var.f629b.release(bArr);
                        iVarE.close();
                        b.f.j.r.b.b();
                        return;
                    }
                    if (i2 > 0) {
                        iVarE.write(bArr, 0, i2);
                        n0Var.d(iVarE, xVar);
                        xVar.a.a(i > 0 ? ((MemoryPooledByteBufferOutputStream) iVarE).l / i : 1.0f - ((float) Math.exp((-r4) / 50000.0d)));
                    }
                } catch (Throwable th) {
                    n0Var.f629b.release(bArr);
                    iVarE.close();
                    throw th;
                }
            }
        }
    }

    public n0(b.f.d.g.g gVar, b.f.d.g.a aVar, o0 o0Var) {
        this.a = gVar;
        this.f629b = aVar;
        this.c = o0Var;
    }

    public static void e(b.f.d.g.i iVar, int i, b.f.j.d.a aVar, l<b.f.j.j.e> lVar, x0 x0Var) throws Throwable {
        CloseableReference closeableReferenceA = CloseableReference.A(((MemoryPooledByteBufferOutputStream) iVar).b());
        b.f.j.j.e eVar = null;
        try {
            b.f.j.j.e eVar2 = new b.f.j.j.e(closeableReferenceA);
            try {
                eVar2.f590s = null;
                eVar2.q();
                x0Var.h(b.f.j.j.f.NETWORK);
                lVar.b(eVar2, i);
                eVar2.close();
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
            } catch (Throwable th) {
                th = th;
                eVar = eVar2;
                if (eVar != null) {
                    eVar.close();
                }
                if (closeableReferenceA != null) {
                    closeableReferenceA.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override // b.f.j.p.w0
    public void b(l<b.f.j.j.e> lVar, x0 x0Var) {
        x0Var.o().e(x0Var, "NetworkFetchProducer");
        Objects.requireNonNull((a0) this.c);
        a0.a aVar = new a0.a(lVar, x0Var);
        o0 o0Var = this.c;
        a aVar2 = new a(aVar);
        a0 a0Var = (a0) o0Var;
        Objects.requireNonNull(a0Var);
        aVar.d = a0Var.c.now();
        x0Var.f(new z(a0Var, a0Var.f604b.submit(new y(a0Var, aVar, aVar2)), aVar2));
    }

    public void c(b.f.d.g.i iVar, x xVar) throws Throwable {
        HashMap map;
        int i = ((MemoryPooledByteBufferOutputStream) iVar).l;
        if (xVar.a().g(xVar.f642b, "NetworkFetchProducer")) {
            Objects.requireNonNull((a0) this.c);
            a0.a aVar = (a0.a) xVar;
            map = new HashMap(4);
            map.put("queue_time", Long.toString(aVar.e - aVar.d));
            map.put("fetch_time", Long.toString(aVar.f - aVar.e));
            map.put("total_time", Long.toString(aVar.f - aVar.d));
            map.put("image_size", Integer.toString(i));
        } else {
            map = null;
        }
        z0 z0VarA = xVar.a();
        z0VarA.j(xVar.f642b, "NetworkFetchProducer", map);
        z0VarA.c(xVar.f642b, "NetworkFetchProducer", true);
        xVar.f642b.n("network");
        e(iVar, 1, null, xVar.a, xVar.f642b);
    }

    public void d(b.f.d.g.i iVar, x xVar) throws Throwable {
        boolean z2;
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (xVar.f642b.p()) {
            Objects.requireNonNull(this.c);
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2 || jUptimeMillis - xVar.c < 100) {
            return;
        }
        xVar.c = jUptimeMillis;
        xVar.a().a(xVar.f642b, "NetworkFetchProducer", "intermediate_result");
        e(iVar, 0, null, xVar.a, xVar.f642b);
    }
}
