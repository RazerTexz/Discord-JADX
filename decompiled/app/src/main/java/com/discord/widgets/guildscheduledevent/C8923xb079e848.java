package com.discord.widgets.guildscheduledevent;

import android.app.DatePickerDialog;
import android.widget.DatePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$6$$special$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8923xb079e848 implements DatePickerDialog.OnDateSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.ViewOnClickListenerC89226 this$0;

    public C8923xb079e848(WidgetGuildScheduledEventSettings.ViewOnClickListenerC89226 viewOnClickListenerC89226) {
        this.this$0 = viewOnClickListenerC89226;
    }

    @Override // android.app.DatePickerDialog.OnDateSetListener
    public final void onDateSet(DatePicker datePicker, int i, int i2, int i3) {
        GuildScheduledEventSettingsViewModel.DateError startDate = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setStartDate(i, i2, i3);
        if (startDate != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, startDate);
        }
    }
}
