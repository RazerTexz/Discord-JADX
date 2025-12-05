package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* compiled from: ClearTextEndIconDelegate.java */
/* renamed from: b.i.a.g.j.c, reason: use source file name */
/* loaded from: classes3.dex */
public class ClearTextEndIconDelegate3 extends AnimatorListenerAdapter {

    /* renamed from: a */
    public final /* synthetic */ ClearTextEndIconDelegate f11785a;

    public ClearTextEndIconDelegate3(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f11785a = clearTextEndIconDelegate;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        this.f11785a.f11819a.setEndIconVisible(false);
    }
}
