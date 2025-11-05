package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import d0.g;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;

/* compiled from: WidgetServerSettingsCommunityOverview.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsCommunityOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final LoggingConfig loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            m.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("COMMUNITY_OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            m.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            j.d(context, WidgetServerSettingsCommunityOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public AnonymousClass1(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion.launchForText$default(WidgetChannelSelector.INSTANCE, WidgetServerSettingsCommunityOverview.this, this.$viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_RULES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public AnonymousClass2(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion.launchForText$default(WidgetChannelSelector.INSTANCE, WidgetServerSettingsCommunityOverview.this, this.$viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_UPDATES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsLanguageSelect.INSTANCE.show(WidgetServerSettingsCommunityOverview.this);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public AnonymousClass4(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppActivity appActivity = WidgetServerSettingsCommunityOverview.this.getAppActivity();
            if (appActivity != null) {
                WidgetConfirmRemoveCommunityDialog.Companion companion = WidgetConfirmRemoveCommunityDialog.INSTANCE;
                FragmentManager supportFragmentManager = appActivity.getSupportFragmentManager();
                m.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                companion.show(supportFragmentManager, this.$viewState.getGuild().getId());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<String, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            m.checkNotNullParameter(str, "locale");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveLocale(str);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function2<Long, String, Unit> {
        public AnonymousClass2() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveRulesChannel(j);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function2<Long, String, Unit> {
        public AnonymousClass3() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.a;
        }

        public final void invoke(long j, String str) {
            m.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveCommunityUpdatesChannel(j);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<WidgetServerSettingsCommunityOverviewViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
            super(1, widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverview.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            m.checkNotNullParameter(viewState, "p1");
            WidgetServerSettingsCommunityOverview.access$configureUI((WidgetServerSettingsCommunityOverview) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<WidgetServerSettingsCommunityOverviewViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            m.checkNotNullParameter(event, "event");
            if (m.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.DisableCommunitySuccess.INSTANCE)) {
                WidgetServerSettingsCommunityOverview.this.requireActivity().finish();
                WidgetServerSettingsEnableCommunitySteps.Companion companion = WidgetServerSettingsEnableCommunitySteps.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsCommunityOverview.this.requireActivity();
                m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsCommunityOverview.this.getGuildId());
                return;
            }
            if (m.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.SaveSuccess.INSTANCE)) {
                b.a.d.m.i(WidgetServerSettingsCommunityOverview.this, R.string.server_settings_updated, 0, 4);
            } else if (m.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.Error.INSTANCE)) {
                b.a.d.m.i(WidgetServerSettingsCommunityOverview.this, R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public WidgetServerSettingsCommunityOverview() {
        super(R.layout.widget_server_settings_community_overview);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCommunityOverview$binding$2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new WidgetServerSettingsCommunityOverview$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetServerSettingsCommunityOverview$viewModel$2(this)));
        this.guildId = g.lazy(new WidgetServerSettingsCommunityOverview$guildId$2(this));
        this.loggingConfig = new LoggingConfig(false, null, WidgetServerSettingsCommunityOverview$loggingConfig$1.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        widgetServerSettingsCommunityOverview.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel access$getViewModel$p(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        return widgetServerSettingsCommunityOverview.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        if (m.areEqual(viewState, WidgetServerSettingsCommunityOverviewViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) {
            configureValidUI((WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) {
            getBinding().e.setIsLoading(((WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) viewState).isLoading());
        }
    }

    private final void configureValidUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded viewState) {
        String strE;
        getBinding().e.setIsLoading(false);
        String string = viewState.getRulesChannel() == null ? requireContext().getString(R.string.guild_settings_public_no_option_selected) : ChannelUtils.e(viewState.getRulesChannel(), requireContext(), false, 2);
        m.checkNotNullExpressionValue(string, "when (viewState.rulesCha…t(requireContext())\n    }");
        if (viewState.getUpdatesChannel() == null) {
            strE = requireContext().getString(R.string.guild_settings_public_no_option_selected);
        } else {
            Channel updatesChannel = viewState.getUpdatesChannel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            m.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            strE = ChannelUtils.e(updatesChannel, fragmentActivityRequireActivity, false, 2);
        }
        m.checkNotNullExpressionValue(strE, "when (viewState.updatesC…(requireActivity())\n    }");
        getBinding().f2553b.setSubtitle(string);
        getBinding().c.setSubtitle(strE);
        getBinding().d.setSubtitle(WidgetSettingsLanguage.INSTANCE.getAsStringInLocale(viewState.getGuild().getPreferredLocale()));
        getBinding().f2553b.setOnClickListener(new AnonymousClass1(viewState));
        getBinding().c.setOnClickListener(new AnonymousClass2(viewState));
        getBinding().d.setOnClickListener(new AnonymousClass3());
        getBinding().e.setOnClickListener(new AnonymousClass4(viewState));
    }

    public static final void create(Context context, long j) {
        INSTANCE.create(context, j);
    }

    private final WidgetServerSettingsCommunityOverviewBinding getBinding() {
        return (WidgetServerSettingsCommunityOverviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCommunityOverviewViewModel getViewModel() {
        return (WidgetServerSettingsCommunityOverviewViewModel) this.viewModel.getValue();
    }

    public final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new AnonymousClass1());
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new AnonymousClass2(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new AnonymousClass3(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(R.string.guild_settings_community);
        Observable<WidgetServerSettingsCommunityOverviewViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass2(), 62, (Object) null);
    }
}
