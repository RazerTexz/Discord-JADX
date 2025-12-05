package p630i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p615g0.Buffer3;

/* compiled from: ParameterHandler.java */
/* renamed from: i0.t, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ParameterHandler3<T> {

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$a */
    public static final class a<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final Method f26571a;

        /* renamed from: b */
        public final int f26572b;

        /* renamed from: c */
        public final Converter2<T, RequestBody> f26573c;

        public a(Method method, int i, Converter2<T, RequestBody> converter2) {
            this.f26571a = method;
            this.f26572b = i;
            this.f26573c = converter2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                throw Utils8.m10692l(this.f26571a, this.f26572b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                requestBuilder.f26630m = this.f26573c.convert(t);
            } catch (IOException e) {
                throw Utils8.m10693m(this.f26571a, e, this.f26572b, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$b */
    public static final class b<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final String f26574a;

        /* renamed from: b */
        public final Converter2<T, String> f26575b;

        /* renamed from: c */
        public final boolean f26576c;

        public b(String str, Converter2<T, String> converter2, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f26574a = str;
            this.f26575b = converter2;
            this.f26576c = z2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f26575b.convert(t)) == null) {
                return;
            }
            requestBuilder.m10718a(this.f26574a, strConvert, this.f26576c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$c */
    public static final class c<T> extends ParameterHandler3<Map<String, T>> {

        /* renamed from: a */
        public final Method f26577a;

        /* renamed from: b */
        public final int f26578b;

        /* renamed from: c */
        public final Converter2<T, String> f26579c;

        /* renamed from: d */
        public final boolean f26580d;

        public c(Method method, int i, Converter2<T, String> converter2, boolean z2) {
            this.f26577a = method;
            this.f26578b = i;
            this.f26579c = converter2;
            this.f26580d = z2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.m10692l(this.f26577a, this.f26578b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.m10692l(this.f26577a, this.f26578b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.m10692l(this.f26577a, this.f26578b, outline.m886y("Field map contained null value for key '", str, "'."), new Object[0]);
                }
                String str2 = (String) this.f26579c.convert(value);
                if (str2 == null) {
                    throw Utils8.m10692l(this.f26577a, this.f26578b, "Field map value '" + value + "' converted to null by " + this.f26579c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.m10718a(str, str2, this.f26580d);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$d */
    public static final class d<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final String f26581a;

        /* renamed from: b */
        public final Converter2<T, String> f26582b;

        public d(String str, Converter2<T, String> converter2) {
            Objects.requireNonNull(str, "name == null");
            this.f26581a = str;
            this.f26582b = converter2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f26582b.convert(t)) == null) {
                return;
            }
            requestBuilder.m10719b(this.f26581a, strConvert);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$e */
    public static final class e<T> extends ParameterHandler3<Map<String, T>> {

        /* renamed from: a */
        public final Method f26583a;

        /* renamed from: b */
        public final int f26584b;

        /* renamed from: c */
        public final Converter2<T, String> f26585c;

        public e(Method method, int i, Converter2<T, String> converter2) {
            this.f26583a = method;
            this.f26584b = i;
            this.f26585c = converter2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.m10692l(this.f26583a, this.f26584b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.m10692l(this.f26583a, this.f26584b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.m10692l(this.f26583a, this.f26584b, outline.m886y("Header map contained null value for key '", str, "'."), new Object[0]);
                }
                requestBuilder.m10719b(str, (String) this.f26585c.convert(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$f */
    public static final class f extends ParameterHandler3<Headers> {

        /* renamed from: a */
        public final Method f26586a;

        /* renamed from: b */
        public final int f26587b;

        public f(Method method, int i) {
            this.f26586a = method;
            this.f26587b = i;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, Headers headers) throws IOException {
            Headers headers2 = headers;
            if (headers2 == null) {
                throw Utils8.m10692l(this.f26586a, this.f26587b, "Headers parameter must not be null.", new Object[0]);
            }
            Headers.C12930a c12930a = requestBuilder.f26625h;
            Objects.requireNonNull(c12930a);
            Intrinsics3.checkParameterIsNotNull(headers2, "headers");
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                c12930a.m10959b(headers2.m10955d(i), headers2.m10957g(i));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$g */
    public static final class g<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final Method f26588a;

        /* renamed from: b */
        public final int f26589b;

        /* renamed from: c */
        public final Headers f26590c;

        /* renamed from: d */
        public final Converter2<T, RequestBody> f26591d;

        public g(Method method, int i, Headers headers, Converter2<T, RequestBody> converter2) {
            this.f26588a = method;
            this.f26589b = i;
            this.f26590c = headers;
            this.f26591d = converter2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) {
            if (t == null) {
                return;
            }
            try {
                requestBuilder.m10720c(this.f26590c, this.f26591d.convert(t));
            } catch (IOException e) {
                throw Utils8.m10692l(this.f26588a, this.f26589b, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$h */
    public static final class h<T> extends ParameterHandler3<Map<String, T>> {

        /* renamed from: a */
        public final Method f26592a;

        /* renamed from: b */
        public final int f26593b;

        /* renamed from: c */
        public final Converter2<T, RequestBody> f26594c;

        /* renamed from: d */
        public final String f26595d;

        public h(Method method, int i, Converter2<T, RequestBody> converter2, String str) {
            this.f26592a = method;
            this.f26593b = i;
            this.f26594c = converter2;
            this.f26595d = str;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.m10692l(this.f26592a, this.f26593b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.m10692l(this.f26592a, this.f26593b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.m10692l(this.f26592a, this.f26593b, outline.m886y("Part map contained null value for key '", str, "'."), new Object[0]);
                }
                requestBuilder.m10720c(Headers.INSTANCE.m10964c("Content-Disposition", outline.m886y("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.f26595d), (RequestBody) this.f26594c.convert(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$i */
    public static final class i<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final Method f26596a;

        /* renamed from: b */
        public final int f26597b;

        /* renamed from: c */
        public final String f26598c;

        /* renamed from: d */
        public final Converter2<T, String> f26599d;

        /* renamed from: e */
        public final boolean f26600e;

        public i(Method method, int i, String str, Converter2<T, String> converter2, boolean z2) {
            this.f26596a = method;
            this.f26597b = i;
            Objects.requireNonNull(str, "name == null");
            this.f26598c = str;
            this.f26599d = converter2;
            this.f26600e = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ea  */
        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void mo10715a(RequestBuilder requestBuilder, T t) throws IOException {
            String strM10429D;
            String strReplace;
            if (t == null) {
                throw Utils8.m10692l(this.f26596a, this.f26597b, outline.m822J(outline.m833U("Path parameter \""), this.f26598c, "\" value must not be null."), new Object[0]);
            }
            String str = this.f26598c;
            String strConvert = this.f26599d.convert(t);
            boolean z2 = this.f26600e;
            if (requestBuilder.f26622e == null) {
                throw new AssertionError();
            }
            int length = strConvert.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = strConvert.codePointAt(iCharCount);
                int i = 47;
                int i2 = -1;
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    Buffer3 buffer3 = new Buffer3();
                    buffer3.m10453c0(strConvert, 0, iCharCount);
                    Buffer3 buffer32 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = strConvert.codePointAt(iCharCount);
                        if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != i2 || (!z2 && (iCodePointAt2 == i || iCodePointAt2 == 37))) {
                                if (buffer32 == null) {
                                    buffer32 = new Buffer3();
                                }
                                buffer32.m10454d0(iCodePointAt2);
                                while (!buffer32.mo10472w()) {
                                    int i3 = buffer32.readByte() & 255;
                                    buffer3.m10444T(37);
                                    char[] cArr = RequestBuilder.f26618a;
                                    buffer3.m10444T(cArr[(i3 >> 4) & 15]);
                                    buffer3.m10444T(cArr[i3 & 15]);
                                }
                            } else {
                                buffer3.m10454d0(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i = 47;
                        i2 = -1;
                    }
                    strM10429D = buffer3.m10429D();
                    strReplace = requestBuilder.f26622e.replace("{" + str + "}", strM10429D);
                    if (!RequestBuilder.f26619b.matcher(strReplace).matches()) {
                        throw new IllegalArgumentException(outline.m883w("@Path parameters shouldn't perform path traversal ('.' or '..'): ", strConvert));
                    }
                    requestBuilder.f26622e = strReplace;
                    return;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            strM10429D = strConvert;
            strReplace = requestBuilder.f26622e.replace("{" + str + "}", strM10429D);
            if (!RequestBuilder.f26619b.matcher(strReplace).matches()) {
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$j */
    public static final class j<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final String f26601a;

        /* renamed from: b */
        public final Converter2<T, String> f26602b;

        /* renamed from: c */
        public final boolean f26603c;

        public j(String str, Converter2<T, String> converter2, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.f26601a = str;
            this.f26602b = converter2;
            this.f26603c = z2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f26602b.convert(t)) == null) {
                return;
            }
            requestBuilder.m10721d(this.f26601a, strConvert, this.f26603c);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$k */
    public static final class k<T> extends ParameterHandler3<Map<String, T>> {

        /* renamed from: a */
        public final Method f26604a;

        /* renamed from: b */
        public final int f26605b;

        /* renamed from: c */
        public final Converter2<T, String> f26606c;

        /* renamed from: d */
        public final boolean f26607d;

        public k(Method method, int i, Converter2<T, String> converter2, boolean z2) {
            this.f26604a = method;
            this.f26605b = i;
            this.f26606c = converter2;
            this.f26607d = z2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw Utils8.m10692l(this.f26604a, this.f26605b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw Utils8.m10692l(this.f26604a, this.f26605b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw Utils8.m10692l(this.f26604a, this.f26605b, outline.m886y("Query map contained null value for key '", str, "'."), new Object[0]);
                }
                String str2 = (String) this.f26606c.convert(value);
                if (str2 == null) {
                    throw Utils8.m10692l(this.f26604a, this.f26605b, "Query map value '" + value + "' converted to null by " + this.f26606c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                requestBuilder.m10721d(str, str2, this.f26607d);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$l */
    public static final class l<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final Converter2<T, String> f26608a;

        /* renamed from: b */
        public final boolean f26609b;

        public l(Converter2<T, String> converter2, boolean z2) {
            this.f26608a = converter2;
            this.f26609b = z2;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) throws IOException {
            if (t == null) {
                return;
            }
            requestBuilder.m10721d(this.f26608a.convert(t), null, this.f26609b);
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$m */
    public static final class m extends ParameterHandler3<MultipartBody.Part> {

        /* renamed from: a */
        public static final m f26610a = new m();

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                requestBuilder.f26628k.m10972a(part2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$n */
    public static final class n extends ParameterHandler3<Object> {

        /* renamed from: a */
        public final Method f26611a;

        /* renamed from: b */
        public final int f26612b;

        public n(Method method, int i) {
            this.f26611a = method;
            this.f26612b = i;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, Object obj) {
            if (obj == null) {
                throw Utils8.m10692l(this.f26611a, this.f26612b, "@Url parameter is null.", new Object[0]);
            }
            Objects.requireNonNull(requestBuilder);
            requestBuilder.f26622e = obj.toString();
        }
    }

    /* compiled from: ParameterHandler.java */
    /* renamed from: i0.t$o */
    public static final class o<T> extends ParameterHandler3<T> {

        /* renamed from: a */
        public final Class<T> f26613a;

        public o(Class<T> cls) {
            this.f26613a = cls;
        }

        @Override // p630i0.ParameterHandler3
        /* renamed from: a */
        public void mo10715a(RequestBuilder requestBuilder, T t) {
            requestBuilder.f26624g.m10982e(this.f26613a, t);
        }
    }

    /* renamed from: a */
    public abstract void mo10715a(RequestBuilder requestBuilder, T t) throws IOException;
}
