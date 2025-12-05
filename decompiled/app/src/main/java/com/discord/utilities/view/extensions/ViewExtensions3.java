package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewExtensions.kt */
/* renamed from: com.discord.utilities.view.extensions.FadeAnimation, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewExtensions3 {
    private final Type type;
    private final ViewPropertyAnimator viewPropertyAnimator;

    /* compiled from: ViewExtensions.kt */
    /* renamed from: com.discord.utilities.view.extensions.FadeAnimation$Type */
    public enum Type {
        FADE_IN,
        FADE_OUT
    }

    public ViewExtensions3(ViewPropertyAnimator viewPropertyAnimator, Type type) {
        Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "viewPropertyAnimator");
        Intrinsics3.checkNotNullParameter(type, "type");
        this.viewPropertyAnimator = viewPropertyAnimator;
        this.type = type;
    }

    public final Type getType() {
        return this.type;
    }

    public final ViewPropertyAnimator getViewPropertyAnimator() {
        return this.viewPropertyAnimator;
    }
}
