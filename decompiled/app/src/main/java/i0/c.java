package i0;

import i0.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import kotlin.Unit;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* compiled from: BuiltInConverters.java */
/* loaded from: classes3.dex */
public final class c extends h.a {
    public boolean a = true;

    /* compiled from: BuiltInConverters.java */
    public static final class a implements h<ResponseBody, ResponseBody> {
        public static final a a = new a();

        @Override // i0.h
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            ResponseBody responseBody2 = responseBody;
            try {
                return c0.a(responseBody2);
            } finally {
                responseBody2.close();
            }
        }
    }

    /* compiled from: BuiltInConverters.java */
    public static final class b implements h<RequestBody, RequestBody> {
        public static final b a = new b();

        @Override // i0.h
        public RequestBody convert(RequestBody requestBody) throws IOException {
            return requestBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    /* renamed from: i0.c$c, reason: collision with other inner class name */
    public static final class C0614c implements h<ResponseBody, ResponseBody> {
        public static final C0614c a = new C0614c();

        @Override // i0.h
        public ResponseBody convert(ResponseBody responseBody) throws IOException {
            return responseBody;
        }
    }

    /* compiled from: BuiltInConverters.java */
    public static final class d implements h<Object, String> {
        public static final d a = new d();

        @Override // i0.h
        public String convert(Object obj) throws IOException {
            return obj.toString();
        }
    }

    /* compiled from: BuiltInConverters.java */
    public static final class e implements h<ResponseBody, Unit> {
        public static final e a = new e();

        @Override // i0.h
        public Unit convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return Unit.a;
        }
    }

    /* compiled from: BuiltInConverters.java */
    public static final class f implements h<ResponseBody, Void> {
        public static final f a = new f();

        @Override // i0.h
        public Void convert(ResponseBody responseBody) throws IOException {
            responseBody.close();
            return null;
        }
    }

    @Override // i0.h.a
    public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, y yVar) {
        if (RequestBody.class.isAssignableFrom(c0.f(type))) {
            return b.a;
        }
        return null;
    }

    @Override // i0.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        if (type == ResponseBody.class) {
            return c0.i(annotationArr, i0.f0.w.class) ? C0614c.a : a.a;
        }
        if (type == Void.class) {
            return f.a;
        }
        if (!this.a || type != Unit.class) {
            return null;
        }
        try {
            return e.a;
        } catch (NoClassDefFoundError unused) {
            this.a = false;
            return null;
        }
    }
}
