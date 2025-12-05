package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.fragment.app.FragmentActivity;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3292f1;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3297i;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.FragmentC3286d1;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.InterfaceC3299j;

/* compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* loaded from: classes3.dex */
public class LifecycleCallback {

    /* renamed from: j */
    @RecentlyNonNull
    public final InterfaceC3299j f20511j;

    public LifecycleCallback(@RecentlyNonNull InterfaceC3299j interfaceC3299j) {
        this.f20511j = interfaceC3299j;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x001f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @RecentlyNonNull
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static InterfaceC3299j m9038c(@RecentlyNonNull Activity activity) {
        InterfaceC3299j interfaceC3299j;
        AnimatableValueParser.m595z(activity, "Activity must not be null");
        if (activity instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) activity;
            WeakHashMap<FragmentActivity, WeakReference<C3292f1>> weakHashMap = C3292f1.f9372j;
            WeakReference<C3292f1> weakReference = weakHashMap.get(fragmentActivity);
            if (weakReference != null) {
                InterfaceC3299j interfaceC3299j2 = (C3292f1) weakReference.get();
                interfaceC3299j = interfaceC3299j2;
                if (interfaceC3299j2 == null) {
                    try {
                        C3292f1 c3292f1 = (C3292f1) fragmentActivity.getSupportFragmentManager().findFragmentByTag("SupportLifecycleFragmentImpl");
                        if (c3292f1 != null) {
                            boolean zIsRemoving = c3292f1.isRemoving();
                            C3292f1 c3292f12 = c3292f1;
                            if (zIsRemoving) {
                                C3292f1 c3292f13 = new C3292f1();
                                fragmentActivity.getSupportFragmentManager().beginTransaction().add(c3292f13, "SupportLifecycleFragmentImpl").commitAllowingStateLoss();
                                c3292f12 = c3292f13;
                            }
                            weakHashMap.put(fragmentActivity, new WeakReference<>(c3292f12));
                            interfaceC3299j = c3292f12;
                        }
                    } catch (ClassCastException e) {
                        throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
                    }
                }
            }
        } else {
            WeakHashMap<Activity, WeakReference<FragmentC3286d1>> weakHashMap2 = FragmentC3286d1.f9363j;
            WeakReference<FragmentC3286d1> weakReference2 = weakHashMap2.get(activity);
            if (weakReference2 != null) {
                InterfaceC3299j interfaceC3299j3 = (FragmentC3286d1) weakReference2.get();
                interfaceC3299j = interfaceC3299j3;
                if (interfaceC3299j3 == null) {
                    try {
                        FragmentC3286d1 fragmentC3286d1 = (FragmentC3286d1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                        if (fragmentC3286d1 != null) {
                            boolean zIsRemoving2 = fragmentC3286d1.isRemoving();
                            InterfaceC3299j interfaceC3299j4 = fragmentC3286d1;
                            if (zIsRemoving2) {
                                FragmentC3286d1 fragmentC3286d12 = new FragmentC3286d1();
                                activity.getFragmentManager().beginTransaction().add(fragmentC3286d12, "LifecycleFragmentImpl").commitAllowingStateLoss();
                                interfaceC3299j4 = fragmentC3286d12;
                            }
                            weakHashMap2.put(activity, new WeakReference<>(interfaceC3299j4));
                            interfaceC3299j = interfaceC3299j4;
                        }
                    } catch (ClassCastException e2) {
                        throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
                    }
                }
            }
        }
        return interfaceC3299j;
    }

    @Keep
    private static InterfaceC3299j getChimeraLifecycleFragmentImpl(C3297i c3297i) {
        throw new IllegalStateException("Method not available in SDK.");
    }

    @MainThread
    /* renamed from: a */
    public void m9039a() {
    }

    @RecentlyNonNull
    /* renamed from: b */
    public Activity m9040b() {
        return this.f20511j.mo4071e();
    }

    @MainThread
    /* renamed from: d */
    public void mo4115d(int i, int i2, @RecentlyNonNull Intent intent) {
    }

    @MainThread
    /* renamed from: e */
    public void mo4116e(@Nullable Bundle bundle) {
    }

    @MainThread
    /* renamed from: f */
    public void mo4063f() {
    }

    @MainThread
    /* renamed from: g */
    public void mo4058g() {
    }

    @MainThread
    /* renamed from: h */
    public void mo4117h(@RecentlyNonNull Bundle bundle) {
    }

    @MainThread
    /* renamed from: i */
    public void mo4059i() {
    }

    @MainThread
    /* renamed from: j */
    public void mo4060j() {
    }
}
