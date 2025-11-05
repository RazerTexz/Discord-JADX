package com.discord.widgets.friends;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.friends.NearbyManager;
import com.discord.widgets.friends.WidgetFriendsFindNearby;
import j0.k.b;
import j0.l.e.k;
import kotlin.NoWhenBranchMatchedException;
import rx.Observable;

/* compiled from: WidgetFriendsFindNearby.kt */
/* loaded from: classes2.dex */
public final class WidgetFriendsFindNearby$ModelProvider$get$1<T, R> implements b<NearbyManager.NearbyState, Observable<? extends WidgetFriendsFindNearby.Model>> {
    public static final WidgetFriendsFindNearby$ModelProvider$get$1 INSTANCE = new WidgetFriendsFindNearby$ModelProvider$get$1();

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetFriendsFindNearby.Model> call(NearbyManager.NearbyState nearbyState) {
        return call2(nearbyState);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetFriendsFindNearby.Model> call2(NearbyManager.NearbyState nearbyState) {
        k kVar;
        if (nearbyState instanceof NearbyManager.NearbyState.Disconnected) {
            return new k(new WidgetFriendsFindNearby.Model.Error(Integer.valueOf(((NearbyManager.NearbyState.Disconnected) nearbyState).getCode())));
        }
        if (nearbyState instanceof NearbyManager.NearbyState.Uninitialized) {
            kVar = new k(WidgetFriendsFindNearby.Model.Uninitialized.INSTANCE);
        } else {
            if (!(nearbyState instanceof NearbyManager.NearbyState.Connected)) {
                throw new NoWhenBranchMatchedException();
            }
            NearbyManager.NearbyState.Connected connected = (NearbyManager.NearbyState.Connected) nearbyState;
            if (!connected.getNearbyUserIds().isEmpty()) {
                return WidgetFriendsFindNearby.ModelProvider.access$getUserModels(WidgetFriendsFindNearby.ModelProvider.INSTANCE, connected.getNearbyUserIds());
            }
            kVar = new k(WidgetFriendsFindNearby.Model.Empty.INSTANCE);
        }
        return kVar;
    }
}
