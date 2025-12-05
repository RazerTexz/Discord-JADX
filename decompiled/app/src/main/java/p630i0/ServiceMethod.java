package p630i0;

import androidx.browser.trusted.sharing.ShareTarget;
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
import p007b.p100d.p104b.p105a.outline;
import p600f0.Call2;
import p600f0.HttpUrl;
import p630i0.HttpServiceMethod;
import p630i0.ParameterHandler3;
import p630i0.RequestFactory;
import p630i0.Utils8;
import p630i0.p636f0.Body;
import p630i0.p636f0.DELETE;
import p630i0.p636f0.Field;
import p630i0.p636f0.FieldMap;
import p630i0.p636f0.FormUrlEncoded;
import p630i0.p636f0.GET;
import p630i0.p636f0.HEAD;
import p630i0.p636f0.HTTP;
import p630i0.p636f0.Header3;
import p630i0.p636f0.HeaderMap;
import p630i0.p636f0.Headers2;
import p630i0.p636f0.Multipart;
import p630i0.p636f0.OPTIONS;
import p630i0.p636f0.PATCH;
import p630i0.p636f0.POST;
import p630i0.p636f0.PUT;
import p630i0.p636f0.Part2;
import p630i0.p636f0.PartMap;
import p630i0.p636f0.Path2;
import p630i0.p636f0.Query2;
import p630i0.p636f0.QueryMap;
import p630i0.p636f0.QueryName;
import p630i0.p636f0.Tag2;
import p630i0.p636f0.Url;
import retrofit2.Response;

