package androidx.activity;

import androidx.view.LifecycleOwner;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: androidx.activity.OnBackPressedDispatcherKt, reason: use source file name */
/* JADX INFO: compiled from: OnBackPressedDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OnBackPressedDispatcher2 {
    public static final OnBackPressedCallback addCallback(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z2, Function1<? super OnBackPressedCallback, Unit> function1) {
        Intrinsics3.checkNotNullParameter(onBackPressedDispatcher, "$this$addCallback");
        Intrinsics3.checkNotNullParameter(function1, "onBackPressed");
        OnBackPressedDispatcher3 onBackPressedDispatcher3 = new OnBackPressedDispatcher3(function1, z2, z2);
        if (lifecycleOwner != null) {
            onBackPressedDispatcher.addCallback(lifecycleOwner, onBackPressedDispatcher3);
        } else {
            onBackPressedDispatcher.addCallback(onBackPressedDispatcher3);
        }
        return onBackPressedDispatcher3;
    }

    public static /* synthetic */ OnBackPressedCallback addCallback$default(OnBackPressedDispatcher onBackPressedDispatcher, LifecycleOwner lifecycleOwner, boolean z2, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            lifecycleOwner = null;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        return addCallback(onBackPressedDispatcher, lifecycleOwner, z2, function1);
    }
}
