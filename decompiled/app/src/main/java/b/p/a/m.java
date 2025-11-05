package b.p.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewGroup;

/* compiled from: SwipeDismissTouchListener.kt */
/* loaded from: classes3.dex */
public final class m extends AnimatorListenerAdapter {
    public final /* synthetic */ l a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ViewGroup.LayoutParams f1975b;
    public final /* synthetic */ int c;

    public m(l lVar, ViewGroup.LayoutParams layoutParams, int i) {
        this.a = lVar;
        this.f1975b = layoutParams;
        this.c = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        d0.z.d.m.checkNotNullParameter(animator, "animation");
        l lVar = this.a;
        lVar.u.onDismiss(lVar.t);
        this.a.t.setAlpha(1.0f);
        this.a.t.setTranslationX(0.0f);
        ViewGroup.LayoutParams layoutParams = this.f1975b;
        layoutParams.height = this.c;
        this.a.t.setLayoutParams(layoutParams);
    }
}
