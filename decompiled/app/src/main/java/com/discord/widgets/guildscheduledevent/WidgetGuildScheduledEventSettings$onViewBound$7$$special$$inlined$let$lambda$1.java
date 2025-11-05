package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1 implements TimePickerDialog.OnTimeSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.AnonymousClass7 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$7$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings.AnonymousClass7 anonymousClass7) {
        this.this$0 = anonymousClass7;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        GuildScheduledEventSettingsViewModel.DateError endTime = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setEndTime(i, i2);
        if (endTime != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, endTime);
        }
    }
}
