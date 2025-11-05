package i0;

import i0.e;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.HttpException;
import retrofit2.Response;

/* compiled from: CompletableFutureCallAdapterFactory.java */
@IgnoreJRERequirement
/* loaded from: classes3.dex */
public final class g extends e.a {
    public static final e.a a = new g();

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class a<R> implements e<R, CompletableFuture<R>> {
        public final Type a;

        /* compiled from: CompletableFutureCallAdapterFactory.java */
        @IgnoreJRERequirement
        /* renamed from: i0.g$a$a, reason: collision with other inner class name */
        public class C0616a implements f<R> {
            public final CompletableFuture<R> a;

            public C0616a(a aVar, CompletableFuture<R> completableFuture) {
                this.a = completableFuture;
            }

            @Override // i0.f
            public void a(d<R> dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // i0.f
            public void b(d<R> dVar, Response<R> response) {
                if (response.a()) {
                    this.a.complete(response.f3824b);
                } else {
                    this.a.completeExceptionally(new HttpException(response));
                }
            }
        }

        public a(Type type) {
            this.a = type;
        }

        @Override // i0.e
        public Type a() {
            return this.a;
        }

        @Override // i0.e
        public Object b(d dVar) {
            b bVar = new b(dVar);
            dVar.C(new C0616a(this, bVar));
            return bVar;
        }
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class b<T> extends CompletableFuture<T> {
        public final d<?> j;

        public b(d<?> dVar) {
            this.j = dVar;
        }

        @Override // java.util.concurrent.CompletableFuture, java.util.concurrent.Future
        public boolean cancel(boolean z2) {
            if (z2) {
                this.j.cancel();
            }
            return super.cancel(z2);
        }
    }

    /* compiled from: CompletableFutureCallAdapterFactory.java */
    @IgnoreJRERequirement
    public static final class c<R> implements e<R, CompletableFuture<Response<R>>> {
        public final Type a;

        /* compiled from: CompletableFutureCallAdapterFactory.java */
        @IgnoreJRERequirement
        public class a implements f<R> {
            public final CompletableFuture<Response<R>> a;

            public a(c cVar, CompletableFuture<Response<R>> completableFuture) {
                this.a = completableFuture;
            }

            @Override // i0.f
            public void a(d<R> dVar, Throwable th) {
                this.a.completeExceptionally(th);
            }

            @Override // i0.f
            public void b(d<R> dVar, Response<R> response) {
                this.a.complete(response);
            }
        }

        public c(Type type) {
            this.a = type;
        }

        @Override // i0.e
        public Type a() {
            return this.a;
        }

        @Override // i0.e
        public Object b(d dVar) {
            b bVar = new b(dVar);
            dVar.C(new a(this, bVar));
            return bVar;
        }
    }

    @Override // i0.e.a
    public e<?, ?> a(Type type, Annotation[] annotationArr, y yVar) {
        if (c0.f(type) != CompletableFuture.class) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
        }
        Type typeE = c0.e(0, (ParameterizedType) type);
        if (c0.f(typeE) != Response.class) {
            return new a(typeE);
        }
        if (typeE instanceof ParameterizedType) {
            return new c(c0.e(0, (ParameterizedType) typeE));
        }
        throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
    }
}
