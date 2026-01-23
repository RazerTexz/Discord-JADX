package p600f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtils;
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
import kotlin.ranges.Progressions2;
import kotlin.text.Regex;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p512d0._Ranges;
import p507d0.p579g0.Charsets2;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.p601e0.Util7;
import p615g0.Buffer3;

/* JADX INFO: renamed from: f0.w, reason: use source file name */
/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpUrl {

    /* JADX INFO: renamed from: c */
    public final boolean f25975c;

    /* JADX INFO: renamed from: d */
    public final String f25976d;

    /* JADX INFO: renamed from: e */
    public final String f25977e;

    /* JADX INFO: renamed from: f */
    public final String f25978f;

    /* JADX INFO: renamed from: g */
    public final String f25979g;

    /* JADX INFO: renamed from: h */
    public final int f25980h;

    /* JADX INFO: renamed from: i */
    public final List<String> f25981i;

    /* JADX INFO: renamed from: j */
    public final List<String> f25982j;

    /* JADX INFO: renamed from: k */
    public final String f25983k;

    /* JADX INFO: renamed from: l */
    public final String f25984l;

    /* JADX INFO: renamed from: b */
    public static final b f25974b = new b(null);

    /* JADX INFO: renamed from: a */
    public static final char[] f25973a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* JADX INFO: renamed from: f0.w$a */
    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public static final C13345a f25985a = new C13345a(null);

        /* JADX INFO: renamed from: b */
        public String f25986b;

        /* JADX INFO: renamed from: e */
        public String f25989e;

        /* JADX INFO: renamed from: g */
        public final List<String> f25991g;

        /* JADX INFO: renamed from: h */
        public List<String> f25992h;

        /* JADX INFO: renamed from: i */
        public String f25993i;

        /* JADX INFO: renamed from: c */
        public String f25987c = "";

        /* JADX INFO: renamed from: d */
        public String f25988d = "";

        /* JADX INFO: renamed from: f */
        public int f25990f = -1;

        /* JADX INFO: renamed from: f0.w$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: HttpUrl.kt */
        public static final class C13345a {
            public C13345a(DefaultConstructorMarker defaultConstructorMarker) {
            }
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f25991g = arrayList;
            arrayList.add("");
        }

        /* JADX INFO: renamed from: a */
        public final a m10408a(String str, String str2) {
            Intrinsics3.checkParameterIsNotNull(str, "encodedName");
            if (this.f25992h == null) {
                this.f25992h = new ArrayList();
            }
            List<String> list = this.f25992h;
            if (list == null) {
                Intrinsics3.throwNpe();
            }
            b bVar = HttpUrl.f25974b;
            list.add(b.m10413a(bVar, str, 0, 0, " \"'<>#&=", true, false, true, false, null, 211));
            List<String> list2 = this.f25992h;
            if (list2 == null) {
                Intrinsics3.throwNpe();
            }
            list2.add(str2 != null ? b.m10413a(bVar, str2, 0, 0, " \"'<>#&=", true, false, true, false, null, 211) : null);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public final HttpUrl m10409b() {
            ArrayList arrayList;
            String str = this.f25986b;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            b bVar = HttpUrl.f25974b;
            String strM10414d = b.m10414d(bVar, this.f25987c, 0, 0, false, 7);
            String strM10414d2 = b.m10414d(bVar, this.f25988d, 0, 0, false, 7);
            String str2 = this.f25989e;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iM10410c = m10410c();
            List<String> list = this.f25991g;
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(b.m10414d(HttpUrl.f25974b, (String) it.next(), 0, 0, false, 7));
            }
            List<String> list2 = this.f25992h;
            if (list2 != null) {
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
                for (String str3 : list2) {
                    arrayList.add(str3 != null ? b.m10414d(HttpUrl.f25974b, str3, 0, 0, true, 3) : null);
                }
            } else {
                arrayList = null;
            }
            String str4 = this.f25993i;
            return new HttpUrl(str, strM10414d, strM10414d2, str2, iM10410c, arrayList2, arrayList, str4 != null ? b.m10414d(HttpUrl.f25974b, str4, 0, 0, false, 7) : null, toString());
        }

        /* JADX INFO: renamed from: c */
        public final int m10410c() {
            int i = this.f25990f;
            if (i != -1) {
                return i;
            }
            String str = this.f25986b;
            if (str == null) {
                Intrinsics3.throwNpe();
            }
            Intrinsics3.checkParameterIsNotNull(str, "scheme");
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
        /* JADX INFO: renamed from: d */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a m10411d(String str) {
            List<String> listM10417e;
            if (str != null) {
                b bVar = HttpUrl.f25974b;
                String strM10413a = b.m10413a(bVar, str, 0, 0, " \"'<>#", true, false, true, false, null, 211);
                listM10417e = strM10413a != null ? bVar.m10417e(strM10413a) : null;
            }
            this.f25992h = listM10417e;
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:188:0x03ca  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x0071  */
        /* JADX WARN: Type inference failed for: r14v1 */
        /* JADX WARN: Type inference failed for: r14v13 */
        /* JADX WARN: Type inference failed for: r14v15 */
        /* JADX WARN: Type inference failed for: r14v2 */
        /* JADX WARN: Type inference failed for: r14v3, types: [boolean] */
        /* JADX WARN: Type inference failed for: r14v5 */
        /* JADX WARN: Type inference failed for: r14v6 */
        /* JADX WARN: Type inference failed for: r14v7 */
        /* JADX WARN: Type inference failed for: r2v50 */
        /* JADX WARN: Type inference failed for: r2v64 */
        /* JADX WARN: Type inference failed for: r3v47 */
        /* JADX WARN: Type inference failed for: r3v65 */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 2 */
        /* JADX INFO: renamed from: e */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final a m10412e(HttpUrl httpUrl, String str) {
            int i;
            char c;
            char c2;
            int iM10126g;
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
            Intrinsics3.checkParameterIsNotNull(str7, "input");
            byte[] bArr = Util7.f25397a;
            int iM10134o = Util7.m10134o(str7, 0, str.length());
            int iM10135p = Util7.m10135p(str7, iM10134o, str.length());
            int i15 = iM10135p - iM10134o;
            char c3 = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
            char c4 = 65535;
            if (i15 < 2) {
                i = -1;
            } else {
                char cCharAt2 = str7.charAt(iM10134o);
                char c5 = 'Z';
                char c6 = 'z';
                if ((cCharAt2 >= 'a' && cCharAt2 <= 'z') || (cCharAt2 >= 'A' && cCharAt2 <= 'Z')) {
                    i = iM10134o;
                    while (true) {
                        i++;
                        if (i < iM10135p) {
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
                if (StringsJVM.startsWith(str7, "https:", iM10134o, true)) {
                    this.f25986b = Constants.SCHEME;
                    iM10134o += 6;
                } else {
                    if (!StringsJVM.startsWith(str7, "http:", iM10134o, true)) {
                        StringBuilder sbM833U = outline.m833U("Expected URL scheme 'http' or 'https' but was '");
                        String strSubstring = str7.substring(0, i);
                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sbM833U.append(strSubstring);
                        sbM833U.append("'");
                        throw new IllegalArgumentException(sbM833U.toString());
                    }
                    this.f25986b = "http";
                    iM10134o += 5;
                }
            } else {
                if (httpUrl == null) {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
                }
                this.f25986b = httpUrl.f25976d;
            }
            int i16 = 0;
            int i17 = iM10134o;
            while (true) {
                c = MentionUtils.SLASH_CHAR;
                c2 = '\\';
                if (i17 >= iM10135p || !((cCharAt = str7.charAt(i17)) == '\\' || cCharAt == '/')) {
                    break;
                }
                i16++;
                i17++;
            }
            char c7 = '?';
            if (i16 >= 2 || httpUrl == null || (!Intrinsics3.areEqual(httpUrl.f25976d, this.f25986b))) {
                int i18 = iM10134o + i16;
                char c8 = MentionUtils.CHANNELS_CHAR;
                boolean z3 = false;
                boolean z4 = false;
                while (true) {
                    iM10126g = Util7.m10126g(str7, "@/\\?#", i18, iM10135p);
                    char cCharAt4 = iM10126g != iM10135p ? str7.charAt(iM10126g) : (char) 65535;
                    if (cCharAt4 == c4 || cCharAt4 == c8 || cCharAt4 == c || cCharAt4 == c2 || cCharAt4 == c7) {
                        break;
                    }
                    if (cCharAt4 != '@') {
                        i9 = iM10135p;
                    } else {
                        if (z3) {
                            boolean z5 = z3;
                            i8 = iM10126g;
                            StringBuilder sb = new StringBuilder();
                            sb.append(this.f25988d);
                            sb.append("%40");
                            i9 = iM10135p;
                            sb.append(b.m10413a(HttpUrl.f25974b, str, i18, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240));
                            this.f25988d = sb.toString();
                            z2 = z5;
                        } else {
                            int iM10125f = Util7.m10125f(str7, c3, i18, iM10126g);
                            b bVar = HttpUrl.f25974b;
                            boolean z6 = z3;
                            i8 = iM10126g;
                            String strM10413a = b.m10413a(bVar, str, i18, iM10125f, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                            if (z4) {
                                strM10413a = outline.m823K(new StringBuilder(), this.f25987c, "%40", strM10413a);
                            }
                            this.f25987c = strM10413a;
                            if (iM10125f != i8) {
                                this.f25988d = b.m10413a(bVar, str, iM10125f + 1, i8, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, null, 240);
                                z2 = true;
                            } else {
                                z2 = z6;
                            }
                            z4 = true;
                            i9 = iM10135p;
                        }
                        i18 = i8 + 1;
                        z3 = z2;
                    }
                    c8 = MentionUtils.CHANNELS_CHAR;
                    c7 = '?';
                    c2 = '\\';
                    c = MentionUtils.SLASH_CHAR;
                    c4 = 65535;
                    c3 = MentionUtils.EMOJIS_AND_STICKERS_CHAR;
                    iM10135p = i9;
                }
                i2 = iM10135p;
                int i19 = i18;
                while (true) {
                    if (i19 < iM10126g) {
                        char cCharAt5 = str7.charAt(i19);
                        if (cCharAt5 == ':') {
                            i3 = i19;
                            break;
                        }
                        if (cCharAt5 == '[') {
                            do {
                                i19++;
                                if (i19 < iM10126g) {
                                }
                            } while (str7.charAt(i19) != ']');
                        }
                        i19++;
                    } else {
                        i3 = iM10126g;
                        break;
                    }
                }
                int i20 = i3 + 1;
                char c9 = '\"';
                if (i20 < iM10126g) {
                    b bVar2 = HttpUrl.f25974b;
                    this.f25989e = C3404f.m4337r1(b.m10414d(bVar2, str, i18, i3, false, 4));
                    i4 = i18;
                    try {
                        i7 = Integer.parseInt(b.m10413a(bVar2, str, i20, iM10126g, "", false, false, false, false, null, 248));
                    } catch (NumberFormatException unused) {
                    }
                    if (1 <= i7 && 65535 >= i7) {
                        i6 = 1;
                    } else {
                        i6 = 1;
                        i7 = -1;
                    }
                    this.f25990f = i7;
                    if (!(i7 != -1)) {
                        StringBuilder sbM833U2 = outline.m833U("Invalid URL port: \"");
                        String strSubstring2 = str7.substring(i20, iM10126g);
                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        sbM833U2.append(strSubstring2);
                        sbM833U2.append('\"');
                        throw new IllegalArgumentException(sbM833U2.toString().toString());
                    }
                    c9 = '\"';
                    i5 = i6;
                } else {
                    i4 = i18;
                    b bVar3 = HttpUrl.f25974b;
                    this.f25989e = C3404f.m4337r1(b.m10414d(bVar3, str, i4, i3, false, 4));
                    String str8 = this.f25986b;
                    if (str8 == null) {
                        Intrinsics3.throwNpe();
                    }
                    this.f25990f = bVar3.m10415b(str8);
                    i5 = 1;
                }
                if (!(this.f25989e != null)) {
                    StringBuilder sbM833U3 = outline.m833U("Invalid URL host: \"");
                    String strSubstring3 = str7.substring(i4, i3);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    sbM833U3.append(strSubstring3);
                    sbM833U3.append(c9);
                    throw new IllegalArgumentException(sbM833U3.toString().toString());
                }
                iM10134o = iM10126g;
            } else {
                this.f25987c = httpUrl.m10403e();
                this.f25988d = httpUrl.m10399a();
                this.f25989e = httpUrl.f25979g;
                this.f25990f = httpUrl.f25980h;
                this.f25991g.clear();
                this.f25991g.addAll(httpUrl.m10401c());
                if (iM10134o == iM10135p || str7.charAt(iM10134o) == '#') {
                    m10411d(httpUrl.m10402d());
                }
                i5 = 1;
                i2 = iM10135p;
            }
            int i21 = i2;
            int iM10126g2 = Util7.m10126g(str7, "?#", iM10134o, i21);
            if (iM10134o == iM10126g2) {
                aVar3 = this;
                i14 = i21;
                str5 = str7;
            } else {
                char cCharAt6 = str7.charAt(iM10134o);
                if (cCharAt6 == '/' || cCharAt6 == '\\') {
                    this.f25991g.clear();
                    this.f25991g.add("");
                    int i22 = i5;
                    str2 = str7;
                    i10 = iM10134o + i22;
                    r14 = i22;
                    i11 = iM10126g2;
                    str3 = "";
                    aVar = this;
                    aVar2 = this;
                    str4 = str7;
                    i12 = i21;
                    str5 = str7;
                    i13 = iM10126g2;
                } else {
                    List<String> list = this.f25991g;
                    list.set(list.size() - i5, "");
                    aVar2 = this;
                    aVar = aVar2;
                    r14 = i5;
                    i11 = iM10126g2;
                    i12 = i21;
                    str3 = "";
                    str2 = str7;
                    str4 = str2;
                    str5 = str4;
                    i10 = iM10134o;
                    i13 = i11;
                }
                while (i10 < i13) {
                    int iM10126g3 = Util7.m10126g(str4, "/\\", i10, i13);
                    boolean z7 = iM10126g3 < i13;
                    String str9 = str4;
                    a aVar5 = aVar2;
                    String str10 = str3;
                    int i23 = i13;
                    String strM10413a2 = b.m10413a(HttpUrl.f25974b, str4, i10, iM10126g3, " \"<>^`{}|/\\?#", true, false, false, false, null, 240);
                    if (Intrinsics3.areEqual(strM10413a2, ".") || StringsJVM.equals(strM10413a2, "%2e", r14)) {
                        aVar4 = aVar5;
                        str6 = str10;
                    } else {
                        if (Intrinsics3.areEqual(strM10413a2, "..") || StringsJVM.equals(strM10413a2, "%2e.", r14) || StringsJVM.equals(strM10413a2, ".%2e", r14) || StringsJVM.equals(strM10413a2, "%2e%2e", r14)) {
                            aVar4 = aVar5;
                            List<String> list2 = aVar4.f25991g;
                            if (list2.remove(list2.size() - (r14 == true ? 1 : 0)).length() == 0) {
                                if (((aVar4.f25991g.isEmpty() ? 1 : 0) ^ (r14 == true ? 1 : 0)) != 0) {
                                    List<String> list3 = aVar4.f25991g;
                                    str6 = str10;
                                    list3.set(list3.size() - (r14 == true ? 1 : 0), str6);
                                } else {
                                    str6 = str10;
                                    aVar4.f25991g.add(str6);
                                }
                            }
                        } else {
                            aVar4 = aVar5;
                            str6 = str10;
                            List<String> list4 = aVar4.f25991g;
                            if (list4.get(list4.size() - (r14 == true ? 1 : 0)).length() == 0) {
                                List<String> list5 = aVar4.f25991g;
                                list5.set(list5.size() - (r14 == true ? 1 : 0), strM10413a2);
                            } else {
                                aVar4.f25991g.add(strM10413a2);
                            }
                            if (z7) {
                                aVar4.f25991g.add(str6);
                            }
                        }
                    }
                    if (z7) {
                        String str11 = str6;
                        String str12 = str5;
                        ?? r3 = r14 == true ? 1 : 0;
                        int i24 = i11;
                        a aVar6 = aVar;
                        int i25 = i12;
                        i10 = iM10126g3 + (r3 == true ? 1 : 0);
                        r14 = r3 == true ? 1 : 0;
                        i11 = i24;
                        str3 = str11;
                        aVar = aVar6;
                        aVar2 = aVar4;
                        str4 = str9;
                        i12 = i25;
                        str5 = str12;
                        i13 = i23;
                    } else {
                        str3 = str6;
                        aVar2 = aVar4;
                        str4 = str9;
                        i13 = i23;
                        i10 = iM10126g3;
                    }
                }
                str7 = str2;
                iM10126g2 = i11;
                aVar3 = aVar;
                i14 = i12;
            }
            if (iM10126g2 < i14 && str5.charAt(iM10126g2) == '?') {
                int iM10125f2 = Util7.m10125f(str5, MentionUtils.CHANNELS_CHAR, iM10126g2, i14);
                b bVar4 = HttpUrl.f25974b;
                aVar3.f25992h = bVar4.m10417e(b.m10413a(bVar4, str7, iM10126g2 + 1, iM10125f2, " \"'<>#", true, false, true, false, null, 208));
                iM10126g2 = iM10125f2;
            }
            if (iM10126g2 < i14 && str5.charAt(iM10126g2) == '#') {
                aVar3.f25993i = b.m10413a(HttpUrl.f25974b, str7, iM10126g2 + 1, i14, "", true, false, false, true, null, Opcodes.ARETURN);
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
            String str = this.f25986b;
            if (str != null) {
                sb.append(str);
                sb.append("://");
            } else {
                sb.append("//");
            }
            if (this.f25987c.length() > 0) {
                sb.append(this.f25987c);
                if (this.f25988d.length() > 0) {
                    sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(this.f25988d);
                }
                sb.append(MentionUtils.MENTIONS_CHAR);
            } else if (this.f25988d.length() > 0) {
            }
            String str2 = this.f25989e;
            if (str2 != null) {
                if (str2 == null) {
                    Intrinsics3.throwNpe();
                }
                if (Strings4.contains$default((CharSequence) str2, MentionUtils.EMOJIS_AND_STICKERS_CHAR, false, 2, (Object) null)) {
                    sb.append('[');
                    sb.append(this.f25989e);
                    sb.append(']');
                } else {
                    sb.append(this.f25989e);
                }
            }
            int i = -1;
            if (this.f25990f != -1 || this.f25986b != null) {
                int iM10410c = m10410c();
                String str3 = this.f25986b;
                if (str3 == null) {
                    sb.append(MentionUtils.EMOJIS_AND_STICKERS_CHAR);
                    sb.append(iM10410c);
                } else {
                    if (str3 == null) {
                        Intrinsics3.throwNpe();
                    }
                    Intrinsics3.checkParameterIsNotNull(str3, "scheme");
                    int iHashCode = str3.hashCode();
                    if (iHashCode != 3213448) {
                        if (iHashCode == 99617003 && str3.equals(Constants.SCHEME)) {
                            i = 443;
                        }
                    } else if (str3.equals("http")) {
                        i = 80;
                    }
                    if (iM10410c != i) {
                    }
                }
            }
            List<String> list = this.f25991g;
            Intrinsics3.checkParameterIsNotNull(list, "$this$toPathString");
            Intrinsics3.checkParameterIsNotNull(sb, "out");
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                sb.append(MentionUtils.SLASH_CHAR);
                sb.append(list.get(i2));
            }
            if (this.f25992h != null) {
                sb.append('?');
                List<String> list2 = this.f25992h;
                if (list2 == null) {
                    Intrinsics3.throwNpe();
                }
                Intrinsics3.checkParameterIsNotNull(list2, "$this$toQueryString");
                Intrinsics3.checkParameterIsNotNull(sb, "out");
                Progressions2 progressions2Step = _Ranges.step(_Ranges.until(0, list2.size()), 2);
                int first = progressions2Step.getFirst();
                int last = progressions2Step.getLast();
                int step = progressions2Step.getStep();
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
            if (this.f25993i != null) {
                sb.append(MentionUtils.CHANNELS_CHAR);
                sb.append(this.f25993i);
            }
            String string = sb.toString();
            Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            return string;
        }
    }

    /* JADX INFO: renamed from: f0.w$b */
    /* JADX INFO: compiled from: HttpUrl.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX WARN: Removed duplicated region for block: B:55:0x0098  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public static String m10413a(b bVar, String str, int i, int i2, String str2, boolean z2, boolean z3, boolean z4, boolean z5, Charset charset, int i3) {
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
            Intrinsics3.checkParameterIsNotNull(str, "$this$canonicalize");
            Intrinsics3.checkParameterIsNotNull(str2, "encodeSet");
            int iCharCount = i4;
            while (iCharCount < length) {
                int iCodePointAt = str.codePointAt(iCharCount);
                int i5 = 2;
                if (iCodePointAt < 32 || iCodePointAt == 127 || (iCodePointAt >= 128 && !z10)) {
                    str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.m10453c0(str, i4, iCharCount);
                    Buffer3 buffer32 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = str.codePointAt(iCharCount);
                        if (z7 && (iCodePointAt2 == 9 || iCodePointAt2 == 10 || iCodePointAt2 == 12 || iCodePointAt2 == 13)) {
                            z6 = z9;
                            str4 = str3;
                        } else if (iCodePointAt2 == 43 && z9) {
                            buffer3.m10452b0(z7 ? BadgeDrawable.DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX : "%2B");
                            z6 = z9;
                            str4 = str3;
                        } else {
                            if (iCodePointAt2 < 32 || iCodePointAt2 == 127 || (iCodePointAt2 >= 128 && !z10)) {
                                z6 = z9;
                            } else {
                                z6 = z9;
                                if (!Strings4.contains$default((CharSequence) str2, (char) iCodePointAt2, false, i5, (Object) null) && (iCodePointAt2 != 37 || (z7 && (!z8 || bVar.m10416c(str, iCharCount, length))))) {
                                    buffer3.m10454d0(iCodePointAt2);
                                    str4 = str3;
                                }
                            }
                            if (buffer32 == null) {
                                buffer32 = new Buffer3();
                            }
                            if (charset2 == null || Intrinsics3.areEqual(charset2, StandardCharsets.UTF_8)) {
                                str4 = str3;
                                buffer32.m10454d0(iCodePointAt2);
                            } else {
                                int iCharCount2 = Character.charCount(iCodePointAt2) + iCharCount;
                                Intrinsics3.checkParameterIsNotNull(str, "string");
                                Intrinsics3.checkParameterIsNotNull(charset2, "charset");
                                if (!(iCharCount >= 0)) {
                                    throw new IllegalArgumentException(outline.m871q("beginIndex < 0: ", iCharCount).toString());
                                }
                                if (!(iCharCount2 >= iCharCount)) {
                                    throw new IllegalArgumentException(outline.m875s("endIndex < beginIndex: ", iCharCount2, " < ", iCharCount).toString());
                                }
                                if (!(iCharCount2 <= str.length())) {
                                    StringBuilder sbM834V = outline.m834V("endIndex > string.length: ", iCharCount2, " > ");
                                    sbM834V.append(str.length());
                                    throw new IllegalArgumentException(sbM834V.toString().toString());
                                }
                                if (Intrinsics3.areEqual(charset2, Charsets2.f25136a)) {
                                    buffer32.m10453c0(str, iCharCount, iCharCount2);
                                    str4 = str3;
                                } else {
                                    String strSubstring = str.substring(iCharCount, iCharCount2);
                                    str4 = str3;
                                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, str4);
                                    if (strSubstring == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    byte[] bytes = strSubstring.getBytes(charset2);
                                    Intrinsics3.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                                    buffer32.m10443S(bytes, 0, bytes.length);
                                }
                            }
                            while (!buffer32.mo10472w()) {
                                int i6 = buffer32.readByte() & 255;
                                buffer3.m10444T(37);
                                char[] cArr = HttpUrl.f25973a;
                                buffer3.m10444T(cArr[(i6 >> 4) & 15]);
                                buffer3.m10444T(cArr[i6 & 15]);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i5 = 2;
                        z9 = z6;
                        str3 = str4;
                    }
                    return buffer3.m10429D();
                }
                str3 = "(this as java.lang.Strin…ing(startIndex, endIndex)";
                if (Strings4.contains$default((CharSequence) str2, (char) iCodePointAt, false, 2, (Object) null) || ((iCodePointAt == 37 && (!z7 || (z8 && !bVar.m10416c(str, iCharCount, length)))) || (iCodePointAt == 43 && z9))) {
                    Buffer3 buffer33 = new Buffer3();
                    buffer33.m10453c0(str, i4, iCharCount);
                    Buffer3 buffer322 = null;
                    while (iCharCount < length) {
                    }
                    return buffer33.m10429D();
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            String strSubstring2 = str.substring(i4, length);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring2;
        }

        /* JADX INFO: renamed from: d */
        public static String m10414d(b bVar, String str, int i, int i2, boolean z2, int i3) {
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
            Intrinsics3.checkParameterIsNotNull(str, "$this$percentDecode");
            int iCharCount = i;
            while (iCharCount < i2) {
                char cCharAt = str.charAt(iCharCount);
                if (cCharAt == '%' || (cCharAt == '+' && z2)) {
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.m10453c0(str, i, iCharCount);
                    while (iCharCount < i2) {
                        int iCodePointAt = str.codePointAt(iCharCount);
                        if (iCodePointAt == 37 && (i4 = iCharCount + 2) < i2) {
                            int iM10137r = Util7.m10137r(str.charAt(iCharCount + 1));
                            int iM10137r2 = Util7.m10137r(str.charAt(i4));
                            if (iM10137r == -1 || iM10137r2 == -1) {
                                buffer3.m10454d0(iCodePointAt);
                                iCharCount += Character.charCount(iCodePointAt);
                            } else {
                                buffer3.m10444T((iM10137r << 4) + iM10137r2);
                                iCharCount = Character.charCount(iCodePointAt) + i4;
                            }
                        } else if (iCodePointAt == 43 && z2) {
                            buffer3.m10444T(32);
                            iCharCount++;
                        } else {
                            buffer3.m10454d0(iCodePointAt);
                            iCharCount += Character.charCount(iCodePointAt);
                        }
                    }
                    return buffer3.m10429D();
                }
                iCharCount++;
            }
            String strSubstring = str.substring(i, i2);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        /* JADX INFO: renamed from: b */
        public final int m10415b(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "scheme");
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

        /* JADX INFO: renamed from: c */
        public final boolean m10416c(String str, int i, int i2) {
            int i3 = i + 2;
            return i3 < i2 && str.charAt(i) == '%' && Util7.m10137r(str.charAt(i + 1)) != -1 && Util7.m10137r(str.charAt(i3)) != -1;
        }

        /* JADX INFO: renamed from: e */
        public final List<String> m10417e(String str) {
            Intrinsics3.checkParameterIsNotNull(str, "$this$toQueryNamesAndValues");
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i <= str.length()) {
                int iIndexOf$default = Strings4.indexOf$default((CharSequence) str, '&', i, false, 4, (Object) null);
                if (iIndexOf$default == -1) {
                    iIndexOf$default = str.length();
                }
                int i2 = iIndexOf$default;
                int iIndexOf$default2 = Strings4.indexOf$default((CharSequence) str, '=', i, false, 4, (Object) null);
                if (iIndexOf$default2 == -1 || iIndexOf$default2 > i2) {
                    String strSubstring = str.substring(i, i2);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring);
                    arrayList.add(null);
                } else {
                    String strSubstring2 = str.substring(i, iIndexOf$default2);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring2);
                    String strSubstring3 = str.substring(iIndexOf$default2 + 1, i2);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    arrayList.add(strSubstring3);
                }
                i = i2 + 1;
            }
            return arrayList;
        }
    }

    public HttpUrl(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        Intrinsics3.checkParameterIsNotNull(str, "scheme");
        Intrinsics3.checkParameterIsNotNull(str2, "username");
        Intrinsics3.checkParameterIsNotNull(str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        Intrinsics3.checkParameterIsNotNull(str4, "host");
        Intrinsics3.checkParameterIsNotNull(list, "pathSegments");
        Intrinsics3.checkParameterIsNotNull(str6, "url");
        this.f25976d = str;
        this.f25977e = str2;
        this.f25978f = str3;
        this.f25979g = str4;
        this.f25980h = i;
        this.f25981i = list;
        this.f25982j = list2;
        this.f25983k = str5;
        this.f25984l = str6;
        this.f25975c = Intrinsics3.areEqual(str, Constants.SCHEME);
    }

    /* JADX INFO: renamed from: a */
    public final String m10399a() {
        if (this.f25978f.length() == 0) {
            return "";
        }
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.f25984l, MentionUtils.EMOJIS_AND_STICKERS_CHAR, this.f25976d.length() + 3, false, 4, (Object) null) + 1;
        int iIndexOf$default2 = Strings4.indexOf$default((CharSequence) this.f25984l, MentionUtils.MENTIONS_CHAR, 0, false, 6, (Object) null);
        String str = this.f25984l;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iIndexOf$default, iIndexOf$default2);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: renamed from: b */
    public final String m10400b() {
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.f25984l, MentionUtils.SLASH_CHAR, this.f25976d.length() + 3, false, 4, (Object) null);
        String str = this.f25984l;
        int iM10126g = Util7.m10126g(str, "?#", iIndexOf$default, str.length());
        String str2 = this.f25984l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iM10126g);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: renamed from: c */
    public final List<String> m10401c() {
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.f25984l, MentionUtils.SLASH_CHAR, this.f25976d.length() + 3, false, 4, (Object) null);
        String str = this.f25984l;
        int iM10126g = Util7.m10126g(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iM10126g) {
            int i = iIndexOf$default + 1;
            int iM10125f = Util7.m10125f(this.f25984l, MentionUtils.SLASH_CHAR, i, iM10126g);
            String str2 = this.f25984l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i, iM10125f);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iM10125f;
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: d */
    public final String m10402d() {
        if (this.f25982j == null) {
            return null;
        }
        int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.f25984l, '?', 0, false, 6, (Object) null) + 1;
        String str = this.f25984l;
        int iM10125f = Util7.m10125f(str, MentionUtils.CHANNELS_CHAR, iIndexOf$default, str.length());
        String str2 = this.f25984l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iM10125f);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* JADX INFO: renamed from: e */
    public final String m10403e() {
        if (this.f25977e.length() == 0) {
            return "";
        }
        int length = this.f25976d.length() + 3;
        String str = this.f25984l;
        int iM10126g = Util7.m10126g(str, ":@", length, str.length());
        String str2 = this.f25984l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iM10126g);
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof HttpUrl) && Intrinsics3.areEqual(((HttpUrl) obj).f25984l, this.f25984l);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0050  */
    /* JADX INFO: renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final a m10404f() {
        int i;
        String strSubstring;
        a aVar = new a();
        aVar.f25986b = this.f25976d;
        String strM10403e = m10403e();
        Intrinsics3.checkParameterIsNotNull(strM10403e, "<set-?>");
        aVar.f25987c = strM10403e;
        String strM10399a = m10399a();
        Intrinsics3.checkParameterIsNotNull(strM10399a, "<set-?>");
        aVar.f25988d = strM10399a;
        aVar.f25989e = this.f25979g;
        int i2 = this.f25980h;
        String str = this.f25976d;
        Intrinsics3.checkParameterIsNotNull(str, "scheme");
        int iHashCode = str.hashCode();
        if (iHashCode != 3213448) {
            i = (iHashCode == 99617003 && str.equals(Constants.SCHEME)) ? 443 : -1;
        } else if (str.equals("http")) {
            i = 80;
        }
        aVar.f25990f = i2 != i ? this.f25980h : -1;
        aVar.f25991g.clear();
        aVar.f25991g.addAll(m10401c());
        aVar.m10411d(m10402d());
        if (this.f25983k == null) {
            strSubstring = null;
        } else {
            int iIndexOf$default = Strings4.indexOf$default((CharSequence) this.f25984l, MentionUtils.CHANNELS_CHAR, 0, false, 6, (Object) null) + 1;
            String str2 = this.f25984l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(iIndexOf$default);
            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        aVar.f25993i = strSubstring;
        return aVar;
    }

    /* JADX INFO: renamed from: g */
    public final a m10405g(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "link");
        try {
            a aVar = new a();
            aVar.m10412e(this, str);
            return aVar;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: h */
    public final String m10406h() {
        a aVarM10405g = m10405g("/...");
        if (aVarM10405g == null) {
            Intrinsics3.throwNpe();
        }
        Objects.requireNonNull(aVarM10405g);
        Intrinsics3.checkParameterIsNotNull("", "username");
        b bVar = f25974b;
        aVarM10405g.f25987c = b.m10413a(bVar, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        Intrinsics3.checkParameterIsNotNull("", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        aVarM10405g.f25988d = b.m10413a(bVar, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        return aVarM10405g.m10409b().f25984l;
    }

    public int hashCode() {
        return this.f25984l.hashCode();
    }

    /* JADX INFO: renamed from: i */
    public final URI m10407i() {
        a aVarM10404f = m10404f();
        String str = aVarM10404f.f25989e;
        aVarM10404f.f25989e = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
        int size = aVarM10404f.f25991g.size();
        for (int i = 0; i < size; i++) {
            List<String> list = aVarM10404f.f25991g;
            list.set(i, b.m10413a(f25974b, list.get(i), 0, 0, "[]", true, true, false, false, null, 227));
        }
        List<String> list2 = aVarM10404f.f25992h;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = list2.get(i2);
                list2.set(i2, str2 != null ? b.m10413a(f25974b, str2, 0, 0, "\\^`{|}", true, true, true, false, null, Opcodes.MONITOREXIT) : null);
            }
        }
        String str3 = aVarM10404f.f25993i;
        aVarM10404f.f25993i = str3 != null ? b.m10413a(f25974b, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, Opcodes.IF_ICMPGT) : null;
        String string = aVarM10404f.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                Intrinsics3.checkExpressionValueIsNotNull(uriCreate, "URI.create(stripped)");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.f25984l;
    }
}
