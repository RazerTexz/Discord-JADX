package p007b.p225i.p226a.p242c.p265v2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* compiled from: Decoder.java */
/* renamed from: b.i.a.c.v2.d, reason: use source file name */
/* loaded from: classes3.dex */
public interface Decoder<I, O, E extends DecoderException> {
    @Nullable
    /* renamed from: b */
    O mo2608b() throws DecoderException;

    @Nullable
    /* renamed from: c */
    I mo2609c() throws DecoderException;

    /* renamed from: d */
    void mo2610d(I i) throws DecoderException;

    void flush();

    void release();
}
