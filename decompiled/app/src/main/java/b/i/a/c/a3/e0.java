package b.i.a.c.a3;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.a3.b0;
import b.i.a.c.a3.h0;
import b.i.a.c.a3.s;
import b.i.a.c.a3.x;
import b.i.a.c.j1;
import b.i.a.c.j2;
import b.i.a.c.k1;
import b.i.a.c.w2.s;
import b.i.a.c.x2.t;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader.d;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: ProgressiveMediaPeriod.java */
/* loaded from: classes3.dex */
public final class e0 implements x, b.i.a.c.x2.j, Loader.b<a>, Loader.f, h0.d {
    public static final Map<String, String> j;
    public static final j1 k;

    @Nullable
    public x.a B;

    @Nullable
    public IcyHeaders C;
    public boolean F;
    public boolean G;
    public boolean H;
    public e I;
    public b.i.a.c.x2.t J;
    public boolean L;
    public boolean N;
    public boolean O;
    public int P;
    public long R;
    public boolean T;
    public int U;
    public boolean V;
    public boolean W;
    public final Uri l;
    public final b.i.a.c.e3.l m;
    public final b.i.a.c.w2.u n;
    public final b.i.a.c.e3.w o;
    public final b0.a p;
    public final s.a q;
    public final b r;

    /* renamed from: s, reason: collision with root package name */
    public final b.i.a.c.e3.o f809s;

    @Nullable
    public final String t;
    public final long u;
    public final d0 w;
    public final Loader v = new Loader("ProgressiveMediaPeriod");

    /* renamed from: x, reason: collision with root package name */
    public final b.i.a.c.f3.j f810x = new b.i.a.c.f3.j();

    /* renamed from: y, reason: collision with root package name */
    public final Runnable f811y = new g(this);

    /* renamed from: z, reason: collision with root package name */
    public final Runnable f812z = new i(this);
    public final Handler A = b.i.a.c.f3.e0.j();
    public d[] E = new d[0];
    public h0[] D = new h0[0];
    public long S = -9223372036854775807L;
    public long Q = -1;
    public long K = -9223372036854775807L;
    public int M = 1;

    /* compiled from: ProgressiveMediaPeriod.java */
    public final class a implements Loader.e, s.a {

        /* renamed from: b, reason: collision with root package name */
        public final Uri f813b;
        public final b.i.a.c.e3.y c;
        public final d0 d;
        public final b.i.a.c.x2.j e;
        public final b.i.a.c.f3.j f;
        public volatile boolean h;
        public long j;

        @Nullable
        public b.i.a.c.x2.w m;
        public boolean n;
        public final b.i.a.c.x2.s g = new b.i.a.c.x2.s();
        public boolean i = true;
        public long l = -1;
        public final long a = t.a.getAndIncrement();
        public b.i.a.c.e3.n k = a(0);

        public a(Uri uri, b.i.a.c.e3.l lVar, d0 d0Var, b.i.a.c.x2.j jVar, b.i.a.c.f3.j jVar2) {
            this.f813b = uri;
            this.c = new b.i.a.c.e3.y(lVar);
            this.d = d0Var;
            this.e = jVar;
            this.f = jVar2;
        }

        public final b.i.a.c.e3.n a(long j) {
            Collections.emptyMap();
            Uri uri = this.f813b;
            String str = e0.this.t;
            Map<String, String> map = e0.j;
            if (uri != null) {
                return new b.i.a.c.e3.n(uri, 0L, 1, null, map, j, -1L, str, 6, null);
            }
            throw new IllegalStateException("The uri must be set.");
        }

