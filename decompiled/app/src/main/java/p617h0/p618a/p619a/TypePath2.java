package p617h0.p618a.p619a;

/* compiled from: TypePath.java */
/* renamed from: h0.a.a.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class TypePath2 {

    /* renamed from: a */
    public final byte[] f26374a;

    /* renamed from: b */
    public final int f26375b;

    public TypePath2(byte[] bArr, int i) {
        this.f26374a = bArr;
        this.f26375b = i;
    }

    /* renamed from: a */
    public static void m10655a(TypePath2 typePath2, ByteVector2 byteVector2) {
        if (typePath2 == null) {
            byteVector2.m10535g(0);
            return;
        }
        byte[] bArr = typePath2.f26374a;
        int i = typePath2.f26375b;
        byteVector2.m10536h(bArr, i, (bArr[i] * 2) + 1);
    }

    public String toString() {
        byte b2 = this.f26374a[this.f26375b];
        StringBuilder sb = new StringBuilder(b2 * 2);
        for (int i = 0; i < b2; i++) {
            byte[] bArr = this.f26374a;
            int i2 = this.f26375b;
            int i3 = i * 2;
            byte b3 = bArr[i3 + i2 + 1];
            if (b3 == 0) {
                sb.append('[');
            } else if (b3 == 1) {
                sb.append('.');
            } else if (b3 == 2) {
                sb.append('*');
            } else {
                if (b3 != 3) {
                    throw new AssertionError();
                }
                sb.append((int) bArr[i3 + i2 + 2]);
                sb.append(';');
            }
        }
        return sb.toString();
    }
}
