package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import p007b.p109f.p115d.p122g.MemoryTrimmableRegistry;
import p007b.p109f.p115d.p122g.NoOpMemoryTrimmableRegistry;
import p007b.p109f.p161j.p183r.FrescoSystrace;

/* compiled from: PoolConfig.java */
/* renamed from: b.f.j.l.w, reason: use source file name */
/* loaded from: classes3.dex */
public class PoolConfig {

    /* renamed from: a */
    public final PoolParams f3958a;

    /* renamed from: b */
    public final PoolStatsTracker f3959b;

    /* renamed from: c */
    public final PoolParams f3960c;

    /* renamed from: d */
    public final MemoryTrimmableRegistry f3961d;

    /* renamed from: e */
    public final PoolParams f3962e;

    /* renamed from: f */
    public final PoolStatsTracker f3963f;

    /* renamed from: g */
    public final PoolParams f3964g;

    /* renamed from: h */
    public final PoolStatsTracker f3965h;

    /* renamed from: i */
    public final String f3966i;

    /* renamed from: j */
    public final int f3967j;

    /* compiled from: PoolConfig.java */
    /* renamed from: b.f.j.l.w$b */
    public static class b {
        public b(a aVar) {
        }
    }

    public PoolConfig(b bVar, a aVar) {
        FrescoSystrace.m1527b();
        this.f3958a = DefaultBitmapPoolParams.m1390a();
        this.f3959b = NoOpPoolStatsTracker.m1398h();
        int i = DefaultFlexByteArrayPoolParams.f3942a;
        int i2 = i * 4194304;
        SparseIntArray sparseIntArray = new SparseIntArray();
        for (int i3 = 131072; i3 <= 4194304; i3 *= 2) {
            sparseIntArray.put(i3, i);
        }
        this.f3960c = new PoolParams(4194304, i2, sparseIntArray, 131072, 4194304, DefaultFlexByteArrayPoolParams.f3942a);
        this.f3961d = NoOpMemoryTrimmableRegistry.m990b();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray2.put(1024, 5);
        sparseIntArray2.put(2048, 5);
        sparseIntArray2.put(4096, 5);
        sparseIntArray2.put(8192, 5);
        sparseIntArray2.put(16384, 5);
        sparseIntArray2.put(32768, 5);
        sparseIntArray2.put(65536, 5);
        sparseIntArray2.put(131072, 5);
        sparseIntArray2.put(262144, 2);
        sparseIntArray2.put(524288, 2);
        sparseIntArray2.put(1048576, 2);
        int iMin = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        int i4 = iMin < 16777216 ? 3145728 : iMin < 33554432 ? 6291456 : 12582912;
        int iMin2 = (int) Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
        this.f3962e = new PoolParams(i4, iMin2 < 16777216 ? iMin2 / 2 : (iMin2 / 4) * 3, sparseIntArray2);
        this.f3963f = NoOpPoolStatsTracker.m1398h();
        SparseIntArray sparseIntArray3 = new SparseIntArray();
        sparseIntArray3.put(16384, 5);
        this.f3964g = new PoolParams(81920, 1048576, sparseIntArray3);
        this.f3965h = NoOpPoolStatsTracker.m1398h();
        this.f3966i = "legacy";
        this.f3967j = 4194304;
        FrescoSystrace.m1527b();
    }
}
