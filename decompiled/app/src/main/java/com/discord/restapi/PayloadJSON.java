package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import d0.z.d.m;
import i0.e0.a.a;
import i0.e0.a.b;
import i0.h;
import i0.y;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;

/* compiled from: PayloadJSON.kt */
/* loaded from: classes.dex */
public final /* data */ class PayloadJSON<T> {
    private final T data;

    /* compiled from: PayloadJSON.kt */
    public static final class ConverterFactory extends h.a {
        private final a gsonConverterFactory;

        /* compiled from: PayloadJSON.kt */
        public static final class RequestBodyConverter<T> implements h<PayloadJSON<T>, RequestBody> {
            private final h<T, RequestBody> gsonRequestBodyConverter;

            public RequestBodyConverter(h<T, RequestBody> hVar) {
                m.checkNotNullParameter(hVar, "gsonRequestBodyConverter");
                this.gsonRequestBodyConverter = hVar;
            }

            @Override // i0.h
            public /* bridge */ /* synthetic */ RequestBody convert(Object obj) {
                return convert((PayloadJSON) obj);
            }

            public RequestBody convert(PayloadJSON<T> value) {
                m.checkNotNullParameter(value, "value");
                return (RequestBody) this.gsonRequestBodyConverter.convert(PayloadJSON.access$getData$p(value));
            }
        }

        public ConverterFactory(Gson gson) {
            m.checkNotNullParameter(gson, "gson");
            Objects.requireNonNull(gson, "gson == null");
            this.gsonConverterFactory = new a(gson);
        }

        @Override // i0.h.a
        public h<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, y retrofit) {
            m.checkNotNullParameter(type, "type");
            m.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
            m.checkNotNullParameter(methodAnnotations, "methodAnnotations");
            m.checkNotNullParameter(retrofit, "retrofit");
            if (!(type instanceof ParameterizedType)) {
                type = null;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType == null || (!m.areEqual(parameterizedType.getRawType(), PayloadJSON.class))) {
                return null;
            }
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            a aVar = this.gsonConverterFactory;
            return new RequestBodyConverter(new b(aVar.a, aVar.a.h(TypeToken.get(type2))));
        }
    }

    public PayloadJSON(T t) {
        this.data = t;
    }

    public static final /* synthetic */ Object access$getData$p(PayloadJSON payloadJSON) {
        return payloadJSON.data;
    }

    private final T component1() {
        return this.data;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PayloadJSON copy$default(PayloadJSON payloadJSON, Object obj, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = payloadJSON.data;
        }
        return payloadJSON.copy(obj);
    }

    public final PayloadJSON<T> copy(T data) {
        return new PayloadJSON<>(data);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof PayloadJSON) && m.areEqual(this.data, ((PayloadJSON) other).data);
        }
        return true;
    }

    public int hashCode() {
        T t = this.data;
        if (t != null) {
            return t.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("PayloadJSON(data=");
        sbU.append(this.data);
        sbU.append(")");
        return sbU.toString();
    }
}
