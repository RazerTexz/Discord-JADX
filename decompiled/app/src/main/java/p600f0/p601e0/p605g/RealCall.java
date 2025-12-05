package p600f0.p601e0.p605g;

import androidx.core.app.NotificationCompat;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.MutableCollections;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Call2;
import p600f0.Callback2;
import p600f0.Dispatcher2;
import p600f0.EventListener;
import p600f0.OkHttpClient;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p603e.CacheInterceptor;
import p600f0.p601e0.p604f.TaskQueue2;
import p600f0.p601e0.p606h.BridgeInterceptor;
import p600f0.p601e0.p606h.CallServerInterceptor;
import p600f0.p601e0.p606h.RealInterceptorChain;
import p600f0.p601e0.p606h.RetryAndFollowUpInterceptor;
import p600f0.p601e0.p609k.Platform2;
import p615g0.AsyncTimeout;

/* compiled from: RealCall.kt */
/* renamed from: f0.e0.g.e, reason: use source file name */
/* loaded from: classes3.dex */
public final class RealCall implements Call2 {

    /* renamed from: A */
    public final boolean f25464A;

    /* renamed from: j */
    public final RealConnectionPool f25465j;

    /* renamed from: k */
    public final EventListener f25466k;

    /* renamed from: l */
    public final c f25467l;

    /* renamed from: m */
    public final AtomicBoolean f25468m;

    /* renamed from: n */
    public Object f25469n;

    /* renamed from: o */
    public ExchangeFinder f25470o;

    /* renamed from: p */
    public RealConnection4 f25471p;

    /* renamed from: q */
    public boolean f25472q;

    /* renamed from: r */
    public Exchange f25473r;

    /* renamed from: s */
    public boolean f25474s;

    /* renamed from: t */
    public boolean f25475t;

    /* renamed from: u */
    public boolean f25476u;

    /* renamed from: v */
    public volatile boolean f25477v;

    /* renamed from: w */
    public volatile Exchange f25478w;

    /* renamed from: x */
    public volatile RealConnection4 f25479x;

    /* renamed from: y */
    public final OkHttpClient f25480y;

    /* renamed from: z */
    public final Request f25481z;

    /* compiled from: RealCall.kt */
    /* renamed from: f0.e0.g.e$a */
    public final class a implements Runnable {

        /* renamed from: j */
        public volatile AtomicInteger f25482j;

        /* renamed from: k */
        public final Callback2 f25483k;

        /* renamed from: l */
        public final /* synthetic */ RealCall f25484l;

        public a(RealCall realCall, Callback2 callback2) {
            Intrinsics3.checkParameterIsNotNull(callback2, "responseCallback");
            this.f25484l = realCall;
            this.f25483k = callback2;
            this.f25482j = new AtomicInteger(0);
        }

        /* renamed from: a */
        public final String m10190a() {
            return this.f25484l.f25481z.url.f25979g;
        }

        @Override // java.lang.Runnable
        public void run() {
            RealCall realCall;
            StringBuilder sbM833U = outline.m833U("OkHttp ");
            sbM833U.append(this.f25484l.f25481z.url.m10406h());
            String string = sbM833U.toString();
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics3.checkExpressionValueIsNotNull(threadCurrentThread, "currentThread");
            String name = threadCurrentThread.getName();
            threadCurrentThread.setName(string);
            try {
                this.f25484l.f25467l.m10424i();
                boolean z2 = false;
                try {
                    try {
                        try {
                            this.f25483k.mo10358a(this.f25484l, this.f25484l.m10185j());
                            realCall = this.f25484l;
                        } catch (IOException e) {
                            e = e;
                            z2 = true;
                            if (z2) {
                                Platform2.a aVar = Platform2.f25785c;
                                Platform2.f25783a.m10330i("Callback failure for " + RealCall.m10180b(this.f25484l), 4, e);
                            } else {
                                this.f25483k.mo10359b(this.f25484l, e);
                            }
                            realCall = this.f25484l;
                            realCall.f25480y.f26012m.m10390c(this);
                        } catch (Throwable th) {
                            th = th;
                            z2 = true;
                            this.f25484l.cancel();
                            if (!z2) {
                                IOException iOException = new IOException("canceled due to " + th);
                                iOException.addSuppressed(th);
                                this.f25483k.mo10359b(this.f25484l, iOException);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        this.f25484l.f25480y.f26012m.m10390c(this);
                        throw th2;
                    }
                } catch (IOException e2) {
                    e = e2;
                } catch (Throwable th3) {
                    th = th3;
                }
                realCall.f25480y.f26012m.m10390c(this);
            } finally {
                threadCurrentThread.setName(name);
            }
        }
    }

    /* compiled from: RealCall.kt */
    /* renamed from: f0.e0.g.e$b */
    public static final class b extends WeakReference<RealCall> {

        /* renamed from: a */
        public final Object f25485a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RealCall realCall, Object obj) {
            super(realCall);
            Intrinsics3.checkParameterIsNotNull(realCall, "referent");
            this.f25485a = obj;
        }
    }

