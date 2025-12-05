package p007b.p225i.p226a.p242c.p267x2;

import androidx.annotation.Nullable;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;

/* compiled from: TrueHdSampleRechunker.java */
/* renamed from: b.i.a.c.x2.x, reason: use source file name */
/* loaded from: classes3.dex */
public final class TrueHdSampleRechunker {

    /* renamed from: a */
    public final byte[] f9004a = new byte[10];

    /* renamed from: b */
    public boolean f9005b;

    /* renamed from: c */
    public int f9006c;

    /* renamed from: d */
    public long f9007d;

    /* renamed from: e */
    public int f9008e;

    /* renamed from: f */
    public int f9009f;

    /* renamed from: g */
    public int f9010g;

    /* renamed from: a */
    public void m3819a(TrackOutput2 trackOutput2, @Nullable TrackOutput2.a aVar) {
        if (this.f9006c > 0) {
            trackOutput2.mo2525d(this.f9007d, this.f9008e, this.f9009f, this.f9010g, aVar);
            this.f9006c = 0;
        }
    }

    /* renamed from: b */
    public void m3820b(TrackOutput2 trackOutput2, long j, int i, int i2, int i3, @Nullable TrackOutput2.a aVar) {
        AnimatableValueParser.m429E(this.f9010g <= i2 + i3, "TrueHD chunk samples must be contiguous in the sample queue.");
        if (this.f9005b) {
            int i4 = this.f9006c;
            int i5 = i4 + 1;
            this.f9006c = i5;
            if (i4 == 0) {
                this.f9007d = j;
                this.f9008e = i;
                this.f9009f = 0;
            }
            this.f9009f += i2;
            this.f9010g = i3;
            if (i5 >= 16) {
                m3819a(trackOutput2, aVar);
            }
        }
    }

    /* renamed from: c */
    public void m3821c(ExtractorInput extractorInput) throws IOException {
        if (this.f9005b) {
            return;
        }
        extractorInput.mo3652o(this.f9004a, 0, 10);
        extractorInput.mo3649k();
        byte[] bArr = this.f9004a;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111 && (bArr[7] & 254) == 186) {
            i = 40 << ((bArr[((bArr[7] & 255) == 187 ? 1 : 0) != 0 ? '\t' : '\b'] >> 4) & 7);
        }
        if (i == 0) {
            return;
        }
        this.f9005b = true;
    }
}
