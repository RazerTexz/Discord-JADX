package com.discord.widgets.guildscheduledevent;

import android.app.TimePickerDialog;
import android.widget.TimePicker;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventSettingsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventSettings$onViewBound$5$$special$$inlined$let$lambda$1 */
/* JADX INFO: compiled from: WidgetGuildScheduledEventSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8921x2849a869 implements TimePickerDialog.OnTimeSetListener {
    public final /* synthetic */ WidgetGuildScheduledEventSettings.ViewOnClickListenerC89205 this$0;

    public C8921x2849a869(WidgetGuildScheduledEventSettings.ViewOnClickListenerC89205 viewOnClickListenerC89205) {
        this.this$0 = viewOnClickListenerC89205;
    }

    @Override // android.app.TimePickerDialog.OnTimeSetListener
    public final void onTimeSet(TimePicker timePicker, int i, int i2) {
        GuildScheduledEventSettingsViewModel.DateError startTime = WidgetGuildScheduledEventSettings.access$getViewModel$p(WidgetGuildScheduledEventSettings.this).setStartTime(i, i2);
        if (startTime != null) {
            WidgetGuildScheduledEventSettings.access$showDateErrorToast(WidgetGuildScheduledEventSettings.this, startTime);
        }
    }
}
