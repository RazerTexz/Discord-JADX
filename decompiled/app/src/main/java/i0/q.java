package i0;

import i0.h;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: OptionalConverterFactory.java */
@IgnoreJRERequirement
/* loaded from: classes3.dex */
public final class q extends h.a {
    public static final h.a a = new q();

    /* compiled from: OptionalConverterFactory.java */
    @IgnoreJRERequirement
    public static final class a<T> implements h<ResponseBody, Optional<T>> {
        public final h<ResponseBody, T> a;

        public a(h<ResponseBody, T> hVar) {
            this.a = hVar;
        }

        @Override // i0.h
        public Object convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.a.convert(responseBody));
        }
    }

    @Override // i0.h.a
    public h<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotationArr, y yVar) {
        if (h.a.getRawType(type) != Optional.class) {
            return null;
        }
        return new a(yVar.d(h.a.getParameterUpperBound(0, (ParameterizedType) type), annotationArr));
    }
}
