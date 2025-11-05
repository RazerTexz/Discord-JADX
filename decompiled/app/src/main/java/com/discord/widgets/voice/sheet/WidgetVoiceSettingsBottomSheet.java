package com.discord.widgets.voice.sheet;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetVoiceSettingsBottomSheetBinding;
import com.discord.models.guild.Guild;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventListBottomSheet;
import com.discord.widgets.mobile_reports.WidgetMobileReports;
import com.discord.widgets.settings.WidgetSettingsVoice;
import com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet;
import com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheetViewModel;
import com.google.android.material.switchmaterial.SwitchMaterial;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetVoiceSettingsBottomSheet.kt */
/* loaded from: classes.dex */
public final class WidgetVoiceSettingsBottomSheet extends AppBottomSheet {
    private static final String ANALYTICS_SOURCE = "Voice Call";
    private static final String ARG_CHANNEL_ID = "ARG_CHANNEL_ID";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetVoiceSettingsBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetVoiceSettingsBottomSheetBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void show$default(Companion companion, Long l, FragmentManager fragmentManager, int i, Object obj) {
            if ((i & 1) != 0) {
                l = null;
            }
            companion.show(l, fragmentManager);
        }

        public final void show(Long channelId, FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet = new WidgetVoiceSettingsBottomSheet();
            Bundle bundle = new Bundle();
            if (channelId != null) {
                bundle.putLong(WidgetVoiceSettingsBottomSheet.ARG_CHANNEL_ID, channelId.longValue());
            }
            widgetVoiceSettingsBottomSheet.setArguments(bundle);
            widgetVoiceSettingsBottomSheet.show(fragmentManager, WidgetVoiceSettingsBottomSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    public interface ViewState {
        Channel getChannel();

        Guild getGuild();

        boolean getNoiseCancellationEnabled();

        boolean getShowInviteItem();

        boolean getShowReportItem();

        boolean getShowStageSettings();

        boolean getShowVoiceParticipants();

        boolean getShowVoiceParticipantsToggle();
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ ViewState $viewState;

        public AnonymousClass1(ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            ChannelInviteLaunchUtils.inviteToChannel$default(ChannelInviteLaunchUtils.INSTANCE, WidgetVoiceSettingsBottomSheet.this, this.$viewState.getChannel(), WidgetVoiceSettingsBottomSheet.ANALYTICS_SOURCE, null, null, 24, null);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.access$getViewModel$p(WidgetVoiceSettingsBottomSheet.this).onToggleVoiceParticipantsHidden();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            WidgetStageStartEventBottomSheet.Companion companion = WidgetStageStartEventBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetStageStartEventBottomSheet.Companion.show$default(companion, parentFragmentManager, WidgetVoiceSettingsBottomSheet.access$getChannelId$p(WidgetVoiceSettingsBottomSheet.this), null, 4, null);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ ViewState $viewState;

        public AnonymousClass4(ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            WidgetGuildScheduledEventListBottomSheet.Companion companion = WidgetGuildScheduledEventListBottomSheet.INSTANCE;
            FragmentManager parentFragmentManager = WidgetVoiceSettingsBottomSheet.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, this.$viewState.getChannel().getGuildId(), Long.valueOf(this.$viewState.getChannel().getId()));
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public AnonymousClass5() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.this.dismiss();
            WidgetSettingsVoice.Companion companion = WidgetSettingsVoice.INSTANCE;
            TextView textView = WidgetVoiceSettingsBottomSheet.access$getBinding$p(WidgetVoiceSettingsBottomSheet.this).i;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceSettingsVoiceSettings");
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "binding.voiceSettingsVoiceSettings.context");
            WidgetSettingsVoice.Companion.launch$default(companion, context, null, false, 6, null);
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7 implements View.OnClickListener {
        public AnonymousClass7() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetVoiceSettingsBottomSheet.access$getViewModel$p(WidgetVoiceSettingsBottomSheet.this).onToggleNoiseCancellation();
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8 implements View.OnClickListener {
        public final /* synthetic */ ViewState $viewState;

        public AnonymousClass8(ViewState viewState) {
            this.$viewState = viewState;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetMobileReports.Companion companion = WidgetMobileReports.INSTANCE;
            Context contextRequireContext = WidgetVoiceSettingsBottomSheet.this.requireContext();
            Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
            companion.launchStageChannelReport(contextRequireContext, this.$viewState.getChannel().getId());
        }
    }

    /* compiled from: WidgetVoiceSettingsBottomSheet.kt */
    /* renamed from: com.discord.widgets.voice.sheet.WidgetVoiceSettingsBottomSheet$onResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<WidgetVoiceSettingsBottomSheetViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetVoiceSettingsBottomSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetVoiceSettingsBottomSheet.access$configureUI(WidgetVoiceSettingsBottomSheet.this, viewState);
        }
    }

    public WidgetVoiceSettingsBottomSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetVoiceSettingsBottomSheet2.INSTANCE, null, 2, null);
        this.channelId = LazyJVM.lazy(new WidgetVoiceSettingsBottomSheet3(this));
        WidgetVoiceSettingsBottomSheet5 widgetVoiceSettingsBottomSheet5 = new WidgetVoiceSettingsBottomSheet5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetVoiceSettingsBottomSheetViewModel.class), new WidgetVoiceSettingsBottomSheet$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetVoiceSettingsBottomSheet5));
    }

    public static final /* synthetic */ void access$configureUI(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet, ViewState viewState) {
        widgetVoiceSettingsBottomSheet.configureUI(viewState);
    }

    public static final /* synthetic */ WidgetVoiceSettingsBottomSheetBinding access$getBinding$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getBinding();
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getChannelId();
    }

    public static final /* synthetic */ WidgetVoiceSettingsBottomSheetViewModel access$getViewModel$p(WidgetVoiceSettingsBottomSheet widgetVoiceSettingsBottomSheet) {
        return widgetVoiceSettingsBottomSheet.getViewModel();
    }

    private final void configureUI(ViewState viewState) {
        Guild guild;
        getBinding().c.setOnClickListener(new AnonymousClass1(viewState));
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceSettingsInvite");
        textView.setVisibility(viewState.getShowInviteItem() ? 0 : 8);
        getBinding().h.setOnClickListener(new AnonymousClass2());
        SwitchMaterial switchMaterial = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial.setChecked(viewState.getShowVoiceParticipants());
        SwitchMaterial switchMaterial2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial2, "binding.voiceSettingsToggleVideoParticipants");
        switchMaterial2.setVisibility(viewState.getShowVoiceParticipantsToggle() ? 0 : 8);
        TextView textView2 = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.voiceSettingsStageSettings");
        textView2.setVisibility(viewState.getShowStageSettings() ? 0 : 8);
        getBinding().g.setOnClickListener(new AnonymousClass3());
        TextView textView3 = getBinding().f2705b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.voiceSettingsEvents");
        textView3.setVisibility(ChannelUtils.w(viewState.getChannel()) ? 0 : 8);
        getBinding().f2705b.setOnClickListener(new AnonymousClass4(viewState));
        getBinding().i.setOnClickListener(new AnonymousClass5());
        TextView textView4 = getBinding().e;
        textView4.setVisibility(ChannelUtils.D(viewState.getChannel()) && (guild = viewState.getGuild()) != null && guild.hasFeature(GuildFeature.COMMUNITY) ? 0 : 8);
        textView4.setOnClickListener(new WidgetVoiceSettingsBottomSheet4(this, viewState));
        getBinding().d.setOnClickListener(new AnonymousClass7());
        SwitchMaterial switchMaterial3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(switchMaterial3, "binding.voiceSettingsNoiseSuppression");
        switchMaterial3.setChecked(viewState.getNoiseCancellationEnabled());
        TextView textView5 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.voiceSettingsReport");
        textView5.setVisibility(viewState.getShowReportItem() ? 0 : 8);
        getBinding().f.setOnClickListener(new AnonymousClass8(viewState));
    }

    private final WidgetVoiceSettingsBottomSheetBinding getBinding() {
        return (WidgetVoiceSettingsBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    private final WidgetVoiceSettingsBottomSheetViewModel getViewModel() {
        return (WidgetVoiceSettingsBottomSheetViewModel) this.viewModel.getValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_voice_settings_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetVoiceSettingsBottomSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass1(), 62, (Object) null);
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetState(3);
    }
}
