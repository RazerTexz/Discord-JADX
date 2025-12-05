package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$6 extends Lambda implements Function1<Channel, Boolean> {
    public final /* synthetic */ WidgetGlobalSearchModel.ChannelContext $channelContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchModel$Companion$create$filteredResults$6(WidgetGlobalSearchModel.ChannelContext channelContext) {
        super(1);
        this.$channelContext = channelContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        Object objM845d = outline.m845d(channel, this.$channelContext.getChannelPerms());
        if (objM845d == null) {
            objM845d = 0L;
        }
        long jLongValue = ((Number) objM845d).longValue();
        return PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(jLongValue)) && PermissionUtils.can(Permission.CONNECT, Long.valueOf(jLongValue));
    }
}
