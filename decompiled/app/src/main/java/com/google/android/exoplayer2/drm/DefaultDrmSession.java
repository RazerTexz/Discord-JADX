package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.c.a3.t;
import b.i.a.c.e3.w;
import b.i.a.c.f3.k;
import b.i.a.c.f3.l;
import b.i.a.c.f3.q;
import b.i.a.c.w2.a0;
import b.i.a.c.w2.d0;
import b.i.a.c.w2.e0;
import b.i.a.c.w2.f;
import b.i.a.c.w2.s;
import b.i.a.c.w2.v;
import b.i.a.c.w2.x;
import b.i.a.c.x0;
import b.i.b.b.p;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.upstream.DataSourceException;
import com.google.android.exoplayer2.upstream.HttpDataSource$CleartextNotPermittedException;
import com.google.android.exoplayer2.upstream.Loader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(18)
/* loaded from: classes3.dex */
public class DefaultDrmSession implements DrmSession {

    @Nullable
    public final List<DrmInitData.SchemeData> a;

    /* renamed from: b, reason: collision with root package name */
    public final a0 f2925b;
    public final a c;
    public final b d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap<String, String> h;
    public final l<s.a> i;
    public final w j;
    public final e0 k;
    public final UUID l;
    public final e m;
    public int n;
    public int o;

    @Nullable
    public HandlerThread p;

    @Nullable
    public c q;

    @Nullable
    public b.i.a.c.v2.b r;

    /* renamed from: s, reason: collision with root package name */
    @Nullable
    public DrmSession.DrmSessionException f2926s;

    @Nullable
    public byte[] t;
    public byte[] u;

    @Nullable
    public a0.a v;

    @Nullable
    public a0.d w;

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    public interface a {
    }

