package androidx.core.transition;

import android.transition.Transition;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: androidx.core.transition.TransitionKt, reason: use source file name */
/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final class Transition2 {

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$1 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02571 extends Lambda implements Function1<Transition, Unit> {
        public static final C02571 INSTANCE = new C02571();

        public C02571() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$2 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02582 extends Lambda implements Function1<Transition, Unit> {
        public static final C02582 INSTANCE = new C02582();

        public C02582() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$3 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02593 extends Lambda implements Function1<Transition, Unit> {
        public static final C02593 INSTANCE = new C02593();

        public C02593() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$4 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02604 extends Lambda implements Function1<Transition, Unit> {
        public static final C02604 INSTANCE = new C02604();

        public C02604() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Transition transition) {
            Intrinsics3.checkNotNullParameter(transition, "it");
        }
    }

    /* JADX INFO: renamed from: androidx.core.transition.TransitionKt$addListener$5 */
    /* JADX INFO: compiled from: Transition.kt */
    public static final class C02615 extends Lambda implements Function1<Transition, Unit> {
        public static final C02615 INSTANCE = new C02615();

        public C02615() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
            invoke2(transition);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
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
            function1 = C02571.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = C02582.INSTANCE;
        }
        Function1 function16 = function12;
        if ((i & 4) != 0) {
            function13 = C02593.INSTANCE;
        }
        Function1 function17 = function13;
        if ((i & 8) != 0) {
            function14 = C02604.INSTANCE;
        }
        if ((i & 16) != 0) {
            function15 = C02615.INSTANCE;
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
