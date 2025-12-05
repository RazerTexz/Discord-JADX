package p007b.p225i.p226a.p242c.p267x2.p275j0;

import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* compiled from: OggPageHeader.java */
/* renamed from: b.i.a.c.x2.j0.f, reason: use source file name */
/* loaded from: classes3.dex */
public final class OggPageHeader {

    /* renamed from: a */
    public int f8530a;

    /* renamed from: b */
    public int f8531b;

    /* renamed from: c */
    public long f8532c;

    /* renamed from: d */
    public int f8533d;

    /* renamed from: e */
    public int f8534e;

    /* renamed from: f */
    public int f8535f;

    /* renamed from: g */
    public final int[] f8536g = new int[255];

    /* renamed from: h */
    public final ParsableByteArray f8537h = new ParsableByteArray(255);

    /* renamed from: a */
    public boolean m3743a(ExtractorInput extractorInput, boolean z2) throws IOException {
        m3744b();
        this.f8537h.m3075A(27);
        if (!AnimatableValueParser.m589x1(extractorInput, this.f8537h.f6793a, 0, 27, z2) || this.f8537h.m3101u() != 1332176723) {
            return false;
        }
        int iM3100t = this.f8537h.m3100t();
        this.f8530a = iM3100t;
        if (iM3100t != 0) {
            if (z2) {
                return false;
            }
            throw ParserException.m8756b("unsupported bit stream revision");
        }
        this.f8531b = this.f8537h.m3100t();
        ParsableByteArray parsableByteArray = this.f8537h;
        byte[] bArr = parsableByteArray.f6793a;
        int i = parsableByteArray.f6794b + 1;
        parsableByteArray.f6794b = i;
        long j = bArr[r3] & 255;
        int i2 = i + 1;
        parsableByteArray.f6794b = i2;
        int i3 = i2 + 1;
        parsableByteArray.f6794b = i3;
        long j2 = j | ((bArr[i] & 255) << 8) | ((bArr[i2] & 255) << 16);
        int i4 = i3 + 1;
        parsableByteArray.f6794b = i4;
        long j3 = j2 | ((bArr[i3] & 255) << 24);
        int i5 = i4 + 1;
        parsableByteArray.f6794b = i5;
        long j4 = j3 | ((bArr[i4] & 255) << 32);
        int i6 = i5 + 1;
        parsableByteArray.f6794b = i6;
        long j5 = j4 | ((bArr[i5] & 255) << 40);
        int i7 = i6 + 1;
        parsableByteArray.f6794b = i7;
        parsableByteArray.f6794b = i7 + 1;
        this.f8532c = j5 | ((bArr[i6] & 255) << 48) | ((bArr[i7] & 255) << 56);
        parsableByteArray.m3090j();
        this.f8537h.m3090j();
        this.f8537h.m3090j();
        int iM3100t2 = this.f8537h.m3100t();
        this.f8533d = iM3100t2;
        this.f8534e = iM3100t2 + 27;
        this.f8537h.m3075A(iM3100t2);
        if (!AnimatableValueParser.m589x1(extractorInput, this.f8537h.f6793a, 0, this.f8533d, z2)) {
            return false;
        }
        for (int i8 = 0; i8 < this.f8533d; i8++) {
            this.f8536g[i8] = this.f8537h.m3100t();
            this.f8535f += this.f8536g[i8];
        }
        return true;
    }

    /* renamed from: b */
    public void m3744b() {
        this.f8530a = 0;
        this.f8531b = 0;
        this.f8532c = 0L;
        this.f8533d = 0;
        this.f8534e = 0;
        this.f8535f = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004f, code lost:
    
        if (r10 == (-1)) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0057, code lost:
    
        if (r9.getPosition() >= r10) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if (r9.mo3647h(1) == (-1)) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0061, code lost:
    
        return false;
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m3745c(ExtractorInput extractorInput, long j) throws IOException {
        AnimatableValueParser.m531j(extractorInput.getPosition() == extractorInput.mo3645f());
        this.f8537h.m3075A(4);
        while (true) {
            if ((j != -1 && extractorInput.getPosition() + 4 >= j) || !AnimatableValueParser.m589x1(extractorInput, this.f8537h.f6793a, 0, 4, true)) {
                break;
            }
            this.f8537h.m3079E(0);
            if (this.f8537h.m3101u() == 1332176723) {
                extractorInput.mo3649k();
                return true;
            }
            extractorInput.mo3650l(1);
        }
    }
}
