package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 */
/* loaded from: classes2.dex */
public final class C8925x38aa2827 implements TimePickerDialog.OnTimeSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.ViewOnClickListenerC89247 this$0;

    public C8925x38aa2827(WidgetGuildScheduledEventSettings.ViewOnClickListenerC89247 viewOnClickListenerC89247) {
        this.this$0 = viewOnClickListenerC89247;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        GuildScheduledEventSettingsViewModel.DateError endTime = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setEndTime(i, i2);
        if (endTime != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, endTime);
        }
    }
}
