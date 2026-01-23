package p007b.p225i.p226a.p242c.p267x2.p275j0;

import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.ParserException;
import java.io.IOException;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.Format2;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.Extractor;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.ExtractorOutput;
import p007b.p225i.p226a.p242c.p267x2.PositionHolder;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.TrackOutput2;
import p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader;

/* JADX INFO: renamed from: b.i.a.c.x2.j0.d, reason: use source file name */
/* JADX INFO: compiled from: OggExtractor.java */
/* JADX INFO: loaded from: classes3.dex */
public class OggExtractor implements Extractor {

    /* JADX INFO: renamed from: a */
    public ExtractorOutput f8522a;

    /* JADX INFO: renamed from: b */
    public StreamReader f8523b;

    /* JADX INFO: renamed from: c */
    public boolean f8524c;

    static {
        C3059a c3059a = C3059a.f8502a;
    }

    @EnsuresNonNullIf(expression = {"streamReader"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    /* JADX INFO: renamed from: a */
    public final boolean m3740a(ExtractorInput extractorInput) throws IOException {
        boolean zM550n2;
        boolean zEquals;
        OggPageHeader oggPageHeader = new OggPageHeader();
        if (oggPageHeader.m3743a(extractorInput, true) && (oggPageHeader.f8531b & 2) == 2) {
            int iMin = Math.min(oggPageHeader.f8535f, 8);
            ParsableByteArray parsableByteArray = new ParsableByteArray(iMin);
            extractorInput.mo3652o(parsableByteArray.f6793a, 0, iMin);
            parsableByteArray.m3079E(0);
            if (parsableByteArray.m3081a() >= 5 && parsableByteArray.m3100t() == 127 && parsableByteArray.m3101u() == 1179402563) {
                this.f8523b = new FlacReader();
            } else {
                parsableByteArray.m3079E(0);
                try {
                    zM550n2 = AnimatableValueParser.m550n2(1, parsableByteArray, true);
                } catch (ParserException unused) {
                    zM550n2 = false;
                }
                if (zM550n2) {
                    this.f8523b = new VorbisReader();
                } else {
                    parsableByteArray.m3079E(0);
                    int iM3081a = parsableByteArray.m3081a();
                    byte[] bArr = OpusReader.f8538n;
                    if (iM3081a < bArr.length) {
                        zEquals = false;
                    } else {
                        byte[] bArr2 = new byte[bArr.length];
                        int length = bArr.length;
                        System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr2, 0, length);
                        parsableByteArray.f6794b += length;
                        zEquals = Arrays.equals(bArr2, bArr);
                    }
                    if (zEquals) {
                        this.f8523b = new OpusReader();
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: b */
    public boolean mo3633b(ExtractorInput extractorInput) throws IOException {
        try {
            return m3740a(extractorInput);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x0180  */
    /* JADX WARN: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int mo3635e(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        boolean z2;
        int i;
        byte[] bArr;
        AnimatableValueParser.m438H(this.f8522a);
        if (this.f8523b == null) {
            if (!m3740a(extractorInput)) {
                throw ParserException.m8755a("Failed to determine bitstream type", null);
            }
            extractorInput.mo3649k();
        }
        if (!this.f8524c) {
            TrackOutput2 trackOutput2Mo2492p = this.f8522a.mo2492p(0, 1);
            this.f8522a.mo2486j();
            StreamReader streamReader = this.f8523b;
            streamReader.f8542c = this.f8522a;
            streamReader.f8541b = trackOutput2Mo2492p;
            streamReader.mo3739e(true);
            this.f8524c = true;
        }
        StreamReader streamReader2 = this.f8523b;
        AnimatableValueParser.m438H(streamReader2.f8541b);
        int i2 = Util2.f6708a;
        int i3 = streamReader2.f8547h;
        int i4 = 3;
        if (i3 == 0) {
            while (true) {
                if (!streamReader2.f8540a.m3742b(extractorInput)) {
                    streamReader2.f8547h = i4;
                    z2 = false;
                    break;
                }
                long position = extractorInput.getPosition();
                long j = streamReader2.f8545f;
                streamReader2.f8550k = position - j;
                if (!streamReader2.mo3738d(streamReader2.f8540a.f8526b, j, streamReader2.f8549j)) {
                    z2 = true;
                    break;
                }
                streamReader2.f8545f = extractorInput.getPosition();
                i4 = 3;
            }
            if (z2) {
                Format2 format2 = streamReader2.f8549j.f8553a;
                streamReader2.f8548i = format2.f7137K;
                if (!streamReader2.f8552m) {
                    streamReader2.f8541b.mo2526e(format2);
                    streamReader2.f8552m = true;
                }
                OggSeeker oggSeeker = streamReader2.f8549j.f8554b;
                if (oggSeeker != null) {
                    streamReader2.f8543d = oggSeeker;
                } else {
                    if (extractorInput.mo3642b() != -1) {
                        OggPageHeader oggPageHeader = streamReader2.f8540a.f8525a;
                        i = 2;
                        streamReader2.f8543d = new DefaultOggSeeker(streamReader2, streamReader2.f8545f, extractorInput.mo3642b(), oggPageHeader.f8534e + oggPageHeader.f8535f, oggPageHeader.f8532c, (oggPageHeader.f8531b & 4) != 0);
                        streamReader2.f8547h = i;
                        OggPacket oggPacket = streamReader2.f8540a;
                        ParsableByteArray parsableByteArray = oggPacket.f8526b;
                        bArr = parsableByteArray.f6793a;
                        if (bArr.length != 65025) {
                            return 0;
                        }
                        parsableByteArray.m3077C(Arrays.copyOf(bArr, Math.max(65025, parsableByteArray.f6795c)), oggPacket.f8526b.f6795c);
                        return 0;
                    }
                    streamReader2.f8543d = new StreamReader.c(null);
                }
                i = 2;
                streamReader2.f8547h = i;
                OggPacket oggPacket2 = streamReader2.f8540a;
                ParsableByteArray parsableByteArray2 = oggPacket2.f8526b;
                bArr = parsableByteArray2.f6793a;
                if (bArr.length != 65025) {
                }
            }
        } else {
            if (i3 == 1) {
                extractorInput.mo3650l((int) streamReader2.f8545f);
                streamReader2.f8547h = 2;
                return 0;
            }
            if (i3 == 2) {
                long jMo3735b = streamReader2.f8543d.mo3735b(extractorInput);
                if (jMo3735b >= 0) {
                    positionHolder.f8992a = jMo3735b;
                    return 1;
                }
                if (jMo3735b < -1) {
                    streamReader2.mo3747b(-(jMo3735b + 2));
                }
                if (!streamReader2.f8551l) {
                    SeekMap seekMapMo3734a = streamReader2.f8543d.mo3734a();
                    AnimatableValueParser.m438H(seekMapMo3734a);
                    streamReader2.f8542c.mo2477a(seekMapMo3734a);
                    streamReader2.f8551l = true;
                }
                if (streamReader2.f8550k > 0 || streamReader2.f8540a.m3742b(extractorInput)) {
                    streamReader2.f8550k = 0L;
                    ParsableByteArray parsableByteArray3 = streamReader2.f8540a.f8526b;
                    long jMo3737c = streamReader2.mo3737c(parsableByteArray3);
                    if (jMo3737c >= 0) {
                        long j2 = streamReader2.f8546g;
                        if (j2 + jMo3737c >= streamReader2.f8544e) {
                            long j3 = (j2 * 1000000) / ((long) streamReader2.f8548i);
                            streamReader2.f8541b.mo2524c(parsableByteArray3, parsableByteArray3.f6795c);
                            streamReader2.f8541b.mo2525d(j3, 1, parsableByteArray3.f6795c, 0, null);
                            streamReader2.f8544e = -1L;
                        }
                    }
                    streamReader2.f8546g += jMo3737c;
                    return 0;
                }
                streamReader2.f8547h = 3;
            } else if (i3 != 3) {
                throw new IllegalStateException();
            }
        }
        return -1;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: f */
    public void mo3636f(ExtractorOutput extractorOutput) {
        this.f8522a = extractorOutput;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    /* JADX INFO: renamed from: g */
    public void mo3637g(long j, long j2) {
        StreamReader streamReader = this.f8523b;
        if (streamReader != null) {
            OggPacket oggPacket = streamReader.f8540a;
            oggPacket.f8525a.m3744b();
            oggPacket.f8526b.m3075A(0);
            oggPacket.f8527c = -1;
            oggPacket.f8529e = false;
            if (j == 0) {
                streamReader.mo3739e(!streamReader.f8551l);
                return;
            }
            if (streamReader.f8547h != 0) {
                long j3 = (((long) streamReader.f8548i) * j2) / 1000000;
                streamReader.f8544e = j3;
                OggSeeker oggSeeker = streamReader.f8543d;
                int i = Util2.f6708a;
                oggSeeker.mo3736c(j3);
                streamReader.f8547h = 2;
            }
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.Extractor
    public void release() {
    }
}
