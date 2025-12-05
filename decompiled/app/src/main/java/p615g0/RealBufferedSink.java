package p615g0;

import java.io.IOException;
import java.nio.ByteBuffer;
import okio.BufferedSink;
import okio.ByteString;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: RealBufferedSink.kt */
/* renamed from: g0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: j */
    public final Buffer3 f26111j;

    /* renamed from: k */
    public boolean f26112k;

    /* renamed from: l */
    public final Sink f26113l;

    public RealBufferedSink(Sink sink) {
        Intrinsics3.checkParameterIsNotNull(sink, "sink");
        this.f26113l = sink;
        this.f26111j = new Buffer3();
    }

    @Override // okio.BufferedSink
    /* renamed from: F */
    public BufferedSink mo10431F() throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        long jM10456f = this.f26111j.m10456f();
        if (jM10456f > 0) {
            this.f26113l.write(this.f26111j, jM10456f);
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: K */
    public BufferedSink mo10436K(String str) throws IOException {
        Intrinsics3.checkParameterIsNotNull(str, "string");
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10452b0(str);
        mo10431F();
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: P */
    public long mo10440P(Source2 source2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(source2, "source");
        long j = 0;
        while (true) {
            long jMo10176i0 = ((JvmOkio) source2).mo10176i0(this.f26111j, 8192);
            if (jMo10176i0 == -1) {
                return j;
            }
            j += jMo10176i0;
            mo10431F();
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: Q */
    public BufferedSink mo10441Q(long j) {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10446V(j);
        return mo10431F();
    }

    @Override // p615g0.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        if (this.f26112k) {
            return;
        }
        Throwable th = null;
        try {
            Buffer3 buffer3 = this.f26111j;
            long j = buffer3.f26080k;
            if (j > 0) {
                this.f26113l.write(buffer3, j);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f26113l.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f26112k = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: e0 */
    public BufferedSink mo10455e0(ByteString byteString) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteString, "byteString");
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10439O(byteString);
        mo10431F();
        return this;
    }

    @Override // okio.BufferedSink, p615g0.Sink, java.io.Flushable
    public void flush() throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        Buffer3 buffer3 = this.f26111j;
        long j = buffer3.f26080k;
        if (j > 0) {
            this.f26113l.write(buffer3, j);
        }
        this.f26113l.flush();
    }

    @Override // okio.BufferedSink
    /* renamed from: g */
    public Buffer3 mo10457g() {
        return this.f26111j;
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f26112k;
    }

    @Override // okio.BufferedSink
    /* renamed from: p */
    public BufferedSink mo10462p() throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        Buffer3 buffer3 = this.f26111j;
        long j = buffer3.f26080k;
        if (j > 0) {
            this.f26113l.write(buffer3, j);
        }
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: q0 */
    public BufferedSink mo10465q0(long j) throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10445U(j);
        mo10431F();
        return this;
    }

    @Override // p615g0.Sink
    public Timeout2 timeout() {
        return this.f26113l.timeout();
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("buffer(");
        sbM833U.append(this.f26113l);
        sbM833U.append(')');
        return sbM833U.toString();
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        Intrinsics3.checkParameterIsNotNull(byteBuffer, "source");
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        int iWrite = this.f26111j.write(byteBuffer);
        mo10431F();
        return iWrite;
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i) {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10444T(i);
        return mo10431F();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i) {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10447W(i);
        return mo10431F();
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i) throws IOException {
        if (!(!this.f26112k)) {
            throw new IllegalStateException("closed".toString());
        }
        this.f26111j.m10448X(i);
        mo10431F();
        return this;
    }

    @Override // p615g0.Sink
    public void write(Buffer3 buffer3, long j) throws IOException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "source");
        if (!this.f26112k) {
            this.f26111j.write(buffer3, j);
            mo10431F();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        if (!this.f26112k) {
            this.f26111j.m10442R(bArr);
            mo10431F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bArr, "source");
        if (!this.f26112k) {
            this.f26111j.m10443S(bArr, i, i2);
            mo10431F();
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }
}
