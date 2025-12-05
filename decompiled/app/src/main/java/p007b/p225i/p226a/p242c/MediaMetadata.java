package p007b.p225i.p226a.p242c;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import java.util.Arrays;
import p007b.p225i.p226a.p242c.Bundleable;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: MediaMetadata.java */
/* renamed from: b.i.a.c.p1, reason: use source file name */
/* loaded from: classes3.dex */
public final class MediaMetadata implements Bundleable {

    /* renamed from: j */
    public static final MediaMetadata f7368j = new b().m3345a();

    /* renamed from: k */
    public static final Bundleable.a<MediaMetadata> f7369k = C2818l0.f7237a;

    /* renamed from: A */
    @Nullable
    public final Integer f7370A;

    /* renamed from: B */
    @Nullable
    public final Boolean f7371B;

    /* renamed from: C */
    @Nullable
    @Deprecated
    public final Integer f7372C;

    /* renamed from: D */
    @Nullable
    public final Integer f7373D;

    /* renamed from: E */
    @Nullable
    public final Integer f7374E;

    /* renamed from: F */
    @Nullable
    public final Integer f7375F;

    /* renamed from: G */
    @Nullable
    public final Integer f7376G;

    /* renamed from: H */
    @Nullable
    public final Integer f7377H;

    /* renamed from: I */
    @Nullable
    public final Integer f7378I;

    /* renamed from: J */
    @Nullable
    public final CharSequence f7379J;

    /* renamed from: K */
    @Nullable
    public final CharSequence f7380K;

    /* renamed from: L */
    @Nullable
    public final CharSequence f7381L;

    /* renamed from: M */
    @Nullable
    public final Integer f7382M;

    /* renamed from: N */
    @Nullable
    public final Integer f7383N;

    /* renamed from: O */
    @Nullable
    public final CharSequence f7384O;

    /* renamed from: P */
    @Nullable
    public final CharSequence f7385P;

    /* renamed from: Q */
    @Nullable
    public final Bundle f7386Q;

    /* renamed from: l */
    @Nullable
    public final CharSequence f7387l;

    /* renamed from: m */
    @Nullable
    public final CharSequence f7388m;

    /* renamed from: n */
    @Nullable
    public final CharSequence f7389n;

    /* renamed from: o */
    @Nullable
    public final CharSequence f7390o;

    /* renamed from: p */
    @Nullable
    public final CharSequence f7391p;

    /* renamed from: q */
    @Nullable
    public final CharSequence f7392q;

    /* renamed from: r */
    @Nullable
    public final CharSequence f7393r;

    /* renamed from: s */
    @Nullable
    public final Uri f7394s;

    /* renamed from: t */
    @Nullable
    public final Rating f7395t;

    /* renamed from: u */
    @Nullable
    public final Rating f7396u;

    /* renamed from: v */
    @Nullable
    public final byte[] f7397v;

    /* renamed from: w */
    @Nullable
    public final Integer f7398w;

    /* renamed from: x */
    @Nullable
    public final Uri f7399x;

    /* renamed from: y */
    @Nullable
    public final Integer f7400y;

    /* renamed from: z */
    @Nullable
    public final Integer f7401z;

    /* compiled from: MediaMetadata.java */
    /* renamed from: b.i.a.c.p1$b */
    public static final class b {

        /* renamed from: A */
        @Nullable
        public Integer f7402A;

        /* renamed from: B */
        @Nullable
        public Integer f7403B;

        /* renamed from: C */
        @Nullable
        public CharSequence f7404C;

        /* renamed from: D */
        @Nullable
        public CharSequence f7405D;

        /* renamed from: E */
        @Nullable
        public Bundle f7406E;

        /* renamed from: a */
        @Nullable
        public CharSequence f7407a;

        /* renamed from: b */
        @Nullable
        public CharSequence f7408b;

        /* renamed from: c */
        @Nullable
        public CharSequence f7409c;

        /* renamed from: d */
        @Nullable
        public CharSequence f7410d;

        /* renamed from: e */
        @Nullable
        public CharSequence f7411e;

        /* renamed from: f */
        @Nullable
        public CharSequence f7412f;

