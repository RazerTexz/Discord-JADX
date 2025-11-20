package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import b.i.a.c.a3.a0;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: MediaSourceEventListener.java */
/* loaded from: classes3.dex */
public interface b0 {
    void X(int i, @Nullable a0.a aVar, t tVar, w wVar);

    void g0(int i, @Nullable a0.a aVar, t tVar, w wVar, IOException iOException, boolean z2);

    void o(int i, @Nullable a0.a aVar, w wVar);

    void q(int i, @Nullable a0.a aVar, t tVar, w wVar);

    void x(int i, @Nullable a0.a aVar, t tVar, w wVar);

    /* compiled from: MediaSourceEventListener.java */
    public static class a {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final a0.a f807b;
        public final CopyOnWriteArrayList<C0092a> c;
        public final long d;

        /* compiled from: MediaSourceEventListener.java */
        /* renamed from: b.i.a.c.a3.b0$a$a, reason: collision with other inner class name */
        public static final class C0092a {
            public Handler a;

            /* renamed from: b, reason: collision with root package name */
            public b0 f808b;

            public C0092a(Handler handler, b0 b0Var) {
                this.a = handler;
                this.f808b = b0Var;
            }
        }

        public a() {
            this.c = new CopyOnWriteArrayList<>();
            this.a = 0;
            this.f807b = null;
            this.d = 0L;
        }

        public final long a(long j) {
            long jM = b.i.a.c.f3.e0.M(j);
            if (jM == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            return this.d + jM;
        }

        public void b(w wVar) {
            for (C0092a c0092a : this.c) {
                b.i.a.c.f3.e0.E(c0092a.a, new d(this, c0092a.f808b, wVar));
            }
        }

        public void c(t tVar, w wVar) {
            for (C0092a c0092a : this.c) {
                b.i.a.c.f3.e0.E(c0092a.a, new f(this, c0092a.f808b, tVar, wVar));
            }
        }

        public void d(t tVar, w wVar) {
            for (C0092a c0092a : this.c) {
                b.i.a.c.f3.e0.E(c0092a.a, new c(this, c0092a.f808b, tVar, wVar));
            }
        }

        public void e(t tVar, w wVar, IOException iOException, boolean z2) {
            for (C0092a c0092a : this.c) {
                b.i.a.c.f3.e0.E(c0092a.a, new b(this, c0092a.f808b, tVar, wVar, iOException, z2));
            }
        }

        public void f(t tVar, w wVar) {
            for (C0092a c0092a : this.c) {
                b.i.a.c.f3.e0.E(c0092a.a, new e(this, c0092a.f808b, tVar, wVar));
            }
        }

        @CheckResult
        public a g(int i, @Nullable a0.a aVar, long j) {
            return new a(this.c, i, aVar, j);
        }

        public a(CopyOnWriteArrayList<C0092a> copyOnWriteArrayList, int i, @Nullable a0.a aVar, long j) {
            this.c = copyOnWriteArrayList;
            this.a = i;
            this.f807b = aVar;
            this.d = j;
        }
    }
}
