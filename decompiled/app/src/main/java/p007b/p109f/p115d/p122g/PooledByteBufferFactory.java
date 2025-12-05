package p007b.p109f.p115d.p122g;

import com.facebook.common.memory.PooledByteBuffer;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: PooledByteBufferFactory.java */
/* renamed from: b.f.d.g.g, reason: use source file name */
/* loaded from: classes.dex */
public interface PooledByteBufferFactory {
    /* renamed from: a */
    PooledByteBufferOutputStream mo993a();

    /* renamed from: b */
    PooledByteBuffer mo994b(byte[] bArr);

    /* renamed from: c */
    PooledByteBuffer mo995c(InputStream inputStream) throws IOException;

    /* renamed from: d */
    PooledByteBuffer mo996d(InputStream inputStream, int i) throws IOException;

    /* renamed from: e */
    PooledByteBufferOutputStream mo997e(int i);
}
