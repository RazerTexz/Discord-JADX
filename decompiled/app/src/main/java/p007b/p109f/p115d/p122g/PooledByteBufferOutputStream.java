package p007b.p109f.p115d.p122g;

import java.io.IOException;
import java.io.OutputStream;
import p007b.p109f.p115d.p119d.Throwables;

/* compiled from: PooledByteBufferOutputStream.java */
/* renamed from: b.f.d.g.i, reason: use source file name */
/* loaded from: classes.dex */
public abstract class PooledByteBufferOutputStream extends OutputStream {
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        try {
            super.close();
        } catch (IOException e) {
            Throwables.m972a(e);
            throw new RuntimeException(e);
        }
    }
}
