package com.discord.utilities.viewbinding;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: FragmentViewBindingDelegate.kt */
/* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate3 {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: FragmentViewBindingDelegate.kt */
    /* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt$viewBinding$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends Lambda implements Function1<T, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke((ViewBinding) obj);
            return Unit.a;
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
            function12 = AnonymousClass1.INSTANCE;
        }
        return viewBinding(fragment, function1, function12);
    }
}
