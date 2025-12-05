package com.discord.widgets.channels.invite;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel;
import java.util.Map;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;

/* compiled from: GroupInviteFriendsSheetViewModel.kt */
/* renamed from: com.discord.widgets.channels.invite.GroupInviteFriendsSheetViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GroupInviteFriendsSheetViewModel3<T, R> implements Func1<Map<Long, ? extends User>, GroupInviteFriendsSheetViewModel.StoreState> {
    public static final GroupInviteFriendsSheetViewModel3 INSTANCE = new GroupInviteFriendsSheetViewModel3();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ GroupInviteFriendsSheetViewModel.StoreState call(Map<Long, ? extends User> map) {
        return call2(map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final GroupInviteFriendsSheetViewModel.StoreState call2(Map<Long, ? extends User> map) {
        Intrinsics3.checkNotNullExpressionValue(map, "friendsUsers");
        return new GroupInviteFriendsSheetViewModel.StoreState(map, null, 2, null);
    }
}
