package b.i.a.c.a3;

import android.os.Handler;
import androidx.annotation.Nullable;
import b.i.a.c.o1;
import b.i.a.c.o2;
import java.io.IOException;

/* compiled from: MediaSource.java */
/* loaded from: classes3.dex */
public interface a0 {

    /* compiled from: MediaSource.java */
    public static final class a extends y {
        public a(Object obj) {
            super(obj);
        }

        public a b(Object obj) {
            return new a(this.a.equals(obj) ? this : new y(obj, this.f835b, this.c, this.d, this.e));
        }

        public a(Object obj, long j, int i) {
            super(obj, j, i);
        }

        public a(Object obj, int i, int i2, long j) {
            super(obj, i, i2, j);
        }

        public a(y yVar) {
            super(yVar);
        }
    }

    /* compiled from: MediaSource.java */
    public interface b {
        void a(a0 a0Var, o2 o2Var);
    }

    void a(b bVar);

    void b(Handler handler, b0 b0Var);

    void c(b0 b0Var);

    void d(b bVar);

    o1 e();

    void f(Handler handler, b.i.a.c.w2.s sVar);

    void g(b.i.a.c.w2.s sVar);

    void h() throws IOException;

    boolean i();

    void j(x xVar);

    @Nullable
    o2 k();

    void l(b bVar, @Nullable b.i.a.c.e3.a0 a0Var);

    void m(b bVar);

    x n(a aVar, b.i.a.c.e3.o oVar, long j);
}
