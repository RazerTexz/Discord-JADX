package p658rx;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p637j0.p641k.Actions2;
import p637j0.p641k.C12590c;
import p637j0.p641k.C12591d;
import p637j0.p641k.C12592e;
import p637j0.p641k.C12593f;
import p637j0.p641k.C12594g;
import p637j0.p641k.C12595h;
import p637j0.p641k.C12596i;
import p637j0.p641k.C12597j;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.EmptyObservableHolder;
import p637j0.p642l.p643a.OnSubscribeCombineLatest;
import p637j0.p642l.p643a.OnSubscribeConcatMap2;
import p637j0.p642l.p643a.OnSubscribeCreate;
import p637j0.p642l.p643a.OnSubscribeDoOnEach;
import p637j0.p642l.p643a.OnSubscribeFilter;
import p637j0.p642l.p643a.OnSubscribeFromArray;
import p637j0.p642l.p643a.OnSubscribeFromCallable;
import p637j0.p642l.p643a.OnSubscribeFromIterable;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p642l.p643a.OnSubscribeMap;
import p637j0.p642l.p643a.OnSubscribeRedo6;
import p637j0.p642l.p643a.OnSubscribeThrow;
import p637j0.p642l.p643a.OnSubscribeTimeoutTimedWithFallback;
import p637j0.p642l.p643a.OnSubscribeTimerOnce2;
import p637j0.p642l.p643a.OnSubscribeTimerPeriodically2;
import p637j0.p642l.p643a.OnSubscribeToMap;
import p637j0.p642l.p643a.OperatorBufferWithTime2;
import p637j0.p642l.p643a.OperatorDebounceWithTime2;
import p637j0.p642l.p643a.OperatorDelay2;
import p637j0.p642l.p643a.OperatorDistinctUntilChanged2;
import p637j0.p642l.p643a.OperatorDoOnSubscribe;
import p637j0.p642l.p643a.OperatorDoOnUnsubscribe;
import p637j0.p642l.p643a.OperatorMerge;
import p637j0.p642l.p643a.OperatorObserveOn2;
import p637j0.p642l.p643a.OperatorOnBackpressureBuffer;
import p637j0.p642l.p643a.OperatorOnBackpressureLatest;
import p637j0.p642l.p643a.OperatorOnErrorResumeNextViaFunction;
import p637j0.p642l.p643a.OperatorOnErrorResumeNextViaFunction4;
import p637j0.p642l.p643a.OperatorReplay;
import p637j0.p642l.p643a.OperatorReplay2;
import p637j0.p642l.p643a.OperatorReplay3;
import p637j0.p642l.p643a.OperatorSampleWithTime;
import p637j0.p642l.p643a.OperatorScan;
import p637j0.p642l.p643a.OperatorSingle;
import p637j0.p642l.p643a.OperatorSkip2;
import p637j0.p642l.p643a.OperatorSubscribeOn;
import p637j0.p642l.p643a.OperatorSwitch2;
import p637j0.p642l.p643a.OperatorTake2;
import p637j0.p642l.p643a.OperatorTakeUntil3;
import p637j0.p642l.p643a.OperatorTakeUntilPredicate2;
import p637j0.p642l.p643a.OperatorToObservableList2;
import p637j0.p642l.p643a.OperatorZip;
import p637j0.p642l.p645c.TrampolineScheduler;
import p637j0.p642l.p647e.ActionObserver;
import p637j0.p642l.p647e.ActionSubscriber;
import p637j0.p642l.p647e.InternalObservableUtils;
import p637j0.p642l.p647e.RxRingBuffer;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p642l.p647e.UtilityFunctions;
import p637j0.p650m.ConnectableObservable;
import p637j0.p651n.SafeSubscriber;
import p637j0.p652o.C12774l;
import p637j0.p653p.Schedulers2;
import p637j0.p655r.Subscriptions;
import p658rx.Emitter;
import p658rx.exceptions.OnErrorFailedException;
import p658rx.functions.Action0;
import p658rx.functions.Action1;
import p658rx.functions.Func0;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;
import p658rx.functions.Func5;
import p658rx.functions.Func6;
import p658rx.functions.Func7;
import p658rx.functions.Func8;
import p658rx.functions.Func9;
import p658rx.functions.FuncN;

