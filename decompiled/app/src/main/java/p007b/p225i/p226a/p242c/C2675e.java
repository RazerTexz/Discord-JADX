package p007b.p225i.p226a.p242c;

import android.content.Context;
import p007b.p225i.p226a.p242c.p257e3.DefaultBandwidthMeter;
import p007b.p225i.p355b.p356a.Supplier2;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.e */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2675e implements Supplier2 {

    /* renamed from: j */
    public final /* synthetic */ Context f6410j;

    public /* synthetic */ C2675e(Context context) {
        this.f6410j = context;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public final Object get() {
        DefaultBandwidthMeter defaultBandwidthMeter;
        Context context = this.f6410j;
        ImmutableList2<Long> immutableList2 = DefaultBandwidthMeter.f6569a;
        synchronized (DefaultBandwidthMeter.class) {
            if (DefaultBandwidthMeter.f6575g == null) {
                DefaultBandwidthMeter.b bVar = new DefaultBandwidthMeter.b(context);
                DefaultBandwidthMeter.f6575g = new DefaultBandwidthMeter(bVar.f6589a, bVar.f6590b, bVar.f6591c, bVar.f6592d, bVar.f6593e, null);
            }
            defaultBandwidthMeter = DefaultBandwidthMeter.f6575g;
        }
        return defaultBandwidthMeter;
    }
}
