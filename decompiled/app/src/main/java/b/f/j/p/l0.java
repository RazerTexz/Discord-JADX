package b.f.j.p;

import android.util.Pair;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: MultiplexProducer.java */
/* loaded from: classes3.dex */
public abstract class l0<K, T extends Closeable> implements w0<T> {

    @VisibleForTesting
    public final Map<K, l0<K, T>.b> a;

    /* renamed from: b, reason: collision with root package name */
    public final w0<T> f622b;
    public final boolean c;
    public final String d;
    public final String e;

    /* compiled from: MultiplexProducer.java */
    @VisibleForTesting
    public class b {
        public final K a;

        /* renamed from: b, reason: collision with root package name */
        public final CopyOnWriteArraySet<Pair<l<T>, x0>> f623b = new CopyOnWriteArraySet<>();
        public T c;
        public float d;
        public int e;
        public d f;
        public l0<K, T>.b.a g;

        /* compiled from: MultiplexProducer.java */
        public class a extends b.f.j.p.b<T> {
            public a(a aVar) {
            }

            @Override // b.f.j.p.b
            public void g() {
                try {
                    b.f.j.r.b.b();
                    b bVar = b.this;
                    synchronized (bVar) {
                        if (bVar.g == this) {
                            bVar.g = null;
                            bVar.f = null;
                            bVar.b(bVar.c);
                            bVar.c = null;
                            bVar.i(b.f.d.l.a.UNSET);
                        }
                    }
                } finally {
                    b.f.j.r.b.b();
                }
            }

