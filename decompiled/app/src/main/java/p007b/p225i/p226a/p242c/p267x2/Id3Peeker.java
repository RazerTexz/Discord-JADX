package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.EOFException;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p279z2.p283k.Id3Decoder;

/* compiled from: Id3Peeker.java */
/* renamed from: b.i.a.c.x2.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class Id3Peeker {

    /* renamed from: a */
    public final ParsableByteArray f8987a = new ParsableByteArray(10);

    @Nullable
    /* renamed from: a */
    public Metadata m3816a(ExtractorInput extractorInput, @Nullable Id3Decoder.a aVar) throws IOException {
        Metadata metadataM3922d = null;
        int i = 0;
        while (true) {
            try {
                extractorInput.mo3652o(this.f8987a.f6793a, 0, 10);
                this.f8987a.m3079E(0);
                if (this.f8987a.m3102v() != 4801587) {
                    break;
                }
                this.f8987a.m3080F(3);
                int iM3099s = this.f8987a.m3099s();
                int i2 = iM3099s + 10;
                if (metadataM3922d == null) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f8987a.f6793a, 0, bArr, 0, 10);
                    extractorInput.mo3652o(bArr, 10, iM3099s);
                    metadataM3922d = new Id3Decoder(aVar).m3922d(bArr, i2);
                } else {
                    extractorInput.mo3646g(iM3099s);
                }
                i += i2;
            } catch (EOFException unused) {
            }
        }
        extractorInput.mo3649k();
        extractorInput.mo3646g(i);
        return metadataM3922d;
    }
}
