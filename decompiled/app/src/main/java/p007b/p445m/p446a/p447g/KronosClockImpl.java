package p007b.p445m.p446a.p447g;

import com.lyft.kronos.Clock8;
import p007b.p445m.p446a.Clock5;
import p007b.p445m.p446a.Clock6;
import p007b.p445m.p446a.p447g.p448d.SntpService;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: KronosClockImpl.kt */
/* renamed from: b.m.a.g.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class KronosClockImpl implements Clock8 {

    /* renamed from: a */
    public final SntpService f13646a;

    /* renamed from: b */
    public final Clock5 f13647b;

    public KronosClockImpl(SntpService sntpService, Clock5 clock5) {
        Intrinsics3.checkParameterIsNotNull(sntpService, "ntpService");
        Intrinsics3.checkParameterIsNotNull(clock5, "fallbackClock");
        this.f13646a = sntpService;
        this.f13647b = clock5;
    }

    @Override // com.lyft.kronos.Clock8, p007b.p445m.p446a.Clock5
    /* renamed from: a */
    public long mo7128a() {
        return m7139c().f13644a;
    }

    @Override // p007b.p445m.p446a.Clock5
    /* renamed from: b */
    public long mo7129b() {
        return this.f13647b.mo7129b();
    }

    /* renamed from: c */
    public Clock6 m7139c() {
        Clock6 clock6Mo7150a = this.f13646a.mo7150a();
        return clock6Mo7150a != null ? clock6Mo7150a : new Clock6(this.f13647b.mo7128a(), null);
    }
}
