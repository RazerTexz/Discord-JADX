package com.discord.stores.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.net.UnknownHostException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import retrofit2.HttpException;
import retrofit2.Response;
import rx.Observable;
import rx.functions.Action1;

/* compiled from: RestCallState.kt */
/* renamed from: com.discord.stores.utilities.RestCallStateKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class RestCallState5 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass1<T>) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$resultHandler.invoke(new RestCallState6(t));
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            this.$resultHandler.invoke(new RestCallState3(error));
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<RestCallState4, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState4 restCallState4) {
            invoke2(restCallState4);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState4 restCallState4) {
            Intrinsics3.checkNotNullParameter(restCallState4, "it");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends Lambda implements Function1<RestCallState3<? extends T>, Unit> {
        public final /* synthetic */ Context $context;

        /* compiled from: RestCallState.kt */
        /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements Runnable {
            public final /* synthetic */ RestCallState3 $failure;

            public AnonymousClass1(RestCallState3 restCallState3) {
                this.$failure = restCallState3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.$failure.getError().showToasts(AnonymousClass2.this.$context);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState3) obj);
            return Unit.a;
        }

        public final void invoke(RestCallState3<? extends T> restCallState3) {
            Intrinsics3.checkNotNullParameter(restCallState3, "failure");
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(restCallState3));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$3, reason: invalid class name */
    public static final class AnonymousClass3<T> extends Lambda implements Function1<RestCallState6<? extends T>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState6) obj);
            return Unit.a;
        }

        public final void invoke(RestCallState6<? extends T> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Response<T>, T> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f3824b;
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Response<T>> {
        public final /* synthetic */ Function1 $networkActionProvider;
        public final /* synthetic */ AnalyticsUtils.Tracker $tracker;

        public AnonymousClass2(Function1 function1, AnalyticsUtils.Tracker tracker) {
            this.$networkActionProvider = function1;
            this.$tracker = tracker;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Response) obj);
        }

        public final void call(Response<T> response) {
            TrackNetworkMetadata2 schema;
            Intrinsics3.checkNotNullExpressionValue(response, "response");
            if (!response.a()) {
                throw new HttpException(response);
            }
            Request request = RestCallState5.getRequest(response);
            if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallState5.getSchema(this.$networkActionProvider, new TrackNetworkMetadata(request.url.l, request.method, Long.valueOf(response.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f3824b)) == null) {
                return;
            }
            this.$tracker.track(schema);
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Throwable> {
        public final /* synthetic */ Function1 $networkActionProvider;
        public final /* synthetic */ AnalyticsUtils.Tracker $tracker;

        public AnonymousClass3(Function1 function1, AnalyticsUtils.Tracker tracker) {
            this.$networkActionProvider = function1;
            this.$tracker = tracker;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
        /* renamed from: call, reason: avoid collision after fix types in other method */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void call2(Throwable th) {
            TrackNetworkMetadata trackNetworkMetadata;
            TrackNetworkMetadata2 schema$default;
            Request request;
            if (GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled()) {
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    Response<?> response = httpException.j;
                    if (response == null || (request = RestCallState5.getRequest(response)) == null) {
                        trackNetworkMetadata = null;
                    } else {
                        String str = request.url.l;
                        String str2 = request.method;
                        Long lValueOf = httpException.j != null ? Long.valueOf(r0.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                        Long lValueOf2 = httpException.j != null ? Long.valueOf(r0.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                        Response<?> response2 = httpException.j;
                        String str3 = response2 != null ? response2.a.message : null;
                        if (str3 == null) {
                            str3 = "";
                        }
                        trackNetworkMetadata = new TrackNetworkMetadata(str, str2, lValueOf, lValueOf2, str3);
                    }
                } else if (th instanceof UnknownHostException) {
                    trackNetworkMetadata = new TrackNetworkMetadata(null, null, null, null, ((UnknownHostException) th).getLocalizedMessage(), 15);
                }
                if (trackNetworkMetadata == null || (schema$default = RestCallState5.getSchema$default(this.$networkActionProvider, trackNetworkMetadata, null, 4, null)) == null) {
                    return;
                }
                this.$tracker.track(schema$default);
            }
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements Func1<Response<T>, T> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f3824b;
        }
    }

    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$executeRequest");
        Intrinsics3.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(RestCallState4.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), observable.getClass(), (Context) null, (Function1) null, new AnonymousClass2(function1), (Function0) null, (Function0) null, new AnonymousClass1(function1), 54, (Object) null);
    }

    public static final Request getRequest(Response<?> response) {
        Intrinsics3.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadata2 getSchema(Function1<? super T, ? extends TrackNetworkMetadata2> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadata2 trackNetworkMetadata2Invoke = function1.invoke(t);
        if (trackNetworkMetadata2Invoke != null) {
            trackNetworkMetadata2Invoke.b(trackNetworkMetadata);
        }
        return trackNetworkMetadata2Invoke;
    }

    public static /* synthetic */ TrackNetworkMetadata2 getSchema$default(Function1 function1, TrackNetworkMetadata trackNetworkMetadata, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return getSchema(function1, trackNetworkMetadata, obj);
    }

    @MainThread
    public static final <T> void handleResponse(RestCallState<? extends T> restCallState, Context context, Function1<? super RestCallState4, Unit> function1, Function1<? super RestCallState3<? extends T>, Unit> function12, Function1<? super RestCallState6<? extends T>, Unit> function13) {
        Intrinsics3.checkNotNullParameter(restCallState, "$this$handleResponse");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(function1, "onLoading");
        Intrinsics3.checkNotNullParameter(function12, "onFailure");
        Intrinsics3.checkNotNullParameter(function13, "onSuccess");
        if (restCallState instanceof RestCallState4) {
            function1.invoke(restCallState);
        } else if (restCallState instanceof RestCallState6) {
            function13.invoke(restCallState);
        } else if (restCallState instanceof RestCallState3) {
            function12.invoke(restCallState);
        }
    }

    public static /* synthetic */ void handleResponse$default(RestCallState restCallState, Context context, Function1 function1, Function1 function12, Function1 function13, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 4) != 0) {
            function12 = new AnonymousClass2(context);
        }
        if ((i & 8) != 0) {
            function13 = AnonymousClass3.INSTANCE;
        }
        handleResponse(restCallState, context, function1, function12, function13);
    }

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, Function1<? super T, ? extends TrackNetworkMetadata2> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$logNetworkAction");
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtils.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.G(AnonymousClass1.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.u(new AnonymousClass2(function1, tracker)).t(new AnonymousClass3(function1, tracker)).G(AnonymousClass4.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
