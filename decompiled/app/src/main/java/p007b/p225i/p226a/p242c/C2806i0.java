package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.MediaItem2;

/* JADX INFO: renamed from: b.i.a.c.i0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C2806i0 implements Bundleable.a {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ C2806i0 f7120a = new C2806i0();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* JADX INFO: renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        MediaItem2.d.a aVar = new MediaItem2.d.a();
        long j = bundle.getLong(MediaItem2.d.m3321a(0), 0L);
        boolean z2 = true;
        AnimatableValueParser.m531j(j >= 0);
        aVar.f7284a = j;
        long j2 = bundle.getLong(MediaItem2.d.m3321a(1), Long.MIN_VALUE);
        if (j2 != Long.MIN_VALUE && j2 < 0) {
            z2 = false;
        }
        AnimatableValueParser.m531j(z2);
        aVar.f7285b = j2;
        aVar.f7286c = bundle.getBoolean(MediaItem2.d.m3321a(2), false);
        aVar.f7287d = bundle.getBoolean(MediaItem2.d.m3321a(3), false);
        aVar.f7288e = bundle.getBoolean(MediaItem2.d.m3321a(4), false);
        return aVar.m3322a();
    }
}
