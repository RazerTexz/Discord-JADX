package p007b.p225i.p226a.p242c.p267x2.p277l0;

import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* JADX INFO: renamed from: b.i.a.c.x2.l0.d, reason: use source file name */
/* JADX INFO: compiled from: WavHeaderReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WavHeaderReader {

    /* JADX INFO: renamed from: a */
    public final int f8960a;

    /* JADX INFO: renamed from: b */
    public final long f8961b;

    public WavHeaderReader(int i, long j) {
        this.f8960a = i;
        this.f8961b = j;
    }

    /* JADX INFO: renamed from: a */
    public static WavHeaderReader m3800a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
        extractorInput.mo3652o(parsableByteArray.f6793a, 0, 8);
        parsableByteArray.m3079E(0);
        return new WavHeaderReader(parsableByteArray.m3086f(), parsableByteArray.m3090j());
    }
}
