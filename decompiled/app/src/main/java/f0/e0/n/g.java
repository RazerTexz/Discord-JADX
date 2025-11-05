package f0.e0.n;

import d0.z.d.m;
import g0.e;

/* compiled from: WebSocketProtocol.kt */
/* loaded from: classes3.dex */
public final class g {
    public static final void a(e.a aVar, byte[] bArr) {
        long j;
        m.checkParameterIsNotNull(aVar, "cursor");
        m.checkParameterIsNotNull(bArr, "key");
        int length = bArr.length;
        int i = 0;
        do {
            byte[] bArr2 = aVar.n;
            int i2 = aVar.o;
            int i3 = aVar.p;
            if (bArr2 != null) {
                while (i2 < i3) {
                    int i4 = i % length;
                    bArr2[i2] = (byte) (bArr2[i2] ^ bArr[i4]);
                    i2++;
                    i = i4 + 1;
                }
            }
            long j2 = aVar.m;
            g0.e eVar = aVar.j;
            if (eVar == null) {
                m.throwNpe();
            }
            if (!(j2 != eVar.k)) {
                throw new IllegalStateException("no more bytes".toString());
            }
            j = aVar.m;
        } while (aVar.b(j == -1 ? 0L : j + (aVar.p - aVar.o)) != -1);
    }
}
