package p007b.p225i.p226a.p242c.p279z2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;

/* JADX INFO: renamed from: b.i.a.c.z2.g, reason: use source file name */
/* JADX INFO: compiled from: SimpleMetadataDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SimpleMetadataDecoder implements MetadataDecoder {
    @Override // p007b.p225i.p226a.p242c.p279z2.MetadataDecoder
    @Nullable
    /* JADX INFO: renamed from: a */
    public final Metadata mo3895a(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.f19778l;
        Objects.requireNonNull(byteBuffer);
        AnimatableValueParser.m531j(byteBuffer.position() == 0 && byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0);
        if (metadataInputBuffer.m3554m()) {
            return null;
        }
        return mo3899b(metadataInputBuffer, byteBuffer);
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public abstract Metadata mo3899b(MetadataInputBuffer metadataInputBuffer, ByteBuffer byteBuffer);
}
