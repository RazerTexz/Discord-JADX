package com.discord.utilities.view.recycler;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: ViewPager2Extensions.kt */
/* renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewPager2Extensions {

    /* compiled from: ViewPager2Extensions.kt */
    /* renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$setUpWithViewPager2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.a;
        }

        public final void invoke(TabLayout.Tab tab, int i) {
            Intrinsics3.checkNotNullParameter(tab, "<anonymous parameter 0>");
        }
    }

    public static final void setUpWithViewPager2(TabLayout tabLayout, ViewPager2 viewPager2, Function2<? super TabLayout.Tab, ? super Integer, Unit> function2) {
        Intrinsics3.checkNotNullParameter(tabLayout, "$this$setUpWithViewPager2");
        Intrinsics3.checkNotNullParameter(viewPager2, "viewPager2");
        Intrinsics3.checkNotNullParameter(function2, "configureTab");
        new TabLayoutMediator(tabLayout, viewPager2, new ViewPager2Extensions2(function2)).attach();
    }

    public static /* synthetic */ void setUpWithViewPager2$default(TabLayout tabLayout, ViewPager2 viewPager2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            function2 = AnonymousClass1.INSTANCE;
        }
        setUpWithViewPager2(tabLayout, viewPager2, function2);
    }
}
