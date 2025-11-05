package com.discord.utilities.rx;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function22;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.functions.Func4;
import rx.functions.Func5;
import rx.functions.Func6;
import rx.functions.Func7;
import rx.functions.Func8;
import rx.functions.Func9;

/* compiled from: ObservableCombineLatestOverloads.kt */
/* loaded from: classes2.dex */
public final class ObservableCombineLatestOverloadsKt {

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T3] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, R, T10, T3, T4, T5, T6, T7, T8, T9> implements Func2<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, R> {
        public final /* synthetic */ Function10 $combineFunction;

        public AnonymousClass1(Function10 function10) {
            this.$combineFunction = function10;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T11] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, T3, R, T10, T11, T4, T5, T6, T7, T8, T9> implements Func3<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, R> {
        public final /* synthetic */ Function11 $combineFunction;

        public AnonymousClass2(Function11 function11) {
            this.$combineFunction = function11;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T5, T6, T7, T8, T9, T10, T12, T11] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, T4, R, T10, T11, T12, T5, T6, T7, T8, T9> implements Func4<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, R> {
        public final /* synthetic */ Function12 $combineFunction;

        public AnonymousClass3(Function12 function12) {
            this.$combineFunction = function12;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func4
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T6, T7, T8, T9, T10, T12, T11, T13] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$4, reason: invalid class name */
    public static final class AnonymousClass4<T1, T2, T3, T4, T5, R, T10, T11, T12, T13, T6, T7, T8, T9> implements Func5<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, R> {
        public final /* synthetic */ Function13 $combineFunction;

        public AnonymousClass4(Function13 function13) {
            this.$combineFunction = function13;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func5
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T12, T11, T14, T13] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$5, reason: invalid class name */
    public static final class AnonymousClass5<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T7, T8, T9> implements Func6<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, R> {
        public final /* synthetic */ Function14 $combineFunction;

        public AnonymousClass5(Function14 function14) {
            this.$combineFunction = function14;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T8, T9, T10, T12, T11, T14, T13, T15] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$6, reason: invalid class name */
    public static final class AnonymousClass6<T1, T2, T3, T4, T5, T6, T7, R, T10, T11, T12, T13, T14, T15, T8, T9> implements Func7<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, R> {
        public final /* synthetic */ Function15 $combineFunction;

        public AnonymousClass6(Function15 function15) {
            this.$combineFunction = function15;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func7
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6, obj7);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T9, T10, T12, T11, T14, T13, T16, T15] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$7, reason: invalid class name */
    public static final class AnonymousClass7<T1, T2, T3, T4, T5, T6, T7, T8, R, T10, T11, T12, T13, T14, T15, T16, T9> implements Func8<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, R> {
        public final /* synthetic */ Function16 $combineFunction;

        public AnonymousClass7(Function16 function16) {
            this.$combineFunction = function16;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15, t16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func8
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6, obj7, obj8);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T10, T12, T11, T14, T13, T16, T15, T17] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$8, reason: invalid class name */
    public static final class AnonymousClass8<T1, T2, T3, T4, T5, T6, T7, T8, T9, R, T10, T11, T12, T13, T14, T15, T16, T17> implements Func9<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, T17, R> {
        public final /* synthetic */ Function17 $combineFunction;

        public AnonymousClass8(Function17 function17) {
            this.$combineFunction = function17;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16, T17 t17) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), t10, t11, t12, t13, t14, t15, t16, t17);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return call((Holder) obj, (Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>) obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T21, T20, T12, T11, T22, T14, T13, T16, T15, T18, T17, T19] */
    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$9, reason: invalid class name */
    public static final class AnonymousClass9<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T7, T8, T9> implements Func6<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>, Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18>, T19, T20, T21, T22, R> {
        public final /* synthetic */ Function22 $combineFunction;

        public AnonymousClass9(Function22 function22) {
            this.$combineFunction = function22;
        }

        public final R call(Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> holder, Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18> holder2, T19 t19, T20 t20, T21 t21, T22 t22) {
            return (R) this.$combineFunction.invoke(holder.getT1(), holder.getT2(), holder.getT3(), holder.getT4(), holder.getT5(), holder.getT6(), holder.getT7(), holder.getT8(), holder.getT9(), holder2.getT1(), holder2.getT2(), holder2.getT3(), holder2.getT4(), holder2.getT5(), holder2.getT6(), holder2.getT7(), holder2.getT8(), holder2.getT9(), t19, t20, t21, t22);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func6
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return call((Holder) obj, (Holder) obj2, (Holder<T10, T11, T12, T13, T14, T15, T16, T17, T18>) obj3, obj4, obj5, obj6);
        }
    }

    /* compiled from: ObservableCombineLatestOverloads.kt */
    /* renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$createHolderObservable$1, reason: invalid class name */
    public static final class AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // rx.functions.Func9
        public final Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9> call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            return new Holder<>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.Func9
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return call((AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R>) obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(function10, "combineFunction");
        Observable<R> observableJ = Observable.j(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, new AnonymousClass1(function10));
        m.checkNotNullExpressionValue(observableJ, "Observable\n        .comb…t10\n          )\n        }");
        return observableJ;
    }

    private static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> Observable<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> createHolderObservable(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        Observable<Holder<T1, T2, T3, T4, T5, T6, T7, T8, T9>> observableC = Observable.c(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, AnonymousClass1.INSTANCE);
        m.checkNotNullExpressionValue(observableC, "Observable\n    .combineL…t5, t6, t7, t8, t9)\n    }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(function11, "combineFunction");
        Observable<R> observableI = Observable.i(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, new AnonymousClass2(function11));
        m.checkNotNullExpressionValue(observableI, "Observable\n        .comb…t11\n          )\n        }");
        return observableI;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(function12, "combineFunction");
        Observable<R> observableH = Observable.h(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, new AnonymousClass3(function12));
        m.checkNotNullExpressionValue(observableH, "Observable\n        .comb…t12\n          )\n        }");
        return observableH;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(function13, "combineFunction");
        Observable<R> observableG = Observable.g(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, new AnonymousClass4(function13));
        m.checkNotNullExpressionValue(observableG, "Observable\n        .comb…t13\n          )\n        }");
        return observableG;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(function14, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, new AnonymousClass5(function14));
        m.checkNotNullExpressionValue(observableF, "Observable\n        .comb…t14\n          )\n        }");
        return observableF;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(function15, "combineFunction");
        Observable<R> observableE = Observable.e(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, new AnonymousClass6(function15));
        m.checkNotNullExpressionValue(observableE, "Observable\n        .comb…t15\n          )\n        }");
        return observableE;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(observable16, "o16");
        m.checkNotNullParameter(function16, "combineFunction");
        Observable<R> observableD = Observable.d(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, new AnonymousClass7(function16));
        m.checkNotNullExpressionValue(observableD, "Observable\n        .comb…t16\n          )\n        }");
        return observableD;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(observable16, "o16");
        m.checkNotNullParameter(observable17, "o17");
        m.checkNotNullParameter(function17, "combineFunction");
        Observable<R> observableC = Observable.c(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, new AnonymousClass8(function17));
        m.checkNotNullExpressionValue(observableC, "Observable\n        .comb…t17\n          )\n        }");
        return observableC;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Observable<T18> observable18, Observable<T19> observable19, Observable<T20> observable20, Observable<T21> observable21, Observable<T22> observable22, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
        m.checkNotNullParameter(observable, "o1");
        m.checkNotNullParameter(observable2, "o2");
        m.checkNotNullParameter(observable3, "o3");
        m.checkNotNullParameter(observable4, "o4");
        m.checkNotNullParameter(observable5, "o5");
        m.checkNotNullParameter(observable6, "o6");
        m.checkNotNullParameter(observable7, "o7");
        m.checkNotNullParameter(observable8, "o8");
        m.checkNotNullParameter(observable9, "o9");
        m.checkNotNullParameter(observable10, "o10");
        m.checkNotNullParameter(observable11, "o11");
        m.checkNotNullParameter(observable12, "o12");
        m.checkNotNullParameter(observable13, "o13");
        m.checkNotNullParameter(observable14, "o14");
        m.checkNotNullParameter(observable15, "o15");
        m.checkNotNullParameter(observable16, "o16");
        m.checkNotNullParameter(observable17, "o17");
        m.checkNotNullParameter(observable18, "o18");
        m.checkNotNullParameter(observable19, "o19");
        m.checkNotNullParameter(observable20, "o20");
        m.checkNotNullParameter(observable21, "o21");
        m.checkNotNullParameter(observable22, "o22");
        m.checkNotNullParameter(function22, "combineFunction");
        Observable<R> observableF = Observable.f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), createHolderObservable(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18), observable19, observable20, observable21, observable22, new AnonymousClass9(function22));
        m.checkNotNullExpressionValue(observableF, "Observable\n        .comb…22,\n          )\n        }");
        return observableF;
    }
}
