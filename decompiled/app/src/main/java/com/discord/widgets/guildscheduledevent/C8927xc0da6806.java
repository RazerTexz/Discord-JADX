package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$8$$special$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8927xc0da6806 implements DatePickerDialog.OnDateSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.ViewOnClickListenerC89268 this$0;

    public C8927xc0da6806(WidgetGuildScheduledEventSettings.ViewOnClickListenerC89268 viewOnClickListenerC89268) {
        this.this$0 = viewOnClickListenerC89268;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        GuildScheduledEventSettingsViewModel.DateError endDate = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setEndDate(i, i2, i3);
        if (endDate != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, endDate);
        }
    }
}
