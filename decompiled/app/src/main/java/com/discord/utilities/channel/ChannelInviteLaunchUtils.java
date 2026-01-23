package com.discord.utilities.channel;

import android.content.Context;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheet;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetFeatureFlag;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShare;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: ChannelInviteLaunchUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChannelInviteLaunchUtils {
    public static final ChannelInviteLaunchUtils INSTANCE = new ChannelInviteLaunchUtils();

    private ChannelInviteLaunchUtils() {
    }

    public static /* synthetic */ void inviteToChannel$default(ChannelInviteLaunchUtils channelInviteLaunchUtils, Fragment fragment, Channel channel, String str, Long l, String str2, int i, Object obj) {
        channelInviteLaunchUtils.inviteToChannel(fragment, channel, str, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : str2);
    }

    public final void inviteToChannel(Fragment fragment, Channel channel, String source, Long eventId, String inviteStoreKey) {
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(source, "source");
        if (channel != null) {
            long id2 = channel.getId();
            if (channel.getGuildId() != 0) {
                WidgetGuildInviteShare.Companion companion = WidgetGuildInviteShare.INSTANCE;
                Context contextRequireContext = fragment.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
                FragmentManager childFragmentManager = fragment.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "fragment.childFragmentManager");
                WidgetGuildInviteShare.Companion.launch$default(companion, contextRequireContext, childFragmentManager, channel.getGuildId(), Long.valueOf(id2), false, eventId, inviteStoreKey, source, 16, null);
                return;
            }
            if (GroupInviteFriendsSheetFeatureFlag.INSTANCE.getINSTANCE().isEnabled()) {
                GroupInviteFriendsSheet.Companion companion2 = GroupInviteFriendsSheet.INSTANCE;
                FragmentManager childFragmentManager2 = fragment.getChildFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(childFragmentManager2, "fragment.childFragmentManager");
                companion2.show(childFragmentManager2, id2, source);
                return;
            }
            WidgetGroupInviteFriends.Companion companion3 = WidgetGroupInviteFriends.INSTANCE;
            Context contextRequireContext2 = fragment.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "fragment.requireContext()");
            companion3.launch(contextRequireContext2, id2, source);
        }
    }
}
