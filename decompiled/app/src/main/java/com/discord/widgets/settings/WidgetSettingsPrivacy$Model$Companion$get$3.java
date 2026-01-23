package com.discord.widgets.settings;

import androidx.core.app.NotificationCompat;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import java.util.concurrent.TimeUnit;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p637j0.p653p.Schedulers2;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy$Model$Companion$get$3<T, R> implements Func1<WidgetSettingsPrivacy.LocalState, Observable<? extends WidgetSettingsPrivacy.Model>> {
    public static final WidgetSettingsPrivacy$Model$Companion$get$3 INSTANCE = new WidgetSettingsPrivacy$Model$Companion$get$3();

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$1 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96581<T, R> implements Func1<MeUser, Boolean> {
        public static final C96581 INSTANCE = new C96581();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(MeUser meUser) {
            return call2(meUser);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(MeUser meUser) {
            return Boolean.valueOf(meUser.isVerified());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$2 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96592<T, R> implements Func1<MeUser, Observable<? extends RestAPI.HarvestState>> {
        public static final C96592 INSTANCE = new C96592();

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1<T, R> implements Func1<Throwable, RestAPI.HarvestState> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            @Override // p637j0.p641k.Func1
            public /* bridge */ /* synthetic */ RestAPI.HarvestState call(Throwable th) {
                return call2(th);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final RestAPI.HarvestState call2(Throwable th) {
                return new RestAPI.HarvestState.NeverRequested();
            }
        }

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Observable<? extends RestAPI.HarvestState> call(MeUser meUser) {
            return call2(meUser);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Observable<? extends RestAPI.HarvestState> call2(MeUser meUser) {
            RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
            Observable<RestAPI.HarvestState> observableM11084J = RestAPI.INSTANCE.getApi().getHarvestStatusGuarded().m11084J(Schedulers2.m10875c());
            Intrinsics3.checkNotNullExpressionValue(observableM11084J, "RestAPI\n                …bserveOn(Schedulers.io())");
            return RetryWithDelay.restRetry$default(retryWithDelay, observableM11084J, 0L, null, null, 7, null).m11111q(500L, TimeUnit.MILLISECONDS).m11087M(AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3$3 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96603<T1, T2, T3, R> implements Func3<WidgetSettingsPrivacy.LocalState, ModelUserConsents2, RestAPI.HarvestState, WidgetSettingsPrivacy.Model> {
        public static final C96603 INSTANCE = new C96603();

        @Override // p658rx.functions.Func3
        public /* bridge */ /* synthetic */ WidgetSettingsPrivacy.Model call(WidgetSettingsPrivacy.LocalState localState, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
            return call2(localState, modelUserConsents2, harvestState);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final WidgetSettingsPrivacy.Model call2(WidgetSettingsPrivacy.LocalState localState, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
            ConnectedAccount contactSyncConnection = localState.getContactSyncConnection();
            Experiment contactSyncExperiment = localState.getContactSyncExperiment();
            boolean z2 = contactSyncExperiment != null && contactSyncExperiment.getBucket() == 1;
            MeUser me2 = localState.getMe();
            int explicitContentFilter = localState.getExplicitContentFilter();
            boolean defaultRestrictedGuilds = localState.getDefaultRestrictedGuilds();
            ModelUserSettings.FriendSourceFlags friendSourceFlags = localState.getFriendSourceFlags();
            int userDiscoveryFlags = localState.getUserDiscoveryFlags();
            Intrinsics3.checkNotNullExpressionValue(modelUserConsents2, "consent");
            return new WidgetSettingsPrivacy.Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, z2, modelUserConsents2, harvestState);
        }
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetSettingsPrivacy.Model> call2(WidgetSettingsPrivacy.LocalState localState) {
        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(localState);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        return Observable.m11075i(scalarSynchronousObservable, companion.getUserSettings().observeConsents(), Observable.m11064I(new ScalarSynchronousObservable(null), StoreUser.observeMe$default(companion.getUsers(), false, 1, null).m11118y(C96581.INSTANCE).m11082A(C96592.INSTANCE)), C96603.INSTANCE);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Observable<? extends WidgetSettingsPrivacy.Model> call(WidgetSettingsPrivacy.LocalState localState) {
        return call2(localState);
    }
}