            @Override // b.f.j.p.b
            public void h(Throwable th) {
                try {
                    b.f.j.r.b.b();
                    b.this.f(this, th);
                } finally {
                    b.f.j.r.b.b();
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // b.f.j.p.b
            public void i(Object obj, int i) {
                Closeable closeable = (Closeable) obj;
                try {
                    b.f.j.r.b.b();
                    b.this.g(this, closeable, i);
                } finally {
                    b.f.j.r.b.b();
                }
            }

            @Override // b.f.j.p.b
            public void j(float f) {
                try {
                    b.f.j.r.b.b();
                    b.this.h(this, f);
                } finally {
                    b.f.j.r.b.b();
                }
            }
        }

        public b(K k) {
            this.a = k;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(l<T> lVar, x0 x0Var) {
            l0<K, T>.b bVar;
            Pair<l<T>, x0> pairCreate = Pair.create(lVar, x0Var);
            synchronized (this) {
                l0 l0Var = l0.this;
                K k = this.a;
                synchronized (l0Var) {
                    bVar = l0Var.a.get(k);
                }
                if (bVar != this) {
                    return false;
                }
                this.f623b.add(pairCreate);
                List<y0> listK = k();
                List<y0> listL = l();
                List<y0> listJ = j();
                Closeable closeableC = this.c;
                float f = this.d;
                int i = this.e;
                d.s(listK);
                d.t(listL);
                d.r(listJ);
                synchronized (pairCreate) {
                    synchronized (this) {
                        if (closeableC != this.c) {
                            closeableC = null;
                        } else if (closeableC != null) {
                            closeableC = l0.this.c(closeableC);
                        }
                    }
                    if (closeableC != null) {
                        if (f > 0.0f) {
                            lVar.a(f);
                        }
                        lVar.b(closeableC, i);
                        b(closeableC);
                    }
                }
                x0Var.f(new m0(this, pairCreate));
                return true;
            }
        }

        public final void b(Closeable closeable) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        public final synchronized boolean c() {
            Iterator<Pair<l<T>, x0>> it = this.f623b.iterator();
            while (it.hasNext()) {
                if (((x0) it.next().second).p()) {
                    return true;
                }
            }
            return false;
        }

        public final synchronized boolean d() {
            Iterator<Pair<l<T>, x0>> it = this.f623b.iterator();
            while (it.hasNext()) {
                if (!((x0) it.next().second).k()) {
                    return false;
                }
            }
            return true;
        }

        public final synchronized b.f.j.d.d e() {
            b.f.j.d.d dVar;
            dVar = b.f.j.d.d.LOW;
            Iterator<Pair<l<T>, x0>> it = this.f623b.iterator();
            while (it.hasNext()) {
                b.f.j.d.d dVarC = ((x0) it.next().second).c();
                if (dVar.ordinal() <= dVarC.ordinal()) {
                    dVar = dVarC;
                }
            }
            return dVar;
        }

        public void f(l0<K, T>.b.a aVar, Throwable th) {
            synchronized (this) {
                if (this.g != aVar) {
                    return;
                }
                this.f623b.clear();
                l0.this.e(this.a, this);
                b(this.c);
                this.c = null;
                for (Pair<l<T>, x0> pair : this.f623b) {
                    synchronized (pair) {
                        ((x0) pair.second).o().k((x0) pair.second, l0.this.d, th, null);
                        ((l) pair.first).c(th);
                    }
                }
            }
        }

        public void g(l0<K, T>.b.a aVar, T t, int i) {
            synchronized (this) {
                if (this.g != aVar) {
                    return;
                }
                b(this.c);
                this.c = null;
                int size = this.f623b.size();
                if (b.f.j.p.b.f(i)) {
                    this.c = (T) l0.this.c(t);
                    this.e = i;
                } else {
                    this.f623b.clear();
                    l0.this.e(this.a, this);
                }
                for (Pair<l<T>, x0> pair : this.f623b) {
                    synchronized (pair) {
                        if (b.f.j.p.b.e(i)) {
                            ((x0) pair.second).o().j((x0) pair.second, l0.this.d, null);
                            d dVar = this.f;
                            if (dVar != null) {
                                ((x0) pair.second).j(dVar.h);
                            }
                            ((x0) pair.second).d(l0.this.e, Integer.valueOf(size));
                        }
                        ((l) pair.first).b(t, i);
                    }
                }
            }
        }

        public void h(l0<K, T>.b.a aVar, float f) {
            synchronized (this) {
                if (this.g != aVar) {
                    return;
                }
                this.d = f;
                for (Pair<l<T>, x0> pair : this.f623b) {
                    synchronized (pair) {
                        ((l) pair.first).a(f);
                    }
                }
            }
        }

        public final void i(b.f.d.l.a aVar) {
            synchronized (this) {
                boolean z2 = true;
                b.c.a.a0.d.i(Boolean.valueOf(this.f == null));
                b.c.a.a0.d.i(Boolean.valueOf(this.g == null));
                if (this.f623b.isEmpty()) {
                    l0.this.e(this.a, this);
                    return;
                }
                x0 x0Var = (x0) this.f623b.iterator().next().second;
                d dVar = new d(x0Var.e(), x0Var.getId(), null, x0Var.o(), x0Var.b(), x0Var.q(), d(), c(), e(), x0Var.g());
                this.f = dVar;
                dVar.j(x0Var.a());
                Objects.requireNonNull(aVar);
                if (aVar != b.f.d.l.a.UNSET) {
                    d dVar2 = this.f;
                    int iOrdinal = aVar.ordinal();
                    if (iOrdinal != 0) {
                        if (iOrdinal != 1) {
                            if (iOrdinal == 2) {
                                throw new IllegalStateException("No boolean equivalent for UNSET");
                            }
                            throw new IllegalStateException("Unrecognized TriState value: " + aVar);
                        }
                        z2 = false;
                    }
                    dVar2.d("started_as_prefetch", Boolean.valueOf(z2));
                }
                l0<K, T>.b.a aVar2 = new a(null);
                this.g = aVar2;
                l0.this.f622b.b(aVar2, this.f);
            }
        }

        public final synchronized List<y0> j() {
            d dVar = this.f;
            ArrayList arrayList = null;
            if (dVar == null) {
                return null;
            }
            boolean zC = c();
            synchronized (dVar) {
                if (zC != dVar.k) {
                    dVar.k = zC;
                    arrayList = new ArrayList(dVar.m);
                }
            }
            return arrayList;
        }

        public final synchronized List<y0> k() {
            d dVar = this.f;
            ArrayList arrayList = null;
            if (dVar == null) {
                return null;
            }
            boolean zD = d();
            synchronized (dVar) {
                if (zD != dVar.i) {
                    dVar.i = zD;
                    arrayList = new ArrayList(dVar.m);
                }
            }
            return arrayList;
        }

        public final synchronized List<y0> l() {
            d dVar = this.f;
            if (dVar == null) {
                return null;
            }
            return dVar.v(e());
        }
    }

    public l0(w0<T> w0Var, String str, String str2) {
        this.f622b = w0Var;
        this.a = new HashMap();
        this.c = false;
        this.d = str;
        this.e = str2;
    }

    @Override // b.f.j.p.w0
    public void b(l<T> lVar, x0 x0Var) {
        boolean z2;
        l0<K, T>.b bVar;
        try {
            b.f.j.r.b.b();
            x0Var.o().e(x0Var, this.d);
            K kD = d(x0Var);
            do {
                z2 = false;
                synchronized (this) {
                    synchronized (this) {
                        bVar = this.a.get(kD);
                    }
                }
                if (bVar == null) {
                    synchronized (this) {
                        bVar = new b(kD);
                        this.a.put(kD, bVar);
                        z2 = true;
                    }
                }
            } while (!bVar.a(lVar, x0Var));
            if (z2) {
                bVar.i(b.f.d.l.a.f(x0Var.k()));
            }
        } finally {
            b.f.j.r.b.b();
        }
    }

    public abstract T c(T t);

    public abstract K d(x0 x0Var);

    public synchronized void e(K k, l0<K, T>.b bVar) {
        if (this.a.get(k) == bVar) {
            this.a.remove(k);
        }
    }

    public l0(w0<T> w0Var, String str, String str2, boolean z2) {
        this.f622b = w0Var;
        this.a = new HashMap();
        this.c = z2;
        this.d = str;
        this.e = str2;
    }
}
