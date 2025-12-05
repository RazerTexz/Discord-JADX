package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGlobalSearchModel.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$1 */
/* loaded from: classes.dex */
public final class C10331xf66aaceb extends Lambda implements Function1<Channel, Boolean> {
    public static final C10331xf66aaceb INSTANCE = new C10331xf66aaceb();

    public C10331xf66aaceb() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
        return ChannelUtils.m7672G(channel);
    }
}
