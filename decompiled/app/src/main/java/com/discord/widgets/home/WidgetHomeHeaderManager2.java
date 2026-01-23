package com.discord.widgets.home;

import android.view.View;
import com.discord.databinding.WidgetHomeBinding;

/* JADX INFO: renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$configure$$inlined$apply$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHomeHeaderManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeHeaderManager2 implements View.OnClickListener {
    public final /* synthetic */ WidgetHomeBinding $binding$inlined;
    public final /* synthetic */ WidgetHomeModel $model$inlined;
    public final /* synthetic */ WidgetHomeModel $this_apply$inlined;
    public final /* synthetic */ WidgetHome $widgetHome$inlined;

    public WidgetHomeHeaderManager2(WidgetHomeModel widgetHomeModel, WidgetHome widgetHome, WidgetHomeModel widgetHomeModel2, WidgetHomeBinding widgetHomeBinding) {
        this.$this_apply$inlined = widgetHomeModel;
        this.$widgetHome$inlined = widgetHome;
        this.$model$inlined = widgetHomeModel2;
        this.$binding$inlined = widgetHomeBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$widgetHome$inlined.handleCenterPanelBack$app_productionGoogleRelease();
    }
}
