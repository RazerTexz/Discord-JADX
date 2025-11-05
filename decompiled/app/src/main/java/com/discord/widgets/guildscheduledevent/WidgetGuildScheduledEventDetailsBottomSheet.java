package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetGuildScheduledEventDetailsBottomSheetBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.directories.DirectoryUtils;
import com.discord.utilities.extensions.SimpleDraweeViewExtensionsKt;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.segmentedcontrol.CardSegment;
import com.discord.views.segmentedcontrol.SegmentedControlContainer;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsExtrasBottomSheet;
import com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.ButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.DirectoryButtonConfiguration;
import com.discord.widgets.guildscheduledevent.buttonconfiguration.GuildButtonConfiguration;
import com.discord.widgets.home.WidgetHome;
import com.discord.widgets.user.usersheet.WidgetUserSheet;
import com.discord.widgets.voice.VoiceUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g;
import d0.t.m;
import d0.z.d.a0;
import d0.z.d.k;
import d0.z.d.o;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildScheduledEventDetailsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private GuildScheduledEventRsvpUserListAdapter adapter;

    /* renamed from: args$delegate, reason: from kotlin metadata */
    private final Lazy args;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: descriptionParser$delegate, reason: from kotlin metadata */
    private final Lazy descriptionParser;

    /* renamed from: locationParser$delegate, reason: from kotlin metadata */
    private final Lazy locationParser;
    private final ActivityResultLauncher<Intent> previewLauncher;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void enqueue(long guildScheduledEventId) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            String strT = a.t("EVENTDETAILS-", guildScheduledEventId);
            notices.requestToShow(new StoreNotices.Notice(strT, null, 0L, 0, false, m.listOf(a0.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildScheduledEventDetailsBottomSheet$Companion$enqueue$guildScheduledEventDetailsNotice$1(guildScheduledEventId, notices, strT), 150, null));
        }

        public final void handleInvalidEvent(Context context) {
            d0.z.d.m.checkNotNullParameter(context, "context");
            b.a.d.m.g(context, R.string.inaccessible_channel_link_title, 0, null, 12);
        }

        public final void show(FragmentManager fragmentManager, GuildScheduledEventDetailsArgs args) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            d0.z.d.m.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = new WidgetGuildScheduledEventDetailsBottomSheet();
            widgetGuildScheduledEventDetailsBottomSheet.setArguments(d.e2(args));
            widgetGuildScheduledEventDetailsBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.class.getName());
        }

        public final void showForDirectory(FragmentManager fragmentManager, long guildScheduledEventId, long hubGuildId, long directoryChannelId) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new GuildScheduledEventDetailsArgs(guildScheduledEventId, Long.valueOf(hubGuildId), Long.valueOf(directoryChannelId), GuildScheduledEventDetailsSource.Directory));
        }

        public final void showForGuild(FragmentManager fragmentManager, long guildScheduledEventId) {
            d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new GuildScheduledEventDetailsArgs(guildScheduledEventId, null, null, null, 14, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            EventDetailsRsvpUsersFetchState.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[EventDetailsRsvpUsersFetchState.LOADING.ordinal()] = 1;
            iArr[EventDetailsRsvpUsersFetchState.EMPTY.ordinal()] = 2;
            iArr[EventDetailsRsvpUsersFetchState.ERROR.ordinal()] = 3;
            iArr[EventDetailsRsvpUsersFetchState.SUCCESS.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureSegmentControl$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Integer, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.a;
        }

        public final void invoke(int i) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).setSegmentedControlIndex(i);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4, reason: invalid class name */
    public static final class AnonymousClass4 extends o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ UserGuildMember $creator;

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                d0.z.d.m.checkNotNullParameter(hook, "$receiver");
                hook.replacementText = AnonymousClass4.this.$creator.getNickOrUserName();
                Context context = WidgetGuildScheduledEventDetailsBottomSheet.this.getContext();
                if (context != null) {
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    d0.z.d.m.checkNotNullExpressionValue(context, "ctx");
                    Typeface themedFont = fontUtils.getThemedFont(context, R.attr.font_primary_semibold);
                    if (themedFont != null) {
                        hook.styles.add(new TypefaceSpanCompat(themedFont));
                    }
                }
                hook.styles.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(AnonymousClass4.this.$creator.getGuildMember(), ColorCompat.getThemedColor(WidgetGuildScheduledEventDetailsBottomSheet.this.getContext(), R.attr.colorHeaderPrimary))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(UserGuildMember userGuildMember) {
            super(1);
            this.$creator = userGuildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            d0.z.d.m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("usernameHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onGuildNameClicked();
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04151 extends o implements Function0<Unit> {
            public C04151() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
            }
        }

        public AnonymousClass1(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            DirectoryUtils directoryUtils = DirectoryUtils.INSTANCE;
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = WidgetGuildScheduledEventDetailsBottomSheet.this;
            GuildScheduledEvent guildScheduledEvent = this.$this_getButtonConfiguration.getGuildScheduledEvent();
            boolean zIsInGuild = this.$this_getButtonConfiguration.isInGuild();
            Long guildId = WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this).getGuildId();
            long jLongValue = guildId != null ? guildId.longValue() : 0L;
            Long channelId = WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this).getChannelId();
            directoryUtils.maybeJoinAndGoToGuild(widgetGuildScheduledEventDetailsBottomSheet, guildScheduledEvent, zIsInGuild, jLongValue, channelId != null ? channelId.longValue() : 0L, !this.$this_getButtonConfiguration.isRsvped() && GuildScheduledEventUtilitiesKt.canRsvp(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new C04151());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10, reason: invalid class name */
    public static final class AnonymousClass10 implements View.OnClickListener {

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10$1, reason: invalid class name */
        public static final class AnonymousClass1 extends o implements Function0<Unit> {
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
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            }
        }

        public AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            guildScheduledEventDetailsViewModelAccess$getViewModel$p.endEventClicked(contextRequireContext, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public AnonymousClass4() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        public AnonymousClass5(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, contextRequireContext, GuildScheduledEventModelKt.toModel(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(this.$this_getButtonConfiguration.getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), WidgetGuildScheduledEventDetailsBottomSheet.access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet.this), false, 16, null);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$6, reason: invalid class name */
    public static final class AnonymousClass6 implements View.OnClickListener {
        public AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public AnonymousClass8() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$9, reason: invalid class name */
    public static final class AnonymousClass9 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        public AnonymousClass9(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            Channel channel = this.$this_getButtonConfiguration.getChannel();
            if (channel != null) {
                VoiceUtils.handleCallChannel(channel, WidgetGuildScheduledEventDetailsBottomSheet.this);
            }
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onResume$1, reason: invalid class name */
    public static final /* synthetic */ class AnonymousClass1 extends k implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public AnonymousClass1(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsBottomSheet, WidgetGuildScheduledEventDetailsBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            d0.z.d.m.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventDetailsBottomSheet.access$configureUi((WidgetGuildScheduledEventDetailsBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Long, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            d0.z.d.m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildScheduledEventDetailsBottomSheet$binding$2.INSTANCE, null, 2, null);
        this.descriptionParser = g.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$descriptionParser$2(this));
        this.locationParser = g.lazy(WidgetGuildScheduledEventDetailsBottomSheet$locationParser$2.INSTANCE);
        this.args = g.lazy(new WidgetGuildScheduledEventDetailsBottomSheet$$special$$inlined$args$1(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2 widgetGuildScheduledEventDetailsBottomSheet$viewModel$2 = new WidgetGuildScheduledEventDetailsBottomSheet$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new WidgetGuildScheduledEventDetailsBottomSheet$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetGuildScheduledEventDetailsBottomSheet$viewModel$2));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsBottomSheet$previewLauncher$1(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel.ViewState viewState) {
        widgetGuildScheduledEventDetailsBottomSheet.configureUi(viewState);
    }

    public static final /* synthetic */ GuildScheduledEventDetailsArgs access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getArgs();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventDetailsViewModel access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getViewModel();
    }

    private final void configureForRsvpUsersFetchState(EventDetailsRsvpUsersFetchState rsvpUsersFetchState) {
        ProgressBar progressBar = getBinding().f2444s;
        d0.z.d.m.checkNotNullExpressionValue(progressBar, "binding.loadingIndicator");
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().n;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().r;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        recyclerView.setVisibility(8);
        int iOrdinal = rsvpUsersFetchState.ordinal();
        if (iOrdinal == 0) {
            ProgressBar progressBar2 = getBinding().f2444s;
            d0.z.d.m.checkNotNullExpressionValue(progressBar2, "binding.loadingIndicator");
            progressBar2.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            ConstraintLayout constraintLayout2 = getBinding().n;
            d0.z.d.m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventEmptyOrErrorContainer");
            constraintLayout2.setVisibility(0);
            TextView textView = getBinding().o;
            d0.z.d.m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventEmptyOrErrorTitle");
            b.n(textView, R.string.guild_event_details_user_list_fetch_error, new Object[0], null, 4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            RecyclerView recyclerView2 = getBinding().r;
            d0.z.d.m.checkNotNullExpressionValue(recyclerView2, "binding.guildScheduledEventRsvpListRecyclerView");
            recyclerView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout3 = getBinding().n;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout3.setVisibility(0);
        TextView textView2 = getBinding().o;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventEmptyOrErrorTitle");
        b.n(textView2, R.string.guild_event_details_user_list_empty_title, new Object[0], null, 4);
    }

    private final void configureForSection(EventDetailsSection section, EventDetailsRsvpUsersFetchState rsvpUsersFetchState) {
        EventDetailsSection eventDetailsSection = EventDetailsSection.RSVP_LIST;
        if (section == eventDetailsSection) {
            configureForRsvpUsersFetchState(rsvpUsersFetchState);
        }
        ConstraintLayout constraintLayout = getBinding().p;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventInfoContainer");
        constraintLayout.setVisibility(section == EventDetailsSection.EVENT_INFO ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().q;
        d0.z.d.m.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventRsvpListContainer");
        constraintLayout2.setVisibility(section == eventDetailsSection ? 0 : 8);
    }

    private final void configureSegmentControl(int segmentIndex, boolean hide) {
        SegmentedControlContainer segmentedControlContainer = getBinding().t;
        d0.z.d.m.checkNotNullExpressionValue(segmentedControlContainer, "binding.segmentedControl");
        segmentedControlContainer.setVisibility(hide ^ true ? 0 : 8);
        if (hide) {
            return;
        }
        SegmentedControlContainer.b(getBinding().t, 0, 1);
        getBinding().t.setOnSegmentSelectedChangeListener(new AnonymousClass1());
        getBinding().t.setSelectedIndex(segmentIndex);
        CardSegment cardSegment = getBinding().u;
        Context contextRequireContext = requireContext();
        d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        cardSegment.setText(b.h(contextRequireContext, R.string.guild_event_details_info_tab_title, new Object[0], null, 4));
        CardSegment cardSegment2 = getBinding().v;
        Context contextRequireContext2 = requireContext();
        d0.z.d.m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        cardSegment2.setText(b.h(contextRequireContext2, R.string.indicate_rsvp, new Object[0], null, 4));
    }

    private final void configureUi(GuildScheduledEventDetailsViewModel.ViewState viewState) {
        CharSequence textFromLocation;
        if (!(viewState instanceof GuildScheduledEventDetailsViewModel.ViewState.Initialized)) {
            dismiss();
            return;
        }
        GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized = (GuildScheduledEventDetailsViewModel.ViewState.Initialized) viewState;
        configureSegmentControl(initialized.getSegmentedControlIndex(), !initialized.isInGuild());
        configureForSection(initialized.getSection(), initialized.getRsvpUsersFetchState());
        getBinding().g.configure(initialized.getGuildScheduledEvent(), false);
        TextView textView = getBinding().m;
        d0.z.d.m.checkNotNullExpressionValue(textView, "binding.guildScheduledEventDetailsTitleText");
        textView.setText(initialized.getGuildScheduledEvent().getName());
        SimpleDraweeView simpleDraweeView = getBinding().i;
        d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventDetailsGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, initialized.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        TextView textView2 = getBinding().j;
        d0.z.d.m.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventDetailsGuildName");
        textView2.setText(initialized.getGuild().getName());
        GuildScheduledEventLocationInfo locationInfo = initialized.getLocationInfo();
        if (locationInfo != null) {
            getBinding().c.setImageResource(locationInfo.getLocationIcon());
        }
        ImageView imageView = getBinding().c;
        d0.z.d.m.checkNotNullExpressionValue(imageView, "binding.guildScheduledEventDetailsChannelIcon");
        imageView.setVisibility(initialized.getLocationInfo() != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().d;
        d0.z.d.m.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsChannelName");
        GuildScheduledEventLocationInfo locationInfo2 = initialized.getLocationInfo();
        CharSequence charSequenceH = null;
        if (locationInfo2 != null) {
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context contextRequireContext = requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textFromLocation = locationParser.getTextFromLocation(contextRequireContext, locationInfo2);
        } else {
            textFromLocation = null;
        }
        ViewExtensions.setTextAndVisibilityBy(linkifiedTextView, textFromLocation);
        ImageView imageView2 = getBinding().l;
        d0.z.d.m.checkNotNullExpressionValue(imageView2, "binding.guildScheduledEventDetailsRsvpIcon");
        imageView2.setVisibility(initialized.getGuildScheduledEvent().getUserCount() != null ? 0 : 8);
        TextView textView3 = getBinding().k;
        d0.z.d.m.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventDetailsRsvpCount");
        Integer userCount = initialized.getGuildScheduledEvent().getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context contextRequireContext2 = requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            Context contextRequireContext3 = requireContext();
            d0.z.d.m.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            charSequenceH = b.h(contextRequireContext2, R.string.guild_event_interested_count, new Object[]{StringResourceUtilsKt.getI18nPluralString(contextRequireContext3, R.plurals.guild_event_interested_count_count, iIntValue, Integer.valueOf(iIntValue))}, null, 4);
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceH);
        UserGuildMember creator = initialized.getCreator();
        if (creator != null) {
            TextView textView4 = getBinding().e;
            d0.z.d.m.checkNotNullExpressionValue(textView4, "binding.guildScheduledEventDetailsCreatedBy");
            textView4.setVisibility(0);
            SimpleDraweeView simpleDraweeView2 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView2.setVisibility(0);
            TextView textView5 = getBinding().e;
            d0.z.d.m.checkNotNullExpressionValue(textView5, "binding.guildScheduledEventDetailsCreatedBy");
            b.m(textView5, R.string.guild_event_created_by_hook, new Object[]{creator.getNickOrUserName()}, new AnonymousClass4(creator));
            SimpleDraweeView simpleDraweeView3 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventDetailsCreatorAvatar");
            SimpleDraweeViewExtensionsKt.configureCreator(simpleDraweeView3, creator);
        } else {
            TextView textView6 = getBinding().e;
            d0.z.d.m.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventDetailsCreatedBy");
            textView6.setVisibility(8);
            SimpleDraweeView simpleDraweeView4 = getBinding().f;
            d0.z.d.m.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView4.setVisibility(8);
        }
        getDescriptionParser().configureDescription(initialized.getGuildScheduledEvent().getDescription(), initialized.getGuildScheduledEvent().getGuildId());
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = getBinding().f2443b;
        d0.z.d.m.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventDetailsButtonView");
        guildScheduledEventBottomButtonView.setVisibility(0);
        getBinding().f2443b.configureForDetails(getButtonConfiguration(initialized));
        getBinding().j.setOnClickListener(new AnonymousClass5());
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("adapter");
        }
        guildScheduledEventRsvpUserListAdapter.setData(initialized.getRsvpUsers());
    }

    private final GuildScheduledEventDetailsArgs getArgs() {
        return (GuildScheduledEventDetailsArgs) this.args.getValue();
    }

    private final ButtonConfiguration getButtonConfiguration(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
        if (getArgs().getSource() == GuildScheduledEventDetailsSource.Directory) {
            return new DirectoryButtonConfiguration(initialized.getGuildScheduledEvent(), initialized.isInGuild(), initialized.isRsvped(), true, new AnonymousClass1(initialized), new AnonymousClass2(), new AnonymousClass3(), new AnonymousClass4());
        }
        GuildScheduledEvent guildScheduledEvent = initialized.getGuildScheduledEvent();
        boolean canStartEvent = initialized.getCanStartEvent();
        boolean canConnect = initialized.getCanConnect();
        boolean zIsConnected = initialized.isConnected();
        boolean zIsInGuild = initialized.isInGuild();
        boolean zIsRsvped = initialized.isRsvped();
        AnonymousClass5 anonymousClass5 = new AnonymousClass5(initialized);
        return new GuildButtonConfiguration(guildScheduledEvent, true, canStartEvent, zIsConnected, canConnect, zIsInGuild, zIsRsvped, true, new AnonymousClass6(), new AnonymousClass9(initialized), new AnonymousClass10(), anonymousClass5, new AnonymousClass7(), new AnonymousClass8());
    }

    private final GuildScheduledEventExternalLocationParser getLocationParser() {
        return (GuildScheduledEventExternalLocationParser) this.locationParser.getValue();
    }

    private final GuildScheduledEventDetailsViewModel getViewModel() {
        return (GuildScheduledEventDetailsViewModel) this.viewModel.getValue();
    }

    public final WidgetGuildScheduledEventDetailsBottomSheetBinding getBinding() {
        return (WidgetGuildScheduledEventDetailsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_guild_scheduled_event_details_bottom_sheet;
    }

    public final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventDetailsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().r;
        d0.z.d.m.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        this.adapter = new GuildScheduledEventRsvpUserListAdapter(recyclerView, new AnonymousClass1());
        RecyclerView recyclerView2 = getBinding().r;
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            d0.z.d.m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventRsvpUserListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
    }
}
