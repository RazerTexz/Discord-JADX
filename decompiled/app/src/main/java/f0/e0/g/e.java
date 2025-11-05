package f0.e0.g;

import androidx.core.app.NotificationCompat;
import d0.t.r;
import f0.e0.k.h;
import f0.q;
import f0.t;
import f0.x;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.TypeCastException;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: RealCall.kt */
/* loaded from: classes3.dex */
public final class e implements f0.e {
    public final boolean A;
    public final k j;
    public final t k;
    public final c l;
    public final AtomicBoolean m;
    public Object n;
    public d o;
    public j p;
    public boolean q;
    public f0.e0.g.c r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3616s;
    public boolean t;
    public boolean u;
    public volatile boolean v;
    public volatile f0.e0.g.c w;

    /* renamed from: x, reason: collision with root package name */
    public volatile j f3617x;

    /* renamed from: y, reason: collision with root package name */
    public final x f3618y;

    /* renamed from: z, reason: collision with root package name */
    public final Request f3619z;

    /* compiled from: RealCall.kt */
    public final class a implements Runnable {
        public volatile AtomicInteger j;
        public final f0.f k;
        public final /* synthetic */ e l;

        public a(e eVar, f0.f fVar) {
            d0.z.d.m.checkParameterIsNotNull(fVar, "responseCallback");
            this.l = eVar;
            this.k = fVar;
            this.j = new AtomicInteger(0);
        }

        public final String a() {
            return this.l.f3619z.url.g;
        }

