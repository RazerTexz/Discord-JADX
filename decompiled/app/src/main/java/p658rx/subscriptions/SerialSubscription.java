package p658rx.subscriptions;

import p637j0.p642l.p646d.SequentialSubscription;
import p637j0.p642l.p646d.Unsubscribed;
import p658rx.Subscription;

/* JADX INFO: loaded from: classes3.dex */
public final class SerialSubscription implements Subscription {

    /* JADX INFO: renamed from: j */
    public final SequentialSubscription f27657j = new SequentialSubscription();

    /* JADX INFO: renamed from: a */
    public void m11139a(Subscription subscription) {
        Subscription subscription2;
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        SequentialSubscription sequentialSubscription = this.f27657j;
        do {
            subscription2 = sequentialSubscription.get();
            if (subscription2 == Unsubscribed.INSTANCE) {
                subscription.unsubscribe();
                return;
            }
        } while (!sequentialSubscription.compareAndSet(subscription2, subscription));
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27657j.isUnsubscribed();
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.f27657j.unsubscribe();
    }
}
