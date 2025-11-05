package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0;
import b.i.a.c.a3.b0;
import b.i.a.c.a3.v;
import b.i.a.c.w2.s;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: CompositeMediaSource.java */
/* loaded from: classes3.dex */
public abstract class o<T> extends l {
    public final HashMap<T, b<T>> g = new HashMap<>();

    @Nullable
    public Handler h;

    @Nullable
    public b.i.a.c.e3.a0 i;

    /* compiled from: CompositeMediaSource.java */
    public final class a implements b0, b.i.a.c.w2.s {
        public final T j;
        public b0.a k;
        public s.a l;

        public a(T t) {
            this.k = o.this.c.g(0, null, 0L);
            this.l = o.this.d.g(0, null);
            this.j = t;
        }

        @Override // b.i.a.c.w2.s
        public void J(int i, @Nullable a0.a aVar) {
            a(i, aVar);
            this.l.b();
        }

        @Override // b.i.a.c.w2.s
        public void S(int i, @Nullable a0.a aVar) {
            a(i, aVar);
            this.l.a();
        }

        @Override // b.i.a.c.a3.b0
        public void X(int i, @Nullable a0.a aVar, t tVar, w wVar) {
            a(i, aVar);
            this.k.d(tVar, b(wVar));
        }

        public final boolean a(int i, @Nullable a0.a aVar) {
            a0.a aVarB;
            if (aVar != null) {
                o oVar = o.this;
                T t = this.j;
                v vVar = (v) oVar;
                Objects.requireNonNull(vVar);
                Object obj = aVar.a;
                Object obj2 = vVar.n.n;
                if (obj2 != null && obj2.equals(obj)) {
                    obj = v.a.l;
                }
                aVarB = aVar.b(obj);
            } else {
                aVarB = null;
            }
            Objects.requireNonNull(o.this);
            b0.a aVar2 = this.k;
            if (aVar2.a != i || !b.i.a.c.f3.e0.a(aVar2.f807b, aVarB)) {
                this.k = o.this.c.g(i, aVarB, 0L);
            }
            s.a aVar3 = this.l;
            if (aVar3.a == i && b.i.a.c.f3.e0.a(aVar3.f1156b, aVarB)) {
                return true;
            }
            this.l = new s.a(o.this.d.c, i, aVarB);
            return true;
        }

        public final w b(w wVar) {
            o oVar = o.this;
            long j = wVar.f;
            Objects.requireNonNull(oVar);
            o oVar2 = o.this;
            long j2 = wVar.g;
            Objects.requireNonNull(oVar2);
            return (j == wVar.f && j2 == wVar.g) ? wVar : new w(wVar.a, wVar.f834b, wVar.c, wVar.d, wVar.e, j, j2);
        }

        @Override // b.i.a.c.w2.s
        public void c0(int i, @Nullable a0.a aVar, int i2) {
            a(i, aVar);
            this.l.d(i2);
        }

        @Override // b.i.a.c.w2.s
        public void d0(int i, @Nullable a0.a aVar) {
            a(i, aVar);
            this.l.f();
        }

        @Override // b.i.a.c.a3.b0
        public void g0(int i, @Nullable a0.a aVar, t tVar, w wVar, IOException iOException, boolean z2) {
            a(i, aVar);
            this.k.e(tVar, b(wVar), iOException, z2);
        }

        @Override // b.i.a.c.w2.s
        public void i0(int i, @Nullable a0.a aVar) {
            a(i, aVar);
            this.l.c();
        }

        @Override // b.i.a.c.a3.b0
        public void o(int i, @Nullable a0.a aVar, w wVar) {
            a(i, aVar);
            this.k.b(b(wVar));
        }

        @Override // b.i.a.c.a3.b0
        public void q(int i, @Nullable a0.a aVar, t tVar, w wVar) {
            a(i, aVar);
            this.k.c(tVar, b(wVar));
        }

        @Override // b.i.a.c.w2.s
        public void u(int i, @Nullable a0.a aVar, Exception exc) {
            a(i, aVar);
            this.l.e(exc);
        }

        @Override // b.i.a.c.a3.b0
        public void x(int i, @Nullable a0.a aVar, t tVar, w wVar) {
            a(i, aVar);
            this.k.f(tVar, b(wVar));
        }
    }

    /* compiled from: CompositeMediaSource.java */
    public static final class b<T> {
        public final a0 a;

        /* renamed from: b, reason: collision with root package name */
        public final a0.b f831b;
        public final o<T>.a c;

        public b(a0 a0Var, a0.b bVar, o<T>.a aVar) {
            this.a = a0Var;
            this.f831b = bVar;
            this.c = aVar;
        }
    }

    @Override // b.i.a.c.a3.l
    @CallSuper
    public void o() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.d(bVar.f831b);
        }
    }

    @Override // b.i.a.c.a3.l
    @CallSuper
    public void p() {
        for (b<T> bVar : this.g.values()) {
            bVar.a.m(bVar.f831b);
        }
    }

    public final void t(T t, a0 a0Var) {
        b.c.a.a0.d.j(!this.g.containsKey(null));
        a0.b aVar = new b.i.a.c.a3.a(this, null);
        a aVar2 = new a(null);
        this.g.put(null, new b<>(a0Var, aVar, aVar2));
        Handler handler = this.h;
        Objects.requireNonNull(handler);
        a0Var.b(handler, aVar2);
        Handler handler2 = this.h;
        Objects.requireNonNull(handler2);
        a0Var.f(handler2, aVar2);
        a0Var.l(aVar, this.i);
        if (!this.f827b.isEmpty()) {
            return;
        }
        a0Var.d(aVar);
    }
}
