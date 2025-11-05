package b.i.a.c.x2.i0;

import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.u;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.x2.i0.d;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.w;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import org.objectweb.asm.Opcodes;

/* compiled from: FragmentedMp4Extractor.java */
/* loaded from: classes3.dex */
public class g implements b.i.a.c.x2.h {
    public static final byte[] a = {-94, 57, 79, 82, 90, -101, 79, 20, -94, 68, 108, 66, 124, 100, -115, -12};

    /* renamed from: b, reason: collision with root package name */
    public static final j1 f1215b;
    public int A;
    public int B;
    public boolean C;
    public b.i.a.c.x2.j D;
    public w[] E;
    public w[] F;
    public boolean G;
    public final int c;
    public final List<j1> d;
    public final SparseArray<b> e;
    public final x f;
    public final x g;
    public final x h;
    public final byte[] i;
    public final x j;
    public final b.i.a.c.z2.i.b k;
    public final x l;
    public final ArrayDeque<d.a> m;
    public final ArrayDeque<a> n;
    public int o;
    public int p;
    public long q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public x f1216s;
    public long t;
    public int u;
    public long v;
    public long w;

    /* renamed from: x, reason: collision with root package name */
    public long f1217x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public b f1218y;

    /* renamed from: z, reason: collision with root package name */
    public int f1219z;

    /* compiled from: FragmentedMp4Extractor.java */
    public static final class a {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final int f1220b;

        public a(long j, int i) {
            this.a = j;
            this.f1220b = i;
        }
    }

    /* compiled from: FragmentedMp4Extractor.java */
    public static final class b {
        public final w a;
        public p d;
        public f e;
        public int f;
        public int g;
        public int h;
        public int i;
        public boolean l;

        /* renamed from: b, reason: collision with root package name */
        public final o f1221b = new o();
        public final x c = new x();
        public final x j = new x(1);
        public final x k = new x();

        public b(w wVar, p pVar, f fVar) {
            this.a = wVar;
            this.d = pVar;
            this.e = fVar;
            this.d = pVar;
            this.e = fVar;
            wVar.e(pVar.a.f);
            e();
        }

        public long a() {
            return !this.l ? this.d.c[this.f] : this.f1221b.f[this.h];
        }

        @Nullable
        public n b() {
            if (!this.l) {
                return null;
            }
            o oVar = this.f1221b;
            f fVar = oVar.a;
            int i = e0.a;
            int i2 = fVar.a;
            n nVarA = oVar.m;
            if (nVarA == null) {
                nVarA = this.d.a.a(i2);
            }
            if (nVarA == null || !nVarA.a) {
                return null;
            }
            return nVarA;
        }

        public boolean c() {
            this.f++;
            if (!this.l) {
                return false;
            }
            int i = this.g + 1;
            this.g = i;
            int[] iArr = this.f1221b.g;
            int i2 = this.h;
            if (i != iArr[i2]) {
                return true;
            }
            this.h = i2 + 1;
            this.g = 0;
            return false;
        }

        public int d(int i, int i2) {
            x xVar;
            n nVarB = b();
            if (nVarB == null) {
                return 0;
            }
            int length = nVarB.d;
            if (length != 0) {
                xVar = this.f1221b.n;
            } else {
                byte[] bArr = nVarB.e;
                int i3 = e0.a;
                x xVar2 = this.k;
                int length2 = bArr.length;
                xVar2.a = bArr;
                xVar2.c = length2;
                xVar2.f984b = 0;
                length = bArr.length;
                xVar = xVar2;
            }
            o oVar = this.f1221b;
            boolean z2 = oVar.k && oVar.l[this.f];
            boolean z3 = z2 || i2 != 0;
            x xVar3 = this.j;
            xVar3.a[0] = (byte) ((z3 ? 128 : 0) | length);
            xVar3.E(0);
            this.a.f(this.j, 1, 1);
            this.a.f(xVar, length, 1);
            if (!z3) {
                return length + 1;
            }
            if (!z2) {
                this.c.A(8);
                x xVar4 = this.c;
                byte[] bArr2 = xVar4.a;
                bArr2[0] = 0;
                bArr2[1] = 1;
                bArr2[2] = (byte) ((i2 >> 8) & 255);
                bArr2[3] = (byte) (i2 & 255);
                bArr2[4] = (byte) ((i >> 24) & 255);
                bArr2[5] = (byte) ((i >> 16) & 255);
                bArr2[6] = (byte) ((i >> 8) & 255);
                bArr2[7] = (byte) (i & 255);
                this.a.f(xVar4, 8, 1);
                return length + 1 + 8;
            }
            x xVar5 = this.f1221b.n;
            int iY = xVar5.y();
            xVar5.F(-2);
            int i4 = (iY * 6) + 2;
            if (i2 != 0) {
                this.c.A(i4);
                byte[] bArr3 = this.c.a;
                xVar5.e(bArr3, 0, i4);
                int i5 = (((bArr3[2] & 255) << 8) | (bArr3[3] & 255)) + i2;
                bArr3[2] = (byte) ((i5 >> 8) & 255);
                bArr3[3] = (byte) (i5 & 255);
                xVar5 = this.c;
            }
            this.a.f(xVar5, i4, 1);
            return length + 1 + i4;
        }

        public void e() {
            o oVar = this.f1221b;
            oVar.d = 0;
            oVar.p = 0L;
            oVar.q = false;
            oVar.k = false;
            oVar.o = false;
            oVar.m = null;
            this.f = 0;
            this.h = 0;
            this.g = 0;
            this.i = 0;
            this.l = false;
        }
    }

    static {
        j1.b bVar = new j1.b();
        bVar.k = "application/x-emsg";
        f1215b = bVar.a();
    }

    public g(int i) {
        List listEmptyList = Collections.emptyList();
        this.c = i;
        this.d = Collections.unmodifiableList(listEmptyList);
        this.k = new b.i.a.c.z2.i.b();
        this.l = new x(16);
        this.f = new x(u.a);
        this.g = new x(5);
        this.h = new x();
        byte[] bArr = new byte[16];
        this.i = bArr;
        this.j = new x(bArr);
        this.m = new ArrayDeque<>();
        this.n = new ArrayDeque<>();
        this.e = new SparseArray<>();
        this.w = -9223372036854775807L;
        this.v = -9223372036854775807L;
        this.f1217x = -9223372036854775807L;
        this.D = b.i.a.c.x2.j.d;
        this.E = new w[0];
        this.F = new w[0];
    }

