package p007b.p225i.p226a.p341g.p351j;

import android.animation.ValueAnimator;
import androidx.annotation.NonNull;

/* compiled from: ClearTextEndIconDelegate.java */
/* renamed from: b.i.a.g.j.e, reason: use source file name */
/* loaded from: classes3.dex */
public class ClearTextEndIconDelegate5 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a */
    public final /* synthetic */ ClearTextEndIconDelegate f11787a;

    public ClearTextEndIconDelegate5(ClearTextEndIconDelegate clearTextEndIconDelegate) {
        this.f11787a = clearTextEndIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
        float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.f11787a.f11821c.setScaleX(fFloatValue);
        this.f11787a.f11821c.setScaleY(fFloatValue);
    }
}
