package com.discord.widgets.guildscheduledevent;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.core.app.NotificationCompat;

/* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect$onViewBound$$inlined$addTextChangedListener$1 */
/* JADX INFO: compiled from: TextView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C8899x17ce3023 implements TextWatcher {
    public final /* synthetic */ WidgetGuildScheduledEventLocationSelect this$0;

    public C8899x17ce3023(WidgetGuildScheduledEventLocationSelect widgetGuildScheduledEventLocationSelect) {
        this.this$0 = widgetGuildScheduledEventLocationSelect;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable s2) {
        String string;
        if (s2 == null || (string = s2.toString()) == null) {
            return;
        }
        WidgetGuildScheduledEventLocationSelect.access$getViewModel$p(this.this$0).setExternalLocation(string);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence text, int start, int count, int after) {
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence text, int start, int before, int count) {
    }
}
