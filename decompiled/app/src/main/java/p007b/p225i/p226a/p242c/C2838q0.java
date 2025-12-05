package p007b.p225i.p226a.p242c;

import android.os.Bundle;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.Timeline;

/* compiled from: lambda */
/* renamed from: b.i.a.c.q0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class C2838q0 implements Bundleable.a {

    /* renamed from: a */
    public static final /* synthetic */ C2838q0 f7441a = new C2838q0();

    @Override // p007b.p225i.p226a.p242c.Bundleable.a
    /* renamed from: a */
    public final Bundleable mo2576a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(Timeline.c.m3338d(1));
        MediaItem2 mediaItem2 = bundle2 != null ? (MediaItem2) MediaItem2.f7261j.mo2576a(bundle2) : null;
        long j = bundle.getLong(Timeline.c.m3338d(2), -9223372036854775807L);
        long j2 = bundle.getLong(Timeline.c.m3338d(3), -9223372036854775807L);
        long j3 = bundle.getLong(Timeline.c.m3338d(4), -9223372036854775807L);
        boolean z2 = bundle.getBoolean(Timeline.c.m3338d(5), false);
        boolean z3 = bundle.getBoolean(Timeline.c.m3338d(6), false);
        Bundle bundle3 = bundle.getBundle(Timeline.c.m3338d(7));
        MediaItem2.g gVar = bundle3 != null ? (MediaItem2.g) MediaItem2.g.f7307k.mo2576a(bundle3) : null;
        boolean z4 = bundle.getBoolean(Timeline.c.m3338d(8), false);
        long j4 = bundle.getLong(Timeline.c.m3338d(9), 0L);
        long j5 = bundle.getLong(Timeline.c.m3338d(10), -9223372036854775807L);
        int i = bundle.getInt(Timeline.c.m3338d(11), 0);
        int i2 = bundle.getInt(Timeline.c.m3338d(12), 0);
        long j6 = bundle.getLong(Timeline.c.m3338d(13), 0L);
        Timeline.c cVar = new Timeline.c();
        cVar.m3342e(Timeline.c.f7346k, mediaItem2, null, j, j2, j3, z2, z3, gVar, j4, j5, i, i2, j6);
        cVar.f7364y = z4;
        return cVar;
    }
}
