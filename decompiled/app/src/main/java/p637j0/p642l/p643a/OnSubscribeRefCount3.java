package p637j0.p642l.p643a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import p637j0.p650m.ConnectableObservable;
import p637j0.p655r.BooleanSubscription;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: OnSubscribeRefCount.java */
/* renamed from: j0.l.a.c0, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeRefCount3<T> implements Observable.InterfaceC13005a<T> {

    /* renamed from: j */
    public final ConnectableObservable<? extends T> f26753j;

    /* renamed from: k */
    public volatile CompositeSubscription f26754k = new CompositeSubscription();

    /* renamed from: l */
    public final AtomicInteger f26755l = new AtomicInteger(0);

    /* renamed from: m */
    public final ReentrantLock f26756m = new ReentrantLock();

    public OnSubscribeRefCount3(ConnectableObservable<? extends T> connectableObservable) {
        this.f26753j = connectableObservable;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        this.f26756m.lock();
        if (this.f26755l.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.f26753j.mo10753k0(new OnSubscribeRefCount4(this, subscriber, atomicBoolean));
                if (z2) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            CompositeSubscription compositeSubscription = this.f26754k;
            subscriber.add(new BooleanSubscription(new OnSubscribeRefCount2(this, compositeSubscription)));
            this.f26753j.m11107i0(new OnSubscribeRefCount(this, subscriber, subscriber, compositeSubscription));
        } finally {
            this.f26756m.unlock();
        }
    }
}
