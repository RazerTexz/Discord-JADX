package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Transition.kt */
/* renamed from: androidx.core.transition.TransitionKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Transition2 {

    /* compiled from: Transition.kt */
    /* renamed from: androidx.core.transition.TransitionKt$addListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    /* renamed from: androidx.core.transition.TransitionKt$addListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    /* renamed from: androidx.core.transition.TransitionKt$addListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    /* renamed from: androidx.core.transition.TransitionKt$addListener$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* compiled from: Transition.kt */
    /* renamed from: androidx.core.transition.TransitionKt$addListener$5, reason: invalid class name */
    public static final class AnonymousClass5 extends Lambda implements Function1<Transition, Unit> {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        public AnonymousClass5() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition transition, Function1<? super Transition, Unit> function1, Function1<? super Transition, Unit> function12, Function1<? super Transition, Unit> function13, Function1<? super Transition, Unit> function14, Function1<? super Transition, Unit> function15) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onEnd");
        Intrinsics3.checkNotNullParameter(function12, "onStart");
        Intrinsics3.checkNotNullParameter(function13, "onCancel");
        Intrinsics3.checkNotNullParameter(function14, "onResume");
        Intrinsics3.checkNotNullParameter(function15, "onPause");
        Transition3 transition3 = new Transition3(function1, function14, function15, function13, function12);
        transition.addListener(transition3);
        return transition3;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, Function1 function1, Function1 function12, Function1 function13, Function1 function14, Function1 function15, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnonymousClass2.INSTANCE;
        }
        Function1 function16 = function12;
        if ((i & 4) != 0) {
            function13 = AnonymousClass3.INSTANCE;
        }
        Function1 function17 = function13;
        if ((i & 8) != 0) {
            function14 = AnonymousClass4.INSTANCE;
        }
        if ((i & 16) != 0) {
            function15 = AnonymousClass5.INSTANCE;
        }
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onEnd");
        Intrinsics3.checkNotNullParameter(function16, "onStart");
        Intrinsics3.checkNotNullParameter(function17, "onCancel");
        Intrinsics3.checkNotNullParameter(function14, "onResume");
        Intrinsics3.checkNotNullParameter(function15, "onPause");
        Transition3 transition3 = new Transition3(function1, function14, function15, function17, function16);
        transition.addListener(transition3);
        return transition3;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition4 transition4 = new Transition4(function1);
        transition.addListener(transition4);
        return transition4;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition5 transition5 = new Transition5(function1);
        transition.addListener(transition5);
        return transition5;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition6 transition6 = new Transition6(function1);
        transition.addListener(transition6);
        return transition6;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition7 transition7 = new Transition7(function1);
        transition.addListener(transition7);
        return transition7;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition transition, Function1<? super Transition, Unit> function1) {
        Intrinsics3.checkNotNullParameter(transition, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        Transition8 transition8 = new Transition8(function1);
        transition.addListener(transition8);
        return transition8;
    }
}
