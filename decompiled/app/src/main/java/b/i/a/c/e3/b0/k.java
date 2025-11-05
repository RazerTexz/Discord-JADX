package b.i.a.c.e3.b0;

import java.nio.ByteBuffer;

/* compiled from: ContentMetadata.java */
/* loaded from: classes3.dex */
public final /* synthetic */ class k {
    public static long a(l lVar) {
        byte[] bArr = ((n) lVar).c.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }
}
