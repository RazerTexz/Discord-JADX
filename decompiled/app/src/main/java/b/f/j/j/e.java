package b.f.j.j;

import android.graphics.ColorSpace;
import android.media.ExifInterface;
import android.os.Build;
import android.util.Pair;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/* compiled from: EncodedImage.java */
/* loaded from: classes.dex */
public class e implements Closeable {
    public final CloseableReference<PooledByteBuffer> j;
    public final Supplier<FileInputStream> k;
    public b.f.i.c l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public b.f.j.d.a f590s;
    public ColorSpace t;
    public boolean u;

    public e(CloseableReference<PooledByteBuffer> closeableReference) {
        this.l = b.f.i.c.a;
        this.m = -1;
        this.n = 0;
        this.o = -1;
        this.p = -1;
        this.q = 1;
        this.r = -1;
        b.c.a.a0.d.i(Boolean.valueOf(CloseableReference.y(closeableReference)));
        this.j = closeableReference.b();
        this.k = null;
    }

    public static e a(e eVar) {
        e eVar2 = null;
        if (eVar != null) {
            Supplier<FileInputStream> supplier = eVar.k;
            if (supplier != null) {
                eVar2 = new e(supplier, eVar.r);
            } else {
                CloseableReference closeableReferenceN = CloseableReference.n(eVar.j);
                if (closeableReferenceN != null) {
                    try {
                        eVar2 = new e(closeableReferenceN);
                    } finally {
                        closeableReferenceN.close();
                    }
                }
                if (closeableReferenceN != null) {
                }
            }
            if (eVar2 != null) {
                eVar2.b(eVar);
            }
        }
        return eVar2;
    }

    public static boolean s(e eVar) {
        return eVar.m >= 0 && eVar.o >= 0 && eVar.p >= 0;
    }

    public static boolean u(e eVar) {
        return eVar != null && eVar.t();
    }

    public void b(e eVar) {
        eVar.x();
        this.l = eVar.l;
        eVar.x();
        this.o = eVar.o;
        eVar.x();
        this.p = eVar.p;
        eVar.x();
        this.m = eVar.m;
        eVar.x();
        this.n = eVar.n;
        this.q = eVar.q;
        this.r = eVar.n();
        this.f590s = eVar.f590s;
        eVar.x();
        this.t = eVar.t;
        this.u = eVar.u;
    }

