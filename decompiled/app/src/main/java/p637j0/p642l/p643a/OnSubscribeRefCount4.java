package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import p637j0.p655r.BooleanSubscription;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: OnSubscribeRefCount.java */
/* renamed from: j0.l.a.z, reason: use source file name */
/* loaded from: classes3.dex */
public class OnSubscribeRefCount4 implements Action1<Subscription> {

    /* renamed from: j */
    public final /* synthetic */ Subscriber f27142j;

    /* renamed from: k */
    public final /* synthetic */ AtomicBoolean f27143k;

    /* renamed from: l */
    public final /* synthetic */ OnSubscribeRefCount3 f27144l;

    public OnSubscribeRefCount4(OnSubscribeRefCount3 onSubscribeRefCount3, Subscriber subscriber, AtomicBoolean atomicBoolean) {
        this.f27144l = onSubscribeRefCount3;
        this.f27142j = subscriber;
        this.f27143k = atomicBoolean;
    }

    @Override // p658rx.functions.Action1
    public void call(Subscription subscription) {
        try {
            this.f27144l.f26754k.m11136a(subscription);
            OnSubscribeRefCount3 onSubscribeRefCount3 = this.f27144l;
            Subscriber subscriber = this.f27142j;
            CompositeSubscription compositeSubscription = onSubscribeRefCount3.f26754k;
            subscriber.add(new BooleanSubscription(new OnSubscribeRefCount2(onSubscribeRefCount3, compositeSubscription)));
            onSubscribeRefCount3.f26753j.m11107i0(new OnSubscribeRefCount(onSubscribeRefCount3, subscriber, subscriber, compositeSubscription));
        } finally {
            this.f27144l.f26756m.unlock();
            this.f27143k.set(false);
        }
    }
}
