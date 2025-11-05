package b.f.d.g;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: PooledByteBufferFactory.java */
/* loaded from: classes.dex */
public interface g {
    i a();

    PooledByteBuffer b(byte[] bArr);

    PooledByteBuffer c(InputStream inputStream) throws IOException;

    PooledByteBuffer d(InputStream inputStream, int i) throws IOException;

    i e(int i);
}
