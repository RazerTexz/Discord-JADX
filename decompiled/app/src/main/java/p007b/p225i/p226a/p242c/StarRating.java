package p007b.p225i.p226a.p242c;

import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: StarRating.java */
/* renamed from: b.i.a.c.l2, reason: use source file name */
/* loaded from: classes3.dex */
public final class StarRating extends Rating {

    /* renamed from: k */
    @IntRange(from = 1)
    public final int f7240k;

    /* renamed from: l */
    public final float f7241l;

    public StarRating(@IntRange(from = 1) int i) {
        AnimatableValueParser.m543m(i > 0, "maxStars must be a positive integer");
        this.f7240k = i;
        this.f7241l = -1.0f;
    }

    /* renamed from: a */
    public static String m3304a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof StarRating)) {
            return false;
        }
        StarRating starRating = (StarRating) obj;
        return this.f7240k == starRating.f7240k && this.f7241l == starRating.f7241l;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7240k), Float.valueOf(this.f7241l)});
    }

    public StarRating(@IntRange(from = 1) int i, @FloatRange(from = 0.0d) float f) {
        AnimatableValueParser.m543m(i > 0, "maxStars must be a positive integer");
        AnimatableValueParser.m543m(f >= 0.0f && f <= ((float) i), "starRating is out of range [0, maxStars]");
        this.f7240k = i;
        this.f7241l = f;
    }
}
