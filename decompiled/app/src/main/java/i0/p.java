package i0;

import f0.e;
import f0.u;
import f0.w;
import i0.v;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: OkHttpCall.java */
/* loaded from: classes3.dex */
public final class p<T> implements d<T> {
    public final w j;
    public final Object[] k;
    public final e.a l;
    public final h<ResponseBody, T> m;
    public volatile boolean n;
    public f0.e o;
    public Throwable p;
    public boolean q;

    /* compiled from: OkHttpCall.java */
    public class a implements f0.f {
        public final /* synthetic */ f a;

        public a(f fVar) {
            this.a = fVar;
        }

        @Override // f0.f
        public void a(f0.e eVar, Response response) {
            try {
                try {
                    this.a.b(p.this, p.this.g(response));
                } catch (Throwable th) {
                    c0.o(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                c0.o(th2);
                try {
                    this.a.a(p.this, th2);
                } catch (Throwable th3) {
                    c0.o(th3);
                    th3.printStackTrace();
                }
            }
        }

        @Override // f0.f
        public void b(f0.e eVar, IOException iOException) {
            try {
                this.a.a(p.this, iOException);
            } catch (Throwable th) {
                c0.o(th);
                th.printStackTrace();
            }
        }
    }

    /* compiled from: OkHttpCall.java */
    public static final class b extends ResponseBody {
        public final ResponseBody l;
        public final g0.g m;
        public IOException n;

        /* compiled from: OkHttpCall.java */
        public class a extends g0.j {
            public a(g0.x xVar) {
                super(xVar);
            }

            @Override // g0.x
            public long i0(g0.e eVar, long j) throws IOException {
                try {
                    d0.z.d.m.checkParameterIsNotNull(eVar, "sink");
                    return this.j.i0(eVar, j);
                } catch (IOException e) {
                    b.this.n = e;
                    throw e;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.l = responseBody;
            a aVar = new a(responseBody.c());
            d0.z.d.m.checkParameterIsNotNull(aVar, "$this$buffer");
            this.m = new g0.r(aVar);
        }

        @Override // okhttp3.ResponseBody
        public long a() {
            return this.l.a();
        }

        @Override // okhttp3.ResponseBody
        public MediaType b() {
            return this.l.b();
        }

        @Override // okhttp3.ResponseBody
        public g0.g c() {
            return this.m;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.l.close();
        }
    }

    /* compiled from: OkHttpCall.java */
    public static final class c extends ResponseBody {
        public final MediaType l;
        public final long m;

        public c(MediaType mediaType, long j) {
            this.l = mediaType;
            this.m = j;
        }

        @Override // okhttp3.ResponseBody
        public long a() {
            return this.m;
        }

        @Override // okhttp3.ResponseBody
        public MediaType b() {
            return this.l;
        }

        @Override // okhttp3.ResponseBody
        public g0.g c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public p(w wVar, Object[] objArr, e.a aVar, h<ResponseBody, T> hVar) {
        this.j = wVar;
        this.k = objArr;
        this.l = aVar;
        this.m = hVar;
    }

    @Override // i0.d
    public void C(f<T> fVar) {
        f0.e eVar;
        Throwable th;
        synchronized (this) {
            if (this.q) {
                throw new IllegalStateException("Already executed.");
            }
            this.q = true;
            eVar = this.o;
            th = this.p;
            if (eVar == null && th == null) {
                try {
                    f0.e eVarB = b();
                    this.o = eVarB;
                    eVar = eVarB;
                } catch (Throwable th2) {
                    th = th2;
                    c0.o(th);
                    this.p = th;
                }
            }
        }
        if (th != null) {
            fVar.a(this, th);
            return;
        }
        if (this.n) {
            eVar.cancel();
        }
        eVar.e(new a(fVar));
    }

    @Override // i0.d
    public d L() {
        return new p(this.j, this.k, this.l, this.m);
    }

    public final f0.e b() throws IOException {
        f0.w wVarB;
        e.a aVar = this.l;
        w wVar = this.j;
        Object[] objArr = this.k;
        t<?>[] tVarArr = wVar.j;
        int length = objArr.length;
        if (length != tVarArr.length) {
            throw new IllegalArgumentException(b.d.b.a.a.B(b.d.b.a.a.V("Argument count (", length, ") doesn't match expected count ("), tVarArr.length, ")"));
        }
        v vVar = new v(wVar.c, wVar.f3761b, wVar.d, wVar.e, wVar.f, wVar.g, wVar.h, wVar.i);
        if (wVar.k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            tVarArr[i].a(vVar, objArr[i]);
        }
        w.a aVar2 = vVar.f;
        if (aVar2 != null) {
            wVarB = aVar2.b();
        } else {
            f0.w wVar2 = vVar.d;
            String str = vVar.e;
            Objects.requireNonNull(wVar2);
            d0.z.d.m.checkParameterIsNotNull(str, "link");
            w.a aVarG = wVar2.g(str);
            wVarB = aVarG != null ? aVarG.b() : null;
            if (wVarB == null) {
                StringBuilder sbU = b.d.b.a.a.U("Malformed URL. Base: ");
                sbU.append(vVar.d);
                sbU.append(", Relative: ");
                sbU.append(vVar.e);
                throw new IllegalArgumentException(sbU.toString());
            }
        }
        RequestBody aVar3 = vVar.m;
        if (aVar3 == null) {
            u.a aVar4 = vVar.l;
            if (aVar4 != null) {
                aVar3 = new f0.u(aVar4.a, aVar4.f3679b);
            } else {
                MultipartBody.a aVar5 = vVar.k;
                if (aVar5 != null) {
                    aVar3 = aVar5.b();
                } else if (vVar.j) {
                    aVar3 = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = vVar.i;
        if (mediaType != null) {
            if (aVar3 != null) {
                aVar3 = new v.a(aVar3, mediaType);
            } else {
                vVar.h.a("Content-Type", mediaType.mediaType);
            }
        }
        Request.a aVar6 = vVar.g;
        aVar6.g(wVarB);
        Headers headersC = vVar.h.c();
        d0.z.d.m.checkParameterIsNotNull(headersC, "headers");
        aVar6.c = headersC.e();
        aVar6.c(vVar.c, aVar3);
        aVar6.e(k.class, new k(wVar.a, arrayList));
        f0.e eVarB = aVar.b(aVar6.a());
        Objects.requireNonNull(eVarB, "Call.Factory returned null.");
        return eVarB;
    }

    @Override // i0.d
    public synchronized Request c() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return f().c();
    }

    @Override // i0.d
    public void cancel() {
        f0.e eVar;
        this.n = true;
        synchronized (this) {
            eVar = this.o;
        }
        if (eVar != null) {
            eVar.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return new p(this.j, this.k, this.l, this.m);
    }

    @Override // i0.d
    public boolean d() {
        boolean z2 = true;
        if (this.n) {
            return true;
        }
        synchronized (this) {
            f0.e eVar = this.o;
            if (eVar == null || !eVar.d()) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // i0.d
    public retrofit2.Response<T> execute() throws IOException {
        f0.e eVarF;
        synchronized (this) {
            if (this.q) {
                throw new IllegalStateException("Already executed.");
            }
            this.q = true;
            eVarF = f();
        }
        if (this.n) {
            eVarF.cancel();
        }
        return g(eVarF.execute());
    }

    public final f0.e f() throws IOException {
        f0.e eVar = this.o;
        if (eVar != null) {
            return eVar;
        }
        Throwable th = this.p;
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            }
            if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            }
            throw ((Error) th);
        }
        try {
            f0.e eVarB = b();
            this.o = eVarB;
            return eVarB;
        } catch (IOException | Error | RuntimeException e) {
            c0.o(e);
            this.p = e;
            throw e;
        }
    }

    public retrofit2.Response<T> g(Response response) throws IOException {
        ResponseBody responseBody = response.body;
        d0.z.d.m.checkParameterIsNotNull(response, "response");
        Request request = response.request;
        f0.y yVar = response.protocol;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        String str = response.message;
        f0.v vVar = response.handshake;
        Headers.a aVarE = response.headers.e();
        Response response2 = response.networkResponse;
        Response response3 = response.cacheResponse;
        Response response4 = response.priorResponse;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        f0.e0.g.c cVar = response.exchange;
        c cVar2 = new c(responseBody.b(), responseBody.a());
        if (!(i >= 0)) {
            throw new IllegalStateException(b.d.b.a.a.q("code < 0: ", i).toString());
        }
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        if (yVar == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        if (str == null) {
            throw new IllegalStateException("message == null".toString());
        }
        Response response5 = new Response(request, yVar, str, i, vVar, aVarE.c(), cVar2, response2, response3, response4, j, j2, cVar);
        int i2 = response5.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        if (i2 < 200 || i2 >= 300) {
            try {
                ResponseBody responseBodyA = c0.a(responseBody);
                if (response5.b()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new retrofit2.Response<>(response5, null, responseBodyA);
            } finally {
                responseBody.close();
            }
        }
        if (i2 == 204 || i2 == 205) {
            responseBody.close();
            return retrofit2.Response.b(null, response5);
        }
        b bVar = new b(responseBody);
        try {
            return retrofit2.Response.b(this.m.convert(bVar), response5);
        } catch (RuntimeException e) {
            IOException iOException = bVar.n;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }
}
