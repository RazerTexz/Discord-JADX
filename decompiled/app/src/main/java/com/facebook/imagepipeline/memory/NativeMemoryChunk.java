package com.facebook.imagepipeline.memory;

import android.util.Log;
import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p109f.p115d.p119d.DoNotStrip;
import p007b.p109f.p161j.p177l.MemoryChunk;
import p007b.p109f.p190m.p191n.NativeLoader;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class NativeMemoryChunk implements MemoryChunk, Closeable {

    /* JADX INFO: renamed from: j */
    public final long f19563j;

    /* JADX INFO: renamed from: k */
    public final int f19564k;

    /* JADX INFO: renamed from: l */
    public boolean f19565l;

    static {
        NativeLoader.m1589c("imagepipeline");
    }

    public NativeMemoryChunk(int i) {
        AnimatableValueParser.m527i(Boolean.valueOf(i > 0));
        this.f19564k = i;
        this.f19563j = nativeAllocate(i);
        this.f19565l = false;
    }

    @DoNotStrip
    private static native long nativeAllocate(int i);

    @DoNotStrip
    private static native void nativeCopyFromByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeCopyToByteArray(long j, byte[] bArr, int i, int i2);

    @DoNotStrip
    private static native void nativeFree(long j);

    @DoNotStrip
    private static native void nativeMemcpy(long j, long j2, int i);

    @DoNotStrip
    private static native byte nativeReadByte(long j);

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* JADX INFO: renamed from: a */
    public void mo1365a(int i, MemoryChunk memoryChunk, int i2, int i3) {
        Objects.requireNonNull(memoryChunk);
        if (memoryChunk.getUniqueId() == this.f19563j) {
            StringBuilder sbM833U = outline.m833U("Copying from NativeMemoryChunk ");
            sbM833U.append(Integer.toHexString(System.identityHashCode(this)));
            sbM833U.append(" to NativeMemoryChunk ");
            sbM833U.append(Integer.toHexString(System.identityHashCode(memoryChunk)));
            sbM833U.append(" which share the same address ");
            sbM833U.append(Long.toHexString(this.f19563j));
            Log.w("NativeMemoryChunk", sbM833U.toString());
            AnimatableValueParser.m527i(Boolean.FALSE);
        }
        if (memoryChunk.getUniqueId() < this.f19563j) {
            synchronized (memoryChunk) {
                synchronized (this) {
                    m8708c(i, memoryChunk, i2, i3);
                }
            }
        } else {
            synchronized (this) {
                synchronized (memoryChunk) {
                    m8708c(i, memoryChunk, i2, i3);
                }
            }
        }
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* JADX INFO: renamed from: b */
    public synchronized int mo1366b(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        AnimatableValueParser.m419B(!isClosed());
        iM507d = AnimatableValueParser.m507d(i, i3, this.f19564k);
        AnimatableValueParser.m555p(i, bArr.length, i2, iM507d, this.f19564k);
        nativeCopyFromByteArray(this.f19563j + ((long) i), bArr, i2, iM507d);
        return iM507d;
    }

    /* JADX INFO: renamed from: c */
    public final void m8708c(int i, MemoryChunk memoryChunk, int i2, int i3) {
        if (!(memoryChunk instanceof NativeMemoryChunk)) {
            throw new IllegalArgumentException("Cannot copy two incompatible MemoryChunks");
        }
        AnimatableValueParser.m419B(!isClosed());
        AnimatableValueParser.m419B(!memoryChunk.isClosed());
        AnimatableValueParser.m555p(i, memoryChunk.getSize(), i2, i3, this.f19564k);
        nativeMemcpy(memoryChunk.mo1370k() + ((long) i2), this.f19563j + ((long) i), i3);
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (!this.f19565l) {
            this.f19565l = true;
            nativeFree(this.f19563j);
        }
    }

    public void finalize() throws Throwable {
        if (isClosed()) {
            return;
        }
        StringBuilder sbM833U = outline.m833U("finalize: Chunk ");
        sbM833U.append(Integer.toHexString(System.identityHashCode(this)));
        sbM833U.append(" still active. ");
        Log.w("NativeMemoryChunk", sbM833U.toString());
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public ByteBuffer getByteBuffer() {
        return null;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public int getSize() {
        return this.f19564k;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public long getUniqueId() {
        return this.f19563j;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* JADX INFO: renamed from: h */
    public synchronized byte mo1368h(int i) {
        boolean z2 = true;
        AnimatableValueParser.m419B(!isClosed());
        AnimatableValueParser.m527i(Boolean.valueOf(i >= 0));
        if (i >= this.f19564k) {
            z2 = false;
        }
        AnimatableValueParser.m527i(Boolean.valueOf(z2));
        return nativeReadByte(this.f19563j + ((long) i));
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* JADX INFO: renamed from: i */
    public synchronized int mo1369i(int i, byte[] bArr, int i2, int i3) {
        int iM507d;
        Objects.requireNonNull(bArr);
        AnimatableValueParser.m419B(!isClosed());
        iM507d = AnimatableValueParser.m507d(i, i3, this.f19564k);
        AnimatableValueParser.m555p(i, bArr.length, i2, iM507d, this.f19564k);
        nativeCopyToByteArray(this.f19563j + ((long) i), bArr, i2, iM507d);
        return iM507d;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    public synchronized boolean isClosed() {
        return this.f19565l;
    }

    @Override // p007b.p109f.p161j.p177l.MemoryChunk
    /* JADX INFO: renamed from: k */
    public long mo1370k() {
        return this.f19563j;
    }

    @VisibleForTesting
    public NativeMemoryChunk() {
        this.f19564k = 0;
        this.f19563j = 0L;
        this.f19565l = true;
    }
}
