package com.discord.stores;

import android.content.Context;
import com.discord.api.guildjoinrequest.ApplicationStatus;
import com.discord.api.guildjoinrequest.GuildJoinRequest;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: StoreGuildJoinRequest.kt */
/* loaded from: classes2.dex */
public final class StoreGuildJoinRequest extends StoreV2 {
    private final Dispatcher dispatcher;
    private final HashMap<Long, GuildJoinRequest> guildJoinRequests;
    private Map<Long, GuildJoinRequest> guildJoinRequestsSnapshot;
    private final StoreGuilds guildsStore;
    private final ObservationDeck observationDeck;
    private HashMap<Long, Guild> pendingGuilds;
    private Map<Long, Guild> pendingGuildsSnapshot;
    private final StoreUser userStore;

    /* compiled from: StoreGuildJoinRequest.kt */
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {

        /* compiled from: StoreGuildJoinRequest.kt */
        /* renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02391 extends o implements Function1<List<? extends com.discord.api.guild.Guild>, Unit> {

            /* compiled from: StoreGuildJoinRequest.kt */
            /* renamed from: com.discord.stores.StoreGuildJoinRequest$fetchPendingGuilds$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C02401 extends o implements Function0<Unit> {
                public final /* synthetic */ List $results;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02401(List list) {
                    super(0);
                    this.$results = list;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    for (com.discord.api.guild.Guild guild : this.$results) {
                        StoreGuildJoinRequest.access$getPendingGuilds$p(StoreGuildJoinRequest.this).put(Long.valueOf(guild.getId()), new Guild(guild));
                    }
                    StoreGuildJoinRequest.this.markChanged();
                }
            }

