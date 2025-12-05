package p615g0;

import androidx.recyclerview.widget.RecyclerView;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Objects;
import okio.BufferedSink;
import okio.ByteString;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.Charsets2;
import p507d0.p580t._ArraysJvm;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.p616z.Buffer5;
import p615g0.p616z.ByteString4;

/* compiled from: Buffer.kt */
/* renamed from: g0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class Buffer3 implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: j */
    public Segment2 f26079j;

    /* renamed from: k */
    public long f26080k;

    /* compiled from: Buffer.kt */
    /* renamed from: g0.e$a */
    public static final class a implements Closeable {

        /* renamed from: j */
        public Buffer3 f26081j;

        /* renamed from: k */
        public boolean f26082k;

        /* renamed from: l */
        public Segment2 f26083l;

        /* renamed from: n */
        public byte[] f26085n;

        /* renamed from: m */
        public long f26084m = -1;

        /* renamed from: o */
        public int f26086o = -1;

        /* renamed from: p */
        public int f26087p = -1;

        /* renamed from: a */
        public final long m10475a(long j) {
            Buffer3 buffer3 = this.f26081j;
            if (buffer3 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (!this.f26082k) {
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            long j2 = buffer3.f26080k;
            int i = 1;
            if (j <= j2) {
                if (!(j >= 0)) {
                    throw new IllegalArgumentException(outline.m877t("newSize < 0: ", j).toString());
                }
                long j3 = j2 - j;
                while (true) {
                    if (j3 > 0) {
                        Segment2 segment2 = buffer3.f26079j;
                        if (segment2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        Segment2 segment22 = segment2.f26124g;
                        if (segment22 == null) {
                            Intrinsics3.throwNpe();
                        }
                        int i2 = segment22.f26120c;
                        long j4 = i2 - segment22.f26119b;
                        if (j4 > j3) {
                            segment22.f26120c = i2 - ((int) j3);
                            break;
                        }
                        buffer3.f26079j = segment22.m10494a();
                        SegmentPool.m10498a(segment22);
                        j3 -= j4;
                    } else {
                        break;
                    }
                }
                this.f26083l = null;
                this.f26084m = j;
                this.f26085n = null;
                this.f26086o = -1;
                this.f26087p = -1;
            } else if (j > j2) {
                long j5 = j - j2;
                boolean z2 = true;
                while (j5 > 0) {
                    Segment2 segment2M10438N = buffer3.m10438N(i);
                    int iMin = (int) Math.min(j5, 8192 - segment2M10438N.f26120c);
                    int i3 = segment2M10438N.f26120c + iMin;
                    segment2M10438N.f26120c = i3;
                    j5 -= iMin;
                    if (z2) {
                        this.f26083l = segment2M10438N;
                        this.f26084m = j2;
                        this.f26085n = segment2M10438N.f26118a;
                        this.f26086o = i3 - iMin;
                        this.f26087p = i3;
                        z2 = false;
                    }
                    i = 1;
                }
            }
            buffer3.f26080k = j;
            return j2;
        }

        /* renamed from: b */
        public final int m10476b(long j) {
            long j2;
            Segment2 segment2;
            Buffer3 buffer3 = this.f26081j;
            if (buffer3 == null) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            if (j >= -1) {
                long j3 = buffer3.f26080k;
                if (j <= j3) {
                    if (j == -1 || j == j3) {
                        this.f26083l = null;
                        this.f26084m = j;
                        this.f26085n = null;
                        this.f26086o = -1;
                        this.f26087p = -1;
                        return -1;
                    }
                    Segment2 segment22 = buffer3.f26079j;
                    Segment2 segment23 = this.f26083l;
                    if (segment23 != null) {
                        long j4 = this.f26084m;
                        int i = this.f26086o;
                        if (segment23 == null) {
                            Intrinsics3.throwNpe();
                        }
                        j2 = j4 - (i - segment23.f26119b);
                        if (j2 > j) {
                            segment2 = segment22;
                            segment22 = this.f26083l;
                            j3 = j2;
                            j2 = 0;
                        } else {
                            segment2 = this.f26083l;
                        }
                    } else {
                        j2 = 0;
                        segment2 = segment22;
                    }
                    if (j3 - j > j - j2) {
                        while (true) {
                            if (segment2 == null) {
                                Intrinsics3.throwNpe();
                            }
                            int i2 = segment2.f26120c;
                            int i3 = segment2.f26119b;
                            if (j < (i2 - i3) + j2) {
                                break;
                            }
                            j2 += i2 - i3;
                            segment2 = segment2.f26123f;
                        }
                    } else {
                        while (j3 > j) {
                            if (segment22 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment22 = segment22.f26124g;
                            if (segment22 == null) {
                                Intrinsics3.throwNpe();
                            }
                            j3 -= segment22.f26120c - segment22.f26119b;
                        }
                        segment2 = segment22;
                        j2 = j3;
                    }
                    if (this.f26082k) {
                        if (segment2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        if (segment2.f26121d) {
                            byte[] bArr = segment2.f26118a;
                            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                            Intrinsics3.checkExpressionValueIsNotNull(bArrCopyOf, "java.util.Arrays.copyOf(this, size)");
                            Segment2 segment24 = new Segment2(bArrCopyOf, segment2.f26119b, segment2.f26120c, false, true);
                            if (buffer3.f26079j == segment2) {
                                buffer3.f26079j = segment24;
                            }
                            segment2.m10495b(segment24);
                            Segment2 segment25 = segment24.f26124g;
                            if (segment25 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment25.m10494a();
                            segment2 = segment24;
                        }
                    }
                    this.f26083l = segment2;
                    this.f26084m = j;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.f26085n = segment2.f26118a;
                    int i4 = segment2.f26119b + ((int) (j - j2));
                    this.f26086o = i4;
                    int i5 = segment2.f26120c;
                    this.f26087p = i5;
                    return i5 - i4;
                }
            }
            String str = String.format("offset=%s > size=%s", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(buffer3.f26080k)}, 2));
            Intrinsics3.checkExpressionValueIsNotNull(str, "java.lang.String.format(format, *args)");
            throw new ArrayIndexOutOfBoundsException(str);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!(this.f26081j != null)) {
                throw new IllegalStateException("not attached to a buffer".toString());
            }
            this.f26081j = null;
            this.f26083l = null;
            this.f26084m = -1L;
            this.f26085n = null;
            this.f26086o = -1;
            this.f26087p = -1;
        }
    }

    /* renamed from: A */
    public String m10427A(long j, Charset charset) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(charset, "charset");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.m877t("byteCount: ", j).toString());
        }
        if (this.f26080k < j) {
            throw new EOFException();
        }
        if (j == 0) {
            return "";
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f26119b;
        if (i + j > segment2.f26120c) {
            return new String(mo10450Z(j), charset);
        }
        int i2 = (int) j;
        String str = new String(segment2.f26118a, i, i2, charset);
        int i3 = segment2.f26119b + i2;
        segment2.f26119b = i3;
        this.f26080k -= j;
        if (i3 == segment2.f26120c) {
            this.f26079j = segment2.m10494a();
            SegmentPool.m10498a(segment2);
        }
        return str;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: B */
    public void mo10428B(Buffer3 buffer3, long j) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        long j2 = this.f26080k;
        if (j2 >= j) {
            buffer3.write(this, j);
        } else {
            buffer3.write(this, j2);
            throw new EOFException();
        }
    }

    /* renamed from: D */
    public String m10429D() {
        return m10427A(this.f26080k, Charsets2.f25136a);
    }

    @Override // p615g0.BufferedSource
    /* renamed from: E */
    public long mo10430E(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        return m10468t(byteString, 0L);
    }

    @Override // okio.BufferedSink
    /* renamed from: F */
    public BufferedSink mo10431F() {
        return this;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: G */
    public String mo10432G(long j) throws EOFException {
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("limit < 0: ", j).toString());
        }
        long j2 = RecyclerView.FOREVER_NS;
        if (j != RecyclerView.FOREVER_NS) {
            j2 = j + 1;
        }
        byte b2 = (byte) 10;
        long jM10466s = m10466s(b2, 0L, j2);
        if (jM10466s != -1) {
            return Buffer5.m10513a(this, jM10466s);
        }
        if (j2 < this.f26080k && m10464q(j2 - 1) == ((byte) 13) && m10464q(j2) == b2) {
            return Buffer5.m10513a(this, j2);
        }
        Buffer3 buffer3 = new Buffer3();
        m10460n(buffer3, 0L, Math.min(32, this.f26080k));
        throw new EOFException("\\n not found: limit=" + Math.min(this.f26080k, j) + " content=" + buffer3.m10473x().mo10503k() + (char) 8230);
    }

    /* renamed from: H */
    public String m10433H(long j) throws EOFException {
        return m10427A(j, Charsets2.f25136a);
    }

    /* renamed from: I */
    public int m10434I() throws EOFException {
        int i;
        int i2;
        int i3;
        if (this.f26080k == 0) {
            throw new EOFException();
        }
        byte bM10464q = m10464q(0L);
        if ((bM10464q & 128) == 0) {
            i = bM10464q & 127;
            i2 = 1;
            i3 = 0;
        } else if ((bM10464q & 224) == 192) {
            i = bM10464q & 31;
            i2 = 2;
            i3 = 128;
        } else if ((bM10464q & 240) == 224) {
            i = bM10464q & 15;
            i2 = 3;
            i3 = 2048;
        } else {
            if ((bM10464q & 248) != 240) {
                skip(1L);
                return 65533;
            }
            i = bM10464q & 7;
            i2 = 4;
            i3 = 65536;
        }
        long j = i2;
        if (this.f26080k < j) {
            StringBuilder sbM834V = outline.m834V("size < ", i2, ": ");
            sbM834V.append(this.f26080k);
            sbM834V.append(" (to read code point prefixed 0x");
            sbM834V.append(C3404f.m4345t1(bM10464q));
            sbM834V.append(')');
            throw new EOFException(sbM834V.toString());
        }
        for (int i4 = 1; i4 < i2; i4++) {
            long j2 = i4;
            byte bM10464q2 = m10464q(j2);
            if ((bM10464q2 & 192) != 128) {
                skip(j2);
                return 65533;
            }
            i = (i << 6) | (bM10464q2 & 63);
        }
        skip(j);
        if (i > 1114111) {
            return 65533;
        }
        if ((55296 <= i && 57343 >= i) || i < i3) {
            return 65533;
        }
        return i;
    }

    /* renamed from: J */
    public final ByteString m10435J(int i) {
        if (i == 0) {
            return ByteString.f27592j;
        }
        C3404f.m4192B(this.f26080k, 0L, i);
        Segment2 segment2 = this.f26079j;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            int i5 = segment2.f26120c;
            int i6 = segment2.f26119b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            segment2 = segment2.f26123f;
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[i4 * 2];
        Segment2 segment22 = this.f26079j;
        int i7 = 0;
        while (i2 < i) {
            if (segment22 == null) {
                Intrinsics3.throwNpe();
            }
            bArr[i7] = segment22.f26118a;
            i2 += segment22.f26120c - segment22.f26119b;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment22.f26119b;
            segment22.f26121d = true;
            i7++;
            segment22 = segment22.f26123f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.BufferedSink
    /* renamed from: K */
    public /* bridge */ /* synthetic */ BufferedSink mo10436K(String str) {
        m10452b0(str);
        return this;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: M */
    public String mo10437M(Charset charset) {
        Intrinsics3.checkParameterIsNotNull(charset, "charset");
        return m10427A(this.f26080k, charset);
    }

    /* renamed from: N */
    public final Segment2 m10438N(int i) {
        if (!(i >= 1 && i <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Segment2 segment2M10499b = SegmentPool.m10499b();
            this.f26079j = segment2M10499b;
            segment2M10499b.f26124g = segment2M10499b;
            segment2M10499b.f26123f = segment2M10499b;
            return segment2M10499b;
        }
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        Segment2 segment22 = segment2.f26124g;
        if (segment22 == null) {
            Intrinsics3.throwNpe();
        }
        if (segment22.f26120c + i <= 8192 && segment22.f26122e) {
            return segment22;
        }
        Segment2 segment2M10499b2 = SegmentPool.m10499b();
        segment22.m10495b(segment2M10499b2);
        return segment2M10499b2;
    }

    /* renamed from: O */
    public Buffer3 m10439O(ByteString byteString) {
        Intrinsics3.checkParameterIsNotNull(byteString, "byteString");
        byteString.mo10510s(this, 0, byteString.mo10502j());
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: P */
    public long mo10440P(Source2 source2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        long j = 0;
        while (true) {
            long jMo10176i0 = source2.mo10176i0(this, 8192);
            if (jMo10176i0 == -1) {
                return j;
            }
            j += jMo10176i0;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: Q */
    public /* bridge */ /* synthetic */ BufferedSink mo10441Q(long j) {
        return m10446V(j);
    }

    /* renamed from: R */
    public Buffer3 m10442R(byte[] bArr) {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        m10443S(bArr, 0, bArr.length);
        return this;
    }

    /* renamed from: S */
    public Buffer3 m10443S(byte[] bArr, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        long j = i2;
        C3404f.m4192B(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment2 segment2M10438N = m10438N(1);
            int iMin = Math.min(i3 - i, 8192 - segment2M10438N.f26120c);
            int i4 = i + iMin;
            _ArraysJvm.copyInto(bArr, segment2M10438N.f26118a, segment2M10438N.f26120c, i, i4);
            segment2M10438N.f26120c += iMin;
            i = i4;
        }
        this.f26080k += j;
        return this;
    }

    /* renamed from: T */
    public Buffer3 m10444T(int i) {
        Segment2 segment2M10438N = m10438N(1);
        byte[] bArr = segment2M10438N.f26118a;
        int i2 = segment2M10438N.f26120c;
        segment2M10438N.f26120c = i2 + 1;
        bArr[i2] = (byte) i;
        this.f26080k++;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f5 A[LOOP:0: B:69:0x00f1->B:71:0x00f5, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0105  */
    /* renamed from: U */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Buffer3 m10445U(long j) {
        if (j == 0) {
            m10444T(48);
        } else {
            boolean z2 = false;
            int i = 1;
            if (j < 0) {
                j = -j;
                if (j < 0) {
                    m10452b0("-9223372036854775808");
                } else {
                    z2 = true;
                    if (j < 100000000) {
                        i = j < 1000000000000L ? j < 10000000000L ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
                    } else if (j >= 10000) {
                        i = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
                    } else if (j >= 100) {
                        i = j < 1000 ? 3 : 4;
                    } else if (j >= 10) {
                        i = 2;
                    }
                    if (z2) {
                        i++;
                    }
                    Segment2 segment2M10438N = m10438N(i);
                    byte[] bArr = segment2M10438N.f26118a;
                    int i2 = segment2M10438N.f26120c + i;
                    while (j != 0) {
                        long j2 = 10;
                        i2--;
                        bArr[i2] = Buffer5.f26137a[(int) (j % j2)];
                        j /= j2;
                    }
                    if (z2) {
                        bArr[i2 - 1] = (byte) 45;
                    }
                    segment2M10438N.f26120c += i;
                    this.f26080k += i;
                }
            } else {
                if (j < 100000000) {
                }
                if (z2) {
                }
                Segment2 segment2M10438N2 = m10438N(i);
                byte[] bArr2 = segment2M10438N2.f26118a;
                int i22 = segment2M10438N2.f26120c + i;
                while (j != 0) {
                }
                if (z2) {
                }
                segment2M10438N2.f26120c += i;
                this.f26080k += i;
            }
        }
        return this;
    }

    /* renamed from: V */
    public Buffer3 m10446V(long j) {
        if (j == 0) {
            m10444T(48);
        } else {
            long j2 = (j >>> 1) | j;
            long j3 = j2 | (j2 >>> 2);
            long j4 = j3 | (j3 >>> 4);
            long j5 = j4 | (j4 >>> 8);
            long j6 = j5 | (j5 >>> 16);
            long j7 = j6 | (j6 >>> 32);
            long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
            long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
            long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
            long j11 = j10 + (j10 >>> 8);
            long j12 = j11 + (j11 >>> 16);
            int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + 3) / 4);
            Segment2 segment2M10438N = m10438N(i);
            byte[] bArr = segment2M10438N.f26118a;
            int i2 = segment2M10438N.f26120c;
            for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
                bArr[i3] = Buffer5.f26137a[(int) (15 & j)];
                j >>>= 4;
            }
            segment2M10438N.f26120c += i;
            this.f26080k += i;
        }
        return this;
    }

    /* renamed from: W */
    public Buffer3 m10447W(int i) {
        Segment2 segment2M10438N = m10438N(4);
        byte[] bArr = segment2M10438N.f26118a;
        int i2 = segment2M10438N.f26120c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        segment2M10438N.f26120c = i5 + 1;
        this.f26080k += 4;
        return this;
    }

    /* renamed from: X */
    public Buffer3 m10448X(int i) {
        Segment2 segment2M10438N = m10438N(2);
        byte[] bArr = segment2M10438N.f26118a;
        int i2 = segment2M10438N.f26120c;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        segment2M10438N.f26120c = i3 + 1;
        this.f26080k += 2;
        return this;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: Y */
    public String mo10449Y() throws EOFException {
        return mo10432G(RecyclerView.FOREVER_NS);
    }

    @Override // p615g0.BufferedSource
    /* renamed from: Z */
    public byte[] mo10450Z(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.m877t("byteCount: ", j).toString());
        }
        if (this.f26080k < j) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j];
        readFully(bArr);
        return bArr;
    }

    /* renamed from: b */
    public Buffer3 m10451b() {
        Buffer3 buffer3 = new Buffer3();
        if (this.f26080k != 0) {
            Segment2 segment2 = this.f26079j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            Segment2 segment2M10496c = segment2.m10496c();
            buffer3.f26079j = segment2M10496c;
            segment2M10496c.f26124g = segment2M10496c;
            segment2M10496c.f26123f = segment2M10496c;
            for (Segment2 segment22 = segment2.f26123f; segment22 != segment2; segment22 = segment22.f26123f) {
                Segment2 segment23 = segment2M10496c.f26124g;
                if (segment23 == null) {
                    Intrinsics3.throwNpe();
                }
                if (segment22 == null) {
                    Intrinsics3.throwNpe();
                }
                segment23.m10495b(segment22.m10496c());
            }
            buffer3.f26080k = this.f26080k;
        }
        return buffer3;
    }

    /* renamed from: b0 */
    public Buffer3 m10452b0(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "string");
        m10453c0(str, 0, str.length());
        return this;
    }

    /* renamed from: c0 */
    public Buffer3 m10453c0(String str, int i, int i2) {
        char cCharAt;
        Intrinsics3.checkParameterIsNotNull(str, "string");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(outline.m871q("beginIndex < 0: ", i).toString());
        }
        if (!(i2 >= i)) {
            throw new IllegalArgumentException(outline.m875s("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        if (!(i2 <= str.length())) {
            StringBuilder sbM834V = outline.m834V("endIndex > string.length: ", i2, " > ");
            sbM834V.append(str.length());
            throw new IllegalArgumentException(sbM834V.toString().toString());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                Segment2 segment2M10438N = m10438N(1);
                byte[] bArr = segment2M10438N.f26118a;
                int i3 = segment2M10438N.f26120c - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = segment2M10438N.f26120c;
                int i6 = (i3 + i) - i5;
                segment2M10438N.f26120c = i5 + i6;
                this.f26080k += i6;
            } else {
                if (cCharAt2 < 2048) {
                    Segment2 segment2M10438N2 = m10438N(2);
                    byte[] bArr2 = segment2M10438N2.f26118a;
                    int i7 = segment2M10438N2.f26120c;
                    bArr2[i7] = (byte) ((cCharAt2 >> 6) | Opcodes.CHECKCAST);
                    bArr2[i7 + 1] = (byte) ((cCharAt2 & '?') | 128);
                    segment2M10438N2.f26120c = i7 + 2;
                    this.f26080k += 2;
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    Segment2 segment2M10438N3 = m10438N(3);
                    byte[] bArr3 = segment2M10438N3.f26118a;
                    int i8 = segment2M10438N3.f26120c;
                    bArr3[i8] = (byte) ((cCharAt2 >> '\f') | 224);
                    bArr3[i8 + 1] = (byte) ((63 & (cCharAt2 >> 6)) | 128);
                    bArr3[i8 + 2] = (byte) ((cCharAt2 & '?') | 128);
                    segment2M10438N3.f26120c = i8 + 3;
                    this.f26080k += 3;
                } else {
                    int i9 = i + 1;
                    char cCharAt3 = i9 < i2 ? str.charAt(i9) : (char) 0;
                    if (cCharAt2 > 56319 || 56320 > cCharAt3 || 57343 < cCharAt3) {
                        m10444T(63);
                        i = i9;
                    } else {
                        int i10 = (((cCharAt2 & 1023) << 10) | (cCharAt3 & 1023)) + 65536;
                        Segment2 segment2M10438N4 = m10438N(4);
                        byte[] bArr4 = segment2M10438N4.f26118a;
                        int i11 = segment2M10438N4.f26120c;
                        bArr4[i11] = (byte) ((i10 >> 18) | 240);
                        bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                        bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                        bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                        segment2M10438N4.f26120c = i11 + 4;
                        this.f26080k += 4;
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public /* bridge */ /* synthetic */ Object clone() {
        return m10451b();
    }

    @Override // p615g0.Source2, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    /* renamed from: d0 */
    public Buffer3 m10454d0(int i) {
        String str;
        if (i < 128) {
            m10444T(i);
        } else if (i < 2048) {
            Segment2 segment2M10438N = m10438N(2);
            byte[] bArr = segment2M10438N.f26118a;
            int i2 = segment2M10438N.f26120c;
            bArr[i2] = (byte) ((i >> 6) | Opcodes.CHECKCAST);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            segment2M10438N.f26120c = i2 + 2;
            this.f26080k += 2;
        } else if (55296 <= i && 57343 >= i) {
            m10444T(63);
        } else if (i < 65536) {
            Segment2 segment2M10438N2 = m10438N(3);
            byte[] bArr2 = segment2M10438N2.f26118a;
            int i3 = segment2M10438N2.f26120c;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            segment2M10438N2.f26120c = i3 + 3;
            this.f26080k += 3;
        } else {
            if (i > 1114111) {
                StringBuilder sbM833U = outline.m833U("Unexpected code point: 0x");
                if (i != 0) {
                    char[] cArr = ByteString4.f26138a;
                    int i4 = 0;
                    char[] cArr2 = {cArr[(i >> 28) & 15], cArr[(i >> 24) & 15], cArr[(i >> 20) & 15], cArr[(i >> 16) & 15], cArr[(i >> 12) & 15], cArr[(i >> 8) & 15], cArr[(i >> 4) & 15], cArr[i & 15]};
                    while (i4 < 8 && cArr2[i4] == '0') {
                        i4++;
                    }
                    str = new String(cArr2, i4, 8 - i4);
                } else {
                    str = "0";
                }
                sbM833U.append(str);
                throw new IllegalArgumentException(sbM833U.toString());
            }
            Segment2 segment2M10438N3 = m10438N(4);
            byte[] bArr3 = segment2M10438N3.f26118a;
            int i5 = segment2M10438N3.f26120c;
            bArr3[i5] = (byte) ((i >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i & 63) | 128);
            segment2M10438N3.f26120c = i5 + 4;
            this.f26080k += 4;
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: e0 */
    public /* bridge */ /* synthetic */ BufferedSink mo10455e0(ByteString byteString) {
        m10439O(byteString);
        return this;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer3)) {
                return false;
            }
            long j = this.f26080k;
            Buffer3 buffer3 = (Buffer3) obj;
            if (j != buffer3.f26080k) {
                return false;
            }
            if (j != 0) {
                Segment2 segment2 = this.f26079j;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                Segment2 segment22 = buffer3.f26079j;
                if (segment22 == null) {
                    Intrinsics3.throwNpe();
                }
                int i = segment2.f26119b;
                int i2 = segment22.f26119b;
                long j2 = 0;
                while (j2 < this.f26080k) {
                    long jMin = Math.min(segment2.f26120c - i, segment22.f26120c - i2);
                    long j3 = 0;
                    while (j3 < jMin) {
                        int i3 = i + 1;
                        int i4 = i2 + 1;
                        if (segment2.f26118a[i] != segment22.f26118a[i2]) {
                            return false;
                        }
                        j3++;
                        i = i3;
                        i2 = i4;
                    }
                    if (i == segment2.f26120c) {
                        segment2 = segment2.f26123f;
                        if (segment2 == null) {
                            Intrinsics3.throwNpe();
                        }
                        i = segment2.f26119b;
                    }
                    if (i2 == segment22.f26120c) {
                        segment22 = segment22.f26123f;
                        if (segment22 == null) {
                            Intrinsics3.throwNpe();
                        }
                        i2 = segment22.f26119b;
                    }
                    j2 += jMin;
                }
            }
        }
        return true;
    }

    /* renamed from: f */
    public final long m10456f() {
        long j = this.f26080k;
        if (j == 0) {
            return 0L;
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        Segment2 segment22 = segment2.f26124g;
        if (segment22 == null) {
            Intrinsics3.throwNpe();
        }
        if (segment22.f26120c < 8192 && segment22.f26122e) {
            j -= r3 - segment22.f26119b;
        }
        return j;
    }

    @Override // okio.BufferedSink, p615g0.Sink, java.io.Flushable
    public void flush() {
    }

    @Override // p615g0.BufferedSource, okio.BufferedSink
    /* renamed from: g */
    public Buffer3 mo10457g() {
        return this;
    }

    public int hashCode() {
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment2.f26120c;
            for (int i3 = segment2.f26119b; i3 < i2; i3++) {
                i = (i * 31) + segment2.f26118a[i3];
            }
            segment2 = segment2.f26123f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
        } while (segment2 != this.f26079j);
        return i;
    }

    @Override // p615g0.Source2
    /* renamed from: i0 */
    public long mo10176i0(Buffer3 buffer3, long j) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(outline.m877t("byteCount < 0: ", j).toString());
        }
        long j2 = this.f26080k;
        if (j2 == 0) {
            return -1L;
        }
        if (j > j2) {
            j = j2;
        }
        buffer3.write(this, j);
        return j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: j */
    public boolean mo10458j(long j) {
        return this.f26080k >= j;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: k0 */
    public long mo10459k0(Sink sink) throws IOException {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        long j = this.f26080k;
        if (j > 0) {
            sink.write(this, j);
        }
        return j;
    }

    /* renamed from: n */
    public final Buffer3 m10460n(Buffer3 buffer3, long j, long j2) {
        Intrinsics3.checkParameterIsNotNull(buffer3, "out");
        C3404f.m4192B(this.f26080k, j, j2);
        if (j2 != 0) {
            buffer3.f26080k += j2;
            Segment2 segment2 = this.f26079j;
            while (true) {
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                int i = segment2.f26120c;
                int i2 = segment2.f26119b;
                if (j < i - i2) {
                    break;
                }
                j -= i - i2;
                segment2 = segment2.f26123f;
            }
            while (j2 > 0) {
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                Segment2 segment2M10496c = segment2.m10496c();
                int i3 = segment2M10496c.f26119b + ((int) j);
                segment2M10496c.f26119b = i3;
                segment2M10496c.f26120c = Math.min(i3 + ((int) j2), segment2M10496c.f26120c);
                Segment2 segment22 = buffer3.f26079j;
                if (segment22 == null) {
                    segment2M10496c.f26124g = segment2M10496c;
                    segment2M10496c.f26123f = segment2M10496c;
                    buffer3.f26079j = segment2M10496c;
                } else {
                    if (segment22 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Segment2 segment23 = segment22.f26124g;
                    if (segment23 == null) {
                        Intrinsics3.throwNpe();
                    }
                    segment23.m10495b(segment2M10496c);
                }
                j2 -= segment2M10496c.f26120c - segment2M10496c.f26119b;
                segment2 = segment2.f26123f;
                j = 0;
            }
        }
        return this;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: o */
    public ByteString mo10461o(long j) throws EOFException {
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.m877t("byteCount: ", j).toString());
        }
        if (this.f26080k < j) {
            throw new EOFException();
        }
        if (j < 4096) {
            return new ByteString(mo10450Z(j));
        }
        ByteString byteStringM10435J = m10435J((int) j);
        skip(j);
        return byteStringM10435J;
    }

    @Override // okio.BufferedSink
    /* renamed from: p */
    public BufferedSink mo10462p() {
        return this;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: p0 */
    public void mo10463p0(long j) throws EOFException {
        if (this.f26080k < j) {
            throw new EOFException();
        }
    }

    /* renamed from: q */
    public final byte m10464q(long j) {
        C3404f.m4192B(this.f26080k, j, 1L);
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
            throw null;
        }
        long j2 = this.f26080k;
        if (j2 - j < j) {
            while (j2 > j) {
                segment2 = segment2.f26124g;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j2 -= segment2.f26120c - segment2.f26119b;
            }
            return segment2.f26118a[(int) ((segment2.f26119b + j) - j2)];
        }
        long j3 = 0;
        while (true) {
            int i = segment2.f26120c;
            int i2 = segment2.f26119b;
            long j4 = (i - i2) + j3;
            if (j4 > j) {
                return segment2.f26118a[(int) ((i2 + j) - j3)];
            }
            segment2 = segment2.f26123f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j3 = j4;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: q0 */
    public /* bridge */ /* synthetic */ BufferedSink mo10465q0(long j) {
        return m10445U(j);
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "sink");
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), segment2.f26120c - segment2.f26119b);
        byteBuffer.put(segment2.f26118a, segment2.f26119b, iMin);
        int i = segment2.f26119b + iMin;
        segment2.f26119b = i;
        this.f26080k -= iMin;
        if (i == segment2.f26120c) {
            this.f26079j = segment2.m10494a();
            SegmentPool.m10498a(segment2);
        }
        return iMin;
    }

    @Override // p615g0.BufferedSource
    public byte readByte() throws EOFException {
        if (this.f26080k == 0) {
            throw new EOFException();
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f26119b;
        int i2 = segment2.f26120c;
        int i3 = i + 1;
        byte b2 = segment2.f26118a[i];
        this.f26080k--;
        if (i3 == i2) {
            this.f26079j = segment2.m10494a();
            SegmentPool.m10498a(segment2);
        } else {
            segment2.f26119b = i3;
        }
        return b2;
    }

    @Override // p615g0.BufferedSource
    public void readFully(byte[] bArr) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int i2 = read(bArr, i, bArr.length - i);
            if (i2 == -1) {
                throw new EOFException();
            }
            i += i2;
        }
    }

    @Override // p615g0.BufferedSource
    public int readInt() throws EOFException {
        if (this.f26080k < 4) {
            throw new EOFException();
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f26119b;
        int i2 = segment2.f26120c;
        if (i2 - i < 4) {
            return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
        }
        byte[] bArr = segment2.f26118a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
        int i6 = i4 + 1;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        int i8 = i6 + 1;
        int i9 = i7 | (bArr[i6] & 255);
        this.f26080k -= 4;
        if (i8 == i2) {
            this.f26079j = segment2.m10494a();
            SegmentPool.m10498a(segment2);
        } else {
            segment2.f26119b = i8;
        }
        return i9;
    }

    @Override // p615g0.BufferedSource
    public long readLong() throws EOFException {
        if (this.f26080k < 8) {
            throw new EOFException();
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f26119b;
        int i2 = segment2.f26120c;
        if (i2 - i < 8) {
            return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
        }
        byte[] bArr = segment2.f26118a;
        long j = (bArr[i] & 255) << 56;
        long j2 = j | ((bArr[r6] & 255) << 48);
        long j3 = j2 | ((bArr[r1] & 255) << 40);
        int i3 = i + 1 + 1 + 1 + 1;
        long j4 = ((bArr[r6] & 255) << 32) | j3;
        long j5 = j4 | ((bArr[i3] & 255) << 24);
        long j6 = j5 | ((bArr[r8] & 255) << 16);
        long j7 = j6 | ((bArr[r1] & 255) << 8);
        int i4 = i3 + 1 + 1 + 1 + 1;
        long j8 = j7 | (bArr[r8] & 255);
        this.f26080k -= 8;
        if (i4 == i2) {
            this.f26079j = segment2.m10494a();
            SegmentPool.m10498a(segment2);
        } else {
            segment2.f26119b = i4;
        }
        return j8;
    }

    @Override // p615g0.BufferedSource
    public short readShort() throws EOFException {
        if (this.f26080k < 2) {
            throw new EOFException();
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            Intrinsics3.throwNpe();
        }
        int i = segment2.f26119b;
        int i2 = segment2.f26120c;
        if (i2 - i < 2) {
            return (short) (((readByte() & 255) << 8) | (readByte() & 255));
        }
        byte[] bArr = segment2.f26118a;
        int i3 = i + 1;
        int i4 = i3 + 1;
        int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
        this.f26080k -= 2;
        if (i4 == i2) {
            this.f26079j = segment2.m10494a();
            SegmentPool.m10498a(segment2);
        } else {
            segment2.f26119b = i4;
        }
        return (short) i5;
    }

    /* renamed from: s */
    public long m10466s(byte b2, long j, long j2) {
        Segment2 segment2;
        long j3 = 0;
        if (!(0 <= j && j2 >= j)) {
            StringBuilder sbM833U = outline.m833U("size=");
            sbM833U.append(this.f26080k);
            sbM833U.append(" fromIndex=");
            sbM833U.append(j);
            sbM833U.append(" toIndex=");
            sbM833U.append(j2);
            throw new IllegalArgumentException(sbM833U.toString().toString());
        }
        long j4 = this.f26080k;
        if (j2 > j4) {
            j2 = j4;
        }
        if (j != j2 && (segment2 = this.f26079j) != null) {
            if (j4 - j < j) {
                while (j4 > j) {
                    segment2 = segment2.f26124g;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j4 -= segment2.f26120c - segment2.f26119b;
                }
                while (j4 < j2) {
                    byte[] bArr = segment2.f26118a;
                    int iMin = (int) Math.min(segment2.f26120c, (segment2.f26119b + j2) - j4);
                    for (int i = (int) ((segment2.f26119b + j) - j4); i < iMin; i++) {
                        if (bArr[i] == b2) {
                            return (i - segment2.f26119b) + j4;
                        }
                    }
                    j4 += segment2.f26120c - segment2.f26119b;
                    segment2 = segment2.f26123f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j = j4;
                }
            } else {
                while (true) {
                    long j5 = (segment2.f26120c - segment2.f26119b) + j3;
                    if (j5 > j) {
                        break;
                    }
                    segment2 = segment2.f26123f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j3 = j5;
                }
                while (j3 < j2) {
                    byte[] bArr2 = segment2.f26118a;
                    int iMin2 = (int) Math.min(segment2.f26120c, (segment2.f26119b + j2) - j3);
                    for (int i2 = (int) ((segment2.f26119b + j) - j3); i2 < iMin2; i2++) {
                        if (bArr2[i2] == b2) {
                            return (i2 - segment2.f26119b) + j3;
                        }
                    }
                    j3 += segment2.f26120c - segment2.f26119b;
                    segment2 = segment2.f26123f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j = j3;
                }
            }
        }
        return -1L;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a3 A[EDGE_INSN: B:46:0x00a3->B:40:0x00a3 BREAK  A[LOOP:0: B:5:0x000b->B:48:?], SYNTHETIC] */
    @Override // p615g0.BufferedSource
    /* renamed from: s0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long mo10467s0() throws EOFException {
        int i;
        if (this.f26080k == 0) {
            throw new EOFException();
        }
        int i2 = 0;
        boolean z2 = false;
        long j = 0;
        do {
            Segment2 segment2 = this.f26079j;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            byte[] bArr = segment2.f26118a;
            int i3 = segment2.f26119b;
            int i4 = segment2.f26120c;
            while (i3 < i4) {
                byte b2 = bArr[i3];
                byte b3 = (byte) 48;
                if (b2 < b3 || b2 > ((byte) 57)) {
                    byte b4 = (byte) 97;
                    if ((b2 >= b4 && b2 <= ((byte) 102)) || (b2 >= (b4 = (byte) 65) && b2 <= ((byte) 70))) {
                        i = (b2 - b4) + 10;
                    } else {
                        if (i2 == 0) {
                            StringBuilder sbM833U = outline.m833U("Expected leading [0-9a-fA-F] character but was 0x");
                            sbM833U.append(C3404f.m4345t1(b2));
                            throw new NumberFormatException(sbM833U.toString());
                        }
                        z2 = true;
                        if (i3 != i4) {
                            this.f26079j = segment2.m10494a();
                            SegmentPool.m10498a(segment2);
                        } else {
                            segment2.f26119b = i3;
                        }
                        if (!z2) {
                            break;
                        }
                    }
                } else {
                    i = b2 - b3;
                }
                if (((-1152921504606846976L) & j) != 0) {
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.m10446V(j);
                    buffer3.m10444T(b2);
                    StringBuilder sbM833U2 = outline.m833U("Number too large: ");
                    sbM833U2.append(buffer3.m10429D());
                    throw new NumberFormatException(sbM833U2.toString());
                }
                j = (j << 4) | i;
                i3++;
                i2++;
            }
            if (i3 != i4) {
            }
            if (!z2) {
            }
        } while (this.f26079j != null);
        this.f26080k -= i2;
        return j;
    }

    @Override // p615g0.BufferedSource
    public void skip(long j) throws EOFException {
        while (j > 0) {
            Segment2 segment2 = this.f26079j;
            if (segment2 == null) {
                throw new EOFException();
            }
            int iMin = (int) Math.min(j, segment2.f26120c - segment2.f26119b);
            long j2 = iMin;
            this.f26080k -= j2;
            j -= j2;
            int i = segment2.f26119b + iMin;
            segment2.f26119b = i;
            if (i == segment2.f26120c) {
                this.f26079j = segment2.m10494a();
                SegmentPool.m10498a(segment2);
            }
        }
    }

    /* renamed from: t */
    public long m10468t(ByteString byteString, long j) {
        int i;
        int i2;
        int i3;
        int i4;
        long j2 = j;
        Intrinsics3.checkParameterIsNotNull(byteString, "targetBytes");
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(outline.m877t("fromIndex < 0: ", j2).toString());
        }
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            return -1L;
        }
        long j4 = this.f26080k;
        if (j4 - j2 < j2) {
            while (j4 > j2) {
                segment2 = segment2.f26124g;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j4 -= segment2.f26120c - segment2.f26119b;
            }
            if (byteString.mo10502j() == 2) {
                byte bMo10505m = byteString.mo10505m(0);
                byte bMo10505m2 = byteString.mo10505m(1);
                while (j4 < this.f26080k) {
                    byte[] bArr = segment2.f26118a;
                    i3 = (int) ((segment2.f26119b + j2) - j4);
                    int i5 = segment2.f26120c;
                    while (i3 < i5) {
                        byte b2 = bArr[i3];
                        if (b2 == bMo10505m || b2 == bMo10505m2) {
                            i4 = segment2.f26119b;
                        } else {
                            i3++;
                        }
                    }
                    j4 += segment2.f26120c - segment2.f26119b;
                    segment2 = segment2.f26123f;
                    if (segment2 == null) {
                        Intrinsics3.throwNpe();
                    }
                    j2 = j4;
                }
                return -1L;
            }
            byte[] bArrMo10504l = byteString.mo10504l();
            while (j4 < this.f26080k) {
                byte[] bArr2 = segment2.f26118a;
                i3 = (int) ((segment2.f26119b + j2) - j4);
                int i6 = segment2.f26120c;
                while (i3 < i6) {
                    byte b3 = bArr2[i3];
                    for (byte b4 : bArrMo10504l) {
                        if (b3 == b4) {
                            i4 = segment2.f26119b;
                        }
                    }
                    i3++;
                }
                j4 += segment2.f26120c - segment2.f26119b;
                segment2 = segment2.f26123f;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j2 = j4;
            }
            return -1L;
            return (i3 - i4) + j4;
        }
        while (true) {
            long j5 = (segment2.f26120c - segment2.f26119b) + j3;
            if (j5 > j2) {
                break;
            }
            segment2 = segment2.f26123f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j3 = j5;
        }
        if (byteString.mo10502j() == 2) {
            byte bMo10505m3 = byteString.mo10505m(0);
            byte bMo10505m4 = byteString.mo10505m(1);
            while (j3 < this.f26080k) {
                byte[] bArr3 = segment2.f26118a;
                i = (int) ((segment2.f26119b + j2) - j3);
                int i7 = segment2.f26120c;
                while (i < i7) {
                    byte b5 = bArr3[i];
                    if (b5 == bMo10505m3 || b5 == bMo10505m4) {
                        i2 = segment2.f26119b;
                    } else {
                        i++;
                    }
                }
                j3 += segment2.f26120c - segment2.f26119b;
                segment2 = segment2.f26123f;
                if (segment2 == null) {
                    Intrinsics3.throwNpe();
                }
                j2 = j3;
            }
            return -1L;
        }
        byte[] bArrMo10504l2 = byteString.mo10504l();
        while (j3 < this.f26080k) {
            byte[] bArr4 = segment2.f26118a;
            i = (int) ((segment2.f26119b + j2) - j3);
            int i8 = segment2.f26120c;
            while (i < i8) {
                byte b6 = bArr4[i];
                for (byte b7 : bArrMo10504l2) {
                    if (b6 == b7) {
                        i2 = segment2.f26119b;
                    }
                }
                i++;
            }
            j3 += segment2.f26120c - segment2.f26119b;
            segment2 = segment2.f26123f;
            if (segment2 == null) {
                Intrinsics3.throwNpe();
            }
            j2 = j3;
        }
        return -1L;
        return (i - i2) + j3;
    }

    @Override // p615g0.Source2
    public Timeout2 timeout() {
        return Timeout2.f26133a;
    }

    public String toString() {
        long j = this.f26080k;
        if (j <= ((long) Integer.MAX_VALUE)) {
            return m10435J((int) j).toString();
        }
        StringBuilder sbM833U = outline.m833U("size > Int.MAX_VALUE: ");
        sbM833U.append(this.f26080k);
        throw new IllegalStateException(sbM833U.toString().toString());
    }

    /* renamed from: u */
    public final a m10469u(a aVar) {
        Intrinsics3.checkParameterIsNotNull(aVar, "unsafeCursor");
        if (!(aVar.f26081j == null)) {
            throw new IllegalStateException("already attached to a buffer".toString());
        }
        aVar.f26081j = this;
        aVar.f26082k = true;
        return aVar;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: u0 */
    public InputStream mo10470u0() {
        return new b();
    }

    @Override // p615g0.BufferedSource
    /* renamed from: v0 */
    public int mo10471v0(Options2 options2) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(options2, "options");
        int iM10514b = Buffer5.m10514b(this, options2, false);
        if (iM10514b == -1) {
            return -1;
        }
        skip(options2.f26107l[iM10514b].mo10502j());
        return iM10514b;
    }

    @Override // p615g0.BufferedSource
    /* renamed from: w */
    public boolean mo10472w() {
        return this.f26080k == 0;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr) {
        m10442R(bArr);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeByte(int i) {
        m10444T(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeInt(int i) {
        m10447W(i);
        return this;
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink writeShort(int i) {
        m10448X(i);
        return this;
    }

    /* renamed from: x */
    public ByteString m10473x() {
        return mo10461o(this.f26080k);
    }

    /* renamed from: y */
    public short m10474y() throws EOFException {
        int i = readShort() & 65535;
        return (short) (((i & 255) << 8) | ((65280 & i) >>> 8));
    }

    @Override // okio.BufferedSink
    public /* bridge */ /* synthetic */ BufferedSink write(byte[] bArr, int i, int i2) {
        m10443S(bArr, i, i2);
        return this;
    }

    /* compiled from: Buffer.kt */
    /* renamed from: g0.e$b */
    public static final class b extends InputStream {
        public b() {
        }

        @Override // java.io.InputStream
        public int available() {
            return (int) Math.min(Buffer3.this.f26080k, Integer.MAX_VALUE);
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.InputStream
        public int read() {
            Buffer3 buffer3 = Buffer3.this;
            if (buffer3.f26080k > 0) {
                return buffer3.readByte() & 255;
            }
            return -1;
        }

        public String toString() {
            return Buffer3.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            Intrinsics3.checkParameterIsNotNull(bArr, "sink");
            return Buffer3.this.read(bArr, i, i2);
        }
    }

    @Override // p615g0.Sink
    public void write(Buffer3 buffer3, long j) {
        int i;
        Segment2 segment2;
        Segment2 segment2M10499b;
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        if (buffer3 != this) {
            C3404f.m4192B(buffer3.f26080k, 0L, j);
            long j2 = j;
            while (j2 > 0) {
                Segment2 segment22 = buffer3.f26079j;
                if (segment22 == null) {
                    Intrinsics3.throwNpe();
                }
                int i2 = segment22.f26120c;
                if (buffer3.f26079j == null) {
                    Intrinsics3.throwNpe();
                }
                if (j2 < i2 - r7.f26119b) {
                    Segment2 segment23 = this.f26079j;
                    if (segment23 != null) {
                        if (segment23 == null) {
                            Intrinsics3.throwNpe();
                        }
                        segment2 = segment23.f26124g;
                    } else {
                        segment2 = null;
                    }
                    if (segment2 != null && segment2.f26122e) {
                        if ((segment2.f26120c + j2) - (segment2.f26121d ? 0 : segment2.f26119b) <= 8192) {
                            Segment2 segment24 = buffer3.f26079j;
                            if (segment24 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment24.m10497d(segment2, (int) j2);
                            buffer3.f26080k -= j2;
                            this.f26080k += j2;
                            return;
                        }
                    }
                    Segment2 segment25 = buffer3.f26079j;
                    if (segment25 == null) {
                        Intrinsics3.throwNpe();
                    }
                    int i3 = (int) j2;
                    Objects.requireNonNull(segment25);
                    if (i3 > 0 && i3 <= segment25.f26120c - segment25.f26119b) {
                        if (i3 >= 1024) {
                            segment2M10499b = segment25.m10496c();
                        } else {
                            segment2M10499b = SegmentPool.m10499b();
                            byte[] bArr = segment25.f26118a;
                            byte[] bArr2 = segment2M10499b.f26118a;
                            int i4 = segment25.f26119b;
                            _ArraysJvm.copyInto$default(bArr, bArr2, 0, i4, i4 + i3, 2, (Object) null);
                        }
                        segment2M10499b.f26120c = segment2M10499b.f26119b + i3;
                        segment25.f26119b += i3;
                        Segment2 segment26 = segment25.f26124g;
                        if (segment26 == null) {
                            Intrinsics3.throwNpe();
                        }
                        segment26.m10495b(segment2M10499b);
                        buffer3.f26079j = segment2M10499b;
                    } else {
                        throw new IllegalArgumentException("byteCount out of range".toString());
                    }
                }
                Segment2 segment27 = buffer3.f26079j;
                if (segment27 == null) {
                    Intrinsics3.throwNpe();
                }
                long j3 = segment27.f26120c - segment27.f26119b;
                buffer3.f26079j = segment27.m10494a();
                Segment2 segment28 = this.f26079j;
                if (segment28 == null) {
                    this.f26079j = segment27;
                    segment27.f26124g = segment27;
                    segment27.f26123f = segment27;
                } else {
                    if (segment28 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Segment2 segment29 = segment28.f26124g;
                    if (segment29 == null) {
                        Intrinsics3.throwNpe();
                    }
                    segment29.m10495b(segment27);
                    Segment2 segment210 = segment27.f26124g;
                    if (!(segment210 != segment27)) {
                        throw new IllegalStateException("cannot compact".toString());
                    }
                    if (segment210 == null) {
                        Intrinsics3.throwNpe();
                    }
                    if (segment210.f26122e) {
                        int i5 = segment27.f26120c - segment27.f26119b;
                        Segment2 segment211 = segment27.f26124g;
                        if (segment211 == null) {
                            Intrinsics3.throwNpe();
                        }
                        int i6 = 8192 - segment211.f26120c;
                        Segment2 segment212 = segment27.f26124g;
                        if (segment212 == null) {
                            Intrinsics3.throwNpe();
                        }
                        if (segment212.f26121d) {
                            i = 0;
                        } else {
                            Segment2 segment213 = segment27.f26124g;
                            if (segment213 == null) {
                                Intrinsics3.throwNpe();
                            }
                            i = segment213.f26119b;
                        }
                        if (i5 <= i6 + i) {
                            Segment2 segment214 = segment27.f26124g;
                            if (segment214 == null) {
                                Intrinsics3.throwNpe();
                            }
                            segment27.m10497d(segment214, i5);
                            segment27.m10494a();
                            SegmentPool.m10498a(segment27);
                        }
                    }
                }
                buffer3.f26080k -= j3;
                this.f26080k += j3;
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public int read(byte[] bArr, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(bArr, "sink");
        C3404f.m4192B(bArr.length, i, i2);
        Segment2 segment2 = this.f26079j;
        if (segment2 == null) {
            return -1;
        }
        int iMin = Math.min(i2, segment2.f26120c - segment2.f26119b);
        byte[] bArr2 = segment2.f26118a;
        int i3 = segment2.f26119b;
        _ArraysJvm.copyInto(bArr2, bArr, i, i3, i3 + iMin);
        int i4 = segment2.f26119b + iMin;
        segment2.f26119b = i4;
        this.f26080k -= iMin;
        if (i4 != segment2.f26120c) {
            return iMin;
        }
        this.f26079j = segment2.m10494a();
        SegmentPool.m10498a(segment2);
        return iMin;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "source");
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            Segment2 segment2M10438N = m10438N(1);
            int iMin = Math.min(i, 8192 - segment2M10438N.f26120c);
            byteBuffer.get(segment2M10438N.f26118a, segment2M10438N.f26120c, iMin);
            i -= iMin;
            segment2M10438N.f26120c += iMin;
        }
        this.f26080k += iRemaining;
        return iRemaining;
    }
}
