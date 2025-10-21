package com.discord.widgets.servers.role_members;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.List;
import rx.functions.Func2;

/* compiled from: ServerSettingsRoleMembersViewModel.kt */
/* renamed from: com.discord.widgets.servers.role_members.ServerSettingsRoleMembersViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class ServerSettingsRoleMembersViewModel4<T1, T2, R> implements Func2<String, ServerSettingsRoleMembersViewModel.StoreState, ServerSettingsRoleMembersViewModel.StoreState> {
    public static final ServerSettingsRoleMembersViewModel4 INSTANCE = new ServerSettingsRoleMembersViewModel4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ ServerSettingsRoleMembersViewModel.StoreState call(String str, ServerSettingsRoleMembersViewModel.StoreState storeState) {
        return call2(str, storeState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final ServerSettingsRoleMembersViewModel.StoreState call2(String str, ServerSettingsRoleMembersViewModel.StoreState storeState) {
        String nick;
        String username;
        Intrinsics3.checkNotNullParameter(str, "filter");
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        List<GuildMember> guildMembers = storeState.getGuildMembers();
        ArrayList arrayList = new ArrayList();
        for (Object obj : guildMembers) {
            GuildMember guildMember = (GuildMember) obj;
            User user = storeState.getUsers().get(Long.valueOf(guildMember.getUserId()));
            boolean z2 = true;
            if ((user == null || (username = user.getUsername()) == null || !Strings4.contains((CharSequence) username, (CharSequence) str, true)) && ((nick = guildMember.getNick()) == null || !Strings4.contains((CharSequence) nick, (CharSequence) str, true))) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(obj);
            }
        }
        return ServerSettingsRoleMembersViewModel.StoreState.copy$default(storeState, arrayList, null, null, 6, null);
    }
}
