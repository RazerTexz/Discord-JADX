package androidx.view;

import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: LifecycleOwner.kt */
/* renamed from: androidx.lifecycle.LifecycleOwnerKt, reason: use source file name */
/* loaded from: classes.dex */
public final class LifecycleOwner2 {
    public static final Lifecycle2 getLifecycleScope(LifecycleOwner lifecycleOwner) {
        Intrinsics3.checkNotNullParameter(lifecycleOwner, "$this$lifecycleScope");
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics3.checkNotNullExpressionValue(lifecycle, "lifecycle");
        return Lifecycle4.getCoroutineScope(lifecycle);
    }
}
