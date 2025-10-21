package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Tuples2;
import rx.Observable;

/* compiled from: UserProfileHeaderViewModel.kt */
/* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class UserProfileHeaderViewModel3<T, R> implements Func1<MeUser, Observable<? extends Tuples2<? extends MeUser, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ long $userId;

    /* compiled from: UserProfileHeaderViewModel.kt */
    /* renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<User, Tuples2<? extends MeUser, ? extends User>> {
        public final /* synthetic */ MeUser $meUser;

        public AnonymousClass1(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends User> call(User user) {
            return call2(user);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<MeUser, User> call2(User user) {
            return new Tuples2<>(this.$meUser, user);
        }
    }

    public UserProfileHeaderViewModel3(long j, StoreUser storeUser) {
        this.$userId = j;
        this.$storeUser = storeUser;
    }

    @Override // j0.k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends MeUser, ? extends User>> call(MeUser meUser) {
        return call2(meUser);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Tuples2<MeUser, User>> call2(MeUser meUser) {
        long j = this.$userId;
        return j == -1 ? new ScalarSynchronousObservable(new Tuples2(meUser, meUser)) : this.$storeUser.observeUser(j).G(new AnonymousClass1(meUser));
    }
}
