package p007b.p225i.p226a.p242c;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.ColorInfo;

/* compiled from: Format.java */
/* renamed from: b.i.a.c.j1, reason: use source file name */
/* loaded from: classes3.dex */
public final class Format2 implements Bundleable {

    /* renamed from: j */
    public static final Format2 f7125j = new b().m3277a();

    /* renamed from: k */
    public static final Bundleable.a<Format2> f7126k = C2802h0.f7051a;

    /* renamed from: A */
    public final long f7127A;

    /* renamed from: B */
    public final int f7128B;

    /* renamed from: C */
    public final int f7129C;

    /* renamed from: D */
    public final float f7130D;

    /* renamed from: E */
    public final int f7131E;

    /* renamed from: F */
    public final float f7132F;

    /* renamed from: G */
    @Nullable
    public final byte[] f7133G;

    /* renamed from: H */
    public final int f7134H;

    /* renamed from: I */
    @Nullable
    public final ColorInfo f7135I;

    /* renamed from: J */
    public final int f7136J;

    /* renamed from: K */
    public final int f7137K;

    /* renamed from: L */
    public final int f7138L;

    /* renamed from: M */
    public final int f7139M;

    /* renamed from: N */
    public final int f7140N;

    /* renamed from: O */
    public final int f7141O;

    /* renamed from: P */
    public final int f7142P;

    /* renamed from: Q */
    public int f7143Q;

    /* renamed from: l */
    @Nullable
    public final String f7144l;

    /* renamed from: m */
    @Nullable
    public final String f7145m;

    /* renamed from: n */
    @Nullable
    public final String f7146n;

    /* renamed from: o */
    public final int f7147o;

    /* renamed from: p */
    public final int f7148p;

    /* renamed from: q */
    public final int f7149q;

    /* renamed from: r */
    public final int f7150r;

    /* renamed from: s */
    public final int f7151s;

    /* renamed from: t */
    @Nullable
    public final String f7152t;

    /* renamed from: u */
    @Nullable
    public final Metadata f7153u;

    /* renamed from: v */
    @Nullable
    public final String f7154v;

    /* renamed from: w */
    @Nullable
    public final String f7155w;

    /* renamed from: x */
    public final int f7156x;

    /* renamed from: y */
    public final List<byte[]> f7157y;

    /* renamed from: z */
    @Nullable
    public final DrmInitData f7158z;

    public Format2(b bVar, a aVar) {
        this.f7144l = bVar.f7163a;
        this.f7145m = bVar.f7164b;
        this.f7146n = Util2.m2982C(bVar.f7165c);
        this.f7147o = bVar.f7166d;
        this.f7148p = bVar.f7167e;
        int i = bVar.f7168f;
        this.f7149q = i;
        int i2 = bVar.f7169g;
        this.f7150r = i2;
        this.f7151s = i2 != -1 ? i2 : i;
        this.f7152t = bVar.f7170h;
        this.f7153u = bVar.f7171i;
        this.f7154v = bVar.f7172j;
        this.f7155w = bVar.f7173k;
        this.f7156x = bVar.f7174l;
        List<byte[]> list = bVar.f7175m;
        this.f7157y = list == null ? Collections.emptyList() : list;
        DrmInitData drmInitData = bVar.f7176n;
        this.f7158z = drmInitData;
        this.f7127A = bVar.f7177o;
        this.f7128B = bVar.f7178p;
        this.f7129C = bVar.f7179q;
        this.f7130D = bVar.f7180r;
        int i3 = bVar.f7181s;
        this.f7131E = i3 == -1 ? 0 : i3;
        float f = bVar.f7182t;
        this.f7132F = f == -1.0f ? 1.0f : f;
        this.f7133G = bVar.f7183u;
        this.f7134H = bVar.f7184v;
        this.f7135I = bVar.f7185w;
        this.f7136J = bVar.f7186x;
        this.f7137K = bVar.f7187y;
        this.f7138L = bVar.f7188z;
        int i4 = bVar.f7159A;
        this.f7139M = i4 == -1 ? 0 : i4;
        int i5 = bVar.f7160B;
        this.f7140N = i5 != -1 ? i5 : 0;
        this.f7141O = bVar.f7161C;
        int i6 = bVar.f7162D;
        if (i6 != 0 || drmInitData == null) {
            this.f7142P = i6;
        } else {
            this.f7142P = 1;
        }
    }

