package p630i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p600f0.Call2;
import p600f0.HttpUrl;
import p630i0.BuiltInConverters;
import p630i0.CallAdapter;
import p630i0.Converter2;

/* compiled from: Retrofit.java */
/* renamed from: i0.y, reason: use source file name */
/* loaded from: classes3.dex */
public final class Retrofit2 {

    /* renamed from: a */
    public final Map<Method, ServiceMethod<?>> f26673a = new ConcurrentHashMap();

    /* renamed from: b */
    public final Call2.a f26674b;

    /* renamed from: c */
    public final HttpUrl f26675c;

    /* renamed from: d */
    public final List<Converter2.a> f26676d;

    /* renamed from: e */
    public final List<CallAdapter.a> f26677e;

    /* renamed from: f */
    public final Executor f26678f;

    /* renamed from: g */
    public final boolean f26679g;

    public Retrofit2(Call2.a aVar, HttpUrl httpUrl, List<Converter2.a> list, List<CallAdapter.a> list2, Executor executor, boolean z2) {
        this.f26674b = aVar;
        this.f26675c = httpUrl;
        this.f26676d = list;
        this.f26677e = list2;
        this.f26678f = executor;
        this.f26679g = z2;
    }

    /* renamed from: a */
    public CallAdapter<?, ?> m10725a(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "returnType == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f26677e.indexOf(null) + 1;
        int size = this.f26677e.size();
        for (int i = iIndexOf; i < size; i++) {
            CallAdapter<?, ?> callAdapterMo10707a = this.f26677e.get(i).mo10707a(type, annotationArr, this);
            if (callAdapterMo10707a != null) {
                return callAdapterMo10707a;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate call adapter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.f26677e.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f26677e.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: b */
    public ServiceMethod<?> m10726b(Method method) {
        ServiceMethod<?> serviceMethodM10730b;
        ServiceMethod<?> serviceMethod = this.f26673a.get(method);
        if (serviceMethod != null) {
            return serviceMethod;
        }
        synchronized (this.f26673a) {
            serviceMethodM10730b = this.f26673a.get(method);
            if (serviceMethodM10730b == null) {
                serviceMethodM10730b = ServiceMethod.m10730b(this, method);
                this.f26673a.put(method, serviceMethodM10730b);
            }
        }
        return serviceMethodM10730b;
    }

    /* renamed from: c */
    public <T> Converter2<T, RequestBody> m10727c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "parameterAnnotations == null");
        Objects.requireNonNull(annotationArr2, "methodAnnotations == null");
        int iIndexOf = this.f26676d.indexOf(null) + 1;
        int size = this.f26676d.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter2<T, RequestBody> converter2 = (Converter2<T, RequestBody>) this.f26676d.get(i).requestBodyConverter(type, annotationArr, annotationArr2, this);
            if (converter2 != null) {
                return converter2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate RequestBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.f26676d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f26676d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: d */
    public <T> Converter2<ResponseBody, T> m10728d(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int iIndexOf = this.f26676d.indexOf(null) + 1;
        int size = this.f26676d.size();
        for (int i = iIndexOf; i < size; i++) {
            Converter2<ResponseBody, T> converter2 = (Converter2<ResponseBody, T>) this.f26676d.get(i).responseBodyConverter(type, annotationArr, this);
            if (converter2 != null) {
                return converter2;
            }
        }
        StringBuilder sb = new StringBuilder("Could not locate ResponseBody converter for ");
        sb.append(type);
        sb.append(".\n");
        sb.append("  Tried:");
        int size2 = this.f26676d.size();
        while (iIndexOf < size2) {
            sb.append("\n   * ");
            sb.append(this.f26676d.get(iIndexOf).getClass().getName());
            iIndexOf++;
        }
        throw new IllegalArgumentException(sb.toString());
    }

    /* renamed from: e */
    public <T> Converter2<T, String> m10729e(Type type, Annotation[] annotationArr) {
        Objects.requireNonNull(type, "type == null");
        Objects.requireNonNull(annotationArr, "annotations == null");
        int size = this.f26676d.size();
        for (int i = 0; i < size; i++) {
            Converter2<T, String> converter2 = (Converter2<T, String>) this.f26676d.get(i).stringConverter(type, annotationArr, this);
            if (converter2 != null) {
                return converter2;
            }
        }
        return BuiltInConverters.d.f26487a;
    }
}
