package p007b.p225i.p226a.p242c.p257e3;

import java.util.Comparator;
import p007b.p225i.p226a.p242c.p257e3.SlidingPercentile;

/* JADX INFO: renamed from: b.i.a.c.e3.c */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2701c implements Comparator {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ C2701c f6520j = new C2701c();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        int i = SlidingPercentile.f6630a;
        return Float.compare(((SlidingPercentile.b) obj).f6640c, ((SlidingPercentile.b) obj2).f6640c);
    }
}
