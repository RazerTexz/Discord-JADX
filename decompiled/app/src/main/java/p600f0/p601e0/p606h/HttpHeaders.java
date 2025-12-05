package p600f0.p601e0.p606h;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import okio.ByteString;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Challenge;
import p600f0.Cookie;
import p600f0.CookieJar2;
import p600f0.HttpUrl;
import p600f0.p601e0.Util7;
import p615g0.Buffer3;

/* compiled from: HttpHeaders.kt */
/* renamed from: f0.e0.h.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class HttpHeaders {

    /* renamed from: a */
    public static final ByteString f25529a;

    /* renamed from: b */
    public static final ByteString f25530b;

    static {
        ByteString.Companion companion = ByteString.INSTANCE;
        f25529a = companion.m11012c("\"\\");
        f25530b = companion.m11012c("\t ,=");
    }

    /* renamed from: a */
    public static final boolean m10221a(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "$this$promisesBody");
        if (Intrinsics3.areEqual(response.request.method, "HEAD")) {
            return false;
        }
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        return (((i >= 100 && i < 200) || i == 204 || i == 304) && Util7.m10131l(response) == -1 && !StringsJVM.equals("chunked", Response.m10989a(response, "Transfer-Encoding", null, 2), true)) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:82:0x0086, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0086, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0091  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10222b(Buffer3 buffer3, List<Challenge> list) throws EOFException {
        String strM10223c;
        int iM10140u;
        LinkedHashMap linkedHashMap;
        String strM10223c2;
        while (true) {
            String strM10223c3 = null;
            while (true) {
                if (strM10223c3 == null) {
                    m10225e(buffer3);
                    strM10223c3 = m10223c(buffer3);
                    if (strM10223c3 == null) {
                        return;
                    }
                }
                boolean zM10225e = m10225e(buffer3);
                strM10223c = m10223c(buffer3);
                if (strM10223c == null) {
                    if (buffer3.mo10472w()) {
                        list.add(new Challenge(strM10223c3, Maps6.emptyMap()));
                        return;
                    }
                    return;
                }
                byte b2 = (byte) 61;
                iM10140u = Util7.m10140u(buffer3, b2);
                boolean zM10225e2 = m10225e(buffer3);
                if (zM10225e || (!zM10225e2 && !buffer3.mo10472w())) {
                    linkedHashMap = new LinkedHashMap();
                    int iM10140u2 = Util7.m10140u(buffer3, b2) + iM10140u;
                    while (true) {
                        if (strM10223c == null) {
                            strM10223c = m10223c(buffer3);
                            if (m10225e(buffer3)) {
                                break;
                            }
                            iM10140u2 = Util7.m10140u(buffer3, b2);
                            if (iM10140u2 != 0) {
                                break;
                            }
                            if (iM10140u2 > 1 || m10225e(buffer3)) {
                                return;
                            }
                            byte b3 = (byte) 34;
                            if (!buffer3.mo10472w() && buffer3.m10464q(0L) == b3) {
                                if (!(buffer3.readByte() == b3)) {
                                    throw new IllegalArgumentException("Failed requirement.".toString());
                                }
                                Buffer3 buffer32 = new Buffer3();
                                while (true) {
                                    long jMo10430E = buffer3.mo10430E(f25529a);
                                    if (jMo10430E == -1) {
                                        break;
                                    }
                                    if (buffer3.m10464q(jMo10430E) == b3) {
                                        buffer32.write(buffer3, jMo10430E);
                                        buffer3.readByte();
                                        strM10223c2 = buffer32.m10429D();
                                        break;
                                    } else {
                                        if (buffer3.f26080k == jMo10430E + 1) {
                                            break;
                                        }
                                        buffer32.write(buffer3, jMo10430E);
                                        buffer3.readByte();
                                        buffer32.write(buffer3, 1L);
                                    }
                                }
                                strM10223c2 = null;
                            } else {
                                strM10223c2 = m10223c(buffer3);
                            }
                            if (strM10223c2 == null || ((String) linkedHashMap.put(strM10223c, strM10223c2)) != null) {
                                return;
                            }
                            if (!m10225e(buffer3) && !buffer3.mo10472w()) {
                                return;
                            } else {
                                strM10223c = null;
                            }
                        } else if (iM10140u2 != 0) {
                        }
                    }
                }
                list.add(new Challenge(strM10223c3, linkedHashMap));
                strM10223c3 = strM10223c;
            }
            StringBuilder sbM833U = outline.m833U(strM10223c);
            sbM833U.append(StringsJVM.repeat("=", iM10140u));
            Map mapSingletonMap = Collections.singletonMap(null, sbM833U.toString());
            Intrinsics3.checkExpressionValueIsNotNull(mapSingletonMap, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
            list.add(new Challenge(strM10223c3, mapSingletonMap));
        }
    }

    /* renamed from: c */
    public static final String m10223c(Buffer3 buffer3) {
        long jMo10430E = buffer3.mo10430E(f25530b);
        if (jMo10430E == -1) {
            jMo10430E = buffer3.f26080k;
        }
        if (jMo10430E != 0) {
            return buffer3.m10433H(jMo10430E);
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:111:0x0223, code lost:
    
        if (okhttp3.internal.publicsuffix.PublicSuffixDatabase.f27586c.m11002a(r8) == null) goto L112;
     */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c4  */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m10224d(CookieJar2 cookieJar2, HttpUrl httpUrl, Headers headers) {
        int i;
        List listEmptyList;
        List<Cookie> listEmptyList2;
        String str;
        List list;
        int i2;
        String str2;
        Cookie cookie;
        int i3;
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "$this$receiveHeaders");
        String str3 = "url";
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        if (cookieJar2 == CookieJar2.f25956a) {
            return;
        }
        Cookie.a aVar = Cookie.f25946e;
        Intrinsics3.checkParameterIsNotNull(httpUrl, "url");
        Intrinsics3.checkParameterIsNotNull(headers, "headers");
        Objects.requireNonNull(headers);
        Intrinsics3.checkParameterIsNotNull("Set-Cookie", ModelAuditLogEntry.CHANGE_KEY_NAME);
        int size = headers.size();
        int i4 = 0;
        int i5 = 0;
        ArrayList arrayList = null;
        while (true) {
            i = 2;
            if (i5 >= size) {
                break;
            }
            if (StringsJVM.equals("Set-Cookie", headers.m10955d(i5), true)) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(headers.m10957g(i5));
            }
            i5++;
        }
        if (arrayList != null) {
            listEmptyList = Collections.unmodifiableList(arrayList);
            Intrinsics3.checkExpressionValueIsNotNull(listEmptyList, "Collections.unmodifiableList(result)");
        } else {
            listEmptyList = Collections2.emptyList();
        }
        List list2 = listEmptyList;
        int size2 = list2.size();
        int i6 = 0;
        ArrayList arrayList2 = null;
        while (i6 < size2) {
            String str4 = (String) list2.get(i6);
            Intrinsics3.checkParameterIsNotNull(httpUrl, str3);
            Intrinsics3.checkParameterIsNotNull(str4, "setCookie");
            long jCurrentTimeMillis = System.currentTimeMillis();
            Intrinsics3.checkParameterIsNotNull(httpUrl, str3);
            Intrinsics3.checkParameterIsNotNull(str4, "setCookie");
            int iM10127h = Util7.m10127h(str4, ';', i4, i4, 6);
            char c = '=';
            int iM10127h2 = Util7.m10127h(str4, '=', i4, iM10127h, i);
            if (iM10127h2 == iM10127h) {
                str = str3;
                list = list2;
                i2 = size2;
                cookie = null;
            } else {
                String strM10118C = Util7.m10118C(str4, i4, iM10127h2);
                if (!(strM10118C.length() == 0)) {
                    if (Util7.m10133n(strM10118C) != -1) {
                        str = str3;
                        list = list2;
                        i2 = size2;
                    } else {
                        String strM10118C2 = Util7.m10118C(str4, iM10127h2 + 1, iM10127h);
                        if (Util7.m10133n(strM10118C2) == -1) {
                            int i7 = iM10127h + 1;
                            int length = str4.length();
                            long j = 253402300799999L;
                            long jM10387c = 253402300799999L;
                            long j2 = -1;
                            String str5 = null;
                            String str6 = null;
                            boolean z2 = false;
                            boolean z3 = false;
                            boolean z4 = false;
                            boolean z5 = true;
                            while (true) {
                                long j3 = RecyclerView.FOREVER_NS;
                                if (i7 < length) {
                                    String str7 = str3;
                                    List list3 = list2;
                                    int iM10125f = Util7.m10125f(str4, ';', i7, length);
                                    int iM10125f2 = Util7.m10125f(str4, c, i7, iM10125f);
                                    String strM10118C3 = Util7.m10118C(str4, i7, iM10125f2);
                                    String strM10118C4 = iM10125f2 < iM10125f ? Util7.m10118C(str4, iM10125f2 + 1, iM10125f) : "";
                                    int i8 = size2;
                                    if (StringsJVM.equals(strM10118C3, "expires", true)) {
                                        try {
                                            jM10387c = aVar.m10387c(strM10118C4, 0, strM10118C4.length());
                                            i3 = length;
                                            z4 = true;
                                        } catch (NumberFormatException | IllegalArgumentException unused) {
                                            i3 = length;
                                            i7 = iM10125f + 1;
                                            list2 = list3;
                                            str3 = str7;
                                            size2 = i8;
                                            length = i3;
                                            c = '=';
                                        }
                                    } else if (StringsJVM.equals(strM10118C3, "max-age", true)) {
                                        try {
                                            long j4 = Long.parseLong(strM10118C4);
                                            i3 = length;
                                            j2 = j4 > 0 ? j4 : Long.MIN_VALUE;
                                        } catch (NumberFormatException e) {
                                            if (!new Regex("-?\\d+").matches(strM10118C4)) {
                                                i3 = length;
                                                throw e;
                                            }
                                            i3 = length;
                                            try {
                                                if (StringsJVM.startsWith$default(strM10118C4, "-", false, 2, null)) {
                                                    j3 = Long.MIN_VALUE;
                                                }
                                                j2 = j3;
                                            } catch (NumberFormatException | IllegalArgumentException unused2) {
                                                i7 = iM10125f + 1;
                                                list2 = list3;
                                                str3 = str7;
                                                size2 = i8;
                                                length = i3;
                                                c = '=';
                                            }
                                            i7 = iM10125f + 1;
                                            list2 = list3;
                                            str3 = str7;
                                            size2 = i8;
                                            length = i3;
                                            c = '=';
                                        }
                                        z4 = true;
                                    } else {
                                        i3 = length;
                                        if (StringsJVM.equals(strM10118C3, "domain", true)) {
                                            if (!(!StringsJVM.endsWith$default(strM10118C4, ".", false, 2, null))) {
                                                throw new IllegalArgumentException("Failed requirement.".toString());
                                            }
                                            String strM4337r1 = C3404f.m4337r1(Strings4.removePrefix(strM10118C4, "."));
                                            if (strM4337r1 == null) {
                                                throw new IllegalArgumentException();
                                            }
                                            str5 = strM4337r1;
                                            z5 = false;
                                        } else if (StringsJVM.equals(strM10118C3, "path", true)) {
                                            str6 = strM10118C4;
                                        } else if (StringsJVM.equals(strM10118C3, "secure", true)) {
                                            z2 = true;
                                        } else if (StringsJVM.equals(strM10118C3, "httponly", true)) {
                                            z3 = true;
                                        }
                                    }
                                    i7 = iM10125f + 1;
                                    list2 = list3;
                                    str3 = str7;
                                    size2 = i8;
                                    length = i3;
                                    c = '=';
                                } else {
                                    str = str3;
                                    list = list2;
                                    i2 = size2;
                                    if (j2 == Long.MIN_VALUE) {
                                        j = Long.MIN_VALUE;
                                    } else if (j2 != -1) {
                                        if (j2 <= 9223372036854775L) {
                                            j3 = j2 * 1000;
                                        }
                                        long j5 = jCurrentTimeMillis + j3;
                                        if (j5 >= jCurrentTimeMillis && j5 <= 253402300799999L) {
                                            j = j5;
                                        }
                                    } else {
                                        j = jM10387c;
                                    }
                                    String str8 = httpUrl.f25979g;
                                    if (str5 == null) {
                                        str5 = str8;
                                    } else if (aVar.m10386b(str8, str5)) {
                                    }
                                    if (str8.length() != str5.length()) {
                                        PublicSuffixDatabase.C12940a c12940a = PublicSuffixDatabase.f27587d;
                                    }
                                    String strSubstring = AutocompleteViewModel.COMMAND_DISCOVER_TOKEN;
                                    if (str6 == null || !StringsJVM.startsWith$default(str6, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null)) {
                                        String strM10400b = httpUrl.m10400b();
                                        int iLastIndexOf$default = Strings4.lastIndexOf$default((CharSequence) strM10400b, MentionUtils.SLASH_CHAR, 0, false, 6, (Object) null);
                                        if (iLastIndexOf$default != 0) {
                                            if (strM10400b == null) {
                                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                            }
                                            strSubstring = strM10400b.substring(0, iLastIndexOf$default);
                                            Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                        }
                                        str2 = strSubstring;
                                    } else {
                                        str2 = str6;
                                    }
                                    cookie = new Cookie(strM10118C, strM10118C2, j, str5, str2, z2, z3, z4, z5, null);
                                }
                            }
                        }
                    }
                }
                cookie = null;
            }
            if (cookie != null) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(cookie);
            }
            i6++;
            list2 = list;
            str3 = str;
            size2 = i2;
            i4 = 0;
            i = 2;
        }
        if (arrayList2 != null) {
            listEmptyList2 = Collections.unmodifiableList(arrayList2);
            Intrinsics3.checkExpressionValueIsNotNull(listEmptyList2, "Collections.unmodifiableList(cookies)");
        } else {
            listEmptyList2 = Collections2.emptyList();
        }
        if (listEmptyList2.isEmpty()) {
            return;
        }
        cookieJar2.mo8745a(httpUrl, listEmptyList2);
    }

    /* renamed from: e */
    public static final boolean m10225e(Buffer3 buffer3) throws EOFException {
        boolean z2 = false;
        while (!buffer3.mo10472w()) {
            byte bM10464q = buffer3.m10464q(0L);
            if (bM10464q == 9 || bM10464q == 32) {
                buffer3.readByte();
            } else {
                if (bM10464q != 44) {
                    break;
                }
                buffer3.readByte();
                z2 = true;
            }
        }
        return z2;
    }
}
