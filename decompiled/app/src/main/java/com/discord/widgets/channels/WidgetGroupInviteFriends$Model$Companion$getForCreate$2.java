package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Collection;
import java.util.List;
import rx.Observable;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForCreate$2<T, R> implements Func1<WidgetGroupInviteFriends.Model.Companion.AddedUsersInput, Observable<? extends WidgetGroupInviteFriends.Model>> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForCreate$2 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForCreate$2();

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<WidgetGroupInviteFriends.Model.ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends.Model.FriendItem>> {
        public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

        public AnonymousClass1(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            this.$usersFilter = addedUsersInput;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends WidgetGroupInviteFriends.Model.FriendItem> call(WidgetGroupInviteFriends.Model.ModelAppUserRelationship modelAppUserRelationship) {
            return call2(modelAppUserRelationship);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<WidgetGroupInviteFriends.Model.FriendItem> call2(WidgetGroupInviteFriends.Model.ModelAppUserRelationship modelAppUserRelationship) {
            WidgetGroupInviteFriends.Model.FriendItem.Companion companion = WidgetGroupInviteFriends.Model.FriendItem.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(modelAppUserRelationship, "friends");
            return companion.createData(modelAppUserRelationship, this.$usersFilter.getAddedUsers());
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForCreate$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<List<? extends WidgetGroupInviteFriends.Model.FriendItem>, Observable<? extends WidgetGroupInviteFriends.Model>> {
        public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

        public AnonymousClass2(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            this.$usersFilter = addedUsersInput;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(List<? extends WidgetGroupInviteFriends.Model.FriendItem> list) {
            return call2((List<WidgetGroupInviteFriends.Model.FriendItem>) list);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetGroupInviteFriends.Model> call2(List<WidgetGroupInviteFriends.Model.FriendItem> list) {
            String filter = this.$usersFilter.getFilter();
            Collection<User> addedUsers = this.$usersFilter.getAddedUsers();
            Intrinsics3.checkNotNullExpressionValue(list, "friendItems");
            return new ScalarSynchronousObservable(new WidgetGroupInviteFriends.Model(null, filter, addedUsers, list, 0, UserUtils.INSTANCE.isStaff(StoreStream.INSTANCE.getUsers().getMeSnapshot()) ? 25 : 10));
        }
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
        return call2(addedUsersInput);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model> call2(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
        return WidgetGroupInviteFriends.Model.Companion.access$getFilteredFriends(WidgetGroupInviteFriends.Model.INSTANCE, null, addedUsersInput.getFilter()).G(new AnonymousClass1(addedUsersInput)).Y(new AnonymousClass2(addedUsersInput));
    }
}
