package p637j0.p642l.p644b;

import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p658rx.Producer;
import p658rx.Subscriber;

/* compiled from: SingleProducer.java */
/* renamed from: j0.l.b.c, reason: use source file name */
/* loaded from: classes3.dex */
public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    public final Subscriber<? super T> child;
    public final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t) {
        this.child = subscriber;
        this.value = t;
    }

    @Override // p658rx.Producer
    /* renamed from: j */
    public void mo10704j(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j != 0 && compareAndSet(false, true)) {
            Subscriber<? super T> subscriber = this.child;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.value;
            try {
                subscriber.onNext(t);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                C3404f.m4329p1(th, subscriber, t);
            }
        }
    }
}
