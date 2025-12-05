package com.discord.widgets.voice.controls;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.discord.C5419R;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.VoiceControlsSheetViewBinding;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.display.DisplayUtils;
import com.discord.utilities.press.OnPressListener;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.views.NumericBadgingView;
import com.discord.views.calls.VolumeSliderView;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.voice.model.CallModel;
import com.google.android.material.textview.MaterialTextView;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p508a0.MathJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: VoiceControlsSheetView.kt */
/* loaded from: classes.dex */
public final class VoiceControlsSheetView extends LinearLayout {
    private final VoiceControlsSheetViewBinding binding;
    private boolean isGestureNavigationEnabled;

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureInviteButtons$1 */
    public static final class ViewOnClickListenerC104351 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onInviteClick;

        public ViewOnClickListenerC104351(Function0 function0) {
            this.$onInviteClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onInviteClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureInviteButtons$2 */
    public static final class ViewOnClickListenerC104362 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onInviteClick;

        public ViewOnClickListenerC104362(Function0 function0) {
            this.$onInviteClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onInviteClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureOutputSelectors$1 */
    public static final class ViewOnClickListenerC104381 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onAudioOutputClick;

        public ViewOnClickListenerC104381(Function0 function0) {
            this.$onAudioOutputClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onAudioOutputClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureOutputSelectors$2 */
    public static final class ViewOnClickListenerC104392 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onAudioOutputClick;

        public ViewOnClickListenerC104392(Function0 function0) {
            this.$onAudioOutputClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onAudioOutputClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureScreenshareButtons$1 */
    public static final class ViewOnClickListenerC104411 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onScreenshareClick;

        public ViewOnClickListenerC104411(Function0 function0) {
            this.$onScreenshareClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onScreenshareClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureScreenshareButtons$2 */
    public static final class ViewOnClickListenerC104422 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onScreenshareClick;

        public ViewOnClickListenerC104422(Function0 function0) {
            this.$onScreenshareClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onScreenshareClick.invoke();
        }
    }

    /* compiled from: VoiceControlsSheetView.kt */
    /* renamed from: com.discord.widgets.voice.controls.VoiceControlsSheetView$configureVideoButton$1 */
    public static final class ViewOnClickListenerC104431 implements View.OnClickListener {
        public final /* synthetic */ Function0 $onVideoClick;

        public ViewOnClickListenerC104431(Function0 function0) {
            this.$onVideoClick = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.$onVideoClick.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingM8402a = VoiceControlsSheetViewBinding.m8402a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetViewBindingM8402a, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingM8402a;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingM8402a.f15608r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    private final void configureInviteButtons(CallModel callModel, Function0<Unit> onInviteClick, boolean showInTopRow) {
        this.binding.f15598h.setOnClickListener(new ViewOnClickListenerC104351(onInviteClick));
        this.binding.f15599i.setOnClickListener(new ViewOnClickListenerC104362(onInviteClick));
        ImageView imageView = this.binding.f15598h;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.inviteButton");
        imageView.setVisibility(callModel.canInvite() && showInTopRow ? 0 : 8);
        TextView textView = this.binding.f15599i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.inviteSecondaryButton");
        textView.setVisibility(callModel.canInvite() && !showInTopRow ? 0 : 8);
        ImageView imageView2 = this.binding.f15598h;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.inviteButton");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, false)));
    }

    /* renamed from: configureMoveToAudienceButton-yox5PQY, reason: not valid java name */
    private final void m11438configureMoveToAudienceButtonyox5PQY(StageRoles stageRoles, Function0<Unit> onMoveToAudienceClick) {
        ImageView imageView = this.binding.f15600j;
        imageView.setVisibility((stageRoles == null || !StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl()) || StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) ? false : true ? 0 : 8);
        ImageView imageView2 = this.binding.f15600j;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.moveToAudienceButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(ColorCompat.getColor(imageView.getContext(), C5419R.color.white_alpha_24)));
        imageView.setOnClickListener(new VoiceControlsSheetView2(this, stageRoles, onMoveToAudienceClick));
    }

    /* renamed from: configureMuteButton-P2fzehM, reason: not valid java name */
    private final void m11439configureMuteButtonP2fzehM(CallModel model, StageRoles stageRoles, Function0<Unit> onMuteClick) {
        if (stageRoles != null && !StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) {
            ImageView imageView = this.binding.f15601k;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.muteButton");
            imageView.setVisibility(8);
            return;
        }
        ImageView imageView2 = this.binding.f15601k;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.muteButton");
        imageView2.setVisibility(0);
        boolean zIsMeMutedByAnySource = model.isMeMutedByAnySource();
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsMeMutedByAnySource);
        ImageView imageView3 = this.binding.f15601k;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.muteButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.f15601k.setImageResource(zIsMeMutedByAnySource ? C5419R.drawable.ic_mic_mute_red_strike_24dp : C5419R.drawable.ic_mic_white_24dp);
        this.binding.f15601k.setOnClickListener(new VoiceControlsSheetView3(onMuteClick));
        ImageView imageView4 = this.binding.f15601k;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.muteButton");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        imageView4.setContentDescription(FormatUtils.m216h(context2, zIsMeMutedByAnySource ? C5419R.string.unmute : C5419R.string.mute, new Object[0], null, 4));
    }

    private final void configureOutputSelectors(VoiceControlsOutputSelectorState outputSelectorState, Function0<Unit> onAudioOutputClick, boolean showInTopRow) {
        FrameLayout frameLayout = this.binding.f15593c;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.audioOutputContainer");
        frameLayout.setVisibility(showInTopRow ? 0 : 8);
        this.binding.f15592b.setImageDrawable(ContextCompat.getDrawable(getContext(), outputSelectorState.getAudioOutputIconRes()));
        ImageView imageView = this.binding.f15592b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.audioOutputButton");
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        imageView.setBackgroundTintList(ColorStateList.valueOf(getDefaultButtonBackgroundTint(context, outputSelectorState.getIsButtonActive())));
        TextView textView = this.binding.f15595e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.audioOutputSecondaryButton");
        textView.setVisibility(showInTopRow ^ true ? 0 : 8);
        TextView textView2 = this.binding.f15595e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.audioOutputSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, outputSelectorState.getAudioOutputIconRes(), 0, 0, 0, 14, null);
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, outputSelectorState.getIsButtonActive());
        ImageView imageView2 = this.binding.f15592b;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.audioOutputButton");
        ColorCompat2.tintWithColor(imageView2, defaultButtonIconTint);
        ImageView imageView3 = this.binding.f15594d;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.audioOutputMore");
        ColorCompat2.tintWithColor(imageView3, defaultButtonIconTint);
        ImageView imageView4 = this.binding.f15594d;
        Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.audioOutputMore");
        imageView4.setVisibility(outputSelectorState.getShowMoreOptions() ? 0 : 8);
        this.binding.f15592b.setOnClickListener(new ViewOnClickListenerC104381(onAudioOutputClick));
        this.binding.f15595e.setOnClickListener(new ViewOnClickListenerC104392(onAudioOutputClick));
    }

    /* renamed from: configureRaiseHandButton-fw_bWyM, reason: not valid java name */
    private final void m11440configureRaiseHandButtonfw_bWyM(CallModel model, StageRoles stageRoles, int requestingToSpeakCount, boolean isUpdatingRequestToSpeak, Function0<Unit> onRaiseHandClick) {
        if (stageRoles == null || !(StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl()) || StageRoles.m11407isAudienceimpl(stageRoles.m11412unboximpl()))) {
            NumericBadgingView numericBadgingView = this.binding.f15604n;
            Intrinsics3.checkNotNullExpressionValue(numericBadgingView, "binding.raiseHandBadge");
            numericBadgingView.setVisibility(8);
            return;
        }
        NumericBadgingView numericBadgingView2 = this.binding.f15604n;
        boolean z2 = false;
        numericBadgingView2.setVisibility(0);
        if (!StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) {
            requestingToSpeakCount = 0;
        }
        numericBadgingView2.setBadgeNumber(requestingToSpeakCount);
        ImageView imageView = this.binding.f15605o;
        if (StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) {
            imageView.setContentDescription(imageView.getResources().getString(C5419R.string.request_to_speak_area_title));
            ViewExtensions.setEnabledAndAlpha$default(imageView, true, 0.0f, 2, null);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), C5419R.drawable.ic_stage_raised_hand_list));
        } else {
            imageView.setContentDescription(imageView.getResources().getString(!model.canRequestToSpeak() ? C5419R.string.audience_raise_hand_no_permission : model.isMyHandRaised() ? C5419R.string.audience_lower_hand : C5419R.string.audience_raise_hand_cta));
            ViewExtensions.setEnabledAndAlpha(imageView, !isUpdatingRequestToSpeak && model.canRequestToSpeak(), 0.2f);
            imageView.setImageDrawable(ContextCompat.getDrawable(imageView.getContext(), C5419R.drawable.ic_stage_raised_hand));
        }
        if (model.isMyHandRaised() && !StageRoles.m11409isModeratorimpl(stageRoles.m11412unboximpl())) {
            z2 = true;
        }
        Context context = imageView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        Context context2 = imageView.getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        int defaultButtonIconTint = getDefaultButtonIconTint(context2, z2);
        imageView.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ColorCompat2.tintWithColor(imageView, defaultButtonIconTint);
        imageView.setOnClickListener(new VoiceControlsSheetView4(this, stageRoles, model, isUpdatingRequestToSpeak, onRaiseHandClick));
    }

    private final void configureScreenshareButtons(CallModel model, Function0<Unit> onScreenshareClick, boolean showInTopRow) {
        boolean z2 = !ChannelUtils.m7669D(model.getChannel());
        boolean zIsStreaming = model.isStreaming();
        int i = zIsStreaming ? C5419R.string.stop_streaming : C5419R.string.mobile_stream_screen_share;
        ImageView imageView = this.binding.f15606p;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.screenShareButton");
        imageView.setVisibility(z2 && showInTopRow ? 0 : 8);
        int i2 = zIsStreaming ? C5419R.drawable.ic_mobile_screenshare_end_24dp : C5419R.drawable.ic_mobile_screenshare_24dp;
        int i3 = zIsStreaming ? ViewCompat.MEASURED_STATE_MASK : -1;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, zIsStreaming);
        this.binding.f15606p.setImageResource(i2);
        ImageView imageView2 = this.binding.f15606p;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.screenShareButton");
        imageView2.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        ImageView imageView3 = this.binding.f15606p;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.screenShareButton");
        imageView3.setImageTintList(ColorStateList.valueOf(i3));
        this.binding.f15606p.setOnClickListener(new ViewOnClickListenerC104411(onScreenshareClick));
        TextView textView = this.binding.f15607q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.screenShareSecondaryButton");
        textView.setVisibility(z2 && !showInTopRow ? 0 : 8);
        this.binding.f15607q.setOnClickListener(new ViewOnClickListenerC104422(onScreenshareClick));
        TextView textView2 = this.binding.f15607q;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.screenShareSecondaryButton");
        ViewExtensions.setCompoundDrawableWithIntrinsicBounds$default(textView2, i2, 0, 0, 0, 14, null);
        this.binding.f15607q.setText(i);
    }

    private final void configureStreamVolume(boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange) {
        TextView textView = this.binding.f15611u;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.streamVolumeLabel");
        textView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView = this.binding.f15612v;
        Intrinsics3.checkNotNullExpressionValue(volumeSliderView, "binding.streamVolumeSlider");
        volumeSliderView.setVisibility(showStreamVolume ? 0 : 8);
        VolumeSliderView volumeSliderView2 = this.binding.f15612v;
        int iRoundToInt = MathJVM.roundToInt(perceptualStreamVolume);
        SeekBar seekBar = volumeSliderView2.binding.f1034d;
        Intrinsics3.checkNotNullExpressionValue(seekBar, "binding.volumeSliderSeekBar");
        seekBar.setProgress(iRoundToInt);
        this.binding.f15612v.setOnVolumeChange(onStreamVolumeChange);
    }

    private final void configureVideoButton(CallModel model, Function0<Unit> onVideoClick, boolean isVideoEnabledForCall) {
        boolean z2 = model.getSelectedVideoDevice() != null;
        boolean z3 = !model.getVideoDevices().isEmpty();
        ImageView imageView = this.binding.f15613w;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.videoButton");
        imageView.setVisibility(z3 && isVideoEnabledForCall ? 0 : 8);
        int i = z2 ? ViewCompat.MEASURED_STATE_MASK : -1;
        ImageView imageView2 = this.binding.f15613w;
        Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.videoButton");
        imageView2.setImageTintList(ColorStateList.valueOf(i));
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        int defaultButtonBackgroundTint = getDefaultButtonBackgroundTint(context, z2);
        ImageView imageView3 = this.binding.f15613w;
        Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.videoButton");
        imageView3.setBackgroundTintList(ColorStateList.valueOf(defaultButtonBackgroundTint));
        this.binding.f15613w.setOnClickListener(new ViewOnClickListenerC104431(onVideoClick));
    }

    private final int getDefaultButtonBackgroundTint(Context context, boolean isActive) {
        if (isActive) {
            return ColorCompat.getColor(context, C5419R.color.white);
        }
        if (isActive) {
            throw new NoWhenBranchMatchedException();
        }
        return ColorCompat.getColor(context, C5419R.color.white_alpha_24);
    }

    private final int getDefaultButtonIconTint(Context context, boolean isActive) {
        if (!isActive) {
            return ColorCompat.getColor(context, C5419R.color.white);
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C5419R.attr.call_controls_active_button_icon_color, typedValue, true);
        return ColorCompat.getColor(context, typedValue.resourceId);
    }

    /* renamed from: configureUI-3jxq49Y, reason: not valid java name */
    public final void m11441configureUI3jxq49Y(CallModel model, VoiceControlsOutputSelectorState outputSelectorState, boolean isVideoEnabledForCall, boolean isPttEnabled, boolean isDeafened, boolean startedAsVideo, boolean showStopWatching, boolean showDisconnect, Function0<Unit> onStopWatchingClick, Function0<Unit> onDisconnectClick, Function0<Unit> onAudioOutputClick, Function0<Unit> onVideoClick, Function0<Unit> onMuteClick, Function0<Unit> onInviteClick, Function0<Unit> onScreenshareClick, boolean showStreamVolume, float perceptualStreamVolume, Function2<? super Float, ? super Boolean, Unit> onStreamVolumeChange, Function0<Unit> onDeafenPressed, int requestingToSpeakCount, Function0<Unit> onRaiseHandClick, Function0<Unit> onMoveToAudienceClick, boolean isUpdatingRequestToSpeak, StageRoles stageRoles) {
        int i;
        Intrinsics3.checkNotNullParameter(model, "model");
        Intrinsics3.checkNotNullParameter(outputSelectorState, "outputSelectorState");
        Intrinsics3.checkNotNullParameter(onStopWatchingClick, "onStopWatchingClick");
        Intrinsics3.checkNotNullParameter(onDisconnectClick, "onDisconnectClick");
        Intrinsics3.checkNotNullParameter(onAudioOutputClick, "onAudioOutputClick");
        Intrinsics3.checkNotNullParameter(onVideoClick, "onVideoClick");
        Intrinsics3.checkNotNullParameter(onMuteClick, "onMuteClick");
        Intrinsics3.checkNotNullParameter(onInviteClick, "onInviteClick");
        Intrinsics3.checkNotNullParameter(onScreenshareClick, "onScreenshareClick");
        Intrinsics3.checkNotNullParameter(onStreamVolumeChange, "onStreamVolumeChange");
        Intrinsics3.checkNotNullParameter(onDeafenPressed, "onDeafenPressed");
        Intrinsics3.checkNotNullParameter(onRaiseHandClick, "onRaiseHandClick");
        Intrinsics3.checkNotNullParameter(onMoveToAudienceClick, "onMoveToAudienceClick");
        ImageView imageView = this.binding.f15610t;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.stopWatchingButton");
        imageView.setVisibility(showStopWatching ? 0 : 8);
        this.binding.f15610t.setOnClickListener(new VoiceControlsSheetView7(onStopWatchingClick));
        if (stageRoles == null || StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) {
            MaterialTextView materialTextView = this.binding.f15609s;
            Intrinsics3.checkNotNullExpressionValue(materialTextView, "binding.stageDisconnectButtonLarge");
            i = 8;
            materialTextView.setVisibility(8);
            ImageView imageView2 = this.binding.f15597g;
            imageView2.setImageResource(stageRoles == null ? C5419R.drawable.ic_call_disconnect_24dp : C5419R.drawable.ic_stage_leave_20dp);
            imageView2.setVisibility(showDisconnect ? 0 : 8);
            imageView2.setOnClickListener(new VoiceControlsSheetView6(stageRoles, showDisconnect, onDisconnectClick));
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.disconnectButton…sconnectClick() }\n      }");
        } else {
            ImageView imageView3 = this.binding.f15597g;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.disconnectButton");
            imageView3.setVisibility(8);
            MaterialTextView materialTextView2 = this.binding.f15609s;
            materialTextView2.setVisibility(showDisconnect ? 0 : 8);
            materialTextView2.setOnClickListener(new VoiceControlsSheetView5(showDisconnect, onDisconnectClick));
            Intrinsics3.checkNotNullExpressionValue(materialTextView2, "binding.stageDisconnectB…Click()\n        }\n      }");
            i = 8;
        }
        Button button = this.binding.f15603m;
        Intrinsics3.checkNotNullExpressionValue(button, "binding.pushToTalkButton");
        if ((stageRoles == null || StageRoles.m11410isSpeakerimpl(stageRoles.m11412unboximpl())) && isPttEnabled) {
            i = 0;
        }
        button.setVisibility(i);
        TextView textView = this.binding.f15596f;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.deafenSecondaryButton");
        FormatUtils.m222n(textView, isDeafened ? C5419R.string.undeafen : C5419R.string.deafen, new Object[0], null, 4);
        this.binding.f15596f.setOnClickListener(new VoiceControlsSheetView8(onDeafenPressed));
        TextView textView2 = this.binding.f15596f;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.deafenSecondaryButton");
        textView2.setActivated(isDeafened);
        m11438configureMoveToAudienceButtonyox5PQY(stageRoles, onMoveToAudienceClick);
        m11440configureRaiseHandButtonfw_bWyM(model, stageRoles, requestingToSpeakCount, isUpdatingRequestToSpeak, onRaiseHandClick);
        m11439configureMuteButtonP2fzehM(model, stageRoles, onMuteClick);
        configureOutputSelectors(outputSelectorState, onAudioOutputClick, (startedAsVideo || ChannelUtils.m7669D(model.getChannel())) ? false : true);
        configureVideoButton(model, onVideoClick, isVideoEnabledForCall);
        configureScreenshareButtons(model, onScreenshareClick, startedAsVideo);
        configureStreamVolume(showStreamVolume, perceptualStreamVolume, onStreamVolumeChange);
        configureInviteButtons(model, onInviteClick, ChannelUtils.m7669D(model.getChannel()));
    }

    public final int getPeekHeight() {
        LinearLayout linearLayout = this.binding.f15602l;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.peekContainer");
        return linearLayout.getMeasuredHeight();
    }

    public final void handleSheetState(int bottomSheetState) {
        CardView cardView = this.binding.f15608r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility((bottomSheetState != 4 || this.isGestureNavigationEnabled) ? 0 : 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        if (resources.getConfiguration().orientation == 1) {
            Resources resources2 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
            i = resources2.getDisplayMetrics().widthPixels;
        } else {
            Resources resources3 = getResources();
            Intrinsics3.checkNotNullExpressionValue(resources3, "resources");
            i = resources3.getDisplayMetrics().heightPixels;
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = i;
        setLayoutParams(layoutParams);
    }

    public final void setOnPTTListener(OnPressListener listener) {
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.binding.f15603m.setOnTouchListener(listener);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingM8402a = VoiceControlsSheetViewBinding.m8402a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetViewBindingM8402a, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingM8402a;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingM8402a.f15608r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        VoiceControlsSheetViewBinding voiceControlsSheetViewBindingM8402a = VoiceControlsSheetViewBinding.m8402a(LayoutInflater.from(getContext()), this);
        Intrinsics3.checkNotNullExpressionValue(voiceControlsSheetViewBindingM8402a, "VoiceControlsSheetViewBi…ater.from(context), this)");
        this.binding = voiceControlsSheetViewBindingM8402a;
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.isGestureNavigationEnabled = DisplayUtils.isGestureNavigationEnabled(resources);
        CardView cardView = voiceControlsSheetViewBindingM8402a.f15608r;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.secondaryActionsCard");
        cardView.setVisibility(this.isGestureNavigationEnabled ? 0 : 4);
    }

    public /* synthetic */ VoiceControlsSheetView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
