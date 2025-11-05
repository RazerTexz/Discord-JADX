package f0;

import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;

/* compiled from: CacheControl.kt */
/* loaded from: classes3.dex */
public final class d {
    public static final a a = new a(null);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3604b;
    public final boolean c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public String n;

    /* compiled from: CacheControl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final int a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (d0.g0.w.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0104  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0108  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final d b(Headers headers) {
            int i;
            int i2;
            boolean z2;
            int i3;
            String string;
            Headers headers2 = headers;
            d0.z.d.m.checkParameterIsNotNull(headers2, "headers");
            int size = headers.size();
            boolean z3 = true;
            int i4 = 0;
            boolean z4 = true;
            String str = null;
            boolean z5 = false;
            boolean z6 = false;
            int iB = -1;
            int iB2 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int iB3 = -1;
            int iB4 = -1;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            while (i4 < size) {
                String strD = headers2.d(i4);
                String strG = headers2.g(i4);
                if (d0.g0.t.equals(strD, "Cache-Control", z3)) {
                    if (str == null) {
                        str = strG;
                    }
                    i2 = 0;
                    while (i2 < strG.length()) {
                        int iA = a(strG, "=,;", i2);
                        String strSubstring = strG.substring(i2, iA);
                        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring == null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        String string2 = d0.g0.w.trim(strSubstring).toString();
                        int i5 = size;
                        if (iA != strG.length()) {
                            z2 = z4;
                            if (strG.charAt(iA) != ',' && strG.charAt(iA) != ';') {
                                int length = iA + 1;
                                byte[] bArr = f0.e0.c.a;
                                d0.z.d.m.checkParameterIsNotNull(strG, "$this$indexOfNonWhitespace");
                                int length2 = strG.length();
                                while (true) {
                                    if (length >= length2) {
                                        length = strG.length();
                                        break;
                                    }
                                    char cCharAt = strG.charAt(length);
                                    int i6 = length2;
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length++;
                                    length2 = i6;
                                }
                                if (length >= strG.length() || strG.charAt(length) != '\"') {
                                    int iA2 = a(strG, ",;", length);
                                    String strSubstring2 = strG.substring(length, iA2);
                                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string = d0.g0.w.trim(strSubstring2).toString();
                                    i3 = iA2;
                                } else {
                                    int i7 = length + 1;
                                    int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) strG, '\"', i7, false, 4, (Object) null);
                                    string = strG.substring(i7, iIndexOf$default);
                                    d0.z.d.m.checkExpressionValueIsNotNull(string, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    i3 = iIndexOf$default + 1;
                                }
                            }
                            z3 = true;
                            if (!d0.g0.t.equals("no-cache", string2, true)) {
                                z5 = true;
                            } else if (d0.g0.t.equals("no-store", string2, true)) {
                                z6 = true;
                            } else if (d0.g0.t.equals("max-age", string2, true)) {
                                iB = f0.e0.c.B(string, -1);
                            } else if (d0.g0.t.equals("s-maxage", string2, true)) {
                                iB2 = f0.e0.c.B(string, -1);
                            } else if (d0.g0.t.equals("private", string2, true)) {
                                z7 = true;
                            } else if (d0.g0.t.equals("public", string2, true)) {
                                z8 = true;
                            } else if (d0.g0.t.equals("must-revalidate", string2, true)) {
                                z9 = true;
                            } else if (d0.g0.t.equals("max-stale", string2, true)) {
                                iB3 = f0.e0.c.B(string, Integer.MAX_VALUE);
                            } else if (d0.g0.t.equals("min-fresh", string2, true)) {
                                iB4 = f0.e0.c.B(string, -1);
                            } else if (d0.g0.t.equals("only-if-cached", string2, true)) {
                                z10 = true;
                            } else if (d0.g0.t.equals("no-transform", string2, true)) {
                                z11 = true;
                            } else if (d0.g0.t.equals("immutable", string2, true)) {
                                z12 = true;
                            }
                            i2 = i3;
                            size = i5;
                            z4 = z2;
                        } else {
                            z2 = z4;
                        }
                        i3 = iA + 1;
                        string = null;
                        z3 = true;
                        if (!d0.g0.t.equals("no-cache", string2, true)) {
                        }
                        i2 = i3;
                        size = i5;
                        z4 = z2;
                    }
                    i = size;
                    i4++;
                    headers2 = headers;
                    size = i;
                } else if (!d0.g0.t.equals(strD, "Pragma", z3)) {
                    i = size;
                    i4++;
                    headers2 = headers;
                    size = i;
                }
                z4 = false;
                i2 = 0;
                while (i2 < strG.length()) {
                }
                i = size;
                i4++;
                headers2 = headers;
                size = i;
            }
            return new d(z5, z6, iB, iB2, z7, z8, z9, iB3, iB4, z10, z11, z12, !z4 ? null : str, null);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        d0.z.d.m.checkParameterIsNotNull(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public d(boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, int i4, boolean z7, boolean z8, boolean z9, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3604b = z2;
        this.c = z3;
        this.d = i;
        this.e = i2;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = i3;
        this.j = i4;
        this.k = z7;
        this.l = z8;
        this.m = z9;
        this.n = str;
    }

    public String toString() {
        String str = this.n;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3604b) {
            sb.append("no-cache, ");
        }
        if (this.c) {
            sb.append("no-store, ");
        }
        if (this.d != -1) {
            sb.append("max-age=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e != -1) {
            sb.append("s-maxage=");
            sb.append(this.e);
            sb.append(", ");
        }
        if (this.f) {
            sb.append("private, ");
        }
        if (this.g) {
            sb.append("public, ");
        }
        if (this.h) {
            sb.append("must-revalidate, ");
        }
        if (this.i != -1) {
            sb.append("max-stale=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j != -1) {
            sb.append("min-fresh=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k) {
            sb.append("only-if-cached, ");
        }
        if (this.l) {
            sb.append("no-transform, ");
        }
        if (this.m) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        d0.z.d.m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        this.n = string;
        return string;
    }
}
