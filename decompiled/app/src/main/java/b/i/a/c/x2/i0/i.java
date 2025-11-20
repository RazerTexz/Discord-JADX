package b.i.a.c.x2.i0;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.f3.e0;
import b.i.a.c.f3.u;
import b.i.a.c.f3.x;
import b.i.a.c.j1;
import b.i.a.c.x2.i0.d;
import b.i.a.c.x2.i0.k;
import b.i.a.c.x2.s;
import b.i.a.c.x2.t;
import b.i.a.c.x2.w;
import com.discord.api.permission.Permission;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.metadata.mp4.SlowMotionData;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* compiled from: Mp4Extractor.java */
/* loaded from: classes3.dex */
public final class i implements b.i.a.c.x2.h, t {
    public static final /* synthetic */ int a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f1222b;
    public final x c;
    public final x d;
    public final x e;
    public final x f;
    public final ArrayDeque<d.a> g;
    public final k h;
    public final List<Metadata.Entry> i;
    public int j;
    public int k;
    public long l;
    public int m;

    @Nullable
    public x n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public b.i.a.c.x2.j f1223s;
    public a[] t;
    public long[][] u;
    public int v;
    public long w;

    /* renamed from: x, reason: collision with root package name */
    public int f1224x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    public MotionPhotoMetadata f1225y;

    /* compiled from: Mp4Extractor.java */
    public static final class a {
        public final m a;

        /* renamed from: b, reason: collision with root package name */
        public final p f1226b;
        public final w c;

        @Nullable
        public final b.i.a.c.x2.x d;
        public int e;

        public a(m mVar, p pVar, w wVar) {
            this.a = mVar;
            this.f1226b = pVar;
            this.c = wVar;
            this.d = "audio/true-hd".equals(mVar.f.w) ? new b.i.a.c.x2.x() : null;
        }
    }

    static {
        b bVar = b.a;
    }

    public i(int i) {
        this.f1222b = i;
        this.j = (i & 4) != 0 ? 3 : 0;
        this.h = new k();
        this.i = new ArrayList();
        this.f = new x(16);
        this.g = new ArrayDeque<>();
        this.c = new x(u.a);
        this.d = new x(4);
        this.e = new x();
        this.o = -1;
    }

    public static long k(p pVar, long j, long j2) {
        int iA = pVar.a(j);
        if (iA == -1) {
            iA = pVar.b(j);
        }
        return iA == -1 ? j2 : Math.min(pVar.c[iA], j2);
    }

