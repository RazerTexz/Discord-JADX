package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import b.a.j.a;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.app.AppLog;
import com.discord.databinding.AnchoredVoiceControlsViewBinding;
import com.discord.floating_view_manager.FloatingViewGravity;
import com.discord.rtcconnection.audio.DiscordAudioManager;
import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import com.discord.stores.StoreAudioManagerV2;
import com.discord.tooltips.SparkleView;
import com.discord.tooltips.TooltipManager;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.press.OnPressListener;
import com.discord.widgets.voice.controls.WidgetScreenShareNfxSheet;
import com.discord.widgets.voice.model.CameraState;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import com.google.android.material.button.MaterialButton;
import d0.z.d.m;
import d0.z.d.o;
import j0.k.b;
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* compiled from: AnchoredVoiceControlsView.kt */
/* loaded from: classes.dex */
public final class AnchoredVoiceControlsView extends FrameLayout {
    private final AnchoredVoiceControlsViewBinding binding;
    private final TooltipManager tooltipManager;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            MediaEngineConnection.InputMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[MediaEngineConnection.InputMode.PUSH_TO_TALK.ordinal()] = 1;
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureScreenShareButtonSparkle$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ WidgetVoiceBottomSheet.FeatureContext $featureContext;
        public final /* synthetic */ boolean $forwardToFullscreenIfVideoActivated;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Function0 $onNavigateToScreenShareNfxSheet;
        public final /* synthetic */ Function0 $onScreenSharePressed;

