package p630i0;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import p630i0.CallAdapter;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.i, reason: use source file name */
/* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DefaultCallAdapterFactory extends CallAdapter.a {

    /* JADX INFO: renamed from: a */
    public final Executor f26534a;

    /* JADX INFO: renamed from: i0.i$a */
    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    public class a implements CallAdapter<Object, Call3<?>> {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Type f26535a;

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ Executor f26536b;

        public a(DefaultCallAdapterFactory defaultCallAdapterFactory, Type type, Executor executor) {
            this.f26535a = type;
            this.f26536b = executor;
        }

        @Override // p630i0.CallAdapter
        /* JADX INFO: renamed from: a */
        public Type mo10705a() {
            return this.f26535a;
        }

        @Override // p630i0.CallAdapter
        /* JADX INFO: renamed from: b */
        public Call3<?> mo10706b(Call3<Object> call3) {
            Executor executor = this.f26536b;
            return executor == null ? call3 : new b(executor, call3);
        }
    }

    /* JADX INFO: renamed from: i0.i$b */
    /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
    public static final class b<T> implements Call3<T> {

        /* JADX INFO: renamed from: j */
        public final Executor f26537j;

        /* JADX INFO: renamed from: k */
        public final Call3<T> f26538k;

        /* JADX INFO: renamed from: i0.i$b$a */
        /* JADX INFO: compiled from: DefaultCallAdapterFactory.java */
        public class a implements Callback3<T> {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ Callback3 f26539a;

            public a(Callback3 callback3) {
                this.f26539a = callback3;
            }

            @Override // p630i0.Callback3
            /* JADX INFO: renamed from: a */
            public void mo10708a(Call3<T> call3, Throwable th) {
                b.this.f26537j.execute(new RunnableC12498a(this, this.f26539a, th));
            }

            @Override // p630i0.Callback3
            /* JADX INFO: renamed from: b */
            public void mo10709b(Call3<T> call3, Response<T> response) {
                b.this.f26537j.execute(new RunnableC12500b(this, this.f26539a, response));
            }
        }

        public b(Executor executor, Call3<T> call3) {
            this.f26537j = executor;
            this.f26538k = call3;
        }

        @Override // p630i0.Call3
        /* JADX INFO: renamed from: C */
        public void mo10697C(Callback3<T> callback3) {
            this.f26538k.mo10697C(new a(callback3));
        }

        @Override // p630i0.Call3
        /* JADX INFO: renamed from: L */
        public Call3<T> mo10698L() {
            return new b(this.f26537j, this.f26538k.mo10698L());
        }

        @Override // p630i0.Call3
        /* JADX INFO: renamed from: c */
        public Request mo10699c() {
            return this.f26538k.mo10699c();
        }

        @Override // p630i0.Call3
        public void cancel() {
            this.f26538k.cancel();
        }

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return mo10698L();
        }

        @Override // p630i0.Call3
        /* JADX INFO: renamed from: d */
        public boolean mo10700d() {
            return this.f26538k.mo10700d();
        }

        @Override // p630i0.Call3
        public Response<T> execute() throws IOException {
            return this.f26538k.execute();
        }
    }

    public DefaultCallAdapterFactory(Executor executor) {
        this.f26534a = executor;
    }

    @Override // p630i0.CallAdapter.a
    /* JADX INFO: renamed from: a */
    public CallAdapter<?, ?> mo10707a(Type type, Annotation[] annotationArr, Retrofit2 retrofit22) {
        if (Utils8.m10686f(type) != Call3.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(this, Utils8.m10685e(0, (ParameterizedType) type), Utils8.m10689i(annotationArr, SkipCallbackExecutor.class) ? null : this.f26534a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
