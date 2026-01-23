package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.i, reason: use source file name */
/* JADX INFO: compiled from: DropdownMenuEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate2 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11814a;

    public DropdownMenuEndIconDelegate2(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11814a = dropdownMenuEndIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.f11814a.f11821c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
