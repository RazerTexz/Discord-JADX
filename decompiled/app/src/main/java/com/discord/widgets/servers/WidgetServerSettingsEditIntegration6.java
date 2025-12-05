package com.discord.widgets.servers;

import android.view.View;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;

/* compiled from: WidgetServerSettingsEditIntegration.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration6 implements View.OnClickListener {
    public final /* synthetic */ CheckedSetting $checkedSetting;
    public final /* synthetic */ int $index;
    public final /* synthetic */ RadioManager $radioManager$inlined;
    public final /* synthetic */ int $stateKey$inlined;
    public final /* synthetic */ WidgetServerSettingsEditIntegration this$0;

    public WidgetServerSettingsEditIntegration6(CheckedSetting checkedSetting, int i, WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager, int i2) {
        this.$checkedSetting = checkedSetting;
        this.$index = i;
        this.this$0 = widgetServerSettingsEditIntegration;
        this.$radioManager$inlined = radioManager;
        this.$stateKey$inlined = i2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$radioManager$inlined.m8550a(this.$checkedSetting);
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).put(this.$stateKey$inlined, Integer.valueOf(this.$index));
        WidgetServerSettingsEditIntegration.access$getState$p(this.this$0).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(this.this$0).f17625o);
    }
}
