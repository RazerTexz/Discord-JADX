package p637j0.p642l.p647e;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Func1;
import p637j0.p642l.p644b.SingleProducer;
import p637j0.p642l.p645c.EventLoopsScheduler;
import p637j0.p651n.Subscribers2;
import p637j0.p652o.C12774l;
import p658rx.Observable;
import p658rx.Producer;
import p658rx.Scheduler;
import p658rx.Subscriber;
import p658rx.Subscription;
import p658rx.functions.Action0;

/* compiled from: ScalarSynchronousObservable.java */
/* renamed from: j0.l.e.k, reason: use source file name */
/* loaded from: classes3.dex */
public final class ScalarSynchronousObservable<T> extends Observable<T> {

    /* renamed from: k */
    public static final boolean f27287k = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: l */
    public final T f27288l;

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$a */
    public class a implements Func1<Action0, Subscription> {

        /* renamed from: j */
        public final /* synthetic */ EventLoopsScheduler f27289j;

        public a(ScalarSynchronousObservable scalarSynchronousObservable, EventLoopsScheduler eventLoopsScheduler) {
            this.f27289j = eventLoopsScheduler;
        }

        @Override // p637j0.p641k.Func1
        public Subscription call(Action0 action0) {
            return this.f27289j.f27191e.get().m10801a().m10805f(action0, -1L, TimeUnit.NANOSECONDS);
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$b */
    public class b implements Func1<Action0, Subscription> {

        /* renamed from: j */
        public final /* synthetic */ Scheduler f27290j;

        public b(ScalarSynchronousObservable scalarSynchronousObservable, Scheduler scheduler) {
            this.f27290j = scheduler;
        }

        @Override // p637j0.p641k.Func1
        public Subscription call(Action0 action0) {
            Scheduler.Worker workerMo10739a = this.f27290j.mo10739a();
            workerMo10739a.mo10740a(new ScalarSynchronousObservable2(this, action0, workerMo10739a));
            return workerMo10739a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$c */
    public class c<R> implements Observable.InterfaceC13005a<R> {

        /* renamed from: j */
        public final /* synthetic */ Func1 f27291j;

        public c(Func1 func1) {
            this.f27291j = func1;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            Observable observable = (Observable) this.f27291j.call(ScalarSynchronousObservable.this.f27288l);
            if (!(observable instanceof ScalarSynchronousObservable)) {
                observable.m11107i0(new Subscribers2(subscriber, subscriber));
            } else {
                T t = ((ScalarSynchronousObservable) observable).f27288l;
                subscriber.setProducer(ScalarSynchronousObservable.f27287k ? new SingleProducer(subscriber, t) : new g(subscriber, t));
            }
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$d */
    public static final class d<T> implements Observable.InterfaceC13005a<T> {

        /* renamed from: j */
        public final T f27293j;

        public d(T t) {
            this.f27293j = t;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            T t = this.f27293j;
            subscriber.setProducer(ScalarSynchronousObservable.f27287k ? new SingleProducer(subscriber, t) : new g(subscriber, t));
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$e */
    public static final class e<T> implements Observable.InterfaceC13005a<T> {

        /* renamed from: j */
        public final T f27294j;

        /* renamed from: k */
        public final Func1<Action0, Subscription> f27295k;

        public e(T t, Func1<Action0, Subscription> func1) {
            this.f27294j = t;
            this.f27295k = func1;
        }

        @Override // p658rx.functions.Action1
        public void call(Object obj) {
            Subscriber subscriber = (Subscriber) obj;
            subscriber.setProducer(new f(subscriber, this.f27294j, this.f27295k));
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$f */
    public static final class f<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        public final Subscriber<? super T> actual;
        public final Func1<Action0, Subscription> onSchedule;
        public final T value;

        public f(Subscriber<? super T> subscriber, T t, Func1<Action0, Subscription> func1) {
            this.actual = subscriber;
            this.value = t;
            this.onSchedule = func1;
        }

        @Override // p658rx.functions.Action0
        public void call() {
            Subscriber<? super T> subscriber = this.actual;
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

        @Override // p658rx.Producer
        /* renamed from: j */
        public void mo10704j(long j) {
            if (j < 0) {
                throw new IllegalArgumentException(outline.m877t("n >= 0 required but it was ", j));
            }
            if (j == 0 || !compareAndSet(false, true)) {
                return;
            }
            this.actual.add(this.onSchedule.call(this));
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            StringBuilder sbM833U = outline.m833U("ScalarAsyncProducer[");
            sbM833U.append(this.value);
            sbM833U.append(", ");
            sbM833U.append(get());
            sbM833U.append("]");
            return sbM833U.toString();
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: j0.l.e.k$g */
    public static final class g<T> implements Producer {

        /* renamed from: j */
        public final Subscriber<? super T> f27296j;

        /* renamed from: k */
        public final T f27297k;

        /* renamed from: l */
        public boolean f27298l;

        public g(Subscriber<? super T> subscriber, T t) {
            this.f27296j = subscriber;
            this.f27297k = t;
        }

        @Override // p658rx.Producer
        /* renamed from: j */
        public void mo10704j(long j) {
            if (this.f27298l) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException(outline.m877t("n >= required but it was ", j));
            }
            if (j == 0) {
                return;
            }
            this.f27298l = true;
            Subscriber<? super T> subscriber = this.f27296j;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t = this.f27297k;
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

    public ScalarSynchronousObservable(T t) {
        super(C12774l.m10862a(new d(t)));
        this.f27288l = t;
    }

    /* renamed from: k0 */
    public <R> Observable<R> m10820k0(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.m11074h0(new c(func1));
    }

    /* renamed from: l0 */
    public Observable<T> m10821l0(Scheduler scheduler) {
        return Observable.m11074h0(new e(this.f27288l, scheduler instanceof EventLoopsScheduler ? new a(this, (EventLoopsScheduler) scheduler) : new b(this, scheduler)));
    }
}
