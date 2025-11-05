package b.i.a.c.s2;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import androidx.media.AudioAttributesCompat;
import b.i.a.c.a2;
import b.i.a.c.a3.a0;
import b.i.a.c.e3.f;
import b.i.a.c.j1;
import b.i.a.c.o1;
import b.i.a.c.o2;
import b.i.a.c.p1;
import b.i.a.c.p2;
import b.i.a.c.s2.h1;
import b.i.a.c.x1;
import b.i.a.c.y1;
import b.i.a.c.z1;
import b.i.b.b.q;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArraySet;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: AnalyticsCollector.java */
/* loaded from: classes3.dex */
public class g1 implements y1.e, b.i.a.c.t2.r, b.i.a.c.g3.x, b.i.a.c.a3.b0, f.a, b.i.a.c.w2.s {
    public final b.i.a.c.f3.g j;
    public final o2.b k;
    public final o2.c l;
    public final a m;
    public final SparseArray<h1.a> n;
    public b.i.a.c.f3.p<h1> o;
    public y1 p;
    public b.i.a.c.f3.o q;
    public boolean r;

    /* compiled from: AnalyticsCollector.java */
    public static final class a {
        public final o2.b a;

        /* renamed from: b, reason: collision with root package name */
        public b.i.b.b.p<a0.a> f1081b;
        public b.i.b.b.q<a0.a, o2> c;

        @Nullable
        public a0.a d;
        public a0.a e;
        public a0.a f;

        public a(o2.b bVar) {
            this.a = bVar;
            b.i.b.b.a<Object> aVar = b.i.b.b.p.k;
            this.f1081b = b.i.b.b.h0.l;
            this.c = b.i.b.b.i0.m;
        }

        @Nullable
        public static a0.a b(y1 y1Var, b.i.b.b.p<a0.a> pVar, @Nullable a0.a aVar, o2.b bVar) {
            o2 o2VarK = y1Var.K();
            int iM = y1Var.m();
            Object objM = o2VarK.q() ? null : o2VarK.m(iM);
            int iB = (y1Var.f() || o2VarK.q()) ? -1 : o2VarK.f(iM, bVar).b(b.i.a.c.f3.e0.B(y1Var.T()) - bVar.n);
            for (int i = 0; i < pVar.size(); i++) {
                a0.a aVar2 = pVar.get(i);
                if (c(aVar2, objM, y1Var.f(), y1Var.B(), y1Var.q(), iB)) {
                    return aVar2;
                }
            }
            if (pVar.isEmpty() && aVar != null) {
                if (c(aVar, objM, y1Var.f(), y1Var.B(), y1Var.q(), iB)) {
                    return aVar;
                }
            }
            return null;
        }

        public static boolean c(a0.a aVar, @Nullable Object obj, boolean z2, int i, int i2, int i3) {
            if (aVar.a.equals(obj)) {
                return (z2 && aVar.f835b == i && aVar.c == i2) || (!z2 && aVar.f835b == -1 && aVar.e == i3);
            }
            return false;
        }

        public final void a(q.a<a0.a, o2> aVar, @Nullable a0.a aVar2, o2 o2Var) {
            if (aVar2 == null) {
                return;
            }
            if (o2Var.b(aVar2.a) != -1) {
                aVar.c(aVar2, o2Var);
                return;
            }
            o2 o2Var2 = this.c.get(aVar2);
            if (o2Var2 != null) {
                aVar.c(aVar2, o2Var2);
            }
        }

        public final void d(o2 o2Var) {
            q.a<a0.a, o2> aVar = new q.a<>(4);
            if (this.f1081b.isEmpty()) {
                a(aVar, this.e, o2Var);
                if (!b.i.a.f.e.o.f.V(this.f, this.e)) {
                    a(aVar, this.f, o2Var);
                }
                if (!b.i.a.f.e.o.f.V(this.d, this.e) && !b.i.a.f.e.o.f.V(this.d, this.f)) {
                    a(aVar, this.d, o2Var);
                }
            } else {
                for (int i = 0; i < this.f1081b.size(); i++) {
                    a(aVar, this.f1081b.get(i), o2Var);
                }
                if (!this.f1081b.contains(this.d)) {
                    a(aVar, this.d, o2Var);
                }
            }
            this.c = aVar.a();
        }
    }

