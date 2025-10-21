package androidx.fragment.app;

import android.os.Bundle;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: Fragment.kt */
/* renamed from: androidx.fragment.app.FragmentKt, reason: use source file name */
/* loaded from: classes.dex */
public final class Fragment2 {
    public static final void clearFragmentResult(Fragment fragment, String str) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$clearFragmentResult");
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResult(str);
    }

    public static final void clearFragmentResultListener(Fragment fragment, String str) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$clearFragmentResultListener");
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        fragment.getParentFragmentManager().clearFragmentResultListener(str);
    }

    public static final void setFragmentResult(Fragment fragment, String str, Bundle bundle) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$setFragmentResult");
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        Intrinsics3.checkNotNullParameter(bundle, "result");
        fragment.getParentFragmentManager().setFragmentResult(str, bundle);
    }

    public static final void setFragmentResultListener(Fragment fragment, String str, Function2<? super String, ? super Bundle, Unit> function2) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$setFragmentResultListener");
        Intrinsics3.checkNotNullParameter(str, "requestKey");
        Intrinsics3.checkNotNullParameter(function2, "listener");
        fragment.getParentFragmentManager().setFragmentResultListener(str, fragment, new Fragment3(function2));
    }
}
