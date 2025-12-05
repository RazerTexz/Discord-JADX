package com.discord.widgets.voice.fullscreen;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.preference.PreferenceManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppTransitionActivity;
import com.discord.databinding.WidgetGuildCallOnboardingBinding;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.voice.VoiceChannelJoinabilityUtils2;
import com.discord.views.JoinVoiceChannelButton;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheetViewModel;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p009a.GuildVideoAtCapacityDialog;
import p007b.p008a.p018d.AppViewModelDelegates3;
import p007b.p008a.p018d.AppViewModelDelegates5;
import p007b.p008a.p062y.JoinVoiceChannelButton2;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;

/* compiled from: WidgetGuildCallOnboardingSheet.kt */
/* loaded from: classes.dex */
public final class WidgetGuildCallOnboardingSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetGuildCallOnboardingSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildCallOnboardingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: WidgetGuildCallOnboardingSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean hasUserSeenVoiceChannelOnboarding(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("CACHE_KEY_VOICE_CHANNEL_ONBOARDED", false);
        }

        public final void markSeenUserVoiceChannelOnboarding(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            PreferenceManager.getDefaultSharedPreferences(context).edit().putBoolean("CACHE_KEY_VOICE_CHANNEL_ONBOARDED", true).apply();
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet = new WidgetGuildCallOnboardingSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetGuildCallOnboardingSheet.setArguments(bundle);
            widgetGuildCallOnboardingSheet.show(fragmentManager, WidgetGuildCallOnboardingSheet.class.getName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheet.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$configureUI$1 */
    public static final class C105481 extends Lambda implements Function0<Unit> {

        /* compiled from: WidgetGuildCallOnboardingSheet.kt */
        /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$configureUI$1$1, reason: invalid class name */
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
                Companion companion = WidgetGuildCallOnboardingSheet.INSTANCE;
                Context contextRequireContext = WidgetGuildCallOnboardingSheet.this.requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion.markSeenUserVoiceChannelOnboarding(contextRequireContext);
                WidgetGuildCallOnboardingSheet.access$getViewModel$p(WidgetGuildCallOnboardingSheet.this).onConnectPressed();
            }
        }

        public C105481() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnimatableValueParser.m473S1(WidgetGuildCallOnboardingSheet.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheet.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$onResume$1 */
    public static final class C105491 extends Lambda implements Function1<WidgetGuildCallOnboardingSheetViewModel.ViewState, Unit> {
        public C105491() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "viewState");
            WidgetGuildCallOnboardingSheet.access$configureUI(WidgetGuildCallOnboardingSheet.this, viewState);
        }
    }

    /* compiled from: WidgetGuildCallOnboardingSheet.kt */
    /* renamed from: com.discord.widgets.voice.fullscreen.WidgetGuildCallOnboardingSheet$onResume$2 */
    public static final class C105502 extends Lambda implements Function1<WidgetGuildCallOnboardingSheetViewModel.Event, Unit> {
        public C105502() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetGuildCallOnboardingSheetViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetGuildCallOnboardingSheetViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "event");
            WidgetGuildCallOnboardingSheet.access$handleEvent(WidgetGuildCallOnboardingSheet.this, event);
        }
    }

    public WidgetGuildCallOnboardingSheet() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildCallOnboardingSheet2.INSTANCE, null, 2, null);
        WidgetGuildCallOnboardingSheet3 widgetGuildCallOnboardingSheet3 = new WidgetGuildCallOnboardingSheet3(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(WidgetGuildCallOnboardingSheetViewModel.class), new C10547x328ca378(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildCallOnboardingSheet3));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet, WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
        widgetGuildCallOnboardingSheet.configureUI(viewState);
    }

    public static final /* synthetic */ Bundle access$getArgumentsOrDefault$p(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        return widgetGuildCallOnboardingSheet.getArgumentsOrDefault();
    }

    public static final /* synthetic */ WidgetGuildCallOnboardingSheetViewModel access$getViewModel$p(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet) {
        return widgetGuildCallOnboardingSheet.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetGuildCallOnboardingSheet widgetGuildCallOnboardingSheet, WidgetGuildCallOnboardingSheetViewModel.Event event) {
        widgetGuildCallOnboardingSheet.handleEvent(event);
    }

    private final void configureUI(WidgetGuildCallOnboardingSheetViewModel.ViewState viewState) {
        if (viewState instanceof WidgetGuildCallOnboardingSheetViewModel.ViewState.Loaded) {
            JoinVoiceChannelButton joinVoiceChannelButton = getBinding().f16750b;
            VoiceChannelJoinabilityUtils2 joinability = ((WidgetGuildCallOnboardingSheetViewModel.ViewState.Loaded) viewState).getJoinability();
            C105481 c105481 = new C105481();
            Objects.requireNonNull(joinVoiceChannelButton);
            Intrinsics3.checkNotNullParameter(joinability, "joinability");
            Intrinsics3.checkNotNullParameter(c105481, "joinVoiceClickListener");
            int iOrdinal = joinability.ordinal();
            if (iOrdinal != 0) {
                if (iOrdinal == 1) {
                    joinVoiceChannelButton.setText(C5419R.string.channel_locked_short);
                    joinVoiceChannelButton.m8547a(joinVoiceChannelButton, C5419R.string.channel_locked);
                    return;
                } else if (iOrdinal != 2) {
                    if (iOrdinal == 3) {
                        joinVoiceChannelButton.setText(C5419R.string.unable_to_join_channel_full);
                        joinVoiceChannelButton.m8547a(joinVoiceChannelButton, C5419R.string.unable_to_join_channel_full);
                        return;
                    } else {
                        if (iOrdinal != 4) {
                            return;
                        }
                        joinVoiceChannelButton.setText(C5419R.string.connect_to_voice);
                        joinVoiceChannelButton.m8547a(joinVoiceChannelButton, C5419R.string.guild_settings_public_welcome_invalid_channel);
                        return;
                    }
                }
            }
            joinVoiceChannelButton.setText(C5419R.string.connect_to_voice);
            joinVoiceChannelButton.setOnClickListener(new JoinVoiceChannelButton2(c105481));
        }
    }

    private final WidgetGuildCallOnboardingBinding getBinding() {
        return (WidgetGuildCallOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetGuildCallOnboardingSheetViewModel getViewModel() {
        return (WidgetGuildCallOnboardingSheetViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetGuildCallOnboardingSheetViewModel.Event event) {
        if (Intrinsics3.areEqual(event, WidgetGuildCallOnboardingSheetViewModel.Event.ShowGuildVideoCapacityDialog.INSTANCE)) {
            GuildVideoAtCapacityDialog.Companion companion = GuildVideoAtCapacityDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.m140a(parentFragmentManager);
            dismiss();
            return;
        }
        if (event instanceof WidgetGuildCallOnboardingSheetViewModel.Event.LaunchGuildCallScreen) {
            WidgetGuildCallOnboardingSheetViewModel.Event.LaunchGuildCallScreen launchGuildCallScreen = (WidgetGuildCallOnboardingSheetViewModel.Event.LaunchGuildCallScreen) event;
            if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(launchGuildCallScreen.getGuildId())) {
                WidgetCallPreviewFullscreen.Companion companion2 = WidgetCallPreviewFullscreen.INSTANCE;
                Context contextRequireContext = requireContext();
                Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
                companion2.launch(contextRequireContext, launchGuildCallScreen.getChannelId(), AppTransitionActivity.Transition.TYPE_SLIDE_VERTICAL_WITH_FADE);
            } else {
                WidgetVoiceBottomSheet.Companion companion3 = WidgetVoiceBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager2 = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                companion3.show(parentFragmentManager2, launchGuildCallScreen.getChannelId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
            }
            dismiss();
        }
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_guild_call_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetGuildCallOnboardingSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C105491(), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetGuildCallOnboardingSheet.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C105502(), 62, (Object) null);
    }
}
