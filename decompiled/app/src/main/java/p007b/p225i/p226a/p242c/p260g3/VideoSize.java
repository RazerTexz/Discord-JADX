package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.Bundleable;

/* compiled from: VideoSize.java */
/* renamed from: b.i.a.c.g3.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class VideoSize implements Bundleable {

    /* renamed from: j */
    public static final VideoSize f6954j = new VideoSize(0, 0);

    /* renamed from: k */
    @IntRange(from = 0)
    public final int f6955k;

    /* renamed from: l */
    @IntRange(from = 0)
    public final int f6956l;

    /* renamed from: m */
    @IntRange(from = 0, m76to = 359)
    public final int f6957m;

    /* renamed from: n */
    @FloatRange(from = 0.0d, fromInclusive = false)
    public final float f6958n;

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2) {
        this.f6955k = i;
        this.f6956l = i2;
        this.f6957m = 0;
        this.f6958n = 1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VideoSize)) {
            return false;
        }
        VideoSize videoSize = (VideoSize) obj;
        return this.f6955k == videoSize.f6955k && this.f6956l == videoSize.f6956l && this.f6957m == videoSize.f6957m && this.f6958n == videoSize.f6958n;
    }

    public int hashCode() {
        return Float.floatToRawIntBits(this.f6958n) + ((((((217 + this.f6955k) * 31) + this.f6956l) * 31) + this.f6957m) * 31);
    }

    public VideoSize(@IntRange(from = 0) int i, @IntRange(from = 0) int i2, @IntRange(from = 0, m76to = 359) int i3, @FloatRange(from = 0.0d, fromInclusive = false) float f) {
        this.f6955k = i;
        this.f6956l = i2;
        this.f6957m = i3;
        this.f6958n = f;
    }
}
