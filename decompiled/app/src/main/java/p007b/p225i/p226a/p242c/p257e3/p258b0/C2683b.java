package p007b.p225i.p226a.p242c.p257e3.p258b0;

import java.util.Comparator;

/* compiled from: lambda */
/* renamed from: b.i.a.c.e3.b0.b */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2683b implements Comparator {

    /* renamed from: j */
    public static final /* synthetic */ C2683b f6437j = new C2683b();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        CacheSpan cacheSpan = (CacheSpan) obj;
        CacheSpan cacheSpan2 = (CacheSpan) obj2;
        long j = cacheSpan.f6470o;
        long j2 = cacheSpan2.f6470o;
        return j - j2 == 0 ? cacheSpan.m2791f(cacheSpan2) : j < j2 ? -1 : 1;
    }
}
