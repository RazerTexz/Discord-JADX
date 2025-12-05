package p630i0.p633e0.p635b;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import p630i0.Converter2;
import p630i0.Retrofit2;

/* compiled from: ScalarsConverterFactory.java */
/* renamed from: i0.e0.b.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarsConverterFactory extends Converter2.a {
    @Override // p630i0.Converter2.a
    public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, Retrofit2 retrofit22) {
        if (type == String.class || type == Boolean.TYPE || type == Boolean.class || type == Byte.TYPE || type == Byte.class || type == Character.TYPE || type == Character.class || type == Double.TYPE || type == Double.class || type == Float.TYPE || type == Float.class || type == Integer.TYPE || type == Integer.class || type == Long.TYPE || type == Long.class || type == Short.TYPE || type == Short.class) {
            return ScalarRequestBodyConverter.f26517a;
        }
        return null;
    }

    @Override // p630i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        if (type == String.class) {
            return ScalarResponseBodyConverters9.f26527a;
        }
        if (type == Boolean.class || type == Boolean.TYPE) {
            return ScalarResponseBodyConverters.f26519a;
        }
        if (type == Byte.class || type == Byte.TYPE) {
            return ScalarResponseBodyConverters2.f26520a;
        }
        if (type == Character.class || type == Character.TYPE) {
            return ScalarResponseBodyConverters3.f26521a;
        }
        if (type == Double.class || type == Double.TYPE) {
            return ScalarResponseBodyConverters4.f26522a;
        }
        if (type == Float.class || type == Float.TYPE) {
            return ScalarResponseBodyConverters5.f26523a;
        }
        if (type == Integer.class || type == Integer.TYPE) {
            return ScalarResponseBodyConverters6.f26524a;
        }
        if (type == Long.class || type == Long.TYPE) {
            return ScalarResponseBodyConverters7.f26525a;
        }
        if (type == Short.class || type == Short.TYPE) {
            return ScalarResponseBodyConverters8.f26526a;
        }
        return null;
    }
}
