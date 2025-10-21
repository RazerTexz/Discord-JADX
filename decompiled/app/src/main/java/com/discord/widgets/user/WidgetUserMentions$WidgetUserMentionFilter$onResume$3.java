package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.views.CheckedSetting;
import com.discord.widgets.user.WidgetUserMentions;
import d0.z.d.Intrinsics3;
import rx.functions.Action1;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter$onResume$3<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetUserMentions.WidgetUserMentionFilter this$0;

    public WidgetUserMentions$WidgetUserMentionFilter$onResume$3(WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter) {
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
        CheckedSetting checkedSetting = WidgetUserMentions.WidgetUserMentionFilter.access$getBinding$p(this.this$0).c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.userMentionsFilterIncludeRoles");
        WidgetUserMentions.WidgetUserMentionFilter.access$updateFilters(widgetUserMentionFilter, WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, false, false, checkedSetting.isChecked(), 7, null));
        WidgetUserMentions.WidgetUserMentionFilter.access$delayedDismiss(this.this$0);
    }
}
