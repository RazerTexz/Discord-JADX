package com.discord.stores;

import android.content.Context;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventMeUser;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.guildscheduledevent.GuildScheduledEventUserUpdate;
import com.discord.api.permission.Permission;
import com.discord.models.domain.ModelPayload;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventUser;
import d0.d0.f;
import d0.f0.q;
import d0.t.h0;
import d0.t.n;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreGuildScheduledEvents.kt */
/* loaded from: classes2.dex */
public final class StoreGuildScheduledEvents extends StoreV2 {
    public static final long FETCH_GUILD_EVENTS_THRESHOLD = 1800000;
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final StoreExperiments experimentsStore;
    private final HashMap<Long, HashMap<Long, GuildScheduledEventUser>> guildScheduledEventUsers;
    private final HashMap<Long, Set<Long>> guildScheduledEventUsersFetches;
    private Map<Long, ? extends Map<Long, GuildScheduledEventUser>> guildScheduledEventUsersSnapshot;
    private final HashMap<Long, List<GuildScheduledEvent>> guildScheduledEvents;
    private final HashMap<Long, Long> guildScheduledEventsFetchTimestamps;
    private Map<Long, ? extends List<GuildScheduledEvent>> guildScheduledEventsSnapshot;
    private final StoreGuilds guildsStore;
    private boolean isFetchingGuildScheduledEventUsers;
    private boolean isGuildScheduledEventUsersError;
    private final HashMap<Long, Long> lastAckedGuildScheduledEventIds;
    private final HashMap<Long, Set<Long>> meGuildScheduledEventIds;
    private Map<Long, ? extends Set<Long>> meGuildScheduledEventIdsSnapshot;
    private final HashSet<Long> meGuildScheduledEventsFetches;
    private final ObservationDeck observationDeck;
    private final StorePermissions permissionsStore;
    private final HashSet<Long> rsvpsAwaitingNetwork;
    private HashSet<Long> rsvpsAwaitingSnapshot;
    private final StoreUser userStore;

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$ackGuildEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildScheduledEvent $mostRecentEvent;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEvent guildScheduledEvent, long j) {
            super(1);
            this.$mostRecentEvent = guildScheduledEvent;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            StoreGuildScheduledEvents.access$getLastAckedGuildScheduledEventIds$p(StoreGuildScheduledEvents.this).put(Long.valueOf(this.$guildId), Long.valueOf(this.$mostRecentEvent.getId()));
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends GuildScheduledEvent>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUserCounts$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02471 extends o implements Function0<Unit> {
            public final /* synthetic */ List $events;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02471(List list) {
                super(0);
                this.$events = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildScheduledEvents.access$getGuildScheduledEvents$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), u.toMutableList((Collection) this.$events));
                StoreGuildScheduledEvents.access$getGuildScheduledEventsFetchTimestamps$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), Long.valueOf(StoreGuildScheduledEvents.access$getClock$p(StoreGuildScheduledEvents.this).currentTimeMillis()));
                StoreGuildScheduledEvents.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEvent> list) {
            invoke2((List<GuildScheduledEvent>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<GuildScheduledEvent> list) {
            m.checkNotNullParameter(list, "events");
            StoreGuildScheduledEvents.access$getDispatcher$p(StoreGuildScheduledEvents.this).schedule(new C02471(list));
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02481 extends o implements Function1<Error, Unit> {
            public C02481() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                m.checkNotNullParameter(error, "it");
                StoreGuildScheduledEvents.access$handleFetchRsvpUsersFailure(StoreGuildScheduledEvents.this);
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<List<? extends ApiGuildScheduledEventUser>, Unit> {

            /* compiled from: StoreGuildScheduledEvents.kt */
            /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02491 extends o implements Function0<Unit> {
                public final /* synthetic */ List $apiGuildScheduledEventUsers;

                /* compiled from: StoreGuildScheduledEvents.kt */
                /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchGuildScheduledEventUsers$1$2$1$1, reason: invalid class name and collision with other inner class name */
                public static final class C02501 extends o implements Function1<ApiGuildScheduledEventUser, GuildScheduledEventUser> {
                    public C02501() {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ GuildScheduledEventUser invoke(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
                        return invoke2(apiGuildScheduledEventUser);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final GuildScheduledEventUser invoke2(ApiGuildScheduledEventUser apiGuildScheduledEventUser) {
                        m.checkNotNullParameter(apiGuildScheduledEventUser, "apiEventUser");
                        return GuildScheduledEventUser.INSTANCE.from(apiGuildScheduledEventUser, AnonymousClass1.this.$guildId);
                    }
                }

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02491(List list) {
                    super(0);
                    this.$apiGuildScheduledEventUsers = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    StoreGuildScheduledEvents.access$getUserStore$p(StoreGuildScheduledEvents.this).handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers);
                    StoreGuildScheduledEvents.access$getGuildsStore$p(StoreGuildScheduledEvents.this).handleGuildScheduledEventUsersFetch(this.$apiGuildScheduledEventUsers, AnonymousClass1.this.$guildId);
                    HashMap map = (HashMap) StoreGuildScheduledEvents.access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this).get(Long.valueOf(AnonymousClass1.this.$eventId));
                    if (map == null) {
                        map = new HashMap();
                    }
                    for (GuildScheduledEventUser guildScheduledEventUser : q.mapNotNull(u.asSequence(this.$apiGuildScheduledEventUsers), new C02501())) {
                        map.put(Long.valueOf(guildScheduledEventUser.getUser().getId()), guildScheduledEventUser);
                    }
                    StoreGuildScheduledEvents.access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$eventId), map);
                    Set linkedHashSet = (Set) StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents.this).get(Long.valueOf(AnonymousClass1.this.$guildId));
                    if (linkedHashSet == null) {
                        linkedHashSet = new LinkedHashSet();
                    }
                    linkedHashSet.add(Long.valueOf(AnonymousClass1.this.$eventId));
                    StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), linkedHashSet);
                    StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this, false);
                    StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents.this, false);
                    StoreGuildScheduledEvents.this.markChanged();
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ApiGuildScheduledEventUser> list) {
                invoke2((List<ApiGuildScheduledEventUser>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ApiGuildScheduledEventUser> list) {
                m.checkNotNullParameter(list, "apiGuildScheduledEventUsers");
                StoreGuildScheduledEvents.access$getDispatcher$p(StoreGuildScheduledEvents.this).schedule(new C02491(list));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$eventId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Set setEmptySet = (Set) StoreGuildScheduledEvents.access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents.this).get(Long.valueOf(this.$guildId));
            if (setEmptySet == null) {
                setEmptySet = n0.emptySet();
            }
            if (setEmptySet.contains(Long.valueOf(this.$eventId))) {
                return;
            }
            StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this, true);
            StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents.this, false);
            StoreGuildScheduledEvents.this.markChanged();
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildScheduledEventUsers(this.$guildId, this.$eventId, 100, true, true), false, 1, null), StoreGuildScheduledEvents.this.getClass(), (Context) null, (Function1) null, new C02481(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends GuildScheduledEventMeUser>, Unit> {
        public final /* synthetic */ long $guildId;

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$fetchMeGuildScheduledEvents$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02511 extends o implements Function0<Unit> {
            public final /* synthetic */ List $eventUsers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02511(List list) {
                super(0);
                this.$eventUsers = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List list = this.$eventUsers;
                ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(list, 10));
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(Long.valueOf(((GuildScheduledEventMeUser) it.next()).getGuildScheduledEventId()));
                }
                StoreGuildScheduledEvents.access$getMeGuildScheduledEventIds$p(StoreGuildScheduledEvents.this).put(Long.valueOf(AnonymousClass1.this.$guildId), u.toMutableSet(arrayList));
                StoreGuildScheduledEvents.access$getMeGuildScheduledEventsFetches$p(StoreGuildScheduledEvents.this).add(Long.valueOf(AnonymousClass1.this.$guildId));
                StoreGuildScheduledEvents.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends GuildScheduledEventMeUser> list) {
            invoke2((List<GuildScheduledEventMeUser>) list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<GuildScheduledEventMeUser> list) {
            m.checkNotNullParameter(list, "eventUsers");
            StoreGuildScheduledEvents.access$getDispatcher$p(StoreGuildScheduledEvents.this).schedule(new C02511(list));
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$handleFetchRsvpUsersFailure$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildScheduledEvents.access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents.this, false);
            StoreGuildScheduledEvents.access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents.this, true);
            StoreGuildScheduledEvents.this.markChanged();
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$observeGuildScheduledEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<GuildScheduledEvent> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ Long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Long l, Long l2) {
            super(0);
            this.$eventId = l;
            this.$guildId = l2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ GuildScheduledEvent invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildScheduledEvent invoke() {
            Long l = this.$eventId;
            if (l != null) {
                return StoreGuildScheduledEvents.this.findEventFromStore(l.longValue(), this.$guildId);
            }
            return null;
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$observeGuildScheduledEvents$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<List<? extends GuildScheduledEvent>> {
        public final /* synthetic */ boolean $filterInaccessible;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, boolean z2) {
            super(0);
            this.$guildId = j;
            this.$filterInaccessible = z2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ List<? extends GuildScheduledEvent> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final List<? extends GuildScheduledEvent> invoke2() {
            return StoreGuildScheduledEvents.this.getGuildScheduledEvents(this.$guildId, this.$filterInaccessible);
        }
    }

    /* compiled from: StoreGuildScheduledEvents.kt */
    /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $eventId;
        public final /* synthetic */ GuildScheduledEvent $guildScheduledEvent;
        public final /* synthetic */ GuildScheduledEvent $storeEvent;

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02521 extends o implements Function1<Error, Unit> {
            public C02521() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                m.checkNotNullParameter(error, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpCreate(storeGuildScheduledEvents, StoreGuildScheduledEvents.access$findEventFromStore(storeGuildScheduledEvents, anonymousClass1.$storeEvent), StoreGuildScheduledEvents.access$getUserStore$p(StoreGuildScheduledEvents.this).getMeSnapshot().getId());
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Void, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r3) {
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {
            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                m.checkNotNullParameter(error, "it");
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpDelete(storeGuildScheduledEvents, StoreGuildScheduledEvents.access$findEventFromStore(storeGuildScheduledEvents, anonymousClass1.$storeEvent), StoreGuildScheduledEvents.access$getUserStore$p(StoreGuildScheduledEvents.this).getMeSnapshot().getId());
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* compiled from: StoreGuildScheduledEvents.kt */
        /* renamed from: com.discord.stores.StoreGuildScheduledEvents$toggleMeRsvpForEvent$1$4, reason: invalid class name */
        public static final class AnonymousClass4 extends o implements Function1<Unit, Unit> {
            public AnonymousClass4() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
                invoke2(unit);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Unit unit) {
                m.checkNotNullParameter(unit, "it");
                StoreGuildScheduledEvents.access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents.this).remove(Long.valueOf(AnonymousClass1.this.$eventId));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildScheduledEvent guildScheduledEvent, long j, GuildScheduledEvent guildScheduledEvent2) {
            super(0);
            this.$guildScheduledEvent = guildScheduledEvent;
            this.$eventId = j;
            this.$storeEvent = guildScheduledEvent2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (StoreGuildScheduledEvents.this.isMeRsvpedToEvent(this.$guildScheduledEvent.getGuildId(), this.$eventId)) {
                StoreGuildScheduledEvents storeGuildScheduledEvents = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpDelete(storeGuildScheduledEvents, this.$storeEvent, StoreGuildScheduledEvents.access$getUserStore$p(storeGuildScheduledEvents).getMeSnapshot().getId());
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildScheduledEventRsvp(this.$storeEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), StoreGuildScheduledEvents.this.getClass(), (Context) null, (Function1) null, new C02521(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
            } else {
                StoreGuildScheduledEvents storeGuildScheduledEvents2 = StoreGuildScheduledEvents.this;
                StoreGuildScheduledEvents.access$processRsvpCreate(storeGuildScheduledEvents2, this.$storeEvent, StoreGuildScheduledEvents.access$getUserStore$p(storeGuildScheduledEvents2).getMeSnapshot().getId());
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().createGuildScheduledEventRsvp(this.$guildScheduledEvent.getGuildId(), this.$storeEvent.getId()), false, 1, null), StoreGuildScheduledEvents.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass4(), 54, (Object) null);
            }
        }
    }

    public StoreGuildScheduledEvents(Dispatcher dispatcher, ObservationDeck observationDeck, StorePermissions storePermissions, StoreUser storeUser, StoreGuilds storeGuilds, Clock clock, StoreExperiments storeExperiments) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(storePermissions, "permissionsStore");
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(storeExperiments, "experimentsStore");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.permissionsStore = storePermissions;
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.clock = clock;
        this.experimentsStore = storeExperiments;
        this.guildScheduledEvents = new HashMap<>();
        this.guildScheduledEventsSnapshot = h0.emptyMap();
        this.lastAckedGuildScheduledEventIds = new HashMap<>();
        this.guildScheduledEventsFetchTimestamps = new HashMap<>();
        this.meGuildScheduledEventIds = new HashMap<>();
        this.meGuildScheduledEventIdsSnapshot = h0.emptyMap();
        this.meGuildScheduledEventsFetches = new HashSet<>();
        this.rsvpsAwaitingNetwork = new HashSet<>();
        this.rsvpsAwaitingSnapshot = new HashSet<>();
        this.guildScheduledEventUsers = new HashMap<>();
        this.guildScheduledEventUsersSnapshot = h0.emptyMap();
        this.guildScheduledEventUsersFetches = new HashMap<>();
    }

    public static final /* synthetic */ GuildScheduledEvent access$findEventFromStore(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent) {
        return storeGuildScheduledEvents.findEventFromStore(guildScheduledEvent);
    }

    public static final /* synthetic */ Clock access$getClock$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.clock;
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventUsers;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventUsersFetches$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventUsersFetches;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEvents$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEvents;
    }

    public static final /* synthetic */ HashMap access$getGuildScheduledEventsFetchTimestamps$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildScheduledEventsFetchTimestamps;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.guildsStore;
    }

    public static final /* synthetic */ HashMap access$getLastAckedGuildScheduledEventIds$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.lastAckedGuildScheduledEventIds;
    }

    public static final /* synthetic */ HashMap access$getMeGuildScheduledEventIds$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.meGuildScheduledEventIds;
    }

    public static final /* synthetic */ HashSet access$getMeGuildScheduledEventsFetches$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.meGuildScheduledEventsFetches;
    }

    public static final /* synthetic */ HashSet access$getRsvpsAwaitingNetwork$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.rsvpsAwaitingNetwork;
    }

    public static final /* synthetic */ StoreUser access$getUserStore$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.userStore;
    }

    public static final /* synthetic */ void access$handleFetchRsvpUsersFailure(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        storeGuildScheduledEvents.handleFetchRsvpUsersFailure();
    }

    public static final /* synthetic */ boolean access$isFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.isFetchingGuildScheduledEventUsers;
    }

    public static final /* synthetic */ boolean access$isGuildScheduledEventUsersError$p(StoreGuildScheduledEvents storeGuildScheduledEvents) {
        return storeGuildScheduledEvents.isGuildScheduledEventUsersError;
    }

    public static final /* synthetic */ void access$processRsvpCreate(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        storeGuildScheduledEvents.processRsvpCreate(guildScheduledEvent, j);
    }

    public static final /* synthetic */ void access$processRsvpDelete(StoreGuildScheduledEvents storeGuildScheduledEvents, GuildScheduledEvent guildScheduledEvent, long j) {
        storeGuildScheduledEvents.processRsvpDelete(guildScheduledEvent, j);
    }

    public static final /* synthetic */ void access$setFetchingGuildScheduledEventUsers$p(StoreGuildScheduledEvents storeGuildScheduledEvents, boolean z2) {
        storeGuildScheduledEvents.isFetchingGuildScheduledEventUsers = z2;
    }

    public static final /* synthetic */ void access$setGuildScheduledEventUsersError$p(StoreGuildScheduledEvents storeGuildScheduledEvents, boolean z2) {
        storeGuildScheduledEvents.isGuildScheduledEventUsersError = z2;
    }

    @StoreThread
    private final void addMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        if (!this.meGuildScheduledEventIds.containsKey(Long.valueOf(guildId))) {
            this.meGuildScheduledEventIds.put(Long.valueOf(guildId), n0.mutableSetOf(Long.valueOf(guildScheduledEventId)));
            return;
        }
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.add(Long.valueOf(guildScheduledEventId));
        }
    }

    @StoreThread
    private final void addUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        GuildMember member;
        if (userId == this.userStore.getMeSnapshot().getId() && !isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            addMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map == null) {
            map = new HashMap<>();
        }
        User user = this.userStore.getUsers(d0.t.m.listOf(Long.valueOf(userId)), false).get(Long.valueOf(userId));
        if (user != null && (member = this.guildsStore.getMember(guildId, userId)) != null) {
            map.put(Long.valueOf(userId), new GuildScheduledEventUser(user, member, guildScheduledEventId));
        }
        this.guildScheduledEventUsers.put(Long.valueOf(guildScheduledEventId), map);
    }

    private final GuildScheduledEvent findEventFromStore(GuildScheduledEvent event) {
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(event.getId(), Long.valueOf(event.getGuildId()));
        return guildScheduledEventFindEventFromStore != null ? guildScheduledEventFindEventFromStore : event;
    }

    public static /* synthetic */ GuildScheduledEvent findEventFromStore$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return storeGuildScheduledEvents.findEventFromStore(j, l);
    }

    public static /* synthetic */ List getGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.getGuildScheduledEvents(j, z2);
    }

    private final void handleFetchRsvpUsersFailure() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public static /* synthetic */ Observable observeGuildScheduledEvents$default(StoreGuildScheduledEvents storeGuildScheduledEvents, long j, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        return storeGuildScheduledEvents.observeGuildScheduledEvents(j, z2);
    }

    private final void processGuildScheduledEventCreateOrUpdate(GuildScheduledEvent guildScheduledEvent) {
        int i;
        int i2;
        GuildScheduledEvent guildScheduledEvent2;
        GuildScheduledEvent guildScheduledEventA = guildScheduledEvent;
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list != null) {
            Iterator<GuildScheduledEvent> it = list.iterator();
            int i3 = 0;
            while (it.hasNext()) {
                if (it.next().getId() == guildScheduledEvent.getId()) {
                    i = i3;
                    break;
                }
                i3++;
            }
            i = -1;
        } else {
            i = -1;
        }
        if (this.guildScheduledEvents.get(Long.valueOf(guildId)) == null) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), n.mutableListOf(guildScheduledEventA));
        } else if (i == -1) {
            List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list2 != null) {
                list2.add(guildScheduledEventA);
            }
        } else {
            List<GuildScheduledEvent> list3 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            Integer userCount = (list3 == null || (guildScheduledEvent2 = list3.get(i)) == null) ? null : guildScheduledEvent2.getUserCount();
            if (guildScheduledEvent.getUserCount() == null) {
                i2 = i;
                guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, userCount, null, null, 229375);
            } else {
                i2 = i;
            }
            List<GuildScheduledEvent> list4 = this.guildScheduledEvents.get(Long.valueOf(guildId));
            if (list4 != null) {
                list4.set(i2, guildScheduledEventA);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void processRsvpCreate(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            return;
        }
        this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
        addUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
        Integer userCount = guildScheduledEvent.getUserCount();
        GuildScheduledEvent guildScheduledEventA = GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf((userCount != null ? userCount.intValue() : 0) + 1), null, null, 229375);
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEventA.getGuildId()));
        if (list != null) {
            m.checkNotNullExpressionValue(list, "eventList");
            Iterator<GuildScheduledEvent> it = list.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == id2) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1) {
                list.set(i, guildScheduledEventA);
            } else {
                list.add(guildScheduledEventA);
            }
        } else {
            this.guildScheduledEvents.put(Long.valueOf(guildScheduledEvent.getGuildId()), n.mutableListOf(guildScheduledEventA));
        }
        markChanged();
    }

    @StoreThread
    private final void processRsvpDelete(GuildScheduledEvent guildScheduledEvent, long userId) {
        long id2 = guildScheduledEvent.getId();
        if (userId != this.userStore.getMeSnapshot().getId() || isMeRsvpedToEvent(guildScheduledEvent.getGuildId(), id2)) {
            this.rsvpsAwaitingSnapshot.add(Long.valueOf(id2));
            removeUserRsvpForEvent(userId, guildScheduledEvent.getGuildId(), id2);
            List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
            if (list != null) {
                m.checkNotNullExpressionValue(list, "eventList");
                Iterator<GuildScheduledEvent> it = list.iterator();
                int i = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i = -1;
                        break;
                    } else {
                        if (it.next().getId() == id2) {
                            break;
                        } else {
                            i++;
                        }
                    }
                }
                Integer numValueOf = Integer.valueOf(i);
                if (!(numValueOf.intValue() != -1)) {
                    numValueOf = null;
                }
                if (numValueOf != null) {
                    int iIntValue = numValueOf.intValue();
                    Integer userCount = guildScheduledEvent.getUserCount();
                    list.set(iIntValue, GuildScheduledEvent.a(guildScheduledEvent, 0L, 0L, null, null, null, null, null, null, null, null, null, null, null, null, null, Integer.valueOf(f.coerceAtLeast(0, userCount != null ? userCount.intValue() - 1 : 0)), null, null, 229375));
                }
            }
            markChanged();
        }
    }

    @StoreThread
    private final void removeMeRsvpForEvent(long guildId, long guildScheduledEventId) {
        Set<Long> set = this.meGuildScheduledEventIds.get(Long.valueOf(guildId));
        if (set != null) {
            set.remove(Long.valueOf(guildScheduledEventId));
        }
    }

    @StoreThread
    private final void removeUserRsvpForEvent(long userId, long guildId, long guildScheduledEventId) {
        if (userId == this.userStore.getMeSnapshot().getId() && isMeRsvpedToEvent(guildId, guildScheduledEventId)) {
            removeMeRsvpForEvent(guildId, guildScheduledEventId);
        }
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(guildScheduledEventId));
        if (map != null) {
            map.remove(Long.valueOf(userId));
        }
    }

    public final void ackGuildEvents(long guildId) {
        Object next;
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<T> it = list.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long id2 = ((GuildScheduledEvent) next).getId();
                do {
                    Object next2 = it.next();
                    long id3 = ((GuildScheduledEvent) next2).getId();
                    if (id2 < id3) {
                        next = next2;
                        id2 = id3;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
        if (guildScheduledEvent != null) {
            Long l = this.lastAckedGuildScheduledEventIds.get(Long.valueOf(guildId));
            if (l == null || l.longValue() < guildScheduledEvent.getId()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().postGuildFeatureAck(guildId, 1, guildScheduledEvent.getId(), new RestAPIParams.GuildFeatureAck(Boolean.FALSE, 0)), false, 1, null), (Context) null, "REST: guildFeatureAck", (Function1) null, new AnonymousClass1(guildScheduledEvent, guildId), (Function1) null, (Function0) null, (Function0) null, 117, (Object) null);
            }
        }
    }

    public final void addGuildScheduledEventFromInvite(GuildScheduledEvent guildScheduledEvent) {
        int i;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        long guildId = guildScheduledEvent.getGuildId();
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list != null) {
            Iterator<GuildScheduledEvent> it = list.iterator();
            i = 0;
            while (it.hasNext()) {
                if (it.next().getId() == guildScheduledEvent.getId()) {
                    break;
                } else {
                    i++;
                }
            }
            i = -1;
        } else {
            i = -1;
        }
        if (i == -1 && !this.guildScheduledEvents.containsKey(Long.valueOf(guildId))) {
            this.guildScheduledEvents.put(Long.valueOf(guildId), n.mutableListOf(guildScheduledEvent));
        } else if (i == -1) {
            ((List) h0.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).add(guildScheduledEvent);
        } else {
            ((List) h0.getValue(this.guildScheduledEvents, Long.valueOf(guildId))).set(i, guildScheduledEvent);
        }
        if (guildScheduledEvent.getUserRsvp() != null) {
            addMeRsvpForEvent(guildId, guildScheduledEvent.getId());
        }
        markChanged();
    }

    @StoreThread
    public final void addMeRsvpsForEvent(List<Pair<Long, Long>> events) {
        m.checkNotNullParameter(events, "events");
        Iterator<T> it = events.iterator();
        while (it.hasNext()) {
            Pair pair = (Pair) it.next();
            addMeRsvpForEvent(((Number) pair.getFirst()).longValue(), ((Number) pair.getSecond()).longValue());
        }
        markChanged();
    }

    public final void fetchGuildScheduledEventUserCounts(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if (list == null || list.isEmpty()) {
            return;
        }
        Long l = this.guildScheduledEventsFetchTimestamps.get(Long.valueOf(guildId));
        if (l == null || this.clock.currentTimeMillis() - l.longValue() >= FETCH_GUILD_EVENTS_THRESHOLD) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getGuildScheduledEvents(guildId, true), false, 1, null), StoreGuildScheduledEvents.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
        }
    }

    public final void fetchGuildScheduledEventUsers(long guildId, long eventId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, eventId));
    }

    public final void fetchMeGuildScheduledEvents(long guildId) {
        List<GuildScheduledEvent> list = this.guildScheduledEvents.get(Long.valueOf(guildId));
        if ((list == null || list.isEmpty()) || this.meGuildScheduledEventsFetches.contains(Long.valueOf(guildId))) {
            return;
        }
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getMeGuildScheduledEvents(guildId), false, 1, null), StoreGuildScheduledEvents.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(guildId), 62, (Object) null);
    }

    public final GuildScheduledEvent getActiveEventForChannel(Long guildId, Long channelId) {
        Object obj = null;
        if (guildId == null || channelId == null) {
            return null;
        }
        Iterator it = getGuildScheduledEvents$default(this, guildId.longValue(), false, 2, null).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) next;
            if (m.areEqual(guildScheduledEvent.getChannelId(), channelId) && guildScheduledEvent.getStatus() == GuildScheduledEventStatus.ACTIVE) {
                obj = next;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }

    public final Map<Long, List<GuildScheduledEvent>> getAllGuildScheduledEvents() {
        return this.guildScheduledEventsSnapshot;
    }

    public final Map<Long, GuildScheduledEventUser> getGuildScheduledEventUsers(long eventId) {
        HashMap<Long, GuildScheduledEventUser> map = this.guildScheduledEventUsers.get(Long.valueOf(eventId));
        return map != null ? map : h0.emptyMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<GuildScheduledEvent> getGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        Map<Long, Long> permissionsByChannel = this.permissionsStore.getPermissionsByChannel();
        List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId));
        if (list == null) {
            return n.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            GuildScheduledEvent guildScheduledEvent = (GuildScheduledEvent) obj;
            boolean zCan = false;
            if (filterInaccessible) {
                if (guildScheduledEvent.getStatus() != GuildScheduledEventStatus.COMPLETED) {
                    if (guildScheduledEvent.getChannelId() == null) {
                        zCan = true;
                    } else {
                        Long l = permissionsByChannel.get(guildScheduledEvent.getChannelId());
                        if (l != null) {
                            zCan = PermissionUtils.can(Permission.VIEW_CHANNEL, Long.valueOf(l.longValue()));
                        }
                    }
                }
            }
            if (zCan) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public final boolean getIsFetchingGuildScheduledEventUsers() {
        return this.isFetchingGuildScheduledEventUsers;
    }

    public final boolean getIsGuildScheduledEventUsersError() {
        return this.isGuildScheduledEventUsersError;
    }

    public final Set<Long> getMeGuildScheduledEventIds(long guildId) {
        Set<Long> set = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        return set != null ? set : n0.emptySet();
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        this.guildScheduledEventsFetchTimestamps.clear();
        this.meGuildScheduledEventsFetches.clear();
        this.guildScheduledEventUsersFetches.clear();
        this.guildScheduledEvents.clear();
        this.meGuildScheduledEventIds.clear();
        List<Guild> guilds = payload.getGuilds();
        m.checkNotNullExpressionValue(guilds, "payload.guilds");
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            List<GuildScheduledEvent> listO = ((Guild) it.next()).o();
            if (listO != null) {
                Iterator<T> it2 = listO.iterator();
                while (it2.hasNext()) {
                    processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it2.next());
                }
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        List<GuildScheduledEvent> listO = guild.o();
        if (listO != null) {
            Iterator<T> it = listO.iterator();
            while (it.hasNext()) {
                processGuildScheduledEventCreateOrUpdate((GuildScheduledEvent) it.next());
            }
        }
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        this.guildScheduledEvents.remove(Long.valueOf(guildId));
        this.guildScheduledEventsFetchTimestamps.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventIds.remove(Long.valueOf(guildId));
        this.meGuildScheduledEventsFetches.remove(Long.valueOf(guildId));
        this.guildScheduledEventUsersFetches.remove(Long.valueOf(guildId));
        markChanged();
    }

    @StoreThread
    public final void handleGuildScheduledEventCreate(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @StoreThread
    public final void handleGuildScheduledEventDelete(GuildScheduledEvent guildScheduledEvent) {
        List<GuildScheduledEvent> list;
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        List<GuildScheduledEvent> list2 = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()));
        if (list2 != null) {
            Iterator<GuildScheduledEvent> it = list2.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                } else {
                    if (it.next().getId() == guildScheduledEvent.getId()) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            if (i != -1 && (list = this.guildScheduledEvents.get(Long.valueOf(guildScheduledEvent.getGuildId()))) != null) {
                list.remove(i);
            }
            removeMeRsvpForEvent(guildScheduledEvent.getGuildId(), guildScheduledEvent.getId());
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildScheduledEventUpdate(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        processGuildScheduledEventCreateOrUpdate(guildScheduledEvent);
    }

    @StoreThread
    public final void handleGuildScheduledEventUserAdd(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        m.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpCreate(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    @StoreThread
    public final void handleGuildScheduledEventUserRemove(GuildScheduledEventUserUpdate guildScheduledEventUserUpdate) {
        m.checkNotNullParameter(guildScheduledEventUserUpdate, "guildScheduledEventUserUpdate");
        GuildScheduledEvent guildScheduledEventFindEventFromStore$default = findEventFromStore$default(this, guildScheduledEventUserUpdate.getGuildScheduledEventId(), null, 2, null);
        if (guildScheduledEventFindEventFromStore$default != null) {
            processRsvpDelete(guildScheduledEventFindEventFromStore$default, guildScheduledEventUserUpdate.getUserId());
        }
    }

    public final boolean isMeRsvpedToEvent(long guildId, long guildScheduledEventId) {
        Set<Long> setEmptySet = this.meGuildScheduledEventIdsSnapshot.get(Long.valueOf(guildId));
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        return setEmptySet.contains(Long.valueOf(guildScheduledEventId));
    }

    public final Observable<GuildScheduledEvent> observeGuildScheduledEvent(Long eventId, Long guildId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(eventId, guildId), 14, null);
    }

    public final Observable<List<GuildScheduledEvent>> observeGuildScheduledEvents(long guildId, boolean filterInaccessible) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId, filterInaccessible), 14, null);
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        this.guildScheduledEventsSnapshot = new HashMap(this.guildScheduledEvents);
        this.meGuildScheduledEventIdsSnapshot = new HashMap(this.meGuildScheduledEventIds);
        this.guildScheduledEventUsersSnapshot = new HashMap(this.guildScheduledEventUsers);
        this.rsvpsAwaitingSnapshot.clear();
    }

    public final void toggleMeRsvpForEvent(GuildScheduledEvent guildScheduledEvent) {
        m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        GuildScheduledEvent guildScheduledEventFindEventFromStore = findEventFromStore(guildScheduledEvent);
        long id2 = guildScheduledEventFindEventFromStore.getId();
        if (this.rsvpsAwaitingNetwork.contains(Long.valueOf(id2)) || this.rsvpsAwaitingSnapshot.contains(Long.valueOf(id2))) {
            return;
        }
        this.rsvpsAwaitingNetwork.add(Long.valueOf(id2));
        this.dispatcher.schedule(new AnonymousClass1(guildScheduledEvent, id2, guildScheduledEventFindEventFromStore));
    }

    public final GuildScheduledEvent findEventFromStore(long eventId, Long guildId) {
        GuildScheduledEvent guildScheduledEvent;
        Object next;
        Object obj = null;
        if (guildId != null) {
            List<GuildScheduledEvent> list = this.guildScheduledEventsSnapshot.get(Long.valueOf(guildId.longValue()));
            if (list != null) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    if (eventId == ((GuildScheduledEvent) next).getId()) {
                        break;
                    }
                }
                guildScheduledEvent = (GuildScheduledEvent) next;
            } else {
                guildScheduledEvent = null;
            }
            if (guildScheduledEvent != null) {
                return guildScheduledEvent;
            }
        }
        Iterator it2 = d0.t.o.flatten(this.guildScheduledEventsSnapshot.values()).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (eventId == ((GuildScheduledEvent) next2).getId()) {
                obj = next2;
                break;
            }
        }
        return (GuildScheduledEvent) obj;
    }
}
