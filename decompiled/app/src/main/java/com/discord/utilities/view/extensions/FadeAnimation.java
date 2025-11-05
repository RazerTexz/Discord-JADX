package com.discord.utilities.view.extensions;

import android.view.ViewPropertyAnimator;
import d0.z.d.m;

/* compiled from: ViewExtensions.kt */
/* loaded from: classes2.dex */
public final class FadeAnimation {
    private final Type type;
    private final ViewPropertyAnimator viewPropertyAnimator;

    /* compiled from: ViewExtensions.kt */
    public enum Type {
        FADE_IN,
        FADE_OUT
    }

    public FadeAnimation(ViewPropertyAnimator viewPropertyAnimator, Type type) {
        m.checkNotNullParameter(viewPropertyAnimator, "viewPropertyAnimator");
        m.checkNotNullParameter(type, "type");
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
