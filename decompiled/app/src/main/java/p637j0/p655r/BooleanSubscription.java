package p637j0.p655r;

import java.util.concurrent.atomic.AtomicReference;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* compiled from: BooleanSubscription.java */
/* renamed from: j0.r.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class BooleanSubscription implements Subscription {

    /* renamed from: j */
    public static final Action0 f27419j = new a();

    /* renamed from: k */
    public final AtomicReference<Action0> f27420k;

    /* compiled from: BooleanSubscription.java */
    /* renamed from: j0.r.a$a */
    public static class a implements Action0 {
        @Override // p658rx.functions.Action0
        public void call() {
        }
    }

    public BooleanSubscription() {
        this.f27420k = new AtomicReference<>();
    }

    @Override // p658rx.Subscription
    public boolean isUnsubscribed() {
        return this.f27420k.get() == f27419j;
    }

    @Override // p658rx.Subscription
    public void unsubscribe() {
        Action0 andSet;
        Action0 action0 = this.f27420k.get();
        Action0 action02 = f27419j;
        if (action0 == action02 || (andSet = this.f27420k.getAndSet(action02)) == null || andSet == action02) {
            return;
        }
        andSet.call();
    }

    public BooleanSubscription(Action0 action0) {
        this.f27420k = new AtomicReference<>(action0);
    }
}
