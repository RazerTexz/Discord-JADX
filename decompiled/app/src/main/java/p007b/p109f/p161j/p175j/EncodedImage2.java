package p007b.p109f.p161j.p175j;

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
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p109f.p115d.p120e.FLog;
import p007b.p109f.p115d.p122g.PooledByteBufferInputStream;
import p007b.p109f.p160i.DefaultImageFormats;
import p007b.p109f.p160i.ImageFormat;
import p007b.p109f.p160i.ImageFormatChecker;
import p007b.p109f.p161j.p169d.BytesRange;
import p007b.p109f.p186k.BitmapUtil;
import p007b.p109f.p186k.ImageMetaData;
import p007b.p109f.p186k.TiffUtil;

/* JADX INFO: renamed from: b.f.j.j.e, reason: use source file name */
/* JADX INFO: compiled from: EncodedImage.java */
/* JADX INFO: loaded from: classes.dex */
public class EncodedImage2 implements Closeable {

    /* JADX INFO: renamed from: j */
    public final CloseableReference<PooledByteBuffer> f3891j;

    /* JADX INFO: renamed from: k */
    public final Supplier<FileInputStream> f3892k;

    /* JADX INFO: renamed from: l */
    public ImageFormat f3893l;

    /* JADX INFO: renamed from: m */
    public int f3894m;

    /* JADX INFO: renamed from: n */
    public int f3895n;

    /* JADX INFO: renamed from: o */
    public int f3896o;

    /* JADX INFO: renamed from: p */
    public int f3897p;

    /* JADX INFO: renamed from: q */
    public int f3898q;

    /* JADX INFO: renamed from: r */
    public int f3899r;

    /* JADX INFO: renamed from: s */
    public BytesRange f3900s;

    /* JADX INFO: renamed from: t */
    public ColorSpace f3901t;

    /* JADX INFO: renamed from: u */
    public boolean f3902u;

    public EncodedImage2(CloseableReference<PooledByteBuffer> closeableReference) {
        this.f3893l = ImageFormat.f3597a;
        this.f3894m = -1;
        this.f3895n = 0;
        this.f3896o = -1;
        this.f3897p = -1;
        this.f3898q = 1;
        this.f3899r = -1;
        AnimatableValueParser.m527i(Boolean.valueOf(CloseableReference.m8640y(closeableReference)));
        this.f3891j = closeableReference.mo999b();
        this.f3892k = null;
    }

    /* JADX INFO: renamed from: a */
    public static EncodedImage2 m1336a(EncodedImage2 encodedImage2) {
        EncodedImage2 encodedImage22 = null;
        if (encodedImage2 != null) {
            Supplier<FileInputStream> supplier = encodedImage2.f3892k;
            if (supplier != null) {
                encodedImage22 = new EncodedImage2(supplier, encodedImage2.f3899r);
            } else {
                CloseableReference closeableReferenceM8636n = CloseableReference.m8636n(encodedImage2.f3891j);
                if (closeableReferenceM8636n != null) {
                    try {
                        encodedImage22 = new EncodedImage2(closeableReferenceM8636n);
                    } finally {
                        closeableReferenceM8636n.close();
                    }
                }
                if (closeableReferenceM8636n != null) {
                }
            }
            if (encodedImage22 != null) {
                encodedImage22.m1339b(encodedImage2);
            }
        }
        return encodedImage22;
    }

    /* JADX INFO: renamed from: s */
    public static boolean m1337s(EncodedImage2 encodedImage2) {
        return encodedImage2.f3894m >= 0 && encodedImage2.f3896o >= 0 && encodedImage2.f3897p >= 0;
    }

    /* JADX INFO: renamed from: u */
    public static boolean m1338u(EncodedImage2 encodedImage2) {
        return encodedImage2 != null && encodedImage2.m1346t();
    }

