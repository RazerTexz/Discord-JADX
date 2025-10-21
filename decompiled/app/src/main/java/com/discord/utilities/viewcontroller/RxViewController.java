package com.discord.utilities.viewcontroller;

import android.content.Context;
import android.view.View;
import androidx.annotation.MainThread;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$ObjectRef;
import rx.Observable;
import rx.Subscription;

/* compiled from: RxViewController.kt */
/* loaded from: classes2.dex */
public abstract class RxViewController<V extends View, T> {
    private Subscription subscription;
    private final V view;

    /* compiled from: RxViewController.kt */
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$bind$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<T, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass1) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(T t) {
            RxViewController.this.configureView(t);
        }
    }

    /* compiled from: RxViewController.kt */
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<T, Boolean> {
        public final /* synthetic */ View $view;

        public AnonymousClass1(View view) {
            this.$view = view;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Boolean call(Object obj) {
            return call((AnonymousClass1<T, R>) obj);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // j0.k.Func1
        public final Boolean call(T t) {
            return Boolean.valueOf(this.$view.isAttachedToWindow());
        }
    }

    /* compiled from: RxViewController.kt */
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public final /* synthetic */ Ref$ObjectRef $subscriptionResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Ref$ObjectRef ref$ObjectRef) {
            super(1);
            this.$subscriptionResult = ref$ObjectRef;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, Traits.Payment.Type.SUBSCRIPTION);
            this.$subscriptionResult.element = subscription;
        }
    }

    /* compiled from: RxViewController.kt */
    /* renamed from: com.discord.utilities.viewcontroller.RxViewController$connectViewRx$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<T, Unit> {
        public final /* synthetic */ Function1 $onNext;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Function1 function1) {
            super(1);
            this.$onNext = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2((AnonymousClass3) obj);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
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
        Observable<T> observableA0 = observable.a0(new ViewDetachedFromWindowObservable(view).observe());
        Intrinsics3.checkNotNullExpressionValue(observableA0, "observable\n        .take…servable(view).observe())");
        Observable<T> observableY = ObservableExtensionsKt.ui(ObservableExtensionsKt.computationLatest(observableA0)).y(new AnonymousClass1(view));
        Intrinsics3.checkNotNullExpressionValue(observableY, "observable\n        .take…view.isAttachedToWindow }");
        ObservableExtensionsKt.appSubscribe$default(observableY, getClass(), (Context) null, new AnonymousClass2(ref$ObjectRef), (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(onNext), 58, (Object) null);
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
        this.subscription = connectViewRx(this.view, observeState(), new AnonymousClass1());
    }

    public abstract void configureView(T viewState);

    public final V getView() {
        return this.view;
    }

    public abstract Observable<T> observeState();
}
