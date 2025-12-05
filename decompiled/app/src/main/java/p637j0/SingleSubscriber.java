package p637j0;

import p658rx.Subscription;
import p658rx.internal.util.SubscriptionList;

/* compiled from: SingleSubscriber.java */
/* renamed from: j0.i, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class SingleSubscriber<T> implements Subscription {

    /* renamed from: j */
    public final SubscriptionList f26697j = new SubscriptionList();

    /* renamed from: a */
    public abstract void m10735a(Throwable th);

    /* renamed from: b */
    public abstract void m10736b(T t);

    @Override // p658rx.Subscription
    public final boolean isUnsubscribed() {
        return this.f26697j.f27645k;
    }

    @Override // p658rx.Subscription
    public final void unsubscribe() {
        this.f26697j.unsubscribe();
    }
}
