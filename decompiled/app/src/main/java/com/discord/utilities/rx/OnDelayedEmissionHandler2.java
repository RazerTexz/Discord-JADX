package com.discord.utilities.rx;

import android.content.Context;
import d0.z.d.Intrinsics3;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OnDelayedEmissionHandler.kt */
/* renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class OnDelayedEmissionHandler2<T> extends Subscriber<T> {
    public final /* synthetic */ Subscriber $subscriber;
    public final /* synthetic */ OnDelayedEmissionHandler this$0;

    public OnDelayedEmissionHandler2(OnDelayedEmissionHandler onDelayedEmissionHandler, Subscriber subscriber) {
        this.this$0 = onDelayedEmissionHandler;
        this.$subscriber = subscriber;
    }

    private final void tryFinish() {
        Subscription subscriptionAccess$getDelaySubscription$p = OnDelayedEmissionHandler.access$getDelaySubscription$p(this.this$0);
        if (subscriptionAccess$getDelaySubscription$p != null) {
            subscriptionAccess$getDelaySubscription$p.unsubscribe();
        }
        Observable<T> observableJ = new ScalarSynchronousObservable(null).J(OnDelayedEmissionHandler.access$getScheduler$p(this.this$0));
        Intrinsics3.checkNotNullExpressionValue(observableJ, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableJ, OnDelayedEmissionHandler2.class, (Context) null, (Function1) null, new OnDelayedEmissionHandler4(this), (Function0) null, (Function0) null, new OnDelayedEmissionHandler3(this), 54, (Object) null);
    }

    @Override // j0.Observer2
    public void onCompleted() {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onCompleted();
    }

    @Override // j0.Observer2
    public void onError(Throwable e) {
        Intrinsics3.checkNotNullParameter(e, "e");
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onError(e);
    }

    @Override // j0.Observer2
    public void onNext(T t) {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onNext(t);
    }
}
