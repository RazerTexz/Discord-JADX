package p007b.p225i.p226a.p242c.p245b3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import java.nio.ByteBuffer;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p265v2.DecoderOutputBuffer;
import p007b.p225i.p226a.p242c.p265v2.SimpleDecoder;

/* compiled from: SimpleSubtitleDecoder.java */
/* renamed from: b.i.a.c.b3.f, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SimpleSubtitleDecoder2 extends SimpleDecoder<SubtitleInputBuffer, SubtitleOutputBuffer, SubtitleDecoderException> implements SubtitleDecoder {
    public SimpleSubtitleDecoder2(String str) {
        super(new SubtitleInputBuffer[2], new SubtitleOutputBuffer[2]);
        AnimatableValueParser.m426D(this.f7937g == this.f7935e.length);
        for (DecoderInputBuffer decoderInputBuffer : this.f7935e) {
            decoderInputBuffer.m8812r(1024);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p245b3.SubtitleDecoder
    /* renamed from: a */
    public void mo2607a(long j) {
    }

    @Override // p007b.p225i.p226a.p242c.p265v2.SimpleDecoder
    @Nullable
    /* renamed from: e */
    public DecoderException mo2616e(DecoderInputBuffer decoderInputBuffer, DecoderOutputBuffer decoderOutputBuffer, boolean z2) {
        SubtitleInputBuffer subtitleInputBuffer = (SubtitleInputBuffer) decoderInputBuffer;
        SubtitleOutputBuffer subtitleOutputBuffer = (SubtitleOutputBuffer) decoderOutputBuffer;
        try {
            ByteBuffer byteBuffer = subtitleInputBuffer.f19778l;
            Objects.requireNonNull(byteBuffer);
            subtitleOutputBuffer.m2619r(subtitleInputBuffer.f19780n, mo2617j(byteBuffer.array(), byteBuffer.limit(), z2), subtitleInputBuffer.f5800r);
            subtitleOutputBuffer.f7901j &= Integer.MAX_VALUE;
            return null;
        } catch (SubtitleDecoderException e) {
            return e;
        }
    }

    /* renamed from: j */
    public abstract Subtitle mo2617j(byte[] bArr, int i, boolean z2) throws SubtitleDecoderException;
}
