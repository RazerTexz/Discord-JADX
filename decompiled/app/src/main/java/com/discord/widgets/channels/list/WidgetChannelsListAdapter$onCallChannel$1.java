package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onCallChannel$1 extends Lambda implements Function1<Channel, Unit> {
    public static final WidgetChannelsListAdapter$onCallChannel$1 INSTANCE = new WidgetChannelsListAdapter$onCallChannel$1();

    public WidgetChannelsListAdapter$onCallChannel$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "it");
    }
}