    public interface b {
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {

        @GuardedBy("this")
        public boolean a;

        public c(Looper looper) {
            super(looper);
        }

        public void a(int i, Object obj, boolean z2) {
            obtainMessage(i, new d(t.a.getAndIncrement(), z2, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:45:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:49:0x00ca  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x00dd A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x00de  */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            long jMin;
            boolean z2;
            Exception excC;
            d dVar = (d) message.obj;
            boolean z3 = true;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    excC = ((d0) defaultDrmSession.k).c(defaultDrmSession.l, (a0.d) dVar.d);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    excC = ((d0) defaultDrmSession2.k).a(defaultDrmSession2.l, (a0.a) dVar.d);
                }
            } catch (MediaDrmCallbackException e) {
                d dVar2 = (d) message.obj;
                if (dVar2.f2928b) {
                    int i2 = dVar2.e + 1;
                    dVar2.e = i2;
                    if (i2 <= ((b.i.a.c.e3.s) DefaultDrmSession.this.j).a(3)) {
                        SystemClock.elapsedRealtime();
                        SystemClock.elapsedRealtime();
                        Throwable unexpectedDrmSessionException = e.getCause() instanceof IOException ? (IOException) e.getCause() : new UnexpectedDrmSessionException(e.getCause());
                        w wVar = DefaultDrmSession.this.j;
                        int i3 = dVar2.e;
                        if ((unexpectedDrmSessionException instanceof ParserException) || (unexpectedDrmSessionException instanceof FileNotFoundException) || (unexpectedDrmSessionException instanceof HttpDataSource$CleartextNotPermittedException) || (unexpectedDrmSessionException instanceof Loader.UnexpectedLoaderException)) {
                            jMin = -9223372036854775807L;
                            if (jMin == -9223372036854775807L) {
                                synchronized (this) {
                                    if (this.a) {
                                        z3 = false;
                                        if (z3) {
                                        }
                                    } else {
                                        sendMessageDelayed(Message.obtain(message), jMin);
                                        if (z3) {
                                        }
                                    }
                                }
                            }
                        } else {
                            int i4 = DataSourceException.j;
                            while (true) {
                                if (unexpectedDrmSessionException == null) {
                                    z2 = false;
                                    break;
                                } else {
                                    if ((unexpectedDrmSessionException instanceof DataSourceException) && ((DataSourceException) unexpectedDrmSessionException).reason == 2008) {
                                        z2 = true;
                                        break;
                                    }
                                    unexpectedDrmSessionException = unexpectedDrmSessionException.getCause();
                                }
                            }
                            if (!z2) {
                                jMin = Math.min((i3 - 1) * 1000, 5000);
                            }
                            if (jMin == -9223372036854775807L) {
                            }
                        }
                    }
                } else {
                    z3 = false;
                    if (z3) {
                        return;
                    } else {
                        excC = e;
                    }
                }
            } catch (Exception e2) {
                q.c("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                excC = e2;
            }
            w wVar2 = DefaultDrmSession.this.j;
            long j = dVar.a;
            Objects.requireNonNull(wVar2);
            synchronized (this) {
                if (!this.a) {
                    DefaultDrmSession.this.m.obtainMessage(message.what, Pair.create(dVar.d, excC)).sendToTarget();
                }
            }
        }
    }

    public static final class d {
        public final long a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f2928b;
        public final long c;
        public final Object d;
        public int e;

        public d(long j, boolean z2, long j2, Object obj) {
            this.a = j;
            this.f2928b = z2;
            this.c = j2;
            this.d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                if (obj == defaultDrmSession.w) {
                    if (defaultDrmSession.n == 2 || defaultDrmSession.j()) {
                        defaultDrmSession.w = null;
                        if (obj2 instanceof Exception) {
                            ((DefaultDrmSessionManager.e) defaultDrmSession.c).a((Exception) obj2, false);
                            return;
                        }
                        try {
                            defaultDrmSession.f2925b.j((byte[]) obj2);
                            DefaultDrmSessionManager.e eVar = (DefaultDrmSessionManager.e) defaultDrmSession.c;
                            eVar.f2933b = null;
                            p pVarN = p.n(eVar.a);
                            eVar.a.clear();
                            b.i.b.b.a aVarP = pVarN.p();
                            while (aVarP.hasNext()) {
                                DefaultDrmSession defaultDrmSession2 = (DefaultDrmSession) aVarP.next();
                                if (defaultDrmSession2.m()) {
                                    defaultDrmSession2.i(true);
                                }
                            }
                            return;
                        } catch (Exception e) {
                            ((DefaultDrmSessionManager.e) defaultDrmSession.c).a(e, true);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i != 1) {
                return;
            }
            DefaultDrmSession defaultDrmSession3 = DefaultDrmSession.this;
            if (obj == defaultDrmSession3.v && defaultDrmSession3.j()) {
                defaultDrmSession3.v = null;
                if (obj2 instanceof Exception) {
                    defaultDrmSession3.l((Exception) obj2, false);
                    return;
                }
                try {
                    byte[] bArr = (byte[]) obj2;
                    if (defaultDrmSession3.e == 3) {
                        a0 a0Var = defaultDrmSession3.f2925b;
                        byte[] bArr2 = defaultDrmSession3.u;
                        int i2 = b.i.a.c.f3.e0.a;
                        a0Var.i(bArr2, bArr);
                        defaultDrmSession3.h(b.i.a.c.w2.a.a);
                        return;
                    }
                    byte[] bArrI = defaultDrmSession3.f2925b.i(defaultDrmSession3.t, bArr);
                    int i3 = defaultDrmSession3.e;
                    if ((i3 == 2 || (i3 == 0 && defaultDrmSession3.u != null)) && bArrI != null && bArrI.length != 0) {
                        defaultDrmSession3.u = bArrI;
                    }
                    defaultDrmSession3.n = 4;
                    defaultDrmSession3.h(b.i.a.c.w2.p.a);
                } catch (Exception e2) {
                    defaultDrmSession3.l(e2, true);
                }
            }
        }
    }

    public DefaultDrmSession(UUID uuid, a0 a0Var, a aVar, b bVar, @Nullable List<DrmInitData.SchemeData> list, int i, boolean z2, boolean z3, @Nullable byte[] bArr, HashMap<String, String> map, e0 e0Var, Looper looper, w wVar) {
        if (i == 1 || i == 3) {
            Objects.requireNonNull(bArr);
        }
        this.l = uuid;
        this.c = aVar;
        this.d = bVar;
        this.f2925b = a0Var;
        this.e = i;
        this.f = z2;
        this.g = z3;
        if (bArr != null) {
            this.u = bArr;
            this.a = null;
        } else {
            Objects.requireNonNull(list);
            this.a = Collections.unmodifiableList(list);
        }
        this.h = map;
        this.k = e0Var;
        this.i = new l<>();
        this.j = wVar;
        this.n = 2;
        this.m = new e(looper);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable s.a aVar) {
        int i = this.o;
        if (i < 0) {
            StringBuilder sb = new StringBuilder(51);
            sb.append("Session reference count less than zero: ");
            sb.append(i);
            Log.e("DefaultDrmSession", sb.toString());
            this.o = 0;
        }
        if (aVar != null) {
            l<s.a> lVar = this.i;
            synchronized (lVar.j) {
                ArrayList arrayList = new ArrayList(lVar.m);
                arrayList.add(aVar);
                lVar.m = Collections.unmodifiableList(arrayList);
                Integer num = lVar.k.get(aVar);
                if (num == null) {
                    HashSet hashSet = new HashSet(lVar.l);
                    hashSet.add(aVar);
                    lVar.l = Collections.unmodifiableSet(hashSet);
                }
                lVar.k.put(aVar, Integer.valueOf(num != null ? num.intValue() + 1 : 1));
            }
        }
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 == 1) {
            b.c.a.a0.d.D(this.n == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = handlerThread;
            handlerThread.start();
            this.q = new c(this.p.getLooper());
            if (m()) {
                i(true);
            }
        } else if (aVar != null && j() && this.i.c(aVar) == 1) {
            aVar.d(this.n);
        }
        DefaultDrmSessionManager.f fVar = (DefaultDrmSessionManager.f) this.d;
        DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
        if (defaultDrmSessionManager.l != -9223372036854775807L) {
            defaultDrmSessionManager.o.remove(this);
            Handler handler = DefaultDrmSessionManager.this.u;
            Objects.requireNonNull(handler);
            handler.removeCallbacksAndMessages(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x00da  */
    @Override // com.google.android.exoplayer2.drm.DrmSession
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void b(@Nullable s.a aVar) {
        int i = this.o;
        if (i <= 0) {
            Log.e("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.o = i2;
        if (i2 == 0) {
            this.n = 0;
            e eVar = this.m;
            int i3 = b.i.a.c.f3.e0.a;
            eVar.removeCallbacksAndMessages(null);
            c cVar = this.q;
            synchronized (cVar) {
                cVar.removeCallbacksAndMessages(null);
                cVar.a = true;
            }
            this.q = null;
            this.p.quit();
            this.p = null;
            this.r = null;
            this.f2926s = null;
            this.v = null;
            this.w = null;
            byte[] bArr = this.t;
            if (bArr != null) {
                this.f2925b.g(bArr);
                this.t = null;
            }
        }
        if (aVar != null) {
            l<s.a> lVar = this.i;
            synchronized (lVar.j) {
                Integer num = lVar.k.get(aVar);
                if (num != null) {
                    ArrayList arrayList = new ArrayList(lVar.m);
                    arrayList.remove(aVar);
                    lVar.m = Collections.unmodifiableList(arrayList);
                    if (num.intValue() == 1) {
                        lVar.k.remove(aVar);
                        HashSet hashSet = new HashSet(lVar.l);
                        hashSet.remove(aVar);
                        lVar.l = Collections.unmodifiableSet(hashSet);
                    } else {
                        lVar.k.put(aVar, Integer.valueOf(num.intValue() - 1));
                    }
                }
            }
            if (this.i.c(aVar) == 0) {
                aVar.f();
            }
        }
        b bVar = this.d;
        int i4 = this.o;
        DefaultDrmSessionManager.f fVar = (DefaultDrmSessionManager.f) bVar;
        if (i4 == 1) {
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager.p > 0 && defaultDrmSessionManager.l != -9223372036854775807L) {
                defaultDrmSessionManager.o.add(this);
                Handler handler = DefaultDrmSessionManager.this.u;
                Objects.requireNonNull(handler);
                handler.postAtTime(new f(this), this, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.l);
            } else if (i4 == 0) {
                DefaultDrmSessionManager.this.m.remove(this);
                DefaultDrmSessionManager defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager2.r == this) {
                    defaultDrmSessionManager2.r = null;
                }
                if (defaultDrmSessionManager2.f2930s == this) {
                    defaultDrmSessionManager2.f2930s = null;
                }
                DefaultDrmSessionManager.e eVar2 = defaultDrmSessionManager2.i;
                eVar2.a.remove(this);
                if (eVar2.f2933b == this) {
                    eVar2.f2933b = null;
                    if (!eVar2.a.isEmpty()) {
                        DefaultDrmSession next = eVar2.a.iterator().next();
                        eVar2.f2933b = next;
                        next.o();
                    }
                }
                DefaultDrmSessionManager defaultDrmSessionManager3 = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager3.l != -9223372036854775807L) {
                    Handler handler2 = defaultDrmSessionManager3.u;
                    Objects.requireNonNull(handler2);
                    handler2.removeCallbacksAndMessages(this);
                    DefaultDrmSessionManager.this.o.remove(this);
                }
            }
        }
        DefaultDrmSessionManager.this.k();
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID c() {
        return this.l;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean d() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean e(String str) {
        a0 a0Var = this.f2925b;
        byte[] bArr = this.t;
        b.c.a.a0.d.H(bArr);
        return a0Var.e(bArr, str);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException f() {
        if (this.n == 1) {
            return this.f2926s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final b.i.a.c.v2.b g() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    public final void h(k<s.a> kVar) {
        Set<s.a> set;
        l<s.a> lVar = this.i;
        synchronized (lVar.j) {
            set = lVar.l;
        }
        Iterator<s.a> it = set.iterator();
        while (it.hasNext()) {
            kVar.accept(it.next());
        }
    }

    @RequiresNonNull({"sessionId"})
    public final void i(boolean z2) {
        Pair pair;
        String str;
        long jMin;
        if (this.g) {
            return;
        }
        byte[] bArr = this.t;
        int i = b.i.a.c.f3.e0.a;
        int i2 = this.e;
        boolean z3 = false;
        if (i2 != 0 && i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return;
                }
                Objects.requireNonNull(this.u);
                Objects.requireNonNull(this.t);
                n(this.u, 3, z2);
                return;
            }
            byte[] bArr2 = this.u;
            if (bArr2 != null) {
                try {
                    this.f2925b.f(bArr, bArr2);
                    z3 = true;
                } catch (Exception e2) {
                    k(e2, 1);
                }
                if (!z3) {
                    return;
                }
            }
            n(bArr, 2, z2);
            return;
        }
        byte[] bArr3 = this.u;
        if (bArr3 == null) {
            n(bArr, 1, z2);
            return;
        }
        if (this.n != 4) {
            try {
                this.f2925b.f(bArr, bArr3);
                z3 = true;
            } catch (Exception e3) {
                k(e3, 1);
            }
            if (!z3) {
                return;
            }
        }
        if (x0.d.equals(this.l)) {
            Map<String, String> mapP = p();
            if (mapP == null) {
                pair = null;
            } else {
                long j = -9223372036854775807L;
                try {
                    str = mapP.get("LicenseDurationRemaining");
                } catch (NumberFormatException unused) {
                }
                long j2 = str != null ? Long.parseLong(str) : -9223372036854775807L;
                Long lValueOf = Long.valueOf(j2);
                try {
                    String str2 = mapP.get("PlaybackDurationRemaining");
                    if (str2 != null) {
                        j = Long.parseLong(str2);
                    }
                } catch (NumberFormatException unused2) {
                }
                pair = new Pair(lValueOf, Long.valueOf(j));
            }
            Objects.requireNonNull(pair);
            jMin = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
        } else {
            jMin = RecyclerView.FOREVER_NS;
        }
        if (this.e != 0 || jMin > 60) {
            if (jMin <= 0) {
                k(new KeysExpiredException(), 2);
                return;
            } else {
                this.n = 4;
                h(b.i.a.c.w2.q.a);
                return;
            }
        }
        StringBuilder sb = new StringBuilder(88);
        sb.append("Offline license has expired or will expire soon. Remaining seconds: ");
        sb.append(jMin);
        Log.d("DefaultDrmSession", sb.toString());
        n(bArr, 2, z2);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean j() {
        int i = this.n;
        return i == 3 || i == 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void k(Exception exc, int i) {
        int iB;
        int i2 = b.i.a.c.f3.e0.a;
        if (i2 >= 21 && b.i.a.c.w2.w.a(exc)) {
            iB = b.i.a.c.w2.w.b(exc);
        } else if (i2 < 23 || !x.a(exc)) {
            if (i2 >= 18 && v.b(exc)) {
                iB = 6002;
            } else if (i2 >= 18 && v.a(exc)) {
                iB = 6007;
            } else if (exc instanceof UnsupportedDrmException) {
                iB = 6001;
            } else if (exc instanceof DefaultDrmSessionManager.MissingSchemeDataException) {
                iB = 6003;
            } else if (exc instanceof KeysExpiredException) {
                iB = 6008;
            } else if (i == 1) {
                iB = 6006;
            } else if (i == 2) {
                iB = 6004;
            } else {
                if (i != 3) {
                    throw new IllegalArgumentException();
                }
                iB = 6002;
            }
        }
        this.f2926s = new DrmSession.DrmSessionException(exc, iB);
        q.b("DefaultDrmSession", "DRM session error", exc);
        h(new b.i.a.c.w2.b(exc));
        if (this.n != 4) {
            this.n = 1;
        }
    }

    public final void l(Exception exc, boolean z2) {
        if (!(exc instanceof NotProvisionedException)) {
            k(exc, z2 ? 1 : 2);
            return;
        }
        DefaultDrmSessionManager.e eVar = (DefaultDrmSessionManager.e) this.c;
        eVar.a.add(this);
        if (eVar.f2933b != null) {
            return;
        }
        eVar.f2933b = this;
        o();
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    public final boolean m() {
        if (j()) {
            return true;
        }
        try {
            byte[] bArrD = this.f2925b.d();
            this.t = bArrD;
            this.r = this.f2925b.c(bArrD);
            this.n = 3;
            h(new b.i.a.c.w2.c(3));
            Objects.requireNonNull(this.t);
            return true;
        } catch (NotProvisionedException unused) {
            DefaultDrmSessionManager.e eVar = (DefaultDrmSessionManager.e) this.c;
            eVar.a.add(this);
            if (eVar.f2933b != null) {
                return false;
            }
            eVar.f2933b = this;
            o();
            return false;
        } catch (Exception e2) {
            k(e2, 1);
            return false;
        }
    }

    public final void n(byte[] bArr, int i, boolean z2) {
        try {
            a0.a aVarK = this.f2925b.k(bArr, this.a, i, this.h);
            this.v = aVarK;
            c cVar = this.q;
            int i2 = b.i.a.c.f3.e0.a;
            Objects.requireNonNull(aVarK);
            cVar.a(1, aVarK, z2);
        } catch (Exception e2) {
            l(e2, true);
        }
    }

    public void o() {
        a0.d dVarB = this.f2925b.b();
        this.w = dVarB;
        c cVar = this.q;
        int i = b.i.a.c.f3.e0.a;
        Objects.requireNonNull(dVarB);
        cVar.a(0, dVarB, true);
    }

    @Nullable
    public Map<String, String> p() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return null;
        }
        return this.f2925b.a(bArr);
    }
}
