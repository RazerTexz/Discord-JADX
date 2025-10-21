package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserAffinity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserAffinities.kt */
/* loaded from: classes2.dex */
public final class StoreUserAffinities extends StoreV2 {
    private ModelUserAffinities affinities;
    private ModelUserAffinities affinitiesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreUserAffinities.kt */
    /* renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserAffinities, Unit> {

        /* compiled from: StoreUserAffinities.kt */
        /* renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C01831 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelUserAffinities $affinities;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01831(ModelUserAffinities modelUserAffinities) {
                super(0);
                this.$affinities = modelUserAffinities;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserAffinities.access$handleUserAffinitiesFetchSuccess(StoreUserAffinities.this, this.$affinities);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserAffinities modelUserAffinities) {
            invoke2(modelUserAffinities);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserAffinities modelUserAffinities) {
            Intrinsics3.checkNotNullParameter(modelUserAffinities, "affinities");
            StoreUserAffinities.access$getDispatcher$p(StoreUserAffinities.this).schedule(new C01831(modelUserAffinities));
        }
    }

    /* compiled from: StoreUserAffinities.kt */
    /* renamed from: com.discord.stores.StoreUserAffinities$observeAffinityUserIds$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements Func1<ModelUserAffinities, List<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.Func1
        public /* bridge */ /* synthetic */ List<? extends Long> call(ModelUserAffinities modelUserAffinities) {
            return call2(modelUserAffinities);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final List<Long> call2(ModelUserAffinities modelUserAffinities) {
            List<ModelUserAffinity> userAffinities = modelUserAffinities.getUserAffinities();
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(userAffinities, 10));
            Iterator<T> it = userAffinities.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((ModelUserAffinity) it.next()).getUserId()));
            }
            return arrayList;
        }
    }

    /* compiled from: StoreUserAffinities.kt */
    /* renamed from: com.discord.stores.StoreUserAffinities$observeUserAffinities$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<ModelUserAffinities> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ ModelUserAffinities invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ModelUserAffinities invoke() {
            return StoreUserAffinities.access$getAffinitiesSnapshot$p(StoreUserAffinities.this);
        }
    }

    public /* synthetic */ StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck);
    }

    public static final /* synthetic */ ModelUserAffinities access$getAffinitiesSnapshot$p(StoreUserAffinities storeUserAffinities) {
        return storeUserAffinities.affinitiesSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserAffinities storeUserAffinities) {
        return storeUserAffinities.dispatcher;
    }

    public static final /* synthetic */ void access$handleUserAffinitiesFetchSuccess(StoreUserAffinities storeUserAffinities, ModelUserAffinities modelUserAffinities) {
        storeUserAffinities.handleUserAffinitiesFetchSuccess(modelUserAffinities);
    }

    public static final /* synthetic */ void access$setAffinitiesSnapshot$p(StoreUserAffinities storeUserAffinities, ModelUserAffinities modelUserAffinities) {
        storeUserAffinities.affinitiesSnapshot = modelUserAffinities;
    }

    @Store3
    private final void fetchUserAffinities() {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserAffinities(), false, 1, null), StoreUserAffinities.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Store3
    private final void handleUserAffinitiesFetchSuccess(ModelUserAffinities affinities) {
        this.affinities = affinities;
        markChanged();
    }

    private final Observable<ModelUserAffinities> observeUserAffinities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Store3
    public final void handleConnectionOpen() {
        fetchUserAffinities();
    }

    public final Observable<List<Long>> observeAffinityUserIds() {
        Observable<List<Long>> observableR = observeUserAffinities().G(AnonymousClass1.INSTANCE).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeUserAffinities()\n…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.affinitiesSnapshot = new ModelUserAffinities(_Collections.toList(this.affinities.getUserAffinities()), _Collections.toList(this.affinities.getInverseUserAffinities()));
    }

    public StoreUserAffinities(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.affinities = new ModelUserAffinities(Collections2.emptyList(), Collections2.emptyList());
        this.affinitiesSnapshot = new ModelUserAffinities(Collections2.emptyList(), Collections2.emptyList());
    }
}
