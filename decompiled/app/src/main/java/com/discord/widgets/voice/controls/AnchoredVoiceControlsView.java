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
import com.discord.C5419R;
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
import java.lang.ref.WeakReference;
import java.util.Objects;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p026j.FloatingViewManager;
import p007b.p008a.p058v.AcknowledgedTooltipsCache;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p637j0.p641k.Func1;
import p658rx.Observable;

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
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureScreenShareButtonSparkle$1 */
    public static final class ViewOnClickListenerC104271 implements View.OnClickListener {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ WidgetVoiceBottomSheet.FeatureContext $featureContext;
        public final /* synthetic */ boolean $forwardToFullscreenIfVideoActivated;
        public final /* synthetic */ FragmentManager $fragmentManager;
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ Function0 $onNavigateToScreenShareNfxSheet;
        public final /* synthetic */ Function0 $onScreenSharePressed;

        public ViewOnClickListenerC104271(FragmentManager fragmentManager, long j, long j2, boolean z2, WidgetVoiceBottomSheet.FeatureContext featureContext, Function0 function0, Function0 function02) {
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
            AnchoredVoiceControlsView.access$getTooltipManager$p(AnchoredVoiceControlsView.this).m8512a(ScreenShareButtonSparkleTooltip.INSTANCE);
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
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureScreenShareButtonSparkle$2 */
    public static final class C104282<T, R> implements Func1<Void, Unit> {
        public static final C104282 INSTANCE = new C104282();

        @Override // p637j0.p641k.Func1
        public /* bridge */ /* synthetic */ Unit call(Void r1) {
            call2(r1);
            return Unit.f27425a;
        }

        /* renamed from: call, reason: avoid collision after fix types in other method */
        public final void call2(Void r1) {
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$1 */
    public static final class ViewOnClickListenerC104291 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onCameraButtonPressed;

        public ViewOnClickListenerC104291(Function0 function0) {
            this.$onCameraButtonPressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onCameraButtonPressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$2 */
    public static final class ViewOnClickListenerC104302 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onSpeakerButtonPressed;

        public ViewOnClickListenerC104302(Function0 function0) {
            this.$onSpeakerButtonPressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onSpeakerButtonPressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$3 */
    public static final class ViewOnClickListenerC104313 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onMutePressed;

        public ViewOnClickListenerC104313(Function0 function0) {
            this.$onMutePressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onMutePressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$4 */
    public static final class ViewOnClickListenerC104324 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onScreenSharePressed;

        public ViewOnClickListenerC104324(Function0 function0) {
            this.$onScreenSharePressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onScreenSharePressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$configureUI$5 */
    public static final class ViewOnClickListenerC104335 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onDisconnectPressed;

        public ViewOnClickListenerC104335(Function0 function0) {
            this.$onDisconnectPressed = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onDisconnectPressed.invoke();
        }
    }

    /* compiled from: AnchoredVoiceControlsView.kt */
    /* renamed from: com.discord.widgets.voice.controls.AnchoredVoiceControlsView$setOnPttPressedListener$1 */
    public static final class C104341 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ Function1 $onPttPressed;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C104341(Function1 function1) {
            super(1);
            this.$onPttPressed = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
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
            TooltipManager.C6648b c6648b = ScreenShareButtonSparkleTooltip.INSTANCE;
            Objects.requireNonNull(tooltipManager);
            Intrinsics3.checkNotNullParameter(c6648b, "tooltip");
            if (!(tooltipManager.tooltipNameToTooltipViewIdMap.get(c6648b.getTooltipName()) != null)) {
                ImageView imageView = this.binding.f15012f;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsScreenshare");
                Context context = imageView.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.voiceFullscreenControlsScreenshare.context");
                SparkleView sparkleView = new SparkleView(context, null);
                sparkleView.setOnClickListener(new ViewOnClickListenerC104271(fragmentManager, channelId, guildId, forwardToFullscreenIfVideoActivated, featureContext, onNavigateToScreenShareNfxSheet, onScreenSharePressed));
                TooltipManager tooltipManager2 = this.tooltipManager;
                View view = this.binding.f15012f;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.voiceFullscreenControlsScreenshare");
                FloatingViewGravity floatingViewGravity = FloatingViewGravity.CENTER;
                Observable<R> observableM11083G = appComponent.getUnsubscribeSignal().m11083G(C104282.INSTANCE);
                Intrinsics3.checkNotNullExpressionValue(observableM11083G, "appComponent.unsubscribeSignal.map { Unit }");
                tooltipManager2.m8515d(view, sparkleView, c6648b, floatingViewGravity, 0, 0, false, observableM11083G);
                return;
            }
        }
        if (showSparkle) {
            return;
        }
        this.tooltipManager.m8514c(ScreenShareButtonSparkleTooltip.INSTANCE);
    }

    public final void configureUI(MediaEngineConnection.InputMode inputMode, StoreAudioManagerV2.State audioManagerState, boolean isMuted, boolean isScreensharing, boolean showScreenShareSparkle, CameraState cameraState, Function0<Unit> onMutePressed, Function0<Unit> onScreenSharePressed, Function0<Unit> onSpeakerButtonPressed, Function0<Unit> onCameraButtonPressed, Function0<Unit> onDisconnectPressed, AppComponent appComponent, FragmentManager fragmentManager, Function0<Unit> onNavigateToScreenShareNfxSheet, long channelId, long guildId, boolean forwardToFullscreenIfVideoActivated, WidgetVoiceBottomSheet.FeatureContext featureContext) {
        String string;
        Intrinsics3.checkNotNullParameter(inputMode, "inputMode");
        Intrinsics3.checkNotNullParameter(audioManagerState, "audioManagerState");
        Intrinsics3.checkNotNullParameter(cameraState, "cameraState");
        Intrinsics3.checkNotNullParameter(onMutePressed, "onMutePressed");
        Intrinsics3.checkNotNullParameter(onScreenSharePressed, "onScreenSharePressed");
        Intrinsics3.checkNotNullParameter(onSpeakerButtonPressed, "onSpeakerButtonPressed");
        Intrinsics3.checkNotNullParameter(onCameraButtonPressed, "onCameraButtonPressed");
        Intrinsics3.checkNotNullParameter(onDisconnectPressed, "onDisconnectPressed");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(onNavigateToScreenShareNfxSheet, "onNavigateToScreenShareNfxSheet");
        Intrinsics3.checkNotNullParameter(featureContext, "featureContext");
        MaterialButton materialButton = this.binding.f15011e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(inputMode.ordinal() != 1 ? 8 : 0);
        this.binding.f15008b.setOnClickListener(new ViewOnClickListenerC104291(onCameraButtonPressed));
        ImageView imageView = this.binding.f15008b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.voiceFullscreenControlsCamera");
        imageView.setVisibility(cameraState != CameraState.CAMERA_DISABLED ? 0 : 8);
        if (cameraState == CameraState.CAMERA_ON) {
            ImageView imageView2 = this.binding.f15008b;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.voiceFullscreenControlsCamera");
            imageView2.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorInteractiveActive)));
            ImageView imageView3 = this.binding.f15008b;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.voiceFullscreenControlsCamera");
            imageView3.setContentDescription(getContext().getString(C5419R.string.camera_on));
        } else {
            ImageView imageView4 = this.binding.f15008b;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.voiceFullscreenControlsCamera");
            imageView4.setImageTintList(ColorStateList.valueOf(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorInteractiveNormal)));
            ImageView imageView5 = this.binding.f15008b;
            Intrinsics3.checkNotNullExpressionValue(imageView5, "binding.voiceFullscreenControlsCamera");
            imageView5.setContentDescription(getContext().getString(C5419R.string.camera_off));
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.BLUETOOTH_HEADSET) {
            this.binding.f15013g.setImageResource(C5419R.drawable.ic_audio_output_bluetooth_white_24dp);
        } else {
            this.binding.f15013g.setImageResource(C5419R.drawable.ic_audio_output_white_24dp);
        }
        if (audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.EARPIECE || audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.WIRED_HEADSET) {
            ImageView imageView6 = this.binding.f15013g;
            Intrinsics3.checkNotNullExpressionValue(imageView6, "binding.voiceFullscreenControlsSpeaker");
            int themedColor = ColorCompat.getThemedColor(imageView6.getContext(), C5419R.attr.colorInteractiveNormal);
            ImageView imageView7 = this.binding.f15013g;
            Intrinsics3.checkNotNullExpressionValue(imageView7, "binding.voiceFullscreenControlsSpeaker");
            imageView7.setImageTintList(ColorStateList.valueOf(themedColor));
        } else {
            ImageView imageView8 = this.binding.f15013g;
            Intrinsics3.checkNotNullExpressionValue(imageView8, "binding.voiceFullscreenControlsSpeaker");
            int themedColor2 = ColorCompat.getThemedColor(imageView8.getContext(), C5419R.attr.colorInteractiveActive);
            ImageView imageView9 = this.binding.f15013g;
            Intrinsics3.checkNotNullExpressionValue(imageView9, "binding.voiceFullscreenControlsSpeaker");
            imageView9.setImageTintList(ColorStateList.valueOf(themedColor2));
        }
        ImageView imageView10 = this.binding.f15013g;
        Intrinsics3.checkNotNullExpressionValue(imageView10, "binding.voiceFullscreenControlsSpeaker");
        imageView10.setActivated(audioManagerState.getActiveAudioDevice() == DiscordAudioManager.DeviceTypes.SPEAKERPHONE);
        this.binding.f15013g.setOnClickListener(new ViewOnClickListenerC104302(onSpeakerButtonPressed));
        ImageView imageView11 = this.binding.f15010d;
        Intrinsics3.checkNotNullExpressionValue(imageView11, "binding.voiceFullscreenControlsMuteState");
        imageView11.setActivated(isMuted);
        ImageView imageView12 = this.binding.f15010d;
        Intrinsics3.checkNotNullExpressionValue(imageView12, "binding.voiceFullscreenControlsMuteState");
        imageView12.setContentDescription(getContext().getString(isMuted ? C5419R.string.unmute : C5419R.string.mute));
        this.binding.f15010d.setOnClickListener(new ViewOnClickListenerC104313(onMutePressed));
        ImageView imageView13 = this.binding.f15012f;
        Intrinsics3.checkNotNullExpressionValue(imageView13, "binding.voiceFullscreenControlsScreenshare");
        imageView13.setActivated(isScreensharing);
        this.binding.f15012f.setImageResource(isScreensharing ? C5419R.drawable.ic_mobile_screenshare_end_24dp : C5419R.drawable.ic_mobile_screenshare_24dp);
        ImageView imageView14 = this.binding.f15012f;
        Intrinsics3.checkNotNullExpressionValue(imageView14, "binding.voiceFullscreenControlsScreenshare");
        Context context = getContext();
        if (context != null) {
            string = context.getString(isScreensharing ? C5419R.string.stop_streaming : C5419R.string.screenshare_screen);
        } else {
            string = null;
        }
        imageView14.setContentDescription(string);
        this.binding.f15012f.setOnClickListener(new ViewOnClickListenerC104324(onScreenSharePressed));
        configureScreenShareButtonSparkle(showScreenShareSparkle, appComponent, fragmentManager, channelId, guildId, forwardToFullscreenIfVideoActivated, featureContext, onNavigateToScreenShareNfxSheet, onScreenSharePressed);
        this.binding.f15009c.setOnClickListener(new ViewOnClickListenerC104335(onDisconnectPressed));
    }

    public final void hidePtt() {
        MaterialButton materialButton = this.binding.f15011e;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.voiceFullscreenControlsPtt");
        materialButton.setVisibility(8);
    }

    public final void setOnPttPressedListener(Function1<? super Boolean, Unit> onPttPressed) {
        Intrinsics3.checkNotNullParameter(onPttPressed, "onPttPressed");
        this.binding.f15011e.setOnTouchListener(new OnPressListener(new C104341(onPttPressed)));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredVoiceControlsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.anchored_voice_controls_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i2 = C5419R.id.voice_fullscreen_controls_camera;
        ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_camera);
        if (imageView != null) {
            i2 = C5419R.id.voice_fullscreen_controls_controls_wrap;
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_controls_wrap);
            if (linearLayout != null) {
                i2 = C5419R.id.voice_fullscreen_controls_disconnect;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_disconnect);
                if (imageView2 != null) {
                    i2 = C5419R.id.voice_fullscreen_controls_mute_state;
                    ImageView imageView3 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_mute_state);
                    if (imageView3 != null) {
                        i2 = C5419R.id.voice_fullscreen_controls_ptt;
                        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_ptt);
                        if (materialButton != null) {
                            i2 = C5419R.id.voice_fullscreen_controls_screenshare;
                            ImageView imageView4 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_screenshare);
                            if (imageView4 != null) {
                                i2 = C5419R.id.voice_fullscreen_controls_speaker;
                                ImageView imageView5 = (ImageView) viewInflate.findViewById(C5419R.id.voice_fullscreen_controls_speaker);
                                if (imageView5 != null) {
                                    AnchoredVoiceControlsViewBinding anchoredVoiceControlsViewBinding = new AnchoredVoiceControlsViewBinding((LinearLayout) viewInflate, imageView, linearLayout, imageView2, imageView3, materialButton, imageView4, imageView5);
                                    Intrinsics3.checkNotNullExpressionValue(anchoredVoiceControlsViewBinding, "AnchoredVoiceControlsVie…rom(context), this, true)");
                                    this.binding = anchoredVoiceControlsViewBinding;
                                    AppLog appLog = AppLog.f14950g;
                                    Intrinsics3.checkNotNullParameter(appLog, "logger");
                                    WeakReference<FloatingViewManager> weakReference = FloatingViewManager.b.f1460a;
                                    FloatingViewManager floatingViewManager = weakReference != null ? weakReference.get() : null;
                                    if (floatingViewManager == null) {
                                        floatingViewManager = new FloatingViewManager(appLog);
                                        FloatingViewManager.b.f1460a = new WeakReference<>(floatingViewManager);
                                    }
                                    FloatingViewManager floatingViewManager2 = floatingViewManager;
                                    TooltipManager.C6647a c6647a = TooltipManager.C6647a.f18975d;
                                    Intrinsics3.checkNotNullParameter(floatingViewManager2, "floatingViewManager");
                                    WeakReference<TooltipManager> weakReference2 = TooltipManager.C6647a.f18972a;
                                    TooltipManager tooltipManager = weakReference2 != null ? weakReference2.get() : null;
                                    if (tooltipManager == null) {
                                        tooltipManager = new TooltipManager((AcknowledgedTooltipsCache) TooltipManager.C6647a.f18973b.getValue(), (Set) TooltipManager.C6647a.f18974c.getValue(), 0, floatingViewManager2, 4);
                                        TooltipManager.C6647a.f18972a = new WeakReference<>(tooltipManager);
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
