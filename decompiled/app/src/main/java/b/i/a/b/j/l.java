package b.i.a.b.j;

import b.i.a.b.j.a;
import b.i.a.b.j.b;
import b.i.a.b.j.i;
import java.util.HashMap;
import java.util.Objects;

/* compiled from: TransportImpl.java */
/* loaded from: classes3.dex */
public final class l<T> implements b.i.a.b.f<T> {
    public final i a;

    /* renamed from: b, reason: collision with root package name */
    public final String f768b;
    public final b.i.a.b.b c;
    public final b.i.a.b.e<T, byte[]> d;
    public final m e;

    public l(i iVar, String str, b.i.a.b.b bVar, b.i.a.b.e<T, byte[]> eVar, m mVar) {
        this.a = iVar;
        this.f768b = str;
        this.c = bVar;
        this.d = eVar;
        this.e = mVar;
    }

    @Override // b.i.a.b.f
    public void a(b.i.a.b.c<T> cVar) {
        b(cVar, k.a);
    }

    @Override // b.i.a.b.f
    public void b(b.i.a.b.c<T> cVar, b.i.a.b.h hVar) {
        m mVar = this.e;
        i iVar = this.a;
        Objects.requireNonNull(iVar, "Null transportContext");
        Objects.requireNonNull(cVar, "Null event");
        String str = this.f768b;
        Objects.requireNonNull(str, "Null transportName");
        b.i.a.b.e<T, byte[]> eVar = this.d;
        Objects.requireNonNull(eVar, "Null transformer");
        b.i.a.b.b bVar = this.c;
        Objects.requireNonNull(bVar, "Null encoding");
        n nVar = (n) mVar;
        b.i.a.b.j.t.e eVar2 = nVar.d;
        b.i.a.b.d dVarC = cVar.c();
        i.a aVarA = i.a();
        aVarA.b(iVar.b());
        aVarA.c(dVarC);
        b.C0087b c0087b = (b.C0087b) aVarA;
        c0087b.f764b = iVar.c();
        i iVarA = c0087b.a();
        a.b bVar2 = new a.b();
        bVar2.f = new HashMap();
        bVar2.e(nVar.f769b.a());
        bVar2.g(nVar.c.a());
        bVar2.f(str);
        bVar2.d(new e(bVar, eVar.apply(cVar.b())));
        bVar2.f762b = cVar.a();
        eVar2.a(iVarA, bVar2.b(), hVar);
    }
}