        public void b() throws IOException {
            b.i.a.c.e3.h sVar;
            int i;
            int iE = 0;
            while (iE == 0 && !this.h) {
                try {
                    long j = this.g.a;
                    b.i.a.c.e3.n nVarA = a(j);
                    this.k = nVarA;
                    long jA = this.c.a(nVarA);
                    this.l = jA;
                    if (jA != -1) {
                        this.l = jA + j;
                    }
                    e0.this.C = IcyHeaders.a(this.c.j());
                    b.i.a.c.e3.y yVar = this.c;
                    IcyHeaders icyHeaders = e0.this.C;
                    if (icyHeaders == null || (i = icyHeaders.o) == -1) {
                        sVar = yVar;
                    } else {
                        sVar = new s(yVar, i, this);
                        b.i.a.c.x2.w wVarB = e0.this.B(new d(0, true));
                        this.m = wVarB;
                        ((h0) wVarB).e(e0.k);
                    }
                    long jA2 = j;
                    ((m) this.d).b(sVar, this.f813b, this.c.j(), j, this.l, this.e);
                    if (e0.this.C != null) {
                        b.i.a.c.x2.h hVar = ((m) this.d).f828b;
                        if (hVar instanceof b.i.a.c.x2.h0.f) {
                            ((b.i.a.c.x2.h0.f) hVar).f1206s = true;
                        }
                    }
                    if (this.i) {
                        d0 d0Var = this.d;
                        long j2 = this.j;
                        b.i.a.c.x2.h hVar2 = ((m) d0Var).f828b;
                        Objects.requireNonNull(hVar2);
                        hVar2.g(jA2, j2);
                        this.i = false;
                    }
                    while (true) {
                        long j3 = jA2;
                        while (iE == 0 && !this.h) {
                            try {
                                b.i.a.c.f3.j jVar = this.f;
                                synchronized (jVar) {
                                    while (!jVar.f971b) {
                                        jVar.wait();
                                    }
                                }
                                d0 d0Var2 = this.d;
                                b.i.a.c.x2.s sVar2 = this.g;
                                m mVar = (m) d0Var2;
                                b.i.a.c.x2.h hVar3 = mVar.f828b;
                                Objects.requireNonNull(hVar3);
                                b.i.a.c.x2.i iVar = mVar.c;
                                Objects.requireNonNull(iVar);
                                iE = hVar3.e(iVar, sVar2);
                                jA2 = ((m) this.d).a();
                                if (jA2 > e0.this.u + j3) {
                                    break;
                                }
                            } catch (InterruptedException unused) {
                                throw new InterruptedIOException();
                            }
                        }
                        this.f.a();
                        e0 e0Var = e0.this;
                        e0Var.A.post(e0Var.f812z);
                    }
                    if (iE == 1) {
                        iE = 0;
                    } else if (((m) this.d).a() != -1) {
                        this.g.a = ((m) this.d).a();
                    }
                    b.i.a.c.e3.y yVar2 = this.c;
                    if (yVar2 != null) {
                        try {
                            yVar2.a.close();
                        } catch (IOException unused2) {
                        }
                    }
                } catch (Throwable th) {
                    if (iE != 1 && ((m) this.d).a() != -1) {
                        this.g.a = ((m) this.d).a();
                    }
                    b.i.a.c.e3.y yVar3 = this.c;
                    if (yVar3 != null) {
                        try {
                            yVar3.a.close();
                        } catch (IOException unused3) {
                        }
                    }
                    throw th;
                }
            }
        }
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    public interface b {
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    public final class c implements i0 {
        public final int a;

        public c(int i) {
            this.a = i;
        }

        @Override // b.i.a.c.a3.i0
        public int a(k1 k1Var, DecoderInputBuffer decoderInputBuffer, int i) {
            int i2;
            e0 e0Var = e0.this;
            int i3 = this.a;
            if (e0Var.D()) {
                return -3;
            }
            e0Var.y(i3);
            h0 h0Var = e0Var.D[i3];
            boolean z2 = e0Var.V;
            boolean z3 = (i & 2) != 0;
            h0.b bVar = h0Var.f819b;
            synchronized (h0Var) {
                decoderInputBuffer.m = false;
                i2 = -5;
                if (h0Var.o()) {
                    j1 j1Var = h0Var.c.b(h0Var.k()).a;
                    if (!z3 && j1Var == h0Var.h) {
                        int iL = h0Var.l(h0Var.t);
                        if (h0Var.q(iL)) {
                            decoderInputBuffer.j = h0Var.n[iL];
                            long j = h0Var.o[iL];
                            decoderInputBuffer.n = j;
                            if (j < h0Var.u) {
                                decoderInputBuffer.j(Integer.MIN_VALUE);
                            }
                            bVar.a = h0Var.m[iL];
                            bVar.f824b = h0Var.l[iL];
                            bVar.c = h0Var.p[iL];
                            i2 = -4;
                        } else {
                            decoderInputBuffer.m = true;
                            i2 = -3;
                        }
                    }
                    h0Var.r(j1Var, k1Var);
                } else {
                    if (!z2 && !h0Var.f821x) {
                        j1 j1Var2 = h0Var.B;
                        if (j1Var2 == null || (!z3 && j1Var2 == h0Var.h)) {
                            i2 = -3;
                        } else {
                            h0Var.r(j1Var2, k1Var);
                        }
                    }
                    decoderInputBuffer.j = 4;
                    i2 = -4;
                }
            }
            if (i2 == -4 && !decoderInputBuffer.n()) {
                boolean z4 = (i & 1) != 0;
                if ((i & 4) == 0) {
                    if (z4) {
                        g0 g0Var = h0Var.a;
                        g0.f(g0Var.e, decoderInputBuffer, h0Var.f819b, g0Var.c);
                    } else {
                        g0 g0Var2 = h0Var.a;
                        g0Var2.e = g0.f(g0Var2.e, decoderInputBuffer, h0Var.f819b, g0Var2.c);
                    }
                }
                if (!z4) {
                    h0Var.t++;
                }
            }
            if (i2 == -3) {
                e0Var.z(i3);
            }
            return i2;
        }

        @Override // b.i.a.c.a3.i0
        public void b() throws IOException {
            e0 e0Var = e0.this;
            h0 h0Var = e0Var.D[this.a];
            DrmSession drmSession = h0Var.i;
            if (drmSession == null || drmSession.getState() != 1) {
                e0Var.A();
            } else {
                DrmSession.DrmSessionException drmSessionExceptionF = h0Var.i.f();
                Objects.requireNonNull(drmSessionExceptionF);
                throw drmSessionExceptionF;
            }
        }

        @Override // b.i.a.c.a3.i0
        public int c(long j) {
            int i;
            e0 e0Var = e0.this;
            int i2 = this.a;
            boolean z2 = false;
            if (e0Var.D()) {
                return 0;
            }
            e0Var.y(i2);
            h0 h0Var = e0Var.D[i2];
            boolean z3 = e0Var.V;
            synchronized (h0Var) {
                int iL = h0Var.l(h0Var.t);
                if (h0Var.o() && j >= h0Var.o[iL]) {
                    if (j <= h0Var.w || !z3) {
                        i = h0Var.i(iL, h0Var.q - h0Var.t, j, true);
                        if (i == -1) {
                        }
                    } else {
                        i = h0Var.q - h0Var.t;
                    }
                }
                i = 0;
            }
            synchronized (h0Var) {
                if (i >= 0) {
                    if (h0Var.t + i <= h0Var.q) {
                        z2 = true;
                    }
                    b.c.a.a0.d.j(z2);
                    h0Var.t += i;
                } else {
                    b.c.a.a0.d.j(z2);
                    h0Var.t += i;
                }
            }
            if (i == 0) {
                e0Var.z(i2);
            }
            return i;
        }

        @Override // b.i.a.c.a3.i0
        public boolean d() {
            e0 e0Var = e0.this;
            return !e0Var.D() && e0Var.D[this.a].p(e0Var.V);
        }
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    public static final class d {
        public final int a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f815b;

        public d(int i, boolean z2) {
            this.a = i;
            this.f815b = z2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || d.class != obj.getClass()) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && this.f815b == dVar.f815b;
        }

        public int hashCode() {
            return (this.a * 31) + (this.f815b ? 1 : 0);
        }
    }

    /* compiled from: ProgressiveMediaPeriod.java */
    public static final class e {
        public final o0 a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean[] f816b;
        public final boolean[] c;
        public final boolean[] d;

        public e(o0 o0Var, boolean[] zArr) {
            this.a = o0Var;
            this.f816b = zArr;
            int i = o0Var.k;
            this.c = new boolean[i];
            this.d = new boolean[i];
        }
    }

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        j = Collections.unmodifiableMap(map);
        j1.b bVar = new j1.b();
        bVar.a = "icy";
        bVar.k = "application/x-icy";
        k = bVar.a();
    }

