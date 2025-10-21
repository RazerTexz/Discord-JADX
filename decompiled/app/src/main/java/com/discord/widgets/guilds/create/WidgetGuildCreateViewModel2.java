package com.discord.widgets.guilds.create;

import com.discord.analytics.generated.events.network_action.TrackNetworkActionGuildCreate;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.guild.Guild;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildCreateViewModel.kt */
/* renamed from: com.discord.widgets.guilds.create.WidgetGuildCreateViewModel$createGuild$createGuildRequestObservable$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildCreateViewModel2 extends Lambda implements Function1<Guild, TrackNetworkMetadata2> {
    public final /* synthetic */ WidgetGuildCreateViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel2(WidgetGuildCreateViewModel widgetGuildCreateViewModel) {
        super(1);
        this.this$0 = widgetGuildCreateViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(Guild guild) {
        return invoke2(guild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final TrackNetworkMetadata2 invoke2(Guild guild) {
        return new TrackNetworkActionGuildCreate(WidgetGuildCreateViewModel.access$getStockGuildTemplate$p(this.this$0).name(), null);
    }
}
