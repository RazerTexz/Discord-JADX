package com.discord.stores;

import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionInviteResolve;
import com.discord.analytics.generated.traits.TrackNetworkMetadata2;
import com.discord.api.channel.Channel;
import com.discord.api.guild.Guild;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIAbortCodes;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.stores.utilities.RestCallState5;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Maps6;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;

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
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
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
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Resolved(invite);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Resolved) && Intrinsics3.areEqual(this.invite, ((Resolved) other).invite);
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
                StringBuilder sbM833U = outline.m833U("Resolved(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(")");
                return sbM833U.toString();
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
    /* renamed from: com.discord.stores.StoreInstantInvites$clearInvites$1 */
    public static final class C61261 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61261(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
    /* renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1 */
    public static final class C61271 extends Lambda implements Function1<List<? extends ModelInvite>, Unit> {

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchGuildInvites$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $invites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$invites = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreInstantInvites.access$onLoadedInvites(StoreInstantInvites.this, this.$invites);
            }
        }

        public C61271() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelInvite> list) {
            invoke2(list);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<? extends ModelInvite> list) {
            Intrinsics3.checkNotNullParameter(list, "invites");
            StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new AnonymousClass1(list));
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1 */
    public static final class C61281 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Long $eventId;
        public final /* synthetic */ String $inviteCode;
        public final /* synthetic */ String $inviteKey;
        public final /* synthetic */ Boolean $inviteResolved;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function0 $onError;

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<ModelInvite, TrackNetworkMetadata2> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ TrackNetworkMetadata2 invoke(ModelInvite modelInvite) {
                return invoke2(modelInvite);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final TrackNetworkMetadata2 invoke2(ModelInvite modelInvite) {
                User inviter;
                Channel channel;
                Channel channel2;
                Guild guild;
                C61281 c61281 = C61281.this;
                return new TrackNetworkActionInviteResolve(c61281.$inviteResolved, c61281.$inviteCode, Boolean.valueOf(StoreStream.INSTANCE.getAuthentication().isAuthed()), (modelInvite == null || (guild = modelInvite.guild) == null) ? null : Long.valueOf(guild.getId()), (modelInvite == null || (channel2 = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel2.getId()), (modelInvite == null || (channel = modelInvite.getChannel()) == null) ? null : Long.valueOf(channel.getType()), (modelInvite == null || (inviter = modelInvite.getInviter()) == null) ? null : Long.valueOf(inviter.getId()), modelInvite != null ? Long.valueOf(modelInvite.getApproximateMemberCount()) : null, modelInvite != null ? Long.valueOf(modelInvite.getApproximatePresenceCount()) : null, modelInvite != null ? modelInvite.getInviteType() : null, null, modelInvite != null ? Boolean.valueOf(Intrinsics3.areEqual(modelInvite.code, String.valueOf(RestAPIAbortCodes.USER_BANNED))) : null, null);
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<ModelInvite, Unit> {

            /* compiled from: StoreInstantInvites.kt */
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$2$1, reason: invalid class name */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public final /* synthetic */ ModelInvite $it;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public AnonymousClass1(ModelInvite modelInvite) {
                    super(0);
                    this.$it = modelInvite;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C61281 c61281 = C61281.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = c61281.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, new InviteState.Resolved(this.$it));
                    GuildScheduledEvent guildScheduledEvent = this.$it.getGuildScheduledEvent();
                    if (guildScheduledEvent != null) {
                        StoreGuildScheduledEvents guildScheduledEvents = StoreStream.INSTANCE.getGuildScheduledEvents();
                        Intrinsics3.checkNotNullExpressionValue(guildScheduledEvent, "event");
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
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelInvite modelInvite) {
                Intrinsics3.checkNotNullParameter(modelInvite, "it");
                StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new AnonymousClass1(modelInvite));
                String str = C61281.this.$location;
                if (str != null) {
                    AnalyticsTracker.INSTANCE.inviteResolved(modelInvite, str);
                }
            }
        }

        /* compiled from: StoreInstantInvites.kt */
        /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3, reason: invalid class name */
        public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

            /* compiled from: StoreInstantInvites.kt */
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$1, reason: invalid class name */
            public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
                public AnonymousClass1() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C61281 c61281 = C61281.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = c61281.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.Invalid.INSTANCE);
                }
            }

            /* compiled from: StoreInstantInvites.kt */
            /* renamed from: com.discord.stores.StoreInstantInvites$fetchInviteIfNotLoaded$1$3$2, reason: invalid class name */
            public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                public AnonymousClass2() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    C61281 c61281 = C61281.this;
                    StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                    String str = c61281.$inviteKey;
                    Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                    StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.LoadFailed.INSTANCE);
                }
            }

            public AnonymousClass3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "error");
                Function0 function0 = C61281.this.$onError;
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
                StoreInstantInvites.access$getDispatcher$p(StoreInstantInvites.this).schedule(new AnonymousClass1());
                C61281 c61281 = C61281.this;
                String str = c61281.$location;
                if (str != null) {
                    String str2 = c61281.$inviteCode;
                    Error.Response response = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                    String message = response.getMessage();
                    Error.Response response2 = error.getResponse();
                    Intrinsics3.checkNotNullExpressionValue(response2, "error.response");
                    AnalyticsTracker.inviteResolveFailed(str2, str, message, Integer.valueOf(response2.getCode()));
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61281(String str, String str2, Long l, Boolean bool, String str3, Function0 function0) {
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
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (!StoreInstantInvites.access$getKnownInvites$p(StoreInstantInvites.this).containsKey(this.$inviteKey) || (StoreInstantInvites.access$getKnownInvites$p(StoreInstantInvites.this).get(this.$inviteKey) instanceof InviteState.LoadFailed)) {
                AnalyticsTracker.inviteOpened(this.$inviteCode);
                StoreInstantInvites storeInstantInvites = StoreInstantInvites.this;
                String str = this.$inviteKey;
                Intrinsics3.checkNotNullExpressionValue(str, "inviteKey");
                StoreInstantInvites.access$setChatInvites(storeInstantInvites, str, InviteState.Loading.INSTANCE);
                ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallState5.logNetworkAction(StoreInstantInvites.access$getRestAPI$p(StoreInstantInvites.this).getInviteCode(this.$inviteCode, true, this.$eventId), new AnonymousClass1()), false, 1, null), StoreInstantInvites.this.getClass(), (Context) null, (Function1) null, new AnonymousClass3(), (Function0) null, (Function0) null, new AnonymousClass2(), 54, (Object) null);
            }
        }
    }

    /* compiled from: StoreInstantInvites.kt */
    /* renamed from: com.discord.stores.StoreInstantInvites$observeInvite$1 */
    public static final class C61291 extends Lambda implements Function0<Map<String, ? extends InviteState>> {
        public C61291() {
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
    /* renamed from: com.discord.stores.StoreInstantInvites$observeInvite$2 */
    public static final class C61302<T, R> implements Func1<Map<String, ? extends InviteState>, InviteState> {
        public final /* synthetic */ String $inviteKey;

        public C61302(String str) {
            this.$inviteKey = str;
        }

        @Override // p637j0.p641k.Func1
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
    /* renamed from: com.discord.stores.StoreInstantInvites$observeKnownInvites$1 */
    public static final class C61311 extends Lambda implements Function0<Map<String, ? extends InviteState>> {
        public C61311() {
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
    /* renamed from: com.discord.stores.StoreInstantInvites$onInviteRemoved$1 */
    public static final class C61321 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelInvite $invite;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61321(ModelInvite modelInvite) {
            super(0);
            this.$invite = modelInvite;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
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
        this(dispatcher, (i & 2) != 0 ? ObservationDeck4.get() : observationDeck, (i & 4) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
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

    @Store3
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
                Intrinsics3.checkNotNullExpressionValue(str, "invite.code");
                linkedHashMap.put(str, modelInvite);
                this.invites.put(lValueOf, linkedHashMap);
            }
        }
        markChanged();
    }

    @Store3
    private final void setChatInvites(String inviteKey, InviteState inviteState) {
        this.knownInvites.put(inviteKey, inviteState);
        markChanged();
    }

    public final void clearInvites(long guildId) {
        this.dispatcher.schedule(new C61261(guildId));
    }

    public final void fetchGuildInvites(long guildId) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getGuildInvites(guildId), false, 1, null), StoreInstantInvites.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C61271(), 62, (Object) null);
    }

    public final void fetchInviteIfNotLoaded(String inviteCode, Long eventId, String location, Boolean inviteResolved, Function0<Unit> onError) {
        Intrinsics3.checkNotNullParameter(inviteCode, "inviteCode");
        this.dispatcher.schedule(new C61281(ModelInvite.getInviteStoreKey(inviteCode, eventId), inviteCode, eventId, inviteResolved, location, onError));
    }

    public final Observable<InviteState> observeInvite(String inviteKey) {
        if (inviteKey == null) {
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(InviteState.LoadFailed.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(InviteState.LoadFailed)");
            return scalarSynchronousObservable;
        }
        Observable<InviteState> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61291(), 14, null).m11083G(new C61302(inviteKey)).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<String, InviteState>> observeKnownInvites() {
        Observable<Map<String, InviteState>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C61311(), 14, null).m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR… }.distinctUntilChanged()");
        return observableM11112r;
    }

    public final void onInviteRemoved(ModelInvite invite) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        this.dispatcher.schedule(new C61321(invite));
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
        return map != null ? map : Maps6.emptyMap();
    }

    public StoreInstantInvites(Dispatcher dispatcher, ObservationDeck observationDeck, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.restAPI = restAPI;
        this.invites = new LinkedHashMap();
        this.invitesSnapshot = Maps6.emptyMap();
        this.knownInvites = new LinkedHashMap();
        this.knownInvitesSnapshot = Maps6.emptyMap();
    }
}