/* loaded from: classes3.dex */
public class Observable<T> {

    /* renamed from: j */
    public final InterfaceC13005a<T> f27640j;

    /* renamed from: rx.Observable$a */
    public interface InterfaceC13005a<T> extends Action1<Subscriber<? super T>> {
    }

    /* renamed from: rx.Observable$b */
    public interface InterfaceC13006b<R, T> extends Func1<Subscriber<? super R>, Subscriber<? super T>> {
    }

    /* renamed from: rx.Observable$c */
    public interface InterfaceC13007c<T, R> extends Func1<Observable<T>, Observable<R>> {
    }

    public Observable(InterfaceC13005a<T> interfaceC13005a) {
        this.f27640j = interfaceC13005a;
    }

    /* renamed from: B */
    public static <T> Observable<T> m11058B(Iterable<? extends T> iterable) {
        return m11074h0(new OnSubscribeFromIterable(iterable));
    }

    /* renamed from: C */
    public static <T> Observable<T> m11059C(T[] tArr) {
        int length = tArr.length;
        return length == 0 ? (Observable<T>) EmptyObservableHolder.f26751k : length == 1 ? new ScalarSynchronousObservable(tArr[0]) : m11074h0(new OnSubscribeFromArray(tArr));
    }

    /* renamed from: D */
    public static <T> Observable<T> m11060D(Callable<? extends T> callable) {
        return m11074h0(new OnSubscribeFromCallable(callable));
    }

    /* renamed from: E */
    public static Observable<Long> m11061E(long j, long j2, TimeUnit timeUnit) {
        return m11062F(j, j2, timeUnit, Schedulers2.m10873a());
    }

    /* renamed from: F */
    public static Observable<Long> m11062F(long j, long j2, TimeUnit timeUnit, Scheduler scheduler) {
        return m11074h0(new OnSubscribeTimerPeriodically2(j, j2, timeUnit, scheduler));
    }

    /* renamed from: H */
    public static <T> Observable<T> m11063H(Observable<? extends Observable<? extends T>> observable) {
        if (observable.getClass() == ScalarSynchronousObservable.class) {
            return ((ScalarSynchronousObservable) observable).m10820k0(UtilityFunctions.a.INSTANCE);
        }
        return m11074h0(new OnSubscribeLift(observable.f27640j, OperatorMerge.b.f27083a));
    }

    /* renamed from: I */
    public static <T> Observable<T> m11064I(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m11063H(m11059C(new Observable[]{observable, observable2}));
    }

    /* renamed from: b */
    public static <T, R> Observable<R> m11065b(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN) {
        return m11074h0(new OnSubscribeCombineLatest(list, funcN));
    }

