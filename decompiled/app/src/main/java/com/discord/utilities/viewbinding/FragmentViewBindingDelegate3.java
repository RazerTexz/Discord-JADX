package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt, reason: use source file name */
/* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FragmentViewBindingDelegate3 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt$viewBinding$1 */
    /* JADX INFO: compiled from: FragmentViewBindingDelegate.kt */
    public static final class C70161<T> extends Lambda implements Function1<T, Unit> {
        public static final C70161 INSTANCE = new C70161();

        public C70161() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((ViewBinding) obj);
            return Unit.f27425a;
        }

        /* JADX WARN: Incorrect types in method signature: (TT;)V */
        public final void invoke(ViewBinding viewBinding) {
            Intrinsics3.checkNotNullParameter(viewBinding, "it");
        }
    }

    public static final <T extends ViewBinding> FragmentViewBindingDelegate<T> viewBinding(Fragment fragment, Function1<? super View, ? extends T> function1, Function1<? super T, Unit> function12) {
        Intrinsics3.checkNotNullParameter(fragment, "$this$viewBinding");
        Intrinsics3.checkNotNullParameter(function1, "viewBindingFactory");
        Intrinsics3.checkNotNullParameter(function12, "onViewBindingDestroy");
        return new FragmentViewBindingDelegate<>(fragment, function1, function12);
    }

    public static /* synthetic */ FragmentViewBindingDelegate viewBinding$default(Fragment fragment, Function1 function1, Function1 function12, int i, Object obj) {
        if ((i & 2) != 0) {
            function12 = C70161.INSTANCE;
        }
        return viewBinding(fragment, function1, function12);
    }
}
