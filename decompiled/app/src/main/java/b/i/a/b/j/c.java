package b.i.a.b.j;

import android.content.Context;
import b.i.a.b.j.g;
import b.i.a.b.j.t.h.q;
import b.i.a.b.j.t.h.r;
import b.i.a.b.j.t.i.a0;
import b.i.a.b.j.t.i.e;
import b.i.a.b.j.t.i.f;
import b.i.a.b.j.t.i.g;
import b.i.a.b.j.t.i.t;
import b.i.a.b.j.t.i.u;
import b.i.a.b.j.v.b;
import b.i.a.b.j.v.c;
import java.util.Objects;
import java.util.concurrent.Executor;

/* compiled from: DaggerTransportRuntimeComponent.java */
/* loaded from: classes3.dex */
public final class c extends o {
    public c0.a.a<Executor> j;
    public c0.a.a<Context> k;
    public c0.a.a l;
    public c0.a.a m;
    public c0.a.a n;
    public c0.a.a<t> o;
    public c0.a.a<b.i.a.b.j.t.h.f> p;
    public c0.a.a<r> q;
    public c0.a.a<b.i.a.b.j.t.c> r;

    /* renamed from: s, reason: collision with root package name */
    public c0.a.a<b.i.a.b.j.t.h.l> f765s;
    public c0.a.a<b.i.a.b.j.t.h.p> t;
    public c0.a.a<n> u;

    public c(Context context, a aVar) {
        c0.a.a aVar2 = g.a.a;
        Object obj = b.i.a.b.j.r.a.a.a;
        this.j = aVar2 instanceof b.i.a.b.j.r.a.a ? aVar2 : new b.i.a.b.j.r.a.a(aVar2);
        Objects.requireNonNull(context, "instance cannot be null");
        b.i.a.b.j.r.a.b bVar = new b.i.a.b.j.r.a.b(context);
        this.k = bVar;
        b.i.a.b.j.v.b bVar2 = b.a.a;
        b.i.a.b.j.v.c cVar = c.a.a;
        b.i.a.b.j.q.j jVar = new b.i.a.b.j.q.j(bVar, bVar2, cVar);
        this.l = jVar;
        c0.a.a lVar = new b.i.a.b.j.q.l(bVar, jVar);
        this.m = lVar instanceof b.i.a.b.j.r.a.a ? lVar : new b.i.a.b.j.r.a.a(lVar);
        a0 a0Var = new a0(this.k, e.a.a, f.a.a);
        this.n = a0Var;
        u uVar = new u(bVar2, cVar, g.a.a, a0Var);
        c0.a.a<t> aVar3 = uVar instanceof b.i.a.b.j.r.a.a ? uVar : new b.i.a.b.j.r.a.a<>(uVar);
        this.o = aVar3;
        b.i.a.b.j.t.f fVar = new b.i.a.b.j.t.f(bVar2);
        this.p = fVar;
        c0.a.a<Context> aVar4 = this.k;
        b.i.a.b.j.t.g gVar = new b.i.a.b.j.t.g(aVar4, aVar3, fVar, cVar);
        this.q = gVar;
        c0.a.a<Executor> aVar5 = this.j;
        c0.a.a aVar6 = this.m;
        b.i.a.b.j.t.d dVar = new b.i.a.b.j.t.d(aVar5, aVar6, gVar, aVar3, aVar3);
        this.r = dVar;
        b.i.a.b.j.t.h.m mVar = new b.i.a.b.j.t.h.m(aVar4, aVar6, aVar3, gVar, aVar5, aVar3, bVar2);
        this.f765s = mVar;
        q qVar = new q(aVar5, aVar3, gVar, aVar3);
        this.t = qVar;
        c0.a.a pVar = new p(bVar2, cVar, dVar, mVar, qVar);
        this.u = pVar instanceof b.i.a.b.j.r.a.a ? pVar : new b.i.a.b.j.r.a.a(pVar);
    }
}
