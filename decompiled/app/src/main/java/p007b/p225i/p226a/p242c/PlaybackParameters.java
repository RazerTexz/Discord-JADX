package p007b.p225i.p226a.p242c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: PlaybackParameters.java */
/* renamed from: b.i.a.c.x1, reason: use source file name */
/* loaded from: classes3.dex */
public final class PlaybackParameters implements Bundleable {

    /* renamed from: j */
    public static final PlaybackParameters f8026j = new PlaybackParameters(1.0f, 1.0f);

    /* renamed from: k */
    public final float f8027k;

    /* renamed from: l */
    public final float f8028l;

    /* renamed from: m */
    public final int f8029m;

    public PlaybackParameters(@FloatRange(from = 0.0d, fromInclusive = false) float f, @FloatRange(from = 0.0d, fromInclusive = false) float f2) {
        AnimatableValueParser.m531j(f > 0.0f);
        AnimatableValueParser.m531j(f2 > 0.0f);
        this.f8027k = f;
        this.f8028l = f2;
        this.f8029m = Math.round(f * 1000.0f);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || PlaybackParameters.class != obj.getClass()) {
            return false;
        }
        PlaybackParameters playbackParameters = (PlaybackParameters) obj;
        return this.f8027k == playbackParameters.f8027k && this.f8028l == playbackParameters.f8028l;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.f8028l) + ((Float.floatToRawIntBits(this.f8027k) + 527) * 31);
    }

    public String toString() {
        return Util2.m3003k("PlaybackParameters(speed=%.2f, pitch=%.2f)", Float.valueOf(this.f8027k), Float.valueOf(this.f8028l));
    }
}
