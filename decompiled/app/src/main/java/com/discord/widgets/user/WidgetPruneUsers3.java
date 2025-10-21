package com.discord.widgets.user;

import android.view.View;
import com.discord.widgets.user.WidgetPruneUsersViewModel;

/* compiled from: WidgetPruneUsers.kt */
/* renamed from: com.discord.widgets.user.WidgetPruneUsers$onViewBound$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetPruneUsers3 implements View.OnClickListener {
    public final /* synthetic */ WidgetPruneUsers this$0;

    public WidgetPruneUsers3(WidgetPruneUsers widgetPruneUsers) {
        this.this$0 = widgetPruneUsers;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        WidgetPruneUsers.access$getViewModel$p(this.this$0).pruneDaysSelected(WidgetPruneUsersViewModel.PruneDays.Seven);
    }
}
