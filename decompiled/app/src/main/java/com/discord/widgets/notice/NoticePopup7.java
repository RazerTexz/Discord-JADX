package com.discord.widgets.notice;

import android.animation.Animator;
import kotlin.jvm.functions.Function0;

/* compiled from: NoticePopup.kt */
/* renamed from: com.discord.widgets.notice.NoticePopup$getAutoDismissAnimator$animatorListener$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopup7 implements Animator.AnimatorListener {
    public final /* synthetic */ Function0 $onEnd;

    public NoticePopup7(Function0 function0) {
        this.$onEnd = function0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animation) {
        if (animation != null) {
            animation.removeListener(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$onEnd.invoke();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animation) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animation) {
    }
}
