package p630i0.p631d0.p632a;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import p630i0.CallAdapter;
import p630i0.Retrofit2;
import p630i0.Utils8;
import p637j0.Completable3;
import p637j0.Single2;
import p658rx.Observable;
import p658rx.Scheduler;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d0.a.g, reason: use source file name */
/* JADX INFO: compiled from: RxJavaCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class RxJavaCallAdapterFactory extends CallAdapter.a {
    public RxJavaCallAdapterFactory(Scheduler scheduler, boolean z2) {
    }

    @Override // p630i0.CallAdapter.a
    /* JADX INFO: renamed from: a */
    public CallAdapter<?, ?> mo10707a(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        Type type2;
        boolean z2;
        boolean z3;
        Type typeM10685e;
        Class<?> clsM10686f = Utils8.m10686f(type);
        boolean z4 = true;
        boolean z5 = clsM10686f == Single2.class;
        boolean z6 = clsM10686f == Completable3.class;
        if (clsM10686f != Observable.class && !z5 && !z6) {
            return null;
        }
        if (z6) {
            return new RxJavaCallAdapter(Void.class, null, false, false, true, false, true);
        }
        if (!(type instanceof ParameterizedType)) {
            String str = z5 ? "Single" : "Observable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type typeM10685e2 = Utils8.m10685e(0, (ParameterizedType) type);
        Class<?> clsM10686f2 = Utils8.m10686f(typeM10685e2);
        if (clsM10686f2 == Response.class) {
            if (!(typeM10685e2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            typeM10685e = Utils8.m10685e(0, (ParameterizedType) typeM10685e2);
            z4 = false;
        } else {
            if (clsM10686f2 != Result4.class) {
                type2 = typeM10685e2;
                z2 = false;
                z3 = true;
                return new RxJavaCallAdapter(type2, null, false, z2, z3, z5, false);
            }
            if (!(typeM10685e2 instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            typeM10685e = Utils8.m10685e(0, (ParameterizedType) typeM10685e2);
        }
        type2 = typeM10685e;
        z2 = z4;
        z3 = false;
        return new RxJavaCallAdapter(type2, null, false, z2, z3, z5, false);
    }
}