    /* compiled from: RealCall.kt */
    /* renamed from: f0.e0.g.e$c */
    public static final class c extends AsyncTimeout {
        public c() {
        }

        @Override // p615g0.AsyncTimeout
        /* renamed from: l */
        public void mo10191l() {
            RealCall.this.cancel();
        }
    }

    public RealCall(OkHttpClient okHttpClient, Request request, boolean z2) {
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(request, "originalRequest");
        this.f25480y = okHttpClient;
        this.f25481z = request;
        this.f25464A = z2;
        this.f25465j = okHttpClient.f26013n.f25929a;
        this.f25466k = okHttpClient.f26016q.mo10115a(this);
        c cVar = new c();
        cVar.mo10484g(okHttpClient.f26005I, TimeUnit.MILLISECONDS);
        this.f25467l = cVar;
        this.f25468m = new AtomicBoolean();
        this.f25476u = true;
    }

    /* renamed from: b */
    public static final String m10180b(RealCall realCall) {
        StringBuilder sb = new StringBuilder();
        sb.append(realCall.f25477v ? "canceled " : "");
        sb.append(realCall.f25464A ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(realCall.f25481z.url.m10406h());
        return sb.toString();
    }

    @Override // p600f0.Call2
    /* renamed from: c */
    public Request mo10111c() {
        return this.f25481z;
    }

    @Override // p600f0.Call2
    public void cancel() {
        Socket socket;
        if (this.f25477v) {
            return;
        }
        this.f25477v = true;
        Exchange exchange = this.f25478w;
        if (exchange != null) {
            exchange.f25442f.cancel();
        }
        RealConnection4 realConnection4 = this.f25479x;
        if (realConnection4 != null && (socket = realConnection4.f25491b) != null) {
            Util7.m10124e(socket);
        }
        Objects.requireNonNull(this.f25466k);
        Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    public Object clone() {
        return new RealCall(this.f25480y, this.f25481z, this.f25464A);
    }

    @Override // p600f0.Call2
    /* renamed from: d */
    public boolean mo10112d() {
        return this.f25477v;
    }

    @Override // p600f0.Call2
    /* renamed from: e */
    public void mo10113e(Callback2 callback2) {
        a next;
        Intrinsics3.checkParameterIsNotNull(callback2, "responseCallback");
        if (!this.f25468m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        m10183h();
        Dispatcher2 dispatcher2 = this.f25480y.f26012m;
        a aVar = new a(this, callback2);
        Objects.requireNonNull(dispatcher2);
        Intrinsics3.checkParameterIsNotNull(aVar, NotificationCompat.CATEGORY_CALL);
        synchronized (dispatcher2) {
            dispatcher2.f25958b.add(aVar);
            if (!aVar.f25484l.f25464A) {
                String strM10190a = aVar.m10190a();
                Iterator<a> it = dispatcher2.f25959c.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        Iterator<a> it2 = dispatcher2.f25958b.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                next = null;
                                break;
                            } else {
                                next = it2.next();
                                if (Intrinsics3.areEqual(next.m10190a(), strM10190a)) {
                                    break;
                                }
                            }
                        }
                    } else {
                        next = it.next();
                        if (Intrinsics3.areEqual(next.m10190a(), strM10190a)) {
                            break;
                        }
                    }
                }
                if (next != null) {
                    Intrinsics3.checkParameterIsNotNull(next, "other");
                    aVar.f25482j = next.f25482j;
                }
            }
        }
        dispatcher2.m10391d();
    }

