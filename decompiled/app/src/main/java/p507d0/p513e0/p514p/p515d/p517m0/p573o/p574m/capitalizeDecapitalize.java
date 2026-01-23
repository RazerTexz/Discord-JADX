package p507d0.p513e0.p514p.p515d.p517m0.p573o.p574m;

import java.util.Iterator;
import java.util.Objects;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.o.m.a, reason: use source file name */
/* JADX INFO: compiled from: capitalizeDecapitalize.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class capitalizeDecapitalize {
    /* JADX INFO: renamed from: a */
    public static final boolean m10040a(String str, int i, boolean z2) {
        char cCharAt = str.charAt(i);
        return z2 ? 'A' <= cCharAt && cCharAt <= 'Z' : Character.isUpperCase(cCharAt);
    }

    /* JADX INFO: renamed from: b */
    public static final String m10041b(String str, boolean z2) {
        if (z2) {
            return toLowerCaseAsciiOnly(str);
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = str.toLowerCase();
        Intrinsics3.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
        return lowerCase;
    }

    public static final String capitalizeAsciiOnly(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        boolean z2 = false;
        if (str.length() == 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if ('a' <= cCharAt && cCharAt <= 'z') {
            z2 = true;
        }
        if (!z2) {
            return str;
        }
        char upperCase = Character.toUpperCase(cCharAt);
        String strSubstring = str.substring(1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(upperCase) + strSubstring;
    }

    public static final String decapitalizeAsciiOnly(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        boolean z2 = false;
        if (str.length() == 0) {
            return str;
        }
        char cCharAt = str.charAt(0);
        if ('A' <= cCharAt && cCharAt <= 'Z') {
            z2 = true;
        }
        if (!z2) {
            return str;
        }
        char lowerCase = Character.toLowerCase(cCharAt);
        String strSubstring = str.substring(1);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
        return String.valueOf(lowerCase) + strSubstring;
    }

    public static final String decapitalizeSmartForCompiler(String str, boolean z2) {
        Integer next;
        Intrinsics3.checkNotNullParameter(str, "<this>");
        if ((str.length() == 0) || !m10040a(str, 0, z2)) {
            return str;
        }
        if (str.length() == 1 || !m10040a(str, 1, z2)) {
            return z2 ? decapitalizeAsciiOnly(str) : StringsJVM.decapitalize(str);
        }
        Iterator<Integer> it = Strings4.getIndices(str).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (!m10040a(str, next.intValue(), z2)) {
                break;
            }
        }
        Integer num = next;
        if (num == null) {
            return m10041b(str, z2);
        }
        int iIntValue = num.intValue() - 1;
        String strSubstring = str.substring(0, iIntValue);
        Intrinsics3.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        String strM10041b = m10041b(strSubstring, z2);
        String strSubstring2 = str.substring(iIntValue);
        Intrinsics3.checkNotNullExpressionValue(strSubstring2, "(this as java.lang.String).substring(startIndex)");
        return Intrinsics3.stringPlus(strM10041b, strSubstring2);
    }

    public static final String toLowerCaseAsciiOnly(String str) {
        Intrinsics3.checkNotNullParameter(str, "<this>");
        StringBuilder sb = new StringBuilder(str.length());
        int length = str.length();
        int i = 0;
        while (i < length) {
            char cCharAt = str.charAt(i);
            i++;
            if ('A' <= cCharAt && cCharAt <= 'Z') {
                cCharAt = Character.toLowerCase(cCharAt);
            }
            sb.append(cCharAt);
        }
        String string = sb.toString();
        Intrinsics3.checkNotNullExpressionValue(string, "builder.toString()");
        return string;
    }
}
