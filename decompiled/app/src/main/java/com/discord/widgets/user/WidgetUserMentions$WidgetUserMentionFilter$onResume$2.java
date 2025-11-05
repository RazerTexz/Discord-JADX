package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.m;
import rx.functions.Action1;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter$onResume$2<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetUserMentions.WidgetUserMentionFilter this$0;

    public WidgetUserMentions$WidgetUserMentionFilter$onResume$2(WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter) {
        this.this$0 = widgetUserMentionFilter;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter = this.this$0;
        WidgetUserMentions.Model.MessageLoader.Filters filtersAccess$getFilters$p = WidgetUserMentions.WidgetUserMentionFilter.access$getFilters$p(widgetUserMentionFilter);
        CheckedSetting checkedSetting = WidgetUserMentions.WidgetUserMentionFilter.access$getBinding$p(this.this$0).f2683b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterIncludeEveryone");
        WidgetUserMentions.WidgetUserMentionFilter.access$updateFilters(widgetUserMentionFilter, WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, false, checkedSetting.isChecked(), false, 11, null));
        WidgetUserMentions.WidgetUserMentionFilter.access$delayedDismiss(this.this$0);
    }
}