            public C02391() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.api.guild.Guild> list) {
                invoke2((List<com.discord.api.guild.Guild>) list);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<com.discord.api.guild.Guild> list) {
                m.checkNotNullParameter(list, "results");
                StoreGuildJoinRequest.access$getDispatcher$p(StoreGuildJoinRequest.this).schedule(new C02401(list));
            }
        }

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
            Map<Long, Guild> guilds = StoreGuildJoinRequest.access$getGuildsStore$p(StoreGuildJoinRequest.this).getGuilds();
            Set setKeySet = StoreGuildJoinRequest.access$getGuildJoinRequests$p(StoreGuildJoinRequest.this).keySet();
            m.checkNotNullExpressionValue(setKeySet, "guildJoinRequests.keys");
            ArrayList arrayList = new ArrayList();
            Iterator it = setKeySet.iterator();
            while (true) {
                boolean z2 = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Long l = (Long) next;
                m.checkNotNullExpressionValue(l, "it");
                if (!guilds.containsKey(l) && !StoreGuildJoinRequest.access$getPendingGuilds$p(StoreGuildJoinRequest.this).containsKey(l)) {
                    z2 = true;
                }
                if (z2) {
                    arrayList.add(next);
                }
            }
            if (!arrayList.isEmpty()) {
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().getUserJoinRequestGuilds(), false, 1, null), StoreGuildJoinRequest.this.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C02391(), 62, (Object) null);
            }
        }
    }

    /* compiled from: StoreGuildJoinRequest.kt */
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequest$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<GuildJoinRequest> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ GuildJoinRequest invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final GuildJoinRequest invoke() {
            return (GuildJoinRequest) StoreGuildJoinRequest.access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest.this).get(Long.valueOf(this.$guildId));
        }
    }

    /* compiled from: StoreGuildJoinRequest.kt */
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$observeGuildJoinRequests$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends GuildJoinRequest>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildJoinRequest> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends GuildJoinRequest> invoke2() {
            return StoreGuildJoinRequest.access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest.this);
        }
    }

    /* compiled from: StoreGuildJoinRequest.kt */
    /* renamed from: com.discord.stores.StoreGuildJoinRequest$observePendingGuilds$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<Long, ? extends Guild>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<Long, ? extends Guild> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<Long, ? extends Guild> invoke2() {
            return StoreGuildJoinRequest.access$getPendingGuildsSnapshot$p(StoreGuildJoinRequest.this);
        }
    }

    public StoreGuildJoinRequest(StoreUser storeUser, StoreGuilds storeGuilds, Dispatcher dispatcher, ObservationDeck observationDeck) {
        m.checkNotNullParameter(storeUser, "userStore");
        m.checkNotNullParameter(storeGuilds, "guildsStore");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.guildsStore = storeGuilds;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.pendingGuilds = new HashMap<>();
        this.pendingGuildsSnapshot = h0.emptyMap();
        this.guildJoinRequests = new HashMap<>();
        this.guildJoinRequestsSnapshot = h0.emptyMap();
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.dispatcher;
    }

    public static final /* synthetic */ HashMap access$getGuildJoinRequests$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildJoinRequests;
    }

    public static final /* synthetic */ Map access$getGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildJoinRequestsSnapshot;
    }

    public static final /* synthetic */ StoreGuilds access$getGuildsStore$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.guildsStore;
    }

    public static final /* synthetic */ HashMap access$getPendingGuilds$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.pendingGuilds;
    }

    public static final /* synthetic */ Map access$getPendingGuildsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest) {
        return storeGuildJoinRequest.pendingGuildsSnapshot;
    }

    public static final /* synthetic */ void access$setGuildJoinRequestsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest, Map map) {
        storeGuildJoinRequest.guildJoinRequestsSnapshot = map;
    }

    public static final /* synthetic */ void access$setPendingGuilds$p(StoreGuildJoinRequest storeGuildJoinRequest, HashMap map) {
        storeGuildJoinRequest.pendingGuilds = map;
    }

    public static final /* synthetic */ void access$setPendingGuildsSnapshot$p(StoreGuildJoinRequest storeGuildJoinRequest, Map map) {
        storeGuildJoinRequest.pendingGuildsSnapshot = map;
    }

    private final void handleGuildJoinRequestApproved(long guildId) {
        Guild guild = this.guildsStore.getGuild(guildId);
        if ((guild != null ? guild.getName() : null) != null) {
            MemberVerificationSuccessDialog.INSTANCE.enqueue(guildId);
        }
    }

    public final void fetchPendingGuilds() {
        this.dispatcher.schedule(new AnonymousClass1());
    }

    public final GuildJoinRequest getGuildJoinRequest(long guildId) {
        return this.guildJoinRequestsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<GuildJoinRequest> guildJoinRequests = payload.getGuildJoinRequests();
        if (guildJoinRequests != null) {
            for (GuildJoinRequest guildJoinRequest : guildJoinRequests) {
                HashMap<Long, GuildJoinRequest> map = this.guildJoinRequests;
                Long lValueOf = Long.valueOf(guildJoinRequest.getGuildId());
                m.checkNotNullExpressionValue(guildJoinRequest, "joinRequest");
                map.put(lValueOf, guildJoinRequest);
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildJoinRequestCreateOrUpdate(long guildId, GuildJoinRequest request) {
        m.checkNotNullParameter(request, "request");
        if (request.getUserId() == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.put(Long.valueOf(guildId), request);
            if (request.getApplicationStatus() == ApplicationStatus.APPROVED && request.getLastSeen() == null) {
                handleGuildJoinRequestApproved(guildId);
            }
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildJoinRequestDelete(long userId, long guildId) {
        if (userId == this.userStore.getMeSnapshot().getId()) {
            this.guildJoinRequests.remove(Long.valueOf(guildId));
            this.pendingGuilds.remove(Long.valueOf(guildId));
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        if (this.guildJoinRequests.remove(Long.valueOf(guildId)) != null) {
            markChanged();
        }
    }

    public final Observable<GuildJoinRequest> observeGuildJoinRequest(long guildId) {
        Observable<GuildJoinRequest> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, GuildJoinRequest>> observeGuildJoinRequests() {
        Observable<Map<Long, GuildJoinRequest>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<Long, Guild>> observePendingGuilds() {
        Observable<Map<Long, Guild>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.guildJoinRequestsSnapshot = new HashMap(this.guildJoinRequests);
        this.pendingGuildsSnapshot = new HashMap(this.pendingGuilds);
    }
}
