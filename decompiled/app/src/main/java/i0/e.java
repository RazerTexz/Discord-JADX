package i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* compiled from: CallAdapter.java */
/* loaded from: classes3.dex */
public interface e<R, T> {

    /* compiled from: CallAdapter.java */
    public static abstract class a {
        public abstract e<?, ?> a(Type type, Annotation[] annotationArr, y yVar);
    }

    Type a();

    T b(d<R> dVar);
}
