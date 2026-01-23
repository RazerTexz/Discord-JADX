package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.n2, reason: use source file name */
/* JADX INFO: compiled from: ThumbRating.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ThumbRating extends Rating {

    /* JADX INFO: renamed from: k */
    public final boolean f7257k;

    /* JADX INFO: renamed from: l */
    public final boolean f7258l;

    public ThumbRating() {
        this.f7257k = false;
        this.f7258l = false;
    }

    /* JADX INFO: renamed from: a */
    public static String m3318a(int i) {
        return Integer.toString(i, 36);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ThumbRating)) {
            return false;
        }
        ThumbRating thumbRating = (ThumbRating) obj;
        return this.f7258l == thumbRating.f7258l && this.f7257k == thumbRating.f7257k;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f7257k), Boolean.valueOf(this.f7258l)});
    }

    public ThumbRating(boolean z2) {
        this.f7257k = true;
        this.f7258l = z2;
    }
}
