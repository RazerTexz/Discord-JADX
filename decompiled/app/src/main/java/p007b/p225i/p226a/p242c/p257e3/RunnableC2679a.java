package p007b.p225i.p226a.p242c.p257e3;

import androidx.core.view.PointerIconCompat;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p259f3.ListenerSet;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsListener;
import p007b.p225i.p226a.p242c.p262s2.C2893s0;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* JADX INFO: renamed from: b.i.a.c.e3.a */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2679a implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ BandwidthMeter.a.C13224a.C13225a f6431j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ int f6432k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ long f6433l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ long f6434m;

    public /* synthetic */ RunnableC2679a(BandwidthMeter.a.C13224a.C13225a c13225a, int i, long j, long j2) {
        this.f6431j = c13225a;
        this.f6432k = i;
        this.f6433l = j;
        this.f6434m = j2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MediaSource2.a next;
        MediaSource2.a aVar;
        MediaSource2.a aVar2;
        BandwidthMeter.a.C13224a.C13225a c13225a = this.f6431j;
        int i = this.f6432k;
        long j = this.f6433l;
        long j2 = this.f6434m;
        AnalyticsCollector analyticsCollector = (AnalyticsCollector) c13225a.f6526b;
        AnalyticsCollector.a aVar3 = analyticsCollector.f7550m;
        if (aVar3.f7557b.isEmpty()) {
            aVar2 = null;
        } else {
            ImmutableList2<MediaSource2.a> immutableList2 = aVar3.f7557b;
            if (!(immutableList2 instanceof List)) {
                Iterator<MediaSource2.a> it = immutableList2.iterator();
                do {
                    next = it.next();
                } while (it.hasNext());
                aVar = next;
            } else {
                if (immutableList2.isEmpty()) {
                    throw new NoSuchElementException();
                }
                aVar = immutableList2.get(immutableList2.size() - 1);
            }
            aVar2 = aVar;
        }
        AnalyticsListener.a aVarM3384m0 = analyticsCollector.m3384m0(aVar2);
        C2893s0 c2893s0 = new C2893s0(aVarM3384m0, i, j, j2);
        analyticsCollector.f7551n.put(PointerIconCompat.TYPE_CELL, aVarM3384m0);
        ListenerSet<AnalyticsListener> listenerSet = analyticsCollector.f7552o;
        listenerSet.m3035b(PointerIconCompat.TYPE_CELL, c2893s0);
        listenerSet.m3034a();
    }
}
