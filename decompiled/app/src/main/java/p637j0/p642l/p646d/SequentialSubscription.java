package p637j0.p642l.p646d;

import java.util.concurrent.atomic.AtomicReference;
import p658rx.Subscription;

/* compiled from: SequentialSubscription.java */
/* renamed from: j0.l.d.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class SequentialSubscription extends AtomicReference<Subscription> implements Subscription {
    private static final long serialVersionUID = 995205034283130269L;

    public SequentialSubscription() {
    }

    /* renamed from: a */
    public boolean m10809a(Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = get();
            if (subscription2 == Unsubscribed.INSTANCE) {
                if (subscription == null) {
                    return false;
                }
                subscription.unsubscribe();
                return false;
            }
        } while (!compareAndSet(subscription2, subscription));
        return true;
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return get() == Unsubscribed.INSTANCE;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        Subscription andSet;
        Subscription subscription = get();
        Unsubscribed unsubscribed = Unsubscribed.INSTANCE;
        if (subscription == unsubscribed || (andSet = getAndSet(unsubscribed)) == null || andSet == unsubscribed) {
            return;
        }
        andSet.unsubscribe();
    }

    public SequentialSubscription(Subscription subscription) {
        lazySet(subscription);
    }
}
