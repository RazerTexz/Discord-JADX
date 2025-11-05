package b.i.a.c.x2.k0;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import b.i.a.c.f3.u;
import b.i.a.c.j1;
import b.i.a.c.x2.k0.i0;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: H264Reader.java */
/* loaded from: classes3.dex */
public final class r implements o {
    public final e0 a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1272b;
    public final boolean c;
    public long g;
    public String i;
    public b.i.a.c.x2.w j;
    public b k;
    public boolean l;
    public boolean n;
    public final boolean[] h = new boolean[3];
    public final w d = new w(7, 128);
    public final w e = new w(8, 128);
    public final w f = new w(6, 128);
    public long m = -9223372036854775807L;
    public final b.i.a.c.f3.x o = new b.i.a.c.f3.x();

    /* compiled from: H264Reader.java */
    public static final class b {
        public final b.i.a.c.x2.w a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f1273b;
        public final boolean c;
        public final b.i.a.c.f3.y f;
        public byte[] g;
        public int h;
        public int i;
        public long j;
        public long l;
        public long p;
        public long q;
        public boolean r;
        public final SparseArray<u.c> d = new SparseArray<>();
        public final SparseArray<u.b> e = new SparseArray<>();
        public a m = new a(null);
        public a n = new a(null);
        public boolean k = false;
        public boolean o = false;

        /* compiled from: H264Reader.java */
        public static final class a {
            public boolean a;

            /* renamed from: b, reason: collision with root package name */
            public boolean f1274b;

            @Nullable
            public u.c c;
            public int d;
            public int e;
            public int f;
            public int g;
            public boolean h;
            public boolean i;
            public boolean j;
            public boolean k;
            public int l;
            public int m;
            public int n;
            public int o;
            public int p;

            public a(a aVar) {
            }
        }

        public b(b.i.a.c.x2.w wVar, boolean z2, boolean z3) {
            this.a = wVar;
            this.f1273b = z2;
            this.c = z3;
            byte[] bArr = new byte[128];
            this.g = bArr;
            this.f = new b.i.a.c.f3.y(bArr, 0, 0);
            a aVar = this.n;
            aVar.f1274b = false;
            aVar.a = false;
        }
    }

