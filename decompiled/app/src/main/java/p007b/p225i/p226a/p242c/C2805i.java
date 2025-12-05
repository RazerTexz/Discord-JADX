package p007b.p225i.p226a.p242c;

import java.util.Objects;
import p007b.p225i.p226a.p242c.ExoPlayer2;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p226a.p242c.p262s2.AnalyticsCollector;
import p007b.p225i.p355b.p356a.Supplier2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.i */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2805i implements Supplier2 {

    /* renamed from: j */
    public final /* synthetic */ ExoPlayer2.b f7119j;

    public /* synthetic */ C2805i(ExoPlayer2.b bVar) {
        this.f7119j = bVar;
    }

    @Override // p007b.p225i.p355b.p356a.Supplier2
    public final Object get() {
        Clock4 clock4 = this.f7119j.f6413b;
        Objects.requireNonNull(clock4);
        return new AnalyticsCollector(clock4);
    }
}
