package p637j0.p642l.p643a;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.p648n.SpscUnboundedAtomicArrayQueue;
import p637j0.p642l.p647e.p649o.SpscUnboundedArrayQueue;
import p637j0.p642l.p647e.p649o.UnsafeAccess;
import p637j0.p652o.C12774l;
import p658rx.Emitter;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.exceptions.MissingBackpressureException;
import p658rx.functions.Action1;
import p658rx.subscriptions.SerialSubscription;

/* JADX INFO: renamed from: j0.l.a.i, reason: use source file name */
/* JADX INFO: compiled from: OnSubscribeCreate.java */
/* JADX INFO: loaded from: classes3.dex */
public final class OnSubscribeCreate<T> implements Observable.InterfaceC13005a<T> {

    /* JADX INFO: renamed from: j */
    public final Action1<Emitter<T>> f26845j;

    /* JADX INFO: renamed from: k */
    public final Emitter.BackpressureMode f26846k;

    /* JADX INFO: renamed from: j0.l.a.i$a */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static abstract class a<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        public final Subscriber<? super T> actual;
        public final SerialSubscription serial = new SerialSubscription();

        public a(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        /* JADX INFO: renamed from: a */
        public void mo10757a() {
        }

        /* JADX INFO: renamed from: b */
        public void mo10758b() {
        }

        @Override // p658rx.Subscription
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // p658rx.Producer
        /* JADX INFO: renamed from: j */
        public final void mo10704j(long j) {
            if (C3404f.m4191A1(j)) {
                C3404f.m4276c0(this, j);
                mo10757a();
            }
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onCompleted();
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onError(th);
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // p658rx.Subscription
        public final void unsubscribe() {
            this.serial.f27657j.unsubscribe();
            mo10758b();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.i$b */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static final class b<T> extends a<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        public volatile boolean done;
        public Throwable error;
        public final Queue<Object> queue;
        public final AtomicInteger wip;

        public b(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.queue = UnsafeAccess.m10858b() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            this.wip = new AtomicInteger();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a
        /* JADX INFO: renamed from: a */
        public void mo10757a() {
            m10759c();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a
        /* JADX INFO: renamed from: b */
        public void mo10758b() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* JADX INFO: renamed from: c */
        public void m10759c() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            Queue<Object> queue = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z2 = this.done;
                    Object objPoll = queue.poll();
                    boolean z3 = objPoll == null;
                    if (z2 && z3) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z3) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.m10745b(objPoll));
                    j2++;
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z4 = this.done;
                    boolean zIsEmpty = queue.isEmpty();
                    if (z4 && zIsEmpty) {
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    C3404f.m4250U0(this, j2);
                }
                iAddAndGet = this.wip.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a, p637j0.Observer2
        public void onCompleted() {
            this.done = true;
            m10759c();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a, p637j0.Observer2
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m10759c();
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            Queue<Object> queue = this.queue;
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            queue.offer(t);
            m10759c();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.i$c */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static final class c<T> extends f<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public c(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.f
        /* JADX INFO: renamed from: c */
        public void mo10760c() {
        }
    }

    /* JADX INFO: renamed from: j0.l.a.i$d */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static final class d<T> extends f<T> {
        private static final long serialVersionUID = 338953216916120960L;
        private boolean done;

        public d(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.f
        /* JADX INFO: renamed from: c */
        public void mo10760c() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a, p637j0.Observer2
        public void onCompleted() {
            if (this.done) {
                return;
            }
            this.done = true;
            super.onCompleted();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a, p637j0.Observer2
        public void onError(Throwable th) {
            if (this.done) {
                C12774l.m10863b(th);
            } else {
                this.done = true;
                super.onError(th);
            }
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.f, p637j0.Observer2
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            super.onNext(t);
        }
    }

    /* JADX INFO: renamed from: j0.l.a.i$e */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static final class e<T> extends a<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        public volatile boolean done;
        public Throwable error;
        public final AtomicReference<Object> queue;
        public final AtomicInteger wip;

        public e(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a
        /* JADX INFO: renamed from: a */
        public void mo10757a() {
            m10761c();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a
        /* JADX INFO: renamed from: b */
        public void mo10758b() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:27:0x0053, code lost:
        
            if (r9 != r5) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0059, code lost:
        
            if (r1.isUnsubscribed() == false) goto L32;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x005b, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x005e, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005f, code lost:
        
            r5 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0065, code lost:
        
            if (r2.get() != null) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0067, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
        
            if (r5 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006a, code lost:
        
            if (r11 == false) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x006c, code lost:
        
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x006e, code lost:
        
            if (r1 == null) goto L40;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0070, code lost:
        
            super.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0074, code lost:
        
            super.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x007a, code lost:
        
            if (r9 == 0) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x007c, code lost:
        
            p007b.p225i.p226a.p288f.p299e.p308o.C3404f.m4250U0(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x007f, code lost:
        
            r4 = r17.wip.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:?, code lost:
        
            return;
         */
        /* JADX INFO: renamed from: c */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m10761c() {
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            AtomicReference<Object> atomicReference = this.queue;
            int iAddAndGet = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    boolean z2 = false;
                    if (j2 == j) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.done;
                    Object andSet = atomicReference.getAndSet(null);
                    boolean z4 = andSet == null;
                    if (z3 && z4) {
                        Throwable th = this.error;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z4) {
                        break;
                    }
                    subscriber.onNext((Object) NotificationLite.m10745b(andSet));
                    j2++;
                }
            } while (iAddAndGet != 0);
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a, p637j0.Observer2
        public void onCompleted() {
            this.done = true;
            m10761c();
        }

        @Override // p637j0.p642l.p643a.OnSubscribeCreate.a, p637j0.Observer2
        public void onError(Throwable th) {
            this.error = th;
            this.done = true;
            m10761c();
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            AtomicReference<Object> atomicReference = this.queue;
            if (t == null) {
                t = (T) NotificationLite.f26769b;
            }
            atomicReference.set(t);
            m10761c();
        }
    }

    /* JADX INFO: renamed from: j0.l.a.i$f */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static abstract class f<T> extends a<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public f(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* JADX INFO: renamed from: c */
        public abstract void mo10760c();

        public void onNext(T t) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            if (get() == 0) {
                mo10760c();
            } else {
                this.actual.onNext(t);
                C3404f.m4250U0(this, 1L);
            }
        }
    }

    /* JADX INFO: renamed from: j0.l.a.i$g */
    /* JADX INFO: compiled from: OnSubscribeCreate.java */
    public static final class g<T> extends a<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public g(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            long j;
            if (this.actual.isUnsubscribed()) {
                return;
            }
            this.actual.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    public OnSubscribeCreate(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.f26845j = action1;
        this.f26846k = backpressureMode;
    }

    @Override // p658rx.functions.Action1
    public void call(Object obj) {
        Subscriber subscriber = (Subscriber) obj;
        int iOrdinal = this.f26846k.ordinal();
        a bVar = iOrdinal != 0 ? iOrdinal != 1 ? iOrdinal != 3 ? iOrdinal != 4 ? new b(subscriber, RxRingBuffer.f27283j) : new e(subscriber) : new c(subscriber) : new d(subscriber) : new g(subscriber);
        subscriber.add(bVar);
        subscriber.setProducer(bVar);
        this.f26845j.call(bVar);
    }
}
