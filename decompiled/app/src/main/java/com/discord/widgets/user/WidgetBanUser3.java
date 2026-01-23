package com.discord.widgets.user;

import android.view.View;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;

/* JADX INFO: renamed from: com.discord.widgets.user.WidgetBanUser$onViewBound$$inlined$forEach$lambda$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetBanUser.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetBanUser3 implements View.OnClickListener {
    public final /* synthetic */ CheckedSetting $radio;
    public final /* synthetic */ WidgetBanUser this$0;

    public WidgetBanUser3(CheckedSetting checkedSetting, WidgetBanUser widgetBanUser) {
        this.$radio = checkedSetting;
        this.this$0 = widgetBanUser;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        RadioManager radioManagerAccess$getDeleteHistoryRadioManager$p = WidgetBanUser.access$getDeleteHistoryRadioManager$p(this.this$0);
        if (radioManagerAccess$getDeleteHistoryRadioManager$p != null) {
            radioManagerAccess$getDeleteHistoryRadioManager$p.m8550a(this.$radio);
        }
    }
}
