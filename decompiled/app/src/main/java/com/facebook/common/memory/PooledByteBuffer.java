package com.facebook.common.memory;

import java.io.Closeable;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public interface PooledByteBuffer extends Closeable {

    public static class ClosedException extends RuntimeException {
        public ClosedException() {
            super("Invalid bytebuf. Already closed");
        }
    }

    ByteBuffer getByteBuffer();

    /* renamed from: h */
    byte mo1395h(int i);

    /* renamed from: i */
    int mo1396i(int i, byte[] bArr, int i2, int i3);

    boolean isClosed();

    /* renamed from: k */
    long mo1397k();

    int size();
}