    public e0(Uri uri, b.i.a.c.e3.l lVar, d0 d0Var, b.i.a.c.w2.u uVar, s.a aVar, b.i.a.c.e3.w wVar, b0.a aVar2, b bVar, b.i.a.c.e3.o oVar, @Nullable String str, int i) {
        this.l = uri;
        this.m = lVar;
        this.n = uVar;
        this.q = aVar;
        this.o = wVar;
        this.p = aVar2;
        this.r = bVar;
        this.f809s = oVar;
        this.t = str;
        this.u = i;
        this.w = d0Var;
    }

    public void A() throws IOException {
        Loader loader = this.v;
        int iA = ((b.i.a.c.e3.s) this.o).a(this.M);
        IOException iOException = loader.e;
        if (iOException != null) {
            throw iOException;
        }
        Loader.d<? extends Loader.e> dVar = loader.d;
        if (dVar != null) {
            if (iA == Integer.MIN_VALUE) {
                iA = dVar.j;
            }
            IOException iOException2 = dVar.n;
            if (iOException2 != null && dVar.o > iA) {
                throw iOException2;
            }
        }
    }

    public final b.i.a.c.x2.w B(d dVar) {
        int length = this.D.length;
        for (int i = 0; i < length; i++) {
            if (dVar.equals(this.E[i])) {
                return this.D[i];
            }
        }
        b.i.a.c.e3.o oVar = this.f809s;
        Looper looper = this.A.getLooper();
        b.i.a.c.w2.u uVar = this.n;
        s.a aVar = this.q;
        Objects.requireNonNull(looper);
        Objects.requireNonNull(uVar);
        Objects.requireNonNull(aVar);
        h0 h0Var = new h0(oVar, looper, uVar, aVar);
        h0Var.g = this;
        int i2 = length + 1;
        d[] dVarArr = (d[]) Arrays.copyOf(this.E, i2);
        dVarArr[length] = dVar;
        int i3 = b.i.a.c.f3.e0.a;
        this.E = dVarArr;
        h0[] h0VarArr = (h0[]) Arrays.copyOf(this.D, i2);
        h0VarArr[length] = h0Var;
        this.D = h0VarArr;
        return h0Var;
    }

