package p600f0;

import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;

/* JADX INFO: renamed from: f0.d, reason: use source file name */
/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheControl {

    /* JADX INFO: renamed from: a */
    public static final a f25373a = new a(null);

    /* JADX INFO: renamed from: b */
    public final boolean f25374b;

    /* JADX INFO: renamed from: c */
    public final boolean f25375c;

    /* JADX INFO: renamed from: d */
    public final int f25376d;

    /* JADX INFO: renamed from: e */
    public final int f25377e;

    /* JADX INFO: renamed from: f */
    public final boolean f25378f;

    /* JADX INFO: renamed from: g */
    public final boolean f25379g;

    /* JADX INFO: renamed from: h */
    public final boolean f25380h;

    /* JADX INFO: renamed from: i */
    public final int f25381i;

    /* JADX INFO: renamed from: j */
    public final int f25382j;

    /* JADX INFO: renamed from: k */
    public final boolean f25383k;

    /* JADX INFO: renamed from: l */
    public final boolean f25384l;

    /* JADX INFO: renamed from: m */
    public final boolean f25385m;

    /* JADX INFO: renamed from: n */
    public String f25386n;

    /* JADX INFO: renamed from: f0.d$a */
    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final int m10107a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (Strings4.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
        /* JADX INFO: renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final CacheControl m10108b(Headers headers) {
            int i;
            int i2;
            boolean z2;
            int i3;
            String string;
            Headers headers2 = headers;
            Intrinsics3.checkParameterIsNotNull(headers2, "headers");
            int size = headers.size();
            boolean z3 = true;
            int i4 = 0;
            boolean z4 = true;
            String str = null;
            boolean z5 = false;
            boolean z6 = false;
            int iM10117B = -1;
            int iM10117B2 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int iM10117B3 = -1;
            int iM10117B4 = -1;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            while (i4 < size) {
                String strM10955d = headers2.m10955d(i4);
                String strM10957g = headers2.m10957g(i4);
                if (StringsJVM.equals(strM10955d, "Cache-Control", z3)) {
                    if (str == null) {
                        str = strM10957g;
                    }
                    i2 = 0;
                    while (i2 < strM10957g.length()) {
                        int iM10107a = m10107a(strM10957g, "=,;", i2);
                        String strSubstring = strM10957g.substring(i2, iM10107a);
                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        String string2 = Strings4.trim(strSubstring).toString();
                        int i5 = size;
                        if (iM10107a != strM10957g.length()) {
                            z2 = z4;
                            if (strM10957g.charAt(iM10107a) != ',' && strM10957g.charAt(iM10107a) != ';') {
                                int length = iM10107a + 1;
                                byte[] bArr = Util7.f25397a;
                                Intrinsics3.checkParameterIsNotNull(strM10957g, "$this$indexOfNonWhitespace");
                                int length2 = strM10957g.length();
                                while (true) {
                                    if (length >= length2) {
                                        length = strM10957g.length();
                                        break;
                                    }
                                    char cCharAt = strM10957g.charAt(length);
                                    int i6 = length2;
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length++;
                                    length2 = i6;
                                }
                                if (length >= strM10957g.length() || strM10957g.charAt(length) != '\"') {
                                    int iM10107a2 = m10107a(strM10957g, ",;", length);
                                    String strSubstring2 = strM10957g.substring(length, iM10107a2);
                                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string = Strings4.trim(strSubstring2).toString();
                                    i3 = iM10107a2;
                                } else {
                                    int i7 = length + 1;
                                    int iIndexOf$default = Strings4.indexOf$default((CharSequence) strM10957g, '\"', i7, false, 4, (Object) null);
                                    string = strM10957g.substring(i7, iIndexOf$default);
                                    Intrinsics3.checkExpressionValueIsNotNull(string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    i3 = iIndexOf$default + 1;
                                }
                            }
                            z3 = true;
                            if (!StringsJVM.equals("no-cache", string2, true)) {
                                z5 = true;
                            } else if (StringsJVM.equals("no-store", string2, true)) {
                                z6 = true;
                            } else if (StringsJVM.equals("max-age", string2, true)) {
                                iM10117B = Util7.m10117B(string, -1);
                            } else if (StringsJVM.equals("s-maxage", string2, true)) {
                                iM10117B2 = Util7.m10117B(string, -1);
                            } else if (StringsJVM.equals("private", string2, true)) {
                                z7 = true;
                            } else if (StringsJVM.equals("public", string2, true)) {
                                z8 = true;
                            } else if (StringsJVM.equals("must-revalidate", string2, true)) {
                                z9 = true;
                            } else if (StringsJVM.equals("max-stale", string2, true)) {
                                iM10117B3 = Util7.m10117B(string, Integer.MAX_VALUE);
                            } else if (StringsJVM.equals("min-fresh", string2, true)) {
                                iM10117B4 = Util7.m10117B(string, -1);
                            } else if (StringsJVM.equals("only-if-cached", string2, true)) {
                                z10 = true;
                            } else if (StringsJVM.equals("no-transform", string2, true)) {
                                z11 = true;
                            } else if (StringsJVM.equals("immutable", string2, true)) {
                                z12 = true;
                            }
                            i2 = i3;
                            size = i5;
                            z4 = z2;
                        } else {
                            z2 = z4;
                        }
                        i3 = iM10107a + 1;
                        string = null;
                        z3 = true;
                        if (!StringsJVM.equals("no-cache", string2, true)) {
                        }
                        i2 = i3;
                        size = i5;
                        z4 = z2;
                    }
                    i = size;
                    i4++;
                    headers2 = headers;
                    size = i;
                } else if (!StringsJVM.equals(strM10955d, "Pragma", z3)) {
                    i = size;
                    i4++;
                    headers2 = headers;
                    size = i;
                }
                z4 = false;
                i2 = 0;
                while (i2 < strM10957g.length()) {
                }
                i = size;
                i4++;
                headers2 = headers;
                size = i;
            }
            return new CacheControl(z5, z6, iM10117B, iM10117B2, z7, z8, z9, iM10117B3, iM10117B4, z10, z11, z12, !z4 ? null : str, null);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public CacheControl(boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, int i4, boolean z7, boolean z8, boolean z9, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f25374b = z2;
        this.f25375c = z3;
        this.f25376d = i;
        this.f25377e = i2;
        this.f25378f = z4;
        this.f25379g = z5;
        this.f25380h = z6;
        this.f25381i = i3;
        this.f25382j = i4;
        this.f25383k = z7;
        this.f25384l = z8;
        this.f25385m = z9;
        this.f25386n = str;
    }

    public String toString() {
        String str = this.f25386n;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f25374b) {
            sb.append("no-cache, ");
        }
        if (this.f25375c) {
            sb.append("no-store, ");
        }
        if (this.f25376d != -1) {
            sb.append("max-age=");
            sb.append(this.f25376d);
            sb.append(", ");
        }
        if (this.f25377e != -1) {
            sb.append("s-maxage=");
            sb.append(this.f25377e);
            sb.append(", ");
        }
        if (this.f25378f) {
            sb.append("private, ");
        }
        if (this.f25379g) {
            sb.append("public, ");
        }
        if (this.f25380h) {
            sb.append("must-revalidate, ");
        }
        if (this.f25381i != -1) {
            sb.append("max-stale=");
            sb.append(this.f25381i);
            sb.append(", ");
        }
        if (this.f25382j != -1) {
            sb.append("min-fresh=");
            sb.append(this.f25382j);
            sb.append(", ");
        }
        if (this.f25383k) {
            sb.append("only-if-cached, ");
        }
        if (this.f25384l) {
            sb.append("no-transform, ");
        }
        if (this.f25385m) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        this.f25386n = string;
        return string;
    }
}
