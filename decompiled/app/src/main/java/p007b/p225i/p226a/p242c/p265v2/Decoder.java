package p007b.p225i.p226a.p242c.p265v2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.decoder.DecoderException;

/* JADX INFO: renamed from: b.i.a.c.v2.d, reason: use source file name */
/* JADX INFO: compiled from: Decoder.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Decoder<I, O, E extends DecoderException> {
    @Nullable
    /* JADX INFO: renamed from: b */
    O mo2608b() throws DecoderException;

    @Nullable
    /* JADX INFO: renamed from: c */
    I mo2609c() throws DecoderException;

    /* JADX INFO: renamed from: d */
    void mo2610d(I i) throws DecoderException;

    void flush();

    void release();
}
