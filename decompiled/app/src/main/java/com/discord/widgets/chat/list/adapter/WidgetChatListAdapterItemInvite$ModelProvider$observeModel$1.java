package com.discord.widgets.chat.list.adapter;

import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelInvite;
import com.discord.models.user.User;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreUser;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapterItemInvite;
import com.discord.widgets.chat.list.entries.InviteEntry;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetChatListAdapterItemInvite.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapterItemInvite$ModelProvider$observeModel$1 extends o implements Function0<WidgetChatListAdapterItemInvite.Model> {
    public final /* synthetic */ StoreAccessibility $accessibilityStore;
    public final /* synthetic */ StoreChannels $channelStore;
    public final /* synthetic */ StoreGuilds $guildStore;
    public final /* synthetic */ ModelInvite $invite;
    public final /* synthetic */ InviteEntry $item;
    public final /* synthetic */ StoreUser $userStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemInvite$ModelProvider$observeModel$1(StoreUser storeUser, InviteEntry inviteEntry, ModelInvite modelInvite, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreAccessibility storeAccessibility) {
        super(0);
        this.$userStore = storeUser;
        this.$item = inviteEntry;
        this.$invite = modelInvite;
        this.$guildStore = storeGuilds;
        this.$channelStore = storeChannels;
        this.$accessibilityStore = storeAccessibility;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetChatListAdapterItemInvite.Model invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChatListAdapterItemInvite.Model invoke() {
        long id2 = this.$userStore.getMeSnapshot().getId();
        User user = this.$userStore.getUsers().get(Long.valueOf(this.$item.getUserId()));
        Guild guild = this.$invite.guild;
        boolean z2 = (guild != null ? this.$guildStore.getGuilds().get(Long.valueOf(guild.getId())) : null) != null;
        Channel channel = this.$invite.getChannel();
        Channel channel2 = channel != null ? this.$channelStore.getChannel(channel.getId()) : null;
        return (this.$invite.getExpirationTime() >= ClockFactory.get().currentTimeMillis() || this.$invite.isRevoked()) ? new WidgetChatListAdapterItemInvite.Model.Invalid(user, id2, channel2) : new WidgetChatListAdapterItemInvite.Model.Resolved(this.$invite, id2, user, z2, channel2, !this.$accessibilityStore.getReducedMotionEnabled());
    }
}
