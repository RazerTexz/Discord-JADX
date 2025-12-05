package p007b.p109f.p161j.p177l;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.IOException;
import java.io.InputStream;
import p007b.p109f.p115d.p119d.Throwables;
import p007b.p109f.p115d.p122g.PooledByteBufferFactory;
import p007b.p109f.p115d.p122g.PooledByteBufferOutputStream;
import p007b.p109f.p115d.p122g.PooledByteStreams;

/* compiled from: MemoryPooledByteBufferFactory.java */
/* renamed from: b.f.j.l.u, reason: use source file name */
/* loaded from: classes3.dex */
public class MemoryPooledByteBufferFactory implements PooledByteBufferFactory {

    /* renamed from: a */
    public final PooledByteStreams f3955a;

    /* renamed from: b */
    public final MemoryChunkPool f3956b;

    public MemoryPooledByteBufferFactory(MemoryChunkPool memoryChunkPool, PooledByteStreams pooledByteStreams) {
        this.f3956b = memoryChunkPool;
        this.f3955a = pooledByteStreams;
    }

    @Override // p007b.p109f.p115d.p122g.PooledByteBufferFactory
    /* renamed from: a */
    public PooledByteBufferOutputStream mo993a() {
        MemoryChunkPool memoryChunkPool = this.f3956b;
        return new MemoryPooledByteBufferOutputStream(memoryChunkPool, memoryChunkPool.f3952k[0]);
    }

    @Override // p007b.p109f.p115d.p122g.PooledByteBufferFactory
    /* renamed from: b */
    public PooledByteBuffer mo994b(byte[] bArr) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f3956b, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return memoryPooledByteBufferOutputStream.m8707b();
            } catch (IOException e) {
                Throwables.m972a(e);
                throw new RuntimeException(e);
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // p007b.p109f.p115d.p122g.PooledByteBufferFactory
    /* renamed from: c */
    public PooledByteBuffer mo995c(InputStream inputStream) throws Throwable {
        MemoryChunkPool memoryChunkPool = this.f3956b;
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(memoryChunkPool, memoryChunkPool.f3952k[0]);
        try {
            this.f3955a.m998a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.m8707b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // p007b.p109f.p115d.p122g.PooledByteBufferFactory
    /* renamed from: d */
    public PooledByteBuffer mo996d(InputStream inputStream, int i) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f3956b, i);
        try {
            this.f3955a.m998a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.m8707b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // p007b.p109f.p115d.p122g.PooledByteBufferFactory
    /* renamed from: e */
    public PooledByteBufferOutputStream mo997e(int i) {
        return new MemoryPooledByteBufferOutputStream(this.f3956b, i);
    }
}
