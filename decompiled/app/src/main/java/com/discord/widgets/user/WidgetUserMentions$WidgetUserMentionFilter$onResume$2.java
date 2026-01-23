package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import com.discord.widgets.user.WidgetUserMentions;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* JADX INFO: compiled from: WidgetUserMentions.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter$onResume$2<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetUserMentions.WidgetUserMentionFilter this$0;

    public WidgetUserMentions$WidgetUserMentionFilter$onResume$2(WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter) {
        this.this$0 = widgetUserMentionFilter;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter = this.this$0;
        WidgetUserMentions.Model.MessageLoader.Filters filtersAccess$getFilters$p = WidgetUserMentions.WidgetUserMentionFilter.access$getFilters$p(widgetUserMentionFilter);
        CheckedSetting checkedSetting = WidgetUserMentions.WidgetUserMentionFilter.access$getBinding$p(this.this$0).f18337b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterIncludeEveryone");
        WidgetUserMentions.WidgetUserMentionFilter.access$updateFilters(widgetUserMentionFilter, WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, false, checkedSetting.isChecked(), false, 11, null));
        WidgetUserMentions.WidgetUserMentionFilter.access$delayedDismiss(this.this$0);
    }
}
