package com.discord.widgets.channels;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.core.view.ViewKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChannelSidebarActionsBinding;
import com.discord.utilities.device.DeviceUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.channelsidebar.GuildChannelSideBarActionsView;
import com.discord.views.channelsidebar.PrivateChannelSideBarActionsView;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import com.discord.widgets.channels.settings.WidgetTextChannelSettings;
import com.discord.widgets.channels.settings.WidgetThreadSettings;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowser;
import com.discord.widgets.chat.pins.WidgetChannelPinnedMessages;
import com.discord.widgets.search.WidgetSearch;
import com.discord.widgets.settings.WidgetMuteSettingsSheet;
import com.discord.widgets.user.calls.PrivateCallLauncher;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetChannelSidebarActions.kt */
/* loaded from: classes2.dex */
public final class WidgetChannelSidebarActions extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetChannelSidebarActions.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChannelSidebarActionsBinding;", 0)};

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$1 */
    public static final class ViewOnClickListenerC73371 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        public ViewOnClickListenerC73371(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSidebarActions.access$startPrivateCall(WidgetChannelSidebarActions.this, ((WidgetChannelSidebarActionsViewModel.ViewState.Private) this.$viewState).getChannelId(), false);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$2 */
    public static final class ViewOnClickListenerC73382 implements View.OnClickListener {
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        public ViewOnClickListenerC73382(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChannelSidebarActions.access$startPrivateCall(WidgetChannelSidebarActions.this, ((WidgetChannelSidebarActionsViewModel.ViewState.Private) this.$viewState).getChannelId(), true);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$3 */
    public static final class ViewOnClickListenerC73393 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;

        public ViewOnClickListenerC73393(long j) {
            this.$channelId = j;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$4 */
    public static final class ViewOnClickListenerC73404 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        public ViewOnClickListenerC73404(long j, Context context) {
            this.$channelId = j;
            this.$context = context;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetSearch.INSTANCE.launchForChannel(this.$channelId, this.$context);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$5 */
    public static final class C73415 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73415(WidgetChannelSidebarActionsViewModel.ViewState viewState, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetSearch.INSTANCE.launchForGuild(((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), this.$context);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$6 */
    public static final class C73426 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73426(Context context, WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            super(1);
            this.$context = context;
            this.$viewState = viewState;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetThreadBrowser.INSTANCE.show(this.$context, ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getGuildId(), ((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).getChannelId(), "Channel Side Bar");
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$7 */
    public static final class C73437 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73437(Context context, long j) {
            super(1);
            this.$context = context;
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetChannelPinnedMessages.INSTANCE.show(this.$context, this.$channelId);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$8 */
    public static final class C73448 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73448(long j) {
            super(1);
            this.$channelId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            WidgetMuteSettingsSheet.Companion companion = WidgetMuteSettingsSheet.INSTANCE;
            long j = this.$channelId;
            FragmentManager parentFragmentManager = WidgetChannelSidebarActions.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.showForChannel(j, parentFragmentManager);
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$configureUI$9 */
    public static final class C73459 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ Context $context;
        public final /* synthetic */ WidgetChannelSidebarActionsViewModel.ViewState $viewState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C73459(WidgetChannelSidebarActionsViewModel.ViewState viewState, long j, Context context) {
            super(1);
            this.$viewState = viewState;
            this.$channelId = j;
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            if (((WidgetChannelSidebarActionsViewModel.ViewState.Guild) this.$viewState).isThread()) {
                WidgetThreadSettings.INSTANCE.launch(this.$channelId, this.$context);
            } else {
                WidgetTextChannelSettings.INSTANCE.launch(this.$channelId, this.$context);
            }
        }
    }

    /* compiled from: WidgetChannelSidebarActions.kt */
    /* renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$onViewBoundOrOnResume$1 */
    public static final class C73461 extends Lambda implements Function1<WidgetChannelSidebarActionsViewModel.ViewState, Unit> {
        public C73461() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetChannelSidebarActions.access$configureUI(WidgetChannelSidebarActions.this, viewState);
        }
    }

    public WidgetChannelSidebarActions() {
        super(C5419R.layout.widget_channel_sidebar_actions);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChannelSidebarActions2.INSTANCE, null, 2, null);
        WidgetChannelSidebarActions3 widgetChannelSidebarActions3 = WidgetChannelSidebarActions3.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetChannelSidebarActionsViewModel.class), new WidgetChannelSidebarActions$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChannelSidebarActions3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetChannelSidebarActions widgetChannelSidebarActions, WidgetChannelSidebarActionsViewModel.ViewState viewState) {
        widgetChannelSidebarActions.configureUI(viewState);
    }

    public static final /* synthetic */ void access$startPrivateCall(WidgetChannelSidebarActions widgetChannelSidebarActions, long j, boolean z2) {
        widgetChannelSidebarActions.startPrivateCall(j, z2);
    }

    private final void configureUI(WidgetChannelSidebarActionsViewModel.ViewState viewState) {
        DeviceUtils deviceUtils = DeviceUtils.INSTANCE;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        boolean zIsSmallScreen = deviceUtils.isSmallScreen(resources);
        if (Intrinsics3.areEqual(viewState, WidgetChannelSidebarActionsViewModel.ViewState.Uninitialized.INSTANCE)) {
            View view = getView();
            if (view != null) {
                ViewKt.setVisible(view, false);
                return;
            }
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel.ViewState.Private) {
            View view2 = getView();
            if (view2 != null) {
                ViewKt.setVisible(view2, true);
            }
            GuildChannelSideBarActionsView guildChannelSideBarActionsView = getBinding().f15959b;
            Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsView, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView.setVisibility(8);
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView = getBinding().f15960c;
            Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsView, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView.setVisibility(0);
            WidgetChannelSidebarActionsViewModel.ViewState.Private r2 = (WidgetChannelSidebarActionsViewModel.ViewState.Private) viewState;
            long channelId = r2.getChannelId();
            getBinding().f15960c.m8590a(new ViewOnClickListenerC73371(viewState), new ViewOnClickListenerC73382(viewState), new ViewOnClickListenerC73393(channelId), new ViewOnClickListenerC73404(channelId, requireContext()), r2.isMuted());
            return;
        }
        if (viewState instanceof WidgetChannelSidebarActionsViewModel.ViewState.Guild) {
            WidgetChannelSidebarActionsViewModel.ViewState.Guild guild = (WidgetChannelSidebarActionsViewModel.ViewState.Guild) viewState;
            long channelId2 = guild.getChannelId();
            Context contextRequireContext = requireContext();
            GuildChannelSideBarActionsView guildChannelSideBarActionsView2 = getBinding().f15959b;
            C73415 c73415 = new C73415(viewState, contextRequireContext);
            C73426 c73426 = new C73426(contextRequireContext, viewState);
            C73437 c73437 = new C73437(contextRequireContext, channelId2);
            guildChannelSideBarActionsView2.m8589a(c73415, c73426, new C73448(channelId2), c73437, new C73459(viewState, channelId2, contextRequireContext), guild.getHasUnreadPins(), guild.isMuted(), guild.getDisablePins(), zIsSmallScreen || guild.isGuildForumPost() || guild.isGuildForumChannel());
            View view3 = getView();
            if (view3 != null) {
                ViewKt.setVisible(view3, true);
            }
            PrivateChannelSideBarActionsView privateChannelSideBarActionsView2 = getBinding().f15960c;
            Intrinsics3.checkNotNullExpressionValue(privateChannelSideBarActionsView2, "binding.widgetChannelSidebarActionsPrivateView");
            privateChannelSideBarActionsView2.setVisibility(8);
            GuildChannelSideBarActionsView guildChannelSideBarActionsView3 = getBinding().f15959b;
            Intrinsics3.checkNotNullExpressionValue(guildChannelSideBarActionsView3, "binding.widgetChannelSidebarActionsGuildView");
            guildChannelSideBarActionsView3.setVisibility(guild.getShouldHideChannelSidebar() ^ true ? 0 : 8);
        }
    }

    private final WidgetChannelSidebarActionsBinding getBinding() {
        return (WidgetChannelSidebarActionsBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetChannelSidebarActionsViewModel getViewModel() {
        return (WidgetChannelSidebarActionsViewModel) this.viewModel.getValue();
    }

    private final void startPrivateCall(long channelId, boolean useVideo) {
        Context contextRequireContext = requireContext();
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        PrivateCallLauncher privateCallLauncher = new PrivateCallLauncher(this, this, contextRequireContext, parentFragmentManager);
        if (useVideo) {
            privateCallLauncher.launchVideoCall(channelId);
        } else {
            privateCallLauncher.launchVoiceCall(channelId);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetChannelSidebarActions.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C73461(), 62, (Object) null);
    }
}
