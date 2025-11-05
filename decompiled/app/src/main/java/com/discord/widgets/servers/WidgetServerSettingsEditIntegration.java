package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.role.GuildRole;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsEditIntegrationBinding;
import com.discord.models.domain.ModelGuildIntegration;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import d0.g;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsEditIntegration.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration extends AppFragment {
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INTEGRATION_ID = "INTENT_EXTRA_INTEGRATION_ID";
    private static final int STATE_KEY_ENABLE_TWITCH_EMOTES = 2131363149;
    private static final int STATE_KEY_EXPIRE_BEHAVIOR = 2131363152;
    private static final int STATE_KEY_GRACE_PERIOD = 2131363153;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager expiryBehaviorRadioManager;

    /* renamed from: expiryBehaviorRadios$delegate, reason: from kotlin metadata */
    private final Lazy expiryBehaviorRadios;
    private RadioManager gracePeriodRadioManager;

    /* renamed from: gracePeriodRadios$delegate, reason: from kotlin metadata */
    private final Lazy gracePeriodRadios;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsEditIntegration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] gracePeriodDays = {1, 3, 7, 14, 30};

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long integrationId, Context context) {
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditIntegration.INTENT_EXTRA_INTEGRATION_ID, integrationId);
            j.d(context, WidgetServerSettingsEditIntegration.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final ModelGuildIntegration integration;
        private final GuildRole role;

        /* compiled from: WidgetServerSettingsEditIntegration.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long integrationId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableG = Observable.g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuildIntegrations().get(guildId, integrationId), WidgetServerSettingsEditIntegration$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "Observable.combineLatest…  }\n          }\n        }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableG).r();
                m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole) {
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(modelGuildIntegration, "integration");
            this.guild = guild;
            this.integration = modelGuildIntegration;
            this.role = guildRole;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                modelGuildIntegration = model.integration;
            }
            if ((i & 4) != 0) {
                guildRole = model.role;
            }
            return model.copy(guild, modelGuildIntegration, guildRole);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        /* renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final Model copy(Guild guild, ModelGuildIntegration integration, GuildRole role) {
            m.checkNotNullParameter(guild, "guild");
            m.checkNotNullParameter(integration, "integration");
            return new Model(guild, integration, role);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return m.areEqual(this.guild, model.guild) && m.areEqual(this.integration, model.integration) && m.areEqual(this.role, model.role);
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        public final GuildRole getRole() {
            return this.role;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            ModelGuildIntegration modelGuildIntegration = this.integration;
            int iHashCode2 = (iHashCode + (modelGuildIntegration != null ? modelGuildIntegration.hashCode() : 0)) * 31;
            GuildRole guildRole = this.role;
            return iHashCode2 + (guildRole != null ? guildRole.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = a.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(", integration=");
            sbU.append(this.integration);
            sbU.append(", role=");
            sbU.append(this.role);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetServerSettingsEditIntegration.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04271 extends o implements Function1<Void, Unit> {
            public C04271() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r5) {
                DimmerView.setDimmed$default(WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f2560b, true, false, 2, null);
            }
        }

        public AnonymousClass1(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().syncIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId()), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
            m.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C04271(), 60, (Object) null);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public AnonymousClass2(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.Companion companion = WidgetServerSettingsEditRole.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            long id3 = this.$model.getRole().getId();
            m.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            m.checkNotNullExpressionValue(context, "v.context");
            companion.launch(id2, id3, context);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* compiled from: WidgetServerSettingsEditIntegration.kt */
        /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        public AnonymousClass3(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int iB = WidgetServerSettingsEditIntegration.access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration.this).b();
            int i = WidgetServerSettingsEditIntegration.access$getGracePeriodDays$cp()[WidgetServerSettingsEditIntegration.access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration.this).b()];
            CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).d;
            m.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuildIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId(), new RestAPIParams.GuildIntegration(iB, i, checkedSetting.isChecked())), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
            m.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 60, (Object) null);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).d.toggle();
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsEditIntegration.access$getState$p(WidgetServerSettingsEditIntegration.this);
            CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).d;
            m.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
            statefulViewsAccess$getState$p.put(R.id.edit_integration_custom_emotes_toggle, Boolean.valueOf(checkedSetting.isChecked()));
            WidgetServerSettingsEditIntegration.access$getState$p(WidgetServerSettingsEditIntegration.this).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).o);
        }
    }

    /* compiled from: WidgetServerSettingsEditIntegration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
            super(1, widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsEditIntegration.access$configureUI((WidgetServerSettingsEditIntegration) this.receiver, model);
        }
    }

    public WidgetServerSettingsEditIntegration() {
        super(R.layout.widget_server_settings_edit_integration);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsEditIntegration$binding$2.INSTANCE, null, 2, null);
        this.expiryBehaviorRadios = g.lazy(new WidgetServerSettingsEditIntegration$expiryBehaviorRadios$2(this));
        this.gracePeriodRadios = g.lazy(new WidgetServerSettingsEditIntegration$gracePeriodRadios$2(this));
        this.state = new StatefulViews(R.id.edit_integration_custom_emotes_toggle, R.id.edit_integration_expired_sub_container, R.id.edit_integration_grace_period_container);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, Model model) {
        widgetServerSettingsEditIntegration.configureUI(model);
    }

    public static final /* synthetic */ WidgetServerSettingsEditIntegrationBinding access$getBinding$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        return widgetServerSettingsEditIntegration.getBinding();
    }

    public static final /* synthetic */ RadioManager access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.expiryBehaviorRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ int[] access$getGracePeriodDays$cp() {
        return gracePeriodDays;
    }

    public static final /* synthetic */ RadioManager access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.gracePeriodRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ StatefulViews access$getState$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        return widgetServerSettingsEditIntegration.state;
    }

    public static final /* synthetic */ void access$setExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager) {
        widgetServerSettingsEditIntegration.expiryBehaviorRadioManager = radioManager;
    }

    public static final /* synthetic */ void access$setGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration, RadioManager radioManager) {
        widgetServerSettingsEditIntegration.gracePeriodRadioManager = radioManager;
    }

    private final void configureUI(Model model) {
        if (model == null) {
            AppActivity appActivity = getAppActivity();
            if (appActivity != null) {
                appActivity.finish();
                return;
            }
            return;
        }
        setActionBarTitle(R.string.integration_settings);
        setActionBarSubtitle(model.getGuild().getName());
        boolean zAreEqual = m.areEqual(model.getIntegration().getType(), "twitch");
        TextView textView = getBinding().m;
        m.checkNotNullExpressionValue(textView, "binding.editIntegrationName");
        textView.setText(model.getIntegration().getDisplayName());
        TextView textView2 = getBinding().n;
        m.checkNotNullExpressionValue(textView2, "binding.editIntegrationOwnerName");
        textView2.setText(model.getIntegration().getUser().getUsername());
        getBinding().l.setImageResource(zAreEqual ? R.drawable.asset_account_sync_twitch : R.drawable.asset_account_sync_youtube);
        getBinding().p.d.setOnClickListener(new AnonymousClass1(model));
        DimmerView.setDimmed$default(getBinding().f2560b, model.getIntegration().isSyncing(), false, 2, null);
        TextView textView3 = getBinding().p.f96b;
        m.checkNotNullExpressionValue(textView3, "binding.syncSettings.editIntegrationLastSyncTime");
        WidgetServerSettingsEditIntegrationBinding binding = getBinding();
        m.checkNotNullExpressionValue(binding, "binding");
        CoordinatorLayout coordinatorLayout = binding.a;
        m.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        m.checkNotNullExpressionValue(context, "binding.root.context");
        textView3.setText(TimeUtils.toReadableTimeString$default(context, TimeUtils.parseUTCDate(model.getIntegration().getSyncedAt()), null, 4, null));
        TextView textView4 = getBinding().p.c;
        m.checkNotNullExpressionValue(textView4, "binding.syncSettings.edi…ntegrationSubscriberCount");
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        WidgetServerSettingsEditIntegrationBinding binding2 = getBinding();
        m.checkNotNullExpressionValue(binding2, "binding");
        CoordinatorLayout coordinatorLayout2 = binding2.a;
        m.checkNotNullExpressionValue(coordinatorLayout2, "binding.root");
        Context context2 = coordinatorLayout2.getContext();
        m.checkNotNullExpressionValue(context2, "binding.root.context");
        textView4.setText(b.l(StringResourceUtilsKt.getQuantityString(resources, context2, zAreEqual ? R.plurals.num_subscribers_subscribers : R.plurals.num_members_subscribers, model.getIntegration().getSubscriberCount(), Integer.valueOf(model.getIntegration().getSubscriberCount())), new Object[0], null, 2));
        getBinding().p.f.setOnClickListener(model.getRole() != null ? new AnonymousClass2(model) : null);
        TextView textView5 = getBinding().p.e;
        m.checkNotNullExpressionValue(textView5, "binding.syncSettings.editIntegrationSyncedRole");
        textView5.setText(model.getRole() != null ? model.getRole().getName() : "None");
        getBinding().p.e.setTextColor(RoleUtils.getOpaqueColor(model.getRole(), ColorCompat.getColor(this, R.color.primary_300)));
        int iIntValue = ((Number) this.state.get(R.id.edit_integration_expired_sub_container, Integer.valueOf(model.getIntegration().getExpireBehavior()))).intValue();
        RadioManager radioManager = this.expiryBehaviorRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        radioManager.a(getExpiryBehaviorRadios().get(iIntValue));
        int iIntValue2 = ((Number) this.state.get(R.id.edit_integration_grace_period_container, Integer.valueOf(getGracePeriodPosition(model.getIntegration().getExpireGracePeriod())))).intValue();
        RadioManager radioManager2 = this.gracePeriodRadioManager;
        if (radioManager2 == null) {
            m.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        radioManager2.a(getGracePeriodRadios().get(iIntValue2));
        LinearLayout linearLayout = getBinding().c;
        m.checkNotNullExpressionValue(linearLayout, "binding.editIntegrationCustomEmotesContainer");
        linearLayout.setVisibility(zAreEqual ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        StatefulViews statefulViews = this.state;
        CheckedSetting checkedSetting2 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.editIntegrationCustomEmotesToggle");
        checkedSetting.setChecked(((Boolean) statefulViews.get(checkedSetting2.getId(), Boolean.valueOf(model.getIntegration().isEnableEmoticons()))).booleanValue());
        this.state.configureSaveActionView(getBinding().o);
        getBinding().o.setOnClickListener(new AnonymousClass3(model));
    }

    private final WidgetServerSettingsEditIntegrationBinding getBinding() {
        return (WidgetServerSettingsEditIntegrationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExpiryBehaviorRadios() {
        return (List) this.expiryBehaviorRadios.getValue();
    }

    private final int getGracePeriodPosition(int gracePeriodDays2) {
        if (gracePeriodDays2 == 1) {
            return 0;
        }
        if (gracePeriodDays2 == 3) {
            return 1;
        }
        if (gracePeriodDays2 == 7) {
            return 2;
        }
        if (gracePeriodDays2 != 14) {
            return gracePeriodDays2 != 30 ? 0 : 4;
        }
        return 3;
    }

    private final List<CheckedSetting> getGracePeriodRadios() {
        return (List) this.gracePeriodRadios.getValue();
    }

    private final RadioManager setupRadioManager(List<CheckedSetting> checkedSettings, int stateKey) {
        RadioManager radioManager = new RadioManager(checkedSettings);
        int i = 0;
        for (Object obj : checkedSettings) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            checkedSetting.e(new WidgetServerSettingsEditIntegration$setupRadioManager$$inlined$forEachIndexed$lambda$1(checkedSetting, i, this, radioManager, stateKey));
            i = i2;
        }
        return radioManager;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenClosed();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.expiryBehaviorRadioManager = setupRadioManager(getExpiryBehaviorRadios(), R.id.edit_integration_expired_sub_container);
        this.gracePeriodRadioManager = setupRadioManager(getGracePeriodRadios(), R.id.edit_integration_grace_period_container);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        List<CheckedSetting> gracePeriodRadios = getGracePeriodRadios();
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(gracePeriodRadios, 10));
        int i = 0;
        for (Object obj : gracePeriodRadios) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Resources resources = getResources();
            m.checkNotNullExpressionValue(resources, "resources");
            Context context = checkedSetting.getContext();
            m.checkNotNullExpressionValue(context, "radio.context");
            int[] iArr = gracePeriodDays;
            checkedSetting.setText(StringResourceUtilsKt.getQuantityString(resources, context, R.plurals.n_days_days, iArr[i], Integer.valueOf(iArr[i])));
            arrayList.add(Unit.a);
            i = i2;
        }
        getBinding().d.e(new AnonymousClass2());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_INTEGRATION_ID, -1L);
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra, longExtra2), this, null, 2, null), WidgetServerSettingsEditIntegration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
