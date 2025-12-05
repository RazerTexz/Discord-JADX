package p007b.p225i.p361c.p369m.p370d.p379p;

import java.io.ByteArrayInputStream;
import java.io.Flushable;
import java.io.IOException;
import java.io.OutputStream;
import org.objectweb.asm.Opcodes;

/* compiled from: CodedOutputStream.java */
/* renamed from: b.i.c.m.d.p.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class CodedOutputStream2 implements Flushable {

    /* renamed from: j */
    public final byte[] f12690j;

    /* renamed from: k */
    public final int f12691k;

    /* renamed from: l */
    public int f12692l = 0;

    /* renamed from: m */
    public final OutputStream f12693m;

    /* compiled from: CodedOutputStream.java */
    /* renamed from: b.i.c.m.d.p.c$a */
    public static class a extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        public a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public CodedOutputStream2(OutputStream outputStream, byte[] bArr) {
        this.f12693m = outputStream;
        this.f12690j = bArr;
        this.f12691k = bArr.length;
    }

    /* renamed from: a */
    public static int m6639a(int i, boolean z2) {
        return m6643e(i) + 1;
    }

    /* renamed from: b */
    public static int m6640b(int i, ByteString2 byteString2) {
        return m6643e(i) + m6642d(byteString2.f12684a.length) + byteString2.f12684a.length;
    }

    /* renamed from: c */
    public static int m6641c(int i, int i2) {
        return m6643e(i) + (i2 >= 0 ? m6642d(i2) : 10);
    }

    /* renamed from: d */
    public static int m6642d(int i) {
        if ((i & (-128)) == 0) {
            return 1;
        }
        if ((i & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i) == 0) {
            return 3;
        }
        return (i & (-268435456)) == 0 ? 4 : 5;
    }

    /* renamed from: e */
    public static int m6643e(int i) {
        return m6642d((i << 3) | 0);
    }

    /* renamed from: f */
    public static int m6644f(int i, int i2) {
        return m6643e(i) + m6642d(i2);
    }

    /* renamed from: h */
    public static int m6645h(int i, long j) {
        return m6643e(i) + (((-128) & j) == 0 ? 1 : ((-16384) & j) == 0 ? 2 : ((-2097152) & j) == 0 ? 3 : ((-268435456) & j) == 0 ? 4 : ((-34359738368L) & j) == 0 ? 5 : ((-4398046511104L) & j) == 0 ? 6 : ((-562949953421312L) & j) == 0 ? 7 : ((-72057594037927936L) & j) == 0 ? 8 : (j & Long.MIN_VALUE) == 0 ? 9 : 10);
    }

    /* renamed from: i */
    public static CodedOutputStream2 m6646i(OutputStream outputStream) {
        return new CodedOutputStream2(outputStream, new byte[4096]);
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f12693m != null) {
            m6647j();
        }
    }

    /* renamed from: j */
    public final void m6647j() throws IOException {
        OutputStream outputStream = this.f12693m;
        if (outputStream == null) {
            throw new a();
        }
        outputStream.write(this.f12690j, 0, this.f12692l);
        this.f12692l = 0;
    }

    /* renamed from: k */
    public void m6648k(int i, boolean z2) throws IOException {
        m6652o((i << 3) | 0);
        m6651n(z2 ? 1 : 0);
    }

    /* renamed from: l */
    public void m6649l(int i, ByteString2 byteString2) throws IOException {
        m6652o((i << 3) | 2);
        m6652o(byteString2.f12684a.length);
        byte[] bArr = byteString2.f12684a;
        int length = bArr.length;
        int i2 = this.f12691k;
        int i3 = this.f12692l;
        int i4 = i2 - i3;
        if (i4 >= length) {
            System.arraycopy(bArr, 0, this.f12690j, i3, length);
            this.f12692l += length;
            return;
        }
        System.arraycopy(bArr, 0, this.f12690j, i3, i4);
        int i5 = i4 + 0;
        int i6 = length - i4;
        this.f12692l = this.f12691k;
        m6647j();
        if (i6 <= this.f12691k) {
            System.arraycopy(byteString2.f12684a, i5, this.f12690j, 0, i6);
            this.f12692l = i6;
            return;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteString2.f12684a);
        long j = i5;
        if (j != byteArrayInputStream.skip(j)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i6 > 0) {
            int iMin = Math.min(i6, this.f12691k);
            int i7 = byteArrayInputStream.read(this.f12690j, 0, iMin);
            if (i7 != iMin) {
                throw new IllegalStateException("Read failed.");
            }
            this.f12693m.write(this.f12690j, 0, i7);
            i6 -= i7;
        }
    }

    /* renamed from: m */
    public void m6650m(int i, int i2) throws IOException {
        m6652o((i << 3) | 0);
        if (i2 >= 0) {
            m6652o(i2);
        } else {
            m6653q(i2);
        }
    }

    /* renamed from: n */
    public void m6651n(int i) throws IOException {
        byte b2 = (byte) i;
        if (this.f12692l == this.f12691k) {
            m6647j();
        }
        byte[] bArr = this.f12690j;
        int i2 = this.f12692l;
        this.f12692l = i2 + 1;
        bArr[i2] = b2;
    }

    /* renamed from: o */
    public void m6652o(int i) throws IOException {
        while ((i & (-128)) != 0) {
            m6651n((i & Opcodes.LAND) | 128);
            i >>>= 7;
        }
        m6651n(i);
    }

    /* renamed from: q */
    public void m6653q(long j) throws IOException {
        while (((-128) & j) != 0) {
            m6651n((((int) j) & Opcodes.LAND) | 128);
            j >>>= 7;
        }
        m6651n((int) j);
    }

    /* renamed from: r */
    public void m6654r(int i, int i2) throws IOException {
        m6652o((i << 3) | i2);
    }

    /* renamed from: s */
    public void m6655s(int i, int i2) throws IOException {
        m6652o((i << 3) | 0);
        m6652o(i2);
    }

    /* renamed from: t */
    public void m6656t(int i, long j) throws IOException {
        m6652o((i << 3) | 0);
        m6653q(j);
    }
}
