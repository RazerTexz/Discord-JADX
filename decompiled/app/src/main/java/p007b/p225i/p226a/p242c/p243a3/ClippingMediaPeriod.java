package p007b.p225i.p226a.p242c.p243a3;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.FormatHolder;
import p007b.p225i.p226a.p242c.SeekParameters;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p259f3.MimeTypes;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.a3.n, reason: use source file name */
/* JADX INFO: compiled from: ClippingMediaPeriod.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ClippingMediaPeriod implements MediaPeriod, MediaPeriod.a {

    /* JADX INFO: renamed from: j */
    public final MediaPeriod f5651j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public MediaPeriod.a f5652k;

    /* JADX INFO: renamed from: l */
    public a[] f5653l = new a[0];

    /* JADX INFO: renamed from: m */
    public long f5654m;

    /* JADX INFO: renamed from: n */
    public long f5655n;

    /* JADX INFO: renamed from: o */
    public long f5656o;

    /* JADX INFO: renamed from: b.i.a.c.a3.n$a */
    /* JADX INFO: compiled from: ClippingMediaPeriod.java */
    public final class a implements SampleStream {

        /* JADX INFO: renamed from: a */
        public final SampleStream f5657a;

        /* JADX INFO: renamed from: b */
        public boolean f5658b;

        public a(SampleStream sampleStream) {
            this.f5657a = sampleStream;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: a */
        public int mo2505a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            if (ClippingMediaPeriod.this.m2564d()) {
                return -3;
            }
            if (this.f5658b) {
                decoderInputBuffer.f7901j = 4;
                return -4;
            }
            int iMo2505a = this.f5657a.mo2505a(formatHolder, decoderInputBuffer, i);
            if (iMo2505a != -5) {
                ClippingMediaPeriod clippingMediaPeriod = ClippingMediaPeriod.this;
                long j = clippingMediaPeriod.f5656o;
                if (j == Long.MIN_VALUE || ((iMo2505a != -4 || decoderInputBuffer.f19780n < j) && !(iMo2505a == -3 && clippingMediaPeriod.mo2493q() == Long.MIN_VALUE && !decoderInputBuffer.f19779m))) {
                    return iMo2505a;
                }
                decoderInputBuffer.mo3856p();
                decoderInputBuffer.f7901j = 4;
                this.f5658b = true;
                return -4;
            }
            Format2 format2 = formatHolder.f7196b;
            Objects.requireNonNull(format2);
            int i2 = format2.f7139M;
            if (i2 != 0 || format2.f7140N != 0) {
                ClippingMediaPeriod clippingMediaPeriod2 = ClippingMediaPeriod.this;
                if (clippingMediaPeriod2.f5655n != 0) {
                    i2 = 0;
                }
                int i3 = clippingMediaPeriod2.f5656o == Long.MIN_VALUE ? format2.f7140N : 0;
                Format2.b bVarM3275a = format2.m3275a();
                bVarM3275a.f7159A = i2;
                bVarM3275a.f7160B = i3;
                formatHolder.f7196b = bVarM3275a.m3277a();
            }
            return -5;
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: b */
        public void mo2506b() throws IOException {
            this.f5657a.mo2506b();
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: c */
        public int mo2507c(long j) {
            if (ClippingMediaPeriod.this.m2564d()) {
                return -3;
            }
            return this.f5657a.mo2507c(j);
        }

        @Override // p007b.p225i.p226a.p242c.p243a3.SampleStream
        /* JADX INFO: renamed from: d */
        public boolean mo2508d() {
            return !ClippingMediaPeriod.this.m2564d() && this.f5657a.mo2508d();
        }
    }

    public ClippingMediaPeriod(MediaPeriod mediaPeriod, boolean z2, long j, long j2) {
        this.f5651j = mediaPeriod;
        this.f5654m = z2 ? j : -9223372036854775807L;
        this.f5655n = j;
        this.f5656o = j2;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.SequenceableLoader.a
    /* JADX INFO: renamed from: a */
    public void mo2542a(SequenceableLoader sequenceableLoader) {
        MediaPeriod.a aVar = this.f5652k;
        Objects.requireNonNull(aVar);
        aVar.mo2542a(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod.a
    /* JADX INFO: renamed from: b */
    public void mo2563b(MediaPeriod mediaPeriod) {
        MediaPeriod.a aVar = this.f5652k;
        Objects.requireNonNull(aVar);
        aVar.mo2563b(this);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: c */
    public long mo2479c() {
        long jMo2479c = this.f5651j.mo2479c();
        if (jMo2479c != Long.MIN_VALUE) {
            long j = this.f5656o;
            if (j == Long.MIN_VALUE || jMo2479c < j) {
                return jMo2479c;
            }
        }
        return Long.MIN_VALUE;
    }

    /* JADX INFO: renamed from: d */
    public boolean m2564d() {
        return this.f5654m != -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: e */
    public void mo2481e() throws IOException {
        this.f5651j.mo2481e();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo2482f(long j) {
        this.f5654m = -9223372036854775807L;
        boolean z2 = false;
        for (a aVar : this.f5653l) {
            if (aVar != null) {
                aVar.f5658b = false;
            }
        }
        long jMo2482f = this.f5651j.mo2482f(j);
        if (jMo2482f == j) {
            z2 = true;
        } else if (jMo2482f >= this.f5655n) {
            long j2 = this.f5656o;
            if (j2 == Long.MIN_VALUE || jMo2482f <= j2) {
            }
        }
        AnimatableValueParser.m426D(z2);
        return jMo2482f;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: g */
    public boolean mo2483g(long j) {
        return this.f5651j.mo2483g(j);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: h */
    public boolean mo2484h() {
        return this.f5651j.mo2484h();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: i */
    public long mo2485i(long j, SeekParameters seekParameters) {
        long j2 = this.f5655n;
        if (j == j2) {
            return j2;
        }
        long jM3001i = Util2.m3001i(seekParameters.f7191c, 0L, j - j2);
        long j3 = seekParameters.f7192d;
        long j4 = this.f5656o;
        long jM3001i2 = Util2.m3001i(j3, 0L, j4 == Long.MIN_VALUE ? RecyclerView.FOREVER_NS : j4 - j);
        if (jM3001i != seekParameters.f7191c || jM3001i2 != seekParameters.f7192d) {
            seekParameters = new SeekParameters(jM3001i, jM3001i2);
        }
        return this.f5651j.mo2485i(j, seekParameters);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: k */
    public long mo2487k() {
        if (m2564d()) {
            long j = this.f5654m;
            this.f5654m = -9223372036854775807L;
            long jMo2487k = mo2487k();
            return jMo2487k != -9223372036854775807L ? jMo2487k : j;
        }
        long jMo2487k2 = this.f5651j.mo2487k();
        if (jMo2487k2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        boolean z2 = true;
        AnimatableValueParser.m426D(jMo2487k2 >= this.f5655n);
        long j2 = this.f5656o;
        if (j2 != Long.MIN_VALUE && jMo2487k2 > j2) {
            z2 = false;
        }
        AnimatableValueParser.m426D(z2);
        return jMo2487k2;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: l */
    public void mo2488l(MediaPeriod.a aVar, long j) {
        this.f5652k = aVar;
        this.f5651j.mo2488l(this, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0088  */
    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: m */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo2489m(ExoTrackSelection2[] exoTrackSelection2Arr, boolean[] zArr, SampleStream[] sampleStreamArr, boolean[] zArr2, long j) {
        long j2;
        boolean z2;
        this.f5653l = new a[sampleStreamArr.length];
        SampleStream[] sampleStreamArr2 = new SampleStream[sampleStreamArr.length];
        int i = 0;
        while (true) {
            SampleStream sampleStream = null;
            if (i >= sampleStreamArr.length) {
                break;
            }
            a[] aVarArr = this.f5653l;
            aVarArr[i] = (a) sampleStreamArr[i];
            if (aVarArr[i] != null) {
                sampleStream = aVarArr[i].f5657a;
            }
            sampleStreamArr2[i] = sampleStream;
            i++;
        }
        long jMo2489m = this.f5651j.mo2489m(exoTrackSelection2Arr, zArr, sampleStreamArr2, zArr2, j);
        boolean z3 = true;
        if (m2564d()) {
            long j3 = this.f5655n;
            if (j != j3) {
                j2 = -9223372036854775807L;
            } else if (j3 != 0) {
                for (ExoTrackSelection2 exoTrackSelection2 : exoTrackSelection2Arr) {
                    if (exoTrackSelection2 != null) {
                        Format2 format2Mo2731h = exoTrackSelection2.mo2731h();
                        if (!MimeTypes.m3043a(format2Mo2731h.f7155w, format2Mo2731h.f7152t)) {
                            z2 = true;
                            break;
                        }
                    }
                }
                z2 = false;
                if (!z2) {
                    j2 = jMo2489m;
                }
            } else {
                z2 = false;
                if (!z2) {
                }
            }
        }
        this.f5654m = j2;
        if (jMo2489m != j) {
            if (jMo2489m >= this.f5655n) {
                long j4 = this.f5656o;
                if (j4 != Long.MIN_VALUE && jMo2489m > j4) {
                    z3 = false;
                }
            }
        }
        AnimatableValueParser.m426D(z3);
        for (int i2 = 0; i2 < sampleStreamArr.length; i2++) {
            if (sampleStreamArr2[i2] == null) {
                this.f5653l[i2] = null;
            } else {
                a[] aVarArr2 = this.f5653l;
                if (aVarArr2[i2] == null || aVarArr2[i2].f5657a != sampleStreamArr2[i2]) {
                    aVarArr2[i2] = new a(sampleStreamArr2[i2]);
                }
            }
            sampleStreamArr[i2] = this.f5653l[i2];
        }
        return jMo2489m;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: n */
    public TrackGroupArray mo2490n() {
        return this.f5651j.mo2490n();
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: q */
    public long mo2493q() {
        long jMo2493q = this.f5651j.mo2493q();
        if (jMo2493q != Long.MIN_VALUE) {
            long j = this.f5656o;
            if (j == Long.MIN_VALUE || jMo2493q < j) {
                return jMo2493q;
            }
        }
        return Long.MIN_VALUE;
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: r */
    public void mo2494r(long j, boolean z2) {
        this.f5651j.mo2494r(j, z2);
    }

    @Override // p007b.p225i.p226a.p242c.p243a3.MediaPeriod
    /* JADX INFO: renamed from: s */
    public void mo2495s(long j) {
        this.f5651j.mo2495s(j);
    }
}
