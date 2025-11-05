package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b.i.a.c.e3.w;
import b.i.a.c.f3.q;
import b.i.a.c.f3.t;
import b.i.a.c.j1;
import b.i.a.c.w2.a0;
import b.i.a.c.w2.b0;
import b.i.a.c.w2.e0;
import b.i.a.c.w2.s;
import b.i.a.c.w2.u;
import b.i.a.c.w2.z;
import b.i.a.c.x0;
import b.i.b.b.h;
import b.i.b.b.h0;
import b.i.b.b.p;
import b.i.b.b.r;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@RequiresApi(18)
/* loaded from: classes3.dex */
public class DefaultDrmSessionManager implements u {

    /* renamed from: b, reason: collision with root package name */
    public final UUID f2929b;
    public final a0.c c;
    public final e0 d;
    public final HashMap<String, String> e;
    public final boolean f;
    public final int[] g;
    public final boolean h;
    public final e i;
    public final w j;
    public final f k;
    public final long l;
    public final List<DefaultDrmSession> m;
    public final Set<d> n;
    public final Set<DefaultDrmSession> o;
    public int p;

    @Nullable
    public a0 q;

    @Nullable
    public DefaultDrmSession r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public DefaultDrmSession f2930s;
    public Looper t;
    public Handler u;
    public int v;

    @Nullable
    public byte[] w;

    /* renamed from: x, reason: collision with root package name */
    @Nullable
    public volatile c f2931x;

    public static final class MissingSchemeDataException extends Exception {
        /* JADX WARN: Illegal instructions before constructor call */
        public MissingSchemeDataException(UUID uuid, a aVar) {
            String strValueOf = String.valueOf(uuid);
            super(b.d.b.a.a.j(strValueOf.length() + 29, "Media does not support uuid: ", strValueOf));
        }
    }

