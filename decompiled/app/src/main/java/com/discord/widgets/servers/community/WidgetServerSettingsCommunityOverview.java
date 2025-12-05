package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.databinding.WidgetServerSettingsCommunityOverviewBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog;
import com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverviewViewModel;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunitySteps;
import com.discord.widgets.settings.WidgetSettingsLanguage;
import com.discord.widgets.settings.WidgetSettingsLanguageSelect;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsCommunityOverview.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunityOverview extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsCommunityOverview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunityOverviewBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final AppLogger2 loggingConfig;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            StoreStream.INSTANCE.getAnalytics().onGuildSettingsPaneViewed("COMMUNITY_OVERVIEW", guildId);
            Intent intentPutExtra = new Intent().putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            Intrinsics3.checkNotNullExpressionValue(intentPutExtra, "Intent()\n          .putE…_EXTRA_GUILD_ID, guildId)");
            AppScreen2.m156d(context, WidgetServerSettingsCommunityOverview.class, intentPutExtra);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$1 */
    public static final class ViewOnClickListenerC93601 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC93601(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion.launchForText$default(WidgetChannelSelector.INSTANCE, WidgetServerSettingsCommunityOverview.this, this.$viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_RULES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$2 */
    public static final class ViewOnClickListenerC93612 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC93612(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion.launchForText$default(WidgetChannelSelector.INSTANCE, WidgetServerSettingsCommunityOverview.this, this.$viewState.getGuild().getId(), WidgetServerSettingsCommunityOverview.REQUEST_KEY_UPDATES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$3 */
    public static final class ViewOnClickListenerC93623 implements View.OnClickListener {
        public ViewOnClickListenerC93623() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSettingsLanguageSelect.INSTANCE.show(WidgetServerSettingsCommunityOverview.this);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$configureValidUI$4 */
    public static final class ViewOnClickListenerC93634 implements View.OnClickListener {
        public final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded $viewState;

        public ViewOnClickListenerC93634(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded loaded) {
            this.$viewState = loaded;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AppActivity appActivity = WidgetServerSettingsCommunityOverview.this.getAppActivity();
            if (appActivity != null) {
                WidgetConfirmRemoveCommunityDialog.Companion companion = WidgetConfirmRemoveCommunityDialog.INSTANCE;
                FragmentManager supportFragmentManager = appActivity.getSupportFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "appActivity.supportFragmentManager");
                companion.show(supportFragmentManager, this.$viewState.getGuild().getId());
            }
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$1 */
    public static final class C93641 extends Lambda implements Function1<String, Unit> {
        public C93641() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            Intrinsics3.checkNotNullParameter(str, "locale");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveLocale(str);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$2 */
    public static final class C93652 extends Lambda implements Function2<Long, String, Unit> {
        public C93652() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveRulesChannel(j);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBound$3 */
    public static final class C93663 extends Lambda implements Function2<Long, String, Unit> {
        public C93663() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunityOverview.access$getViewModel$p(WidgetServerSettingsCommunityOverview.this).saveCommunityUpdatesChannel(j);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C93671 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsCommunityOverviewViewModel.ViewState, Unit> {
        public C93671(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
            super(1, widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverview.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsCommunityOverviewViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetServerSettingsCommunityOverview.access$configureUI((WidgetServerSettingsCommunityOverview) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetServerSettingsCommunityOverview.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunityOverview$onViewBoundOrOnResume$2 */
    public static final class C93682 extends Lambda implements Function1<WidgetServerSettingsCommunityOverviewViewModel.Event, Unit> {
        public C93682() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsCommunityOverviewViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.DisableCommunitySuccess.INSTANCE)) {
                WidgetServerSettingsCommunityOverview.this.requireActivity().finish();
                WidgetServerSettingsEnableCommunitySteps.Companion companion = WidgetServerSettingsEnableCommunitySteps.INSTANCE;
                FragmentActivity fragmentActivityRequireActivity = WidgetServerSettingsCommunityOverview.this.requireActivity();
                Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
                companion.create(fragmentActivityRequireActivity, WidgetServerSettingsCommunityOverview.this.getGuildId());
                return;
            }
            if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.SaveSuccess.INSTANCE)) {
                AppToast.m171i(WidgetServerSettingsCommunityOverview.this, C5419R.string.server_settings_updated, 0, 4);
            } else if (Intrinsics3.areEqual(event, WidgetServerSettingsCommunityOverviewViewModel.Event.Error.INSTANCE)) {
                AppToast.m171i(WidgetServerSettingsCommunityOverview.this, C5419R.string.guild_settings_public_update_failed, 0, 4);
            }
        }
    }

    public WidgetServerSettingsCommunityOverview() {
        super(C5419R.layout.widget_server_settings_community_overview);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunityOverview2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsCommunityOverviewViewModel.class), new C9358xb2c7ca17(this), new AppViewModelDelegates2(new WidgetServerSettingsCommunityOverview5(this)));
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsCommunityOverview3(this));
        this.loggingConfig = new AppLogger2(false, null, WidgetServerSettingsCommunityOverview4.INSTANCE, 3);
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview, WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        widgetServerSettingsCommunityOverview.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetServerSettingsCommunityOverviewViewModel access$getViewModel$p(WidgetServerSettingsCommunityOverview widgetServerSettingsCommunityOverview) {
        return widgetServerSettingsCommunityOverview.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState viewState) {
        if (Intrinsics3.areEqual(viewState, WidgetServerSettingsCommunityOverviewViewModel.ViewState.Invalid.INSTANCE)) {
            requireActivity().finish();
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) {
            configureValidUI((WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded) viewState);
        } else if (viewState instanceof WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) {
            getBinding().f17580e.setIsLoading(((WidgetServerSettingsCommunityOverviewViewModel.ViewState.DisableCommunityLoading) viewState).isLoading());
        }
    }

    private final void configureValidUI(WidgetServerSettingsCommunityOverviewViewModel.ViewState.Loaded viewState) {
        String strM7681e;
        getBinding().f17580e.setIsLoading(false);
        String string = viewState.getRulesChannel() == null ? requireContext().getString(C5419R.string.guild_settings_public_no_option_selected) : ChannelUtils.m7681e(viewState.getRulesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string, "when (viewState.rulesCha…t(requireContext())\n    }");
        if (viewState.getUpdatesChannel() == null) {
            strM7681e = requireContext().getString(C5419R.string.guild_settings_public_no_option_selected);
        } else {
            Channel updatesChannel = viewState.getUpdatesChannel();
            FragmentActivity fragmentActivityRequireActivity = requireActivity();
            Intrinsics3.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity()");
            strM7681e = ChannelUtils.m7681e(updatesChannel, fragmentActivityRequireActivity, false, 2);
        }
        Intrinsics3.checkNotNullExpressionValue(strM7681e, "when (viewState.updatesC…(requireActivity())\n    }");
        getBinding().f17577b.setSubtitle(string);
        getBinding().f17578c.setSubtitle(strM7681e);
        getBinding().f17579d.setSubtitle(WidgetSettingsLanguage.INSTANCE.getAsStringInLocale(viewState.getGuild().getPreferredLocale()));
        getBinding().f17577b.setOnClickListener(new ViewOnClickListenerC93601(viewState));
        getBinding().f17578c.setOnClickListener(new ViewOnClickListenerC93612(viewState));
        getBinding().f17579d.setOnClickListener(new ViewOnClickListenerC93623());
        getBinding().f17580e.setOnClickListener(new ViewOnClickListenerC93634(viewState));
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

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public AppLogger2 getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetSettingsLanguageSelect.INSTANCE.registerForResult(this, new C93641());
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new C93652(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new C93663(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarTitle(C5419R.string.guild_settings_community);
        Observable<WidgetServerSettingsCommunityOverviewViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        Intrinsics3.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93671(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetServerSettingsCommunityOverview.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93682(), 62, (Object) null);
    }
}
