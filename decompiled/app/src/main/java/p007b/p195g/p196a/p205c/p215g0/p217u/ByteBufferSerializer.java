package p007b.p195g.p196a.p205c.p215g0.p217u;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p195g.p196a.p198b.Base64Variants;
import p007b.p195g.p196a.p198b.JsonGenerator;
import p007b.p195g.p196a.p205c.SerializerProvider;
import p007b.p195g.p196a.p205c.p219i0.ByteBufferBackedInputStream;

/* JADX INFO: renamed from: b.g.a.c.g0.u.g, reason: use source file name */
/* JADX INFO: compiled from: ByteBufferSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class ByteBufferSerializer extends StdScalarSerializer<ByteBuffer> {
    public ByteBufferSerializer() {
        super(ByteBuffer.class);
    }

    @Override // p007b.p195g.p196a.p205c.JsonSerializer
    /* JADX INFO: renamed from: f */
    public void mo1807f(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        ByteBuffer byteBuffer = (ByteBuffer) obj;
        if (byteBuffer.hasArray()) {
            int iPosition = byteBuffer.position();
            byte[] bArrArray = byteBuffer.array();
            int iArrayOffset = byteBuffer.arrayOffset() + iPosition;
            int iLimit = byteBuffer.limit() - iPosition;
            Objects.requireNonNull(jsonGenerator);
            jsonGenerator.mo1660n(Base64Variants.f4452b, bArrArray, iArrayOffset, iLimit);
            return;
        }
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        if (byteBufferAsReadOnlyBuffer.position() > 0) {
            byteBufferAsReadOnlyBuffer.rewind();
        }
        ByteBufferBackedInputStream byteBufferBackedInputStream = new ByteBufferBackedInputStream(byteBufferAsReadOnlyBuffer);
        int iRemaining = byteBufferAsReadOnlyBuffer.remaining();
        Objects.requireNonNull(jsonGenerator);
        jsonGenerator.mo1655f(Base64Variants.f4452b, byteBufferBackedInputStream, iRemaining);
        byteBufferBackedInputStream.close();
    }
}
