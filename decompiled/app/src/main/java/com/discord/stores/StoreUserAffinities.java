package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelUserAffinities;
import com.discord.models.domain.ModelUserAffinity;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

/* compiled from: StoreUserAffinities.kt */
/* loaded from: classes2.dex */
public final class StoreUserAffinities extends StoreV2 {
    private ModelUserAffinities affinities;
    private ModelUserAffinities affinitiesSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* compiled from: StoreUserAffinities.kt */
    /* renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1 */
    public static final class C65581 extends Lambda implements Function1<ModelUserAffinities, Unit> {

        /* compiled from: StoreUserAffinities.kt */
        /* renamed from: com.discord.stores.StoreUserAffinities$fetchUserAffinities$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ModelUserAffinities $affinities;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ModelUserAffinities modelUserAffinities) {
                super(0);
                this.$affinities = modelUserAffinities;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserAffinities.access$handleUserAffinitiesFetchSuccess(StoreUserAffinities.this, this.$affinities);
            }
        }

        public C65581() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserAffinities modelUserAffinities) {
            invoke2(modelUserAffinities);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserAffinities modelUserAffinities) {
            Intrinsics3.checkNotNullParameter(modelUserAffinities, "affinities");
            StoreUserAffinities.access$getDispatcher$p(StoreUserAffinities.this).schedule(new AnonymousClass1(modelUserAffinities));
        }
    }

    /* compiled from: StoreUserAffinities.kt */
    /* renamed from: com.discord.stores.StoreUserAffinities$observeAffinityUserIds$1 */
    public static final class C65591<T, R> implements Func1<ModelUserAffinities, List<? extends Long>> {
        public static final C65591 INSTANCE = new C65591();

        @Override // p637j0.p641k.Func1
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
    /* renamed from: com.discord.stores.StoreUserAffinities$observeUserAffinities$1 */
    public static final class C65601 extends Lambda implements Function0<ModelUserAffinities> {
        public C65601() {
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
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserAffinities(), false, 1, null), StoreUserAffinities.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C65581(), 62, (Object) null);
    }

    @Store3
    private final void handleUserAffinitiesFetchSuccess(ModelUserAffinities affinities) {
        this.affinities = affinities;
        markChanged();
    }

    private final Observable<ModelUserAffinities> observeUserAffinities() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C65601(), 14, null);
    }

    @Store3
    public final void handleConnectionOpen() {
        fetchUserAffinities();
    }

    public final Observable<List<Long>> observeAffinityUserIds() {
        Observable<List<Long>> observableM11112r = observeUserAffinities().m11083G(C65591.INSTANCE).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observeUserAffinities()\n…  .distinctUntilChanged()");
        return observableM11112r;
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
