package b.f.j.l;

import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.MemoryPooledByteBufferOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: MemoryPooledByteBufferFactory.java */
/* loaded from: classes3.dex */
public class u implements b.f.d.g.g {
    public final b.f.d.g.j a;

    /* renamed from: b, reason: collision with root package name */
    public final s f599b;

    public u(s sVar, b.f.d.g.j jVar) {
        this.f599b = sVar;
        this.a = jVar;
    }

    @Override // b.f.d.g.g
    public b.f.d.g.i a() {
        s sVar = this.f599b;
        return new MemoryPooledByteBufferOutputStream(sVar, sVar.k[0]);
    }

    @Override // b.f.d.g.g
    public PooledByteBuffer b(byte[] bArr) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f599b, bArr.length);
        try {
            try {
                memoryPooledByteBufferOutputStream.write(bArr, 0, bArr.length);
                return memoryPooledByteBufferOutputStream.b();
            } catch (IOException e) {
                b.f.d.d.m.a(e);
                throw new RuntimeException(e);
            }
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // b.f.d.g.g
    public PooledByteBuffer c(InputStream inputStream) throws Throwable {
        s sVar = this.f599b;
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(sVar, sVar.k[0]);
        try {
            this.a.a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // b.f.d.g.g
    public PooledByteBuffer d(InputStream inputStream, int i) throws Throwable {
        MemoryPooledByteBufferOutputStream memoryPooledByteBufferOutputStream = new MemoryPooledByteBufferOutputStream(this.f599b, i);
        try {
            this.a.a(inputStream, memoryPooledByteBufferOutputStream);
            return memoryPooledByteBufferOutputStream.b();
        } finally {
            memoryPooledByteBufferOutputStream.close();
        }
    }

    @Override // b.f.d.g.g
    public b.f.d.g.i e(int i) {
        return new MemoryPooledByteBufferOutputStream(this.f599b, i);
    }
}
