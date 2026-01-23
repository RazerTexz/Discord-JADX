package p007b.p225i.p226a.p242c;

import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.c.v1, reason: use source file name */
/* JADX INFO: compiled from: PercentageRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PercentageRating extends Rating {

    /* JADX INFO: renamed from: k */
    public final float f7900k;

    public PercentageRating() {
        this.f7900k = -1.0f;
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof PercentageRating) && this.f7900k == ((PercentageRating) obj).f7900k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f7900k)});
    }

    public PercentageRating(@FloatRange(from = 0.0d, m75to = 100.0d) float f) {
        AnimatableValueParser.m543m(f >= 0.0f && f <= 100.0f, "percent must be in the range of [0, 100]");
        this.f7900k = f;
    }
}
