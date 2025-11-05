package i0;

import androidx.browser.trusted.sharing.ShareTarget;
import f0.e;
import i0.c0;
import i0.j;
import i0.t;
import i0.w;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.net.URI;
import java.util.Map;
import kotlin.coroutines.Continuation;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

/* compiled from: ServiceMethod.java */
/* loaded from: classes3.dex */
public abstract class z<T> {
    public static <T> z<T> b(y yVar, Method method) throws CloneNotSupportedException {
        Type genericReturnType;
        boolean z2;
        int i;
        int i2;
        t<?> tVar;
        int i3;
        int i4;
        int i5;
        int i6;
        t<?> oVar;
        t<?> gVar;
        t<?> sVar;
        t<?> cVar;
        t<?> bVar;
        w.a aVar = new w.a(yVar, method);
        for (Annotation annotation : aVar.e) {
            if (annotation instanceof i0.f0.b) {
                aVar.b("DELETE", ((i0.f0.b) annotation).value(), false);
            } else if (annotation instanceof i0.f0.f) {
                aVar.b(ShareTarget.METHOD_GET, ((i0.f0.f) annotation).value(), false);
            } else if (annotation instanceof i0.f0.g) {
                aVar.b("HEAD", ((i0.f0.g) annotation).value(), false);
            } else if (annotation instanceof i0.f0.n) {
                aVar.b("PATCH", ((i0.f0.n) annotation).value(), true);
            } else if (annotation instanceof i0.f0.o) {
                aVar.b(ShareTarget.METHOD_POST, ((i0.f0.o) annotation).value(), true);
            } else if (annotation instanceof i0.f0.p) {
                aVar.b("PUT", ((i0.f0.p) annotation).value(), true);
            } else if (annotation instanceof i0.f0.m) {
                aVar.b("OPTIONS", ((i0.f0.m) annotation).value(), false);
            } else if (annotation instanceof i0.f0.h) {
                i0.f0.h hVar = (i0.f0.h) annotation;
                aVar.b(hVar.method(), hVar.path(), hVar.hasBody());
            } else if (annotation instanceof i0.f0.k) {
                String[] strArrValue = ((i0.f0.k) annotation).value();
                if (strArrValue.length == 0) {
                    throw c0.j(aVar.d, "@Headers annotation is empty.", new Object[0]);
                }
                Headers.a aVar2 = new Headers.a();
                for (String str : strArrValue) {
                    int iIndexOf = str.indexOf(58);
                    if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                        throw c0.j(aVar.d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                    }
                    String strSubstring = str.substring(0, iIndexOf);
                    String strTrim = str.substring(iIndexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                        try {
                            aVar.v = MediaType.b(strTrim);
                        } catch (IllegalArgumentException e) {
                            throw c0.k(aVar.d, e, "Malformed content type: %s", strTrim);
                        }
                    } else {
                        aVar2.a(strSubstring, strTrim);
                    }
                }
                aVar.u = aVar2.c();
            } else if (annotation instanceof i0.f0.l) {
                if (aVar.r) {
                    throw c0.j(aVar.d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.f3763s = true;
            } else if (!(annotation instanceof i0.f0.e)) {
                continue;
            } else {
                if (aVar.f3763s) {
                    throw c0.j(aVar.d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.r = true;
            }
        }
        if (aVar.p == null) {
            throw c0.j(aVar.d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (!aVar.q) {
            if (aVar.f3763s) {
                throw c0.j(aVar.d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
            if (aVar.r) {
                throw c0.j(aVar.d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
        }
        int length = aVar.f.length;
        aVar.f3764x = new t[length];
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < length) {
            t<?>[] tVarArr = aVar.f3764x;
            Type type = aVar.g[i8];
            Annotation[] annotationArr = aVar.f[i8];
            boolean z3 = i8 == i7;
            if (annotationArr != null) {
                int length2 = annotationArr.length;
                tVar = null;
                int i9 = 0;
                while (i9 < length2) {
                    Annotation annotation2 = annotationArr[i9];
                    int i10 = length;
                    if (annotation2 instanceof i0.f0.y) {
                        aVar.c(i8, type);
                        if (aVar.o) {
                            throw c0.l(aVar.d, i8, "Multiple @Url method annotations found.", new Object[0]);
                        }
                        if (aVar.k) {
                            throw c0.l(aVar.d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        if (aVar.l) {
                            throw c0.l(aVar.d, i8, "A @Url parameter must not come after a @Query.", new Object[0]);
                        }
                        if (aVar.m) {
                            throw c0.l(aVar.d, i8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        if (aVar.n) {
                            throw c0.l(aVar.d, i8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                        }
                        if (aVar.t != null) {
                            throw c0.l(aVar.d, i8, "@Url cannot be used with @%s URL", aVar.p);
                        }
                        aVar.o = true;
                        if (type != f0.w.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                            throw c0.l(aVar.d, i8, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                        }
                        oVar = new t.n(aVar.d, i8);
                        i3 = i7;
                        i4 = i9;
                        i6 = length2;
                    } else {
                        i3 = i7;
                        if (annotation2 instanceof i0.f0.s) {
                            aVar.c(i8, type);
                            if (aVar.l) {
                                throw c0.l(aVar.d, i8, "A @Path parameter must not come after a @Query.", new Object[0]);
                            }
                            if (aVar.m) {
                                throw c0.l(aVar.d, i8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                            }
                            if (aVar.n) {
                                throw c0.l(aVar.d, i8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            if (aVar.o) {
                                throw c0.l(aVar.d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                            }
                            if (aVar.t == null) {
                                throw c0.l(aVar.d, i8, "@Path can only be used with relative url on @%s", aVar.p);
                            }
                            aVar.k = true;
                            i0.f0.s sVar2 = (i0.f0.s) annotation2;
                            String strValue = sVar2.value();
                            if (!w.a.f3762b.matcher(strValue).matches()) {
                                throw c0.l(aVar.d, i8, "@Path parameter name must match %s. Found: %s", w.a.a.pattern(), strValue);
                            }
                            if (!aVar.w.contains(strValue)) {
                                throw c0.l(aVar.d, i8, "URL \"%s\" does not contain \"{%s}\".", aVar.t, strValue);
                            }
                            i4 = i9;
                            i5 = length2;
                            gVar = new t.i<>(aVar.d, i8, strValue, aVar.c.e(type, annotationArr), sVar2.encoded());
                        } else {
                            i4 = i9;
                            i5 = length2;
                            if (annotation2 instanceof i0.f0.t) {
                                aVar.c(i8, type);
                                i0.f0.t tVar2 = (i0.f0.t) annotation2;
                                String strValue2 = tVar2.value();
                                boolean zEncoded = tVar2.encoded();
                                Class<?> clsF = c0.f(type);
                                aVar.l = true;
                                if (Iterable.class.isAssignableFrom(clsF)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw c0.l(aVar.d, i8, b.d.b.a.a.p(clsF, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new r<>(new t.j(strValue2, aVar.c.e(c0.e(0, (ParameterizedType) type), annotationArr), zEncoded));
                                } else if (clsF.isArray()) {
                                    gVar = new s(new t.j(strValue2, aVar.c.e(w.a.a(clsF.getComponentType()), annotationArr), zEncoded));
                                } else {
                                    bVar = new t.j<>(strValue2, aVar.c.e(type, annotationArr), zEncoded);
                                    i6 = i5;
                                    oVar = bVar;
                                }
                            } else if (annotation2 instanceof i0.f0.v) {
                                aVar.c(i8, type);
                                boolean zEncoded2 = ((i0.f0.v) annotation2).encoded();
                                Class<?> clsF2 = c0.f(type);
                                aVar.m = true;
                                if (Iterable.class.isAssignableFrom(clsF2)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw c0.l(aVar.d, i8, b.d.b.a.a.p(clsF2, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new r<>(new t.l(aVar.c.e(c0.e(0, (ParameterizedType) type), annotationArr), zEncoded2));
                                } else if (clsF2.isArray()) {
                                    gVar = new s(new t.l(aVar.c.e(w.a.a(clsF2.getComponentType()), annotationArr), zEncoded2));
                                } else {
                                    cVar = new t.l<>(aVar.c.e(type, annotationArr), zEncoded2);
                                    i6 = i5;
                                    oVar = cVar;
                                }
                            } else {
                                if (annotation2 instanceof i0.f0.u) {
                                    aVar.c(i8, type);
                                    Class<?> clsF3 = c0.f(type);
                                    aVar.n = true;
                                    if (!Map.class.isAssignableFrom(clsF3)) {
                                        throw c0.l(aVar.d, i8, "@QueryMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeG = c0.g(type, clsF3, Map.class);
                                    if (!(typeG instanceof ParameterizedType)) {
                                        throw c0.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType = (ParameterizedType) typeG;
                                    Type typeE = c0.e(0, parameterizedType);
                                    if (String.class != typeE) {
                                        throw c0.l(aVar.d, i8, b.d.b.a.a.z("@QueryMap keys must be of type String: ", typeE), new Object[0]);
                                    }
                                    cVar = new t.k<>(aVar.d, i8, aVar.c.e(c0.e(1, parameterizedType), annotationArr), ((i0.f0.u) annotation2).encoded());
                                } else if (annotation2 instanceof i0.f0.i) {
                                    aVar.c(i8, type);
                                    String strValue3 = ((i0.f0.i) annotation2).value();
                                    Class<?> clsF4 = c0.f(type);
                                    if (Iterable.class.isAssignableFrom(clsF4)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw c0.l(aVar.d, i8, b.d.b.a.a.p(clsF4, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new r<>(new t.d(strValue3, aVar.c.e(c0.e(0, (ParameterizedType) type), annotationArr)));
                                    } else if (clsF4.isArray()) {
                                        gVar = new s(new t.d(strValue3, aVar.c.e(w.a.a(clsF4.getComponentType()), annotationArr)));
                                    } else {
                                        cVar = new t.d<>(strValue3, aVar.c.e(type, annotationArr));
                                    }
                                } else if (annotation2 instanceof i0.f0.j) {
                                    if (type == Headers.class) {
                                        gVar = new t.f(aVar.d, i8);
                                    } else {
                                        aVar.c(i8, type);
                                        Class<?> clsF5 = c0.f(type);
                                        if (!Map.class.isAssignableFrom(clsF5)) {
                                            throw c0.l(aVar.d, i8, "@HeaderMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeG2 = c0.g(type, clsF5, Map.class);
                                        if (!(typeG2 instanceof ParameterizedType)) {
                                            throw c0.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType2 = (ParameterizedType) typeG2;
                                        Type typeE2 = c0.e(0, parameterizedType2);
                                        if (String.class != typeE2) {
                                            throw c0.l(aVar.d, i8, b.d.b.a.a.z("@HeaderMap keys must be of type String: ", typeE2), new Object[0]);
                                        }
                                        sVar = new t.e<>(aVar.d, i8, aVar.c.e(c0.e(1, parameterizedType2), annotationArr));
                                        i6 = i5;
                                        oVar = sVar;
                                    }
                                } else if (annotation2 instanceof i0.f0.c) {
                                    aVar.c(i8, type);
                                    if (!aVar.r) {
                                        throw c0.l(aVar.d, i8, "@Field parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    i0.f0.c cVar2 = (i0.f0.c) annotation2;
                                    String strValue4 = cVar2.value();
                                    boolean zEncoded3 = cVar2.encoded();
                                    aVar.h = true;
                                    Class<?> clsF6 = c0.f(type);
                                    if (Iterable.class.isAssignableFrom(clsF6)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw c0.l(aVar.d, i8, b.d.b.a.a.p(clsF6, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new r<>(new t.b(strValue4, aVar.c.e(c0.e(0, (ParameterizedType) type), annotationArr), zEncoded3));
                                    } else if (clsF6.isArray()) {
                                        gVar = new s(new t.b(strValue4, aVar.c.e(w.a.a(clsF6.getComponentType()), annotationArr), zEncoded3));
                                    } else {
                                        bVar = new t.b<>(strValue4, aVar.c.e(type, annotationArr), zEncoded3);
                                        i6 = i5;
                                        oVar = bVar;
                                    }
                                } else if (annotation2 instanceof i0.f0.d) {
                                    aVar.c(i8, type);
                                    if (!aVar.r) {
                                        throw c0.l(aVar.d, i8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    Class<?> clsF7 = c0.f(type);
                                    if (!Map.class.isAssignableFrom(clsF7)) {
                                        throw c0.l(aVar.d, i8, "@FieldMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeG3 = c0.g(type, clsF7, Map.class);
                                    if (!(typeG3 instanceof ParameterizedType)) {
                                        throw c0.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType3 = (ParameterizedType) typeG3;
                                    Type typeE3 = c0.e(0, parameterizedType3);
                                    if (String.class != typeE3) {
                                        throw c0.l(aVar.d, i8, b.d.b.a.a.z("@FieldMap keys must be of type String: ", typeE3), new Object[0]);
                                    }
                                    h<T, String> hVarE = aVar.c.e(c0.e(1, parameterizedType3), annotationArr);
                                    aVar.h = true;
                                    cVar = new t.c<>(aVar.d, i8, hVarE, ((i0.f0.d) annotation2).encoded());
                                } else if (annotation2 instanceof i0.f0.q) {
                                    aVar.c(i8, type);
                                    if (!aVar.f3763s) {
                                        throw c0.l(aVar.d, i8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                    }
                                    i0.f0.q qVar = (i0.f0.q) annotation2;
                                    aVar.i = true;
                                    String strValue5 = qVar.value();
                                    Class<?> clsF8 = c0.f(type);
                                    if (strValue5.isEmpty()) {
                                        if (Iterable.class.isAssignableFrom(clsF8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw c0.l(aVar.d, i8, b.d.b.a.a.p(clsF8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            if (!MultipartBody.Part.class.isAssignableFrom(c0.f(c0.e(0, (ParameterizedType) type)))) {
                                                throw c0.l(aVar.d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            sVar = new r<>(t.m.a);
                                        } else if (clsF8.isArray()) {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsF8.getComponentType())) {
                                                throw c0.l(aVar.d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            sVar = new s(t.m.a);
                                        } else {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsF8)) {
                                                throw c0.l(aVar.d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            gVar = t.m.a;
                                        }
                                        i6 = i5;
                                        oVar = sVar;
                                    } else {
                                        i6 = i5;
                                        Headers headersC = Headers.INSTANCE.c("Content-Disposition", b.d.b.a.a.y("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", qVar.encoding());
                                        if (Iterable.class.isAssignableFrom(clsF8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw c0.l(aVar.d, i8, b.d.b.a.a.p(clsF8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            Type typeE4 = c0.e(0, (ParameterizedType) type);
                                            if (MultipartBody.Part.class.isAssignableFrom(c0.f(typeE4))) {
                                                throw c0.l(aVar.d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new r<>(new t.g(aVar.d, i8, headersC, aVar.c.c(typeE4, annotationArr, aVar.e)));
                                        } else if (clsF8.isArray()) {
                                            Class<?> clsA = w.a.a(clsF8.getComponentType());
                                            if (MultipartBody.Part.class.isAssignableFrom(clsA)) {
                                                throw c0.l(aVar.d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new s(new t.g(aVar.d, i8, headersC, aVar.c.c(clsA, annotationArr, aVar.e)));
                                        } else {
                                            if (MultipartBody.Part.class.isAssignableFrom(clsF8)) {
                                                throw c0.l(aVar.d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            gVar = new t.g<>(aVar.d, i8, headersC, aVar.c.c(type, annotationArr, aVar.e));
                                            oVar = gVar;
                                        }
                                    }
                                } else {
                                    i6 = i5;
                                    if (annotation2 instanceof i0.f0.r) {
                                        aVar.c(i8, type);
                                        if (!aVar.f3763s) {
                                            throw c0.l(aVar.d, i8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                        }
                                        aVar.i = true;
                                        Class<?> clsF9 = c0.f(type);
                                        if (!Map.class.isAssignableFrom(clsF9)) {
                                            throw c0.l(aVar.d, i8, "@PartMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeG4 = c0.g(type, clsF9, Map.class);
                                        if (!(typeG4 instanceof ParameterizedType)) {
                                            throw c0.l(aVar.d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType4 = (ParameterizedType) typeG4;
                                        Type typeE5 = c0.e(0, parameterizedType4);
                                        if (String.class != typeE5) {
                                            throw c0.l(aVar.d, i8, b.d.b.a.a.z("@PartMap keys must be of type String: ", typeE5), new Object[0]);
                                        }
                                        Type typeE6 = c0.e(1, parameterizedType4);
                                        if (MultipartBody.Part.class.isAssignableFrom(c0.f(typeE6))) {
                                            throw c0.l(aVar.d, i8, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                        }
                                        oVar = new t.h<>(aVar.d, i8, aVar.c.c(typeE6, annotationArr, aVar.e), ((i0.f0.r) annotation2).encoding());
                                    } else if (annotation2 instanceof i0.f0.a) {
                                        aVar.c(i8, type);
                                        if (aVar.r || aVar.f3763s) {
                                            throw c0.l(aVar.d, i8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                        }
                                        if (aVar.j) {
                                            throw c0.l(aVar.d, i8, "Multiple @Body method annotations found.", new Object[0]);
                                        }
                                        try {
                                            h<T, RequestBody> hVarC = aVar.c.c(type, annotationArr, aVar.e);
                                            aVar.j = true;
                                            oVar = new t.a<>(aVar.d, i8, hVarC);
                                        } catch (RuntimeException e2) {
                                            throw c0.m(aVar.d, e2, i8, "Unable to create @Body converter for %s", type);
                                        }
                                    } else if (annotation2 instanceof i0.f0.x) {
                                        aVar.c(i8, type);
                                        Class<?> clsF10 = c0.f(type);
                                        for (int i11 = i8 - 1; i11 >= 0; i11--) {
                                            t<?> tVar3 = aVar.f3764x[i11];
                                            if ((tVar3 instanceof t.o) && ((t.o) tVar3).a.equals(clsF10)) {
                                                Method method2 = aVar.d;
                                                StringBuilder sbU = b.d.b.a.a.U("@Tag type ");
                                                sbU.append(clsF10.getName());
                                                sbU.append(" is duplicate of parameter #");
                                                sbU.append(i11 + 1);
                                                sbU.append(" and would always overwrite its value.");
                                                throw c0.l(method2, i8, sbU.toString(), new Object[0]);
                                            }
                                        }
                                        oVar = new t.o<>(clsF10);
                                    } else {
                                        oVar = null;
                                    }
                                }
                                i6 = i5;
                                oVar = cVar;
                            }
                        }
                        i6 = i5;
                        oVar = gVar;
                    }
                    if (oVar != null) {
                        if (tVar != null) {
                            throw c0.l(aVar.d, i8, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        tVar = oVar;
                    }
                    i9 = i4 + 1;
                    length = i10;
                    i7 = i3;
                    length2 = i6;
                }
                i = length;
                i2 = i7;
            } else {
                i = length;
                i2 = i7;
                tVar = null;
            }
            if (tVar == null) {
                if (z3) {
                    try {
                        if (c0.f(type) == Continuation.class) {
                            aVar.f3765y = true;
                            tVar = null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw c0.l(aVar.d, i8, "No Retrofit annotation found.", new Object[0]);
            }
            tVarArr[i8] = tVar;
            i8++;
            length = i;
            i7 = i2;
        }
        if (aVar.t == null && !aVar.o) {
            throw c0.j(aVar.d, "Missing either @%s URL or @Url parameter.", aVar.p);
        }
        boolean z4 = aVar.r;
        if (!z4 && !aVar.f3763s && !aVar.q && aVar.j) {
            throw c0.j(aVar.d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if (z4 && !aVar.h) {
            throw c0.j(aVar.d, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if (aVar.f3763s && !aVar.i) {
            throw c0.j(aVar.d, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        w wVar = new w(aVar);
        Type genericReturnType2 = method.getGenericReturnType();
        if (c0.h(genericReturnType2)) {
            throw c0.j(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
        }
        if (genericReturnType2 == Void.TYPE) {
            throw c0.j(method, "Service methods cannot return void.", new Object[0]);
        }
        boolean z5 = wVar.k;
        Annotation[] annotations = method.getAnnotations();
        if (z5) {
            Type typeE7 = ((ParameterizedType) method.getGenericParameterTypes()[r5.length - 1]).getActualTypeArguments()[0];
            if (typeE7 instanceof WildcardType) {
                typeE7 = ((WildcardType) typeE7).getLowerBounds()[0];
            }
            if (c0.f(typeE7) == Response.class && (typeE7 instanceof ParameterizedType)) {
                typeE7 = c0.e(0, (ParameterizedType) typeE7);
                z2 = true;
            } else {
                z2 = false;
            }
            genericReturnType = new c0.b(null, d.class, typeE7);
            if (!c0.i(annotations, a0.class)) {
                Annotation[] annotationArr2 = new Annotation[annotations.length + 1];
                annotationArr2[0] = b0.a;
                System.arraycopy(annotations, 0, annotationArr2, 1, annotations.length);
                annotations = annotationArr2;
            }
        } else {
            genericReturnType = method.getGenericReturnType();
            z2 = false;
        }
        try {
            e<?, ?> eVarA = yVar.a(genericReturnType, annotations);
            Type typeA = eVarA.a();
            if (typeA == okhttp3.Response.class) {
                StringBuilder sbU2 = b.d.b.a.a.U("'");
                sbU2.append(c0.f(typeA).getName());
                sbU2.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw c0.j(method, sbU2.toString(), new Object[0]);
            }
            if (typeA == Response.class) {
                throw c0.j(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
            }
            if (wVar.c.equals("HEAD") && !Void.class.equals(typeA)) {
                throw c0.j(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            try {
                h<ResponseBody, T> hVarD = yVar.d(typeA, method.getAnnotations());
                e.a aVar3 = yVar.f3767b;
                return !z5 ? new j.a(wVar, aVar3, hVarD, eVarA) : z2 ? new j.c(wVar, aVar3, hVarD, eVarA) : new j.b(wVar, aVar3, hVarD, eVarA, false);
            } catch (RuntimeException e3) {
                throw c0.k(method, e3, "Unable to create converter for %s", typeA);
            }
        } catch (RuntimeException e4) {
            throw c0.k(method, e4, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    public abstract T a(Object[] objArr);
}
