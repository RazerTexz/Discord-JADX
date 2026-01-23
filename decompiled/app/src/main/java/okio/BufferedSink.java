package okio;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import p615g0.Buffer3;
import p615g0.Sink;
import p615g0.Source2;

/* JADX INFO: compiled from: BufferedSink.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    /* JADX INFO: renamed from: F */
    BufferedSink mo10431F() throws IOException;

    /* JADX INFO: renamed from: K */
    BufferedSink mo10436K(String string) throws IOException;

    /* JADX INFO: renamed from: P */
    long mo10440P(Source2 source) throws IOException;

    /* JADX INFO: renamed from: Q */
    BufferedSink mo10441Q(long v) throws IOException;

    /* JADX INFO: renamed from: e0 */
    BufferedSink mo10455e0(ByteString byteString) throws IOException;

    @Override // p615g0.Sink, java.io.Flushable
    void flush() throws IOException;

    /* JADX INFO: renamed from: g */
    Buffer3 mo10457g();

    /* JADX INFO: renamed from: p */
    BufferedSink mo10462p() throws IOException;

    /* JADX INFO: renamed from: q0 */
    BufferedSink mo10465q0(long v) throws IOException;

    BufferedSink write(byte[] source) throws IOException;

    BufferedSink write(byte[] source, int offset, int byteCount) throws IOException;

    BufferedSink writeByte(int b2) throws IOException;

    BufferedSink writeInt(int i) throws IOException;

    BufferedSink writeShort(int s2) throws IOException;
}
