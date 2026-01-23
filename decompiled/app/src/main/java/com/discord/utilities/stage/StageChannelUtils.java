package com.discord.utilities.stage;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentManager;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStageChannels;
import com.discord.stores.StoreStageInstances;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.start.WidgetModeratorStartStage;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: StageChannelUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageChannelUtils {
    public static final StageChannelUtils INSTANCE = new StageChannelUtils();

    /* JADX INFO: renamed from: com.discord.utilities.stage.StageChannelUtils$connectToStageChannel$2 */
    /* JADX INFO: compiled from: StageChannelUtils.kt */
    public static final class C69172 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ FragmentManager $fragmentManager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C69172(Context context, FragmentManager fragmentManager, Channel channel) {
            super(0);
            this.$context = context;
            this.$fragmentManager = fragmentManager;
            this.$channel = channel;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, this.$context, this.$fragmentManager, this.$channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
        }
    }

    private StageChannelUtils() {
    }

    public static final boolean computeCanEditStageModerators(StorePermissions permissionStore, StoreGuilds guildStore, long meId, long guildId, Channel channel) {
        Intrinsics3.checkNotNullParameter(permissionStore, "permissionStore");
        Intrinsics3.checkNotNullParameter(guildStore, "guildStore");
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Guild guild = guildStore.getGuilds().get(Long.valueOf(guildId));
        if ((guild != null && guild.isOwner(meId)) || AnimatableValueParser.m439H0((Long) outline.m845d(channel, permissionStore.getPermissionsByChannel()), 8L) || AnimatableValueParser.m439H0(permissionStore.getGuildPermissions().get(Long.valueOf(guildId)), 289406992L)) {
            return true;
        }
        PermissionUtils permissionUtils = PermissionUtils.INSTANCE;
        Map<Long, GuildMember> map = guildStore.getMembers().get(Long.valueOf(guildId));
        return AnimatableValueParser.m439H0(Long.valueOf(permissionUtils.computeChannelOverwrite(meId, guildId, map != null ? map.get(Long.valueOf(meId)) : null, channel.m7655v())), Permission.MANAGE_ROLES);
    }

    public static /* synthetic */ boolean shouldShowEndStageBottomSheet$default(StageChannelUtils stageChannelUtils, long j, StoreChannels storeChannels, StoreStageChannels storeStageChannels, StoreStageInstances storeStageInstances, StoreUser storeUser, int i, Object obj) {
        if ((i & 2) != 0) {
            storeChannels = StoreStream.INSTANCE.getChannels();
        }
        StoreChannels storeChannels2 = storeChannels;
        if ((i & 4) != 0) {
            storeStageChannels = StoreStream.INSTANCE.getStageChannels();
        }
        StoreStageChannels storeStageChannels2 = storeStageChannels;
        if ((i & 8) != 0) {
            storeStageInstances = StoreStream.INSTANCE.getStageInstances();
        }
        StoreStageInstances storeStageInstances2 = storeStageInstances;
        if ((i & 16) != 0) {
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        return stageChannelUtils.shouldShowEndStageBottomSheet(j, storeChannels2, storeStageChannels2, storeStageInstances2, storeUser);
    }

    public final void connectToStageChannel(Channel channel, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (channel.getType() != 13) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StageInstance stageInstanceForChannel = companion.getStageInstances().getStageInstanceForChannel(channel.getId());
        Long l = (Long) outline.m845d(channel, companion.getPermissions().getPermissionsByChannel());
        if (stageInstanceForChannel != null && AnimatableValueParser.m484W0(stageInstanceForChannel)) {
            StageChannelJoinHelper.connectToStage$default(StageChannelJoinHelper.INSTANCE, context, fragmentManager, channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
            return;
        }
        if (stageInstanceForChannel != null || l == null || !PermissionUtils.can(20971536L, Long.valueOf(l.longValue()))) {
            MemberVerificationUtils.maybeShowVerificationGate$default(MemberVerificationUtils.INSTANCE, context, fragmentManager, channel.getGuildId(), "Guild Voice", null, null, new C69172(context, fragmentManager, channel), 48, null);
            return;
        }
        WidgetModeratorStartStage.INSTANCE.launch(context, channel.getId(), channel.getGuildId());
    }

    public final boolean shouldShowEndStageBottomSheet(long channelId, StoreChannels channelsStore, StoreStageChannels stageChannelsStore, StoreStageInstances stageInstanceStore, StoreUser userStore) {
        StageRoles stageRolesM11392getMyRolesvisDeB4;
        Map<Long, StageRoles> channelRoles;
        Intrinsics3.checkNotNullParameter(channelsStore, "channelsStore");
        Intrinsics3.checkNotNullParameter(stageChannelsStore, "stageChannelsStore");
        Intrinsics3.checkNotNullParameter(stageInstanceStore, "stageInstanceStore");
        Intrinsics3.checkNotNullParameter(userStore, "userStore");
        Channel channel = channelsStore.getChannel(channelId);
        if (channel == null || !ChannelUtils.m7669D(channel) || stageInstanceStore.getStageInstanceForChannel(channel.getId()) == null || (stageRolesM11392getMyRolesvisDeB4 = stageChannelsStore.m11392getMyRolesvisDeB4(channel.getId())) == null || !StageRoles.m11409isModeratorimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl()) || (channelRoles = stageChannelsStore.getChannelRoles(channel.getId())) == null) {
            return false;
        }
        long id2 = userStore.getMeSnapshot().getId();
        boolean z2 = false;
        boolean z3 = false;
        for (Map.Entry<Long, StageRoles> entry : channelRoles.entrySet()) {
            long jLongValue = entry.getKey().longValue();
            int iM11412unboximpl = entry.getValue().m11412unboximpl();
            if (jLongValue != id2 && StageRoles.m11409isModeratorimpl(iM11412unboximpl)) {
                if (StageRoles.m11410isSpeakerimpl(iM11412unboximpl)) {
                    z2 = true;
                    z3 = true;
                } else {
                    z2 = true;
                }
            }
        }
        if (!z2) {
            return true;
        }
        if (StageRoles.m11410isSpeakerimpl(stageRolesM11392getMyRolesvisDeB4.m11412unboximpl())) {
            return !z3;
        }
        return false;
    }
}
