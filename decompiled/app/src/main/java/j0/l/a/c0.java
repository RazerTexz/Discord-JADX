package j0.l.a;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

/* compiled from: OnSubscribeRefCount.java */
/* loaded from: classes3.dex */
public final class c0<T> implements Observable.a<T> {
    public final j0.m.b<? extends T> j;
    public volatile CompositeSubscription k = new CompositeSubscription();
    public final AtomicInteger l = new AtomicInteger(0);
    public final ReentrantLock m = new ReentrantLock();

    public c0(j0.m.b<? extends T> bVar) {
        this.j = bVar;
    }

    @Override // rx.functions.Action1
    public void call(Object obj) {
        boolean z2;
        Subscriber subscriber = (Subscriber) obj;
        this.m.lock();
        if (this.l.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.j.k0(new z(this, subscriber, atomicBoolean));
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
            CompositeSubscription compositeSubscription = this.k;
            subscriber.add(new j0.r.a(new b0(this, compositeSubscription)));
            this.j.i0(new a0(this, subscriber, subscriber, compositeSubscription));
        } finally {
            this.m.unlock();
        }
    }
}
