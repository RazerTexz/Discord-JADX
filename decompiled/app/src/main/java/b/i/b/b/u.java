package b.i.b.b;

import b.i.b.a.g;
import b.i.b.b.v;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* compiled from: MapMaker.java */
/* loaded from: classes3.dex */
public final class u {
    public boolean a;

    /* renamed from: b, reason: collision with root package name */
    public int f1649b = -1;
    public int c = -1;

    @MonotonicNonNullDecl
    public v.p d;

    @MonotonicNonNullDecl
    public v.p e;

    @MonotonicNonNullDecl
    public b.i.b.a.d<Object> f;

    public v.p a() {
        return (v.p) b.i.a.f.e.o.f.W(this.d, v.p.j);
    }

    public v.p b() {
        return (v.p) b.i.a.f.e.o.f.W(this.e, v.p.j);
    }

    public <K, V> ConcurrentMap<K, V> c() {
        if (!this.a) {
            int i = this.f1649b;
            if (i == -1) {
                i = 16;
            }
            int i2 = this.c;
            if (i2 == -1) {
                i2 = 4;
            }
            return new ConcurrentHashMap(i, 0.75f, i2);
        }
        v.b0<Object, Object, v.e> b0Var = v.j;
        v.p pVar = v.p.k;
        v.p pVarA = a();
        v.p pVar2 = v.p.j;
        if (pVarA == pVar2 && b() == pVar2) {
            return new v(this, v.q.a.a);
        }
        if (a() == pVar2 && b() == pVar) {
            return new v(this, v.s.a.a);
        }
        if (a() == pVar && b() == pVar2) {
            return new v(this, v.w.a.a);
        }
        if (a() == pVar && b() == pVar) {
            return new v(this, v.y.a.a);
        }
        throw new AssertionError();
    }

    public u d(v.p pVar) {
        v.p pVar2 = this.d;
        b.i.a.f.e.o.f.G(pVar2 == null, "Key strength was already set to %s", pVar2);
        Objects.requireNonNull(pVar);
        this.d = pVar;
        if (pVar != v.p.j) {
            this.a = true;
        }
        return this;
    }

    public String toString() {
        b.i.b.a.g gVar = new b.i.b.a.g(u.class.getSimpleName(), null);
        int i = this.f1649b;
        if (i != -1) {
            gVar.a("initialCapacity", i);
        }
        int i2 = this.c;
        if (i2 != -1) {
            gVar.a("concurrencyLevel", i2);
        }
        v.p pVar = this.d;
        if (pVar != null) {
            String strU1 = b.i.a.f.e.o.f.u1(pVar.toString());
            g.a aVar = new g.a(null);
            gVar.c.c = aVar;
            gVar.c = aVar;
            aVar.f1644b = strU1;
            aVar.a = "keyStrength";
        }
        v.p pVar2 = this.e;
        if (pVar2 != null) {
            String strU12 = b.i.a.f.e.o.f.u1(pVar2.toString());
            g.a aVar2 = new g.a(null);
            gVar.c.c = aVar2;
            gVar.c = aVar2;
            aVar2.f1644b = strU12;
            aVar2.a = "valueStrength";
        }
        if (this.f != null) {
            g.a aVar3 = new g.a(null);
            gVar.c.c = aVar3;
            gVar.c = aVar3;
            aVar3.f1644b = "keyEquivalence";
        }
        return gVar.toString();
    }
}
