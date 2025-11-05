package f0.e0.h;

import d0.g0.t;
import d0.z.d.m;
import f0.n;
import f0.p;
import g0.l;
import g0.r;
import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: BridgeInterceptor.kt */
/* loaded from: classes3.dex */
public final class a implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public final p f3624b;

    public a(p pVar) {
        m.checkParameterIsNotNull(pVar, "cookieJar");
        this.f3624b = pVar;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        ResponseBody responseBody;
        m.checkParameterIsNotNull(chain, "chain");
        g gVar = (g) chain;
        Request request = gVar.f;
        Request.a aVar = new Request.a(request);
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                aVar.b("Content-Type", mediaTypeContentType.mediaType);
            }
            long size = requestBody.getSize();
            if (size != -1) {
                aVar.b("Content-Length", String.valueOf(size));
                aVar.d("Transfer-Encoding");
            } else {
                aVar.b("Transfer-Encoding", "chunked");
                aVar.d("Content-Length");
            }
        }
        int i = 0;
        if (request.b("Host") == null) {
            aVar.b("Host", f0.e0.c.y(request.url, false));
        }
        if (request.b("Connection") == null) {
            aVar.b("Connection", "Keep-Alive");
        }
        if (request.b("Accept-Encoding") == null && request.b("Range") == null) {
            aVar.b("Accept-Encoding", "gzip");
            z2 = true;
        } else {
            z2 = false;
        }
        List<n> listB = this.f3624b.b(request.url);
        if (!listB.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listB) {
                int i2 = i + 1;
                if (i < 0) {
                    d0.t.n.throwIndexOverflow();
                }
                n nVar = (n) obj;
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(nVar.f);
                sb.append('=');
                sb.append(nVar.g);
                i = i2;
            }
            String string = sb.toString();
            m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            aVar.b("Cookie", string);
        }
        if (request.b("User-Agent") == null) {
            aVar.b("User-Agent", "okhttp/4.8.0");
        }
        Response responseA = gVar.a(aVar.a());
        e.d(this.f3624b, request.url, responseA.headers);
        Response.a aVar2 = new Response.a(responseA);
        aVar2.g(request);
        if (z2 && t.equals("gzip", Response.a(responseA, "Content-Encoding", null, 2), true) && e.a(responseA) && (responseBody = responseA.body) != null) {
            l lVar = new l(responseBody.c());
            Headers.a aVarE = responseA.headers.e();
            aVarE.d("Content-Encoding");
            aVarE.d("Content-Length");
            aVar2.d(aVarE.c());
            String strA = Response.a(responseA, "Content-Type", null, 2);
            m.checkParameterIsNotNull(lVar, "$this$buffer");
            aVar2.g = new h(strA, -1L, new r(lVar));
        }
        return aVar2.a();
    }
}
