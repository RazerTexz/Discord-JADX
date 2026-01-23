package com.discord.widgets.channels;

import android.animation.Animator;
import com.discord.widgets.channels.WidgetChannelTopic;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1 */
/* JADX INFO: compiled from: Animator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7354x41ecd366 implements Animator.AnimatorListener {
    public final /* synthetic */ WidgetChannelTopic.C73531 this$0;

    public C7354x41ecd366(WidgetChannelTopic.C73531 c73531) {
        this.this$0 = c73531;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
        WidgetChannelTopic.access$configureEllipsis(WidgetChannelTopic.this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        Intrinsics3.checkNotNullParameter(animator, "animator");
    }
}
