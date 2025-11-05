package androidx.view;

import d0.z.d.m;

/* compiled from: View.kt */
/* renamed from: androidx.savedstate.ViewKt, reason: from Kotlin metadata */
/* loaded from: classes.dex */
public final class View {
    public static final SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(android.view.View view) {
        m.checkNotNullParameter(view, "$this$findViewTreeSavedStateRegistryOwner");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
