package b.i.a.c;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.b0;
import b.i.a.c.a3.k0;
import b.i.a.c.w2.s;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/* compiled from: MediaSourceList.java */
/* loaded from: classes3.dex */
public final class u1 {
    public final d d;
    public final b0.a e;
    public final s.a f;
    public final HashMap<c, b> g;
    public final Set<c> h;
    public boolean j;

    @Nullable
    public b.i.a.c.e3.a0 k;
    public b.i.a.c.a3.k0 i = new k0.a(0, new Random());

    /* renamed from: b, reason: collision with root package name */
    public final IdentityHashMap<b.i.a.c.a3.x, c> f1137b = new IdentityHashMap<>();
    public final Map<Object, c> c = new HashMap();
    public final List<c> a = new ArrayList();

    /* compiled from: MediaSourceList.java */
    public final class a implements b.i.a.c.a3.b0, b.i.a.c.w2.s {
        public final c j;
        public b0.a k;
        public s.a l;

        public a(c cVar) {
            this.k = u1.this.e;
            this.l = u1.this.f;
            this.j = cVar;
        }

        @Override // b.i.a.c.w2.s
        public void J(int i, @Nullable a0.a aVar) {
            if (a(i, aVar)) {
                this.l.b();
            }
        }

        @Override // b.i.a.c.w2.s
        public void S(int i, @Nullable a0.a aVar) {
            if (a(i, aVar)) {
                this.l.a();
            }
        }

        @Override // b.i.a.c.a3.b0
        public void X(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
            if (a(i, aVar)) {
                this.k.d(tVar, wVar);
            }
        }

        public final boolean a(int i, @Nullable a0.a aVar) {
            a0.a aVarB = null;
            if (aVar != null) {
                c cVar = this.j;
                int i2 = 0;
                while (true) {
                    if (i2 >= cVar.c.size()) {
                        break;
                    }
                    if (cVar.c.get(i2).d == aVar.d) {
                        aVarB = aVar.b(Pair.create(cVar.f1139b, aVar.a));
                        break;
                    }
                    i2++;
                }
                if (aVarB == null) {
                    return false;
                }
            }
            int i3 = i + this.j.d;
            b0.a aVar2 = this.k;
            if (aVar2.a != i3 || !b.i.a.c.f3.e0.a(aVar2.f807b, aVarB)) {
                this.k = u1.this.e.g(i3, aVarB, 0L);
            }
            s.a aVar3 = this.l;
            if (aVar3.a == i3 && b.i.a.c.f3.e0.a(aVar3.f1156b, aVarB)) {
                return true;
            }
            this.l = u1.this.f.g(i3, aVarB);
            return true;
        }

        @Override // b.i.a.c.w2.s
        public void c0(int i, @Nullable a0.a aVar, int i2) {
            if (a(i, aVar)) {
                this.l.d(i2);
            }
        }

        @Override // b.i.a.c.w2.s
        public void d0(int i, @Nullable a0.a aVar) {
            if (a(i, aVar)) {
                this.l.f();
            }
        }

        @Override // b.i.a.c.a3.b0
        public void g0(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar, IOException iOException, boolean z2) {
            if (a(i, aVar)) {
                this.k.e(tVar, wVar, iOException, z2);
            }
        }

        @Override // b.i.a.c.w2.s
        public void i0(int i, @Nullable a0.a aVar) {
            if (a(i, aVar)) {
                this.l.c();
            }
        }

        @Override // b.i.a.c.a3.b0
        public void o(int i, @Nullable a0.a aVar, b.i.a.c.a3.w wVar) {
            if (a(i, aVar)) {
                this.k.b(wVar);
            }
        }

        @Override // b.i.a.c.a3.b0
        public void q(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
            if (a(i, aVar)) {
                this.k.c(tVar, wVar);
            }
        }

        @Override // b.i.a.c.w2.s
        public void u(int i, @Nullable a0.a aVar, Exception exc) {
            if (a(i, aVar)) {
                this.l.e(exc);
            }
        }

        @Override // b.i.a.c.a3.b0
        public void x(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
            if (a(i, aVar)) {
                this.k.f(tVar, wVar);
            }
        }
    }

    /* compiled from: MediaSourceList.java */
    public static final class b {
        public final b.i.a.c.a3.a0 a;

        /* renamed from: b, reason: collision with root package name */
        public final a0.b f1138b;
        public final a c;

        public b(b.i.a.c.a3.a0 a0Var, a0.b bVar, a aVar) {
            this.a = a0Var;
            this.f1138b = bVar;
            this.c = aVar;
        }
    }

    /* compiled from: MediaSourceList.java */
    public static final class c implements t1 {
        public final b.i.a.c.a3.v a;
        public int d;
        public boolean e;
        public final List<a0.a> c = new ArrayList();

