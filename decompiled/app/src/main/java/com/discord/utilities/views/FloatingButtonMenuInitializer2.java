package com.discord.utilities.views;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.res.Resources;
import android.view.View;
import com.discord.utilities.views.FloatingButtonMenuInitializer;
import d0.z.d.Intrinsics3;

/* compiled from: FloatingButtonMenuInitializer.kt */
/* renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$animatorFactoryFadeIn$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer2 implements FloatingButtonMenuInitializer.AnimatorFactory<View> {
    public final /* synthetic */ FloatingButtonMenuInitializer this$0;

    public FloatingButtonMenuInitializer2(FloatingButtonMenuInitializer floatingButtonMenuInitializer) {
        this.this$0 = floatingButtonMenuInitializer;
    }

    @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
    public Animator createAnimator(View view) throws Resources.NotFoundException {
        Intrinsics3.checkNotNullParameter(view, "view");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(FloatingButtonMenuInitializer.access$getContext$p(this.this$0), R.animator.fade_in);
        animatorLoadAnimator.setTarget(view);
        return animatorLoadAnimator;
    }
}
