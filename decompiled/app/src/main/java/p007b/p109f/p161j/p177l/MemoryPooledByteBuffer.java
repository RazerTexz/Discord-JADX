package p007b.p109f.p161j.p177l;

import androidx.annotation.VisibleForTesting;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import java.nio.ByteBuffer;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: MemoryPooledByteBuffer.java */
/* renamed from: b.f.j.l.t, reason: use source file name */
/* loaded from: classes3.dex */
public class MemoryPooledByteBuffer implements PooledByteBuffer {

    /* renamed from: j */
    public final int f3953j;

    /* renamed from: k */
    @VisibleForTesting
    public CloseableReference<MemoryChunk> f3954k;

    public MemoryPooledByteBuffer(CloseableReference<MemoryChunk> closeableReference, int i) {
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0 && i <= closeableReference.m8642u().getSize()));
        this.f3954k = closeableReference.mo999b();
        this.f3953j = i;
    }

    /* renamed from: a */
    public synchronized void m1394a() {
        try {
            synchronized (this) {
            }
        } catch (Throwable th) {
            throw th;
        }
        if (!CloseableReference.m8640y(this.f3954k)) {
            throw new PooledByteBuffer.ClosedException();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        CloseableReference<MemoryChunk> closeableReference = this.f3954k;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f3954k = null;
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized ByteBuffer getByteBuffer() {
        return this.f3954k.m8642u().getByteBuffer();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    /* renamed from: h */
    public synchronized byte mo1395h(int i) {
        m1394a();
        boolean z2 = true;
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0));
        if (i >= this.f3953j) {
            z2 = false;
        }
        AnimatableValueParser.m527i(Boolean.valueOf(z2));
        return this.f3954k.m8642u().mo1368h(i);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    /* renamed from: i */
    public synchronized int mo1396i(int i, byte[] bArr, int i2, int i3) {
        m1394a();
        AnimatableValueParser.m527i(Boolean.valueOf(i + i3 <= this.f3953j));
        return this.f3954k.m8642u().mo1369i(i, bArr, i2, i3);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized boolean isClosed() {
        return !CloseableReference.m8640y(this.f3954k);
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    /* renamed from: k */
    public synchronized long mo1397k() throws UnsupportedOperationException {
        m1394a();
        return this.f3954k.m8642u().mo1370k();
    }

    @Override // com.facebook.common.memory.PooledByteBuffer
    public synchronized int size() {
        m1394a();
        return this.f3953j;
    }
}
