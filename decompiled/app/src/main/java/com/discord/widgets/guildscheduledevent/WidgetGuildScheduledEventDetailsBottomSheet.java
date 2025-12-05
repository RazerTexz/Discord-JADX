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
import com.discord.C5419R;
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
import com.discord.utilities.extensions.SimpleDraweeViewExtensions;
import com.discord.utilities.font.FontUtils;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities5;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.spans.TypefaceSpanCompat;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
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
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p027k.FormatUtils;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.LazyJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildScheduledEventDetailsBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildScheduledEventDetailsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildScheduledEventDetailsBottomSheetBinding;", 0)};

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
            String strM877t = outline.m877t("EVENTDETAILS-", guildScheduledEventId);
            notices.requestToShow(new StoreNotices.Notice(strM877t, null, 0L, 0, false, CollectionsJVM.listOf(Reflection2.getOrCreateKotlinClass(WidgetHome.class)), 0L, false, 0L, new WidgetGuildScheduledEventDetailsBottomSheet4(guildScheduledEventId, notices, strM877t), 150, null));
        }

        public final void handleInvalidEvent(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppToast.m169g(context, C5419R.string.inaccessible_channel_link_title, 0, null, 12);
        }

        public final void show(FragmentManager fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet2 args) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(args, "args");
            WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet = new WidgetGuildScheduledEventDetailsBottomSheet();
            widgetGuildScheduledEventDetailsBottomSheet.setArguments(AnimatableValueParser.m514e2(args));
            widgetGuildScheduledEventDetailsBottomSheet.show(fragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.class.getName());
        }

        public final void showForDirectory(FragmentManager fragmentManager, long guildScheduledEventId, long hubGuildId, long directoryChannelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new WidgetGuildScheduledEventDetailsBottomSheet2(guildScheduledEventId, Long.valueOf(hubGuildId), Long.valueOf(directoryChannelId), WidgetGuildScheduledEventDetailsBottomSheet3.Directory));
        }

        public final void showForGuild(FragmentManager fragmentManager, long guildScheduledEventId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            show(fragmentManager, new WidgetGuildScheduledEventDetailsBottomSheet2(guildScheduledEventId, null, null, null, 14, null));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GuildScheduledEventDetailsViewModel2.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventDetailsViewModel2.LOADING.ordinal()] = 1;
            iArr[GuildScheduledEventDetailsViewModel2.EMPTY.ordinal()] = 2;
            iArr[GuildScheduledEventDetailsViewModel2.ERROR.ordinal()] = 3;
            iArr[GuildScheduledEventDetailsViewModel2.SUCCESS.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureSegmentControl$1 */
    public static final class C88591 extends Lambda implements Function1<Integer, Unit> {
        public C88591() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            invoke(num.intValue());
            return Unit.f27425a;
        }

        public final void invoke(int i) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).setSegmentedControlIndex(i);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4 */
    public static final class C88604 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ UserGuildMember $creator;

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$4$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.replacementText = C88604.this.$creator.getNickOrUserName();
                Context context = WidgetGuildScheduledEventDetailsBottomSheet.this.getContext();
                if (context != null) {
                    FontUtils fontUtils = FontUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(context, "ctx");
                    Typeface themedFont = fontUtils.getThemedFont(context, C5419R.attr.font_primary_semibold);
                    if (themedFont != null) {
                        hook.styles.add(new TypefaceSpanCompat(themedFont));
                    }
                }
                hook.styles.add(new ForegroundColorSpan(GuildMember.INSTANCE.getColor(C88604.this.$creator.getGuildMember(), ColorCompat.getThemedColor(WidgetGuildScheduledEventDetailsBottomSheet.this.getContext(), C5419R.attr.colorHeaderPrimary))));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C88604(UserGuildMember userGuildMember) {
            super(1);
            this.$creator = userGuildMember;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("usernameHook", new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$configureUi$5 */
    public static final class ViewOnClickListenerC88615 implements View.OnClickListener {
        public ViewOnClickListenerC88615() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onGuildNameClicked();
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1 */
    public static final class ViewOnClickListenerC88621 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$1$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
            }
        }

        public ViewOnClickListenerC88621(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
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
            directoryUtils.maybeJoinAndGoToGuild(widgetGuildScheduledEventDetailsBottomSheet, guildScheduledEvent, zIsInGuild, jLongValue, channelId != null ? channelId.longValue() : 0L, !this.$this_getButtonConfiguration.isRsvped() && GuildScheduledEventUtilities5.canRsvp(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10 */
    public static final class ViewOnClickListenerC886310 implements View.OnClickListener {

        /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
        /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$10$1, reason: invalid class name */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            }
        }

        public ViewOnClickListenerC886310() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModelAccess$getViewModel$p = WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this);
            Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            guildScheduledEventDetailsViewModelAccess$getViewModel$p.endEventClicked(contextRequireContext, new AnonymousClass1());
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$2 */
    public static final class ViewOnClickListenerC88642 implements View.OnClickListener {
        public ViewOnClickListenerC88642() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$3 */
    public static final class ViewOnClickListenerC88653 implements View.OnClickListener {
        public ViewOnClickListenerC88653() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$4 */
    public static final class ViewOnClickListenerC88664 implements View.OnClickListener {
        public ViewOnClickListenerC88664() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$5 */
    public static final class ViewOnClickListenerC88675 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        public ViewOnClickListenerC88675(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
            this.$this_getButtonConfiguration = initialized;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetPreviewGuildScheduledEvent.Companion companion = WidgetPreviewGuildScheduledEvent.INSTANCE;
            Context contextRequireContext = WidgetGuildScheduledEventDetailsBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetPreviewGuildScheduledEvent.Companion.launch$default(companion, contextRequireContext, GuildScheduledEventModel2.toModel(this.$this_getButtonConfiguration.getGuildScheduledEvent()), new WidgetPreviewGuildScheduledEvent.Companion.ExistingEventData(this.$this_getButtonConfiguration.getGuildScheduledEvent().getId(), WidgetPreviewGuildScheduledEvent.Companion.Action.START_EVENT), WidgetGuildScheduledEventDetailsBottomSheet.access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet.this), false, 16, null);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$6 */
    public static final class ViewOnClickListenerC88686 implements View.OnClickListener {
        public ViewOnClickListenerC88686() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onRsvpButtonClicked();
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$7 */
    public static final class ViewOnClickListenerC88697 implements View.OnClickListener {
        public ViewOnClickListenerC88697() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet.this).onShareButtonClicked(new WeakReference<>(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$8 */
    public static final class ViewOnClickListenerC88708 implements View.OnClickListener {
        public ViewOnClickListenerC88708() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetGuildScheduledEventDetailsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventDetailsExtrasBottomSheet.Companion companion = WidgetGuildScheduledEventDetailsExtrasBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, WidgetGuildScheduledEventDetailsBottomSheet.access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet.this));
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$getButtonConfiguration$9 */
    public static final class ViewOnClickListenerC88719 implements View.OnClickListener {
        public final /* synthetic */ GuildScheduledEventDetailsViewModel.ViewState.Initialized $this_getButtonConfiguration;

        public ViewOnClickListenerC88719(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
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
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onResume$1 */
    public static final /* synthetic */ class C88721 extends FunctionReferenceImpl implements Function1<GuildScheduledEventDetailsViewModel.ViewState, Unit> {
        public C88721(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
            super(1, widgetGuildScheduledEventDetailsBottomSheet, WidgetGuildScheduledEventDetailsBottomSheet.class, "configureUi", "configureUi(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildScheduledEventDetailsViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetGuildScheduledEventDetailsBottomSheet.access$configureUi((WidgetGuildScheduledEventDetailsBottomSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetGuildScheduledEventDetailsBottomSheet.kt */
    /* renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet$onViewCreated$1 */
    public static final class C88731 extends Lambda implements Function1<Long, Unit> {
        public C88731() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke(l.longValue());
            return Unit.f27425a;
        }

        public final void invoke(long j) {
            WidgetUserSheet.Companion companion = WidgetUserSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetGuildScheduledEventDetailsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetUserSheet.Companion.show$default(companion, j, null, parentFragmentManager, null, null, null, null, 122, null);
        }
    }

    public WidgetGuildScheduledEventDetailsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildScheduledEventDetailsBottomSheet5.INSTANCE, null, 2, null);
        this.descriptionParser = LazyJVM.lazy(new WidgetGuildScheduledEventDetailsBottomSheet6(this));
        this.locationParser = LazyJVM.lazy(WidgetGuildScheduledEventDetailsBottomSheet7.INSTANCE);
        this.args = LazyJVM.lazy(new C8856x82cb5b4e(this, "intent_args_key"));
        WidgetGuildScheduledEventDetailsBottomSheet9 widgetGuildScheduledEventDetailsBottomSheet9 = new WidgetGuildScheduledEventDetailsBottomSheet9(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildScheduledEventDetailsViewModel.class), new C8858x355f71cf(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildScheduledEventDetailsBottomSheet9));
        this.previewLauncher = WidgetPreviewGuildScheduledEvent.INSTANCE.createJoinOnStartActivityRegistration(this, new WidgetGuildScheduledEventDetailsBottomSheet8(this));
    }

    public static final /* synthetic */ void access$configureUi(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet, GuildScheduledEventDetailsViewModel.ViewState viewState) {
        widgetGuildScheduledEventDetailsBottomSheet.configureUi(viewState);
    }

    public static final /* synthetic */ WidgetGuildScheduledEventDetailsBottomSheet2 access$getArgs$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getArgs();
    }

    public static final /* synthetic */ ActivityResultLauncher access$getPreviewLauncher$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.previewLauncher;
    }

    public static final /* synthetic */ GuildScheduledEventDetailsViewModel access$getViewModel$p(WidgetGuildScheduledEventDetailsBottomSheet widgetGuildScheduledEventDetailsBottomSheet) {
        return widgetGuildScheduledEventDetailsBottomSheet.getViewModel();
    }

    private final void configureForRsvpUsersFetchState(GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState) {
        ProgressBar progressBar = getBinding().f16997s;
        Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.loadingIndicator");
        progressBar.setVisibility(8);
        ConstraintLayout constraintLayout = getBinding().f16992n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout.setVisibility(8);
        RecyclerView recyclerView = getBinding().f16996r;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        recyclerView.setVisibility(8);
        int iOrdinal = rsvpUsersFetchState.ordinal();
        if (iOrdinal == 0) {
            ProgressBar progressBar2 = getBinding().f16997s;
            Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.loadingIndicator");
            progressBar2.setVisibility(0);
            return;
        }
        if (iOrdinal == 1) {
            ConstraintLayout constraintLayout2 = getBinding().f16992n;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventEmptyOrErrorContainer");
            constraintLayout2.setVisibility(0);
            TextView textView = getBinding().f16993o;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventEmptyOrErrorTitle");
            FormatUtils.m222n(textView, C5419R.string.guild_event_details_user_list_fetch_error, new Object[0], null, 4);
            return;
        }
        if (iOrdinal != 2) {
            if (iOrdinal != 3) {
                return;
            }
            RecyclerView recyclerView2 = getBinding().f16996r;
            Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.guildScheduledEventRsvpListRecyclerView");
            recyclerView2.setVisibility(0);
            return;
        }
        ConstraintLayout constraintLayout3 = getBinding().f16992n;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.guildScheduledEventEmptyOrErrorContainer");
        constraintLayout3.setVisibility(0);
        TextView textView2 = getBinding().f16993o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventEmptyOrErrorTitle");
        FormatUtils.m222n(textView2, C5419R.string.guild_event_details_user_list_empty_title, new Object[0], null, 4);
    }

    private final void configureForSection(GuildScheduledEventDetailsViewModel3 section, GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState) {
        GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = GuildScheduledEventDetailsViewModel3.RSVP_LIST;
        if (section == guildScheduledEventDetailsViewModel3) {
            configureForRsvpUsersFetchState(rsvpUsersFetchState);
        }
        ConstraintLayout constraintLayout = getBinding().f16994p;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.guildScheduledEventInfoContainer");
        constraintLayout.setVisibility(section == GuildScheduledEventDetailsViewModel3.EVENT_INFO ? 0 : 8);
        ConstraintLayout constraintLayout2 = getBinding().f16995q;
        Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.guildScheduledEventRsvpListContainer");
        constraintLayout2.setVisibility(section == guildScheduledEventDetailsViewModel3 ? 0 : 8);
    }

    private final void configureSegmentControl(int segmentIndex, boolean hide) {
        SegmentedControlContainer segmentedControlContainer = getBinding().f16998t;
        Intrinsics3.checkNotNullExpressionValue(segmentedControlContainer, "binding.segmentedControl");
        segmentedControlContainer.setVisibility(hide ^ true ? 0 : 8);
        if (hide) {
            return;
        }
        SegmentedControlContainer.m8606b(getBinding().f16998t, 0, 1);
        getBinding().f16998t.setOnSegmentSelectedChangeListener(new C88591());
        getBinding().f16998t.setSelectedIndex(segmentIndex);
        CardSegment cardSegment = getBinding().f16999u;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        cardSegment.setText(FormatUtils.m216h(contextRequireContext, C5419R.string.guild_event_details_info_tab_title, new Object[0], null, 4));
        CardSegment cardSegment2 = getBinding().f17000v;
        Context contextRequireContext2 = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        cardSegment2.setText(FormatUtils.m216h(contextRequireContext2, C5419R.string.indicate_rsvp, new Object[0], null, 4));
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
        getBinding().f16985g.configure(initialized.getGuildScheduledEvent(), false);
        TextView textView = getBinding().f16991m;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.guildScheduledEventDetailsTitleText");
        textView.setText(initialized.getGuildScheduledEvent().getName());
        SimpleDraweeView simpleDraweeView = getBinding().f16987i;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.guildScheduledEventDetailsGuildIcon");
        IconUtils.setIcon$default((ImageView) simpleDraweeView, initialized.getGuild(), 0, (MGImages.ChangeDetector) null, false, 28, (Object) null);
        TextView textView2 = getBinding().f16988j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.guildScheduledEventDetailsGuildName");
        textView2.setText(initialized.getGuild().getName());
        GuildScheduledEventLocationInfo locationInfo = initialized.getLocationInfo();
        if (locationInfo != null) {
            getBinding().f16981c.setImageResource(locationInfo.getLocationIcon());
        }
        ImageView imageView = getBinding().f16981c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.guildScheduledEventDetailsChannelIcon");
        imageView.setVisibility(initialized.getLocationInfo() != null ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().f16982d;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.guildScheduledEventDetailsChannelName");
        GuildScheduledEventLocationInfo locationInfo2 = initialized.getLocationInfo();
        CharSequence charSequenceM216h = null;
        if (locationInfo2 != null) {
            GuildScheduledEventExternalLocationParser locationParser = getLocationParser();
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            textFromLocation = locationParser.getTextFromLocation(contextRequireContext, locationInfo2);
        } else {
            textFromLocation = null;
        }
        ViewExtensions.setTextAndVisibilityBy(linkifiedTextView, textFromLocation);
        ImageView imageView2 = getBinding().f16990l;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.guildScheduledEventDetailsRsvpIcon");
        imageView2.setVisibility(initialized.getGuildScheduledEvent().getUserCount() != null ? 0 : 8);
        TextView textView3 = getBinding().f16989k;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.guildScheduledEventDetailsRsvpCount");
        Integer userCount = initialized.getGuildScheduledEvent().getUserCount();
        if (userCount != null) {
            int iIntValue = userCount.intValue();
            Context contextRequireContext2 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
            Context contextRequireContext3 = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext3, "requireContext()");
            charSequenceM216h = FormatUtils.m216h(contextRequireContext2, C5419R.string.guild_event_interested_count, new Object[]{StringResourceUtils.getI18nPluralString(contextRequireContext3, C5419R.plurals.guild_event_interested_count_count, iIntValue, Integer.valueOf(iIntValue))}, null, 4);
        }
        ViewExtensions.setTextAndVisibilityBy(textView3, charSequenceM216h);
        UserGuildMember creator = initialized.getCreator();
        if (creator != null) {
            TextView textView4 = getBinding().f16983e;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.guildScheduledEventDetailsCreatedBy");
            textView4.setVisibility(0);
            SimpleDraweeView simpleDraweeView2 = getBinding().f16984f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView2.setVisibility(0);
            TextView textView5 = getBinding().f16983e;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.guildScheduledEventDetailsCreatedBy");
            FormatUtils.m221m(textView5, C5419R.string.guild_event_created_by_hook, new Object[]{creator.getNickOrUserName()}, new C88604(creator));
            SimpleDraweeView simpleDraweeView3 = getBinding().f16984f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.guildScheduledEventDetailsCreatorAvatar");
            SimpleDraweeViewExtensions.configureCreator(simpleDraweeView3, creator);
        } else {
            TextView textView6 = getBinding().f16983e;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.guildScheduledEventDetailsCreatedBy");
            textView6.setVisibility(8);
            SimpleDraweeView simpleDraweeView4 = getBinding().f16984f;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.guildScheduledEventDetailsCreatorAvatar");
            simpleDraweeView4.setVisibility(8);
        }
        getDescriptionParser().configureDescription(initialized.getGuildScheduledEvent().getDescription(), initialized.getGuildScheduledEvent().getGuildId());
        GuildScheduledEventBottomButtonView guildScheduledEventBottomButtonView = getBinding().f16980b;
        Intrinsics3.checkNotNullExpressionValue(guildScheduledEventBottomButtonView, "binding.guildScheduledEventDetailsButtonView");
        guildScheduledEventBottomButtonView.setVisibility(0);
        getBinding().f16980b.configureForDetails(getButtonConfiguration(initialized));
        getBinding().f16988j.setOnClickListener(new ViewOnClickListenerC88615());
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        guildScheduledEventRsvpUserListAdapter.setData(initialized.getRsvpUsers());
    }

    private final WidgetGuildScheduledEventDetailsBottomSheet2 getArgs() {
        return (WidgetGuildScheduledEventDetailsBottomSheet2) this.args.getValue();
    }

    private final ButtonConfiguration getButtonConfiguration(GuildScheduledEventDetailsViewModel.ViewState.Initialized initialized) {
        if (getArgs().getSource() == WidgetGuildScheduledEventDetailsBottomSheet3.Directory) {
            return new DirectoryButtonConfiguration(initialized.getGuildScheduledEvent(), initialized.isInGuild(), initialized.isRsvped(), true, new ViewOnClickListenerC88621(initialized), new ViewOnClickListenerC88642(), new ViewOnClickListenerC88653(), new ViewOnClickListenerC88664());
        }
        GuildScheduledEvent guildScheduledEvent = initialized.getGuildScheduledEvent();
        boolean canStartEvent = initialized.getCanStartEvent();
        boolean canConnect = initialized.getCanConnect();
        boolean zIsConnected = initialized.isConnected();
        boolean zIsInGuild = initialized.isInGuild();
        boolean zIsRsvped = initialized.isRsvped();
        ViewOnClickListenerC88675 viewOnClickListenerC88675 = new ViewOnClickListenerC88675(initialized);
        return new GuildButtonConfiguration(guildScheduledEvent, true, canStartEvent, zIsConnected, canConnect, zIsInGuild, zIsRsvped, true, new ViewOnClickListenerC88686(), new ViewOnClickListenerC88719(initialized), new ViewOnClickListenerC886310(), viewOnClickListenerC88675, new ViewOnClickListenerC88697(), new ViewOnClickListenerC88708());
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
        return C5419R.layout.widget_guild_scheduled_event_details_bottom_sheet;
    }

    public final GuildScheduledEventDescriptionParser getDescriptionParser() {
        return (GuildScheduledEventDescriptionParser) this.descriptionParser.getValue();
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildScheduledEventDetailsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C88721(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = getBinding().f16996r;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.guildScheduledEventRsvpListRecyclerView");
        this.adapter = new GuildScheduledEventRsvpUserListAdapter(recyclerView, new C88731());
        RecyclerView recyclerView2 = getBinding().f16996r;
        GuildScheduledEventRsvpUserListAdapter guildScheduledEventRsvpUserListAdapter = this.adapter;
        if (guildScheduledEventRsvpUserListAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView2.setAdapter(guildScheduledEventRsvpUserListAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(recyclerView2.getContext()));
    }
}
