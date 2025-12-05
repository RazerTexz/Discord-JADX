package p007b.p109f.p115d.p122g;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* compiled from: PooledByteStreams.java */
/* renamed from: b.f.d.g.j, reason: use source file name */
/* loaded from: classes.dex */
public class PooledByteStreams {

    /* renamed from: a */
    public final int f3117a;

    /* renamed from: b */
    public final ByteArrayPool f3118b;

    public PooledByteStreams(ByteArrayPool byteArrayPool) {
        AnimatableValueParser.m527i(true);
        this.f3117a = 16384;
        this.f3118b = byteArrayPool;
    }

    /* renamed from: a */
    public long m998a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = this.f3118b.get(this.f3117a);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr, 0, this.f3117a);
                if (i == -1) {
                    return j;
                }
                outputStream.write(bArr, 0, i);
                j += i;
            } finally {
                this.f3118b.release(bArr);
            }
        }
    }
}
