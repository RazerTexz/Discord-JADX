package i0;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/* compiled from: ParameterHandler.java */
/* loaded from: classes3.dex */
public abstract class t<T> {

    /* compiled from: ParameterHandler.java */
    public static final class a<T> extends t<T> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3745b;
        public final i0.h<T, RequestBody> c;

        public a(Method method, int i, i0.h<T, RequestBody> hVar) {
            this.a = method;
            this.f3745b = i;
            this.c = hVar;
        }

        @Override // i0.t
        public void a(v vVar, T t) {
            if (t == null) {
                throw c0.l(this.a, this.f3745b, "Body parameter value must not be null.", new Object[0]);
            }
            try {
                vVar.m = this.c.convert(t);
            } catch (IOException e) {
                throw c0.m(this.a, e, this.f3745b, "Unable to convert " + t + " to RequestBody", new Object[0]);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class b<T> extends t<T> {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final i0.h<T, String> f3746b;
        public final boolean c;

        public b(String str, i0.h<T, String> hVar, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f3746b = hVar;
            this.c = z2;
        }

        @Override // i0.t
        public void a(v vVar, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f3746b.convert(t)) == null) {
                return;
            }
            vVar.a(this.a, strConvert, this.c);
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class c<T> extends t<Map<String, T>> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3747b;
        public final i0.h<T, String> c;
        public final boolean d;

        public c(Method method, int i, i0.h<T, String> hVar, boolean z2) {
            this.a = method;
            this.f3747b = i;
            this.c = hVar;
            this.d = z2;
        }

        @Override // i0.t
        public void a(v vVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw c0.l(this.a, this.f3747b, "Field map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw c0.l(this.a, this.f3747b, "Field map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw c0.l(this.a, this.f3747b, b.d.b.a.a.y("Field map contained null value for key '", str, "'."), new Object[0]);
                }
                String str2 = (String) this.c.convert(value);
                if (str2 == null) {
                    throw c0.l(this.a, this.f3747b, "Field map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                vVar.a(str, str2, this.d);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class d<T> extends t<T> {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final i0.h<T, String> f3748b;

        public d(String str, i0.h<T, String> hVar) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f3748b = hVar;
        }

        @Override // i0.t
        public void a(v vVar, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f3748b.convert(t)) == null) {
                return;
            }
            vVar.b(this.a, strConvert);
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class e<T> extends t<Map<String, T>> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3749b;
        public final i0.h<T, String> c;

        public e(Method method, int i, i0.h<T, String> hVar) {
            this.a = method;
            this.f3749b = i;
            this.c = hVar;
        }

        @Override // i0.t
        public void a(v vVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw c0.l(this.a, this.f3749b, "Header map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw c0.l(this.a, this.f3749b, "Header map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw c0.l(this.a, this.f3749b, b.d.b.a.a.y("Header map contained null value for key '", str, "'."), new Object[0]);
                }
                vVar.b(str, (String) this.c.convert(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class f extends t<Headers> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3750b;

        public f(Method method, int i) {
            this.a = method;
            this.f3750b = i;
        }

        @Override // i0.t
        public void a(v vVar, Headers headers) throws IOException {
            Headers headers2 = headers;
            if (headers2 == null) {
                throw c0.l(this.a, this.f3750b, "Headers parameter must not be null.", new Object[0]);
            }
            Headers.a aVar = vVar.h;
            Objects.requireNonNull(aVar);
            d0.z.d.m.checkParameterIsNotNull(headers2, "headers");
            int size = headers2.size();
            for (int i = 0; i < size; i++) {
                aVar.b(headers2.d(i), headers2.g(i));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class g<T> extends t<T> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3751b;
        public final Headers c;
        public final i0.h<T, RequestBody> d;

        public g(Method method, int i, Headers headers, i0.h<T, RequestBody> hVar) {
            this.a = method;
            this.f3751b = i;
            this.c = headers;
            this.d = hVar;
        }

        @Override // i0.t
        public void a(v vVar, T t) {
            if (t == null) {
                return;
            }
            try {
                vVar.c(this.c, this.d.convert(t));
            } catch (IOException e) {
                throw c0.l(this.a, this.f3751b, "Unable to convert " + t + " to RequestBody", e);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class h<T> extends t<Map<String, T>> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3752b;
        public final i0.h<T, RequestBody> c;
        public final String d;

        public h(Method method, int i, i0.h<T, RequestBody> hVar, String str) {
            this.a = method;
            this.f3752b = i;
            this.c = hVar;
            this.d = str;
        }

        @Override // i0.t
        public void a(v vVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw c0.l(this.a, this.f3752b, "Part map was null.", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw c0.l(this.a, this.f3752b, "Part map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw c0.l(this.a, this.f3752b, b.d.b.a.a.y("Part map contained null value for key '", str, "'."), new Object[0]);
                }
                vVar.c(Headers.INSTANCE.c("Content-Disposition", b.d.b.a.a.y("form-data; name=\"", str, "\""), "Content-Transfer-Encoding", this.d), (RequestBody) this.c.convert(value));
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class i<T> extends t<T> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3753b;
        public final String c;
        public final i0.h<T, String> d;
        public final boolean e;

        public i(Method method, int i, String str, i0.h<T, String> hVar, boolean z2) {
            this.a = method;
            this.f3753b = i;
            Objects.requireNonNull(str, "name == null");
            this.c = str;
            this.d = hVar;
            this.e = z2;
        }

        /* JADX WARN: Removed duplicated region for block: B:52:0x00e7  */
        /* JADX WARN: Removed duplicated region for block: B:54:0x00ea  */
        @Override // i0.t
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(v vVar, T t) throws IOException {
            String strD;
            String strReplace;
            if (t == null) {
                throw c0.l(this.a, this.f3753b, b.d.b.a.a.J(b.d.b.a.a.U("Path parameter \""), this.c, "\" value must not be null."), new Object[0]);
            }
            String str = this.c;
            String strConvert = this.d.convert(t);
            boolean z2 = this.e;
            if (vVar.e == null) {
                throw new AssertionError();
            }
            int length = strConvert.length();
            int iCharCount = 0;
            while (iCharCount < length) {
                int iCodePointAt = strConvert.codePointAt(iCharCount);
                int i = 47;
                int i2 = -1;
                if (iCodePointAt < 32 || iCodePointAt >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt) != -1 || (!z2 && (iCodePointAt == 47 || iCodePointAt == 37))) {
                    g0.e eVar = new g0.e();
                    eVar.c0(strConvert, 0, iCharCount);
                    g0.e eVar2 = null;
                    while (iCharCount < length) {
                        int iCodePointAt2 = strConvert.codePointAt(iCharCount);
                        if (!z2 || (iCodePointAt2 != 9 && iCodePointAt2 != 10 && iCodePointAt2 != 12 && iCodePointAt2 != 13)) {
                            if (iCodePointAt2 < 32 || iCodePointAt2 >= 127 || " \"<>^`{}|\\?#".indexOf(iCodePointAt2) != i2 || (!z2 && (iCodePointAt2 == i || iCodePointAt2 == 37))) {
                                if (eVar2 == null) {
                                    eVar2 = new g0.e();
                                }
                                eVar2.d0(iCodePointAt2);
                                while (!eVar2.w()) {
                                    int i3 = eVar2.readByte() & 255;
                                    eVar.T(37);
                                    char[] cArr = v.a;
                                    eVar.T(cArr[(i3 >> 4) & 15]);
                                    eVar.T(cArr[i3 & 15]);
                                }
                            } else {
                                eVar.d0(iCodePointAt2);
                            }
                        }
                        iCharCount += Character.charCount(iCodePointAt2);
                        i = 47;
                        i2 = -1;
                    }
                    strD = eVar.D();
                    strReplace = vVar.e.replace("{" + str + "}", strD);
                    if (!v.f3759b.matcher(strReplace).matches()) {
                        throw new IllegalArgumentException(b.d.b.a.a.w("@Path parameters shouldn't perform path traversal ('.' or '..'): ", strConvert));
                    }
                    vVar.e = strReplace;
                    return;
                }
                iCharCount += Character.charCount(iCodePointAt);
            }
            strD = strConvert;
            strReplace = vVar.e.replace("{" + str + "}", strD);
            if (!v.f3759b.matcher(strReplace).matches()) {
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class j<T> extends t<T> {
        public final String a;

        /* renamed from: b, reason: collision with root package name */
        public final i0.h<T, String> f3754b;
        public final boolean c;

        public j(String str, i0.h<T, String> hVar, boolean z2) {
            Objects.requireNonNull(str, "name == null");
            this.a = str;
            this.f3754b = hVar;
            this.c = z2;
        }

        @Override // i0.t
        public void a(v vVar, T t) throws IOException {
            String strConvert;
            if (t == null || (strConvert = this.f3754b.convert(t)) == null) {
                return;
            }
            vVar.d(this.a, strConvert, this.c);
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class k<T> extends t<Map<String, T>> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3755b;
        public final i0.h<T, String> c;
        public final boolean d;

        public k(Method method, int i, i0.h<T, String> hVar, boolean z2) {
            this.a = method;
            this.f3755b = i;
            this.c = hVar;
            this.d = z2;
        }

        @Override // i0.t
        public void a(v vVar, Object obj) throws IOException {
            Map map = (Map) obj;
            if (map == null) {
                throw c0.l(this.a, this.f3755b, "Query map was null", new Object[0]);
            }
            for (Map.Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (str == null) {
                    throw c0.l(this.a, this.f3755b, "Query map contained null key.", new Object[0]);
                }
                Object value = entry.getValue();
                if (value == null) {
                    throw c0.l(this.a, this.f3755b, b.d.b.a.a.y("Query map contained null value for key '", str, "'."), new Object[0]);
                }
                String str2 = (String) this.c.convert(value);
                if (str2 == null) {
                    throw c0.l(this.a, this.f3755b, "Query map value '" + value + "' converted to null by " + this.c.getClass().getName() + " for key '" + str + "'.", new Object[0]);
                }
                vVar.d(str, str2, this.d);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class l<T> extends t<T> {
        public final i0.h<T, String> a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f3756b;

        public l(i0.h<T, String> hVar, boolean z2) {
            this.a = hVar;
            this.f3756b = z2;
        }

        @Override // i0.t
        public void a(v vVar, T t) throws IOException {
            if (t == null) {
                return;
            }
            vVar.d(this.a.convert(t), null, this.f3756b);
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class m extends t<MultipartBody.Part> {
        public static final m a = new m();

        @Override // i0.t
        public void a(v vVar, MultipartBody.Part part) throws IOException {
            MultipartBody.Part part2 = part;
            if (part2 != null) {
                vVar.k.a(part2);
            }
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class n extends t<Object> {
        public final Method a;

        /* renamed from: b, reason: collision with root package name */
        public final int f3757b;

        public n(Method method, int i) {
            this.a = method;
            this.f3757b = i;
        }

        @Override // i0.t
        public void a(v vVar, Object obj) {
            if (obj == null) {
                throw c0.l(this.a, this.f3757b, "@Url parameter is null.", new Object[0]);
            }
            Objects.requireNonNull(vVar);
            vVar.e = obj.toString();
        }
    }

    /* compiled from: ParameterHandler.java */
    public static final class o<T> extends t<T> {
        public final Class<T> a;

        public o(Class<T> cls) {
            this.a = cls;
        }

        @Override // i0.t
        public void a(v vVar, T t) {
            vVar.g.e(this.a, t);
        }
    }

    public abstract void a(v vVar, T t) throws IOException;
}
