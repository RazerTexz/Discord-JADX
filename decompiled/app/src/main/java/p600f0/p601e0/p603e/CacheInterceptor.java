package p600f0.p601e0.p603e;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import java.io.IOException;
import java.util.ArrayList;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.Handshake;
import p600f0.Protocol2;
import p600f0.p601e0.Util7;
import p600f0.p601e0.p605g.Exchange;
import p600f0.p601e0.p605g.RealCall;
import p600f0.p601e0.p606h.RealInterceptorChain;

/* compiled from: CacheInterceptor.kt */
/* renamed from: f0.e0.e.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class CacheInterceptor implements Interceptor {

    /* renamed from: b */
    public static final a f25406b = new a(null);

    /* compiled from: CacheInterceptor.kt */
    /* renamed from: f0.e0.e.a$a */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* renamed from: a */
        public static final Response m10147a(a aVar, Response response) {
            if ((response != null ? response.body : null) == null) {
                return response;
            }
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
            if (!(i >= 0)) {
                throw new IllegalStateException(outline.m871q("code < 0: ", i).toString());
            }
            if (request == null) {
                throw new IllegalStateException("request == null".toString());
            }
            if (protocol2 == null) {
                throw new IllegalStateException("protocol == null".toString());
            }
            if (str != null) {
                return new Response(request, protocol2, str, i, handshake, c12930aM10956e.m10960c(), null, response2, response3, response4, j, j2, exchange);
            }
            throw new IllegalStateException("message == null".toString());
        }

        /* renamed from: b */
        public final boolean m10148b(String str) {
            return StringsJVM.equals("Content-Length", str, true) || StringsJVM.equals("Content-Encoding", str, true) || StringsJVM.equals("Content-Type", str, true);
        }

        /* renamed from: c */
        public final boolean m10149c(String str) {
            return (StringsJVM.equals("Connection", str, true) || StringsJVM.equals("Keep-Alive", str, true) || StringsJVM.equals("Proxy-Authenticate", str, true) || StringsJVM.equals("Proxy-Authorization", str, true) || StringsJVM.equals("TE", str, true) || StringsJVM.equals("Trailers", str, true) || StringsJVM.equals("Transfer-Encoding", str, true) || StringsJVM.equals("Upgrade", str, true)) ? false : true;
        }
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Headers headers;
        int i;
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        RealCall realCall = realInterceptorChain.f25532b;
        System.currentTimeMillis();
        Request request = realInterceptorChain.f25536f;
        Intrinsics3.checkParameterIsNotNull(request, "request");
        CacheStrategy cacheStrategy = new CacheStrategy(request, null);
        if (request != null && request.m10976a().f25383k) {
            cacheStrategy = new CacheStrategy(null, null);
        }
        Request request2 = cacheStrategy.f25407a;
        Response response = cacheStrategy.f25408b;
        if (!(realCall instanceof RealCall)) {
        }
        if (request2 == null && response == null) {
            Response.C12937a c12937a = new Response.C12937a();
            c12937a.m10997g(realInterceptorChain.f25536f);
            c12937a.m10996f(Protocol2.HTTP_1_1);
            c12937a.f27567c = 504;
            c12937a.m10995e("Unsatisfiable Request (only-if-cached)");
            c12937a.f27571g = Util7.f25399c;
            c12937a.f27575k = -1L;
            c12937a.f27576l = System.currentTimeMillis();
            Response responseM10991a = c12937a.m10991a();
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(responseM10991a, "response");
            return responseM10991a;
        }
        if (request2 == null) {
            if (response == null) {
                Intrinsics3.throwNpe();
            }
            Response.C12937a c12937a2 = new Response.C12937a(response);
            c12937a2.m10992b(a.m10147a(f25406b, response));
            Response responseM10991a2 = c12937a2.m10991a();
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(responseM10991a2, "response");
            return responseM10991a2;
        }
        if (response != null) {
            Intrinsics3.checkParameterIsNotNull(realCall, NotificationCompat.CATEGORY_CALL);
            Intrinsics3.checkParameterIsNotNull(response, "cachedResponse");
        }
        Response responseMo10228a = ((RealInterceptorChain) chain).mo10228a(request2);
        if (response != null) {
            if (responseMo10228a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String == 304) {
                Response.C12937a c12937a3 = new Response.C12937a(response);
                a aVar = f25406b;
                Headers headers2 = response.headers;
                Headers headers3 = responseMo10228a.headers;
                ArrayList arrayList = new ArrayList(20);
                int i2 = 0;
                for (int size = headers2.size(); i2 < size; size = i) {
                    String strM10955d = headers2.m10955d(i2);
                    String strM10957g = headers2.m10957g(i2);
                    if (StringsJVM.equals("Warning", strM10955d, true)) {
                        headers = headers2;
                        i = size;
                        if (StringsJVM.startsWith$default(strM10957g, "1", false, 2, null)) {
                        }
                        i2++;
                        headers2 = headers;
                    } else {
                        headers = headers2;
                        i = size;
                    }
                    if (aVar.m10148b(strM10955d) || !aVar.m10149c(strM10955d) || headers3.m10954c(strM10955d) == null) {
                        Intrinsics3.checkParameterIsNotNull(strM10955d, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Intrinsics3.checkParameterIsNotNull(strM10957g, "value");
                        arrayList.add(strM10955d);
                        arrayList.add(Strings4.trim(strM10957g).toString());
                    }
                    i2++;
                    headers2 = headers;
                }
                int size2 = headers3.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    String strM10955d2 = headers3.m10955d(i3);
                    if (!aVar.m10148b(strM10955d2) && aVar.m10149c(strM10955d2)) {
                        String strM10957g2 = headers3.m10957g(i3);
                        Intrinsics3.checkParameterIsNotNull(strM10955d2, ModelAuditLogEntry.CHANGE_KEY_NAME);
                        Intrinsics3.checkParameterIsNotNull(strM10957g2, "value");
                        arrayList.add(strM10955d2);
                        arrayList.add(Strings4.trim(strM10957g2).toString());
                    }
                }
                Object[] array = arrayList.toArray(new String[0]);
                if (array == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                c12937a3.m10994d(new Headers((String[]) array, null));
                c12937a3.f27575k = responseMo10228a.sentRequestAtMillis;
                c12937a3.f27576l = responseMo10228a.receivedResponseAtMillis;
                a aVar2 = f25406b;
                c12937a3.m10992b(a.m10147a(aVar2, response));
                Response responseM10147a = a.m10147a(aVar2, responseMo10228a);
                c12937a3.m10993c("networkResponse", responseM10147a);
                c12937a3.f27572h = responseM10147a;
                c12937a3.m10991a();
                ResponseBody responseBody = responseMo10228a.body;
                if (responseBody == null) {
                    Intrinsics3.throwNpe();
                }
                responseBody.close();
                Intrinsics3.throwNpe();
                throw null;
            }
            ResponseBody responseBody2 = response.body;
            if (responseBody2 != null) {
                byte[] bArr = Util7.f25397a;
                Intrinsics3.checkParameterIsNotNull(responseBody2, "$this$closeQuietly");
                try {
                    responseBody2.close();
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception unused) {
                }
            }
        }
        Response.C12937a c12937a4 = new Response.C12937a(responseMo10228a);
        a aVar3 = f25406b;
        c12937a4.m10992b(a.m10147a(aVar3, response));
        Response responseM10147a2 = a.m10147a(aVar3, responseMo10228a);
        c12937a4.m10993c("networkResponse", responseM10147a2);
        c12937a4.f27572h = responseM10147a2;
        return c12937a4.m10991a();
    }
}
