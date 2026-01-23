package p600f0.p601e0.p606h;

import java.io.IOException;
import java.util.List;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Cookie;
import p600f0.CookieJar2;
import p600f0.p601e0.Util7;
import p615g0.GzipSource;
import p615g0.RealBufferedSource;

/* JADX INFO: renamed from: f0.e0.h.a, reason: use source file name */
/* JADX INFO: compiled from: BridgeInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BridgeInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b */
    public final CookieJar2 f25524b;

    public BridgeInterceptor(CookieJar2 cookieJar2) {
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "cookieJar");
        this.f25524b = cookieJar2;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean z2;
        ResponseBody responseBody;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        Request request = realInterceptorChain.f25536f;
        Request.C12935a c12935a = new Request.C12935a(request);
        RequestBody requestBody = request.body;
        if (requestBody != null) {
            MediaType mediaTypeContentType = requestBody.contentType();
            if (mediaTypeContentType != null) {
                c12935a.m10979b("Content-Type", mediaTypeContentType.mediaType);
            }
            long size = requestBody.getSize();
            if (size != -1) {
                c12935a.m10979b("Content-Length", String.valueOf(size));
                c12935a.m10981d("Transfer-Encoding");
            } else {
                c12935a.m10979b("Transfer-Encoding", "chunked");
                c12935a.m10981d("Content-Length");
            }
        }
        int i = 0;
        if (request.m10977b("Host") == null) {
            c12935a.m10979b("Host", Util7.m10144y(request.url, false));
        }
        if (request.m10977b("Connection") == null) {
            c12935a.m10979b("Connection", "Keep-Alive");
        }
        if (request.m10977b("Accept-Encoding") == null && request.m10977b("Range") == null) {
            c12935a.m10979b("Accept-Encoding", "gzip");
            z2 = true;
        } else {
            z2 = false;
        }
        List<Cookie> listMo8746b = this.f25524b.mo8746b(request.url);
        if (!listMo8746b.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (Object obj : listMo8746b) {
                int i2 = i + 1;
                if (i < 0) {
                    Collections2.throwIndexOverflow();
                }
                Cookie cookie = (Cookie) obj;
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(cookie.f25947f);
                sb.append('=');
                sb.append(cookie.f25948g);
                i = i2;
            }
            String string = sb.toString();
            Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
            c12935a.m10979b("Cookie", string);
        }
        if (request.m10977b("User-Agent") == null) {
            c12935a.m10979b("User-Agent", "okhttp/4.8.0");
        }
        Response responseMo10228a = realInterceptorChain.mo10228a(c12935a.m10978a());
        HttpHeaders.m10224d(this.f25524b, request.url, responseMo10228a.headers);
        Response.C12937a c12937a = new Response.C12937a(responseMo10228a);
        c12937a.m10997g(request);
        if (z2 && StringsJVM.equals("gzip", Response.m10989a(responseMo10228a, "Content-Encoding", null, 2), true) && HttpHeaders.m10221a(responseMo10228a) && (responseBody = responseMo10228a.body) != null) {
            GzipSource gzipSource = new GzipSource(responseBody.mo10105c());
            Headers.C12930a c12930aM10956e = responseMo10228a.headers.m10956e();
            c12930aM10956e.m10961d("Content-Encoding");
            c12930aM10956e.m10961d("Content-Length");
            c12937a.m10994d(c12930aM10956e.m10960c());
            String strM10989a = Response.m10989a(responseMo10228a, "Content-Type", null, 2);
            Intrinsics3.checkParameterIsNotNull(gzipSource, "$this$buffer");
            c12937a.f27571g = new RealResponseBody(strM10989a, -1L, new RealBufferedSource(gzipSource));
        }
        return c12937a.m10991a();
    }
}
