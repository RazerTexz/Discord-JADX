package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.User;
import j0.k.Func1;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* compiled from: WidgetGroupInviteFriends.kt */
/* loaded from: classes2.dex */
public final class WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1<T, R> implements Func1<Map<Long, ? extends Integer>, Observable<? extends List<User>>> {
    public final /* synthetic */ Observable $addedUsers;

    /* compiled from: WidgetGroupInviteFriends.kt */
    /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<Collection<? extends User>, Observable<? extends List<User>>> {
        public final /* synthetic */ Map $friends;

        /* compiled from: WidgetGroupInviteFriends.kt */
        /* renamed from: com.discord.widgets.channels.WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02441<T, R> implements Func1<User, Boolean> {
            public C02441() {
            }

            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Boolean call(User user) {
                return call2(user);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final Boolean call2(User user) {
                return Boolean.valueOf(AnonymousClass1.this.$friends.containsKey(Long.valueOf(user.getId())));
            }
        }

        public AnonymousClass1(Map map) {
            this.$friends = map;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Collection<? extends User> collection) {
            return call2(collection);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends List<User>> call2(Collection<? extends User> collection) {
            return Observable.B(collection).y(new C02441()).f0();
        }
    }

    public WidgetGroupInviteFriends$Model$Companion$getFriendChanges$1(Observable observable) {
        this.$addedUsers = observable;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends List<User>> call(Map<Long, ? extends Integer> map) {
        return call2((Map<Long, Integer>) map);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<User>> call2(Map<Long, Integer> map) {
        return this.$addedUsers.Y(new AnonymousClass1(map));
    }
}
