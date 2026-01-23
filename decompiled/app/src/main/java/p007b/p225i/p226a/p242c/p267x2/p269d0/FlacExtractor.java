package p007b.p225i.p226a.p242c.p267x2.p269d0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableBitArray;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.FlacFrameReader;
import p007b.p225i.p226a.p242c.p267x2.FlacSeekTableSeekMap;
import p007b.p225i.p226a.p242c.p267x2.FlacStreamMetadata;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p355b.p356a.Charsets;

/* JADX INFO: renamed from: b.i.a.c.x2.d0.d, reason: use source file name */
/* JADX INFO: compiled from: FlacExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacExtractor implements Extractor {

    /* JADX INFO: renamed from: a */
    public final byte[] f8100a = new byte[42];

    /* JADX INFO: renamed from: b */
    public final ParsableByteArray f8101b = new ParsableByteArray(new byte[32768], 0);

    /* JADX INFO: renamed from: c */
    public final boolean f8102c;

    /* JADX INFO: renamed from: d */
    public final FlacFrameReader.a f8103d;

    /* JADX INFO: renamed from: e */
    public ExtractorOutput f8104e;

    /* JADX INFO: renamed from: f */
    public TrackOutput2 f8105f;

    /* JADX INFO: renamed from: g */
    public int f8106g;

    /* JADX INFO: renamed from: h */
    @Nullable
    public Metadata f8107h;

    /* JADX INFO: renamed from: i */
    public FlacStreamMetadata f8108i;

    /* JADX INFO: renamed from: j */
    public int f8109j;

    /* JADX INFO: renamed from: k */
    public int f8110k;

    /* JADX INFO: renamed from: l */
    public FlacBinarySearchSeeker f8111l;

    /* JADX INFO: renamed from: m */
    public int f8112m;

    /* JADX INFO: renamed from: n */
    public long f8113n;

    static {
        C3007a c3007a = C3007a.f8095a;
    }

    public FlacExtractor(int i) {
        this.f8102c = (i & 1) != 0;
        this.f8103d = new FlacFrameReader.a();
        this.f8106g = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m3641a() {
        long j = this.f8113n * 1000000;
        FlacStreamMetadata flacStreamMetadata = this.f8108i;
        int i = Util2.f6708a;
        this.f8105f.mo2525d(j / ((long) flacStreamMetadata.f8974e), 1, this.f8112m, 0, null);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        AnimatableValueParser.m593y1(extractorInput, false);
        byte[] bArr = new byte[4];
        extractorInput.mo3652o(bArr, 0, 4);
        return (((((((long) bArr[0]) & 255) << 24) | ((((long) bArr[1]) & 255) << 16)) | ((((long) bArr[2]) & 255) << 8)) | (255 & ((long) bArr[3]))) == 1716281667;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v8, types: [boolean, int] */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        FlacStreamMetadata flacStreamMetadata;
        SeekMap bVar;
        long j;
        boolean zM3803b;
        int i = this.f8106g;
        ?? r4 = 0;
        if (i == 0) {
            boolean z3 = !this.f8102c;
            extractorInput.mo3649k();
            long jMo3645f = extractorInput.mo3645f();
            Metadata metadataM593y1 = AnimatableValueParser.m593y1(extractorInput, z3);
            extractorInput.mo3650l((int) (extractorInput.mo3645f() - jMo3645f));
            this.f8107h = metadataM593y1;
            this.f8106g = 1;
            return 0;
        }
        if (i == 1) {
            byte[] bArr = this.f8100a;
            extractorInput.mo3652o(bArr, 0, bArr.length);
            extractorInput.mo3649k();
            this.f8106g = 2;
            return 0;
        }
        int i2 = 4;
        int i3 = 3;
        if (i == 2) {
            byte[] bArr2 = new byte[4];
            extractorInput.readFully(bArr2, 0, 4);
            if ((((((long) bArr2[0]) & 255) << 24) | ((((long) bArr2[1]) & 255) << 16) | ((((long) bArr2[2]) & 255) << 8) | (((long) bArr2[3]) & 255)) != 1716281667) {
                throw ParserException.m8755a("Failed to read FLAC stream marker.", null);
            }
            this.f8106g = 3;
            return 0;
        }
        if (i == 3) {
            FlacStreamMetadata flacStreamMetadataM3809b = this.f8108i;
            boolean z4 = false;
            while (!z4) {
                extractorInput.mo3649k();
                ParsableBitArray parsableBitArray = new ParsableBitArray(new byte[i2]);
                extractorInput.mo3652o(parsableBitArray.f6789a, r4, i2);
                boolean zM3066f = parsableBitArray.m3066f();
                int iM3067g = parsableBitArray.m3067g(i);
                int iM3067g2 = parsableBitArray.m3067g(24) + i2;
                if (iM3067g == 0) {
                    byte[] bArr3 = new byte[38];
                    extractorInput.readFully(bArr3, r4, 38);
                    flacStreamMetadataM3809b = new FlacStreamMetadata(bArr3, i2);
                } else {
                    if (flacStreamMetadataM3809b == null) {
                        throw new IllegalArgumentException();
                    }
                    if (iM3067g == i3) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray(iM3067g2);
                        extractorInput.readFully(parsableByteArray.f6793a, r4, iM3067g2);
                        flacStreamMetadataM3809b = flacStreamMetadataM3809b.m3809b(AnimatableValueParser.m452L1(parsableByteArray));
                    } else {
                        if (iM3067g == i2) {
                            ParsableByteArray parsableByteArray2 = new ParsableByteArray(iM3067g2);
                            extractorInput.readFully(parsableByteArray2.f6793a, r4, iM3067g2);
                            parsableByteArray2.m3080F(i2);
                            z2 = zM3066f;
                            flacStreamMetadata = new FlacStreamMetadata(flacStreamMetadataM3809b.f8970a, flacStreamMetadataM3809b.f8971b, flacStreamMetadataM3809b.f8972c, flacStreamMetadataM3809b.f8973d, flacStreamMetadataM3809b.f8974e, flacStreamMetadataM3809b.f8976g, flacStreamMetadataM3809b.f8977h, flacStreamMetadataM3809b.f8979j, flacStreamMetadataM3809b.f8980k, flacStreamMetadataM3809b.m3812f(FlacStreamMetadata.m3806a(Arrays.asList(AnimatableValueParser.m458N1(parsableByteArray2, r4, r4).f9015a), Collections.emptyList())));
                        } else {
                            z2 = zM3066f;
                            if (iM3067g == 6) {
                                ParsableByteArray parsableByteArray3 = new ParsableByteArray(iM3067g2);
                                extractorInput.readFully(parsableByteArray3.f6793a, 0, iM3067g2);
                                parsableByteArray3.m3080F(i2);
                                int iM3086f = parsableByteArray3.m3086f();
                                String strM3098r = parsableByteArray3.m3098r(parsableByteArray3.m3086f(), Charsets.f11943a);
                                String strM3097q = parsableByteArray3.m3097q(parsableByteArray3.m3086f());
                                int iM3086f2 = parsableByteArray3.m3086f();
                                int iM3086f3 = parsableByteArray3.m3086f();
                                int iM3086f4 = parsableByteArray3.m3086f();
                                int iM3086f5 = parsableByteArray3.m3086f();
                                int iM3086f6 = parsableByteArray3.m3086f();
                                byte[] bArr4 = new byte[iM3086f6];
                                System.arraycopy(parsableByteArray3.f6793a, parsableByteArray3.f6794b, bArr4, 0, iM3086f6);
                                parsableByteArray3.f6794b += iM3086f6;
                                flacStreamMetadata = new FlacStreamMetadata(flacStreamMetadataM3809b.f8970a, flacStreamMetadataM3809b.f8971b, flacStreamMetadataM3809b.f8972c, flacStreamMetadataM3809b.f8973d, flacStreamMetadataM3809b.f8974e, flacStreamMetadataM3809b.f8976g, flacStreamMetadataM3809b.f8977h, flacStreamMetadataM3809b.f8979j, flacStreamMetadataM3809b.f8980k, flacStreamMetadataM3809b.m3812f(FlacStreamMetadata.m3806a(Collections.emptyList(), Collections.singletonList(new PictureFrame(iM3086f, strM3098r, strM3097q, iM3086f2, iM3086f3, iM3086f4, iM3086f5, bArr4)))));
                            } else {
                                extractorInput.mo3650l(iM3067g2);
                                int i4 = Util2.f6708a;
                                this.f8108i = flacStreamMetadataM3809b;
                                z4 = z2;
                                r4 = 0;
                                i2 = 4;
                                i3 = 3;
                                i = 7;
                            }
                        }
                        flacStreamMetadataM3809b = flacStreamMetadata;
                        int i42 = Util2.f6708a;
                        this.f8108i = flacStreamMetadataM3809b;
                        z4 = z2;
                        r4 = 0;
                        i2 = 4;
                        i3 = 3;
                        i = 7;
                    }
                }
                z2 = zM3066f;
                int i422 = Util2.f6708a;
                this.f8108i = flacStreamMetadataM3809b;
                z4 = z2;
                r4 = 0;
                i2 = 4;
                i3 = 3;
                i = 7;
            }
            Objects.requireNonNull(this.f8108i);
            this.f8109j = Math.max(this.f8108i.f8972c, 6);
            TrackOutput2 trackOutput2 = this.f8105f;
            int i5 = Util2.f6708a;
            trackOutput2.mo2526e(this.f8108i.m3811e(this.f8100a, this.f8107h));
            this.f8106g = 4;
            return 0;
        }
        long j2 = 0;
        if (i == 4) {
            extractorInput.mo3649k();
            byte[] bArr5 = new byte[2];
            extractorInput.mo3652o(bArr5, 0, 2);
            int i6 = (bArr5[1] & 255) | ((bArr5[0] & 255) << 8);
            if ((i6 >> 2) != 16382) {
                extractorInput.mo3649k();
                throw ParserException.m8755a("First frame does not start with sync code.", null);
            }
            extractorInput.mo3649k();
            this.f8110k = i6;
            ExtractorOutput extractorOutput = this.f8104e;
            int i7 = Util2.f6708a;
            long position = extractorInput.getPosition();
            long jMo3642b = extractorInput.mo3642b();
            Objects.requireNonNull(this.f8108i);
            FlacStreamMetadata flacStreamMetadata2 = this.f8108i;
            if (flacStreamMetadata2.f8980k != null) {
                bVar = new FlacSeekTableSeekMap(flacStreamMetadata2, position);
            } else if (jMo3642b == -1 || flacStreamMetadata2.f8979j <= 0) {
                bVar = new SeekMap.b(flacStreamMetadata2.m3810d(), 0L);
            } else {
                FlacBinarySearchSeeker flacBinarySearchSeeker = new FlacBinarySearchSeeker(flacStreamMetadata2, this.f8110k, position, jMo3642b);
                this.f8111l = flacBinarySearchSeeker;
                bVar = flacBinarySearchSeeker.f8030a;
            }
            extractorOutput.mo2477a(bVar);
            this.f8106g = 5;
            return 0;
        }
        if (i != 5) {
            throw new IllegalStateException();
        }
        Objects.requireNonNull(this.f8105f);
        Objects.requireNonNull(this.f8108i);
        FlacBinarySearchSeeker flacBinarySearchSeeker2 = this.f8111l;
        if (flacBinarySearchSeeker2 != null && flacBinarySearchSeeker2.m3614b()) {
            return this.f8111l.m3613a(extractorInput, positionHolder);
        }
        if (this.f8113n == -1) {
            FlacStreamMetadata flacStreamMetadata3 = this.f8108i;
            extractorInput.mo3649k();
            extractorInput.mo3646g(1);
            byte[] bArr6 = new byte[1];
            extractorInput.mo3652o(bArr6, 0, 1);
            boolean z5 = (bArr6[0] & 1) == 1;
            extractorInput.mo3646g(2);
            i = z5 ? 7 : 6;
            ParsableByteArray parsableByteArray4 = new ParsableByteArray(i);
            parsableByteArray4.m3078D(AnimatableValueParser.m597z1(extractorInput, parsableByteArray4.f6793a, 0, i));
            extractorInput.mo3649k();
            try {
                long jM3106z = parsableByteArray4.m3106z();
                if (!z5) {
                    jM3106z *= (long) flacStreamMetadata3.f8971b;
                }
                j2 = jM3106z;
            } catch (NumberFormatException unused) {
                z = false;
            }
            if (!z) {
                throw ParserException.m8755a(null, null);
            }
            this.f8113n = j2;
            return 0;
        }
        ParsableByteArray parsableByteArray5 = this.f8101b;
        int i8 = parsableByteArray5.f6795c;
        if (i8 < 32768) {
            int i9 = extractorInput.read(parsableByteArray5.f6793a, i8, 32768 - i8);
            z = i9 == -1;
            if (!z) {
                this.f8101b.m3078D(i8 + i9);
            } else if (this.f8101b.m3081a() == 0) {
                m3641a();
                return -1;
            }
        } else {
            z = false;
        }
        ParsableByteArray parsableByteArray6 = this.f8101b;
        int i10 = parsableByteArray6.f6794b;
        int i11 = this.f8112m;
        int i12 = this.f8109j;
        if (i11 < i12) {
            parsableByteArray6.m3080F(Math.min(i12 - i11, parsableByteArray6.m3081a()));
        }
        ParsableByteArray parsableByteArray7 = this.f8101b;
        Objects.requireNonNull(this.f8108i);
        int i13 = parsableByteArray7.f6794b;
        while (true) {
            if (i13 <= parsableByteArray7.f6795c - 16) {
                parsableByteArray7.m3079E(i13);
                if (FlacFrameReader.m3803b(parsableByteArray7, this.f8108i, this.f8110k, this.f8103d)) {
                    parsableByteArray7.m3079E(i13);
                    j = this.f8103d.f8967a;
                    break;
                }
                i13++;
            } else {
                if (z) {
                    while (true) {
                        int i14 = parsableByteArray7.f6795c;
                        if (i13 > i14 - this.f8109j) {
                            parsableByteArray7.m3079E(i14);
                            break;
                        }
                        parsableByteArray7.m3079E(i13);
                        try {
                            zM3803b = FlacFrameReader.m3803b(parsableByteArray7, this.f8108i, this.f8110k, this.f8103d);
                        } catch (IndexOutOfBoundsException unused2) {
                            zM3803b = false;
                        }
                        if (parsableByteArray7.f6794b > parsableByteArray7.f6795c) {
                            zM3803b = false;
                        }
                        if (zM3803b) {
                            parsableByteArray7.m3079E(i13);
                            j = this.f8103d.f8967a;
                            break;
                        }
                        i13++;
                    }
                } else {
                    parsableByteArray7.m3079E(i13);
                }
                j = -1;
            }
        }
        ParsableByteArray parsableByteArray8 = this.f8101b;
        int i15 = parsableByteArray8.f6794b - i10;
        parsableByteArray8.m3079E(i10);
        this.f8105f.mo2524c(this.f8101b, i15);
        this.f8112m += i15;
        if (j != -1) {
            m3641a();
            this.f8112m = 0;
            this.f8113n = j;
        }
        if (this.f8101b.m3081a() >= 16) {
            return 0;
        }
        int iM3081a = this.f8101b.m3081a();
        ParsableByteArray parsableByteArray9 = this.f8101b;
        byte[] bArr7 = parsableByteArray9.f6793a;
        System.arraycopy(bArr7, parsableByteArray9.f6794b, bArr7, 0, iM3081a);
        this.f8101b.m3079E(0);
        this.f8101b.m3078D(iM3081a);
        return 0;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8104e = extractorOutput;
        this.f8105f = extractorOutput.mo2492p(0, 1);
        extractorOutput.mo2486j();
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        if (j == 0) {
            this.f8106g = 0;
        } else {
            FlacBinarySearchSeeker flacBinarySearchSeeker = this.f8111l;
            if (flacBinarySearchSeeker != null) {
                flacBinarySearchSeeker.m3617e(j2);
            }
        }
        this.f8113n = j2 != 0 ? -1L : 0L;
        this.f8112m = 0;
        this.f8101b.m3075A(0);
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
