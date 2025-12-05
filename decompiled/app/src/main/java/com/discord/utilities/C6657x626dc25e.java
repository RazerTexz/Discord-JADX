package com.discord.utilities;

import com.discord.api.channel.Channel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ShareUtils.kt */
/* renamed from: com.discord.utilities.ShareUtils$observeChannelAndIconPairs$3$pinnedOnlyShortcutChannels$5 */
/* loaded from: classes2.dex */
public final class C6657x626dc25e extends Lambda implements Function1<Channel, ChannelShortcutInfo> {
    public static final C6657x626dc25e INSTANCE = new C6657x626dc25e();

    public C6657x626dc25e() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ChannelShortcutInfo invoke(Channel channel) {
        return invoke2(channel);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ChannelShortcutInfo invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        return new ChannelShortcutInfo(channel, 20, true);
    }
}
