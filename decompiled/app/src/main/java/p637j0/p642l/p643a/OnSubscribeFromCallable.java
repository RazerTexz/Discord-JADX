package p637j0.p642l.p643a;

import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p644b.SingleDelayedProducer;
import p658rx.Observable;
import p658rx.Subscriber;

/* compiled from: OnSubscribeFromCallable.java */
/* renamed from: j0.l.a.p, reason: use source file name */
/* loaded from: classes3.dex */
public final class OnSubscribeFromCallable<T> implements Observable.InterfaceC13005a<T> {

    /* renamed from: j */
    public final Callable<? extends T> f26972j;

    public OnSubscribeFromCallable(Callable<? extends T> callable) {
        this.f26972j = callable;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        subscriber.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.m10799b(this.f26972j.call());
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            subscriber.onError(th);
        }
    }
}