    public final void C() {
        a aVar = new a(this.l, this.m, this.w, this, this.f810x);
        if (this.G) {
            b.c.a.a0.d.D(w());
            long j2 = this.K;
            if (j2 != -9223372036854775807L && this.S > j2) {
                this.V = true;
                this.S = -9223372036854775807L;
                return;
            }
            b.i.a.c.x2.t tVar = this.J;
            Objects.requireNonNull(tVar);
            long j3 = tVar.h(this.S).a.c;
            long j4 = this.S;
            aVar.g.a = j3;
            aVar.j = j4;
            aVar.i = true;
            aVar.n = false;
            for (h0 h0Var : this.D) {
                h0Var.u = this.S;
            }
            this.S = -9223372036854775807L;
        }
        this.U = u();
        Loader loader = this.v;
        int iA = ((b.i.a.c.e3.s) this.o).a(this.M);
        Objects.requireNonNull(loader);
        Looper looperMyLooper = Looper.myLooper();
        b.c.a.a0.d.H(looperMyLooper);
        loader.e = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        loader.new d(looperMyLooper, aVar, this, iA, jElapsedRealtime).b(0L);
        b.i.a.c.e3.n nVar = aVar.k;
        b0.a aVar2 = this.p;
        aVar2.f(new t(aVar.a, nVar, jElapsedRealtime), new w(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)));
    }

    public final boolean D() {
        return this.O || w();
    }

