package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p630i0.Converter2;

/* compiled from: OptionalConverterFactory.java */
@IgnoreJRERequirement
/* renamed from: i0.q, reason: use source file name */
/* loaded from: classes3.dex */
public final class OptionalConverterFactory extends Converter2.a {

    /* renamed from: a */
    public static final Converter2.a f26567a = new OptionalConverterFactory();

    /* compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    /* renamed from: i0.q$a */
    public static final class a<T> implements Converter2<ResponseBody, Optional<T>> {

        /* renamed from: a */
        public final Converter2<ResponseBody, T> f26568a;

        public a(Converter2<ResponseBody, T> converter2) {
            this.f26568a = converter2;
        }

        @Override // p630i0.Converter2
        public Object convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.f26568a.convert(responseBody));
        }
    }

    @Override // p630i0.Converter2.a
    public Converter2<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        if (Converter2.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(retrofit22.m10728d(Converter2.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
