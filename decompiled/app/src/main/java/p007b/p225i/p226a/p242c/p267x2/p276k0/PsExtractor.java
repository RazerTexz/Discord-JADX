package p007b.p225i.p226a.p242c.p267x2.p276k0;

import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.discord.api.permission.Permission;
import java.io.IOException;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.p276k0.TsPayloadReader;

/* compiled from: PsExtractor.java */
/* renamed from: b.i.a.c.x2.k0.b0, reason: use source file name */
/* loaded from: classes3.dex */
public final class PsExtractor implements Extractor {

    /* renamed from: e */
    public boolean f8578e;

    /* renamed from: f */
    public boolean f8579f;

    /* renamed from: g */
    public boolean f8580g;

    /* renamed from: h */
    public long f8581h;

    /* renamed from: i */
    @Nullable
    public PsBinarySearchSeeker f8582i;

    /* renamed from: j */
    public ExtractorOutput f8583j;

    /* renamed from: k */
    public boolean f8584k;

    /* renamed from: a */
    public final TimestampAdjuster f8574a = new TimestampAdjuster(0);

    /* renamed from: c */
    public final ParsableByteArray f8576c = new ParsableByteArray(4096);

    /* renamed from: b */
    public final SparseArray<a> f8575b = new SparseArray<>();

    /* renamed from: d */
    public final PsDurationReader f8577d = new PsDurationReader();

    /* compiled from: PsExtractor.java */
    /* renamed from: b.i.a.c.x2.k0.b0$a */
    public static final class a {

        /* renamed from: a */
        public final ElementaryStreamReader f8585a;

        /* renamed from: b */
        public final TimestampAdjuster f8586b;

        /* renamed from: c */
        public final ParsableBitArray f8587c = new ParsableBitArray(new byte[64]);

        /* renamed from: d */
        public boolean f8588d;

        /* renamed from: e */
        public boolean f8589e;

        /* renamed from: f */
        public boolean f8590f;

        /* renamed from: g */
        public int f8591g;

        /* renamed from: h */
        public long f8592h;

        public a(ElementaryStreamReader elementaryStreamReader, TimestampAdjuster timestampAdjuster) {
            this.f8585a = elementaryStreamReader;
            this.f8586b = timestampAdjuster;
        }
    }