    @Override // b.i.a.c.x2.h
    public boolean b(b.i.a.c.x2.i iVar) throws IOException {
        return l.a(iVar, false, (this.f1222b & 2) != 0);
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:235:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0523  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x053a  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x056e  */
    /* JADX WARN: Removed duplicated region for block: B:361:0x04a5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x06bb A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:364:0x06b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:366:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:367:0x0006 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    @Override // b.i.a.c.x2.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int e(b.i.a.c.x2.i iVar, s sVar) throws IOException {
        int i;
        char c;
        boolean z2;
        long j;
        d.a aVarPeek;
        long j2;
        int i2;
        boolean z3;
        while (true) {
            int i3 = this.j;
            int i4 = 4;
            int i5 = 2;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            throw new IllegalStateException();
                        }
                        k kVar = this.h;
                        List<Metadata.Entry> list = this.i;
                        int i6 = kVar.d;
                        if (i6 == 0) {
                            long jB = iVar.b();
                            sVar.a = (jB == -1 || jB < 8) ? 0L : jB - 8;
                            kVar.d = 1;
                        } else if (i6 != 1) {
                            short s2 = 2819;
                            if (i6 == 2) {
                                long jB2 = iVar.b();
                                int i7 = (kVar.e - 12) - 8;
                                x xVar = new x(i7);
                                iVar.readFully(xVar.a, 0, i7);
                                int i8 = 0;
                                while (i8 < i7 / 12) {
                                    xVar.F(i5);
                                    short sI = xVar.i();
                                    if (sI == 2192 || sI == 2816 || sI == 2817 || sI == s2 || sI == 2820) {
                                        kVar.c.add(new k.a(sI, (jB2 - kVar.e) - xVar.h(), xVar.h()));
                                    } else {
                                        xVar.F(8);
                                    }
                                    i8++;
                                    s2 = 2819;
                                    i5 = 2;
                                }
                                if (kVar.c.isEmpty()) {
                                    sVar.a = 0L;
                                } else {
                                    kVar.d = 3;
                                    sVar.a = kVar.c.get(0).a;
                                }
                            } else {
                                if (i6 != 3) {
                                    throw new IllegalStateException();
                                }
                                long position = iVar.getPosition();
                                int iB = (int) ((iVar.b() - iVar.getPosition()) - kVar.e);
                                x xVar2 = new x(iB);
                                iVar.readFully(xVar2.a, 0, iB);
                                int i9 = 0;
                                while (i9 < kVar.c.size()) {
                                    k.a aVar = kVar.c.get(i9);
                                    List<Metadata.Entry> list2 = list;
                                    xVar2.E((int) (aVar.a - position));
                                    xVar2.F(i4);
                                    int iH = xVar2.h();
                                    String strQ = xVar2.q(iH);
                                    switch (strQ.hashCode()) {
                                        case -1711564334:
                                            if (strQ.equals("SlowMotion_Data")) {
                                                i = 0;
                                            } else {
                                                i = -1;
                                            }
                                            break;
                                        case -1332107749:
                                            if (strQ.equals("Super_SlowMotion_Edit_Data")) {
                                                i = 1;
                                                break;
                                            }
                                            break;
                                        case -1251387154:
                                            if (strQ.equals("Super_SlowMotion_Data")) {
                                                i = 2;
                                                break;
                                            }
                                            break;
                                        case -830665521:
                                            if (strQ.equals("Super_SlowMotion_Deflickering_On")) {
                                                i = 3;
                                                break;
                                            }
                                            break;
                                        case 1760745220:
                                            if (strQ.equals("Super_SlowMotion_BGM")) {
                                                i = 4;
                                                break;
                                            }
                                            break;
                                    }
                                    if (i == 0) {
                                        c = 2192;
                                    } else if (i == 1) {
                                        c = 2819;
                                    } else if (i == 2) {
                                        c = 2816;
                                    } else if (i == 3) {
                                        c = 2820;
                                    } else {
                                        if (i != i4) {
                                            throw ParserException.a("Invalid SEF name", null);
                                        }
                                        c = 2817;
                                    }
                                    int i10 = aVar.f1229b - (iH + 8);
                                    if (c == 2192) {
                                        ArrayList arrayList = new ArrayList();
                                        List<String> listA = k.f1228b.a(xVar2.q(i10));
                                        for (int i11 = 0; i11 < listA.size(); i11++) {
                                            List<String> listA2 = k.a.a(listA.get(i11));
                                            if (listA2.size() != 3) {
                                                throw ParserException.a(null, null);
                                            }
                                            try {
                                                arrayList.add(new SlowMotionData.Segment(Long.parseLong(listA2.get(0)), Long.parseLong(listA2.get(1)), 1 << (Integer.parseInt(listA2.get(2)) - 1)));
                                            } catch (NumberFormatException e) {
                                                throw ParserException.a(null, e);
                                            }
                                        }
                                        list2.add(new SlowMotionData(arrayList));
                                    } else if (c != 2816 && c != 2817 && c != 2819 && c != 2820) {
                                        throw new IllegalStateException();
                                    }
                                    i9++;
                                    list = list2;
                                    i4 = 4;
                                }
                                sVar.a = 0L;
                            }
                        } else {
                            byte[] bArr = new byte[8];
                            iVar.readFully(bArr, 0, 8);
                            kVar.e = ((bArr[0] & 255) | ((bArr[1] & 255) << 8) | ((bArr[2] & 255) << 16) | ((bArr[3] & 255) << 24)) + 8;
                            if (((bArr[7] & 255) | ((bArr[5] & 255) << 16) | ((bArr[4] & 255) << 24) | ((bArr[6] & 255) << 8)) != 1397048916) {
                                sVar.a = 0L;
                            } else {
                                sVar.a = iVar.getPosition() - (kVar.e - 12);
                                kVar.d = 2;
                            }
                        }
                        if (sVar.a == 0) {
                            j();
                        }
                        return 1;
                    }
                    long position2 = iVar.getPosition();
                    if (this.o == -1) {
                        int i12 = -1;
                        boolean z4 = true;
                        int i13 = -1;
                        int i14 = 0;
                        long j3 = RecyclerView.FOREVER_NS;
                        boolean z5 = true;
                        long j4 = RecyclerView.FOREVER_NS;
                        long j5 = RecyclerView.FOREVER_NS;
                        while (true) {
                            a[] aVarArr = this.t;
                            int i15 = e0.a;
                            if (i14 >= aVarArr.length) {
                                break;
                            }
                            a aVar2 = aVarArr[i14];
                            int i16 = aVar2.e;
                            p pVar = aVar2.f1226b;
                            if (i16 != pVar.f1233b) {
                                long j6 = pVar.c[i16];
                                long j7 = this.u[i14][i16];
                                long j8 = j6 - position2;
                                boolean z6 = j8 < 0 || j8 >= Permission.USE_EXTERNAL_EMOJIS;
                                if ((!z6 && z4) || (z6 == z4 && j8 < j5)) {
                                    z4 = z6;
                                    j5 = j8;
                                    i13 = i14;
                                    j4 = j7;
                                }
                                if (j7 < j3) {
                                    z5 = z6;
                                    i12 = i14;
                                    j3 = j7;
                                }
                            }
                            i14++;
                        }
                        if (j3 == RecyclerView.FOREVER_NS || !z5 || j4 < j3 + 10485760) {
                            i12 = i13;
                        }
                        this.o = i12;
                        if (i12 == -1) {
                            return -1;
                        }
                    }
                    a[] aVarArr2 = this.t;
                    int i17 = e0.a;
                    a aVar3 = aVarArr2[this.o];
                    w wVar = aVar3.c;
                    int i18 = aVar3.e;
                    p pVar2 = aVar3.f1226b;
                    long j9 = pVar2.c[i18];
                    int i19 = pVar2.d[i18];
                    b.i.a.c.x2.x xVar3 = aVar3.d;
                    long j10 = (j9 - position2) + this.p;
                    if (j10 < 0 || j10 >= Permission.USE_EXTERNAL_EMOJIS) {
                        sVar.a = j9;
                        return 1;
                    }
                    if (aVar3.a.g == 1) {
                        j10 += 8;
                        i19 -= 8;
                    }
                    iVar.l((int) j10);
                    m mVar = aVar3.a;
                    int i20 = mVar.j;
                    if (i20 == 0) {
                        if ("audio/ac4".equals(mVar.f.w)) {
                            if (this.q == 0) {
                                b.i.a.c.t2.n.a(i19, this.e);
                                wVar.c(this.e, 7);
                                this.q += 7;
                            }
                            i19 += 7;
                        } else if (xVar3 != null) {
                            xVar3.c(iVar);
                        }
                        while (true) {
                            int i21 = this.q;
                            if (i21 >= i19) {
                                break;
                            }
                            int iB2 = wVar.b(iVar, i19 - i21, false);
                            this.p += iB2;
                            this.q += iB2;
                            this.r -= iB2;
                        }
                    } else {
                        byte[] bArr2 = this.d.a;
                        bArr2[0] = 0;
                        bArr2[1] = 0;
                        bArr2[2] = 0;
                        int i22 = 4 - i20;
                        while (this.q < i19) {
                            int i23 = this.r;
                            if (i23 == 0) {
                                iVar.readFully(bArr2, i22, i20);
                                this.p += i20;
                                this.d.E(0);
                                int iF = this.d.f();
                                if (iF < 0) {
                                    throw ParserException.a("Invalid NAL length", null);
                                }
                                this.r = iF;
                                this.c.E(0);
                                wVar.c(this.c, 4);
                                this.q += 4;
                                i19 += i22;
                            } else {
                                int iB3 = wVar.b(iVar, i23, false);
                                this.p += iB3;
                                this.q += iB3;
                                this.r -= iB3;
                            }
                        }
                    }
                    int i24 = i19;
                    p pVar3 = aVar3.f1226b;
                    long j11 = pVar3.f[i18];
                    int i25 = pVar3.g[i18];
                    if (xVar3 != null) {
                        xVar3.b(wVar, j11, i25, i24, 0, null);
                        if (i18 + 1 == aVar3.f1226b.f1233b) {
                            xVar3.a(wVar, null);
                        }
                    } else {
                        wVar.d(j11, i25, i24, 0, null);
                    }
                    aVar3.e++;
                    this.o = -1;
                    this.p = 0;
                    this.q = 0;
                    this.r = 0;
                    return 0;
                }
                long j12 = this.l - this.m;
                long position3 = iVar.getPosition() + j12;
                x xVar4 = this.n;
                if (xVar4 != null) {
                    iVar.readFully(xVar4.a, this.m, (int) j12);
                    if (this.k == 1718909296) {
                        xVar4.E(8);
                        int iF2 = xVar4.f();
                        int i26 = iF2 != 1751476579 ? iF2 != 1903435808 ? 0 : 1 : 2;
                        if (i26 == 0) {
                            xVar4.F(4);
                            while (true) {
                                if (xVar4.a() <= 0) {
                                    i26 = 0;
                                    break;
                                }
                                int iF3 = xVar4.f();
                                i26 = iF3 != 1751476579 ? iF3 != 1903435808 ? 0 : 1 : 2;
                                if (i26 != 0) {
                                    break;
                                }
                            }
                        }
                        this.f1224x = i26;
                    } else if (!this.g.isEmpty()) {
                        this.g.peek().c.add(new d.b(this.k, xVar4));
                    }
                } else if (j12 < Permission.USE_EXTERNAL_EMOJIS) {
                    iVar.l((int) j12);
                } else {
                    sVar.a = iVar.getPosition() + j12;
                    z2 = true;
                    l(position3);
                    if (!((z2 || this.j == 2) ? false : true)) {
                        return 1;
                    }
                }
                z2 = false;
                l(position3);
                if (z2) {
                    if (!((z2 || this.j == 2) ? false : true)) {
                    }
                }
            } else if (this.m != 0) {
                j = this.l;
                if (j != 1) {
                    iVar.readFully(this.f.a, 8, 8);
                    this.m += 8;
                    this.l = this.f.x();
                } else if (j == 0) {
                    long jB3 = iVar.b();
                    if (jB3 == -1 && (aVarPeek = this.g.peek()) != null) {
                        jB3 = aVarPeek.f1209b;
                    }
                    if (jB3 != -1) {
                        this.l = (jB3 - iVar.getPosition()) + this.m;
                    }
                }
                j2 = this.l;
                i2 = this.m;
                if (j2 >= i2) {
                    throw ParserException.b("Atom size less than header length (unsupported).");
                }
                int i27 = this.k;
                if (i27 == 1836019574 || i27 == 1953653099 || i27 == 1835297121 || i27 == 1835626086 || i27 == 1937007212 || i27 == 1701082227 || i27 == 1835365473) {
                    long position4 = iVar.getPosition();
                    long j13 = this.l;
                    long j14 = this.m;
                    long j15 = (position4 + j13) - j14;
                    if (j13 != j14 && this.k == 1835365473) {
                        this.e.A(8);
                        iVar.o(this.e.a, 0, 8);
                        x xVar5 = this.e;
                        byte[] bArr3 = e.a;
                        int i28 = xVar5.f984b;
                        xVar5.F(4);
                        if (xVar5.f() != 1751411826) {
                            i28 += 4;
                        }
                        xVar5.E(i28);
                        iVar.l(this.e.f984b);
                        iVar.k();
                    }
                    this.g.push(new d.a(this.k, j15));
                    if (this.l == this.m) {
                        l(j15);
                    } else {
                        j();
                    }
                } else if (i27 == 1835296868 || i27 == 1836476516 || i27 == 1751411826 || i27 == 1937011556 || i27 == 1937011827 || i27 == 1937011571 || i27 == 1668576371 || i27 == 1701606260 || i27 == 1937011555 || i27 == 1937011578 || i27 == 1937013298 || i27 == 1937007471 || i27 == 1668232756 || i27 == 1953196132 || i27 == 1718909296 || i27 == 1969517665 || i27 == 1801812339 || i27 == 1768715124) {
                    b.c.a.a0.d.D(i2 == 8);
                    b.c.a.a0.d.D(this.l <= 2147483647L);
                    x xVar6 = new x((int) this.l);
                    System.arraycopy(this.f.a, 0, xVar6.a, 0, 8);
                    this.n = xVar6;
                    this.j = 1;
                } else {
                    long position5 = iVar.getPosition();
                    long j16 = this.m;
                    long j17 = position5 - j16;
                    if (this.k == 1836086884) {
                        this.f1225y = new MotionPhotoMetadata(0L, j17, -9223372036854775807L, j17 + j16, this.l - j16);
                    }
                    this.n = null;
                    this.j = 1;
                }
                z3 = true;
                if (z3) {
                    return -1;
                }
            } else if (iVar.c(this.f.a, 0, 8, true)) {
                this.m = 8;
                this.f.E(0);
                this.l = this.f.u();
                this.k = this.f.f();
                j = this.l;
                if (j != 1) {
                }
                j2 = this.l;
                i2 = this.m;
                if (j2 >= i2) {
                }
            } else {
                if (this.f1224x == 2 && (this.f1222b & 2) != 0) {
                    b.i.a.c.x2.j jVar = this.f1223s;
                    Objects.requireNonNull(jVar);
                    w wVarP = jVar.p(0, 4);
                    MotionPhotoMetadata motionPhotoMetadata = this.f1225y;
                    Metadata metadata = motionPhotoMetadata == null ? null : new Metadata(motionPhotoMetadata);
                    j1.b bVar = new j1.b();
                    bVar.i = metadata;
                    wVarP.e(bVar.a());
                    jVar.j();
                    jVar.a(new t.b(-9223372036854775807L, 0L));
                }
                z3 = false;
                if (z3) {
                }
            }
        }
    }

    @Override // b.i.a.c.x2.h
    public void f(b.i.a.c.x2.j jVar) {
        this.f1223s = jVar;
    }

    @Override // b.i.a.c.x2.h
    public void g(long j, long j2) {
        this.g.clear();
        this.m = 0;
        this.o = -1;
        this.p = 0;
        this.q = 0;
        this.r = 0;
        if (j == 0) {
            if (this.j != 3) {
                j();
                return;
            }
            k kVar = this.h;
            kVar.c.clear();
            kVar.d = 0;
            this.i.clear();
            return;
        }
        a[] aVarArr = this.t;
        if (aVarArr != null) {
            for (a aVar : aVarArr) {
                p pVar = aVar.f1226b;
                int iA = pVar.a(j2);
                if (iA == -1) {
                    iA = pVar.b(j2);
                }
                aVar.e = iA;
                b.i.a.c.x2.x xVar = aVar.d;
                if (xVar != null) {
                    xVar.f1300b = false;
                    xVar.c = 0;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.t
    public t.a h(long j) {
        long j2;
        long jK;
        long j3;
        long j4;
        int iB;
        long j5 = j;
        a[] aVarArr = this.t;
        Objects.requireNonNull(aVarArr);
        if (aVarArr.length == 0) {
            return new t.a(b.i.a.c.x2.u.a);
        }
        long j6 = -1;
        int i = this.v;
        if (i != -1) {
            p pVar = this.t[i].f1226b;
            int iA = pVar.a(j5);
            if (iA == -1) {
                iA = pVar.b(j5);
            }
            if (iA == -1) {
                return new t.a(b.i.a.c.x2.u.a);
            }
            long j7 = pVar.f[iA];
            j2 = pVar.c[iA];
            if (j7 >= j5 || iA >= pVar.f1233b - 1 || (iB = pVar.b(j5)) == -1 || iB == iA) {
                j4 = -9223372036854775807L;
            } else {
                long j8 = pVar.f[iB];
                long j9 = pVar.c[iB];
                j4 = j8;
                j6 = j9;
            }
            jK = j6;
            j3 = j4;
            j5 = j7;
        } else {
            j2 = RecyclerView.FOREVER_NS;
            jK = -1;
            j3 = -9223372036854775807L;
        }
        int i2 = 0;
        while (true) {
            a[] aVarArr2 = this.t;
            if (i2 >= aVarArr2.length) {
                break;
            }
            if (i2 != this.v) {
                p pVar2 = aVarArr2[i2].f1226b;
                long jK2 = k(pVar2, j5, j2);
                if (j3 != -9223372036854775807L) {
                    jK = k(pVar2, j3, jK);
                }
                j2 = jK2;
            }
            i2++;
        }
        b.i.a.c.x2.u uVar = new b.i.a.c.x2.u(j5, j2);
        return j3 == -9223372036854775807L ? new t.a(uVar) : new t.a(uVar, new b.i.a.c.x2.u(j3, jK));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.w;
    }

    public final void j() {
        this.j = 0;
        this.m = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x01d0, code lost:
    
        r13 = r3.o(r11 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01db, code lost:
    
        if (r9 != 1851878757) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01dd, code lost:
    
        r6 = r3.o(r11 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01e7, code lost:
    
        if (r9 != 1684108385) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01e9, code lost:
    
        r5 = r11;
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x01ec, code lost:
    
        r3.F(r11 - 12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x01f1, code lost:
    
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01f4, code lost:
    
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x01f6, code lost:
    
        if (r13 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x01f8, code lost:
    
        if (r6 == null) goto L158;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01fb, code lost:
    
        if (r0 != (-1)) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x01ff, code lost:
    
        r3.E(r0);
        r3.F(16);
        r0 = new com.google.android.exoplayer2.metadata.id3.InternalFrame(r13, r6, r3.o(r5 - 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0215, code lost:
    
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x0219, code lost:
    
        r19 = r8;
        r8 = 16777215 & r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0222, code lost:
    
        if (r8 != 6516084) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x0224, code lost:
    
        r0 = b.i.a.c.x2.i0.h.a(r5, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x022a, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x0230, code lost:
    
        if (r8 == 7233901) goto L160;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0235, code lost:
    
        if (r8 != 7631467) goto L127;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x023c, code lost:
    
        if (r8 == 6516589) goto L159;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0241, code lost:
    
        if (r8 != 7828084) goto L132;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x0248, code lost:
    
        if (r8 != 6578553) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x024a, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TDRC", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0255, code lost:
    
        if (r8 != 4280916) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x0257, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TPE1", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x0261, code lost:
    
        if (r8 != 7630703) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0263, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TSSE", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x026d, code lost:
    
        if (r8 != 6384738) goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x026f, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TALB", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0279, code lost:
    
        if (r8 != 7108978) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x027b, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "USLT", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0285, code lost:
    
        if (r8 != 6776174) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0287, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TCON", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x028f, code lost:
    
        if (r8 != 6779504) goto L153;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0291, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TIT1", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0298, code lost:
    
        r5 = java.lang.String.valueOf(b.i.a.c.x2.i0.d.a(r5));
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x02a6, code lost:
    
        if (r5.length() == 0) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x02a8, code lost:
    
        r5 = "Skipped unknown metadata entry: ".concat(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02ad, code lost:
    
        r5 = new java.lang.String("Skipped unknown metadata entry: ");
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02b2, code lost:
    
        android.util.Log.d("MetadataUtil", r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02b5, code lost:
    
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02b7, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TCOM", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02be, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TIT2", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02c7, code lost:
    
        if (r0 == null) goto L363;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x02c9, code lost:
    
        r4.add(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x02cc, code lost:
    
        r13 = null;
        r6 = r16;
        r0 = r17;
        r8 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x02d5, code lost:
    
        r3.E(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x02d8, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:167:0x02d9, code lost:
    
        r17 = r0;
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x02e1, code lost:
    
        if (r4.isEmpty() == false) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x02e4, code lost:
    
        r0 = new com.google.android.exoplayer2.metadata.Metadata(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0097, code lost:
    
        r3.E(r6);
        r6 = r6 + r7;
        r3.F(r9);
        r4 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00a3, code lost:
    
        r5 = r3.f984b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a5, code lost:
    
        if (r5 >= r6) goto L361;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
    
        r7 = r3.f() + r5;
        r5 = r3.f();
        r9 = (r5 >> 24) & 255;
        r16 = r6;
        r17 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00be, code lost:
    
        if (r9 == 169) goto L117;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c2, code lost:
    
        if (r9 != 253) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c9, code lost:
    
        if (r5 != 1735291493) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00cb, code lost:
    
        r5 = b.i.a.c.x2.i0.h.f(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00cf, code lost:
    
        if (r5 <= 0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d1, code lost:
    
        r9 = b.i.a.c.x2.i0.h.a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00d4, code lost:
    
        if (r5 > r9.length) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00d6, code lost:
    
        r5 = r9[r5 - 1];
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00db, code lost:
    
        r5 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00dc, code lost:
    
        if (r5 == null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00de, code lost:
    
        r0 = new com.google.android.exoplayer2.metadata.id3.TextInformationFrame("TCON", r13, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00e5, code lost:
    
        android.util.Log.w("MetadataUtil", "Failed to parse standard genre code");
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00f1, code lost:
    
        if (r5 != 1684632427) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00f3, code lost:
    
        r0 = b.i.a.c.x2.i0.h.c(r5, "TPOS", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00fe, code lost:
    
        if (r5 != 1953655662) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0100, code lost:
    
        r0 = b.i.a.c.x2.i0.h.c(r5, "TRCK", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x010b, code lost:
    
        if (r5 != 1953329263) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010d, code lost:
    
        r0 = b.i.a.c.x2.i0.h.e(r5, "TBPM", r3, true, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x011b, code lost:
    
        if (r5 != 1668311404) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x011d, code lost:
    
        r0 = b.i.a.c.x2.i0.h.e(r5, "TCMP", r3, true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0128, code lost:
    
        if (r5 != 1668249202) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x012a, code lost:
    
        r0 = b.i.a.c.x2.i0.h.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0133, code lost:
    
        if (r5 != 1631670868) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0135, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TPE2", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0140, code lost:
    
        if (r5 != 1936682605) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0142, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TSOT", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x014c, code lost:
    
        if (r5 != 1936679276) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x014e, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TSO2", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0158, code lost:
    
        if (r5 != 1936679282) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x015a, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TSOA", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0164, code lost:
    
        if (r5 != 1936679265) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0166, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TSOP", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0170, code lost:
    
        if (r5 != 1936679791) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0172, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TSOC", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x017c, code lost:
    
        if (r5 != 1920233063) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x017e, code lost:
    
        r0 = b.i.a.c.x2.i0.h.e(r5, "ITUNESADVISORY", r3, false, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x018a, code lost:
    
        if (r5 != 1885823344) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x018c, code lost:
    
        r0 = b.i.a.c.x2.i0.h.e(r5, "ITUNESGAPLESS", r3, false, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0197, code lost:
    
        if (r5 != 1936683886) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0199, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TVSHOWSORT", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01a3, code lost:
    
        if (r5 != 1953919848) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01a5, code lost:
    
        r0 = b.i.a.c.x2.i0.h.d(r5, "TVSHOW", r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01ab, code lost:
    
        r19 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01b2, code lost:
    
        if (r5 != 757935405) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01b4, code lost:
    
        r0 = -1;
        r5 = -1;
        r6 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x01b7, code lost:
    
        r9 = r3.f984b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01b9, code lost:
    
        if (r9 >= r7) goto L364;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01bb, code lost:
    
        r11 = r3.f();
        r9 = r3.f();
        r19 = r8;
        r3.F(4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01ce, code lost:
    
        if (r9 != 1835360622) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x049e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x04a1  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x05ac  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x05d7  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x05e1  */
    /* JADX WARN: Removed duplicated region for block: B:318:0x061e A[LOOP:12: B:316:0x061b->B:318:0x061e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:322:0x063a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l(long j) throws ParserException {
        ArrayList arrayList;
        boolean z2;
        Metadata metadata;
        int i;
        Metadata metadata2;
        Metadata metadata3;
        Metadata metadata4;
        int size;
        int i2;
        a[] aVarArr;
        int i3;
        int i4;
        ArrayList arrayList2;
        int i5;
        Metadata metadata5;
        int i6;
        int i7;
        ArrayList arrayList3;
        int i8;
        int i9;
        String[] strArr;
        Metadata metadata6;
        MdtaMetadataEntry mdtaMetadataEntry;
        ArrayList arrayList4;
        boolean z3;
        while (!this.g.isEmpty() && this.g.peek().f1209b == j) {
            d.a aVarPop = this.g.pop();
            if (aVarPop.a == 1836019574) {
                ArrayList arrayList5 = new ArrayList();
                boolean z4 = this.f1224x == 1;
                b.i.a.c.x2.p pVar = new b.i.a.c.x2.p();
                d.b bVarC = aVarPop.c(1969517665);
                int i10 = 1768715124;
                int i11 = 1751411826;
                int i12 = 1835365473;
                int i13 = 4;
                int i14 = 8;
                Metadata metadata7 = null;
                if (bVarC != null) {
                    byte[] bArr = e.a;
                    x xVar = bVarC.f1210b;
                    xVar.E(8);
                    Metadata metadata8 = null;
                    String strO = null;
                    while (xVar.a() >= i14) {
                        int i15 = xVar.f984b;
                        int iF = xVar.f();
                        int i16 = i10;
                        int iF2 = xVar.f();
                        if (iF2 == i12) {
                            xVar.E(i15);
                            int i17 = i15 + iF;
                            xVar.F(i14);
                            int i18 = xVar.f984b;
                            xVar.F(i13);
                            if (xVar.f() != i11) {
                                i18 += 4;
                            }
                            xVar.E(i18);
                            int i19 = i16;
                            while (true) {
                                int i20 = xVar.f984b;
                                if (i20 >= i17) {
                                    arrayList4 = arrayList5;
                                    z3 = z4;
                                    break;
                                }
                                int iF3 = xVar.f();
                                if (xVar.f() == i19) {
                                    break;
                                }
                                xVar.E(i20 + iF3);
                                i14 = 8;
                                i19 = 1768715124;
                                strO = null;
                            }
                            Metadata metadata9 = null;
                            metadata7 = metadata9;
                        } else {
                            arrayList4 = arrayList5;
                            z3 = z4;
                            if (iF2 == 1936553057) {
                                xVar.E(i15);
                                int i21 = i15 + iF;
                                xVar.F(12);
                                while (true) {
                                    int i22 = xVar.f984b;
                                    if (i22 >= i21) {
                                        break;
                                    }
                                    int iF4 = xVar.f();
                                    if (xVar.f() != 1935766900) {
                                        xVar.E(i22 + iF4);
                                    } else {
                                        if (iF4 < 14) {
                                            break;
                                        }
                                        xVar.F(5);
                                        int iT = xVar.t();
                                        if (iT == 12 || iT == 13) {
                                            float f = iT == 12 ? 240.0f : 120.0f;
                                            xVar.F(1);
                                            metadata8 = new Metadata(new SmtaMetadataEntry(f, xVar.t()));
                                        }
                                    }
                                }
                                metadata8 = null;
                            }
                        }
                        xVar.E(i15 + iF);
                        i14 = 8;
                        i10 = 1768715124;
                        i11 = 1751411826;
                        i12 = 1835365473;
                        strO = null;
                        i13 = 4;
                        arrayList5 = arrayList4;
                        z4 = z3;
                    }
                    arrayList = arrayList5;
                    z2 = z4;
                    Pair pairCreate = Pair.create(metadata7, metadata8);
                    metadata2 = (Metadata) pairCreate.first;
                    metadata = (Metadata) pairCreate.second;
                    if (metadata2 != null) {
                        pVar.b(metadata2);
                    }
                    i = 1835365473;
                } else {
                    arrayList = arrayList5;
                    z2 = z4;
                    metadata = null;
                    i = 1835365473;
                    metadata2 = null;
                }
                Metadata metadata10 = metadata2;
                d.a aVarB = aVarPop.b(i);
                if (aVarB != null) {
                    byte[] bArr2 = e.a;
                    d.b bVarC2 = aVarB.c(1751411826);
                    d.b bVarC3 = aVarB.c(1801812339);
                    d.b bVarC4 = aVarB.c(1768715124);
                    if (bVarC2 == null || bVarC3 == null || bVarC4 == null) {
                        metadata3 = metadata10;
                        metadata4 = null;
                        Metadata metadata11 = metadata4;
                        List<p> listE = e.e(aVarPop, pVar, -9223372036854775807L, null, (this.f1222b & 1) != 0, z2, b.i.a.c.x2.i0.a.a);
                        b.i.a.c.x2.j jVar = this.f1223s;
                        Objects.requireNonNull(jVar);
                        ArrayList arrayList6 = (ArrayList) listE;
                        size = arrayList6.size();
                        long jMax = -9223372036854775807L;
                        long j2 = -9223372036854775807L;
                        i2 = 0;
                        int size2 = -1;
                        while (i2 < size) {
                            p pVar2 = (p) arrayList6.get(i2);
                            if (pVar2.f1233b == 0) {
                                metadata5 = metadata;
                                arrayList2 = arrayList6;
                                i5 = size;
                                arrayList3 = arrayList;
                            } else {
                                m mVar = pVar2.a;
                                Metadata metadata12 = metadata11;
                                int i23 = size2;
                                long j3 = mVar.e;
                                if (j3 == j2) {
                                    j3 = pVar2.h;
                                }
                                jMax = Math.max(jMax, j3);
                                a aVar = new a(mVar, pVar2, jVar.p(i2, mVar.f1230b));
                                arrayList2 = arrayList6;
                                int i24 = "audio/true-hd".equals(mVar.f.w) ? pVar2.e * 16 : pVar2.e + 30;
                                j1.b bVarA = mVar.f.a();
                                bVarA.l = i24;
                                int i25 = mVar.f1230b;
                                i5 = size;
                                if (i25 == 2 && j3 > 0 && (i8 = pVar2.f1233b) > 1) {
                                    bVarA.r = i8 / (j3 / 1000000.0f);
                                }
                                if (i25 == 1) {
                                    int i26 = pVar.f1294b;
                                    if ((i26 == -1 || pVar.c == -1) ? false : true) {
                                        bVarA.A = i26;
                                        bVarA.B = pVar.c;
                                    }
                                }
                                Metadata[] metadataArr = new Metadata[2];
                                metadataArr[0] = metadata;
                                metadataArr[1] = this.i.isEmpty() ? null : new Metadata(this.i);
                                Metadata metadata13 = new Metadata(new Metadata.Entry[0]);
                                if (i25 == 1) {
                                    if (metadata3 != null) {
                                        metadata5 = metadata;
                                        metadata11 = metadata12;
                                        metadata13 = metadata3;
                                    } else {
                                        metadata5 = metadata;
                                        metadata11 = metadata12;
                                    }
                                    for (i6 = 0; i6 < 2; i6++) {
                                        Metadata metadata14 = metadataArr[i6];
                                        if (metadata14 != null) {
                                            metadata13 = metadata13.a(metadata14.j);
                                        }
                                    }
                                    if (metadata13.j.length > 0) {
                                        bVarA.i = metadata13;
                                    }
                                    aVar.c.e(bVarA.a());
                                    if (mVar.f1230b != 2) {
                                        i7 = i23;
                                        if (i7 == -1) {
                                            size2 = arrayList.size();
                                        }
                                        arrayList3 = arrayList;
                                        arrayList3.add(aVar);
                                    } else {
                                        i7 = i23;
                                    }
                                    size2 = i7;
                                    arrayList3 = arrayList;
                                    arrayList3.add(aVar);
                                } else {
                                    if (i25 == 2 && metadata12 != null) {
                                        int i27 = 0;
                                        metadata11 = metadata12;
                                        while (true) {
                                            Metadata.Entry[] entryArr = metadata11.j;
                                            if (i27 >= entryArr.length) {
                                                metadata5 = metadata;
                                                break;
                                            }
                                            Metadata.Entry entry = entryArr[i27];
                                            if (entry instanceof MdtaMetadataEntry) {
                                                MdtaMetadataEntry mdtaMetadataEntry2 = (MdtaMetadataEntry) entry;
                                                metadata5 = metadata;
                                                if ("com.android.capture.fps".equals(mdtaMetadataEntry2.j)) {
                                                    metadata13 = new Metadata(mdtaMetadataEntry2);
                                                    break;
                                                }
                                            } else {
                                                metadata5 = metadata;
                                            }
                                            i27++;
                                            metadata = metadata5;
                                        }
                                    }
                                    while (i6 < 2) {
                                    }
                                    if (metadata13.j.length > 0) {
                                    }
                                    aVar.c.e(bVarA.a());
                                    if (mVar.f1230b != 2) {
                                    }
                                    size2 = i7;
                                    arrayList3 = arrayList;
                                    arrayList3.add(aVar);
                                }
                            }
                            i2++;
                            j2 = -9223372036854775807L;
                            arrayList = arrayList3;
                            arrayList6 = arrayList2;
                            size = i5;
                            metadata = metadata5;
                        }
                        long j4 = 0;
                        this.v = size2;
                        this.w = jMax;
                        aVarArr = (a[]) arrayList.toArray(new a[0]);
                        this.t = aVarArr;
                        long[][] jArr = new long[aVarArr.length][];
                        int[] iArr = new int[aVarArr.length];
                        long[] jArr2 = new long[aVarArr.length];
                        boolean[] zArr = new boolean[aVarArr.length];
                        for (i3 = 0; i3 < aVarArr.length; i3++) {
                            jArr[i3] = new long[aVarArr[i3].f1226b.f1233b];
                            jArr2[i3] = aVarArr[i3].f1226b.f[0];
                        }
                        i4 = 0;
                        while (i4 < aVarArr.length) {
                            long j5 = RecyclerView.FOREVER_NS;
                            int i28 = -1;
                            for (int i29 = 0; i29 < aVarArr.length; i29++) {
                                if (!zArr[i29] && jArr2[i29] <= j5) {
                                    j5 = jArr2[i29];
                                    i28 = i29;
                                }
                            }
                            int i30 = iArr[i28];
                            jArr[i28][i30] = j4;
                            j4 += aVarArr[i28].f1226b.d[i30];
                            int i31 = i30 + 1;
                            iArr[i28] = i31;
                            if (i31 < jArr[i28].length) {
                                jArr2[i28] = aVarArr[i28].f1226b.f[i31];
                            } else {
                                zArr[i28] = true;
                                i4++;
                            }
                        }
                        this.u = jArr;
                        jVar.j();
                        jVar.a(this);
                        this.g.clear();
                        this.j = 2;
                    } else {
                        x xVar2 = bVarC2.f1210b;
                        xVar2.E(16);
                        if (xVar2.f() == 1835299937) {
                            x xVar3 = bVarC3.f1210b;
                            xVar3.E(12);
                            int iF5 = xVar3.f();
                            String[] strArr2 = new String[iF5];
                            for (int i32 = 0; i32 < iF5; i32++) {
                                int iF6 = xVar3.f();
                                xVar3.F(4);
                                strArr2[i32] = xVar3.q(iF6 - 8);
                            }
                            int i33 = 8;
                            x xVar4 = bVarC4.f1210b;
                            xVar4.E(8);
                            ArrayList arrayList7 = new ArrayList();
                            while (xVar4.a() > i33) {
                                int i34 = xVar4.f984b;
                                int iF7 = xVar4.f();
                                int iF8 = xVar4.f() - 1;
                                if (iF8 < 0 || iF8 >= iF5) {
                                    i9 = iF5;
                                    strArr = strArr2;
                                    metadata6 = metadata10;
                                    b.d.b.a.a.g0(52, "Skipped metadata with unknown key index: ", iF8, "AtomParsers");
                                } else {
                                    String str = strArr2[iF8];
                                    int i35 = i34 + iF7;
                                    while (true) {
                                        int i36 = xVar4.f984b;
                                        if (i36 >= i35) {
                                            i9 = iF5;
                                            strArr = strArr2;
                                            metadata6 = metadata10;
                                            mdtaMetadataEntry = null;
                                            break;
                                        }
                                        int iF9 = xVar4.f();
                                        i9 = iF5;
                                        if (xVar4.f() == 1684108385) {
                                            int iF10 = xVar4.f();
                                            int iF11 = xVar4.f();
                                            int i37 = iF9 - 16;
                                            byte[] bArr3 = new byte[i37];
                                            strArr = strArr2;
                                            metadata6 = metadata10;
                                            System.arraycopy(xVar4.a, xVar4.f984b, bArr3, 0, i37);
                                            xVar4.f984b += i37;
                                            mdtaMetadataEntry = new MdtaMetadataEntry(str, bArr3, iF11, iF10);
                                            break;
                                        }
                                        xVar4.E(i36 + iF9);
                                        iF5 = i9;
                                    }
                                    if (mdtaMetadataEntry != null) {
                                        arrayList7.add(mdtaMetadataEntry);
                                    }
                                }
                                xVar4.E(i34 + iF7);
                                i33 = 8;
                                iF5 = i9;
                                strArr2 = strArr;
                                metadata10 = metadata6;
                            }
                            metadata3 = metadata10;
                            if (!arrayList7.isEmpty()) {
                                metadata4 = new Metadata(arrayList7);
                            }
                            Metadata metadata112 = metadata4;
                            List<p> listE2 = e.e(aVarPop, pVar, -9223372036854775807L, null, (this.f1222b & 1) != 0, z2, b.i.a.c.x2.i0.a.a);
                            b.i.a.c.x2.j jVar2 = this.f1223s;
                            Objects.requireNonNull(jVar2);
                            ArrayList arrayList62 = (ArrayList) listE2;
                            size = arrayList62.size();
                            long jMax2 = -9223372036854775807L;
                            long j22 = -9223372036854775807L;
                            i2 = 0;
                            int size22 = -1;
                            while (i2 < size) {
                            }
                            long j42 = 0;
                            this.v = size22;
                            this.w = jMax2;
                            aVarArr = (a[]) arrayList.toArray(new a[0]);
                            this.t = aVarArr;
                            long[][] jArr3 = new long[aVarArr.length][];
                            int[] iArr2 = new int[aVarArr.length];
                            long[] jArr22 = new long[aVarArr.length];
                            boolean[] zArr2 = new boolean[aVarArr.length];
                            while (i3 < aVarArr.length) {
                            }
                            i4 = 0;
                            while (i4 < aVarArr.length) {
                            }
                            this.u = jArr3;
                            jVar2.j();
                            jVar2.a(this);
                            this.g.clear();
                            this.j = 2;
                        }
                        metadata4 = null;
                        Metadata metadata1122 = metadata4;
                        List<p> listE22 = e.e(aVarPop, pVar, -9223372036854775807L, null, (this.f1222b & 1) != 0, z2, b.i.a.c.x2.i0.a.a);
                        b.i.a.c.x2.j jVar22 = this.f1223s;
                        Objects.requireNonNull(jVar22);
                        ArrayList arrayList622 = (ArrayList) listE22;
                        size = arrayList622.size();
                        long jMax22 = -9223372036854775807L;
                        long j222 = -9223372036854775807L;
                        i2 = 0;
                        int size222 = -1;
                        while (i2 < size) {
                        }
                        long j422 = 0;
                        this.v = size222;
                        this.w = jMax22;
                        aVarArr = (a[]) arrayList.toArray(new a[0]);
                        this.t = aVarArr;
                        long[][] jArr32 = new long[aVarArr.length][];
                        int[] iArr22 = new int[aVarArr.length];
                        long[] jArr222 = new long[aVarArr.length];
                        boolean[] zArr22 = new boolean[aVarArr.length];
                        while (i3 < aVarArr.length) {
                        }
                        i4 = 0;
                        while (i4 < aVarArr.length) {
                        }
                        this.u = jArr32;
                        jVar22.j();
                        jVar22.a(this);
                        this.g.clear();
                        this.j = 2;
                    }
                }
            } else if (!this.g.isEmpty()) {
                this.g.peek().d.add(aVarPop);
            }
        }
        if (this.j != 2) {
            j();
        }
    }

    @Override // b.i.a.c.x2.h
    public void release() {
    }
}
