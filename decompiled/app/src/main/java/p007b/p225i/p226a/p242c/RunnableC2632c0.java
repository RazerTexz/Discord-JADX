package p007b.p225i.p226a.p242c;

import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.ExoPlayerImplInternal2;

/* compiled from: lambda */
/* renamed from: b.i.a.c.c0 */
/* loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2632c0 implements Runnable {

    /* renamed from: j */
    public final /* synthetic */ ExoPlayerImpl f6165j;

    /* renamed from: k */
    public final /* synthetic */ ExoPlayerImplInternal2.d f6166k;

    public /* synthetic */ RunnableC2632c0(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal2.d dVar) {
        this.f6165j = exoPlayerImpl;
        this.f6166k = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        long j;
        boolean z2;
        long jM2913m0;
        ExoPlayerImpl exoPlayerImpl = this.f6165j;
        ExoPlayerImplInternal2.d dVar = this.f6166k;
        int i = exoPlayerImpl.f6681x - dVar.f7103c;
        exoPlayerImpl.f6681x = i;
        boolean z3 = true;
        if (dVar.f7104d) {
            exoPlayerImpl.f6682y = dVar.f7105e;
            exoPlayerImpl.f6683z = true;
        }
        if (dVar.f7106f) {
            exoPlayerImpl.f6652A = dVar.f7107g;
        }
        if (i == 0) {
            Timeline timeline = dVar.f7102b.f7947b;
            if (!exoPlayerImpl.f6657F.f7947b.m3331q() && timeline.m3331q()) {
                exoPlayerImpl.f6658G = -1;
                exoPlayerImpl.f6659H = 0L;
            }
            if (!timeline.m3331q()) {
                List listAsList = Arrays.asList(((PlaylistTimeline) timeline).f6174r);
                AnimatableValueParser.m426D(listAsList.size() == exoPlayerImpl.f6670m.size());
                for (int i2 = 0; i2 < listAsList.size(); i2++) {
                    exoPlayerImpl.f6670m.get(i2).f6685b = (Timeline) listAsList.get(i2);
                }
            }
            long j2 = -9223372036854775807L;
            if (exoPlayerImpl.f6683z) {
                if (dVar.f7102b.f7948c.equals(exoPlayerImpl.f6657F.f7948c) && dVar.f7102b.f7950e == exoPlayerImpl.f6657F.f7965t) {
                    z3 = false;
                }
                if (z3) {
                    if (timeline.m3331q() || dVar.f7102b.f7948c.m2593a()) {
                        jM2913m0 = dVar.f7102b.f7950e;
                    } else {
                        PlaybackInfo playbackInfo = dVar.f7102b;
                        jM2913m0 = exoPlayerImpl.m2913m0(timeline, playbackInfo.f7948c, playbackInfo.f7950e);
                    }
                    j2 = jM2913m0;
                }
                j = j2;
                z2 = z3;
            } else {
                j = -9223372036854775807L;
                z2 = false;
            }
            exoPlayerImpl.f6683z = false;
            exoPlayerImpl.m2924s0(dVar.f7102b, 1, exoPlayerImpl.f6652A, false, z2, exoPlayerImpl.f6682y, j, -1);
        }
    }
}
