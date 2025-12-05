package com.discord.widgets.servers.role_members;

import com.discord.models.member.GuildMember;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ServerSettingsRoleMembersViewModel.kt */
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeGuildRoleMembers$1$guildMembers$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel3 extends Lambda implements Function1<GuildMember, Boolean> {
    public final /* synthetic */ ServerSettingsRoleMembersViewModel2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsRoleMembersViewModel3(ServerSettingsRoleMembersViewModel2 serverSettingsRoleMembersViewModel2) {
        super(1);
        this.this$0 = serverSettingsRoleMembersViewModel2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(GuildMember guildMember) {
        return Boolean.valueOf(invoke2(guildMember));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(GuildMember guildMember) {
        Intrinsics3.checkNotNullParameter(guildMember, "it");
        return guildMember.getRoles().contains(Long.valueOf(this.this$0.$guildRoleId));
    }
}