        /* renamed from: g */
        @Nullable
        public CharSequence f7413g;

        /* renamed from: h */
        @Nullable
        public Uri f7414h;

        /* renamed from: i */
        @Nullable
        public Rating f7415i;

        /* renamed from: j */
        @Nullable
        public Rating f7416j;

        /* renamed from: k */
        @Nullable
        public byte[] f7417k;

        /* renamed from: l */
        @Nullable
        public Integer f7418l;

        /* renamed from: m */
        @Nullable
        public Uri f7419m;

        /* renamed from: n */
        @Nullable
        public Integer f7420n;

        /* renamed from: o */
        @Nullable
        public Integer f7421o;

        /* renamed from: p */
        @Nullable
        public Integer f7422p;

        /* renamed from: q */
        @Nullable
        public Boolean f7423q;

        /* renamed from: r */
        @Nullable
        public Integer f7424r;

        /* renamed from: s */
        @Nullable
        public Integer f7425s;

        /* renamed from: t */
        @Nullable
        public Integer f7426t;

        /* renamed from: u */
        @Nullable
        public Integer f7427u;

        /* renamed from: v */
        @Nullable
        public Integer f7428v;

        /* renamed from: w */
        @Nullable
        public Integer f7429w;

        /* renamed from: x */
        @Nullable
        public CharSequence f7430x;

        /* renamed from: y */
        @Nullable
        public CharSequence f7431y;

        /* renamed from: z */
        @Nullable
        public CharSequence f7432z;

        public b() {
        }

        /* renamed from: a */
        public MediaMetadata m3345a() {
            return new MediaMetadata(this, null);
        }

        /* renamed from: b */
        public b m3346b(byte[] bArr, int i) {
            if (this.f7417k == null || Util2.m2993a(Integer.valueOf(i), 3) || !Util2.m2993a(this.f7418l, 3)) {
                this.f7417k = (byte[]) bArr.clone();
                this.f7418l = Integer.valueOf(i);
            }
            return this;
        }

        public b(MediaMetadata mediaMetadata, a aVar) {
            this.f7407a = mediaMetadata.f7387l;
            this.f7408b = mediaMetadata.f7388m;
            this.f7409c = mediaMetadata.f7389n;
            this.f7410d = mediaMetadata.f7390o;
            this.f7411e = mediaMetadata.f7391p;
            this.f7412f = mediaMetadata.f7392q;
            this.f7413g = mediaMetadata.f7393r;
            this.f7414h = mediaMetadata.f7394s;
            this.f7415i = mediaMetadata.f7395t;
            this.f7416j = mediaMetadata.f7396u;
            this.f7417k = mediaMetadata.f7397v;
            this.f7418l = mediaMetadata.f7398w;
            this.f7419m = mediaMetadata.f7399x;
            this.f7420n = mediaMetadata.f7400y;
            this.f7421o = mediaMetadata.f7401z;
            this.f7422p = mediaMetadata.f7370A;
            this.f7423q = mediaMetadata.f7371B;
            this.f7424r = mediaMetadata.f7373D;
            this.f7425s = mediaMetadata.f7374E;
            this.f7426t = mediaMetadata.f7375F;
            this.f7427u = mediaMetadata.f7376G;
            this.f7428v = mediaMetadata.f7377H;
            this.f7429w = mediaMetadata.f7378I;
            this.f7430x = mediaMetadata.f7379J;
            this.f7431y = mediaMetadata.f7380K;
            this.f7432z = mediaMetadata.f7381L;
            this.f7402A = mediaMetadata.f7382M;
            this.f7403B = mediaMetadata.f7383N;
            this.f7404C = mediaMetadata.f7384O;
            this.f7405D = mediaMetadata.f7385P;
            this.f7406E = mediaMetadata.f7386Q;
        }
    }

