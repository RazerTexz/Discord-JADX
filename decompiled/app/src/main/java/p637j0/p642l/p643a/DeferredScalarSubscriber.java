package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import p007b.p100d.p104b.p105a.outline;
import p658rx.Producer;
import p658rx.Subscriber;

/* compiled from: DeferredScalarSubscriber.java */
/* renamed from: j0.l.a.a, reason: use source file name */
/* loaded from: classes3.dex */
public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {

    /* renamed from: j */
    public final Subscriber<? super R> f26719j;

    /* renamed from: k */
    public boolean f26720k;

    /* renamed from: l */
    public R f26721l;

    /* renamed from: m */
    public final AtomicInteger f26722m = new AtomicInteger();

    /* compiled from: DeferredScalarSubscriber.java */
    /* renamed from: j0.l.a.a$a */
    public static final class a implements Producer {

        /* renamed from: j */
        public final DeferredScalarSubscriber<?, ?> f26723j;

        public a(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.f26723j = deferredScalarSubscriber;
        }

        @Override // p658rx.Producer
        /* renamed from: j */
        public void mo10704j(long j) {
            DeferredScalarSubscriber<?, ?> deferredScalarSubscriber = this.f26723j;
            Objects.requireNonNull(deferredScalarSubscriber);
            if (j < 0) {
                throw new IllegalArgumentException(outline.m877t("n >= 0 required but it was ", j));
            }
            if (j != 0) {
                Subscriber<? super Object> subscriber = deferredScalarSubscriber.f26719j;
                do {
                    int i = deferredScalarSubscriber.f26722m.get();
                    if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (i == 2) {
                        if (deferredScalarSubscriber.f26722m.compareAndSet(2, 3)) {
                            subscriber.onNext(deferredScalarSubscriber.f26721l);
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                        return;
                    }
                } while (!deferredScalarSubscriber.f26722m.compareAndSet(0, 1));
            }
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.f26719j = subscriber;
    }

    @Override // p658rx.Subscriber
    public final void setProducer(Producer producer) {
        producer.mo10704j(RecyclerView.FOREVER_NS);
    }
}
