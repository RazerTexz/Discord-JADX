package b.f.j.p;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: PostprocessorProducer.java */
/* loaded from: classes3.dex */
public class t0 implements w0<CloseableReference<b.f.j.j.c>> {
    public final w0<CloseableReference<b.f.j.j.c>> a;

    /* renamed from: b, reason: collision with root package name */
    public final PlatformBitmapFactory f639b;
    public final Executor c;

    /* compiled from: PostprocessorProducer.java */
    public class b extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
        public final z0 c;
        public final x0 d;
        public final b.f.j.q.b e;
        public boolean f;
        public CloseableReference<b.f.j.j.c> g;
        public int h;
        public boolean i;
        public boolean j;

        /* compiled from: PostprocessorProducer.java */
        public class a extends e {
            public a(t0 t0Var) {
            }

            @Override // b.f.j.p.y0
            public void a() {
                b bVar = b.this;
                if (bVar.o()) {
                    bVar.f632b.d();
                }
            }
        }

        public b(l<CloseableReference<b.f.j.j.c>> lVar, z0 z0Var, b.f.j.q.b bVar, x0 x0Var) {
            super(lVar);
            this.g = null;
            this.h = 0;
            this.i = false;
            this.j = false;
            this.c = z0Var;
            this.e = bVar;
            this.d = x0Var;
            x0Var.f(new a(t0.this));
        }

