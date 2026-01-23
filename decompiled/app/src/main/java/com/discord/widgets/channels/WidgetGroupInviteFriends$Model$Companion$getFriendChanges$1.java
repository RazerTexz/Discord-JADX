package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends List<User>>> {
    public final /* synthetic */ Observable $addedUsers;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1 */
    /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
    public static final class C73841<T, R> implements Func1<Collection<? extends User>, Observable<? extends List<User>>> {
        public final /* synthetic */ Map $friends;

        /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
        public static final class AnonymousClass1<T, R> implements Func1<User, Boolean> {
            public AnonymousClass1() {
            }

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ Boolean call(User user) {
                return call2(user);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(User user) {
                return Boolean.valueOf(C73841.this.$friends.containsKey(Long.valueOf(user.getId())));
            }
        }

        public C73841(Map map) {
            this.$friends = map;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Collection<? extends User> collection) {
            return call2(collection);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<User>> call2(Collection<? extends User> collection) {
            return Observable.m11058B(collection).m11118y(new AnonymousClass1()).m11105f0();
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1(Observable observable) {
        this.$addedUsers = observable;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<User>> call2(Map<Long, Integer> map) {
        return this.$addedUsers.m11099Y(new C73841(map));
    }
}
