package p007b.p225i.p226a.p242c.p260g3;

import androidx.annotation.Nullable;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* compiled from: DolbyVisionConfig.java */
/* renamed from: b.i.a.c.g3.o, reason: use source file name */
/* loaded from: classes3.dex */
public final class DolbyVisionConfig {

    /* renamed from: a */
    public final String f6849a;

    public DolbyVisionConfig(int i, int i2, String str) {
        this.f6849a = str;
    }

    @Nullable
    /* renamed from: a */
    public static DolbyVisionConfig m3126a(ParsableByteArray parsableByteArray) {
        String str;
        parsableByteArray.m3080F(2);
        int iM3100t = parsableByteArray.m3100t();
        int i = iM3100t >> 1;
        int iM3100t2 = ((parsableByteArray.m3100t() >> 3) & 31) | ((iM3100t & 1) << 5);
        if (i == 4 || i == 5 || i == 7) {
            str = "dvhe";
        } else if (i == 8) {
            str = "hev1";
        } else {
            if (i != 9) {
                return null;
            }
            str = "avc3";
        }
        String str2 = iM3100t2 < 10 ? ".0" : ".";
        StringBuilder sb = new StringBuilder(str2.length() + str.length() + 24);
        sb.append(str);
        sb.append(".0");
        sb.append(i);
        sb.append(str2);
        sb.append(iM3100t2);
        return new DolbyVisionConfig(i, iM3100t2, sb.toString());
    }
}
