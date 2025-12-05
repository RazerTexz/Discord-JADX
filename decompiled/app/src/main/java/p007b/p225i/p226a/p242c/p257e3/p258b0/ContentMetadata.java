package p007b.p225i.p226a.p242c.p257e3.p258b0;

import java.nio.ByteBuffer;

/* compiled from: ContentMetadata.java */
/* renamed from: b.i.a.c.e3.b0.k, reason: use source file name */
/* loaded from: classes3.dex */
public final /* synthetic */ class ContentMetadata {
    /* renamed from: a */
    public static long m2814a(ContentMetadata2 contentMetadata2) {
        byte[] bArr = ((DefaultContentMetadata) contentMetadata2).f6500c.get("exo_len");
        if (bArr != null) {
            return ByteBuffer.wrap(bArr).getLong();
        }
        return -1L;
    }
}
