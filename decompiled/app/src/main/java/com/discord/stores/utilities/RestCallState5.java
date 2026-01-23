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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtils;
import java.net.UnknownHostException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okhttp3.Request;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Action1;
import retrofit2.HttpException;
import retrofit2.Response;

/* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt, reason: use source file name */
/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallState5 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$1 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66371<T> extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66371(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$resultHandler.invoke(new RestCallState6(t));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$2 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66382 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ Function1 $resultHandler;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66382(Function1 function1) {
            super(1);
            this.$resultHandler = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            this.$resultHandler.invoke(new RestCallState3(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$1 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66391 extends Lambda implements Function1<RestCallState4, Unit> {
        public static final C66391 INSTANCE = new C66391();

        public C66391() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RestCallState4 restCallState4) {
            invoke2(restCallState4);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RestCallState4 restCallState4) {
            Intrinsics3.checkNotNullParameter(restCallState4, "it");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66402<T> extends Lambda implements Function1<RestCallState3<? extends T>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: RestCallState.kt */
        public static final class AnonymousClass1 implements Runnable {
            public final /* synthetic */ RestCallState3 $failure;

            public AnonymousClass1(RestCallState3 restCallState3) {
                this.$failure = restCallState3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.$failure.getError().showToasts(C66402.this.$context);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C66402(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState3) obj);
            return Unit.f27425a;
        }

        public final void invoke(RestCallState3<? extends T> restCallState3) {
            Intrinsics3.checkNotNullParameter(restCallState3, "failure");
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(restCallState3));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$3 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66413<T> extends Lambda implements Function1<RestCallState6<? extends T>, Unit> {
        public static final C66413 INSTANCE = new C66413();

        public C66413() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((RestCallState6) obj);
            return Unit.f27425a;
        }

        public final void invoke(RestCallState6<? extends T> restCallState6) {
            Intrinsics3.checkNotNullParameter(restCallState6, "it");
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$1 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66421<T, R> implements Func1<Response<T>, T> {
        public static final C66421 INSTANCE = new C66421();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f27632b;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$2 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66432<T> implements Action1<Response<T>> {
        public final /* synthetic */ Function1 $networkActionProvider;
        public final /* synthetic */ AnalyticsUtils.Tracker $tracker;

        public C66432(Function1 function1, AnalyticsUtils.Tracker tracker) {
            this.$networkActionProvider = function1;
            this.$tracker = tracker;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Response) obj);
        }

        public final void call(Response<T> response) {
            TrackNetworkMetadata2 schema;
            Intrinsics3.checkNotNullExpressionValue(response, "response");
            if (!response.m11057a()) {
                throw new HttpException(response);
            }
            Request request = RestCallState5.getRequest(response);
            if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallState5.getSchema(this.$networkActionProvider, new TrackNetworkMetadata(request.url.f25984l, request.method, Long.valueOf(response.f27631a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f27632b)) == null) {
                return;
            }
            this.$tracker.track(schema);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$3 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66443<T> implements Action1<Throwable> {
        public final /* synthetic */ Function1 $networkActionProvider;
        public final /* synthetic */ AnalyticsUtils.Tracker $tracker;

        public C66443(Function1 function1, AnalyticsUtils.Tracker tracker) {
            this.$networkActionProvider = function1;
            this.$tracker = tracker;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Throwable th) {
            call2(th);
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x006e  */
        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
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
                    Response<?> response = httpException.f27630j;
                    if (response == null || (request = RestCallState5.getRequest(response)) == null) {
                        trackNetworkMetadata = null;
                    } else {
                        String str = request.url.f25984l;
                        String str2 = request.method;
                        Long lValueOf = httpException.f27630j != null ? Long.valueOf(r0.f27631a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                        Long lValueOf2 = httpException.f27630j != null ? Long.valueOf(r0.f27631a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String) : null;
                        Response<?> response2 = httpException.f27630j;
                        String str3 = response2 != null ? response2.f27631a.message : null;
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

    /* JADX INFO: renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$4 */
    /* JADX INFO: compiled from: RestCallState.kt */
    public static final class C66454<T, R> implements Func1<Response<T>, T> {
        public static final C66454 INSTANCE = new C66454();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f27632b;
        }
    }

    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$executeRequest");
        Intrinsics3.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(RestCallState4.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), observable.getClass(), (Context) null, (Function1) null, new C66382(function1), (Function0) null, (Function0) null, new C66371(function1), 54, (Object) null);
    }

    public static final Request getRequest(Response<?> response) {
        Intrinsics3.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.f27631a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadata2 getSchema(Function1<? super T, ? extends TrackNetworkMetadata2> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadata2 trackNetworkMetadata2Invoke = function1.invoke(t);
        if (trackNetworkMetadata2Invoke != null) {
            trackNetworkMetadata2Invoke.mo7529b(trackNetworkMetadata);
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
            function1 = C66391.INSTANCE;
        }
        if ((i & 4) != 0) {
            function12 = new C66402(context);
        }
        if ((i & 8) != 0) {
            function13 = C66413.INSTANCE;
        }
        handleResponse(restCallState, context, function1, function12, function13);
    }

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, Function1<? super T, ? extends TrackNetworkMetadata2> function1) {
        Intrinsics3.checkNotNullParameter(observable, "$this$logNetworkAction");
        Intrinsics3.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtils.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.m11083G(C66421.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.m11115u(new C66432(function1, tracker)).m11114t(new C66443(function1, tracker)).m11083G(C66454.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