/* compiled from: ServiceMethod.java */
/* renamed from: i0.z, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class ServiceMethod<T> {
    /* renamed from: b */
    public static <T> ServiceMethod<T> m10730b(Retrofit2 retrofit22, Method method) throws CloneNotSupportedException {
        Type genericReturnType;
        boolean z2;
        int i;
        int i2;
        ParameterHandler3<?> parameterHandler3;
        int i3;
        int i4;
        int i5;
        int i6;
        ParameterHandler3<?> oVar;
        ParameterHandler3<?> gVar;
        ParameterHandler3<?> parameterHandler2;
        ParameterHandler3<?> cVar;
        ParameterHandler3<?> bVar;
        RequestFactory.a aVar = new RequestFactory.a(retrofit22, method);
        for (Annotation annotation : aVar.f26648e) {
            if (annotation instanceof DELETE) {
                aVar.m10723b("DELETE", ((DELETE) annotation).value(), false);
            } else if (annotation instanceof GET) {
                aVar.m10723b(ShareTarget.METHOD_GET, ((GET) annotation).value(), false);
            } else if (annotation instanceof HEAD) {
                aVar.m10723b("HEAD", ((HEAD) annotation).value(), false);
            } else if (annotation instanceof PATCH) {
                aVar.m10723b("PATCH", ((PATCH) annotation).value(), true);
            } else if (annotation instanceof POST) {
                aVar.m10723b(ShareTarget.METHOD_POST, ((POST) annotation).value(), true);
            } else if (annotation instanceof PUT) {
                aVar.m10723b("PUT", ((PUT) annotation).value(), true);
            } else if (annotation instanceof OPTIONS) {
                aVar.m10723b("OPTIONS", ((OPTIONS) annotation).value(), false);
            } else if (annotation instanceof HTTP) {
                HTTP http = (HTTP) annotation;
                aVar.m10723b(http.method(), http.path(), http.hasBody());
            } else if (annotation instanceof Headers2) {
                String[] strArrValue = ((Headers2) annotation).value();
                if (strArrValue.length == 0) {
                    throw Utils8.m10690j(aVar.f26647d, "@Headers annotation is empty.", new Object[0]);
                }
                Headers.C12930a c12930a = new Headers.C12930a();
                for (String str : strArrValue) {
                    int iIndexOf = str.indexOf(58);
                    if (iIndexOf == -1 || iIndexOf == 0 || iIndexOf == str.length() - 1) {
                        throw Utils8.m10690j(aVar.f26647d, "@Headers value must be in the form \"Name: Value\". Found: \"%s\"", str);
                    }
                    String strSubstring = str.substring(0, iIndexOf);
                    String strTrim = str.substring(iIndexOf + 1).trim();
                    if ("Content-Type".equalsIgnoreCase(strSubstring)) {
                        try {
                            aVar.f26665v = MediaType.m10965b(strTrim);
                        } catch (IllegalArgumentException e) {
                            throw Utils8.m10691k(aVar.f26647d, e, "Malformed content type: %s", strTrim);
                        }
                    } else {
                        c12930a.m10958a(strSubstring, strTrim);
                    }
                }
                aVar.f26664u = c12930a.m10960c();
            } else if (annotation instanceof Multipart) {
                if (aVar.f26661r) {
                    throw Utils8.m10690j(aVar.f26647d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.f26662s = true;
            } else if (!(annotation instanceof FormUrlEncoded)) {
                continue;
            } else {
                if (aVar.f26662s) {
                    throw Utils8.m10690j(aVar.f26647d, "Only one encoding annotation is allowed.", new Object[0]);
                }
                aVar.f26661r = true;
            }
        }
        if (aVar.f26659p == null) {
            throw Utils8.m10690j(aVar.f26647d, "HTTP method annotation is required (e.g., @GET, @POST, etc.).", new Object[0]);
        }
        if (!aVar.f26660q) {
            if (aVar.f26662s) {
                throw Utils8.m10690j(aVar.f26647d, "Multipart can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
            if (aVar.f26661r) {
                throw Utils8.m10690j(aVar.f26647d, "FormUrlEncoded can only be specified on HTTP methods with request body (e.g., @POST).", new Object[0]);
            }
        }
        int length = aVar.f26649f.length;
        aVar.f26667x = new ParameterHandler3[length];
        int i7 = length - 1;
        int i8 = 0;
        while (i8 < length) {
            ParameterHandler3<?>[] parameterHandler3Arr = aVar.f26667x;
            Type type = aVar.f26650g[i8];
            Annotation[] annotationArr = aVar.f26649f[i8];
            boolean z3 = i8 == i7;
            if (annotationArr != null) {
                int length2 = annotationArr.length;
                parameterHandler3 = null;
                int i9 = 0;
                while (i9 < length2) {
                    Annotation annotation2 = annotationArr[i9];
                    int i10 = length;
                    if (annotation2 instanceof Url) {
                        aVar.m10724c(i8, type);
                        if (aVar.f26658o) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "Multiple @Url method annotations found.", new Object[0]);
                        }
                        if (aVar.f26654k) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                        }
                        if (aVar.f26655l) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "A @Url parameter must not come after a @Query.", new Object[0]);
                        }
                        if (aVar.f26656m) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "A @Url parameter must not come after a @QueryName.", new Object[0]);
                        }
                        if (aVar.f26657n) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "A @Url parameter must not come after a @QueryMap.", new Object[0]);
                        }
                        if (aVar.f26663t != null) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "@Url cannot be used with @%s URL", aVar.f26659p);
                        }
                        aVar.f26658o = true;
                        if (type != HttpUrl.class && type != String.class && type != URI.class && (!(type instanceof Class) || !"android.net.Uri".equals(((Class) type).getName()))) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "@Url must be okhttp3.HttpUrl, String, java.net.URI, or android.net.Uri type.", new Object[0]);
                        }
                        oVar = new ParameterHandler3.n(aVar.f26647d, i8);
                        i3 = i7;
                        i4 = i9;
                        i6 = length2;
                    } else {
                        i3 = i7;
                        if (annotation2 instanceof Path2) {
                            aVar.m10724c(i8, type);
                            if (aVar.f26655l) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "A @Path parameter must not come after a @Query.", new Object[0]);
                            }
                            if (aVar.f26656m) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "A @Path parameter must not come after a @QueryName.", new Object[0]);
                            }
                            if (aVar.f26657n) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "A @Path parameter must not come after a @QueryMap.", new Object[0]);
                            }
                            if (aVar.f26658o) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "@Path parameters may not be used with @Url.", new Object[0]);
                            }
                            if (aVar.f26663t == null) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "@Path can only be used with relative url on @%s", aVar.f26659p);
                            }
                            aVar.f26654k = true;
                            Path2 path2 = (Path2) annotation2;
                            String strValue = path2.value();
                            if (!RequestFactory.a.f26645b.matcher(strValue).matches()) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "@Path parameter name must match %s. Found: %s", RequestFactory.a.f26644a.pattern(), strValue);
                            }
                            if (!aVar.f26666w.contains(strValue)) {
                                throw Utils8.m10692l(aVar.f26647d, i8, "URL \"%s\" does not contain \"{%s}\".", aVar.f26663t, strValue);
                            }
                            i4 = i9;
                            i5 = length2;
                            gVar = new ParameterHandler3.i<>(aVar.f26647d, i8, strValue, aVar.f26646c.m10729e(type, annotationArr), path2.encoded());
                        } else {
                            i4 = i9;
                            i5 = length2;
                            if (annotation2 instanceof Query2) {
                                aVar.m10724c(i8, type);
                                Query2 query2 = (Query2) annotation2;
                                String strValue2 = query2.value();
                                boolean zEncoded = query2.encoded();
                                Class<?> clsM10686f = Utils8.m10686f(type);
                                aVar.f26655l = true;
                                if (Iterable.class.isAssignableFrom(clsM10686f)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, outline.m869p(clsM10686f, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new ParameterHandler<>(new ParameterHandler3.j(strValue2, aVar.f26646c.m10729e(Utils8.m10685e(0, (ParameterizedType) type), annotationArr), zEncoded));
                                } else if (clsM10686f.isArray()) {
                                    gVar = new ParameterHandler2(new ParameterHandler3.j(strValue2, aVar.f26646c.m10729e(RequestFactory.a.m10722a(clsM10686f.getComponentType()), annotationArr), zEncoded));
                                } else {
                                    bVar = new ParameterHandler3.j<>(strValue2, aVar.f26646c.m10729e(type, annotationArr), zEncoded);
                                    i6 = i5;
                                    oVar = bVar;
                                }
                            } else if (annotation2 instanceof QueryName) {
                                aVar.m10724c(i8, type);
                                boolean zEncoded2 = ((QueryName) annotation2).encoded();
                                Class<?> clsM10686f2 = Utils8.m10686f(type);
                                aVar.f26656m = true;
                                if (Iterable.class.isAssignableFrom(clsM10686f2)) {
                                    if (!(type instanceof ParameterizedType)) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, outline.m869p(clsM10686f2, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                    }
                                    gVar = new ParameterHandler<>(new ParameterHandler3.l(aVar.f26646c.m10729e(Utils8.m10685e(0, (ParameterizedType) type), annotationArr), zEncoded2));
                                } else if (clsM10686f2.isArray()) {
                                    gVar = new ParameterHandler2(new ParameterHandler3.l(aVar.f26646c.m10729e(RequestFactory.a.m10722a(clsM10686f2.getComponentType()), annotationArr), zEncoded2));
                                } else {
                                    cVar = new ParameterHandler3.l<>(aVar.f26646c.m10729e(type, annotationArr), zEncoded2);
                                    i6 = i5;
                                    oVar = cVar;
                                }
                            } else {
                                if (annotation2 instanceof QueryMap) {
                                    aVar.m10724c(i8, type);
                                    Class<?> clsM10686f3 = Utils8.m10686f(type);
                                    aVar.f26657n = true;
                                    if (!Map.class.isAssignableFrom(clsM10686f3)) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "@QueryMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeM10687g = Utils8.m10687g(type, clsM10686f3, Map.class);
                                    if (!(typeM10687g instanceof ParameterizedType)) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType = (ParameterizedType) typeM10687g;
                                    Type typeM10685e = Utils8.m10685e(0, parameterizedType);
                                    if (String.class != typeM10685e) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, outline.m887z("@QueryMap keys must be of type String: ", typeM10685e), new Object[0]);
                                    }
                                    cVar = new ParameterHandler3.k<>(aVar.f26647d, i8, aVar.f26646c.m10729e(Utils8.m10685e(1, parameterizedType), annotationArr), ((QueryMap) annotation2).encoded());
                                } else if (annotation2 instanceof Header3) {
                                    aVar.m10724c(i8, type);
                                    String strValue3 = ((Header3) annotation2).value();
                                    Class<?> clsM10686f4 = Utils8.m10686f(type);
                                    if (Iterable.class.isAssignableFrom(clsM10686f4)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, outline.m869p(clsM10686f4, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new ParameterHandler<>(new ParameterHandler3.d(strValue3, aVar.f26646c.m10729e(Utils8.m10685e(0, (ParameterizedType) type), annotationArr)));
                                    } else if (clsM10686f4.isArray()) {
                                        gVar = new ParameterHandler2(new ParameterHandler3.d(strValue3, aVar.f26646c.m10729e(RequestFactory.a.m10722a(clsM10686f4.getComponentType()), annotationArr)));
                                    } else {
                                        cVar = new ParameterHandler3.d<>(strValue3, aVar.f26646c.m10729e(type, annotationArr));
                                    }
                                } else if (annotation2 instanceof HeaderMap) {
                                    if (type == Headers.class) {
                                        gVar = new ParameterHandler3.f(aVar.f26647d, i8);
                                    } else {
                                        aVar.m10724c(i8, type);
                                        Class<?> clsM10686f5 = Utils8.m10686f(type);
                                        if (!Map.class.isAssignableFrom(clsM10686f5)) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "@HeaderMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeM10687g2 = Utils8.m10687g(type, clsM10686f5, Map.class);
                                        if (!(typeM10687g2 instanceof ParameterizedType)) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType2 = (ParameterizedType) typeM10687g2;
                                        Type typeM10685e2 = Utils8.m10685e(0, parameterizedType2);
                                        if (String.class != typeM10685e2) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, outline.m887z("@HeaderMap keys must be of type String: ", typeM10685e2), new Object[0]);
                                        }
                                        parameterHandler2 = new ParameterHandler3.e<>(aVar.f26647d, i8, aVar.f26646c.m10729e(Utils8.m10685e(1, parameterizedType2), annotationArr));
                                        i6 = i5;
                                        oVar = parameterHandler2;
                                    }
                                } else if (annotation2 instanceof Field) {
                                    aVar.m10724c(i8, type);
                                    if (!aVar.f26661r) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "@Field parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    Field field = (Field) annotation2;
                                    String strValue4 = field.value();
                                    boolean zEncoded3 = field.encoded();
                                    aVar.f26651h = true;
                                    Class<?> clsM10686f6 = Utils8.m10686f(type);
                                    if (Iterable.class.isAssignableFrom(clsM10686f6)) {
                                        if (!(type instanceof ParameterizedType)) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, outline.m869p(clsM10686f6, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                        }
                                        gVar = new ParameterHandler<>(new ParameterHandler3.b(strValue4, aVar.f26646c.m10729e(Utils8.m10685e(0, (ParameterizedType) type), annotationArr), zEncoded3));
                                    } else if (clsM10686f6.isArray()) {
                                        gVar = new ParameterHandler2(new ParameterHandler3.b(strValue4, aVar.f26646c.m10729e(RequestFactory.a.m10722a(clsM10686f6.getComponentType()), annotationArr), zEncoded3));
                                    } else {
                                        bVar = new ParameterHandler3.b<>(strValue4, aVar.f26646c.m10729e(type, annotationArr), zEncoded3);
                                        i6 = i5;
                                        oVar = bVar;
                                    }
                                } else if (annotation2 instanceof FieldMap) {
                                    aVar.m10724c(i8, type);
                                    if (!aVar.f26661r) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "@FieldMap parameters can only be used with form encoding.", new Object[0]);
                                    }
                                    Class<?> clsM10686f7 = Utils8.m10686f(type);
                                    if (!Map.class.isAssignableFrom(clsM10686f7)) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "@FieldMap parameter type must be Map.", new Object[0]);
                                    }
                                    Type typeM10687g3 = Utils8.m10687g(type, clsM10686f7, Map.class);
                                    if (!(typeM10687g3 instanceof ParameterizedType)) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                    }
                                    ParameterizedType parameterizedType3 = (ParameterizedType) typeM10687g3;
                                    Type typeM10685e3 = Utils8.m10685e(0, parameterizedType3);
                                    if (String.class != typeM10685e3) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, outline.m887z("@FieldMap keys must be of type String: ", typeM10685e3), new Object[0]);
                                    }
                                    Converter2<T, String> converter2M10729e = aVar.f26646c.m10729e(Utils8.m10685e(1, parameterizedType3), annotationArr);
                                    aVar.f26651h = true;
                                    cVar = new ParameterHandler3.c<>(aVar.f26647d, i8, converter2M10729e, ((FieldMap) annotation2).encoded());
                                } else if (annotation2 instanceof Part2) {
                                    aVar.m10724c(i8, type);
                                    if (!aVar.f26662s) {
                                        throw Utils8.m10692l(aVar.f26647d, i8, "@Part parameters can only be used with multipart encoding.", new Object[0]);
                                    }
                                    Part2 part2 = (Part2) annotation2;
                                    aVar.f26652i = true;
                                    String strValue5 = part2.value();
                                    Class<?> clsM10686f8 = Utils8.m10686f(type);
                                    if (strValue5.isEmpty()) {
                                        if (Iterable.class.isAssignableFrom(clsM10686f8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, outline.m869p(clsM10686f8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            if (!MultipartBody.Part.class.isAssignableFrom(Utils8.m10686f(Utils8.m10685e(0, (ParameterizedType) type)))) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            parameterHandler2 = new ParameterHandler<>(ParameterHandler3.m.f26610a);
                                        } else if (clsM10686f8.isArray()) {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsM10686f8.getComponentType())) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            parameterHandler2 = new ParameterHandler2(ParameterHandler3.m.f26610a);
                                        } else {
                                            if (!MultipartBody.Part.class.isAssignableFrom(clsM10686f8)) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, "@Part annotation must supply a name or use MultipartBody.Part parameter type.", new Object[0]);
                                            }
                                            gVar = ParameterHandler3.m.f26610a;
                                        }
                                        i6 = i5;
                                        oVar = parameterHandler2;
                                    } else {
                                        i6 = i5;
                                        Headers headersM10964c = Headers.INSTANCE.m10964c("Content-Disposition", outline.m886y("form-data; name=\"", strValue5, "\""), "Content-Transfer-Encoding", part2.encoding());
                                        if (Iterable.class.isAssignableFrom(clsM10686f8)) {
                                            if (!(type instanceof ParameterizedType)) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, outline.m869p(clsM10686f8, new StringBuilder(), " must include generic type (e.g., ", "<String>)"), new Object[0]);
                                            }
                                            Type typeM10685e4 = Utils8.m10685e(0, (ParameterizedType) type);
                                            if (MultipartBody.Part.class.isAssignableFrom(Utils8.m10686f(typeM10685e4))) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new ParameterHandler<>(new ParameterHandler3.g(aVar.f26647d, i8, headersM10964c, aVar.f26646c.m10727c(typeM10685e4, annotationArr, aVar.f26648e)));
                                        } else if (clsM10686f8.isArray()) {
                                            Class<?> clsM10722a = RequestFactory.a.m10722a(clsM10686f8.getComponentType());
                                            if (MultipartBody.Part.class.isAssignableFrom(clsM10722a)) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            oVar = new ParameterHandler2(new ParameterHandler3.g(aVar.f26647d, i8, headersM10964c, aVar.f26646c.m10727c(clsM10722a, annotationArr, aVar.f26648e)));
                                        } else {
                                            if (MultipartBody.Part.class.isAssignableFrom(clsM10686f8)) {
                                                throw Utils8.m10692l(aVar.f26647d, i8, "@Part parameters using the MultipartBody.Part must not include a part name in the annotation.", new Object[0]);
                                            }
                                            gVar = new ParameterHandler3.g<>(aVar.f26647d, i8, headersM10964c, aVar.f26646c.m10727c(type, annotationArr, aVar.f26648e));
                                            oVar = gVar;
                                        }
                                    }
                                } else {
                                    i6 = i5;
                                    if (annotation2 instanceof PartMap) {
                                        aVar.m10724c(i8, type);
                                        if (!aVar.f26662s) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "@PartMap parameters can only be used with multipart encoding.", new Object[0]);
                                        }
                                        aVar.f26652i = true;
                                        Class<?> clsM10686f9 = Utils8.m10686f(type);
                                        if (!Map.class.isAssignableFrom(clsM10686f9)) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "@PartMap parameter type must be Map.", new Object[0]);
                                        }
                                        Type typeM10687g4 = Utils8.m10687g(type, clsM10686f9, Map.class);
                                        if (!(typeM10687g4 instanceof ParameterizedType)) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "Map must include generic types (e.g., Map<String, String>)", new Object[0]);
                                        }
                                        ParameterizedType parameterizedType4 = (ParameterizedType) typeM10687g4;
                                        Type typeM10685e5 = Utils8.m10685e(0, parameterizedType4);
                                        if (String.class != typeM10685e5) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, outline.m887z("@PartMap keys must be of type String: ", typeM10685e5), new Object[0]);
                                        }
                                        Type typeM10685e6 = Utils8.m10685e(1, parameterizedType4);
                                        if (MultipartBody.Part.class.isAssignableFrom(Utils8.m10686f(typeM10685e6))) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "@PartMap values cannot be MultipartBody.Part. Use @Part List<Part> or a different value type instead.", new Object[0]);
                                        }
                                        oVar = new ParameterHandler3.h<>(aVar.f26647d, i8, aVar.f26646c.m10727c(typeM10685e6, annotationArr, aVar.f26648e), ((PartMap) annotation2).encoding());
                                    } else if (annotation2 instanceof Body) {
                                        aVar.m10724c(i8, type);
                                        if (aVar.f26661r || aVar.f26662s) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "@Body parameters cannot be used with form or multi-part encoding.", new Object[0]);
                                        }
                                        if (aVar.f26653j) {
                                            throw Utils8.m10692l(aVar.f26647d, i8, "Multiple @Body method annotations found.", new Object[0]);
                                        }
                                        try {
                                            Converter2<T, RequestBody> converter2M10727c = aVar.f26646c.m10727c(type, annotationArr, aVar.f26648e);
                                            aVar.f26653j = true;
                                            oVar = new ParameterHandler3.a<>(aVar.f26647d, i8, converter2M10727c);
                                        } catch (RuntimeException e2) {
                                            throw Utils8.m10693m(aVar.f26647d, e2, i8, "Unable to create @Body converter for %s", type);
                                        }
                                    } else if (annotation2 instanceof Tag2) {
                                        aVar.m10724c(i8, type);
                                        Class<?> clsM10686f10 = Utils8.m10686f(type);
                                        for (int i11 = i8 - 1; i11 >= 0; i11--) {
                                            ParameterHandler3<?> parameterHandler32 = aVar.f26667x[i11];
                                            if ((parameterHandler32 instanceof ParameterHandler3.o) && ((ParameterHandler3.o) parameterHandler32).f26613a.equals(clsM10686f10)) {
                                                Method method2 = aVar.f26647d;
                                                StringBuilder sbM833U = outline.m833U("@Tag type ");
                                                sbM833U.append(clsM10686f10.getName());
                                                sbM833U.append(" is duplicate of parameter #");
                                                sbM833U.append(i11 + 1);
                                                sbM833U.append(" and would always overwrite its value.");
                                                throw Utils8.m10692l(method2, i8, sbM833U.toString(), new Object[0]);
                                            }
                                        }
                                        oVar = new ParameterHandler3.o<>(clsM10686f10);
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
                        if (parameterHandler3 != null) {
                            throw Utils8.m10692l(aVar.f26647d, i8, "Multiple Retrofit annotations found, only one allowed.", new Object[0]);
                        }
                        parameterHandler3 = oVar;
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
                parameterHandler3 = null;
            }
            if (parameterHandler3 == null) {
                if (z3) {
                    try {
                        if (Utils8.m10686f(type) == Continuation.class) {
                            aVar.f26668y = true;
                            parameterHandler3 = null;
                        }
                    } catch (NoClassDefFoundError unused) {
                    }
                }
                throw Utils8.m10692l(aVar.f26647d, i8, "No Retrofit annotation found.", new Object[0]);
            }
            parameterHandler3Arr[i8] = parameterHandler3;
            i8++;
            length = i;
            i7 = i2;
        }
        if (aVar.f26663t == null && !aVar.f26658o) {
            throw Utils8.m10690j(aVar.f26647d, "Missing either @%s URL or @Url parameter.", aVar.f26659p);
        }
        boolean z4 = aVar.f26661r;
        if (!z4 && !aVar.f26662s && !aVar.f26660q && aVar.f26653j) {
            throw Utils8.m10690j(aVar.f26647d, "Non-body HTTP method cannot contain @Body.", new Object[0]);
        }
        if (z4 && !aVar.f26651h) {
            throw Utils8.m10690j(aVar.f26647d, "Form-encoded method must contain at least one @Field.", new Object[0]);
        }
        if (aVar.f26662s && !aVar.f26652i) {
            throw Utils8.m10690j(aVar.f26647d, "Multipart method must contain at least one @Part.", new Object[0]);
        }
        RequestFactory requestFactory = new RequestFactory(aVar);
        Type genericReturnType2 = method.getGenericReturnType();
        if (Utils8.m10688h(genericReturnType2)) {
            throw Utils8.m10690j(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType2);
        }
        if (genericReturnType2 == Void.TYPE) {
            throw Utils8.m10690j(method, "Service methods cannot return void.", new Object[0]);
        }
        boolean z5 = requestFactory.f26643k;
        Annotation[] annotations = method.getAnnotations();
        if (z5) {
            Type typeM10685e7 = ((ParameterizedType) method.getGenericParameterTypes()[r5.length - 1]).getActualTypeArguments()[0];
            if (typeM10685e7 instanceof WildcardType) {
                typeM10685e7 = ((WildcardType) typeM10685e7).getLowerBounds()[0];
            }
            if (Utils8.m10686f(typeM10685e7) == Response.class && (typeM10685e7 instanceof ParameterizedType)) {
                typeM10685e7 = Utils8.m10685e(0, (ParameterizedType) typeM10685e7);
                z2 = true;
            } else {
                z2 = false;
            }
            genericReturnType = new Utils8.b(null, Call3.class, typeM10685e7);
            if (!Utils8.m10689i(annotations, SkipCallbackExecutor.class)) {
                Annotation[] annotationArr2 = new Annotation[annotations.length + 1];
                annotationArr2[0] = SkipCallbackExecutorImpl.f26482a;
                System.arraycopy(annotations, 0, annotationArr2, 1, annotations.length);
                annotations = annotationArr2;
            }
        } else {
            genericReturnType = method.getGenericReturnType();
            z2 = false;
        }
        try {
            CallAdapter<?, ?> callAdapterM10725a = retrofit22.m10725a(genericReturnType, annotations);
            Type typeMo10705a = callAdapterM10725a.mo10705a();
            if (typeMo10705a == okhttp3.Response.class) {
                StringBuilder sbM833U2 = outline.m833U("'");
                sbM833U2.append(Utils8.m10686f(typeMo10705a).getName());
                sbM833U2.append("' is not a valid response body type. Did you mean ResponseBody?");
                throw Utils8.m10690j(method, sbM833U2.toString(), new Object[0]);
            }
            if (typeMo10705a == Response.class) {
                throw Utils8.m10690j(method, "Response must include generic type (e.g., Response<String>)", new Object[0]);
            }
            if (requestFactory.f26635c.equals("HEAD") && !Void.class.equals(typeMo10705a)) {
                throw Utils8.m10690j(method, "HEAD method must use Void as response type.", new Object[0]);
            }
            try {
                Converter2<ResponseBody, T> converter2M10728d = retrofit22.m10728d(typeMo10705a, method.getAnnotations());
                Call2.a aVar2 = retrofit22.f26674b;
                return !z5 ? new HttpServiceMethod.a(requestFactory, aVar2, converter2M10728d, callAdapterM10725a) : z2 ? new HttpServiceMethod.c(requestFactory, aVar2, converter2M10728d, callAdapterM10725a) : new HttpServiceMethod.b(requestFactory, aVar2, converter2M10728d, callAdapterM10725a, false);
            } catch (RuntimeException e3) {
                throw Utils8.m10691k(method, e3, "Unable to create converter for %s", typeMo10705a);
            }
        } catch (RuntimeException e4) {
            throw Utils8.m10691k(method, e4, "Unable to create call adapter for %s", genericReturnType);
        }
    }

    /* renamed from: a */
    public abstract T mo10710a(Object[] objArr);
}
