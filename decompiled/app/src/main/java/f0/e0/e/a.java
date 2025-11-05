package f0.e0.e;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.g0.t;
import d0.g0.w;
import d0.z.d.m;
import f0.e0.g.c;
import f0.e0.g.e;
import f0.e0.h.g;
import f0.v;
import f0.y;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: CacheInterceptor.kt */
/* loaded from: classes3.dex */
public final class a implements Interceptor {

    /* renamed from: b, reason: collision with root package name */
    public static final C0604a f3607b = new C0604a(null);

    /* compiled from: CacheInterceptor.kt */
    /* renamed from: f0.e0.e.a$a, reason: collision with other inner class name */
    public static final class C0604a {
        public C0604a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public static final Response a(C0604a c0604a, Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
            m.checkParameterIsNotNull(response, "response");
            Request request = response.request;
            y yVar = response.protocol;
            int i = response.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String;
            String str = response.message;
            v vVar = response.handshake;
            Headers.a aVarE = response.headers.e();
            Response response2 = response.networkResponse;
            Response response3 = response.cacheResponse;
            Response response4 = response.priorResponse;
            long j = response.sentRequestAtMillis;
            long j2 = response.receivedResponseAtMillis;
            c cVar = response.exchange;
            if (!(i >= 0)) {
                throw new IllegalStateException(b.d.b.a.a.q("code < 0: ", i).toString());
            }
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            if (yVar == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            if (str != null) {
                return new Response(request, yVar, str, i, vVar, aVarE.c(), null, response2, response3, response4, j, j2, cVar);
            }
            throw new IllegalStateException("message == null".toString());
        }

        public final boolean b(String str) {
            return t.equals("Content-Length", str, true) || t.equals("Content-Encoding", str, true) || t.equals("Content-Type", str, true);
        }

        public final boolean c(String str) {
            return (t.equals("Connection", str, true) || t.equals("Keep-Alive", str, true) || t.equals("Proxy-Authenticate", str, true) || t.equals("Proxy-Authorization", str, true) || t.equals("TE", str, true) || t.equals("Trailers", str, true) || t.equals("Transfer-Encoding", str, true) || t.equals("Upgrade", str, true)) ? false : true;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Headers headers;
        int i;
        m.checkParameterIsNotNull(chain, "chain");
        g gVar = (g) chain;
        e eVar = gVar.f3628b;
        System.currentTimeMillis();
        Request request = gVar.f;
        m.checkParameterIsNotNull(request, "request");
        b bVar = new b(request, null);
        if (request != null && request.a().k) {
            bVar = new b(null, null);
        }
        Request request2 = bVar.a;
        Response response = bVar.f3608b;
        if (!(eVar instanceof e)) {
        }
        if (request2 == null && response == null) {
            Response.a aVar = new Response.a();
            aVar.g(gVar.f);
            aVar.f(y.HTTP_1_1);
            aVar.c = 504;
            aVar.e("Unsatisfiable Request (only-if-cached)");
            aVar.g = f0.e0.c.c;
            aVar.k = -1L;
            aVar.l = System.currentTimeMillis();
            Response responseA = aVar.a();
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(responseA, "response");
            return responseA;
        }
        if (request2 == null) {
            if (response == null) {
                m.throwNpe();
            }
            Response.a aVar2 = new Response.a(response);
            aVar2.b(C0604a.a(f3607b, response));
            Response responseA2 = aVar2.a();
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(responseA2, "response");
            return responseA2;
        }
        if (response != null) {
            m.checkParameterIsNotNull(eVar, NotificationCompat.CATEGORY_CALL);
            m.checkParameterIsNotNull(response, "cachedResponse");
        }
        Response responseA3 = ((g) chain).a(request2);
        if (response != null) {
            if (responseA3.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 304) {
                Response.a aVar3 = new Response.a(response);
                C0604a c0604a = f3607b;
                Headers headers2 = response.headers;
                Headers headers3 = responseA3.headers;
                ArrayList arrayList = new ArrayList(20);
                int i2 = 0;
                for (int size = headers2.size(); i2 < size; size = i) {
                    String strD = headers2.d(i2);
                    String strG = headers2.g(i2);
                    if (t.equals("Warning", strD, true)) {
                        headers = headers2;
                        i = size;
                        if (t.startsWith$default(strG, "1", false, 2, null)) {
                        }
                        i2++;
                        headers2 = headers;
                    } else {
                        headers = headers2;
                        i = size;
                    }
                    if (c0604a.b(strD) || !c0604a.c(strD) || headers3.c(strD) == null) {
                        m.checkParameterIsNotNull(strD, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        m.checkParameterIsNotNull(strG, "value");
                        arrayList.add(strD);
                        arrayList.add(w.trim(strG).toString());
                    }
                    i2++;
                    headers2 = headers;
                }
                int size2 = headers3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strD2 = headers3.d(i3);
                    if (!c0604a.b(strD2) && c0604a.c(strD2)) {
                        String strG2 = headers3.g(i3);
                        m.checkParameterIsNotNull(strD2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        m.checkParameterIsNotNull(strG2, "value");
                        arrayList.add(strD2);
                        arrayList.add(w.trim(strG2).toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                aVar3.d(new Headers((String[]) array, null));
                aVar3.k = responseA3.sentRequestAtMillis;
                aVar3.l = responseA3.receivedResponseAtMillis;
                C0604a c0604a2 = f3607b;
                aVar3.b(C0604a.a(c0604a2, response));
                Response responseA4 = C0604a.a(c0604a2, responseA3);
                aVar3.c("networkResponse", responseA4);
                aVar3.h = responseA4;
                aVar3.a();
                ResponseBody responseBody = responseA3.body;
                if (responseBody == null) {
                    m.throwNpe();
                }
                responseBody.close();
                m.throwNpe();
                throw null;
            }
            ResponseBody responseBody2 = response.body;
            if (responseBody2 != null) {
                byte[] bArr = f0.e0.c.a;
                m.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                try {
                    responseBody2.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
        Response.a aVar4 = new Response.a(responseA3);
        C0604a c0604a3 = f3607b;
        aVar4.b(C0604a.a(c0604a3, response));
        Response responseA5 = C0604a.a(c0604a3, responseA3);
        aVar4.c("networkResponse", responseA5);
        aVar4.h = responseA5;
        return aVar4.a();
    }
}
