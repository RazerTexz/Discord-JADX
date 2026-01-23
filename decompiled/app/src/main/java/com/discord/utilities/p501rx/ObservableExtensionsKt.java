package com.discord.utilities.p501rx;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.app.AppComponent;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p638j.p640b.AndroidSchedulers;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p647e.ActionSubscriber;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* JADX INFO: compiled from: ObservableExtensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableExtensionsKt {

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68791 extends Lambda implements Function0<Unit> {
        public static final C68791 INSTANCE = new C68791();

        public C68791() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68802 extends Lambda implements Function0<Unit> {
        public static final C68802 INSTANCE = new C68802();

        public C68802() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$3 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68813 extends Lambda implements Function0<Unit> {
        public static final C68813 INSTANCE = new C68813();

        public C68813() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$4 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68824 extends Lambda implements Function0<Unit> {
        public static final C68824 INSTANCE = new C68824();

        public C68824() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$bindToComponentLifecycle$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68842 implements Action0 {
        public final /* synthetic */ MGRecyclerAdapterSimple $adapter;

        public C68842(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
            this.$adapter = mGRecyclerAdapterSimple;
        }

        @Override // p658rx.functions.Action0
        public final void call() {
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = this.$adapter;
            if (mGRecyclerAdapterSimple != null) {
                mGRecyclerAdapterSimple.unsubscribeFromUpdates();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterIs$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68851<T, R> implements Func1<Object, Boolean> {
        public static final C68851 INSTANCE = new C68851();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p637j0.p641k.Func1
        public final Boolean call(Object obj) {
            Intrinsics3.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            return Boolean.valueOf(obj instanceof Object);
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call(obj);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterIs$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68862<T, R> implements Func1<Object, T> {
        public static final C68862 INSTANCE = new C68862();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p637j0.p641k.Func1
        public final T call(Object obj) {
            Intrinsics3.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68871<T, R> implements Func1<T, Boolean> {
        public static final C68871 INSTANCE = new C68871();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p637j0.p641k.Func1
        public final Boolean call(T t) {
            return Boolean.valueOf(t != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call(obj);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68882<T, R> implements Func1<T, T> {
        public static final C68882 INSTANCE = new C68882();

        @Override // p637j0.p641k.Func1
        public final T call(T t) {
            Intrinsics3.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$toMap$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68891<T, R, K, V> implements Func1<Tuples2<? extends K, ? extends V>, K> {
        public static final C68891 INSTANCE = new C68891();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Tuples2) obj);
        }

        public final K call(Tuples2<? extends K, ? extends V> tuples2) {
            return tuples2.getFirst();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$toMap$2 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68902<T, R, K, V> implements Func1<Tuples2<? extends K, ? extends V>, V> {
        public static final C68902 INSTANCE = new C68902();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Tuples2) obj);
        }

        public final V call(Tuples2<? extends K, ? extends V> tuples2) {
            return tuples2.getSecond();
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableExtensionsKt$withDimmer$1 */
    /* JADX INFO: compiled from: ObservableExtensions.kt */
    public static final class C68911 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ DimmerView $dimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C68911(DimmerView dimmerView) {
            super(1);
            this.$dimmer = dimmerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            DimmerView dimmerView = this.$dimmer;
            if (dimmerView != null) {
                DimmerView.setDimmed$default(dimmerView, z2, false, 2, null);
            }
        }
    }

    public static final <T> void appSubscribe(Observable<T> observable, Class<?> cls, Context context, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, Function0<Unit> function0, Function0<Unit> function02, Function1<? super T, Unit> function13) {
        Intrinsics3.checkNotNullParameter(observable, "$this$appSubscribe");
        Intrinsics3.checkNotNullParameter(cls, "errorClass");
        Intrinsics3.checkNotNullParameter(function0, "onCompleted");
        Intrinsics3.checkNotNullParameter(function02, "onTerminated");
        Intrinsics3.checkNotNullParameter(function13, "onNext");
        String simpleName = cls.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        appSubscribe(observable, context, simpleName, function1, function13, function12, function0, function02);
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Class cls, Context context, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function1 function13, int i, Object obj) {
        appSubscribe(observable, (Class<?>) cls, (i & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), (Function1<? super Error, Unit>) ((i & 8) != 0 ? null : function12), (Function0<Unit>) ((i & 16) != 0 ? C68791.INSTANCE : function0), (Function0<Unit>) ((i & 32) != 0 ? C68802.INSTANCE : function02), function13);
    }

    public static final <T> Observable<T> bindToComponentLifecycle(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        Intrinsics3.checkNotNullParameter(observable, "$this$bindToComponentLifecycle");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Observable<T> observableM11102a0 = observable.m11102a0(appComponent.getUnsubscribeSignal());
        if (appComponent instanceof Fragment) {
            observableM11102a0 = observableM11102a0.m11118y(new C6883x1d5b58ff(appComponent));
        }
        Observable<T> observableM11117w = observableM11102a0.m11117w(new C68842(mGRecyclerAdapterSimple));
        Intrinsics3.checkNotNullExpressionValue(observableM11117w, "takeUntil(appComponent.u…beFromUpdates()\n        }");
        return observableM11117w;
    }

    public static /* synthetic */ Observable bindToComponentLifecycle$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return bindToComponentLifecycle(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> computationBuffered(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$computationBuffered");
        Observable<T> observableM11084J = observable.m11085K().m11098X(Schedulers2.m10873a()).m11084J(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11084J, "onBackpressureBuffer()\n …Schedulers.computation())");
        return observableM11084J;
    }

    public static final <T> Observable<T> computationLatest(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$computationLatest");
        Observable<T> observableM11084J = observable.m11086L().m11098X(Schedulers2.m10873a()).m11084J(Schedulers2.m10873a());
        Intrinsics3.checkNotNullExpressionValue(observableM11084J, "onBackpressureLatest()\n …Schedulers.computation())");
        return observableM11084J;
    }

    public static final /* synthetic */ <T> Observable<T> filterIs(Observable<?> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$filterIs");
        Intrinsics3.needClassReification();
        Observable<?> observableM11118y = observable.m11118y(C68851.INSTANCE);
        Intrinsics3.needClassReification();
        Observable<T> observable2 = (Observable<T>) observableM11118y.m11083G(C68862.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable2, "filter { it is T }.map { it as T }");
        return observable2;
    }

    public static final /* synthetic */ <T> Observable<T> filterNull(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$filterNull");
        Observable<T> observable2 = (Observable<T>) observable.m11118y(C68871.INSTANCE).m11083G(C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observable2, "filter { it != null }.map { it!! }");
        return observable2;
    }

    public static final <T> Observable<T> leadingEdgeThrottle(Observable<T> observable, long j, TimeUnit timeUnit) {
        Intrinsics3.checkNotNullParameter(observable, "$this$leadingEdgeThrottle");
        Intrinsics3.checkNotNullParameter(timeUnit, "timeUnit");
        Observable<T> observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(observable.f27640j, new LeadingEdgeThrottle(j, timeUnit)));
        Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "lift(LeadingEdgeThrottle…indowDuration, timeUnit))");
        return observableM11074h0;
    }

    public static final <T> Observable<T> restSubscribeOn(Observable<T> observable, boolean z2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$restSubscribeOn");
        Observable<T> observableM11098X = observable.m11098X(Schedulers2.m10875c());
        if (z2) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(observableM11098X, "observable");
            observableM11098X = RetryWithDelay.restRetry$default(retryWithDelay, observableM11098X, 0L, null, null, 7, null);
        }
        Intrinsics3.checkNotNullExpressionValue(observableM11098X, "subscribeOn(Schedulers.i… observable\n      }\n    }");
        return observableM11098X;
    }

    public static /* synthetic */ Observable restSubscribeOn$default(Observable observable, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return restSubscribeOn(observable, z2);
    }

    public static final <T> Observable<T> takeSingleUntilTimeout(Observable<T> observable, long j, boolean z2) {
        Intrinsics3.checkNotNullParameter(observable, "$this$takeSingleUntilTimeout");
        Observable<T> observableM11100Z = observable.m11100Z(1);
        Observable<T> observableM11104c0 = z2 ? observableM11100Z.m11104c0(j, TimeUnit.MILLISECONDS) : observableM11100Z.m11102a0(Observable.m11068d0(j, TimeUnit.MILLISECONDS));
        Intrinsics3.checkNotNullExpressionValue(observableM11104c0, "take(1).let {\n      if (…LISECONDS))\n      }\n    }");
        return computationLatest(observableM11104c0);
    }

    public static /* synthetic */ Observable takeSingleUntilTimeout$default(Observable observable, long j, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 5000;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return takeSingleUntilTimeout(observable, j, z2);
    }

    public static final <K, V> Observable<Map<K, V>> toMap(Observable<Tuples2<K, V>> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$toMap");
        Observable<Map<K, V>> observableM11106g0 = observable.m11106g0(C68891.INSTANCE, C68902.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11106g0, "toMap({ it.first }, { it.second })");
        return observableM11106g0;
    }

    /* JADX INFO: renamed from: ui */
    public static final <T> Observable<T> m8518ui(Observable<T> observable) {
        Intrinsics3.checkNotNullParameter(observable, "$this$ui");
        Observable<T> observableM11084J = observable.m11084J(AndroidSchedulers.m10738a());
        Intrinsics3.checkNotNullExpressionValue(observableM11084J, "observeOn(AndroidSchedulers.mainThread())");
        return observableM11084J;
    }

    public static /* synthetic */ Observable ui$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return m8519ui(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> withDimmer(Observable<T> observable, DimmerView dimmerView, long j) {
        Intrinsics3.checkNotNullParameter(observable, "$this$withDimmer");
        Observable<T> observableM11074h0 = Observable.m11074h0(new OnSubscribeLift(observable.f27640j, new OnDelayedEmissionHandler(new C68911(dimmerView), j, TimeUnit.MILLISECONDS, null, 8, null)));
        Intrinsics3.checkNotNullExpressionValue(observableM11074h0, "lift(\n        OnDelayedE…LISECONDS\n        )\n    )");
        return observableM11074h0;
    }

    public static /* synthetic */ Observable withDimmer$default(Observable observable, DimmerView dimmerView, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        return withDimmer(observable, dimmerView, j);
    }

    /* JADX INFO: renamed from: ui */
    public static final <T> Observable<T> m8519ui(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        Intrinsics3.checkNotNullParameter(observable, "$this$ui");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        return bindToComponentLifecycle(m8518ui(observable), appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> void appSubscribe(Observable<T> observable, Context context, String str, Function1<? super Subscription, Unit> function1, Function1<? super T, Unit> function12, Function1<? super Error, Unit> function13, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics3.checkNotNullParameter(observable, "$this$appSubscribe");
        Intrinsics3.checkNotNullParameter(str, "errorTag");
        Intrinsics3.checkNotNullParameter(function12, "onNext");
        Intrinsics3.checkNotNullParameter(function0, "onCompleted");
        Intrinsics3.checkNotNullParameter(function02, "onTerminated");
        WeakReference weakReference = new WeakReference(context);
        ObservableExtensionsKt$sam$rx_functions_Action1$0 observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function12);
        ObservableExtensionsKt$appSubscribe$subscription$1 observableExtensionsKt$appSubscribe$subscription$1 = new ObservableExtensionsKt$appSubscribe$subscription$1(str, function13, weakReference, function02);
        ObservableExtensionsKt$appSubscribe$subscription$2 observableExtensionsKt$appSubscribe$subscription$2 = new ObservableExtensionsKt$appSubscribe$subscription$2(function0, function02);
        Objects.requireNonNull(observable);
        Subscription subscriptionM11095U = observable.m11095U(new ActionSubscriber(observableExtensionsKt$sam$rx_functions_Action1$0, observableExtensionsKt$appSubscribe$subscription$1, observableExtensionsKt$appSubscribe$subscription$2));
        if (function1 != null) {
            Intrinsics3.checkNotNullExpressionValue(subscriptionM11095U, Traits.Payment.Type.SUBSCRIPTION);
            function1.invoke(subscriptionM11095U);
        }
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Context context, String str, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, int i, Object obj) {
        appSubscribe(observable, (i & 1) != 0 ? null : context, str, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), function12, (Function1<? super Error, Unit>) ((i & 16) != 0 ? null : function13), (Function0<Unit>) ((i & 32) != 0 ? C68813.INSTANCE : function0), (Function0<Unit>) ((i & 64) != 0 ? C68824.INSTANCE : function02));
    }
}
