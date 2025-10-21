package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func2;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeStoreState$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel4<T1, T2, R> implements Func2<Channel, Map<Long, ? extends User>, GroupInviteFriendsSheetViewModel.StoreState> {
    public static final GroupInviteFriendsSheetViewModel4 INSTANCE = new GroupInviteFriendsSheetViewModel4();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel.StoreState call(Channel channel, Map<Long, ? extends User> map) {
        return call2(channel, map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsSheetViewModel.StoreState call2(Channel channel, Map<Long, ? extends User> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "friendUsersMap");
        return new GroupInviteFriendsSheetViewModel.StoreState(map, channel);
    }
}