    public r(e0 e0Var, boolean z2, boolean z3) {
        this.a = e0Var;
        this.f1272b = z2;
        this.c = z3;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0171  */
    @RequiresNonNull({"sampleReader"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(byte[] bArr, int i, int i2) {
        boolean zD;
        boolean zD2;
        boolean z2;
        boolean z3;
        int iF;
        int i3;
        int iG;
        int i4;
        int iE;
        int iG2;
        int i5;
        int iG3;
        if (!this.l || this.k.c) {
            this.d.a(bArr, i, i2);
            this.e.a(bArr, i, i2);
        }
        this.f.a(bArr, i, i2);
        b bVar = this.k;
        if (bVar.k) {
            int i6 = i2 - i;
            byte[] bArr2 = bVar.g;
            int length = bArr2.length;
            int i7 = bVar.h + i6;
            if (length < i7) {
                bVar.g = Arrays.copyOf(bArr2, i7 * 2);
            }
            System.arraycopy(bArr, i, bVar.g, bVar.h, i6);
            int i8 = bVar.h + i6;
            bVar.h = i8;
            b.i.a.c.f3.y yVar = bVar.f;
            yVar.a = bVar.g;
            yVar.c = 0;
            yVar.f985b = i8;
            yVar.d = 0;
            yVar.a();
            if (bVar.f.b(8)) {
                bVar.f.i();
                int iE2 = bVar.f.e(2);
                bVar.f.j(5);
                if (bVar.f.c()) {
                    bVar.f.f();
                    if (bVar.f.c()) {
                        int iF2 = bVar.f.f();
                        if (!bVar.c) {
                            bVar.k = false;
                            b.a aVar = bVar.n;
                            aVar.e = iF2;
                            aVar.f1274b = true;
                            return;
                        }
                        if (bVar.f.c()) {
                            int iF3 = bVar.f.f();
                            if (bVar.e.indexOfKey(iF3) < 0) {
                                bVar.k = false;
                                return;
                            }
                            u.b bVar2 = bVar.e.get(iF3);
                            u.c cVar = bVar.d.get(bVar2.f980b);
                            if (cVar.h) {
                                if (!bVar.f.b(2)) {
                                    return;
                                } else {
                                    bVar.f.j(2);
                                }
                            }
                            if (bVar.f.b(cVar.j)) {
                                int iE3 = bVar.f.e(cVar.j);
                                if (!cVar.i) {
                                    if (bVar.f.b(1)) {
                                        zD = bVar.f.d();
                                        if (zD) {
                                            if (!bVar.f.b(1)) {
                                                return;
                                            }
                                            zD2 = bVar.f.d();
                                            z2 = true;
                                        }
                                        z3 = bVar.i != 5;
                                        if (z3) {
                                            iF = 0;
                                        } else if (!bVar.f.c()) {
                                            return;
                                        } else {
                                            iF = bVar.f.f();
                                        }
                                        i3 = cVar.k;
                                        if (i3 == 0) {
                                            if (i3 != 1 || cVar.m) {
                                                iG = 0;
                                            } else {
                                                if (!bVar.f.c()) {
                                                    return;
                                                }
                                                iG = bVar.f.g();
                                                if (bVar2.c && !zD) {
                                                    if (!bVar.f.c()) {
                                                        return;
                                                    }
                                                    iG2 = bVar.f.g();
                                                    i5 = 0;
                                                    i4 = iG;
                                                    iE = 0;
                                                }
                                            }
                                            i4 = iG;
                                            iE = 0;
                                            iG2 = 0;
                                            i5 = 0;
                                        } else {
                                            if (!bVar.f.b(cVar.l)) {
                                                return;
                                            }
                                            iE = bVar.f.e(cVar.l);
                                            if (!bVar2.c || zD) {
                                                iG3 = 0;
                                            } else if (!bVar.f.c()) {
                                                return;
                                            } else {
                                                iG3 = bVar.f.g();
                                            }
                                            i5 = iG3;
                                            iG2 = 0;
                                            i4 = 0;
                                        }
                                        b.a aVar2 = bVar.n;
                                        aVar2.c = cVar;
                                        aVar2.d = iE2;
                                        aVar2.e = iF2;
                                        aVar2.f = iE3;
                                        aVar2.g = iF3;
                                        aVar2.h = zD;
                                        aVar2.i = z2;
                                        aVar2.j = zD2;
                                        aVar2.k = z3;
                                        aVar2.l = iF;
                                        aVar2.m = iE;
                                        aVar2.n = i5;
                                        aVar2.o = i4;
                                        aVar2.p = iG2;
                                        aVar2.a = true;
                                        aVar2.f1274b = true;
                                        bVar.k = false;
                                    }
                                    return;
                                }
                                zD = false;
                                zD2 = false;
                                z2 = false;
                                if (bVar.i != 5) {
                                }
                                if (z3) {
                                }
                                i3 = cVar.k;
                                if (i3 == 0) {
                                }
                                b.a aVar22 = bVar.n;
                                aVar22.c = cVar;
                                aVar22.d = iE2;
                                aVar22.e = iF2;
                                aVar22.f = iE3;
                                aVar22.g = iF3;
                                aVar22.h = zD;
                                aVar22.i = z2;
                                aVar22.j = zD2;
                                aVar22.k = z3;
                                aVar22.l = iF;
                                aVar22.m = iE;
                                aVar22.n = i5;
                                aVar22.o = i4;
                                aVar22.p = iG2;
                                aVar22.a = true;
                                aVar22.f1274b = true;
                                bVar.k = false;
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:131:0x0292  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f3  */
    @Override // b.i.a.c.x2.k0.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(b.i.a.c.f3.x xVar) {
        int i;
        byte[] bArr;
        int i2;
        int i3;
        boolean z2;
        int i4;
        int i5;
        int i6;
        boolean z3;
        b.c.a.a0.d.H(this.j);
        int i7 = b.i.a.c.f3.e0.a;
        int i8 = xVar.f984b;
        int i9 = xVar.c;
        byte[] bArr2 = xVar.a;
        this.g += xVar.a();
        this.j.c(xVar, xVar.a());
        while (true) {
            int iB = b.i.a.c.f3.u.b(bArr2, i8, i9, this.h);
            if (iB == i9) {
                a(bArr2, i8, i9);
                return;
            }
            int i10 = iB + 3;
            int i11 = bArr2[i10] & 31;
            int i12 = iB - i8;
            if (i12 > 0) {
                a(bArr2, i8, iB);
            }
            int i13 = i9 - iB;
            long j = this.g - i13;
            int i14 = i12 < 0 ? -i12 : 0;
            long j2 = this.m;
            if (!this.l || this.k.c) {
                this.d.b(i14);
                this.e.b(i14);
                if (this.l) {
                    i = i9;
                    bArr = bArr2;
                    w wVar = this.d;
                    if (wVar.c) {
                        u.c cVarE = b.i.a.c.f3.u.e(wVar.d, 3, wVar.e);
                        this.k.d.append(cVarE.d, cVarE);
                        this.d.c();
                    } else {
                        w wVar2 = this.e;
                        if (wVar2.c) {
                            u.b bVarD = b.i.a.c.f3.u.d(wVar2.d, 3, wVar2.e);
                            this.k.e.append(bVarD.a, bVarD);
                            this.e.c();
                        }
                    }
                } else if (this.d.c && this.e.c) {
                    ArrayList arrayList = new ArrayList();
                    w wVar3 = this.d;
                    arrayList.add(Arrays.copyOf(wVar3.d, wVar3.e));
                    w wVar4 = this.e;
                    arrayList.add(Arrays.copyOf(wVar4.d, wVar4.e));
                    w wVar5 = this.d;
                    u.c cVarE2 = b.i.a.c.f3.u.e(wVar5.d, 3, wVar5.e);
                    w wVar6 = this.e;
                    u.b bVarD2 = b.i.a.c.f3.u.d(wVar6.d, 3, wVar6.e);
                    i = i9;
                    String strA = b.i.a.c.f3.h.a(cVarE2.a, cVarE2.f981b, cVarE2.c);
                    b.i.a.c.x2.w wVar7 = this.j;
                    j1.b bVar = new j1.b();
                    bArr = bArr2;
                    bVar.a = this.i;
                    bVar.k = "video/avc";
                    bVar.h = strA;
                    bVar.p = cVarE2.e;
                    bVar.q = cVarE2.f;
                    bVar.t = cVarE2.g;
                    bVar.m = arrayList;
                    wVar7.e(bVar.a());
                    this.l = true;
                    this.k.d.append(cVarE2.d, cVarE2);
                    this.k.e.append(bVarD2.a, bVarD2);
                    this.d.c();
                    this.e.c();
                } else {
                    i = i9;
                    bArr = bArr2;
                }
            }
            if (this.f.b(i14)) {
                w wVar8 = this.f;
                this.o.C(this.f.d, b.i.a.c.f3.u.f(wVar8.d, wVar8.e));
                this.o.E(4);
                b.c.a.a0.d.J(j2, this.o, this.a.f1246b);
            }
            b bVar2 = this.k;
            boolean z4 = this.l;
            boolean z5 = this.n;
            if (bVar2.i == 9) {
                if (z4 && bVar2.o) {
                    long j3 = bVar2.j;
                    int i15 = i13 + ((int) (j - j3));
                    long j4 = bVar2.q;
                    if (j4 != -9223372036854775807L) {
                        bVar2.a.d(j4, bVar2.r ? 1 : 0, (int) (j3 - bVar2.p), i15, null);
                    }
                }
                bVar2.p = bVar2.j;
                bVar2.q = bVar2.l;
                bVar2.r = false;
                bVar2.o = true;
            } else if (bVar2.c) {
                b.a aVar = bVar2.n;
                b.a aVar2 = bVar2.m;
                if (aVar.a) {
                    if (aVar2.a) {
                        u.c cVar = aVar.c;
                        b.c.a.a0.d.H(cVar);
                        u.c cVar2 = aVar2.c;
                        b.c.a.a0.d.H(cVar2);
                        if (aVar.f == aVar2.f && aVar.g == aVar2.g && aVar.h == aVar2.h && ((!aVar.i || !aVar2.i || aVar.j == aVar2.j) && (((i4 = aVar.d) == (i5 = aVar2.d) || (i4 != 0 && i5 != 0)) && (((i6 = cVar.k) != 0 || cVar2.k != 0 || (aVar.m == aVar2.m && aVar.n == aVar2.n)) && ((i6 != 1 || cVar2.k != 1 || (aVar.o == aVar2.o && aVar.p == aVar2.p)) && (z3 = aVar.k) == aVar2.k && (!z3 || aVar.l == aVar2.l)))))) {
                            z2 = false;
                        }
                        if (z2) {
                        }
                    }
                    z2 = true;
                    if (z2) {
                    }
                }
            }
            if (bVar2.f1273b) {
                b.a aVar3 = bVar2.n;
                z5 = aVar3.f1274b && ((i3 = aVar3.e) == 7 || i3 == 2);
            }
            boolean z6 = bVar2.r;
            int i16 = bVar2.i;
            boolean z7 = z6 | (i16 == 5 || (z5 && i16 == 1));
            bVar2.r = z7;
            if (z7) {
                this.n = false;
            }
            long j5 = this.m;
            if (!this.l || this.k.c) {
                this.d.d(i11);
                this.e.d(i11);
            }
            this.f.d(i11);
            b bVar3 = this.k;
            bVar3.i = i11;
            bVar3.l = j5;
            bVar3.j = j;
            if (bVar3.f1273b) {
                i2 = 1;
                if (i11 == 1) {
                    b.a aVar4 = bVar3.m;
                    bVar3.m = bVar3.n;
                    bVar3.n = aVar4;
                    aVar4.f1274b = false;
                    aVar4.a = false;
                    bVar3.h = 0;
                    bVar3.k = true;
                }
                i8 = i10;
                i9 = i;
                bArr2 = bArr;
            } else {
                i2 = 1;
            }
            if (!bVar3.c || (i11 != 5 && i11 != i2 && i11 != 2)) {
            }
            i8 = i10;
            i9 = i;
            bArr2 = bArr;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void c() {
        this.g = 0L;
        this.n = false;
        this.m = -9223372036854775807L;
        b.i.a.c.f3.u.a(this.h);
        this.d.c();
        this.e.c();
        this.f.c();
        b bVar = this.k;
        if (bVar != null) {
            bVar.k = false;
            bVar.o = false;
            b.a aVar = bVar.n;
            aVar.f1274b = false;
            aVar.a = false;
        }
    }

    @Override // b.i.a.c.x2.k0.o
    public void d() {
    }

    @Override // b.i.a.c.x2.k0.o
    public void e(b.i.a.c.x2.j jVar, i0.d dVar) {
        dVar.a();
        this.i = dVar.b();
        b.i.a.c.x2.w wVarP = jVar.p(dVar.c(), 2);
        this.j = wVarP;
        this.k = new b(wVarP, this.f1272b, this.c);
        this.a.a(jVar, dVar);
    }

    @Override // b.i.a.c.x2.k0.o
    public void f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.m = j;
        }
        this.n |= (i & 2) != 0;
    }
}
