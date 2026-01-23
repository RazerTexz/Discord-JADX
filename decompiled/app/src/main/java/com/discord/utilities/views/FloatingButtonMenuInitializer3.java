package com.discord.utilities.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import com.discord.utilities.views.FloatingButtonMenuInitializer;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.views.FloatingButtonMenuInitializer$animatorFactorySlideUp$1, reason: use source file name */
/* JADX INFO: compiled from: FloatingButtonMenuInitializer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FloatingButtonMenuInitializer3 implements FloatingButtonMenuInitializer.AnimatorFactory<View> {
    @Override // com.discord.utilities.views.FloatingButtonMenuInitializer.AnimatorFactory
    public Animator createAnimator(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        return ObjectAnimator.ofFloat(view, (Property<View, Float>) View.TRANSLATION_Y, view.getHeight() * 1.0f, 0.0f);
    }
}
