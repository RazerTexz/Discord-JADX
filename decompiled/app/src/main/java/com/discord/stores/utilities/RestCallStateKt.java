package com.discord.stores.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.analytics.generated.traits.TrackNetworkMetadata;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.AnalyticsUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.testing.TestUtilsKt;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
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
/* loaded from: classes2.dex */
public final class RestCallStateKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends o implements Function1<T, Unit> {
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
            this.$resultHandler.invoke(new Success(t));
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$executeRequest$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Error, Unit> {
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
            m.checkNotNullParameter(error, "error");
            this.$resultHandler.invoke(new Failure(error));
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Loading, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Loading loading) {
            invoke2(loading);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Loading loading) {
            m.checkNotNullParameter(loading, "it");
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2, reason: invalid class name */
    public static final class AnonymousClass2<T> extends o implements Function1<Failure<? extends T>, Unit> {
        public final /* synthetic */ Context $context;

        /* compiled from: RestCallState.kt */
        /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$2$1, reason: invalid class name */
        public static final class AnonymousClass1 implements Runnable {
            public final /* synthetic */ Failure $failure;

            public AnonymousClass1(Failure failure) {
                this.$failure = failure;
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
            invoke((Failure) obj);
            return Unit.a;
        }

        public final void invoke(Failure<? extends T> failure) {
            m.checkNotNullParameter(failure, "failure");
            new Handler(Looper.getMainLooper()).post(new AnonymousClass1(failure));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$handleResponse$3, reason: invalid class name */
    public static final class AnonymousClass3<T> extends o implements Function1<Success<? extends T>, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((Success) obj);
            return Unit.a;
        }

        public final void invoke(Success<? extends T> success) {
            m.checkNotNullParameter(success, "it");
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Response<T>, T> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
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
            TrackNetworkMetadataReceiver schema;
            m.checkNotNullExpressionValue(response, "response");
            if (!response.a()) {
                throw new HttpException(response);
            }
            Request request = RestCallStateKt.getRequest(response);
            if (!GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled() || (schema = RestCallStateKt.getSchema(this.$networkActionProvider, new TrackNetworkMetadata(request.url.l, request.method, Long.valueOf(response.a.com.discord.models.domain.ModelAuditLogEntry.CHANGE_KEY_CODE java.lang.String), null, null, 24), response.f3824b)) == null) {
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
            TrackNetworkMetadataReceiver schema$default;
            Request request;
            if (GrowthTeamFeatures.INSTANCE.isNetworkActionLoggingEnabled()) {
                if (th instanceof HttpException) {
                    HttpException httpException = (HttpException) th;
                    Response<?> response = httpException.j;
                    if (response == null || (request = RestCallStateKt.getRequest(response)) == null) {
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
                if (trackNetworkMetadata == null || (schema$default = RestCallStateKt.getSchema$default(this.$networkActionProvider, trackNetworkMetadata, null, 4, null)) == null) {
                    return;
                }
                this.$tracker.track(schema$default);
            }
        }
    }

    /* compiled from: RestCallState.kt */
    /* renamed from: com.discord.stores.utilities.RestCallStateKt$logNetworkAction$4, reason: invalid class name */
    public static final class AnonymousClass4<T, R> implements b<Response<T>, T> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Response) obj);
        }

        public final T call(Response<T> response) {
            return response.f3824b;
        }
    }

    public static final <T> void executeRequest(Observable<T> observable, Function1<? super RestCallState<? extends T>, Unit> function1) {
        m.checkNotNullParameter(observable, "$this$executeRequest");
        m.checkNotNullParameter(function1, "resultHandler");
        function1.invoke(Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(observable, false, 1, null), observable.getClass(), (Context) null, (Function1) null, new AnonymousClass2(function1), (Function0) null, (Function0) null, new AnonymousClass1(function1), 54, (Object) null);
    }

    public static final Request getRequest(Response<?> response) {
        m.checkNotNullParameter(response, "$this$getRequest");
        okhttp3.Response response2 = response.a;
        Objects.requireNonNull(response2, "null cannot be cast to non-null type okhttp3.Response");
        return response2.request;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <T> TrackNetworkMetadataReceiver getSchema(Function1<? super T, ? extends TrackNetworkMetadataReceiver> function1, TrackNetworkMetadata trackNetworkMetadata, T t) {
        m.checkNotNullParameter(function1, "networkActionProvider");
        TrackNetworkMetadataReceiver trackNetworkMetadataReceiverInvoke = function1.invoke(t);
        if (trackNetworkMetadataReceiverInvoke != null) {
            trackNetworkMetadataReceiverInvoke.b(trackNetworkMetadata);
        }
        return trackNetworkMetadataReceiverInvoke;
    }

    public static /* synthetic */ TrackNetworkMetadataReceiver getSchema$default(Function1 function1, TrackNetworkMetadata trackNetworkMetadata, Object obj, int i, Object obj2) {
        if ((i & 4) != 0) {
            obj = null;
        }
        return getSchema(function1, trackNetworkMetadata, obj);
    }

    @MainThread
    public static final <T> void handleResponse(RestCallState<? extends T> restCallState, Context context, Function1<? super Loading, Unit> function1, Function1<? super Failure<? extends T>, Unit> function12, Function1<? super Success<? extends T>, Unit> function13) {
        m.checkNotNullParameter(restCallState, "$this$handleResponse");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(function1, "onLoading");
        m.checkNotNullParameter(function12, "onFailure");
        m.checkNotNullParameter(function13, "onSuccess");
        if (restCallState instanceof Loading) {
            function1.invoke(restCallState);
        } else if (restCallState instanceof Success) {
            function13.invoke(restCallState);
        } else if (restCallState instanceof Failure) {
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

    public static final <T> Observable<T> logNetworkAction(Observable<Response<T>> observable, Function1<? super T, ? extends TrackNetworkMetadataReceiver> function1) {
        m.checkNotNullParameter(observable, "$this$logNetworkAction");
        m.checkNotNullParameter(function1, "networkActionProvider");
        if (TestUtilsKt.getIS_JUNIT_TEST()) {
            Observable<T> observable2 = (Observable<T>) observable.G(AnonymousClass1.INSTANCE);
            m.checkNotNullExpressionValue(observable2, "map { it.body() }");
            return observable2;
        }
        AnalyticsUtils.Tracker tracker = AnalyticsTracker.INSTANCE.getTracker();
        Observable<T> observable3 = (Observable<T>) observable.u(new AnonymousClass2(function1, tracker)).t(new AnonymousClass3(function1, tracker)).G(AnonymousClass4.INSTANCE);
        m.checkNotNullExpressionValue(observable3, "doOnNext { response ->\n …rectly.\n    it.body()\n  }");
        return observable3;
    }
}
