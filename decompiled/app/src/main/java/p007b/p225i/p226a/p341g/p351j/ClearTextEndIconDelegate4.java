package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.i.a.g.j.d, reason: use source file name */
/* JADX INFO: compiled from: ClearTextEndIconDelegate.java */
/* JADX INFO: loaded from: classes3.dex */
public class ClearTextEndIconDelegate4 implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ClearTextEndIconDelegate f11786a;

    public ClearTextEndIconDelegate4(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f11786a = clearTextEndIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        this.f11786a.f11821c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }
}
