package p007b.p225i.p226a.p341g.p351j;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: renamed from: b.i.a.g.j.l, reason: use source file name */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate5 extends AnimatorListenerAdapter {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11818a;

    public DropdownMenuEndIconDelegate5(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11818a = dropdownMenuEndIconDelegate;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate = this.f11818a;
        dropdownMenuEndIconDelegate.f11821c.setChecked(dropdownMenuEndIconDelegate.f11797j);
        this.f11818a.f11803p.start();
    }
}
