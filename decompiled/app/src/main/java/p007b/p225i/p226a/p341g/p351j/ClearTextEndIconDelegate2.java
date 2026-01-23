package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.j.b, reason: use source file name */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClearTextEndIconDelegate2 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ClearTextEndIconDelegate f11784a;

    public ClearTextEndIconDelegate2(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f11784a = clearTextEndIconDelegate;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        this.f11784a.f11819a.setEndIconVisible(true);
    }
}
