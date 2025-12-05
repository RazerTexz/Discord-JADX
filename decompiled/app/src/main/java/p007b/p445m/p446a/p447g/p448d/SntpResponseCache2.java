package p007b.p445m.p446a.p447g.p448d;

import p007b.p445m.p446a.Clock5;
import p007b.p445m.p446a.SyncResponseCache;
import p007b.p445m.p446a.p447g.p448d.SntpClient;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: SntpResponseCache.kt */
/* renamed from: b.m.a.g.d.g, reason: use source file name */
/* loaded from: classes3.dex */
public final class SntpResponseCache2 implements SntpResponseCache {

    /* renamed from: a */
    public final SyncResponseCache f13656a;

    /* renamed from: b */
    public final Clock5 f13657b;

    public SntpResponseCache2(SyncResponseCache syncResponseCache, Clock5 clock5) {
        Intrinsics3.checkParameterIsNotNull(syncResponseCache, "syncResponseCache");
        Intrinsics3.checkParameterIsNotNull(clock5, "deviceClock");
        this.f13656a = syncResponseCache;
        this.f13657b = clock5;
    }

    @Override // p007b.p445m.p446a.p447g.p448d.SntpResponseCache
    /* renamed from: a */
    public void mo7149a(SntpClient.b bVar) {
        Intrinsics3.checkParameterIsNotNull(bVar, "response");
        this.f13656a.mo7138f(bVar.f13652a);
        this.f13656a.mo7133a(bVar.f13653b);
        this.f13656a.mo7134b(bVar.f13654c);
    }

    @Override // p007b.p445m.p446a.p447g.p448d.SntpResponseCache
    public void clear() {
        this.f13656a.clear();
    }

    @Override // p007b.p445m.p446a.p447g.p448d.SntpResponseCache
    public SntpClient.b get() {
        long jMo7137e = this.f13656a.mo7137e();
        long jMo7135c = this.f13656a.mo7135c();
        long jMo7136d = this.f13656a.mo7136d();
        if (jMo7135c == 0) {
            return null;
        }
        return new SntpClient.b(jMo7137e, jMo7135c, jMo7136d, this.f13657b);
    }
}
