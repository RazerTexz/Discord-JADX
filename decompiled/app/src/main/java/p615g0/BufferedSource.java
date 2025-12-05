package p615g0;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import okio.ByteString;

/* compiled from: BufferedSource.kt */
/* renamed from: g0.g, reason: use source file name */
/* loaded from: classes3.dex */
public interface BufferedSource extends Source2, ReadableByteChannel {
    /* renamed from: B */
    void mo10428B(Buffer3 buffer3, long j) throws IOException;

    /* renamed from: E */
    long mo10430E(ByteString byteString) throws IOException;

    /* renamed from: G */
    String mo10432G(long j) throws IOException;

    /* renamed from: M */
    String mo10437M(Charset charset) throws IOException;

    /* renamed from: Y */
    String mo10449Y() throws IOException;

    /* renamed from: Z */
    byte[] mo10450Z(long j) throws IOException;

    /* renamed from: g */
    Buffer3 mo10457g();

    /* renamed from: j */
    boolean mo10458j(long j) throws IOException;

    /* renamed from: k0 */
    long mo10459k0(Sink sink) throws IOException;

    /* renamed from: o */
    ByteString mo10461o(long j) throws IOException;

    /* renamed from: p0 */
    void mo10463p0(long j) throws IOException;

    byte readByte() throws IOException;

    void readFully(byte[] bArr) throws IOException;

    int readInt() throws IOException;

    long readLong() throws IOException;

    short readShort() throws IOException;

    /* renamed from: s0 */
    long mo10467s0() throws IOException;

    void skip(long j) throws IOException;

    /* renamed from: u0 */
    InputStream mo10470u0();

    /* renamed from: v0 */
    int mo10471v0(Options2 options2) throws IOException;

    /* renamed from: w */
    boolean mo10472w() throws IOException;
}
