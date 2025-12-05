package p007b.p225i.p226a.p242c.p279z2.p281i;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Objects;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p279z2.MetadataInputBuffer;
import p007b.p225i.p226a.p242c.p279z2.SimpleMetadataDecoder;

/* compiled from: EventMessageDecoder.java */
/* renamed from: b.i.a.c.z2.i.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class EventMessageDecoder extends SimpleMetadataDecoder {
    @Override // p007b.p225i.p226a.p242c.p279z2.SimpleMetadataDecoder
    /* renamed from: b */
    public Metadata mo3899b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer) {
        ParsableByteArray parsableByteArray = new ParsableByteArray(byteBuffer.array(), byteBuffer.limit());
        String strM3094n = parsableByteArray.m3094n();
        Objects.requireNonNull(strM3094n);
        String strM3094n2 = parsableByteArray.m3094n();
        Objects.requireNonNull(strM3094n2);
        return new Metadata(new EventMessage(strM3094n, strM3094n2, parsableByteArray.m3093m(), parsableByteArray.m3093m(), Arrays.copyOfRange(parsableByteArray.f6793a, parsableByteArray.f6794b, parsableByteArray.f6795c)));
    }
}
