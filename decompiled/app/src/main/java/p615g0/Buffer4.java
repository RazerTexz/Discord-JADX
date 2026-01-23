package p615g0;

import java.io.OutputStream;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: g0.f, reason: use source file name */
/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class Buffer4 extends OutputStream {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ Buffer3 f26089j;

    public Buffer4(Buffer3 buffer3) {
        this.f26089j = buffer3;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
    }

    public String toString() {
        return this.f26089j + ".outputStream()";
    }

    @Override // java.io.OutputStream
    public void write(int i) {
        this.f26089j.m10444T(i);
    }

    @Override // java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(bArr, "data");
        this.f26089j.m10443S(bArr, i, i2);
    }
}
