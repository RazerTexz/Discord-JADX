package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.channel.GuildChannelIconUtils;
import com.discord.utilities.channel.GuildChannelIconUtils2;
import com.discord.widgets.channels.WidgetChannelTopicViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func5;

/* compiled from: WidgetChannelTopicViewModel.kt */
/* renamed from: com.discord.widgets.channels.WidgetChannelTopicViewModel$Companion$mapChannelToGuildStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChannelTopicViewModel2<T1, T2, T3, T4, T5, R> implements Func5<Map<Long, ? extends Channel>, Map<Long, ? extends User>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Boolean, WidgetChannelTopicViewModel.StoreState.Guild> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetChannelTopicViewModel.Companion.NavState $navState;

    public WidgetChannelTopicViewModel2(Channel channel, WidgetChannelTopicViewModel.Companion.NavState navState) {
        this.$channel = channel;
        this.$navState = navState;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChannelTopicViewModel.StoreState.Guild call(Map<Long, ? extends Channel> map, Map<Long, ? extends User> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Boolean bool) {
        return call2((Map<Long, Channel>) map, map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChannelTopicViewModel.StoreState.Guild call2(Map<Long, Channel> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Boolean bool) {
        Channel channel = this.$channel;
        Intrinsics3.checkNotNullExpressionValue(map, "channels");
        GuildChannelIconUtils channelType = GuildChannelIconUtils2.getChannelType(this.$channel);
        Intrinsics3.checkNotNullExpressionValue(map2, "users");
        Intrinsics3.checkNotNullExpressionValue(map3, "members");
        Intrinsics3.checkNotNullExpressionValue(map4, "roles");
        Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return new WidgetChannelTopicViewModel.StoreState.Guild.Topic(channel, map, channelType, map2, map3, map4, bool.booleanValue(), this.$navState.isRightPanelOpened(), this.$navState.isOnHomeTab());
    }
}
