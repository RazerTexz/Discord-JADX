package com.discord.utilities.p501rx;

import android.content.Context;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.Subscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.discord.utilities.rx.OnDelayedEmissionHandler$call$wrappedSubscriber$1, reason: use source file name */
/* JADX INFO: compiled from: OnDelayedEmissionHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
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
        Observable<T> observableM11084J = new ScalarSynchronousObservable(null).m11084J(OnDelayedEmissionHandler.access$getScheduler$p(this.this$0));
        Intrinsics3.checkNotNullExpressionValue(observableM11084J, "Observable\n            .…    .observeOn(scheduler)");
        ObservableExtensionsKt.appSubscribe$default(observableM11084J, OnDelayedEmissionHandler2.class, (Context) null, (Function1) null, new OnDelayedEmissionHandler4(this), (Function0) null, (Function0) null, new OnDelayedEmissionHandler3(this), 54, (Object) null);
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable e) {
        Intrinsics3.checkNotNullParameter(e, "e");
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onError(e);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        if (this.$subscriber.isUnsubscribed()) {
            return;
        }
        tryFinish();
        this.$subscriber.onNext(t);
    }
}
