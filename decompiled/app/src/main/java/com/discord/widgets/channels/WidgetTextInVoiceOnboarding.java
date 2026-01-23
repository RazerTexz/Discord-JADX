package com.discord.widgets.channels;

import android.app.Dialog;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.VideoView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.discord.C5419R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.m846d0(WidgetTextInVoiceOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String VIDEO_URL = "https://cdn.discordapp.com/attachments/727325253608538113/942859496601043024/Text_in_Voice_NUX_Mobile_In-App.mp4";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onCtaClicked;

    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onCtaClicked) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(onCtaClicked, "onCtaClicked");
            WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding = new WidgetTextInVoiceOnboarding();
            WidgetTextInVoiceOnboarding.access$setOnCtaClicked$p(widgetTextInVoiceOnboarding, onCtaClicked);
            widgetTextInVoiceOnboarding.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$1 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class RunnableC73931 implements Runnable {
        public RunnableC73931() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = WidgetTextInVoiceOnboarding.this.getView();
            Integer numValueOf = view != null ? Integer.valueOf(view.getMeasuredHeight()) : null;
            Dialog dialog = WidgetTextInVoiceOnboarding.this.getDialog();
            View viewFindViewById = dialog != null ? dialog.findViewById(C5419R.id.design_bottom_sheet) : null;
            ViewGroup.LayoutParams layoutParams = viewFindViewById != null ? viewFindViewById.getLayoutParams() : null;
            if (numValueOf == null || numValueOf.intValue() <= 0) {
                return;
            }
            if (layoutParams != null) {
                layoutParams.height = numValueOf.intValue() + 1;
            }
            if (viewFindViewById != null) {
                viewFindViewById.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$2 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class ViewOnClickListenerC73942 implements View.OnClickListener {
        public ViewOnClickListenerC73942() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            if (videoView.isPlaying()) {
                WidgetTextInVoiceOnboarding.access$showVideoOverlay(WidgetTextInVoiceOnboarding.this);
                WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d.pause();
            } else {
                WidgetTextInVoiceOnboarding.access$hideVideoOverlay(WidgetTextInVoiceOnboarding.this);
                WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d.start();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$3 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C73953 implements MediaPlayer.OnPreparedListener {
        public C73953() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) {
            Intrinsics3.checkNotNullParameter(mediaPlayer, "mp");
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            videoView.getLayoutParams().height = -2;
            WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d.requestLayout();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$4 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C73964 implements MediaPlayer.OnInfoListener {
        public C73964() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i != 3) {
                return false;
            }
            ImageView imageView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18251g;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.textInVoiceOnboardingVideoPlaceholder");
            imageView.setVisibility(4);
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d;
            Intrinsics3.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            videoView.getLayoutParams().height = -2;
            WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).f18248d.requestLayout();
            return false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$hideVideoOverlay$1 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C73971 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final C73971 INSTANCE = new C73971();

        public C73971() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$onViewCreated$1 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class ViewOnClickListenerC73981 implements View.OnClickListener {
        public ViewOnClickListenerC73981() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextInVoiceOnboarding.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$onViewCreated$2 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class ViewOnClickListenerC73992 implements View.OnClickListener {
        public ViewOnClickListenerC73992() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnCtaClicked$p = WidgetTextInVoiceOnboarding.access$getOnCtaClicked$p(WidgetTextInVoiceOnboarding.this);
            if (function0Access$getOnCtaClicked$p != null) {
            }
            WidgetTextInVoiceOnboarding.this.dismiss();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$1 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C74001 extends Lambda implements Function1<View, Unit> {
        public static final C74001 INSTANCE = new C74001();

        public C74001() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$2 */
    /* JADX INFO: compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class C74012 extends Lambda implements Function1<ViewPropertyAnimator, Unit> {
        public static final C74012 INSTANCE = new C74012();

        public C74012() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            Intrinsics3.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetTextInVoiceOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetTextInVoiceOnboarding2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ WidgetTextInVoiceOnboardingBinding access$getBinding$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        return widgetTextInVoiceOnboarding.getBinding();
    }

    public static final /* synthetic */ Function0 access$getOnCtaClicked$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        return widgetTextInVoiceOnboarding.onCtaClicked;
    }

    public static final /* synthetic */ void access$hideVideoOverlay(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        widgetTextInVoiceOnboarding.hideVideoOverlay();
    }

    public static final /* synthetic */ void access$setOnCtaClicked$p(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding, Function0 function0) {
        widgetTextInVoiceOnboarding.onCtaClicked = function0;
    }

    public static final /* synthetic */ void access$showVideoOverlay(WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding) {
        widgetTextInVoiceOnboarding.showVideoOverlay();
    }

    private final void configureMedia(String videoUrl) {
        View view = getView();
        if (view != null) {
            view.post(new RunnableC73931());
        }
        FrameLayout frameLayout = getBinding().f18249e;
        Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.textInVoiceOnboardingVideoContainer");
        frameLayout.setClipToOutline(true);
        getBinding().f18248d.setVideoPath(videoUrl);
        hideVideoOverlay();
        getBinding().f18248d.setOnClickListener(new ViewOnClickListenerC73942());
        getBinding().f18248d.setOnPreparedListener(new C73953());
        getBinding().f18248d.setOnInfoListener(new C73964());
    }

    private final WidgetTextInVoiceOnboardingBinding getBinding() {
        return (WidgetTextInVoiceOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f18250f, 200L, C73971.INSTANCE, null, 4, null);
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f18250f, 200L, C74001.INSTANCE, C74012.INSTANCE, null, 8, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return C5419R.layout.widget_text_in_voice_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        new TextInVoiceOnboardingManager().markSeen();
        getBinding().f18246b.setOnClickListener(new ViewOnClickListenerC73981());
        getBinding().f18247c.setOnClickListener(new ViewOnClickListenerC73992());
        configureMedia(VIDEO_URL);
    }
}
