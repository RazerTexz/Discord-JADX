package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;

/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes3.dex */
public class w implements Action0 {
    public final /* synthetic */ Observable j;
    public final /* synthetic */ Subscriber k;
    public final /* synthetic */ AtomicLong l;
    public final /* synthetic */ Scheduler.Worker m;
    public final /* synthetic */ Action0 n;
    public final /* synthetic */ AtomicBoolean o;

    /* compiled from: OnSubscribeRedo.java */
    public class a extends Subscriber<Object> {
        public a(Subscriber subscriber) {
            super(subscriber);
        }

        @Override // j0.g
        public void onCompleted() {
            w.this.k.onCompleted();
        }

        @Override // j0.g
        public void onError(Throwable th) {
            w.this.k.onError(th);
        }

        @Override // j0.g
        public void onNext(Object obj) {
            if (w.this.k.isUnsubscribed()) {
                return;
            }
            if (w.this.l.get() <= 0) {
                w.this.o.compareAndSet(false, true);
            } else {
                w wVar = w.this;
                wVar.m.a(wVar.n);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            producer.j(RecyclerView.FOREVER_NS);
        }
    }

    public w(y yVar, Observable observable, Subscriber subscriber, AtomicLong atomicLong, Scheduler.Worker worker, Action0 action0, AtomicBoolean atomicBoolean) {
        this.j = observable;
        this.k = subscriber;
        this.l = atomicLong;
        this.m = worker;
        this.n = action0;
        this.o = atomicBoolean;
    }

    @Override // rx.functions.Action0
    public void call() {
        this.j.i0(new a(this.k));
    }
}