    public static int a(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw b.d.b.a.a.w0(38, "Unexpected negative value: ", i, null);
    }

    @Nullable
    public static DrmInitData h(List<d.b> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            d.b bVar = list.get(i);
            if (bVar.a == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] bArr = bVar.f1210b.a;
                j jVarV1 = b.c.a.a0.d.v1(bArr);
                UUID uuid = jVarV1 == null ? null : jVarV1.a;
                if (uuid == null) {
                    Log.w("FragmentedMp4Extractor", "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(uuid, "video/mp4", bArr));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData(null, false, (DrmInitData.SchemeData[]) arrayList.toArray(new DrmInitData.SchemeData[0]));
    }

    public static void i(x xVar, int i, o oVar) throws ParserException {
        xVar.E(i + 8);
        int iF = xVar.f() & ViewCompat.MEASURED_SIZE_MASK;
        if ((iF & 1) != 0) {
            throw ParserException.b("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z2 = (iF & 2) != 0;
        int iW = xVar.w();
        if (iW == 0) {
            Arrays.fill(oVar.l, 0, oVar.e, false);
            return;
        }
        int i2 = oVar.e;
        if (iW != i2) {
            throw ParserException.a(b.d.b.a.a.h(80, "Senc sample count ", iW, " is different from fragment sample count", i2), null);
        }
        Arrays.fill(oVar.l, 0, iW, z2);
        int iA = xVar.a();
        x xVar2 = oVar.n;
        byte[] bArr = xVar2.a;
        if (bArr.length < iA) {
            bArr = new byte[iA];
        }
        xVar2.a = bArr;
        xVar2.c = iA;
        xVar2.f984b = 0;
        oVar.k = true;
        oVar.o = true;
        xVar.e(bArr, 0, iA);
        oVar.n.E(0);
        oVar.o = false;
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        return l.a(iVar, true, false);
    }

    public final void c() {
        this.o = 0;
        this.r = 0;
    }

    public final f d(SparseArray<f> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        f fVar = sparseArray.get(i);
        Objects.requireNonNull(fVar);
        return fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0236 A[LOOP:10: B:106:0x0236->B:108:0x023c, LOOP_START] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0588  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x059f  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x05d9  */
    /* JADX WARN: Removed duplicated region for block: B:345:0x02cb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x0759 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:357:0x0762 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:359:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0004 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0148  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ca  */
    @Override // b.i.a.c.x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(b.i.a.c.x2.i iVar, s sVar) throws IOException {
        int i;
        int iB;
        String strN;
        String strN2;
        long jF;
        long j;
        long jU;
        long jX;
        long jX2;
        long j2;
        boolean z2;
        while (true) {
            int i2 = this.o;
            int i3 = 1;
            if (i2 != 0) {
                if (i2 == 1) {
                    int i4 = ((int) this.q) - this.r;
                    x xVar = this.f1216s;
                    if (xVar != null) {
                        iVar.readFully(xVar.a, 8, i4);
                        int i5 = this.p;
                        d.b bVar = new d.b(i5, xVar);
                        long position = iVar.getPosition();
                        if (!this.m.isEmpty()) {
                            this.m.peek().c.add(bVar);
                        } else if (i5 == 1936286840) {
                            xVar.E(8);
                            int iF = (xVar.f() >> 24) & 255;
                            xVar.F(4);
                            long jU2 = xVar.u();
                            if (iF == 0) {
                                jX = xVar.u();
                                jX2 = xVar.u();
                            } else {
                                jX = xVar.x();
                                jX2 = xVar.x();
                            }
                            long j3 = position + jX2;
                            long jF2 = e0.F(jX, 1000000L, jU2);
                            xVar.F(2);
                            int iY = xVar.y();
                            int[] iArr = new int[iY];
                            long[] jArr = new long[iY];
                            long[] jArr2 = new long[iY];
                            long[] jArr3 = new long[iY];
                            int i6 = 0;
                            long jF3 = jF2;
                            while (i6 < iY) {
                                int iF2 = xVar.f();
                                if ((iF2 & Integer.MIN_VALUE) != 0) {
                                    throw ParserException.a("Unhandled indirect reference", null);
                                }
                                long jU3 = xVar.u();
                                iArr[i6] = iF2 & Integer.MAX_VALUE;
                                jArr[i6] = j3;
                                jArr3[i6] = jF3;
                                long j4 = jX + jU3;
                                int i7 = i6;
                                int i8 = iY;
                                long[] jArr4 = jArr2;
                                long[] jArr5 = jArr3;
                                jF3 = e0.F(j4, 1000000L, jU2);
                                jArr4[i7] = jF3 - jArr5[i7];
                                xVar.F(4);
                                j3 += iArr[i7];
                                i6 = i7 + 1;
                                jArr2 = jArr4;
                                jArr3 = jArr5;
                                jArr = jArr;
                                jX = j4;
                                iY = i8;
                            }
                            Pair pairCreate = Pair.create(Long.valueOf(jF2), new b.i.a.c.x2.c(iArr, jArr, jArr2, jArr3));
                            this.f1217x = ((Long) pairCreate.first).longValue();
                            this.D.a((t) pairCreate.second);
                            this.G = true;
                        } else if (i5 == 1701671783 && this.E.length != 0) {
                            xVar.E(8);
                            int iF3 = (xVar.f() >> 24) & 255;
                            if (iF3 == 0) {
                                strN = xVar.n();
                                Objects.requireNonNull(strN);
                                strN2 = xVar.n();
                                Objects.requireNonNull(strN2);
                                long jU4 = xVar.u();
                                long jF4 = e0.F(xVar.u(), 1000000L, jU4);
                                long j5 = this.f1217x;
                                j = j5 != -9223372036854775807L ? j5 + jF4 : -9223372036854775807L;
                                jF = e0.F(xVar.u(), 1000L, jU4);
                                j = j;
                                j = jF4;
                                jU = xVar.u();
                            } else if (iF3 != 1) {
                                b.d.b.a.a.g0(46, "Skipping unsupported emsg version: ", iF3, "FragmentedMp4Extractor");
                            } else {
                                long jU5 = xVar.u();
                                long jF5 = e0.F(xVar.x(), 1000000L, jU5);
                                jF = e0.F(xVar.u(), 1000L, jU5);
                                jU = xVar.u();
                                strN = xVar.n();
                                Objects.requireNonNull(strN);
                                strN2 = xVar.n();
                                Objects.requireNonNull(strN2);
                                j = jF5;
                            }
                            byte[] bArr = new byte[xVar.a()];
                            int iA = xVar.a();
                            System.arraycopy(xVar.a, xVar.f984b, bArr, 0, iA);
                            xVar.f984b += iA;
                            b.i.a.c.z2.i.b bVar2 = this.k;
                            bVar2.a.reset();
                            try {
                                DataOutputStream dataOutputStream = bVar2.f1322b;
                                dataOutputStream.writeBytes(strN);
                                dataOutputStream.writeByte(0);
                                DataOutputStream dataOutputStream2 = bVar2.f1322b;
                                dataOutputStream2.writeBytes(strN2);
                                dataOutputStream2.writeByte(0);
                                bVar2.f1322b.writeLong(jF);
                                bVar2.f1322b.writeLong(jU);
                                bVar2.f1322b.write(bArr);
                                bVar2.f1322b.flush();
                                x xVar2 = new x(bVar2.a.toByteArray());
                                int iA2 = xVar2.a();
                                for (w wVar : this.E) {
                                    xVar2.E(0);
                                    wVar.c(xVar2, iA2);
                                }
                                if (j == -9223372036854775807L) {
                                    this.n.addLast(new a(j, iA2));
                                    this.u += iA2;
                                } else {
                                    for (w wVar2 : this.E) {
                                        wVar2.d(j, 1, iA2, 0, null);
                                    }
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        iVar.l(i4);
                    }
                    j(iVar.getPosition());
                } else if (i2 != 2) {
                    b bVar3 = this.f1218y;
                    if (bVar3 == null) {
                        SparseArray<b> sparseArray = this.e;
                        int size = sparseArray.size();
                        long j6 = Long.MAX_VALUE;
                        b bVar4 = null;
                        for (int i9 = 0; i9 < size; i9++) {
                            b bVarValueAt = sparseArray.valueAt(i9);
                            boolean z3 = bVarValueAt.l;
                            if ((z3 || bVarValueAt.f != bVarValueAt.d.f1233b) && (!z3 || bVarValueAt.h != bVarValueAt.f1221b.d)) {
                                long jA = bVarValueAt.a();
                                if (jA < j6) {
                                    bVar4 = bVarValueAt;
                                    j6 = jA;
                                }
                            }
                        }
                        if (bVar4 == null) {
                            int position2 = (int) (this.t - iVar.getPosition());
                            if (position2 < 0) {
                                throw ParserException.a("Offset to end of mdat was negative.", null);
                            }
                            iVar.l(position2);
                            c();
                            i3 = 0;
                            if (i3 == 0) {
                                return 0;
                            }
                        } else {
                            int iA3 = (int) (bVar4.a() - iVar.getPosition());
                            if (iA3 < 0) {
                                Log.w("FragmentedMp4Extractor", "Ignoring negative offset to sample data.");
                                iA3 = 0;
                            }
                            iVar.l(iA3);
                            this.f1218y = bVar4;
                            bVar3 = bVar4;
                            char c = 6;
                            if (this.o != 3) {
                                p pVar = bVar3.d;
                                m mVar = pVar.a;
                                w wVar3 = bVar3.a;
                                long j7 = bVar3.l ? pVar.f[bVar3.f] : bVar3.f1221b.i[bVar3.f];
                                i = mVar.j;
                                if (i != 0) {
                                    while (true) {
                                        int i10 = this.A;
                                        int i11 = this.f1219z;
                                        if (i10 >= i11) {
                                            break;
                                        }
                                        this.A += wVar3.b(iVar, i11 - i10, false);
                                    }
                                } else {
                                    byte[] bArr2 = this.g.a;
                                    bArr2[0] = 0;
                                    bArr2[1] = 0;
                                    bArr2[2] = 0;
                                    int i12 = i + 1;
                                    int i13 = 4 - i;
                                    while (this.A < this.f1219z) {
                                        int i14 = this.B;
                                        if (i14 == 0) {
                                            iVar.readFully(bArr2, i13, i12);
                                            this.g.E(0);
                                            int iF4 = this.g.f();
                                            if (iF4 < i3) {
                                                throw ParserException.a("Invalid NAL length", null);
                                            }
                                            this.B = iF4 - 1;
                                            this.f.E(0);
                                            wVar3.c(this.f, 4);
                                            wVar3.c(this.g, i3);
                                            if (this.F.length > 0) {
                                                String str = mVar.f.w;
                                                byte b2 = bArr2[4];
                                                byte[] bArr3 = u.a;
                                                boolean z4 = ("video/avc".equals(str) && (b2 & 31) == c) || ("video/hevc".equals(str) && ((b2 & 126) >> i3) == 39);
                                                this.C = z4;
                                                this.A += 5;
                                                this.f1219z += i13;
                                            }
                                        } else {
                                            if (this.C) {
                                                this.h.A(i14);
                                                iVar.readFully(this.h.a, 0, this.B);
                                                wVar3.c(this.h, this.B);
                                                iB = this.B;
                                                x xVar3 = this.h;
                                                int iF5 = u.f(xVar3.a, xVar3.c);
                                                this.h.E("video/hevc".equals(mVar.f.w) ? 1 : 0);
                                                this.h.D(iF5);
                                                b.c.a.a0.d.J(j7, this.h, this.F);
                                            } else {
                                                iB = wVar3.b(iVar, i14, false);
                                            }
                                            this.A += iB;
                                            this.B -= iB;
                                            c = 6;
                                            i3 = 1;
                                        }
                                    }
                                }
                                int i15 = bVar3.l ? bVar3.d.g[bVar3.f] : bVar3.f1221b.j[bVar3.f] ? 1 : 0;
                                if (bVar3.b() != null) {
                                    i15 |= BasicMeasure.EXACTLY;
                                }
                                int i16 = i15;
                                n nVarB = bVar3.b();
                                wVar3.d(j7, i16, this.f1219z, 0, nVarB == null ? nVarB.c : null);
                                while (!this.n.isEmpty()) {
                                    a aVarRemoveFirst = this.n.removeFirst();
                                    this.u -= aVarRemoveFirst.f1220b;
                                    long j8 = aVarRemoveFirst.a + j7;
                                    w[] wVarArr = this.E;
                                    int i17 = 0;
                                    for (int length = wVarArr.length; i17 < length; length = length) {
                                        wVarArr[i17].d(j8, 1, aVarRemoveFirst.f1220b, this.u, null);
                                        i17++;
                                    }
                                }
                                if (!bVar3.c()) {
                                    this.f1218y = null;
                                }
                                this.o = 3;
                                i3 = 1;
                                if (i3 == 0) {
                                }
                            } else {
                                int i18 = !bVar3.l ? bVar3.d.d[bVar3.f] : bVar3.f1221b.h[bVar3.f];
                                this.f1219z = i18;
                                if (bVar3.f < bVar3.i) {
                                    iVar.l(i18);
                                    n nVarB2 = bVar3.b();
                                    if (nVarB2 != null) {
                                        x xVar4 = bVar3.f1221b.n;
                                        int i19 = nVarB2.d;
                                        if (i19 != 0) {
                                            xVar4.F(i19);
                                        }
                                        o oVar = bVar3.f1221b;
                                        if (oVar.k && oVar.l[bVar3.f]) {
                                            xVar4.F(xVar4.y() * 6);
                                        }
                                    }
                                    if (!bVar3.c()) {
                                        this.f1218y = null;
                                    }
                                    this.o = 3;
                                    if (i3 == 0) {
                                    }
                                } else {
                                    if (bVar3.d.a.g == 1) {
                                        this.f1219z = i18 - 8;
                                        iVar.l(8);
                                    }
                                    if ("audio/ac4".equals(bVar3.d.a.f.w)) {
                                        this.A = bVar3.d(this.f1219z, 7);
                                        b.i.a.c.t2.n.a(this.f1219z, this.j);
                                        bVar3.a.c(this.j, 7);
                                        this.A += 7;
                                    } else {
                                        this.A = bVar3.d(this.f1219z, 0);
                                    }
                                    this.f1219z += this.A;
                                    this.o = 4;
                                    this.B = 0;
                                    p pVar2 = bVar3.d;
                                    m mVar2 = pVar2.a;
                                    w wVar32 = bVar3.a;
                                    long j72 = bVar3.l ? pVar2.f[bVar3.f] : bVar3.f1221b.i[bVar3.f];
                                    i = mVar2.j;
                                    if (i != 0) {
                                    }
                                    if (bVar3.l) {
                                    }
                                    if (bVar3.b() != null) {
                                    }
                                    int i162 = i15;
                                    n nVarB3 = bVar3.b();
                                    wVar32.d(j72, i162, this.f1219z, 0, nVarB3 == null ? nVarB3.c : null);
                                    while (!this.n.isEmpty()) {
                                    }
                                    if (!bVar3.c()) {
                                    }
                                    this.o = 3;
                                    i3 = 1;
                                    if (i3 == 0) {
                                    }
                                }
                            }
                        }
                    } else {
                        char c2 = 6;
                        if (this.o != 3) {
                        }
                    }
                } else {
                    int size2 = this.e.size();
                    long j9 = Long.MAX_VALUE;
                    b bVarValueAt2 = null;
                    for (int i20 = 0; i20 < size2; i20++) {
                        o oVar2 = this.e.valueAt(i20).f1221b;
                        if (oVar2.o) {
                            long j10 = oVar2.c;
                            if (j10 < j9) {
                                bVarValueAt2 = this.e.valueAt(i20);
                                j9 = j10;
                            }
                        }
                    }
                    if (bVarValueAt2 == null) {
                        this.o = 3;
                    } else {
                        int position3 = (int) (j9 - iVar.getPosition());
                        if (position3 < 0) {
                            throw ParserException.a("Offset to encryption data was negative.", null);
                        }
                        iVar.l(position3);
                        o oVar3 = bVarValueAt2.f1221b;
                        x xVar5 = oVar3.n;
                        iVar.readFully(xVar5.a, 0, xVar5.c);
                        oVar3.n.E(0);
                        oVar3.o = false;
                    }
                }
            } else if (this.r != 0) {
                j2 = this.q;
                if (j2 != 1) {
                    iVar.readFully(this.l.a, 8, 8);
                    this.r += 8;
                    this.q = this.l.x();
                } else if (j2 == 0) {
                    long jB = iVar.b();
                    if (jB == -1 && !this.m.isEmpty()) {
                        jB = this.m.peek().f1209b;
                    }
                    if (jB != -1) {
                        this.q = (jB - iVar.getPosition()) + this.r;
                    }
                }
                if (this.q >= this.r) {
                    throw ParserException.b("Atom size less than header length (unsupported).");
                }
                long position4 = iVar.getPosition() - this.r;
                int i21 = this.p;
                if ((i21 == 1836019558 || i21 == 1835295092) && !this.G) {
                    this.D.a(new t.b(this.w, position4));
                    this.G = true;
                }
                if (this.p == 1836019558) {
                    int size3 = this.e.size();
                    for (int i22 = 0; i22 < size3; i22++) {
                        o oVar4 = this.e.valueAt(i22).f1221b;
                        Objects.requireNonNull(oVar4);
                        oVar4.c = position4;
                        oVar4.f1232b = position4;
                    }
                }
                int i23 = this.p;
                if (i23 == 1835295092) {
                    this.f1218y = null;
                    this.t = position4 + this.q;
                    this.o = 2;
                } else if (i23 == 1836019574 || i23 == 1953653099 || i23 == 1835297121 || i23 == 1835626086 || i23 == 1937007212 || i23 == 1836019558 || i23 == 1953653094 || i23 == 1836475768 || i23 == 1701082227) {
                    long position5 = (iVar.getPosition() + this.q) - 8;
                    this.m.push(new d.a(this.p, position5));
                    if (this.q == this.r) {
                        j(position5);
                    } else {
                        c();
                    }
                } else if (i23 == 1751411826 || i23 == 1835296868 || i23 == 1836476516 || i23 == 1936286840 || i23 == 1937011556 || i23 == 1937011827 || i23 == 1668576371 || i23 == 1937011555 || i23 == 1937011578 || i23 == 1937013298 || i23 == 1937007471 || i23 == 1668232756 || i23 == 1937011571 || i23 == 1952867444 || i23 == 1952868452 || i23 == 1953196132 || i23 == 1953654136 || i23 == 1953658222 || i23 == 1886614376 || i23 == 1935763834 || i23 == 1935763823 || i23 == 1936027235 || i23 == 1970628964 || i23 == 1935828848 || i23 == 1936158820 || i23 == 1701606260 || i23 == 1835362404 || i23 == 1701671783) {
                    if (this.r != 8) {
                        throw ParserException.b("Leaf atom defines extended atom size (unsupported).");
                    }
                    long j11 = this.q;
                    if (j11 > 2147483647L) {
                        throw ParserException.b("Leaf atom with length > 2147483647 (unsupported).");
                    }
                    x xVar6 = new x((int) j11);
                    System.arraycopy(this.l.a, 0, xVar6.a, 0, 8);
                    this.f1216s = xVar6;
                    this.o = 1;
                } else {
                    if (this.q > 2147483647L) {
                        throw ParserException.b("Skipping atom with length > 2147483647 (unsupported).");
                    }
                    this.f1216s = null;
                    this.o = 1;
                }
                z2 = true;
                if (z2) {
                    return -1;
                }
            } else if (iVar.c(this.l.a, 0, 8, true)) {
                this.r = 8;
                this.l.E(0);
                this.q = this.l.u();
                this.p = this.l.f();
                j2 = this.q;
                if (j2 != 1) {
                }
                if (this.q >= this.r) {
                }
            } else {
                z2 = false;
                if (z2) {
                }
            }
        }
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        int i;
        this.D = jVar;
        c();
        w[] wVarArr = new w[2];
        this.E = wVarArr;
        int i2 = 100;
        int i3 = 0;
        if ((this.c & 4) != 0) {
            wVarArr[0] = this.D.p(100, 5);
            i2 = 101;
            i = 1;
        } else {
            i = 0;
        }
        w[] wVarArr2 = (w[]) e0.D(this.E, i);
        this.E = wVarArr2;
        for (w wVar : wVarArr2) {
            wVar.e(f1215b);
        }
        this.F = new w[this.d.size()];
        while (i3 < this.F.length) {
            w wVarP = this.D.p(i2, 3);
            wVarP.e(this.d.get(i3));
            this.F[i3] = wVarP;
            i3++;
            i2++;
        }
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        int size = this.e.size();
        for (int i = 0; i < size; i++) {
            this.e.valueAt(i).e();
        }
        this.n.clear();
        this.u = 0;
        this.v = j2;
        this.m.clear();
        c();
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0680  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void j(long j) throws ParserException {
        g gVar;
        byte[] bArr;
        SparseArray<b> sparseArray;
        d.a aVar;
        int i;
        int i2;
        int i3;
        int i4;
        byte[] bArr2;
        int i5;
        byte[] bArr3;
        int i6;
        d.a aVar2;
        int i7;
        List<d.b> list;
        int i8;
        d.a aVar3;
        o oVar;
        int i9;
        int i10;
        long j2;
        int i11;
        int i12;
        boolean z2;
        int iF;
        boolean z3;
        int iF2;
        boolean z4;
        int iF3;
        boolean z5;
        boolean z6;
        int iF4;
        int i13;
        x xVar;
        g gVar2 = this;
        g gVar3 = gVar2;
        while (!gVar3.m.isEmpty() && gVar3.m.peek().f1209b == j) {
            d.a aVarPop = gVar3.m.pop();
            int i14 = aVarPop.a;
            int i15 = 12;
            if (i14 == 1836019574) {
                b.c.a.a0.d.E(true, "Unexpected moov box.");
                DrmInitData drmInitDataH = h(aVarPop.c);
                d.a aVarB = aVarPop.b(1836475768);
                Objects.requireNonNull(aVarB);
                SparseArray<f> sparseArray2 = new SparseArray<>();
                int size = aVarB.c.size();
                long jU = -9223372036854775807L;
                int i16 = 0;
                while (i16 < size) {
                    d.b bVar = aVarB.c.get(i16);
                    int i17 = bVar.a;
                    if (i17 == 1953654136) {
                        x xVar2 = bVar.f1210b;
                        xVar2.E(i15);
                        Pair pairCreate = Pair.create(Integer.valueOf(xVar2.f()), new f(xVar2.f() - 1, xVar2.f(), xVar2.f(), xVar2.f()));
                        sparseArray2.put(((Integer) pairCreate.first).intValue(), (f) pairCreate.second);
                    } else {
                        if (i17 == 1835362404) {
                            x xVar3 = bVar.f1210b;
                            xVar3.E(8);
                            jU = ((xVar3.f() >> 24) & 255) == 0 ? xVar3.u() : xVar3.x();
                        }
                        i16++;
                        i15 = 12;
                    }
                    i16++;
                    i15 = 12;
                }
                ArrayList arrayList = (ArrayList) e.e(aVarPop, new b.i.a.c.x2.p(), jU, drmInitDataH, (gVar3.c & 16) != 0, false, new c(gVar3));
                int size2 = arrayList.size();
                if (gVar3.e.size() == 0) {
                    for (int i18 = 0; i18 < size2; i18++) {
                        p pVar = (p) arrayList.get(i18);
                        m mVar = pVar.a;
                        gVar3.e.put(mVar.a, new b(gVar3.D.p(i18, mVar.f1230b), pVar, gVar3.d(sparseArray2, mVar.a)));
                        gVar3.w = Math.max(gVar3.w, mVar.e);
                    }
                    gVar3.D.j();
                } else {
                    b.c.a.a0.d.D(gVar3.e.size() == size2);
                    for (int i19 = 0; i19 < size2; i19++) {
                        p pVar2 = (p) arrayList.get(i19);
                        m mVar2 = pVar2.a;
                        b bVar2 = gVar3.e.get(mVar2.a);
                        f fVarD = gVar3.d(sparseArray2, mVar2.a);
                        bVar2.d = pVar2;
                        bVar2.e = fVarD;
                        bVar2.a.e(pVar2.a.f);
                        bVar2.e();
                    }
                }
                gVar = gVar2;
            } else {
                int i20 = 8;
                if (i14 == 1836019558) {
                    SparseArray<b> sparseArray3 = gVar3.e;
                    int i21 = gVar3.c;
                    byte[] bArr4 = gVar3.i;
                    int size3 = aVarPop.d.size();
                    int i22 = 0;
                    while (i22 < size3) {
                        d.a aVar4 = aVarPop.d.get(i22);
                        if (aVar4.a == 1953653094) {
                            d.b bVarC = aVar4.c(1952868452);
                            Objects.requireNonNull(bVarC);
                            x xVar4 = bVarC.f1210b;
                            xVar4.E(i20);
                            int iF5 = xVar4.f() & ViewCompat.MEASURED_SIZE_MASK;
                            b bVar3 = sparseArray3.get(xVar4.f());
                            if (bVar3 == null) {
                                bVar3 = null;
                            } else {
                                if ((iF5 & 1) != 0) {
                                    long jX = xVar4.x();
                                    o oVar2 = bVar3.f1221b;
                                    oVar2.f1232b = jX;
                                    oVar2.c = jX;
                                }
                                f fVar = bVar3.e;
                                bVar3.f1221b.a = new f((iF5 & 2) != 0 ? xVar4.f() - 1 : fVar.a, (iF5 & 8) != 0 ? xVar4.f() : fVar.f1214b, (iF5 & 16) != 0 ? xVar4.f() : fVar.c, (iF5 & 32) != 0 ? xVar4.f() : fVar.d);
                            }
                            if (bVar3 == null) {
                                bArr = bArr4;
                                sparseArray = sparseArray3;
                                aVar = aVarPop;
                                i = i21;
                                i2 = size3;
                                i3 = i22;
                            } else {
                                o oVar3 = bVar3.f1221b;
                                long j3 = oVar3.p;
                                boolean z7 = oVar3.q;
                                bVar3.e();
                                bVar3.l = true;
                                d.b bVarC2 = aVar4.c(1952867444);
                                if (bVarC2 == null || (i21 & 2) != 0) {
                                    oVar3.p = j3;
                                    oVar3.q = z7;
                                } else {
                                    x xVar5 = bVarC2.f1210b;
                                    xVar5.E(i20);
                                    oVar3.p = ((xVar5.f() >> 24) & 255) == 1 ? xVar5.x() : xVar5.u();
                                    oVar3.q = true;
                                }
                                List<d.b> list2 = aVar4.c;
                                int size4 = list2.size();
                                int i23 = 0;
                                int i24 = 0;
                                int i25 = 0;
                                while (true) {
                                    i4 = 1953658222;
                                    if (i23 >= size4) {
                                        break;
                                    }
                                    SparseArray<b> sparseArray4 = sparseArray3;
                                    d.b bVar4 = list2.get(i23);
                                    int i26 = size3;
                                    if (bVar4.a == 1953658222) {
                                        x xVar6 = bVar4.f1210b;
                                        xVar6.E(12);
                                        int iW = xVar6.w();
                                        if (iW > 0) {
                                            i25 += iW;
                                            i24++;
                                        }
                                    }
                                    i23++;
                                    size3 = i26;
                                    sparseArray3 = sparseArray4;
                                }
                                sparseArray = sparseArray3;
                                i2 = size3;
                                bVar3.h = 0;
                                bVar3.g = 0;
                                bVar3.f = 0;
                                o oVar4 = bVar3.f1221b;
                                oVar4.d = i24;
                                oVar4.e = i25;
                                if (oVar4.g.length < i24) {
                                    oVar4.f = new long[i24];
                                    oVar4.g = new int[i24];
                                }
                                if (oVar4.h.length < i25) {
                                    int i27 = (i25 * Opcodes.LUSHR) / 100;
                                    oVar4.h = new int[i27];
                                    oVar4.i = new long[i27];
                                    oVar4.j = new boolean[i27];
                                    oVar4.l = new boolean[i27];
                                }
                                int i28 = 0;
                                int i29 = 0;
                                int i30 = 0;
                                while (i28 < size4) {
                                    d.b bVar5 = list2.get(i28);
                                    if (bVar5.a == i4) {
                                        int i31 = i30 + 1;
                                        x xVar7 = bVar5.f1210b;
                                        xVar7.E(8);
                                        int iF6 = xVar7.f() & ViewCompat.MEASURED_SIZE_MASK;
                                        list = list2;
                                        m mVar3 = bVar3.d.a;
                                        i9 = size4;
                                        o oVar5 = bVar3.f1221b;
                                        f fVar2 = oVar5.a;
                                        int i32 = e0.a;
                                        oVar5.g[i30] = xVar7.w();
                                        long[] jArr = oVar5.f;
                                        i8 = i22;
                                        aVar3 = aVar4;
                                        jArr[i30] = oVar5.f1232b;
                                        if ((iF6 & 1) != 0) {
                                            aVar2 = aVarPop;
                                            bArr3 = bArr4;
                                            i6 = i28;
                                            jArr[i30] = jArr[i30] + xVar7.f();
                                        } else {
                                            bArr3 = bArr4;
                                            i6 = i28;
                                            aVar2 = aVarPop;
                                        }
                                        boolean z8 = (iF6 & 4) != 0;
                                        int iF7 = fVar2.d;
                                        if (z8) {
                                            iF7 = xVar7.f();
                                        }
                                        boolean z9 = (iF6 & 256) != 0;
                                        boolean z10 = (iF6 & 512) != 0;
                                        boolean z11 = (iF6 & 1024) != 0;
                                        boolean z12 = (iF6 & 2048) != 0;
                                        long[] jArr2 = mVar3.h;
                                        if (jArr2 != null) {
                                            i10 = iF7;
                                            oVar = oVar3;
                                            if (jArr2.length == 1 && jArr2[0] == 0) {
                                                j2 = mVar3.i[0];
                                            }
                                            int[] iArr = oVar5.h;
                                            long[] jArr3 = oVar5.i;
                                            boolean[] zArr = oVar5.j;
                                            boolean z13 = (mVar3.f1230b == 2 || (i21 & 1) == 0) ? false : true;
                                            i11 = oVar5.g[i30] + i29;
                                            i7 = i21;
                                            long j4 = mVar3.c;
                                            long j5 = oVar5.p;
                                            i12 = i29;
                                            while (i12 < i11) {
                                                if (z9) {
                                                    z2 = z9;
                                                    iF = xVar7.f();
                                                } else {
                                                    z2 = z9;
                                                    iF = fVar2.f1214b;
                                                }
                                                a(iF);
                                                if (z10) {
                                                    z3 = z10;
                                                    iF2 = xVar7.f();
                                                } else {
                                                    z3 = z10;
                                                    iF2 = fVar2.c;
                                                }
                                                a(iF2);
                                                if (z11) {
                                                    z4 = z8;
                                                    iF3 = xVar7.f();
                                                } else if (i12 == 0 && z8) {
                                                    z4 = z8;
                                                    iF3 = i10;
                                                } else {
                                                    z4 = z8;
                                                    iF3 = fVar2.d;
                                                }
                                                if (z12) {
                                                    z5 = z11;
                                                    z6 = z12;
                                                    iF4 = xVar7.f();
                                                } else {
                                                    z5 = z11;
                                                    z6 = z12;
                                                    iF4 = 0;
                                                }
                                                jArr3[i12] = e0.F((iF4 + j5) - j2, 1000000L, j4);
                                                if (oVar5.q) {
                                                    i13 = i11;
                                                    xVar = xVar7;
                                                } else {
                                                    i13 = i11;
                                                    xVar = xVar7;
                                                    jArr3[i12] = jArr3[i12] + bVar3.d.h;
                                                }
                                                iArr[i12] = iF2;
                                                zArr[i12] = ((iF3 >> 16) & 1) == 0 && (!z13 || i12 == 0);
                                                j5 += iF;
                                                i12++;
                                                i11 = i13;
                                                xVar7 = xVar;
                                                z9 = z2;
                                                z10 = z3;
                                                z8 = z4;
                                                z11 = z5;
                                                z12 = z6;
                                            }
                                            int i33 = i11;
                                            oVar5.p = j5;
                                            i30 = i31;
                                            i29 = i33;
                                        } else {
                                            i10 = iF7;
                                            oVar = oVar3;
                                        }
                                        j2 = 0;
                                        int[] iArr2 = oVar5.h;
                                        long[] jArr32 = oVar5.i;
                                        boolean[] zArr2 = oVar5.j;
                                        if (mVar3.f1230b == 2) {
                                            i11 = oVar5.g[i30] + i29;
                                            i7 = i21;
                                            long j42 = mVar3.c;
                                            long j52 = oVar5.p;
                                            i12 = i29;
                                            while (i12 < i11) {
                                            }
                                            int i332 = i11;
                                            oVar5.p = j52;
                                            i30 = i31;
                                            i29 = i332;
                                        }
                                    } else {
                                        bArr3 = bArr4;
                                        i6 = i28;
                                        aVar2 = aVarPop;
                                        i7 = i21;
                                        list = list2;
                                        i8 = i22;
                                        aVar3 = aVar4;
                                        oVar = oVar3;
                                        i9 = size4;
                                    }
                                    i28 = i6 + 1;
                                    i21 = i7;
                                    list2 = list;
                                    size4 = i9;
                                    i22 = i8;
                                    aVar4 = aVar3;
                                    aVarPop = aVar2;
                                    bArr4 = bArr3;
                                    oVar3 = oVar;
                                    i4 = 1953658222;
                                }
                                byte[] bArr5 = bArr4;
                                aVar = aVarPop;
                                i = i21;
                                i3 = i22;
                                o oVar6 = oVar3;
                                m mVar4 = bVar3.d.a;
                                f fVar3 = oVar6.a;
                                Objects.requireNonNull(fVar3);
                                n nVarA = mVar4.a(fVar3.a);
                                d.b bVarC3 = aVar4.c(1935763834);
                                if (bVarC3 != null) {
                                    Objects.requireNonNull(nVarA);
                                    x xVar8 = bVarC3.f1210b;
                                    int i34 = nVarA.d;
                                    xVar8.E(8);
                                    if ((xVar8.f() & ViewCompat.MEASURED_SIZE_MASK & 1) == 1) {
                                        xVar8.F(8);
                                    }
                                    int iT = xVar8.t();
                                    int iW2 = xVar8.w();
                                    int i35 = oVar6.e;
                                    if (iW2 > i35) {
                                        throw ParserException.a(b.d.b.a.a.h(78, "Saiz sample count ", iW2, " is greater than fragment sample count", i35), null);
                                    }
                                    if (iT == 0) {
                                        boolean[] zArr3 = oVar6.l;
                                        i5 = 0;
                                        for (int i36 = 0; i36 < iW2; i36++) {
                                            int iT2 = xVar8.t();
                                            i5 += iT2;
                                            zArr3[i36] = iT2 > i34;
                                        }
                                    } else {
                                        i5 = (iT * iW2) + 0;
                                        Arrays.fill(oVar6.l, 0, iW2, iT > i34);
                                    }
                                    Arrays.fill(oVar6.l, iW2, oVar6.e, false);
                                    if (i5 > 0) {
                                        x xVar9 = oVar6.n;
                                        byte[] bArr6 = xVar9.a;
                                        if (bArr6.length < i5) {
                                            bArr6 = new byte[i5];
                                        }
                                        xVar9.C(bArr6, i5);
                                        oVar6.k = true;
                                        oVar6.o = true;
                                    }
                                }
                                d.b bVarC4 = aVar4.c(1935763823);
                                if (bVarC4 != null) {
                                    x xVar10 = bVarC4.f1210b;
                                    xVar10.E(8);
                                    int iF8 = xVar10.f();
                                    if ((16777215 & iF8 & 1) == 1) {
                                        xVar10.F(8);
                                    }
                                    int iW3 = xVar10.w();
                                    if (iW3 != 1) {
                                        throw b.d.b.a.a.w0(40, "Unexpected saio entry count: ", iW3, null);
                                    }
                                    oVar6.c += ((iF8 >> 24) & 255) == 0 ? xVar10.u() : xVar10.x();
                                }
                                byte[] bArr7 = null;
                                d.b bVarC5 = aVar4.c(1936027235);
                                if (bVarC5 != null) {
                                    i(bVarC5.f1210b, 0, oVar6);
                                }
                                String str = nVarA != null ? nVarA.f1231b : null;
                                x xVar11 = null;
                                x xVar12 = null;
                                for (int i37 = 0; i37 < aVar4.c.size(); i37++) {
                                    d.b bVar6 = aVar4.c.get(i37);
                                    x xVar13 = bVar6.f1210b;
                                    int i38 = bVar6.a;
                                    if (i38 == 1935828848) {
                                        xVar13.E(12);
                                        if (xVar13.f() == 1936025959) {
                                            xVar11 = xVar13;
                                        }
                                    } else if (i38 == 1936158820) {
                                        xVar13.E(12);
                                        if (xVar13.f() == 1936025959) {
                                            xVar12 = xVar13;
                                        }
                                    }
                                }
                                if (xVar11 != null && xVar12 != null) {
                                    xVar11.E(8);
                                    int iF9 = (xVar11.f() >> 24) & 255;
                                    xVar11.F(4);
                                    if (iF9 == 1) {
                                        xVar11.F(4);
                                    }
                                    if (xVar11.f() != 1) {
                                        throw ParserException.b("Entry count in sbgp != 1 (unsupported).");
                                    }
                                    xVar12.E(8);
                                    int iF10 = (xVar12.f() >> 24) & 255;
                                    xVar12.F(4);
                                    if (iF10 == 1) {
                                        if (xVar12.u() == 0) {
                                            throw ParserException.b("Variable length description in sgpd found (unsupported)");
                                        }
                                    } else if (iF10 >= 2) {
                                        xVar12.F(4);
                                    }
                                    if (xVar12.u() != 1) {
                                        throw ParserException.b("Entry count in sgpd != 1 (unsupported).");
                                    }
                                    xVar12.F(1);
                                    int iT3 = xVar12.t();
                                    int i39 = (iT3 & 240) >> 4;
                                    int i40 = iT3 & 15;
                                    boolean z14 = xVar12.t() == 1;
                                    if (z14) {
                                        int iT4 = xVar12.t();
                                        byte[] bArr8 = new byte[16];
                                        System.arraycopy(xVar12.a, xVar12.f984b, bArr8, 0, 16);
                                        xVar12.f984b += 16;
                                        if (iT4 == 0) {
                                            int iT5 = xVar12.t();
                                            bArr7 = new byte[iT5];
                                            System.arraycopy(xVar12.a, xVar12.f984b, bArr7, 0, iT5);
                                            xVar12.f984b += iT5;
                                        }
                                        oVar6.k = true;
                                        oVar6.m = new n(z14, str, iT4, bArr8, i39, i40, bArr7);
                                    }
                                }
                                int size5 = aVar4.c.size();
                                int i41 = 0;
                                while (i41 < size5) {
                                    d.b bVar7 = aVar4.c.get(i41);
                                    if (bVar7.a == 1970628964) {
                                        x xVar14 = bVar7.f1210b;
                                        xVar14.E(8);
                                        bArr2 = bArr5;
                                        System.arraycopy(xVar14.a, xVar14.f984b, bArr2, 0, 16);
                                        xVar14.f984b += 16;
                                        if (Arrays.equals(bArr2, a)) {
                                            i(xVar14, 16, oVar6);
                                        }
                                    } else {
                                        bArr2 = bArr5;
                                    }
                                    i41++;
                                    bArr5 = bArr2;
                                }
                                bArr = bArr5;
                            }
                        }
                        i22 = i3 + 1;
                        i20 = 8;
                        bArr4 = bArr;
                        i21 = i;
                        size3 = i2;
                        sparseArray3 = sparseArray;
                        aVarPop = aVar;
                    }
                    DrmInitData drmInitDataH2 = h(aVarPop.c);
                    gVar = this;
                    if (drmInitDataH2 != null) {
                        int size6 = gVar.e.size();
                        for (int i42 = 0; i42 < size6; i42++) {
                            b bVarValueAt = gVar.e.valueAt(i42);
                            m mVar5 = bVarValueAt.d.a;
                            f fVar4 = bVarValueAt.f1221b.a;
                            int i43 = e0.a;
                            n nVarA2 = mVar5.a(fVar4.a);
                            DrmInitData drmInitDataA = drmInitDataH2.a(nVarA2 != null ? nVarA2.f1231b : null);
                            j1.b bVarA = bVarValueAt.d.a.f.a();
                            bVarA.n = drmInitDataA;
                            bVarValueAt.a.e(bVarA.a());
                        }
                    }
                    if (gVar.v != -9223372036854775807L) {
                        int size7 = gVar.e.size();
                        for (int i44 = 0; i44 < size7; i44++) {
                            b bVarValueAt2 = gVar.e.valueAt(i44);
                            long j6 = gVar.v;
                            int i45 = bVarValueAt2.f;
                            while (true) {
                                o oVar7 = bVarValueAt2.f1221b;
                                if (i45 >= oVar7.e || oVar7.i[i45] >= j6) {
                                    break;
                                }
                                if (oVar7.j[i45]) {
                                    bVarValueAt2.i = i45;
                                }
                                i45++;
                            }
                        }
                        gVar.v = -9223372036854775807L;
                    }
                    gVar3 = gVar;
                } else {
                    gVar = gVar2;
                    if (!gVar3.m.isEmpty()) {
                        gVar3.m.peek().d.add(aVarPop);
                    }
                }
            }
            gVar2 = gVar;
        }
        c();
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
