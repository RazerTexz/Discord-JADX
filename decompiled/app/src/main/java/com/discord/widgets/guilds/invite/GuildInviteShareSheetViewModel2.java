package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Map;
import rx.functions.Func7;

/* compiled from: GuildInviteShareSheetViewModel.kt */
/* renamed from: com.discord.widgets.guilds.invite.GuildInviteShareSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildInviteShareSheetViewModel2<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<ModelInvite.Settings, Map<Long, ? extends Channel>, MeUser, List<? extends Channel>, Guild, List<? extends InviteSuggestion>, Map<Long, ? extends StageInstance>, GuildInviteShareSheetViewModel.StoreState> {
    public static final GuildInviteShareSheetViewModel2 INSTANCE = new GuildInviteShareSheetViewModel2();

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ GuildInviteShareSheetViewModel.StoreState call(ModelInvite.Settings settings, Map<Long, ? extends Channel> map, MeUser meUser, List<? extends Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, ? extends StageInstance> map2) {
        return call2(settings, (Map<Long, Channel>) map, meUser, (List<Channel>) list, guild, list2, (Map<Long, StageInstance>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildInviteShareSheetViewModel.StoreState call2(ModelInvite.Settings settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
        if (guild == null) {
            return GuildInviteShareSheetViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(settings, "inviteSettings");
        Intrinsics3.checkNotNullExpressionValue(map, "invitableChannels");
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        Intrinsics3.checkNotNullExpressionValue(list, "dms");
        Intrinsics3.checkNotNullExpressionValue(list2, "inviteSuggestions");
        Intrinsics3.checkNotNullExpressionValue(map2, "guildStageInstances");
        return new GuildInviteShareSheetViewModel.StoreState.Valid(settings, map, meUser, list, guild, list2, map2);
    }
}
