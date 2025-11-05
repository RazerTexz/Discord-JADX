package b.f.j.p;

import java.util.Objects;

/* compiled from: ThreadHandoffProducer.java */
/* loaded from: classes3.dex */
public class f1<T> implements w0<T> {
    public final w0<T> a;

    /* renamed from: b, reason: collision with root package name */
    public final g1 f610b;

    /* compiled from: ThreadHandoffProducer.java */
    public class a extends e1<T> {
        public final /* synthetic */ z0 o;
        public final /* synthetic */ x0 p;
        public final /* synthetic */ l q;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(l lVar, z0 z0Var, x0 x0Var, String str, z0 z0Var2, x0 x0Var2, l lVar2) {
            super(lVar, z0Var, x0Var, str);
            this.o = z0Var2;
            this.p = x0Var2;
            this.q = lVar2;
        }

        @Override // b.f.j.p.e1
        public void b(T t) {
        }

        @Override // b.f.j.p.e1
        public T d() throws Exception {
            return null;
        }

        @Override // b.f.j.p.e1
        public void g(T t) {
            this.o.j(this.p, "BackgroundThreadHandoffProducer", null);
            f1.this.a.b(this.q, this.p);
        }
    }

    /* compiled from: ThreadHandoffProducer.java */
    public class b extends e {
        public final /* synthetic */ e1 a;

        public b(e1 e1Var) {
            this.a = e1Var;
        }

        @Override // b.f.j.p.y0
        public void a() {
            this.a.a();
            g1 g1Var = f1.this.f610b;
            e1 e1Var = this.a;
            h1 h1Var = (h1) g1Var;
            synchronized (h1Var) {
                h1Var.a.remove(e1Var);
            }
        }
    }

    public f1(w0<T> w0Var, g1 g1Var) {
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.f610b = g1Var;
    }

    @Override // b.f.j.p.w0
    public void b(l<T> lVar, x0 x0Var) {
        try {
            b.f.j.r.b.b();
            z0 z0VarO = x0Var.o();
            Objects.requireNonNull(x0Var.g().getExperiments());
            a aVar = new a(lVar, z0VarO, x0Var, "BackgroundThreadHandoffProducer", z0VarO, x0Var, lVar);
            x0Var.f(new b(aVar));
            h1 h1Var = (h1) this.f610b;
            synchronized (h1Var) {
                h1Var.f614b.execute(aVar);
            }
        } finally {
            b.f.j.r.b.b();
        }
    }
}