    /* renamed from: c */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> m11066c(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new C12590c(func9));
    }

    /* renamed from: d */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> m11067d(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new C12597j(func8));
    }

    /* renamed from: d0 */
    public static Observable<Long> m11068d0(long j, TimeUnit timeUnit) {
        return m11070e0(j, timeUnit, Schedulers2.m10873a());
    }

    /* renamed from: e */
    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> m11069e(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new C12596i(func7));
    }

    /* renamed from: e0 */
    public static Observable<Long> m11070e0(long j, TimeUnit timeUnit, Scheduler scheduler) {
        return m11074h0(new OnSubscribeTimerOnce2(j, timeUnit, scheduler));
    }

    /* renamed from: f */
    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> m11071f(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new C12595h(func6));
    }

    /* renamed from: g */
    public static <T1, T2, T3, T4, T5, R> Observable<R> m11072g(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4, observable5), new C12594g(func5));
    }

    /* renamed from: h */
    public static <T1, T2, T3, T4, R> Observable<R> m11073h(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4) {
        return m11065b(Arrays.asList(observable, observable2, observable3, observable4), new C12593f(func4));
    }

    /* renamed from: h0 */
    public static <T> Observable<T> m11074h0(InterfaceC13005a<T> interfaceC13005a) {
        return new Observable<>(C12774l.m10862a(interfaceC13005a));
    }

    /* renamed from: i */
    public static <T1, T2, T3, R> Observable<R> m11075i(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3) {
        return m11065b(Arrays.asList(observable, observable2, observable3), new C12592e(func3));
    }

    /* renamed from: j */
    public static <T1, T2, R> Observable<R> m11076j(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return m11065b(Arrays.asList(observable, observable2), new C12591d(func2));
    }

    /* renamed from: j0 */
    public static <T1, T2, R> Observable<R> m11077j0(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2) {
        return m11074h0(new OnSubscribeLift(new ScalarSynchronousObservable(new Observable[]{observable, observable2}).f27640j, new OperatorZip(func2)));
    }

    /* renamed from: l */
    public static <T> Observable<T> m11078l(Iterable<? extends Observable<? extends T>> iterable) {
        return m11074h0(new OnSubscribeFromIterable(iterable)).m11109n(UtilityFunctions.a.INSTANCE);
    }

    /* renamed from: m */
    public static <T> Observable<T> m11079m(Observable<? extends T> observable, Observable<? extends T> observable2) {
        return m11059C(new Object[]{observable, observable2}).m11109n(UtilityFunctions.a.INSTANCE);
    }

    /* renamed from: o */
    public static <T> Observable<T> m11080o(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        return m11074h0(new OnSubscribeCreate(action1, backpressureMode));
    }

    /* renamed from: x */
    public static <T> Observable<T> m11081x(Throwable th) {
        return m11074h0(new OnSubscribeThrow(th));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: A */
    public final <R> Observable<R> m11082A(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return getClass() == ScalarSynchronousObservable.class ? ((ScalarSynchronousObservable) this).m10820k0(func1) : m11063H(m11083G(func1));
    }

    /* renamed from: G */
    public final <R> Observable<R> m11083G(Func1<? super T, ? extends R> func1) {
        return m11074h0(new OnSubscribeMap(this, func1));
    }

    /* renamed from: J */
    public final Observable<T> m11084J(Scheduler scheduler) {
        int i = RxRingBuffer.f27283j;
        if (this instanceof ScalarSynchronousObservable) {
            return ((ScalarSynchronousObservable) this).m10821l0(scheduler);
        }
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorObserveOn2(scheduler, false, i)));
    }

    /* renamed from: K */
    public final Observable<T> m11085K() {
        return m11074h0(new OnSubscribeLift(this.f27640j, OperatorOnBackpressureBuffer.b.f26735a));
    }

    /* renamed from: L */
    public final Observable<T> m11086L() {
        return m11074h0(new OnSubscribeLift(this.f27640j, OperatorOnBackpressureLatest.a.f26740a));
    }

    /* renamed from: M */
    public final Observable<T> m11087M(Func1<? super Throwable, ? extends T> func1) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorOnErrorResumeNextViaFunction4(new OperatorOnErrorResumeNextViaFunction(func1))));
    }

    /* renamed from: N */
    public final ConnectableObservable<T> m11088N(int i) {
        if (i == Integer.MAX_VALUE) {
            Func0 func0 = OperatorReplay.f26857k;
            AtomicReference atomicReference = new AtomicReference();
            return new OperatorReplay(new OperatorReplay3(atomicReference, func0), this, atomicReference, func0);
        }
        OperatorReplay2 operatorReplay2 = new OperatorReplay2(i);
        AtomicReference atomicReference2 = new AtomicReference();
        return new OperatorReplay(new OperatorReplay3(atomicReference2, operatorReplay2), this, atomicReference2, operatorReplay2);
    }

    /* renamed from: O */
    public final Observable<T> m11089O(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        InternalObservableUtils.d dVar = new InternalObservableUtils.d(func1);
        AtomicReference<Schedulers2> atomicReference = Schedulers2.f27393a;
        return m11074h0(new OnSubscribeRedo6(this, dVar, true, false, TrampolineScheduler.f27250a));
    }

    /* renamed from: P */
    public final Observable<T> m11090P(long j, TimeUnit timeUnit) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorSampleWithTime(j, timeUnit, Schedulers2.m10873a())));
    }

    /* renamed from: Q */
    public final <R> Observable<R> m11091Q(R r, Func2<R, ? super T, R> func2) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorScan(r, func2)));
    }

    /* renamed from: R */
    public final Observable<T> m11092R() {
        return m11074h0(new OnSubscribeLift(this.f27640j, OperatorSingle.a.f27024a));
    }

    /* renamed from: S */
    public final Observable<T> m11093S(int i) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorSkip2(i)));
    }

    /* renamed from: T */
    public final Observable<T> m11094T(T t) {
        return m11079m(new ScalarSynchronousObservable(t), this);
    }

    /* renamed from: U */
    public final Subscription m11095U(Subscriber<? super T> subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("subscriber can not be null");
        }
        if (this.f27640j == null) {
            throw new IllegalStateException("onSubscribe function can not be null.");
        }
        subscriber.onStart();
        if (!(subscriber instanceof SafeSubscriber)) {
            subscriber = new SafeSubscriber(subscriber);
        }
        try {
            InterfaceC13005a interfaceC13005aCall = this.f27640j;
            Func2<Observable, InterfaceC13005a, InterfaceC13005a> func2 = C12774l.f27378e;
            if (func2 != null) {
                interfaceC13005aCall = func2.call(this, interfaceC13005aCall);
            }
            interfaceC13005aCall.call(subscriber);
            Func1<Subscription, Subscription> func1 = C12774l.f27380g;
            return func1 != null ? func1.call(subscriber) : subscriber;
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            if (subscriber.isUnsubscribed()) {
                C12774l.m10863b(C12774l.m10864c(th));
            } else {
                try {
                    subscriber.onError(C12774l.m10864c(th));
                } catch (Throwable th2) {
                    C3404f.m4325o1(th2);
                    StringBuilder sbM833U = outline.m833U("Error occurred attempting to subscribe [");
                    sbM833U.append(th.getMessage());
                    sbM833U.append("] and then again while trying to pass to onError.");
                    OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbM833U.toString(), th2);
                    C12774l.m10864c(onErrorFailedException);
                    throw onErrorFailedException;
                }
            }
            return Subscriptions.f27422a;
        }
    }

    /* renamed from: V */
    public final Subscription m11096V(Action1<? super T> action1) {
        return m11095U(new ActionSubscriber(action1, InternalObservableUtils.f27272l, Actions2.f26710a));
    }

    /* renamed from: W */
    public final Subscription m11097W(Action1<? super T> action1, Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        }
        if (action12 != null) {
            return m11095U(new ActionSubscriber(action1, action12, Actions2.f26710a));
        }
        throw new IllegalArgumentException("onError can not be null");
    }

    /* renamed from: X */
    public final Observable<T> m11098X(Scheduler scheduler) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).m10821l0(scheduler) : m11074h0(new OperatorSubscribeOn(this, scheduler, !(this.f27640j instanceof OnSubscribeCreate)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Y */
    public final <R> Observable<R> m11099Y(Func1<? super T, ? extends Observable<? extends R>> func1) {
        Observable<R> observableM11083G = m11083G(func1);
        return m11074h0(new OnSubscribeLift(observableM11083G.f27640j, OperatorSwitch2.a.f27126a));
    }

    /* renamed from: Z */
    public final Observable<T> m11100Z(int i) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorTake2(i)));
    }

    /* renamed from: a */
    public final Observable<List<T>> m11101a(long j, TimeUnit timeUnit) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorBufferWithTime2(j, j, timeUnit, Integer.MAX_VALUE, Schedulers2.m10873a())));
    }

    /* renamed from: a0 */
    public final <E> Observable<T> m11102a0(Observable<? extends E> observable) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorTakeUntil3(observable)));
    }

    /* renamed from: b0 */
    public final Observable<T> m11103b0(Func1<? super T, Boolean> func1) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorTakeUntilPredicate2(func1)));
    }

    /* renamed from: c0 */
    public final Observable<T> m11104c0(long j, TimeUnit timeUnit) {
        return m11074h0(new OnSubscribeTimeoutTimedWithFallback(this, j, timeUnit, Schedulers2.m10873a(), null));
    }

    /* renamed from: f0 */
    public final Observable<List<T>> m11105f0() {
        return m11074h0(new OnSubscribeLift(this.f27640j, OperatorToObservableList2.a.f26954a));
    }

    /* renamed from: g0 */
    public final <K, V> Observable<Map<K, V>> m11106g0(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        return m11074h0(new OnSubscribeToMap(this, func1, func12));
    }

    /* renamed from: i0 */
    public final Subscription m11107i0(Subscriber<? super T> subscriber) {
        try {
            subscriber.onStart();
            InterfaceC13005a interfaceC13005aCall = this.f27640j;
            Func2<Observable, InterfaceC13005a, InterfaceC13005a> func2 = C12774l.f27378e;
            if (func2 != null) {
                interfaceC13005aCall = func2.call(this, interfaceC13005aCall);
            }
            interfaceC13005aCall.call(subscriber);
            Func1<Subscription, Subscription> func1 = C12774l.f27380g;
            return func1 != null ? func1.call(subscriber) : subscriber;
        } catch (Throwable th) {
            C3404f.m4325o1(th);
            try {
                subscriber.onError(C12774l.m10864c(th));
                return Subscriptions.f27422a;
            } catch (Throwable th2) {
                C3404f.m4325o1(th2);
                StringBuilder sbM833U = outline.m833U("Error occurred attempting to subscribe [");
                sbM833U.append(th.getMessage());
                sbM833U.append("] and then again while trying to pass to onError.");
                OnErrorFailedException onErrorFailedException = new OnErrorFailedException(sbM833U.toString(), th2);
                C12774l.m10864c(onErrorFailedException);
                throw onErrorFailedException;
            }
        }
    }

    /* renamed from: k */
    public <R> Observable<R> m11108k(InterfaceC13007c<? super T, ? extends R> interfaceC13007c) {
        return (Observable) interfaceC13007c.call(this);
    }

    /* renamed from: n */
    public final <R> Observable<R> m11109n(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return this instanceof ScalarSynchronousObservable ? ((ScalarSynchronousObservable) this).m10820k0(func1) : m11074h0(new OnSubscribeConcatMap2(this, func1, 2, 0));
    }

    /* renamed from: p */
    public final Observable<T> m11110p(long j, TimeUnit timeUnit) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorDebounceWithTime2(j, timeUnit, Schedulers2.m10873a())));
    }

    /* renamed from: q */
    public final Observable<T> m11111q(long j, TimeUnit timeUnit) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorDelay2(j, timeUnit, Schedulers2.m10873a())));
    }

    /* renamed from: r */
    public final Observable<T> m11112r() {
        return m11074h0(new OnSubscribeLift(this.f27640j, OperatorDistinctUntilChanged2.a.f27059a));
    }

    /* renamed from: s */
    public final Observable<T> m11113s(Func2<? super T, ? super T, Boolean> func2) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorDistinctUntilChanged2(func2)));
    }

    /* renamed from: t */
    public final Observable<T> m11114t(Action1<? super Throwable> action1) {
        Actions2.a aVar = Actions2.f26710a;
        return m11074h0(new OnSubscribeDoOnEach(this, new ActionObserver(aVar, action1, aVar)));
    }

    /* renamed from: u */
    public final Observable<T> m11115u(Action1<? super T> action1) {
        Actions2.a aVar = Actions2.f26710a;
        return m11074h0(new OnSubscribeDoOnEach(this, new ActionObserver(action1, aVar, aVar)));
    }

    /* renamed from: v */
    public final Observable<T> m11116v(Action0 action0) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorDoOnSubscribe(action0)));
    }

    /* renamed from: w */
    public final Observable<T> m11117w(Action0 action0) {
        return m11074h0(new OnSubscribeLift(this.f27640j, new OperatorDoOnUnsubscribe(action0)));
    }

    /* renamed from: y */
    public final Observable<T> m11118y(Func1<? super T, Boolean> func1) {
        return m11074h0(new OnSubscribeFilter(this, func1));
    }

    /* renamed from: z */
    public final Observable<T> m11119z() {
        return m11100Z(1).m11092R();
    }
}
