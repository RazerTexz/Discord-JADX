package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.q, reason: use source file name */
/* JADX INFO: compiled from: H263Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class H263Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: a */
    public static final float[] f8762a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};

    /* JADX INFO: renamed from: b */
    @Nullable
    public final UserDataReader f8763b;

    /* JADX INFO: renamed from: g */
    public b f8768g;

    /* JADX INFO: renamed from: h */
    public long f8769h;

    /* JADX INFO: renamed from: i */
    public String f8770i;

    /* JADX INFO: renamed from: j */
    public TrackOutput2 f8771j;

    /* JADX INFO: renamed from: k */
    public boolean f8772k;

    /* JADX INFO: renamed from: d */
    public final boolean[] f8765d = new boolean[4];

    /* JADX INFO: renamed from: e */
    public final a f8766e = new a(128);

    /* JADX INFO: renamed from: l */
    public long f8773l = -9223372036854775807L;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final NalUnitTargetBuffer f8767f = new NalUnitTargetBuffer(Opcodes.GETSTATIC, 128);

    /* JADX INFO: renamed from: c */
    @Nullable
    public final ParsableByteArray f8764c = new ParsableByteArray();

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.q$a */
    /* JADX INFO: compiled from: H263Reader.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final byte[] f8774a = {0, 0, 1};

        /* JADX INFO: renamed from: b */
        public boolean f8775b;

        /* JADX INFO: renamed from: c */
        public int f8776c;

        /* JADX INFO: renamed from: d */
        public int f8777d;

        /* JADX INFO: renamed from: e */
        public int f8778e;

        /* JADX INFO: renamed from: f */
        public byte[] f8779f;

        public a(int i) {
            this.f8779f = new byte[i];
        }

        /* JADX INFO: renamed from: a */
        public void m3780a(byte[] bArr, int i, int i2) {
            if (this.f8775b) {
                int i3 = i2 - i;
                byte[] bArr2 = this.f8779f;
                int length = bArr2.length;
                int i4 = this.f8777d;
                if (length < i4 + i3) {
                    this.f8779f = Arrays.copyOf(bArr2, (i4 + i3) * 2);
                }
                System.arraycopy(bArr, i, this.f8779f, this.f8777d, i3);
                this.f8777d += i3;
            }
        }

        /* JADX INFO: renamed from: b */
        public void m3781b() {
            this.f8775b = false;
            this.f8777d = 0;
            this.f8776c = 0;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.x2.k0.q$b */
    /* JADX INFO: compiled from: H263Reader.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final TrackOutput2 f8780a;

        /* JADX INFO: renamed from: b */
        public boolean f8781b;

        /* JADX INFO: renamed from: c */
        public boolean f8782c;

        /* JADX INFO: renamed from: d */
        public boolean f8783d;

        /* JADX INFO: renamed from: e */
        public int f8784e;

        /* JADX INFO: renamed from: f */
        public int f8785f;

        /* JADX INFO: renamed from: g */
        public long f8786g;

        /* JADX INFO: renamed from: h */
        public long f8787h;

        public b(TrackOutput2 trackOutput2) {
            this.f8780a = trackOutput2;
        }

        /* JADX INFO: renamed from: a */
        public void m3782a(byte[] bArr, int i, int i2) {
            if (this.f8782c) {
                int i3 = this.f8785f;
                int i4 = (i + 1) - i3;
                if (i4 >= i2) {
                    this.f8785f = (i2 - i) + i3;
                } else {
                    this.f8783d = ((bArr[i4] & 192) >> 6) == 0;
                    this.f8782c = false;
                }
            }
        }
    }

    public H263Reader(@Nullable UserDataReader userDataReader) {
        this.f8763b = userDataReader;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x022d  */
    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo3758b(ParsableByteArray parsableByteArray) {
        int i;
        int i2;
        int i3;
        boolean z2;
        float f;
        AnimatableValueParser.m438H(this.f8768g);
        AnimatableValueParser.m438H(this.f8771j);
        int i4 = parsableByteArray.f6794b;
        int i5 = parsableByteArray.f6795c;
        byte[] bArr = parsableByteArray.f6793a;
        this.f8769h += (long) parsableByteArray.m3081a();
        this.f8771j.mo2524c(parsableByteArray, parsableByteArray.m3081a());
        while (true) {
            int iM3055b = NalUnitUtil.m3055b(bArr, i4, i5, this.f8765d);
            if (iM3055b == i5) {
                if (!this.f8772k) {
                    this.f8766e.m3780a(bArr, i4, i5);
                }
                this.f8768g.m3782a(bArr, i4, i5);
                NalUnitTargetBuffer nalUnitTargetBuffer = this.f8767f;
                if (nalUnitTargetBuffer != null) {
                    nalUnitTargetBuffer.m3788a(bArr, i4, i5);
                    return;
                }
                return;
            }
            int i6 = iM3055b + 3;
            int i7 = parsableByteArray.f6793a[i6] & 255;
            int i8 = iM3055b - i4;
            if (this.f8772k) {
                i = i5;
                i2 = i6;
            } else {
                if (i8 > 0) {
                    this.f8766e.m3780a(bArr, i4, iM3055b);
                }
                int i9 = i8 < 0 ? -i8 : 0;
                a aVar = this.f8766e;
                int i10 = aVar.f8776c;
                if (i10 != 0) {
                    if (i10 != 1) {
                        if (i10 != 2) {
                            if (i10 != 3) {
                                if (i10 != 4) {
                                    throw new IllegalStateException();
                                }
                                if (i7 == 179 || i7 == 181) {
                                    aVar.f8777d -= i9;
                                    aVar.f8775b = false;
                                    z2 = true;
                                }
                                if (!z2) {
                                    TrackOutput2 trackOutput2 = this.f8771j;
                                    a aVar2 = this.f8766e;
                                    int i11 = aVar2.f8778e;
                                    String str = this.f8770i;
                                    Objects.requireNonNull(str);
                                    byte[] bArrCopyOf = Arrays.copyOf(aVar2.f8779f, aVar2.f8777d);
                                    ParsableBitArray parsableBitArray = new ParsableBitArray(bArrCopyOf);
                                    parsableBitArray.m3074n(i11);
                                    parsableBitArray.m3074n(4);
                                    parsableBitArray.m3072l();
                                    parsableBitArray.m3073m(8);
                                    if (parsableBitArray.m3066f()) {
                                        parsableBitArray.m3073m(4);
                                        parsableBitArray.m3073m(3);
                                    }
                                    int iM3067g = parsableBitArray.m3067g(4);
                                    i2 = i6;
                                    if (iM3067g == 15) {
                                        int iM3067g2 = parsableBitArray.m3067g(8);
                                        int iM3067g3 = parsableBitArray.m3067g(8);
                                        if (iM3067g3 == 0) {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            i = i5;
                                            f = 1.0f;
                                            if (parsableBitArray.m3066f()) {
                                                parsableBitArray.m3073m(2);
                                                parsableBitArray.m3073m(1);
                                                if (parsableBitArray.m3066f()) {
                                                    parsableBitArray.m3073m(15);
                                                    parsableBitArray.m3072l();
                                                    parsableBitArray.m3073m(15);
                                                    parsableBitArray.m3072l();
                                                    parsableBitArray.m3073m(15);
                                                    parsableBitArray.m3072l();
                                                    parsableBitArray.m3073m(3);
                                                    parsableBitArray.m3073m(11);
                                                    parsableBitArray.m3072l();
                                                    parsableBitArray.m3073m(15);
                                                    parsableBitArray.m3072l();
                                                }
                                            }
                                            if (parsableBitArray.m3067g(2) != 0) {
                                                Log.w("H263Reader", "Unhandled video object layer shape");
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g4 = parsableBitArray.m3067g(16);
                                            parsableBitArray.m3072l();
                                            if (parsableBitArray.m3066f()) {
                                                if (iM3067g4 == 0) {
                                                    Log.w("H263Reader", "Invalid vop_increment_time_resolution");
                                                } else {
                                                    int i12 = 0;
                                                    for (int i13 = iM3067g4 - 1; i13 > 0; i13 >>= 1) {
                                                        i12++;
                                                    }
                                                    parsableBitArray.m3073m(i12);
                                                }
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g5 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            int iM3067g6 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            parsableBitArray.m3072l();
                                            Format2.b bVar = new Format2.b();
                                            bVar.f7163a = str;
                                            bVar.f7173k = "video/mp4v-es";
                                            bVar.f7178p = iM3067g5;
                                            bVar.f7179q = iM3067g6;
                                            bVar.f7182t = f;
                                            bVar.f7175m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.mo2526e(bVar.m3277a());
                                            this.f8772k = true;
                                        } else {
                                            f = iM3067g2 / iM3067g3;
                                            i = i5;
                                            if (parsableBitArray.m3066f()) {
                                            }
                                            if (parsableBitArray.m3067g(2) != 0) {
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g42 = parsableBitArray.m3067g(16);
                                            parsableBitArray.m3072l();
                                            if (parsableBitArray.m3066f()) {
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g52 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            int iM3067g62 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            parsableBitArray.m3072l();
                                            Format2.b bVar2 = new Format2.b();
                                            bVar2.f7163a = str;
                                            bVar2.f7173k = "video/mp4v-es";
                                            bVar2.f7178p = iM3067g52;
                                            bVar2.f7179q = iM3067g62;
                                            bVar2.f7182t = f;
                                            bVar2.f7175m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.mo2526e(bVar2.m3277a());
                                            this.f8772k = true;
                                        }
                                    } else {
                                        float[] fArr = f8762a;
                                        i = i5;
                                        if (iM3067g < fArr.length) {
                                            f = fArr[iM3067g];
                                            if (parsableBitArray.m3066f()) {
                                            }
                                            if (parsableBitArray.m3067g(2) != 0) {
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g422 = parsableBitArray.m3067g(16);
                                            parsableBitArray.m3072l();
                                            if (parsableBitArray.m3066f()) {
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g522 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            int iM3067g622 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            parsableBitArray.m3072l();
                                            Format2.b bVar22 = new Format2.b();
                                            bVar22.f7163a = str;
                                            bVar22.f7173k = "video/mp4v-es";
                                            bVar22.f7178p = iM3067g522;
                                            bVar22.f7179q = iM3067g622;
                                            bVar22.f7182t = f;
                                            bVar22.f7175m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.mo2526e(bVar22.m3277a());
                                            this.f8772k = true;
                                        } else {
                                            Log.w("H263Reader", "Invalid aspect ratio");
                                            f = 1.0f;
                                            if (parsableBitArray.m3066f()) {
                                            }
                                            if (parsableBitArray.m3067g(2) != 0) {
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g4222 = parsableBitArray.m3067g(16);
                                            parsableBitArray.m3072l();
                                            if (parsableBitArray.m3066f()) {
                                            }
                                            parsableBitArray.m3072l();
                                            int iM3067g5222 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            int iM3067g6222 = parsableBitArray.m3067g(13);
                                            parsableBitArray.m3072l();
                                            parsableBitArray.m3072l();
                                            Format2.b bVar222 = new Format2.b();
                                            bVar222.f7163a = str;
                                            bVar222.f7173k = "video/mp4v-es";
                                            bVar222.f7178p = iM3067g5222;
                                            bVar222.f7179q = iM3067g6222;
                                            bVar222.f7182t = f;
                                            bVar222.f7175m = Collections.singletonList(bArrCopyOf);
                                            trackOutput2.mo2526e(bVar222.m3277a());
                                            this.f8772k = true;
                                        }
                                    }
                                }
                            } else if ((i7 & 240) != 32) {
                                Log.w("H263Reader", "Unexpected start code value");
                                aVar.m3781b();
                            } else {
                                aVar.f8778e = aVar.f8777d;
                                aVar.f8776c = 4;
                            }
                        } else if (i7 > 31) {
                            Log.w("H263Reader", "Unexpected start code value");
                            aVar.m3781b();
                        } else {
                            aVar.f8776c = 3;
                        }
                    } else if (i7 != 181) {
                        Log.w("H263Reader", "Unexpected start code value");
                        aVar.m3781b();
                    } else {
                        aVar.f8776c = 2;
                    }
                } else if (i7 == 176) {
                    aVar.f8776c = 1;
                    aVar.f8775b = true;
                }
                byte[] bArr2 = a.f8774a;
                aVar.m3780a(bArr2, 0, bArr2.length);
                z2 = false;
                if (!z2) {
                }
            }
            this.f8768g.m3782a(bArr, i4, iM3055b);
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.f8767f;
            if (nalUnitTargetBuffer2 != null) {
                if (i8 > 0) {
                    nalUnitTargetBuffer2.m3788a(bArr, i4, iM3055b);
                    i3 = 0;
                } else {
                    i3 = -i8;
                }
                if (this.f8767f.m3789b(i3)) {
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.f8767f;
                    int iM3059f = NalUnitUtil.m3059f(nalUnitTargetBuffer3.f8906d, nalUnitTargetBuffer3.f8907e);
                    ParsableByteArray parsableByteArray2 = this.f8764c;
                    int i14 = Util2.f6708a;
                    parsableByteArray2.m3077C(this.f8767f.f8906d, iM3059f);
                    this.f8763b.m3769a(this.f8773l, this.f8764c);
                }
                if (i7 == 178) {
                    if (parsableByteArray.f6793a[iM3055b + 2] == 1) {
                        this.f8767f.m3791d(i7);
                    }
                }
            }
            int i15 = i - iM3055b;
            long j = this.f8769h - ((long) i15);
            b bVar3 = this.f8768g;
            boolean z3 = this.f8772k;
            if (bVar3.f8784e == 182 && z3 && bVar3.f8781b) {
                long j2 = bVar3.f8787h;
                if (j2 != -9223372036854775807L) {
                    bVar3.f8780a.mo2525d(j2, bVar3.f8783d ? 1 : 0, (int) (j - bVar3.f8786g), i15, null);
                }
            }
            if (bVar3.f8784e != 179) {
                bVar3.f8786g = j;
            }
            b bVar4 = this.f8768g;
            long j3 = this.f8773l;
            bVar4.f8784e = i7;
            bVar4.f8783d = false;
            bVar4.f8781b = i7 == 182 || i7 == 179;
            bVar4.f8782c = i7 == 182;
            bVar4.f8785f = 0;
            bVar4.f8787h = j3;
            i5 = i;
            i4 = i2;
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: c */
    public void mo3759c() {
        NalUnitUtil.m3054a(this.f8765d);
        this.f8766e.m3781b();
        b bVar = this.f8768g;
        if (bVar != null) {
            bVar.f8781b = false;
            bVar.f8782c = false;
            bVar.f8783d = false;
            bVar.f8784e = -1;
        }
        NalUnitTargetBuffer nalUnitTargetBuffer = this.f8767f;
        if (nalUnitTargetBuffer != null) {
            nalUnitTargetBuffer.m3790c();
        }
        this.f8769h = 0L;
        this.f8773l = -9223372036854775807L;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: d */
    public void mo3760d() {
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: e */
    public void mo3761e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.m3765a();
        this.f8770i = dVar.m3766b();
        TrackOutput2 trackOutput2Mo2492p = extractorOutput.mo2492p(dVar.m3767c(), 2);
        this.f8771j = trackOutput2Mo2492p;
        this.f8768g = new b(trackOutput2Mo2492p);
        UserDataReader userDataReader = this.f8763b;
        if (userDataReader != null) {
            userDataReader.m3770b(extractorOutput, dVar);
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p276k0.ElementaryStreamReader
    /* JADX INFO: renamed from: f */
    public void mo3762f(long j, int i) {
        if (j != -9223372036854775807L) {
            this.f8773l = j;
        }
    }
}