        @Override // java.lang.Runnable
        public void run() {
            e eVar;
            StringBuilder sbU = b.d.b.a.a.U("OkHttp ");
            sbU.append(this.l.f3619z.url.h());
            String string = sbU.toString();
            Thread threadCurrentThread = Thread.currentThread();
            d0.z.d.m.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(string);
            try {
                this.l.l.i();
                boolean z2 = false;
                try {
                    try {
                        try {
                            this.k.a(this.l, this.l.j());
                            eVar = this.l;
                        } catch (IOException e) {
                            e = e;
                            z2 = true;
                            if (z2) {
                                h.a aVar = f0.e0.k.h.c;
                                f0.e0.k.h.a.i("Callback failure for " + e.b(this.l), 4, e);
                            } else {
                                this.k.b(this.l, e);
                            }
                            eVar = this.l;
                            eVar.f3618y.m.c(this);
                        } catch (Throwable th) {
                            th = th;
                            z2 = true;
                            this.l.cancel();
                            if (!z2) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.addSuppressed(th);
                                this.k.b(this.l, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        this.l.f3618y.m.c(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                eVar.f3618y.m.c(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    /* compiled from: RealCall.kt */
    public static final class b extends WeakReference<e> {
        public final Object a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(e eVar, Object obj) {
            super(eVar);
            d0.z.d.m.checkParameterIsNotNull(eVar, "referent");
            this.a = obj;
        }
    }

    /* compiled from: RealCall.kt */
    public static final class c extends g0.b {
        public c() {
        }

        @Override // g0.b
        public void l() {
            e.this.cancel();
        }
    }

    public e(x xVar, Request request, boolean z2) {
        d0.z.d.m.checkParameterIsNotNull(xVar, "client");
        d0.z.d.m.checkParameterIsNotNull(request, "originalRequest");
        this.f3618y = xVar;
        this.f3619z = request;
        this.A = z2;
        this.j = xVar.n.a;
        this.k = xVar.q.a(this);
        c cVar = new c();
        cVar.g(xVar.I, TimeUnit.MILLISECONDS);
        this.l = cVar;
        this.m = new AtomicBoolean();
        this.u = true;
    }

    public static final String b(e eVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(eVar.v ? "canceled " : "");
        sb.append(eVar.A ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(eVar.f3619z.url.h());
        return sb.toString();
    }

    @Override // f0.e
    public Request c() {
        return this.f3619z;
    }

    @Override // f0.e
    public void cancel() {
        Socket socket;
        if (this.v) {
            return;
        }
        this.v = true;
        f0.e0.g.c cVar = this.w;
        if (cVar != null) {
            cVar.f.cancel();
        }
        j jVar = this.f3617x;
        if (jVar != null && (socket = jVar.f3620b) != null) {
            f0.e0.c.e(socket);
        }
        Objects.requireNonNull(this.k);
        d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public Object clone() {
        return new e(this.f3618y, this.f3619z, this.A);
    }

    @Override // f0.e
    public boolean d() {
        return this.v;
    }

    @Override // f0.e
    public void e(f0.f fVar) {
        a next;
        d0.z.d.m.checkParameterIsNotNull(fVar, "responseCallback");
        if (!this.m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        h();
        q qVar = this.f3618y.m;
        a aVar = new a(this, fVar);
        Objects.requireNonNull(qVar);
        d0.z.d.m.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        synchronized (qVar) {
            qVar.f3677b.add(aVar);
            if (!aVar.l.A) {
                String strA = aVar.a();
                Iterator<a> it = qVar.c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<a> it2 = qVar.f3677b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it2.next();
                                if (d0.z.d.m.areEqual(next.a(), strA)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        next = it.next();
                        if (d0.z.d.m.areEqual(next.a(), strA)) {
                            break;
                        }
                    }
                }
                if (next != null) {
                    d0.z.d.m.checkParameterIsNotNull(next, "other");
                    aVar.j = next.j;
                }
            }
        }
        qVar.d();
    }

    @Override // f0.e
    public Response execute() {
        if (!this.m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.l.i();
        h();
        try {
            q qVar = this.f3618y.m;
            synchronized (qVar) {
                d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                qVar.d.add(this);
            }
            return j();
        } finally {
            q qVar2 = this.f3618y.m;
            Objects.requireNonNull(qVar2);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            qVar2.b(qVar2.d, this);
        }
    }

    public final void f(j jVar) {
        d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
        byte[] bArr = f0.e0.c.a;
        if (!(this.p == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.p = jVar;
        jVar.o.add(new b(this, this.n));
    }

    public final <E extends IOException> E g(E e) {
        E interruptedIOException;
        Socket socketM;
        byte[] bArr = f0.e0.c.a;
        j jVar = this.p;
        if (jVar != null) {
            synchronized (jVar) {
                socketM = m();
            }
            if (this.p == null) {
                if (socketM != null) {
                    f0.e0.c.e(socketM);
                }
                Objects.requireNonNull(this.k);
                d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
            } else {
                if (!(socketM == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.q && this.l.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
        } else {
            interruptedIOException = e;
        }
        if (e != null) {
            t tVar = this.k;
            if (interruptedIOException == null) {
                d0.z.d.m.throwNpe();
            }
            Objects.requireNonNull(tVar);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            d0.z.d.m.checkParameterIsNotNull(interruptedIOException, "ioe");
        } else {
            Objects.requireNonNull(this.k);
            d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
        }
        return interruptedIOException;
    }

    public final void h() {
        h.a aVar = f0.e0.k.h.c;
        this.n = f0.e0.k.h.a.g("response.body().close()");
        Objects.requireNonNull(this.k);
        d0.z.d.m.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public final void i(boolean z2) {
        f0.e0.g.c cVar;
        synchronized (this) {
            if (!this.u) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z2 && (cVar = this.w) != null) {
            cVar.f.cancel();
            cVar.c.k(cVar, true, true, null);
        }
        this.r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response j() throws Throwable {
        ArrayList arrayList = new ArrayList();
        r.addAll(arrayList, this.f3618y.o);
        arrayList.add(new f0.e0.h.i(this.f3618y));
        arrayList.add(new f0.e0.h.a(this.f3618y.v));
        Objects.requireNonNull(this.f3618y);
        arrayList.add(new f0.e0.e.a());
        arrayList.add(f0.e0.g.a.f3612b);
        if (!this.A) {
            r.addAll(arrayList, this.f3618y.p);
        }
        arrayList.add(new f0.e0.h.b(this.A));
        Request request = this.f3619z;
        x xVar = this.f3618y;
        f0.e0.h.g gVar = new f0.e0.h.g(this, arrayList, 0, null, request, xVar.J, xVar.K, xVar.L);
        boolean z2 = false;
        try {
            try {
                Response responseA = gVar.a(this.f3619z);
                if (!this.v) {
                    l(null);
                    return responseA;
                }
                d0.z.d.m.checkParameterIsNotNull(responseA, "$this$closeQuietly");
                try {
                    responseA.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                try {
                    IOException iOExceptionL = l(e2);
                    if (iOExceptionL == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    throw iOExceptionL;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (!z2) {
                        l(null);
                    }
                    throw th;
                }
            }
        } catch (Throwable th2) {
            th = th2;
            if (!z2) {
            }
            throw th;
        }
    }

    public final <E extends IOException> E k(f0.e0.g.c cVar, boolean z2, boolean z3, E e) {
        boolean z4;
        boolean z5;
        d0.z.d.m.checkParameterIsNotNull(cVar, "exchange");
        if (!d0.z.d.m.areEqual(cVar, this.w)) {
            return e;
        }
        synchronized (this) {
            z4 = false;
            if (z2) {
                try {
                    if (!this.f3616s) {
                        if (z3 || !this.t) {
                            z5 = false;
                        }
                    }
                    if (z2) {
                        this.f3616s = false;
                    }
                    if (z3) {
                        this.t = false;
                    }
                    boolean z6 = this.f3616s;
                    boolean z7 = (z6 || this.t) ? false : true;
                    if (!z6 && !this.t) {
                        if (!this.u) {
                            z4 = true;
                        }
                    }
                    z5 = z4;
                    z4 = z7;
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                if (z3) {
                }
                z5 = false;
            }
        }
        if (z4) {
            this.w = null;
            j jVar = this.p;
            if (jVar != null) {
                synchronized (jVar) {
                    jVar.l++;
                }
            }
        }
        return z5 ? (E) g(e) : e;
    }

    public final IOException l(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.u) {
                this.u = false;
                if (!this.f3616s) {
                    if (!this.t) {
                        z2 = true;
                    }
                }
            }
        }
        return z2 ? g(iOException) : iOException;
    }

    public final Socket m() {
        j jVar = this.p;
        if (jVar == null) {
            d0.z.d.m.throwNpe();
        }
        byte[] bArr = f0.e0.c.a;
        List<Reference<e>> list = jVar.o;
        Iterator<Reference<e>> it = list.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (d0.z.d.m.areEqual(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        list.remove(i);
        this.p = null;
        if (list.isEmpty()) {
            jVar.p = System.nanoTime();
            k kVar = this.j;
            Objects.requireNonNull(kVar);
            d0.z.d.m.checkParameterIsNotNull(jVar, "connection");
            byte[] bArr2 = f0.e0.c.a;
            if (jVar.i || kVar.e == 0) {
                jVar.i = true;
                kVar.d.remove(jVar);
                if (kVar.d.isEmpty()) {
                    kVar.f3621b.a();
                }
                z2 = true;
            } else {
                f0.e0.f.c.d(kVar.f3621b, kVar.c, 0L, 2);
            }
            if (z2) {
                return jVar.n();
            }
        }
        return null;
    }

    public final void n() {
        if (!(!this.q)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.q = true;
        this.l.j();
    }
}
