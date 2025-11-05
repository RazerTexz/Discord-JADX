package com.discord.stores;

import android.content.Context;
import android.content.SharedPreferences;
import com.discord.analytics.generated.events.network_action.TrackNetworkActionUserSurveyFetch;
import com.discord.analytics.generated.traits.TrackNetworkMetadataReceiver;
import com.discord.api.guild.GuildFeature;
import com.discord.api.user.SurveyGuildRequirements;
import com.discord.api.user.UserSurvey;
import com.discord.api.user.UserSurveyFetchResponse;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.utilities.RestCallStateKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.Clock;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: StoreUserSurvey.kt */
/* loaded from: classes2.dex */
public final class StoreUserSurvey extends StoreV2 {
    private final Clock clock;
    private final Dispatcher dispatcher;
    private final ObservationDeck observationDeck;
    private int refetchIntervalMs;
    private final RestAPI restApi;
    private final SharedPreferences sharedPreferences;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final StoreUser storeUser;
    private UserSurvey userSurvey;

    /* compiled from: StoreUserSurvey.kt */
    /* renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<UserSurveyFetchResponse, TrackNetworkMetadataReceiver> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ TrackNetworkMetadataReceiver invoke(UserSurveyFetchResponse userSurveyFetchResponse) {
            return invoke2(userSurveyFetchResponse);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final TrackNetworkMetadataReceiver invoke2(UserSurveyFetchResponse userSurveyFetchResponse) {
            UserSurvey survey;
            return new TrackNetworkActionUserSurveyFetch((userSurveyFetchResponse == null || (survey = userSurveyFetchResponse.getSurvey()) == null) ? null : survey.getKey());
        }
    }

    /* compiled from: StoreUserSurvey.kt */
    /* renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<UserSurveyFetchResponse, Unit> {

        /* compiled from: StoreUserSurvey.kt */
        /* renamed from: com.discord.stores.StoreUserSurvey$fetchUserSurvey$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
            public final /* synthetic */ UserSurveyFetchResponse $res;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(UserSurveyFetchResponse userSurveyFetchResponse) {
                super(0);
                this.$res = userSurveyFetchResponse;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreUserSurvey.access$handleUserSurveyFetchSuccess(StoreUserSurvey.this, this.$res);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(UserSurveyFetchResponse userSurveyFetchResponse) {
            invoke2(userSurveyFetchResponse);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(UserSurveyFetchResponse userSurveyFetchResponse) {
            m.checkNotNullParameter(userSurveyFetchResponse, "res");
            StoreUserSurvey.access$getDispatcher$p(StoreUserSurvey.this).schedule(new AnonymousClass1(userSurveyFetchResponse));
        }
    }

    /* compiled from: StoreUserSurvey.kt */
    /* renamed from: com.discord.stores.StoreUserSurvey$observeUserSurvey$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function0<UserSurvey> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ UserSurvey invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final UserSurvey invoke() {
            return StoreUserSurvey.access$getUserSurvey(StoreUserSurvey.this);
        }
    }

    public /* synthetic */ StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, storeUser, storeGuilds, storePermissions, observationDeck, (i & 32) != 0 ? RestAPI.INSTANCE.getApi() : restAPI, clock, sharedPreferences);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreUserSurvey storeUserSurvey) {
        return storeUserSurvey.dispatcher;
    }

    public static final /* synthetic */ UserSurvey access$getUserSurvey(StoreUserSurvey storeUserSurvey) {
        return storeUserSurvey.getUserSurvey();
    }

    public static final /* synthetic */ void access$handleUserSurveyFetchSuccess(StoreUserSurvey storeUserSurvey, UserSurveyFetchResponse userSurveyFetchResponse) {
        storeUserSurvey.handleUserSurveyFetchSuccess(userSurveyFetchResponse);
    }

    @StoreThread
    private final void fetchUserSurvey() {
        setLastFetched();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestCallStateKt.logNetworkAction(this.restApi.getUserSurvey(), AnonymousClass1.INSTANCE), false, 1, null), StoreUserSurvey.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }

    private final UserSurvey getUserSurvey() {
        return this.userSurvey;
    }

    @StoreThread
    private final void handleUserSurveyFetchSuccess(UserSurveyFetchResponse res) {
        UserSurvey survey;
        if (res == null || (survey = res.getSurvey()) == null || !meetsGuildRequirements(survey)) {
            return;
        }
        this.userSurvey = survey;
        markChanged();
    }

    private final boolean meetsGuildRequirements(UserSurvey survey) {
        boolean z2;
        List<String> listC = survey.c();
        if (listC.isEmpty()) {
            return true;
        }
        Iterator<String> it = listC.iterator();
        while (it.hasNext()) {
            if (!StoreUserSurveyKt.getIMPLEMENTED_GUILD_REQUIREMENTS().contains(it.next())) {
                return false;
            }
        }
        MeUser meSnapshot = this.storeUser.getMeSnapshot();
        for (Map.Entry<Long, Guild> entry : this.storeGuilds.getGuilds().entrySet()) {
            long jLongValue = entry.getKey().longValue();
            Guild value = entry.getValue();
            if (!listC.contains(SurveyGuildRequirements.IS_COMMUNITY.getValue()) || value.getFeatures().contains(GuildFeature.COMMUNITY)) {
                if (!listC.contains(SurveyGuildRequirements.IS_HUB.getValue()) || value.getFeatures().contains(GuildFeature.HUB)) {
                    if (listC.contains(SurveyGuildRequirements.GUILD_SIZE.getValue())) {
                        Integer num = survey.d().get(0);
                        Integer num2 = survey.d().get(1);
                        int memberCount = value.getMemberCount();
                        if (num == null || memberCount >= num.intValue()) {
                            if (num2 == null || memberCount <= num2.intValue()) {
                            }
                        }
                    }
                    Map<Long, Long> guildPermissions = this.storePermissions.getGuildPermissions();
                    if (listC.contains(SurveyGuildRequirements.GUILD_PERMISSIONS.getValue())) {
                        List<Long> listB = survey.b();
                        if (listB.isEmpty()) {
                            continue;
                        } else {
                            Iterator<Long> it2 = listB.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z2 = false;
                                    break;
                                }
                                if (PermissionUtils.can(it2.next().longValue(), guildPermissions.get(Long.valueOf(jLongValue)))) {
                                    z2 = true;
                                    break;
                                }
                            }
                            if (!z2) {
                                continue;
                            }
                        }
                    }
                    boolean zIsOwner = value.isOwner(meSnapshot.getId());
                    boolean zCan = PermissionUtils.can(8L, guildPermissions.get(Long.valueOf(jLongValue)));
                    if (!listC.contains(SurveyGuildRequirements.IS_OWNER.getValue()) || zIsOwner) {
                        if (!listC.contains(SurveyGuildRequirements.IS_ADMIN.getValue()) || zCan) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private final void setLastFetched() {
        this.sharedPreferences.edit().putLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", this.clock.currentTimeMillis()).apply();
    }

    @StoreThread
    public final void handleConnectionOpen() {
        if (this.clock.currentTimeMillis() - this.sharedPreferences.getLong("CACHE_KEY_USER_SURVEY_LAST_FETCHED", 0L) > this.refetchIntervalMs) {
            fetchUserSurvey();
        }
    }

    public final Observable<UserSurvey> observeUserSurvey() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public StoreUserSurvey(Dispatcher dispatcher, StoreUser storeUser, StoreGuilds storeGuilds, StorePermissions storePermissions, ObservationDeck observationDeck, RestAPI restAPI, Clock clock, SharedPreferences sharedPreferences) {
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(clock, "clock");
        m.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        this.dispatcher = dispatcher;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        this.observationDeck = observationDeck;
        this.restApi = restAPI;
        this.clock = clock;
        this.sharedPreferences = sharedPreferences;
        this.refetchIntervalMs = 86400000;
    }
}
