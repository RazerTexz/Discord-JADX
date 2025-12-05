package com.discord.widgets.servers.community;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetServerSettingsCommunitySetupSecondStepBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.WidgetChannelSelector;
import com.discord.widgets.servers.community.WidgetServerSettingsEnableCommunityViewModel;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppViewModelDelegates2;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.Observable;

/* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
/* loaded from: classes2.dex */
public final class WidgetServerSettingsCommunitySecondStep extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetServerSettingsCommunitySecondStep.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCommunitySetupSecondStepBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String REQUEST_KEY_RULES_CHANNEL = "REQUEST_KEY_RULES_CHANNEL";
    private static final String REQUEST_KEY_UPDATES_CHANNEL = "REQUEST_KEY_UPDATES_CHANNEL";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void create(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.m156d(context, WidgetServerSettingsCommunitySecondStep.class, new Intent());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$configureUI$1 */
    public static final class ViewOnClickListenerC93751 implements View.OnClickListener {
        public ViewOnClickListenerC93751() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
            WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = WidgetServerSettingsCommunitySecondStep.this;
            WidgetChannelSelector.Companion.launchForText$default(companion, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(widgetServerSettingsCommunitySecondStep).getGuildId(), WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_RULES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$configureUI$2 */
    public static final class ViewOnClickListenerC93762 implements View.OnClickListener {
        public ViewOnClickListenerC93762() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
            WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep = WidgetServerSettingsCommunitySecondStep.this;
            WidgetChannelSelector.Companion.launchForText$default(companion, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(widgetServerSettingsCommunitySecondStep).getGuildId(), WidgetServerSettingsCommunitySecondStep.REQUEST_KEY_UPDATES_CHANNEL, false, 0, 24, null);
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$1 */
    public static final class C93771 extends Lambda implements Function2<Long, String, Unit> {

        /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Channel channel) {
                super(1);
                this.$channelId = j;
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "guildConfig");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, this.$channel, null, Long.valueOf(this.$channelId), null, false, false, false, false, null, false, null, null, 4090, null);
            }
        }

        public C93771() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(WidgetServerSettingsCommunitySecondStep.this).modifyGuildConfig(new AnonymousClass1(j, StoreStream.INSTANCE.getChannels().getChannel(j)));
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$2 */
    public static final class C93782 extends Lambda implements Function2<Long, String, Unit> {

        /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
        /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBound$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig, WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig> {
            public final /* synthetic */ Channel $channel;
            public final /* synthetic */ long $channelId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(long j, Channel channel) {
                super(1);
                this.$channelId = j;
                this.$channel = channel;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                return invoke2(communityGuildConfig);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig invoke2(WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig communityGuildConfig) {
                Intrinsics3.checkNotNullParameter(communityGuildConfig, "guildConfig");
                return WidgetServerSettingsEnableCommunityViewModel.CommunityGuildConfig.copy$default(communityGuildConfig, null, this.$channel, null, Long.valueOf(this.$channelId), false, false, false, false, null, false, null, null, 4085, null);
            }
        }

        public C93782() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Long l, String str) {
            invoke(l.longValue(), str);
            return Unit.f27425a;
        }

        public final void invoke(long j, String str) {
            Intrinsics3.checkNotNullParameter(str, "<anonymous parameter 1>");
            WidgetServerSettingsCommunitySecondStep.access$getViewModel$p(WidgetServerSettingsCommunitySecondStep.this).modifyGuildConfig(new AnonymousClass1(j, StoreStream.INSTANCE.getChannels().getChannel(j)));
        }
    }

    /* compiled from: WidgetServerSettingsCommunitySecondStep.kt */
    /* renamed from: com.discord.widgets.servers.community.WidgetServerSettingsCommunitySecondStep$onViewBoundOrOnResume$1 */
    public static final /* synthetic */ class C93811 extends FunctionReferenceImpl implements Function1<WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded, Unit> {
        public C93811(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
            super(1, widgetServerSettingsCommunitySecondStep, WidgetServerSettingsCommunitySecondStep.class, "configureUI", "configureUI(Lcom/discord/widgets/servers/community/WidgetServerSettingsEnableCommunityViewModel$ViewState$Loaded;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            invoke2(loaded);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
            Intrinsics3.checkNotNullParameter(loaded, "p1");
            WidgetServerSettingsCommunitySecondStep.access$configureUI((WidgetServerSettingsCommunitySecondStep) this.receiver, loaded);
        }
    }

    public WidgetServerSettingsCommunitySecondStep() {
        super(C5419R.layout.widget_server_settings_community_setup_second_step);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCommunitySecondStep2.INSTANCE, null, 2, null);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetServerSettingsEnableCommunityViewModel.class), new C9373x1435c0be(this), new AppViewModelDelegates2(WidgetServerSettingsCommunitySecondStep3.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep, WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded loaded) {
        widgetServerSettingsCommunitySecondStep.configureUI(loaded);
    }

    public static final /* synthetic */ WidgetServerSettingsEnableCommunityViewModel access$getViewModel$p(WidgetServerSettingsCommunitySecondStep widgetServerSettingsCommunitySecondStep) {
        return widgetServerSettingsCommunitySecondStep.getViewModel();
    }

    private final void configureUI(WidgetServerSettingsEnableCommunityViewModel.ViewState.Loaded viewState) {
        String string = viewState.getCommunityGuildConfig().getRulesChannel() == null ? requireContext().getString(C5419R.string.enable_public_modal_create_channel) : ChannelUtils.m7681e(viewState.getCommunityGuildConfig().getRulesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string, "when (viewState.communit…t(requireContext())\n    }");
        String string2 = viewState.getCommunityGuildConfig().getUpdatesChannel() == null ? requireContext().getString(C5419R.string.enable_public_modal_create_channel) : ChannelUtils.m7681e(viewState.getCommunityGuildConfig().getUpdatesChannel(), requireContext(), false, 2);
        Intrinsics3.checkNotNullExpressionValue(string2, "when (viewState.communit…t(requireContext())\n    }");
        getBinding().f17585b.setSubtitle(string);
        getBinding().f17586c.setSubtitle(string2);
        getBinding().f17585b.setOnClickListener(new ViewOnClickListenerC93751());
        getBinding().f17586c.setOnClickListener(new ViewOnClickListenerC93762());
    }

    public static final void create(Context context) {
        INSTANCE.create(context);
    }

    private final WidgetServerSettingsCommunitySetupSecondStepBinding getBinding() {
        return (WidgetServerSettingsCommunitySetupSecondStepBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsEnableCommunityViewModel getViewModel() {
        return (WidgetServerSettingsEnableCommunityViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        WidgetChannelSelector.Companion companion = WidgetChannelSelector.INSTANCE;
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_RULES_CHANNEL, false, new C93771(), 4, null);
        WidgetChannelSelector.Companion.registerForResult$default(companion, this, REQUEST_KEY_UPDATES_CHANNEL, false, new C93782(), 4, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable observableM11083G = ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null).m11118y(C9379x709831cc.INSTANCE).m11083G(C9380x709831cd.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it is T }.map { it as T }");
        ObservableExtensionsKt.appSubscribe$default(observableM11083G, WidgetServerSettingsCommunitySecondStep.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C93811(this), 62, (Object) null);
    }
}
