package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.Collections;
import java.util.List;
import org.objectweb.asm.Opcodes;
import p007b.p225i.p226a.p242c.p259f3.CodecSpecificDataUtil;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* JADX INFO: renamed from: b.i.a.c.g3.q, reason: use source file name */
/* JADX INFO: compiled from: HevcConfig.java */
/* JADX INFO: loaded from: classes3.dex */
public final class HevcConfig {

    /* JADX INFO: renamed from: a */
    public final List<byte[]> f6863a;

    /* JADX INFO: renamed from: b */
    public final int f6864b;

    /* JADX INFO: renamed from: c */
    public final float f6865c;

    /* JADX INFO: renamed from: d */
    @Nullable
    public final String f6866d;

    public HevcConfig(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.f6863a = list;
        this.f6864b = i;
        this.f6865c = f;
        this.f6866d = str;
    }

    /* JADX INFO: renamed from: a */
    public static HevcConfig m3131a(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        int i2;
        try {
            parsableByteArray.m3080F(21);
            int iM3100t = parsableByteArray.m3100t() & 3;
            int iM3100t2 = parsableByteArray.m3100t();
            int i3 = parsableByteArray.f6794b;
            int i4 = 0;
            int i5 = 0;
            for (int i6 = 0; i6 < iM3100t2; i6++) {
                parsableByteArray.m3080F(1);
                int iM3105y = parsableByteArray.m3105y();
                for (int i7 = 0; i7 < iM3105y; i7++) {
                    int iM3105y2 = parsableByteArray.m3105y();
                    i5 += iM3105y2 + 4;
                    parsableByteArray.m3080F(iM3105y2);
                }
            }
            parsableByteArray.m3079E(i3);
            byte[] bArr = new byte[i5];
            String strM3023b = null;
            int i8 = 0;
            int i9 = 0;
            int i10 = -1;
            int i11 = -1;
            float f = 1.0f;
            while (i8 < iM3100t2) {
                int iM3100t3 = parsableByteArray.m3100t() & Opcodes.LAND;
                int iM3105y3 = parsableByteArray.m3105y();
                int i12 = 0;
                while (i12 < iM3105y3) {
                    int iM3105y4 = parsableByteArray.m3105y();
                    byte[] bArr2 = NalUnitUtil.f6753a;
                    int i13 = iM3100t2;
                    System.arraycopy(bArr2, i4, bArr, i9, bArr2.length);
                    int length = i9 + bArr2.length;
                    System.arraycopy(parsableByteArray.f6793a, parsableByteArray.f6794b, bArr, length, iM3105y4);
                    if (iM3100t3 == 33 && i12 == 0) {
                        NalUnitUtil.a aVarM3056c = NalUnitUtil.m3056c(bArr, length, length + iM3105y4);
                        int i14 = aVarM3056c.f6763g;
                        i11 = aVarM3056c.f6764h;
                        f = aVarM3056c.f6765i;
                        i = iM3100t3;
                        i2 = iM3105y3;
                        i10 = i14;
                        strM3023b = CodecSpecificDataUtil.m3023b(aVarM3056c.f6757a, aVarM3056c.f6758b, aVarM3056c.f6759c, aVarM3056c.f6760d, aVarM3056c.f6761e, aVarM3056c.f6762f);
                    } else {
                        i = iM3100t3;
                        i2 = iM3105y3;
                    }
                    i9 = length + iM3105y4;
                    parsableByteArray.m3080F(iM3105y4);
                    i12++;
                    iM3100t2 = i13;
                    iM3100t3 = i;
                    iM3105y3 = i2;
                    i4 = 0;
                }
                i8++;
                i4 = 0;
            }
            return new HevcConfig(i5 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), iM3100t + 1, i10, i11, f, strM3023b);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.m8755a("Error parsing HEVC config", e);
        }
    }
}
