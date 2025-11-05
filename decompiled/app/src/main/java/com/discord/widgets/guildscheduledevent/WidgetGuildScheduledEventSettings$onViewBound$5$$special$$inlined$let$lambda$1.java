package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* compiled from: WidgetGuildScheduledEventSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1 implements TimePickerDialog.OnTimeSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.AnonymousClass5 this$0;

    public WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1(WidgetGuildScheduledEventSettings.AnonymousClass5 anonymousClass5) {
        this.this$0 = anonymousClass5;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        GuildScheduledEventSettingsViewModel.DateError startTime = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setStartTime(i, i2);
        if (startTime != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, startTime);
        }
    }
}
