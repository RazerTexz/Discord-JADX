package b.i.a.c;

import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.a.c.w0;
import java.util.Arrays;

/* compiled from: MediaMetadata.java */
/* loaded from: classes3.dex */
public final class p1 implements w0 {
    public static final p1 j = new b().a();
    public static final w0.a<p1> k = l0.a;

    @Nullable
    public final Integer A;

    @Nullable
    public final Boolean B;

    @Nullable
    @Deprecated
    public final Integer C;

    @Nullable
    public final Integer D;

    @Nullable
    public final Integer E;

    @Nullable
    public final Integer F;

    @Nullable
    public final Integer G;

    @Nullable
    public final Integer H;

    @Nullable
    public final Integer I;

    @Nullable
    public final CharSequence J;

    @Nullable
    public final CharSequence K;

    @Nullable
    public final CharSequence L;

    @Nullable
    public final Integer M;

    @Nullable
    public final Integer N;

    @Nullable
    public final CharSequence O;

    @Nullable
    public final CharSequence P;

    @Nullable
    public final Bundle Q;

    @Nullable
    public final CharSequence l;

    @Nullable
    public final CharSequence m;

    @Nullable
    public final CharSequence n;

    @Nullable
    public final CharSequence o;

    @Nullable
    public final CharSequence p;

    @Nullable
    public final CharSequence q;

    @Nullable
    public final CharSequence r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public final Uri f1046s;

    @Nullable
    public final d2 t;

    @Nullable
    public final d2 u;

    @Nullable
    public final byte[] v;

    @Nullable
    public final Integer w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public final Uri f1047x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public final Integer f1048y;

    /* renamed from: z, reason: collision with root package name */
    @Nullable
    public final Integer f1049z;

    /* compiled from: MediaMetadata.java */
    public static final class b {

        @Nullable
        public Integer A;

        @Nullable
        public Integer B;

        @Nullable
        public CharSequence C;

        @Nullable
        public CharSequence D;

        @Nullable
        public Bundle E;

        @Nullable
        public CharSequence a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public CharSequence f1050b;

        @Nullable
        public CharSequence c;

        @Nullable
        public CharSequence d;

        @Nullable
        public CharSequence e;

        @Nullable
        public CharSequence f;

        @Nullable
        public CharSequence g;

        @Nullable
        public Uri h;

        @Nullable
        public d2 i;

        @Nullable
        public d2 j;

        @Nullable
        public byte[] k;

        @Nullable
        public Integer l;

        @Nullable
        public Uri m;

        @Nullable
        public Integer n;

        @Nullable
        public Integer o;

        @Nullable
        public Integer p;

        @Nullable
        public Boolean q;

        @Nullable
        public Integer r;

        /* renamed from: s, reason: collision with root package name */
        @Nullable
        public Integer f1051s;

        @Nullable
        public Integer t;

        @Nullable
        public Integer u;

        @Nullable
        public Integer v;

        @Nullable
        public Integer w;

        /* renamed from: x, reason: collision with root package name */
        @Nullable
        public CharSequence f1052x;

        /* renamed from: y, reason: collision with root package name */
        @Nullable
        public CharSequence f1053y;

        /* renamed from: z, reason: collision with root package name */
        @Nullable
        public CharSequence f1054z;

        public b() {
        }

        public p1 a() {
            return new p1(this, null);
        }

        public b b(byte[] bArr, int i) {
            if (this.k == null || b.i.a.c.f3.e0.a(Integer.valueOf(i), 3) || !b.i.a.c.f3.e0.a(this.l, 3)) {
                this.k = (byte[]) bArr.clone();
                this.l = Integer.valueOf(i);
            }
            return this;
        }

        public b(p1 p1Var, a aVar) {
            this.a = p1Var.l;
            this.f1050b = p1Var.m;
            this.c = p1Var.n;
            this.d = p1Var.o;
            this.e = p1Var.p;
            this.f = p1Var.q;
            this.g = p1Var.r;
            this.h = p1Var.f1046s;
            this.i = p1Var.t;
            this.j = p1Var.u;
            this.k = p1Var.v;
            this.l = p1Var.w;
            this.m = p1Var.f1047x;
            this.n = p1Var.f1048y;
            this.o = p1Var.f1049z;
            this.p = p1Var.A;
            this.q = p1Var.B;
            this.r = p1Var.D;
            this.f1051s = p1Var.E;
            this.t = p1Var.F;
            this.u = p1Var.G;
            this.v = p1Var.H;
            this.w = p1Var.I;
            this.f1052x = p1Var.J;
            this.f1053y = p1Var.K;
            this.f1054z = p1Var.L;
            this.A = p1Var.M;
            this.B = p1Var.N;
            this.C = p1Var.O;
            this.D = p1Var.P;
            this.E = p1Var.Q;
        }
    }

