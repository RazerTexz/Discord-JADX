package com.discord.utilities.view.recycler;

import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewPager2Extensions.kt */
/* renamed from: com.discord.utilities.view.recycler.ViewPager2ExtensionsKt$sam$com_google_android_material_tabs_TabLayoutMediator_TabConfigurationStrategy$0, reason: use source file name */
/* loaded from: classes2.dex */
public final class ViewPager2Extensions2 implements TabLayoutMediator.TabConfigurationStrategy {
    private final /* synthetic */ Function2 function;

    public ViewPager2Extensions2(Function2 function2) {
        this.function = function2;
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public final /* synthetic */ void onConfigureTab(@NonNull TabLayout.Tab tab, int i) {
        Intrinsics3.checkNotNullParameter(tab, "p0");
        Intrinsics3.checkNotNullExpressionValue(this.function.invoke(tab, Integer.valueOf(i)), "invoke(...)");
    }
}
