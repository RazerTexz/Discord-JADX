package com.discord.gateway.rest;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGateway;
import com.discord.restapi.RestAPIBuilder;
import com.discord.restapi.RestInterceptors2;
import com.discord.restapi.utils.RetryWithDelay;
import com.franmontiel.persistentcookiejar.PersistentCookieJar;
import com.franmontiel.persistentcookiejar.cache.SetCookieCache;
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor;
import java.util.List;
import java.util.Objects;
import okhttp3.Interceptor;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.SpreadBuilder;
import p637j0.p641k.Func1;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;

/* compiled from: RestClient.kt */
/* loaded from: classes.dex */
public final class RestClient {
    public static final RestClient INSTANCE = new RestClient();
    private static RestApi restApi;

    /* compiled from: RestClient.kt */
    /* renamed from: com.discord.gateway.rest.RestClient$getGateway$1 */
    public static final class C55221<T, R> implements Func1<ModelGateway, String> {
        public static final C55221 INSTANCE = new C55221();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ String call(ModelGateway modelGateway) {
            return call2(modelGateway);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final String call2(ModelGateway modelGateway) {
            Intrinsics3.checkNotNullExpressionValue(modelGateway, "it");
            return modelGateway.getUrl();
        }
    }

    private RestClient() {
    }

    public final Observable<String> getGateway() {
        RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
        RestApi restApi2 = restApi;
        if (restApi2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("restApi");
        }
        Observable<ModelGateway> observableM11098X = restApi2.getGateway().m11098X(Schedulers2.m10875c());
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "restApi\n          .getGa…scribeOn(Schedulers.io())");
        Observable<String> observableM11083G = RetryWithDelay.restRetry$default(retryWithDelay, observableM11098X, 0L, null, null, 7, null).m11083G(C55221.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "restApi\n          .getGa…          .map { it.url }");
        return observableM11083G;
    }

    public final void init(RestConfig restConfig, Context context) {
        Intrinsics3.checkNotNullParameter(restConfig, "restConfig");
        Intrinsics3.checkNotNullParameter(context, "context");
        String baseUrl = restConfig.getBaseUrl();
        RestInterceptors2.HeadersProvider headersProvider = restConfig.getHeadersProvider();
        List<Interceptor> listComponent3 = restConfig.component3();
        RestInterceptors2 restInterceptors2 = new RestInterceptors2(headersProvider);
        PersistentCookieJar persistentCookieJar = new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
        SpreadBuilder spreadBuilder = new SpreadBuilder(2);
        spreadBuilder.add(restInterceptors2);
        Object[] array = listComponent3.toArray(new Interceptor[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        spreadBuilder.addSpread(array);
        restApi = (RestApi) RestAPIBuilder.build$default(new RestAPIBuilder(baseUrl, persistentCookieJar), RestApi.class, false, 0L, Collections2.listOf(spreadBuilder.toArray(new Interceptor[spreadBuilder.size()])), null, false, null, 118, null);
    }
}