    public class b implements a0.b {
        public b(a aVar) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.m) {
                if (Arrays.equals(defaultDrmSession.t, bArr)) {
                    if (message.what == 2 && defaultDrmSession.e == 0 && defaultDrmSession.n == 4) {
                        int i = b.i.a.c.f3.e0.a;
                        defaultDrmSession.i(false);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public class d implements u.b {

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final s.a f2932b;

        @Nullable
        public DrmSession c;
        public boolean d;

        public d(@Nullable s.a aVar) {
            this.f2932b = aVar;
        }

        @Override // b.i.a.c.w2.u.b
        public void release() {
            Handler handler = DefaultDrmSessionManager.this.u;
            Objects.requireNonNull(handler);
            b.i.a.c.f3.e0.E(handler, new b.i.a.c.w2.d(this));
        }
    }

    public class e implements DefaultDrmSession.a {
        public final Set<DefaultDrmSession> a = new HashSet();

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public DefaultDrmSession f2933b;

        public void a(Exception exc, boolean z2) {
            this.f2933b = null;
            p pVarN = p.n(this.a);
            this.a.clear();
            b.i.b.b.a aVarP = pVarN.p();
            while (aVarP.hasNext()) {
                ((DefaultDrmSession) aVarP.next()).k(exc, z2 ? 1 : 3);
            }
        }
    }

    public class f implements DefaultDrmSession.b {
        public f(a aVar) {
        }
    }

    public DefaultDrmSessionManager(UUID uuid, a0.c cVar, e0 e0Var, HashMap map, boolean z2, int[] iArr, boolean z3, w wVar, long j, a aVar) {
        Objects.requireNonNull(uuid);
        b.c.a.a0.d.m(!x0.f1158b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f2929b = uuid;
        this.c = cVar;
        this.d = e0Var;
        this.e = map;
        this.f = z2;
        this.g = iArr;
        this.h = z3;
        this.j = wVar;
        this.i = new e();
        this.k = new f(null);
        this.v = 0;
        this.m = new ArrayList();
        this.n = h.c();
        this.o = h.c();
        this.l = j;
    }

    public static boolean f(DrmSession drmSession) {
        DefaultDrmSession defaultDrmSession = (DefaultDrmSession) drmSession;
        if (defaultDrmSession.n == 1) {
            if (b.i.a.c.f3.e0.a < 19) {
                return true;
            }
            DrmSession.DrmSessionException drmSessionExceptionF = defaultDrmSession.f();
            Objects.requireNonNull(drmSessionExceptionF);
            if (drmSessionExceptionF.getCause() instanceof ResourceBusyException) {
                return true;
            }
        }
        return false;
    }

    public static List<DrmInitData.SchemeData> i(DrmInitData drmInitData, UUID uuid, boolean z2) {
        ArrayList arrayList = new ArrayList(drmInitData.m);
        for (int i = 0; i < drmInitData.m; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.j[i];
            if ((schemeData.a(uuid) || (x0.c.equals(uuid) && schemeData.a(x0.f1158b))) && (schemeData.n != null || z2)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Override // b.i.a.c.w2.u
    public final void a() {
        int i = this.p;
        this.p = i + 1;
        if (i != 0) {
            return;
        }
        if (this.q == null) {
            a0 a0VarA = this.c.a(this.f2929b);
            this.q = a0VarA;
            a0VarA.h(new b(null));
        } else if (this.l != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                this.m.get(i2).a(null);
            }
        }
    }

    @Override // b.i.a.c.w2.u
    public u.b b(Looper looper, @Nullable s.a aVar, j1 j1Var) {
        b.c.a.a0.d.D(this.p > 0);
        j(looper);
        d dVar = new d(aVar);
        Handler handler = this.u;
        Objects.requireNonNull(handler);
        handler.post(new b.i.a.c.w2.e(dVar, j1Var));
        return dVar;
    }

    @Override // b.i.a.c.w2.u
    @Nullable
    public DrmSession c(Looper looper, @Nullable s.a aVar, j1 j1Var) {
        b.c.a.a0.d.D(this.p > 0);
        j(looper);
        return e(looper, aVar, j1Var, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x008f  */
    @Override // b.i.a.c.w2.u
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int d(j1 j1Var) {
        String str;
        a0 a0Var = this.q;
        Objects.requireNonNull(a0Var);
        int iL = a0Var.l();
        DrmInitData drmInitData = j1Var.f1020z;
        boolean z2 = false;
        if (drmInitData == null) {
            int iG = t.g(j1Var.w);
            int[] iArr = this.g;
            int i = b.i.a.c.f3.e0.a;
            int i2 = 0;
            while (true) {
                if (i2 >= iArr.length) {
                    i2 = -1;
                    break;
                }
                if (iArr[i2] == iG) {
                    break;
                }
                i2++;
            }
            if (i2 != -1) {
                return iL;
            }
            return 0;
        }
        if (this.w == null) {
            if (!((ArrayList) i(drmInitData, this.f2929b, true)).isEmpty()) {
                str = drmInitData.l;
                if (str != null || "cenc".equals(str) || (!"cbcs".equals(str) ? !("cbc1".equals(str) || "cens".equals(str)) : b.i.a.c.f3.e0.a >= 25)) {
                    z2 = true;
                }
            } else if (drmInitData.m == 1 && drmInitData.j[0].a(x0.f1158b)) {
                String strValueOf = String.valueOf(this.f2929b);
                b.d.b.a.a.h0(strValueOf.length() + 72, "DrmInitData only contains common PSSH SchemeData. Assuming support for: ", strValueOf, "DefaultDrmSessionMgr");
                str = drmInitData.l;
                if (str != null) {
                    z2 = true;
                }
            }
        }
        if (z2) {
            return iL;
        }
        return 1;
    }

    @Nullable
    public final DrmSession e(Looper looper, @Nullable s.a aVar, j1 j1Var, boolean z2) {
        List<DrmInitData.SchemeData> listI;
        if (this.f2931x == null) {
            this.f2931x = new c(looper);
        }
        DrmInitData drmInitData = j1Var.f1020z;
        DefaultDrmSession defaultDrmSessionH = null;
        int i = 0;
        if (drmInitData == null) {
            int iG = t.g(j1Var.w);
            a0 a0Var = this.q;
            Objects.requireNonNull(a0Var);
            if (a0Var.l() == 2 && b0.a) {
                return null;
            }
            int[] iArr = this.g;
            int i2 = b.i.a.c.f3.e0.a;
            while (true) {
                if (i >= iArr.length) {
                    i = -1;
                    break;
                }
                if (iArr[i] == iG) {
                    break;
                }
                i++;
            }
            if (i == -1 || a0Var.l() == 1) {
                return null;
            }
            DefaultDrmSession defaultDrmSession = this.r;
            if (defaultDrmSession == null) {
                b.i.b.b.a<Object> aVar2 = p.k;
                DefaultDrmSession defaultDrmSessionH2 = h(h0.l, true, null, z2);
                this.m.add(defaultDrmSessionH2);
                this.r = defaultDrmSessionH2;
            } else {
                defaultDrmSession.a(null);
            }
            return this.r;
        }
        if (this.w == null) {
            listI = i(drmInitData, this.f2929b, false);
            if (((ArrayList) listI).isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f2929b, null);
                q.b("DefaultDrmSessionMgr", "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.e(missingSchemeDataException);
                }
                return new z(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listI = null;
        }
        if (this.f) {
            Iterator<DefaultDrmSession> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (b.i.a.c.f3.e0.a(next.a, listI)) {
                    defaultDrmSessionH = next;
                    break;
                }
            }
        } else {
            defaultDrmSessionH = this.f2930s;
        }
        if (defaultDrmSessionH == null) {
            defaultDrmSessionH = h(listI, false, aVar, z2);
            if (!this.f) {
                this.f2930s = defaultDrmSessionH;
            }
            this.m.add(defaultDrmSessionH);
        } else {
            defaultDrmSessionH.a(aVar);
        }
        return defaultDrmSessionH;
    }

    public final DefaultDrmSession g(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable s.a aVar) {
        Objects.requireNonNull(this.q);
        boolean z3 = this.h | z2;
        UUID uuid = this.f2929b;
        a0 a0Var = this.q;
        e eVar = this.i;
        f fVar = this.k;
        int i = this.v;
        byte[] bArr = this.w;
        HashMap<String, String> map = this.e;
        e0 e0Var = this.d;
        Looper looper = this.t;
        Objects.requireNonNull(looper);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(uuid, a0Var, eVar, fVar, list, i, z3, z2, bArr, map, e0Var, looper, this.j);
        defaultDrmSession.a(aVar);
        if (this.l != -9223372036854775807L) {
            defaultDrmSession.a(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession h(@Nullable List<DrmInitData.SchemeData> list, boolean z2, @Nullable s.a aVar, boolean z3) {
        DefaultDrmSession defaultDrmSessionG = g(list, z2, aVar);
        if (f(defaultDrmSessionG) && !this.o.isEmpty()) {
            l();
            defaultDrmSessionG.b(aVar);
            if (this.l != -9223372036854775807L) {
                defaultDrmSessionG.b(null);
            }
            defaultDrmSessionG = g(list, z2, aVar);
        }
        if (!f(defaultDrmSessionG) || !z3 || this.n.isEmpty()) {
            return defaultDrmSessionG;
        }
        m();
        if (!this.o.isEmpty()) {
            l();
        }
        defaultDrmSessionG.b(aVar);
        if (this.l != -9223372036854775807L) {
            defaultDrmSessionG.b(null);
        }
        return g(list, z2, aVar);
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    public final synchronized void j(Looper looper) {
        Looper looper2 = this.t;
        if (looper2 == null) {
            this.t = looper;
            this.u = new Handler(looper);
        } else {
            b.c.a.a0.d.D(looper2 == looper);
            Objects.requireNonNull(this.u);
        }
    }

    public final void k() {
        if (this.q != null && this.p == 0 && this.m.isEmpty() && this.n.isEmpty()) {
            a0 a0Var = this.q;
            Objects.requireNonNull(a0Var);
            a0Var.release();
            this.q = null;
        }
    }

    public final void l() {
        Iterator itJ = r.m(this.o).j();
        while (itJ.hasNext()) {
            ((DrmSession) itJ.next()).b(null);
        }
    }

    public final void m() {
        Iterator itJ = r.m(this.n).j();
        while (itJ.hasNext()) {
            d dVar = (d) itJ.next();
            Handler handler = DefaultDrmSessionManager.this.u;
            Objects.requireNonNull(handler);
            b.i.a.c.f3.e0.E(handler, new b.i.a.c.w2.d(dVar));
        }
    }

    @Override // b.i.a.c.w2.u
    public final void release() {
        int i = this.p - 1;
        this.p = i;
        if (i != 0) {
            return;
        }
        if (this.l != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.m);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).b(null);
            }
        }
        m();
        k();
    }
}
