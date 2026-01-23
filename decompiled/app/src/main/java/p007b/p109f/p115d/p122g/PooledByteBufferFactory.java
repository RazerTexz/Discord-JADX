package p007b.p109f.p115d.p122g;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: b.f.d.g.g, reason: use source file name */
/* JADX INFO: compiled from: PooledByteBufferFactory.java */
/* JADX INFO: loaded from: classes.dex */
public interface PooledByteBufferFactory {
    /* JADX INFO: renamed from: a */
    PooledByteBufferOutputStream mo993a();

    /* JADX INFO: renamed from: b */
    PooledByteBuffer mo994b(byte[] bArr);

    /* JADX INFO: renamed from: c */
    PooledByteBuffer mo995c(InputStream inputStream) throws IOException;

    /* JADX INFO: renamed from: d */
    PooledByteBuffer mo996d(InputStream inputStream, int i) throws IOException;

    /* JADX INFO: renamed from: e */
    PooledByteBufferOutputStream mo997e(int i);
}
