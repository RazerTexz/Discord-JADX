package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import java.util.ArrayList;
import java.util.List;
import p007b.p225i.p226a.p242c.p259f3.CodecSpecificDataUtil;
import p007b.p225i.p226a.p242c.p259f3.NalUnitUtil;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* compiled from: AvcConfig.java */
/* renamed from: b.i.a.c.g3.m, reason: use source file name */
/* loaded from: classes3.dex */
public final class AvcConfig {

    /* renamed from: a */
    public final List<byte[]> f6837a;

    /* renamed from: b */
    public final int f6838b;

    /* renamed from: c */
    public final int f6839c;

    /* renamed from: d */
    public final int f6840d;

    /* renamed from: e */
    public final float f6841e;

    /* renamed from: f */
    @Nullable
    public final String f6842f;

    public AvcConfig(List<byte[]> list, int i, int i2, int i3, float f, @Nullable String str) {
        this.f6837a = list;
        this.f6838b = i;
        this.f6839c = i2;
        this.f6840d = i3;
        this.f6841e = f;
        this.f6842f = str;
    }

    /* renamed from: a */
    public static byte[] m3121a(ParsableByteArray parsableByteArray) {
        int iM3105y = parsableByteArray.m3105y();
        int i = parsableByteArray.f6794b;
        parsableByteArray.m3080F(iM3105y);
        byte[] bArr = parsableByteArray.f6793a;
        byte[] bArr2 = CodecSpecificDataUtil.f6721a;
        byte[] bArr3 = new byte[bArr2.length + iM3105y];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, iM3105y);
        return bArr3;
    }

    /* renamed from: b */
    public static AvcConfig m3122b(ParsableByteArray parsableByteArray) throws ParserException {
        String strM3022a;
        int i;
        int i2;
        float f;
        try {
            parsableByteArray.m3080F(4);
            int iM3100t = (parsableByteArray.m3100t() & 3) + 1;
            if (iM3100t == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int iM3100t2 = parsableByteArray.m3100t() & 31;
            for (int i3 = 0; i3 < iM3100t2; i3++) {
                arrayList.add(m3121a(parsableByteArray));
            }
            int iM3100t3 = parsableByteArray.m3100t();
            for (int i4 = 0; i4 < iM3100t3; i4++) {
                arrayList.add(m3121a(parsableByteArray));
            }
            if (iM3100t2 > 0) {
                NalUnitUtil.c cVarM3058e = NalUnitUtil.m3058e((byte[]) arrayList.get(0), iM3100t, ((byte[]) arrayList.get(0)).length);
                int i5 = cVarM3058e.f6773e;
                int i6 = cVarM3058e.f6774f;
                float f2 = cVarM3058e.f6775g;
                strM3022a = CodecSpecificDataUtil.m3022a(cVarM3058e.f6769a, cVarM3058e.f6770b, cVarM3058e.f6771c);
                i = i5;
                i2 = i6;
                f = f2;
            } else {
                strM3022a = null;
                i = -1;
                i2 = -1;
                f = 1.0f;
            }
            return new AvcConfig(arrayList, iM3100t, i, i2, f, strM3022a);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.m8755a("Error parsing AVC config", e);
        }
    }
}