        /* renamed from: b, reason: collision with root package name */
        public final Object f1139b = new Object();

        public c(b.i.a.c.a3.a0 a0Var, boolean z2) {
            this.a = new b.i.a.c.a3.v(a0Var, z2);
        }

        @Override // b.i.a.c.t1
        public o2 a() {
            return this.a.n;
        }

        @Override // b.i.a.c.t1
        public Object getUid() {
            return this.f1139b;
        }
    }

    /* compiled from: MediaSourceList.java */
    public interface d {
    }

    public u1(d dVar, @Nullable b.i.a.c.s2.g1 g1Var, Handler handler) {
        this.d = dVar;
        b0.a aVar = new b0.a();
        this.e = aVar;
        s.a aVar2 = new s.a();
        this.f = aVar2;
        this.g = new HashMap<>();
        this.h = new HashSet();
        if (g1Var != null) {
            aVar.c.add(new b0.a.C0092a(handler, g1Var));
            aVar2.c.add(new s.a.C0101a(handler, g1Var));
        }
    }

    public o2 a(int i, List<c> list, b.i.a.c.a3.k0 k0Var) {
        if (!list.isEmpty()) {
            this.i = k0Var;
            for (int i2 = i; i2 < list.size() + i; i2++) {
                c cVar = list.get(i2 - i);
                if (i2 > 0) {
                    c cVar2 = this.a.get(i2 - 1);
                    cVar.d = cVar2.a.n.p() + cVar2.d;
                    cVar.e = false;
                    cVar.c.clear();
                } else {
                    cVar.d = 0;
                    cVar.e = false;
                    cVar.c.clear();
                }
                b(i2, cVar.a.n.p());
                this.a.add(i2, cVar);
                this.c.put(cVar.f1139b, cVar);
                if (this.j) {
                    g(cVar);
                    if (this.f1137b.isEmpty()) {
                        this.h.add(cVar);
                    } else {
                        b bVar = this.g.get(cVar);
                        if (bVar != null) {
                            bVar.a.d(bVar.f1138b);
                        }
                    }
                }
            }
        }
        return c();
    }

    public final void b(int i, int i2) {
        while (i < this.a.size()) {
            this.a.get(i).d += i2;
            i++;
        }
    }

    public o2 c() {
        if (this.a.isEmpty()) {
            return o2.j;
        }
        int iP = 0;
        for (int i = 0; i < this.a.size(); i++) {
            c cVar = this.a.get(i);
            cVar.d = iP;
            iP += cVar.a.n.p();
        }
        return new c2(this.a, this.i);
    }

    public final void d() {
        Iterator<c> it = this.h.iterator();
        while (it.hasNext()) {
            c next = it.next();
            if (next.c.isEmpty()) {
                b bVar = this.g.get(next);
                if (bVar != null) {
                    bVar.a.d(bVar.f1138b);
                }
                it.remove();
            }
        }
    }

    public int e() {
        return this.a.size();
    }

    public final void f(c cVar) {
        if (cVar.e && cVar.c.isEmpty()) {
            b bVarRemove = this.g.remove(cVar);
            Objects.requireNonNull(bVarRemove);
            bVarRemove.a.a(bVarRemove.f1138b);
            bVarRemove.a.c(bVarRemove.c);
            bVarRemove.a.g(bVarRemove.c);
            this.h.remove(cVar);
        }
    }

    public final void g(c cVar) {
        b.i.a.c.a3.v vVar = cVar.a;
        n0 n0Var = new n0(this);
        a aVar = new a(cVar);
        this.g.put(cVar, new b(vVar, n0Var, aVar));
        Handler handler = new Handler(b.i.a.c.f3.e0.o(), null);
        Objects.requireNonNull(vVar);
        b0.a aVar2 = vVar.c;
        Objects.requireNonNull(aVar2);
        aVar2.c.add(new b0.a.C0092a(handler, aVar));
        Handler handler2 = new Handler(b.i.a.c.f3.e0.o(), null);
        s.a aVar3 = vVar.d;
        Objects.requireNonNull(aVar3);
        aVar3.c.add(new s.a.C0101a(handler2, aVar));
        vVar.l(n0Var, this.k);
    }

    public void h(b.i.a.c.a3.x xVar) {
        c cVarRemove = this.f1137b.remove(xVar);
        Objects.requireNonNull(cVarRemove);
        cVarRemove.a.j(xVar);
        cVarRemove.c.remove(((b.i.a.c.a3.u) xVar).j);
        if (!this.f1137b.isEmpty()) {
            d();
        }
        f(cVarRemove);
    }

    public final void i(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            c cVarRemove = this.a.remove(i3);
            this.c.remove(cVarRemove.f1139b);
            b(i3, -cVarRemove.a.n.p());
            cVarRemove.e = true;
            if (this.j) {
                f(cVarRemove);
            }
        }
    }
}