        public AnonymousClass1(FragmentManager fragmentManager, long j, long j2, boolean z2, WidgetVoiceBottomSheet.FeatureContext featureContext, Function0 function0, Function0 function02) {
            this.$fragmentManager = fragmentManager;
            this.$channelId = j;
            this.$guildId = j2;
            this.$forwardToFullscreenIfVideoActivated = z2;
            this.$featureContext = featureContext;
            this.$onNavigateToScreenShareNfxSheet = function0;
            this.$onScreenSharePressed = function02;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            AnchoredVoiceControlsView.access$getTooltipManager$p(AnchoredVoiceControlsView.this).a(ScreenShareButtonSparkleTooltip.INSTANCE);
            WidgetScreenShareNfxSheet.Companion companion = WidgetScreenShareNfxSheet.INSTANCE;
            if (!companion.canShow()) {
                this.$onScreenSharePressed.invoke();
            } else {
                companion.show(this.$fragmentManager, this.$channelId, this.$guildId, new WidgetScreenShareNfxSheet.VoiceBottomSheetParams(this.$forwardToFullscreenIfVideoActivated, this.$featureContext));
                this.$onNavigateToScreenShareNfxSheet.invoke();
            }
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureScreenShareButtonSparkle$2, reason: invalid class name */
    public static final class AnonymousClass2<T, R> implements b<Void, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        @Override // j0.k.b
        public /* bridge */ /* synthetic */ Unit call(Void r1) {
            call2(r1);
            return Unit.a;
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onCameraButtonPressed;

        public AnonymousClass1(Function0 function0) {
            this.$onCameraButtonPressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onCameraButtonPressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onSpeakerButtonPressed;

        public AnonymousClass2(Function0 function0) {
            this.$onSpeakerButtonPressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onSpeakerButtonPressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$3, reason: invalid class name */
    public static final class AnonymousClass3 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onMutePressed;

        public AnonymousClass3(Function0 function0) {
            this.$onMutePressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onMutePressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$4, reason: invalid class name */
    public static final class AnonymousClass4 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onScreenSharePressed;

        public AnonymousClass4(Function0 function0) {
            this.$onScreenSharePressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onScreenSharePressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$5, reason: invalid class name */
    public static final class AnonymousClass5 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDisconnectPressed;

        public AnonymousClass5(Function0 function0) {
            this.$onDisconnectPressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDisconnectPressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$setOnPttPressedListener$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Boolean, Unit> {
        public final /* synthetic */ Function1 $onPttPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Function1 function1) {
            super(1);
            this.$onPttPressed = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            this.$onPttPressed.invoke(Boolean.valueOf(z2));
        }
    }

    public AnchoredVoiceControlsView(Context context) {
        this(context, null, 0, 6, null);
    }

    public AnchoredVoiceControlsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ AnchoredVoiceControlsView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public static final /* synthetic */ TooltipManager access$getTooltipManager$p(AnchoredVoiceControlsView anchoredVoiceControlsView) {
        return anchoredVoiceControlsView.tooltipManager;
    }

    private final void configureScreenShareButtonSparkle(boolean showSparkle, AppComponent appComponent, FragmentManager fragmentManager, long channelId, long guildId, boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext, Function0<Unit> onNavigateToScreenShareNfxSheet, Function0<Unit> onScreenSharePressed) {
        if (showSparkle) {
            TooltipManager tooltipManager = this.tooltipManager;
            TooltipManager.b bVar = ScreenShareButtonSparkleTooltip.INSTANCE;
            Objects.requireNonNull(tooltipManager);
            m.checkNotNullParameter(bVar, "tooltip");
            if (!(tooltipManager.tooltipNameToTooltipViewIdMap.get(bVar.getTooltipName()) != null)) {
                ImageView imageView = this.binding.f;
                m.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsScreenshare");
                Context context = imageView.getContext();
                m.checkNotNullExpressionValue(context, "binding.voiceFullscreenControlsScreenshare.context");
                SparkleView sparkleView = new SparkleView(context, null);
                sparkleView.setOnClickListener(new AnonymousClass1(fragmentManager, channelId, guildId, forwardToFullscreenIfVideoActivated, featureContext, onNavigateToScreenShareNfxSheet, onScreenSharePressed));
                TooltipManager tooltipManager2 = this.tooltipManager;
                View view = this.binding.f;
                m.checkNotNullExpressionValue(view, "binding.voiceFullscreenControlsScreenshare");
                FloatingViewGravity floatingViewGravity = FloatingViewGravity.CENTER;
                Observable<R> observableG = appComponent.getUnsubscribeSignal().G(AnonymousClass2.INSTANCE);
                m.checkNotNullExpressionValue(observableG, "appComponent.unsubscribeSignal.map { Unit }");
                tooltipManager2.d(view, sparkleView, bVar, floatingViewGravity, 0, 0, false, observableG);
                return;
            }
        }
        if (showSparkle) {
            return;
        }
        this.tooltipManager.c(ScreenShareButtonSparkleTooltip.INSTANCE);
    }

    public final void configureUI(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State audioManagerState, boolean isMuted, boolean isScreensharing, boolean showScreenShareSparkle, CameraState cameraState, Function0<Unit> onMutePressed, Function0<Unit> onScreenSharePressed, Function0<Unit> onSpeakerButtonPressed, Function0<Unit> onCameraButtonPressed, Function0<Unit> onDisconnectPressed, AppComponent appComponent, FragmentManager fragmentManager, Function0<Unit> onNavigateToScreenShareNfxSheet, long channelId, long guildId, boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext) {
        String string;
        m.checkNotNullParameter(inputMode, "inputMode");
        m.checkNotNullParameter(audioManagerState, "audioManagerState");
        m.checkNotNullParameter(cameraState, "cameraState");
        m.checkNotNullParameter(onMutePressed, "onMutePressed");
        m.checkNotNullParameter(onScreenSharePressed, "onScreenSharePressed");
        m.checkNotNullParameter(onSpeakerButtonPressed, "onSpeakerButtonPressed");
        m.checkNotNullParameter(onCameraButtonPressed, "onCameraButtonPressed");
        m.checkNotNullParameter(onDisconnectPressed, "onDisconnectPressed");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(onNavigateToScreenShareNfxSheet, "onNavigateToScreenShareNfxSheet");
        m.checkNotNullParameter(featureContext, "featureContext");
        MaterialButton materialButton = this.binding.e;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(inputMode.ordinal() != 1 ? 8 : 0);
        this.binding.f2088b.setOnClickListener(new AnonymousClass1(onCameraButtonPressed));
        ImageView imageView = this.binding.f2088b;
        m.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsCamera");
        imageView.setVisibility(cameraState != CameraState.CAMERA_DISABLED ? 0 : 8);
        if (cameraState == CameraState.CAMERA_ON) {
            ImageView imageView2 = this.binding.f2088b;
            m.checkNotNullExpressionValue(imageView2, "binding.voiceFullscreenControlsCamera");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveActive)));
            ImageView imageView3 = this.binding.f2088b;
            m.checkNotNullExpressionValue(imageView3, "binding.voiceFullscreenControlsCamera");
            imageView3.setContentDescription(getContext().getString(R.string.camera_on));
        } else {
            ImageView imageView4 = this.binding.f2088b;
            m.checkNotNullExpressionValue(imageView4, "binding.voiceFullscreenControlsCamera");
            imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), R.attr.colorInteractiveNormal)));
            ImageView imageView5 = this.binding.f2088b;
            m.checkNotNullExpressionValue(imageView5, "binding.voiceFullscreenControlsCamera");
            imageView5.setContentDescription(getContext().getString(R.string.camera_off));
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET) {
            this.binding.g.setImageResource(R.drawable.ic_audio_output_bluetooth_white_24dp);
        } else {
            this.binding.g.setImageResource(R.drawable.ic_audio_output_white_24dp);
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE || audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.WIRED_HEADSET) {
            ImageView imageView6 = this.binding.g;
            m.checkNotNullExpressionValue(imageView6, "binding.voiceFullscreenControlsSpeaker");
            int themedColor = ColorCompat.getThemedColor(imageView6.getContext(), R.attr.colorInteractiveNormal);
            ImageView imageView7 = this.binding.g;
            m.checkNotNullExpressionValue(imageView7, "binding.voiceFullscreenControlsSpeaker");
            imageView7.setImageTintList(ColorStateList.valueOf(themedColor));
        } else {
            ImageView imageView8 = this.binding.g;
            m.checkNotNullExpressionValue(imageView8, "binding.voiceFullscreenControlsSpeaker");
            int themedColor2 = ColorCompat.getThemedColor(imageView8.getContext(), R.attr.colorInteractiveActive);
            ImageView imageView9 = this.binding.g;
            m.checkNotNullExpressionValue(imageView9, "binding.voiceFullscreenControlsSpeaker");
            imageView9.setImageTintList(ColorStateList.valueOf(themedColor2));
        }
        ImageView imageView10 = this.binding.g;
        m.checkNotNullExpressionValue(imageView10, "binding.voiceFullscreenControlsSpeaker");
        imageView10.setActivated(audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
        this.binding.g.setOnClickListener(new AnonymousClass2(onSpeakerButtonPressed));
        ImageView imageView11 = this.binding.d;
        m.checkNotNullExpressionValue(imageView11, "binding.voiceFullscreenControlsMuteState");
        imageView11.setActivated(isMuted);
        ImageView imageView12 = this.binding.d;
        m.checkNotNullExpressionValue(imageView12, "binding.voiceFullscreenControlsMuteState");
        imageView12.setContentDescription(getContext().getString(isMuted ? R.string.unmute : R.string.mute));
        this.binding.d.setOnClickListener(new AnonymousClass3(onMutePressed));
        ImageView imageView13 = this.binding.f;
        m.checkNotNullExpressionValue(imageView13, "binding.voiceFullscreenControlsScreenshare");
        imageView13.setActivated(isScreensharing);
        this.binding.f.setImageResource(isScreensharing ? R.drawable.ic_mobile_screenshare_end_24dp : R.drawable.ic_mobile_screenshare_24dp);
        ImageView imageView14 = this.binding.f;
        m.checkNotNullExpressionValue(imageView14, "binding.voiceFullscreenControlsScreenshare");
        Context context = getContext();
        if (context != null) {
            string = context.getString(isScreensharing ? R.string.stop_streaming : R.string.screenshare_screen);
        } else {
            string = null;
        }
        imageView14.setContentDescription(string);
        this.binding.f.setOnClickListener(new AnonymousClass4(onScreenSharePressed));
        configureScreenShareButtonSparkle(showScreenShareSparkle, appComponent, fragmentManager, channelId, guildId, forwardToFullscreenIfVideoActivated, featureContext, onNavigateToScreenShareNfxSheet, onScreenSharePressed);
        this.binding.c.setOnClickListener(new AnonymousClass5(onDisconnectPressed));
    }

