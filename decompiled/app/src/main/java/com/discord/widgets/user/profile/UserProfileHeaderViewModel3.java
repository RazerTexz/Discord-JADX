package com.discord.widgets.user.profile;

import androidx.core.app.NotificationCompat;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreUser;
import kotlin.Tuples2;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel3<T, R> implements Func1<MeUser, Observable<? extends Tuples2<? extends MeUser, ? extends User>>> {
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ long $userId;

    /* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1$1 */
    /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
    public static final class C103101<T, R> implements Func1<User, Tuples2<? extends MeUser, ? extends User>> {
        public final /* synthetic */ MeUser $meUser;

        public C103101(MeUser meUser) {
            this.$meUser = meUser;
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Tuples2<? extends MeUser, ? extends User> call(User user) {
            return call2(user);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<MeUser, User> call2(User user) {
            return new Tuples2<>(this.$meUser, user);
        }
    }

    public UserProfileHeaderViewModel3(long j, StoreUser storeUser) {
        this.$userId = j;
        this.$storeUser = storeUser;
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends Tuples2<? extends MeUser, ? extends User>> call(MeUser meUser) {
        return call2(meUser);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends Tuples2<MeUser, User>> call2(MeUser meUser) {
        long j = this.$userId;
        return j == -1 ? new ScalarSynchronousObservable(new Tuples2(meUser, meUser)) : this.$storeUser.observeUser(j).m11083G(new C103101(meUser));
    }
}
