package b.m.a.g;

import b.m.a.d;
import b.m.a.g.d.h;
import com.lyft.kronos.KronosClock;
import d0.z.d.m;

/* compiled from: KronosClockImpl.kt */
/* loaded from: classes3.dex */
public final class b implements KronosClock {
    public final h a;

    /* renamed from: b, reason: collision with root package name */
    public final b.m.a.b f1905b;

    public b(h hVar, b.m.a.b bVar) {
        m.checkParameterIsNotNull(hVar, "ntpService");
        m.checkParameterIsNotNull(bVar, "fallbackClock");
        this.a = hVar;
        this.f1905b = bVar;
    }

    @Override // com.lyft.kronos.KronosClock, b.m.a.b
    public long a() {
        return c().a;
    }

    @Override // b.m.a.b
    public long b() {
        return this.f1905b.b();
    }

    public d c() {
        d dVarA = this.a.a();
        return dVarA != null ? dVarA : new d(this.f1905b.a(), null);
    }
}
