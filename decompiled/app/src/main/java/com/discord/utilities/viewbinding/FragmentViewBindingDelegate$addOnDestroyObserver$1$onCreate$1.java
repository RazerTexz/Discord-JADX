package com.discord.utilities.viewbinding;

import androidx.exifinterface.media.ExifInterface;
import androidx.view.DefaultLifecycleObserver;
import androidx.view.LifecycleOwner;
import androidx.view.Observer;
import androidx.viewbinding.ViewBinding;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import d0.z.d.m;
import y.c.a;

/* compiled from: FragmentViewBindingDelegate.kt */
/* loaded from: classes2.dex */
public final class FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1<T> implements Observer<LifecycleOwner> {
    public final /* synthetic */ FragmentViewBindingDelegate.AnonymousClass1 this$0;

    /* compiled from: FragmentViewBindingDelegate.kt */
    /* renamed from: com.discord.utilities.viewbinding.FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1$1, reason: invalid class name */
    public static final class AnonymousClass1 implements DefaultLifecycleObserver {
        public AnonymousClass1() {
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            a.a(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public void onDestroy(LifecycleOwner owner) {
            m.checkNotNullParameter(owner, "owner");
            ViewBinding viewBindingAccess$getBinding$p = FragmentViewBindingDelegate.access$getBinding$p(FragmentViewBindingDelegate.this);
            if (viewBindingAccess$getBinding$p != null) {
                FragmentViewBindingDelegate.this.getOnViewBindingDestroy().invoke(viewBindingAccess$getBinding$p);
            }
            FragmentViewBindingDelegate.access$setBinding$p(FragmentViewBindingDelegate.this, null);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            a.c(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
            a.d(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            a.e(this, lifecycleOwner);
        }

        @Override // androidx.view.DefaultLifecycleObserver, androidx.view.FullLifecycleObserver
        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            a.f(this, lifecycleOwner);
        }
    }

    public FragmentViewBindingDelegate$addOnDestroyObserver$1$onCreate$1(FragmentViewBindingDelegate.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // androidx.view.Observer
    public /* bridge */ /* synthetic */ void onChanged(LifecycleOwner lifecycleOwner) {
        onChanged2(lifecycleOwner);
    }

    /* renamed from: onChanged, reason: avoid collision after fix types in other method */
    public final void onChanged2(LifecycleOwner lifecycleOwner) {
        m.checkNotNullExpressionValue(lifecycleOwner, "viewLifecycleOwner");
        lifecycleOwner.getLifecycle().addObserver(new AnonymousClass1());
    }
}
