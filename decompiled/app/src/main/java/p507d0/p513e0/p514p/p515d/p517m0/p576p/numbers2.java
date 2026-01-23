package p507d0.p513e0.p514p.p515d.p517m0.p576p;

import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.p.g, reason: use source file name */
/* JADX INFO: compiled from: numbers.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class numbers2 {
    public static final numbers extractRadix(String str) {
        Intrinsics3.checkNotNullParameter(str, "value");
        if (StringsJVM.startsWith$default(str, "0x", false, 2, null) || StringsJVM.startsWith$default(str, "0X", false, 2, null)) {
            String strSubstring = str.substring(2);
            Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
            return new numbers(strSubstring, 16);
        }
        if (!StringsJVM.startsWith$default(str, "0b", false, 2, null) && !StringsJVM.startsWith$default(str, "0B", false, 2, null)) {
            return new numbers(str, 10);
        }
        String strSubstring2 = str.substring(2);
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return new numbers(strSubstring2, 2);
    }
}
