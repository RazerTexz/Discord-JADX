package com.discord.widgets.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsPrivacyBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserConsents3;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.WidgetSettingsPrivacyDefaultsBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.Tuples;
import p507d0.p580t.Collections2;
import p507d0.p580t.MapsJVM;
import p507d0.p580t.Sets5;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p637j0.p642l.p647e.ScalarSynchronousObservable;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func7;

/* compiled from: WidgetSettingsPrivacy.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsPrivacy.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AlertDialog dialog;

    /* renamed from: explicitContentRadios$delegate, reason: from kotlin metadata */
    private final Lazy explicitContentRadios;

    /* renamed from: friendSourceRadios$delegate, reason: from kotlin metadata */
    private final Lazy friendSourceRadios;
    private RadioManager radioManagerExplicit;
    private final StoreUserSettings userSettings;

    /* compiled from: WidgetSettingsPrivacy.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m157e(context, WidgetSettingsPrivacy.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    public static final /* data */ class LocalState {
        private final ConnectedAccount contactSyncConnection;
        private final Experiment contactSyncExperiment;
        private final boolean defaultRestrictedGuilds;
        private final int explicitContentFilter;
        private final ModelUserSettings.FriendSourceFlags friendSourceFlags;
        private final MeUser me;
        private final int userDiscoveryFlags;

        public LocalState(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.explicitContentFilter = i;
            this.defaultRestrictedGuilds = z2;
            this.friendSourceFlags = friendSourceFlags;
            this.contactSyncConnection = connectedAccount;
            this.contactSyncExperiment = experiment;
            this.userDiscoveryFlags = i2;
        }

        public static /* synthetic */ LocalState copy$default(LocalState localState, MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                meUser = localState.me;
            }
            if ((i3 & 2) != 0) {
                i = localState.explicitContentFilter;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                z2 = localState.defaultRestrictedGuilds;
            }
            boolean z3 = z2;
            if ((i3 & 8) != 0) {
                friendSourceFlags = localState.friendSourceFlags;
            }
            ModelUserSettings.FriendSourceFlags friendSourceFlags2 = friendSourceFlags;
            if ((i3 & 16) != 0) {
                connectedAccount = localState.contactSyncConnection;
            }
            ConnectedAccount connectedAccount2 = connectedAccount;
            if ((i3 & 32) != 0) {
                experiment = localState.contactSyncExperiment;
            }
            Experiment experiment2 = experiment;
            if ((i3 & 64) != 0) {
                i2 = localState.userDiscoveryFlags;
            }
            return localState.copy(meUser, i4, z3, friendSourceFlags2, connectedAccount2, experiment2, i2);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component2, reason: from getter */
        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        /* renamed from: component4, reason: from getter */
        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        /* renamed from: component5, reason: from getter */
        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        /* renamed from: component6, reason: from getter */
        public final Experiment getContactSyncExperiment() {
            return this.contactSyncExperiment;
        }

        /* renamed from: component7, reason: from getter */
        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        public final LocalState copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount contactSyncConnection, Experiment contactSyncExperiment, int userDiscoveryFlags) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new LocalState(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, contactSyncConnection, contactSyncExperiment, userDiscoveryFlags);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalState)) {
                return false;
            }
            LocalState localState = (LocalState) other;
            return Intrinsics3.areEqual(this.me, localState.me) && this.explicitContentFilter == localState.explicitContentFilter && this.defaultRestrictedGuilds == localState.defaultRestrictedGuilds && Intrinsics3.areEqual(this.friendSourceFlags, localState.friendSourceFlags) && Intrinsics3.areEqual(this.contactSyncConnection, localState.contactSyncConnection) && Intrinsics3.areEqual(this.contactSyncExperiment, localState.contactSyncExperiment) && this.userDiscoveryFlags == localState.userDiscoveryFlags;
        }

        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final Experiment getContactSyncExperiment() {
            return this.contactSyncExperiment;
        }

        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (((meUser != null ? meUser.hashCode() : 0) * 31) + this.explicitContentFilter) * 31;
            boolean z2 = this.defaultRestrictedGuilds;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            ModelUserSettings.FriendSourceFlags friendSourceFlags = this.friendSourceFlags;
            int iHashCode2 = (i2 + (friendSourceFlags != null ? friendSourceFlags.hashCode() : 0)) * 31;
            ConnectedAccount connectedAccount = this.contactSyncConnection;
            int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
            Experiment experiment = this.contactSyncExperiment;
            return ((iHashCode3 + (experiment != null ? experiment.hashCode() : 0)) * 31) + this.userDiscoveryFlags;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("LocalState(me=");
            sbM833U.append(this.me);
            sbM833U.append(", explicitContentFilter=");
            sbM833U.append(this.explicitContentFilter);
            sbM833U.append(", defaultRestrictedGuilds=");
            sbM833U.append(this.defaultRestrictedGuilds);
            sbM833U.append(", friendSourceFlags=");
            sbM833U.append(this.friendSourceFlags);
            sbM833U.append(", contactSyncConnection=");
            sbM833U.append(this.contactSyncConnection);
            sbM833U.append(", contactSyncExperiment=");
            sbM833U.append(this.contactSyncExperiment);
            sbM833U.append(", userDiscoveryFlags=");
            return outline.m814B(sbM833U, this.userDiscoveryFlags, ")");
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ModelUserConsents2 consents;
        private final ConnectedAccount contactSyncConnection;
        private final boolean defaultRestrictedGuilds;
        private final int explicitContentFilter;
        private final ModelUserSettings.FriendSourceFlags friendSourceFlags;
        private final RestAPI.HarvestState harvestState;
        private final MeUser me;
        private final boolean showContactSync;
        private final int userDiscoveryFlags;

        /* compiled from: WidgetSettingsPrivacy.kt */
        public static final class Companion {
            private Companion() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r1v10, types: [com.discord.widgets.settings.WidgetSettingsPrivacy$sam$rx_functions_Func7$0] */
            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                Observable<Integer> observableObserveExplicitContentFilter = companion.getUserSettings().observeExplicitContentFilter();
                Observable<Boolean> observableObserveIsDefaultGuildsRestricted = companion.getUserSettings().observeIsDefaultGuildsRestricted();
                Observable<ModelUserSettings.FriendSourceFlags> observableObserveFriendSourceFlags = companion.getUserSettings().observeFriendSourceFlags();
                Observable observableM11083G = companion.getUserConnections().observeConnectedAccounts().m11083G(WidgetSettingsPrivacy$Model$Companion$get$1.INSTANCE);
                Observable<Experiment> observableObserveUserExperiment = companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true);
                Observable<Integer> observableObserveFriendDiscoveryFlags = companion.getUserSettings().observeFriendDiscoveryFlags();
                WidgetSettingsPrivacy$Model$Companion$get$2 widgetSettingsPrivacy$sam$rx_functions_Func7$0 = WidgetSettingsPrivacy$Model$Companion$get$2.INSTANCE;
                if (widgetSettingsPrivacy$sam$rx_functions_Func7$0 != null) {
                    widgetSettingsPrivacy$sam$rx_functions_Func7$0 = new WidgetSettingsPrivacy$sam$rx_functions_Func7$0(widgetSettingsPrivacy$sam$rx_functions_Func7$0);
                }
                Observable observableM11099Y = Observable.m11069e(observableObserveMe$default, observableObserveExplicitContentFilter, observableObserveIsDefaultGuildsRestricted, observableObserveFriendSourceFlags, observableM11083G, observableObserveUserExperiment, observableObserveFriendDiscoveryFlags, (Func7) widgetSettingsPrivacy$sam$rx_functions_Func7$0).m11099Y(WidgetSettingsPrivacy$Model$Companion$get$3.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11099Y, "Observable\n          .co…            }\n          }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(modelUserConsents2, "consents");
            this.me = meUser;
            this.explicitContentFilter = i;
            this.defaultRestrictedGuilds = z2;
            this.friendSourceFlags = friendSourceFlags;
            this.userDiscoveryFlags = i2;
            this.contactSyncConnection = connectedAccount;
            this.showContactSync = z3;
            this.consents = modelUserConsents2;
            this.harvestState = harvestState;
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState, int i3, Object obj) {
            return model.copy((i3 & 1) != 0 ? model.me : meUser, (i3 & 2) != 0 ? model.explicitContentFilter : i, (i3 & 4) != 0 ? model.defaultRestrictedGuilds : z2, (i3 & 8) != 0 ? model.friendSourceFlags : friendSourceFlags, (i3 & 16) != 0 ? model.userDiscoveryFlags : i2, (i3 & 32) != 0 ? model.contactSyncConnection : connectedAccount, (i3 & 64) != 0 ? model.showContactSync : z3, (i3 & 128) != 0 ? model.consents : modelUserConsents2, (i3 & 256) != 0 ? model.harvestState : harvestState);
        }

        /* renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* renamed from: component2, reason: from getter */
        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        /* renamed from: component4, reason: from getter */
        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        /* renamed from: component5, reason: from getter */
        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        /* renamed from: component6, reason: from getter */
        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        /* renamed from: component7, reason: from getter */
        public final boolean getShowContactSync() {
            return this.showContactSync;
        }

        /* renamed from: component8, reason: from getter */
        public final ModelUserConsents2 getConsents() {
            return this.consents;
        }

        /* renamed from: component9, reason: from getter */
        public final RestAPI.HarvestState getHarvestState() {
            return this.harvestState;
        }

        public final Model copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings.FriendSourceFlags friendSourceFlags, int userDiscoveryFlags, ConnectedAccount contactSyncConnection, boolean showContactSync, ModelUserConsents2 consents, RestAPI.HarvestState harvestState) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(consents, "consents");
            return new Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, showContactSync, consents, harvestState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.me, model.me) && this.explicitContentFilter == model.explicitContentFilter && this.defaultRestrictedGuilds == model.defaultRestrictedGuilds && Intrinsics3.areEqual(this.friendSourceFlags, model.friendSourceFlags) && this.userDiscoveryFlags == model.userDiscoveryFlags && Intrinsics3.areEqual(this.contactSyncConnection, model.contactSyncConnection) && this.showContactSync == model.showContactSync && Intrinsics3.areEqual(this.consents, model.consents) && Intrinsics3.areEqual(this.harvestState, model.harvestState);
        }

        public final ModelUserConsents2 getConsents() {
            return this.consents;
        }

        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        public final RestAPI.HarvestState getHarvestState() {
            return this.harvestState;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getShowContactSync() {
            return this.showContactSync;
        }

        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (((meUser != null ? meUser.hashCode() : 0) * 31) + this.explicitContentFilter) * 31;
            boolean z2 = this.defaultRestrictedGuilds;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            ModelUserSettings.FriendSourceFlags friendSourceFlags = this.friendSourceFlags;
            int iHashCode2 = (((i2 + (friendSourceFlags != null ? friendSourceFlags.hashCode() : 0)) * 31) + this.userDiscoveryFlags) * 31;
            ConnectedAccount connectedAccount = this.contactSyncConnection;
            int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
            boolean z3 = this.showContactSync;
            int i3 = (iHashCode3 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
            ModelUserConsents2 modelUserConsents2 = this.consents;
            int iHashCode4 = (i3 + (modelUserConsents2 != null ? modelUserConsents2.hashCode() : 0)) * 31;
            RestAPI.HarvestState harvestState = this.harvestState;
            return iHashCode4 + (harvestState != null ? harvestState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(me=");
            sbM833U.append(this.me);
            sbM833U.append(", explicitContentFilter=");
            sbM833U.append(this.explicitContentFilter);
            sbM833U.append(", defaultRestrictedGuilds=");
            sbM833U.append(this.defaultRestrictedGuilds);
            sbM833U.append(", friendSourceFlags=");
            sbM833U.append(this.friendSourceFlags);
            sbM833U.append(", userDiscoveryFlags=");
            sbM833U.append(this.userDiscoveryFlags);
            sbM833U.append(", contactSyncConnection=");
            sbM833U.append(this.contactSyncConnection);
            sbM833U.append(", showContactSync=");
            sbM833U.append(this.showContactSync);
            sbM833U.append(", consents=");
            sbM833U.append(this.consents);
            sbM833U.append(", harvestState=");
            sbM833U.append(this.harvestState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1 */
    public static final class C96611 extends Lambda implements Function1<RenderContext, Unit> {
        public C96611() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C132901 extends Lambda implements Function1<View, Unit> {
                public static final C132901 INSTANCE = new C132901();

                public C132901() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, AppHelpDesk.f507a.m149a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetSettingsPrivacy.this.getContext(), C5419R.color.link)), false, null, C132901.INSTANCE, 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("onClick", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$2 */
    public static final class ViewOnClickListenerC96622 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC96622(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18052c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            boolean z2 = !checkedSetting.isChecked();
            if (this.$model.getContactSyncConnection() == null) {
                if (z2) {
                    AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location(Traits.Location.Page.USER_SETTINGS, null, null, null, null, 30, null));
                    ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.m10073to("location_page", Traits.Location.Page.USER_SETTINGS)), 1, null);
                    WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetSettingsPrivacy.this.requireContext(), null, false, false, false, 30, null);
                    return;
                }
                return;
            }
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18054e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            boolean zIsChecked = checkedSetting2.isChecked();
            CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18051b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            analyticsTracker.contactSyncToggled(z2, zIsChecked, checkedSetting3.isChecked());
            WidgetSettingsPrivacy.access$toggleContactSync(WidgetSettingsPrivacy.this, this.$model.getContactSyncConnection(), z2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$3 */
    public static final class ViewOnClickListenerC96633 implements View.OnClickListener {
        public ViewOnClickListenerC96633() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18054e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingPhone");
            boolean z2 = !checkedSetting.isChecked();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18051b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingEmail");
            boolean zIsChecked = checkedSetting2.isChecked();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18052c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEnabled");
            boolean zIsChecked2 = checkedSetting3.isChecked();
            CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18051b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEmail");
            analyticsTracker.contactSyncToggled(zIsChecked2, z2, checkedSetting4.isChecked());
            WidgetSettingsPrivacy.access$updateFriendDiscoveryFlags(WidgetSettingsPrivacy.this, z2, zIsChecked);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$4 */
    public static final class ViewOnClickListenerC96644 implements View.OnClickListener {
        public ViewOnClickListenerC96644() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18051b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEmail");
            boolean z2 = !checkedSetting.isChecked();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18054e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            boolean zIsChecked = checkedSetting2.isChecked();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18052c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEnabled");
            boolean zIsChecked2 = checkedSetting3.isChecked();
            CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18054e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingPhone");
            analyticsTracker.contactSyncToggled(zIsChecked2, checkedSetting4.isChecked(), z2);
            WidgetSettingsPrivacy.access$updateFriendDiscoveryFlags(WidgetSettingsPrivacy.this, zIsChecked, z2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$5 */
    public static final class ViewOnClickListenerC96655 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC96655(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (UserUtils.INSTANCE.isStaff(this.$model.getMe())) {
                WidgetSettingsPrivacy.access$deleteContactSync(WidgetSettingsPrivacy.this);
            }
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureDefaultGuildsRestricted$1 */
    public static final class ViewOnClickListenerC96661 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC96661(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPrivacy.access$showDefaultGuildsRestrictedExistingServers(WidgetSettingsPrivacy.this, !this.$model.getDefaultRestrictedGuilds());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureExplicitContentRadio$1 */
    public static final class ViewOnClickListenerC96671 implements View.OnClickListener {
        public final /* synthetic */ int $explicitContentFilter;

        public ViewOnClickListenerC96671(int i) {
            this.$explicitContentFilter = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettings().setExplicitContentFilter(WidgetSettingsPrivacy.this.getAppActivity(), this.$explicitContentFilter);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureFriendSourceRadio$1 */
    public static final class C96681<T> implements Action1<Boolean> {
        public C96681() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 0, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureFriendSourceRadio$2 */
    public static final class C96692<T> implements Action1<Boolean> {
        public C96692() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 1, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureFriendSourceRadio$3 */
    public static final class C96703<T> implements Action1<Boolean> {
        public C96703() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            Intrinsics3.checkNotNullExpressionValue(bool, "checked");
            WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 2, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1 */
    public static final class C96711<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class ViewOnClickListenerC132911 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public ViewOnClickListenerC132911(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18075z;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                    checkedSetting.setChecked(true);
                    CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18075z;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
                    checkedSetting2.setEnabled(true);
                }
            }

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public AnonymousClass2(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                    Boolean bool = anonymousClass1.$consented;
                    Intrinsics3.checkNotNullExpressionValue(bool, "consented");
                    boolean zBooleanValue = bool.booleanValue();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18075z;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                    WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                Intrinsics3.checkNotNullParameter(alertDialog, "dialog");
                Intrinsics3.checkNotNullParameter(textView, "dialogHeader");
                Intrinsics3.checkNotNullParameter(textView2, "dialogBody");
                Intrinsics3.checkNotNullParameter(textView3, "dialogCancel");
                Intrinsics3.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(C5419R.string.usage_statistics_disable_modal_title);
                textView2.setText(C5419R.string.usage_statistics_disable_modal_body);
                textView3.setText(C5419R.string.usage_statistics_disable_modal_cancel);
                textView3.setOnClickListener(new ViewOnClickListenerC132911(alertDialog));
                textView4.setText(C5419R.string.usage_statistics_disable_modal_confirm);
                textView4.setOnClickListener(new AnonymousClass2(alertDialog));
            }
        }

        public C96711(Context context) {
            this.$context = context;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18075z;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setEnabled(false);
            Intrinsics3.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.access$confirmConsent(WidgetSettingsPrivacy.this, this.$context, new AnonymousClass1(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18075z;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
            WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2 */
    public static final class C96722<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class ViewOnClickListenerC132921 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public ViewOnClickListenerC132921(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18071v;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                    checkedSetting.setChecked(true);
                    CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18071v;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
                    checkedSetting2.setEnabled(true);
                }
            }

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1$2, reason: invalid class name */
            public static final class AnonymousClass2 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public AnonymousClass2(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                    Boolean bool = anonymousClass1.$consented;
                    Intrinsics3.checkNotNullExpressionValue(bool, "consented");
                    boolean zBooleanValue = bool.booleanValue();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18071v;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                    WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                Intrinsics3.checkNotNullParameter(alertDialog, "dialog");
                Intrinsics3.checkNotNullParameter(textView, "dialogHeader");
                Intrinsics3.checkNotNullParameter(textView2, "dialogBody");
                Intrinsics3.checkNotNullParameter(textView3, "dialogCancel");
                Intrinsics3.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(C5419R.string.personalization_disable_modal_title);
                textView2.setText(C5419R.string.personalization_disable_modal_body);
                textView3.setText(C5419R.string.personalization_disable_modal_cancel);
                textView3.setOnClickListener(new ViewOnClickListenerC132921(alertDialog));
                textView4.setText(C5419R.string.personalization_disable_modal_confirm);
                textView4.setOnClickListener(new AnonymousClass2(alertDialog));
            }
        }

        public C96722(Context context) {
            this.$context = context;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18071v;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
            checkedSetting.setEnabled(false);
            Intrinsics3.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.access$confirmConsent(WidgetSettingsPrivacy.this, this.$context, new AnonymousClass1(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18071v;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureRequestDataButton$1 */
    public static final class ViewOnClickListenerC96731 implements View.OnClickListener {
        public final /* synthetic */ RestAPI.HarvestState $harvestState;
        public final /* synthetic */ boolean $isMeVerified;

        public ViewOnClickListenerC96731(boolean z2, RestAPI.HarvestState harvestState) {
            this.$isMeVerified = z2;
            this.$harvestState = harvestState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI.HarvestState harvestState;
            Context context = WidgetSettingsPrivacy.this.getContext();
            if (context != null) {
                Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                if (!this.$isMeVerified || (harvestState = this.$harvestState) == null) {
                    AppToast.m171i(WidgetSettingsPrivacy.this, C5419R.string.data_privacy_controls_request_data_tooltip, 0, 4);
                } else {
                    WidgetSettingsPrivacy.access$onRequestDataClick(WidgetSettingsPrivacy.this, context, harvestState);
                }
            }
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$1 */
    public static final class C96741 extends Lambda implements Function1<ModelUserConsents3, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96741(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserConsents3 modelUserConsents3) {
            invoke2(modelUserConsents3);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserConsents3 modelUserConsents3) {
            Intrinsics3.checkNotNullParameter(modelUserConsents3, "requestedHarvest");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(C5419R.string.data_privacy_controls_request_data_success_title).setMessage(C5419R.string.data_privacy_controls_request_data_success_body), C5419R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
            WidgetSettingsPrivacy.access$configureRequestDataButton(WidgetSettingsPrivacy.this, true, new RestAPI.HarvestState.LastRequested(modelUserConsents3));
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$2 */
    public static final class C96752 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96752(Context context) {
            super(1);
            this.$context = context;
        }

        public static /* synthetic */ void invoke$default(C96752 c96752, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            c96752.invoke2(str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.CharSequence] */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetNoticeDialog.Builder title = new WidgetNoticeDialog.Builder(this.$context).setTitle(C5419R.string.data_privacy_controls_request_data_failure_title);
            String strM216h = str;
            if (str == null) {
                strM216h = FormatUtils.m216h(this.$context, C5419R.string.data_privacy_controls_request_data_failure_body, new Object[0], null, 4);
            }
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(title.setMessage(strM216h), C5419R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3 */
    public static final class C96763 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C96752 $handleRequestError$2;
        public final /* synthetic */ C96741 $handleRequestSuccess$1;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                Intrinsics3.checkNotNullParameter(error, "it");
                C96752 c96752 = C96763.this.$handleRequestError$2;
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                c96752.invoke2(response.getMessage());
                error.setShowErrorToasts(false);
            }
        }

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends Lambda implements Function1<ModelUserConsents3, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserConsents3 modelUserConsents3) {
                invoke2(modelUserConsents3);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserConsents3 modelUserConsents3) {
                if (modelUserConsents3 != null) {
                    C96763.this.$handleRequestSuccess$1.invoke2(modelUserConsents3);
                } else {
                    C96752.invoke$default(C96763.this.$handleRequestError$2, null, 1, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96763(Context context, C96752 c96752, C96741 c96741) {
            super(0);
            this.$context = context;
            this.$handleRequestError$2 = c96752;
            this.$handleRequestSuccess$1 = c96741;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().requestHarvest(), false)), WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18056g, 100L), WidgetSettingsPrivacy.this.getClass(), this.$context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4 */
    public static final class C96774 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C96763 $requestHarvest$3;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                C96774.this.$requestHarvest$3.invoke2();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96774(Context context, C96763 c96763) {
            super(0);
            this.$context = context;
            this.$requestHarvest$3 = c96763;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(C5419R.string.data_privacy_controls_request_data_download).setMessage(C5419R.string.data_privacy_controls_request_data_modal_note).setPositiveButton(C5419R.string.okay, new AnonymousClass1()), C5419R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2 */
    public static final class C96782 extends Lambda implements Function1<RenderContext, Unit> {
        public static final C96782 INSTANCE = new C96782();

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                UriHandler.handle$default(uriHandler, context, AppHelpDesk.f507a.m149a(360004066391L, null), false, false, null, 28, null);
            }
        }

        public C96782() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$3 */
    public static final class ViewOnClickListenerC96793 implements View.OnClickListener {
        public static final ViewOnClickListenerC96793 INSTANCE = new ViewOnClickListenerC96793();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            WidgetSettingsAccount.Companion.launch$default(companion, context, true, null, 4, null);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$4 */
    public static final class ViewOnClickListenerC96804 implements View.OnClickListener {
        public final /* synthetic */ String $dataRequestArticleUrl;

        public ViewOnClickListenerC96804(String str) {
            this.$dataRequestArticleUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, outline.m885x(view, "it", "it.context"), this.$dataRequestArticleUrl, false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C96811 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C96811(WidgetSettingsPrivacy widgetSettingsPrivacy) {
            super(1, widgetSettingsPrivacy, WidgetSettingsPrivacy.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            WidgetSettingsPrivacy.access$configureUI((WidgetSettingsPrivacy) this.receiver, model);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$2 */
    public static final class C96822 extends Lambda implements Function1<Boolean, Unit> {
        public C96822() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f18074y;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyScreenreaderDetection");
            checkedSetting.setChecked(z2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$toggleConsent$1 */
    public static final class C96851 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ CheckedSetting $toggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96851(CheckedSetting checkedSetting) {
            super(1);
            this.$toggle = checkedSetting;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            this.$toggle.setEnabled(true);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$toggleConsent$2 */
    public static final class C96862<T> implements Action1<Error> {
        public final /* synthetic */ boolean $consented;
        public final /* synthetic */ CheckedSetting $toggle;

        public C96862(CheckedSetting checkedSetting, boolean z2) {
            this.$toggle = checkedSetting;
            this.$consented = z2;
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Error error) {
            call2(error);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Error error) {
            this.$toggle.setEnabled(true);
            this.$toggle.setChecked(true ^ this.$consented);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$updateDefaultGuildsRestricted$1 */
    public static final class C96871<T, R> implements Func1<Map<Long, ? extends Guild>, Set<? extends Long>> {
        public static final C96871 INSTANCE = new C96871();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, Guild> map) {
            return map.keySet();
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2 */
    public static final class C96882 extends Lambda implements Function1<Set<? extends Long>, Unit> {
        public final /* synthetic */ boolean $defaultGuildsRestricted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96882(boolean z2) {
            super(1);
            this.$defaultGuildsRestricted = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            StoreStream.INSTANCE.getUserSettings().setDefaultGuildsRestricted(WidgetSettingsPrivacy.this.getAppActivity(), this.$defaultGuildsRestricted, set);
        }
    }

    public WidgetSettingsPrivacy() {
        super(C5419R.layout.widget_settings_privacy);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsPrivacy$binding$2.INSTANCE, null, 2, null);
        this.explicitContentRadios = LazyJVM.lazy(new WidgetSettingsPrivacy$explicitContentRadios$2(this));
        this.friendSourceRadios = LazyJVM.lazy(new WidgetSettingsPrivacy$friendSourceRadios$2(this));
        this.userSettings = StoreStream.INSTANCE.getUserSettings();
    }

    public static final /* synthetic */ void access$configureRequestDataButton(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, RestAPI.HarvestState harvestState) {
        widgetSettingsPrivacy.configureRequestDataButton(z2, harvestState);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsPrivacy widgetSettingsPrivacy, Model model) {
        widgetSettingsPrivacy.configureUI(model);
    }

    public static final /* synthetic */ void access$confirmConsent(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context, Function5 function5) {
        widgetSettingsPrivacy.confirmConsent(context, function5);
    }

    public static final /* synthetic */ void access$deleteContactSync(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        widgetSettingsPrivacy.deleteContactSync();
    }

    public static final /* synthetic */ WidgetSettingsPrivacyBinding access$getBinding$p(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        return widgetSettingsPrivacy.getBinding();
    }

    public static final /* synthetic */ StoreUserSettings access$getUserSettings$p(WidgetSettingsPrivacy widgetSettingsPrivacy) {
        return widgetSettingsPrivacy.userSettings;
    }

    public static final /* synthetic */ void access$onRequestDataClick(WidgetSettingsPrivacy widgetSettingsPrivacy, Context context, RestAPI.HarvestState harvestState) {
        widgetSettingsPrivacy.onRequestDataClick(context, harvestState);
    }

    public static final /* synthetic */ void access$showDefaultGuildsRestrictedExistingServers(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2) {
        widgetSettingsPrivacy.showDefaultGuildsRestrictedExistingServers(z2);
    }

    public static final /* synthetic */ void access$toggleConsent(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, String str, CheckedSetting checkedSetting) {
        widgetSettingsPrivacy.toggleConsent(z2, str, checkedSetting);
    }

    public static final /* synthetic */ void access$toggleContactSync(WidgetSettingsPrivacy widgetSettingsPrivacy, ConnectedAccount connectedAccount, boolean z2) {
        widgetSettingsPrivacy.toggleContactSync(connectedAccount, z2);
    }

    public static final /* synthetic */ void access$updateDefaultGuildsRestricted(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, boolean z3) {
        widgetSettingsPrivacy.updateDefaultGuildsRestricted(z2, z3);
    }

    public static final /* synthetic */ void access$updateFriendDiscoveryFlags(WidgetSettingsPrivacy widgetSettingsPrivacy, boolean z2, boolean z3) {
        widgetSettingsPrivacy.updateFriendDiscoveryFlags(z2, z3);
    }

    public static final /* synthetic */ void access$updateFriendSourceFlags(WidgetSettingsPrivacy widgetSettingsPrivacy, int i, boolean z2) {
        widgetSettingsPrivacy.updateFriendSourceFlags(i, z2);
    }

    private final void configureContactSyncOptions(Model model) {
        LinearLayout linearLayout = getBinding().f18059j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyContactSync");
        linearLayout.setVisibility(model.getShowContactSync() ? 0 : 8);
        if (model.getShowContactSync()) {
            TextView textView = getBinding().f18053d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.contactSyncSettingInfo");
            FormatUtils.m221m(textView, C5419R.string.contact_sync_info_settings_2, new Object[0], new C96611());
            TextView textView2 = getBinding().f18053d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.contactSyncSettingInfo");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            CheckedSetting checkedSetting = getBinding().f18052c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
            checkedSetting.setChecked(contactSyncConnection != null && contactSyncConnection.getFriendSync());
            CheckedSetting checkedSetting2 = getBinding().f18054e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            checkedSetting2.setChecked((model.getUserDiscoveryFlags() & 2) == 2);
            CheckedSetting checkedSetting3 = getBinding().f18051b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            checkedSetting3.setChecked((model.getUserDiscoveryFlags() & 4) == 4);
            getBinding().f18052c.m8527e(new ViewOnClickListenerC96622(model));
            getBinding().f18054e.m8527e(new ViewOnClickListenerC96633());
            getBinding().f18051b.m8527e(new ViewOnClickListenerC96644());
            CheckedSetting checkedSetting4 = getBinding().f18055f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingStaffOnly");
            checkedSetting4.setVisibility(UserUtils.INSTANCE.isStaff(model.getMe()) ? 0 : 8);
            CheckedSetting checkedSetting5 = getBinding().f18055f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingStaffOnly");
            checkedSetting5.setChecked(true);
            getBinding().f18055f.m8527e(new ViewOnClickListenerC96655(model));
        }
    }

    private final void configureDefaultGuildsRestricted(Model model) {
        CheckedSetting checkedSetting = getBinding().f18062m;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyDefaultRestrictedGuilds");
        checkedSetting.setChecked(!model.getDefaultRestrictedGuilds());
        getBinding().f18062m.m8527e(new ViewOnClickListenerC96661(model));
    }

    private final void configureExplicitContentRadio(Model model, CheckedSetting radio, int explicitContentFilter) {
        RadioManager radioManager;
        radio.m8527e(new ViewOnClickListenerC96671(explicitContentFilter));
        if (this.radioManagerExplicit == null || model.getExplicitContentFilter() != explicitContentFilter || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.m8550a(radio);
    }

    private final void configureFriendSourceRadio(Model model) {
        getFriendSourceRadios().get(0).setOnCheckedListener(new C96681());
        getFriendSourceRadios().get(1).setOnCheckedListener(new C96692());
        getFriendSourceRadios().get(2).setOnCheckedListener(new C96703());
        ModelUserSettings.FriendSourceFlags friendSourceFlags = model.getFriendSourceFlags();
        boolean zIsAll = friendSourceFlags != null ? friendSourceFlags.isAll() : false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        checkedSetting.setChecked(zIsAll);
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        CheckedSetting checkedSetting3 = checkedSetting2;
        ModelUserSettings.FriendSourceFlags friendSourceFlags2 = model.getFriendSourceFlags();
        checkedSetting3.setChecked((friendSourceFlags2 != null ? friendSourceFlags2.isMutualFriends() : false) || zIsAll);
        CheckedSetting checkedSetting4 = getFriendSourceRadios().get(2);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "friendSourceRadios[2]");
        CheckedSetting checkedSetting5 = checkedSetting4;
        ModelUserSettings.FriendSourceFlags friendSourceFlags3 = model.getFriendSourceFlags();
        checkedSetting5.setChecked((friendSourceFlags3 != null ? friendSourceFlags3.isMutualGuilds() : false) || zIsAll);
    }

    private final void configurePrivacyControls(Model model) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            LinearLayout linearLayout = getBinding().f18060k;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyControls");
            linearLayout.setVisibility(0);
            CheckedSetting checkedSetting = getBinding().f18075z;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setChecked(model.getConsents().getUsageStatistics().getConsented());
            getBinding().f18075z.setOnCheckedListener(new C96711(context));
            CheckedSetting checkedSetting2 = getBinding().f18071v;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            checkedSetting2.setChecked(model.getConsents().getPersonalization().getConsented());
            getBinding().f18071v.setOnCheckedListener(new C96722(context));
        }
    }

    private final void configureRequestDataButton(boolean isMeVerified, RestAPI.HarvestState harvestState) {
        getBinding().f18072w.setOnClickListener(new ViewOnClickListenerC96731(isMeVerified, harvestState));
    }

    private final void configureUI(Model model) {
        configureDefaultGuildsRestricted(model);
        configureFriendSourceRadio(model);
        configureContactSyncOptions(model);
        CheckedSetting checkedSetting = getExplicitContentRadios().get(0);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "explicitContentRadios[0]");
        configureExplicitContentRadio(model, checkedSetting, 0);
        CheckedSetting checkedSetting2 = getExplicitContentRadios().get(1);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "explicitContentRadios[1]");
        configureExplicitContentRadio(model, checkedSetting2, 1);
        CheckedSetting checkedSetting3 = getExplicitContentRadios().get(2);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "explicitContentRadios[2]");
        configureExplicitContentRadio(model, checkedSetting3, 2);
        configurePrivacyControls(model);
        configureRequestDataButton(model.getMe().isVerified(), model.getHarvestState());
    }

    private final void confirmConsent(Context context, Function5<? super AlertDialog, ? super TextView, ? super TextView, ? super TextView, ? super TextView, Unit> function5) {
        ViewDialogConfirmationBinding viewDialogConfirmationBindingM8393a = ViewDialogConfirmationBinding.m8393a(getLayoutInflater().inflate(C5419R.layout.view_dialog_confirmation, (ViewGroup) null, false));
        Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingM8393a, "ViewDialogConfirmationBi…outInflater, null, false)");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(viewDialogConfirmationBindingM8393a.f15420a).setCancelable(false).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(this…(false)\n        .create()");
        TextView textView = viewDialogConfirmationBindingM8393a.f15423d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        TextView textView2 = viewDialogConfirmationBindingM8393a.f15424e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        MaterialButton materialButton = viewDialogConfirmationBindingM8393a.f15421b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
        MaterialButton materialButton2 = viewDialogConfirmationBindingM8393a.f15422c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
        function5.invoke(alertDialogCreate, textView, textView2, materialButton, materialButton2);
        alertDialogCreate.show();
    }

    private final void deleteContactSync() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getContactSync().clearDismissStates();
        companion.getUserConnections().deleteUserConnection("contacts", "@me");
    }

    private final WidgetSettingsPrivacyBinding getBinding() {
        return (WidgetSettingsPrivacyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentRadios() {
        return (List) this.explicitContentRadios.getValue();
    }

    private final List<CheckedSetting> getFriendSourceRadios() {
        return (List) this.friendSourceRadios.getValue();
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void onRequestDataClick(Context context, RestAPI.HarvestState harvestState) {
        C96774 c96774 = new C96774(context, new C96763(context, new C96752(context), new C96741(context)));
        if (harvestState instanceof RestAPI.HarvestState.NeverRequested) {
            c96774.invoke2();
            return;
        }
        if (harvestState instanceof RestAPI.HarvestState.LastRequested) {
            ModelUserConsents3 data = ((RestAPI.HarvestState.LastRequested) harvestState).getData();
            if (ModelUserConsents3.canRequest$default(data, 0L, 1, null)) {
                c96774.invoke2();
            } else {
                showNextAvailableRequestAlert(data.nextAvailableRequestInMillis());
            }
        }
    }

    private final void showDefaultGuildsRestrictedExistingServers(boolean defaultGuildsRestricted) {
        View viewInflate = getLayoutInflater().inflate(C5419R.layout.widget_settings_privacy_defaults, (ViewGroup) null, false);
        int i = C5419R.id.settings_privacy_defaults_existing_no;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.settings_privacy_defaults_existing_no);
        if (materialButton != null) {
            i = C5419R.id.settings_privacy_defaults_existing_yes;
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.settings_privacy_defaults_existing_yes);
            if (materialButton2 != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new WidgetSettingsPrivacyDefaultsBinding(linearLayout, materialButton, materialButton2), "WidgetSettingsPrivacyDef…outInflater, null, false)");
                materialButton.setOnClickListener(new ViewOnClickListenerC9683x9e9c2a8c(this, defaultGuildsRestricted));
                materialButton2.setOnClickListener(new ViewOnClickListenerC9684x9e9c2a8d(this, defaultGuildsRestricted));
                AlertDialog alertDialog = this.dialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                this.dialog = alertDialogCreate;
                if (alertDialogCreate != null) {
                    alertDialogCreate.show();
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void showNextAvailableRequestAlert(long nextAvailableRequestMillis) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(context).setTitle(C5419R.string.data_privacy_rate_limit_title).setMessage(FormatUtils.m216h(context, C5419R.string.data_download_requested_status_note, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, nextAvailableRequestMillis, context, 0, 4, null)}, null, 4)), C5419R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    private final void toggleConsent(boolean consented, String consentType, CheckedSetting toggle) {
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().setConsent(consented, consentType), this, null, 2, null), getBinding().f18056g, 100L).m11108k(C0879o.f566a.m184g(getContext(), new C96851(toggle), new C96862(toggle, consented)));
    }

    private final void toggleContactSync(ConnectedAccount contactsAccount, boolean syncFriends) {
        if (contactsAccount == null) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getUserConnections().updateUserConnection(contactsAccount, syncFriends, contactsAccount.getShowActivity(), contactsAccount.getVisibility() == 1);
        if (syncFriends) {
            companion.getContactSync().backgroundUploadContacts();
        }
    }

    private final void updateDefaultGuildsRestricted(boolean defaultGuildsRestricted, boolean applyToExistingGuilds) {
        Observable observableM11100Z = (!applyToExistingGuilds ? new ScalarSynchronousObservable(null) : !defaultGuildsRestricted ? new ScalarSynchronousObservable(Sets5.emptySet()) : StoreStream.INSTANCE.getGuilds().observeGuilds().m11083G(C96871.INSTANCE)).m11100Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableM11100Z, "when {\n      !applyToExi… }\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11100Z), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96882(defaultGuildsRestricted), 62, (Object) null);
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void updateFriendDiscoveryFlags(boolean allowPhone, boolean allowEmail) {
        int i = allowPhone ? 2 : 0;
        if (allowEmail) {
            i |= 4;
        }
        StoreStream.INSTANCE.getUserSettings().setFriendDiscoveryFlags(getAppActivity(), i);
    }

    private final void updateFriendSourceFlags(int index, boolean checked) {
        boolean z2 = false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        boolean zIsChecked = checkedSetting.isChecked();
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        boolean zIsChecked2 = checkedSetting2.isChecked();
        CheckedSetting checkedSetting3 = getFriendSourceRadios().get(2);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "friendSourceRadios[2]");
        boolean zIsChecked3 = checkedSetting3.isChecked();
        if ((zIsChecked && zIsChecked2 && zIsChecked3) || (index == 0 && checked)) {
            z2 = true;
        }
        StoreStream.INSTANCE.getUserSettings().setFriendSourceFlags(getAppActivity(), Boolean.valueOf(z2), Boolean.valueOf(zIsChecked3), Boolean.valueOf(zIsChecked2));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // com.discord.app.AppFragment
    @SuppressLint({"SetTextI18n"})
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.privacy_and_safety);
        this.radioManagerExplicit = new RadioManager(getExplicitContentRadios());
        CheckedSetting checkedSetting = getBinding().f18071v;
        CheckedSetting checkedSetting2 = getBinding().f18071v;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        AppHelpDesk appHelpDesk = AppHelpDesk.f507a;
        checkedSetting.m8530h(FormatUtils.m218j(checkedSetting2, C5419R.string.data_privacy_controls_personalization_note_learn_more, new Object[]{appHelpDesk.m149a(360004109911L, null)}, null, 4), true);
        CheckedSetting checkedSetting3 = getBinding().f18074y;
        CheckedSetting checkedSetting4 = getBinding().f18074y;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsPrivacyScreenreaderDetection");
        checkedSetting3.m8530h(FormatUtils.m218j(checkedSetting4, C5419R.string.data_privacy_controls_allow_accessibility_detection_note, new Object[]{appHelpDesk.m149a(360035966492L, null)}, null, 4), true);
        CheckedSetting checkedSetting5 = getBinding().f18074y;
        checkedSetting5.setOnCheckedListener(new WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1(checkedSetting5, this));
        getBinding().f18058i.setButtonVisibility(false);
        CheckedSetting checkedSetting6 = getBinding().f18058i;
        CheckedSetting checkedSetting7 = getBinding().f18058i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsPrivacyBasicService");
        checkedSetting6.m8530h(FormatUtils.m212d(checkedSetting7, C5419R.string.data_privacy_controls_basic_service_note, new Object[0], C96782.INSTANCE), true);
        getBinding().f18058i.m8527e(ViewOnClickListenerC96793.INSTANCE);
        String strM149a = appHelpDesk.m149a(360004027692L, null);
        TextView textView = getBinding().f18057h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.requestDataLink");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        TextView textView2 = getBinding().f18057h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.requestDataLink");
        sb.append(FormatUtils.m218j(textView2, C5419R.string.notice_whats_this, new Object[0], null, 4));
        sb.append("](");
        sb.append(strM149a);
        sb.append(')');
        textView.setText(FormatUtils.m220l(sb.toString(), new Object[0], null, 2));
        getBinding().f18057h.setOnClickListener(new ViewOnClickListenerC96804(strM149a));
        CheckedSetting checkedSetting8 = getBinding().f18075z;
        CheckedSetting checkedSetting9 = getBinding().f18075z;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.settingsPrivacyStatistics");
        checkedSetting8.m8530h(FormatUtils.m218j(checkedSetting9, C5419R.string.data_privacy_controls_usage_statistics_note, new Object[]{appHelpDesk.m149a(360004109911L, null)}, null, 4), true);
        for (TextView textView3 : Collections2.listOf((Object[]) new TextView[]{getBinding().f18073x, getBinding().f18063n, getBinding().f18070u, getBinding().f18061l})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView3, "header");
            accessibilityUtils.setViewIsHeading(textView3);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96811(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.userSettings.observeIsAccessibilityDetectionAllowed(), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96822(), 62, (Object) null);
    }
}
