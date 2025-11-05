package i0;

import i0.e;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.Executor;
import okhttp3.Request;
import retrofit2.Response;

/* compiled from: DefaultCallAdapterFactory.java */
/* loaded from: classes3.dex */
public final class i extends e.a {
    public final Executor a;

    /* compiled from: DefaultCallAdapterFactory.java */
    public class a implements e<Object, d<?>> {
        public final /* synthetic */ Type a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Executor f3740b;

        public a(i iVar, Type type, Executor executor) {
            this.a = type;
            this.f3740b = executor;
        }

        @Override // i0.e
        public Type a() {
            return this.a;
        }

        @Override // i0.e
        public d<?> b(d<Object> dVar) {
            Executor executor = this.f3740b;
            return executor == null ? dVar : new b(executor, dVar);
        }
    }

    /* compiled from: DefaultCallAdapterFactory.java */
    public static final class b<T> implements d<T> {
        public final Executor j;
        public final d<T> k;

        /* compiled from: DefaultCallAdapterFactory.java */
        public class a implements f<T> {
            public final /* synthetic */ f a;

            public a(f fVar) {
                this.a = fVar;
            }

            @Override // i0.f
            public void a(d<T> dVar, Throwable th) {
                b.this.j.execute(new i0.a(this, this.a, th));
            }

            @Override // i0.f
            public void b(d<T> dVar, Response<T> response) {
                b.this.j.execute(new i0.b(this, this.a, response));
            }
        }

        public b(Executor executor, d<T> dVar) {
            this.j = executor;
            this.k = dVar;
        }

        @Override // i0.d
        public void C(f<T> fVar) {
            this.k.C(new a(fVar));
        }

        @Override // i0.d
        public d<T> L() {
            return new b(this.j, this.k.L());
        }

        @Override // i0.d
        public Request c() {
            return this.k.c();
        }

        @Override // i0.d
        public void cancel() {
            this.k.cancel();
        }

        public /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
            return L();
        }

        @Override // i0.d
        public boolean d() {
            return this.k.d();
        }

        @Override // i0.d
        public Response<T> execute() throws IOException {
            return this.k.execute();
        }
    }

    public i(Executor executor) {
        this.a = executor;
    }

    @Override // i0.e.a
    public e<?, ?> a(Type type, Annotation[] annotationArr, y yVar) {
        if (c0.f(type) != d.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            return new a(this, c0.e(0, (ParameterizedType) type), c0.i(annotationArr, a0.class) ? null : this.a);
        }
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
