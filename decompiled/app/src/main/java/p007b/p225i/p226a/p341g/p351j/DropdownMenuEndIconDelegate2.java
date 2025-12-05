package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: DropdownMenuEndIconDelegate.java */
/* renamed from: b.i.a.g.j.i, reason: use source file name */
/* loaded from: classes3.dex */
public class DropdownMenuEndIconDelegate2 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ DropdownMenuEndIconDelegate f11814a;

    public DropdownMenuEndIconDelegate2(DropdownMenuEndIconDelegate dropdownMenuEndIconDelegate) {
        this.f11814a = dropdownMenuEndIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.f11814a.f11821c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
