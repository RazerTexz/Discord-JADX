package com.discord.utilities.rx;

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
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.a.r;
import j0.p.a;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class ObservableExtensionsKt {

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function0<Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$appSubscribe$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function0<Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$bindToComponentLifecycle$2, reason: invalid class name */
    public static final class AnonymousClass2 implements Action0 {
        public final /* synthetic */ MGRecyclerAdapterSimple $adapter;

        public AnonymousClass2(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
            this.$adapter = mGRecyclerAdapterSimple;
        }

        @Override // rx.functions.Action0
        public final void call() {
            MGRecyclerAdapterSimple mGRecyclerAdapterSimple = this.$adapter;
            if (mGRecyclerAdapterSimple != null) {
                mGRecyclerAdapterSimple.unsubscribeFromUpdates();
            }
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterIs$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<Object, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.b
        public final Boolean call(Object obj) {
            m.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            return Boolean.valueOf(obj instanceof Object);
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call(obj);
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterIs$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Object, T> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j0.k.b
        public final T call(Object obj) {
            m.reifiedOperationMarker(1, ExifInterface.GPS_DIRECTION_TRUE);
            return obj;
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<T, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.b
        public final Boolean call(T t) {
            return Boolean.valueOf(t != null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call(obj);
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$filterNull$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<T, T> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public final T call(T t) {
            m.checkNotNull(t);
            return t;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$toMap$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R, K, V> implements b<Pair<? extends K, ? extends V>, K> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Pair) obj);
        }

        public final K call(Pair<? extends K, ? extends V> pair) {
            return pair.getFirst();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [V, K] */
    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$toMap$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R, K, V> implements b<Pair<? extends K, ? extends V>, V> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Pair) obj);
        }

        public final V call(Pair<? extends K, ? extends V> pair) {
            return pair.getSecond();
        }
    }

    /* compiled from: ObservableExtensions.kt */
    /* renamed from: com.discord.utilities.rx.ObservableExtensionsKt$withDimmer$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public final /* synthetic */ DimmerView $dimmer;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DimmerView dimmerView) {
            super(1);
            this.$dimmer = dimmerView;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            DimmerView dimmerView = this.$dimmer;
            if (dimmerView != null) {
                DimmerView.setDimmed$default(dimmerView, z2, false, 2, null);
            }
        }
    }

    public static final <T> void appSubscribe(Observable<T> observable, Class<?> cls, Context context, Function1<? super Subscription, Unit> function1, Function1<? super Error, Unit> function12, Function0<Unit> function0, Function0<Unit> function02, Function1<? super T, Unit> function13) {
        m.checkNotNullParameter(observable, "$this$appSubscribe");
        m.checkNotNullParameter(cls, "errorClass");
        m.checkNotNullParameter(function0, "onCompleted");
        m.checkNotNullParameter(function02, "onTerminated");
        m.checkNotNullParameter(function13, "onNext");
        String simpleName = cls.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "errorClass.simpleName");
        appSubscribe(observable, context, simpleName, function1, function13, function12, function0, function02);
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Class cls, Context context, Function1 function1, Function1 function12, Function0 function0, Function0 function02, Function1 function13, int i, Object obj) {
        appSubscribe(observable, (Class<?>) cls, (i & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), (Function1<? super Error, Unit>) ((i & 8) != 0 ? null : function12), (Function0<Unit>) ((i & 16) != 0 ? AnonymousClass1.INSTANCE : function0), (Function0<Unit>) ((i & 32) != 0 ? AnonymousClass2.INSTANCE : function02), function13);
    }

    public static final <T> Observable<T> bindToComponentLifecycle(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        m.checkNotNullParameter(observable, "$this$bindToComponentLifecycle");
        m.checkNotNullParameter(appComponent, "appComponent");
        Observable<T> observableA0 = observable.a0(appComponent.getUnsubscribeSignal());
        if (appComponent instanceof Fragment) {
            observableA0 = observableA0.y(new ObservableExtensionsKt$bindToComponentLifecycle$$inlined$let$lambda$1(appComponent));
        }
        Observable<T> observableW = observableA0.w(new AnonymousClass2(mGRecyclerAdapterSimple));
        m.checkNotNullExpressionValue(observableW, "takeUntil(appComponent.u…beFromUpdates()\n        }");
        return observableW;
    }

    public static /* synthetic */ Observable bindToComponentLifecycle$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return bindToComponentLifecycle(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> computationBuffered(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$computationBuffered");
        Observable<T> observableJ = observable.K().X(a.a()).J(a.a());
        m.checkNotNullExpressionValue(observableJ, "onBackpressureBuffer()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final <T> Observable<T> computationLatest(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$computationLatest");
        Observable<T> observableJ = observable.L().X(a.a()).J(a.a());
        m.checkNotNullExpressionValue(observableJ, "onBackpressureLatest()\n …Schedulers.computation())");
        return observableJ;
    }

    public static final /* synthetic */ <T> Observable<T> filterIs(Observable<?> observable) {
        m.checkNotNullParameter(observable, "$this$filterIs");
        m.needClassReification();
        Observable<?> observableY = observable.y(AnonymousClass1.INSTANCE);
        m.needClassReification();
        Observable<T> observable2 = (Observable<T>) observableY.G(AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observable2, "filter { it is T }.map { it as T }");
        return observable2;
    }

    public static final /* synthetic */ <T> Observable<T> filterNull(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$filterNull");
        Observable<T> observable2 = (Observable<T>) observable.y(AnonymousClass1.INSTANCE).G(AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observable2, "filter { it != null }.map { it!! }");
        return observable2;
    }

    public static final <T> Observable<T> leadingEdgeThrottle(Observable<T> observable, long j, TimeUnit timeUnit) {
        m.checkNotNullParameter(observable, "$this$leadingEdgeThrottle");
        m.checkNotNullParameter(timeUnit, "timeUnit");
        Observable<T> observableH0 = Observable.h0(new r(observable.j, new LeadingEdgeThrottle(j, timeUnit)));
        m.checkNotNullExpressionValue(observableH0, "lift(LeadingEdgeThrottle…indowDuration, timeUnit))");
        return observableH0;
    }

    public static final <T> Observable<T> restSubscribeOn(Observable<T> observable, boolean z2) {
        m.checkNotNullParameter(observable, "$this$restSubscribeOn");
        Observable<T> observableX = observable.X(a.c());
        if (z2) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            m.checkNotNullExpressionValue(observableX, "observable");
            observableX = RetryWithDelay.restRetry$default(retryWithDelay, observableX, 0L, null, null, 7, null);
        }
        m.checkNotNullExpressionValue(observableX, "subscribeOn(Schedulers.i… observable\n      }\n    }");
        return observableX;
    }

    public static /* synthetic */ Observable restSubscribeOn$default(Observable observable, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = true;
        }
        return restSubscribeOn(observable, z2);
    }

    public static final <T> Observable<T> takeSingleUntilTimeout(Observable<T> observable, long j, boolean z2) {
        m.checkNotNullParameter(observable, "$this$takeSingleUntilTimeout");
        Observable<T> observableZ = observable.Z(1);
        Observable<T> observableC0 = z2 ? observableZ.c0(j, TimeUnit.MILLISECONDS) : observableZ.a0(Observable.d0(j, TimeUnit.MILLISECONDS));
        m.checkNotNullExpressionValue(observableC0, "take(1).let {\n      if (…LISECONDS))\n      }\n    }");
        return computationLatest(observableC0);
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

    public static final <K, V> Observable<Map<K, V>> toMap(Observable<Pair<K, V>> observable) {
        m.checkNotNullParameter(observable, "$this$toMap");
        Observable<Map<K, V>> observableG0 = observable.g0(AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG0, "toMap({ it.first }, { it.second })");
        return observableG0;
    }

    public static final <T> Observable<T> ui(Observable<T> observable) {
        m.checkNotNullParameter(observable, "$this$ui");
        Observable<T> observableJ = observable.J(j0.j.b.a.a());
        m.checkNotNullExpressionValue(observableJ, "observeOn(AndroidSchedulers.mainThread())");
        return observableJ;
    }

    public static /* synthetic */ Observable ui$default(Observable observable, AppComponent appComponent, MGRecyclerAdapterSimple mGRecyclerAdapterSimple, int i, Object obj) {
        if ((i & 2) != 0) {
            mGRecyclerAdapterSimple = null;
        }
        return ui(observable, appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> Observable<T> withDimmer(Observable<T> observable, DimmerView dimmerView, long j) {
        m.checkNotNullParameter(observable, "$this$withDimmer");
        Observable<T> observableH0 = Observable.h0(new r(observable.j, new OnDelayedEmissionHandler(new AnonymousClass1(dimmerView), j, TimeUnit.MILLISECONDS, null, 8, null)));
        m.checkNotNullExpressionValue(observableH0, "lift(\n        OnDelayedE…LISECONDS\n        )\n    )");
        return observableH0;
    }

    public static /* synthetic */ Observable withDimmer$default(Observable observable, DimmerView dimmerView, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 300;
        }
        return withDimmer(observable, dimmerView, j);
    }

    public static final <T> Observable<T> ui(Observable<T> observable, AppComponent appComponent, MGRecyclerAdapterSimple<?> mGRecyclerAdapterSimple) {
        m.checkNotNullParameter(observable, "$this$ui");
        m.checkNotNullParameter(appComponent, "appComponent");
        return bindToComponentLifecycle(ui(observable), appComponent, mGRecyclerAdapterSimple);
    }

    public static final <T> void appSubscribe(Observable<T> observable, Context context, String str, Function1<? super Subscription, Unit> function1, Function1<? super T, Unit> function12, Function1<? super Error, Unit> function13, Function0<Unit> function0, Function0<Unit> function02) {
        m.checkNotNullParameter(observable, "$this$appSubscribe");
        m.checkNotNullParameter(str, "errorTag");
        m.checkNotNullParameter(function12, "onNext");
        m.checkNotNullParameter(function0, "onCompleted");
        m.checkNotNullParameter(function02, "onTerminated");
        WeakReference weakReference = new WeakReference(context);
        ObservableExtensionsKt$sam$rx_functions_Action1$0 observableExtensionsKt$sam$rx_functions_Action1$0 = new ObservableExtensionsKt$sam$rx_functions_Action1$0(function12);
        ObservableExtensionsKt$appSubscribe$subscription$1 observableExtensionsKt$appSubscribe$subscription$1 = new ObservableExtensionsKt$appSubscribe$subscription$1(str, function13, weakReference, function02);
        ObservableExtensionsKt$appSubscribe$subscription$2 observableExtensionsKt$appSubscribe$subscription$2 = new ObservableExtensionsKt$appSubscribe$subscription$2(function0, function02);
        Objects.requireNonNull(observable);
        Subscription subscriptionU = observable.U(new j0.l.e.b(observableExtensionsKt$sam$rx_functions_Action1$0, observableExtensionsKt$appSubscribe$subscription$1, observableExtensionsKt$appSubscribe$subscription$2));
        if (function1 != null) {
            m.checkNotNullExpressionValue(subscriptionU, Traits.Payment.Type.SUBSCRIPTION);
            function1.invoke(subscriptionU);
        }
    }

    public static /* synthetic */ void appSubscribe$default(Observable observable, Context context, String str, Function1 function1, Function1 function12, Function1 function13, Function0 function0, Function0 function02, int i, Object obj) {
        appSubscribe(observable, (i & 1) != 0 ? null : context, str, (Function1<? super Subscription, Unit>) ((i & 4) != 0 ? null : function1), function12, (Function1<? super Error, Unit>) ((i & 16) != 0 ? null : function13), (Function0<Unit>) ((i & 32) != 0 ? AnonymousClass3.INSTANCE : function0), (Function0<Unit>) ((i & 64) != 0 ? AnonymousClass4.INSTANCE : function02));
    }
}
