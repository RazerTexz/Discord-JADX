package b.i.a.c;

import android.os.Looper;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.Nullable;
import b.i.a.c.f3.n;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: Player.java */
/* loaded from: classes3.dex */
public interface y1 {

    /* compiled from: Player.java */
    public static final class b implements w0 {
        public static final b j = new b(new n.b().b(), null);
        public final b.i.a.c.f3.n k;

        /* compiled from: Player.java */
        public static final class a {
            public final n.b a = new n.b();

            public a a(b bVar) {
                n.b bVar2 = this.a;
                b.i.a.c.f3.n nVar = bVar.k;
                Objects.requireNonNull(bVar2);
                for (int i = 0; i < nVar.c(); i++) {
                    bVar2.a(nVar.b(i));
                }
                return this;
            }

            public a b(int i, boolean z2) {
                n.b bVar = this.a;
                Objects.requireNonNull(bVar);
                if (z2) {
                    b.c.a.a0.d.D(!bVar.f972b);
                    bVar.a.append(i, true);
                }
                return this;
            }

            public b c() {
                return new b(this.a.b(), null);
            }
        }

        public b(b.i.a.c.f3.n nVar, a aVar) {
            this.k = nVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof b) {
                return this.k.equals(((b) obj).k);
            }
            return false;
        }

        public int hashCode() {
            return this.k.hashCode();
        }
    }

    /* compiled from: Player.java */
    @Deprecated
    public interface c {
        void A(p1 p1Var);

        void D(boolean z2);

        void E(y1 y1Var, d dVar);

        @Deprecated
        void H(boolean z2, int i);

        void L(int i);

        void M(@Nullable o1 o1Var, int i);

        void W(boolean z2, int i);

        @Deprecated
        void Y(b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.n nVar);

        @Deprecated
        void a();

        void b0(x1 x1Var);

        void f0(@Nullable PlaybackException playbackException);

        void g(f fVar, f fVar2, int i);

        void h(int i);

        @Deprecated
        void i(boolean z2);

        @Deprecated
        void j(int i);

        void j0(boolean z2);

        void p(p2 p2Var);

        void r(boolean z2);

        void s(PlaybackException playbackException);

        void t(b bVar);

        void v(o2 o2Var, int i);

        void y(int i);
    }

    /* compiled from: Player.java */
    public static final class d {
        public final b.i.a.c.f3.n a;

        public d(b.i.a.c.f3.n nVar) {
            this.a = nVar;
        }

        public boolean a(int... iArr) {
            b.i.a.c.f3.n nVar = this.a;
            Objects.requireNonNull(nVar);
            for (int i : iArr) {
                if (nVar.a(i)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof d) {
                return this.a.equals(((d) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    /* compiled from: Player.java */
    public interface e extends c {
        void G(int i, boolean z2);

        void a0(int i, int i2);

        void b(Metadata metadata);

        void c();

        void d(boolean z2);

        void e(List<b.i.a.c.b3.b> list);

        void f(b.i.a.c.g3.y yVar);

        void w(float f);

        void z(c1 c1Var);
    }

    /* compiled from: Player.java */
    public static final class f implements w0 {

        @Nullable
        public final Object j;
        public final int k;

        @Nullable
        public final o1 l;

        @Nullable
        public final Object m;
        public final int n;
        public final long o;
        public final long p;
        public final int q;
        public final int r;

        public f(@Nullable Object obj, int i, @Nullable o1 o1Var, @Nullable Object obj2, int i2, long j, long j2, int i3, int i4) {
            this.j = obj;
            this.k = i;
            this.l = o1Var;
            this.m = obj2;
            this.n = i2;
            this.o = j;
            this.p = j2;
            this.q = i3;
            this.r = i4;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || f.class != obj.getClass()) {
                return false;
            }
            f fVar = (f) obj;
            return this.k == fVar.k && this.n == fVar.n && this.o == fVar.o && this.p == fVar.p && this.q == fVar.q && this.r == fVar.r && b.i.a.f.e.o.f.V(this.j, fVar.j) && b.i.a.f.e.o.f.V(this.m, fVar.m) && b.i.a.f.e.o.f.V(this.l, fVar.l);
        }

        public int hashCode() {
            return Arrays.hashCode(new Object[]{this.j, Integer.valueOf(this.k), this.l, this.m, Integer.valueOf(this.n), Long.valueOf(this.o), Long.valueOf(this.p), Integer.valueOf(this.q), Integer.valueOf(this.r)});
        }
    }

    List<b.i.a.c.b3.b> A();

    int B();

    int C();

    boolean D(int i);

    void E(int i);

    void F(@Nullable SurfaceView surfaceView);

    int G();

    p2 H();

    int I();

    long J();

    o2 K();

    Looper L();

    boolean M();

    long N();

    void O();

    void P();

    void Q(@Nullable TextureView textureView);

    void R();

    p1 S();

    long T();

    long U();

    void a();

    x1 c();

    void d();

    void e();

    boolean f();

    long g();

    void h(int i, long j);

    b i();

    boolean j();

    void k(boolean z2);

    long l();

    int m();

    void n(@Nullable TextureView textureView);

    b.i.a.c.g3.y o();

    void p(e eVar);

    int q();

    void r(@Nullable SurfaceView surfaceView);

    void s();

    @Nullable
    PlaybackException t();

    void u(boolean z2);

    long v();

    long w();

    void x(e eVar);

    int y();

    boolean z();
}
