package com.facebook.imagepipeline.memory;

import com.facebook.common.references.CloseableReference;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p115d.p122g.PooledByteBufferOutputStream;
import p007b.p109f.p161j.p177l.MemoryChunk;
import p007b.p109f.p161j.p177l.MemoryChunkPool;
import p007b.p109f.p161j.p177l.MemoryPooledByteBuffer;

/* loaded from: classes3.dex */
public class MemoryPooledByteBufferOutputStream extends PooledByteBufferOutputStream {

    /* renamed from: j */
    public final MemoryChunkPool f19560j;

    /* renamed from: k */
    public CloseableReference<MemoryChunk> f19561k;

    /* renamed from: l */
    public int f19562l;

    public static class InvalidStreamException extends RuntimeException {
        public InvalidStreamException() {
            super("OutputStream no longer valid");
        }
    }

    public MemoryPooledByteBufferOutputStream(MemoryChunkPool memoryChunkPool, int i) {
        AnimatableValueParser.m527i(Boolean.valueOf(i > 0));
        Objects.requireNonNull(memoryChunkPool);
        this.f19560j = memoryChunkPool;
        this.f19562l = 0;
        this.f19561k = CloseableReference.m8633D(memoryChunkPool.get(i), memoryChunkPool);
    }

    /* renamed from: a */
    public final void m8706a() {
        if (!CloseableReference.m8640y(this.f19561k)) {
            throw new InvalidStreamException();
        }
    }

    /* renamed from: b */
    public MemoryPooledByteBuffer m8707b() {
        m8706a();
        CloseableReference<MemoryChunk> closeableReference = this.f19561k;
        Objects.requireNonNull(closeableReference);
        return new MemoryPooledByteBuffer(closeableReference, this.f19562l);
    }

    @Override // p007b.p109f.p115d.p122g.PooledByteBufferOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        CloseableReference<MemoryChunk> closeableReference = this.f19561k;
        Class<CloseableReference> cls = CloseableReference.f19438j;
        if (closeableReference != null) {
            closeableReference.close();
        }
        this.f19561k = null;
        this.f19562l = -1;
        super.close();
    }

    @Override // java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws Throwable {
        if (i < 0 || i2 < 0 || i + i2 > bArr.length) {
            StringBuilder sbM833U = outline.m833U("length=");
            sbM833U.append(bArr.length);
            sbM833U.append("; regionStart=");
            sbM833U.append(i);
            sbM833U.append("; regionLength=");
            sbM833U.append(i2);
            throw new ArrayIndexOutOfBoundsException(sbM833U.toString());
        }
        m8706a();
        int i3 = this.f19562l + i2;
        m8706a();
        Objects.requireNonNull(this.f19561k);
        if (i3 > this.f19561k.m8642u().getSize()) {
            MemoryChunk memoryChunk = this.f19560j.get(i3);
            Objects.requireNonNull(this.f19561k);
            this.f19561k.m8642u().mo1365a(0, memoryChunk, 0, this.f19562l);
            this.f19561k.close();
            this.f19561k = CloseableReference.m8633D(memoryChunk, this.f19560j);
        }
        CloseableReference<MemoryChunk> closeableReference = this.f19561k;
        Objects.requireNonNull(closeableReference);
        closeableReference.m8642u().mo1366b(this.f19562l, bArr, i, i2);
        this.f19562l += i2;
    }
}
