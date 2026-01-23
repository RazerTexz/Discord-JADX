package com.discord.stores;

import android.content.Context;
import com.discord.api.application.Application;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreApplication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplication extends StoreV2 {
    private final HashMap<Long, Application> applications;
    private final HashSet<Long> applicationsLoading;
    private HashMap<Long, Application> applicationsSnapshot;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1 */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class C56941 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $appId;

        /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplication.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<List<? extends Application>, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreApplication.kt */
            public static final class C132461 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C132461(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Object next;
                    StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).remove(Long.valueOf(C56941.this.$appId));
                    Iterator it = this.$results.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        } else {
                            next = it.next();
                            if (((Application) next).getId() == C56941.this.$appId) {
                                break;
                            }
                        }
                    }
                    Application application = (Application) next;
                    if (application != null) {
                        StoreApplication.access$getApplications$p(StoreApplication.this).put(Long.valueOf(C56941.this.$appId), application);
                        StoreApplication.this.markChanged();
                    }
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends Application> list) {
                invoke2((List<Application>) list);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<Application> list) {
                Intrinsics3.checkNotNullParameter(list, "results");
                StoreApplication.access$getDispatcher$p(StoreApplication.this).schedule(new C132461(list));
            }
        }

        /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: StoreApplication.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<Error, Unit> {

            /* JADX INFO: renamed from: com.discord.stores.StoreApplication$fetchIfNonexisting$1$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: StoreApplication.kt */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).remove(Long.valueOf(C56941.this.$appId));
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                StoreApplication.access$getDispatcher$p(StoreApplication.this).schedule(new AnonymousClass1());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56941(long j) {
            super(0);
            this.$appId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreApplication.access$getApplications$p(StoreApplication.this).containsKey(Long.valueOf(this.$appId)) || StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).contains(Long.valueOf(this.$appId))) {
                return;
            }
            StoreApplication.access$getApplicationsLoading$p(StoreApplication.this).add(Long.valueOf(this.$appId));
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getApplications(this.$appId), false, 1, null), StoreApplication.this.getClass(), (Context) null, (Function1) null, new AnonymousClass2(), (Function0) null, (Function0) null, new AnonymousClass1(), 54, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$observeApplication$1 */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class C56951 extends Lambda implements Function0<Application> {
        public final /* synthetic */ Long $appId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56951(Long l) {
            super(0);
            this.$appId = l;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Application invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Application invoke() {
            return (Application) StoreApplication.access$getApplicationsSnapshot$p(StoreApplication.this).get(this.$appId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreApplication$observeApplications$1 */
    /* JADX INFO: compiled from: StoreApplication.kt */
    public static final class C56961 extends Lambda implements Function0<Map<Long, ? extends Application>> {
        public final /* synthetic */ Collection $applicationIds;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C56961(Collection collection) {
            super(0);
            this.$applicationIds = collection;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Application> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Application> invoke2() {
            HashMap mapAccess$getApplicationsSnapshot$p = StoreApplication.access$getApplicationsSnapshot$p(StoreApplication.this);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry entry : mapAccess$getApplicationsSnapshot$p.entrySet()) {
                if (this.$applicationIds.contains(Long.valueOf(((Number) entry.getKey()).longValue()))) {
                    linkedHashMap.put(entry.getKey(), entry.getValue());
                }
            }
            return linkedHashMap;
        }
    }

    public StoreApplication(Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.applications = new HashMap<>();
        this.applicationsLoading = new HashSet<>();
        this.applicationsSnapshot = new HashMap<>();
    }

    public static final /* synthetic */ HashMap access$getApplications$p(StoreApplication storeApplication) {
        return storeApplication.applications;
    }

    public static final /* synthetic */ HashSet access$getApplicationsLoading$p(StoreApplication storeApplication) {
        return storeApplication.applicationsLoading;
    }

    public static final /* synthetic */ HashMap access$getApplicationsSnapshot$p(StoreApplication storeApplication) {
        return storeApplication.applicationsSnapshot;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreApplication storeApplication) {
        return storeApplication.dispatcher;
    }

    public static final /* synthetic */ void access$setApplicationsSnapshot$p(StoreApplication storeApplication, HashMap map) {
        storeApplication.applicationsSnapshot = map;
    }

    public final void fetchIfNonexisting(long appId) {
        this.dispatcher.schedule(new C56941(appId));
    }

    public final Observable<Application> observeApplication(Long appId) {
        if (appId != null) {
            fetchIfNonexisting(appId.longValue());
            return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56951(appId), 14, null);
        }
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable\n          .just(null)");
        return scalarSynchronousObservable;
    }

    public final Observable<Map<Long, Application>> observeApplications(Collection<Long> applicationIds) {
        Intrinsics3.checkNotNullParameter(applicationIds, "applicationIds");
        Observable<Map<Long, Application>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C56961(applicationIds), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.applicationsSnapshot = new HashMap<>(this.applications);
    }
}
