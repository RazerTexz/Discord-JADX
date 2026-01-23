package com.discord.utilities.viewcontroller;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: RxViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class RxViewController<V extends View, T> {
    private Subscription subscription;
    private final V view;

    /* JADX INFO: renamed from: com.discord.utilities.viewcontroller.RxViewController$bind$1 */
    /* JADX INFO: compiled from: RxViewController.kt */
    public static final class C70171 extends Lambda implements Function1<T, Unit> {
        public C70171() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            RxViewController.this.configureView(t);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$1 */
    /* JADX INFO: compiled from: RxViewController.kt */
    public static final class C70181<T, R> implements Func1<T, Boolean> {
        public final /* synthetic */ View $view;

        public C70181(View view) {
            this.$view = view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call(obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p637j0.p641k.Func1
        public final Boolean call(T t) {
            return Boolean.valueOf(this.$view.isAttachedToWindow());
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$2 */
    /* JADX INFO: compiled from: RxViewController.kt */
    public static final class C70192 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ Ref$ObjectRef $subscriptionResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70192(Ref$ObjectRef ref$ObjectRef) {
            super(1);
            this.$subscriptionResult = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            this.$subscriptionResult.element = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$3 */
    /* JADX INFO: compiled from: RxViewController.kt */
    public static final class C70203 extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C70203(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            this.$onNext.invoke(t);
        }
    }

    public RxViewController(V v) {
        Intrinsics3.checkNotNullParameter(v, "view");
        this.view = v;
    }

    private final <T> Subscription connectViewRx(View view, Observable<T> observable, Function1<? super T, Unit> onNext) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = null;
        Observable<T> observableM11102a0 = observable.m11102a0(new ViewDetachedFromWindowObservable(view).observe());
        Intrinsics3.checkNotNullExpressionValue(observableM11102a0, "observable\n        .take…servable(view).observe())");
        Observable<T> observableM11118y = ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.computationLatest(observableM11102a0)).m11118y(new C70181(view));
        Intrinsics3.checkNotNullExpressionValue(observableM11118y, "observable\n        .take…view.isAttachedToWindow }");
        ObservableExtensionsKt.appSubscribe$default(observableM11118y, getClass(), (Context) null, new C70192(ref$ObjectRef), (Function1) null, (Function0) null, (Function0) null, new C70203(onNext), 58, (Object) null);
        T t = ref$ObjectRef.element;
        if (t == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("subscriptionResult");
        }
        return (Subscription) t;
    }

    @MainThread
    public final void bind() {
        Subscription subscription = this.subscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.subscription = connectViewRx(this.view, observeState(), new C70171());
    }

    public abstract void configureView(T viewState);

    public final V getView() {
        return this.view;
    }

    public abstract Observable<T> observeState();
}
