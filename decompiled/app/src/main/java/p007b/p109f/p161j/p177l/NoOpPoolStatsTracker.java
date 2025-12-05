package p007b.p109f.p161j.p177l;

import com.facebook.imagepipeline.memory.BasePool;

/* compiled from: NoOpPoolStatsTracker.java */
/* renamed from: b.f.j.l.v, reason: use source file name */
/* loaded from: classes3.dex */
public class NoOpPoolStatsTracker implements PoolStatsTracker {

    /* renamed from: a */
    public static NoOpPoolStatsTracker f3957a;

    /* renamed from: h */
    public static synchronized NoOpPoolStatsTracker m1398h() {
        if (f3957a == null) {
            f3957a = new NoOpPoolStatsTracker();
        }
        return f3957a;
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: a */
    public void mo1399a(int i) {
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: b */
    public void mo1400b(int i) {
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: c */
    public void mo1401c(BasePool basePool) {
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: d */
    public void mo1402d() {
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: e */
    public void mo1403e(int i) {
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: f */
    public void mo1404f() {
    }

    @Override // p007b.p109f.p161j.p177l.PoolStatsTracker
    /* renamed from: g */
    public void mo1405g(int i) {
    }
}
