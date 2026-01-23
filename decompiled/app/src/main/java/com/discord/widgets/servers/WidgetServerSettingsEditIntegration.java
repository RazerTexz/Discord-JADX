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
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.stateful.StatefulViews;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.servers.WidgetServerSettingsEditRole;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditIntegration extends AppFragment {
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String INTENT_EXTRA_INTEGRATION_ID = "INTENT_EXTRA_INTEGRATION_ID";
    private static final int STATE_KEY_ENABLE_TWITCH_EMOTES = 2131363149;
    private static final int STATE_KEY_EXPIRE_BEHAVIOR = 2131363152;
    private static final int STATE_KEY_GRACE_PERIOD = 2131363153;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private RadioManager expiryBehaviorRadioManager;

    /* JADX INFO: renamed from: expiryBehaviorRadios$delegate, reason: from kotlin metadata */
    private final Lazy expiryBehaviorRadios;
    private RadioManager gracePeriodRadioManager;

    /* JADX INFO: renamed from: gracePeriodRadios$delegate, reason: from kotlin metadata */
    private final Lazy gracePeriodRadios;
    private final StatefulViews state;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsEditIntegration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsEditIntegrationBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int[] gracePeriodDays = {1, 3, 7, 14, 30};

    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(long guildId, long integrationId, Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetServerSettingsEditIntegration.INTENT_EXTRA_INTEGRATION_ID, integrationId);
            AppScreen2.m156d(context, WidgetServerSettingsEditIntegration.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;
        private final ModelGuildIntegration integration;
        private final GuildRole role;

        /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId, long integrationId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11072g = Observable.m11072g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getGuilds().observeRoles(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getGuildIntegrations().get(guildId, integrationId), WidgetServerSettingsEditIntegration2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11072g, "Observable.combineLatest…  }\n          }\n        }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11072g).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, ModelGuildIntegration modelGuildIntegration, GuildRole guildRole) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(modelGuildIntegration, "integration");
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

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelGuildIntegration getIntegration() {
            return this.integration;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final GuildRole getRole() {
            return this.role;
        }

        public final Model copy(Guild guild, ModelGuildIntegration integration, GuildRole role) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(integration, "integration");
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
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.integration, model.integration) && Intrinsics3.areEqual(this.role, model.role);
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
            StringBuilder sbM833U = outline.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", integration=");
            sbM833U.append(this.integration);
            sbM833U.append(", role=");
            sbM833U.append(this.role);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class ViewOnClickListenerC92181 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r5) {
                DimmerView.setDimmed$default(WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f17612b, true, false, 2, null);
            }
        }

        public ViewOnClickListenerC92181(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().syncIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId()), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class ViewOnClickListenerC92192 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC92192(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditRole.Companion companion = WidgetServerSettingsEditRole.INSTANCE;
            long id2 = this.$model.getGuild().getId();
            long id3 = this.$model.getRole().getId();
            Intrinsics3.checkNotNullExpressionValue(view, "v");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "v.context");
            companion.launch(id2, id3, context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class ViewOnClickListenerC92203 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$configureUI$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
                invoke2(r1);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Void r1) {
            }
        }

        public ViewOnClickListenerC92203(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int iM8551b = WidgetServerSettingsEditIntegration.access$getExpiryBehaviorRadioManager$p(WidgetServerSettingsEditIntegration.this).m8551b();
            int i = WidgetServerSettingsEditIntegration.access$getGracePeriodDays$cp()[WidgetServerSettingsEditIntegration.access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration.this).m8551b()];
            CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f17614d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
            Observable observableUi$default = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuildIntegration(this.$model.getGuild().getId(), this.$model.getIntegration().getId(), new RestAPIParams.GuildIntegration(iM8551b, i, checkedSetting.isChecked())), false, 1, null), WidgetServerSettingsEditIntegration.this, null, 2, null);
            Class<?> cls = WidgetServerSettingsEditIntegration.this.getClass();
            Intrinsics3.checkNotNullExpressionValue(view, "view");
            ObservableExtensionsKt.appSubscribe$default(observableUi$default, cls, view.getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, AnonymousClass1.INSTANCE, 60, (Object) null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final class ViewOnClickListenerC92212 implements View.OnClickListener {
        public ViewOnClickListenerC92212() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f17614d.toggle();
            StatefulViews statefulViewsAccess$getState$p = WidgetServerSettingsEditIntegration.access$getState$p(WidgetServerSettingsEditIntegration.this);
            CheckedSetting checkedSetting = WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f17614d;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
            statefulViewsAccess$getState$p.put(C5419R.id.edit_integration_custom_emotes_toggle, Boolean.valueOf(checkedSetting.isChecked()));
            WidgetServerSettingsEditIntegration.access$getState$p(WidgetServerSettingsEditIntegration.this).configureSaveActionView(WidgetServerSettingsEditIntegration.access$getBinding$p(WidgetServerSettingsEditIntegration.this).f17625o);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsEditIntegration$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsEditIntegration.kt */
    public static final /* synthetic */ class C92221 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C92221(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
            super(1, widgetServerSettingsEditIntegration, WidgetServerSettingsEditIntegration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsEditIntegration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsEditIntegration.access$configureUI((WidgetServerSettingsEditIntegration) this.receiver, model);
        }
    }

    public WidgetServerSettingsEditIntegration() {
        super(C5419R.layout.widget_server_settings_edit_integration);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsEditIntegration3.INSTANCE, null, 2, null);
        this.expiryBehaviorRadios = LazyJVM.lazy(new WidgetServerSettingsEditIntegration4(this));
        this.gracePeriodRadios = LazyJVM.lazy(new WidgetServerSettingsEditIntegration5(this));
        this.state = new StatefulViews(C5419R.id.edit_integration_custom_emotes_toggle, C5419R.id.edit_integration_expired_sub_container, C5419R.id.edit_integration_grace_period_container);
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
            Intrinsics3.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ int[] access$getGracePeriodDays$cp() {
        return gracePeriodDays;
    }

    public static final /* synthetic */ RadioManager access$getGracePeriodRadioManager$p(WidgetServerSettingsEditIntegration widgetServerSettingsEditIntegration) {
        RadioManager radioManager = widgetServerSettingsEditIntegration.gracePeriodRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
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
        setActionBarTitle(C5419R.string.integration_settings);
        setActionBarSubtitle(model.getGuild().getName());
        boolean zAreEqual = Intrinsics3.areEqual(model.getIntegration().getType(), "twitch");
        TextView textView = getBinding().f17623m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.editIntegrationName");
        textView.setText(model.getIntegration().getDisplayName());
        TextView textView2 = getBinding().f17624n;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.editIntegrationOwnerName");
        textView2.setText(model.getIntegration().getUser().getUsername());
        getBinding().f17622l.setImageResource(zAreEqual ? C5419R.drawable.asset_account_sync_twitch : C5419R.drawable.asset_account_sync_youtube);
        getBinding().f17626p.f768d.setOnClickListener(new ViewOnClickListenerC92181(model));
        DimmerView.setDimmed$default(getBinding().f17612b, model.getIntegration().isSyncing(), false, 2, null);
        TextView textView3 = getBinding().f17626p.f766b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.syncSettings.editIntegrationLastSyncTime");
        WidgetServerSettingsEditIntegrationBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        CoordinatorLayout coordinatorLayout = binding.f17611a;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout, "binding.root");
        Context context = coordinatorLayout.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.root.context");
        textView3.setText(TimeUtils.toReadableTimeString$default(context, TimeUtils.parseUTCDate(model.getIntegration().getSyncedAt()), null, 4, null));
        TextView textView4 = getBinding().f17626p.f767c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.syncSettings.edi…ntegrationSubscriberCount");
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        WidgetServerSettingsEditIntegrationBinding binding2 = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding2, "binding");
        CoordinatorLayout coordinatorLayout2 = binding2.f17611a;
        Intrinsics3.checkNotNullExpressionValue(coordinatorLayout2, "binding.root");
        Context context2 = coordinatorLayout2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "binding.root.context");
        textView4.setText(FormatUtils.m220l(StringResourceUtils.getQuantityString(resources, context2, zAreEqual ? C5419R.plurals.num_subscribers_subscribers : C5419R.plurals.num_members_subscribers, model.getIntegration().getSubscriberCount(), Integer.valueOf(model.getIntegration().getSubscriberCount())), new Object[0], null, 2));
        getBinding().f17626p.f770f.setOnClickListener(model.getRole() != null ? new ViewOnClickListenerC92192(model) : null);
        TextView textView5 = getBinding().f17626p.f769e;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.syncSettings.editIntegrationSyncedRole");
        textView5.setText(model.getRole() != null ? model.getRole().getName() : "None");
        getBinding().f17626p.f769e.setTextColor(RoleUtils.getOpaqueColor(model.getRole(), ColorCompat.getColor(this, C5419R.color.primary_300)));
        int iIntValue = ((Number) this.state.get(C5419R.id.edit_integration_expired_sub_container, Integer.valueOf(model.getIntegration().getExpireBehavior()))).intValue();
        RadioManager radioManager = this.expiryBehaviorRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("expiryBehaviorRadioManager");
        }
        radioManager.m8550a(getExpiryBehaviorRadios().get(iIntValue));
        int iIntValue2 = ((Number) this.state.get(C5419R.id.edit_integration_grace_period_container, Integer.valueOf(getGracePeriodPosition(model.getIntegration().getExpireGracePeriod())))).intValue();
        RadioManager radioManager2 = this.gracePeriodRadioManager;
        if (radioManager2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("gracePeriodRadioManager");
        }
        radioManager2.m8550a(getGracePeriodRadios().get(iIntValue2));
        LinearLayout linearLayout = getBinding().f17613c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.editIntegrationCustomEmotesContainer");
        linearLayout.setVisibility(zAreEqual ? 0 : 8);
        CheckedSetting checkedSetting = getBinding().f17614d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.editIntegrationCustomEmotesToggle");
        StatefulViews statefulViews = this.state;
        CheckedSetting checkedSetting2 = getBinding().f17614d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.editIntegrationCustomEmotesToggle");
        checkedSetting.setChecked(((Boolean) statefulViews.get(checkedSetting2.getId(), Boolean.valueOf(model.getIntegration().isEnableEmoticons()))).booleanValue());
        this.state.configureSaveActionView(getBinding().f17625o);
        getBinding().f17625o.setOnClickListener(new ViewOnClickListenerC92203(model));
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
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            checkedSetting.m8527e(new WidgetServerSettingsEditIntegration6(checkedSetting, i, this, radioManager, stateKey));
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setRetainInstance(true);
        this.expiryBehaviorRadioManager = setupRadioManager(getExpiryBehaviorRadios(), C5419R.id.edit_integration_expired_sub_container);
        this.gracePeriodRadioManager = setupRadioManager(getGracePeriodRadios(), C5419R.id.edit_integration_grace_period_container);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        this.state.setupUnsavedChangesConfirmation(this);
        List<CheckedSetting> gracePeriodRadios = getGracePeriodRadios();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(gracePeriodRadios, 10));
        int i = 0;
        for (Object obj : gracePeriodRadios) {
            int i2 = i + 1;
            if (i < 0) {
                Collections2.throwIndexOverflow();
            }
            CheckedSetting checkedSetting = (CheckedSetting) obj;
            Resources resources = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources, "resources");
            Context context = checkedSetting.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "radio.context");
            int[] iArr = gracePeriodDays;
            checkedSetting.setText(StringResourceUtils.getQuantityString(resources, context, C5419R.plurals.n_days_days, iArr[i], Integer.valueOf(iArr[i])));
            arrayList.add(Unit.f27425a);
            i = i2;
        }
        getBinding().f17614d.m8527e(new ViewOnClickListenerC92212());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        long longExtra2 = getMostRecentIntent().getLongExtra(INTENT_EXTRA_INTEGRATION_ID, -1L);
        StoreStream.INSTANCE.getGuildIntegrations().onIntegrationScreenOpened(longExtra);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra, longExtra2), this, null, 2, null), WidgetServerSettingsEditIntegration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C92221(this), 62, (Object) null);
    }
}
