package p617h0.p618a.p619a;

import p007b.p100d.p104b.p105a.outline;

/* compiled from: Label.java */
/* renamed from: h0.a.a.p, reason: use source file name */
/* loaded from: classes3.dex */
public class Label2 {

    /* renamed from: a */
    public static final Label2 f26248a = new Label2();

    /* renamed from: b */
    public short f26249b;

    /* renamed from: c */
    public short f26250c;

    /* renamed from: d */
    public int[] f26251d;

    /* renamed from: e */
    public int f26252e;

    /* renamed from: f */
    public int[] f26253f;

    /* renamed from: g */
    public short f26254g;

    /* renamed from: h */
    public short f26255h;

    /* renamed from: i */
    public short f26256i;

    /* renamed from: j */
    public short f26257j;

    /* renamed from: k */
    public Frame3 f26258k;

    /* renamed from: l */
    public Label2 f26259l;

    /* renamed from: m */
    public Edge2 f26260m;

    /* renamed from: n */
    public Label2 f26261n;

    /* renamed from: a */
    public final void m10587a(int i, int i2, int i3) {
        if (this.f26253f == null) {
            this.f26253f = new int[6];
        }
        int[] iArr = this.f26253f;
        int i4 = iArr[0];
        if (i4 + 2 >= iArr.length) {
            int[] iArr2 = new int[iArr.length + 6];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f26253f = iArr2;
        }
        int[] iArr3 = this.f26253f;
        int i5 = i4 + 1;
        iArr3[i5] = i;
        int i6 = i5 + 1;
        iArr3[i6] = i2 | i3;
        iArr3[0] = i6;
    }

    /* renamed from: b */
    public final Label2 m10588b() {
        Frame3 frame3 = this.f26258k;
        return frame3 == null ? this : frame3.f26228a;
    }

    /* renamed from: c */
    public final void m10589c(short s2) {
        this.f26261n = f26248a;
        Label2 label2M10590d = this;
        while (label2M10590d != f26248a) {
            Label2 label2 = label2M10590d.f26261n;
            label2M10590d.f26261n = null;
            if (label2M10590d.f26257j == 0) {
                label2M10590d.f26257j = s2;
                label2M10590d = label2M10590d.m10590d(label2);
            } else {
                label2M10590d = label2;
            }
        }
    }

    /* renamed from: d */
    public final Label2 m10590d(Label2 label2) {
        Edge2 edge2 = this.f26260m;
        while (edge2 != null) {
            if (!((this.f26249b & 16) != 0 && edge2 == this.f26260m.f26215c)) {
                Label2 label22 = edge2.f26214b;
                if (label22.f26261n == null) {
                    label22.f26261n = label2;
                    label2 = label22;
                }
            }
            edge2 = edge2.f26215c;
        }
        return label2;
    }

    /* renamed from: e */
    public final void m10591e(ByteVector2 byteVector2, int i, boolean z2) {
        if ((this.f26249b & 4) != 0) {
            if (z2) {
                byteVector2.m10537i(this.f26252e - i);
                return;
            } else {
                byteVector2.m10538j(this.f26252e - i);
                return;
            }
        }
        if (z2) {
            m10587a(i, 536870912, byteVector2.f26154b);
            byteVector2.m10537i(-1);
        } else {
            m10587a(i, 268435456, byteVector2.f26154b);
            byteVector2.m10538j(-1);
        }
    }

    /* renamed from: f */
    public final boolean m10592f(byte[] bArr, int i) {
        this.f26249b = (short) (this.f26249b | 4);
        this.f26252e = i;
        int[] iArr = this.f26253f;
        boolean z2 = false;
        if (iArr == null) {
            return false;
        }
        for (int i2 = iArr[0]; i2 > 0; i2 -= 2) {
            int[] iArr2 = this.f26253f;
            int i3 = iArr2[i2 - 1];
            int i4 = iArr2[i2];
            int i5 = i - i3;
            int i6 = 268435455 & i4;
            if ((i4 & (-268435456)) == 268435456) {
                if (i5 < -32768 || i5 > 32767) {
                    int i7 = bArr[i3] & 255;
                    if (i7 < 198) {
                        bArr[i3] = (byte) (i7 + 49);
                    } else {
                        bArr[i3] = (byte) (i7 + 20);
                    }
                    z2 = true;
                }
                bArr[i6] = (byte) (i5 >>> 8);
                bArr[i6 + 1] = (byte) i5;
            } else {
                int i8 = i6 + 1;
                bArr[i6] = (byte) (i5 >>> 24);
                int i9 = i8 + 1;
                bArr[i8] = (byte) (i5 >>> 16);
                bArr[i9] = (byte) (i5 >>> 8);
                bArr[i9 + 1] = (byte) i5;
            }
        }
        return z2;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("L");
        sbM833U.append(System.identityHashCode(this));
        return sbM833U.toString();
    }
}
