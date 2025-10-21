package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreGuildMemberVerificationForm;
import com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func6;

/* compiled from: WidgetMemberVerificationViewModel.kt */
/* renamed from: com.discord.widgets.servers.member_verification.WidgetMemberVerificationViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetMemberVerificationViewModel2<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, Guild, StoreGuildMemberVerificationForm.MemberVerificationFormData, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, Boolean, WidgetMemberVerificationViewModel.StoreState> {
    public final /* synthetic */ Guild $inviteGuild;

    public WidgetMemberVerificationViewModel2(Guild guild) {
        this.$inviteGuild = guild;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetMemberVerificationViewModel.StoreState call(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, ? extends String> map, Map<Long, ? extends GuildRole> map2, Boolean bool) {
        return call2(meUser, guild, memberVerificationFormData, (Map<Long, String>) map, (Map<Long, GuildRole>) map2, bool);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationViewModel.StoreState call2(MeUser meUser, Guild guild, StoreGuildMemberVerificationForm.MemberVerificationFormData memberVerificationFormData, Map<Long, String> map, Map<Long, GuildRole> map2, Boolean bool) {
        Intrinsics3.checkNotNullExpressionValue(meUser, "me");
        if (guild == null) {
            guild = this.$inviteGuild;
        }
        Intrinsics3.checkNotNullExpressionValue(map, "channels");
        Intrinsics3.checkNotNullExpressionValue(map2, "roles");
        Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
        return new WidgetMemberVerificationViewModel.StoreState(meUser, guild, memberVerificationFormData, map, map2, bool.booleanValue());
    }
}
