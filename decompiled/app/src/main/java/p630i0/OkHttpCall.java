package p630i0;

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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Call2;
import p600f0.Callback2;
import p600f0.FormBody;
import p600f0.Handshake;
import p600f0.HttpUrl;
import p600f0.Protocol2;
import p600f0.p601e0.p605g.Exchange;
import p615g0.Buffer3;
import p615g0.BufferedSource;
import p615g0.ForwardingSource;
import p615g0.RealBufferedSource;
import p615g0.Source2;
import p630i0.RequestBuilder;

/* JADX INFO: renamed from: i0.p, reason: use source file name */
/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OkHttpCall<T> implements Call3<T> {

    /* JADX INFO: renamed from: j */
    public final RequestFactory f26551j;

    /* JADX INFO: renamed from: k */
    public final Object[] f26552k;

    /* JADX INFO: renamed from: l */
    public final Call2.a f26553l;

    /* JADX INFO: renamed from: m */
    public final Converter2<ResponseBody, T> f26554m;

    /* JADX INFO: renamed from: n */
    public volatile boolean f26555n;

    /* JADX INFO: renamed from: o */
    public Call2 f26556o;

    /* JADX INFO: renamed from: p */
    public Throwable f26557p;

    /* JADX INFO: renamed from: q */
    public boolean f26558q;

    /* JADX INFO: renamed from: i0.p$a */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public class a implements Callback2 {

        /* JADX INFO: renamed from: a */
        public final /* synthetic */ Callback3 f26559a;

        public a(Callback3 callback3) {
            this.f26559a = callback3;
        }

        @Override // p600f0.Callback2
        /* JADX INFO: renamed from: a */
        public void mo10358a(Call2 call2, Response response) {
            try {
                try {
                    this.f26559a.mo10709b(OkHttpCall.this, OkHttpCall.this.m10714g(response));
                } catch (Throwable th) {
                    Utils8.m10695o(th);
                    th.printStackTrace();
                }
            } catch (Throwable th2) {
                Utils8.m10695o(th2);
                try {
                    this.f26559a.mo10708a(OkHttpCall.this, th2);
                } catch (Throwable th3) {
                    Utils8.m10695o(th3);
                    th3.printStackTrace();
                }
            }
        }

        @Override // p600f0.Callback2
        /* JADX INFO: renamed from: b */
        public void mo10359b(Call2 call2, IOException iOException) {
            try {
                this.f26559a.mo10708a(OkHttpCall.this, iOException);
            } catch (Throwable th) {
                Utils8.m10695o(th);
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: i0.p$b */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public static final class b extends ResponseBody {

        /* JADX INFO: renamed from: l */
        public final ResponseBody f26561l;

        /* JADX INFO: renamed from: m */
        public final BufferedSource f26562m;

        /* JADX INFO: renamed from: n */
        public IOException f26563n;

        /* JADX INFO: renamed from: i0.p$b$a */
        /* JADX INFO: compiled from: OkHttpCall.java */
        public class a extends ForwardingSource {
            public a(Source2 source2) {
                super(source2);
            }

            @Override // p615g0.Source2
            /* JADX INFO: renamed from: i0 */
            public long mo10176i0(Buffer3 buffer3, long j) throws IOException {
                try {
                    Intrinsics3.checkParameterIsNotNull(buffer3, "sink");
                    return this.f26093j.mo10176i0(buffer3, j);
                } catch (IOException e) {
                    b.this.f26563n = e;
                    throw e;
                }
            }
        }

        public b(ResponseBody responseBody) {
            this.f26561l = responseBody;
            a aVar = new a(responseBody.mo10105c());
            Intrinsics3.checkParameterIsNotNull(aVar, "$this$buffer");
            this.f26562m = new RealBufferedSource(aVar);
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public long mo10103a() {
            return this.f26561l.mo10103a();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public MediaType mo10104b() {
            return this.f26561l.mo10104b();
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public BufferedSource mo10105c() {
            return this.f26562m;
        }

        @Override // okhttp3.ResponseBody, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.f26561l.close();
        }
    }

    /* JADX INFO: renamed from: i0.p$c */
    /* JADX INFO: compiled from: OkHttpCall.java */
    public static final class c extends ResponseBody {

        /* JADX INFO: renamed from: l */
        public final MediaType f26565l;

        /* JADX INFO: renamed from: m */
        public final long f26566m;

        public c(MediaType mediaType, long j) {
            this.f26565l = mediaType;
            this.f26566m = j;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: a */
        public long mo10103a() {
            return this.f26566m;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: b */
        public MediaType mo10104b() {
            return this.f26565l;
        }

        @Override // okhttp3.ResponseBody
        /* JADX INFO: renamed from: c */
        public BufferedSource mo10105c() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    public OkHttpCall(RequestFactory requestFactory, Object[] objArr, Call2.a aVar, Converter2<ResponseBody, T> converter2) {
        this.f26551j = requestFactory;
        this.f26552k = objArr;
        this.f26553l = aVar;
        this.f26554m = converter2;
    }

    @Override // p630i0.Call3
    /* JADX INFO: renamed from: C */
    public void mo10697C(Callback3<T> callback3) {
        Call2 call2;
        Throwable th;
        synchronized (this) {
            if (this.f26558q) {
                throw new IllegalStateException("Already executed.");
            }
            this.f26558q = true;
            call2 = this.f26556o;
            th = this.f26557p;
            if (call2 == null && th == null) {
                try {
                    Call2 call2M10712b = m10712b();
                    this.f26556o = call2M10712b;
                    call2 = call2M10712b;
                } catch (Throwable th2) {
                    th = th2;
                    Utils8.m10695o(th);
                    this.f26557p = th;
                }
            }
        }
        if (th != null) {
            callback3.mo10708a(this, th);
            return;
        }
        if (this.f26555n) {
            call2.cancel();
        }
        call2.mo10113e(new a(callback3));
    }

    @Override // p630i0.Call3
    /* JADX INFO: renamed from: L */
    public Call3 mo10698L() {
        return new OkHttpCall(this.f26551j, this.f26552k, this.f26553l, this.f26554m);
    }

    /* JADX INFO: renamed from: b */
    public final Call2 m10712b() throws IOException {
        HttpUrl httpUrlM10409b;
        Call2.a aVar = this.f26553l;
        RequestFactory requestFactory = this.f26551j;
        Object[] objArr = this.f26552k;
        ParameterHandler3<?>[] parameterHandler3Arr = requestFactory.f26642j;
        int length = objArr.length;
        if (length != parameterHandler3Arr.length) {
            throw new IllegalArgumentException(outline.m814B(outline.m834V("Argument count (", length, ") doesn't match expected count ("), parameterHandler3Arr.length, ")"));
        }
        RequestBuilder requestBuilder = new RequestBuilder(requestFactory.f26635c, requestFactory.f26634b, requestFactory.f26636d, requestFactory.f26637e, requestFactory.f26638f, requestFactory.f26639g, requestFactory.f26640h, requestFactory.f26641i);
        if (requestFactory.f26643k) {
            length--;
        }
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(objArr[i]);
            parameterHandler3Arr[i].mo10715a(requestBuilder, objArr[i]);
        }
        HttpUrl.a aVar2 = requestBuilder.f26623f;
        if (aVar2 != null) {
            httpUrlM10409b = aVar2.m10409b();
        } else {
            HttpUrl httpUrl = requestBuilder.f26621d;
            String str = requestBuilder.f26622e;
            Objects.requireNonNull(httpUrl);
            Intrinsics3.checkParameterIsNotNull(str, "link");
            HttpUrl.a aVarM10405g = httpUrl.m10405g(str);
            httpUrlM10409b = aVarM10405g != null ? aVarM10405g.m10409b() : null;
            if (httpUrlM10409b == null) {
                StringBuilder sbM833U = outline.m833U("Malformed URL. Base: ");
                sbM833U.append(requestBuilder.f26621d);
                sbM833U.append(", Relative: ");
                sbM833U.append(requestBuilder.f26622e);
                throw new IllegalArgumentException(sbM833U.toString());
            }
        }
        RequestBody aVar3 = requestBuilder.f26630m;
        if (aVar3 == null) {
            FormBody.a aVar4 = requestBuilder.f26629l;
            if (aVar4 != null) {
                aVar3 = new FormBody(aVar4.f25966a, aVar4.f25967b);
            } else {
                MultipartBody.C12933a c12933a = requestBuilder.f26628k;
                if (c12933a != null) {
                    aVar3 = c12933a.m10973b();
                } else if (requestBuilder.f26627j) {
                    aVar3 = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = requestBuilder.f26626i;
        if (mediaType != null) {
            if (aVar3 != null) {
                aVar3 = new RequestBuilder.a(aVar3, mediaType);
            } else {
                requestBuilder.f26625h.m10958a("Content-Type", mediaType.mediaType);
            }
        }
        Request.C12935a c12935a = requestBuilder.f26624g;
        c12935a.m10984g(httpUrlM10409b);
        Headers headersM10960c = requestBuilder.f26625h.m10960c();
        Intrinsics3.checkParameterIsNotNull(headersM10960c, "headers");
        c12935a.f27545c = headersM10960c.m10956e();
        c12935a.m10980c(requestBuilder.f26620c, aVar3);
        c12935a.m10982e(Invocation.class, new Invocation(requestFactory.f26633a, arrayList));
        Call2 call2Mo10114b = aVar.mo10114b(c12935a.m10978a());
        Objects.requireNonNull(call2Mo10114b, "Call.Factory returned null.");
        return call2Mo10114b;
    }

    @Override // p630i0.Call3
    /* JADX INFO: renamed from: c */
    public synchronized Request mo10699c() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return m10713f().mo10111c();
    }

    @Override // p630i0.Call3
    public void cancel() {
        Call2 call2;
        this.f26555n = true;
        synchronized (this) {
            call2 = this.f26556o;
        }
        if (call2 != null) {
            call2.cancel();
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return new OkHttpCall(this.f26551j, this.f26552k, this.f26553l, this.f26554m);
    }

    @Override // p630i0.Call3
    /* JADX INFO: renamed from: d */
    public boolean mo10700d() {
        boolean z2 = true;
        if (this.f26555n) {
            return true;
        }
        synchronized (this) {
            Call2 call2 = this.f26556o;
            if (call2 == null || !call2.mo10112d()) {
                z2 = false;
            }
        }
        return z2;
    }

    @Override // p630i0.Call3
    public retrofit2.Response<T> execute() throws IOException {
        Call2 call2M10713f;
        synchronized (this) {
            if (this.f26558q) {
                throw new IllegalStateException("Already executed.");
            }
            this.f26558q = true;
            call2M10713f = m10713f();
        }
        if (this.f26555n) {
            call2M10713f.cancel();
        }
        return m10714g(call2M10713f.execute());
    }

    /* JADX INFO: renamed from: f */
    public final Call2 m10713f() throws IOException {
        Call2 call2 = this.f26556o;
        if (call2 != null) {
            return call2;
        }
        Throwable th = this.f26557p;
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
            Call2 call2M10712b = m10712b();
            this.f26556o = call2M10712b;
            return call2M10712b;
        } catch (IOException | Error | RuntimeException e) {
            Utils8.m10695o(e);
            this.f26557p = e;
            throw e;
        }
    }

    /* JADX INFO: renamed from: g */
    public retrofit2.Response<T> m10714g(Response response) throws IOException {
        ResponseBody responseBody = response.body;
        Intrinsics3.checkParameterIsNotNull(response, "response");
        Request request = response.request;
        Protocol2 protocol2 = response.protocol;
        int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        String str = response.message;
        Handshake handshake = response.handshake;
        Headers.C12930a c12930aM10956e = response.headers.m10956e();
        Response response2 = response.networkResponse;
        Response response3 = response.cacheResponse;
        Response response4 = response.priorResponse;
        long j = response.sentRequestAtMillis;
        long j2 = response.receivedResponseAtMillis;
        Exchange exchange = response.exchange;
        c cVar = new c(responseBody.mo10104b(), responseBody.mo10103a());
        if (!(i >= 0)) {
            throw new IllegalStateException(outline.m871q("code < 0: ", i).toString());
        }
        if (request == null) {
            throw new IllegalStateException("request == null".toString());
        }
        if (protocol2 == null) {
            throw new IllegalStateException("protocol == null".toString());
        }
        if (str == null) {
            throw new IllegalStateException("message == null".toString());
        }
        Response response5 = new Response(request, protocol2, str, i, handshake, c12930aM10956e.m10960c(), cVar, response2, response3, response4, j, j2, exchange);
        int i2 = response5.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
        if (i2 < 200 || i2 >= 300) {
            try {
                ResponseBody responseBodyM10681a = Utils8.m10681a(responseBody);
                if (response5.m10990b()) {
                    throw new IllegalArgumentException("rawResponse should not be successful response");
                }
                return new retrofit2.Response<>(response5, null, responseBodyM10681a);
            } finally {
                responseBody.close();
            }
        }
        if (i2 == 204 || i2 == 205) {
            responseBody.close();
            return retrofit2.Response.m11056b(null, response5);
        }
        b bVar = new b(responseBody);
        try {
            return retrofit2.Response.m11056b(this.f26554m.convert(bVar), response5);
        } catch (RuntimeException e) {
            IOException iOException = bVar.f26563n;
            if (iOException == null) {
                throw e;
            }
            throw iOException;
        }
    }
}
