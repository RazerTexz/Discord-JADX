package f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.google.android.material.badge.BadgeDrawable;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntProgression;
import kotlin.text.Regex;
import org.objectweb.asm.Opcodes;

/* compiled from: HttpUrl.kt */
/* loaded from: classes3.dex */
public final class w {
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final List<String> i;
    public final List<String> j;
    public final String k;
    public final String l;

    /* renamed from: b, reason: collision with root package name */
    public static final b f3681b = new b(null);
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* compiled from: HttpUrl.kt */
    public static final class a {
        public static final C0612a a = new C0612a(null);

        /* renamed from: b, reason: collision with root package name */
        public String f3682b;
        public String e;
        public final List<String> g;
        public List<String> h;
        public String i;
        public String c = "";
        public String d = "";
        public int f = -1;

        /* compiled from: HttpUrl.kt */
        /* renamed from: f0.w$a$a, reason: collision with other inner class name */
        public static final class C0612a {
            public C0612a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.g = arrayList;
            arrayList.add("");
        }

        public final a a(String str, String str2) {
            d0.z.d.m.checkParameterIsNotNull(str, "encodedName");
            if (this.h == null) {
                this.h = new ArrayList();
            }
            List<String> list = this.h;
            if (list == null) {
                d0.z.d.m.throwNpe();
            }
            b bVar = w.f3681b;
            list.add(b.a(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
            List<String> list2 = this.h;
            if (list2 == null) {
                d0.z.d.m.throwNpe();
            }
            list2.add(str2 != null ? b.a(bVar, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211) : null);
            return this;
        }

        public final w b() {
            ArrayList arrayList;
            String str = this.f3682b;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = w.f3681b;
            String strD = b.d(bVar, this.c, 0, 0, false, 7);
            String strD2 = b.d(bVar, this.d, 0, 0, false, 7);
            String str2 = this.e;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iC = c();
            List<String> list = this.g;
            ArrayList arrayList2 = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.d(w.f3681b, (String) it.next(), 0, 0, false, 7));
            }
            List<String> list2 = this.h;
            if (list2 != null) {
                arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? b.d(w.f3681b, str3, 0, 0, true, 3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.i;
            return new w(str, strD, strD2, str2, iC, arrayList2, arrayList, str4 != null ? b.d(w.f3681b, str4, 0, 0, false, 7) : null, toString());
        }

        public final int c() {
            int i = this.f;
            if (i != -1) {
                return i;
            }
            String str = this.f3682b;
            if (str == null) {
                d0.z.d.m.throwNpe();
            }
            d0.z.d.m.checkParameterIsNotNull(str, "scheme");
            int iHashCode = str.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && str.equals(Constants.SCHEME)) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        /* JADX WARN: Removed duplicated region for block: B:6:0x001c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a d(String str) {
            List<String> listE;
            if (str != null) {
                b bVar = w.f3681b;
                String strA = b.a(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211);
                listE = strA != null ? bVar.e(strA) : null;
            }
            this.h = listE;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:188:0x03ca  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v13 */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3, types: [boolean] */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r2v50 */
        /* JADX WARN: Type inference failed for: r2v64 */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a e(w wVar, String str) {
            int i;
            char c;
            char c2;
            int iG;
            int i2;
            int i3;
            int i4;
            int i5;
            int i6;
            int i7;
            int i8;
            int i9;
            boolean z2;
            String str2;
            int i10;
            ?? r14;
            int i11;
            String str3;
            a aVar;
            a aVar2;
            String str4;
            int i12;
            String str5;
            int i13;
            a aVar3;
            int i14;
            a aVar4;
            String str6;
            char cCharAt;
            String str7 = str;
            d0.z.d.m.checkParameterIsNotNull(str7, "input");
            byte[] bArr = f0.e0.c.a;
            int iO = f0.e0.c.o(str7, 0, str.length());
            int iP = f0.e0.c.p(str7, iO, str.length());
            int i15 = iP - iO;
            char c3 = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
            char c4 = 65535;
            if (i15 < 2) {
                i = -1;
            } else {
                char cCharAt2 = str7.charAt(iO);
                char c5 = 'Z';
                char c6 = 'z';
                if ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || (cCharAt2 >= 'A' && cCharAt2 <= 'Z')) {
                    i = iO;
                    while (true) {
                        i++;
                        if (i < iP) {
                            char cCharAt3 = str7.charAt(i);
                            if (('a' > cCharAt3 || c6 < cCharAt3) && (('A' > cCharAt3 || c5 < cCharAt3) && (('0' > cCharAt3 || '9' < cCharAt3) && cCharAt3 != '+' && cCharAt3 != '-' && cCharAt3 != '.'))) {
                                if (cCharAt3 != ':') {
                                    break;
                                }
                            } else {
                                c5 = 'Z';
                                c6 = 'z';
                            }
                        } else {
                            break;
                        }
                    }
                    i = -1;
                }
            }
            if (i != -1) {
                if (d0.g0.t.startsWith(str7, "https:", iO, true)) {
                    this.f3682b = Constants.SCHEME;
                    iO += 6;
                } else {
                    if (!d0.g0.t.startsWith(str7, "http:", iO, true)) {
                        StringBuilder sbU = b.d.b.a.a.U("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str7.substring(0, i);
                        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sbU.append(strSubstring);
                        sbU.append("'");
                        throw new IllegalArgumentException(sbU.toString());
                    }
                    this.f3682b = "http";
                    iO += 5;
                }
            } else {
                if (wVar == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f3682b = wVar.d;
            }
            int i16 = 0;
            int i17 = iO;
            while (true) {
                c = MentionUtilsKt.SLASH_CHAR;
                c2 = '\\';
                if (i17 >= iP || !((cCharAt = str7.charAt(i17)) == '\\' || cCharAt == '/')) {
                    break;
                }
                i16++;
                i17++;
            }
            char c7 = '?';
            if (i16 >= 2 || wVar == null || (!d0.z.d.m.areEqual(wVar.d, this.f3682b))) {
                int i18 = iO + i16;
                char c8 = MentionUtilsKt.CHANNELS_CHAR;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    iG = f0.e0.c.g(str7, "@/\\?#", i18, iP);
                    char cCharAt4 = iG != iP ? str7.charAt(iG) : (char) 65535;
                    if (cCharAt4 == c4 || cCharAt4 == c8 || cCharAt4 == c || cCharAt4 == c2 || cCharAt4 == c7) {
                        break;
                    }
                    if (cCharAt4 != '@') {
                        i9 = iP;
                    } else {
                        if (z3) {
                            boolean z5 = z3;
                            i8 = iG;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.d);
                            sb.append("%40");
                            i9 = iP;
                            sb.append(b.a(w.f3681b, str, i18, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240));
                            this.d = sb.toString();
                            z2 = z5;
                        } else {
                            int iF = f0.e0.c.f(str7, c3, i18, iG);
                            b bVar = w.f3681b;
                            boolean z6 = z3;
                            i8 = iG;
                            String strA = b.a(bVar, str, i18, iF, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                            if (z4) {
                                strA = b.d.b.a.a.K(new StringBuilder(), this.c, "%40", strA);
                            }
                            this.c = strA;
                            if (iF != i8) {
                                this.d = b.a(bVar, str, iF + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                                z2 = true;
                            } else {
                                z2 = z6;
                            }
                            z4 = true;
                            i9 = iP;
                        }
                        i18 = i8 + 1;
                        z3 = z2;
                    }
                    c8 = MentionUtilsKt.CHANNELS_CHAR;
                    c7 = '?';
                    c2 = '\\';
                    c = MentionUtilsKt.SLASH_CHAR;
                    c4 = 65535;
                    c3 = MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR;
                    iP = i9;
                }
                i2 = iP;
                int i19 = i18;
                while (true) {
                    if (i19 < iG) {
                        char cCharAt5 = str7.charAt(i19);
                        if (cCharAt5 == ':') {
                            i3 = i19;
                            break;
                        }
                        if (cCharAt5 == '[') {
                            do {
                                i19++;
                                if (i19 < iG) {
                                }
                            } while (str7.charAt(i19) != ']');
                        }
                        i19++;
                    } else {
                        i3 = iG;
                        break;
                    }
                }
                int i20 = i3 + 1;
                char c9 = '\"';
                if (i20 < iG) {
                    b bVar2 = w.f3681b;
                    this.e = b.i.a.f.e.o.f.r1(b.d(bVar2, str, i18, i3, false, 4));
                    i4 = i18;
                    try {
                        i7 = Integer.parseInt(b.a(bVar2, str, i20, iG, "", false, false, false, false, null, 248));
                    } catch (NumberFormatException unused) {
                    }
                    if (1 <= i7 && 65535 >= i7) {
                        i6 = 1;
                    } else {
                        i6 = 1;
                        i7 = -1;
                    }
                    this.f = i7;
                    if (!(i7 != -1)) {
                        StringBuilder sbU2 = b.d.b.a.a.U("Invalid URL port: \"");
                        String strSubstring2 = str7.substring(i20, iG);
                        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sbU2.append(strSubstring2);
                        sbU2.append('\"');
                        throw new IllegalArgumentException(sbU2.toString().toString());
                    }
                    c9 = '\"';
                    i5 = i6;
                } else {
                    i4 = i18;
                    b bVar3 = w.f3681b;
                    this.e = b.i.a.f.e.o.f.r1(b.d(bVar3, str, i4, i3, false, 4));
                    String str8 = this.f3682b;
                    if (str8 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    this.f = bVar3.b(str8);
                    i5 = 1;
                }
                if (!(this.e != null)) {
                    StringBuilder sbU3 = b.d.b.a.a.U("Invalid URL host: \"");
                    String strSubstring3 = str7.substring(i4, i3);
                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sbU3.append(strSubstring3);
                    sbU3.append(c9);
                    throw new IllegalArgumentException(sbU3.toString().toString());
                }
                iO = iG;
            } else {
                this.c = wVar.e();
                this.d = wVar.a();
                this.e = wVar.g;
                this.f = wVar.h;
                this.g.clear();
                this.g.addAll(wVar.c());
                if (iO == iP || str7.charAt(iO) == '#') {
                    d(wVar.d());
                }
                i5 = 1;
                i2 = iP;
            }
            int i21 = i2;
            int iG2 = f0.e0.c.g(str7, "?#", iO, i21);
            if (iO == iG2) {
                aVar3 = this;
                i14 = i21;
                str5 = str7;
            } else {
                char cCharAt6 = str7.charAt(iO);
                if (cCharAt6 == '/' || cCharAt6 == '\\') {
                    this.g.clear();
                    this.g.add("");
                    int i22 = i5;
                    str2 = str7;
                    i10 = iO + i22;
                    r14 = i22;
                    i11 = iG2;
                    str3 = "";
                    aVar = this;
                    aVar2 = this;
                    str4 = str7;
                    i12 = i21;
                    str5 = str7;
                    i13 = iG2;
                } else {
                    List<String> list = this.g;
                    list.set(list.size() - i5, "");
                    aVar2 = this;
                    aVar = aVar2;
                    r14 = i5;
                    i11 = iG2;
                    i12 = i21;
                    str3 = "";
                    str2 = str7;
                    str4 = str2;
                    str5 = str4;
                    i10 = iO;
                    i13 = i11;
                }
                while (i10 < i13) {
                    int iG3 = f0.e0.c.g(str4, "/\\", i10, i13);
                    boolean z7 = iG3 < i13;
                    String str9 = str4;
                    a aVar5 = aVar2;
                    String str10 = str3;
                    int i23 = i13;
                    String strA2 = b.a(w.f3681b, str4, i10, iG3, " \"<>^`{}|/\\?#", true, false, false, false, null, 240);
                    if (d0.z.d.m.areEqual(strA2, ".") || d0.g0.t.equals(strA2, "%2e", r14)) {
                        aVar4 = aVar5;
                        str6 = str10;
                    } else {
                        if (d0.z.d.m.areEqual(strA2, "..") || d0.g0.t.equals(strA2, "%2e.", r14) || d0.g0.t.equals(strA2, ".%2e", r14) || d0.g0.t.equals(strA2, "%2e%2e", r14)) {
                            aVar4 = aVar5;
                            List<String> list2 = aVar4.g;
                            if (list2.remove(list2.size() - (r14 == true ? 1 : 0)).length() == 0) {
                                if (((aVar4.g.isEmpty() ? 1 : 0) ^ (r14 == true ? 1 : 0)) != 0) {
                                    List<String> list3 = aVar4.g;
                                    str6 = str10;
                                    list3.set(list3.size() - (r14 == true ? 1 : 0), str6);
                                } else {
                                    str6 = str10;
                                    aVar4.g.add(str6);
                                }
                            }
                        } else {
                            aVar4 = aVar5;
                            str6 = str10;
                            List<String> list4 = aVar4.g;
                            if (list4.get(list4.size() - (r14 == true ? 1 : 0)).length() == 0) {
                                List<String> list5 = aVar4.g;
                                list5.set(list5.size() - (r14 == true ? 1 : 0), strA2);
                            } else {
                                aVar4.g.add(strA2);
                            }
                            if (z7) {
                                aVar4.g.add(str6);
                            }
                        }
                    }
                    if (z7) {
                        String str11 = str6;
                        String str12 = str5;
                        int i24 = r14 == true ? 1 : 0;
                        i10 = iG3 + i24;
                        r14 = i24;
                        i11 = i11;
                        str3 = str11;
                        aVar = aVar;
                        aVar2 = aVar4;
                        str4 = str9;
                        i12 = i12;
                        str5 = str12;
                        i13 = i23;
                    } else {
                        str3 = str6;
                        aVar2 = aVar4;
                        str4 = str9;
                        i13 = i23;
                        i10 = iG3;
                    }
                }
                str7 = str2;
                iG2 = i11;
                aVar3 = aVar;
                i14 = i12;
            }
            if (iG2 < i14 && str5.charAt(iG2) == '?') {
                int iF2 = f0.e0.c.f(str5, MentionUtilsKt.CHANNELS_CHAR, iG2, i14);
                b bVar4 = w.f3681b;
                aVar3.h = bVar4.e(b.a(bVar4, str7, iG2 + 1, iF2, " \"'<>#", true, false, true, false, null, 208));
                iG2 = iF2;
            }
            if (iG2 < i14 && str5.charAt(iG2) == '#') {
                aVar3.i = b.a(w.f3681b, str7, iG2 + 1, i14, "", true, false, false, true, null, Opcodes.ARETURN);
            }
            return aVar3;
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:52:0x00ba  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.f3682b;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.c.length() > 0) {
                sb.append(this.c);
                if (this.d.length() > 0) {
                    sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(this.d);
                }
                sb.append(MentionUtilsKt.MENTIONS_CHAR);
            } else if (this.d.length() > 0) {
            }
            String str2 = this.e;
            if (str2 != null) {
                if (str2 == null) {
                    d0.z.d.m.throwNpe();
                }
                if (d0.g0.w.contains$default((CharSequence) str2, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
                    sb.append('[');
                    sb.append(this.e);
                    sb.append(']');
                } else {
                    sb.append(this.e);
                }
            }
            int i = -1;
            if (this.f != -1 || this.f3682b != null) {
                int iC = c();
                String str3 = this.f3682b;
                if (str3 == null) {
                    sb.append(MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(iC);
                } else {
                    if (str3 == null) {
                        d0.z.d.m.throwNpe();
                    }
                    d0.z.d.m.checkParameterIsNotNull(str3, "scheme");
                    int iHashCode = str3.hashCode();
                    if (iHashCode != 3213448) {
                        if (iHashCode == 99617003 && str3.equals(Constants.SCHEME)) {
                            i = 443;
                        }
                    } else if (str3.equals("http")) {
                        i = 80;
                    }
                    if (iC != i) {
                    }
                }
            }
            List<String> list = this.g;
            d0.z.d.m.checkParameterIsNotNull(list, "$this$toPathString");
            d0.z.d.m.checkParameterIsNotNull(sb, "out");
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(MentionUtilsKt.SLASH_CHAR);
                sb.append(list.get(i2));
            }
            if (this.h != null) {
                sb.append('?');
                List<String> list2 = this.h;
                if (list2 == null) {
                    d0.z.d.m.throwNpe();
                }
                d0.z.d.m.checkParameterIsNotNull(list2, "$this$toQueryString");
                d0.z.d.m.checkParameterIsNotNull(sb, "out");
                IntProgression intProgressionStep = d0.d0.f.step(d0.d0.f.until(0, list2.size()), 2);
                int first = intProgressionStep.getFirst();
                int last = intProgressionStep.getLast();
                int step = intProgressionStep.getStep();
                if (step < 0 ? first >= last : first <= last) {
                    while (true) {
                        String str4 = list2.get(first);
                        String str5 = list2.get(first + 1);
                        if (first > 0) {
                            sb.append('&');
                        }
                        sb.append(str4);
                        if (str5 != null) {
                            sb.append('=');
                            sb.append(str5);
                        }
                        if (first == last) {
                            break;
                        }
                        first += step;
                    }
                }
            }
            if (this.i != null) {
                sb.append(MentionUtilsKt.CHANNELS_CHAR);
                sb.append(this.i);
            }
            String string = sb.toString();
            d0.z.d.m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* compiled from: HttpUrl.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String a(b bVar, String str, int i, int i2, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i3) {
            String str3;
            boolean z6;
            String str4;
            int i4 = (i3 & 1) != 0 ? 0 : i;
            int length = (i3 & 2) != 0 ? str.length() : i2;
            boolean z7 = (i3 & 8) != 0 ? false : z2;
            boolean z8 = (i3 & 16) != 0 ? false : z3;
            boolean z9 = (i3 & 32) != 0 ? false : z4;
            boolean z10 = (i3 & 64) != 0 ? false : z5;
            Charset charset2 = (i3 & 128) != 0 ? null : charset;
            d0.z.d.m.checkParameterIsNotNull(str, "$this$canonicalize");
            d0.z.d.m.checkParameterIsNotNull(str2, "encodeSet");
            int iCharCount = i4;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                int i5 = 2;
                if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && !z10)) {
                    str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                    g0.e eVar = new g0.e();
                    eVar.c0(str, i4, iCharCount);
                    g0.e eVar2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = str.codePointAt(iCharCount);
                        if (z7 && (iCodePointAt2 == 9 || iCodePointAt2 == 10 || iCodePointAt2 == 12 || iCodePointAt2 == 13)) {
                            z6 = z9;
                            str4 = str3;
                        } else if (iCodePointAt2 == 43 && z9) {
                            eVar.b0(z7 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                            z6 = z9;
                            str4 = str3;
                        } else {
                            if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || (iCodePointAt2 >= 128 && !z10)) {
                                z6 = z9;
                            } else {
                                z6 = z9;
                                if (!d0.g0.w.contains$default((CharSequence) str2, (char) iCodePointAt2, false, i5, (Object) null) && (iCodePointAt2 != 37 || (z7 && (!z8 || bVar.c(str, iCharCount, length))))) {
                                    eVar.d0(iCodePointAt2);
                                    str4 = str3;
                                }
                            }
                            if (eVar2 == null) {
                                eVar2 = new g0.e();
                            }
                            if (charset2 == null || d0.z.d.m.areEqual(charset2, StandardCharsets.UTF_8)) {
                                str4 = str3;
                                eVar2.d0(iCodePointAt2);
                            } else {
                                int iCharCount2 = Character.charCount(iCodePointAt2) + iCharCount;
                                d0.z.d.m.checkParameterIsNotNull(str, "string");
                                d0.z.d.m.checkParameterIsNotNull(charset2, "charset");
                                if (!(iCharCount >= 0)) {
                                    throw new IllegalArgumentException(b.d.b.a.a.q("beginIndex < 0: ", iCharCount).toString());
                                }
                                if (!(iCharCount2 >= iCharCount)) {
                                    throw new IllegalArgumentException(b.d.b.a.a.s("endIndex < beginIndex: ", iCharCount2, " < ", iCharCount).toString());
                                }
                                if (!(iCharCount2 <= str.length())) {
                                    StringBuilder sbV = b.d.b.a.a.V("endIndex > string.length: ", iCharCount2, " > ");
                                    sbV.append(str.length());
                                    throw new IllegalArgumentException(sbV.toString().toString());
                                }
                                if (d0.z.d.m.areEqual(charset2, d0.g0.c.a)) {
                                    eVar2.c0(str, iCharCount, iCharCount2);
                                    str4 = str3;
                                } else {
                                    String strSubstring = str.substring(iCharCount, iCharCount2);
                                    str4 = str3;
                                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, str4);
                                    if (strSubstring == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    byte[] bytes = strSubstring.getBytes(charset2);
                                    d0.z.d.m.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                                    eVar2.S(bytes, 0, bytes.length);
                                }
                            }
                            while (!eVar2.w()) {
                                int i6 = eVar2.readByte() & 255;
                                eVar.T(37);
                                char[] cArr = w.a;
                                eVar.T(cArr[(i6 >> 4) & 15]);
                                eVar.T(cArr[i6 & 15]);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i5 = 2;
                        z9 = z6;
                        str3 = str4;
                    }
                    return eVar.D();
                }
                str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                if (d0.g0.w.contains$default((CharSequence) str2, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z7 || (z8 && !bVar.c(str, iCharCount, length)))) || (iCodePointAt == 43 && z9))) {
                    g0.e eVar3 = new g0.e();
                    eVar3.c0(str, i4, iCharCount);
                    g0.e eVar22 = null;
                    while (iCharCount < length) {
                    }
                    return eVar3.D();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring2 = str.substring(i4, length);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring2;
        }

        public static String d(b bVar, String str, int i, int i2, boolean z2, int i3) {
            int i4;
            if ((i3 & 1) != 0) {
                i = 0;
            }
            if ((i3 & 2) != 0) {
                i2 = str.length();
            }
            if ((i3 & 4) != 0) {
                z2 = false;
            }
            d0.z.d.m.checkParameterIsNotNull(str, "$this$percentDecode");
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                    g0.e eVar = new g0.e();
                    eVar.c0(str, i, iCharCount);
                    while (iCharCount < i2) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int iR = f0.e0.c.r(str.charAt(iCharCount + 1));
                            int iR2 = f0.e0.c.r(str.charAt(i4));
                            if (iR == -1 || iR2 == -1) {
                                eVar.d0(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                eVar.T((iR << 4) + iR2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            }
                        } else if (iCodePointAt == 43 && z2) {
                            eVar.T(32);
                            iCharCount++;
                        } else {
                            eVar.d0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return eVar.D();
                }
                iCharCount++;
            }
            String strSubstring = str.substring(i, i2);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final int b(String str) {
            d0.z.d.m.checkParameterIsNotNull(str, "scheme");
            int iHashCode = str.hashCode();
            if (iHashCode != 3213448) {
                if (iHashCode == 99617003 && str.equals(Constants.SCHEME)) {
                    return 443;
                }
            } else if (str.equals("http")) {
                return 80;
            }
            return -1;
        }

        public final boolean c(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && f0.e0.c.r(str.charAt(i + 1)) != -1 && f0.e0.c.r(str.charAt(i3)) != -1;
        }

        public final List<String> e(String str) {
            d0.z.d.m.checkParameterIsNotNull(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) str, '&', i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int i2 = iIndexOf$default;
                int iIndexOf$default2 = d0.g0.w.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > i2) {
                    String strSubstring = str.substring(i, i2);
                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iIndexOf$default2);
                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iIndexOf$default2 + 1, i2);
                    d0.z.d.m.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }
    }

    public w(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        d0.z.d.m.checkParameterIsNotNull(str2, "username");
        d0.z.d.m.checkParameterIsNotNull(str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        d0.z.d.m.checkParameterIsNotNull(str4, "host");
        d0.z.d.m.checkParameterIsNotNull(list, "pathSegments");
        d0.z.d.m.checkParameterIsNotNull(str6, "url");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = i;
        this.i = list;
        this.j = list2;
        this.k = str5;
        this.l = str6;
        this.c = d0.z.d.m.areEqual(str, Constants.SCHEME);
    }

    public final String a() {
        if (this.f.length() == 0) {
            return "";
        }
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, this.d.length() + 3, false, 4, (Object) null) + 1;
        int iIndexOf$default2 = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.MENTIONS_CHAR, 0, false, 6, (Object) null);
        String str = this.l;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iIndexOf$default, iIndexOf$default2);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.SLASH_CHAR, this.d.length() + 3, false, 4, (Object) null);
        String str = this.l;
        int iG = f0.e0.c.g(str, "?#", iIndexOf$default, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iG);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> c() {
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.SLASH_CHAR, this.d.length() + 3, false, 4, (Object) null);
        String str = this.l;
        int iG = f0.e0.c.g(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iG) {
            int i = iIndexOf$default + 1;
            int iF = f0.e0.c.f(this.l, MentionUtilsKt.SLASH_CHAR, i, iG);
            String str2 = this.l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i, iF);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.j == null) {
            return null;
        }
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, '?', 0, false, 6, (Object) null) + 1;
        String str = this.l;
        int iF = f0.e0.c.f(str, MentionUtilsKt.CHANNELS_CHAR, iIndexOf$default, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iF);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.e.length() == 0) {
            return "";
        }
        int length = this.d.length() + 3;
        String str = this.l;
        int iG = f0.e0.c.g(str, ":@", length, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iG);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && d0.z.d.m.areEqual(((w) obj).l, this.l);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a f() {
        int i;
        String strSubstring;
        a aVar = new a();
        aVar.f3682b = this.d;
        String strE = e();
        d0.z.d.m.checkParameterIsNotNull(strE, "<set-?>");
        aVar.c = strE;
        String strA = a();
        d0.z.d.m.checkParameterIsNotNull(strA, "<set-?>");
        aVar.d = strA;
        aVar.e = this.g;
        int i2 = this.h;
        String str = this.d;
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        int iHashCode = str.hashCode();
        if (iHashCode != 3213448) {
            i = (iHashCode == 99617003 && str.equals(Constants.SCHEME)) ? 443 : -1;
        } else if (str.equals("http")) {
            i = 80;
        }
        aVar.f = i2 != i ? this.h : -1;
        aVar.g.clear();
        aVar.g.addAll(c());
        aVar.d(d());
        if (this.k == null) {
            strSubstring = null;
        } else {
            int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.CHANNELS_CHAR, 0, false, 6, (Object) null) + 1;
            String str2 = this.l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(iIndexOf$default);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        aVar.i = strSubstring;
        return aVar;
    }

    public final a g(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, "link");
        try {
            a aVar = new a();
            aVar.e(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String h() {
        a aVarG = g("/...");
        if (aVarG == null) {
            d0.z.d.m.throwNpe();
        }
        Objects.requireNonNull(aVarG);
        d0.z.d.m.checkParameterIsNotNull("", "username");
        b bVar = f3681b;
        aVarG.c = b.a(bVar, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        d0.z.d.m.checkParameterIsNotNull("", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        aVarG.d = b.a(bVar, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        return aVarG.b().l;
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    public final URI i() {
        a aVarF = f();
        String str = aVarF.e;
        aVarF.e = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
        int size = aVarF.g.size();
        for (int i = 0; i < size; i++) {
            List<String> list = aVarF.g;
            list.set(i, b.a(f3681b, list.get(i), 0, 0, "[]", true, true, false, false, null, 227));
        }
        List<String> list2 = aVarF.h;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = list2.get(i2);
                list2.set(i2, str2 != null ? b.a(f3681b, str2, 0, 0, "\\^`{|}", true, true, true, false, null, Opcodes.MONITOREXIT) : null);
            }
        }
        String str3 = aVarF.i;
        aVarF.i = str3 != null ? b.a(f3681b, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, Opcodes.IF_ICMPGT) : null;
        String string = aVarF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                d0.z.d.m.checkExpressionValueIsNotNull(uriCreate, "URI.create(stripped)");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.l;
    }
}
