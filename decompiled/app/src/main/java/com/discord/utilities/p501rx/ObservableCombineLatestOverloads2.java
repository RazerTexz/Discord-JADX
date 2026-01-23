package com.discord.utilities.p501rx;

import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function22;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.functions.Func4;
import p658rx.functions.Func5;
import p658rx.functions.Func6;
import p658rx.functions.Func7;
import p658rx.functions.Func8;
import p658rx.functions.Func9;

/* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt, reason: use source file name */
/* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ObservableCombineLatestOverloads2 {

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T3] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$1 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68691<T1, T2, R, T10, T3, T4, T5, T6, T7, T8, T9> implements Func2<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, R> {
        public final /* synthetic */ Function10 $combineFunction;

        public C68691(Function10 function10) {
            this.$combineFunction = function10;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((ObservableCombineLatestOverloads) obj, obj2);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T4, T5, T6, T10, T7, T8, T9, T11] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$2 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68702<T1, T2, T3, R, T10, T11, T4, T5, T6, T7, T8, T9> implements Func3<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, R> {
        public final /* synthetic */ Function11 $combineFunction;

        public C68702(Function11 function11) {
            this.$combineFunction = function11;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T5, T6, T7, T8, T9, T10, T12, T11] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$3 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68713<T1, T2, T3, T4, R, T10, T11, T12, T5, T6, T7, T8, T9> implements Func4<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, R> {
        public final /* synthetic */ Function12 $combineFunction;

        public C68713(Function12 function12) {
            this.$combineFunction = function12;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func4
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3, obj4);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T6, T7, T8, T9, T10, T12, T11, T13] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$4 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68724<T1, T2, T3, T4, T5, R, T10, T11, T12, T13, T6, T7, T8, T9> implements Func5<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, R> {
        public final /* synthetic */ Function13 $combineFunction;

        public C68724(Function13 function13) {
            this.$combineFunction = function13;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func5
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3, obj4, obj5);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T12, T11, T14, T13] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$5 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68735<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T7, T8, T9> implements Func6<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, R> {
        public final /* synthetic */ Function14 $combineFunction;

        public C68735(Function14 function14) {
            this.$combineFunction = function14;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func6
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3, obj4, obj5, obj6);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T8, T9, T10, T12, T11, T14, T13, T15] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$6 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68746<T1, T2, T3, T4, T5, T6, T7, R, T10, T11, T12, T13, T14, T15, T8, T9> implements Func7<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, R> {
        public final /* synthetic */ Function15 $combineFunction;

        public C68746(Function15 function15) {
            this.$combineFunction = function15;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func7
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3, obj4, obj5, obj6, obj7);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T9, T10, T12, T11, T14, T13, T16, T15] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$7 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68757<T1, T2, T3, T4, T5, T6, T7, T8, R, T10, T11, T12, T13, T14, T15, T16, T9> implements Func8<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, R> {
        public final /* synthetic */ Function16 $combineFunction;

        public C68757(Function16 function16) {
            this.$combineFunction = function16;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15, t16);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func8
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T10, T12, T11, T14, T13, T16, T15, T17] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$8 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68768<T1, T2, T3, T4, T5, T6, T7, T8, T9, R, T10, T11, T12, T13, T14, T15, T16, T17> implements Func9<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, T10, T11, T12, T13, T14, T15, T16, T17, R> {
        public final /* synthetic */ Function17 $combineFunction;

        public C68768(Function17 function17) {
            this.$combineFunction = function17;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, T10 t10, T11 t11, T12 t12, T13 t13, T14 t14, T15 t15, T16 t16, T17 t17) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), t10, t11, t12, t13, t14, t15, t16, t17);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func9
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return call((ObservableCombineLatestOverloads) obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T7, T8, T9, T10, T21, T20, T12, T11, T22, T14, T13, T16, T15, T18, T17, T19] */
    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$combineLatest$9 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68779<T1, T2, T3, T4, T5, T6, R, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, T7, T8, T9> implements Func6<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>, ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18>, T19, T20, T21, T22, R> {
        public final /* synthetic */ Function22 $combineFunction;

        public C68779(Function22 function22) {
            this.$combineFunction = function22;
        }

        public final R call(ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> observableCombineLatestOverloads, ObservableCombineLatestOverloads<T10, T11, T12, T13, T14, T15, T16, T17, T18> observableCombineLatestOverloads2, T19 t19, T20 t20, T21 t21, T22 t22) {
            return (R) this.$combineFunction.invoke(observableCombineLatestOverloads.getT1(), observableCombineLatestOverloads.getT2(), observableCombineLatestOverloads.getT3(), observableCombineLatestOverloads.getT4(), observableCombineLatestOverloads.getT5(), observableCombineLatestOverloads.getT6(), observableCombineLatestOverloads.getT7(), observableCombineLatestOverloads.getT8(), observableCombineLatestOverloads.getT9(), observableCombineLatestOverloads2.getT1(), observableCombineLatestOverloads2.getT2(), observableCombineLatestOverloads2.getT3(), observableCombineLatestOverloads2.getT4(), observableCombineLatestOverloads2.getT5(), observableCombineLatestOverloads2.getT6(), observableCombineLatestOverloads2.getT7(), observableCombineLatestOverloads2.getT8(), observableCombineLatestOverloads2.getT9(), t19, t20, t21, t22);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func6
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            return call((ObservableCombineLatestOverloads) obj, (ObservableCombineLatestOverloads) obj2, obj3, obj4, obj5, obj6);
        }
    }

    /* JADX INFO: renamed from: com.discord.utilities.rx.ObservableCombineLatestOverloadsKt$createHolderObservable$1 */
    /* JADX INFO: compiled from: ObservableCombineLatestOverloads.kt */
    public static final class C68781<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<T1, T2, T3, T4, T5, T6, T7, T8, T9, ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> {
        public static final C68781 INSTANCE = new C68781();

        @Override // p658rx.functions.Func9
        public final ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9> call(T1 t1, T2 t2, T3 t3, T4 t4, T5 t5, T6 t6, T7 t7, T8 t8, T9 t9) {
            return new ObservableCombineLatestOverloads<>(t1, t2, t3, t4, t5, t6, t7, t8, t9);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p658rx.functions.Func9
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9) {
            return call(obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
        }
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Function10<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? extends R> function10) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(function10, "combineFunction");
        Observable<R> observableM11076j = Observable.m11076j(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, new C68691(function10));
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n        .comb…t10\n          )\n        }");
        return observableM11076j;
    }

    private static final <T1, T2, T3, T4, T5, T6, T7, T8, T9> Observable<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> createHolderObservable(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9) {
        Observable<ObservableCombineLatestOverloads<T1, T2, T3, T4, T5, T6, T7, T8, T9>> observableM11066c = Observable.m11066c(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9, C68781.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11066c, "Observable\n    .combineL…t5, t6, t7, t8, t9)\n    }");
        return observableM11066c;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Function11<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? extends R> function11) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(function11, "combineFunction");
        Observable<R> observableM11075i = Observable.m11075i(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, new C68702(function11));
        Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable\n        .comb…t11\n          )\n        }");
        return observableM11075i;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Function12<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? extends R> function12) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(function12, "combineFunction");
        Observable<R> observableM11073h = Observable.m11073h(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, new C68713(function12));
        Intrinsics3.checkNotNullExpressionValue(observableM11073h, "Observable\n        .comb…t12\n          )\n        }");
        return observableM11073h;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Function13<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? extends R> function13) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(function13, "combineFunction");
        Observable<R> observableM11072g = Observable.m11072g(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, new C68724(function13));
        Intrinsics3.checkNotNullExpressionValue(observableM11072g, "Observable\n        .comb…t13\n          )\n        }");
        return observableM11072g;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Function14<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? extends R> function14) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(function14, "combineFunction");
        Observable<R> observableM11071f = Observable.m11071f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, new C68735(function14));
        Intrinsics3.checkNotNullExpressionValue(observableM11071f, "Observable\n        .comb…t14\n          )\n        }");
        return observableM11071f;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Function15<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? extends R> function15) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(function15, "combineFunction");
        Observable<R> observableM11069e = Observable.m11069e(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, new C68746(function15));
        Intrinsics3.checkNotNullExpressionValue(observableM11069e, "Observable\n        .comb…t15\n          )\n        }");
        return observableM11069e;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Function16<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? extends R> function16) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(function16, "combineFunction");
        Observable<R> observableM11067d = Observable.m11067d(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, new C68757(function16));
        Intrinsics3.checkNotNullExpressionValue(observableM11067d, "Observable\n        .comb…t16\n          )\n        }");
        return observableM11067d;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Function17<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? extends R> function17) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(observable17, "o17");
        Intrinsics3.checkNotNullParameter(function17, "combineFunction");
        Observable<R> observableM11066c = Observable.m11066c(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, new C68768(function17));
        Intrinsics3.checkNotNullExpressionValue(observableM11066c, "Observable\n        .comb…t17\n          )\n        }");
        return observableM11066c;
    }

    public static final <T1, T2, T3, T4, T5, T6, T7, T8, T9, T10, T11, T12, T13, T14, T15, T16, T17, T18, T19, T20, T21, T22, R> Observable<R> combineLatest(Observable<T1> observable, Observable<T2> observable2, Observable<T3> observable3, Observable<T4> observable4, Observable<T5> observable5, Observable<T6> observable6, Observable<T7> observable7, Observable<T8> observable8, Observable<T9> observable9, Observable<T10> observable10, Observable<T11> observable11, Observable<T12> observable12, Observable<T13> observable13, Observable<T14> observable14, Observable<T15> observable15, Observable<T16> observable16, Observable<T17> observable17, Observable<T18> observable18, Observable<T19> observable19, Observable<T20> observable20, Observable<T21> observable21, Observable<T22> observable22, Function22<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? super T10, ? super T11, ? super T12, ? super T13, ? super T14, ? super T15, ? super T16, ? super T17, ? super T18, ? super T19, ? super T20, ? super T21, ? super T22, ? extends R> function22) {
        Intrinsics3.checkNotNullParameter(observable, "o1");
        Intrinsics3.checkNotNullParameter(observable2, "o2");
        Intrinsics3.checkNotNullParameter(observable3, "o3");
        Intrinsics3.checkNotNullParameter(observable4, "o4");
        Intrinsics3.checkNotNullParameter(observable5, "o5");
        Intrinsics3.checkNotNullParameter(observable6, "o6");
        Intrinsics3.checkNotNullParameter(observable7, "o7");
        Intrinsics3.checkNotNullParameter(observable8, "o8");
        Intrinsics3.checkNotNullParameter(observable9, "o9");
        Intrinsics3.checkNotNullParameter(observable10, "o10");
        Intrinsics3.checkNotNullParameter(observable11, "o11");
        Intrinsics3.checkNotNullParameter(observable12, "o12");
        Intrinsics3.checkNotNullParameter(observable13, "o13");
        Intrinsics3.checkNotNullParameter(observable14, "o14");
        Intrinsics3.checkNotNullParameter(observable15, "o15");
        Intrinsics3.checkNotNullParameter(observable16, "o16");
        Intrinsics3.checkNotNullParameter(observable17, "o17");
        Intrinsics3.checkNotNullParameter(observable18, "o18");
        Intrinsics3.checkNotNullParameter(observable19, "o19");
        Intrinsics3.checkNotNullParameter(observable20, "o20");
        Intrinsics3.checkNotNullParameter(observable21, "o21");
        Intrinsics3.checkNotNullParameter(observable22, "o22");
        Intrinsics3.checkNotNullParameter(function22, "combineFunction");
        Observable<R> observableM11071f = Observable.m11071f(createHolderObservable(observable, observable2, observable3, observable4, observable5, observable6, observable7, observable8, observable9), createHolderObservable(observable10, observable11, observable12, observable13, observable14, observable15, observable16, observable17, observable18), observable19, observable20, observable21, observable22, new C68779(function22));
        Intrinsics3.checkNotNullExpressionValue(observableM11071f, "Observable\n        .comb…22,\n          )\n        }");
        return observableM11071f;
    }
}
