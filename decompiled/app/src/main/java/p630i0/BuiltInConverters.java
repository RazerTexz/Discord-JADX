package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p630i0.Converter2;
import p630i0.p636f0.Streaming;

/* JADX INFO: renamed from: i0.c, reason: use source file name */
/* JADX INFO: compiled from: BuiltInConverters.java */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInConverters extends Converter2.a {

    /* JADX INFO: renamed from: a */
    public boolean f26483a = true;

    /* JADX INFO: renamed from: i0.c$a */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class a implements Converter2<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a */
        public static final a f26484a = new a();

        @Override // p630i0.Converter2
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            ResponseBody responseBody2 = responseBody;
            try {
                return Utils8.m10681a(responseBody2);
            } finally {
                responseBody2.close();
            }
        }
    }

    /* JADX INFO: renamed from: i0.c$b */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class b implements Converter2<RequestBody, RequestBody> {

        /* JADX INFO: renamed from: a */
        public static final b f26485a = new b();

        @Override // p630i0.Converter2
        public RequestBody convert(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    /* JADX INFO: renamed from: i0.c$c */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class c implements Converter2<ResponseBody, ResponseBody> {

        /* JADX INFO: renamed from: a */
        public static final c f26486a = new c();

        @Override // p630i0.Converter2
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    /* JADX INFO: renamed from: i0.c$d */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class d implements Converter2<Object, String> {

        /* JADX INFO: renamed from: a */
        public static final d f26487a = new d();

        @Override // p630i0.Converter2
        public String convert(Object obj) throws IOException {
            return obj.toString();
        }
    }

    /* JADX INFO: renamed from: i0.c$e */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class e implements Converter2<ResponseBody, Unit> {

        /* JADX INFO: renamed from: a */
        public static final e f26488a = new e();

        @Override // p630i0.Converter2
        public Unit convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: i0.c$f */
    /* JADX INFO: compiled from: BuiltInConverters.java */
    public static final class f implements Converter2<ResponseBody, Void> {

        /* JADX INFO: renamed from: a */
        public static final f f26489a = new f();

        @Override // p630i0.Converter2
        public Void convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    @Override // p630i0.Converter2.a
    public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit22) {
        if (RequestBody.class.isAssignableFrom(Utils8.m10686f(type))) {
            return b.f26485a;
        }
        return null;
    }

    @Override // p630i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        if (type == ResponseBody.class) {
            return Utils8.m10689i(annotationArr, Streaming.class) ? c.f26486a : a.f26484a;
        }
        if (type == Void.class) {
            return f.f26489a;
        }
        if (!this.f26483a || type != Unit.class) {
            return null;
        }
        try {
            return e.f26488a;
        } catch (NoClassDefFoundError unused) {
            this.f26483a = false;
            return null;
        }
    }
}
