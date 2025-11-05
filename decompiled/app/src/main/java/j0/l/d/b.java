package j0.l.d;

import rx.Subscription;

/* compiled from: Unsubscribed.java */
/* loaded from: classes3.dex */
public enum b implements Subscription {
    INSTANCE;

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        return true;
    }

    @Override // rx.Subscription
    public void unsubscribe() {
    }
}
