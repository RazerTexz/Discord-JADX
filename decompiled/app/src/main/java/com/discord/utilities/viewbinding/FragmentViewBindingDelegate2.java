package com.discord.utilities.viewbinding;

import androidx.exifinterface.media.ExifInterface;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import p507d0.p592z.p594d.Intrinsics3;
import p677y.p685c.DefaultLifecycleObserver2;

/* compiled from: FragmentViewBindingDelegate.kt */
/* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate2<T> implements Observer<LifecycleOwner> {
    public final /* synthetic */ FragmentViewBindingDelegate.C70141 this$0;

    /* compiled from: FragmentViewBindingDelegate.kt */
    /* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1 */
    public static final class C70151 implements DefaultLifecycleObserver {
        public C70151() {
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.m11359a(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public void onDestroy(LifecycleOwner owner) {
            Intrinsics3.checkNotNullParameter(owner, "owner");
            ViewBinding viewBindingAccess$getBinding$p = FragmentViewBindingDelegate.access$getBinding$p(FragmentViewBindingDelegate.this);
            if (viewBindingAccess$getBinding$p != null) {
                FragmentViewBindingDelegate.this.getOnViewBindingDestroy().invoke(viewBindingAccess$getBinding$p);
            }
            FragmentViewBindingDelegate.access$setBinding$p(FragmentViewBindingDelegate.this, null);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.m11361c(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.m11362d(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.m11363e(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            DefaultLifecycleObserver2.m11364f(this, lifecycleOwner);
        }
    }

    public FragmentViewBindingDelegate2(FragmentViewBindingDelegate.C70141 c70141) {
        this.this$0 = c70141;
    }

    @Override // androidx.view.Observer
    public /* bridge */ /* synthetic */ void onChanged(LifecycleOwner lifecycleOwner) {
        onChanged2(lifecycleOwner);
    }

    /* renamed from: onChanged, reason: avoid collision after fix types in other method */
    public final void onChanged2(LifecycleOwner lifecycleOwner) {
        Intrinsics3.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(new C70151());
    }
}
