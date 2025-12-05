package p007b.p225i.p226a.p242c.p267x2.p276k0;

import java.io.IOException;
import org.objectweb.asm.Opcodes;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;
import p007b.p225i.p226a.p242c.p259f3.TimestampAdjuster;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker;
import p007b.p225i.p226a.p242c.p267x2.ExtractorInput;

/* compiled from: TsBinarySearchSeeker.java */
/* renamed from: b.i.a.c.x2.k0.f0, reason: use source file name */
/* loaded from: classes3.dex */
public final class TsBinarySearchSeeker extends BinarySearchSeeker {

    /* compiled from: TsBinarySearchSeeker.java */
    /* renamed from: b.i.a.c.x2.k0.f0$a */
    public static final class a implements BinarySearchSeeker.f {

        /* renamed from: a */
        public final TimestampAdjuster f8607a;

        /* renamed from: b */
        public final ParsableByteArray f8608b = new ParsableByteArray();

        /* renamed from: c */
        public final int f8609c;

        /* renamed from: d */
        public final int f8610d;

        public a(int i, TimestampAdjuster timestampAdjuster, int i2) {
            this.f8609c = i;
            this.f8607a = timestampAdjuster;
            this.f8610d = i2;
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.f
        /* renamed from: a */
        public void mo3627a() {
            this.f8608b.m3076B(Util2.f6713f);
        }

        @Override // p007b.p225i.p226a.p242c.p267x2.BinarySearchSeeker.f
        /* renamed from: b */
        public BinarySearchSeeker.e mo3628b(ExtractorInput extractorInput, long j) throws IOException {
            long position = extractorInput.getPosition();
            int iMin = (int) Math.min(this.f8610d, extractorInput.mo3642b() - position);
            this.f8608b.m3075A(iMin);
            extractorInput.mo3652o(this.f8608b.f6793a, 0, iMin);
            ParsableByteArray parsableByteArray = this.f8608b;
            int i = parsableByteArray.f6795c;
            long j2 = -1;
            long j3 = -1;
            long j4 = -9223372036854775807L;
            while (parsableByteArray.m3081a() >= 188) {
                byte[] bArr = parsableByteArray.f6793a;
                int i2 = parsableByteArray.f6794b;
                while (i2 < i && bArr[i2] != 71) {
                    i2++;
                }
                int i3 = i2 + Opcodes.NEWARRAY;
                if (i3 > i) {
                    break;
                }
                long jM449K1 = AnimatableValueParser.m449K1(parsableByteArray, i2, this.f8609c);
                if (jM449K1 != -9223372036854775807L) {
                    long jM2973b = this.f8607a.m2973b(jM449K1);
                    if (jM2973b > j) {
                        return j4 == -9223372036854775807L ? BinarySearchSeeker.e.m3624a(jM2973b, position) : BinarySearchSeeker.e.m3625b(position + j3);
                    }
                    if (100000 + jM2973b > j) {
                        return BinarySearchSeeker.e.m3625b(position + i2);
                    }
                    j4 = jM2973b;
                    j3 = i2;
                }
                parsableByteArray.m3079E(i3);
                j2 = i3;
            }
            return j4 != -9223372036854775807L ? BinarySearchSeeker.e.m3626c(j4, position + j2) : BinarySearchSeeker.e.f8049a;
        }
    }

    public TsBinarySearchSeeker(TimestampAdjuster timestampAdjuster, long j, long j2, int i, int i2) {
        super(new BinarySearchSeeker.b(), new a(i, timestampAdjuster, i2), j, 0L, j + 1, 0L, j2, 188L, 940);
    }
}
