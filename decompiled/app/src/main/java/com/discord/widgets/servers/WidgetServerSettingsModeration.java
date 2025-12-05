package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.discord.C5419R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsModeration.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsModeration extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsModeration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String VERIFICATION_LEVEL_HIGH_MINUTES = "10";
    private static final String VERIFICATION_LEVEL_MEDIUM_MINUTES = "5";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;
    private RadioManager radioManagerExplicit;
    private RadioManager radioManagerVerification;

    /* compiled from: WidgetServerSettingsModeration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MODERATION", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetServerSettingsModeration.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    public static final /* data */ class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Guild guild;

        /* compiled from: WidgetServerSettingsModeration.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(long guildId) {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11075i = Observable.m11075i(companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), WidgetServerSettingsModeration2.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable\n             …        }\n              }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n             …  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            this.guild = guild;
        }

        public static /* synthetic */ Model copy$default(Model model, Guild guild, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = model.guild;
            }
            return model.copy(guild);
        }

        /* renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Model copy(Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "guild");
            return new Model(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && Intrinsics3.areEqual(this.guild, ((Model) other).guild);
            }
            return true;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public int hashCode() {
            Guild guild = this.guild;
            if (guild != null) {
                return guild.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Model(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$configureExplicitContentRadio$1 */
    public static final class ViewOnClickListenerC92691 implements View.OnClickListener {
        public final /* synthetic */ GuildExplicitContentFilter $explicitContentLevel;
        public final /* synthetic */ Model $model;

        public ViewOnClickListenerC92691(Model model, GuildExplicitContentFilter guildExplicitContentFilter) {
            this.$model = model;
            this.$explicitContentLevel = guildExplicitContentFilter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.access$updateGuild(WidgetServerSettingsModeration.this, this.$model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForExplicitContentFilter(this.$explicitContentLevel));
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$configureVerificationLevelRadio$1 */
    public static final class ViewOnClickListenerC92701 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ GuildVerificationLevel $verificationLevel;

        public ViewOnClickListenerC92701(Model model, GuildVerificationLevel guildVerificationLevel) {
            this.$model = model;
            this.$verificationLevel = guildVerificationLevel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.access$updateGuild(WidgetServerSettingsModeration.this, this.$model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForVerificationLevel(this.$verificationLevel));
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C92711 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public C92711(WidgetServerSettingsModeration widgetServerSettingsModeration) {
            super(1, widgetServerSettingsModeration, WidgetServerSettingsModeration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsModeration.access$configureUI((WidgetServerSettingsModeration) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$updateGuild$1 */
    public static final class C92721 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public C92721() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            AppToast.m171i(WidgetServerSettingsModeration.this, C5419R.string.server_settings_updated, 0, 4);
        }
    }

    public WidgetServerSettingsModeration() {
        super(C5419R.layout.widget_server_settings_moderation);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsModeration3.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsModeration4(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsModeration5.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsModeration widgetServerSettingsModeration, Model model) {
        widgetServerSettingsModeration.configureUI(model);
    }

    public static final /* synthetic */ void access$updateGuild(WidgetServerSettingsModeration widgetServerSettingsModeration, long j, RestAPIParams.UpdateGuild updateGuild) {
        widgetServerSettingsModeration.updateGuild(j, updateGuild);
    }

    private final void configureExplicitContentRadio(Model model, CheckedSetting radio, GuildExplicitContentFilter explicitContentLevel) {
        RadioManager radioManager;
        if (!model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) || explicitContentLevel.compareTo(GuildExplicitContentFilter.ALL) >= 0) {
            radio.m8527e(new ViewOnClickListenerC92691(model, explicitContentLevel));
        } else {
            radio.m8525b(C5419R.string.tooltip_community_feature_disabled);
        }
        if (this.radioManagerExplicit == null || model.getGuild().getExplicitContentFilter() != explicitContentLevel || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.m8550a(radio);
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
        setActionBarSubtitle(model.getGuild().getName());
        configureVerificationLevelRadio(model, getVerificationViews().get(0), GuildVerificationLevel.NONE);
        configureVerificationLevelRadio(model, getVerificationViews().get(1), GuildVerificationLevel.LOW);
        configureVerificationLevelRadio(model, getVerificationViews().get(2), GuildVerificationLevel.MEDIUM);
        configureVerificationLevelRadio(model, getVerificationViews().get(3), GuildVerificationLevel.HIGH);
        configureVerificationLevelRadio(model, getVerificationViews().get(4), GuildVerificationLevel.HIGHEST);
        configureExplicitContentRadio(model, getExplicitContentViews().get(0), GuildExplicitContentFilter.NONE);
        configureExplicitContentRadio(model, getExplicitContentViews().get(1), GuildExplicitContentFilter.SOME);
        configureExplicitContentRadio(model, getExplicitContentViews().get(2), GuildExplicitContentFilter.ALL);
    }

    private final void configureVerificationLevelRadio(Model model, CheckedSetting radio, GuildVerificationLevel verificationLevel) {
        RadioManager radioManager;
        if (model.getGuild().getFeatures().contains(GuildFeature.COMMUNITY) && verificationLevel == GuildVerificationLevel.NONE) {
            radio.m8525b(C5419R.string.tooltip_community_feature_disabled);
        } else {
            radio.m8527e(new ViewOnClickListenerC92701(model, verificationLevel));
        }
        if (this.radioManagerVerification == null || model.getGuild().getVerificationLevel() != verificationLevel || (radioManager = this.radioManagerVerification) == null) {
            return;
        }
        radioManager.m8550a(radio);
    }

    private final WidgetServerSettingsModerationBinding getBinding() {
        return (WidgetServerSettingsModerationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentViews() {
        CheckedSetting checkedSetting = getBinding().f17714b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationExplicit1");
        CheckedSetting checkedSetting2 = getBinding().f17715c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationExplicit2");
        CheckedSetting checkedSetting3 = getBinding().f17716d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationExplicit3");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<CheckedSetting> getVerificationViews() {
        CheckedSetting checkedSetting = getBinding().f17718f;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationVerification1");
        CheckedSetting checkedSetting2 = getBinding().f17719g;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationVerification2");
        CheckedSetting checkedSetting3 = getBinding().f17720h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationVerification3");
        CheckedSetting checkedSetting4 = getBinding().f17721i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.serverSettingsModerationVerification4");
        CheckedSetting checkedSetting5 = getBinding().f17722j;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.serverSettingsModerationVerification5");
        return Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5});
    }

    private final void updateGuild(long guildId, RestAPIParams.UpdateGuild updateGuild) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(guildId, updateGuild), false, 1, null), this, null, 2, null), WidgetServerSettingsModeration.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C92721(), 60, (Object) null);
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
        setActionBarTitle(C5419R.string.moderation);
        TextView textView = getBinding().f17723k;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.serverSettingsModerationVerificationHelp");
        FormatUtils.m222n(textView, C5419R.string.form_help_verification_level, new Object[0], null, 4);
        TextView textView2 = getBinding().f17717e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.serverSettingsModerationExplicitHelp");
        FormatUtils.m222n(textView2, C5419R.string.form_help_explicit_content_filter, new Object[0], null, 4);
        this.radioManagerVerification = new RadioManager(getVerificationViews());
        this.radioManagerExplicit = new RadioManager(getExplicitContentViews());
        CheckedSetting.m8524i(getVerificationViews().get(2), FormatUtils.m219k(this, C5419R.string.verification_level_medium_criteria, new Object[]{VERIFICATION_LEVEL_MEDIUM_MINUTES}, null, 4), false, 2);
        CheckedSetting.m8524i(getVerificationViews().get(3), FormatUtils.m219k(this, C5419R.string.verification_level_high_criteria, new Object[]{VERIFICATION_LEVEL_HIGH_MINUTES}, null, 4), false, 2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsModeration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C92711(this), 62, (Object) null);
    }
}