    @Override // p600f0.Call2
    public Response execute() {
        if (!this.f25468m.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed".toString());
        }
        this.f25467l.m10424i();
        m10183h();
        try {
            Dispatcher2 dispatcher2 = this.f25480y.f26012m;
            synchronized (dispatcher2) {
                Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                dispatcher2.f25960d.add(this);
            }
            return m10185j();
        } finally {
            Dispatcher2 dispatcher22 = this.f25480y.f26012m;
            Objects.requireNonNull(dispatcher22);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            dispatcher22.m10389b(dispatcher22.f25960d, this);
        }
    }

    /* renamed from: f */
    public final void m10181f(RealConnection4 realConnection4) {
        Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
        byte[] bArr = Util7.f25397a;
        if (!(this.f25471p == null)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f25471p = realConnection4;
        realConnection4.f25504o.add(new b(this, this.f25469n));
    }

    /* renamed from: g */
    public final <E extends IOException> E m10182g(E e) {
        E interruptedIOException;
        Socket socketM10188m;
        byte[] bArr = Util7.f25397a;
        RealConnection4 realConnection4 = this.f25471p;
        if (realConnection4 != null) {
            synchronized (realConnection4) {
                socketM10188m = m10188m();
            }
            if (this.f25471p == null) {
                if (socketM10188m != null) {
                    Util7.m10124e(socketM10188m);
                }
                Objects.requireNonNull(this.f25466k);
                Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
                Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
            } else {
                if (!(socketM10188m == null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
            }
        }
        if (!this.f25472q && this.f25467l.m10425j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (e != null) {
                interruptedIOException.initCause(e);
            }
        } else {
            interruptedIOException = e;
        }
        if (e != null) {
            EventListener eventListener = this.f25466k;
            if (interruptedIOException == null) {
                Intrinsics3.throwNpe();
            }
            Objects.requireNonNull(eventListener);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(interruptedIOException, "ioe");
        } else {
            Objects.requireNonNull(this.f25466k);
            Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
        }
        return interruptedIOException;
    }

    /* renamed from: h */
    public final void m10183h() {
        Platform2.a aVar = Platform2.f25785c;
        this.f25469n = Platform2.f25783a.mo10321g("response.body().close()");
        Objects.requireNonNull(this.f25466k);
        Intrinsics3.checkParameterIsNotNull(this, NotificationCompat.CATEGORY_CALL);
    }

    /* renamed from: i */
    public final void m10184i(boolean z2) {
        Exchange exchange;
        synchronized (this) {
            if (!this.f25476u) {
                throw new IllegalStateException("released".toString());
            }
        }
        if (z2 && (exchange = this.f25478w) != null) {
            exchange.f25442f.cancel();
            exchange.f25439c.m10186k(exchange, true, true, null);
        }
        this.f25473r = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0095  */
    /* renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Response m10185j() throws Throwable {
        ArrayList arrayList = new ArrayList();
        MutableCollections.addAll(arrayList, this.f25480y.f26014o);
        arrayList.add(new RetryAndFollowUpInterceptor(this.f25480y));
        arrayList.add(new BridgeInterceptor(this.f25480y.f26021v));
        Objects.requireNonNull(this.f25480y);
        arrayList.add(new CacheInterceptor());
        arrayList.add(ConnectInterceptor.f25432b);
        if (!this.f25464A) {
            MutableCollections.addAll(arrayList, this.f25480y.f26015p);
        }
        arrayList.add(new CallServerInterceptor(this.f25464A));
        Request request = this.f25481z;
        OkHttpClient okHttpClient = this.f25480y;
        RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this, arrayList, 0, null, request, okHttpClient.f26006J, okHttpClient.f26007K, okHttpClient.f26008L);
        boolean z2 = false;
        try {
            try {
                Response responseMo10228a = realInterceptorChain.mo10228a(this.f25481z);
                if (!this.f25477v) {
                    m10187l(null);
                    return responseMo10228a;
                }
                Intrinsics3.checkParameterIsNotNull(responseMo10228a, "$this$closeQuietly");
                try {
                    responseMo10228a.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                try {
                    IOException iOExceptionM10187l = m10187l(e2);
                    if (iOExceptionM10187l == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                    }
                    throw iOExceptionM10187l;
                } catch (Throwable th) {
                    th = th;
                    z2 = true;
                    if (!z2) {
                        m10187l(null);
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

    /* renamed from: k */
    public final <E extends IOException> E m10186k(Exchange exchange, boolean z2, boolean z3, E e) {
        boolean z4;
        boolean z5;
        Intrinsics3.checkParameterIsNotNull(exchange, "exchange");
        if (!Intrinsics3.areEqual(exchange, this.f25478w)) {
            return e;
        }
        synchronized (this) {
            z4 = false;
            if (z2) {
                try {
                    if (!this.f25474s) {
                        if (z3 || !this.f25475t) {
                            z5 = false;
                        }
                    }
                    if (z2) {
                        this.f25474s = false;
                    }
                    if (z3) {
                        this.f25475t = false;
                    }
                    boolean z6 = this.f25474s;
                    boolean z7 = (z6 || this.f25475t) ? false : true;
                    if (!z6 && !this.f25475t) {
                        if (!this.f25476u) {
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
            this.f25478w = null;
            RealConnection4 realConnection4 = this.f25471p;
            if (realConnection4 != null) {
                synchronized (realConnection4) {
                    realConnection4.f25501l++;
                }
            }
        }
        return z5 ? (E) m10182g(e) : e;
    }

    /* renamed from: l */
    public final IOException m10187l(IOException iOException) {
        boolean z2;
        synchronized (this) {
            z2 = false;
            if (this.f25476u) {
                this.f25476u = false;
                if (!this.f25474s) {
                    if (!this.f25475t) {
                        z2 = true;
                    }
                }
            }
        }
        return z2 ? m10182g(iOException) : iOException;
    }

    /* renamed from: m */
    public final Socket m10188m() {
        RealConnection4 realConnection4 = this.f25471p;
        if (realConnection4 == null) {
            Intrinsics3.throwNpe();
        }
        byte[] bArr = Util7.f25397a;
        List<Reference<RealCall>> list = realConnection4.f25504o;
        Iterator<Reference<RealCall>> it = list.iterator();
        boolean z2 = false;
        int i = 0;
        while (true) {
            if (!it.hasNext()) {
                i = -1;
                break;
            }
            if (Intrinsics3.areEqual(it.next().get(), this)) {
                break;
            }
            i++;
        }
        if (!(i != -1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        list.remove(i);
        this.f25471p = null;
        if (list.isEmpty()) {
            realConnection4.f25505p = System.nanoTime();
            RealConnectionPool realConnectionPool = this.f25465j;
            Objects.requireNonNull(realConnectionPool);
            Intrinsics3.checkParameterIsNotNull(realConnection4, "connection");
            byte[] bArr2 = Util7.f25397a;
            if (realConnection4.f25498i || realConnectionPool.f25511e == 0) {
                realConnection4.f25498i = true;
                realConnectionPool.f25510d.remove(realConnection4);
                if (realConnectionPool.f25510d.isEmpty()) {
                    realConnectionPool.f25508b.m10152a();
                }
                z2 = true;
            } else {
                TaskQueue2.m10151d(realConnectionPool.f25508b, realConnectionPool.f25509c, 0L, 2);
            }
            if (z2) {
                return realConnection4.m10205n();
            }
        }
        return null;
    }

    /* renamed from: n */
    public final void m10189n() {
        if (!(!this.f25472q)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        this.f25472q = true;
        this.f25467l.m10425j();
    }
}
