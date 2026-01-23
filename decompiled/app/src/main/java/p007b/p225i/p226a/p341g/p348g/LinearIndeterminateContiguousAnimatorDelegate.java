package p007b.p225i.p226a.p341g.p348g;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.g.i, reason: use source file name */
/* JADX INFO: compiled from: LinearIndeterminateContiguousAnimatorDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class LinearIndeterminateContiguousAnimatorDelegate extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ LinearIndeterminateContiguousAnimatorDelegate2 f11742a;

    public LinearIndeterminateContiguousAnimatorDelegate(LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2) {
        this.f11742a = linearIndeterminateContiguousAnimatorDelegate2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        LinearIndeterminateContiguousAnimatorDelegate2 linearIndeterminateContiguousAnimatorDelegate2 = this.f11742a;
        linearIndeterminateContiguousAnimatorDelegate2.f11747h = (linearIndeterminateContiguousAnimatorDelegate2.f11747h + 1) % linearIndeterminateContiguousAnimatorDelegate2.f11746g.indicatorColors.length;
        linearIndeterminateContiguousAnimatorDelegate2.f11748i = true;
    }
}
