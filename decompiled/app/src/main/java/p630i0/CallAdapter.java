package p630i0;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: i0.e, reason: use source file name */
/* JADX INFO: compiled from: CallAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface CallAdapter<R, T> {

    /* JADX INFO: renamed from: i0.e$a */
    /* JADX INFO: compiled from: CallAdapter.java */
    public static abstract class a {
        /* JADX INFO: renamed from: a */
        public abstract CallAdapter<?, ?> mo10707a(Type type, Annotation[] annotationArr, Retrofit2 retrofit22);
    }

    /* JADX INFO: renamed from: a */
    Type mo10705a();

    /* JADX INFO: renamed from: b */
    T mo10706b(Call3<R> call3);
}
