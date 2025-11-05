package com.discord.widgets.servers;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import b.a.d.j;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.guild.GuildExplicitContentFilter;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsModerationBinding;
import com.discord.models.guild.Guild;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import d0.g;
import d0.t.n;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsModeration.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsModeration extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsModeration.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsModerationBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String VERIFICATION_LEVEL_HIGH_MINUTES = "10";
    private static final String VERIFICATION_LEVEL_MEDIUM_MINUTES = "5";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;
    private RadioManager radioManagerExplicit;
    private RadioManager radioManagerVerification;

    /* compiled from: WidgetServerSettingsModeration.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("MODERATION", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent().putExtra(INTENT_EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetServerSettingsModeration.class, intentPutExtra);
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
                Observable observableI = Observable.i(companion.getGuilds().observeGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getPermissions().observePermissionsForGuild(guildId), WidgetServerSettingsModeration$Model$Companion$get$1.INSTANCE);
                m.checkNotNullExpressionValue(observableI, "Observable\n             …        }\n              }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                m.checkNotNullExpressionValue(observableR, "Observable\n             …  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(Guild guild) {
            m.checkNotNullParameter(guild, "guild");
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
            m.checkNotNullParameter(guild, "guild");
            return new Model(guild);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Model) && m.areEqual(this.guild, ((Model) other).guild);
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
            StringBuilder sbU = a.U("Model(guild=");
            sbU.append(this.guild);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$configureExplicitContentRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildExplicitContentFilter $explicitContentLevel;
        public final /* synthetic */ Model $model;

        public AnonymousClass1(Model model, GuildExplicitContentFilter guildExplicitContentFilter) {
            this.$model = model;
            this.$explicitContentLevel = guildExplicitContentFilter;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.access$updateGuild(WidgetServerSettingsModeration.this, this.$model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForExplicitContentFilter(this.$explicitContentLevel));
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$configureVerificationLevelRadio$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Model $model;
        public final /* synthetic */ GuildVerificationLevel $verificationLevel;

        public AnonymousClass1(Model model, GuildVerificationLevel guildVerificationLevel) {
            this.$model = model;
            this.$verificationLevel = guildVerificationLevel;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetServerSettingsModeration.access$updateGuild(WidgetServerSettingsModeration.this, this.$model.getGuild().getId(), RestAPIParams.UpdateGuild.INSTANCE.createForVerificationLevel(this.$verificationLevel));
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetServerSettingsModeration widgetServerSettingsModeration) {
            super(1, widgetServerSettingsModeration, WidgetServerSettingsModeration.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/WidgetServerSettingsModeration$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetServerSettingsModeration.access$configureUI((WidgetServerSettingsModeration) this.receiver, model);
        }
    }

    /* compiled from: WidgetServerSettingsModeration.kt */
    /* renamed from: com.discord.widgets.servers.WidgetServerSettingsModeration$updateGuild$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<com.discord.api.guild.Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            m.checkNotNullParameter(guild, "it");
            b.a.d.m.i(WidgetServerSettingsModeration.this, R.string.server_settings_updated, 0, 4);
        }
    }

    public WidgetServerSettingsModeration() {
        super(R.layout.widget_server_settings_moderation);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsModeration$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsModeration$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsModeration$loggingConfig$1.INSTANCE, 3);
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
            radio.e(new AnonymousClass1(model, explicitContentLevel));
        } else {
            radio.b(R.string.tooltip_community_feature_disabled);
        }
        if (this.radioManagerExplicit == null || model.getGuild().getExplicitContentFilter() != explicitContentLevel || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
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
            radio.b(R.string.tooltip_community_feature_disabled);
        } else {
            radio.e(new AnonymousClass1(model, verificationLevel));
        }
        if (this.radioManagerVerification == null || model.getGuild().getVerificationLevel() != verificationLevel || (radioManager = this.radioManagerVerification) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final WidgetServerSettingsModerationBinding getBinding() {
        return (WidgetServerSettingsModerationBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentViews() {
        CheckedSetting checkedSetting = getBinding().f2580b;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationExplicit1");
        CheckedSetting checkedSetting2 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationExplicit2");
        CheckedSetting checkedSetting3 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationExplicit3");
        return n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final List<CheckedSetting> getVerificationViews() {
        CheckedSetting checkedSetting = getBinding().f;
        m.checkNotNullExpressionValue(checkedSetting, "binding.serverSettingsModerationVerification1");
        CheckedSetting checkedSetting2 = getBinding().g;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.serverSettingsModerationVerification2");
        CheckedSetting checkedSetting3 = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.serverSettingsModerationVerification3");
        CheckedSetting checkedSetting4 = getBinding().i;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.serverSettingsModerationVerification4");
        CheckedSetting checkedSetting5 = getBinding().j;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.serverSettingsModerationVerification5");
        return n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3, checkedSetting4, checkedSetting5});
    }

    private final void updateGuild(long guildId, RestAPIParams.UpdateGuild updateGuild) {
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().updateGuild(guildId, updateGuild), false, 1, null), this, null, 2, null), WidgetServerSettingsModeration.class, getContext(), (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 60, (Object) null);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.moderation);
        TextView textView = getBinding().k;
        m.checkNotNullExpressionValue(textView, "binding.serverSettingsModerationVerificationHelp");
        b.n(textView, R.string.form_help_verification_level, new Object[0], null, 4);
        TextView textView2 = getBinding().e;
        m.checkNotNullExpressionValue(textView2, "binding.serverSettingsModerationExplicitHelp");
        b.n(textView2, R.string.form_help_explicit_content_filter, new Object[0], null, 4);
        this.radioManagerVerification = new RadioManager(getVerificationViews());
        this.radioManagerExplicit = new RadioManager(getExplicitContentViews());
        CheckedSetting.i(getVerificationViews().get(2), b.k(this, R.string.verification_level_medium_criteria, new Object[]{VERIFICATION_LEVEL_MEDIUM_MINUTES}, null, 4), false, 2);
        CheckedSetting.i(getVerificationViews().get(3), b.k(this, R.string.verification_level_high_criteria, new Object[]{VERIFICATION_LEVEL_HIGH_MINUTES}, null, 4), false, 2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(getGuildId()), this, null, 2, null), WidgetServerSettingsModeration.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
