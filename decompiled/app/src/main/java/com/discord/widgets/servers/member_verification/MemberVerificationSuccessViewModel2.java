package com.discord.widgets.servers.member_verification;

import androidx.core.app.NotificationCompat;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.guild.Guild;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel;
import rx.functions.Func2;

/* compiled from: MemberVerificationSuccessViewModel.kt */
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationSuccessViewModel2<T1, T2, R> implements Func2<GuildJoinRequest, Guild, MemberVerificationSuccessViewModel.StoreState> {
    public static final MemberVerificationSuccessViewModel2 INSTANCE = new MemberVerificationSuccessViewModel2();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ MemberVerificationSuccessViewModel.StoreState call(GuildJoinRequest guildJoinRequest, Guild guild) {
        return call2(guildJoinRequest, guild);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final MemberVerificationSuccessViewModel.StoreState call2(GuildJoinRequest guildJoinRequest, Guild guild) {
        return new MemberVerificationSuccessViewModel.StoreState(guildJoinRequest != null ? guildJoinRequest.getLastSeen() : null, guild != null ? guild.getName() : null);
    }
}
