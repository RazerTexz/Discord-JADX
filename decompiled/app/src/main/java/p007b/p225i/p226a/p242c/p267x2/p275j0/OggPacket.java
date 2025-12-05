package p007b.p225i.p226a.p242c.p267x2.p275j0;

import java.io.EOFException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* compiled from: OggPacket.java */
/* renamed from: b.i.a.c.x2.j0.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class OggPacket {

    /* renamed from: a */
    public final OggPageHeader f8525a = new OggPageHeader();

    /* renamed from: b */
    public final ParsableByteArray f8526b = new ParsableByteArray(new byte[65025], 0);

    /* renamed from: c */
    public int f8527c = -1;

    /* renamed from: d */
    public int f8528d;

    /* renamed from: e */
    public boolean f8529e;

    /* renamed from: a */
    public final int m3741a(int i) {
        int i2;
        int i3 = 0;
        this.f8528d = 0;
        do {
            int i4 = this.f8528d;
            int i5 = i + i4;
            OggPageHeader oggPageHeader = this.f8525a;
            if (i5 >= oggPageHeader.f8533d) {
                break;
            }
            int[] iArr = oggPageHeader.f8536g;
            this.f8528d = i4 + 1;
            i2 = iArr[i4 + i];
            i3 += i2;
        } while (i2 == 255);
        return i3;
    }

    /* renamed from: b */
    public boolean m3742b(ExtractorInput extractorInput) throws IOException {
        boolean z2;
        int i;
        boolean z3;
        AnimatableValueParser.m426D(extractorInput != null);
        if (this.f8529e) {
            this.f8529e = false;
            this.f8526b.m3075A(0);
        }
        while (!this.f8529e) {
            if (this.f8527c < 0) {
                if (!this.f8525a.m3745c(extractorInput, -1L) || !this.f8525a.m3743a(extractorInput, true)) {
                    return false;
                }
                OggPageHeader oggPageHeader = this.f8525a;
                int iM3741a = oggPageHeader.f8534e;
                if ((oggPageHeader.f8531b & 1) == 1 && this.f8526b.f6795c == 0) {
                    iM3741a += m3741a(0);
                    i = this.f8528d + 0;
                } else {
                    i = 0;
                }
                try {
                    extractorInput.mo3650l(iM3741a);
                    z3 = true;
                } catch (EOFException unused) {
                    z3 = false;
                }
                if (!z3) {
                    return false;
                }
                this.f8527c = i;
            }
            int iM3741a2 = m3741a(this.f8527c);
            int i2 = this.f8527c + this.f8528d;
            if (iM3741a2 > 0) {
                ParsableByteArray parsableByteArray = this.f8526b;
                parsableByteArray.m3082b(parsableByteArray.f6795c + iM3741a2);
                ParsableByteArray parsableByteArray2 = this.f8526b;
                try {
                    extractorInput.readFully(parsableByteArray2.f6793a, parsableByteArray2.f6795c, iM3741a2);
                    z2 = true;
                } catch (EOFException unused2) {
                    z2 = false;
                }
                if (!z2) {
                    return false;
                }
                ParsableByteArray parsableByteArray3 = this.f8526b;
                parsableByteArray3.m3078D(parsableByteArray3.f6795c + iM3741a2);
                this.f8529e = this.f8525a.f8536g[i2 + (-1)] != 255;
            }
            if (i2 == this.f8525a.f8533d) {
                i2 = -1;
            }
            this.f8527c = i2;
        }
        return true;
    }
}