    /* JADX INFO: renamed from: b */
    public void m1339b(EncodedImage2 encodedImage2) {
        encodedImage2.m1347x();
        this.f3893l = encodedImage2.f3893l;
        encodedImage2.m1347x();
        this.f3896o = encodedImage2.f3896o;
        encodedImage2.m1347x();
        this.f3897p = encodedImage2.f3897p;
        encodedImage2.m1347x();
        this.f3894m = encodedImage2.f3894m;
        encodedImage2.m1347x();
        this.f3895n = encodedImage2.f3895n;
        this.f3898q = encodedImage2.f3898q;
        this.f3899r = encodedImage2.m1344n();
        this.f3900s = encodedImage2.f3900s;
        encodedImage2.m1347x();
        this.f3901t = encodedImage2.f3901t;
        this.f3902u = encodedImage2.f3902u;
    }

    /* JADX INFO: renamed from: c */
    public CloseableReference<PooledByteBuffer> m1340c() {
        return CloseableReference.m8636n(this.f3891j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        CloseableReference<PooledByteBuffer> closeableReference = this.f3891j;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
    }

    /* JADX INFO: renamed from: d */
    public String m1341d(int i) {
        CloseableReference<PooledByteBuffer> closeableReferenceM1340c = m1340c();
        if (closeableReferenceM1340c == null) {
            return "";
        }
        int iMin = Math.min(m1344n(), i);
        byte[] bArr = new byte[iMin];
        try {
            closeableReferenceM1340c.m8642u().mo1396i(0, bArr, 0, iMin);
            closeableReferenceM1340c.close();
            StringBuilder sb = new StringBuilder(iMin * 2);
            for (int i2 = 0; i2 < iMin; i2++) {
                sb.append(String.format("%02X", Byte.valueOf(bArr[i2])));
            }
            return sb.toString();
        } catch (Throwable th) {
            closeableReferenceM1340c.close();
            throw th;
        }
    }

    /* JADX INFO: renamed from: e */
    public InputStream m1342e() {
        Supplier<FileInputStream> supplier = this.f3892k;
        if (supplier != null) {
            return supplier.get();
        }
        CloseableReference closeableReferenceM8636n = CloseableReference.m8636n(this.f3891j);
        if (closeableReferenceM8636n == null) {
            return null;
        }
        try {
            return new PooledByteBufferInputStream((PooledByteBuffer) closeableReferenceM8636n.m8642u());
        } finally {
            closeableReferenceM8636n.close();
        }
    }

    /* JADX INFO: renamed from: f */
    public InputStream m1343f() {
        InputStream inputStreamM1342e = m1342e();
        Objects.requireNonNull(inputStreamM1342e);
        return inputStreamM1342e;
    }

    /* JADX INFO: renamed from: n */
    public int m1344n() {
        CloseableReference<PooledByteBuffer> closeableReference = this.f3891j;
        if (closeableReference == null) {
            return this.f3899r;
        }
        closeableReference.m8642u();
        return this.f3891j.m8642u().size();
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
    /* JADX INFO: renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m1345q() {
        boolean z2;
        int i;
        boolean z3;
        int iM446J1;
        int i2;
        int i3;
        int i4;
        int i5;
        int iM446J12;
        ImageFormat imageFormatM1174b = ImageFormatChecker.m1174b(m1342e());
        this.f3893l = imageFormatM1174b;
        int attributeInt = 0;
        InputStream inputStreamM1342e = null;
        pairM433F0 = null;
        pairM433F0 = null;
        pairM433F0 = null;
        pairM433F0 = null;
        Pair<Integer, Integer> pairM433F0 = null;
        if (DefaultImageFormats.m1172a(imageFormatM1174b) || imageFormatM1174b == DefaultImageFormats.f3594j) {
            InputStream inputStreamM1342e2 = m1342e();
            byte[] bArr = new byte[4];
            try {
                try {
                    inputStreamM1342e2.read(bArr);
                } catch (Throwable th) {
                    if (inputStreamM1342e2 != null) {
                        try {
                            inputStreamM1342e2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.printStackTrace();
                if (inputStreamM1342e2 != null) {
                }
                if (pairM433F0 != null) {
                }
            }
            if (AnimatableValueParser.m441I(bArr, "RIFF")) {
                AnimatableValueParser.m584w0(inputStreamM1342e2);
                inputStreamM1342e2.read(bArr);
                if (AnimatableValueParser.m441I(bArr, "WEBP")) {
                    inputStreamM1342e2.read(bArr);
                    StringBuilder sb = new StringBuilder();
                    for (int i6 = 0; i6 < 4; i6++) {
                        sb.append((char) bArr[i6]);
                    }
                    String string = sb.toString();
                    if ("VP8 ".equals(string)) {
                        pairM433F0 = AnimatableValueParser.m430E0(inputStreamM1342e2);
                    } else if ("VP8L".equals(string)) {
                        pairM433F0 = AnimatableValueParser.m433F0(inputStreamM1342e2);
                    } else {
                        if ("VP8X".equals(string)) {
                            inputStreamM1342e2.skip(8L);
                            Pair<Integer, Integer> pair = new Pair<>(Integer.valueOf(AnimatableValueParser.m428D1(inputStreamM1342e2) + 1), Integer.valueOf(AnimatableValueParser.m428D1(inputStreamM1342e2) + 1));
                            try {
                                inputStreamM1342e2.close();
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                            pairM433F0 = pair;
                        }
                        if (pairM433F0 != null) {
                            this.f3896o = ((Integer) pairM433F0.first).intValue();
                            this.f3897p = ((Integer) pairM433F0.second).intValue();
                        }
                    }
                }
            }
            inputStreamM1342e2.close();
            if (pairM433F0 != null) {
            }
        } else {
            try {
                inputStreamM1342e = m1342e();
                ImageMetaData imageMetaDataM1538a = BitmapUtil.m1538a(inputStreamM1342e);
                this.f3901t = imageMetaDataM1538a.f4278b;
                Pair<Integer, Integer> pair2 = imageMetaDataM1538a.f4277a;
                if (pair2 != null) {
                    this.f3896o = ((Integer) pair2.first).intValue();
                    this.f3897p = ((Integer) pair2.second).intValue();
                }
                try {
                    inputStreamM1342e.close();
                } catch (IOException unused) {
                }
                pairM433F0 = imageMetaDataM1538a.f4277a;
            } catch (Throwable th2) {
                if (inputStreamM1342e != null) {
                    try {
                        inputStreamM1342e.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th2;
            }
        }
        if (imageFormatM1174b != DefaultImageFormats.f3585a || this.f3894m != -1) {
            if (imageFormatM1174b != DefaultImageFormats.f3595k || this.f3894m != -1) {
                if (this.f3894m == -1) {
                    this.f3894m = 0;
                    return;
                }
                return;
            }
            InputStream inputStreamM1342e3 = m1342e();
            if (Build.VERSION.SDK_INT >= 24) {
                try {
                    attributeInt = new ExifInterface(inputStreamM1342e3).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
                } catch (IOException unused3) {
                    int i7 = FLog.f3102a;
                }
            } else {
                int i8 = FLog.f3102a;
            }
            this.f3895n = attributeInt;
            this.f3894m = AnimatableValueParser.m568s0(attributeInt);
            return;
        }
        if (pairM433F0 != null) {
            InputStream inputStreamM1342e4 = m1342e();
            try {
                Objects.requireNonNull(inputStreamM1342e4);
                while (AnimatableValueParser.m446J1(inputStreamM1342e4, 1, false) == 255) {
                    int iM446J13 = 255;
                    while (iM446J13 == 255) {
                        iM446J13 = AnimatableValueParser.m446J1(inputStreamM1342e4, 1, false);
                    }
                    if (iM446J13 == 225) {
                        z2 = true;
                        break;
                    } else if (iM446J13 != 216 && iM446J13 != 1) {
                        if (iM446J13 == 217 || iM446J13 == 218) {
                            break;
                        } else {
                            inputStreamM1342e4.skip(AnimatableValueParser.m446J1(inputStreamM1342e4, 2, false) - 2);
                        }
                    }
                }
                z2 = false;
                if (!z2 || (iM446J12 = AnimatableValueParser.m446J1(inputStreamM1342e4, 2, false) - 2) <= 6) {
                    i = 0;
                    if (i != 0) {
                        if (i > 8) {
                            int iM446J14 = AnimatableValueParser.m446J1(inputStreamM1342e4, 4, false);
                            int i9 = i - 4;
                            if (iM446J14 == 1229531648 || iM446J14 == 1296891946) {
                                z3 = iM446J14 == 1229531648;
                                iM446J1 = AnimatableValueParser.m446J1(inputStreamM1342e4, 4, z3);
                                i2 = i9 - 4;
                                if (iM446J1 < 8 || iM446J1 - 8 > i2) {
                                    FLog.m973a(TiffUtil.class, "Invalid offset");
                                    i2 = 0;
                                }
                                i3 = iM446J1 - 8;
                                if (i2 != 0 && i3 <= i2) {
                                    inputStreamM1342e4.skip(i3);
                                    i4 = i2 - i3;
                                    if (i4 < 14) {
                                        int iM446J15 = AnimatableValueParser.m446J1(inputStreamM1342e4, 2, z3);
                                        int i10 = i4 - 2;
                                        while (true) {
                                            int i11 = iM446J15 - 1;
                                            if (iM446J15 <= 0 || i10 < 12) {
                                                break;
                                            }
                                            i5 = i10 - 2;
                                            if (AnimatableValueParser.m446J1(inputStreamM1342e4, 2, z3) == 274) {
                                                break;
                                            }
                                            inputStreamM1342e4.skip(10L);
                                            i10 = i5 - 10;
                                            iM446J15 = i11;
                                        }
                                        if (i5 < 10 && AnimatableValueParser.m446J1(inputStreamM1342e4, 2, z3) == 3 && AnimatableValueParser.m446J1(inputStreamM1342e4, 4, z3) == 1) {
                                            attributeInt = AnimatableValueParser.m446J1(inputStreamM1342e4, 2, z3);
                                        }
                                    }
                                    i5 = 0;
                                    if (i5 < 10) {
                                        attributeInt = AnimatableValueParser.m446J1(inputStreamM1342e4, 2, z3);
                                    }
                                }
                            } else {
                                FLog.m973a(TiffUtil.class, "Invalid TIFF header");
                            }
                        }
                        i2 = 0;
                        z3 = false;
                        iM446J1 = 0;
                        i3 = iM446J1 - 8;
                        if (i2 != 0) {
                            inputStreamM1342e4.skip(i3);
                            i4 = i2 - i3;
                            if (i4 < 14) {
                            }
                            i5 = 0;
                            if (i5 < 10) {
                            }
                        }
                    }
                } else {
                    int iM446J16 = AnimatableValueParser.m446J1(inputStreamM1342e4, 4, false);
                    int iM446J17 = AnimatableValueParser.m446J1(inputStreamM1342e4, 2, false);
                    i = (iM446J12 - 4) - 2;
                    if (iM446J16 != 1165519206 || iM446J17 != 0) {
                    }
                    if (i != 0) {
                    }
                }
            } catch (IOException unused4) {
            }
            this.f3895n = attributeInt;
            this.f3894m = AnimatableValueParser.m568s0(attributeInt);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0010  */
    /* JADX INFO: renamed from: t */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean m1346t() {
        boolean z2;
        if (!CloseableReference.m8640y(this.f3891j)) {
            z2 = this.f3892k != null;
        }
        return z2;
    }

    /* JADX INFO: renamed from: x */
    public final void m1347x() {
        if (this.f3896o < 0 || this.f3897p < 0) {
            m1345q();
        }
    }

    public EncodedImage2(Supplier<FileInputStream> supplier, int i) {
        this.f3893l = ImageFormat.f3597a;
        this.f3894m = -1;
        this.f3895n = 0;
        this.f3896o = -1;
        this.f3897p = -1;
        this.f3898q = 1;
        this.f3899r = -1;
        Objects.requireNonNull(supplier);
        this.f3891j = null;
        this.f3892k = supplier;
        this.f3899r = i;
    }
}
