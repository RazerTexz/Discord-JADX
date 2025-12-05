package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: CircularIndeterminateAnimatorDelegate.java */
/* renamed from: b.i.a.g.g.c, reason: use source file name */
/* loaded from: classes3.dex */
public class CircularIndeterminateAnimatorDelegate2 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ CircularIndeterminateAnimatorDelegate3 f11718a;

    public CircularIndeterminateAnimatorDelegate2(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
        this.f11718a = circularIndeterminateAnimatorDelegate3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.f11718a.mo6123a();
        CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3 = this.f11718a;
        circularIndeterminateAnimatorDelegate3.f11731p.onAnimationEnd(circularIndeterminateAnimatorDelegate3.f11736a);
    }
}