    static {
        C3076d c3076d = C3076d.f8594a;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        byte[] bArr = new byte[14];
        extractorInput.mo3652o(bArr, 0, 14);
        if (442 != (((bArr[0] & 255) << 24) | ((bArr[1] & 255) << 16) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        extractorInput.mo3646g(bArr[13] & 7);
        extractorInput.mo3652o(bArr, 0, 3);
        return 1 == ((((bArr[0] & 255) << 16) | ((bArr[1] & 255) << 8)) | (bArr[2] & 255));
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x021d  */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int i;
        ElementaryStreamReader h262Reader;
        AnimatableValueParser.m438H(this.f8583j);
        long jMo3642b = extractorInput.mo3642b();
        int i2 = 1;
        long j = -9223372036854775807L;
        if (jMo3642b != -1) {
            PsDurationReader psDurationReader = this.f8577d;
            if (!psDurationReader.f8567c) {
                if (!psDurationReader.f8569e) {
                    long jMo3642b2 = extractorInput.mo3642b();
                    int iMin = (int) Math.min(20000L, jMo3642b2);
                    long j2 = jMo3642b2 - iMin;
                    if (extractorInput.getPosition() != j2) {
                        positionHolder.f8992a = j2;
                    } else {
                        psDurationReader.f8566b.m3075A(iMin);
                        extractorInput.mo3649k();
                        extractorInput.mo3652o(psDurationReader.f8566b.f6793a, 0, iMin);
                        ParsableByteArray parsableByteArray = psDurationReader.f8566b;
                        int i3 = parsableByteArray.f6794b;
                        int i4 = parsableByteArray.f6795c - 4;
                        while (true) {
                            if (i4 < i3) {
                                break;
                            }
                            if (psDurationReader.m3751b(parsableByteArray.f6793a, i4) == 442) {
                                parsableByteArray.m3079E(i4 + 4);
                                long jM3749c = PsDurationReader.m3749c(parsableByteArray);
                                if (jM3749c != -9223372036854775807L) {
                                    j = jM3749c;
                                    break;
                                }
                            }
                            i4--;
                        }
                        psDurationReader.f8571g = j;
                        psDurationReader.f8569e = true;
                        i2 = 0;
                    }
                } else {
                    if (psDurationReader.f8571g == -9223372036854775807L) {
                        psDurationReader.m3750a(extractorInput);
                        return 0;
                    }
                    if (psDurationReader.f8568d) {
                        long j3 = psDurationReader.f8570f;
                        if (j3 == -9223372036854775807L) {
                            psDurationReader.m3750a(extractorInput);
                            return 0;
                        }
                        long jM2973b = psDurationReader.f8565a.m2973b(psDurationReader.f8571g) - psDurationReader.f8565a.m2973b(j3);
                        psDurationReader.f8572h = jM2973b;
                        if (jM2973b < 0) {
                            Log.w("PsDurationReader", outline.m855i(65, "Invalid duration: ", jM2973b, ". Using TIME_UNSET instead."));
                            psDurationReader.f8572h = -9223372036854775807L;
                        }
                        psDurationReader.m3750a(extractorInput);
                        return 0;
                    }
                    int iMin2 = (int) Math.min(20000L, extractorInput.mo3642b());
                    long j4 = 0;
                    if (extractorInput.getPosition() != j4) {
                        positionHolder.f8992a = j4;
                    } else {
                        psDurationReader.f8566b.m3075A(iMin2);
                        extractorInput.mo3649k();
                        extractorInput.mo3652o(psDurationReader.f8566b.f6793a, 0, iMin2);
                        ParsableByteArray parsableByteArray2 = psDurationReader.f8566b;
                        int i5 = parsableByteArray2.f6794b;
                        int i6 = parsableByteArray2.f6795c;
                        while (true) {
                            if (i5 >= i6 - 3) {
                                break;
                            }
                            if (psDurationReader.m3751b(parsableByteArray2.f6793a, i5) == 442) {
                                parsableByteArray2.m3079E(i5 + 4);
                                long jM3749c2 = PsDurationReader.m3749c(parsableByteArray2);
                                if (jM3749c2 != -9223372036854775807L) {
                                    j = jM3749c2;
                                    break;
                                }
                            }
                            i5++;
                        }
                        psDurationReader.f8570f = j;
                        psDurationReader.f8568d = true;
                        i2 = 0;
                    }
                }
                return i2;
            }
        }
        if (this.f8584k) {
            i = 442;
        } else {
            this.f8584k = true;
            PsDurationReader psDurationReader2 = this.f8577d;
            long j5 = psDurationReader2.f8572h;
            if (j5 != -9223372036854775807L) {
                PsBinarySearchSeeker psBinarySearchSeeker = new PsBinarySearchSeeker(psDurationReader2.f8565a, j5, jMo3642b);
                this.f8582i = psBinarySearchSeeker;
                this.f8583j.mo2477a(psBinarySearchSeeker.f8030a);
                i = 442;
            } else {
                i = 442;
                this.f8583j.mo2477a(new SeekMap.b(j5, 0L));
            }
        }
        PsBinarySearchSeeker psBinarySearchSeeker2 = this.f8582i;
        if (psBinarySearchSeeker2 != null && psBinarySearchSeeker2.m3614b()) {
            return this.f8582i.m3613a(extractorInput, positionHolder);
        }
        extractorInput.mo3649k();
        long jMo3645f = jMo3642b != -1 ? jMo3642b - extractorInput.mo3645f() : -1L;
        if ((jMo3645f != -1 && jMo3645f < 4) || !extractorInput.mo3644e(this.f8576c.f6793a, 0, 4, true)) {
            return -1;
        }
        this.f8576c.m3079E(0);
        int iM3086f = this.f8576c.m3086f();
        if (iM3086f == 441) {
            return -1;
        }
        if (iM3086f == i) {
            extractorInput.mo3652o(this.f8576c.f6793a, 0, 10);
            this.f8576c.m3079E(9);
            extractorInput.mo3650l((this.f8576c.m3100t() & 7) + 14);
            return 0;
        }
        if (iM3086f == 443) {
            extractorInput.mo3652o(this.f8576c.f6793a, 0, 2);
            this.f8576c.m3079E(0);
            extractorInput.mo3650l(this.f8576c.m3105y() + 6);
            return 0;
        }
        if (((iM3086f & InputDeviceCompat.SOURCE_ANY) >> 8) != 1) {
            extractorInput.mo3650l(1);
            return 0;
        }
        int i7 = iM3086f & 255;
        a aVar = this.f8575b.get(i7);
        if (!this.f8578e) {
            if (aVar == null) {
                ElementaryStreamReader elementaryStreamReader = null;
                if (i7 == 189) {
                    h262Reader = new Ac3Reader(null);
                    this.f8579f = true;
                    this.f8581h = extractorInput.getPosition();
                } else if ((i7 & 224) == 192) {
                    h262Reader = new MpegAudioReader(null);
                    this.f8579f = true;
                    this.f8581h = extractorInput.getPosition();
                } else {
                    if ((i7 & 240) == 224) {
                        h262Reader = new H262Reader(null);
                        this.f8580g = true;
                        this.f8581h = extractorInput.getPosition();
                    }
                    if (elementaryStreamReader != null) {
                        elementaryStreamReader.mo3761e(this.f8583j, new TsPayloadReader.d(Integer.MIN_VALUE, i7, 256));
                        aVar = new a(elementaryStreamReader, this.f8574a);
                        this.f8575b.put(i7, aVar);
                    }
                }
                elementaryStreamReader = h262Reader;
                if (elementaryStreamReader != null) {
                }
            }
            if (extractorInput.getPosition() > ((this.f8579f && this.f8580g) ? this.f8581h + Permission.MANAGE_MESSAGES : Permission.CONNECT)) {
                this.f8578e = true;
                this.f8583j.mo2486j();
            }
        }
        extractorInput.mo3652o(this.f8576c.f6793a, 0, 2);
        this.f8576c.m3079E(0);
        int iM3105y = this.f8576c.m3105y() + 6;
        if (aVar == null) {
            extractorInput.mo3650l(iM3105y);
            return 0;
        }
        this.f8576c.m3075A(iM3105y);
        extractorInput.readFully(this.f8576c.f6793a, 0, iM3105y);
        this.f8576c.m3079E(6);
        ParsableByteArray parsableByteArray3 = this.f8576c;
        parsableByteArray3.m3085e(aVar.f8587c.f6789a, 0, 3);
        aVar.f8587c.m3071k(0);
        aVar.f8587c.m3073m(8);
        aVar.f8588d = aVar.f8587c.m3066f();
        aVar.f8589e = aVar.f8587c.m3066f();
        aVar.f8587c.m3073m(6);
        int iM3067g = aVar.f8587c.m3067g(8);
        aVar.f8591g = iM3067g;
        parsableByteArray3.m3085e(aVar.f8587c.f6789a, 0, iM3067g);
        aVar.f8587c.m3071k(0);
        aVar.f8592h = 0L;
        if (aVar.f8588d) {
            aVar.f8587c.m3073m(4);
            aVar.f8587c.m3073m(1);
            aVar.f8587c.m3073m(1);
            long jM3067g = (aVar.f8587c.m3067g(3) << 30) | (aVar.f8587c.m3067g(15) << 15) | aVar.f8587c.m3067g(15);
            aVar.f8587c.m3073m(1);
            if (!aVar.f8590f && aVar.f8589e) {
                aVar.f8587c.m3073m(4);
                aVar.f8587c.m3073m(1);
                aVar.f8587c.m3073m(1);
                aVar.f8587c.m3073m(1);
                aVar.f8586b.m2973b(aVar.f8587c.m3067g(15) | (aVar.f8587c.m3067g(3) << 30) | (aVar.f8587c.m3067g(15) << 15));
                aVar.f8590f = true;
            }
            aVar.f8592h = aVar.f8586b.m2973b(jM3067g);
        }
        aVar.f8585a.mo3762f(aVar.f8592h, 4);
        aVar.f8585a.mo3758b(parsableByteArray3);
        aVar.f8585a.mo3760d();
        ParsableByteArray parsableByteArray4 = this.f8576c;
        parsableByteArray4.m3078D(parsableByteArray4.f6793a.length);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8583j = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* renamed from: g */
    public void mo3637g(long j, long j2) {
        boolean z2 = this.f8574a.m2975d() == -9223372036854775807L;
        if (!z2) {
            long jM2974c = this.f8574a.m2974c();
            z2 = (jM2974c == -9223372036854775807L || jM2974c == 0 || jM2974c == j2) ? false : true;
        }
        if (z2) {
            this.f8574a.m2976e(j2);
        }
        PsBinarySearchSeeker psBinarySearchSeeker = this.f8582i;
        if (psBinarySearchSeeker != null) {
            psBinarySearchSeeker.m3617e(j2);
        }
        for (int i = 0; i < this.f8575b.size(); i++) {
            a aVarValueAt = this.f8575b.valueAt(i);
            aVarValueAt.f8590f = false;
            aVarValueAt.f8585a.mo3759c();
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
