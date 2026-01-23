package p617h0.p618a.p619a;

import java.util.Objects;

/* JADX INFO: renamed from: h0.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: AnnotationWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationWriter2 {

    /* JADX INFO: renamed from: a */
    public final SymbolTable2 f26141a;

    /* JADX INFO: renamed from: b */
    public final boolean f26142b;

    /* JADX INFO: renamed from: c */
    public final ByteVector2 f26143c;

    /* JADX INFO: renamed from: d */
    public final int f26144d;

    /* JADX INFO: renamed from: e */
    public int f26145e;

    /* JADX INFO: renamed from: f */
    public final AnnotationWriter2 f26146f;

    /* JADX INFO: renamed from: g */
    public AnnotationWriter2 f26147g;

    public AnnotationWriter2(SymbolTable2 symbolTable2, boolean z2, ByteVector2 byteVector2, AnnotationWriter2 annotationWriter2) {
        this.f26141a = symbolTable2;
        this.f26142b = z2;
        this.f26143c = byteVector2;
        int i = byteVector2.f26154b;
        this.f26144d = i == 0 ? -1 : i - 2;
        this.f26146f = annotationWriter2;
        if (annotationWriter2 != null) {
            annotationWriter2.f26147g = this;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m10516b(String str, AnnotationWriter2[] annotationWriter2Arr, int i) {
        int iM10518a = (i * 2) + 7;
        for (int i2 = 0; i2 < i; i2++) {
            iM10518a += annotationWriter2Arr[i2] == null ? 0 : r3.m10518a(str) - 8;
        }
        return iM10518a;
    }

    /* JADX INFO: renamed from: d */
    public static void m10517d(int i, AnnotationWriter2[] annotationWriter2Arr, int i2, ByteVector2 byteVector2) {
        int iM10518a = (i2 * 2) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            iM10518a += annotationWriter2Arr[i3] == null ? 0 : r4.m10518a(null) - 8;
        }
        byteVector2.m10538j(i);
        byteVector2.m10537i(iM10518a);
        byteVector2.m10535g(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            AnnotationWriter2 annotationWriter2 = null;
            int i5 = 0;
            for (AnnotationWriter2 annotationWriter22 = annotationWriter2Arr[i4]; annotationWriter22 != null; annotationWriter22 = annotationWriter22.f26146f) {
                annotationWriter22.m10522g();
                i5++;
                annotationWriter2 = annotationWriter22;
            }
            byteVector2.m10538j(i5);
            while (annotationWriter2 != null) {
                ByteVector2 byteVector22 = annotationWriter2.f26143c;
                byteVector2.m10536h(byteVector22.f26153a, 0, byteVector22.f26154b);
                annotationWriter2 = annotationWriter2.f26147g;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m10518a(String str) {
        if (str != null) {
            this.f26141a.m10637l(str);
        }
        int i = 8;
        for (AnnotationWriter2 annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.f26146f) {
            i += annotationWriter2.f26143c.f26154b;
        }
        return i;
    }

    /* JADX INFO: renamed from: c */
    public void m10519c(int i, ByteVector2 byteVector2) {
        int i2 = 2;
        int i3 = 0;
        AnnotationWriter2 annotationWriter2 = null;
        for (AnnotationWriter2 annotationWriter22 = this; annotationWriter22 != null; annotationWriter22 = annotationWriter22.f26146f) {
            annotationWriter22.m10522g();
            i2 += annotationWriter22.f26143c.f26154b;
            i3++;
            annotationWriter2 = annotationWriter22;
        }
        byteVector2.m10538j(i);
        byteVector2.m10537i(i2);
        byteVector2.m10538j(i3);
        while (annotationWriter2 != null) {
            ByteVector2 byteVector22 = annotationWriter2.f26143c;
            byteVector2.m10536h(byteVector22.f26153a, 0, byteVector22.f26154b);
            annotationWriter2 = annotationWriter2.f26147g;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m10520e(String str, Object obj) {
        this.f26145e++;
        if (this.f26142b) {
            this.f26143c.m10538j(this.f26141a.m10637l(str));
        }
        if (obj instanceof String) {
            this.f26143c.m10533e(115, this.f26141a.m10637l((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.f26143c.m10533e(66, this.f26141a.m10630e(((Byte) obj).byteValue()).f26340a);
            return;
        }
        if (obj instanceof Boolean) {
            this.f26143c.m10533e(90, this.f26141a.m10630e(((Boolean) obj).booleanValue() ? 1 : 0).f26340a);
            return;
        }
        if (obj instanceof Character) {
            this.f26143c.m10533e(67, this.f26141a.m10630e(((Character) obj).charValue()).f26340a);
            return;
        }
        if (obj instanceof Short) {
            this.f26143c.m10533e(83, this.f26141a.m10630e(((Short) obj).shortValue()).f26340a);
            return;
        }
        if (obj instanceof Type2) {
            this.f26143c.m10533e(99, this.f26141a.m10637l(((Type2) obj).m10651d()));
            return;
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f26143c.m10533e(91, bArr.length);
            int length = bArr.length;
            while (i < length) {
                this.f26143c.m10533e(66, this.f26141a.m10630e(bArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f26143c.m10533e(91, zArr.length);
            int length2 = zArr.length;
            while (i < length2) {
                this.f26143c.m10533e(90, this.f26141a.m10630e(zArr[i] ? 1 : 0).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f26143c.m10533e(91, sArr.length);
            int length3 = sArr.length;
            while (i < length3) {
                this.f26143c.m10533e(83, this.f26141a.m10630e(sArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f26143c.m10533e(91, cArr.length);
            int length4 = cArr.length;
            while (i < length4) {
                this.f26143c.m10533e(67, this.f26141a.m10630e(cArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f26143c.m10533e(91, iArr.length);
            int length5 = iArr.length;
            while (i < length5) {
                this.f26143c.m10533e(73, this.f26141a.m10630e(iArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f26143c.m10533e(91, jArr.length);
            int length6 = jArr.length;
            while (i < length6) {
                this.f26143c.m10533e(74, this.f26141a.m10632g(5, jArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f26143c.m10533e(91, fArr.length);
            int length7 = fArr.length;
            while (i < length7) {
                float f = fArr[i];
                ByteVector2 byteVector2 = this.f26143c;
                SymbolTable2 symbolTable2 = this.f26141a;
                Objects.requireNonNull(symbolTable2);
                byteVector2.m10533e(70, symbolTable2.m10631f(4, Float.floatToRawIntBits(f)).f26340a);
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            Symbol2 symbol2M10627b = this.f26141a.m10627b(obj);
            this.f26143c.m10533e(".s.IFJDCS".charAt(symbol2M10627b.f26341b), symbol2M10627b.f26340a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.f26143c.m10533e(91, dArr.length);
        int length8 = dArr.length;
        while (i < length8) {
            double d = dArr[i];
            ByteVector2 byteVector22 = this.f26143c;
            SymbolTable2 symbolTable22 = this.f26141a;
            Objects.requireNonNull(symbolTable22);
            byteVector22.m10533e(68, symbolTable22.m10632g(6, Double.doubleToRawLongBits(d)).f26340a);
            i++;
        }
    }

    /* JADX INFO: renamed from: f */
    public AnnotationWriter2 m10521f(String str) {
        this.f26145e++;
        if (this.f26142b) {
            this.f26143c.m10538j(this.f26141a.m10637l(str));
        }
        this.f26143c.m10533e(91, 0);
        return new AnnotationWriter2(this.f26141a, false, this.f26143c, null);
    }

    /* JADX INFO: renamed from: g */
    public void m10522g() {
        int i = this.f26144d;
        if (i != -1) {
            byte[] bArr = this.f26143c.f26153a;
            int i2 = this.f26145e;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }
}
