package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p630i0.Converter2;
import p630i0.Retrofit2;
import p630i0.p633e0.p634a.GsonConverterFactory;
import p630i0.p633e0.p634a.GsonRequestBodyConverter;

/* compiled from: PayloadJSON.kt */
/* loaded from: classes.dex */
public final /* data */ class PayloadJSON<T> {
    private final T data;

    /* compiled from: PayloadJSON.kt */
    public static final class ConverterFactory extends Converter2.a {
        private final GsonConverterFactory gsonConverterFactory;

        /* compiled from: PayloadJSON.kt */
        public static final class RequestBodyConverter<T> implements Converter2<PayloadJSON<T>, RequestBody> {
            private final Converter2<T, RequestBody> gsonRequestBodyConverter;

            public RequestBodyConverter(Converter2<T, RequestBody> converter2) {
                Intrinsics3.checkNotNullParameter(converter2, "gsonRequestBodyConverter");
                this.gsonRequestBodyConverter = converter2;
            }

            @Override // p630i0.Converter2
            public /* bridge */ /* synthetic */ RequestBody convert(Object obj) {
                return convert((PayloadJSON) obj);
            }

            public RequestBody convert(PayloadJSON<T> value) {
                Intrinsics3.checkNotNullParameter(value, "value");
                return (RequestBody) this.gsonRequestBodyConverter.convert(PayloadJSON.access$getData$p(value));
            }
        }

        public ConverterFactory(Gson gson) {
            Intrinsics3.checkNotNullParameter(gson, "gson");
            Objects.requireNonNull(gson, "gson == null");
            this.gsonConverterFactory = new GsonConverterFactory(gson);
        }

        @Override // p630i0.Converter2.a
        public Converter2<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit2 retrofit) {
            Intrinsics3.checkNotNullParameter(type, "type");
            Intrinsics3.checkNotNullParameter(parameterAnnotations, "parameterAnnotations");
            Intrinsics3.checkNotNullParameter(methodAnnotations, "methodAnnotations");
            Intrinsics3.checkNotNullParameter(retrofit, "retrofit");
            if (!(type instanceof ParameterizedType)) {
                type = null;
            }
            ParameterizedType parameterizedType = (ParameterizedType) type;
            if (parameterizedType == null || (!Intrinsics3.areEqual(parameterizedType.getRawType(), PayloadJSON.class))) {
                return null;
            }
            Type type2 = parameterizedType.getActualTypeArguments()[0];
            GsonConverterFactory gsonConverterFactory = this.gsonConverterFactory;
            return new RequestBodyConverter(new GsonRequestBodyConverter(gsonConverterFactory.f26510a, gsonConverterFactory.f26510a.m9204h(TypeToken.get(type2))));
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
            return (other instanceof PayloadJSON) && Intrinsics3.areEqual(this.data, ((PayloadJSON) other).data);
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
        StringBuilder sbM833U = outline.m833U("PayloadJSON(data=");
        sbM833U.append(this.data);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
