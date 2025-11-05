package b.a.p;

import b.i.a.c.a2;
import b.i.a.c.a3.o0;
import b.i.a.c.c1;
import b.i.a.c.c3.n;
import b.i.a.c.g3.y;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.p1;
import b.i.a.c.p2;
import b.i.a.c.x1;
import b.i.a.c.y1;
import b.i.a.c.z1;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import d0.z.d.m;
import java.util.List;
import rx.subjects.PublishSubject;

/* compiled from: RxPlayerEventListener.kt */
/* loaded from: classes.dex */
public final class k implements y1.e {
    public final PublishSubject<c> j = PublishSubject.k0();
    public final PublishSubject<a> k = PublishSubject.k0();
    public final PublishSubject<b> l = PublishSubject.k0();

    /* compiled from: RxPlayerEventListener.kt */
    public static final class a {
        public final boolean a;

        public a(boolean z2) {
            this.a = z2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && this.a == ((a) obj).a;
            }
            return true;
        }

        public int hashCode() {
            boolean z2 = this.a;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return b.d.b.a.a.O(b.d.b.a.a.U("IsPlayingChange(isPlaying="), this.a, ")");
        }
    }

    /* compiled from: RxPlayerEventListener.kt */
    public static final class b {
        public final PlaybackException a;

        public b(PlaybackException playbackException) {
            m.checkNotNullParameter(playbackException, "exoPlaybackException");
            this.a = playbackException;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && m.areEqual(this.a, ((b) obj).a);
            }
            return true;
        }

        public int hashCode() {
            PlaybackException playbackException = this.a;
            if (playbackException != null) {
                return playbackException.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("PlayerError(exoPlaybackException=");
            sbU.append(this.a);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: RxPlayerEventListener.kt */
    public static final class c {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && this.a == ((c) obj).a;
            }
            return true;
        }

        public int hashCode() {
            return this.a;
        }

        public String toString() {
            return b.d.b.a.a.B(b.d.b.a.a.U("PlayerStateChange(playbackState="), this.a, ")");
        }
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void A(p1 p1Var) {
        a2.i(this, p1Var);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void D(boolean z2) {
        a2.t(this, z2);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void E(y1 y1Var, y1.d dVar) {
        a2.e(this, y1Var, dVar);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void G(int i, boolean z2) {
        a2.d(this, i, z2);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void H(boolean z2, int i) {
        z1.k(this, z2, i);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void L(int i) {
        a2.s(this, i);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void M(o1 o1Var, int i) {
        a2.h(this, o1Var, i);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void W(boolean z2, int i) {
        a2.k(this, z2, i);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void Y(o0 o0Var, n nVar) {
        z1.r(this, o0Var, nVar);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void a() {
        z1.o(this);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void a0(int i, int i2) {
        a2.v(this, i, i2);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void b(Metadata metadata) {
        a2.j(this, metadata);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void b0(x1 x1Var) {
        a2.l(this, x1Var);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void c() {
        a2.r(this);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void d(boolean z2) {
        a2.u(this, z2);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void e(List list) {
        a2.b(this, list);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void f(y yVar) {
        a2.y(this, yVar);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        a2.p(this, playbackException);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void g(y1.f fVar, y1.f fVar2, int i) {
        a2.q(this, fVar, fVar2, i);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void h(int i) {
        a2.n(this, i);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void i(boolean z2) {
        z1.d(this, z2);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void j(int i) {
        z1.l(this, i);
    }

    @Override // b.i.a.c.y1.c
    public void j0(boolean z2) {
        PublishSubject<a> publishSubject = this.k;
        publishSubject.k.onNext(new a(z2));
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void p(p2 p2Var) {
        a2.x(this, p2Var);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void r(boolean z2) {
        a2.f(this, z2);
    }

    @Override // b.i.a.c.y1.c
    public void s(PlaybackException playbackException) {
        m.checkNotNullParameter(playbackException, "error");
        PublishSubject<b> publishSubject = this.l;
        publishSubject.k.onNext(new b(playbackException));
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void t(y1.b bVar) {
        a2.a(this, bVar);
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void v(o2 o2Var, int i) {
        a2.w(this, o2Var, i);
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void w(float f) {
        a2.z(this, f);
    }

    @Override // b.i.a.c.y1.c
    public void y(int i) {
        PublishSubject<c> publishSubject = this.j;
        publishSubject.k.onNext(new c(i));
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void z(c1 c1Var) {
        a2.c(this, c1Var);
    }
}
