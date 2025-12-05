package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* compiled from: WidgetChannelTopicViewModel.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$observeNavState$3, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel6<T1, T2, R> implements Func2<Boolean, Boolean, WidgetChannelTopicViewModel.Companion.NavState> {
    public static final WidgetChannelTopicViewModel6 INSTANCE = new WidgetChannelTopicViewModel6();

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState call(Boolean bool, Boolean bool2) {
        return call2(bool, bool2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel.Companion.NavState call2(Boolean bool, Boolean bool2) {
        Intrinsics3.checkNotNullExpressionValue(bool, "isOpen");
        boolean zBooleanValue = bool.booleanValue();
        Intrinsics3.checkNotNullExpressionValue(bool2, "isOnHomeTab");
        return new WidgetChannelTopicViewModel.Companion.NavState(zBooleanValue, bool2.booleanValue());
    }
}
