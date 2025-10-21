package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGlobalSearchModel.kt */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$filteredResults$10 extends Lambda implements Function1<Channel, Boolean> {
    public static final WidgetGlobalSearchModel$Companion$create$filteredResults$10 INSTANCE = new WidgetGlobalSearchModel$Companion$create$filteredResults$10();

    public WidgetGlobalSearchModel$Companion$create$filteredResults$10() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        return ChannelUtils.F(channel);
    }
}
