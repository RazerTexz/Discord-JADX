package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.l.a.q0;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: OperatorDebounceWithTime.java */
/* loaded from: classes3.dex */
public class p0<T> extends Subscriber<T> {
    public final q0.a<T> j;
    public final Subscriber<?> k;
    public final /* synthetic */ SerialSubscription l;
    public final /* synthetic */ Scheduler.Worker m;
    public final /* synthetic */ SerializedSubscriber n;
    public final /* synthetic */ q0 o;

    /* compiled from: OperatorDebounceWithTime.java */
    public class a implements Action0 {
        public final /* synthetic */ int j;

        public a(int i) {
            this.j = i;
        }

        @Override // rx.functions.Action0
        public void call() {
            p0 p0Var = p0.this;
            q0.a<T> aVar = p0Var.j;
            int i = this.j;
            SerializedSubscriber serializedSubscriber = p0Var.n;
            Subscriber<?> subscriber = p0Var.k;
            synchronized (aVar) {
                if (!aVar.e && aVar.c && i == aVar.a) {
                    T t = aVar.f3778b;
                    aVar.f3778b = null;
                    aVar.c = false;
                    aVar.e = true;
                    try {
                        serializedSubscriber.onNext(t);
                        synchronized (aVar) {
                            if (aVar.d) {
                                serializedSubscriber.onCompleted();
                            } else {
                                aVar.e = false;
                            }
                        }
                    } catch (Throwable th) {
                        b.i.a.f.e.o.f.p1(th, subscriber, t);
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p0(q0 q0Var, Subscriber subscriber, SerialSubscription serialSubscription, Scheduler.Worker worker, SerializedSubscriber serializedSubscriber) {
        super(subscriber);
        this.o = q0Var;
        this.l = serialSubscription;
        this.m = worker;
        this.n = serializedSubscriber;
        this.j = new q0.a<>();
        this.k = this;
    }

    @Override // j0.g
    public void onCompleted() {
        q0.a<T> aVar = this.j;
        SerializedSubscriber serializedSubscriber = this.n;
        synchronized (aVar) {
            if (aVar.e) {
                aVar.d = true;
                return;
            }
            T t = aVar.f3778b;
            boolean z2 = aVar.c;
            aVar.f3778b = null;
            aVar.c = false;
            aVar.e = true;
            if (z2) {
                try {
                    serializedSubscriber.onNext(t);
                } catch (Throwable th) {
                    b.i.a.f.e.o.f.p1(th, this, t);
                    return;
                }
            }
            serializedSubscriber.onCompleted();
        }
    }

    @Override // j0.g
    public void onError(Throwable th) {
        this.n.j.onError(th);
        unsubscribe();
        q0.a<T> aVar = this.j;
        synchronized (aVar) {
            aVar.a++;
            aVar.f3778b = null;
            aVar.c = false;
        }
    }

    @Override // j0.g
    public void onNext(T t) {
        int i;
        q0.a<T> aVar = this.j;
        synchronized (aVar) {
            aVar.f3778b = t;
            aVar.c = true;
            i = aVar.a + 1;
            aVar.a = i;
        }
        SerialSubscription serialSubscription = this.l;
        Scheduler.Worker worker = this.m;
        a aVar2 = new a(i);
        q0 q0Var = this.o;
        serialSubscription.a(worker.b(aVar2, q0Var.j, q0Var.k));
    }

    @Override // rx.Subscriber
    public void onStart() {
        request(RecyclerView.FOREVER_NS);
    }
}
