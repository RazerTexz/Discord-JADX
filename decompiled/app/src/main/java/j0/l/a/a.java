package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;

/* compiled from: DeferredScalarSubscriber.java */
/* loaded from: classes3.dex */
public abstract class a<T, R> extends Subscriber<T> {
    public final Subscriber<? super R> j;
    public boolean k;
    public R l;
    public final AtomicInteger m = new AtomicInteger();

    /* compiled from: DeferredScalarSubscriber.java */
    /* renamed from: j0.l.a.a$a, reason: collision with other inner class name */
    public static final class C0621a implements Producer {
        public final a<?, ?> j;

        public C0621a(a<?, ?> aVar) {
            this.j = aVar;
        }

        @Override // rx.Producer
        public void j(long j) {
            a<?, ?> aVar = this.j;
            Objects.requireNonNull(aVar);
            if (j < 0) {
                throw new IllegalArgumentException(b.d.b.a.a.t("n >= 0 required but it was ", j));
            }
            if (j != 0) {
                Subscriber<? super Object> subscriber = aVar.j;
                do {
                    int i = aVar.m.get();
                    if (i == 1 || i == 3 || subscriber.isUnsubscribed()) {
                        return;
                    }
                    if (i == 2) {
                        if (aVar.m.compareAndSet(2, 3)) {
                            subscriber.onNext(aVar.l);
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            subscriber.onCompleted();
                            return;
                        }
                        return;
                    }
                } while (!aVar.m.compareAndSet(0, 1));
            }
        }
    }

    public a(Subscriber<? super R> subscriber) {
        this.j = subscriber;
    }

    @Override // rx.Subscriber
    public final void setProducer(Producer producer) {
        producer.j(RecyclerView.FOREVER_NS);
    }
}
