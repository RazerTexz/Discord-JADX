package b.f.d.g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: PooledByteStreams.java */
/* loaded from: classes.dex */
public class j {
    public final int a;

    /* renamed from: b, reason: collision with root package name */
    public final a f472b;

    public j(a aVar) {
        b.c.a.a0.d.i(true);
        this.a = 16384;
        this.f472b = aVar;
    }

    public long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f472b.get(this.a);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.a);
                if (i == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, i);
                j += i;
            } finally {
                this.f472b.release(bArr);
            }
        }
    }
}
