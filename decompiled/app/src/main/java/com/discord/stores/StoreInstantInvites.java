package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionInviteResolve;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.h0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import j0.l.e.k;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreInstantInvites.kt */
/* loaded from: classes2.dex */
public final class StoreInstantInvites extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<String, ModelInvite>> invites;
    private Map<Long, ? extends Map<String, ? extends ModelInvite>> invitesSnapshot;
    private final Map<String, InviteState> knownInvites;
    private Map<String, ? extends InviteState> knownInvitesSnapshot;
    private final ObservationDeck observationDeck;
    private final RestAPI restAPI;

    /* compiled from: StoreInstantInvites.kt */
    public static abstract class InviteState {

        /* compiled from: StoreInstantInvites.kt */
        public static final class Invalid extends InviteState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        public static final class LoadFailed extends InviteState {
            public static final LoadFailed INSTANCE = new LoadFailed();

            private LoadFailed() {
                super(null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        public static final class Loading extends InviteState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        public static final /* data */ class Resolved extends InviteState {
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Resolved(ModelInvite modelInvite) {
                super(null);
                m.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
            }

            public static /* synthetic */ Resolved copy$default(Resolved resolved, ModelInvite modelInvite, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = resolved.invite;
                }
                return resolved.copy(modelInvite);
            }

            /* renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final Resolved copy(ModelInvite invite) {
                m.checkNotNullParameter(invite, "invite");
                return new Resolved(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && m.areEqual(this.invite, ((Resolved) other).invite);
                }
                return true;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                if (modelInvite != null) {
                    return modelInvite.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = a.U("Resolved(invite=");
                sbU.append(this.invite);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private InviteState() {
        }

        public /* synthetic */ InviteState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            Error.Type.values();
            int[] iArr = new int[18];
            $EnumSwitchMapping$0 = iArr;
            iArr[Error.Type.DISCORD_REQUEST_ERROR.ordinal()] = 1;
            iArr[Error.Type.NETWORK.ordinal()] = 2;
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$clearInvites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreInstantInvites.access$getInvites$p(StoreInstantInvites.this).get(Long.valueOf(this.$guildId));
            if (map != null) {
                map.clear();
            }
            StoreInstantInvites.this.markChanged();
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<List<? extends ModelInvite>, Unit> {

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02611 extends o implements Function0<Unit> {
            public final /* synthetic */ List $invites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C02611(List list) {
                super(0);
                this.$invites = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreInstantInvites.access$onLoadedInvites(StoreInstantInvites.this, this.$invites);
            }
        }

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelInvite> list) {
            invoke2(list);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelInvite> list) {
            m.checkNotNullParameter(list, "invites");
            StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new C02611(list));
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ String $inviteCode;
        public final /* synthetic */ String $inviteKey;
        public final /* synthetic */ Boolean $inviteResolved;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function0 $onError;

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C02621 extends o implements Function1<ModelInvite, TrackNetworkMetadataReceiver> {
            public C02621() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(ModelInvite modelInvite) {
                return invoke2(modelInvite);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadataReceiver invoke2(ModelInvite modelInvite) {
                User inviter;
                Channel channel;
                Channel channel2;
                Guild guild;
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                return new TrackNetworkActionInviteResolve(anonymousClass1.$inviteResolved, anonymousClass1.$inviteCode, Boolean.valueOf(StoreStream.INSTANCE.getAuthentication().isAuthed()), (modelInvite == null || (guild = modelInvite.guild) == null) ? null : Long.valueOf(guild.getId()), (modelInvite == null || (channel2 = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel2.getId()), (modelInvite == null || (channel = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel.getType()), (modelInvite == null || (inviter = modelInvite.getInviter()) == null) ? null : Long.valueOf(inviter.getId()), modelInvite != null ? Long.valueOf(modelInvite.getApproximateMemberCount()) : null, modelInvite != null ? Long.valueOf(modelInvite.getApproximatePresenceCount()) : null, modelInvite != null ? modelInvite.getInviteType() : null, null, modelInvite != null ? Boolean.valueOf(m.areEqual(modelInvite.code, String.valueOf(RestAPIAbortCodes.USER_BANNED))) : null, null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<ModelInvite, Unit> {

            /* compiled from: StoreInstantInvites.kt */
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2$1, reason: invalid class name and collision with other inner class name */
            public static final class C02631 extends o implements Function0<Unit> {
                public final /* synthetic */ ModelInvite $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C02631(ModelInvite modelInvite) {
                    super(0);
                    this.$it = modelInvite;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    m.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, new InviteState.Resolved(this.$it));
                    GuildScheduledEvent guildScheduledEvent = this.$it.getGuildScheduledEvent();
                    if (guildScheduledEvent != null) {
                        StoreGuildScheduledEvents guildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
                        m.checkNotNullExpressionValue(guildScheduledEvent, "event");
                        guildScheduledEvents.addGuildScheduledEventFromInvite(guildScheduledEvent);
                    }
                }
            }

            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
                invoke2(modelInvite);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                m.checkNotNullParameter(modelInvite, "it");
                StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new C02631(modelInvite));
                String str = AnonymousClass1.this.$location;
                if (str != null) {
                    AnalyticsTracker.INSTANCE.inviteResolved(modelInvite, str);
                }
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends o implements Function1<Error, Unit> {

            /* compiled from: StoreInstantInvites.kt */
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1, reason: invalid class name and collision with other inner class name */
            public static final class C02641 extends o implements Function0<Unit> {
                public C02641() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    m.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.Invalid.INSTANCE);
                }
            }

            /* compiled from: StoreInstantInvites.kt */
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$2, reason: invalid class name */
            public static final class AnonymousClass2 extends o implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = anonymousClass1.$inviteKey;
                    m.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.LoadFailed.INSTANCE);
                }
            }

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
                m.checkNotNullParameter(error, "error");
                Function0 function0 = AnonymousClass1.this.$onError;
                if (function0 != null) {
                }
                int iOrdinal = error.getType().ordinal();
                if (iOrdinal != 3) {
                    if (iOrdinal != 11) {
                        return;
                    }
                    StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new AnonymousClass2());
                    return;
                }
                error.setShowErrorToasts(false);
                StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new C02641());
                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                String str = anonymousClass1.$location;
                if (str != null) {
                    String str2 = anonymousClass1.$inviteCode;
                    Error.Response response = error.getResponse();
                    m.checkNotNullExpressionValue(response, "error.response");
                    String message = response.getMessage();
                    Error.Response response2 = error.getResponse();
                    m.checkNotNullExpressionValue(response2, "error.response");
                    AnalyticsTracker.inviteResolveFailed(str2, str, message, Integer.valueOf(response2.getCode()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, String str2, Long l, Boolean bool, String str3, Function0 function0) {
            super(0);
            this.$inviteKey = str;
            this.$inviteCode = str2;
            this.$eventId = l;
            this.$inviteResolved = bool;
            this.$location = str3;
            this.$onError = function0;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreInstantInvites.access$getKnownInvites$p(StoreInstantInvites.this).containsKey(this.$inviteKey) || (StoreInstantInvites.access$getKnownInvites$p(StoreInstantInvites.this).get(this.$inviteKey) instanceof InviteState.LoadFailed)) {
                AnalyticsTracker.inviteOpened(this.$inviteCode);
                StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                String str = this.$inviteKey;
                m.checkNotNullExpressionValue(str, "inviteKey");
                StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.Loading.INSTANCE);
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(StoreInstantInvites.access$getRestAPI$p(StoreInstantInvites.this).getInviteCode(this.$inviteCode, true, this.$eventId), new C02621()), false, 1, null), StoreInstantInvites.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
            }
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$observeInvite$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<String, ? extends InviteState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends InviteState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends InviteState> invoke2() {
            return StoreInstantInvites.access$getKnownInvites(StoreInstantInvites.this);
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$observeInvite$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Map<String, ? extends InviteState>, InviteState> {
        public final /* synthetic */ String $inviteKey;

        public AnonymousClass2(String str) {
            this.$inviteKey = str;
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ InviteState call(Map<String, ? extends InviteState> map) {
            return call2(map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final InviteState call2(Map<String, ? extends InviteState> map) {
            InviteState inviteState = map.get(this.$inviteKey);
            return inviteState != null ? inviteState : InviteState.Loading.INSTANCE;
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$observeKnownInvites$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Map<String, ? extends InviteState>> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Map<String, ? extends InviteState> invoke() {
            return invoke2();
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Map<String, ? extends InviteState> invoke2() {
            return StoreInstantInvites.access$getKnownInvites(StoreInstantInvites.this);
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$onInviteRemoved$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<Unit> {
        public final /* synthetic */ ModelInvite $invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelInvite modelInvite) {
            super(0);
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map;
            Guild guild = this.$invite.guild;
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            String str = this.$invite.code;
            if (lValueOf == null || (map = (Map) StoreInstantInvites.access$getInvites$p(StoreInstantInvites.this).get(lValueOf)) == null || ((ModelInvite) map.remove(str)) == null) {
                return;
            }
            StoreInstantInvites.this.markChanged();
        }
    }

    public /* synthetic */ StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? ObservationDeckProvider.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.dispatcher;
    }

    public static final /* synthetic */ Map access$getInvites$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.invites;
    }

    public static final /* synthetic */ Map access$getKnownInvites(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.getKnownInvites();
    }

    public static final /* synthetic */ Map access$getKnownInvites$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.knownInvites;
    }

    public static final /* synthetic */ RestAPI access$getRestAPI$p(StoreInstantInvites storeInstantInvites) {
        return storeInstantInvites.restAPI;
    }

    public static final /* synthetic */ void access$onLoadedInvites(StoreInstantInvites storeInstantInvites, List list) {
        storeInstantInvites.onLoadedInvites(list);
    }

    public static final /* synthetic */ void access$setChatInvites(StoreInstantInvites storeInstantInvites, String str, InviteState inviteState) {
        storeInstantInvites.setChatInvites(str, inviteState);
    }

    public static /* synthetic */ void fetchInviteIfNotLoaded$default(StoreInstantInvites storeInstantInvites, String str, Long l, String str2, Boolean bool, Function0 function0, int i, Object obj) {
        storeInstantInvites.fetchInviteIfNotLoaded(str, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : bool, (i & 16) != 0 ? null : function0);
    }

    private final Map<Long, Map<String, ModelInvite>> getInvites() {
        return this.invitesSnapshot;
    }

    private final Map<String, InviteState> getKnownInvites() {
        return this.knownInvitesSnapshot;
    }

    @StoreThread
    private final void onLoadedInvites(List<? extends ModelInvite> updatedInvites) {
        this.invites.clear();
        for (ModelInvite modelInvite : updatedInvites) {
            Guild guild = modelInvite.guild;
            Long lValueOf = guild != null ? Long.valueOf(guild.getId()) : null;
            if (lValueOf != null) {
                Map<String, ModelInvite> linkedHashMap = this.invites.get(lValueOf);
                if (linkedHashMap == null) {
                    linkedHashMap = new LinkedHashMap<>();
                }
                String str = modelInvite.code;
                m.checkNotNullExpressionValue(str, "invite.code");
                linkedHashMap.put(str, modelInvite);
                this.invites.put(lValueOf, linkedHashMap);
            }
        }
        markChanged();
    }

    @StoreThread
    private final void setChatInvites(String inviteKey, InviteState inviteState) {
        this.knownInvites.put(inviteKey, inviteState);
        markChanged();
    }

    public final void clearInvites(long guildId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId));
    }

    public final void fetchGuildInvites(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildInvites(guildId), false, 1, null), StoreInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    public final void fetchInviteIfNotLoaded(String inviteCode, Long eventId, String location, Boolean inviteResolved, Function0<Unit> onError) {
        m.checkNotNullParameter(inviteCode, "inviteCode");
        this.dispatcher.schedule(new AnonymousClass1(ModelInvite.getInviteStoreKey(inviteCode, eventId), inviteCode, eventId, inviteResolved, location, onError));
    }

    public final Observable<InviteState> observeInvite(String inviteKey) {
        if (inviteKey == null) {
            k kVar = new k(InviteState.LoadFailed.INSTANCE);
            m.checkNotNullExpressionValue(kVar, "Observable.just(InviteState.LoadFailed)");
            return kVar;
        }
        Observable<InviteState> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).G(new AnonymousClass2(inviteKey)).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    public final Observable<Map<String, InviteState>> observeKnownInvites() {
        Observable<Map<String, InviteState>> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableR;
    }

    public final void onInviteRemoved(ModelInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        this.dispatcher.schedule(new AnonymousClass1(invite));
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Map<String, ModelInvite>> entry : this.invites.entrySet()) {
            linkedHashMap.put(Long.valueOf(entry.getKey().longValue()), new HashMap(entry.getValue()));
        }
        this.invitesSnapshot = linkedHashMap;
        this.knownInvitesSnapshot = new HashMap(this.knownInvites);
    }

    public final Map<String, ModelInvite> getInvites(long guildId) {
        Map<String, ModelInvite> map = getInvites().get(Long.valueOf(guildId));
        return map != null ? map : h0.emptyMap();
    }

    public StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.invites = new LinkedHashMap();
        this.invitesSnapshot = h0.emptyMap();
        this.knownInvites = new LinkedHashMap();
        this.knownInvitesSnapshot = h0.emptyMap();
    }
}
