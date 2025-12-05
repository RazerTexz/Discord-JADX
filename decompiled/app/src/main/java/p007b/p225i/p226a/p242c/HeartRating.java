package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* compiled from: HeartRating.java */
/* renamed from: b.i.a.c.l1, reason: use source file name */
/* loaded from: classes3.dex */
public final class HeartRating extends Rating {

    /* renamed from: k */
    public final boolean f7238k;

    /* renamed from: l */
    public final boolean f7239l;

    public HeartRating() {
        this.f7238k = false;
        this.f7239l = false;
    }

    /* renamed from: a */
    public static String m3303a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof HeartRating)) {
            return false;
        }
        HeartRating heartRating = (HeartRating) obj;
        return this.f7239l == heartRating.f7239l && this.f7238k == heartRating.f7238k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f7238k), Boolean.valueOf(this.f7239l)});
    }

    public HeartRating(boolean z2) {
        this.f7238k = true;
        this.f7239l = z2;
    }
}