    @Nullable
    /* renamed from: b */
    public static <T> T m3273b(@Nullable T t, @Nullable T t2) {
        return t != null ? t : t2;
    }

    /* renamed from: d */
    public static String m3274d(int i) {
        return Integer.toString(i, 36);
    }

    /* renamed from: a */
    public b m3275a() {
        return new b(this, null);
    }

    /* renamed from: c */
    public boolean m3276c(Format2 format2) {
        if (this.f7157y.size() != format2.f7157y.size()) {
            return false;
        }
        for (int i = 0; i < this.f7157y.size(); i++) {
            if (!Arrays.equals(this.f7157y.get(i), format2.f7157y.get(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(@Nullable Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj == null || Format2.class != obj.getClass()) {
            return false;
        }
        Format2 format2 = (Format2) obj;
        int i2 = this.f7143Q;
        return (i2 == 0 || (i = format2.f7143Q) == 0 || i2 == i) && this.f7147o == format2.f7147o && this.f7148p == format2.f7148p && this.f7149q == format2.f7149q && this.f7150r == format2.f7150r && this.f7156x == format2.f7156x && this.f7127A == format2.f7127A && this.f7128B == format2.f7128B && this.f7129C == format2.f7129C && this.f7131E == format2.f7131E && this.f7134H == format2.f7134H && this.f7136J == format2.f7136J && this.f7137K == format2.f7137K && this.f7138L == format2.f7138L && this.f7139M == format2.f7139M && this.f7140N == format2.f7140N && this.f7141O == format2.f7141O && this.f7142P == format2.f7142P && Float.compare(this.f7130D, format2.f7130D) == 0 && Float.compare(this.f7132F, format2.f7132F) == 0 && Util2.m2993a(this.f7144l, format2.f7144l) && Util2.m2993a(this.f7145m, format2.f7145m) && Util2.m2993a(this.f7152t, format2.f7152t) && Util2.m2993a(this.f7154v, format2.f7154v) && Util2.m2993a(this.f7155w, format2.f7155w) && Util2.m2993a(this.f7146n, format2.f7146n) && Arrays.equals(this.f7133G, format2.f7133G) && Util2.m2993a(this.f7153u, format2.f7153u) && Util2.m2993a(this.f7135I, format2.f7135I) && Util2.m2993a(this.f7158z, format2.f7158z) && m3276c(format2);
    }

    public int hashCode() {
        if (this.f7143Q == 0) {
            String str = this.f7144l;
            int iHashCode = (527 + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.f7145m;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.f7146n;
            int iHashCode3 = (((((((((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.f7147o) * 31) + this.f7148p) * 31) + this.f7149q) * 31) + this.f7150r) * 31;
            String str4 = this.f7152t;
            int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
            Metadata metadata = this.f7153u;
            int iHashCode5 = (iHashCode4 + (metadata == null ? 0 : metadata.hashCode())) * 31;
            String str5 = this.f7154v;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.f7155w;
            this.f7143Q = ((((((((((((((((Float.floatToIntBits(this.f7132F) + ((((Float.floatToIntBits(this.f7130D) + ((((((((((iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.f7156x) * 31) + ((int) this.f7127A)) * 31) + this.f7128B) * 31) + this.f7129C) * 31)) * 31) + this.f7131E) * 31)) * 31) + this.f7134H) * 31) + this.f7136J) * 31) + this.f7137K) * 31) + this.f7138L) * 31) + this.f7139M) * 31) + this.f7140N) * 31) + this.f7141O) * 31) + this.f7142P;
        }
        return this.f7143Q;
    }

    public String toString() {
        String str = this.f7144l;
        String str2 = this.f7145m;
        String str3 = this.f7154v;
        String str4 = this.f7155w;
        String str5 = this.f7152t;
        int i = this.f7151s;
        String str6 = this.f7146n;
        int i2 = this.f7128B;
        int i3 = this.f7129C;
        float f = this.f7130D;
        int i4 = this.f7136J;
        int i5 = this.f7137K;
        StringBuilder sbM831S = outline.m831S(outline.m841b(str6, outline.m841b(str5, outline.m841b(str4, outline.m841b(str3, outline.m841b(str2, outline.m841b(str, 104)))))), "Format(", str, ", ", str2);
        outline.m876s0(sbM831S, ", ", str3, ", ", str4);
        sbM831S.append(", ");
        sbM831S.append(str5);
        sbM831S.append(", ");
        sbM831S.append(i);
        sbM831S.append(", ");
        sbM831S.append(str6);
        sbM831S.append(", [");
        sbM831S.append(i2);
        sbM831S.append(", ");
        sbM831S.append(i3);
        sbM831S.append(", ");
        sbM831S.append(f);
        sbM831S.append("], [");
        sbM831S.append(i4);
        sbM831S.append(", ");
        sbM831S.append(i5);
        sbM831S.append("])");
        return sbM831S.toString();
    }

    /* compiled from: Format.java */
    /* renamed from: b.i.a.c.j1$b */
    public static final class b {

        /* renamed from: A */
        public int f7159A;

        /* renamed from: B */
        public int f7160B;

        /* renamed from: C */
        public int f7161C;

        /* renamed from: D */
        public int f7162D;

        /* renamed from: a */
        @Nullable
        public String f7163a;

        /* renamed from: b */
        @Nullable
        public String f7164b;

        /* renamed from: c */
        @Nullable
        public String f7165c;

        /* renamed from: d */
        public int f7166d;

        /* renamed from: e */
        public int f7167e;

        /* renamed from: f */
        public int f7168f;

        /* renamed from: g */
        public int f7169g;

        /* renamed from: h */
        @Nullable
        public String f7170h;

        /* renamed from: i */
        @Nullable
        public Metadata f7171i;

        /* renamed from: j */
        @Nullable
        public String f7172j;

        /* renamed from: k */
        @Nullable
        public String f7173k;

        /* renamed from: l */
        public int f7174l;

        /* renamed from: m */
        @Nullable
        public List<byte[]> f7175m;

        /* renamed from: n */
        @Nullable
        public DrmInitData f7176n;

        /* renamed from: o */
        public long f7177o;

        /* renamed from: p */
        public int f7178p;

        /* renamed from: q */
        public int f7179q;

        /* renamed from: r */
        public float f7180r;

        /* renamed from: s */
        public int f7181s;

        /* renamed from: t */
        public float f7182t;

        /* renamed from: u */
        @Nullable
        public byte[] f7183u;

        /* renamed from: v */
        public int f7184v;

        /* renamed from: w */
        @Nullable
        public ColorInfo f7185w;

        /* renamed from: x */
        public int f7186x;

        /* renamed from: y */
        public int f7187y;

        /* renamed from: z */
        public int f7188z;

        public b() {
            this.f7168f = -1;
            this.f7169g = -1;
            this.f7174l = -1;
            this.f7177o = RecyclerView.FOREVER_NS;
            this.f7178p = -1;
            this.f7179q = -1;
            this.f7180r = -1.0f;
            this.f7182t = 1.0f;
            this.f7184v = -1;
            this.f7186x = -1;
            this.f7187y = -1;
            this.f7188z = -1;
            this.f7161C = -1;
            this.f7162D = 0;
        }

        /* renamed from: a */
        public Format2 m3277a() {
            return new Format2(this, null);
        }

        /* renamed from: b */
        public b m3278b(int i) {
            this.f7163a = Integer.toString(i);
            return this;
        }

        public b(Format2 format2, a aVar) {
            this.f7163a = format2.f7144l;
            this.f7164b = format2.f7145m;
            this.f7165c = format2.f7146n;
            this.f7166d = format2.f7147o;
            this.f7167e = format2.f7148p;
            this.f7168f = format2.f7149q;
            this.f7169g = format2.f7150r;
            this.f7170h = format2.f7152t;
            this.f7171i = format2.f7153u;
            this.f7172j = format2.f7154v;
            this.f7173k = format2.f7155w;
            this.f7174l = format2.f7156x;
            this.f7175m = format2.f7157y;
            this.f7176n = format2.f7158z;
            this.f7177o = format2.f7127A;
            this.f7178p = format2.f7128B;
            this.f7179q = format2.f7129C;
            this.f7180r = format2.f7130D;
            this.f7181s = format2.f7131E;
            this.f7182t = format2.f7132F;
            this.f7183u = format2.f7133G;
            this.f7184v = format2.f7134H;
            this.f7185w = format2.f7135I;
            this.f7186x = format2.f7136J;
            this.f7187y = format2.f7137K;
            this.f7188z = format2.f7138L;
            this.f7159A = format2.f7139M;
            this.f7160B = format2.f7140N;
            this.f7161C = format2.f7141O;
            this.f7162D = format2.f7142P;
        }
    }
}
