package p007b.p225i.p226a.p242c.p267x2.p269d0;

import com.discord.api.permission.Permission;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker;
import p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.FlacFrameReader;
import p007b.p225i.p226a.p242c.p267x2.FlacStreamMetadata;

/* compiled from: FlacBinarySearchSeeker.java */
/* renamed from: b.i.a.c.x2.d0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class FlacBinarySearchSeeker extends BinarySearchSeeker {

    /* compiled from: FlacBinarySearchSeeker.java */
    /* renamed from: b.i.a.c.x2.d0.c$b */
    public static final class b implements BinarySearchSeeker.f {

        /* renamed from: a */
        public final FlacStreamMetadata f8097a;

        /* renamed from: b */
        public final int f8098b;

        /* renamed from: c */
        public final FlacFrameReader.a f8099c = new FlacFrameReader.a();

        public b(FlacStreamMetadata flacStreamMetadata, int i, a aVar) {
            this.f8097a = flacStreamMetadata;
            this.f8098b = i;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.f
        /* renamed from: a */
        public /* synthetic */ void mo3627a() {
            BinarySearchSeeker2.m3629a(this);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.f
        /* renamed from: b */
        public BinarySearchSeeker.e mo3628b(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            long jM3640c = m3640c(extractorInput);
            long jMo3645f = extractorInput.mo3645f();
            extractorInput.mo3646g(Math.max(6, this.f8097a.f8972c));
            long jM3640c2 = m3640c(extractorInput);
            return (jM3640c > j || jM3640c2 <= j) ? jM3640c2 <= j ? BinarySearchSeeker.e.m3626c(jM3640c2, extractorInput.mo3645f()) : BinarySearchSeeker.e.m3624a(jM3640c, position) : BinarySearchSeeker.e.m3625b(jMo3645f);
        }

        /* renamed from: c */
        public final long m3640c(ExtractorInput extractorInput) throws IOException {
            while (extractorInput.mo3645f() < extractorInput.mo3642b() - 6) {
                FlacStreamMetadata flacStreamMetadata = this.f8097a;
                int i = this.f8098b;
                FlacFrameReader.a aVar = this.f8099c;
                long jMo3645f = extractorInput.mo3645f();
                byte[] bArr = new byte[2];
                boolean zM3803b = false;
                extractorInput.mo3652o(bArr, 0, 2);
                if ((((bArr[0] & 255) << 8) | (bArr[1] & 255)) != i) {
                    extractorInput.mo3649k();
                    extractorInput.mo3646g((int) (jMo3645f - extractorInput.getPosition()));
                } else {
                    ParsableByteArray parsableByteArray = new ParsableByteArray(16);
                    System.arraycopy(bArr, 0, parsableByteArray.f6793a, 0, 2);
                    parsableByteArray.m3078D(AnimatableValueParser.m597z1(extractorInput, parsableByteArray.f6793a, 2, 14));
                    extractorInput.mo3649k();
                    extractorInput.mo3646g((int) (jMo3645f - extractorInput.getPosition()));
                    zM3803b = FlacFrameReader.m3803b(parsableByteArray, flacStreamMetadata, i, aVar);
                }
                if (zM3803b) {
                    break;
                }
                extractorInput.mo3646g(1);
            }
            if (extractorInput.mo3645f() < extractorInput.mo3642b() - 6) {
                return this.f8099c.f8967a;
            }
            extractorInput.mo3646g((int) (extractorInput.mo3642b() - extractorInput.mo3645f()));
            return this.f8097a.f8979j;
        }
    }

    public FlacBinarySearchSeeker(FlacStreamMetadata flacStreamMetadata, int i, long j, long j2) {
        long j3;
        long j4;
        Objects.requireNonNull(flacStreamMetadata);
        C3008b c3008b = new C3008b(flacStreamMetadata);
        b bVar = new b(flacStreamMetadata, i, null);
        long jM3810d = flacStreamMetadata.m3810d();
        long j5 = flacStreamMetadata.f8979j;
        int i2 = flacStreamMetadata.f8973d;
        if (i2 > 0) {
            j3 = (i2 + flacStreamMetadata.f8972c) / 2;
            j4 = 1;
        } else {
            int i3 = flacStreamMetadata.f8970a;
            j3 = ((((i3 != flacStreamMetadata.f8971b || i3 <= 0) ? Permission.SEND_TTS_MESSAGES : i3) * flacStreamMetadata.f8976g) * flacStreamMetadata.f8977h) / 8;
            j4 = 64;
        }
        super(c3008b, bVar, jM3810d, 0L, j5, j, j2, j3 + j4, Math.max(6, flacStreamMetadata.f8972c));
    }
}
