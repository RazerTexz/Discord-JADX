package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Objects;
import p007b.p225i.p226a.p242c.SeekParameters;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: MaskingMediaPeriod.java */
/* renamed from: b.i.a.c.a3.u, reason: use source file name */
/* loaded from: classes3.dex */
public final class MaskingMediaPeriod implements MediaPeriod, MediaPeriod.a {

    /* renamed from: j */
    public final MediaSource2.a f5705j;

    /* renamed from: k */
    public final long f5706k;

    /* renamed from: l */
    public final DefaultAllocator f5707l;

    /* renamed from: m */
    public MediaSource2 f5708m;

    /* renamed from: n */
    public MediaPeriod f5709n;

    /* renamed from: o */
    @Nullable
    public MediaPeriod.a f5710o;

    /* renamed from: p */
    public long f5711p = -9223372036854775807L;

    public MaskingMediaPeriod(MediaSource2.a aVar, DefaultAllocator defaultAllocator, long j) {
        this.f5705j = aVar;
        this.f5707l = defaultAllocator;
        this.f5706k = j;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.SequenceableLoader.a
    /* renamed from: a */
    public void mo2542a(SequenceableLoader sequenceableLoader) {
        MediaPeriod.a aVar = this.f5710o;
        int i = Util2.f6708a;
        aVar.mo2542a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod.a
    /* renamed from: b */
    public void mo2563b(MediaPeriod mediaPeriod) {
        MediaPeriod.a aVar = this.f5710o;
        int i = Util2.f6708a;
        aVar.mo2563b(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: c */
    public long mo2479c() {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2479c();
    }

    /* renamed from: d */
    public void m2590d(MediaSource2.a aVar) {
        long j = this.f5706k;
        long j2 = this.f5711p;
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        MediaSource2 mediaSource2 = this.f5708m;
        Objects.requireNonNull(mediaSource2);
        MediaPeriod mediaPeriodMo2459n = mediaSource2.mo2459n(aVar, this.f5707l, j);
        this.f5709n = mediaPeriodMo2459n;
        if (this.f5710o != null) {
            mediaPeriodMo2459n.mo2488l(this, j);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: e */
    public void mo2481e() throws IOException {
        try {
            MediaPeriod mediaPeriod = this.f5709n;
            if (mediaPeriod != null) {
                mediaPeriod.mo2481e();
                return;
            }
            MediaSource2 mediaSource2 = this.f5708m;
            if (mediaSource2 != null) {
                mediaSource2.mo2453h();
            }
        } catch (IOException e) {
            throw e;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: f */
    public long mo2482f(long j) {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2482f(j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: g */
    public boolean mo2483g(long j) {
        MediaPeriod mediaPeriod = this.f5709n;
        return mediaPeriod != null && mediaPeriod.mo2483g(j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: h */
    public boolean mo2484h() {
        MediaPeriod mediaPeriod = this.f5709n;
        return mediaPeriod != null && mediaPeriod.mo2484h();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: i */
    public long mo2485i(long j, SeekParameters seekParameters) {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2485i(j, seekParameters);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: k */
    public long mo2487k() {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2487k();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: l */
    public void mo2488l(MediaPeriod.a aVar, long j) {
        this.f5710o = aVar;
        MediaPeriod mediaPeriod = this.f5709n;
        if (mediaPeriod != null) {
            long j2 = this.f5706k;
            long j3 = this.f5711p;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            mediaPeriod.mo2488l(this, j2);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: m */
    public long mo2489m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        long j3 = this.f5711p;
        if (j3 == -9223372036854775807L || j != this.f5706k) {
            j2 = j;
        } else {
            this.f5711p = -9223372036854775807L;
            j2 = j3;
        }
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2489m(exoTrackSelection2Arr, zArr, sampleStreamArr, zArr2, j2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: n */
    public TrackGroupArray mo2490n() {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2490n();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: q */
    public long mo2493q() {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        return mediaPeriod.mo2493q();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: r */
    public void mo2494r(long j, boolean z2) {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        mediaPeriod.mo2494r(j, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* renamed from: s */
    public void mo2495s(long j) {
        MediaPeriod mediaPeriod = this.f5709n;
        int i = Util2.f6708a;
        mediaPeriod.mo2495s(j);
    }
}