    @Override // b.i.a.c.x2.j
    public void a(b.i.a.c.x2.t tVar) {
        this.A.post(new h(this, tVar));
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    public void b(Loader.e eVar, long j2, long j3, boolean z2) {
        a aVar = (a) eVar;
        b.i.a.c.e3.y yVar = aVar.c;
        t tVar = new t(aVar.a, aVar.k, yVar.c, yVar.d, j2, j3, yVar.f956b);
        Objects.requireNonNull(this.o);
        b0.a aVar2 = this.p;
        aVar2.c(tVar, new w(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)));
        if (z2) {
            return;
        }
        if (this.Q == -1) {
            this.Q = aVar.l;
        }
        for (h0 h0Var : this.D) {
            h0Var.s(false);
        }
        if (this.P > 0) {
            x.a aVar3 = this.B;
            Objects.requireNonNull(aVar3);
            aVar3.a(this);
        }
    }

    @Override // b.i.a.c.a3.x
    public long c() {
        if (this.P == 0) {
            return Long.MIN_VALUE;
        }
        return q();
    }

    @Override // com.google.android.exoplayer2.upstream.Loader.b
    public void d(Loader.e eVar, long j2, long j3) {
        b.i.a.c.x2.t tVar;
        a aVar = (a) eVar;
        if (this.K == -9223372036854775807L && (tVar = this.J) != null) {
            boolean zC = tVar.c();
            long jV = v();
            long j4 = jV == Long.MIN_VALUE ? 0L : jV + 10000;
            this.K = j4;
            ((f0) this.r).u(j4, zC, this.L);
        }
        b.i.a.c.e3.y yVar = aVar.c;
        t tVar2 = new t(aVar.a, aVar.k, yVar.c, yVar.d, j2, j3, yVar.f956b);
        Objects.requireNonNull(this.o);
        b0.a aVar2 = this.p;
        aVar2.d(tVar2, new w(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)));
        if (this.Q == -1) {
            this.Q = aVar.l;
        }
        this.V = true;
        x.a aVar3 = this.B;
        Objects.requireNonNull(aVar3);
        aVar3.a(this);
    }

    @Override // b.i.a.c.a3.x
    public void e() throws IOException {
        A();
        if (this.V && !this.G) {
            throw ParserException.a("Loading finished before preparation is complete.", null);
        }
    }

    @Override // b.i.a.c.a3.x
    public long f(long j2) {
        boolean z2;
        t();
        boolean[] zArr = this.I.f816b;
        if (!this.J.c()) {
            j2 = 0;
        }
        this.O = false;
        this.R = j2;
        if (w()) {
            this.S = j2;
            return j2;
        }
        if (this.M != 7) {
            int length = this.D.length;
            for (int i = 0; i < length; i++) {
                if (!this.D[i].t(j2, false) && (zArr[i] || !this.H)) {
                    z2 = false;
                    break;
                }
            }
            z2 = true;
            if (z2) {
                return j2;
            }
        }
        this.T = false;
        this.S = j2;
        this.V = false;
        if (this.v.b()) {
            for (h0 h0Var : this.D) {
                h0Var.h();
            }
            Loader.d<? extends Loader.e> dVar = this.v.d;
            b.c.a.a0.d.H(dVar);
            dVar.a(false);
        } else {
            this.v.e = null;
            for (h0 h0Var2 : this.D) {
                h0Var2.s(false);
            }
        }
        return j2;
    }

    @Override // b.i.a.c.a3.x
    public boolean g(long j2) {
        if (!this.V) {
            if (!(this.v.e != null) && !this.T && (!this.G || this.P != 0)) {
                boolean zB = this.f810x.b();
                if (this.v.b()) {
                    return zB;
                }
                C();
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.c.a3.x
    public boolean h() {
        boolean z2;
        if (this.v.b()) {
            b.i.a.c.f3.j jVar = this.f810x;
            synchronized (jVar) {
                z2 = jVar.f971b;
            }
            if (z2) {
                return true;
            }
        }
        return false;
    }

    @Override // b.i.a.c.a3.x
    public long i(long j2, j2 j2Var) {
        t();
        if (!this.J.c()) {
            return 0L;
        }
        t.a aVarH = this.J.h(j2);
        long j3 = aVarH.a.f1298b;
        long j4 = aVarH.f1296b.f1298b;
        long j5 = j2Var.c;
        if (j5 == 0 && j2Var.d == 0) {
            return j2;
        }
        int i = b.i.a.c.f3.e0.a;
        long j6 = j2 - j5;
        long j7 = ((j5 ^ j2) & (j2 ^ j6)) >= 0 ? j6 : Long.MIN_VALUE;
        long j8 = j2Var.d;
        long j9 = RecyclerView.FOREVER_NS;
        long j10 = j2 + j8;
        if (((j8 ^ j10) & (j2 ^ j10)) >= 0) {
            j9 = j10;
        }
        boolean z2 = false;
        boolean z3 = j7 <= j3 && j3 <= j9;
        if (j7 <= j4 && j4 <= j9) {
            z2 = true;
        }
        if (z3 && z2) {
            if (Math.abs(j3 - j2) <= Math.abs(j4 - j2)) {
                return j3;
            }
        } else {
            if (z3) {
                return j3;
            }
            if (!z2) {
                return j7;
            }
        }
        return j4;
    }

    @Override // b.i.a.c.x2.j
    public void j() {
        this.F = true;
        this.A.post(this.f811y);
    }

    @Override // b.i.a.c.a3.x
    public long k() {
        if (!this.O) {
            return -9223372036854775807L;
        }
        if (!this.V && u() <= this.U) {
            return -9223372036854775807L;
        }
        this.O = false;
        return this.R;
    }

    @Override // b.i.a.c.a3.x
    public void l(x.a aVar, long j2) {
        this.B = aVar;
        this.f810x.b();
        C();
    }

    @Override // b.i.a.c.a3.x
    public long m(b.i.a.c.c3.j[] jVarArr, boolean[] zArr, i0[] i0VarArr, boolean[] zArr2, long j2) {
        t();
        e eVar = this.I;
        o0 o0Var = eVar.a;
        boolean[] zArr3 = eVar.c;
        int i = this.P;
        for (int i2 = 0; i2 < jVarArr.length; i2++) {
            if (i0VarArr[i2] != null && (jVarArr[i2] == null || !zArr[i2])) {
                int i3 = ((c) i0VarArr[i2]).a;
                b.c.a.a0.d.D(zArr3[i3]);
                this.P--;
                zArr3[i3] = false;
                i0VarArr[i2] = null;
            }
        }
        boolean z2 = !this.N ? j2 == 0 : i != 0;
        for (int i4 = 0; i4 < jVarArr.length; i4++) {
            if (i0VarArr[i4] == null && jVarArr[i4] != null) {
                b.i.a.c.c3.j jVar = jVarArr[i4];
                b.c.a.a0.d.D(jVar.length() == 1);
                b.c.a.a0.d.D(jVar.f(0) == 0);
                int iA = o0Var.a(jVar.a());
                b.c.a.a0.d.D(!zArr3[iA]);
                this.P++;
                zArr3[iA] = true;
                i0VarArr[i4] = new c(iA);
                zArr2[i4] = true;
                if (!z2) {
                    h0 h0Var = this.D[iA];
                    z2 = (h0Var.t(j2, true) || h0Var.k() == 0) ? false : true;
                }
            }
        }
        if (this.P == 0) {
            this.T = false;
            this.O = false;
            if (this.v.b()) {
                for (h0 h0Var2 : this.D) {
                    h0Var2.h();
                }
                Loader.d<? extends Loader.e> dVar = this.v.d;
                b.c.a.a0.d.H(dVar);
                dVar.a(false);
            } else {
                for (h0 h0Var3 : this.D) {
                    h0Var3.s(false);
                }
            }
        } else if (z2) {
            j2 = f(j2);
            for (int i5 = 0; i5 < i0VarArr.length; i5++) {
                if (i0VarArr[i5] != null) {
                    zArr2[i5] = true;
                }
            }
        }
        this.N = true;
        return j2;
    }

    @Override // b.i.a.c.a3.x
    public o0 n() {
        t();
        return this.I.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00db  */
    @Override // com.google.android.exoplayer2.upstream.Loader.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Loader.c o(Loader.e eVar, long j2, long j3, IOException iOException, int i) {
        long jMin;
        boolean z2;
        Loader.c cVarA;
        b.i.a.c.x2.t tVar;
        boolean z3;
        a aVar = (a) eVar;
        if (this.Q == -1) {
            this.Q = aVar.l;
        }
        b.i.a.c.e3.y yVar = aVar.c;
        t tVar2 = new t(aVar.a, aVar.k, yVar.c, yVar.d, j2, j3, yVar.f956b);
        b.i.a.c.f3.e0.M(aVar.j);
        b.i.a.c.f3.e0.M(this.K);
        if ((iOException instanceof ParserException) || (iOException instanceof FileNotFoundException) || (iOException instanceof HttpDataSource$CleartextNotPermittedException) || (iOException instanceof Loader.UnexpectedLoaderException)) {
            jMin = -9223372036854775807L;
        } else {
            int i2 = DataSourceException.j;
            Throwable cause = iOException;
            while (true) {
                if (cause == null) {
                    z3 = false;
                    break;
                }
                if ((cause instanceof DataSourceException) && ((DataSourceException) cause).reason == 2008) {
                    z3 = true;
                    break;
                }
                cause = cause.getCause();
            }
            if (!z3) {
                jMin = Math.min((i - 1) * 1000, 5000);
            }
        }
        if (jMin == -9223372036854775807L) {
            cVarA = Loader.f2978b;
        } else {
            int iU = u();
            boolean z4 = iU > this.U;
            if (this.Q != -1 || ((tVar = this.J) != null && tVar.i() != -9223372036854775807L)) {
                this.U = iU;
            } else if (!this.G || D()) {
                this.O = this.G;
                this.R = 0L;
                this.U = 0;
                for (h0 h0Var : this.D) {
                    h0Var.s(false);
                }
                aVar.g.a = 0L;
                aVar.j = 0L;
                aVar.i = true;
                aVar.n = false;
            } else {
                this.T = true;
                z2 = false;
                cVarA = !z2 ? Loader.a(z4, jMin) : Loader.a;
            }
            z2 = true;
            if (!z2) {
            }
        }
        int i3 = cVarA.a;
        boolean z5 = !(i3 == 0 || i3 == 1);
        b0.a aVar2 = this.p;
        aVar2.e(tVar2, new w(1, -1, null, 0, null, aVar2.a(aVar.j), aVar2.a(this.K)), iOException, z5);
        if (z5) {
            Objects.requireNonNull(this.o);
        }
        return cVarA;
    }

    @Override // b.i.a.c.x2.j
    public b.i.a.c.x2.w p(int i, int i2) {
        return B(new d(i, false));
    }

    @Override // b.i.a.c.a3.x
    public long q() {
        long jV;
        boolean z2;
        long j2;
        t();
        boolean[] zArr = this.I.f816b;
        if (this.V) {
            return Long.MIN_VALUE;
        }
        if (w()) {
            return this.S;
        }
        if (this.H) {
            int length = this.D.length;
            jV = Long.MAX_VALUE;
            for (int i = 0; i < length; i++) {
                if (zArr[i]) {
                    h0 h0Var = this.D[i];
                    synchronized (h0Var) {
                        z2 = h0Var.f821x;
                    }
                    if (z2) {
                        continue;
                    } else {
                        h0 h0Var2 = this.D[i];
                        synchronized (h0Var2) {
                            j2 = h0Var2.w;
                        }
                        jV = Math.min(jV, j2);
                    }
                }
            }
        } else {
            jV = Long.MAX_VALUE;
        }
        if (jV == RecyclerView.FOREVER_NS) {
            jV = v();
        }
        return jV == Long.MIN_VALUE ? this.R : jV;
    }

    @Override // b.i.a.c.a3.x
    public void r(long j2, boolean z2) {
        long jG;
        int i;
        t();
        if (w()) {
            return;
        }
        boolean[] zArr = this.I.c;
        int length = this.D.length;
        for (int i2 = 0; i2 < length; i2++) {
            h0 h0Var = this.D[i2];
            boolean z3 = zArr[i2];
            g0 g0Var = h0Var.a;
            synchronized (h0Var) {
                int i3 = h0Var.q;
                jG = -1;
                if (i3 != 0) {
                    long[] jArr = h0Var.o;
                    int i4 = h0Var.f820s;
                    if (j2 >= jArr[i4]) {
                        int i5 = h0Var.i(i4, (!z3 || (i = h0Var.t) == i3) ? i3 : i + 1, j2, z2);
                        if (i5 != -1) {
                            jG = h0Var.g(i5);
                        }
                    }
                }
            }
            g0Var.a(jG);
        }
    }

    @Override // b.i.a.c.a3.x
    public void s(long j2) {
    }

    @EnsuresNonNull({"trackState", "seekMap"})
    public final void t() {
        b.c.a.a0.d.D(this.G);
        Objects.requireNonNull(this.I);
        Objects.requireNonNull(this.J);
    }

    public final int u() {
        int iN = 0;
        for (h0 h0Var : this.D) {
            iN += h0Var.n();
        }
        return iN;
    }

    public final long v() {
        long j2;
        long jMax = Long.MIN_VALUE;
        for (h0 h0Var : this.D) {
            synchronized (h0Var) {
                j2 = h0Var.w;
            }
            jMax = Math.max(jMax, j2);
        }
        return jMax;
    }

    public final boolean w() {
        return this.S != -9223372036854775807L;
    }

    public final void x() {
        if (this.W || this.G || !this.F || this.J == null) {
            return;
        }
        for (h0 h0Var : this.D) {
            if (h0Var.m() == null) {
                return;
            }
        }
        this.f810x.a();
        int length = this.D.length;
        n0[] n0VarArr = new n0[length];
        boolean[] zArr = new boolean[length];
        for (int i = 0; i < length; i++) {
            j1 j1VarM = this.D[i].m();
            Objects.requireNonNull(j1VarM);
            String str = j1VarM.w;
            boolean zH = b.i.a.c.f3.t.h(str);
            boolean z2 = zH || b.i.a.c.f3.t.j(str);
            zArr[i] = z2;
            this.H = z2 | this.H;
            IcyHeaders icyHeaders = this.C;
            if (icyHeaders != null) {
                if (zH || this.E[i].f815b) {
                    Metadata metadata = j1VarM.u;
                    Metadata metadata2 = metadata == null ? new Metadata(icyHeaders) : metadata.a(icyHeaders);
                    j1.b bVarA = j1VarM.a();
                    bVarA.i = metadata2;
                    j1VarM = bVarA.a();
                }
                if (zH && j1VarM.q == -1 && j1VarM.r == -1 && icyHeaders.j != -1) {
                    j1.b bVarA2 = j1VarM.a();
                    bVarA2.f = icyHeaders.j;
                    j1VarM = bVarA2.a();
                }
            }
            int iD = this.n.d(j1VarM);
            j1.b bVarA3 = j1VarM.a();
            bVarA3.D = iD;
            n0VarArr[i] = new n0(bVarA3.a());
        }
        this.I = new e(new o0(n0VarArr), zArr);
        this.G = true;
        x.a aVar = this.B;
        Objects.requireNonNull(aVar);
        aVar.b(this);
    }

    public final void y(int i) {
        t();
        e eVar = this.I;
        boolean[] zArr = eVar.d;
        if (zArr[i]) {
            return;
        }
        j1 j1Var = eVar.a.l[i].l[0];
        b0.a aVar = this.p;
        aVar.b(new w(1, b.i.a.c.f3.t.g(j1Var.w), j1Var, 0, null, aVar.a(this.R), -9223372036854775807L));
        zArr[i] = true;
    }

    public final void z(int i) {
        t();
        boolean[] zArr = this.I.f816b;
        if (this.T && zArr[i] && !this.D[i].p(false)) {
            this.S = 0L;
            this.T = false;
            this.O = true;
            this.R = 0L;
            this.U = 0;
            for (h0 h0Var : this.D) {
                h0Var.s(false);
            }
            x.a aVar = this.B;
            Objects.requireNonNull(aVar);
            aVar.a(this);
        }
    }
}
