package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.b, reason: use source file name */
/* JADX INFO: compiled from: CircularIndeterminateAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class CircularIndeterminateAnimatorDelegate extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CircularIndeterminateAnimatorDelegate3 f11717a;

    public CircularIndeterminateAnimatorDelegate(CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3) {
        this.f11717a = circularIndeterminateAnimatorDelegate3;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        CircularIndeterminateAnimatorDelegate3 circularIndeterminateAnimatorDelegate3 = this.f11717a;
        circularIndeterminateAnimatorDelegate3.f11728m = (circularIndeterminateAnimatorDelegate3.f11728m + 4) % circularIndeterminateAnimatorDelegate3.f11727l.indicatorColors.length;
    }
}
