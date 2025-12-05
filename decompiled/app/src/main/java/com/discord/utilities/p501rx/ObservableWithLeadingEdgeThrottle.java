package com.discord.utilities.p501rx;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p637j0.p641k.C12590c;
import p637j0.p641k.C12591d;
import p637j0.p641k.C12592e;
import p637j0.p641k.C12593f;
import p637j0.p641k.C12594g;
import p637j0.p641k.C12595h;
import p637j0.p641k.C12596i;
import p637j0.p641k.C12597j;
import p637j0.p641k.Func1;
import p637j0.p642l.p643a.OnSubscribeLift;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.Scheduler;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;
import p658rx.functions.Func5;
import p658rx.functions.Func6;
import p658rx.functions.Func7;
import p658rx.functions.Func8;
import p658rx.functions.Func9;
import p658rx.functions.FuncN;

/* loaded from: classes2.dex */
public class ObservableWithLeadingEdgeThrottle {
    private static final FuncN IDENTITY_FUNC_N = new C68921();

    /* renamed from: com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle$1 */
    public static class C68921 implements FuncN {
        @Override // p658rx.functions.FuncN
        public Object call(Object... objArr) {
            return objArr;
        }
    }

    /* renamed from: com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle$2 */
    public static class C68932 implements Func1 {
        public final /* synthetic */ FuncN val$combineFunction;

        public C68932(FuncN funcN) {
            this.val$combineFunction = funcN;
        }

        @Override // p637j0.p641k.Func1
        public Object call(Object obj) {
            return this.val$combineFunction.call((Object[]) obj);
        }
    }

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2), new C12591d(func2), j, timeUnit);
    }

    public static <T1, T2, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Func2<? super T1, ? super T2, ? extends R> func2, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2), new C12591d(func2), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3), new C12592e(func3), j, timeUnit);
    }

    public static <T1, T2, T3, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Func3<? super T1, ? super T2, ? super T3, ? extends R> func3, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3), new C12592e(func3), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4), new C12593f(func4), j, timeUnit);
    }

    public static <T1, T2, T3, T4, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Func4<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> func4, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4), new C12593f(func4), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5), new C12594g(func5), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Func5<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> func5, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5), new C12594g(func5), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new C12595h(func6), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Func6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> func6, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6), new C12595h(func6), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new C12596i(func7), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Func7<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> func7, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7), new C12596i(func7), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new C12597j(func8), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Func8<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> func8, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8), new C12597j(func8), j, timeUnit, scheduler);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9, long j, TimeUnit timeUnit) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new C12590c(func9), j, timeUnit);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> Observable<R> combineLatest(Observable<? extends T1> observable, Observable<? extends T2> observable2, Observable<? extends T3> observable3, Observable<? extends T4> observable4, Observable<? extends T5> observable5, Observable<? extends T6> observable6, Observable<? extends T7> observable7, Observable<? extends T8> observable8, Observable<? extends T9> observable9, Func9<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> func9, long j, TimeUnit timeUnit, Scheduler scheduler) {
        return combineLatest(Arrays.asList(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), new C12590c(func9), j, timeUnit, scheduler);
    }

    private static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN, long j, TimeUnit timeUnit, Scheduler scheduler) {
        Observable observableM11065b = Observable.m11065b(list, IDENTITY_FUNC_N);
        return Observable.m11074h0(new OnSubscribeLift(observableM11065b.f27640j, new LeadingEdgeThrottle(j, timeUnit, scheduler))).m11083G(new C68932(funcN));
    }

    private static <T, R> Observable<R> combineLatest(List<? extends Observable<? extends T>> list, FuncN<? extends R> funcN, long j, TimeUnit timeUnit) {
        return combineLatest(list, funcN, j, timeUnit, Schedulers2.m10873a());
    }
}
