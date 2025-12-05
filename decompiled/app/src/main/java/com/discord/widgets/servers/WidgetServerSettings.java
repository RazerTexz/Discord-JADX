package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsBinding;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionsContexts;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import com.discord.widgets.servers.WidgetServerDeleteDialog;
import com.discord.widgets.servers.WidgetServerSettingsOverview;
import com.discord.widgets.servers.auditlog.WidgetServerSettingsAuditLog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptions;
import com.discord.widgets.servers.guild_role_subscription.payments.WidgetServerSettingsGuildRoleSubscriptionEarnings;
import com.discord.widgets.servers.settings.invites.WidgetServerSettingsInstantInvites;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembers;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.functions.Action2;

/* compiled from: WidgetServerSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettings extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettings.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private long guildId;
    private final AppLogger2 loggingConfig;

    /* compiled from: WidgetServerSettings.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m156d(context, WidgetServerSettings.class, new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final boolean canManageGuildRoleSubscriptions;
        private final Guild guild;
        private final boolean hasGuildRoleSubscriptions;
        private final PermissionsContexts manageGuildContext;

        /* compiled from: WidgetServerSettings.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11071f = Observable.m11071f(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), companion.getChannels().observeChannelCategories(guildId), companion.getPermissions().observeChannelPermissionsForGuild(guildId), GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().observeCanGuildSeeGuildRoleSubscriptionsSettings(guildId), WidgetServerSettings2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11071f, "Observable\n          .co…            )\n          }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11071f).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild, PermissionsContexts permissionsContexts, boolean z2, boolean z3) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(permissionsContexts, "manageGuildContext");
            this.guild = guild;
            this.manageGuildContext = permissionsContexts;
            this.canManageGuildRoleSubscriptions = z2;
            this.hasGuildRoleSubscriptions = z3;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, PermissionsContexts permissionsContexts, boolean z2, boolean z3, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            if ((i & 2) != 0) {
                permissionsContexts = model.manageGuildContext;
            }
            if ((i & 4) != 0) {
                z2 = model.canManageGuildRoleSubscriptions;
            }
            if ((i & 8) != 0) {
                z3 = model.hasGuildRoleSubscriptions;
            }
            return model.copy(guild, permissionsContexts, z2, z3);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* renamed from: component2, reason: from getter */
        public final PermissionsContexts getManageGuildContext() {
            return this.manageGuildContext;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getCanManageGuildRoleSubscriptions() {
            return this.canManageGuildRoleSubscriptions;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getHasGuildRoleSubscriptions() {
            return this.hasGuildRoleSubscriptions;
        }

        public final Model copy(Guild guild, PermissionsContexts manageGuildContext, boolean canManageGuildRoleSubscriptions, boolean hasGuildRoleSubscriptions) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            Intrinsics3.checkNotNullParameter(manageGuildContext, "manageGuildContext");
            return new Model(guild, manageGuildContext, canManageGuildRoleSubscriptions, hasGuildRoleSubscriptions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.guild, model.guild) && Intrinsics3.areEqual(this.manageGuildContext, model.manageGuildContext) && this.canManageGuildRoleSubscriptions == model.canManageGuildRoleSubscriptions && this.hasGuildRoleSubscriptions == model.hasGuildRoleSubscriptions;
        }

        public final boolean getCanManageGuildRoleSubscriptions() {
            return this.canManageGuildRoleSubscriptions;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final boolean getHasGuildRoleSubscriptions() {
            return this.hasGuildRoleSubscriptions;
        }

        public final PermissionsContexts getManageGuildContext() {
            return this.manageGuildContext;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            PermissionsContexts permissionsContexts = this.manageGuildContext;
            int iHashCode2 = (iHashCode + (permissionsContexts != null ? permissionsContexts.hashCode() : 0)) * 31;
            boolean z2 = this.canManageGuildRoleSubscriptions;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode2 + i) * 31;
            boolean z3 = this.hasGuildRoleSubscriptions;
            return i2 + (z3 ? 1 : z3 ? 1 : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", manageGuildContext=");
            sbM833U.append(this.manageGuildContext);
            sbM833U.append(", canManageGuildRoleSubscriptions=");
            sbM833U.append(this.canManageGuildRoleSubscriptions);
            sbM833U.append(", hasGuildRoleSubscriptions=");
            return outline.m827O(sbM833U, this.hasGuildRoleSubscriptions, ")");
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureToolbar$1 */
    public static final class C91701<T1, T2> implements Action2<MenuItem, Context> {
        public final /* synthetic */ Guild $guild;

        public C91701(Guild guild) {
            this.$guild = guild;
        }

        @Override // p658rx.functions.Action2
        public /* bridge */ /* synthetic */ void call(MenuItem menuItem, Context context) {
            call2(menuItem, context);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(MenuItem menuItem, Context context) {
            Intrinsics3.checkNotNullExpressionValue(menuItem, "menuItem");
            if (menuItem.getItemId() != C5419R.id.menu_server_settings_delete) {
                return;
            }
            WidgetServerDeleteDialog.Companion companion = WidgetServerDeleteDialog.INSTANCE;
            FragmentManager parentFragmentManager = WidgetServerSettings.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$guild.getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$1 */
    public static final class ViewOnClickListenerC91711 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91711(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsOverview.Companion.create$default(WidgetServerSettingsOverview.INSTANCE, outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId(), false, 4, null);
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$10 */
    public static final class ViewOnClickListenerC917210 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917210(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsMembers.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$11 */
    public static final class ViewOnClickListenerC917311 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917311(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsRoles.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$12 */
    public static final class ViewOnClickListenerC917412 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917412(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsInstantInvites.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$13 */
    public static final class ViewOnClickListenerC917513 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917513(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsBans.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$14 */
    public static final class ViewOnClickListenerC917614 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917614(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEmojis.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$15 */
    public static final class ViewOnClickListenerC917715 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917715(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            if (this.$model.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
            } else {
                WidgetServerSettingsCreatorMonetizationOnboarding.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
            }
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$16 */
    public static final class ViewOnClickListenerC917816 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917816(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptions.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$17 */
    public static final class ViewOnClickListenerC917917 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC917917(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptionTierList.INSTANCE.launch(WidgetServerSettings.this.requireContext(), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$18 */
    public static final class ViewOnClickListenerC918018 implements View.OnClickListener {
        public ViewOnClickListenerC918018() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsGuildRoleSubscriptionEarnings.INSTANCE.launch(WidgetServerSettings.this.requireContext());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$2 */
    public static final class ViewOnClickListenerC91812 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91812(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.INSTANCE.launch(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$3 */
    public static final class ViewOnClickListenerC91823 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91823(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsAuditLog.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId(), this.$model.getGuild().getName());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$4 */
    public static final class ViewOnClickListenerC91834 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91834(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsChannels.INSTANCE.show(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$5 */
    public static final class ViewOnClickListenerC91845 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91845(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsSecurity.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$6 */
    public static final class ViewOnClickListenerC91856 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91856(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsIntegrations.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$7 */
    public static final class ViewOnClickListenerC91867 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91867(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsVanityUrl.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$8 */
    public static final class ViewOnClickListenerC91878 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91878(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsCommunityOverview.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$configureUI$9 */
    public static final class ViewOnClickListenerC91889 implements View.OnClickListener {
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC91889(Model model) {
            this.$model = model;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsEnableCommunitySteps.INSTANCE.create(outline.m885x(view, "v", "v.context"), this.$model.getGuild().getId());
        }
    }

    /* compiled from: WidgetServerSettings.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettings$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C91891 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C91891(WidgetServerSettings widgetServerSettings) {
            super(1, widgetServerSettings, WidgetServerSettings.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettings$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettings.access$configureUI((WidgetServerSettings) this.receiver, model);
        }
    }

    public WidgetServerSettings() {
        super(C5419R.layout.widget_server_settings);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettings3.INSTANCE, null, 2, null);
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettings4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettings widgetServerSettings, Model model) {
        widgetServerSettings.configureUI(model);
    }

    private final void configureSectionsVisibility() {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5 = true;
        List<TextView> listListOf = Collections2.listOf((Object[]) new TextView[]{getBinding().f17554p, getBinding().f17551m, getBinding().f17552n, getBinding().f17555q, getBinding().f17556r, getBinding().f17550l, getBinding().f17542d});
        List<TextView> listListOf2 = Collections2.listOf((Object[]) new TextView[]{getBinding().f17549k, getBinding().f17557s, getBinding().f17548j, getBinding().f17540b});
        List<TextView> listListOf3 = Collections2.listOf((Object[]) new TextView[]{getBinding().f17546h, getBinding().f17544f, getBinding().f17547i, getBinding().f17545g});
        LinearLayout linearLayout = getBinding().f17559u;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionGeneralSettings");
        boolean z6 = listListOf instanceof Collection;
        if (z6 && listListOf.isEmpty()) {
            z2 = false;
        } else {
            for (TextView textView : listListOf) {
                Intrinsics3.checkNotNullExpressionValue(textView, "view");
                if (textView.getVisibility() == 0) {
                    z2 = true;
                    break;
                }
            }
            z2 = false;
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        View view = getBinding().f17562x;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.serverSettingsSectionUserManagementDivider");
        if (z6 && listListOf.isEmpty()) {
            z3 = false;
        } else {
            for (TextView textView2 : listListOf) {
                Intrinsics3.checkNotNullExpressionValue(textView2, "view");
                if (textView2.getVisibility() == 0) {
                    z3 = true;
                    break;
                }
            }
            z3 = false;
        }
        view.setVisibility(z3 ? 0 : 8);
        LinearLayout linearLayout2 = getBinding().f17561w;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.serverSettingsSectionUserManagement");
        if ((listListOf2 instanceof Collection) && listListOf2.isEmpty()) {
            z4 = false;
        } else {
            for (TextView textView3 : listListOf2) {
                Intrinsics3.checkNotNullExpressionValue(textView3, "view");
                if (textView3.getVisibility() == 0) {
                    z4 = true;
                    break;
                }
            }
            z4 = false;
        }
        linearLayout2.setVisibility(z4 ? 0 : 8);
        LinearLayout linearLayout3 = getBinding().f17560v;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.serverSettingsSectionServerMonetization");
        if ((listListOf3 instanceof Collection) && listListOf3.isEmpty()) {
            z5 = false;
        } else {
            for (TextView textView4 : listListOf3) {
                Intrinsics3.checkNotNullExpressionValue(textView4, "view");
                if (textView4.getVisibility() == 0) {
                    break;
                }
            }
            z5 = false;
        }
        linearLayout3.setVisibility(z5 ? 0 : 8);
    }

    private final void configureToolbar(Model model) {
        Guild guild = model.getGuild();
        String forGuild$default = IconUtils.getForGuild$default(guild, null, true, null, 10, null);
        TextView textView = getBinding().f17538A;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsServerName");
        textView.setText(guild.getName());
        SimpleDraweeView simpleDraweeView = getBinding().f17563y;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.serverSettingsServerIcon");
        IconUtils.setIcon$default(simpleDraweeView, forGuild$default, C5419R.dimen.avatar_size_large, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
        TextView textView2 = getBinding().f17564z;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsServerIconText");
        textView2.setVisibility(forGuild$default == null ? 0 : 8);
        TextView textView3 = getBinding().f17564z;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsServerIconText");
        textView3.setText(guild.getShortName());
        AppFragment.setActionBarOptionsMenu$default(this, model.getManageGuildContext().isOwnerWithRequiredMFALevel() ? C5419R.menu.menu_server_settings : C5419R.menu.menu_empty, new C91701(guild), null, 4, null);
    }

    private final void configureUI(Model model) {
        if (model == null || !model.getManageGuildContext().canManage()) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        configureToolbar(model);
        PermissionsContexts manageGuildContext = model.getManageGuildContext();
        TextView textView = getBinding().f17554p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsOptionOverview");
        textView.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17554p.setOnClickListener(new ViewOnClickListenerC91711(model));
        TextView textView2 = getBinding().f17553o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsOptionModeration");
        textView2.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17553o.setOnClickListener(new ViewOnClickListenerC91812(model));
        TextView textView3 = getBinding().f17550l;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.serverSettingsOptionAuditLog");
        textView3.setVisibility(manageGuildContext.getCanViewAuditLogs() ? 0 : 8);
        getBinding().f17550l.setOnClickListener(new ViewOnClickListenerC91823(model));
        TextView textView4 = getBinding().f17551m;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.serverSettingsOptionChannels");
        textView4.setVisibility(manageGuildContext.getCanManageChannels() ? 0 : 8);
        getBinding().f17551m.setOnClickListener(new ViewOnClickListenerC91834(model));
        TextView textView5 = getBinding().f17555q;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.serverSettingsOptionSecurity");
        textView5.setVisibility(manageGuildContext.isOwnerWithRequiredMFALevel() ? 0 : 8);
        getBinding().f17555q.setOnClickListener(new ViewOnClickListenerC91845(model));
        TextView textView6 = getBinding().f17552n;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.serverSettingsOptionIntegrations");
        textView6.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17552n.setOnClickListener(new ViewOnClickListenerC91856(model));
        TextView textView7 = getBinding().f17556r;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.serverSettingsOptionVanityUrl");
        textView7.setVisibility(manageGuildContext.getCanManageServer() && model.getGuild().getFeatures().contains(GuildFeature.VANITY_URL) ? 0 : 8);
        getBinding().f17556r.setOnClickListener(new ViewOnClickListenerC91867(model));
        LinearLayout linearLayout = getBinding().f17558t;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.serverSettingsSectionCommunity");
        linearLayout.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        TextView textView8 = getBinding().f17541c;
        Intrinsics3.checkNotNullExpressionValue(textView8, "binding.serverSettingsCommunityOverviewOption");
        Set<GuildFeature> features = model.getGuild().getFeatures();
        GuildFeature guildFeature = GuildFeature.COMMUNITY;
        textView8.setVisibility(features.contains(guildFeature) ? 0 : 8);
        getBinding().f17541c.setOnClickListener(new ViewOnClickListenerC91878(model));
        TextView textView9 = getBinding().f17543e;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.serverSettingsEnableCommunityOption");
        textView9.setVisibility(model.getGuild().getFeatures().contains(guildFeature) ^ true ? 0 : 8);
        getBinding().f17543e.setOnClickListener(new ViewOnClickListenerC91889(model));
        getBinding().f17549k.setOnClickListener(new ViewOnClickListenerC917210(model));
        TextView textView10 = getBinding().f17557s;
        Intrinsics3.checkNotNullExpressionValue(textView10, "binding.serverSettingsRolesOption");
        textView10.setVisibility(manageGuildContext.getCanManageRoles() ? 0 : 8);
        getBinding().f17557s.setOnClickListener(new ViewOnClickListenerC917311(model));
        TextView textView11 = getBinding().f17548j;
        Intrinsics3.checkNotNullExpressionValue(textView11, "binding.serverSettingsInstantInvitesOption");
        textView11.setVisibility(manageGuildContext.getCanManageServer() ? 0 : 8);
        getBinding().f17548j.setOnClickListener(new ViewOnClickListenerC917412(model));
        TextView textView12 = getBinding().f17540b;
        Intrinsics3.checkNotNullExpressionValue(textView12, "binding.serverSettingsBansOption");
        textView12.setVisibility(manageGuildContext.getCanManageBans() ? 0 : 8);
        getBinding().f17540b.setOnClickListener(new ViewOnClickListenerC917513(model));
        TextView textView13 = getBinding().f17542d;
        Intrinsics3.checkNotNullExpressionValue(textView13, "binding.serverSettingsEmojisOption");
        textView13.setVisibility(manageGuildContext.getCanManageEmojisAndStickers() ? 0 : 8);
        getBinding().f17542d.setOnClickListener(new ViewOnClickListenerC917614(model));
        TextView textView14 = getBinding().f17546h;
        Intrinsics3.checkNotNullExpressionValue(textView14, "binding.serverSettingsGu…oleSubscriptionGetStarted");
        textView14.setVisibility(model.getCanManageGuildRoleSubscriptions() && !model.getHasGuildRoleSubscriptions() ? 0 : 8);
        getBinding().f17546h.setOnClickListener(new ViewOnClickListenerC917715(model));
        boolean z2 = model.getCanManageGuildRoleSubscriptions() && model.getHasGuildRoleSubscriptions();
        TextView textView15 = getBinding().f17544f;
        Intrinsics3.checkNotNullExpressionValue(textView15, "binding.serverSettingsGu…RoleSubscriptionBasicInfo");
        textView15.setVisibility(z2 ? 0 : 8);
        getBinding().f17544f.setOnClickListener(new ViewOnClickListenerC917816(model));
        TextView textView16 = getBinding().f17547i;
        Intrinsics3.checkNotNullExpressionValue(textView16, "binding.serverSettingsGuildRoleSubscriptionTiers");
        textView16.setVisibility(z2 ? 0 : 8);
        getBinding().f17547i.setOnClickListener(new ViewOnClickListenerC917917(model));
        TextView textView17 = getBinding().f17545g;
        Intrinsics3.checkNotNullExpressionValue(textView17, "binding.serverSettingsGu…dRoleSubscriptionEarnings");
        textView17.setVisibility(z2 ? 0 : 8);
        getBinding().f17545g.setOnClickListener(new ViewOnClickListenerC918018());
        configureSectionsVisibility();
    }

    private final WidgetServerSettingsBinding getBinding() {
        return (WidgetServerSettingsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.server_settings);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        long longExtra = getMostRecentIntent().getLongExtra("INTENT_EXTRA_GUILD_ID", -1L);
        this.guildId = longExtra;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(longExtra), this, null, 2, null), WidgetServerSettings.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C91891(this), 62, (Object) null);
    }
}
