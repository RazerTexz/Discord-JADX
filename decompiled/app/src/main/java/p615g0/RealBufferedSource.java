package p615g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.ByteString;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.CharJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.p616z.Buffer5;

/* compiled from: RealBufferedSource.kt */
/* renamed from: g0.r, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: j */
    public final Buffer3 f26114j;

    /* renamed from: k */
    public boolean f26115k;

    /* renamed from: l */
    public final Source2 f26116l;

    public RealBufferedSource(Source2 source2) {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        this.f26116l = source2;
        this.f26114j = new Buffer3();
    }

    @Override // p615g0.BufferedSource
    /* renamed from: B */
    public void mo10428B(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        try {
            if (!mo10458j(j)) {
                throw new EOFException();
            }
            this.f26114j.mo10428B(buffer3, j);
        } catch (EOFException e) {
            buffer3.mo10440P(this.f26114j);
            throw e;
        }
    }

    @Override // p615g0.BufferedSource
    /* renamed from: E */
    public long mo10430E(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jMax = 0;
        while (true) {
            long jM10468t = this.f26114j.m10468t(byteString, jMax);
            if (jM10468t != -1) {
                return jM10468t;
            }
            Buffer3 buffer3 = this.f26114j;
            long j = buffer3.f26080k;
            if (this.f26116l.mo10176i0(buffer3, 8192) == -1) {
                return -1L;
            }
            jMax = Math.max(jMax, j);
        }
    }

    @Override // p615g0.BufferedSource
    /* renamed from: G */
    public String mo10432G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("limit < 0: ", j).toString());
        }
        long j2 = j == RecyclerView.FOREVER_NS ? Long.MAX_VALUE : j + 1;
        byte b2 = (byte) 10;
        long jM10492a = m10492a(b2, 0L, j2);
        if (jM10492a != -1) {
            return Buffer5.m10513a(this.f26114j, jM10492a);
        }
        if (j2 < RecyclerView.FOREVER_NS && mo10458j(j2) && this.f26114j.m10464q(j2 - 1) == ((byte) 13) && mo10458j(1 + j2) && this.f26114j.m10464q(j2) == b2) {
            return Buffer5.m10513a(this.f26114j, j2);
        }
        Buffer3 buffer3 = new Buffer3();
        Buffer3 buffer32 = this.f26114j;
        buffer32.m10460n(buffer3, 0L, Math.min(32, buffer32.f26080k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f26114j.f26080k, j) + " content=" + buffer3.m10473x().mo10503k() + "…");
    }

    @Override // p615g0.BufferedSource
    /* renamed from: M */
    public String mo10437M(Charset charset) throws IOException {
        Intrinsics3.checkParameterIsNotNull(charset, "charset");
        this.f26114j.mo10440P(this.f26116l);
        return this.f26114j.mo10437M(charset);
    }

    @Override // p615g0.BufferedSource
    /* renamed from: Y */
    public String mo10449Y() {
        return mo10432G(RecyclerView.FOREVER_NS);
    }

    @Override // p615g0.BufferedSource
    /* renamed from: Z */
    public byte[] mo10450Z(long j) throws EOFException {
        if (mo10458j(j)) {
            return this.f26114j.mo10450Z(j);
        }
        throw new EOFException();
    }

    /* renamed from: a */
    public long m10492a(byte b2, long j, long j2) {
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j && j2 >= j)) {
            throw new IllegalArgumentException(("fromIndex=" + j + " toIndex=" + j2).toString());
        }
        while (j < j2) {
            long jM10466s = this.f26114j.m10466s(b2, j, j2);
            if (jM10466s != -1) {
                return jM10466s;
            }
            Buffer3 buffer3 = this.f26114j;
            long j3 = buffer3.f26080k;
            if (j3 >= j2 || this.f26116l.mo10176i0(buffer3, 8192) == -1) {
                return -1L;
            }
            j = Math.max(j, j3);
        }
        return -1L;
    }

    /* renamed from: b */
    public int m10493b() throws EOFException {
        mo10463p0(4L);
        int i = this.f26114j.readInt();
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f26115k) {
            return;
        }
        this.f26115k = true;
        this.f26116l.close();
        Buffer3 buffer3 = this.f26114j;
        buffer3.skip(buffer3.f26080k);
    }

    @Override // p615g0.BufferedSource, okio.BufferedSink
    /* renamed from: g */
    public Buffer3 mo10457g() {
        return this.f26114j;
    }

    @Override // p615g0.Source2
    /* renamed from: i0 */
    public long mo10176i0(Buffer3 buffer3, long j) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
        }
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        Buffer3 buffer32 = this.f26114j;
        if (buffer32.f26080k == 0 && this.f26116l.mo10176i0(buffer32, 8192) == -1) {
            return -1L;
        }
        return this.f26114j.mo10176i0(buffer3, Math.min(j, this.f26114j.f26080k));
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f26115k;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: j */
    public boolean mo10458j(long j) {
        Buffer3 buffer3;
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
        }
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            buffer3 = this.f26114j;
            if (buffer3.f26080k >= j) {
                return true;
            }
        } while (this.f26116l.mo10176i0(buffer3, 8192) != -1);
        return false;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: k0 */
    public long mo10459k0(Sink sink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        long j = 0;
        while (this.f26116l.mo10176i0(this.f26114j, 8192) != -1) {
            long jM10456f = this.f26114j.m10456f();
            if (jM10456f > 0) {
                j += jM10456f;
                sink.write(this.f26114j, jM10456f);
            }
        }
        Buffer3 buffer3 = this.f26114j;
        long j2 = buffer3.f26080k;
        if (j2 <= 0) {
            return j;
        }
        long j3 = j + j2;
        sink.write(buffer3, j2);
        return j3;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: o */
    public ByteString mo10461o(long j) throws EOFException {
        if (mo10458j(j)) {
            return this.f26114j.mo10461o(j);
        }
        throw new EOFException();
    }

    @Override // p615g0.BufferedSource
    /* renamed from: p0 */
    public void mo10463p0(long j) throws EOFException {
        if (!mo10458j(j)) {
            throw new EOFException();
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "sink");
        Buffer3 buffer3 = this.f26114j;
        if (buffer3.f26080k == 0 && this.f26116l.mo10176i0(buffer3, 8192) == -1) {
            return -1;
        }
        return this.f26114j.read(byteBuffer);
    }

    @Override // p615g0.BufferedSource
    public byte readByte() throws EOFException {
        mo10463p0(1L);
        return this.f26114j.readByte();
    }

    @Override // p615g0.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(bArr, "sink");
        try {
            mo10463p0(bArr.length);
            this.f26114j.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (true) {
                Buffer3 buffer3 = this.f26114j;
                long j = buffer3.f26080k;
                if (j <= 0) {
                    throw e;
                }
                int i2 = buffer3.read(bArr, i, (int) j);
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
        }
    }

    @Override // p615g0.BufferedSource
    public int readInt() throws EOFException {
        mo10463p0(4L);
        return this.f26114j.readInt();
    }

    @Override // p615g0.BufferedSource
    public long readLong() throws EOFException {
        mo10463p0(8L);
        return this.f26114j.readLong();
    }

    @Override // p615g0.BufferedSource
    public short readShort() throws EOFException {
        mo10463p0(2L);
        return this.f26114j.readShort();
    }

    @Override // p615g0.BufferedSource
    /* renamed from: s0 */
    public long mo10467s0() throws EOFException {
        byte bM10464q;
        mo10463p0(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!mo10458j(i2)) {
                break;
            }
            bM10464q = this.f26114j.m10464q(i);
            if ((bM10464q < ((byte) 48) || bM10464q > ((byte) 57)) && ((bM10464q < ((byte) 97) || bM10464q > ((byte) 102)) && (bM10464q < ((byte) 65) || bM10464q > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder sbM833U = outline.m833U("Expected leading [0-9a-fA-F] character but was 0x");
            String string = Integer.toString(bM10464q, CharJVM.checkRadix(CharJVM.checkRadix(16)));
            Intrinsics3.checkExpressionValueIsNotNull(string, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sbM833U.append(string);
            throw new NumberFormatException(sbM833U.toString());
        }
        return this.f26114j.mo10467s0();
    }

    @Override // p615g0.BufferedSource
    public void skip(long j) throws EOFException {
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j > 0) {
            Buffer3 buffer3 = this.f26114j;
            if (buffer3.f26080k == 0 && this.f26116l.mo10176i0(buffer3, 8192) == -1) {
                throw new EOFException();
            }
            long jMin = Math.min(j, this.f26114j.f26080k);
            this.f26114j.skip(jMin);
            j -= jMin;
        }
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return this.f26116l.timeout();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("buffer(");
        sbM833U.append(this.f26116l);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // p615g0.BufferedSource
    /* renamed from: u0 */
    public InputStream mo10470u0() {
        return new a();
    }

    @Override // p615g0.BufferedSource
    /* renamed from: v0 */
    public int mo10471v0(Options2 options2) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(options2, "options");
        if (!(!this.f26115k)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            int iM10514b = Buffer5.m10514b(this.f26114j, options2, true);
            if (iM10514b != -2) {
                if (iM10514b != -1) {
                    this.f26114j.skip(options2.f26107l[iM10514b].mo10502j());
                    return iM10514b;
                }
            } else if (this.f26116l.mo10176i0(this.f26114j, 8192) == -1) {
                break;
            }
        }
        return -1;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: w */
    public boolean mo10472w() {
        if (!this.f26115k) {
            return this.f26114j.mo10472w() && this.f26116l.mo10176i0(this.f26114j, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    /* compiled from: RealBufferedSource.kt */
    /* renamed from: g0.r$a */
    public static final class a extends InputStream {
        public a() {
        }

        @Override // java.io.InputStream
        public int available() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.f26115k) {
                throw new IOException("closed");
            }
            return (int) Math.min(realBufferedSource.f26114j.f26080k, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            RealBufferedSource.this.close();
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            RealBufferedSource realBufferedSource = RealBufferedSource.this;
            if (realBufferedSource.f26115k) {
                throw new IOException("closed");
            }
            Buffer3 buffer3 = realBufferedSource.f26114j;
            if (buffer3.f26080k == 0 && realBufferedSource.f26116l.mo10176i0(buffer3, 8192) == -1) {
                return -1;
            }
            return RealBufferedSource.this.f26114j.readByte() & 255;
        }

        public String toString() {
            return RealBufferedSource.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Intrinsics3.checkParameterIsNotNull(bArr, "data");
            if (!RealBufferedSource.this.f26115k) {
                C3404f.m4192B(bArr.length, i, i2);
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                Buffer3 buffer3 = realBufferedSource.f26114j;
                if (buffer3.f26080k == 0 && realBufferedSource.f26116l.mo10176i0(buffer3, 8192) == -1) {
                    return -1;
                }
                return RealBufferedSource.this.f26114j.read(bArr, i, i2);
            }
            throw new IOException("closed");
        }
    }
}
