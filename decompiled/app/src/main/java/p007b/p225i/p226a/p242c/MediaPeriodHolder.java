package p007b.p225i.p226a.p242c;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlaybackException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.MediaSourceList;
import p007b.p225i.p226a.p242c.p243a3.ClippingMediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.EmptySampleStream;
import p007b.p225i.p226a.p242c.p243a3.MediaPeriod;
import p007b.p225i.p226a.p242c.p243a3.MediaSource2;
import p007b.p225i.p226a.p242c.p243a3.SampleStream;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p255c3.TrackSelector;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectorResult;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p259f3.Log2;

/* compiled from: MediaPeriodHolder.java */
/* renamed from: b.i.a.c.q1, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaPeriodHolder {

    /* renamed from: a */
    public final MediaPeriod f7442a;

    /* renamed from: b */
    public final Object f7443b;

    /* renamed from: c */
    public final SampleStream[] f7444c;

    /* renamed from: d */
    public boolean f7445d;

    /* renamed from: e */
    public boolean f7446e;

    /* renamed from: f */
    public MediaPeriodInfo f7447f;

    /* renamed from: g */
    public boolean f7448g;

    /* renamed from: h */
    public final boolean[] f7449h;

    /* renamed from: i */
    public final RendererCapabilities[] f7450i;

    /* renamed from: j */
    public final TrackSelector f7451j;

    /* renamed from: k */
    public final MediaSourceList f7452k;

    /* renamed from: l */
    @Nullable
    public MediaPeriodHolder f7453l;

    /* renamed from: m */
    public TrackGroupArray f7454m;

    /* renamed from: n */
    public TrackSelectorResult f7455n;

    /* renamed from: o */
    public long f7456o;

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j, TrackSelector trackSelector, DefaultAllocator defaultAllocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.f7450i = rendererCapabilitiesArr;
        this.f7456o = j;
        this.f7451j = trackSelector;
        this.f7452k = mediaSourceList;
        MediaSource2.a aVar = mediaPeriodInfo.f7465a;
        this.f7443b = aVar.f5732a;
        this.f7447f = mediaPeriodInfo;
        this.f7454m = TrackGroupArray.f5674j;
        this.f7455n = trackSelectorResult;
        this.f7444c = new SampleStream[rendererCapabilitiesArr.length];
        this.f7449h = new boolean[rendererCapabilitiesArr.length];
        long j2 = mediaPeriodInfo.f7466b;
        long j3 = mediaPeriodInfo.f7468d;
        Objects.requireNonNull(mediaSourceList);
        Pair pair = (Pair) aVar.f5732a;
        Object obj = pair.first;
        MediaSource2.a aVarM2460b = aVar.m2460b(pair.second);
        MediaSourceList.c cVar = mediaSourceList.f7866c.get(obj);
        Objects.requireNonNull(cVar);
        mediaSourceList.f7871h.add(cVar);
        MediaSourceList.b bVar = mediaSourceList.f7870g.get(cVar);
        if (bVar != null) {
            bVar.f7879a.mo2458m(bVar.f7880b);
        }
        cVar.f7884c.add(aVarM2460b);
        MediaPeriod mediaPeriodM2591u = cVar.f7882a.m2591u(aVarM2460b, defaultAllocator, j2);
        mediaSourceList.f7865b.put(mediaPeriodM2591u, cVar);
        mediaSourceList.m3538d();
        this.f7442a = j3 != -9223372036854775807L ? new ClippingMediaPeriod(mediaPeriodM2591u, true, 0L, j3) : mediaPeriodM2591u;
    }

    /* renamed from: a */
    public long m3347a(TrackSelectorResult trackSelectorResult, long j, boolean z2, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z3 = true;
            if (i >= trackSelectorResult.f6326a) {
                break;
            }
            boolean[] zArr2 = this.f7449h;
            if (z2 || !trackSelectorResult.m2755a(this.f7455n, i)) {
                z3 = false;
            }
            zArr2[i] = z3;
            i++;
        }
        SampleStream[] sampleStreamArr = this.f7444c;
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f7450i;
            if (i2 >= rendererCapabilitiesArr.length) {
                break;
            }
            if (((BaseRenderer) rendererCapabilitiesArr[i2]).f7889j == -2) {
                sampleStreamArr[i2] = null;
            }
            i2++;
        }
        m3348b();
        this.f7455n = trackSelectorResult;
        m3349c();
        long jMo2489m = this.f7442a.mo2489m(trackSelectorResult.f6328c, this.f7449h, this.f7444c, zArr, j);
        SampleStream[] sampleStreamArr2 = this.f7444c;
        int i3 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr2 = this.f7450i;
            if (i3 >= rendererCapabilitiesArr2.length) {
                break;
            }
            if (((BaseRenderer) rendererCapabilitiesArr2[i3]).f7889j == -2 && this.f7455n.m2756b(i3)) {
                sampleStreamArr2[i3] = new EmptySampleStream();
            }
            i3++;
        }
        this.f7446e = false;
        int i4 = 0;
        while (true) {
            SampleStream[] sampleStreamArr3 = this.f7444c;
            if (i4 >= sampleStreamArr3.length) {
                return jMo2489m;
            }
            if (sampleStreamArr3[i4] != null) {
                AnimatableValueParser.m426D(trackSelectorResult.m2756b(i4));
                if (((BaseRenderer) this.f7450i[i4]).f7889j != -2) {
                    this.f7446e = true;
                }
            } else {
                AnimatableValueParser.m426D(trackSelectorResult.f6328c[i4] == null);
            }
            i4++;
        }
    }

    /* renamed from: b */
    public final void m3348b() {
        if (!m3353g()) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.f7455n;
            if (i >= trackSelectorResult.f6326a) {
                return;
            }
            boolean zM2756b = trackSelectorResult.m2756b(i);
            ExoTrackSelection2 exoTrackSelection2 = this.f7455n.f6328c[i];
            if (zM2756b && exoTrackSelection2 != null) {
                exoTrackSelection2.mo2725g();
            }
            i++;
        }
    }

    /* renamed from: c */
    public final void m3349c() {
        if (!m3353g()) {
            return;
        }
        int i = 0;
        while (true) {
            TrackSelectorResult trackSelectorResult = this.f7455n;
            if (i >= trackSelectorResult.f6326a) {
                return;
            }
            boolean zM2756b = trackSelectorResult.m2756b(i);
            ExoTrackSelection2 exoTrackSelection2 = this.f7455n.f6328c[i];
            if (zM2756b && exoTrackSelection2 != null) {
                exoTrackSelection2.mo2724e();
            }
            i++;
        }
    }

    /* renamed from: d */
    public long m3350d() {
        if (!this.f7445d) {
            return this.f7447f.f7466b;
        }
        long jMo2493q = this.f7446e ? this.f7442a.mo2493q() : Long.MIN_VALUE;
        return jMo2493q == Long.MIN_VALUE ? this.f7447f.f7469e : jMo2493q;
    }

    /* renamed from: e */
    public long m3351e() {
        return this.f7447f.f7466b + this.f7456o;
    }

    /* renamed from: f */
    public boolean m3352f() {
        return this.f7445d && (!this.f7446e || this.f7442a.mo2493q() == Long.MIN_VALUE);
    }

    /* renamed from: g */
    public final boolean m3353g() {
        return this.f7453l == null;
    }

    /* renamed from: h */
    public void m3354h() {
        m3348b();
        MediaSourceList mediaSourceList = this.f7452k;
        MediaPeriod mediaPeriod = this.f7442a;
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaSourceList.m3542h(((ClippingMediaPeriod) mediaPeriod).f5651j);
            } else {
                mediaSourceList.m3542h(mediaPeriod);
            }
        } catch (RuntimeException e) {
            Log2.m3039b("MediaPeriodHolder", "Period release failed.", e);
        }
    }

    /* renamed from: i */
    public TrackSelectorResult m3355i(float f, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult trackSelectorResultMo2753b = this.f7451j.mo2753b(this.f7450i, this.f7454m, this.f7447f.f7465a, timeline);
        for (ExoTrackSelection2 exoTrackSelection2 : trackSelectorResultMo2753b.f6328c) {
            if (exoTrackSelection2 != null) {
                exoTrackSelection2.mo2726i(f);
            }
        }
        return trackSelectorResultMo2753b;
    }

    /* renamed from: j */
    public void m3356j() {
        MediaPeriod mediaPeriod = this.f7442a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j = this.f7447f.f7468d;
            if (j == -9223372036854775807L) {
                j = Long.MIN_VALUE;
            }
            ClippingMediaPeriod clippingMediaPeriod = (ClippingMediaPeriod) mediaPeriod;
            clippingMediaPeriod.f5655n = 0L;
            clippingMediaPeriod.f5656o = j;
        }
    }
}
