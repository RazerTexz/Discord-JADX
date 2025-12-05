package p007b.p225i.p226a.p242c.p260g3.p261z;

import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: Projection.java */
/* renamed from: b.i.a.c.g3.z.h, reason: use source file name */
/* loaded from: classes3.dex */
public final class Projection {

    /* renamed from: a */
    public final a f6979a;

    /* renamed from: b */
    public final a f6980b;

    /* renamed from: c */
    public final int f6981c;

    /* renamed from: d */
    public final boolean f6982d;

    /* compiled from: Projection.java */
    /* renamed from: b.i.a.c.g3.z.h$a */
    public static final class a {

        /* renamed from: a */
        public final b[] f6983a;

        public a(b... bVarArr) {
            this.f6983a = bVarArr;
        }
    }

    /* compiled from: Projection.java */
    /* renamed from: b.i.a.c.g3.z.h$b */
    public static final class b {

        /* renamed from: a */
        public final int f6984a;

        /* renamed from: b */
        public final int f6985b;

        /* renamed from: c */
        public final float[] f6986c;

        /* renamed from: d */
        public final float[] f6987d;

        public b(int i, float[] fArr, float[] fArr2, int i2) {
            this.f6984a = i;
            AnimatableValueParser.m531j(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
            this.f6986c = fArr;
            this.f6987d = fArr2;
            this.f6985b = i2;
        }
    }

    public Projection(a aVar, int i) {
        this.f6979a = aVar;
        this.f6980b = aVar;
        this.f6981c = i;
        this.f6982d = aVar == aVar;
    }

    public Projection(a aVar, a aVar2, int i) {
        this.f6979a = aVar;
        this.f6980b = aVar2;
        this.f6981c = i;
        this.f6982d = aVar == aVar2;
    }
}
