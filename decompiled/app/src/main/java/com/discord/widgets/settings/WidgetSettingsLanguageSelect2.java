package com.discord.widgets.settings;

import android.view.View;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;

/* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsLanguageSelect$Adapter$AdapterItemLocale$onConfigure$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetSettingsLanguageSelect.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsLanguageSelect2 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsLanguageSelect.Model.Item $data;
    public final /* synthetic */ WidgetSettingsLanguageSelect.Adapter.AdapterItemLocale this$0;

    public WidgetSettingsLanguageSelect2(WidgetSettingsLanguageSelect.Adapter.AdapterItemLocale adapterItemLocale, WidgetSettingsLanguageSelect.Model.Item item) {
        this.this$0 = adapterItemLocale;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetSettingsLanguageSelect.access$onLocaleSelected(WidgetSettingsLanguageSelect.Adapter.access$getDialog$p(WidgetSettingsLanguageSelect.Adapter.AdapterItemLocale.access$getAdapter$p(this.this$0)), this.$data.getLocale());
    }
}
