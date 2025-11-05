package b.i.a.c.x2.k0;

import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.Nullable;
import b.i.a.c.x2.k0.i0;
import b.i.a.c.x2.t;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* compiled from: TsExtractor.java */
/* loaded from: classes3.dex */
public final class h0 implements b.i.a.c.x2.h {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1252b;
    public final List<b.i.a.c.f3.d0> c;
    public final b.i.a.c.f3.x d;
    public final SparseIntArray e;
    public final i0.c f;
    public final SparseArray<i0> g;
    public final SparseBooleanArray h;
    public final SparseBooleanArray i;
    public final g0 j;
    public f0 k;
    public b.i.a.c.x2.j l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;

    @Nullable
    public i0 q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public int f1253s;

    /* compiled from: TsExtractor.java */
    public class a implements c0 {
        public final b.i.a.c.f3.w a = new b.i.a.c.f3.w(new byte[4]);

        public a() {
        }

        @Override // b.i.a.c.x2.k0.c0
        public void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, i0.d dVar) {
        }

        @Override // b.i.a.c.x2.k0.c0
        public void b(b.i.a.c.f3.x xVar) {
            if (xVar.t() == 0 && (xVar.t() & 128) != 0) {
                xVar.F(6);
                int iA = xVar.a() / 4;
                for (int i = 0; i < iA; i++) {
                    xVar.d(this.a, 4);
                    int iG = this.a.g(16);
                    this.a.m(3);
                    if (iG == 0) {
                        this.a.m(13);
                    } else {
                        int iG2 = this.a.g(13);
                        if (h0.this.g.get(iG2) == null) {
                            h0 h0Var = h0.this;
                            h0Var.g.put(iG2, new d0(h0Var.new b(iG2)));
                            h0.this.m++;
                        }
                    }
                }
                h0 h0Var2 = h0.this;
                if (h0Var2.a != 2) {
                    h0Var2.g.remove(0);
                }
            }
        }
    }

    /* compiled from: TsExtractor.java */
    public class b implements c0 {
        public final b.i.a.c.f3.w a = new b.i.a.c.f3.w(new byte[5]);

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray<i0> f1255b = new SparseArray<>();
        public final SparseIntArray c = new SparseIntArray();
        public final int d;

        public b(int i) {
            this.d = i;
        }

        @Override // b.i.a.c.x2.k0.c0
        public void a(b.i.a.c.f3.d0 d0Var, b.i.a.c.x2.j jVar, i0.d dVar) {
        }

        /* JADX WARN: Removed duplicated region for block: B:47:0x012c  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x0134  */
        /* JADX WARN: Removed duplicated region for block: B:56:0x0141  */
        @Override // b.i.a.c.x2.k0.c0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(b.i.a.c.f3.x xVar) {
            b.i.a.c.f3.d0 d0Var;
            b.i.a.c.f3.d0 d0Var2;
            int i;
            int i2;
            int i3;
            b.i.a.c.f3.d0 d0Var3;
            int i4;
            if (xVar.t() != 2) {
                return;
            }
            h0 h0Var = h0.this;
            int i5 = h0Var.a;
            if (i5 == 1 || i5 == 2 || h0Var.m == 1) {
                d0Var = h0Var.c.get(0);
            } else {
                d0Var = new b.i.a.c.f3.d0(h0Var.c.get(0).c());
                h0.this.c.add(d0Var);
            }
            if ((xVar.t() & 128) == 0) {
                return;
            }
            xVar.F(1);
            int iY = xVar.y();
            int i6 = 3;
            xVar.F(3);
            xVar.d(this.a, 2);
            this.a.m(3);
            int i7 = 13;
            h0.this.f1253s = this.a.g(13);
            xVar.d(this.a, 2);
            int i8 = 4;
            this.a.m(4);
            int i9 = 12;
            xVar.F(this.a.g(12));
            h0 h0Var2 = h0.this;
            int i10 = 21;
            if (h0Var2.a == 2 && h0Var2.q == null) {
                i0.b bVar = new i0.b(21, null, null, b.i.a.c.f3.e0.f);
                h0 h0Var3 = h0.this;
                h0Var3.q = h0Var3.f.a(21, bVar);
                h0 h0Var4 = h0.this;
                i0 i0Var = h0Var4.q;
                if (i0Var != null) {
                    i0Var.a(d0Var, h0Var4.l, new i0.d(iY, 21, 8192));
                }
            }
            this.f1255b.clear();
            this.c.clear();
            int iA = xVar.a();
            while (iA > 0) {
                int i11 = 5;
                xVar.d(this.a, 5);
                int iG = this.a.g(8);
                this.a.m(i6);
                int iG2 = this.a.g(i7);
                this.a.m(i8);
                int iG3 = this.a.g(i9);
                int i12 = xVar.f984b;
                int i13 = iG3 + i12;
                int i14 = -1;
                String strTrim = null;
                ArrayList arrayList = null;
                while (xVar.f984b < i13) {
                    int iT = xVar.t();
                    int iT2 = xVar.f984b + xVar.t();
                    if (iT2 > i13) {
                        break;
                    }
                    if (iT == i11) {
                        long jU = xVar.u();
                        if (jU == 1094921523) {
                            i14 = Opcodes.LOR;
                        } else if (jU == 1161904947) {
                            i14 = Opcodes.I2D;
                        } else if (jU == 1094921524) {
                            i14 = Opcodes.IRETURN;
                        } else if (jU == 1212503619) {
                            i14 = 36;
                        }
                        i3 = iY;
                        d0Var3 = d0Var;
                        i4 = iG2;
                    } else {
                        if (iT != 106) {
                            if (iT != 122) {
                                if (iT == 127) {
                                    if (xVar.t() == i10) {
                                    }
                                } else if (iT == 123) {
                                    i14 = Opcodes.L2D;
                                } else if (iT == 10) {
                                    strTrim = xVar.q(3).trim();
                                    i3 = iY;
                                    d0Var3 = d0Var;
                                    i4 = iG2;
                                } else {
                                    int i15 = 3;
                                    if (iT == 89) {
                                        ArrayList arrayList2 = new ArrayList();
                                        while (xVar.f984b < iT2) {
                                            String strTrim2 = xVar.q(i15).trim();
                                            int iT3 = xVar.t();
                                            byte[] bArr = new byte[4];
                                            System.arraycopy(xVar.a, xVar.f984b, bArr, 0, 4);
                                            xVar.f984b += 4;
                                            arrayList2.add(new i0.a(strTrim2, iT3, bArr));
                                            d0Var = d0Var;
                                            iY = iY;
                                            iG2 = iG2;
                                            i15 = 3;
                                        }
                                        i3 = iY;
                                        d0Var3 = d0Var;
                                        i4 = iG2;
                                        arrayList = arrayList2;
                                        i14 = 89;
                                    } else {
                                        i3 = iY;
                                        d0Var3 = d0Var;
                                        i4 = iG2;
                                        if (iT == 111) {
                                            i14 = 257;
                                        }
                                    }
                                }
                            }
                        }
                        i3 = iY;
                        d0Var3 = d0Var;
                        i4 = iG2;
                    }
                    xVar.F(iT2 - xVar.f984b);
                    d0Var = d0Var3;
                    iY = i3;
                    iG2 = i4;
                    i11 = 5;
                    i10 = 21;
                }
                int i16 = iY;
                b.i.a.c.f3.d0 d0Var4 = d0Var;
                int i17 = iG2;
                xVar.E(i13);
                i0.b bVar2 = new i0.b(i14, strTrim, arrayList, Arrays.copyOfRange(xVar.a, i12, i13));
                if (iG == 6 || iG == 5) {
                    iG = i14;
                }
                iA -= iG3 + 5;
                h0 h0Var5 = h0.this;
                int i18 = h0Var5.a == 2 ? iG : i17;
                if (!h0Var5.h.get(i18)) {
                    h0 h0Var6 = h0.this;
                    i0 i0VarA = (h0Var6.a == 2 && iG == 21) ? h0Var6.q : h0Var6.f.a(iG, bVar2);
                    if (h0.this.a == 2) {
                        i2 = i17;
                        if (i2 < this.c.get(i18, 8192)) {
                        }
                    } else {
                        i2 = i17;
                    }
                    this.c.put(i18, i2);
                    this.f1255b.put(i18, i0VarA);
                }
                d0Var = d0Var4;
                iY = i16;
                i6 = 3;
                i8 = 4;
                i7 = 13;
                i9 = 12;
                i10 = 21;
            }
            int i19 = iY;
            b.i.a.c.f3.d0 d0Var5 = d0Var;
            int size = this.c.size();
            int i20 = 0;
            while (i20 < size) {
                int iKeyAt = this.c.keyAt(i20);
                int iValueAt = this.c.valueAt(i20);
                h0.this.h.put(iKeyAt, true);
                h0.this.i.put(iValueAt, true);
                i0 i0VarValueAt = this.f1255b.valueAt(i20);
                if (i0VarValueAt != null) {
                    h0 h0Var7 = h0.this;
                    if (i0VarValueAt != h0Var7.q) {
                        b.i.a.c.x2.j jVar = h0Var7.l;
                        i = i19;
                        i0.d dVar = new i0.d(i, iKeyAt, 8192);
                        d0Var2 = d0Var5;
                        i0VarValueAt.a(d0Var2, jVar, dVar);
                    } else {
                        d0Var2 = d0Var5;
                        i = i19;
                    }
                    h0.this.g.put(iValueAt, i0VarValueAt);
                } else {
                    d0Var2 = d0Var5;
                    i = i19;
                }
                i20++;
                d0Var5 = d0Var2;
                i19 = i;
            }
            h0 h0Var8 = h0.this;
            if (h0Var8.a == 2) {
                if (h0Var8.n) {
                    return;
                }
                h0Var8.l.j();
                h0 h0Var9 = h0.this;
                h0Var9.m = 0;
                h0Var9.n = true;
                return;
            }
            h0Var8.g.remove(this.d);
            h0 h0Var10 = h0.this;
            int i21 = h0Var10.a == 1 ? 0 : h0Var10.m - 1;
            h0Var10.m = i21;
            if (i21 == 0) {
                h0Var10.l.j();
                h0.this.n = true;
            }
        }
    }

    static {
        e eVar = e.a;
    }

    public h0(int i, int i2, int i3) {
        b.i.a.c.f3.d0 d0Var = new b.i.a.c.f3.d0(0L);
        l lVar = new l(i2);
        this.f = lVar;
        this.f1252b = i3;
        this.a = i;
        if (i == 1 || i == 2) {
            this.c = Collections.singletonList(d0Var);
        } else {
            ArrayList arrayList = new ArrayList();
            this.c = arrayList;
            arrayList.add(d0Var);
        }
        this.d = new b.i.a.c.f3.x(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.h = sparseBooleanArray;
        this.i = new SparseBooleanArray();
        SparseArray<i0> sparseArray = new SparseArray<>();
        this.g = sparseArray;
        this.e = new SparseIntArray();
        this.j = new g0(i3);
        this.l = b.i.a.c.x2.j.d;
        this.f1253s = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray<i0> sparseArrayB = lVar.b();
        int size = sparseArrayB.size();
        for (int i4 = 0; i4 < size; i4++) {
            this.g.put(sparseArrayB.keyAt(i4), sparseArrayB.valueAt(i4));
        }
        this.g.put(0, new d0(new a()));
        this.q = null;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        boolean z2;
        byte[] bArr = this.d.a;
        iVar.o(bArr, 0, 940);
        for (int i = 0; i < 188; i++) {
            int i2 = 0;
            while (true) {
                if (i2 >= 5) {
                    z2 = true;
                    break;
                }
                if (bArr[(i2 * Opcodes.NEWARRAY) + i] != 71) {
                    z2 = false;
                    break;
                }
                i2++;
            }
            if (z2) {
                iVar.l(i);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v9 */
    @Override // b.i.a.c.x2.h
    public int e(b.i.a.c.x2.i iVar, b.i.a.c.x2.s sVar) throws IOException {
        ?? r0;
        ?? r1;
        boolean z2;
        int i;
        boolean z3;
        boolean z4;
        long jB = iVar.b();
        int i2 = 1;
        if (this.n) {
            long j = -9223372036854775807L;
            if ((jB == -1 || this.a == 2) ? false : true) {
                g0 g0Var = this.j;
                if (!g0Var.d) {
                    int i3 = this.f1253s;
                    if (i3 <= 0) {
                        g0Var.a(iVar);
                        return 0;
                    }
                    if (!g0Var.f) {
                        long jB2 = iVar.b();
                        int iMin = (int) Math.min(g0Var.a, jB2);
                        long j2 = jB2 - iMin;
                        if (iVar.getPosition() != j2) {
                            sVar.a = j2;
                        } else {
                            g0Var.c.A(iMin);
                            iVar.k();
                            iVar.o(g0Var.c.a, 0, iMin);
                            b.i.a.c.f3.x xVar = g0Var.c;
                            int i4 = xVar.f984b;
                            int i5 = xVar.c;
                            int i6 = i5 - 188;
                            while (true) {
                                if (i6 < i4) {
                                    break;
                                }
                                byte[] bArr = xVar.a;
                                int i7 = -4;
                                int i8 = 0;
                                while (true) {
                                    if (i7 > 4) {
                                        z4 = false;
                                        break;
                                    }
                                    int i9 = (i7 * Opcodes.NEWARRAY) + i6;
                                    if (i9 < i4 || i9 >= i5 || bArr[i9] != 71) {
                                        i8 = 0;
                                    } else {
                                        i8++;
                                        if (i8 == 5) {
                                            z4 = true;
                                            break;
                                        }
                                    }
                                    i7++;
                                }
                                if (z4) {
                                    long jK1 = b.c.a.a0.d.K1(xVar, i6, i3);
                                    if (jK1 != -9223372036854775807L) {
                                        j = jK1;
                                        break;
                                    }
                                }
                                i6--;
                            }
                            g0Var.h = j;
                            g0Var.f = true;
                            i2 = 0;
                        }
                    } else {
                        if (g0Var.h == -9223372036854775807L) {
                            g0Var.a(iVar);
                            return 0;
                        }
                        if (g0Var.e) {
                            long j3 = g0Var.g;
                            if (j3 == -9223372036854775807L) {
                                g0Var.a(iVar);
                                return 0;
                            }
                            long jB3 = g0Var.f1250b.b(g0Var.h) - g0Var.f1250b.b(j3);
                            g0Var.i = jB3;
                            if (jB3 < 0) {
                                Log.w("TsDurationReader", b.d.b.a.a.i(65, "Invalid duration: ", jB3, ". Using TIME_UNSET instead."));
                                g0Var.i = -9223372036854775807L;
                            }
                            g0Var.a(iVar);
                            return 0;
                        }
                        int iMin2 = (int) Math.min(g0Var.a, iVar.b());
                        long j4 = 0;
                        if (iVar.getPosition() != j4) {
                            sVar.a = j4;
                        } else {
                            g0Var.c.A(iMin2);
                            iVar.k();
                            iVar.o(g0Var.c.a, 0, iMin2);
                            b.i.a.c.f3.x xVar2 = g0Var.c;
                            int i10 = xVar2.f984b;
                            int i11 = xVar2.c;
                            while (true) {
                                if (i10 >= i11) {
                                    break;
                                }
                                if (xVar2.a[i10] == 71) {
                                    long jK12 = b.c.a.a0.d.K1(xVar2, i10, i3);
                                    if (jK12 != -9223372036854775807L) {
                                        j = jK12;
                                        break;
                                    }
                                }
                                i10++;
                            }
                            g0Var.g = j;
                            g0Var.e = true;
                            i2 = 0;
                        }
                    }
                    return i2;
                }
            }
            if (!this.o) {
                this.o = true;
                g0 g0Var2 = this.j;
                long j5 = g0Var2.i;
                if (j5 != -9223372036854775807L) {
                    f0 f0Var = new f0(g0Var2.f1250b, j5, jB, this.f1253s, this.f1252b);
                    this.k = f0Var;
                    this.l.a(f0Var.a);
                } else {
                    this.l.a(new t.b(j5, 0L));
                }
            }
            if (this.p) {
                z3 = false;
                this.p = false;
                g(0L, 0L);
                if (iVar.getPosition() != 0) {
                    sVar.a = 0L;
                    return 1;
                }
            } else {
                z3 = false;
            }
            r1 = 1;
            r1 = 1;
            f0 f0Var2 = this.k;
            r0 = z3;
            if (f0Var2 != null) {
                r0 = z3;
                if (f0Var2.b()) {
                    return this.k.a(iVar, sVar);
                }
            }
        } else {
            r0 = 0;
            r1 = 1;
        }
        b.i.a.c.f3.x xVar3 = this.d;
        byte[] bArr2 = xVar3.a;
        if (9400 - xVar3.f984b < 188) {
            int iA = xVar3.a();
            if (iA > 0) {
                System.arraycopy(bArr2, this.d.f984b, bArr2, r0, iA);
            }
            this.d.C(bArr2, iA);
        }
        while (true) {
            if (this.d.a() >= 188) {
                z2 = true;
                break;
            }
            int i12 = this.d.c;
            int i13 = iVar.read(bArr2, i12, 9400 - i12);
            if (i13 == -1) {
                z2 = false;
                break;
            }
            this.d.D(i12 + i13);
        }
        if (!z2) {
            return -1;
        }
        b.i.a.c.f3.x xVar4 = this.d;
        int i14 = xVar4.f984b;
        int i15 = xVar4.c;
        byte[] bArr3 = xVar4.a;
        int i16 = i14;
        while (i16 < i15 && bArr3[i16] != 71) {
            i16++;
        }
        this.d.E(i16);
        int i17 = i16 + Opcodes.NEWARRAY;
        if (i17 > i15) {
            int i18 = (i16 - i14) + this.r;
            this.r = i18;
            i = 2;
            if (this.a == 2 && i18 > 376) {
                throw ParserException.a("Cannot find sync byte. Most likely not a Transport Stream.", null);
            }
        } else {
            i = 2;
            this.r = r0;
        }
        b.i.a.c.f3.x xVar5 = this.d;
        int i19 = xVar5.c;
        if (i17 > i19) {
            return r0;
        }
        int iF = xVar5.f();
        if ((8388608 & iF) != 0) {
            this.d.E(i17);
            return r0;
        }
        int i20 = ((4194304 & iF) != 0 ? 1 : 0) | 0;
        int i21 = (2096896 & iF) >> 8;
        boolean z5 = (iF & 32) != 0;
        i0 i0Var = (iF & 16) != 0 ? this.g.get(i21) : null;
        if (i0Var == null) {
            this.d.E(i17);
            return r0;
        }
        if (this.a != i) {
            int i22 = iF & 15;
            int i23 = this.e.get(i21, i22 - 1);
            this.e.put(i21, i22);
            if (i23 == i22) {
                this.d.E(i17);
                return r0;
            }
            if (i22 != ((i23 + r1) & 15)) {
                i0Var.c();
            }
        }
        if (z5) {
            int iT = this.d.t();
            i20 |= (this.d.t() & 64) != 0 ? 2 : 0;
            this.d.F(iT - r1);
        }
        boolean z6 = this.n;
        if (this.a == i || z6 || !this.i.get(i21, r0)) {
            this.d.D(i17);
            i0Var.b(this.d, i20);
            this.d.D(i19);
        }
        if (this.a != i && !z6 && this.n && jB != -1) {
            this.p = r1;
        }
        this.d.E(i17);
        return r0;
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.l = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        f0 f0Var;
        b.c.a.a0.d.D(this.a != 2);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            b.i.a.c.f3.d0 d0Var = this.c.get(i);
            boolean z2 = d0Var.d() == -9223372036854775807L;
            if (!z2) {
                long jC = d0Var.c();
                z2 = (jC == -9223372036854775807L || jC == 0 || jC == j2) ? false : true;
            }
            if (z2) {
                d0Var.e(j2);
            }
        }
        if (j2 != 0 && (f0Var = this.k) != null) {
            f0Var.e(j2);
        }
        this.d.A(0);
        this.e.clear();
        for (int i2 = 0; i2 < this.g.size(); i2++) {
            this.g.valueAt(i2).c();
        }
        this.r = 0;
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
