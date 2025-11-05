package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.Consents;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import j0.p.a;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Func3;

/* compiled from: WidgetSettingsPrivacy.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3<T, R> implements b<WidgetSettingsPrivacy.LocalState, Observable<? extends WidgetSettingsPrivacy.Model>> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3();

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<MeUser, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            return Boolean.valueOf(meUser.isVerified());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<MeUser, Observable<? extends RestAPI.HarvestState>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$2$1, reason: invalid class name */
        public static final class AnonymousClass1<T, R> implements b<Throwable, RestAPI.HarvestState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // j0.k.b
            public /* bridge */ /* synthetic */ RestAPI.HarvestState call(Throwable th) {
                return call2(th);
            }

            /* renamed from: call, reason: avoid collision after fix types in other method */
            public final RestAPI.HarvestState call2(Throwable th) {
                return new RestAPI.HarvestState.NeverRequested();
            }
        }

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Observable<? extends RestAPI.HarvestState> call(MeUser meUser) {
            return call2(meUser);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends RestAPI.HarvestState> call2(MeUser meUser) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Observable<RestAPI.HarvestState> observableJ = RestAPI.INSTANCE.getApi().getHarvestStatusGuarded().J(a.c());
            m.checkNotNullExpressionValue(observableJ, "RestAPI\n                …bserveOn(Schedulers.io())");
            return RetryWithDelay.restRetry$default(retryWithDelay, observableJ, 0L, null, null, 7, null).q(500L, TimeUnit.MILLISECONDS).M(AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$3, reason: invalid class name */
    public static final class AnonymousClass3<T1, T2, T3, R> implements Func3<WidgetSettingsPrivacy.LocalState, Consents, RestAPI.HarvestState, WidgetSettingsPrivacy.Model> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetSettingsPrivacy.Model call(WidgetSettingsPrivacy.LocalState localState, Consents consents, RestAPI.HarvestState harvestState) {
            return call2(localState, consents, harvestState);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetSettingsPrivacy.Model call2(WidgetSettingsPrivacy.LocalState localState, Consents consents, RestAPI.HarvestState harvestState) {
            ConnectedAccount contactSyncConnection = localState.getContactSyncConnection();
            Experiment contactSyncExperiment = localState.getContactSyncExperiment();
            boolean z2 = contactSyncExperiment != null && contactSyncExperiment.getBucket() == 1;
            MeUser me2 = localState.getMe();
            int explicitContentFilter = localState.getExplicitContentFilter();
            boolean defaultRestrictedGuilds = localState.getDefaultRestrictedGuilds();
            ModelUserSettings.FriendSourceFlags friendSourceFlags = localState.getFriendSourceFlags();
            int userDiscoveryFlags = localState.getUserDiscoveryFlags();
            m.checkNotNullExpressionValue(consents, "consent");
            return new WidgetSettingsPrivacy.Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, z2, consents, harvestState);
        }
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsPrivacy.Model> call2(WidgetSettingsPrivacy.LocalState localState) {
        k kVar = new k(localState);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.i(kVar, companion.getUserSettings().observeConsents(), Observable.I(new k(null), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).y(AnonymousClass1.INSTANCE).A(AnonymousClass2.INSTANCE)), AnonymousClass3.INSTANCE);
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsPrivacy.Model> call(WidgetSettingsPrivacy.LocalState localState) {
        return call2(localState);
    }
}
