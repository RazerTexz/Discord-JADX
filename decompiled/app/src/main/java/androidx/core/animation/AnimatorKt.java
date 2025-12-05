package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt {

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$1 */
    public static final class C02061 extends Lambda implements Function1<Animator, Unit> {
        public static final C02061 INSTANCE = new C02061();

        public C02061() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$2 */
    public static final class C02072 extends Lambda implements Function1<Animator, Unit> {
        public static final C02072 INSTANCE = new C02072();

        public C02072() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$3 */
    public static final class C02083 extends Lambda implements Function1<Animator, Unit> {
        public static final C02083 INSTANCE = new C02083();

        public C02083() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$4 */
    public static final class C02094 extends Lambda implements Function1<Animator, Unit> {
        public static final C02094 INSTANCE = new C02094();

        public C02094() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addPauseListener$1 */
    public static final class C02101 extends Lambda implements Function1<Animator, Unit> {
        public static final C02101 INSTANCE = new C02101();

        public C02101() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addPauseListener$2 */
    public static final class C02112 extends Lambda implements Function1<Animator, Unit> {
        public static final C02112 INSTANCE = new C02112();

        public C02112() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "it");
        }
    }

    public static final Animator.AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13, Function1<? super Animator, Unit> function14) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onEnd");
        Intrinsics3.checkNotNullParameter(function12, "onStart");
        Intrinsics3.checkNotNullParameter(function13, "onCancel");
        Intrinsics3.checkNotNullParameter(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = C02061.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = C02072.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = C02083.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = C02094.INSTANCE;
        }
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onEnd");
        Intrinsics3.checkNotNullParameter(function12, "onStart");
        Intrinsics3.checkNotNullParameter(function13, "onCancel");
        Intrinsics3.checkNotNullParameter(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onResume");
        Intrinsics3.checkNotNullParameter(function12, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = C02101.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = C02112.INSTANCE;
        }
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "onResume");
        Intrinsics3.checkNotNullParameter(function12, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 animatorKt$doOnCancel$$inlined$addListener$default$1 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$default$1);
        return animatorKt$doOnCancel$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 animatorKt$doOnEnd$$inlined$addListener$default$1 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$default$1);
        return animatorKt$doOnEnd$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnPause$$inlined$addPauseListener$default$1 animatorKt$doOnPause$$inlined$addPauseListener$default$1 = new AnimatorKt$doOnPause$$inlined$addPauseListener$default$1(function1);
        animator.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$default$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$default$1;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 animatorKt$doOnRepeat$$inlined$addListener$default$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$default$1);
        return animatorKt$doOnRepeat$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnResume$$inlined$addPauseListener$default$1 animatorKt$doOnResume$$inlined$addPauseListener$default$1 = new AnimatorKt$doOnResume$$inlined$addPauseListener$default$1(function1);
        animator.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$default$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$default$1;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, Function1<? super Animator, Unit> function1) {
        Intrinsics3.checkNotNullParameter(animator, "<this>");
        Intrinsics3.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnStart$$inlined$addListener$default$1 animatorKt$doOnStart$$inlined$addListener$default$1 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$default$1);
        return animatorKt$doOnStart$$inlined$addListener$default$1;
    }
}
