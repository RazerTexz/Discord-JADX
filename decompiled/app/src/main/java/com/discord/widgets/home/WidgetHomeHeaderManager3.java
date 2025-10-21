package com.discord.widgets.home;

import android.view.View;
import com.discord.api.channel.Channel;
import com.discord.databinding.WidgetHomeBinding;

/* compiled from: WidgetHomeHeaderManager.kt */
/* renamed from: com.discord.widgets.home.WidgetHomeHeaderManager$configure$$inlined$apply$lambda$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHomeHeaderManager3 implements View.OnClickListener {
    public final /* synthetic */ WidgetHomeBinding $binding$inlined;
    public final /* synthetic */ WidgetHomeModel $model$inlined;
    public final /* synthetic */ WidgetHomeModel $this_apply;
    public final /* synthetic */ WidgetHome $widgetHome$inlined;

    public WidgetHomeHeaderManager3(WidgetHomeModel widgetHomeModel, WidgetHome widgetHome, WidgetHomeModel widgetHomeModel2, WidgetHomeBinding widgetHomeBinding) {
        this.$this_apply = widgetHomeModel;
        this.$widgetHome$inlined = widgetHome;
        this.$model$inlined = widgetHomeModel2;
        this.$binding$inlined = widgetHomeBinding;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Channel channel = this.$this_apply.getChannel();
        Integer numValueOf = channel != null ? Integer.valueOf(channel.getType()) : null;
        if ((numValueOf != null && numValueOf.intValue() == 1) || ((numValueOf != null && numValueOf.intValue() == 3) || ((numValueOf != null && numValueOf.intValue() == 5) || ((numValueOf != null && numValueOf.intValue() == 15) || (numValueOf != null && numValueOf.intValue() == 0))))) {
            this.$widgetHome$inlined.getPanelLayout().openEndPanel();
        }
    }
}