    public g1(b.i.a.c.f3.g gVar) {
        this.j = gVar;
        this.o = new b.i.a.c.f3.p<>(new CopyOnWriteArraySet(), b.i.a.c.f3.e0.o(), gVar, o0.a);
        o2.b bVar = new o2.b();
        this.k = bVar;
        this.l = new o2.c();
        this.m = new a(bVar);
        this.n = new SparseArray<>();
    }

    @Override // b.i.a.c.y1.c
    public void A(p1 p1Var) {
        h1.a aVarK0 = k0();
        r0 r0Var = new r0(aVarK0, p1Var);
        this.n.put(14, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(14, r0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void B(String str) {
        h1.a aVarP0 = p0();
        t tVar = new t(aVarP0, str);
        this.n.put(PointerIconCompat.TYPE_ALL_SCROLL, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ALL_SCROLL, tVar);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void C(String str, long j, long j2) {
        h1.a aVarP0 = p0();
        l0 l0Var = new l0(aVarP0, str, j2, j);
        this.n.put(PointerIconCompat.TYPE_VERTICAL_TEXT, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_VERTICAL_TEXT, l0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void D(boolean z2) {
        h1.a aVarK0 = k0();
        g0 g0Var = new g0(aVarK0, z2);
        this.n.put(9, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(9, g0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void E(y1 y1Var, y1.d dVar) {
        a2.e(this, y1Var, dVar);
    }

    @Override // b.i.a.c.g3.x
    public final void F(int i, long j) {
        h1.a aVarO0 = o0();
        z zVar = new z(aVarO0, i, j);
        this.n.put(AudioAttributesCompat.FLAG_ALL, aVarO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(AudioAttributesCompat.FLAG_ALL, zVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void G(int i, boolean z2) {
        a2.d(this, i, z2);
    }

    @Override // b.i.a.c.y1.c
    public final void H(boolean z2, int i) {
        h1.a aVarK0 = k0();
        j0 j0Var = new j0(aVarK0, z2, i);
        this.n.put(-1, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(-1, j0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void I(j1 j1Var, @Nullable b.i.a.c.v2.g gVar) {
        h1.a aVarP0 = p0();
        i0 i0Var = new i0(aVarP0, j1Var, gVar);
        this.n.put(PointerIconCompat.TYPE_ALIAS, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ALIAS, i0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void J(int i, @Nullable a0.a aVar) {
        h1.a aVarN0 = n0(i, aVar);
        t0 t0Var = new t0(aVarN0);
        this.n.put(1034, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1034, t0Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void K(Object obj, long j) {
        h1.a aVarP0 = p0();
        f1 f1Var = new f1(aVarP0, obj, j);
        this.n.put(1027, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1027, f1Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void L(int i) {
        h1.a aVarK0 = k0();
        b0 b0Var = new b0(aVarK0, i);
        this.n.put(8, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(8, b0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void M(@Nullable o1 o1Var, int i) {
        h1.a aVarK0 = k0();
        q qVar = new q(aVarK0, o1Var, i);
        this.n.put(1, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1, qVar);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void N(Exception exc) {
        h1.a aVarP0 = p0();
        e0 e0Var = new e0(aVarP0, exc);
        this.n.put(PointerIconCompat.TYPE_ZOOM_IN, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ZOOM_IN, e0Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public /* synthetic */ void O(j1 j1Var) {
        b.i.a.c.g3.w.a(this, j1Var);
    }

    @Override // b.i.a.c.g3.x
    public final void P(b.i.a.c.v2.e eVar) {
        h1.a aVarP0 = p0();
        d0 d0Var = new d0(aVarP0, eVar);
        this.n.put(PointerIconCompat.TYPE_GRAB, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_GRAB, d0Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void Q(j1 j1Var, @Nullable b.i.a.c.v2.g gVar) {
        h1.a aVarP0 = p0();
        y0 y0Var = new y0(aVarP0, j1Var, gVar);
        this.n.put(1022, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1022, y0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void R(long j) {
        h1.a aVarP0 = p0();
        n0 n0Var = new n0(aVarP0, j);
        this.n.put(PointerIconCompat.TYPE_COPY, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_COPY, n0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void S(int i, @Nullable a0.a aVar) {
        h1.a aVarN0 = n0(i, aVar);
        e1 e1Var = new e1(aVarN0);
        this.n.put(1031, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1031, e1Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void T(Exception exc) {
        h1.a aVarP0 = p0();
        k kVar = new k(aVarP0, exc);
        this.n.put(1037, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1037, kVar);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public /* synthetic */ void U(j1 j1Var) {
        b.i.a.c.t2.q.a(this, j1Var);
    }

    @Override // b.i.a.c.g3.x
    public final void V(Exception exc) {
        h1.a aVarP0 = p0();
        q0 q0Var = new q0(aVarP0, exc);
        this.n.put(1038, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1038, q0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void W(boolean z2, int i) {
        h1.a aVarK0 = k0();
        d1 d1Var = new d1(aVarK0, z2, i);
        this.n.put(5, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(5, d1Var);
        pVar.a();
    }

    @Override // b.i.a.c.a3.b0
    public final void X(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        h1.a aVarN0 = n0(i, aVar);
        y yVar = new y(aVarN0, tVar, wVar);
        this.n.put(PointerIconCompat.TYPE_CONTEXT_MENU, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_CONTEXT_MENU, yVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void Y(b.i.a.c.a3.o0 o0Var, b.i.a.c.c3.n nVar) {
        h1.a aVarK0 = k0();
        i iVar = new i(aVarK0, o0Var, nVar);
        this.n.put(2, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(2, iVar);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void Z(b.i.a.c.v2.e eVar) {
        h1.a aVarO0 = o0();
        j jVar = new j(aVarO0, eVar);
        this.n.put(InputDeviceCompat.SOURCE_GAMEPAD, aVarO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(InputDeviceCompat.SOURCE_GAMEPAD, jVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void a() {
        h1.a aVarK0 = k0();
        u uVar = new u(aVarK0);
        this.n.put(-1, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(-1, uVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public void a0(int i, int i2) {
        h1.a aVarP0 = p0();
        n nVar = new n(aVarP0, i, i2);
        this.n.put(1029, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1029, nVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public final void b(Metadata metadata) {
        h1.a aVarK0 = k0();
        v vVar = new v(aVarK0, metadata);
        this.n.put(PointerIconCompat.TYPE_CROSSHAIR, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_CROSSHAIR, vVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void b0(x1 x1Var) {
        h1.a aVarK0 = k0();
        m mVar = new m(aVarK0, x1Var);
        this.n.put(12, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(12, mVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void c() {
        a2.r(this);
    }

    @Override // b.i.a.c.w2.s
    public final void c0(int i, @Nullable a0.a aVar, int i2) {
        h1.a aVarN0 = n0(i, aVar);
        p0 p0Var = new p0(aVarN0, i2);
        this.n.put(1030, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1030, p0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public final void d(boolean z2) {
        h1.a aVarP0 = p0();
        u0 u0Var = new u0(aVarP0, z2);
        this.n.put(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_TOP_LEFT_DIAGONAL_DOUBLE_ARROW, u0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void d0(int i, @Nullable a0.a aVar) {
        h1.a aVarN0 = n0(i, aVar);
        b bVar = new b(aVarN0);
        this.n.put(1035, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1035, bVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void e(List list) {
        a2.b(this, list);
    }

    @Override // b.i.a.c.t2.r
    public final void e0(int i, long j, long j2) {
        h1.a aVarP0 = p0();
        c0 c0Var = new c0(aVarP0, i, j, j2);
        this.n.put(PointerIconCompat.TYPE_NO_DROP, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_NO_DROP, c0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public final void f(b.i.a.c.g3.y yVar) {
        h1.a aVarP0 = p0();
        m0 m0Var = new m0(aVarP0, yVar);
        this.n.put(1028, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1028, m0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void f0(PlaybackException playbackException) {
        a2.p(this, playbackException);
    }

    @Override // b.i.a.c.y1.c
    public final void g(y1.f fVar, y1.f fVar2, int i) {
        if (i == 1) {
            this.r = false;
        }
        a aVar = this.m;
        y1 y1Var = this.p;
        Objects.requireNonNull(y1Var);
        aVar.d = a.b(y1Var, aVar.f1081b, aVar.e, aVar.a);
        h1.a aVarK0 = k0();
        r rVar = new r(aVarK0, i, fVar, fVar2);
        this.n.put(11, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(11, rVar);
        pVar.a();
    }

    @Override // b.i.a.c.a3.b0
    public final void g0(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar, IOException iOException, boolean z2) {
        h1.a aVarN0 = n0(i, aVar);
        f0 f0Var = new f0(aVarN0, tVar, wVar, iOException, z2);
        this.n.put(PointerIconCompat.TYPE_HELP, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_HELP, f0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void h(int i) {
        h1.a aVarK0 = k0();
        b1 b1Var = new b1(aVarK0, i);
        this.n.put(6, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(6, b1Var);
        pVar.a();
    }

    @Override // b.i.a.c.g3.x
    public final void h0(long j, int i) {
        h1.a aVarO0 = o0();
        c1 c1Var = new c1(aVarO0, j, i);
        this.n.put(1026, aVarO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1026, c1Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void i(boolean z2) {
        z1.d(this, z2);
    }

    @Override // b.i.a.c.w2.s
    public final void i0(int i, @Nullable a0.a aVar) {
        h1.a aVarN0 = n0(i, aVar);
        v0 v0Var = new v0(aVarN0);
        this.n.put(1033, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1033, v0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public /* synthetic */ void j(int i) {
        z1.l(this, i);
    }

    @Override // b.i.a.c.y1.c
    public void j0(boolean z2) {
        h1.a aVarK0 = k0();
        z0 z0Var = new z0(aVarK0, z2);
        this.n.put(7, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(7, z0Var);
        pVar.a();
    }

    @Override // b.i.a.c.t2.r
    public final void k(b.i.a.c.v2.e eVar) {
        h1.a aVarO0 = o0();
        w0 w0Var = new w0(aVarO0, eVar);
        this.n.put(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, aVarO0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_HORIZONTAL_DOUBLE_ARROW, w0Var);
        pVar.a();
    }

    public final h1.a k0() {
        return m0(this.m.d);
    }

    @Override // b.i.a.c.g3.x
    public final void l(String str) {
        h1.a aVarP0 = p0();
        f fVar = new f(aVarP0, str);
        this.n.put(1024, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1024, fVar);
        pVar.a();
    }

    @RequiresNonNull({"player"})
    public final h1.a l0(o2 o2Var, int i, @Nullable a0.a aVar) {
        long jW;
        a0.a aVar2 = o2Var.q() ? null : aVar;
        long jD = this.j.d();
        boolean z2 = false;
        boolean z3 = o2Var.equals(this.p.K()) && i == this.p.C();
        long jA = 0;
        if (aVar2 != null && aVar2.a()) {
            if (z3 && this.p.B() == aVar2.f835b && this.p.q() == aVar2.c) {
                z2 = true;
            }
            if (z2) {
                jA = this.p.T();
            }
        } else {
            if (z3) {
                jW = this.p.w();
                return new h1.a(jD, o2Var, i, aVar2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
            }
            if (!o2Var.q()) {
                jA = o2Var.o(i, this.l, 0L).a();
            }
        }
        jW = jA;
        return new h1.a(jD, o2Var, i, aVar2, jW, this.p.K(), this.p.C(), this.m.d, this.p.T(), this.p.g());
    }

    @Override // b.i.a.c.t2.r
    public final void m(b.i.a.c.v2.e eVar) {
        h1.a aVarP0 = p0();
        l lVar = new l(aVarP0, eVar);
        this.n.put(PointerIconCompat.TYPE_TEXT, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_TEXT, lVar);
        pVar.a();
    }

    public final h1.a m0(@Nullable a0.a aVar) {
        Objects.requireNonNull(this.p);
        o2 o2Var = aVar == null ? null : this.m.c.get(aVar);
        if (aVar != null && o2Var != null) {
            return l0(o2Var, o2Var.h(aVar.a, this.k).l, aVar);
        }
        int iC = this.p.C();
        o2 o2VarK = this.p.K();
        if (!(iC < o2VarK.p())) {
            o2VarK = o2.j;
        }
        return l0(o2VarK, iC, null);
    }

    @Override // b.i.a.c.g3.x
    public final void n(String str, long j, long j2) {
        h1.a aVarP0 = p0();
        d dVar = new d(aVarP0, str, j2, j);
        this.n.put(PointerIconCompat.TYPE_GRABBING, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_GRABBING, dVar);
        pVar.a();
    }

    public final h1.a n0(int i, @Nullable a0.a aVar) {
        Objects.requireNonNull(this.p);
        if (aVar != null) {
            return this.m.c.get(aVar) != null ? m0(aVar) : l0(o2.j, i, aVar);
        }
        o2 o2VarK = this.p.K();
        if (!(i < o2VarK.p())) {
            o2VarK = o2.j;
        }
        return l0(o2VarK, i, null);
    }

    @Override // b.i.a.c.a3.b0
    public final void o(int i, @Nullable a0.a aVar, b.i.a.c.a3.w wVar) {
        h1.a aVarN0 = n0(i, aVar);
        g gVar = new g(aVarN0, wVar);
        this.n.put(PointerIconCompat.TYPE_WAIT, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_WAIT, gVar);
        pVar.a();
    }

    public final h1.a o0() {
        return m0(this.m.e);
    }

    @Override // b.i.a.c.y1.c
    public void p(p2 p2Var) {
        h1.a aVarK0 = k0();
        w wVar = new w(aVarK0, p2Var);
        this.n.put(2, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(2, wVar);
        pVar.a();
    }

    public final h1.a p0() {
        return m0(this.m.f);
    }

    @Override // b.i.a.c.a3.b0
    public final void q(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        h1.a aVarN0 = n0(i, aVar);
        h0 h0Var = new h0(aVarN0, tVar, wVar);
        this.n.put(PointerIconCompat.TYPE_HAND, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_HAND, h0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void r(boolean z2) {
        h1.a aVarK0 = k0();
        e eVar = new e(aVarK0, z2);
        this.n.put(3, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(3, eVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void s(PlaybackException playbackException) {
        b.i.a.c.a3.y yVar;
        h1.a aVarM0 = (!(playbackException instanceof ExoPlaybackException) || (yVar = ((ExoPlaybackException) playbackException).mediaPeriodId) == null) ? null : m0(new a0.a(yVar));
        if (aVarM0 == null) {
            aVarM0 = k0();
        }
        b.i.a.c.s2.a aVar = new b.i.a.c.s2.a(aVarM0, playbackException);
        this.n.put(10, aVarM0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(10, aVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public void t(y1.b bVar) {
        h1.a aVarK0 = k0();
        a0 a0Var = new a0(aVarK0, bVar);
        this.n.put(13, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(13, a0Var);
        pVar.a();
    }

    @Override // b.i.a.c.w2.s
    public final void u(int i, @Nullable a0.a aVar, Exception exc) {
        h1.a aVarN0 = n0(i, aVar);
        c cVar = new c(aVarN0, exc);
        this.n.put(1032, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1032, cVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void v(o2 o2Var, int i) {
        a aVar = this.m;
        y1 y1Var = this.p;
        Objects.requireNonNull(y1Var);
        aVar.d = a.b(y1Var, aVar.f1081b, aVar.e, aVar.a);
        aVar.d(y1Var.K());
        h1.a aVarK0 = k0();
        x xVar = new x(aVarK0, i);
        this.n.put(0, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(0, xVar);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public final void w(float f) {
        h1.a aVarP0 = p0();
        s sVar = new s(aVarP0, f);
        this.n.put(PointerIconCompat.TYPE_ZOOM_OUT, aVarP0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(PointerIconCompat.TYPE_ZOOM_OUT, sVar);
        pVar.a();
    }

    @Override // b.i.a.c.a3.b0
    public final void x(int i, @Nullable a0.a aVar, b.i.a.c.a3.t tVar, b.i.a.c.a3.w wVar) {
        h1.a aVarN0 = n0(i, aVar);
        k0 k0Var = new k0(aVarN0, tVar, wVar);
        this.n.put(1000, aVarN0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(1000, k0Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.c
    public final void y(int i) {
        h1.a aVarK0 = k0();
        a1 a1Var = new a1(aVarK0, i);
        this.n.put(4, aVarK0);
        b.i.a.c.f3.p<h1> pVar = this.o;
        pVar.b(4, a1Var);
        pVar.a();
    }

    @Override // b.i.a.c.y1.e
    public /* synthetic */ void z(b.i.a.c.c1 c1Var) {
        a2.c(this, c1Var);
    }
}
