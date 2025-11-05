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
import b.a.d.f;
import b.a.d.j;
import b.a.i.b6;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsPrivacyBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.Consents;
import com.discord.models.domain.Harvest;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.t.g0;
import d0.t.n;
import d0.t.n0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
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
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func7;

/* compiled from: WidgetSettingsPrivacy.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsPrivacy extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsPrivacy.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", 0)};

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
            m.checkNotNullParameter(context, "context");
            j.e(context, WidgetSettingsPrivacy.class, null, 4);
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
            m.checkNotNullParameter(meUser, "me");
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
            m.checkNotNullParameter(me2, "me");
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
            return m.areEqual(this.me, localState.me) && this.explicitContentFilter == localState.explicitContentFilter && this.defaultRestrictedGuilds == localState.defaultRestrictedGuilds && m.areEqual(this.friendSourceFlags, localState.friendSourceFlags) && m.areEqual(this.contactSyncConnection, localState.contactSyncConnection) && m.areEqual(this.contactSyncExperiment, localState.contactSyncExperiment) && this.userDiscoveryFlags == localState.userDiscoveryFlags;
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
            StringBuilder sbU = a.U("LocalState(me=");
            sbU.append(this.me);
            sbU.append(", explicitContentFilter=");
            sbU.append(this.explicitContentFilter);
            sbU.append(", defaultRestrictedGuilds=");
            sbU.append(this.defaultRestrictedGuilds);
            sbU.append(", friendSourceFlags=");
            sbU.append(this.friendSourceFlags);
            sbU.append(", contactSyncConnection=");
            sbU.append(this.contactSyncConnection);
            sbU.append(", contactSyncExperiment=");
            sbU.append(this.contactSyncExperiment);
            sbU.append(", userDiscoveryFlags=");
            return a.B(sbU, this.userDiscoveryFlags, ")");
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Consents consents;
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
                Observable observableG = companion.getUserConnections().observeConnectedAccounts().G(WidgetSettingsPrivacy$Model$Companion$get$1.INSTANCE);
                Observable<Experiment> observableObserveUserExperiment = companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true);
                Observable<Integer> observableObserveFriendDiscoveryFlags = companion.getUserSettings().observeFriendDiscoveryFlags();
                WidgetSettingsPrivacy$Model$Companion$get$2 widgetSettingsPrivacy$sam$rx_functions_Func7$0 = WidgetSettingsPrivacy$Model$Companion$get$2.INSTANCE;
                if (widgetSettingsPrivacy$sam$rx_functions_Func7$0 != null) {
                    widgetSettingsPrivacy$sam$rx_functions_Func7$0 = new WidgetSettingsPrivacy$sam$rx_functions_Func7$0(widgetSettingsPrivacy$sam$rx_functions_Func7$0);
                }
                Observable observableY = Observable.e(observableObserveMe$default, observableObserveExplicitContentFilter, observableObserveIsDefaultGuildsRestricted, observableObserveFriendSourceFlags, observableG, observableObserveUserExperiment, observableObserveFriendDiscoveryFlags, (Func7) widgetSettingsPrivacy$sam$rx_functions_Func7$0).Y(WidgetSettingsPrivacy$Model$Companion$get$3.INSTANCE);
                m.checkNotNullExpressionValue(observableY, "Observable\n          .co…            }\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                m.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, Consents consents, RestAPI.HarvestState harvestState) {
            m.checkNotNullParameter(meUser, "me");
            m.checkNotNullParameter(consents, "consents");
            this.me = meUser;
            this.explicitContentFilter = i;
            this.defaultRestrictedGuilds = z2;
            this.friendSourceFlags = friendSourceFlags;
            this.userDiscoveryFlags = i2;
            this.contactSyncConnection = connectedAccount;
            this.showContactSync = z3;
            this.consents = consents;
            this.harvestState = harvestState;
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, Consents consents, RestAPI.HarvestState harvestState, int i3, Object obj) {
            return model.copy((i3 & 1) != 0 ? model.me : meUser, (i3 & 2) != 0 ? model.explicitContentFilter : i, (i3 & 4) != 0 ? model.defaultRestrictedGuilds : z2, (i3 & 8) != 0 ? model.friendSourceFlags : friendSourceFlags, (i3 & 16) != 0 ? model.userDiscoveryFlags : i2, (i3 & 32) != 0 ? model.contactSyncConnection : connectedAccount, (i3 & 64) != 0 ? model.showContactSync : z3, (i3 & 128) != 0 ? model.consents : consents, (i3 & 256) != 0 ? model.harvestState : harvestState);
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
        public final Consents getConsents() {
            return this.consents;
        }

        /* renamed from: component9, reason: from getter */
        public final RestAPI.HarvestState getHarvestState() {
            return this.harvestState;
        }

        public final Model copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings.FriendSourceFlags friendSourceFlags, int userDiscoveryFlags, ConnectedAccount contactSyncConnection, boolean showContactSync, Consents consents, RestAPI.HarvestState harvestState) {
            m.checkNotNullParameter(me2, "me");
            m.checkNotNullParameter(consents, "consents");
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
            return m.areEqual(this.me, model.me) && this.explicitContentFilter == model.explicitContentFilter && this.defaultRestrictedGuilds == model.defaultRestrictedGuilds && m.areEqual(this.friendSourceFlags, model.friendSourceFlags) && this.userDiscoveryFlags == model.userDiscoveryFlags && m.areEqual(this.contactSyncConnection, model.contactSyncConnection) && this.showContactSync == model.showContactSync && m.areEqual(this.consents, model.consents) && m.areEqual(this.harvestState, model.harvestState);
        }

        public final Consents getConsents() {
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
            Consents consents = this.consents;
            int iHashCode4 = (i3 + (consents != null ? consents.hashCode() : 0)) * 31;
            RestAPI.HarvestState harvestState = this.harvestState;
            return iHashCode4 + (harvestState != null ? harvestState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(me=");
            sbU.append(this.me);
            sbU.append(", explicitContentFilter=");
            sbU.append(this.explicitContentFilter);
            sbU.append(", defaultRestrictedGuilds=");
            sbU.append(this.defaultRestrictedGuilds);
            sbU.append(", friendSourceFlags=");
            sbU.append(this.friendSourceFlags);
            sbU.append(", userDiscoveryFlags=");
            sbU.append(this.userDiscoveryFlags);
            sbU.append(", contactSyncConnection=");
            sbU.append(this.contactSyncConnection);
            sbU.append(", showContactSync=");
            sbU.append(this.showContactSync);
            sbU.append(", consents=");
            sbU.append(this.consents);
            sbU.append(", harvestState=");
            sbU.append(this.harvestState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04471 extends o implements Function1<Hook, Unit> {

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class C04481 extends o implements Function1<View, Unit> {
                public static final C04481 INSTANCE = new C04481();

                public C04481() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    m.checkNotNullParameter(view, "it");
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    m.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, f.a.a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public C04471() {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetSettingsPrivacy.this.getContext(), R.color.link)), false, null, C04481.INSTANCE, 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("onClick", new C04471());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).c;
            m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            boolean z2 = !checkedSetting.isChecked();
            if (this.$model.getContactSyncConnection() == null) {
                if (z2) {
                    AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location(Traits.Location.Page.USER_SETTINGS, null, null, null, null, 30, null));
                    ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, g0.mapOf(d0.o.to("location_page", Traits.Location.Page.USER_SETTINGS)), 1, null);
                    WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetSettingsPrivacy.this.requireContext(), null, false, false, false, 30, null);
                    return;
                }
                return;
            }
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).e;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            boolean zIsChecked = checkedSetting2.isChecked();
            CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2635b;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            analyticsTracker.contactSyncToggled(z2, zIsChecked, checkedSetting3.isChecked());
            WidgetSettingsPrivacy.access$toggleContactSync(WidgetSettingsPrivacy.this, this.$model.getContactSyncConnection(), z2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).e;
            m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingPhone");
            boolean z2 = !checkedSetting.isChecked();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2635b;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingEmail");
            boolean zIsChecked = checkedSetting2.isChecked();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).c;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEnabled");
            boolean zIsChecked2 = checkedSetting3.isChecked();
            CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2635b;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEmail");
            analyticsTracker.contactSyncToggled(zIsChecked2, z2, checkedSetting4.isChecked());
            WidgetSettingsPrivacy.access$updateFriendDiscoveryFlags(WidgetSettingsPrivacy.this, z2, zIsChecked);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2635b;
            m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEmail");
            boolean z2 = !checkedSetting.isChecked();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).e;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            boolean zIsChecked = checkedSetting2.isChecked();
            AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
            CheckedSetting checkedSetting3 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).c;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEnabled");
            boolean zIsChecked2 = checkedSetting3.isChecked();
            CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).e;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingPhone");
            analyticsTracker.contactSyncToggled(zIsChecked2, checkedSetting4.isChecked(), z2);
            WidgetSettingsPrivacy.access$updateFriendDiscoveryFlags(WidgetSettingsPrivacy.this, zIsChecked, z2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass5(Model model) {
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
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureDefaultGuildsRestricted$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsPrivacy.access$showDefaultGuildsRestrictedExistingServers(WidgetSettingsPrivacy.this, !this.$model.getDefaultRestrictedGuilds());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureExplicitContentRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ int $explicitContentFilter;

        public AnonymousClass1(int i) {
            this.$explicitContentFilter = i;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getUserSettings().setExplicitContentFilter(WidgetSettingsPrivacy.this.getAppActivity(), this.$explicitContentFilter);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureFriendSourceRadio$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            m.checkNotNullExpressionValue(bool, "checked");
            WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 0, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureFriendSourceRadio$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public AnonymousClass2() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            m.checkNotNullExpressionValue(bool, "checked");
            WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 1, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureFriendSourceRadio$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public AnonymousClass3() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            m.checkNotNullExpressionValue(bool, "checked");
            WidgetSettingsPrivacy.access$updateFriendSourceFlags(widgetSettingsPrivacy, 2, bool.booleanValue());
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04491 extends o implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1$1, reason: invalid class name and collision with other inner class name */
            public static final class ViewOnClickListenerC04501 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public ViewOnClickListenerC04501(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2639z;
                    m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                    checkedSetting.setChecked(true);
                    CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2639z;
                    m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
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
                    C04491 c04491 = C04491.this;
                    WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                    Boolean bool = c04491.$consented;
                    m.checkNotNullExpressionValue(bool, "consented");
                    boolean zBooleanValue = bool.booleanValue();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2639z;
                    m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                    WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C04491(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                m.checkNotNullParameter(alertDialog, "dialog");
                m.checkNotNullParameter(textView, "dialogHeader");
                m.checkNotNullParameter(textView2, "dialogBody");
                m.checkNotNullParameter(textView3, "dialogCancel");
                m.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(R.string.usage_statistics_disable_modal_title);
                textView2.setText(R.string.usage_statistics_disable_modal_body);
                textView3.setText(R.string.usage_statistics_disable_modal_cancel);
                textView3.setOnClickListener(new ViewOnClickListenerC04501(alertDialog));
                textView4.setText(R.string.usage_statistics_disable_modal_confirm);
                textView4.setOnClickListener(new AnonymousClass2(alertDialog));
            }
        }

        public AnonymousClass1(Context context) {
            this.$context = context;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2639z;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setEnabled(false);
            m.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.access$confirmConsent(WidgetSettingsPrivacy.this, this.$context, new C04491(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2639z;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
            WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1$1, reason: invalid class name and collision with other inner class name */
            public static final class ViewOnClickListenerC04511 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public ViewOnClickListenerC04511(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).v;
                    m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                    checkedSetting.setChecked(true);
                    CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).v;
                    m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
                    checkedSetting2.setEnabled(true);
                }
            }

            /* compiled from: WidgetSettingsPrivacy.kt */
            /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1$2, reason: invalid class name and collision with other inner class name */
            public static final class ViewOnClickListenerC04522 implements View.OnClickListener {
                public final /* synthetic */ AlertDialog $dialog;

                public ViewOnClickListenerC04522(AlertDialog alertDialog) {
                    this.$dialog = alertDialog;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.$dialog.dismiss();
                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                    WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                    Boolean bool = anonymousClass1.$consented;
                    m.checkNotNullExpressionValue(bool, "consented");
                    boolean zBooleanValue = bool.booleanValue();
                    CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).v;
                    m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
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
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                m.checkNotNullParameter(alertDialog, "dialog");
                m.checkNotNullParameter(textView, "dialogHeader");
                m.checkNotNullParameter(textView2, "dialogBody");
                m.checkNotNullParameter(textView3, "dialogCancel");
                m.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(R.string.personalization_disable_modal_title);
                textView2.setText(R.string.personalization_disable_modal_body);
                textView3.setText(R.string.personalization_disable_modal_cancel);
                textView3.setOnClickListener(new ViewOnClickListenerC04511(alertDialog));
                textView4.setText(R.string.personalization_disable_modal_confirm);
                textView4.setOnClickListener(new ViewOnClickListenerC04522(alertDialog));
            }
        }

        public AnonymousClass2(Context context) {
            this.$context = context;
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).v;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
            checkedSetting.setEnabled(false);
            m.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.access$confirmConsent(WidgetSettingsPrivacy.this, this.$context, new AnonymousClass1(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).v;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            WidgetSettingsPrivacy.access$toggleConsent(widgetSettingsPrivacy, zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureRequestDataButton$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ RestAPI.HarvestState $harvestState;
        public final /* synthetic */ boolean $isMeVerified;

        public AnonymousClass1(boolean z2, RestAPI.HarvestState harvestState) {
            this.$isMeVerified = z2;
            this.$harvestState = harvestState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            RestAPI.HarvestState harvestState;
            Context context = WidgetSettingsPrivacy.this.getContext();
            if (context != null) {
                m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                if (!this.$isMeVerified || (harvestState = this.$harvestState) == null) {
                    b.a.d.m.i(WidgetSettingsPrivacy.this, R.string.data_privacy_controls_request_data_tooltip, 0, 4);
                } else {
                    WidgetSettingsPrivacy.access$onRequestDataClick(WidgetSettingsPrivacy.this, context, harvestState);
                }
            }
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Harvest, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Harvest harvest) {
            invoke2(harvest);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Harvest harvest) {
            m.checkNotNullParameter(harvest, "requestedHarvest");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(R.string.data_privacy_controls_request_data_success_title).setMessage(R.string.data_privacy_controls_request_data_success_body), R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
            WidgetSettingsPrivacy.access$configureRequestDataButton(WidgetSettingsPrivacy.this, true, new RestAPI.HarvestState.LastRequested(harvest));
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<String, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        public static /* synthetic */ void invoke$default(AnonymousClass2 anonymousClass2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            anonymousClass2.invoke2(str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v5, types: [java.lang.CharSequence] */
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetNoticeDialog.Builder title = new WidgetNoticeDialog.Builder(this.$context).setTitle(R.string.data_privacy_controls_request_data_failure_title);
            String strH = str;
            if (str == null) {
                strH = b.h(this.$context, R.string.data_privacy_controls_request_data_failure_body, new Object[0], null, 4);
            }
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(title.setMessage(strH), R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass2 $handleRequestError$2;
        public final /* synthetic */ AnonymousClass1 $handleRequestSuccess$1;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
            public AnonymousClass1() {
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
                AnonymousClass2 anonymousClass2 = AnonymousClass3.this.$handleRequestError$2;
                Error.Response response = error.getResponse();
                m.checkNotNullExpressionValue(response, "it.response");
                anonymousClass2.invoke2(response.getMessage());
                error.setShowErrorToasts(false);
            }
        }

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$2, reason: invalid class name */
        public static final class AnonymousClass2 extends o implements Function1<Harvest, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Harvest harvest) {
                invoke2(harvest);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Harvest harvest) {
                if (harvest != null) {
                    AnonymousClass3.this.$handleRequestSuccess$1.invoke2(harvest);
                } else {
                    AnonymousClass2.invoke$default(AnonymousClass3.this.$handleRequestError$2, null, 1, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, AnonymousClass2 anonymousClass2, AnonymousClass1 anonymousClass1) {
            super(0);
            this.$context = context;
            this.$handleRequestError$2 = anonymousClass2;
            this.$handleRequestSuccess$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().requestHarvest(), false)), WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).g, 100L), WidgetSettingsPrivacy.this.getClass(), this.$context, (Function1) null, new AnonymousClass1(), (Function0) null, (Function0) null, new AnonymousClass2(), 52, (Object) null);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass3 $requestHarvest$3;

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
                AnonymousClass4.this.$requestHarvest$3.invoke2();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context, AnonymousClass3 anonymousClass3) {
            super(0);
            this.$context = context;
            this.$requestHarvest$3 = anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(R.string.data_privacy_controls_request_data_download).setMessage(R.string.data_privacy_controls_request_data_modal_note).setPositiveButton(R.string.okay, new AnonymousClass1()), R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<RenderContext, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* compiled from: WidgetSettingsPrivacy.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                m.checkNotNullParameter(view, "it");
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context context = view.getContext();
                m.checkNotNullExpressionValue(context, "it.context");
                UriHandler.handle$default(uriHandler, context, f.a.a(360004066391L, null), false, false, null, 28, null);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
            m.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "it.context");
            WidgetSettingsAccount.Companion.launch$default(companion, context, true, null, 4, null);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ String $dataRequestArticleUrl;

        public AnonymousClass4(String str) {
            this.$dataRequestArticleUrl = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            UriHandler.handle$default(UriHandler.INSTANCE, a.x(view, "it", "it.context"), this.$dataRequestArticleUrl, false, false, null, 28, null);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSettingsPrivacy widgetSettingsPrivacy) {
            super(1, widgetSettingsPrivacy, WidgetSettingsPrivacy.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "p1");
            WidgetSettingsPrivacy.access$configureUI((WidgetSettingsPrivacy) this.receiver, model);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.access$getBinding$p(WidgetSettingsPrivacy.this).f2638y;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyScreenreaderDetection");
            checkedSetting.setChecked(z2);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$toggleConsent$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
        public final /* synthetic */ CheckedSetting $toggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CheckedSetting checkedSetting) {
            super(1);
            this.$toggle = checkedSetting;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            this.$toggle.setEnabled(true);
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$toggleConsent$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements Action1<Error> {
        public final /* synthetic */ boolean $consented;
        public final /* synthetic */ CheckedSetting $toggle;

        public AnonymousClass2(CheckedSetting checkedSetting, boolean z2) {
            this.$toggle = checkedSetting;
            this.$consented = z2;
        }

        @Override // rx.functions.Action1
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
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$updateDefaultGuildsRestricted$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements j0.k.b<Map<Long, ? extends Guild>, Set<? extends Long>> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
            return call2((Map<Long, Guild>) map);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Set<Long> call2(Map<Long, Guild> map) {
            return map.keySet();
        }
    }

    /* compiled from: WidgetSettingsPrivacy.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<Set<? extends Long>, Unit> {
        public final /* synthetic */ boolean $defaultGuildsRestricted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2) {
            super(1);
            this.$defaultGuildsRestricted = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            StoreStream.INSTANCE.getUserSettings().setDefaultGuildsRestricted(WidgetSettingsPrivacy.this.getAppActivity(), this.$defaultGuildsRestricted, set);
        }
    }

    public WidgetSettingsPrivacy() {
        super(R.layout.widget_settings_privacy);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsPrivacy$binding$2.INSTANCE, null, 2, null);
        this.explicitContentRadios = g.lazy(new WidgetSettingsPrivacy$explicitContentRadios$2(this));
        this.friendSourceRadios = g.lazy(new WidgetSettingsPrivacy$friendSourceRadios$2(this));
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
        LinearLayout linearLayout = getBinding().j;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyContactSync");
        linearLayout.setVisibility(model.getShowContactSync() ? 0 : 8);
        if (model.getShowContactSync()) {
            TextView textView = getBinding().d;
            m.checkNotNullExpressionValue(textView, "binding.contactSyncSettingInfo");
            b.m(textView, R.string.contact_sync_info_settings_2, new Object[0], new AnonymousClass1());
            TextView textView2 = getBinding().d;
            m.checkNotNullExpressionValue(textView2, "binding.contactSyncSettingInfo");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            CheckedSetting checkedSetting = getBinding().c;
            m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
            checkedSetting.setChecked(contactSyncConnection != null && contactSyncConnection.getFriendSync());
            CheckedSetting checkedSetting2 = getBinding().e;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            checkedSetting2.setChecked((model.getUserDiscoveryFlags() & 2) == 2);
            CheckedSetting checkedSetting3 = getBinding().f2635b;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            checkedSetting3.setChecked((model.getUserDiscoveryFlags() & 4) == 4);
            getBinding().c.e(new AnonymousClass2(model));
            getBinding().e.e(new AnonymousClass3());
            getBinding().f2635b.e(new AnonymousClass4());
            CheckedSetting checkedSetting4 = getBinding().f;
            m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingStaffOnly");
            checkedSetting4.setVisibility(UserUtils.INSTANCE.isStaff(model.getMe()) ? 0 : 8);
            CheckedSetting checkedSetting5 = getBinding().f;
            m.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingStaffOnly");
            checkedSetting5.setChecked(true);
            getBinding().f.e(new AnonymousClass5(model));
        }
    }

    private final void configureDefaultGuildsRestricted(Model model) {
        CheckedSetting checkedSetting = getBinding().m;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyDefaultRestrictedGuilds");
        checkedSetting.setChecked(!model.getDefaultRestrictedGuilds());
        getBinding().m.e(new AnonymousClass1(model));
    }

    private final void configureExplicitContentRadio(Model model, CheckedSetting radio, int explicitContentFilter) {
        RadioManager radioManager;
        radio.e(new AnonymousClass1(explicitContentFilter));
        if (this.radioManagerExplicit == null || model.getExplicitContentFilter() != explicitContentFilter || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureFriendSourceRadio(Model model) {
        getFriendSourceRadios().get(0).setOnCheckedListener(new AnonymousClass1());
        getFriendSourceRadios().get(1).setOnCheckedListener(new AnonymousClass2());
        getFriendSourceRadios().get(2).setOnCheckedListener(new AnonymousClass3());
        ModelUserSettings.FriendSourceFlags friendSourceFlags = model.getFriendSourceFlags();
        boolean zIsAll = friendSourceFlags != null ? friendSourceFlags.isAll() : false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        m.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        checkedSetting.setChecked(zIsAll);
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        m.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        CheckedSetting checkedSetting3 = checkedSetting2;
        ModelUserSettings.FriendSourceFlags friendSourceFlags2 = model.getFriendSourceFlags();
        checkedSetting3.setChecked((friendSourceFlags2 != null ? friendSourceFlags2.isMutualFriends() : false) || zIsAll);
        CheckedSetting checkedSetting4 = getFriendSourceRadios().get(2);
        m.checkNotNullExpressionValue(checkedSetting4, "friendSourceRadios[2]");
        CheckedSetting checkedSetting5 = checkedSetting4;
        ModelUserSettings.FriendSourceFlags friendSourceFlags3 = model.getFriendSourceFlags();
        checkedSetting5.setChecked((friendSourceFlags3 != null ? friendSourceFlags3.isMutualGuilds() : false) || zIsAll);
    }

    private final void configurePrivacyControls(Model model) {
        Context context = getContext();
        if (context != null) {
            m.checkNotNullExpressionValue(context, "context ?: return");
            LinearLayout linearLayout = getBinding().k;
            m.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyControls");
            linearLayout.setVisibility(0);
            CheckedSetting checkedSetting = getBinding().f2639z;
            m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setChecked(model.getConsents().getUsageStatistics().getConsented());
            getBinding().f2639z.setOnCheckedListener(new AnonymousClass1(context));
            CheckedSetting checkedSetting2 = getBinding().v;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            checkedSetting2.setChecked(model.getConsents().getPersonalization().getConsented());
            getBinding().v.setOnCheckedListener(new AnonymousClass2(context));
        }
    }

    private final void configureRequestDataButton(boolean isMeVerified, RestAPI.HarvestState harvestState) {
        getBinding().w.setOnClickListener(new AnonymousClass1(isMeVerified, harvestState));
    }

    private final void configureUI(Model model) {
        configureDefaultGuildsRestricted(model);
        configureFriendSourceRadio(model);
        configureContactSyncOptions(model);
        CheckedSetting checkedSetting = getExplicitContentRadios().get(0);
        m.checkNotNullExpressionValue(checkedSetting, "explicitContentRadios[0]");
        configureExplicitContentRadio(model, checkedSetting, 0);
        CheckedSetting checkedSetting2 = getExplicitContentRadios().get(1);
        m.checkNotNullExpressionValue(checkedSetting2, "explicitContentRadios[1]");
        configureExplicitContentRadio(model, checkedSetting2, 1);
        CheckedSetting checkedSetting3 = getExplicitContentRadios().get(2);
        m.checkNotNullExpressionValue(checkedSetting3, "explicitContentRadios[2]");
        configureExplicitContentRadio(model, checkedSetting3, 2);
        configurePrivacyControls(model);
        configureRequestDataButton(model.getMe().isVerified(), model.getHarvestState());
    }

    private final void confirmConsent(Context context, Function5<? super AlertDialog, ? super TextView, ? super TextView, ? super TextView, ? super TextView, Unit> function5) {
        ViewDialogConfirmationBinding viewDialogConfirmationBindingA = ViewDialogConfirmationBinding.a(getLayoutInflater().inflate(R.layout.view_dialog_confirmation, (ViewGroup) null, false));
        m.checkNotNullExpressionValue(viewDialogConfirmationBindingA, "ViewDialogConfirmationBi…outInflater, null, false)");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(viewDialogConfirmationBindingA.a).setCancelable(false).create();
        m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(this…(false)\n        .create()");
        TextView textView = viewDialogConfirmationBindingA.d;
        m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        TextView textView2 = viewDialogConfirmationBindingA.e;
        m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        MaterialButton materialButton = viewDialogConfirmationBindingA.f2185b;
        m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
        MaterialButton materialButton2 = viewDialogConfirmationBindingA.c;
        m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
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
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(context, new AnonymousClass3(context, new AnonymousClass2(context), new AnonymousClass1(context)));
        if (harvestState instanceof RestAPI.HarvestState.NeverRequested) {
            anonymousClass4.invoke2();
            return;
        }
        if (harvestState instanceof RestAPI.HarvestState.LastRequested) {
            Harvest data = ((RestAPI.HarvestState.LastRequested) harvestState).getData();
            if (Harvest.canRequest$default(data, 0L, 1, null)) {
                anonymousClass4.invoke2();
            } else {
                showNextAvailableRequestAlert(data.nextAvailableRequestInMillis());
            }
        }
    }

    private final void showDefaultGuildsRestrictedExistingServers(boolean defaultGuildsRestricted) {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_settings_privacy_defaults, (ViewGroup) null, false);
        int i = R.id.settings_privacy_defaults_existing_no;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.settings_privacy_defaults_existing_no);
        if (materialButton != null) {
            i = R.id.settings_privacy_defaults_existing_yes;
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.settings_privacy_defaults_existing_yes);
            if (materialButton2 != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                m.checkNotNullExpressionValue(new b6(linearLayout, materialButton, materialButton2), "WidgetSettingsPrivacyDef…outInflater, null, false)");
                materialButton.setOnClickListener(new WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$1(this, defaultGuildsRestricted));
                materialButton2.setOnClickListener(new WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$2(this, defaultGuildsRestricted));
                AlertDialog alertDialog = this.dialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                m.checkNotNullExpressionValue(linearLayout, "binding.root");
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
            m.checkNotNullExpressionValue(context, "context ?: return");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(context).setTitle(R.string.data_privacy_rate_limit_title).setMessage(b.h(context, R.string.data_download_requested_status_note, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, nextAvailableRequestMillis, context, 0, 4, null)}, null, 4)), R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    private final void toggleConsent(boolean consented, String consentType, CheckedSetting toggle) {
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().setConsent(consented, consentType), this, null, 2, null), getBinding().g, 100L).k(b.a.d.o.a.g(getContext(), new AnonymousClass1(toggle), new AnonymousClass2(toggle, consented)));
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
        Observable observableZ = (!applyToExistingGuilds ? new j0.l.e.k(null) : !defaultGuildsRestricted ? new j0.l.e.k(n0.emptySet()) : StoreStream.INSTANCE.getGuilds().observeGuilds().G(AnonymousClass1.INSTANCE)).Z(1);
        m.checkNotNullExpressionValue(observableZ, "when {\n      !applyToExi… }\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableZ), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(defaultGuildsRestricted), 62, (Object) null);
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
        m.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        boolean zIsChecked = checkedSetting.isChecked();
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        m.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        boolean zIsChecked2 = checkedSetting2.isChecked();
        CheckedSetting checkedSetting3 = getFriendSourceRadios().get(2);
        m.checkNotNullExpressionValue(checkedSetting3, "friendSourceRadios[2]");
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
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.privacy_and_safety);
        this.radioManagerExplicit = new RadioManager(getExplicitContentRadios());
        CheckedSetting checkedSetting = getBinding().v;
        CheckedSetting checkedSetting2 = getBinding().v;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        f fVar = f.a;
        checkedSetting.h(b.j(checkedSetting2, R.string.data_privacy_controls_personalization_note_learn_more, new Object[]{fVar.a(360004109911L, null)}, null, 4), true);
        CheckedSetting checkedSetting3 = getBinding().f2638y;
        CheckedSetting checkedSetting4 = getBinding().f2638y;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsPrivacyScreenreaderDetection");
        checkedSetting3.h(b.j(checkedSetting4, R.string.data_privacy_controls_allow_accessibility_detection_note, new Object[]{fVar.a(360035966492L, null)}, null, 4), true);
        CheckedSetting checkedSetting5 = getBinding().f2638y;
        checkedSetting5.setOnCheckedListener(new WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1(checkedSetting5, this));
        getBinding().i.setButtonVisibility(false);
        CheckedSetting checkedSetting6 = getBinding().i;
        CheckedSetting checkedSetting7 = getBinding().i;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsPrivacyBasicService");
        checkedSetting6.h(b.d(checkedSetting7, R.string.data_privacy_controls_basic_service_note, new Object[0], AnonymousClass2.INSTANCE), true);
        getBinding().i.e(AnonymousClass3.INSTANCE);
        String strA = fVar.a(360004027692L, null);
        TextView textView = getBinding().h;
        m.checkNotNullExpressionValue(textView, "binding.requestDataLink");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        TextView textView2 = getBinding().h;
        m.checkNotNullExpressionValue(textView2, "binding.requestDataLink");
        sb.append(b.j(textView2, R.string.notice_whats_this, new Object[0], null, 4));
        sb.append("](");
        sb.append(strA);
        sb.append(')');
        textView.setText(b.l(sb.toString(), new Object[0], null, 2));
        getBinding().h.setOnClickListener(new AnonymousClass4(strA));
        CheckedSetting checkedSetting8 = getBinding().f2639z;
        CheckedSetting checkedSetting9 = getBinding().f2639z;
        m.checkNotNullExpressionValue(checkedSetting9, "binding.settingsPrivacyStatistics");
        checkedSetting8.h(b.j(checkedSetting9, R.string.data_privacy_controls_usage_statistics_note, new Object[]{fVar.a(360004109911L, null)}, null, 4), true);
        for (TextView textView3 : n.listOf((Object[]) new TextView[]{getBinding().f2637x, getBinding().n, getBinding().u, getBinding().l})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView3, "header");
            accessibilityUtils.setViewIsHeading(textView3);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(this.userSettings.observeIsAccessibilityDetectionAllowed(), this, null, 2, null), WidgetSettingsPrivacy.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
