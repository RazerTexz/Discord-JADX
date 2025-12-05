package com.discord.widgets.user;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.user.WidgetUserMentions;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: WidgetUserMentions.kt */
/* loaded from: classes.dex */
public final class WidgetUserMentions$WidgetUserMentionFilter$onResume$1<T> implements Action1<Boolean> {
    public final /* synthetic */ WidgetUserMentions.WidgetUserMentionFilter this$0;

    public WidgetUserMentions$WidgetUserMentionFilter$onResume$1(WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter) {
        this.this$0 = widgetUserMentionFilter;
    }

    @Override // p658rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Boolean bool) {
        call2(bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(Boolean bool) {
        WidgetUserMentions.WidgetUserMentionFilter widgetUserMentionFilter = this.this$0;
        WidgetUserMentions.Model.MessageLoader.Filters filtersAccess$getFilters$p = WidgetUserMentions.WidgetUserMentionFilter.access$getFilters$p(widgetUserMentionFilter);
        Intrinsics3.checkNotNullExpressionValue(WidgetUserMentions.WidgetUserMentionFilter.access$getBinding$p(this.this$0).f18339d, "binding.userMentionsFilterThisServer");
        WidgetUserMentions.WidgetUserMentionFilter.access$updateFilters(widgetUserMentionFilter, WidgetUserMentions.Model.MessageLoader.Filters.copy$default(filtersAccess$getFilters$p, 0L, !r1.isChecked(), false, false, 13, null));
        WidgetUserMentions.WidgetUserMentionFilter.access$delayedDismiss(this.this$0);
    }
}
