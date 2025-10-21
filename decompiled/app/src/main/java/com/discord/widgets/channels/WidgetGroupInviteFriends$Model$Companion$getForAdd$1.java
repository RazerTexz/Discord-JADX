package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.user.CoreUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import rx.Observable;
import rx.functions.Func2;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getForAdd$1<T, R> implements Func1<Channel, Observable<? extends WidgetGroupInviteFriends.Model>> {
    public final /* synthetic */ Observable $addedUsersPublisher;
    public final /* synthetic */ Observable $filterPublisher;

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(2, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke(Collection<? extends User> collection, String str) {
            return invoke2(collection, str);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke2(Collection<? extends User> collection, String str) {
            Intrinsics3.checkNotNullParameter(collection, "p1");
            Intrinsics3.checkNotNullParameter(str, "p2");
            return new WidgetGroupInviteFriends.Model.Companion.AddedUsersInput(collection, str);
        }
    }

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements Func1<WidgetGroupInviteFriends.Model.Companion.AddedUsersInput, Observable<? extends WidgetGroupInviteFriends.Model>> {
        public final /* synthetic */ Channel $channel;

        /* compiled from: WidgetGroupInviteFriends.kt */
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$2, reason: invalid class name and collision with other inner class name */
        public static final class C02432<T, R> implements Func1<WidgetGroupInviteFriends.Model.ModelAppUserRelationship, List<? extends WidgetGroupInviteFriends.Model.FriendItem>> {
            public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

            public C02432(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
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
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getForAdd$1$2$3, reason: invalid class name */
        public static final class AnonymousClass3<T, R> implements Func1<List<? extends WidgetGroupInviteFriends.Model.FriendItem>, Observable<? extends WidgetGroupInviteFriends.Model>> {
            public final /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput $usersFilter;

            public AnonymousClass3(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
                this.$usersFilter = addedUsersInput;
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(List<? extends WidgetGroupInviteFriends.Model.FriendItem> list) {
                return call2((List<WidgetGroupInviteFriends.Model.FriendItem>) list);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends WidgetGroupInviteFriends.Model> call2(List<WidgetGroupInviteFriends.Model.FriendItem> list) {
                Channel channel = AnonymousClass2.this.$channel;
                String filter = this.$usersFilter.getFilter();
                Collection<User> addedUsers = this.$usersFilter.getAddedUsers();
                Intrinsics3.checkNotNullExpressionValue(list, "friendItems");
                return new ScalarSynchronousObservable(new WidgetGroupInviteFriends.Model(channel, filter, addedUsers, list, 1, UserUtils.INSTANCE.isStaff(StoreStream.INSTANCE.getUsers().getMeSnapshot()) ? 25 : 10));
            }
        }

        public AnonymousClass2(Channel channel) {
            this.$channel = channel;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            return call2(addedUsersInput);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends WidgetGroupInviteFriends.Model> call2(WidgetGroupInviteFriends.Model.Companion.AddedUsersInput addedUsersInput) {
            ArrayList arrayList;
            WidgetGroupInviteFriends.Model.Companion companion = WidgetGroupInviteFriends.Model.INSTANCE;
            List<com.discord.api.user.User> listZ = this.$channel.z();
            if (listZ != null) {
                arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listZ, 10));
                Iterator<T> it = listZ.iterator();
                while (it.hasNext()) {
                    arrayList.add(new CoreUser((com.discord.api.user.User) it.next()));
                }
            } else {
                arrayList = null;
            }
            return WidgetGroupInviteFriends.Model.Companion.access$getFilteredFriends(companion, arrayList, addedUsersInput.getFilter()).G(new C02432(addedUsersInput)).Y(new AnonymousClass3(addedUsersInput));
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getForAdd$1(Observable observable, Observable observable2) {
        this.$addedUsersPublisher = observable;
        this.$filterPublisher = observable2;
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetGroupInviteFriends.Model> call2(Channel channel) {
        if (channel == null) {
            return new ScalarSynchronousObservable(null);
        }
        Observable observable = this.$addedUsersPublisher;
        Observable observable2 = this.$filterPublisher;
        AnonymousClass1 anonymousClass1 = AnonymousClass1.INSTANCE;
        Object widgetGroupInviteFriends$sam$rx_functions_Func2$0 = anonymousClass1;
        if (anonymousClass1 != null) {
            widgetGroupInviteFriends$sam$rx_functions_Func2$0 = new WidgetGroupInviteFriends$sam$rx_functions_Func2$0(anonymousClass1);
        }
        return Observable.j(observable, observable2, (Func2) widgetGroupInviteFriends$sam$rx_functions_Func2$0).Y(new AnonymousClass2(channel));
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetGroupInviteFriends.Model> call(Channel channel) {
        return call2(channel);
    }
}