    public MediaMetadata(b bVar, a aVar) {
        this.f7387l = bVar.f7407a;
        this.f7388m = bVar.f7408b;
        this.f7389n = bVar.f7409c;
        this.f7390o = bVar.f7410d;
        this.f7391p = bVar.f7411e;
        this.f7392q = bVar.f7412f;
        this.f7393r = bVar.f7413g;
        this.f7394s = bVar.f7414h;
        this.f7395t = bVar.f7415i;
        this.f7396u = bVar.f7416j;
        this.f7397v = bVar.f7417k;
        this.f7398w = bVar.f7418l;
        this.f7399x = bVar.f7419m;
        this.f7400y = bVar.f7420n;
        this.f7401z = bVar.f7421o;
        this.f7370A = bVar.f7422p;
        this.f7371B = bVar.f7423q;
        Integer num = bVar.f7424r;
        this.f7372C = num;
        this.f7373D = num;
        this.f7374E = bVar.f7425s;
        this.f7375F = bVar.f7426t;
        this.f7376G = bVar.f7427u;
        this.f7377H = bVar.f7428v;
        this.f7378I = bVar.f7429w;
        this.f7379J = bVar.f7430x;
        this.f7380K = bVar.f7431y;
        this.f7381L = bVar.f7432z;
        this.f7382M = bVar.f7402A;
        this.f7383N = bVar.f7403B;
        this.f7384O = bVar.f7404C;
        this.f7385P = bVar.f7405D;
        this.f7386Q = bVar.f7406E;
    }

    /* renamed from: b */
    public static String m3343b(int i) {
        return Integer.toString(i, 36);
    }

    /* renamed from: a */
    public b m3344a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MediaMetadata.class != obj.getClass()) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return Util2.m2993a(this.f7387l, mediaMetadata.f7387l) && Util2.m2993a(this.f7388m, mediaMetadata.f7388m) && Util2.m2993a(this.f7389n, mediaMetadata.f7389n) && Util2.m2993a(this.f7390o, mediaMetadata.f7390o) && Util2.m2993a(this.f7391p, mediaMetadata.f7391p) && Util2.m2993a(this.f7392q, mediaMetadata.f7392q) && Util2.m2993a(this.f7393r, mediaMetadata.f7393r) && Util2.m2993a(this.f7394s, mediaMetadata.f7394s) && Util2.m2993a(this.f7395t, mediaMetadata.f7395t) && Util2.m2993a(this.f7396u, mediaMetadata.f7396u) && Arrays.equals(this.f7397v, mediaMetadata.f7397v) && Util2.m2993a(this.f7398w, mediaMetadata.f7398w) && Util2.m2993a(this.f7399x, mediaMetadata.f7399x) && Util2.m2993a(this.f7400y, mediaMetadata.f7400y) && Util2.m2993a(this.f7401z, mediaMetadata.f7401z) && Util2.m2993a(this.f7370A, mediaMetadata.f7370A) && Util2.m2993a(this.f7371B, mediaMetadata.f7371B) && Util2.m2993a(this.f7373D, mediaMetadata.f7373D) && Util2.m2993a(this.f7374E, mediaMetadata.f7374E) && Util2.m2993a(this.f7375F, mediaMetadata.f7375F) && Util2.m2993a(this.f7376G, mediaMetadata.f7376G) && Util2.m2993a(this.f7377H, mediaMetadata.f7377H) && Util2.m2993a(this.f7378I, mediaMetadata.f7378I) && Util2.m2993a(this.f7379J, mediaMetadata.f7379J) && Util2.m2993a(this.f7380K, mediaMetadata.f7380K) && Util2.m2993a(this.f7381L, mediaMetadata.f7381L) && Util2.m2993a(this.f7382M, mediaMetadata.f7382M) && Util2.m2993a(this.f7383N, mediaMetadata.f7383N) && Util2.m2993a(this.f7384O, mediaMetadata.f7384O) && Util2.m2993a(this.f7385P, mediaMetadata.f7385P);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f7387l, this.f7388m, this.f7389n, this.f7390o, this.f7391p, this.f7392q, this.f7393r, this.f7394s, this.f7395t, this.f7396u, Integer.valueOf(Arrays.hashCode(this.f7397v)), this.f7398w, this.f7399x, this.f7400y, this.f7401z, this.f7370A, this.f7371B, this.f7373D, this.f7374E, this.f7375F, this.f7376G, this.f7377H, this.f7378I, this.f7379J, this.f7380K, this.f7381L, this.f7382M, this.f7383N, this.f7384O, this.f7385P});
    }
}
