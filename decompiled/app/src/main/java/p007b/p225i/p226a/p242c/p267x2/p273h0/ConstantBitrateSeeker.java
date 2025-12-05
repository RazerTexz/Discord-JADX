package p007b.p225i.p226a.p242c.p267x2.p273h0;

import p007b.p225i.p226a.p242c.p263t2.MpegAudioUtil;
import p007b.p225i.p226a.p242c.p267x2.ConstantBitrateSeekMap;

/* compiled from: ConstantBitrateSeeker.java */
/* renamed from: b.i.a.c.x2.h0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class ConstantBitrateSeeker extends ConstantBitrateSeekMap implements Seeker {
    public ConstantBitrateSeeker(long j, long j2, MpegAudioUtil.a aVar, boolean z2) {
        super(j, j2, aVar.f7682f, aVar.f7679c, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: a */
    public long mo3689a() {
        return -1L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p273h0.Seeker
    /* renamed from: d */
    public long mo3690d(long j) {
        return ConstantBitrateSeekMap.m3638e(j, this.f8089b, this.f8092e);
    }
}
