package p007b.p225i.p226a.p242c.p245b3.p254v;

import androidx.annotation.Nullable;
import java.util.regex.Pattern;
import p007b.p225i.p226a.p242c.p259f3.ParsableByteArray;

/* compiled from: WebvttCssParser.java */
/* renamed from: b.i.a.c.b3.v.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class WebvttCssParser {

    /* renamed from: a */
    public static final Pattern f6110a = Pattern.compile("\\[voice=\"([^\"]*)\"\\]");

    /* renamed from: b */
    public static final Pattern f6111b = Pattern.compile("^((?:[0-9]*\\.)?[0-9]+)(px|em|%)$");

    /* renamed from: c */
    public final ParsableByteArray f6112c = new ParsableByteArray();

    /* renamed from: d */
    public final StringBuilder f6113d = new StringBuilder();

    /* renamed from: a */
    public static String m2705a(ParsableByteArray parsableByteArray, StringBuilder sb) {
        boolean z2 = false;
        sb.setLength(0);
        int i = parsableByteArray.f6794b;
        int i2 = parsableByteArray.f6795c;
        while (i < i2 && !z2) {
            char c = (char) parsableByteArray.f6793a[i];
            if ((c < 'A' || c > 'Z') && ((c < 'a' || c > 'z') && !((c >= '0' && c <= '9') || c == '#' || c == '-' || c == '.' || c == '_'))) {
                z2 = true;
            } else {
                i++;
                sb.append(c);
            }
        }
        parsableByteArray.m3080F(i - parsableByteArray.f6794b);
        return sb.toString();
    }

    @Nullable
    /* renamed from: b */
    public static String m2706b(ParsableByteArray parsableByteArray, StringBuilder sb) {
        m2707c(parsableByteArray);
        if (parsableByteArray.m3081a() == 0) {
            return null;
        }
        String strM2705a = m2705a(parsableByteArray, sb);
        if (!"".equals(strM2705a)) {
            return strM2705a;
        }
        char cM3100t = (char) parsableByteArray.m3100t();
        StringBuilder sb2 = new StringBuilder(1);
        sb2.append(cM3100t);
        return sb2.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0064  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m2707c(ParsableByteArray parsableByteArray) {
        boolean z2;
        boolean z3;
        while (true) {
            for (boolean z4 = true; parsableByteArray.m3081a() > 0 && z4; z4 = false) {
                char c = (char) parsableByteArray.f6793a[parsableByteArray.f6794b];
                if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
                    parsableByteArray.m3080F(1);
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (!z2) {
                    int i = parsableByteArray.f6794b;
                    int i2 = parsableByteArray.f6795c;
                    byte[] bArr = parsableByteArray.f6793a;
                    if (i + 2 <= i2) {
                        int i3 = i + 1;
                        if (bArr[i] == 47) {
                            int i4 = i3 + 1;
                            if (bArr[i3] == 42) {
                                while (true) {
                                    int i5 = i4 + 1;
                                    if (i5 >= i2) {
                                        break;
                                    }
                                    if (((char) bArr[i4]) == '*' && ((char) bArr[i5]) == '/') {
                                        i2 = i5 + 1;
                                        i4 = i2;
                                    } else {
                                        i4 = i5;
                                    }
                                }
                                parsableByteArray.m3080F(i2 - parsableByteArray.f6794b);
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                break;
                            }
                        }
                    }
                }
            }
            return;
        }
    }
}
