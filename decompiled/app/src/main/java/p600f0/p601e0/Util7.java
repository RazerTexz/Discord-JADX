package p600f0.p601e0;

import androidx.recyclerview.widget.RecyclerView;
import com.adjust.sdk.Constants;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.MentionUtils;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import okhttp3.Headers;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.ByteString;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Charsets2;
import p507d0.p579g0.Strings4;
import p507d0.p580t.Maps6;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.ResponseBody2;
import p600f0.p601e0.p608j.Header2;
import p615g0.Buffer3;
import p615g0.BufferedSource;
import p615g0.Options2;
import p615g0.Source2;

/* compiled from: Util.kt */
/* renamed from: f0.e0.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class Util7 {

    /* renamed from: a */
    public static final byte[] f25397a;

    /* renamed from: b */
    public static final Headers f25398b = Headers.INSTANCE.m10964c(new String[0]);

    /* renamed from: c */
    public static final ResponseBody f25399c;

    /* renamed from: d */
    public static final Options2 f25400d;

    /* renamed from: e */
    public static final TimeZone f25401e;

    /* renamed from: f */
    public static final Regex f25402f;

    /* renamed from: g */
    public static final String f25403g;

    static {
        byte[] bArr = new byte[0];
        f25397a = bArr;
        Intrinsics3.checkParameterIsNotNull(bArr, "$this$toResponseBody");
        Buffer3 buffer3 = new Buffer3();
        buffer3.m10442R(bArr);
        Intrinsics3.checkParameterIsNotNull(buffer3, "$this$asResponseBody");
        f25399c = new ResponseBody2(buffer3, null, 0);
        RequestBody.Companion.m10986d(RequestBody.INSTANCE, bArr, null, 0, 0, 7);
        Options2.a aVar = Options2.f26106k;
        ByteString.Companion companion = ByteString.INSTANCE;
        f25400d = aVar.m10491c(companion.m11010a("efbbbf"), companion.m11010a("feff"), companion.m11010a("fffe"), companion.m11010a("0000ffff"), companion.m11010a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        if (timeZone == null) {
            Intrinsics3.throwNpe();
        }
        f25401e = timeZone;
        f25402f = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        String name = OkHttpClient.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name, "OkHttpClient::class.java.name");
        f25403g = Strings4.removeSuffix(Strings4.removePrefix(name, "okhttp3."), "Client");
    }

    /* renamed from: A */
    public static final <K, V> Map<K, V> m10116A(Map<K, ? extends V> map) {
        Intrinsics3.checkParameterIsNotNull(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return Maps6.emptyMap();
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics3.checkExpressionValueIsNotNull(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    /* renamed from: B */
    public static final int m10117B(String str, int i) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    /* renamed from: C */
    public static final String m10118C(String str, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$trimSubstring");
        int iM10134o = m10134o(str, i, i2);
        String strSubstring = str.substring(iM10134o, m10135p(str, iM10134o, i2));
        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    /* renamed from: D */
    public static final Throwable m10119D(Exception exc, List<? extends Exception> list) {
        Intrinsics3.checkParameterIsNotNull(exc, "$this$withSuppressed");
        Intrinsics3.checkParameterIsNotNull(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            exc.addSuppressed(it.next());
        }
        return exc;
    }

    /* renamed from: a */
    public static final boolean m10120a(HttpUrl httpUrl, HttpUrl httpUrl2) {
        Intrinsics3.checkParameterIsNotNull(httpUrl, "$this$canReuseConnectionFor");
        Intrinsics3.checkParameterIsNotNull(httpUrl2, "other");
        return Intrinsics3.areEqual(httpUrl.f25979g, httpUrl2.f25979g) && httpUrl.f25980h == httpUrl2.f25980h && Intrinsics3.areEqual(httpUrl.f25976d, httpUrl2.f25976d);
    }

    /* renamed from: b */
    public static final int m10121b(String str, long j, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        if (!(j >= 0)) {
            throw new IllegalStateException(outline.m883w(str, " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(outline.m883w(str, " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(outline.m883w(str, " too small.").toString());
    }

    /* renamed from: c */
    public static final void m10122c(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /* renamed from: d */
    public static final void m10123d(Closeable closeable) {
        Intrinsics3.checkParameterIsNotNull(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    /* renamed from: e */
    public static final void m10124e(Socket socket) {
        Intrinsics3.checkParameterIsNotNull(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    /* renamed from: f */
    public static final int m10125f(String str, char c, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: g */
    public static final int m10126g(String str, String str2, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$delimiterOffset");
        Intrinsics3.checkParameterIsNotNull(str2, "delimiters");
        while (i < i2) {
            if (Strings4.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: h */
    public static /* synthetic */ int m10127h(String str, char c, int i, int i2, int i3) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return m10125f(str, c, i, i2);
    }

    /* renamed from: i */
    public static final boolean m10128i(Source2 source2, int i, TimeUnit timeUnit) {
        Intrinsics3.checkParameterIsNotNull(source2, "$this$discard");
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        try {
            return m10141v(source2, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: j */
    public static final String m10129j(String str, Object... objArr) {
        Intrinsics3.checkParameterIsNotNull(str, "format");
        Intrinsics3.checkParameterIsNotNull(objArr, "args");
        Locale locale = Locale.US;
        Intrinsics3.checkExpressionValueIsNotNull(locale, "Locale.US");
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        Intrinsics3.checkExpressionValueIsNotNull(str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    /* renamed from: k */
    public static final boolean m10130k(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics3.checkParameterIsNotNull(strArr, "$this$hasIntersection");
        Intrinsics3.checkParameterIsNotNull(comparator, "comparator");
        if (!(strArr.length == 0) && strArr2 != null) {
            if (!(strArr2.length == 0)) {
                for (String str : strArr) {
                    for (String str2 : strArr2) {
                        if (comparator.compare(str, str2) == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: l */
    public static final long m10131l(Response response) {
        Intrinsics3.checkParameterIsNotNull(response, "$this$headersContentLength");
        String strM10954c = response.headers.m10954c("Content-Length");
        if (strM10954c != null) {
            Intrinsics3.checkParameterIsNotNull(strM10954c, "$this$toLongOrDefault");
            try {
                return Long.parseLong(strM10954c);
            } catch (NumberFormatException unused) {
            }
        }
        return -1L;
    }

    @SafeVarargs
    /* renamed from: m */
    public static final <T> List<T> m10132m(T... tArr) {
        Intrinsics3.checkParameterIsNotNull(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics3.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiable…sList(*elements.clone()))");
        return listUnmodifiableList;
    }

    /* renamed from: n */
    public static final int m10133n(String str) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt <= 31 || cCharAt >= 127) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: o */
    public static final int m10134o(String str, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    /* renamed from: p */
    public static final int m10135p(String str, int i, int i2) {
        Intrinsics3.checkParameterIsNotNull(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    /* renamed from: q */
    public static final String[] m10136q(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        Intrinsics3.checkParameterIsNotNull(strArr, "$this$intersect");
        Intrinsics3.checkParameterIsNotNull(strArr2, "other");
        Intrinsics3.checkParameterIsNotNull(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: r */
    public static final int m10137r(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        char c2 = 'a';
        if ('a' > c || 'f' < c) {
            c2 = 'A';
            if ('A' > c || 'F' < c) {
                return -1;
            }
        }
        return (c - c2) + 10;
    }

    /* renamed from: s */
    public static final Charset m10138s(BufferedSource bufferedSource, Charset charset) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "$this$readBomAsCharset");
        Intrinsics3.checkParameterIsNotNull(charset, "default");
        int iMo10471v0 = bufferedSource.mo10471v0(f25400d);
        if (iMo10471v0 == -1) {
            return charset;
        }
        if (iMo10471v0 == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            Intrinsics3.checkExpressionValueIsNotNull(charset2, "UTF_8");
            return charset2;
        }
        if (iMo10471v0 == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            Intrinsics3.checkExpressionValueIsNotNull(charset3, "UTF_16BE");
            return charset3;
        }
        if (iMo10471v0 == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            Intrinsics3.checkExpressionValueIsNotNull(charset4, "UTF_16LE");
            return charset4;
        }
        if (iMo10471v0 == 3) {
            return Charsets2.f25139d.UTF32_BE();
        }
        if (iMo10471v0 == 4) {
            return Charsets2.f25139d.UTF32_LE();
        }
        throw new AssertionError();
    }

    /* renamed from: t */
    public static final int m10139t(BufferedSource bufferedSource) throws IOException {
        Intrinsics3.checkParameterIsNotNull(bufferedSource, "$this$readMedium");
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* renamed from: u */
    public static final int m10140u(Buffer3 buffer3, byte b2) throws EOFException {
        Intrinsics3.checkParameterIsNotNull(buffer3, "$this$skipAll");
        int i = 0;
        while (!buffer3.mo10472w() && buffer3.m10464q(0L) == b2) {
            i++;
            buffer3.readByte();
        }
        return i;
    }

    /* renamed from: v */
    public static final boolean m10141v(Source2 source2, int i, TimeUnit timeUnit) throws IOException {
        boolean z2;
        Intrinsics3.checkParameterIsNotNull(source2, "$this$skipAll");
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jMo10480c = source2.timeout().mo10482e() ? source2.timeout().mo10480c() - jNanoTime : Long.MAX_VALUE;
        source2.timeout().mo10481d(Math.min(jMo10480c, timeUnit.toNanos(i)) + jNanoTime);
        try {
            Buffer3 buffer3 = new Buffer3();
            while (source2.mo10176i0(buffer3, Permission.MANAGE_MESSAGES) != -1) {
                buffer3.skip(buffer3.f26080k);
            }
            z2 = true;
        } catch (InterruptedIOException unused) {
            z2 = false;
            if (jMo10480c == RecyclerView.FOREVER_NS) {
            }
        } catch (Throwable th) {
            if (jMo10480c == RecyclerView.FOREVER_NS) {
                source2.timeout().mo10478a();
            } else {
                source2.timeout().mo10481d(jNanoTime + jMo10480c);
            }
            throw th;
        }
        if (jMo10480c == RecyclerView.FOREVER_NS) {
            source2.timeout().mo10478a();
        } else {
            source2.timeout().mo10481d(jNanoTime + jMo10480c);
        }
        return z2;
    }

    /* renamed from: w */
    public static final Headers m10142w(List<Header2> list) {
        Intrinsics3.checkParameterIsNotNull(list, "$this$toHeaders");
        ArrayList arrayList = new ArrayList(20);
        for (Header2 header2 : list) {
            ByteString byteString = header2.f25587h;
            ByteString byteString2 = header2.f25588i;
            String strM11008q = byteString.m11008q();
            String strM11008q2 = byteString2.m11008q();
            Intrinsics3.checkParameterIsNotNull(strM11008q, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkParameterIsNotNull(strM11008q2, "value");
            arrayList.add(strM11008q);
            arrayList.add(Strings4.trim(strM11008q2).toString());
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return new Headers((String[]) array, null);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    /* renamed from: x */
    public static final String m10143x(int i) {
        String hexString = Integer.toHexString(i);
        Intrinsics3.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(this)");
        return hexString;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* renamed from: y */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final String m10144y(HttpUrl httpUrl, boolean z2) {
        int i;
        Intrinsics3.checkParameterIsNotNull(httpUrl, "$this$toHostHeader");
        String strM820H = Strings4.contains$default((CharSequence) httpUrl.f25979g, (CharSequence) ":", false, 2, (Object) null) ? outline.m820H(outline.m829Q('['), httpUrl.f25979g, ']') : httpUrl.f25979g;
        if (!z2) {
            int i2 = httpUrl.f25980h;
            String str = httpUrl.f25976d;
            Intrinsics3.checkParameterIsNotNull(str, "scheme");
            int iHashCode = str.hashCode();
            if (iHashCode != 3213448) {
                i = (iHashCode == 99617003 && str.equals(Constants.SCHEME)) ? 443 : -1;
                if (i2 == i) {
                    return strM820H;
                }
            } else {
                if (str.equals("http")) {
                    i = 80;
                }
                if (i2 == i) {
                }
            }
        }
        return strM820H + MentionUtils.EMOJIS_AND_STICKERS_CHAR + httpUrl.f25980h;
    }

    /* renamed from: z */
    public static final <T> List<T> m10145z(List<? extends T> list) {
        Intrinsics3.checkParameterIsNotNull(list, "$this$toImmutableList");
        List<T> listUnmodifiableList = Collections.unmodifiableList(_Collections.toMutableList((Collection) list));
        Intrinsics3.checkExpressionValueIsNotNull(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }
}
