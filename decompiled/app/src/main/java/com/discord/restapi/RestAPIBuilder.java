package com.discord.restapi;

import androidx.annotation.VisibleForTesting;
import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.Model;
import com.discord.models.experiments.dto.UserExperimentDto;
import com.discord.restapi.PayloadJSON;
import com.discord.restapi.RestAPIParams;
import com.google.gson.Gson;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Interceptor;
import p007b.p008a.p017b.TypeAdapterRegistrar;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p408d.FieldNamingPolicy;
import p007b.p225i.p408d.GsonBuilder;
import p507d0.p592z.p594d.Intrinsics3;
import p600f0.CookieJar2;
import p600f0.HttpUrl;
import p600f0.OkHttpClient;
import p600f0.p601e0.Util7;
import p630i0.BuiltInConverters;
import p630i0.CompletableFutureCallAdapterFactory;
import p630i0.DefaultCallAdapterFactory;
import p630i0.OptionalConverterFactory;
import p630i0.Platform3;
import p630i0.Retrofit;
import p630i0.Retrofit2;
import p630i0.p631d0.p632a.RxJavaCallAdapterFactory;
import p630i0.p633e0.p634a.GsonConverterFactory;
import p630i0.p633e0.p635b.ScalarsConverterFactory;

/* compiled from: RestAPIBuilder.kt */
/* loaded from: classes.dex */
public final class RestAPIBuilder {
    private static final int API_VERSION = 9;
    public static final String CONTENT_TYPE_JSON = "application/json";
    public static final String CONTENT_TYPE_TEXT = "text/plain";
    private static final long DEFAULT_TIMEOUT_MILLIS = 10000;
    private final String baseApiUrl;
    private final CookieJar2 cookieJar;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static Function2<? super String, ? super OkHttpClient, Unit> clientCallback = RestAPIBuilder2.INSTANCE;

    /* compiled from: RestAPIBuilder.kt */
    public static final class Companion {
        private Companion() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getClientCallback$annotations() {
        }

        public final Function2<String, OkHttpClient, Unit> getClientCallback() {
            return RestAPIBuilder.access$getClientCallback$cp();
        }

