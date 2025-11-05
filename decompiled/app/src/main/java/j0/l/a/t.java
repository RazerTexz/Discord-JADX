package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.f;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.SerialSubscription;

/* compiled from: OnSubscribeRedo.java */
/* loaded from: classes3.dex */
public class t implements Action0 {
    public final /* synthetic */ Subscriber j;
    public final /* synthetic */ Subject k;
    public final /* synthetic */ j0.l.b.a l;
    public final /* synthetic */ AtomicLong m;
    public final /* synthetic */ SerialSubscription n;
    public final /* synthetic */ y o;

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: OnSubscribeRedo.java */
    public class a<T> extends Subscriber<T> {
        public boolean j;

        public a() {
        }

        @Override // j0.g
        public void onCompleted() {
            if (this.j) {
                return;
            }
            this.j = true;
            unsubscribe();
            t.this.k.onNext(j0.f.a);
        }

        @Override // j0.g
        public void onError(Throwable th) {
            if (this.j) {
                return;
            }
            this.j = true;
            unsubscribe();
            t.this.k.onNext(new j0.f(f.a.OnError, null, th));
        }

        @Override // j0.g
        public void onNext(T t) {
            long j;
            if (this.j) {
                return;
            }
            t.this.j.onNext(t);
            do {
                j = t.this.m.get();
                if (j == RecyclerView.FOREVER_NS) {
                    break;
                }
            } while (!t.this.m.compareAndSet(j, j - 1));
            t.this.l.b(1L);
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            t.this.l.c(producer);
        }
    }

    public t(y yVar, Subscriber subscriber, Subject subject, j0.l.b.a aVar, AtomicLong atomicLong, SerialSubscription serialSubscription) {
        this.o = yVar;
        this.j = subscriber;
        this.k = subject;
        this.l = aVar;
        this.m = atomicLong;
        this.n = serialSubscription;
    }

    @Override // rx.functions.Action0
    public void call() {
        if (this.j.isUnsubscribed()) {
            return;
        }
        a aVar = new a();
        this.n.a(aVar);
        this.o.j.i0(aVar);
    }
}
