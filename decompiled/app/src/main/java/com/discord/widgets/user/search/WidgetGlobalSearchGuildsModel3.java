package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchGuildsModel.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel$Companion$asDirectMessageItems$2, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel3 extends Lambda implements Function1<Channel, WidgetGlobalSearchGuildsModel.Item> {
    public final /* synthetic */ Map $mentionCounts;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsModel3(Map map) {
        super(1);
        this.$mentionCounts = map;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchGuildsModel.Item invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchGuildsModel.Item invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        WidgetGlobalSearchGuildsModel.Item.Companion companion = WidgetGlobalSearchGuildsModel.Item.INSTANCE;
        Integer num = (Integer) outline.m845d(channel, this.$mentionCounts);
        return companion.createDirectMessage$app_productionGoogleRelease(channel, num != null ? num.intValue() : 0);
    }
}