    public final void hidePtt() {
        MaterialButton materialButton = this.binding.e;
        m.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(8);
    }

    public final void setOnPttPressedListener(Function1<? super Boolean, Unit> onPttPressed) {
        m.checkNotNullParameter(onPttPressed, "onPttPressed");
        this.binding.e.setOnTouchListener(new OnPressListener(new AnonymousClass1(onPttPressed)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredVoiceControlsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.anchored_voice_controls_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = R.id.voice_fullscreen_controls_camera;
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_camera);
        if (imageView != null) {
            i2 = R.id.voice_fullscreen_controls_controls_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.voice_fullscreen_controls_controls_wrap);
            if (linearLayout != null) {
                i2 = R.id.voice_fullscreen_controls_disconnect;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_disconnect);
                if (imageView2 != null) {
                    i2 = R.id.voice_fullscreen_controls_mute_state;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_mute_state);
                    if (imageView3 != null) {
                        i2 = R.id.voice_fullscreen_controls_ptt;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.voice_fullscreen_controls_ptt);
                        if (materialButton != null) {
                            i2 = R.id.voice_fullscreen_controls_screenshare;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_screenshare);
                            if (imageView4 != null) {
                                i2 = R.id.voice_fullscreen_controls_speaker;
                                ImageView imageView5 = (ImageView) viewInflate.findViewById(R.id.voice_fullscreen_controls_speaker);
                                if (imageView5 != null) {
                                    AnchoredVoiceControlsViewBinding anchoredVoiceControlsViewBinding = new AnchoredVoiceControlsViewBinding((LinearLayout) viewInflate, imageView, linearLayout, imageView2, imageView3, materialButton, imageView4, imageView5);
                                    m.checkNotNullExpressionValue(anchoredVoiceControlsViewBinding, "AnchoredVoiceControlsVie…rom(context), this, true)");
                                    this.binding = anchoredVoiceControlsViewBinding;
                                    AppLog appLog = AppLog.g;
                                    m.checkNotNullParameter(appLog, "logger");
                                    WeakReference<a> weakReference = a.b.a;
                                    a aVar = weakReference != null ? weakReference.get() : null;
                                    if (aVar == null) {
                                        aVar = new a(appLog);
                                        a.b.a = new WeakReference<>(aVar);
                                    }
                                    a aVar2 = aVar;
                                    TooltipManager.a aVar3 = TooltipManager.a.d;
                                    m.checkNotNullParameter(aVar2, "floatingViewManager");
                                    WeakReference<TooltipManager> weakReference2 = TooltipManager.a.a;
                                    TooltipManager tooltipManager = weakReference2 != null ? weakReference2.get() : null;
                                    if (tooltipManager == null) {
                                        tooltipManager = new TooltipManager((b.a.v.a) TooltipManager.a.f2815b.getValue(), (Set) TooltipManager.a.c.getValue(), 0, aVar2, 4);
                                        TooltipManager.a.a = new WeakReference<>(tooltipManager);
                                    }
                                    this.tooltipManager = tooltipManager;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i2)));
    }
}
