package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.list.WidgetChannelsListItemThreadActions;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActiveViewModel;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetThreadBrowserActive.kt */
/* loaded from: classes2.dex */
public final class WidgetThreadBrowserActive extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetThreadBrowserActive.class, "binding", "getBinding()Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private WidgetThreadBrowserAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: browserViewModel$delegate, reason: from kotlin metadata */
    private final Lazy browserViewModel;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetThreadBrowserActive.kt */
    public static final class Companion {
        private Companion() {
        }

        public final WidgetThreadBrowserActive create(long guildId, long channelId) {
            WidgetThreadBrowserActive widgetThreadBrowserActive = new WidgetThreadBrowserActive();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetThreadBrowserActive.setArguments(bundleT);
            return widgetThreadBrowserActive;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetThreadBrowserActive.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetThreadBrowserActiveViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadBrowserActiveViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetThreadBrowserActiveViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetThreadBrowserActive.access$updateView(WidgetThreadBrowserActive.this, viewState);
        }
    }

    /* compiled from: WidgetThreadBrowserActive.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Channel, Unit> {
        public AnonymousClass1(WidgetThreadBrowserViewModel widgetThreadBrowserViewModel) {
            super(1, widgetThreadBrowserViewModel, WidgetThreadBrowserViewModel.class, "openThread", "openThread(Lcom/discord/api/channel/Channel;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "p1");
            ((WidgetThreadBrowserViewModel) this.receiver).openThread(channel);
        }
    }

    /* compiled from: WidgetThreadBrowserActive.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onViewBound$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Channel, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Intrinsics3.checkNotNullParameter(channel, "channel");
            WidgetChannelsListItemThreadActions.Companion companion = WidgetChannelsListItemThreadActions.INSTANCE;
            FragmentManager parentFragmentManager = WidgetThreadBrowserActive.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, channel.getId());
        }
    }

    /* compiled from: WidgetThreadBrowserActive.kt */
    /* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            ChannelSelector.openCreateThread$default(ChannelSelector.INSTANCE.getInstance(), WidgetThreadBrowserActive.access$getGuildId$p(WidgetThreadBrowserActive.this), WidgetThreadBrowserActive.access$getChannelId$p(WidgetThreadBrowserActive.this), null, "Thread Browser Empty State", 4, null);
            WidgetThreadBrowserActive.this.requireAppActivity().finish();
        }
    }

    public WidgetThreadBrowserActive() {
        super(R.layout.widget_thread_browser_active);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetThreadBrowserActive2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetThreadBrowserActive5(this));
        this.channelId = LazyJVM.lazy(new WidgetThreadBrowserActive4(this));
        WidgetThreadBrowserActive6 widgetThreadBrowserActive6 = new WidgetThreadBrowserActive6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserActiveViewModel.class), new WidgetThreadBrowserActive$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetThreadBrowserActive6));
        this.browserViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetThreadBrowserViewModel.class), new WidgetThreadBrowserActive$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetThreadBrowserActive3(this)));
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        return widgetThreadBrowserActive.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserActive widgetThreadBrowserActive) {
        return widgetThreadBrowserActive.getGuildId();
    }

    public static final /* synthetic */ void access$updateView(WidgetThreadBrowserActive widgetThreadBrowserActive, WidgetThreadBrowserActiveViewModel.ViewState viewState) {
        widgetThreadBrowserActive.updateView(viewState);
    }

    private final WidgetThreadBrowserActiveBinding getBinding() {
        return (WidgetThreadBrowserActiveBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetThreadBrowserViewModel getBrowserViewModel() {
        return (WidgetThreadBrowserViewModel) this.browserViewModel.getValue();
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final WidgetThreadBrowserActiveViewModel getViewModel() {
        return (WidgetThreadBrowserActiveViewModel) this.viewModel.getValue();
    }

    private final void updateView(WidgetThreadBrowserActiveViewModel.ViewState viewState) {
        WidgetThreadBrowserAdapter widgetThreadBrowserAdapter = this.adapter;
        if (widgetThreadBrowserAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetThreadBrowserAdapter.setData(viewState.getListItems());
        TextView textView = getBinding().f2668b.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.emptyView.threadBrowserEmptyHeading");
        textView.setText(requireContext().getString(R.string.thread_browser_empty_state_active_header));
        ConstraintLayout constraintLayout = getBinding().f2668b.f196b;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.emptyView.threadBrowserEmpty");
        constraintLayout.setVisibility(viewState.getListItems().isEmpty() ? 0 : 8);
        MaterialButton materialButton = getBinding().f2668b.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.emptyView.threadBrowserEmptyCreateButton");
        materialButton.setVisibility(viewState.getCanCreateThread() ? 0 : 8);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetThreadBrowserActive.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = (WidgetThreadBrowserAdapter) companion.configure(new WidgetThreadBrowserAdapter(recyclerView, new AnonymousClass1(getBrowserViewModel()), new AnonymousClass2()));
        getBinding().f2668b.c.setOnClickListener(new AnonymousClass3());
    }
}
