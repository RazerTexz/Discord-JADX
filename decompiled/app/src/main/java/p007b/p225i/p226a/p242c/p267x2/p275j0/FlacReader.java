package p007b.p225i.p226a.p242c.p267x2.p275j0;

import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;
import p007b.p225i.p226a.p242c.p267x2.FlacFrameReader;
import p007b.p225i.p226a.p242c.p267x2.FlacSeekTableSeekMap;
import p007b.p225i.p226a.p242c.p267x2.FlacStreamMetadata;
import p007b.p225i.p226a.p242c.p267x2.SeekMap;
import p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader;

/* compiled from: FlacReader.java */
/* renamed from: b.i.a.c.x2.j0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class FlacReader extends StreamReader {

    /* renamed from: n */
    @Nullable
    public FlacStreamMetadata f8516n;

    /* renamed from: o */
    @Nullable
    public a f8517o;

    /* compiled from: FlacReader.java */
    /* renamed from: b.i.a.c.x2.j0.c$a */
    public static final class a implements OggSeeker {

        /* renamed from: a */
        public FlacStreamMetadata f8518a;

        /* renamed from: b */
        public FlacStreamMetadata.a f8519b;

        /* renamed from: c */
        public long f8520c = -1;

        /* renamed from: d */
        public long f8521d = -1;

        public a(FlacStreamMetadata flacStreamMetadata, FlacStreamMetadata.a aVar) {
            this.f8518a = flacStreamMetadata;
            this.f8519b = aVar;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* renamed from: a */
        public SeekMap mo3734a() {
            AnimatableValueParser.m426D(this.f8520c != -1);
            return new FlacSeekTableSeekMap(this.f8518a, this.f8520c);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* renamed from: b */
        public long mo3735b(ExtractorInput extractorInput) {
            long j = this.f8521d;
            if (j < 0) {
                return -1L;
            }
            long j2 = -(j + 2);
            this.f8521d = -1L;
            return j2;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.OggSeeker
        /* renamed from: c */
        public void mo3736c(long j) {
            long[] jArr = this.f8519b.f8982a;
            this.f8521d = jArr[Util2.m2997e(jArr, j, true, true)];
        }
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* renamed from: c */
    public long mo3737c(ParsableByteArray parsableByteArray) {
        byte[] bArr = parsableByteArray.f6793a;
        if (!(bArr[0] == -1)) {
            return -1L;
        }
        int i = (bArr[2] & 255) >> 4;
        if (i == 6 || i == 7) {
            parsableByteArray.m3080F(4);
            parsableByteArray.m3106z();
        }
        int iM3804c = FlacFrameReader.m3804c(parsableByteArray, i);
        parsableByteArray.m3079E(0);
        return iM3804c;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    /* renamed from: d */
    public boolean mo3738d(ParsableByteArray parsableByteArray, long j, StreamReader.b bVar) {
        byte[] bArr = parsableByteArray.f6793a;
        FlacStreamMetadata flacStreamMetadata = this.f8516n;
        if (flacStreamMetadata == null) {
            FlacStreamMetadata flacStreamMetadata2 = new FlacStreamMetadata(bArr, 17);
            this.f8516n = flacStreamMetadata2;
            bVar.f8553a = flacStreamMetadata2.m3811e(Arrays.copyOfRange(bArr, 9, parsableByteArray.f6795c), null);
            return true;
        }
        if ((bArr[0] & 127) == 3) {
            FlacStreamMetadata.a aVarM452L1 = AnimatableValueParser.m452L1(parsableByteArray);
            FlacStreamMetadata flacStreamMetadataM3809b = flacStreamMetadata.m3809b(aVarM452L1);
            this.f8516n = flacStreamMetadataM3809b;
            this.f8517o = new a(flacStreamMetadataM3809b, aVarM452L1);
            return true;
        }
        if (!(bArr[0] == -1)) {
            return true;
        }
        a aVar = this.f8517o;
        if (aVar != null) {
            aVar.f8520c = j;
            bVar.f8554b = aVar;
        }
        Objects.requireNonNull(bVar.f8553a);
        return false;
    }

    @Override // p007b.p225i.p226a.p242c.p267x2.p275j0.StreamReader
    /* renamed from: e */
    public void mo3739e(boolean z2) {
        super.mo3739e(z2);
        if (z2) {
            this.f8516n = null;
            this.f8517o = null;
        }
    }
}
