package p637j0.p655r;

import p637j0.p642l.p646d.SequentialSubscription;
import p658rx.Subscription;

/* JADX INFO: renamed from: j0.r.b, reason: use source file name */
/* JADX INFO: compiled from: MultipleAssignmentSubscription.java */
/* JADX INFO: loaded from: classes3.dex */
public final class MultipleAssignmentSubscription implements Subscription {

    /* JADX INFO: renamed from: j */
    public final SequentialSubscription f27421j = new SequentialSubscription();

    /* JADX INFO: renamed from: a */
    public void m10881a(Subscription subscription) {
        this.f27421j.m10809a(subscription);
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27421j.isUnsubscribed();
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        this.f27421j.unsubscribe();
    }
}