    public p1(b bVar, a aVar) {
        this.l = bVar.a;
        this.m = bVar.f1050b;
        this.n = bVar.c;
        this.o = bVar.d;
        this.p = bVar.e;
        this.q = bVar.f;
        this.r = bVar.g;
        this.f1046s = bVar.h;
        this.t = bVar.i;
        this.u = bVar.j;
        this.v = bVar.k;
        this.w = bVar.l;
        this.f1047x = bVar.m;
        this.f1048y = bVar.n;
        this.f1049z = bVar.o;
        this.A = bVar.p;
        this.B = bVar.q;
        Integer num = bVar.r;
        this.C = num;
        this.D = num;
        this.E = bVar.f1051s;
        this.F = bVar.t;
        this.G = bVar.u;
        this.H = bVar.v;
        this.I = bVar.w;
        this.J = bVar.f1052x;
        this.K = bVar.f1053y;
        this.L = bVar.f1054z;
        this.M = bVar.A;
        this.N = bVar.B;
        this.O = bVar.C;
        this.P = bVar.D;
        this.Q = bVar.E;
    }

    public static String b(int i) {
        return Integer.toString(i, 36);
    }

    public b a() {
        return new b(this, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || p1.class != obj.getClass()) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return b.i.a.c.f3.e0.a(this.l, p1Var.l) && b.i.a.c.f3.e0.a(this.m, p1Var.m) && b.i.a.c.f3.e0.a(this.n, p1Var.n) && b.i.a.c.f3.e0.a(this.o, p1Var.o) && b.i.a.c.f3.e0.a(this.p, p1Var.p) && b.i.a.c.f3.e0.a(this.q, p1Var.q) && b.i.a.c.f3.e0.a(this.r, p1Var.r) && b.i.a.c.f3.e0.a(this.f1046s, p1Var.f1046s) && b.i.a.c.f3.e0.a(this.t, p1Var.t) && b.i.a.c.f3.e0.a(this.u, p1Var.u) && Arrays.equals(this.v, p1Var.v) && b.i.a.c.f3.e0.a(this.w, p1Var.w) && b.i.a.c.f3.e0.a(this.f1047x, p1Var.f1047x) && b.i.a.c.f3.e0.a(this.f1048y, p1Var.f1048y) && b.i.a.c.f3.e0.a(this.f1049z, p1Var.f1049z) && b.i.a.c.f3.e0.a(this.A, p1Var.A) && b.i.a.c.f3.e0.a(this.B, p1Var.B) && b.i.a.c.f3.e0.a(this.D, p1Var.D) && b.i.a.c.f3.e0.a(this.E, p1Var.E) && b.i.a.c.f3.e0.a(this.F, p1Var.F) && b.i.a.c.f3.e0.a(this.G, p1Var.G) && b.i.a.c.f3.e0.a(this.H, p1Var.H) && b.i.a.c.f3.e0.a(this.I, p1Var.I) && b.i.a.c.f3.e0.a(this.J, p1Var.J) && b.i.a.c.f3.e0.a(this.K, p1Var.K) && b.i.a.c.f3.e0.a(this.L, p1Var.L) && b.i.a.c.f3.e0.a(this.M, p1Var.M) && b.i.a.c.f3.e0.a(this.N, p1Var.N) && b.i.a.c.f3.e0.a(this.O, p1Var.O) && b.i.a.c.f3.e0.a(this.P, p1Var.P);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.l, this.m, this.n, this.o, this.p, this.q, this.r, this.f1046s, this.t, this.u, Integer.valueOf(Arrays.hashCode(this.v)), this.w, this.f1047x, this.f1048y, this.f1049z, this.A, this.B, this.D, this.E, this.F, this.G, this.H, this.I, this.J, this.K, this.L, this.M, this.N, this.O, this.P});
    }
}
