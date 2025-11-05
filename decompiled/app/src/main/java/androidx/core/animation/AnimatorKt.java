package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt {

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Animator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            m.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Animator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            m.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Animator, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            m.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addListener$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<Animator, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            m.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addPauseListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Animator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            m.checkNotNullParameter(animator, "it");
        }
    }

    /* compiled from: Animator.kt */
    /* renamed from: androidx.core.animation.AnimatorKt$addPauseListener$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Animator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Animator animator) {
            invoke2(animator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Animator animator) {
            m.checkNotNullParameter(animator, "it");
        }
    }

    public static final Animator.AnimatorListener addListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12, Function1<? super Animator, Unit> function13, Function1<? super Animator, Unit> function14) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onEnd");
        m.checkNotNullParameter(function12, "onStart");
        m.checkNotNullParameter(function13, "onCancel");
        m.checkNotNullParameter(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, Function1 function1, Function1 function12, Function1 function13, Function1 function14, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnonymousClass2.INSTANCE;
        }
        if ((i & 4) != 0) {
            function13 = AnonymousClass3.INSTANCE;
        }
        if ((i & 8) != 0) {
            function14 = AnonymousClass4.INSTANCE;
        }
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onEnd");
        m.checkNotNullParameter(function12, "onStart");
        m.checkNotNullParameter(function13, "onCancel");
        m.checkNotNullParameter(function14, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(function14, function1, function13, function12);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, Function1<? super Animator, Unit> function1, Function1<? super Animator, Unit> function12) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onResume");
        m.checkNotNullParameter(function12, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = AnonymousClass1.INSTANCE;
        }
        if ((i & 2) != 0) {
            function12 = AnonymousClass2.INSTANCE;
        }
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "onResume");
        m.checkNotNullParameter(function12, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(function12, function1);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnCancel$$inlined$addListener$default$1 animatorKt$doOnCancel$$inlined$addListener$default$1 = new AnimatorKt$doOnCancel$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnCancel$$inlined$addListener$default$1);
        return animatorKt$doOnCancel$$inlined$addListener$default$1;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnEnd$$inlined$addListener$default$1 animatorKt$doOnEnd$$inlined$addListener$default$1 = new AnimatorKt$doOnEnd$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnEnd$$inlined$addListener$default$1);
        return animatorKt$doOnEnd$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnPause$$inlined$addPauseListener$default$1 animatorKt$doOnPause$$inlined$addPauseListener$default$1 = new AnimatorKt$doOnPause$$inlined$addPauseListener$default$1(function1);
        animator.addPauseListener(animatorKt$doOnPause$$inlined$addPauseListener$default$1);
        return animatorKt$doOnPause$$inlined$addPauseListener$default$1;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnRepeat$$inlined$addListener$default$1 animatorKt$doOnRepeat$$inlined$addListener$default$1 = new AnimatorKt$doOnRepeat$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnRepeat$$inlined$addListener$default$1);
        return animatorKt$doOnRepeat$$inlined$addListener$default$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnResume$$inlined$addPauseListener$default$1 animatorKt$doOnResume$$inlined$addPauseListener$default$1 = new AnimatorKt$doOnResume$$inlined$addPauseListener$default$1(function1);
        animator.addPauseListener(animatorKt$doOnResume$$inlined$addPauseListener$default$1);
        return animatorKt$doOnResume$$inlined$addPauseListener$default$1;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, Function1<? super Animator, Unit> function1) {
        m.checkNotNullParameter(animator, "<this>");
        m.checkNotNullParameter(function1, "action");
        AnimatorKt$doOnStart$$inlined$addListener$default$1 animatorKt$doOnStart$$inlined$addListener$default$1 = new AnimatorKt$doOnStart$$inlined$addListener$default$1(function1);
        animator.addListener(animatorKt$doOnStart$$inlined$addListener$default$1);
        return animatorKt$doOnStart$$inlined$addListener$default$1;
    }
}
