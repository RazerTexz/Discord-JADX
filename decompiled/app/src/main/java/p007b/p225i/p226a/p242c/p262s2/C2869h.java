package p007b.p225i.p226a.p242c.p262s2;

import android.util.SparseArray;
import java.util.Objects;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.p259f3.FlagSet;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;

/* JADX INFO: renamed from: b.i.a.c.s2.h */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2869h implements ListenerSet.b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ AnalyticsCollector f7562a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Player2 f7563b;

    public /* synthetic */ C2869h(AnalyticsCollector analyticsCollector, Player2 player2) {
        this.f7562a = analyticsCollector;
        this.f7563b = player2;
    }

    @Override // p007b.p225i.p226a.p242c.p259f3.ListenerSet.b
    /* JADX INFO: renamed from: a */
    public final void mo3037a(Object obj, FlagSet flagSet) {
        AnalyticsListener analyticsListener = (AnalyticsListener) obj;
        SparseArray<AnalyticsListener.a> sparseArray = this.f7562a.f7551n;
        SparseArray sparseArray2 = new SparseArray(flagSet.m3031c());
        for (int i = 0; i < flagSet.m3031c(); i++) {
            int iM3030b = flagSet.m3030b(i);
            AnalyticsListener.a aVar = sparseArray.get(iM3030b);
            Objects.requireNonNull(aVar);
            sparseArray2.append(iM3030b, aVar);
        }
        analyticsListener.m3402K();
    }
}
