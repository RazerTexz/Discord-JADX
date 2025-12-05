package p007b.p109f.p161j.p177l;

import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: BufferMemoryChunk.java */
/* renamed from: b.f.j.l.i, reason: use source file name */
/* loaded from: classes3.dex */
public class BufferMemoryChunk implements MemoryChunk, Closeable {

    /* renamed from: j */
    public ByteBuffer f3938j;

    /* renamed from: k */
    public final int f3939k;

    /* renamed from: l */
    public final long f3940l = System.identityHashCode(this);

    public BufferMemoryChunk(int i) {
        this.f3938j = ByteBuffer.allocateDirect(i);
        this.f3939k = i;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: a */
    public void mo1365a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Objects.requireNonNull(memoryChunk);
        if (memoryChunk.getUniqueId() == this.f3940l) {
            StringBuilder sbM833U = outline.m833U("Copying from BufferMemoryChunk ");
            sbM833U.append(Long.toHexString(this.f3940l));
            sbM833U.append(" to BufferMemoryChunk ");
            sbM833U.append(Long.toHexString(memoryChunk.getUniqueId()));
            sbM833U.append(" which are the same ");
            Log.w("BufferMemoryChunk", sbM833U.toString());
            AnimatableValueParser.m527i(Boolean.FALSE);
        }
        if (memoryChunk.getUniqueId() < this.f3940l) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    m1389c(i, memoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    m1389c(i, memoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: b */
    public synchronized int mo1366b(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        AnimatableValueParser.m419B(!isClosed());
        Objects.requireNonNull(this.f3938j);
        iM507d = AnimatableValueParser.m507d(i, i3, this.f3939k);
        AnimatableValueParser.m555p(i, bArr.length, i2, iM507d, this.f3939k);
        this.f3938j.position(i);
        this.f3938j.put(bArr, i2, iM507d);
        return iM507d;
    }

    /* renamed from: c */
    public final void m1389c(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof BufferMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        AnimatableValueParser.m419B(!isClosed());
        AnimatableValueParser.m419B(!memoryChunk.isClosed());
        Objects.requireNonNull(this.f3938j);
        AnimatableValueParser.m555p(i, memoryChunk.getSize(), i2, i3, this.f3939k);
        this.f3938j.position(i);
        ByteBuffer byteBuffer = memoryChunk.getByteBuffer();
        Objects.requireNonNull(byteBuffer);
        byteBuffer.position(i2);
        byte[] bArr = new byte[i3];
        this.f3938j.get(bArr, 0, i3);
        byteBuffer.put(bArr, 0, i3);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f3938j = null;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public synchronized ByteBuffer getByteBuffer() {
        return this.f3938j;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public int getSize() {
        return this.f3939k;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public long getUniqueId() {
        return this.f3940l;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: h */
    public synchronized byte mo1368h(int i) {
        boolean z2 = true;
        AnimatableValueParser.m419B(!isClosed());
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0));
        if (i >= this.f3939k) {
            z2 = false;
        }
        AnimatableValueParser.m527i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.f3938j);
        return this.f3938j.get(i);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: i */
    public synchronized int mo1369i(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(bArr);
        AnimatableValueParser.m419B(!isClosed());
        Objects.requireNonNull(this.f3938j);
        iM507d = AnimatableValueParser.m507d(i, i3, this.f3939k);
        AnimatableValueParser.m555p(i, bArr.length, i2, iM507d, this.f3939k);
        this.f3938j.position(i);
        this.f3938j.get(bArr, i2, iM507d);
        return iM507d;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public synchronized boolean isClosed() {
        return this.f3938j == null;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: k */
    public long mo1370k() {
        throw new UnsupportedOperationException("Cannot get the pointer of a BufferMemoryChunk");
    }
}
