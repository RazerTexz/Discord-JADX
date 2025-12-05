package p637j0.p654q;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.Observer2;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.subjects.Subject;

/* compiled from: ReplaySubject.java */
/* renamed from: j0.q.a, reason: use source file name */
/* loaded from: classes3.dex */
public final class ReplaySubject<T> extends Subject<T, T> {

    /* renamed from: k */
    public static final Object[] f27397k = new Object[0];

    /* renamed from: l */
    public final d<T> f27398l;

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$a */
    public interface a<T> {
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$b */
    public static final class b<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        public final Subscriber<? super T> actual;
        public int index;
        public Object node;
        public final AtomicLong requested = new AtomicLong();
        public final d<T> state;
        public int tailIndex;

        public b(Subscriber<? super T> subscriber, d<T> dVar) {
            this.actual = subscriber;
            this.state = dVar;
        }

        @Override // p658rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // p658rx.Producer
        /* renamed from: j */
        public void mo10704j(long j) {
            if (j > 0) {
                C3404f.m4276c0(this.requested, j);
                ((c) this.state.buffer).m10876a(this);
            } else if (j < 0) {
                throw new IllegalArgumentException(outline.m877t("n >= required but it was ", j));
            }
        }

        @Override // p658rx.Subscription
        public void unsubscribe() {
            this.state.m10877a(this);
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$c */
    public static final class c<T> implements a<T> {

        /* renamed from: a */
        public final int f27399a;

        /* renamed from: b */
        public volatile a<T> f27400b;

        /* renamed from: c */
        public a<T> f27401c;

        /* renamed from: d */
        public int f27402d;

        /* renamed from: e */
        public volatile boolean f27403e;

        /* renamed from: f */
        public Throwable f27404f;

        /* compiled from: ReplaySubject.java */
        /* renamed from: j0.q.a$c$a */
        public static final class a<T> extends AtomicReference<a<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            public final T value;

            public a(T t) {
                this.value = t;
            }
        }

        public c(int i) {
            this.f27399a = i;
            a<T> aVar = new a<>(null);
            this.f27401c = aVar;
            this.f27400b = aVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
        
            if (r10 != r5) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0064, code lost:
        
            if (r2.isUnsubscribed() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0066, code lost:
        
            r18.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
        
            r3 = r17.f27403e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x006f, code lost:
        
            if (r7.get() != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0071, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0072, code lost:
        
            if (r3 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x0074, code lost:
        
            if (r12 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x0076, code lost:
        
            r18.node = null;
            r1 = r17.f27404f;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007a, code lost:
        
            if (r1 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x007c, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0080, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0086, code lost:
        
            if (r10 == 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x008f, code lost:
        
            if (r5 == androidx.recyclerview.widget.RecyclerView.FOREVER_NS) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x0091, code lost:
        
            p007b.p225i.p226a.p288f.p299e.p308o.C3404f.m4250U0(r18.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0096, code lost:
        
            r18.node = r7;
            r4 = r18.addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:?, code lost:
        
            return;
         */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void m10876a(b<T> bVar) {
            if (bVar.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = bVar.actual;
            int iAddAndGet = 1;
            do {
                long j = bVar.requested.get();
                a<T> aVar = (a) bVar.node;
                if (aVar == null) {
                    aVar = this.f27400b;
                }
                long j2 = 0;
                while (true) {
                    boolean z2 = false;
                    if (j2 == j) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        bVar.node = null;
                        return;
                    }
                    boolean z3 = this.f27403e;
                    a<T> aVar2 = aVar.get();
                    boolean z4 = aVar2 == null;
                    if (z3 && z4) {
                        bVar.node = null;
                        Throwable th = this.f27404f;
                        if (th != null) {
                            subscriber.onError(th);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z4) {
                        break;
                    }
                    subscriber.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
            } while (iAddAndGet != 0);
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: j0.q.a$d */
    public static final class d<T> extends AtomicReference<b<T>[]> implements Observable.InterfaceC13005a<T>, Observer2<T> {

        /* renamed from: j */
        public static final b[] f27405j = new b[0];

        /* renamed from: k */
        public static final b[] f27406k = new b[0];
        private static final long serialVersionUID = 5952362471246910544L;
        public final a<T> buffer;

        public d(a<T> aVar) {
            this.buffer = aVar;
            lazySet(f27405j);
        }

        /* renamed from: a */
        public void m10877a(b<T> bVar) {
            b<T>[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = get();
                if (bVarArr == f27406k || bVarArr == f27405j) {
                    return;
                }
                int length = bVarArr.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        i = -1;
                        break;
                    } else if (bVarArr[i] == bVar) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f27405j;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i);
                    System.arraycopy(bVarArr, i + 1, bVarArr3, i, (length - i) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!compareAndSet(bVarArr, bVarArr2));
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            boolean z2;
            Subscriber subscriber = (Subscriber) obj;
            b<T> bVar = new b<>(subscriber, this);
            subscriber.add(bVar);
            subscriber.setProducer(bVar);
            while (true) {
                b<T>[] bVarArr = get();
                z2 = false;
                if (bVarArr == f27406k) {
                    break;
                }
                int length = bVarArr.length;
                b[] bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
                if (compareAndSet(bVarArr, bVarArr2)) {
                    z2 = true;
                    break;
                }
            }
            if (z2 && bVar.isUnsubscribed()) {
                m10877a(bVar);
            } else {
                ((c) this.buffer).m10876a(bVar);
            }
        }

        @Override // p637j0.Observer2
        public void onCompleted() {
            a<T> aVar = this.buffer;
            ((c) aVar).f27403e = true;
            for (b<T> bVar : getAndSet(f27406k)) {
                ((c) aVar).m10876a(bVar);
            }
        }

        @Override // p637j0.Observer2
        public void onError(Throwable th) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            cVar.f27404f = th;
            cVar.f27403e = true;
            ArrayList arrayList = null;
            for (b<T> bVar : getAndSet(f27406k)) {
                try {
                    ((c) aVar).m10876a(bVar);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            C3404f.m4321n1(arrayList);
        }

        @Override // p637j0.Observer2
        public void onNext(T t) {
            a<T> aVar = this.buffer;
            c cVar = (c) aVar;
            Objects.requireNonNull(cVar);
            c.a<T> aVar2 = new c.a<>(t);
            cVar.f27401c.set(aVar2);
            cVar.f27401c = aVar2;
            int i = cVar.f27402d;
            if (i == cVar.f27399a) {
                cVar.f27400b = cVar.f27400b.get();
            } else {
                cVar.f27402d = i + 1;
            }
            for (b<T> bVar : get()) {
                ((c) aVar).m10876a(bVar);
            }
        }
    }

    public ReplaySubject(d<T> dVar) {
        super(dVar);
        this.f27398l = dVar;
    }

    @Override // p637j0.Observer2
    public void onCompleted() {
        this.f27398l.onCompleted();
    }

    @Override // p637j0.Observer2
    public void onError(Throwable th) {
        this.f27398l.onError(th);
    }

    @Override // p637j0.Observer2
    public void onNext(T t) {
        this.f27398l.onNext(t);
    }
}
