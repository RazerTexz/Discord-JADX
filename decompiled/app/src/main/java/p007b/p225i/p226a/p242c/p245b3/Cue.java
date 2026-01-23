package p007b.p225i.p226a.p242c.p245b3;

import android.graphics.Bitmap;
import android.text.Layout;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Bundleable;

/* JADX INFO: renamed from: b.i.a.c.b3.b, reason: use source file name */
/* JADX INFO: compiled from: Cue.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Cue implements Bundleable {

    /* JADX INFO: renamed from: j */
    public static final Cue f5754j = new Cue("", null, null, null, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, Integer.MIN_VALUE, Integer.MIN_VALUE, -3.4028235E38f, -3.4028235E38f, -3.4028235E38f, false, ViewCompat.MEASURED_STATE_MASK, Integer.MIN_VALUE, 0.0f, null);

    /* JADX INFO: renamed from: k */
    public static final Bundleable.a<Cue> f5755k = C2577a.f5753a;

    /* JADX INFO: renamed from: A */
    public final int f5756A;

    /* JADX INFO: renamed from: B */
    public final float f5757B;

    /* JADX INFO: renamed from: l */
    @Nullable
    public final CharSequence f5758l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final Layout.Alignment f5759m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public final Layout.Alignment f5760n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public final Bitmap f5761o;

    /* JADX INFO: renamed from: p */
    public final float f5762p;

    /* JADX INFO: renamed from: q */
    public final int f5763q;

    /* JADX INFO: renamed from: r */
    public final int f5764r;

    /* JADX INFO: renamed from: s */
    public final float f5765s;

    /* JADX INFO: renamed from: t */
    public final int f5766t;

    /* JADX INFO: renamed from: u */
    public final float f5767u;

    /* JADX INFO: renamed from: v */
    public final float f5768v;

    /* JADX INFO: renamed from: w */
    public final boolean f5769w;

    /* JADX INFO: renamed from: x */
    public final int f5770x;

    /* JADX INFO: renamed from: y */
    public final int f5771y;

    /* JADX INFO: renamed from: z */
    public final float f5772z;

    public Cue(CharSequence charSequence, Layout.Alignment alignment, Layout.Alignment alignment2, Bitmap bitmap, float f, int i, int i2, float f2, int i3, int i4, float f3, float f4, float f5, boolean z2, int i5, int i6, float f6, a aVar) {
        if (charSequence == null) {
            Objects.requireNonNull(bitmap);
        } else {
            AnimatableValueParser.m531j(bitmap == null);
        }
        if (charSequence instanceof Spanned) {
            this.f5758l = SpannedString.valueOf(charSequence);
        } else if (charSequence != null) {
            this.f5758l = charSequence.toString();
        } else {
            this.f5758l = null;
        }
        this.f5759m = alignment;
        this.f5760n = alignment2;
        this.f5761o = bitmap;
        this.f5762p = f;
        this.f5763q = i;
        this.f5764r = i2;
        this.f5765s = f2;
        this.f5766t = i3;
        this.f5767u = f4;
        this.f5768v = f5;
        this.f5769w = z2;
        this.f5770x = i5;
        this.f5771y = i4;
        this.f5772z = f3;
        this.f5756A = i6;
        this.f5757B = f6;
    }

    /* JADX INFO: renamed from: b */
    public static String m2604b(int i) {
        return Integer.toString(i, 36);
    }

    /* JADX INFO: renamed from: a */
    public b m2605a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (this == obj) {
            return true;
        }
        if (obj == null || Cue.class != obj.getClass()) {
            return false;
        }
        Cue cue = (Cue) obj;
        return TextUtils.equals(this.f5758l, cue.f5758l) && this.f5759m == cue.f5759m && this.f5760n == cue.f5760n && ((bitmap = this.f5761o) != null ? !((bitmap2 = cue.f5761o) == null || !bitmap.sameAs(bitmap2)) : cue.f5761o == null) && this.f5762p == cue.f5762p && this.f5763q == cue.f5763q && this.f5764r == cue.f5764r && this.f5765s == cue.f5765s && this.f5766t == cue.f5766t && this.f5767u == cue.f5767u && this.f5768v == cue.f5768v && this.f5769w == cue.f5769w && this.f5770x == cue.f5770x && this.f5771y == cue.f5771y && this.f5772z == cue.f5772z && this.f5756A == cue.f5756A && this.f5757B == cue.f5757B;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f5758l, this.f5759m, this.f5760n, this.f5761o, Float.valueOf(this.f5762p), Integer.valueOf(this.f5763q), Integer.valueOf(this.f5764r), Float.valueOf(this.f5765s), Integer.valueOf(this.f5766t), Float.valueOf(this.f5767u), Float.valueOf(this.f5768v), Boolean.valueOf(this.f5769w), Integer.valueOf(this.f5770x), Integer.valueOf(this.f5771y), Float.valueOf(this.f5772z), Integer.valueOf(this.f5756A), Float.valueOf(this.f5757B)});
    }

    /* JADX INFO: renamed from: b.i.a.c.b3.b$b */
    /* JADX INFO: compiled from: Cue.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        @Nullable
        public CharSequence f5773a;

        /* JADX INFO: renamed from: b */
        @Nullable
        public Bitmap f5774b;

        /* JADX INFO: renamed from: c */
        @Nullable
        public Layout.Alignment f5775c;

        /* JADX INFO: renamed from: d */
        @Nullable
        public Layout.Alignment f5776d;

        /* JADX INFO: renamed from: e */
        public float f5777e;

        /* JADX INFO: renamed from: f */
        public int f5778f;

        /* JADX INFO: renamed from: g */
        public int f5779g;

        /* JADX INFO: renamed from: h */
        public float f5780h;

        /* JADX INFO: renamed from: i */
        public int f5781i;

        /* JADX INFO: renamed from: j */
        public int f5782j;

        /* JADX INFO: renamed from: k */
        public float f5783k;

        /* JADX INFO: renamed from: l */
        public float f5784l;

        /* JADX INFO: renamed from: m */
        public float f5785m;

        /* JADX INFO: renamed from: n */
        public boolean f5786n;

        /* JADX INFO: renamed from: o */
        @ColorInt
        public int f5787o;

        /* JADX INFO: renamed from: p */
        public int f5788p;

        /* JADX INFO: renamed from: q */
        public float f5789q;

        public b() {
            this.f5773a = null;
            this.f5774b = null;
            this.f5775c = null;
            this.f5776d = null;
            this.f5777e = -3.4028235E38f;
            this.f5778f = Integer.MIN_VALUE;
            this.f5779g = Integer.MIN_VALUE;
            this.f5780h = -3.4028235E38f;
            this.f5781i = Integer.MIN_VALUE;
            this.f5782j = Integer.MIN_VALUE;
            this.f5783k = -3.4028235E38f;
            this.f5784l = -3.4028235E38f;
            this.f5785m = -3.4028235E38f;
            this.f5786n = false;
            this.f5787o = ViewCompat.MEASURED_STATE_MASK;
            this.f5788p = Integer.MIN_VALUE;
        }

        /* JADX INFO: renamed from: a */
        public Cue m2606a() {
            return new Cue(this.f5773a, this.f5775c, this.f5776d, this.f5774b, this.f5777e, this.f5778f, this.f5779g, this.f5780h, this.f5781i, this.f5782j, this.f5783k, this.f5784l, this.f5785m, this.f5786n, this.f5787o, this.f5788p, this.f5789q, null);
        }

        public b(Cue cue, a aVar) {
            this.f5773a = cue.f5758l;
            this.f5774b = cue.f5761o;
            this.f5775c = cue.f5759m;
            this.f5776d = cue.f5760n;
            this.f5777e = cue.f5762p;
            this.f5778f = cue.f5763q;
            this.f5779g = cue.f5764r;
            this.f5780h = cue.f5765s;
            this.f5781i = cue.f5766t;
            this.f5782j = cue.f5771y;
            this.f5783k = cue.f5772z;
            this.f5784l = cue.f5767u;
            this.f5785m = cue.f5768v;
            this.f5786n = cue.f5769w;
            this.f5787o = cue.f5770x;
            this.f5788p = cue.f5756A;
            this.f5789q = cue.f5757B;
        }
    }
}
