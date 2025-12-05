package p007b.p225i.p226a.p242c.p255c3;

import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.List;
import p007b.p225i.p226a.p242c.p243a3.TrackGroup;
import p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2;
import p007b.p225i.p226a.p242c.p257e3.BandwidthMeter;
import p007b.p225i.p226a.p242c.p259f3.Clock4;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* compiled from: AdaptiveTrackSelection.java */
/* renamed from: b.i.a.c.c3.f, reason: use source file name */
/* loaded from: classes3.dex */
public class AdaptiveTrackSelection extends BaseTrackSelection {

    /* renamed from: f */
    public final BandwidthMeter f6182f;

    /* renamed from: g */
    public final Clock4 f6183g;

    /* compiled from: AdaptiveTrackSelection.java */
    /* renamed from: b.i.a.c.c3.f$a */
    public static final class a {

        /* renamed from: a */
        public final long f6184a;

        /* renamed from: b */
        public final long f6185b;

        public a(long j, long j2) {
            this.f6184a = j;
            this.f6185b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f6184a == aVar.f6184a && this.f6185b == aVar.f6185b;
        }

        public int hashCode() {
            return (((int) this.f6184a) * 31) + ((int) this.f6185b);
        }
    }

    /* compiled from: AdaptiveTrackSelection.java */
    /* renamed from: b.i.a.c.c3.f$b */
    public static class b implements ExoTrackSelection2.b {

        /* renamed from: a */
        public final Clock4 f6186a = Clock4.f6720a;
    }

    public AdaptiveTrackSelection(TrackGroup trackGroup, int[] iArr, int i, BandwidthMeter bandwidthMeter, long j, long j2, long j3, int i2, int i3, float f, float f2, List<a> list, Clock4 clock4) {
        super(trackGroup, iArr, i);
        if (j3 < j) {
            Log.w("AdaptiveTrackSelection", "Adjusting minDurationToRetainAfterDiscardMs to be at least minDurationForQualityIncreaseMs");
        }
        this.f6182f = bandwidthMeter;
        ImmutableList2.m6264n(list);
        this.f6183g = clock4;
    }

    /* renamed from: m */
    public static void m2722m(List<ImmutableList2.a<a>> list, long[] jArr) {
        long j = 0;
        for (long j2 : jArr) {
            j += j2;
        }
        for (int i = 0; i < list.size(); i++) {
            ImmutableList2.a<a> aVar = list.get(i);
            if (aVar != null) {
                aVar.m6271b(new a(j, jArr[i]));
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: b */
    public int mo2723b() {
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.BaseTrackSelection, p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    @CallSuper
    /* renamed from: e */
    public void mo2724e() {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.BaseTrackSelection, p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    @CallSuper
    /* renamed from: g */
    public void mo2725g() {
    }

    @Override // p007b.p225i.p226a.p242c.p255c3.BaseTrackSelection, p007b.p225i.p226a.p242c.p255c3.ExoTrackSelection2
    /* renamed from: i */
    public void mo2726i(float f) {
    }
}
