package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventListBottomSheetBinding;
import com.discord.utilities.recycler.SpaceBetweenItemDecoration;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelect;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.voice.VoiceUtils;
import d0.LazyJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Reflection2;
import java.lang.ref.WeakReference;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventListBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildScheduledEventListBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventListBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GuildScheduledEventListAdapter adapter;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, long j, Long l, int i, Object obj) {
            if ((i & 4) != 0) {
                l = null;
            }
            companion.show(fragmentManager, j, l);
        }

        public final void show(FragmentManager fragmentManager, long guildId, Long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet = new WidgetGuildScheduledEventListBottomSheet();
            Bundle bundleT = outline.T("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            if (channelId != null) {
                bundleT.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId.longValue());
            }
            widgetGuildScheduledEventListBottomSheet.setArguments(bundleT);
            widgetGuildScheduledEventListBottomSheet.show(fragmentManager, WidgetGuildScheduledEventListBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$configureUi((WidgetGuildScheduledEventListBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onEventCardClicked", "onEventCardClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onEventCardClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$2, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass2(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onRsvpClicked", "onRsvpClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onRsvpClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$3, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass3 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass3(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onEventStartClicked", "onEventStartClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onEventStartClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$4, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass4 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass4(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onJoinClicked", "onJoinClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onJoinClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$5, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass5 extends FunctionReferenceImpl implements Function1<GuildScheduledEventListItem.Event, Unit> {
        public AnonymousClass5(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
            super(1, widgetGuildScheduledEventListBottomSheet, WidgetGuildScheduledEventListBottomSheet.class, "onShareClicked", "onShareClicked(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListItem$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventListItem.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventListItem.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetGuildScheduledEventListBottomSheet.access$onShareClicked((WidgetGuildScheduledEventListBottomSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetGuildScheduledEventListBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet$onViewCreated$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventLocationSelect.Companion companion = WidgetGuildScheduledEventLocationSelect.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventListBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launch(contextRequireContext, WidgetGuildScheduledEventListBottomSheet.access$getGuildId$p(WidgetGuildScheduledEventListBottomSheet.this), WidgetGuildScheduledEventListBottomSheet.access$getChannelId$p(WidgetGuildScheduledEventListBottomSheet.this));
        }
    }

    public WidgetGuildScheduledEventListBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventListBottomSheet2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildScheduledEventListBottomSheet4(this));
        this.channelId = LazyJVM.lazy(new WidgetGuildScheduledEventListBottomSheet3(this));
        WidgetGuildScheduledEventListBottomSheet6 widgetGuildScheduledEventListBottomSheet6 = new WidgetGuildScheduledEventListBottomSheet6(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventListViewModel.class), new WidgetGuildScheduledEventListBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventListBottomSheet6));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventListBottomSheet5(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListViewModel.ViewState viewState) {
        widgetGuildScheduledEventListBottomSheet.configureUi(viewState);
    }

    public static final /* synthetic */ Long access$getChannelId$p(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        return widgetGuildScheduledEventListBottomSheet.getChannelId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet) {
        return widgetGuildScheduledEventListBottomSheet.getGuildId();
    }

    public static final /* synthetic */ void access$onEventCardClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onEventCardClicked(event);
    }

    public static final /* synthetic */ void access$onEventStartClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onEventStartClicked(event);
    }

    public static final /* synthetic */ void access$onJoinClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onJoinClicked(event);
    }

    public static final /* synthetic */ void access$onRsvpClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onRsvpClicked(event);
    }

    public static final /* synthetic */ void access$onShareClicked(WidgetGuildScheduledEventListBottomSheet widgetGuildScheduledEventListBottomSheet, GuildScheduledEventListItem.Event event) {
        widgetGuildScheduledEventListBottomSheet.onShareClicked(event);
    }

    private final void configureUi(GuildScheduledEventListViewModel.ViewState viewState) {
        if (!(viewState instanceof GuildScheduledEventListViewModel.ViewState.Loaded)) {
            viewState = null;
        }
        GuildScheduledEventListViewModel.ViewState.Loaded loaded = (GuildScheduledEventListViewModel.ViewState.Loaded) viewState;
        if (loaded != null) {
            TextView textView = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventListToolbarTitle");
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textView.setText(StringResourceUtils.getI18nPluralString(contextRequireContext, R.plurals.guild_events_plural_number, loaded.getGuildScheduledEvents().size(), Integer.valueOf(loaded.getGuildScheduledEvents().size())));
            GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
            if (guildScheduledEventListAdapter == null) {
                Intrinsics3.throwUninitializedPropertyAccessException("adapter");
            }
            guildScheduledEventListAdapter.setData(loaded.getGuildScheduledEvents());
            TextView textView2 = getBinding().f2446b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.createEventButton");
            textView2.setVisibility(loaded.getCanCreateEvents() ? 0 : 8);
            ConstraintLayout constraintLayout = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventListEmptyState");
            constraintLayout.setVisibility(loaded.getGuildScheduledEvents().isEmpty() ? 0 : 8);
        }
    }

    private final WidgetGuildScheduledEventListBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventListBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Long getChannelId() {
        return (Long) this.channelId.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildScheduledEventListViewModel getViewModel() {
        return (GuildScheduledEventListViewModel) this.viewModel.getValue();
    }

    private final void onEventCardClicked(GuildScheduledEventListItem.Event item) {
        WidgetGuildScheduledEventDetailsBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        companion.showForGuild(parentFragmentManager, item.getEvent().getId());
    }

    private final void onEventStartClicked(GuildScheduledEventListItem.Event item) {
        if (item.getCanStartEvent()) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, contextRequireContext, GuildScheduledEventModel2.toModel(item.getEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(item.getEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), this.previewLauncher, false, 16, null);
        }
    }

    private final void onJoinClicked(GuildScheduledEventListItem.Event item) {
        Channel channel = item.getChannel();
        if (channel != null) {
            dismiss();
            VoiceUtils.handleCallChannel(channel, this);
        }
    }

    private final void onRsvpClicked(GuildScheduledEventListItem.Event item) {
        if (!item.isRsvped()) {
            AppToast.g(getContext(), R.string.guild_event_interested_notification, 0, null, 12);
        }
        getViewModel().toggleRsvp(item.getEvent());
    }

    private final void onShareClicked(GuildScheduledEventListItem.Event item) {
        getViewModel().onShareClicked(item.getEvent(), new WeakReference<>(requireContext()), new WeakReference<>(this));
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_list_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventListBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventListRecyclerView");
        this.adapter = new GuildScheduledEventListAdapter(recyclerView, new AnonymousClass2(this), new AnonymousClass3(this), new AnonymousClass1(this), new AnonymousClass4(this), new AnonymousClass5(this));
        RecyclerView recyclerView2 = getBinding().d;
        GuildScheduledEventListAdapter guildScheduledEventListAdapter = this.adapter;
        if (guildScheduledEventListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
        Context context = recyclerView2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        int orientation = ((LinearLayoutManager) layoutManager).getOrientation();
        GuildScheduledEventListAdapter guildScheduledEventListAdapter2 = this.adapter;
        if (guildScheduledEventListAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.addItemDecoration(new SpaceBetweenItemDecoration(context, orientation, guildScheduledEventListAdapter2, 0, 0, 24, null));
        recyclerView2.setItemAnimator(null);
        getBinding().f2446b.setOnClickListener(new AnonymousClass7());
    }
}
