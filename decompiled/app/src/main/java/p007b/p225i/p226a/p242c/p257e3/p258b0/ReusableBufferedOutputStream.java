package p007b.p225i.p226a.p242c.p257e3.p258b0;

import java.io.BufferedOutputStream;
import java.io.OutputStream;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.Util2;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.p, reason: use source file name */
/* JADX INFO: compiled from: ReusableBufferedOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ReusableBufferedOutputStream extends BufferedOutputStream {

    /* JADX INFO: renamed from: j */
    public boolean f6503j;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    /* JADX INFO: renamed from: a */
    public void m2822a(OutputStream outputStream) {
        AnimatableValueParser.m426D(this.f6503j);
        ((BufferedOutputStream) this).out = outputStream;
        ((BufferedOutputStream) this).count = 0;
        this.f6503j = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f6503j = true;
        try {
            flush();
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            ((BufferedOutputStream) this).out.close();
        } catch (Throwable th2) {
            if (th == null) {
                th = th2;
            }
        }
        if (th == null) {
            return;
        }
        int i = Util2.f6708a;
        throw th;
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int i) {
        super(outputStream, i);
    }
}
