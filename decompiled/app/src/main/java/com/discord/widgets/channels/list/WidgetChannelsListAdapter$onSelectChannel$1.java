package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelsListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelsListAdapter$onSelectChannel$1 extends Lambda implements Function1<Channel, Unit> {
    public static final WidgetChannelsListAdapter$onSelectChannel$1 INSTANCE = new WidgetChannelsListAdapter$onSelectChannel$1();

    public WidgetChannelsListAdapter$onSelectChannel$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
    }
}
