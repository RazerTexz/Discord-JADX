package p637j0.p642l.p643a;

import androidx.recyclerview.widget.RecyclerView;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.BackpressureOverflow;
import p637j0.p642l.p647e.BackpressureDrainManager;
import p658rx.Observable;
import p658rx.Subscriber;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Action0;

/* JADX INFO: renamed from: j0.l.a.a1, reason: use source file name */
/* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public class OperatorOnBackpressureBuffer<T> implements Observable.InterfaceC13006b<T, T> {

    /* JADX INFO: renamed from: j */
    public final BackpressureOverflow.b f26727j;

    /* JADX INFO: renamed from: j0.l.a.a1$a */
    /* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
    public static final class a<T> extends Subscriber<T> implements BackpressureDrainManager.a {

        /* JADX INFO: renamed from: l */
        public final Subscriber<? super T> f26730l;

        /* JADX INFO: renamed from: p */
        public final BackpressureOverflow.b f26734p;

        /* JADX INFO: renamed from: j */
        public final ConcurrentLinkedQueue<Object> f26728j = new ConcurrentLinkedQueue<>();

        /* JADX INFO: renamed from: m */
        public final AtomicBoolean f26731m = new AtomicBoolean(false);

        /* JADX INFO: renamed from: k */
        public final AtomicLong f26729k = null;

        /* JADX INFO: renamed from: o */
        public final Action0 f26733o = null;

        /* JADX INFO: renamed from: n */
        public final BackpressureDrainManager f26732n = new BackpressureDrainManager(this);

        public a(Subscriber<? super T> subscriber, Long l, Action0 action0, BackpressureOverflow.b bVar) {
            this.f26730l = subscriber;
            this.f26734p = bVar;
        }

        @Override // p637j0.Observer2
        public void onCompleted() throws Throwable {
            if (this.f26731m.get()) {
                return;
            }
            BackpressureDrainManager backpressureDrainManager = this.f26732n;
            backpressureDrainManager.terminated = true;
            backpressureDrainManager.m10810a();
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) throws Throwable {
            if (this.f26731m.get()) {
                return;
            }
            BackpressureDrainManager backpressureDrainManager = this.f26732n;
            if (backpressureDrainManager.terminated) {
                return;
            }
            backpressureDrainManager.exception = th;
            backpressureDrainManager.terminated = true;
            backpressureDrainManager.m10810a();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0040  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x006b A[EDGE_INSN: B:44:0x006b->B:33:0x006b BREAK  A[LOOP:0: B:5:0x0008->B:46:?], SYNTHETIC] */
        @Override // p637j0.Observer2
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onNext(T t) throws Throwable {
            long j;
            boolean z2 = false;
            if (this.f26729k == null) {
                z2 = true;
            } else {
                do {
                    j = this.f26729k.get();
                    if (j <= 0) {
                        try {
                        } catch (MissingBackpressureException e) {
                            if (this.f26731m.compareAndSet(false, true)) {
                                unsubscribe();
                                this.f26730l.onError(e);
                            }
                        }
                        if (this.f26734p.mo10731a()) {
                            Object objPoll = this.f26728j.poll();
                            AtomicLong atomicLong = this.f26729k;
                            if (atomicLong != null && objPoll != null) {
                                atomicLong.incrementAndGet();
                            }
                            boolean z3 = objPoll != null;
                            Action0 action0 = this.f26733o;
                            if (action0 != null) {
                                try {
                                    action0.call();
                                    if (!z3) {
                                        break;
                                    }
                                } catch (Throwable th) {
                                    C3404f.m4325o1(th);
                                    BackpressureDrainManager backpressureDrainManager = this.f26732n;
                                    if (!backpressureDrainManager.terminated) {
                                        backpressureDrainManager.exception = th;
                                        backpressureDrainManager.terminated = true;
                                        backpressureDrainManager.m10810a();
                                    }
                                }
                            } else if (!z3) {
                            }
                            z2 = true;
                        }
                    }
                } while (!this.f26729k.compareAndSet(j, j - 1));
                z2 = true;
            }
            if (z2) {
                ConcurrentLinkedQueue<Object> concurrentLinkedQueue = this.f26728j;
                if (t == null) {
                    t = (T) NotificationLite.f26769b;
                }
                concurrentLinkedQueue.offer(t);
                this.f26732n.m10810a();
            }
        }

        @Override // p658rx.Subscriber
        public void onStart() {
            request(RecyclerView.FOREVER_NS);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.a1$b */
    /* JADX INFO: compiled from: OperatorOnBackpressureBuffer.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public static final OperatorOnBackpressureBuffer<?> f26735a = new OperatorOnBackpressureBuffer<>();
    }

    public OperatorOnBackpressureBuffer() {
        int i = BackpressureOverflow.f26683a;
        this.f26727j = BackpressureOverflow.a.f26684a;
    }

    @Override // p637j0.p641k.Func1
    public Object call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        a aVar = new a(subscriber, null, null, this.f26727j);
        subscriber.add(aVar);
        subscriber.setProducer(aVar.f26732n);
        return aVar;
    }
}