        public final void setClientCallback(Function2<? super String, ? super OkHttpClient, Unit> function2) {
            Intrinsics3.checkNotNullParameter(function2, "<set-?>");
            RestAPIBuilder.access$setClientCallback$cp(function2);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RestAPIBuilder(String str, CookieJar2 cookieJar2) {
        Intrinsics3.checkNotNullParameter(str, "baseApiUrl");
        Intrinsics3.checkNotNullParameter(cookieJar2, "cookieJar");
        this.baseApiUrl = str;
        this.cookieJar = cookieJar2;
    }

    public static final /* synthetic */ Function2 access$getClientCallback$cp() {
        return clientCallback;
    }

    public static final /* synthetic */ void access$setClientCallback$cp(Function2 function2) {
        clientCallback = function2;
    }

    public static /* synthetic */ Object build$default(RestAPIBuilder restAPIBuilder, Class cls, boolean z2, long j, List list, String str, boolean z3, String str2, int i, Object obj) {
        return restAPIBuilder.build(cls, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? 10000L : j, (i & 8) != 0 ? null : list, (i & 16) == 0 ? str : null, (i & 32) != 0 ? true : z3, (i & 64) != 0 ? CONTENT_TYPE_JSON : str2);
    }

    private final <T> T buildApi(OkHttpClient client, Class<T> api, String baseApiUrl, boolean serializeNulls, boolean addVersion, String contentType) throws SecurityException {
        String str;
        String str2;
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.f13097c = FieldNamingPolicy.f13091m;
        Intrinsics3.checkNotNullExpressionValue(gsonBuilder, "GsonBuilder()\n        .s…ER_CASE_WITH_UNDERSCORES)");
        TypeAdapterRegistrar.m147a(gsonBuilder);
        gsonBuilder.f13099e.add(new Model.TypeAdapterFactory());
        gsonBuilder.f13099e.add(UserExperimentDto.TypeAdapterFactory.INSTANCE);
        gsonBuilder.m6852b(RestAPIParams.ChannelPosition.class, new RestAPIParams.ChannelPosition.Serializer());
        if (serializeNulls) {
            gsonBuilder.f13101g = true;
        }
        Gson gsonM6851a = gsonBuilder.m6851a();
        if (addVersion) {
            str2 = "v9/";
            str = baseApiUrl;
        } else {
            str = baseApiUrl;
            str2 = "";
        }
        String strM883w = outline.m883w(str, str2);
        Platform3 platform3 = Platform3.f26614a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Objects.requireNonNull(client, "client == null");
        arrayList2.add(new RxJavaCallAdapterFactory(null, false));
        arrayList.add(new ScalarsConverterFactory());
        Intrinsics3.checkNotNullExpressionValue(gsonM6851a, "gson");
        arrayList.add(new PayloadJSON.ConverterFactory(gsonM6851a));
        if (Intrinsics3.areEqual(contentType, CONTENT_TYPE_JSON)) {
            arrayList.add(new GsonConverterFactory(gsonM6851a));
        }
        Objects.requireNonNull(strM883w, "baseUrl == null");
        Intrinsics3.checkParameterIsNotNull(strM883w, "$this$toHttpUrl");
        HttpUrl.a aVar = new HttpUrl.a();
        aVar.m10412e(null, strM883w);
        HttpUrl httpUrlM10409b = aVar.m10409b();
        if (!"".equals(httpUrlM10409b.f25981i.get(r4.size() - 1))) {
            throw new IllegalArgumentException("baseUrl must end in /: " + httpUrlM10409b);
        }
        Executor executorMo10716a = platform3.mo10716a();
        ArrayList arrayList3 = new ArrayList(arrayList2);
        DefaultCallAdapterFactory defaultCallAdapterFactory = new DefaultCallAdapterFactory(executorMo10716a);
        arrayList3.addAll(platform3.f26615b ? Arrays.asList(CompletableFutureCallAdapterFactory.f26528a, defaultCallAdapterFactory) : Collections.singletonList(defaultCallAdapterFactory));
        ArrayList arrayList4 = new ArrayList(arrayList.size() + 1 + (platform3.f26615b ? 1 : 0));
        arrayList4.add(new BuiltInConverters());
        arrayList4.addAll(arrayList);
        arrayList4.addAll(platform3.f26615b ? Collections.singletonList(OptionalConverterFactory.f26567a) : Collections.emptyList());
        Retrofit2 retrofit22 = new Retrofit2(client, httpUrlM10409b, Collections.unmodifiableList(arrayList4), Collections.unmodifiableList(arrayList3), executorMo10716a, false);
        if (!api.isInterface()) {
            throw new IllegalArgumentException("API declarations must be interfaces.");
        }
        ArrayDeque arrayDeque = new ArrayDeque(1);
        arrayDeque.add(api);
        while (!arrayDeque.isEmpty()) {
            Class<T> cls = (Class) arrayDeque.removeFirst();
            if (cls.getTypeParameters().length != 0) {
                StringBuilder sb = new StringBuilder("Type parameters are unsupported on ");
                sb.append(cls.getName());
                if (cls != api) {
                    sb.append(" which is an interface of ");
                    sb.append(api.getName());
                }
                throw new IllegalArgumentException(sb.toString());
            }
            Collections.addAll(arrayDeque, cls.getInterfaces());
        }
        if (retrofit22.f26679g) {
            Platform3 platform32 = Platform3.f26614a;
            for (Method method : api.getDeclaredMethods()) {
                if (!(platform32.f26615b && method.isDefault()) && !Modifier.isStatic(method.getModifiers())) {
                    retrofit22.m10726b(method);
                }
            }
        }
        return (T) Proxy.newProxyInstance(api.getClassLoader(), new Class[]{api}, new Retrofit(retrofit22, api));
    }

    public static /* synthetic */ Object buildApi$default(RestAPIBuilder restAPIBuilder, OkHttpClient okHttpClient, Class cls, String str, boolean z2, boolean z3, String str2, int i, Object obj) {
        return restAPIBuilder.buildApi(okHttpClient, cls, str, (i & 8) != 0 ? false : z2, z3, str2);
    }

    private final OkHttpClient buildOkHttpClient(Long timeoutMillis, List<? extends Interceptor> interceptors) {
        OkHttpClient.a aVar = new OkHttpClient.a();
        if (interceptors != null) {
            for (Interceptor interceptor : interceptors) {
                Intrinsics3.checkParameterIsNotNull(interceptor, "interceptor");
                aVar.f26031c.add(interceptor);
            }
        }
        if (timeoutMillis != null) {
            long jLongValue = timeoutMillis.longValue();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            aVar.m10420a(jLongValue, timeUnit);
            long jLongValue2 = timeoutMillis.longValue();
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f26054z = Util7.m10121b("timeout", jLongValue2, timeUnit);
            long jLongValue3 = timeoutMillis.longValue();
            Intrinsics3.checkParameterIsNotNull(timeUnit, "unit");
            aVar.f26052x = Util7.m10121b("timeout", jLongValue3, timeUnit);
        }
        CookieJar2 cookieJar2 = this.cookieJar;
        Intrinsics3.checkParameterIsNotNull(cookieJar2, "cookieJar");
        aVar.f26038j = cookieJar2;
        return new OkHttpClient(aVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OkHttpClient buildOkHttpClient$default(RestAPIBuilder restAPIBuilder, Long l, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return restAPIBuilder.buildOkHttpClient(l, list);
    }

    public final <T> T build(Class<T> apiDefinition, boolean serializeNulls, long timeoutMillis, List<? extends Interceptor> interceptors, String clientName, boolean addVersion, String contentType) {
        Intrinsics3.checkNotNullParameter(apiDefinition, "apiDefinition");
        Intrinsics3.checkNotNullParameter(contentType, "contentType");
        OkHttpClient okHttpClientBuildOkHttpClient = buildOkHttpClient(Long.valueOf(timeoutMillis), interceptors);
        if (clientName != null) {
            clientCallback.invoke(clientName, okHttpClientBuildOkHttpClient);
        }
        return (T) buildApi(okHttpClientBuildOkHttpClient, apiDefinition, this.baseApiUrl, serializeNulls, addVersion, contentType);
    }
}
