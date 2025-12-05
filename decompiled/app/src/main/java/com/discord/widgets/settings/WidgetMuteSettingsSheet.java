package com.discord.widgets.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetMuteSettingsSheetBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import com.discord.widgets.settings.MuteSettingsSheetViewModel;
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
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p658rx.subscriptions.CompositeSubscription;

/* compiled from: WidgetMuteSettingsSheet.kt */
/* loaded from: classes2.dex */
public final class WidgetMuteSettingsSheet extends AppBottomSheet {
    private static final float ACTIVE_OPACITY = 1.0f;
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";
    private static final String ARG_GUILD_ID = "ARG_GUILD_ID";
    private static final float INACTIVE_OPACITY = 0.2f;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetMuteSettingsSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetMuteSettingsSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetMuteSettingsSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void showForChannel(long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_CHANNEL_ID, channelId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public final void showForGuild(long guildId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetMuteSettingsSheet widgetMuteSettingsSheet = new WidgetMuteSettingsSheet();
            Bundle bundle = new Bundle();
            bundle.putLong(WidgetMuteSettingsSheet.ARG_GUILD_ID, guildId);
            widgetMuteSettingsSheet.setArguments(bundle);
            widgetMuteSettingsSheet.show(fragmentManager, WidgetMuteSettingsSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            MuteSettingsSheetViewModel.SettingsType settingsType = MuteSettingsSheetViewModel.SettingsType.GUILD;
            iArr[settingsType.ordinal()] = 1;
            MuteSettingsSheetViewModel.SettingsType settingsType2 = MuteSettingsSheetViewModel.SettingsType.DM;
            iArr[settingsType2.ordinal()] = 2;
            MuteSettingsSheetViewModel.SettingsType settingsType3 = MuteSettingsSheetViewModel.SettingsType.GROUP_DM;
            iArr[settingsType3.ordinal()] = 3;
            iArr[MuteSettingsSheetViewModel.SettingsType.GUILD_CHANNEL.ordinal()] = 4;
            iArr[MuteSettingsSheetViewModel.SettingsType.THREAD.ordinal()] = 5;
            MuteSettingsSheetViewModel.SettingsType settingsType4 = MuteSettingsSheetViewModel.SettingsType.CATEGORY;
            iArr[settingsType4.ordinal()] = 6;
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[settingsType3.ordinal()] = 1;
            iArr2[settingsType2.ordinal()] = 2;
            MuteSettingsSheetViewModel.SettingsType.values();
            int[] iArr3 = new int[7];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[settingsType2.ordinal()] = 1;
            iArr3[settingsType3.ordinal()] = 2;
            iArr3[settingsType.ordinal()] = 3;
            iArr3[settingsType4.ordinal()] = 4;
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$1 */
    public static final class ViewOnClickListenerC95991 implements View.OnClickListener {
        public ViewOnClickListenerC95991() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.unmute(context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$2 */
    public static final /* synthetic */ class C96002 extends FunctionReferenceImpl implements Function1<MuteSettingsSheetViewModel.ViewState, Unit> {
        public C96002(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "updateViews", "updateViews(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            WidgetMuteSettingsSheet.access$updateViews((WidgetMuteSettingsSheet) this.receiver, viewState);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$bindSubscriptions$3 */
    public static final /* synthetic */ class C96013 extends FunctionReferenceImpl implements Function1<MuteSettingsSheetViewModel.Event, Unit> {
        public C96013(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
            super(1, widgetMuteSettingsSheet, WidgetMuteSettingsSheet.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/MuteSettingsSheetViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(MuteSettingsSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(MuteSettingsSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            WidgetMuteSettingsSheet.access$handleEvent((WidgetMuteSettingsSheet) this.receiver, event);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureNotificationSettings$1 */
    public static final class C96021 extends Lambda implements Function1<RenderContext, Unit> {
        public C96021() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.boldColor = Integer.valueOf(ColorCompat.getColor(WidgetMuteSettingsSheet.this.requireContext(), C5419R.color.status_red_500));
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$configureNotificationSettings$2 */
    public static final class ViewOnClickListenerC96032 implements View.OnClickListener {
        public ViewOnClickListenerC96032() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this).onChannelSettingsSelected();
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$1 */
    public static final class ViewOnClickListenerC96051 implements View.OnClickListener {
        public ViewOnClickListenerC96051() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(900000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$2 */
    public static final class ViewOnClickListenerC96062 implements View.OnClickListener {
        public ViewOnClickListenerC96062() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(3600000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$3 */
    public static final class ViewOnClickListenerC96073 implements View.OnClickListener {
        public ViewOnClickListenerC96073() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(28800000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$4 */
    public static final class ViewOnClickListenerC96084 implements View.OnClickListener {
        public ViewOnClickListenerC96084() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(86400000L, context);
        }
    }

    /* compiled from: WidgetMuteSettingsSheet.kt */
    /* renamed from: com.discord.widgets.settings.WidgetMuteSettingsSheet$onViewCreated$5 */
    public static final class ViewOnClickListenerC96095 implements View.OnClickListener {
        public ViewOnClickListenerC96095() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            MuteSettingsSheetViewModel muteSettingsSheetViewModelAccess$getViewModel$p = WidgetMuteSettingsSheet.access$getViewModel$p(WidgetMuteSettingsSheet.this);
            Intrinsics3.checkNotNullExpressionValue(view, "it");
            Context context = view.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "it.context");
            muteSettingsSheetViewModelAccess$getViewModel$p.selectMuteDurationMs(0L, context);
        }
    }

    public WidgetMuteSettingsSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetMuteSettingsSheet2.INSTANCE, null, 2, null);
        WidgetMuteSettingsSheet4 widgetMuteSettingsSheet4 = new WidgetMuteSettingsSheet4(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(MuteSettingsSheetViewModel.class), new WidgetMuteSettingsSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetMuteSettingsSheet4));
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetMuteSettingsSheetBinding access$getBinding$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getBinding();
    }

    public static final /* synthetic */ MuteSettingsSheetViewModel access$getViewModel$p(WidgetMuteSettingsSheet widgetMuteSettingsSheet) {
        return widgetMuteSettingsSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetMuteSettingsSheet widgetMuteSettingsSheet, MuteSettingsSheetViewModel.Event event) {
        widgetMuteSettingsSheet.handleEvent(event);
    }

    public static final /* synthetic */ void access$updateViews(WidgetMuteSettingsSheet widgetMuteSettingsSheet, MuteSettingsSheetViewModel.ViewState viewState) {
        widgetMuteSettingsSheet.updateViews(viewState);
    }

    private final void configureNotificationSettings(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        TextView textView = getBinding().f17280g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.notificationSettingsOverridesLabel");
        int notificationSetting = viewState.getNotificationSetting();
        textView.setText(notificationSetting == ModelNotificationSettings.FREQUENCY_ALL ? FormatUtils.m219k(this, C5419R.string.form_label_all_messages_short, new Object[0], null, 4) : notificationSetting == ModelNotificationSettings.FREQUENCY_MENTIONS ? FormatUtils.m219k(this, C5419R.string.form_label_only_mentions_short, new Object[0], null, 4) : notificationSetting == ModelNotificationSettings.FREQUENCY_NOTHING ? FormatUtils.m219k(this, C5419R.string.form_label_nothing, new Object[0], null, 4) : "");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal != 0) {
            boolean z2 = true;
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 5) {
                if (!viewState.isChannelMuted() && !viewState.isGuildMuted()) {
                    z2 = false;
                }
                if (z2) {
                    TextView textView2 = getBinding().f17279f;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.notificationSettingsLabel");
                    textView2.setAlpha(0.2f);
                    getBinding().f17277d.setOnClickListener(null);
                    TextView textView3 = getBinding().f17275b;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.channelMutedDetails");
                    textView3.setVisibility(0);
                    TextView textView4 = getBinding().f17275b;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.channelMutedDetails");
                    textView4.setText(viewState.isChannelMuted() ? FormatUtils.m219k(this, C5419R.string.form_description_mobile_notification_muted, new Object[0], null, 4) : FormatUtils.m213e(this, C5419R.string.form_label_mobile_channel_override_guild_muted, new Object[0], new C96021()));
                } else {
                    TextView textView5 = getBinding().f17279f;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.notificationSettingsLabel");
                    textView5.setAlpha(1.0f);
                    getBinding().f17277d.setOnClickListener(new ViewOnClickListenerC96032());
                    TextView textView6 = getBinding().f17275b;
                    Intrinsics3.checkNotNullExpressionValue(textView6, "binding.channelMutedDetails");
                    textView6.setVisibility(8);
                }
                FrameLayout frameLayout = getBinding().f17278e;
                Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.notificationSettingsButtonContainer");
                frameLayout.setVisibility(0);
                return;
            }
        }
        FrameLayout frameLayout2 = getBinding().f17278e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.notificationSettingsButtonContainer");
        frameLayout2.setVisibility(8);
        TextView textView7 = getBinding().f17275b;
        Intrinsics3.checkNotNullExpressionValue(textView7, "binding.channelMutedDetails");
        textView7.setVisibility(8);
    }

    private final void configureUnmuteButton(MuteSettingsSheetViewModel.ViewState.Loaded viewState) {
        CharSequence charSequenceM213e;
        WidgetMuteSettingsSheet3 widgetMuteSettingsSheet3 = new WidgetMuteSettingsSheet3(this);
        if (!viewState.isChannelMuted()) {
            LinearLayout linearLayout = getBinding().f17288o;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.unmuteButton");
            linearLayout.setVisibility(8);
            LinearLayout linearLayout2 = getBinding().f17276c;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.muteSettingsSheetMuteOptions");
            linearLayout2.setVisibility(0);
            return;
        }
        TextView textView = getBinding().f17290q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.unmuteButtonLabel");
        FormatUtils.m221m(textView, C5419R.string.unmute_channel, new Object[]{viewState.getSubtitle()}, widgetMuteSettingsSheet3);
        TextView textView2 = getBinding().f17289p;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.unmuteButtonDetailsLabel");
        int iOrdinal = viewState.getSettingsType().ordinal();
        if (iOrdinal == 1 || iOrdinal == 2) {
            String muteEndTime = viewState.getMuteEndTime();
            charSequenceM213e = muteEndTime == null ? FormatUtils.m213e(this, C5419R.string.form_label_mobile_dm_muted, new Object[0], widgetMuteSettingsSheet3) : FormatUtils.m213e(this, C5419R.string.form_label_mobile_dm_muted_until, new Object[]{parseMuteEndtime(muteEndTime)}, widgetMuteSettingsSheet3);
        } else {
            String muteEndTime2 = viewState.getMuteEndTime();
            charSequenceM213e = muteEndTime2 == null ? FormatUtils.m213e(this, C5419R.string.form_label_mobile_channel_muted, new Object[0], widgetMuteSettingsSheet3) : FormatUtils.m213e(this, C5419R.string.form_label_mobile_channel_muted_until, new Object[]{parseMuteEndtime(muteEndTime2)}, widgetMuteSettingsSheet3);
        }
        textView2.setText(charSequenceM213e);
        LinearLayout linearLayout3 = getBinding().f17288o;
        Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.unmuteButton");
        linearLayout3.setVisibility(0);
        LinearLayout linearLayout4 = getBinding().f17276c;
        Intrinsics3.checkNotNullExpressionValue(linearLayout4, "binding.muteSettingsSheetMuteOptions");
        linearLayout4.setVisibility(8);
    }

    private final WidgetMuteSettingsSheetBinding getBinding() {
        return (WidgetMuteSettingsSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final MuteSettingsSheetViewModel getViewModel() {
        return (MuteSettingsSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(MuteSettingsSheetViewModel.Event event) {
        if (event instanceof MuteSettingsSheetViewModel.Event.Dismiss) {
            dismiss();
        } else if (event instanceof MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) {
            WidgetChannelNotificationSettings.Companion companion = WidgetChannelNotificationSettings.INSTANCE;
            Context contextRequireContext = requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            WidgetChannelNotificationSettings.Companion.launch$default(companion, contextRequireContext, ((MuteSettingsSheetViewModel.Event.NavigateToChannelSettings) event).getChannelId(), false, 4, null);
        }
    }

    private final String parseMuteEndtime(String muteEndTime) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        return TimeUtils.renderUtcDateTime$default(timeUtils, muteEndTime, contextRequireContext, null, 3, 3, 4, null);
    }

    public static final void showForChannel(long j, FragmentManager fragmentManager) {
        INSTANCE.showForChannel(j, fragmentManager);
    }

    private final void updateViews(MuteSettingsSheetViewModel.ViewState viewState) {
        if (!(viewState instanceof MuteSettingsSheetViewModel.ViewState.Loaded)) {
            if (viewState instanceof MuteSettingsSheetViewModel.ViewState.Failure) {
                AppToast.m171i(this, C5419R.string.default_failure_to_perform_action_message, 0, 4);
                dismiss();
                return;
            }
            return;
        }
        MuteSettingsSheetViewModel.ViewState.Loaded loaded = (MuteSettingsSheetViewModel.ViewState.Loaded) viewState;
        int iOrdinal = loaded.getSettingsType().ordinal();
        Integer numValueOf = iOrdinal != 0 ? (iOrdinal == 1 || iOrdinal == 2) ? Integer.valueOf(C5419R.string.mute_settings_mute_this_conversation) : iOrdinal != 3 ? iOrdinal != 4 ? iOrdinal != 5 ? null : Integer.valueOf(C5419R.string.mute_settings_mute_category) : Integer.valueOf(C5419R.string.mute_settings_mute_channel) : Integer.valueOf(C5419R.string.mute_settings_mute_thread) : Integer.valueOf(C5419R.string.mute_settings_mute_server);
        TextView textView = getBinding().f17287n;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(numValueOf != null ? FormatUtils.m219k(this, numValueOf.intValue(), new Object[0], null, 4) : null);
        TextView textView2 = getBinding().f17286m;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.subtitle");
        textView2.setText(loaded.getSubtitle());
        configureUnmuteButton(loaded);
        configureNotificationSettings(loaded);
    }

    @Override // com.discord.app.AppBottomSheet
    public void bindSubscriptions(CompositeSubscription compositeSubscription) {
        Intrinsics3.checkNotNullParameter(compositeSubscription, "compositeSubscription");
        super.bindSubscriptions(compositeSubscription);
        getBinding().f17288o.setOnClickListener(new ViewOnClickListenerC95991());
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetMuteSettingsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96002(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetMuteSettingsSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C96013(this), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_mute_settings_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getBinding().f17283j.setOnClickListener(new ViewOnClickListenerC96051());
        getBinding().f17284k.setOnClickListener(new ViewOnClickListenerC96062());
        getBinding().f17282i.setOnClickListener(new ViewOnClickListenerC96073());
        getBinding().f17285l.setOnClickListener(new ViewOnClickListenerC96084());
        getBinding().f17281h.setOnClickListener(new ViewOnClickListenerC96095());
    }
}
