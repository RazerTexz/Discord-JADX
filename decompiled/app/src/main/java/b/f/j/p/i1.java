package b.f.j.p;

import android.util.Pair;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* compiled from: ThrottlingProducer.java */
/* loaded from: classes3.dex */
public class i1<T> implements w0<T> {
    public final w0<T> a;

    /* renamed from: b, reason: collision with root package name */
    public int f616b;
    public final ConcurrentLinkedQueue<Pair<l<T>, x0>> c;
    public final Executor d;

    /* compiled from: ThrottlingProducer.java */
    public class b extends p<T, T> {

        /* compiled from: ThrottlingProducer.java */
        public class a implements Runnable {
            public final /* synthetic */ Pair j;

            public a(Pair pair) {
                this.j = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                i1 i1Var = i1.this;
                Pair pair = this.j;
                l lVar = (l) pair.first;
                x0 x0Var = (x0) pair.second;
                Objects.requireNonNull(i1Var);
                x0Var.o().j(x0Var, "ThrottlingProducer", null);
                i1Var.a.b(new b(lVar, null), x0Var);
            }
        }

        public b(l lVar, a aVar) {
            super(lVar);
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void g() {
            this.f632b.d();
            n();
        }

        @Override // b.f.j.p.p, b.f.j.p.b
        public void h(Throwable th) {
            this.f632b.c(th);
            n();
        }

        @Override // b.f.j.p.b
        public void i(T t, int i) {
            this.f632b.b(t, i);
            if (b.f.j.p.b.e(i)) {
                n();
            }
        }

        public final void n() {
            Pair<l<T>, x0> pairPoll;
            synchronized (i1.this) {
                pairPoll = i1.this.c.poll();
                if (pairPoll == null) {
                    i1 i1Var = i1.this;
                    i1Var.f616b--;
                }
            }
            if (pairPoll != null) {
                i1.this.d.execute(new a(pairPoll));
            }
        }
    }

    public i1(int i, Executor executor, w0<T> w0Var) {
        Objects.requireNonNull(executor);
        this.d = executor;
        Objects.requireNonNull(w0Var);
        this.a = w0Var;
        this.c = new ConcurrentLinkedQueue<>();
        this.f616b = 0;
    }

    @Override // b.f.j.p.w0
    public void b(l<T> lVar, x0 x0Var) {
        boolean z2;
        x0Var.o().e(x0Var, "ThrottlingProducer");
        synchronized (this) {
            int i = this.f616b;
            z2 = true;
            if (i >= 5) {
                this.c.add(Pair.create(lVar, x0Var));
            } else {
                this.f616b = i + 1;
                z2 = false;
            }
        }
        if (z2) {
            return;
        }
        x0Var.o().j(x0Var, "ThrottlingProducer", null);
        this.a.b(new b(lVar, null), x0Var);
    }
}
