package com.discord.widgets.stage.start;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetModeratorStartStageBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.calls.CallEventsButtonView;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel2;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.stage.start.ModeratorStartStageItem;
import com.discord.widgets.stage.start.ModeratorStartStageViewModel;
import com.discord.widgets.voice.fullscreen.WidgetCallFullscreen;
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

/* compiled from: WidgetModeratorStartStage.kt */
/* loaded from: classes2.dex */
public final class WidgetModeratorStartStage extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetModeratorStartStage.class, "binding", "getBinding()Lcom/discord/databinding/WidgetModeratorStartStageBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private ModeratorStartStageAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetModeratorStartStage.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long channelId, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetModeratorStartStage.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$handleListItemClick$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetModeratorStartStage widgetModeratorStartStage = WidgetModeratorStartStage.this;
            WidgetModeratorStartStage.access$launchStageCall(widgetModeratorStartStage, WidgetModeratorStartStage.access$getChannelId$p(widgetModeratorStartStage));
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBound$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModeratorStartStageItem, Unit> {
        public AnonymousClass1(WidgetModeratorStartStage widgetModeratorStartStage) {
            super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "handleListItemClick", "handleListItemClick(Lcom/discord/widgets/stage/start/ModeratorStartStageItem;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageItem moderatorStartStageItem) {
            invoke2(moderatorStartStageItem);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModeratorStartStageItem moderatorStartStageItem) {
            Intrinsics3.checkNotNullParameter(moderatorStartStageItem, "p1");
            WidgetModeratorStartStage.access$handleListItemClick((WidgetModeratorStartStage) this.receiver, moderatorStartStageItem);
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBound$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetModeratorStartStage.access$getViewModel$p(WidgetModeratorStartStage.this).disconnectFromStage();
            FragmentActivity activity = WidgetModeratorStartStage.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* compiled from: WidgetModeratorStartStage.kt */
    /* renamed from: com.discord.widgets.stage.start.WidgetModeratorStartStage$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ModeratorStartStageViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetModeratorStartStage widgetModeratorStartStage) {
            super(1, widgetModeratorStartStage, WidgetModeratorStartStage.class, "configureUi", "configureUi(Lcom/discord/widgets/stage/start/ModeratorStartStageViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModeratorStartStageViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModeratorStartStageViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetModeratorStartStage.access$configureUi((WidgetModeratorStartStage) this.receiver, viewState);
        }
    }

    public WidgetModeratorStartStage() {
        super(R.layout.widget_moderator_start_stage);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetModeratorStartStage2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetModeratorStartStage3(this));
        this.guildId = LazyJVM.lazy(new WidgetModeratorStartStage4(this));
        WidgetModeratorStartStage6 widgetModeratorStartStage6 = new WidgetModeratorStartStage6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ModeratorStartStageViewModel.class), new WidgetModeratorStartStage$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetModeratorStartStage6));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetModeratorStartStage5(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetModeratorStartStage widgetModeratorStartStage, ModeratorStartStageViewModel.ViewState viewState) {
        widgetModeratorStartStage.configureUi(viewState);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetModeratorStartStage widgetModeratorStartStage) {
        return widgetModeratorStartStage.getChannelId();
    }

    public static final /* synthetic */ ModeratorStartStageViewModel access$getViewModel$p(WidgetModeratorStartStage widgetModeratorStartStage) {
        return widgetModeratorStartStage.getViewModel();
    }

    public static final /* synthetic */ void access$handleListItemClick(WidgetModeratorStartStage widgetModeratorStartStage, ModeratorStartStageItem moderatorStartStageItem) {
        widgetModeratorStartStage.handleListItemClick(moderatorStartStageItem);
    }

    public static final /* synthetic */ void access$launchStageCall(WidgetModeratorStartStage widgetModeratorStartStage, long j) {
        widgetModeratorStartStage.launchStageCall(j);
    }

    private final void configureToolbar(ModeratorStartStageViewModel.ViewState viewState) {
        CallEventsButtonView callEventsButtonView = getBinding().d;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        callEventsButtonView.a(parentFragmentManager, getGuildId(), getChannelId(), viewState.getChannelEvents());
    }

    private final void configureUi(ModeratorStartStageViewModel.ViewState viewState) {
        if (viewState.getChannelEventActive()) {
            launchStageCall(getChannelId());
            return;
        }
        configureToolbar(viewState);
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        moderatorStartStageAdapter.setData(viewState.getItems());
    }

    private final WidgetModeratorStartStageBinding getBinding() {
        return (WidgetModeratorStartStageBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ModeratorStartStageViewModel getViewModel() {
        return (ModeratorStartStageViewModel) this.viewModel.getValue();
    }

    private final void handleListItemClick(ModeratorStartStageItem item) {
        if (item instanceof ModeratorStartStageItem.ListItem.StaticOption.StartStage) {
            WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, getChannelId(), new AnonymousClass1());
            return;
        }
        if (item instanceof ModeratorStartStageItem.ListItem.StaticOption.ScheduleEvent) {
            WidgetGuildScheduledEventLocationSelect.INSTANCE.launch(requireContext(), getGuildId(), Long.valueOf(getChannelId()));
            return;
        }
        if (!(item instanceof ModeratorStartStageItem.ListItem.Event)) {
            if (item instanceof ModeratorStartStageItem.Continue) {
                launchStageCall(getChannelId());
            }
        } else {
            ModeratorStartStageItem.ListItem.Event event = (ModeratorStartStageItem.ListItem.Event) item;
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(WidgetPreviewGuildScheduledEvent.INSTANCE, requireContext(), GuildScheduledEventModel2.toModel(event.getEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(event.getEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), this.previewLauncher, false, 16, null);
        }
    }

    private final void launchStageCall(long channelId) {
        WidgetCallFullscreen.Companion.launch$default(WidgetCallFullscreen.INSTANCE, requireContext(), channelId, true, null, AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE, 8, null);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        RecyclerView recyclerView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.recyclerView");
        this.adapter = new ModeratorStartStageAdapter(recyclerView, new AnonymousClass1(this));
        RecyclerView recyclerView2 = getBinding().c;
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        ModeratorStartStageAdapter moderatorStartStageAdapter = this.adapter;
        if (moderatorStartStageAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(moderatorStartStageAdapter);
        getBinding().f2497b.setOnClickListener(new AnonymousClass3());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetModeratorStartStage.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }
}
