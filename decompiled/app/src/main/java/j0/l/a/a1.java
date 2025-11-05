package j0.l.a;

import androidx.recyclerview.widget.RecyclerView;
import j0.a;
import j0.l.e.c;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;

/* compiled from: OperatorOnBackpressureBuffer.java */
/* loaded from: classes3.dex */
public class a1<T> implements Observable.b<T, T> {
    public final a.b j;

    /* compiled from: OperatorOnBackpressureBuffer.java */
    public static final class a<T> extends Subscriber<T> implements c.a {
        public final Subscriber<? super T> l;
        public final a.b p;
        public final ConcurrentLinkedQueue<Object> j = new ConcurrentLinkedQueue<>();
        public final AtomicBoolean m = new AtomicBoolean(false);
        public final AtomicLong k = null;
        public final Action0 o = null;
        public final j0.l.e.c n = new j0.l.e.c(this);

        public a(Subscriber<? super T> subscriber, Long l, Action0 action0, a.b bVar) {
            this.l = subscriber;
            this.p = bVar;
        }

        @Override // j0.g
        public void onCompleted() throws Throwable {
            if (this.m.get()) {
                return;
            }
            j0.l.e.c cVar = this.n;
            cVar.terminated = true;
            cVar.a();
        }

        @Override // j0.g
        public void onError(Throwable th) throws Throwable {
            if (this.m.get()) {
                return;
            }
            j0.l.e.c cVar = this.n;
            if (cVar.terminated) {
                return;
            }
            cVar.exception = th;
            cVar.terminated = true;
            cVar.a();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x006b A[EDGE_INSN: B:44:0x006b->B:33:0x006b BREAK  A[LOOP:0: B:5:0x0008->B:46:?], SYNTHETIC] */
        @Override // j0.g
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onNext(T t) throws Throwable {
            long j;
            boolean z2 = false;
            if (this.k == null) {
                z2 = true;
            } else {
                do {
                    j = this.k.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e) {
                            if (this.m.compareAndSet(false, true)) {
                                unsubscribe();
                                this.l.onError(e);
                            }
                        }
                        if (this.p.a()) {
                            Object objPoll = this.j.poll();
                            AtomicLong atomicLong = this.k;
                            if (atomicLong != null && objPoll != null) {
                                atomicLong.incrementAndGet();
                            }
                            boolean z3 = objPoll != null;
                            Action0 action0 = this.o;
                            if (action0 != null) {
                                try {
                                    action0.call();
                                    if (!z3) {
                                        break;
                                    }
                                } catch (Throwable th) {
                                    b.i.a.f.e.o.f.o1(th);
                                    j0.l.e.c cVar = this.n;
                                    if (!cVar.terminated) {
                                        cVar.exception = th;
                                        cVar.terminated = true;
                                        cVar.a();
                                    }
                                }
                            } else if (!z3) {
                            }
                            z2 = true;
                        }
                    }
                } while (!this.k.compareAndSet(j, j - 1));
                z2 = true;
            }
            if (z2) {
                ConcurrentLinkedQueue<Object> concurrentLinkedQueue = this.j;
                if (t == null) {
                    t = (T) e.f3771b;
                }
                concurrentLinkedQueue.offer(t);
                this.n.a();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    /* compiled from: OperatorOnBackpressureBuffer.java */
    public static final class b {
        public static final a1<?> a = new a1<>();
    }

    public a1() {
        int i = j0.a.a;
        this.j = a.C0618a.a;
    }

    @Override // j0.k.b
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, null, null, this.j);
        subscriber.add(aVar);
        subscriber.setProducer(aVar.n);
        return aVar;
    }
}
