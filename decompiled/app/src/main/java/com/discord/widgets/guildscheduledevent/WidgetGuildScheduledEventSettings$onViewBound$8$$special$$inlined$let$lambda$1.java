package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 implements DatePickerDialog.OnDateSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.AnonymousClass8 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings.AnonymousClass8 anonymousClass8) {
        this.this$0 = anonymousClass8;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        GuildScheduledEventSettingsViewModel.DateError endDate = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setEndDate(i, i2, i3);
        if (endDate != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, endDate);
        }
    }
}
