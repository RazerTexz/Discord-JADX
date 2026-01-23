package com.discord.utilities.view.recycler;

import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt, reason: use source file name */
/* JADX INFO: compiled from: ViewPager2Extensions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ViewPager2Extensions {

    /* JADX INFO: renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$setUpWithViewPager2$1 */
    /* JADX INFO: compiled from: ViewPager2Extensions.kt */
    public static final class C70081 extends Lambda implements Function2<TabLayout.Tab, Integer, Unit> {
        public static final C70081 INSTANCE = new C70081();

        public C70081() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(TabLayout.Tab tab, Integer num) {
            invoke(tab, num.intValue());
            return Unit.f27425a;
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
            function2 = C70081.INSTANCE;
        }
        setUpWithViewPager2(tabLayout, viewPager2, function2);
    }
}
