package b.m.a.g.d;

import b.m.a.g.d.e;
import d0.z.d.m;

/* compiled from: SntpResponseCache.kt */
/* loaded from: classes3.dex */
public final class g implements f {
    public final b.m.a.f a;

    /* renamed from: b, reason: collision with root package name */
    public final b.m.a.b f1908b;

    public g(b.m.a.f fVar, b.m.a.b bVar) {
        m.checkParameterIsNotNull(fVar, "syncResponseCache");
        m.checkParameterIsNotNull(bVar, "deviceClock");
        this.a = fVar;
        this.f1908b = bVar;
    }

    @Override // b.m.a.g.d.f
    public void a(e.b bVar) {
        m.checkParameterIsNotNull(bVar, "response");
        this.a.f(bVar.a);
        this.a.a(bVar.f1907b);
        this.a.b(bVar.c);
    }

    @Override // b.m.a.g.d.f
    public void clear() {
        this.a.clear();
    }

    @Override // b.m.a.g.d.f
    public e.b get() {
        long jE = this.a.e();
        long jC = this.a.c();
        long jD = this.a.d();
        if (jC == 0) {
            return null;
        }
        return new e.b(jE, jC, jD, this.f1908b);
    }
}