    public CloseableReference<PooledByteBuffer> c() {
        return CloseableReference.n(this.j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<PooledByteBuffer> closeableReference = this.j;
        Class<CloseableReference> cls = CloseableReference.j;
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    public String d(int i) {
        CloseableReference<PooledByteBuffer> closeableReferenceC = c();
        if (closeableReferenceC == null) {
            return "";
        }
        int iMin = Math.min(n(), i);
        byte[] bArr = new byte[iMin];
        try {
            closeableReferenceC.u().i(0, bArr, 0, iMin);
            closeableReferenceC.close();
            StringBuilder sb = new StringBuilder(iMin * 2);
            for (int i2 = 0; i2 < iMin; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } catch (Throwable th) {
            closeableReferenceC.close();
            throw th;
        }
    }

    public InputStream e() {
        Supplier<FileInputStream> supplier = this.k;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference closeableReferenceN = CloseableReference.n(this.j);
        if (closeableReferenceN == null) {
            return null;
        }
        try {
            return new b.f.d.g.h((PooledByteBuffer) closeableReferenceN.u());
        } finally {
            closeableReferenceN.close();
        }
    }

    public InputStream f() {
        InputStream inputStreamE = e();
        Objects.requireNonNull(inputStreamE);
        return inputStreamE;
    }

    public int n() {
        CloseableReference<PooledByteBuffer> closeableReference = this.j;
        if (closeableReference == null) {
            return this.r;
        }
        closeableReference.u();
        return this.j.u().size();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:11|162|12|(1:14)(2:15|(1:17)(5:18|(1:20)|192|21|(1:23)(2:24|(1:26)(3:27|(4:29|165|30|34)|(1:45)))))|175|40|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ac, code lost:
    
        r1 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00ad, code lost:
    
        r1.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01ac A[Catch: IOException -> 0x01e5, TryCatch #5 {IOException -> 0x01e5, blocks: (B:63:0x010a, B:64:0x010d, B:68:0x011a, B:84:0x0142, B:86:0x014a, B:110:0x019a, B:114:0x01a0, B:130:0x01d2, B:133:0x01da, B:136:0x01e1, B:117:0x01ac, B:118:0x01b2, B:122:0x01ba, B:125:0x01c3, B:96:0x016a, B:100:0x017a, B:105:0x0188, B:107:0x0190, B:109:0x0194, B:81:0x0135), top: B:169:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01d1 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01d2 A[Catch: IOException -> 0x01e5, TryCatch #5 {IOException -> 0x01e5, blocks: (B:63:0x010a, B:64:0x010d, B:68:0x011a, B:84:0x0142, B:86:0x014a, B:110:0x019a, B:114:0x01a0, B:130:0x01d2, B:133:0x01da, B:136:0x01e1, B:117:0x01ac, B:118:0x01b2, B:122:0x01ba, B:125:0x01c3, B:96:0x016a, B:100:0x017a, B:105:0x0188, B:107:0x0190, B:109:0x0194, B:81:0x0135), top: B:169:0x010a }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0161  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0163  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q() {
        boolean z2;
        int i;
        boolean z3;
        int iJ1;
        int i2;
        int i3;
        int i4;
        int i5;
        int iJ12;
        b.f.i.c cVarB = b.f.i.d.b(e());
        this.l = cVarB;
        int attributeInt = 0;
        InputStream inputStreamE = null;
        pairF0 = null;
        pairF0 = null;
        pairF0 = null;
        pairF0 = null;
        Pair<Integer, Integer> pairF0 = null;
        if (b.f.i.b.a(cVarB) || cVarB == b.f.i.b.j) {
            InputStream inputStreamE2 = e();
            byte[] bArr = new byte[4];
            try {
                try {
                    inputStreamE2.read(bArr);
                } catch (Throwable th) {
                    if (inputStreamE2 != null) {
                        try {
                            inputStreamE2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (inputStreamE2 != null) {
                }
            }
            if (b.c.a.a0.d.I(bArr, "RIFF")) {
                b.c.a.a0.d.w0(inputStreamE2);
                inputStreamE2.read(bArr);
                if (b.c.a.a0.d.I(bArr, "WEBP")) {
                    inputStreamE2.read(bArr);
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < 4; i6++) {
                        sb.append((char) bArr[i6]);
                    }
                    String string = sb.toString();
                    if ("VP8 ".equals(string)) {
                        pairF0 = b.c.a.a0.d.E0(inputStreamE2);
                    } else if ("VP8L".equals(string)) {
                        pairF0 = b.c.a.a0.d.F0(inputStreamE2);
                    } else {
                        if ("VP8X".equals(string)) {
                            inputStreamE2.skip(8L);
                            Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(b.c.a.a0.d.D1(inputStreamE2) + 1), Integer.valueOf(b.c.a.a0.d.D1(inputStreamE2) + 1));
                            try {
                                inputStreamE2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            pairF0 = pair;
                        }
                        if (pairF0 != null) {
                            this.o = ((Integer) pairF0.first).intValue();
                            this.p = ((Integer) pairF0.second).intValue();
                        }
                    }
                }
            }
            inputStreamE2.close();
            if (pairF0 != null) {
            }
        } else {
            try {
                inputStreamE = e();
                b.f.k.b bVarA = b.f.k.a.a(inputStreamE);
                this.t = bVarA.f646b;
                Pair<Integer, Integer> pair2 = bVarA.a;
                if (pair2 != null) {
                    this.o = ((Integer) pair2.first).intValue();
                    this.p = ((Integer) pair2.second).intValue();
                }
                try {
                    inputStreamE.close();
                } catch (IOException unused) {
                }
                pairF0 = bVarA.a;
            } catch (Throwable th2) {
                if (inputStreamE != null) {
                    try {
                        inputStreamE.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th2;
            }
        }
        if (cVarB != b.f.i.b.a || this.m != -1) {
            if (cVarB != b.f.i.b.k || this.m != -1) {
                if (this.m == -1) {
                    this.m = 0;
                    return;
                }
                return;
            }
            InputStream inputStreamE3 = e();
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    attributeInt = new ExifInterface(inputStreamE3).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                } catch (IOException unused3) {
                    int i7 = b.f.d.e.a.a;
                }
            } else {
                int i8 = b.f.d.e.a.a;
            }
            this.n = attributeInt;
            this.m = b.c.a.a0.d.s0(attributeInt);
            return;
        }
        if (pairF0 != null) {
            InputStream inputStreamE4 = e();
            try {
                Objects.requireNonNull(inputStreamE4);
                while (b.c.a.a0.d.J1(inputStreamE4, 1, false) == 255) {
                    int iJ13 = 255;
                    while (iJ13 == 255) {
                        iJ13 = b.c.a.a0.d.J1(inputStreamE4, 1, false);
                    }
                    if (iJ13 == 225) {
                        z2 = true;
                        break;
                    } else if (iJ13 != 216 && iJ13 != 1) {
                        if (iJ13 == 217 || iJ13 == 218) {
                            break;
                        } else {
                            inputStreamE4.skip(b.c.a.a0.d.J1(inputStreamE4, 2, false) - 2);
                        }
                    }
                }
                z2 = false;
                if (!z2 || (iJ12 = b.c.a.a0.d.J1(inputStreamE4, 2, false) - 2) <= 6) {
                    i = 0;
                    if (i != 0) {
                        if (i > 8) {
                            int iJ14 = b.c.a.a0.d.J1(inputStreamE4, 4, false);
                            int i9 = i - 4;
                            if (iJ14 == 1229531648 || iJ14 == 1296891946) {
                                z3 = iJ14 == 1229531648;
                                iJ1 = b.c.a.a0.d.J1(inputStreamE4, 4, z3);
                                i2 = i9 - 4;
                                if (iJ1 < 8 || iJ1 - 8 > i2) {
                                    b.f.d.e.a.a(b.f.k.c.class, "Invalid offset");
                                    i2 = 0;
                                }
                                i3 = iJ1 - 8;
                                if (i2 != 0 && i3 <= i2) {
                                    inputStreamE4.skip(i3);
                                    i4 = i2 - i3;
                                    if (i4 < 14) {
                                        int iJ15 = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                                        int i10 = i4 - 2;
                                        while (true) {
                                            int i11 = iJ15 - 1;
                                            if (iJ15 <= 0 || i10 < 12) {
                                                break;
                                            }
                                            i5 = i10 - 2;
                                            if (b.c.a.a0.d.J1(inputStreamE4, 2, z3) == 274) {
                                                break;
                                            }
                                            inputStreamE4.skip(10L);
                                            i10 = i5 - 10;
                                            iJ15 = i11;
                                        }
                                        if (i5 < 10 && b.c.a.a0.d.J1(inputStreamE4, 2, z3) == 3 && b.c.a.a0.d.J1(inputStreamE4, 4, z3) == 1) {
                                            attributeInt = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                                        }
                                    }
                                    i5 = 0;
                                    if (i5 < 10) {
                                        attributeInt = b.c.a.a0.d.J1(inputStreamE4, 2, z3);
                                    }
                                }
                            } else {
                                b.f.d.e.a.a(b.f.k.c.class, "Invalid TIFF header");
                            }
                        }
                        i2 = 0;
                        z3 = false;
                        iJ1 = 0;
                        i3 = iJ1 - 8;
                        if (i2 != 0) {
                            inputStreamE4.skip(i3);
                            i4 = i2 - i3;
                            if (i4 < 14) {
                            }
                            i5 = 0;
                            if (i5 < 10) {
                            }
                        }
                    }
                } else {
                    int iJ16 = b.c.a.a0.d.J1(inputStreamE4, 4, false);
                    int iJ17 = b.c.a.a0.d.J1(inputStreamE4, 2, false);
                    i = (iJ12 - 4) - 2;
                    if (iJ16 != 1165519206 || iJ17 != 0) {
                    }
                    if (i != 0) {
                    }
                }
            } catch (IOException unused4) {
            }
            this.n = attributeInt;
            this.m = b.c.a.a0.d.s0(attributeInt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean t() {
        boolean z2;
        if (!CloseableReference.y(this.j)) {
            z2 = this.k != null;
        }
        return z2;
    }

    public final void x() {
        if (this.o < 0 || this.p < 0) {
            q();
        }
    }

    public e(Supplier<FileInputStream> supplier, int i) {
        this.l = b.f.i.c.a;
        this.m = -1;
        this.n = 0;
        this.o = -1;
        this.p = -1;
        this.q = 1;
        this.r = -1;
        Objects.requireNonNull(supplier);
        this.j = null;
        this.k = supplier;
        this.r = i;
    }
}
