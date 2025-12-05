package p007b.p225i.p226a.p242c.p245b3.p247o;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* compiled from: DvbParser.java */
/* renamed from: b.i.a.c.b3.o.b, reason: use source file name */
/* loaded from: classes3.dex */
public final class DvbParser {

    /* renamed from: a */
    public static final byte[] f5916a = {0, 7, 8, 15};

    /* renamed from: b */
    public static final byte[] f5917b = {0, 119, -120, -1};

    /* renamed from: c */
    public static final byte[] f5918c = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};

    /* renamed from: d */
    public final Paint f5919d;

    /* renamed from: e */
    public final Paint f5920e;

    /* renamed from: f */
    public final Canvas f5921f;

    /* renamed from: g */
    public final b f5922g;

    /* renamed from: h */
    public final a f5923h;

    /* renamed from: i */
    public final h f5924i;

    /* renamed from: j */
    public Bitmap f5925j;

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$a */
    public static final class a {

        /* renamed from: a */
        public final int f5926a;

        /* renamed from: b */
        public final int[] f5927b;

        /* renamed from: c */
        public final int[] f5928c;

        /* renamed from: d */
        public final int[] f5929d;

        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.f5926a = i;
            this.f5927b = iArr;
            this.f5928c = iArr2;
            this.f5929d = iArr3;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$b */
    public static final class b {

        /* renamed from: a */
        public final int f5930a;

        /* renamed from: b */
        public final int f5931b;

        /* renamed from: c */
        public final int f5932c;

        /* renamed from: d */
        public final int f5933d;

        /* renamed from: e */
        public final int f5934e;

        /* renamed from: f */
        public final int f5935f;

        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f5930a = i;
            this.f5931b = i2;
            this.f5932c = i3;
            this.f5933d = i4;
            this.f5934e = i5;
            this.f5935f = i6;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$c */
    public static final class c {

        /* renamed from: a */
        public final int f5936a;

        /* renamed from: b */
        public final boolean f5937b;

        /* renamed from: c */
        public final byte[] f5938c;

        /* renamed from: d */
        public final byte[] f5939d;

        public c(int i, boolean z2, byte[] bArr, byte[] bArr2) {
            this.f5936a = i;
            this.f5937b = z2;
            this.f5938c = bArr;
            this.f5939d = bArr2;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$d */
    public static final class d {

        /* renamed from: a */
        public final int f5940a;

        /* renamed from: b */
        public final int f5941b;

        /* renamed from: c */
        public final SparseArray<e> f5942c;

        public d(int i, int i2, int i3, SparseArray<e> sparseArray) {
            this.f5940a = i2;
            this.f5941b = i3;
            this.f5942c = sparseArray;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$e */
    public static final class e {

        /* renamed from: a */
        public final int f5943a;

        /* renamed from: b */
        public final int f5944b;

        public e(int i, int i2) {
            this.f5943a = i;
            this.f5944b = i2;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$f */
    public static final class f {

        /* renamed from: a */
        public final int f5945a;

        /* renamed from: b */
        public final boolean f5946b;

        /* renamed from: c */
        public final int f5947c;

        /* renamed from: d */
        public final int f5948d;

        /* renamed from: e */
        public final int f5949e;

        /* renamed from: f */
        public final int f5950f;

        /* renamed from: g */
        public final int f5951g;

        /* renamed from: h */
        public final int f5952h;

        /* renamed from: i */
        public final int f5953i;

        /* renamed from: j */
        public final SparseArray<g> f5954j;

        public f(int i, boolean z2, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray<g> sparseArray) {
            this.f5945a = i;
            this.f5946b = z2;
            this.f5947c = i2;
            this.f5948d = i3;
            this.f5949e = i5;
            this.f5950f = i6;
            this.f5951g = i7;
            this.f5952h = i8;
            this.f5953i = i9;
            this.f5954j = sparseArray;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$g */
    public static final class g {

        /* renamed from: a */
        public final int f5955a;

        /* renamed from: b */
        public final int f5956b;

        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.f5955a = i3;
            this.f5956b = i4;
        }
    }

    /* compiled from: DvbParser.java */
    /* renamed from: b.i.a.c.b3.o.b$h */
    public static final class h {

        /* renamed from: a */
        public final int f5957a;

        /* renamed from: b */
        public final int f5958b;

        /* renamed from: c */
        public final SparseArray<f> f5959c = new SparseArray<>();

        /* renamed from: d */
        public final SparseArray<a> f5960d = new SparseArray<>();

        /* renamed from: e */
        public final SparseArray<c> f5961e = new SparseArray<>();

        /* renamed from: f */
        public final SparseArray<a> f5962f = new SparseArray<>();

        /* renamed from: g */
        public final SparseArray<c> f5963g = new SparseArray<>();

        /* renamed from: h */
        @Nullable
        public b f5964h;

        /* renamed from: i */
        @Nullable
        public d f5965i;

        public h(int i, int i2) {
            this.f5957a = i;
            this.f5958b = i2;
        }
    }

    public DvbParser(int i, int i2) {
        Paint paint = new Paint();
        this.f5919d = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.f5920e = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.f5921f = new Canvas();
        this.f5922g = new b(719, 575, 0, 719, 0, 575);
        this.f5923h = new a(0, new int[]{0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505}, m2661b(), m2662c());
        this.f5924i = new h(i, i2);
    }

    /* renamed from: a */
    public static byte[] m2660a(int i, int i2, ParsableBitArray parsableBitArray) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) parsableBitArray.m3067g(i2);
        }
        return bArr;
    }

    /* renamed from: b */
    public static int[] m2661b() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i = 1; i < 16; i++) {
            if (i < 8) {
                iArr[i] = m2663d(255, (i & 1) != 0 ? 255 : 0, (i & 2) != 0 ? 255 : 0, (i & 4) != 0 ? 255 : 0);
            } else {
                int i2 = i & 1;
                int i3 = Opcodes.LAND;
                int i4 = i2 != 0 ? Opcodes.LAND : 0;
                int i5 = (i & 2) != 0 ? Opcodes.LAND : 0;
                if ((i & 4) == 0) {
                    i3 = 0;
                }
                iArr[i] = m2663d(255, i4, i5, i3);
            }
        }
        return iArr;
    }

    /* renamed from: c */
    public static int[] m2662c() {
        int i;
        int[] iArr = new int[256];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = m2663d(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & Opcodes.L2I;
                int i4 = Opcodes.TABLESWITCH;
                if (i3 == 0) {
                    int i5 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i6 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = m2663d(255, i5, i6, i + i4);
                } else if (i3 == 8) {
                    int i7 = ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? Opcodes.TABLESWITCH : 0);
                    int i8 = ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? Opcodes.TABLESWITCH : 0);
                    i = (i2 & 4) == 0 ? 0 : 85;
                    if ((i2 & 64) == 0) {
                        i4 = 0;
                    }
                    iArr[i2] = m2663d(Opcodes.LAND, i7, i8, i + i4);
                } else if (i3 == 128) {
                    iArr[i2] = m2663d(255, ((i2 & 1) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + Opcodes.LAND + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + Opcodes.LAND + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = m2663d(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    /* renamed from: d */
    public static int m2663d(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x01d1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x01fb  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x020b A[LOOP:3: B:87:0x0163->B:118:0x020b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x013b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0205 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0112 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0141 A[LOOP:2: B:41:0x00ab->B:74:0x0141, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0184 A[PHI: r1
      0x0184: PHI (r1v4 int) = (r1v3 int), (r1v22 int) binds: [B:88:0x0167, B:95:0x0183] A[DONT_GENERATE, DONT_INLINE]] */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2664e(byte[] bArr, int[] iArr, int i, int i2, int i3, @Nullable Paint paint, Canvas canvas) {
        byte[] bArr2;
        byte[] bArr3;
        boolean z2;
        int iM3067g;
        boolean z3;
        int i4;
        int i5;
        int iM3067g2;
        int iM3067g3;
        boolean z4;
        int iM3067g4;
        int i6;
        int i7;
        int iM3067g5;
        boolean z5;
        int iM3067g6;
        ParsableBitArray parsableBitArray = new ParsableBitArray(bArr);
        int i8 = i2;
        int i9 = i3;
        byte[] bArrM2660a = null;
        byte[] bArrM2660a2 = null;
        byte[] bArrM2660a3 = null;
        while (parsableBitArray.m3062b() != 0) {
            int i10 = 8;
            int iM3067g7 = parsableBitArray.m3067g(8);
            if (iM3067g7 != 240) {
                int i11 = 4;
                int i12 = 2;
                switch (iM3067g7) {
                    case 16:
                        if (i == 3) {
                            bArr3 = bArrM2660a == null ? f5917b : bArrM2660a;
                        } else if (i == 2) {
                            bArr3 = bArrM2660a3 == null ? f5916a : bArrM2660a3;
                        } else {
                            bArr2 = null;
                            int i13 = i8;
                            z2 = false;
                            while (true) {
                                iM3067g = parsableBitArray.m3067g(2);
                                if (iM3067g == 0) {
                                    if (parsableBitArray.m3066f()) {
                                        iM3067g2 = parsableBitArray.m3067g(3) + 3;
                                        iM3067g3 = parsableBitArray.m3067g(2);
                                    } else if (parsableBitArray.m3066f()) {
                                        iM3067g = 0;
                                        z3 = z2;
                                        i4 = 1;
                                        if (i4 == 0 || paint == null) {
                                            i5 = i13;
                                        } else {
                                            if (bArr2 != 0) {
                                                iM3067g = bArr2[iM3067g];
                                            }
                                            paint.setColor(iArr[iM3067g]);
                                            i5 = i13;
                                            canvas.drawRect(i13, i9, i13 + i4, i9 + 1, paint);
                                        }
                                        i13 = i5 + i4;
                                        if (!z3) {
                                            parsableBitArray.m3063c();
                                            i8 = i13;
                                        } else {
                                            z2 = z3;
                                        }
                                        break;
                                    } else {
                                        int iM3067g8 = parsableBitArray.m3067g(2);
                                        if (iM3067g8 == 0) {
                                            z2 = true;
                                        } else if (iM3067g8 == 1) {
                                            z3 = z2;
                                            iM3067g = 0;
                                            i4 = 2;
                                            if (i4 == 0) {
                                                i5 = i13;
                                                i13 = i5 + i4;
                                                if (!z3) {
                                                }
                                            }
                                        } else if (iM3067g8 == 2) {
                                            iM3067g2 = parsableBitArray.m3067g(4) + 12;
                                            iM3067g3 = parsableBitArray.m3067g(2);
                                        } else if (iM3067g8 == 3) {
                                            iM3067g2 = parsableBitArray.m3067g(8) + 29;
                                            iM3067g3 = parsableBitArray.m3067g(2);
                                        }
                                        z3 = z2;
                                        iM3067g = 0;
                                        i4 = 0;
                                        if (i4 == 0) {
                                        }
                                    }
                                    i4 = iM3067g2;
                                    iM3067g = iM3067g3;
                                    z3 = z2;
                                    if (i4 == 0) {
                                    }
                                } else {
                                    z3 = z2;
                                    i4 = 1;
                                    if (i4 == 0) {
                                    }
                                }
                            }
                        }
                        bArr2 = bArr3;
                        int i132 = i8;
                        z2 = false;
                        while (true) {
                            iM3067g = parsableBitArray.m3067g(2);
                            if (iM3067g == 0) {
                            }
                            z2 = z3;
                        }
                        break;
                    case 17:
                        byte[] bArr4 = i == 3 ? bArrM2660a2 == null ? f5918c : bArrM2660a2 : null;
                        int i14 = i8;
                        boolean z6 = false;
                        while (true) {
                            int iM3067g9 = parsableBitArray.m3067g(i11);
                            if (iM3067g9 != 0) {
                                z4 = z6;
                                iM3067g4 = iM3067g9;
                                i6 = 1;
                                if (i6 == 0) {
                                }
                            } else if (parsableBitArray.m3066f()) {
                                if (parsableBitArray.m3066f()) {
                                    int iM3067g10 = parsableBitArray.m3067g(i12);
                                    if (iM3067g10 == 0) {
                                        iM3067g9 = 0;
                                        z4 = z6;
                                        iM3067g4 = iM3067g9;
                                        i6 = 1;
                                        if (i6 == 0) {
                                        }
                                    } else if (iM3067g10 == 1) {
                                        z4 = z6;
                                        iM3067g4 = 0;
                                        i6 = 2;
                                        if (i6 == 0) {
                                        }
                                    } else if (iM3067g10 != i12) {
                                        if (iM3067g10 == 3) {
                                            iM3067g5 = parsableBitArray.m3067g(i10) + 25;
                                            iM3067g4 = parsableBitArray.m3067g(i11);
                                        }
                                        z4 = z6;
                                        iM3067g4 = 0;
                                        i6 = 0;
                                        if (i6 == 0) {
                                        }
                                    } else {
                                        iM3067g5 = parsableBitArray.m3067g(i11) + 9;
                                        iM3067g4 = parsableBitArray.m3067g(i11);
                                    }
                                } else {
                                    iM3067g5 = parsableBitArray.m3067g(i12) + i11;
                                    iM3067g4 = parsableBitArray.m3067g(i11);
                                }
                                z4 = z6;
                                i6 = iM3067g5;
                                if (i6 == 0) {
                                }
                            } else {
                                int iM3067g11 = parsableBitArray.m3067g(3);
                                if (iM3067g11 != 0) {
                                    z4 = z6;
                                    i6 = iM3067g11 + 2;
                                    iM3067g4 = 0;
                                    if (i6 == 0 || paint == null) {
                                        i7 = i14;
                                    } else {
                                        if (bArr4 != 0) {
                                            iM3067g4 = bArr4[iM3067g4];
                                        }
                                        paint.setColor(iArr[iM3067g4]);
                                        i7 = i14;
                                        canvas.drawRect(i14, i9, i14 + i6, i9 + 1, paint);
                                    }
                                    i14 = i7 + i6;
                                    if (!z4) {
                                        parsableBitArray.m3063c();
                                        i8 = i14;
                                    } else {
                                        z6 = z4;
                                        i12 = 2;
                                        i11 = 4;
                                        i10 = 8;
                                    }
                                    break;
                                } else {
                                    z6 = true;
                                    z4 = z6;
                                    iM3067g4 = 0;
                                    i6 = 0;
                                    if (i6 == 0) {
                                        i7 = i14;
                                        i14 = i7 + i6;
                                        if (!z4) {
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 18:
                        int i15 = i8;
                        boolean z7 = false;
                        while (true) {
                            int iM3067g12 = parsableBitArray.m3067g(8);
                            if (iM3067g12 != 0) {
                                z5 = z7;
                                iM3067g6 = 1;
                            } else if (parsableBitArray.m3066f()) {
                                z5 = z7;
                                iM3067g6 = parsableBitArray.m3067g(7);
                                iM3067g12 = parsableBitArray.m3067g(8);
                            } else {
                                int iM3067g13 = parsableBitArray.m3067g(7);
                                if (iM3067g13 != 0) {
                                    z5 = z7;
                                    iM3067g6 = iM3067g13;
                                    iM3067g12 = 0;
                                } else {
                                    iM3067g12 = 0;
                                    z5 = true;
                                    iM3067g6 = 0;
                                }
                            }
                            if (iM3067g6 != 0 && paint != null) {
                                paint.setColor(iArr[iM3067g12]);
                                canvas.drawRect(i15, i9, i15 + iM3067g6, i9 + 1, paint);
                            }
                            i15 += iM3067g6;
                            if (z5) {
                                i8 = i15;
                            } else {
                                z7 = z5;
                            }
                            break;
                        }
                        break;
                    default:
                        switch (iM3067g7) {
                            case 32:
                                bArrM2660a3 = m2660a(4, 4, parsableBitArray);
                                break;
                            case 33:
                                bArrM2660a = m2660a(4, 8, parsableBitArray);
                                break;
                            case 34:
                                bArrM2660a2 = m2660a(16, 8, parsableBitArray);
                                break;
                        }
                        break;
                }
            } else {
                i9 += 2;
                i8 = i2;
            }
        }
    }

    /* renamed from: f */
    public static a m2665f(ParsableBitArray parsableBitArray, int i) {
        int iM3067g;
        int iM3067g2;
        int iM3067g3;
        int iM3067g4;
        int i2 = 8;
        int iM3067g5 = parsableBitArray.m3067g(8);
        parsableBitArray.m3073m(8);
        int i3 = i - 2;
        int i4 = 4;
        int[] iArr = {0, -1, ViewCompat.MEASURED_STATE_MASK, -8421505};
        int[] iArrM2661b = m2661b();
        int[] iArrM2662c = m2662c();
        while (i3 > 0) {
            int iM3067g6 = parsableBitArray.m3067g(i2);
            int iM3067g7 = parsableBitArray.m3067g(i2);
            int i5 = i3 - 2;
            int[] iArr2 = (iM3067g7 & 128) != 0 ? iArr : (iM3067g7 & 64) != 0 ? iArrM2661b : iArrM2662c;
            if ((iM3067g7 & 1) != 0) {
                iM3067g3 = parsableBitArray.m3067g(i2);
                iM3067g = parsableBitArray.m3067g(i2);
                iM3067g4 = parsableBitArray.m3067g(i2);
                iM3067g2 = parsableBitArray.m3067g(i2);
                i3 = i5 - 4;
            } else {
                int iM3067g8 = parsableBitArray.m3067g(6) << 2;
                int iM3067g9 = parsableBitArray.m3067g(i4) << i4;
                int iM3067g10 = parsableBitArray.m3067g(i4) << i4;
                i3 = i5 - 2;
                iM3067g = iM3067g9;
                iM3067g2 = parsableBitArray.m3067g(2) << 6;
                iM3067g3 = iM3067g8;
                iM3067g4 = iM3067g10;
            }
            if (iM3067g3 == 0) {
                iM3067g = 0;
                iM3067g4 = 0;
                iM3067g2 = 255;
            }
            double d2 = iM3067g3;
            double d3 = iM3067g - 128;
            double d4 = iM3067g4 - 128;
            iArr2[iM3067g6] = m2663d((byte) (255 - (iM3067g2 & 255)), Util2.m3000h((int) ((1.402d * d3) + d2), 0, 255), Util2.m3000h((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), Util2.m3000h((int) ((d4 * 1.772d) + d2), 0, 255));
            iArr = iArr;
            iM3067g5 = iM3067g5;
            i2 = 8;
            i4 = 4;
        }
        return new a(iM3067g5, iArr, iArrM2661b, iArrM2662c);
    }

    /* renamed from: g */
    public static c m2666g(ParsableBitArray parsableBitArray) {
        byte[] bArr;
        int iM3067g = parsableBitArray.m3067g(16);
        parsableBitArray.m3073m(4);
        int iM3067g2 = parsableBitArray.m3067g(2);
        boolean zM3066f = parsableBitArray.m3066f();
        parsableBitArray.m3073m(1);
        byte[] bArr2 = Util2.f6713f;
        if (iM3067g2 != 1) {
            if (iM3067g2 == 0) {
                int iM3067g3 = parsableBitArray.m3067g(16);
                int iM3067g4 = parsableBitArray.m3067g(16);
                if (iM3067g3 > 0) {
                    bArr2 = new byte[iM3067g3];
                    parsableBitArray.m3069i(bArr2, 0, iM3067g3);
                }
                if (iM3067g4 > 0) {
                    bArr = new byte[iM3067g4];
                    parsableBitArray.m3069i(bArr, 0, iM3067g4);
                }
            }
            return new c(iM3067g, zM3066f, bArr2, bArr);
        }
        parsableBitArray.m3073m(parsableBitArray.m3067g(8) * 16);
        bArr = bArr2;
        return new c(iM3067g, zM3066f, bArr2, bArr);
    }
}