        public static void n(b bVar, CloseableReference closeableReference, int i) {
            Objects.requireNonNull(bVar);
            b.c.a.a0.d.i(Boolean.valueOf(CloseableReference.y(closeableReference)));
            if (!(((b.f.j.j.c) closeableReference.u()) instanceof b.f.j.j.d)) {
                bVar.q(closeableReference, i);
                return;
            }
            bVar.c.e(bVar.d, "PostprocessorProducer");
            CloseableReference<b.f.j.j.c> closeableReferenceR = null;
            try {
                try {
                    closeableReferenceR = bVar.r((b.f.j.j.c) closeableReference.u());
                    z0 z0Var = bVar.c;
                    x0 x0Var = bVar.d;
                    z0Var.j(x0Var, "PostprocessorProducer", bVar.p(z0Var, x0Var, bVar.e));
                    bVar.q(closeableReferenceR, i);
                } catch (Exception e) {
                    z0 z0Var2 = bVar.c;
                    x0 x0Var2 = bVar.d;
                    z0Var2.k(x0Var2, "PostprocessorProducer", e, bVar.p(z0Var2, x0Var2, bVar.e));
                    if (bVar.o()) {
                        bVar.f632b.c(e);
                    }
                }
            } finally {
                if (closeableReferenceR != null) {
                    closeableReferenceR.close();
                }
            }
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void g() {
            if (o()) {
                this.f632b.d();
            }
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void h(Throwable th) {
            if (o()) {
                this.f632b.c(th);
            }
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (!CloseableReference.y(closeableReference)) {
                if (b.f.j.p.b.e(i)) {
                    q(null, i);
                    return;
                }
                return;
            }
            synchronized (this) {
                if (!this.f) {
                    CloseableReference<b.f.j.j.c> closeableReference2 = this.g;
                    this.g = CloseableReference.n(closeableReference);
                    this.h = i;
                    this.i = true;
                    boolean zS = s();
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                    if (zS) {
                        t0.this.c.execute(new u0(this));
                    }
                }
            }
        }

        public final boolean o() {
            synchronized (this) {
                if (this.f) {
                    return false;
                }
                CloseableReference<b.f.j.j.c> closeableReference = this.g;
                this.g = null;
                this.f = true;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }

        public final Map<String, String> p(z0 z0Var, x0 x0Var, b.f.j.q.b bVar) {
            if (z0Var.g(x0Var, "PostprocessorProducer")) {
                return b.f.d.d.f.of("Postprocessor", bVar.getName());
            }
            return null;
        }

        /* JADX WARN: Removed duplicated region for block: B:12:0x0010  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void q(CloseableReference<b.f.j.j.c> closeableReference, int i) {
            boolean z2;
            boolean zE = b.f.j.p.b.e(i);
            if (!zE) {
                synchronized (this) {
                    z2 = this.f;
                }
                if (z2) {
                    if (!zE || !o()) {
                        return;
                    }
                }
            }
            this.f632b.b(closeableReference, i);
        }

        public final CloseableReference<b.f.j.j.c> r(b.f.j.j.c cVar) {
            b.f.j.j.d dVar = (b.f.j.j.d) cVar;
            CloseableReference<Bitmap> closeableReferenceProcess = this.e.process(dVar.m, t0.this.f639b);
            try {
                b.f.j.j.d dVar2 = new b.f.j.j.d(closeableReferenceProcess, cVar.b(), dVar.o, dVar.p);
                dVar2.e(dVar.k);
                CloseableReference<b.f.j.j.c> closeableReferenceA = CloseableReference.A(dVar2);
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
                return closeableReferenceA;
            } catch (Throwable th) {
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReferenceProcess != null) {
                    closeableReferenceProcess.close();
                }
                throw th;
            }
        }

        public final synchronized boolean s() {
            if (this.f || !this.i || this.j || !CloseableReference.y(this.g)) {
                return false;
            }
            this.j = true;
            return true;
        }
    }

    /* compiled from: PostprocessorProducer.java */
    public class c extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> implements b.f.j.q.d {
        public boolean c;
        public CloseableReference<b.f.j.j.c> d;

        public c(t0 t0Var, b bVar, b.f.j.q.c cVar, x0 x0Var, a aVar) {
            super(bVar);
            this.c = false;
            this.d = null;
            cVar.a(this);
            x0Var.f(new v0(this, t0Var));
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void g() {
            if (n()) {
                this.f632b.d();
            }
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void h(Throwable th) {
            if (n()) {
                this.f632b.c(th);
            }
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (b.f.j.p.b.f(i)) {
                return;
            }
            synchronized (this) {
                if (!this.c) {
                    CloseableReference<b.f.j.j.c> closeableReference2 = this.d;
                    this.d = CloseableReference.n(closeableReference);
                    if (closeableReference2 != null) {
                        closeableReference2.close();
                    }
                }
            }
            synchronized (this) {
                if (!this.c) {
                    CloseableReference closeableReferenceN = CloseableReference.n(this.d);
                    try {
                        this.f632b.b(closeableReferenceN, 0);
                    } finally {
                        if (closeableReferenceN != null) {
                            closeableReferenceN.close();
                        }
                    }
                }
            }
        }

        public final boolean n() {
            synchronized (this) {
                if (this.c) {
                    return false;
                }
                CloseableReference<b.f.j.j.c> closeableReference = this.d;
                this.d = null;
                this.c = true;
                Class<CloseableReference> cls = CloseableReference.j;
                if (closeableReference != null) {
                    closeableReference.close();
                }
                return true;
            }
        }
    }

    /* compiled from: PostprocessorProducer.java */
    public class d extends p<CloseableReference<b.f.j.j.c>, CloseableReference<b.f.j.j.c>> {
        public d(t0 t0Var, b bVar, a aVar) {
            super(bVar);
        }

        @Override // b.f.j.p.b
        public void i(Object obj, int i) {
            CloseableReference closeableReference = (CloseableReference) obj;
            if (b.f.j.p.b.f(i)) {
                return;
            }
            this.f632b.b(closeableReference, i);
        }
    }

    public t0(w0<CloseableReference<b.f.j.j.c>> w0Var, PlatformBitmapFactory platformBitmapFactory, Executor executor) {
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.f639b = platformBitmapFactory;
        Objects.requireNonNull(executor);
        this.c = executor;
    }

    @Override // b.f.j.p.w0
    public void b(l<CloseableReference<b.f.j.j.c>> lVar, x0 x0Var) {
        z0 z0VarO = x0Var.o();
        b.f.j.q.b bVar = x0Var.e().f2903s;
        Objects.requireNonNull(bVar);
        b bVar2 = new b(lVar, z0VarO, bVar, x0Var);
        this.a.b(bVar instanceof b.f.j.q.c ? new c(this, bVar2, (b.f.j.q.c) bVar, x0Var, null) : new d(this, bVar2, null), x0Var);
    }
}
