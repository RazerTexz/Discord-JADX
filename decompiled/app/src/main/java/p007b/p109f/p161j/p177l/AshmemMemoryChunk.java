package p007b.p109f.p161j.p177l;

import android.annotation.TargetApi;
import android.os.SharedMemory;
import android.system.ErrnoException;
import android.util.Log;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;

/* compiled from: AshmemMemoryChunk.java */
@TargetApi(27)
/* renamed from: b.f.j.l.a, reason: use source file name */
/* loaded from: classes3.dex */
public class AshmemMemoryChunk implements MemoryChunk, Closeable {

    /* renamed from: j */
    public SharedMemory f3914j;

    /* renamed from: k */
    public ByteBuffer f3915k;

    /* renamed from: l */
    public final long f3916l;

    public AshmemMemoryChunk(int i) {
        AnimatableValueParser.m527i(Boolean.valueOf(i > 0));
        try {
            SharedMemory sharedMemoryCreate = SharedMemory.create("AshmemMemoryChunk", i);
            this.f3914j = sharedMemoryCreate;
            this.f3915k = sharedMemoryCreate.mapReadWrite();
            this.f3916l = System.identityHashCode(this);
        } catch (ErrnoException e) {
            throw new RuntimeException("Fail to create AshmemMemory", e);
        }
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: a */
    public void mo1365a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Objects.requireNonNull(memoryChunk);
        if (memoryChunk.getUniqueId() == this.f3916l) {
            StringBuilder sbM833U = outline.m833U("Copying from AshmemMemoryChunk ");
            sbM833U.append(Long.toHexString(this.f3916l));
            sbM833U.append(" to AshmemMemoryChunk ");
            sbM833U.append(Long.toHexString(memoryChunk.getUniqueId()));
            sbM833U.append(" which are the same ");
            Log.w("AshmemMemoryChunk", sbM833U.toString());
            AnimatableValueParser.m527i(Boolean.FALSE);
        }
        if (memoryChunk.getUniqueId() < this.f3916l) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    m1367c(i, memoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    m1367c(i, memoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: b */
    public synchronized int mo1366b(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(this.f3915k);
        iM507d = AnimatableValueParser.m507d(i, i3, getSize());
        AnimatableValueParser.m555p(i, bArr.length, i2, iM507d, getSize());
        this.f3915k.position(i);
        this.f3915k.put(bArr, i2, iM507d);
        return iM507d;
    }

    /* renamed from: c */
    public final void m1367c(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof AshmemMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        AnimatableValueParser.m419B(!isClosed());
        AnimatableValueParser.m419B(!memoryChunk.isClosed());
        Objects.requireNonNull(this.f3915k);
        Objects.requireNonNull(memoryChunk.getByteBuffer());
        AnimatableValueParser.m555p(i, memoryChunk.getSize(), i2, i3, getSize());
        this.f3915k.position(i);
        memoryChunk.getByteBuffer().position(i2);
        byte[] bArr = new byte[i3];
        this.f3915k.get(bArr, 0, i3);
        memoryChunk.getByteBuffer().put(bArr, 0, i3);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!isClosed()) {
            SharedMemory sharedMemory = this.f3914j;
            if (sharedMemory != null) {
                sharedMemory.close();
            }
            ByteBuffer byteBuffer = this.f3915k;
            if (byteBuffer != null) {
                SharedMemory.unmap(byteBuffer);
            }
            this.f3915k = null;
            this.f3914j = null;
        }
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public ByteBuffer getByteBuffer() {
        return this.f3915k;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public int getSize() {
        Objects.requireNonNull(this.f3914j);
        return this.f3914j.getSize();
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public long getUniqueId() {
        return this.f3916l;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: h */
    public synchronized byte mo1368h(int i) {
        boolean z2 = true;
        AnimatableValueParser.m419B(!isClosed());
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0));
        if (i >= getSize()) {
            z2 = false;
        }
        AnimatableValueParser.m527i(Boolean.valueOf(z2));
        Objects.requireNonNull(this.f3915k);
        return this.f3915k.get(i);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: i */
    public synchronized int mo1369i(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(bArr);
        Objects.requireNonNull(this.f3915k);
        iM507d = AnimatableValueParser.m507d(i, i3, getSize());
        AnimatableValueParser.m555p(i, bArr.length, i2, iM507d, getSize());
        this.f3915k.position(i);
        this.f3915k.get(bArr, i2, iM507d);
        return iM507d;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x000c  */
    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized boolean isClosed() {
        boolean z2;
        if (this.f3915k != null) {
            z2 = this.f3914j == null;
        }
        return z2;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* renamed from: k */
    public long mo1370k() {
        throw new UnsupportedOperationException("Cannot get the pointer of an  AshmemMemoryChunk");
    }
}
