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
import b.d.b.a.a;
import com.discord.R;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetTextInVoiceOnboardingBinding;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;

/* compiled from: WidgetTextInVoiceOnboarding.kt */
/* loaded from: classes2.dex */
public final class WidgetTextInVoiceOnboarding extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetTextInVoiceOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetTextInVoiceOnboardingBinding;", 0)};

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String VIDEO_URL = "https://cdn.discordapp.com/attachments/727325253608538113/942859496601043024/Text_in_Voice_NUX_Mobile_In-App.mp4";

    /* renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Function0<Unit> onCtaClicked;

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, Function0<Unit> onCtaClicked) {
            m.checkNotNullParameter(fragmentManager, "fragmentManager");
            m.checkNotNullParameter(onCtaClicked, "onCtaClicked");
            WidgetTextInVoiceOnboarding widgetTextInVoiceOnboarding = new WidgetTextInVoiceOnboarding();
            WidgetTextInVoiceOnboarding.access$setOnCtaClicked$p(widgetTextInVoiceOnboarding, onCtaClicked);
            widgetTextInVoiceOnboarding.show(fragmentManager, "javaClass");
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Runnable {
        public AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = WidgetTextInVoiceOnboarding.this.getView();
            Integer numValueOf = view != null ? Integer.valueOf(view.getMeasuredHeight()) : null;
            Dialog dialog = WidgetTextInVoiceOnboarding.this.getDialog();
            View viewFindViewById = dialog != null ? dialog.findViewById(R.id.design_bottom_sheet) : null;
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

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d;
            m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            if (videoView.isPlaying()) {
                WidgetTextInVoiceOnboarding.access$showVideoOverlay(WidgetTextInVoiceOnboarding.this);
                WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.pause();
            } else {
                WidgetTextInVoiceOnboarding.access$hideVideoOverlay(WidgetTextInVoiceOnboarding.this);
                WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.start();
            }
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$3, reason: invalid class name */
    public static final class AnonymousClass3 implements MediaPlayer.OnPreparedListener {
        public AnonymousClass3() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public final void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            m.checkNotNullParameter(mediaPlayer, "mp");
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d;
            m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            videoView.getLayoutParams().height = -2;
            WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.requestLayout();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$configureMedia$4, reason: invalid class name */
    public static final class AnonymousClass4 implements MediaPlayer.OnInfoListener {
        public AnonymousClass4() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public final boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i != 3) {
                return false;
            }
            ImageView imageView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).g;
            m.checkNotNullExpressionValue(imageView, "binding.textInVoiceOnboardingVideoPlaceholder");
            imageView.setVisibility(4);
            VideoView videoView = WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d;
            m.checkNotNullExpressionValue(videoView, "binding.textInVoiceOnboardingVideo");
            videoView.getLayoutParams().height = -2;
            WidgetTextInVoiceOnboarding.access$getBinding$p(WidgetTextInVoiceOnboarding.this).d.requestLayout();
            return false;
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$hideVideoOverlay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(2.0f);
            viewPropertyAnimator.scaleY(2.0f);
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$onViewCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 implements View.OnClickListener {
        public AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetTextInVoiceOnboarding.this.dismiss();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$onViewCreated$2, reason: invalid class name */
    public static final class AnonymousClass2 implements View.OnClickListener {
        public AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0Access$getOnCtaClicked$p = WidgetTextInVoiceOnboarding.access$getOnCtaClicked$p(WidgetTextInVoiceOnboarding.this);
            if (function0Access$getOnCtaClicked$p != null) {
            }
            WidgetTextInVoiceOnboarding.this.dismiss();
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<View, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            m.checkNotNullParameter(view, "view");
            view.setScaleX(2.0f);
            view.setScaleY(2.0f);
        }
    }

    /* compiled from: WidgetTextInVoiceOnboarding.kt */
    /* renamed from: com.discord.widgets.channels.WidgetTextInVoiceOnboarding$showVideoOverlay$2, reason: invalid class name */
    public static final class AnonymousClass2 extends o implements Function1<ViewPropertyAnimator, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ViewPropertyAnimator viewPropertyAnimator) {
            invoke2(viewPropertyAnimator);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ViewPropertyAnimator viewPropertyAnimator) {
            m.checkNotNullParameter(viewPropertyAnimator, "$receiver");
            viewPropertyAnimator.scaleX(1.0f);
            viewPropertyAnimator.scaleY(1.0f);
        }
    }

    public WidgetTextInVoiceOnboarding() {
        super(false, 1, null);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetTextInVoiceOnboarding$binding$2.INSTANCE, null, 2, null);
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
            view.post(new AnonymousClass1());
        }
        FrameLayout frameLayout = getBinding().e;
        m.checkNotNullExpressionValue(frameLayout, "binding.textInVoiceOnboardingVideoContainer");
        frameLayout.setClipToOutline(true);
        getBinding().d.setVideoPath(videoUrl);
        hideVideoOverlay();
        getBinding().d.setOnClickListener(new AnonymousClass2());
        getBinding().d.setOnPreparedListener(new AnonymousClass3());
        getBinding().d.setOnInfoListener(new AnonymousClass4());
    }

    private final WidgetTextInVoiceOnboardingBinding getBinding() {
        return (WidgetTextInVoiceOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final void hideVideoOverlay() {
        ViewExtensions.fadeOut$default(getBinding().f, 200L, AnonymousClass1.INSTANCE, null, 4, null);
    }

    private final void showVideoOverlay() {
        ViewExtensions.fadeIn$default(getBinding().f, 200L, AnonymousClass1.INSTANCE, AnonymousClass2.INSTANCE, null, 8, null);
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_text_in_voice_onboarding;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        m.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        setBottomSheetCollapsedStateDisabled();
        new TextInVoiceOnboardingManager().markSeen();
        getBinding().f2666b.setOnClickListener(new AnonymousClass1());
        getBinding().c.setOnClickListener(new AnonymousClass2());
        configureMedia(VIDEO_URL);
    }
}
