package com.discord.widgets.channels.list;

import com.discord.api.channel.Channel;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetChannelsListAdapter.kt */
/* renamed from: com.discord.widgets.channels.list.WidgetChannelsListAdapter$onSelectGuildRoleSubscriptionLockedChannel$1 */
/* loaded from: classes2.dex */
public final class C7450xb3042f02 extends Lambda implements Function1<Channel, Unit> {
    public static final C7450xb3042f02 INSTANCE = new C7450xb3042f02();

    public C7450xb3042f02() {
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
