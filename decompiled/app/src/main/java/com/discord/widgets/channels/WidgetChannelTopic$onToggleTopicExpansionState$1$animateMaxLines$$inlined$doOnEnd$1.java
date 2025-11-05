package com.discord.widgets.channels;

import android.animation.Animator;
import com.discord.widgets.channels.WidgetChannelTopic;
import d0.z.d.m;

/* compiled from: Animator.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1 implements Animator.AnimatorListener {
    public final /* synthetic */ WidgetChannelTopic.AnonymousClass1 this$0;

    public WidgetChannelTopic$onToggleTopicExpansionState$1$animateMaxLines$$inlined$doOnEnd$1(WidgetChannelTopic.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
        WidgetChannelTopic.access$configureEllipsis(WidgetChannelTopic.this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        m.checkNotNullParameter(animator, "animator");
    }
}
