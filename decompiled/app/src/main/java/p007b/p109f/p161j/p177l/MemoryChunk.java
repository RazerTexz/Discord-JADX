package p007b.p109f.p161j.p177l;

import java.nio.ByteBuffer;

/* compiled from: MemoryChunk.java */
/* renamed from: b.f.j.l.r, reason: use source file name */
/* loaded from: classes3.dex */
public interface MemoryChunk {
    /* renamed from: a */
    void mo1365a(int i, MemoryChunk memoryChunk, int i2, int i3);

    /* renamed from: b */
    int mo1366b(int i, byte[] bArr, int i2, int i3);

    void close();

    ByteBuffer getByteBuffer();

    int getSize();

    long getUniqueId();

    /* renamed from: h */
    byte mo1368h(int i);

    /* renamed from: i */
    int mo1369i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    /* renamed from: k */
    long mo1370k() throws UnsupportedOperationException;
}
