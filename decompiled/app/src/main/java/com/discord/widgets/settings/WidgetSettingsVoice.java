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
import b.a.d.f;
import b.a.d.j;
import b.c.a.a0.d;
import b.d.b.a.a;
import com.discord.R;
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
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.utilities.voice.DiscordOverlayService;
import com.discord.utilities.voice.PerceptualVolumeUtils;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.google.android.material.button.MaterialButton;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.functions.Func3;
import rx.subjects.BehaviorSubject;

/* compiled from: WidgetSettingsVoice.kt */
/* loaded from: classes2.dex */
public final class WidgetSettingsVoice extends AppFragment {
    private static final String ARG_TARGET_AUTO_TOGGLE = "ARG_TARGET_AUTO_TOGGLE";
    private static final String ARG_TARGET_RES_ID = "ARG_TARGET_RES_ID";
    private static final int OVERLAY_PERMISSION_REQUEST_CODE = 2552;

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private List<CheckedSetting> openSLESConfigRadioButtons;
    private RadioManager openSLESConfigRadioManager;
    private final BehaviorSubject<Boolean> requestListenForSensitivitySubject;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsVoice.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MediaEngine.LocalVoiceStatus LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED = new MediaEngine.LocalVoiceStatus(-1.0f, false);

    /* compiled from: WidgetSettingsVoice.kt */
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
            m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            if (targetResId != null) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_RES_ID, targetResId.intValue());
            }
            if (isTargetAutoToggle) {
                intent.putExtra(WidgetSettingsVoice.ARG_TARGET_AUTO_TOGGLE, isTargetAutoToggle);
            }
            j.d(context, WidgetSettingsVoice.class, intent);
            StoreAnalytics.onUserSettingsPaneViewed$default(StoreStream.INSTANCE.getAnalytics(), "Voice & Video", null, 2, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    public static final class InputModeSelector extends AppBottomSheet {
        public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(InputModeSelector.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsVoiceInputModeBinding;", 0)};

        /* renamed from: binding$delegate, reason: from kotlin metadata */
        private final FragmentViewBindingDelegate binding;

        public InputModeSelector() {
            super(false, 1, null);
            this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsVoice$InputModeSelector$binding$2.INSTANCE, null, 2, null);
        }

        private final WidgetSettingsVoiceInputModeBinding getBinding() {
            return (WidgetSettingsVoiceInputModeBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
        }

        @Override // com.discord.app.AppBottomSheet
        public int getContentViewResId() {
            return R.layout.widget_settings_voice_input_mode;
        }

        @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
        public void onViewCreated(View view, Bundle savedInstanceState) {
            m.checkNotNullParameter(view, "view");
            super.onViewCreated(view, savedInstanceState);
            setBottomSheetCollapsedStateDisabled();
            getBinding().f2646b.setOnClickListener(new WidgetSettingsVoice$InputModeSelector$onViewCreated$1(this));
            getBinding().c.setOnClickListener(new WidgetSettingsVoice$InputModeSelector$onViewCreated$2(this));
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

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            InputModeSelector inputModeSelector = new InputModeSelector();
            FragmentManager childFragmentManager = WidgetSettingsVoice.this.getChildFragmentManager();
            m.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            inputModeSelector.show(childFragmentManager, String.valueOf(a0.getOrCreateKotlinClass(InputModeSelector.class)));
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3<T> implements Action1<Boolean> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleAutomaticGainControl();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4<T> implements Action1<Boolean> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleNoiseCancellation();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public static final AnonymousClass5 INSTANCE = new AnonymousClass5();

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            StoreStream.INSTANCE.getMediaSettings().toggleNoiseSuppression();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$6, reason: invalid class name */
    public static final class AnonymousClass6<T> implements Action1<Boolean> {
        public static final AnonymousClass6 INSTANCE = new AnonymousClass6();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleVADUseKrisp();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$7, reason: invalid class name */
    public static final class AnonymousClass7<T> implements Action1<Boolean> {
        public static final AnonymousClass7 INSTANCE = new AnonymousClass7();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleEchoCancellation();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$8, reason: invalid class name */
    public static final class AnonymousClass8<T> implements Action1<Boolean> {
        public static final AnonymousClass8 INSTANCE = new AnonymousClass8();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleAutomaticVAD();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureUI$9, reason: invalid class name */
    public static final class AnonymousClass9<T> implements Action1<Boolean> {
        public static final AnonymousClass9 INSTANCE = new AnonymousClass9();

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            StoreStream.INSTANCE.getMediaSettings().toggleEnableVideoHardwareScaling();
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureVoiceSensitivity$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {

        /* compiled from: WidgetSettingsVoice.kt */
        /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$configureVoiceSensitivity$1$1, reason: invalid class name and collision with other inner class name */
        public static final class C04531 extends o implements Function0<Unit> {
            public C04531() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetSettingsVoice.access$getRequestListenForSensitivitySubject$p(WidgetSettingsVoice.this).onNext(Boolean.TRUE);
            }
        }

        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            d.S1(WidgetSettingsVoice.this, null, new C04531(), 1, null);
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$1, reason: invalid class name */
    public static final class AnonymousClass1<T, R> implements b<RtcConnection.StateChange, Boolean> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Boolean call(RtcConnection.StateChange stateChange) {
            return call2(stateChange);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Boolean call2(RtcConnection.StateChange stateChange) {
            return Boolean.valueOf(m.areEqual(stateChange.state, RtcConnection.State.f.a));
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$2, reason: invalid class name */
    public static final class AnonymousClass2<T1, T2, R> implements Func2<RtcConnection.StateChange, Channel, Pair<? extends RtcConnection.StateChange, ? extends Channel>> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // rx.functions.Func2
        public /* bridge */ /* synthetic */ Pair<? extends RtcConnection.StateChange, ? extends Channel> call(RtcConnection.StateChange stateChange, Channel channel) {
            return call2(stateChange, channel);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final Pair<RtcConnection.StateChange, Channel> call2(RtcConnection.StateChange stateChange, Channel channel) {
            return d0.o.to(stateChange, channel);
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onOverlayToggled$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Pair<? extends RtcConnection.StateChange, ? extends Channel>, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends RtcConnection.StateChange, ? extends Channel> pair) {
            invoke2((Pair<RtcConnection.StateChange, Channel>) pair);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<RtcConnection.StateChange, Channel> pair) {
            DiscordOverlayService.INSTANCE.launchForVoice(this.$context);
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBound$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public AnonymousClass1() {
        }

        @Override // rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Boolean bool) {
            call2(bool);
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Boolean bool) {
            if (!bool.booleanValue() || Companion.access$hasOverlayPermission(WidgetSettingsVoice.INSTANCE, WidgetSettingsVoice.this.requireContext())) {
                StoreUserSettings userSettings = StoreStream.INSTANCE.getUserSettings();
                m.checkNotNullExpressionValue(bool, "isChecked");
                userSettings.setIsMobileOverlayEnabled(bool.booleanValue());
                WidgetSettingsVoice widgetSettingsVoice = WidgetSettingsVoice.this;
                CheckedSetting checkedSetting = WidgetSettingsVoice.access$getBinding$p(widgetSettingsVoice).u;
                m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
                Context context = checkedSetting.getContext();
                m.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
                WidgetSettingsVoice.access$onOverlayToggled(widgetSettingsVoice, context);
                return;
            }
            CheckedSetting checkedSetting2 = WidgetSettingsVoice.access$getBinding$p(WidgetSettingsVoice.this).u;
            m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
            checkedSetting2.setChecked(false);
            AnalyticsTracker.INSTANCE.permissionsRequested("overlay");
            WidgetSettingsVoice widgetSettingsVoice2 = WidgetSettingsVoice.this;
            StringBuilder sbU = a.U("package:");
            CheckedSetting checkedSetting3 = WidgetSettingsVoice.access$getBinding$p(WidgetSettingsVoice.this).u;
            m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOverlayToggle");
            Context context2 = checkedSetting3.getContext();
            m.checkNotNullExpressionValue(context2, "binding.settingsVoiceOverlayToggle.context");
            sbU.append(context2.getPackageName());
            widgetSettingsVoice2.startActivityForResult(new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION", Uri.parse(sbU.toString())), WidgetSettingsVoice.OVERLAY_PERMISSION_REQUEST_CODE);
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$1, reason: invalid class name */
    public static final class AnonymousClass1 extends b.a.y.j {
        @Override // b.a.y.j, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            m.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                StoreStream.INSTANCE.getMediaSettings().setOutputVolume(PerceptualVolumeUtils.perceptualToAmplitude$default(PerceptualVolumeUtils.INSTANCE, progress, 0.0f, 2, null));
            }
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$2, reason: invalid class name */
    public static final class AnonymousClass2 extends b.a.y.j {
        @Override // b.a.y.j, android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            m.checkNotNullParameter(seekBar, "seekBar");
            if (fromUser) {
                StoreStream.INSTANCE.getMediaSettings().setSensitivity(progress - 100.0f);
            }
        }
    }

    /* compiled from: WidgetSettingsVoice.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettingsVoice$onViewBoundOrOnResume$3, reason: invalid class name */
    public static final class AnonymousClass3 extends o implements Function1<Model, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            m.checkNotNullParameter(model, "it");
            WidgetSettingsVoice.access$configureUI(WidgetSettingsVoice.this, model);
        }
    }

    public WidgetSettingsVoice() {
        super(R.layout.widget_settings_voice);
        this.requestListenForSensitivitySubject = BehaviorSubject.l0(Boolean.FALSE);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsVoice$binding$2.INSTANCE, null, 2, null);
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
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
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
        SeekBar seekBar = getBinding().f2642s;
        m.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceOutputVolume");
        seekBar.setProgress(d0.a0.a.roundToInt(PerceptualVolumeUtils.amplitudeToPerceptual$default(PerceptualVolumeUtils.INSTANCE, model.getVoiceConfig().getOutputVolume(), 0.0f, 2, null)));
        getBinding().i.setOnClickListener(new AnonymousClass1());
        getBinding().j.setText(model.getModePTT() ? R.string.input_mode_ptt : model.getModeVAD() ? R.string.input_mode_vad : 0);
        String strJ = a.J(new StringBuilder(), f.a.a(360045138471L, null), "?utm_source=discord&utm_medium=blog&utm_campaign=2020-06_help-voice-video&utm_content=--t%3Apm");
        LinkifiedTextView linkifiedTextView = getBinding().D;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.settingsVoiceVideoTroubleshootingGuide");
        b.a.k.b.n(linkifiedTextView, R.string.form_help_voice_video_troubleshooting_guide, new Object[]{strJ}, null, 4);
        RadioManager radioManager = this.openSLESConfigRadioManager;
        if (radioManager == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        int iOrdinal = model.getOpenSLESConfig().ordinal();
        if (iOrdinal == 0) {
            checkedSetting = getBinding().n;
        } else if (iOrdinal == 1) {
            checkedSetting = getBinding().p;
        } else {
            if (iOrdinal != 2) {
                throw new NoWhenBranchMatchedException();
            }
            checkedSetting = getBinding().o;
        }
        m.checkNotNullExpressionValue(checkedSetting, "when (model.openSLESConf…esForceDisabled\n        }");
        radioManager.a(checkedSetting);
        List<CheckedSetting> list = this.openSLESConfigRadioButtons;
        if (list == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        for (CheckedSetting checkedSetting2 : list) {
            checkedSetting2.setOnCheckedListener(new WidgetSettingsVoice$configureUI$$inlined$forEach$lambda$1(checkedSetting2, this));
        }
        CheckedSetting checkedSetting3 = getBinding().e;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceGainControlToggle");
        checkedSetting3.setChecked(model.getVoiceConfig().getAutomaticGainControl());
        getBinding().e.setOnCheckedListener(AnonymousClass3.INSTANCE);
        CheckedSetting checkedSetting4 = getBinding().k;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceNoiseCancellationToggle");
        StoreMediaSettings.NoiseProcessing noiseProcessing = model.getVoiceConfig().getNoiseProcessing();
        StoreMediaSettings.NoiseProcessing noiseProcessing2 = StoreMediaSettings.NoiseProcessing.Cancellation;
        checkedSetting4.setChecked(noiseProcessing == noiseProcessing2);
        getBinding().k.setOnCheckedListener(AnonymousClass4.INSTANCE);
        TextView textView = getBinding().g;
        m.checkNotNullExpressionValue(textView, "binding.settingsVoiceKrispInfo");
        b.a.k.b.n(textView, R.string.learn_more_link, new Object[]{f.a.a(360040843952L, null)}, null, 4);
        TextView textView2 = getBinding().g;
        m.checkNotNullExpressionValue(textView2, "binding.settingsVoiceKrispInfo");
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        CheckedSetting checkedSetting5 = getBinding().l;
        m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceNoiseSuppressionToggle");
        checkedSetting5.setChecked(model.getVoiceConfig().getNoiseProcessing() == StoreMediaSettings.NoiseProcessing.Suppression);
        if (model.getVoiceConfig().getNoiseProcessing() == noiseProcessing2) {
            getBinding().l.b(R.string.user_settings_disable_noise_suppression);
            CheckedSetting.i(getBinding().l, b.a.k.b.k(this, R.string.user_settings_disable_noise_suppression, new Object[0], null, 4), false, 2);
        } else {
            getBinding().l.e(AnonymousClass5.INSTANCE);
            CheckedSetting.i(getBinding().l, null, false, 2);
        }
        CheckedSetting checkedSetting6 = getBinding().h;
        m.checkNotNullExpressionValue(checkedSetting6, "binding.settingsVoiceKrispVadToggle");
        checkedSetting6.setChecked(model.getVoiceConfig().getVadUseKrisp() == StoreMediaSettings.VadUseKrisp.Enabled);
        getBinding().h.setOnCheckedListener(AnonymousClass6.INSTANCE);
        CheckedSetting checkedSetting7 = getBinding().c;
        m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsVoiceEchoCancellationToggle");
        checkedSetting7.setChecked(model.getVoiceConfig().getEchoCancellation());
        getBinding().c.setOnCheckedListener(AnonymousClass7.INSTANCE);
        CheckedSetting checkedSetting8 = getBinding().f2641b;
        m.checkNotNullExpressionValue(checkedSetting8, "binding.settingsVoiceAutoVadToggle");
        checkedSetting8.setChecked(model.getVoiceConfig().getAutomaticVad());
        CheckedSetting checkedSetting9 = getBinding().f2641b;
        m.checkNotNullExpressionValue(checkedSetting9, "binding.settingsVoiceAutoVadToggle");
        checkedSetting9.setVisibility(model.getModeVAD() ? 0 : 8);
        getBinding().f2641b.setOnCheckedListener(AnonymousClass8.INSTANCE);
        CheckedSetting checkedSetting10 = getBinding().d;
        m.checkNotNullExpressionValue(checkedSetting10, "binding.settingsVoiceEnableHardwareScalingToggle");
        checkedSetting10.setChecked(model.getVoiceConfig().getEnableVideoHardwareScaling());
        getBinding().d.setOnCheckedListener(AnonymousClass9.INSTANCE);
        configureVoiceSensitivity(model);
    }

    private final void configureVoiceSensitivity(Model model) {
        RelativeLayout relativeLayout = getBinding().B;
        m.checkNotNullExpressionValue(relativeLayout, "binding.settingsVoiceSensitivityWrap");
        relativeLayout.setVisibility(model.getModeVAD() ? 0 : 8);
        TextView textView = getBinding().f2643x;
        m.checkNotNullExpressionValue(textView, "binding.settingsVoiceSensitivityLabel");
        textView.setVisibility(model.getVoiceConfig().getAutomaticVad() ? 0 : 8);
        boolean z2 = !m.areEqual(model.getLocalVoiceStatus(), LOCAL_VOICE_STATUS_ENGINE_UNINITIALIZED);
        LinearLayout linearLayout = getBinding().A;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsVoiceSensitivityTestingContainer");
        linearLayout.setVisibility(z2 ? 0 : 8);
        MaterialButton materialButton = getBinding().f2645z;
        m.checkNotNullExpressionValue(materialButton, "binding.settingsVoiceSensitivityTestButton");
        materialButton.setVisibility(z2 ^ true ? 0 : 8);
        getBinding().f2645z.setOnClickListener(new AnonymousClass1());
        if (model.getVoiceConfig().getAutomaticVad()) {
            View view = getBinding().w;
            m.checkNotNullExpressionValue(view, "binding.settingsVoiceSensitivityAutomatic");
            view.setVisibility(0);
            SeekBar seekBar = getBinding().f2644y;
            m.checkNotNullExpressionValue(seekBar, "binding.settingsVoiceSensitivityManual");
            seekBar.setVisibility(4);
            int i = model.getLocalVoiceStatus().isSpeaking ? R.drawable.drawable_voice_indicator_speaking : R.drawable.drawable_voice_indicator_not_speaking;
            View view2 = getBinding().w;
            m.checkNotNullExpressionValue(view2, "binding.settingsVoiceSensitivityAutomatic");
            view2.setBackground(ContextCompat.getDrawable(requireContext(), i));
            return;
        }
        View view3 = getBinding().w;
        m.checkNotNullExpressionValue(view3, "binding.settingsVoiceSensitivityAutomatic");
        view3.setVisibility(4);
        SeekBar seekBar2 = getBinding().f2644y;
        m.checkNotNullExpressionValue(seekBar2, "binding.settingsVoiceSensitivityManual");
        seekBar2.setVisibility(0);
        SeekBar seekBar3 = getBinding().f2644y;
        m.checkNotNullExpressionValue(seekBar3, "binding.settingsVoiceSensitivityManual");
        seekBar3.setSecondaryProgress(((int) model.getLocalVoiceStatus().amplitude) + 100);
        SeekBar seekBar4 = getBinding().f2644y;
        m.checkNotNullExpressionValue(seekBar4, "binding.settingsVoiceSensitivityManual");
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
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioManager");
        }
        Checkable checkable = radioManager.buttons.get(radioManager.b());
        MediaEngine.OpenSLESConfig openSLESConfig = m.areEqual(checkable, getBinding().n) ? MediaEngine.OpenSLESConfig.DEFAULT : m.areEqual(checkable, getBinding().p) ? MediaEngine.OpenSLESConfig.FORCE_ENABLED : m.areEqual(checkable, getBinding().o) ? MediaEngine.OpenSLESConfig.FORCE_DISABLED : null;
        if (openSLESConfig != null) {
            StoreStream.INSTANCE.getMediaEngine().setOpenSLESConfig(openSLESConfig);
        }
        b.a.d.m.i(this, R.string.user_settings_restart_app_mobile, 0, 4);
    }

    private final void onOverlayToggled(Context context) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        if (!companion.getUserSettings().getIsMobileOverlayEnabled()) {
            DiscordOverlayService.INSTANCE.launchForClose(context);
            return;
        }
        Observable<RtcConnection.StateChange> observableY = companion.getRtcConnection().getConnectionState().y(AnonymousClass1.INSTANCE);
        Observable<R> observableG = companion.getVoiceChannelSelected().observeSelectedChannel().y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
        Observable observableJ = Observable.j(observableY, observableG, AnonymousClass2.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable\n          .co… -> rtcState to channel }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.takeSingleUntilTimeout(observableJ, 200L, false), this, null, 2, null), WidgetSettingsVoice.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(context), 62, (Object) null);
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode != OVERLAY_PERMISSION_REQUEST_CODE) {
            super.onActivityResult(requestCode, resultCode, data);
            return;
        }
        boolean zAccess$hasOverlayPermission = Companion.access$hasOverlayPermission(INSTANCE, requireContext());
        StoreStream.INSTANCE.getUserSettings().setIsMobileOverlayEnabled(zAccess$hasOverlayPermission);
        CheckedSetting checkedSetting = getBinding().u;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOverlayToggle");
        checkedSetting.setChecked(zAccess$hasOverlayPermission);
        CheckedSetting checkedSetting2 = getBinding().u;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOverlayToggle");
        Context context = checkedSetting2.getContext();
        m.checkNotNullExpressionValue(context, "binding.settingsVoiceOverlayToggle.context");
        onOverlayToggled(context);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        TextView textView = getBinding().q;
        m.checkNotNullExpressionValue(textView, "binding.settingsVoiceOpenslesHelp");
        b.a.k.b.n(textView, R.string.form_label_android_opensl_desc, new Object[0], null, 4);
        CheckedSetting checkedSetting = getBinding().n;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsVoiceOpenslesDefault");
        CheckedSetting checkedSetting2 = getBinding().p;
        m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsVoiceOpenslesForceEnabled");
        CheckedSetting checkedSetting3 = getBinding().o;
        m.checkNotNullExpressionValue(checkedSetting3, "binding.settingsVoiceOpenslesForceDisabled");
        List<CheckedSetting> listListOf = n.listOf((Object[]) new CheckedSetting[]{checkedSetting, checkedSetting2, checkedSetting3});
        this.openSLESConfigRadioButtons = listListOf;
        if (listListOf == null) {
            m.throwUninitializedPropertyAccessException("openSLESConfigRadioButtons");
        }
        this.openSLESConfigRadioManager = new RadioManager(listListOf);
        CheckedSetting checkedSetting4 = getBinding().u;
        m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsVoiceOverlayToggle");
        checkedSetting4.setChecked(StoreStream.INSTANCE.getUserSettings().getIsMobileOverlayEnabled() && Companion.access$hasOverlayPermission(INSTANCE, requireContext()));
        getBinding().u.setOnCheckedListener(new AnonymousClass1());
        for (TextView textView2 : n.listOf((Object[]) new TextView[]{getBinding().f, getBinding().r, getBinding().t, getBinding().v, getBinding().C, getBinding().m})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView2, "header");
            accessibilityUtils.setViewIsHeading(textView2);
        }
        Integer numValueOf = Integer.valueOf(getMostRecentIntent().getIntExtra(ARG_TARGET_RES_ID, 0));
        if (numValueOf.intValue() == 0) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            View viewFindViewById = view.findViewById(numValueOf.intValue());
            m.checkNotNullExpressionValue(viewFindViewById, "target");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(viewFindViewById);
            if (coroutineScope != null) {
                b.i.a.f.e.o.f.H0(coroutineScope, null, null, new WidgetSettingsVoice$onViewBound$3$1(viewFindViewById, null), 3, null);
            }
            if (m.areEqual(viewFindViewById, getBinding().u)) {
                CheckedSetting checkedSetting5 = getBinding().u;
                m.checkNotNullExpressionValue(checkedSetting5, "binding.settingsVoiceOverlayToggle");
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
        getBinding().f2642s.setOnSeekBarChangeListener(new AnonymousClass1());
        getBinding().f2644y.setOnSeekBarChangeListener(new AnonymousClass2());
        Model.Companion companion = Model.INSTANCE;
        BehaviorSubject<Boolean> behaviorSubject = this.requestListenForSensitivitySubject;
        m.checkNotNullExpressionValue(behaviorSubject, "requestListenForSensitivitySubject");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(companion.get(behaviorSubject), this, null, 2, null), WidgetSettingsVoice.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new AnonymousClass3(), 62, (Object) null);
    }

    /* compiled from: WidgetSettingsVoice.kt */
    public static final class Model {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final MediaEngine.LocalVoiceStatus localVoiceStatus;
        private final boolean modePTT;
        private final boolean modeVAD;
        private final MediaEngine.OpenSLESConfig openSLESConfig;
        private final StoreMediaSettings.VoiceConfiguration voiceConfig;

        /* compiled from: WidgetSettingsVoice.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get(Observable<Boolean> requestListenForSensitivity) {
                m.checkNotNullParameter(requestListenForSensitivity, "requestListenForSensitivity");
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableJ = Observable.j(requestListenForSensitivity, companion.getMediaEngine().getIsNativeEngineInitialized(), WidgetSettingsVoice$Model$Companion$get$shouldListenForSensitivity$1.INSTANCE);
                Observable<StoreMediaSettings.VoiceConfiguration> voiceConfig = companion.getMediaSettings().getVoiceConfig();
                Observable<MediaEngine.OpenSLESConfig> openSLESConfig = companion.getMediaEngine().getOpenSLESConfig();
                Observable observableY = observableJ.Y(WidgetSettingsVoice$Model$Companion$get$1.INSTANCE);
                WidgetSettingsVoice$Model$Companion$get$2 widgetSettingsVoice$Model$Companion$get$2 = WidgetSettingsVoice$Model$Companion$get$2.INSTANCE;
                Object widgetSettingsVoice$sam$rx_functions_Func3$0 = widgetSettingsVoice$Model$Companion$get$2;
                if (widgetSettingsVoice$Model$Companion$get$2 != null) {
                    widgetSettingsVoice$sam$rx_functions_Func3$0 = new WidgetSettingsVoice$sam$rx_functions_Func3$0(widgetSettingsVoice$Model$Companion$get$2);
                }
                Observable observableI = Observable.i(voiceConfig, openSLESConfig, observableY, (Func3) widgetSettingsVoice$sam$rx_functions_Func3$0);
                m.checkNotNullExpressionValue(observableI, "Observable\n            .…    ::Model\n            )");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
                m.checkNotNullExpressionValue(observableR, "Observable\n            .…  .distinctUntilChanged()");
                return observableR;
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
