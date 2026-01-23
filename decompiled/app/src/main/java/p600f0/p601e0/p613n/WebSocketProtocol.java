package p600f0.p601e0.p613n;

import p507d0.p592z.p594d.Intrinsics3;
import p615g0.Buffer3;

/* JADX INFO: renamed from: f0.e0.n.g, reason: use source file name */
/* JADX INFO: compiled from: WebSocketProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketProtocol {
    /* JADX INFO: renamed from: a */
    public static final void m10360a(Buffer3.a aVar, byte[] bArr) {
        long j;
        Intrinsics3.checkParameterIsNotNull(aVar, "cursor");
        Intrinsics3.checkParameterIsNotNull(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = aVar.f26085n;
            int i2 = aVar.f26086o;
            int i3 = aVar.f26087p;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = aVar.f26084m;
            Buffer3 buffer3 = aVar.f26081j;
            if (buffer3 == null) {
                Intrinsics3.throwNpe();
            }
            if (!(j2 != buffer3.f26080k)) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j = aVar.f26084m;
        } while (aVar.m10476b(j == -1 ? 0L : j + ((long) (aVar.f26087p - aVar.f26086o))) != -1);
    }
}
