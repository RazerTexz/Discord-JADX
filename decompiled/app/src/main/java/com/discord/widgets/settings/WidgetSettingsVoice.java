package com.discord.widgets.settings;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Checkable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.IdRes;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetSettingsVoiceBinding;
import com.discord.databinding.WidgetSettingsVoiceInputModeBinding;
import com.discord.rtcconnection.RtcConnection;
import com.discord.rtcconnection.mediaengine.MediaEngine;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreMediaSettings;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p018d.AppHelpDesk;
import p007b.p008a.p018d.AppScreen2;
import p007b.p008a.p018d.AppToast;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.OnSeekBarChangeListenerAdapter;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p100d.p104b.p105a.outline;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.Tuples;
import p507d0.p508a0.MathJVM;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p507d0.p592z.p594d.Reflection2;
import p637j0.p641k.Func1;
import p658rx.Observable;
import p658rx.functions.Action1;
import p658rx.functions.Func2;
import p658rx.functions.Func3;
import p658rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetSettingsVoice.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsVoice extends AppFragment {
    private static final String ARG_TARGET_AUTO_TOGGLE = "ARG_TARGET_AUTO_TOGGLE";
    private static final String ARG_TARGET_RES_ID = "ARG_TARGET_RES_ID";
    private static final int OVERLAY_PERMISSION_REQUEST_CODE = 2552;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private List<CheckedSetting> openSLESConfigRadioButtons;
    private RadioManager openSLESConfigRadioManager;
    private final BehaviorSubject<Boolean> requestListenForSensitivitySubject;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetSettingsVoice.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MediaEngine.LocalVoiceStatus LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED = new MediaEngine.LocalVoiceStatus(-1.0f, false);

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ boolean access$hasOverlayPermission(Companion companion, Context context) {
            return companion.hasOverlayPermission(context);
        }

        private final boolean hasOverlayPermission(Context context) {
            return Build.VERSION.SDK_INT <= 22 || Settings.canDrawOverlays(context);
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Integer num, boolean z2, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            companion.launch(context, num, z2);
        }

        public final void launch(Context context, @IdRes Integer targetResId, boolean isTargetAutoToggle) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (targetResId != null) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_RES_ID, targetResId.intValue());
            }
            if (isTargetAutoToggle) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_AUTO_TOGGLE, isTargetAutoToggle);
            }
            AppScreen2.m156d(context, WidgetSettingsVoice.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "Voice & Video", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class InputModeSelector extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(InputModeSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", 0)};

        /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public InputModeSelector() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsVoice$InputModeSelector$binding$2.INSTANCE, null, 2, null);
        }

        private final WidgetSettingsVoiceInputModeBinding getBinding() {
            return (WidgetSettingsVoiceInputModeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return C5419R.layout.widget_settings_voice_input_mode;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            Intrinsics3.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            setBottomSheetCollapsedStateDisabled();
            getBinding().f18122b.setOnClickListener(new WidgetSettingsVoice$InputModeSelector$onViewCreated$1(this));
            getBinding().f18123c.setOnClickListener(new WidgetSettingsVoice$InputModeSelector$onViewCreated$2(this));
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MediaEngine.OpenSLESConfig.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaEngine.OpenSLESConfig.DEFAULT.ordinal()] = 1;
            iArr[MediaEngine.OpenSLESConfig.FORCE_ENABLED.ordinal()] = 2;
            iArr[MediaEngine.OpenSLESConfig.FORCE_DISABLED.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$1 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class ViewOnClickListenerC96901 implements View.OnClickListener {
        public ViewOnClickListenerC96901() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            InputModeSelector inputModeSelector = new InputModeSelector();
            FragmentManager childFragmentManager = WidgetSettingsVoice.this.getChildFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            inputModeSelector.show(childFragmentManager, String.valueOf(Reflection2.getOrCreateKotlinClass(InputModeSelector.class)));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$3 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96913<T> implements Action1<Boolean> {
        public static final C96913 INSTANCE = new C96913();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleAutomaticGainControl();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$4 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96924<T> implements Action1<Boolean> {
        public static final C96924 INSTANCE = new C96924();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleNoiseCancellation();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$5 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class ViewOnClickListenerC96935 implements View.OnClickListener {
        public static final ViewOnClickListenerC96935 INSTANCE = new ViewOnClickListenerC96935();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMediaSettings().toggleNoiseSuppression();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$6 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96946<T> implements Action1<Boolean> {
        public static final C96946 INSTANCE = new C96946();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleVADUseKrisp();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$7 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96957<T> implements Action1<Boolean> {
        public static final C96957 INSTANCE = new C96957();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleEchoCancellation();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$8 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96968<T> implements Action1<Boolean> {
        public static final C96968 INSTANCE = new C96968();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleAutomaticVAD();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$9 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96979<T> implements Action1<Boolean> {
        public static final C96979 INSTANCE = new C96979();

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleEnableVideoHardwareScaling();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureVoiceSensitivity$1 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class ViewOnClickListenerC96981 implements View.OnClickListener {

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureVoiceSensitivity$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetSettingsVoice.access$getRequestListenForSensitivitySubject$p(WidgetSettingsVoice.this).onNext(Boolean.TRUE);
            }
        }

        public ViewOnClickListenerC96981() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnimatableValueParser.m473S1(WidgetSettingsVoice.this, null, new AnonymousClass1(), 1, null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$1 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C96991<T, R> implements Func1<RtcConnection.StateChange, Boolean> {
        public static final C96991 INSTANCE = new C96991();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Boolean call(RtcConnection.StateChange stateChange) {
            return call2(stateChange);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(RtcConnection.StateChange stateChange) {
            return Boolean.valueOf(Intrinsics3.areEqual(stateChange.state, RtcConnection.State.C5612f.f18814a));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$2 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97002<T1, T2, R> implements Func2<RtcConnection.StateChange, Channel, Tuples2<? extends RtcConnection.StateChange, ? extends Channel>> {
        public static final C97002 INSTANCE = new C97002();

        @Override // p658rx.functions.Func2
        public /* bridge */ /* synthetic */ Tuples2<? extends RtcConnection.StateChange, ? extends Channel> call(RtcConnection.StateChange stateChange, Channel channel) {
            return call2(stateChange, channel);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final Tuples2<RtcConnection.StateChange, Channel> call2(RtcConnection.StateChange stateChange, Channel channel) {
            return Tuples.m10073to(stateChange, channel);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$3 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97013 extends Lambda implements Function1<Tuples2<? extends RtcConnection.StateChange, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C97013(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends RtcConnection.StateChange, ? extends Channel> tuples2) {
            invoke2((Tuples2<RtcConnection.StateChange, Channel>) tuples2);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<RtcConnection.StateChange, Channel> tuples2) {
            DiscordOverlayService.INSTANCE.launchForVoice(this.$context);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97021<T> implements Action1<Boolean> {
        public C97021() {
        }

        @Override // p658rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            if (!bool.booleanValue() || Companion.access$hasOverlayPermission(WidgetSettingsVoice.INSTANCE, WidgetSettingsVoice.this.requireContext())) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                Intrinsics3.checkNotNullExpressionValue(bool, "isChecked");
                userSettings.setIsMobileOverlayEnabled(bool.booleanValue());
                WidgetSettingsVoice widgetSettingsVoice = WidgetSettingsVoice.this;
                CheckedSetting checkedSetting = WidgetSettingsVoice.access$getBinding$p(widgetSettingsVoice).f18115u;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
                Context context = checkedSetting.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
                WidgetSettingsVoice.access$onOverlayToggled(widgetSettingsVoice, context);
                return;
            }
            CheckedSetting checkedSetting2 = WidgetSettingsVoice.access$getBinding$p(WidgetSettingsVoice.this).f18115u;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
            checkedSetting2.setChecked(false);
            AnalyticsTracker.INSTANCE.permissionsRequested("overlay");
            WidgetSettingsVoice widgetSettingsVoice2 = WidgetSettingsVoice.this;
            StringBuilder sbM833U = outline.m833U("package:");
            CheckedSetting checkedSetting3 = WidgetSettingsVoice.access$getBinding$p(WidgetSettingsVoice.this).f18115u;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOverlayToggle");
            Context context2 = checkedSetting3.getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "binding.settingsVoiceOverlayToggle.context");
            sbM833U.append(context2.getPackageName());
            widgetSettingsVoice2.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sbM833U.toString())), WidgetSettingsVoice.OVERLAY_PERMISSION_REQUEST_CODE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97031 extends OnSeekBarChangeListenerAdapter {
        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                StoreStream.INSTANCE.getMediaSettings().setOutputVolume(PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, progress, 0.0f, 2, null));
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97042 extends OnSeekBarChangeListenerAdapter {
        @Override // p007b.p008a.p062y.OnSeekBarChangeListenerAdapter, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            Intrinsics3.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                StoreStream.INSTANCE.getMediaSettings().setSensitivity(progress - 100.0f);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class C97053 extends Lambda implements Function1<Model, Unit> {
        public C97053() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "it");
            WidgetSettingsVoice.access$configureUI(WidgetSettingsVoice.this, model);
        }
    }

    public WidgetSettingsVoice() {
        super(C5419R.layout.widget_settings_voice);
        this.requestListenForSensitivitySubject = BehaviorSubject.m11130l0(Boolean.FALSE);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsVoice$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsVoice widgetSettingsVoice, Model model) {
        widgetSettingsVoice.configureUI(model);
    }

    public static final /* synthetic */ WidgetSettingsVoiceBinding access$getBinding$p(WidgetSettingsVoice widgetSettingsVoice) {
        return widgetSettingsVoice.getBinding();
    }

    public static final /* synthetic */ MediaEngine.LocalVoiceStatus access$getLOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED$cp() {
        return LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED;
    }

    public static final /* synthetic */ RadioManager access$getOpenSLESConfigRadioManager$p(WidgetSettingsVoice widgetSettingsVoice) {
        RadioManager radioManager = widgetSettingsVoice.openSLESConfigRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        return radioManager;
    }

    public static final /* synthetic */ BehaviorSubject access$getRequestListenForSensitivitySubject$p(WidgetSettingsVoice widgetSettingsVoice) {
        return widgetSettingsVoice.requestListenForSensitivitySubject;
    }

    public static final /* synthetic */ void access$onOpenSLESConfigChanged(WidgetSettingsVoice widgetSettingsVoice) {
        widgetSettingsVoice.onOpenSLESConfigChanged();
    }

    public static final /* synthetic */ void access$onOverlayToggled(WidgetSettingsVoice widgetSettingsVoice, Context context) {
        widgetSettingsVoice.onOverlayToggled(context);
    }

    public static final /* synthetic */ void access$setOpenSLESConfigRadioManager$p(WidgetSettingsVoice widgetSettingsVoice, RadioManager radioManager) {
        widgetSettingsVoice.openSLESConfigRadioManager = radioManager;
    }

    private final void configureUI(Model model) {
        CheckedSetting checkedSetting;
        SeekBar seekBar = getBinding().f18113s;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceOutputVolume");
        seekBar.setProgress(MathJVM.roundToInt(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, model.getVoiceConfig().getOutputVolume(), 0.0f, 2, null)));
        getBinding().f18103i.setOnClickListener(new ViewOnClickListenerC96901());
        getBinding().f18104j.setText(model.getModePTT() ? C5419R.string.input_mode_ptt : model.getModeVAD() ? C5419R.string.input_mode_vad : 0);
        String strM822J = outline.m822J(new StringBuilder(), AppHelpDesk.f507a.m149a(360045138471L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-voice-video&utm_content=--t%3Apm");
        LinkifiedTextView linkifiedTextView = getBinding().f18094D;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsVoiceVideoTroubleshootingGuide");
        FormatUtils.m222n(linkifiedTextView, C5419R.string.form_help_voice_video_troubleshooting_guide, new Object[]{strM822J}, null, 4);
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        int iOrdinal = model.getOpenSLESConfig().ordinal();
        if (iOrdinal == 0) {
            checkedSetting = getBinding().f18108n;
        } else if (iOrdinal == 1) {
            checkedSetting = getBinding().f18110p;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            checkedSetting = getBinding().f18109o;
        }
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "when (model.openSLESConf…esForceDisabled\n        }");
        radioManager.m8550a(checkedSetting);
        List<CheckedSetting> list = this.openSLESConfigRadioButtons;
        if (list == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        for (CheckedSetting checkedSetting2 : list) {
            checkedSetting2.setOnCheckedListener(new WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1(checkedSetting2, this));
        }
        CheckedSetting checkedSetting3 = getBinding().f18099e;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceGainControlToggle");
        checkedSetting3.setChecked(model.getVoiceConfig().getAutomaticGainControl());
        getBinding().f18099e.setOnCheckedListener(C96913.INSTANCE);
        CheckedSetting checkedSetting4 = getBinding().f18105k;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceNoiseCancellationToggle");
        StoreMediaSettings.NoiseProcessing noiseProcessing = model.getVoiceConfig().getNoiseProcessing();
        StoreMediaSettings.NoiseProcessing noiseProcessing2 = StoreMediaSettings.NoiseProcessing.Cancellation;
        checkedSetting4.setChecked(noiseProcessing == noiseProcessing2);
        getBinding().f18105k.setOnCheckedListener(C96924.INSTANCE);
        TextView textView = getBinding().f18101g;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsVoiceKrispInfo");
        FormatUtils.m222n(textView, C5419R.string.learn_more_link, new Object[]{AppHelpDesk.f507a.m149a(360040843952L, null)}, null, 4);
        TextView textView2 = getBinding().f18101g;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsVoiceKrispInfo");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        CheckedSetting checkedSetting5 = getBinding().f18106l;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceNoiseSuppressionToggle");
        checkedSetting5.setChecked(model.getVoiceConfig().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Suppression);
        if (model.getVoiceConfig().getNoiseProcessing() == noiseProcessing2) {
            getBinding().f18106l.m8525b(C5419R.string.user_settings_disable_noise_suppression);
            CheckedSetting.m8524i(getBinding().f18106l, FormatUtils.m219k(this, C5419R.string.user_settings_disable_noise_suppression, new Object[0], null, 4), false, 2);
        } else {
            getBinding().f18106l.m8527e(ViewOnClickListenerC96935.INSTANCE);
            CheckedSetting.m8524i(getBinding().f18106l, null, false, 2);
        }
        CheckedSetting checkedSetting6 = getBinding().f18102h;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceKrispVadToggle");
        checkedSetting6.setChecked(model.getVoiceConfig().getVadUseKrisp() == StoreMediaSettings.VadUseKrisp.Enabled);
        getBinding().f18102h.setOnCheckedListener(C96946.INSTANCE);
        CheckedSetting checkedSetting7 = getBinding().f18097c;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceEchoCancellationToggle");
        checkedSetting7.setChecked(model.getVoiceConfig().getEchoCancellation());
        getBinding().f18097c.setOnCheckedListener(C96957.INSTANCE);
        CheckedSetting checkedSetting8 = getBinding().f18096b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting8, "binding.settingsVoiceAutoVadToggle");
        checkedSetting8.setChecked(model.getVoiceConfig().getAutomaticVad());
        CheckedSetting checkedSetting9 = getBinding().f18096b;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.settingsVoiceAutoVadToggle");
        checkedSetting9.setVisibility(model.getModeVAD() ? 0 : 8);
        getBinding().f18096b.setOnCheckedListener(C96968.INSTANCE);
        CheckedSetting checkedSetting10 = getBinding().f18098d;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting10, "binding.settingsVoiceEnableHardwareScalingToggle");
        checkedSetting10.setChecked(model.getVoiceConfig().getEnableVideoHardwareScaling());
        getBinding().f18098d.setOnCheckedListener(C96979.INSTANCE);
        configureVoiceSensitivity(model);
    }

    private final void configureVoiceSensitivity(Model model) {
        RelativeLayout relativeLayout = getBinding().f18092B;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.settingsVoiceSensitivityWrap");
        relativeLayout.setVisibility(model.getModeVAD() ? 0 : 8);
        TextView textView = getBinding().f18118x;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsVoiceSensitivityLabel");
        textView.setVisibility(model.getVoiceConfig().getAutomaticVad() ? 0 : 8);
        boolean z2 = !Intrinsics3.areEqual(model.getLocalVoiceStatus(), LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
        LinearLayout linearLayout = getBinding().f18091A;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsVoiceSensitivityTestingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f18120z;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.settingsVoiceSensitivityTestButton");
        materialButton.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().f18120z.setOnClickListener(new ViewOnClickListenerC96981());
        if (model.getVoiceConfig().getAutomaticVad()) {
            View view = getBinding().f18117w;
            Intrinsics3.checkNotNullExpressionValue(view, "binding.settingsVoiceSensitivityAutomatic");
            view.setVisibility(0);
            SeekBar seekBar = getBinding().f18119y;
            Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceSensitivityManual");
            seekBar.setVisibility(4);
            int i = model.getLocalVoiceStatus().isSpeaking ? C5419R.drawable.drawable_voice_indicator_speaking : C5419R.drawable.drawable_voice_indicator_not_speaking;
            View view2 = getBinding().f18117w;
            Intrinsics3.checkNotNullExpressionValue(view2, "binding.settingsVoiceSensitivityAutomatic");
            view2.setBackground(ContextCompat.getDrawable(requireContext(), i));
            return;
        }
        View view3 = getBinding().f18117w;
        Intrinsics3.checkNotNullExpressionValue(view3, "binding.settingsVoiceSensitivityAutomatic");
        view3.setVisibility(4);
        SeekBar seekBar2 = getBinding().f18119y;
        Intrinsics3.checkNotNullExpressionValue(seekBar2, "binding.settingsVoiceSensitivityManual");
        seekBar2.setVisibility(0);
        SeekBar seekBar3 = getBinding().f18119y;
        Intrinsics3.checkNotNullExpressionValue(seekBar3, "binding.settingsVoiceSensitivityManual");
        seekBar3.setSecondaryProgress(((int) model.getLocalVoiceStatus().amplitude) + 100);
        SeekBar seekBar4 = getBinding().f18119y;
        Intrinsics3.checkNotNullExpressionValue(seekBar4, "binding.settingsVoiceSensitivityManual");
        seekBar4.setProgress(((int) model.getVoiceConfig().getSensitivity()) + 100);
    }

    private final WidgetSettingsVoiceBinding getBinding() {
        return (WidgetSettingsVoiceBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    public static final void launch(Context context, @IdRes Integer num, boolean z2) {
        INSTANCE.launch(context, num, z2);
    }

    private final void onOpenSLESConfigChanged() {
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        Checkable checkable = radioManager.buttons.get(radioManager.m8551b());
        MediaEngine.OpenSLESConfig openSLESConfig = Intrinsics3.areEqual(checkable, getBinding().f18108n) ? MediaEngine.OpenSLESConfig.DEFAULT : Intrinsics3.areEqual(checkable, getBinding().f18110p) ? MediaEngine.OpenSLESConfig.FORCE_ENABLED : Intrinsics3.areEqual(checkable, getBinding().f18109o) ? MediaEngine.OpenSLESConfig.FORCE_DISABLED : null;
        if (openSLESConfig != null) {
            StoreStream.INSTANCE.getMediaEngine().setOpenSLESConfig(openSLESConfig);
        }
        AppToast.m171i(this, C5419R.string.user_settings_restart_app_mobile, 0, 4);
    }

    private final void onOverlayToggled(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
            DiscordOverlayService.INSTANCE.launchForClose(context);
            return;
        }
        Observable<RtcConnection.StateChange> observableM11118y = companion.getRtcConnection().getConnectionState().m11118y(C96991.INSTANCE);
        Observable<R> observableM11083G = companion.getVoiceChannelSelected().observeSelectedChannel().m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
        Observable observableM11076j = Observable.m11076j(observableM11118y, observableM11083G, C97002.INSTANCE);
        Intrinsics3.checkNotNullExpressionValue(observableM11076j, "Observable\n          .co… -> rtcState to channel }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableM11076j, 200L, false), this, null, 2, null), WidgetSettingsVoice.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C97013(context), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != OVERLAY_PERMISSION_REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        boolean zAccess$hasOverlayPermission = Companion.access$hasOverlayPermission(INSTANCE, requireContext());
        StoreStream.INSTANCE.getUserSettings().setIsMobileOverlayEnabled(zAccess$hasOverlayPermission);
        CheckedSetting checkedSetting = getBinding().f18115u;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
        checkedSetting.setChecked(zAccess$hasOverlayPermission);
        CheckedSetting checkedSetting2 = getBinding().f18115u;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
        Context context = checkedSetting2.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
        onOverlayToggled(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().f18111q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsVoiceOpenslesHelp");
        FormatUtils.m222n(textView, C5419R.string.form_label_android_opensl_desc, new Object[0], null, 4);
        CheckedSetting checkedSetting = getBinding().f18108n;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOpenslesDefault");
        CheckedSetting checkedSetting2 = getBinding().f18110p;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOpenslesForceEnabled");
        CheckedSetting checkedSetting3 = getBinding().f18109o;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOpenslesForceDisabled");
        List<CheckedSetting> listListOf = Collections2.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
        this.openSLESConfigRadioButtons = listListOf;
        if (listListOf == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        this.openSLESConfigRadioManager = new RadioManager(listListOf);
        CheckedSetting checkedSetting4 = getBinding().f18115u;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceOverlayToggle");
        checkedSetting4.setChecked(StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled() && Companion.access$hasOverlayPermission(INSTANCE, requireContext()));
        getBinding().f18115u.setOnCheckedListener(new C97021());
        for (TextView textView2 : Collections2.listOf((Object[]) new TextView[]{getBinding().f18100f, getBinding().f18112r, getBinding().f18114t, getBinding().f18116v, getBinding().f18093C, getBinding().f18107m})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
        Integer numValueOf = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_TARGET_RES_ID, 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            View viewFindViewById = view.findViewById(numValueOf.intValue());
            Intrinsics3.checkNotNullExpressionValue(viewFindViewById, "target");
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(viewFindViewById);
            if (coroutineScope != null) {
                C3404f.m4211H0(coroutineScope, null, null, new WidgetSettingsVoice$onViewBound$3$1(viewFindViewById, null), 3, null);
            }
            if (Intrinsics3.areEqual(viewFindViewById, getBinding().f18115u)) {
                CheckedSetting checkedSetting5 = getBinding().f18115u;
                Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
                if (checkedSetting5.isChecked() || !getMostRecentIntent().getBooleanExtra(ARG_TARGET_AUTO_TOGGLE, false)) {
                    return;
                }
                viewFindViewById.post(new WidgetSettingsVoice$onViewBound$$inlined$let$lambda$1(this, view));
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        getBinding().f18113s.setOnSeekBarChangeListener(new C97031());
        getBinding().f18119y.setOnSeekBarChangeListener(new C97042());
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> behaviorSubject = this.requestListenForSensitivitySubject;
        Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "requestListenForSensitivitySubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(behaviorSubject), this, null, 2, null), WidgetSettingsVoice.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new C97053(), 62, (Object) null);
    }

    /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
    public static final class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final MediaEngine.LocalVoiceStatus localVoiceStatus;
        private final boolean modePTT;
        private final boolean modeVAD;
        private final MediaEngine.OpenSLESConfig openSLESConfig;
        private final StoreMediaSettings.VoiceConfiguration voiceConfig;

        /* JADX INFO: compiled from: WidgetSettingsVoice.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Observable<Boolean> requestListenForSensitivity) {
                Intrinsics3.checkNotNullParameter(requestListenForSensitivity, "requestListenForSensitivity");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableM11076j = Observable.m11076j(requestListenForSensitivity, companion.getMediaEngine().getIsNativeEngineInitialized(), C9689x8d464d17.INSTANCE);
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = companion.getMediaSettings().getVoiceConfig();
                Observable<MediaEngine.OpenSLESConfig> openSLESConfig = companion.getMediaEngine().getOpenSLESConfig();
                Observable observableM11099Y = observableM11076j.m11099Y(WidgetSettingsVoice$Model$Companion$get$1.INSTANCE);
                WidgetSettingsVoice$Model$Companion$get$2 widgetSettingsVoice$Model$Companion$get$2 = WidgetSettingsVoice$Model$Companion$get$2.INSTANCE;
                Object widgetSettingsVoice$sam$rx_functions_Func3$0 = widgetSettingsVoice$Model$Companion$get$2;
                if (widgetSettingsVoice$Model$Companion$get$2 != null) {
                    widgetSettingsVoice$sam$rx_functions_Func3$0 = new WidgetSettingsVoice$sam$rx_functions_Func3$0(widgetSettingsVoice$Model$Companion$get$2);
                }
                Observable observableM11075i = Observable.m11075i(voiceConfig, openSLESConfig, observableM11099Y, (Func3) widgetSettingsVoice$sam$rx_functions_Func3$0);
                Intrinsics3.checkNotNullExpressionValue(observableM11075i, "Observable\n            .…    ::Model\n            )");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11075i).m11112r();
                Intrinsics3.checkNotNullExpressionValue(observableM11112r, "Observable\n            .…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Model(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus) {
            this.voiceConfig = voiceConfiguration;
            this.openSLESConfig = openSLESConfig;
            this.localVoiceStatus = localVoiceStatus;
            this.modePTT = voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.PUSH_TO_TALK;
            this.modeVAD = voiceConfiguration.getInputMode() == MediaEngineConnection.InputMode.VOICE_ACTIVITY;
        }

        public final MediaEngine.LocalVoiceStatus getLocalVoiceStatus() {
            return this.localVoiceStatus;
        }

        public final boolean getModePTT() {
            return this.modePTT;
        }

        public final boolean getModeVAD() {
            return this.modeVAD;
        }

        public final MediaEngine.OpenSLESConfig getOpenSLESConfig() {
            return this.openSLESConfig;
        }

        public final StoreMediaSettings.VoiceConfiguration getVoiceConfig() {
            return this.voiceConfig;
        }

        public /* synthetic */ Model(StoreMediaSettings.VoiceConfiguration voiceConfiguration, MediaEngine.OpenSLESConfig openSLESConfig, MediaEngine.LocalVoiceStatus localVoiceStatus, DefaultConstructorMarker defaultConstructorMarker) {
            this(voiceConfiguration, openSLESConfig, localVoiceStatus);
        }
    }
}
