package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsFindNearby;
import kotlin.NoWhenBranchMatchedException;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* compiled from: WidgetFriendsFindNearby.kt */
/* renamed from: com.discord.widgets.friends.WidgetFriendsFindNearby$ModelProvider$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby2<T, R> implements Func1<NearbyManager.NearbyState, Observable<? extends WidgetFriendsFindNearby.Model>> {
    public static final WidgetFriendsFindNearby2 INSTANCE = new WidgetFriendsFindNearby2();

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetFriendsFindNearby.Model> call(NearbyManager.NearbyState nearbyState) {
        return call2(nearbyState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetFriendsFindNearby.Model> call2(NearbyManager.NearbyState nearbyState) {
        ScalarSynchronousObservable scalarSynchronousObservable;
        if (nearbyState instanceof NearbyManager.NearbyState.Disconnected) {
            return new ScalarSynchronousObservable(new WidgetFriendsFindNearby.Model.Error(Integer.valueOf(((NearbyManager.NearbyState.Disconnected) nearbyState).getCode())));
        }
        if (nearbyState instanceof NearbyManager.NearbyState.Uninitialized) {
            scalarSynchronousObservable = new ScalarSynchronousObservable(WidgetFriendsFindNearby.Model.Uninitialized.INSTANCE);
        } else {
            if (!(nearbyState instanceof NearbyManager.NearbyState.Connected)) {
                throw new NoWhenBranchMatchedException();
            }
            NearbyManager.NearbyState.Connected connected = (NearbyManager.NearbyState.Connected) nearbyState;
            if (!connected.getNearbyUserIds().isEmpty()) {
                return WidgetFriendsFindNearby.ModelProvider.access$getUserModels(WidgetFriendsFindNearby.ModelProvider.INSTANCE, connected.getNearbyUserIds());
            }
            scalarSynchronousObservable = new ScalarSynchronousObservable(WidgetFriendsFindNearby.Model.Empty.INSTANCE);
        }
        return scalarSynchronousObservable;
    }
}
