package com.discord.widgets.notice;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: NoticePopup.kt */
/* renamed from: com.discord.widgets.notice.NoticePopup$enqueue$notice$1$3$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class NoticePopup5 implements View.OnTouchListener {
    public final /* synthetic */ ValueAnimator $viewAutoDismissAnimator;

    public NoticePopup5(ValueAnimator valueAnimator) {
        this.$viewAutoDismissAnimator = valueAnimator;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Intrinsics3.checkNotNullExpressionValue(motionEvent, "event");
        if (motionEvent.getAction() != 0) {
            return false;
        }
        NoticePopup.access$cancelCountdown(NoticePopup.INSTANCE, this.$viewAutoDismissAnimator);
        return false;
    }
}
