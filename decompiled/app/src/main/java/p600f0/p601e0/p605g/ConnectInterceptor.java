package p600f0.p601e0.p605g;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import java.util.Objects;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.internal.connection.RouteException;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.OkHttpClient;
import p600f0.p601e0.p606h.RealInterceptorChain;

/* JADX INFO: renamed from: f0.e0.g.a, reason: use source file name */
/* JADX INFO: compiled from: ConnectInterceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ConnectInterceptor implements Interceptor {

    /* JADX INFO: renamed from: b */
    public static final ConnectInterceptor f25432b = new ConnectInterceptor();

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics3.checkParameterIsNotNull(chain, "chain");
        RealInterceptorChain realInterceptorChain = (RealInterceptorChain) chain;
        RealCall realCall = realInterceptorChain.f25532b;
        Objects.requireNonNull(realCall);
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        synchronized (realCall) {
            if (!realCall.f25476u) {
                throw new IllegalStateException("released".toString());
            }
            if (!(!realCall.f25475t)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            if (!(!realCall.f25474s)) {
                throw new IllegalStateException("Check failed.".toString());
            }
        }
        ExchangeFinder exchangeFinder = realCall.f25470o;
        if (exchangeFinder == null) {
            Intrinsics3.throwNpe();
        }
        OkHttpClient okHttpClient = realCall.f25480y;
        Objects.requireNonNull(exchangeFinder);
        Intrinsics3.checkParameterIsNotNull(okHttpClient, "client");
        Intrinsics3.checkParameterIsNotNull(realInterceptorChain, "chain");
        try {
            Exchange exchange = new Exchange(realCall, realCall.f25466k, exchangeFinder, exchangeFinder.m10177a(realInterceptorChain.f25537g, realInterceptorChain.f25538h, realInterceptorChain.f25539i, okHttpClient.f26009M, okHttpClient.f26017r, !Intrinsics3.areEqual(realInterceptorChain.f25536f.method, ShareTarget.METHOD_GET)).m10202k(okHttpClient, realInterceptorChain));
            realCall.f25473r = exchange;
            realCall.f25478w = exchange;
            synchronized (realCall) {
                realCall.f25474s = true;
                realCall.f25475t = true;
            }
            if (realCall.f25477v) {
                throw new IOException("Canceled");
            }
            return RealInterceptorChain.m10227d(realInterceptorChain, 0, exchange, null, 0, 0, 0, 61).mo10228a(realInterceptorChain.f25536f);
        } catch (IOException e) {
            exchangeFinder.m10179c(e);
            throw new RouteException(e);
        } catch (RouteException e2) {
            exchangeFinder.m10179c(e2.getLastConnectException());
            throw e2;
        }
    }
}
