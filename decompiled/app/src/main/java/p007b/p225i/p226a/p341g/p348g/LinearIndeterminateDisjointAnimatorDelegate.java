package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: LinearIndeterminateDisjointAnimatorDelegate.java */
/* renamed from: b.i.a.g.g.k, reason: use source file name */
/* loaded from: classes3.dex */
public class LinearIndeterminateDisjointAnimatorDelegate extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ LinearIndeterminateDisjointAnimatorDelegate2 f11750a;

    public LinearIndeterminateDisjointAnimatorDelegate(LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2) {
        this.f11750a = linearIndeterminateDisjointAnimatorDelegate2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2 = this.f11750a;
        if (linearIndeterminateDisjointAnimatorDelegate2.f11760m) {
            linearIndeterminateDisjointAnimatorDelegate2.f11754g.setRepeatCount(-1);
            LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate22 = this.f11750a;
            linearIndeterminateDisjointAnimatorDelegate22.f11761n.onAnimationEnd(linearIndeterminateDisjointAnimatorDelegate22.f11736a);
            this.f11750a.f11760m = false;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        LinearIndeterminateDisjointAnimatorDelegate2 linearIndeterminateDisjointAnimatorDelegate2 = this.f11750a;
        linearIndeterminateDisjointAnimatorDelegate2.f11757j = (linearIndeterminateDisjointAnimatorDelegate2.f11757j + 1) % linearIndeterminateDisjointAnimatorDelegate2.f11756i.indicatorColors.length;
        linearIndeterminateDisjointAnimatorDelegate2.f11758k = true;
    }
}
