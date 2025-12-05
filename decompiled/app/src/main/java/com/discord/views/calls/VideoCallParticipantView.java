package com.discord.views.calls;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.DisplayCutoutCompat;
import com.discord.C5419R;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColors2;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.grid.FrameGridLayout;
import com.discord.views.VoiceUserView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import p000.C13004r;
import p000.C13172t;
import p007b.p008a.p025i.ViewVideoCallParticipantBinding;
import p007b.p008a.p027k.FormatUtils;
import p007b.p008a.p062y.p063j0.VideoCallParticipantView2;
import p007b.p008a.p062y.p063j0.VideoCallParticipantView3;
import p007b.p008a.p062y.p063j0.VideoCallParticipantView4;
import p007b.p008a.p062y.p063j0.VideoCallParticipantView5;
import p007b.p008a.p062y.p063j0.VideoCallParticipantView6;
import p007b.p008a.p062y.p063j0.VideoCallParticipantView7;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.BehaviorSubject;

/* compiled from: VideoCallParticipantView.kt */
/* loaded from: classes2.dex */
public final class VideoCallParticipantView extends ConstraintLayout implements FrameGridLayout.DataView {

    /* renamed from: j, reason: from kotlin metadata */
    public final ViewVideoCallParticipantBinding binding;

    /* renamed from: k, reason: from kotlin metadata */
    public final boolean matchVideoOrientation;

    /* renamed from: l, reason: from kotlin metadata */
    public ParticipantData data;

    /* renamed from: m, reason: from kotlin metadata */
    public String userAvatarUrl;

    /* renamed from: n, reason: from kotlin metadata */
    public Function1<? super String, Unit> onWatchStreamClicked;

    /* renamed from: o, reason: from kotlin metadata */
    public Subscription representativeColorSubscription;

    /* renamed from: p, reason: from kotlin metadata */
    public boolean animateLabelFades;

    /* renamed from: q, reason: from kotlin metadata */
    public Subscription frameRenderedSubscription;

    /* renamed from: r, reason: from kotlin metadata */
    public DisplayCutoutCompat displayCutout;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean canOverlapTopCutout;

    /* renamed from: t, reason: from kotlin metadata */
    public VideoCallGridAdapter.CallUiInsets callUiInsets;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean controlsVisible;

    /* renamed from: v, reason: from kotlin metadata */
    public Drawable livePillBg;

    /* renamed from: w, reason: from kotlin metadata */
    public Drawable liveSplitPillBg;

    /* renamed from: x, reason: from kotlin metadata */
    public Function2<? super StreamResolution, ? super StreamFps, Unit> onStreamQualityIndicatorClicked;

    /* renamed from: y, reason: from kotlin metadata */
    public Function2<? super StreamResolution, ? super StreamFps, Unit> onStreamQualityIndicatorShown;

    /* compiled from: VideoCallParticipantView.kt */
    public static final /* data */ class StreamFps {

        /* renamed from: a, reason: from kotlin metadata */
        public final int fps;

        public StreamFps(int i) {
            this.fps = i;
        }

        /* renamed from: a */
        public final boolean m8586a() {
            return this.fps == 60;
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StreamFps) && this.fps == ((StreamFps) other).fps;
            }
            return true;
        }

        /* renamed from: hashCode, reason: from getter */
        public int getFps() {
            return this.fps;
        }

        public String toString() {
            return outline.m814B(outline.m833U("StreamFps(fps="), this.fps, ")");
        }
    }

    /* compiled from: VideoCallParticipantView.kt */
    public static abstract class StreamResolution {

        /* compiled from: VideoCallParticipantView.kt */
        /* renamed from: com.discord.views.calls.VideoCallParticipantView$StreamResolution$a */
        public static final class C7108a extends StreamResolution {

            /* renamed from: a */
            public final int f19254a;

            public C7108a(int i) {
                super(null);
                this.f19254a = i;
            }

            @Override // com.discord.views.calls.VideoCallParticipantView.StreamResolution
            /* renamed from: a */
            public CharSequence mo8587a(Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                return FormatUtils.m216h(context, C5419R.string.screenshare_resolution_abbreviated, new Object[]{Integer.valueOf(this.f19254a)}, null, 4);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof C7108a) && this.f19254a == ((C7108a) obj).f19254a;
                }
                return true;
            }

            public int hashCode() {
                return this.f19254a;
            }

            public String toString() {
                return outline.m814B(outline.m833U("Fixed(heightPx="), this.f19254a, ")");
            }
        }

        /* compiled from: VideoCallParticipantView.kt */
        /* renamed from: com.discord.views.calls.VideoCallParticipantView$StreamResolution$b */
        public static final class C7109b extends StreamResolution {

            /* renamed from: a */
            public static final C7109b f19255a = new C7109b();

            public C7109b() {
                super(null);
            }

            @Override // com.discord.views.calls.VideoCallParticipantView.StreamResolution
            /* renamed from: a */
            public CharSequence mo8587a(Context context) {
                Intrinsics3.checkNotNullParameter(context, "context");
                return FormatUtils.m216h(context, C5419R.string.screenshare_source, new Object[0], null, 4);
            }
        }

        public StreamResolution() {
        }

        /* renamed from: a */
        public abstract CharSequence mo8587a(Context context);

        /* renamed from: b */
        public final boolean m8588b() {
            return (this instanceof C7109b) || ((this instanceof C7108a) && ((C7108a) this).f19254a == 1080);
        }

        public StreamResolution(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: VideoCallParticipantView.kt */
    /* renamed from: com.discord.views.calls.VideoCallParticipantView$a */
    public static final class ViewOnClickListenerC7110a implements View.OnClickListener {

        /* renamed from: k */
        public final /* synthetic */ ParticipantData.C7107a f19257k;

        public ViewOnClickListenerC7110a(ParticipantData.C7107a c7107a) {
            this.f19257k = c7107a;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function2<? super StreamResolution, ? super StreamFps, Unit> function2 = VideoCallParticipantView.this.onStreamQualityIndicatorClicked;
            ParticipantData.C7107a c7107a = this.f19257k;
            function2.invoke(c7107a.f19250b, c7107a.f19251c);
        }
    }

    public VideoCallParticipantView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VideoCallParticipantView(Context context, AttributeSet attributeSet, int i, int i2) {
        AppVideoStreamRenderer appVideoStreamRenderer;
        boolean z2;
        AttributeSet attributeSet2 = (i2 & 2) != 0 ? null : attributeSet;
        int i3 = (i2 & 4) != 0 ? 0 : i;
        Intrinsics3.checkNotNullParameter(context, "context");
        super(context, attributeSet2, i3);
        LayoutInflater.from(context).inflate(C5419R.layout.view_video_call_participant, this);
        int i4 = C5419R.id.participant_bg_avatar;
        View viewFindViewById = findViewById(C5419R.id.participant_bg_avatar);
        if (viewFindViewById != null) {
            i4 = C5419R.id.participant_bg_letterbox;
            View viewFindViewById2 = findViewById(C5419R.id.participant_bg_letterbox);
            if (viewFindViewById2 != null) {
                i4 = C5419R.id.participant_deafen_status_indicator;
                ImageView imageView = (ImageView) findViewById(C5419R.id.participant_deafen_status_indicator);
                if (imageView != null) {
                    i4 = C5419R.id.participant_fullscreen_streamqual_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(C5419R.id.participant_fullscreen_streamqual_container);
                    if (constraintLayout != null) {
                        i4 = C5419R.id.participant_fullscreen_streamqual_divider;
                        Space space = (Space) findViewById(C5419R.id.participant_fullscreen_streamqual_divider);
                        if (space != null) {
                            i4 = C5419R.id.participant_fullscreen_streamqual_icon;
                            ImageView imageView2 = (ImageView) findViewById(C5419R.id.participant_fullscreen_streamqual_icon);
                            if (imageView2 != null) {
                                i4 = C5419R.id.participant_fullscreen_streamqual_info;
                                TextView textView = (TextView) findViewById(C5419R.id.participant_fullscreen_streamqual_info);
                                if (textView != null) {
                                    i4 = C5419R.id.participant_fullscreen_streamqual_info_container;
                                    LinearLayout linearLayout = (LinearLayout) findViewById(C5419R.id.participant_fullscreen_streamqual_info_container);
                                    if (linearLayout != null) {
                                        i4 = C5419R.id.participant_fullscreen_streamqual_live_indicator;
                                        TextView textView2 = (TextView) findViewById(C5419R.id.participant_fullscreen_streamqual_live_indicator);
                                        if (textView2 != null) {
                                            i4 = C5419R.id.participant_live_indicator;
                                            TextView textView3 = (TextView) findViewById(C5419R.id.participant_live_indicator);
                                            if (textView3 != null) {
                                                i4 = C5419R.id.participant_mute_status_indicator;
                                                ImageView imageView3 = (ImageView) findViewById(C5419R.id.participant_mute_status_indicator);
                                                if (imageView3 != null) {
                                                    i4 = C5419R.id.participant_stream_ended;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(C5419R.id.participant_stream_ended);
                                                    if (constraintLayout2 != null) {
                                                        i4 = C5419R.id.participant_stream_ended_img;
                                                        ImageView imageView4 = (ImageView) findViewById(C5419R.id.participant_stream_ended_img);
                                                        if (imageView4 != null) {
                                                            i4 = C5419R.id.participant_stream_ended_label;
                                                            TextView textView4 = (TextView) findViewById(C5419R.id.participant_stream_ended_label);
                                                            if (textView4 != null) {
                                                                i4 = C5419R.id.participant_stream_paused;
                                                                TextView textView5 = (TextView) findViewById(C5419R.id.participant_stream_paused);
                                                                if (textView5 != null) {
                                                                    i4 = C5419R.id.participant_stream_preview_image;
                                                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.participant_stream_preview_image);
                                                                    if (simpleDraweeView != null) {
                                                                        i4 = C5419R.id.participant_stream_preview_text;
                                                                        TextView textView6 = (TextView) findViewById(C5419R.id.participant_stream_preview_text);
                                                                        if (textView6 != null) {
                                                                            i4 = C5419R.id.participant_video_label;
                                                                            TextView textView7 = (TextView) findViewById(C5419R.id.participant_video_label);
                                                                            if (textView7 != null) {
                                                                                i4 = C5419R.id.participant_video_loading_indicator;
                                                                                ProgressBar progressBar = (ProgressBar) findViewById(C5419R.id.participant_video_loading_indicator);
                                                                                if (progressBar != null) {
                                                                                    i4 = C5419R.id.participant_video_stream_renderer;
                                                                                    AppVideoStreamRenderer appVideoStreamRenderer2 = (AppVideoStreamRenderer) findViewById(C5419R.id.participant_video_stream_renderer);
                                                                                    if (appVideoStreamRenderer2 != null) {
                                                                                        i4 = C5419R.id.participant_voice_indicators;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) findViewById(C5419R.id.participant_voice_indicators);
                                                                                        if (linearLayout2 != null) {
                                                                                            i4 = C5419R.id.participant_voice_user_view;
                                                                                            VoiceUserView voiceUserView = (VoiceUserView) findViewById(C5419R.id.participant_voice_user_view);
                                                                                            if (voiceUserView != null) {
                                                                                                AttributeSet attributeSet3 = attributeSet2;
                                                                                                ViewVideoCallParticipantBinding viewVideoCallParticipantBinding = new ViewVideoCallParticipantBinding(this, viewFindViewById, viewFindViewById2, imageView, constraintLayout, space, imageView2, textView, linearLayout, textView2, textView3, imageView3, constraintLayout2, imageView4, textView4, textView5, simpleDraweeView, textView6, textView7, progressBar, appVideoStreamRenderer2, linearLayout2, voiceUserView);
                                                                                                Intrinsics3.checkNotNullExpressionValue(viewVideoCallParticipantBinding, "ViewVideoCallParticipant…ater.from(context), this)");
                                                                                                this.binding = viewVideoCallParticipantBinding;
                                                                                                this.onWatchStreamClicked = VideoCallParticipantView2.f2035j;
                                                                                                this.callUiInsets = new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0);
                                                                                                this.livePillBg = ContextCompat.getDrawable(context, C5419R.drawable.bg_stream_live_indicator);
                                                                                                this.liveSplitPillBg = ContextCompat.getDrawable(context, C5419R.drawable.bg_stream_live_indicator_split_pill);
                                                                                                this.onStreamQualityIndicatorClicked = C13172t.f27924j;
                                                                                                this.onStreamQualityIndicatorShown = C13172t.f27925k;
                                                                                                if (attributeSet3 != null) {
                                                                                                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet3, C5419R.a.VideoCallParticipantView, 0, 0);
                                                                                                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…            0\n          )");
                                                                                                    z2 = typedArrayObtainStyledAttributes.getBoolean(0, false);
                                                                                                    this.matchVideoOrientation = typedArrayObtainStyledAttributes.getBoolean(1, false);
                                                                                                    typedArrayObtainStyledAttributes.recycle();
                                                                                                    appVideoStreamRenderer = appVideoStreamRenderer2;
                                                                                                } else {
                                                                                                    this.matchVideoOrientation = false;
                                                                                                    appVideoStreamRenderer = appVideoStreamRenderer2;
                                                                                                    z2 = false;
                                                                                                }
                                                                                                appVideoStreamRenderer.setIsOverlay(z2);
                                                                                                appVideoStreamRenderer.setMatchVideoOrientation(this.matchVideoOrientation);
                                                                                                return;
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i4)));
    }

    /* renamed from: d */
    public static /* synthetic */ void m8580d(VideoCallParticipantView videoCallParticipantView, ParticipantData participantData, DisplayCutoutCompat displayCutoutCompat, boolean z2, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean z3, int i) {
        DisplayCutoutCompat displayCutoutCompat2 = (i & 2) != 0 ? videoCallParticipantView.displayCutout : null;
        if ((i & 4) != 0) {
            z2 = videoCallParticipantView.canOverlapTopCutout;
        }
        boolean z4 = z2;
        VideoCallGridAdapter.CallUiInsets callUiInsets2 = (i & 8) != 0 ? videoCallParticipantView.callUiInsets : null;
        if ((i & 16) != 0) {
            z3 = videoCallParticipantView.controlsVisible;
        }
        videoCallParticipantView.m8583c(participantData, displayCutoutCompat2, z4, callUiInsets2, z3);
    }

    /* renamed from: a */
    public final void m8581a(ParticipantData participantData) {
        CharSequence charSequenceM216h;
        ParticipantData.C7107a c7107a = participantData.streamQualityIndicatorData;
        if (!participantData.isFocused || !this.controlsVisible || c7107a == null) {
            m8582b(false);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.f916e;
        constraintLayout.setTranslationX(-this.callUiInsets.getRight());
        constraintLayout.setTranslationY(this.callUiInsets.getTop());
        constraintLayout.setOnClickListener(new ViewOnClickListenerC7110a(c7107a));
        ImageView imageView = this.binding.f917f;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.participantFullscreenStreamqualIcon");
        imageView.setVisibility(c7107a.f19249a ? 0 : 8);
        StreamResolution streamResolution = c7107a.f19250b;
        Context context = getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceMo8587a = streamResolution.mo8587a(context);
        StreamFps streamFps = c7107a.f19251c;
        if (streamFps != null) {
            Context context2 = getContext();
            Intrinsics3.checkNotNullExpressionValue(context2, "context");
            Intrinsics3.checkNotNullParameter(context2, "context");
            charSequenceM216h = FormatUtils.m216h(context2, C5419R.string.screenshare_fps_abbreviated, new Object[]{Integer.valueOf(streamFps.fps)}, null, 4);
        } else {
            charSequenceM216h = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequenceMo8587a);
        sb.append(' ');
        sb.append(charSequenceM216h);
        String string = sb.toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        String string2 = Strings4.trim(string).toString();
        Drawable drawable = (!(string2.length() == 0) || c7107a.f19249a) ? this.liveSplitPillBg : this.livePillBg;
        TextView textView = this.binding.f919h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.participantFulls…enStreamqualLiveIndicator");
        textView.setBackground(drawable);
        int i = c7107a.f19252d ? C5419R.color.primary_300 : C5419R.color.white;
        TextView textView2 = this.binding.f918g;
        textView2.setText(string2);
        CharSequence text = textView2.getText();
        Intrinsics3.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        textView2.setVisibility(text.length() > 0 ? 0 : 8);
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), i));
        textView2.requestLayout();
        this.onStreamQualityIndicatorShown.invoke(c7107a.f19250b, c7107a.f19251c);
        m8582b(true);
    }

    /* renamed from: b */
    public final void m8582b(boolean visible) {
        ViewExtensions.fadeBy(this.binding.f916e, visible, 200L);
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x047e  */
    @MainThread
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8583c(ParticipantData data, DisplayCutoutCompat displayCutout, boolean canOverlapTopCutout, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
        ParticipantData.Type type;
        boolean z2;
        Integer num;
        boolean z3;
        int i;
        Intrinsics3.checkNotNullParameter(callUiInsets, "callUiInsets");
        this.displayCutout = displayCutout;
        this.canOverlapTopCutout = canOverlapTopCutout;
        this.callUiInsets = callUiInsets;
        this.controlsVisible = controlsVisible;
        StoreVoiceParticipants.VoiceUser voiceUser = data != null ? data.voiceParticipant : null;
        if (voiceUser != null) {
            String colorId = RepresentativeColors2.getColorId(voiceUser.getUser());
            this.binding.f930s.setOnBitmapLoadedListener(new VideoCallParticipantView3(colorId));
            this.binding.f930s.m8570a(voiceUser, C5419R.dimen.avatar_size_hero);
            Subscription subscription = this.representativeColorSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Integer> observableM11103b0 = RepresentativeColors2.getUserRepresentativeColors().observeRepresentativeColor(colorId).m11103b0(VideoCallParticipantView4.f2036j);
            Intrinsics3.checkNotNullExpressionValue(observableM11103b0, "UserRepresentativeColors….takeUntil { it != null }");
            ObservableExtensionsKt.appSubscribe$default(observableM11103b0, VideoCallParticipantView.class, (Context) null, new C13004r(1, this), (Function1) null, (Function0) null, (Function0) null, new VideoCallParticipantView5(this), 58, (Object) null);
        }
        String forUser$default = IconUtils.getForUser$default(voiceUser != null ? voiceUser.getUser() : null, false, null, 6, null);
        if (!Intrinsics3.areEqual(forUser$default, this.userAvatarUrl)) {
            this.userAvatarUrl = forUser$default;
        }
        ParticipantData participantData = this.data;
        if (participantData == null || (type = participantData.type) == null) {
            type = ParticipantData.Type.DEFAULT;
        }
        boolean z4 = participantData != null && participantData.isFocused;
        Integer numM8585b = participantData != null ? participantData.m8585b() : null;
        this.data = data;
        Integer numM8585b2 = data != null ? data.m8585b() : null;
        Integer numM8585b3 = data != null ? data.m8585b() : null;
        if (!Intrinsics3.areEqual(numM8585b3, numM8585b)) {
            if (numM8585b3 != null) {
                AppVideoStreamRenderer appVideoStreamRenderer = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer.setVisibility(8);
                View view = this.binding.f914c;
                Intrinsics3.checkNotNullExpressionValue(view, "binding.participantBgLetterbox");
                SimpleDraweeView simpleDraweeView = this.binding.f924m;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.participantStreamPreviewImage");
                view.setVisibility((simpleDraweeView.getVisibility() == 0) ^ true ? 0 : 8);
                ProgressBar progressBar = this.binding.f927p;
                Intrinsics3.checkNotNullExpressionValue(progressBar, "binding.participantVideoLoadingIndicator");
                progressBar.setVisibility(0);
            } else {
                AppVideoStreamRenderer appVideoStreamRenderer2 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer2, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer2.setVisibility(8);
                View view2 = this.binding.f914c;
                Intrinsics3.checkNotNullExpressionValue(view2, "binding.participantBgLetterbox");
                view2.setVisibility(8);
                ProgressBar progressBar2 = this.binding.f927p;
                Intrinsics3.checkNotNullExpressionValue(progressBar2, "binding.participantVideoLoadingIndicator");
                progressBar2.setVisibility(8);
            }
        }
        boolean z5 = z4;
        ParticipantData.Type type2 = type;
        Integer num2 = numM8585b2;
        if ((data != null ? data.type : null) == ParticipantData.Type.APPLICATION_STREAMING) {
            View view3 = this.binding.f913b;
            Intrinsics3.checkNotNullExpressionValue(view3, "binding.participantBgAvatar");
            view3.setVisibility(8);
            VoiceUserView voiceUserView = this.binding.f930s;
            Intrinsics3.checkNotNullExpressionValue(voiceUserView, "binding.participantVoiceUserView");
            voiceUserView.setVisibility(8);
            ImageView imageView = this.binding.f921j;
            Intrinsics3.checkNotNullExpressionValue(imageView, "binding.participantMuteStatusIndicator");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.f915d;
            Intrinsics3.checkNotNullExpressionValue(imageView2, "binding.participantDeafenStatusIndicator");
            imageView2.setVisibility(8);
            ParticipantData.ApplicationStreamState applicationStreamState = data.applicationStreamState;
            if (applicationStreamState != null) {
                int iOrdinal = applicationStreamState.ordinal();
                if (iOrdinal == 0) {
                    ProgressBar progressBar3 = this.binding.f927p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar3, "binding.participantVideoLoadingIndicator");
                    progressBar3.setVisibility(0);
                    TextView textView = this.binding.f923l;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.participantStreamPaused");
                    textView.setVisibility(8);
                    ConstraintLayout constraintLayout = this.binding.f922k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout, "binding.participantStreamEnded");
                    constraintLayout.setVisibility(8);
                    SimpleDraweeView simpleDraweeView2 = this.binding.f924m;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.participantStreamPreviewImage");
                    simpleDraweeView2.setVisibility(0);
                    TextView textView2 = this.binding.f925n;
                    Intrinsics3.checkNotNullExpressionValue(textView2, "binding.participantStreamPreviewText");
                    textView2.setVisibility(8);
                    TextView textView3 = this.binding.f920i;
                    Intrinsics3.checkNotNullExpressionValue(textView3, "binding.participantLiveIndicator");
                    textView3.setVisibility(data.isFocused ^ true ? 0 : 8);
                    m8582b(false);
                } else if (iOrdinal == 1) {
                    TextView textView4 = this.binding.f925n;
                    Intrinsics3.checkNotNullExpressionValue(textView4, "binding.participantStreamPreviewText");
                    textView4.setVisibility(8);
                    TextView textView5 = this.binding.f923l;
                    Intrinsics3.checkNotNullExpressionValue(textView5, "binding.participantStreamPaused");
                    textView5.setVisibility(8);
                    ConstraintLayout constraintLayout2 = this.binding.f922k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout2, "binding.participantStreamEnded");
                    constraintLayout2.setVisibility(8);
                    TextView textView6 = this.binding.f920i;
                    Intrinsics3.checkNotNullExpressionValue(textView6, "binding.participantLiveIndicator");
                    textView6.setVisibility(data.isFocused ^ true ? 0 : 8);
                    m8581a(data);
                } else if (iOrdinal == 2) {
                    ProgressBar progressBar4 = this.binding.f927p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar4, "binding.participantVideoLoadingIndicator");
                    progressBar4.setVisibility(8);
                    SimpleDraweeView simpleDraweeView3 = this.binding.f924m;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.participantStreamPreviewImage");
                    simpleDraweeView3.setVisibility(0);
                    TextView textView7 = this.binding.f925n;
                    Intrinsics3.checkNotNullExpressionValue(textView7, "binding.participantStreamPreviewText");
                    textView7.setVisibility(0);
                    TextView textView8 = this.binding.f923l;
                    Intrinsics3.checkNotNullExpressionValue(textView8, "binding.participantStreamPaused");
                    textView8.setVisibility(8);
                    ConstraintLayout constraintLayout3 = this.binding.f922k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout3, "binding.participantStreamEnded");
                    constraintLayout3.setVisibility(8);
                    TextView textView9 = this.binding.f920i;
                    Intrinsics3.checkNotNullExpressionValue(textView9, "binding.participantLiveIndicator");
                    textView9.setVisibility(8);
                    this.binding.f925n.setOnClickListener(new VideoCallParticipantView6(this, data));
                    StreamContext streamContext = data.voiceParticipant.getStreamContext();
                    StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
                    if (preview instanceof StoreApplicationStreamPreviews.StreamPreview.Resolved) {
                        this.binding.f924m.setImageURI(((StoreApplicationStreamPreviews.StreamPreview.Resolved) preview).getUrl());
                        SimpleDraweeView simpleDraweeView4 = this.binding.f924m;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.participantStreamPreviewImage");
                        ViewGroup.LayoutParams layoutParams = simpleDraweeView4.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        layoutParams2.dimensionRatio = "16:9";
                        simpleDraweeView4.setLayoutParams(layoutParams2);
                    } else {
                        this.binding.f924m.setImageURI((String) null);
                        SimpleDraweeView simpleDraweeView5 = this.binding.f924m;
                        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView5, "binding.participantStreamPreviewImage");
                        ViewGroup.LayoutParams layoutParams3 = simpleDraweeView5.getLayoutParams();
                        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                        layoutParams4.dimensionRatio = null;
                        simpleDraweeView5.setLayoutParams(layoutParams4);
                    }
                    m8582b(false);
                } else if (iOrdinal == 3) {
                    ProgressBar progressBar5 = this.binding.f927p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar5, "binding.participantVideoLoadingIndicator");
                    progressBar5.setVisibility(8);
                    SimpleDraweeView simpleDraweeView6 = this.binding.f924m;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView6, "binding.participantStreamPreviewImage");
                    simpleDraweeView6.setVisibility(0);
                    TextView textView10 = this.binding.f925n;
                    Intrinsics3.checkNotNullExpressionValue(textView10, "binding.participantStreamPreviewText");
                    textView10.setVisibility(8);
                    TextView textView11 = this.binding.f923l;
                    Intrinsics3.checkNotNullExpressionValue(textView11, "binding.participantStreamPaused");
                    textView11.setVisibility(0);
                    ConstraintLayout constraintLayout4 = this.binding.f922k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout4, "binding.participantStreamEnded");
                    constraintLayout4.setVisibility(8);
                    TextView textView12 = this.binding.f920i;
                    Intrinsics3.checkNotNullExpressionValue(textView12, "binding.participantLiveIndicator");
                    textView12.setVisibility(data.isFocused ^ true ? 0 : 8);
                    m8581a(data);
                } else if (iOrdinal == 4) {
                    ProgressBar progressBar6 = this.binding.f927p;
                    Intrinsics3.checkNotNullExpressionValue(progressBar6, "binding.participantVideoLoadingIndicator");
                    progressBar6.setVisibility(8);
                    TextView textView13 = this.binding.f925n;
                    Intrinsics3.checkNotNullExpressionValue(textView13, "binding.participantStreamPreviewText");
                    textView13.setVisibility(8);
                    TextView textView14 = this.binding.f923l;
                    Intrinsics3.checkNotNullExpressionValue(textView14, "binding.participantStreamPaused");
                    textView14.setVisibility(8);
                    ConstraintLayout constraintLayout5 = this.binding.f922k;
                    Intrinsics3.checkNotNullExpressionValue(constraintLayout5, "binding.participantStreamEnded");
                    constraintLayout5.setVisibility(0);
                    TextView textView15 = this.binding.f920i;
                    Intrinsics3.checkNotNullExpressionValue(textView15, "binding.participantLiveIndicator");
                    textView15.setVisibility(8);
                    m8582b(false);
                }
            }
        } else {
            SimpleDraweeView simpleDraweeView7 = this.binding.f924m;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView7, "binding.participantStreamPreviewImage");
            simpleDraweeView7.setVisibility(8);
            TextView textView16 = this.binding.f925n;
            Intrinsics3.checkNotNullExpressionValue(textView16, "binding.participantStreamPreviewText");
            textView16.setVisibility(8);
            TextView textView17 = this.binding.f923l;
            Intrinsics3.checkNotNullExpressionValue(textView17, "binding.participantStreamPaused");
            textView17.setVisibility(8);
            ConstraintLayout constraintLayout6 = this.binding.f922k;
            Intrinsics3.checkNotNullExpressionValue(constraintLayout6, "binding.participantStreamEnded");
            constraintLayout6.setVisibility(8);
            m8582b(false);
            ImageView imageView3 = this.binding.f921j;
            Intrinsics3.checkNotNullExpressionValue(imageView3, "binding.participantMuteStatusIndicator");
            imageView3.setVisibility(voiceUser != null ? voiceUser.getIsMuted() : false ? 0 : 8);
            ImageView imageView4 = this.binding.f915d;
            Intrinsics3.checkNotNullExpressionValue(imageView4, "binding.participantDeafenStatusIndicator");
            imageView4.setVisibility(voiceUser != null ? voiceUser.getIsDeafened() : false ? 0 : 8);
            if (num2 != null) {
                View view4 = this.binding.f913b;
                Intrinsics3.checkNotNullExpressionValue(view4, "binding.participantBgAvatar");
                view4.setVisibility(8);
                VoiceUserView voiceUserView2 = this.binding.f930s;
                Intrinsics3.checkNotNullExpressionValue(voiceUserView2, "binding.participantVoiceUserView");
                voiceUserView2.setVisibility(8);
            } else {
                View view5 = this.binding.f913b;
                Intrinsics3.checkNotNullExpressionValue(view5, "binding.participantBgAvatar");
                view5.setVisibility(0);
                VoiceUserView voiceUserView3 = this.binding.f930s;
                Intrinsics3.checkNotNullExpressionValue(voiceUserView3, "binding.participantVoiceUserView");
                voiceUserView3.setVisibility(0);
            }
            TextView textView18 = this.binding.f920i;
            Intrinsics3.checkNotNullExpressionValue(textView18, "binding.participantLiveIndicator");
            textView18.setVisibility(8);
        }
        LinearLayout linearLayout = this.binding.f929r;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.participantVoiceIndicators");
        LinearLayout linearLayout2 = this.binding.f929r;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.participantVoiceIndicators");
        Iterator<View> it = androidx.core.view.ViewGroup.getChildren(linearLayout2).iterator();
        while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            } else {
                if (it.next().getVisibility() == 0) {
                    z2 = true;
                    break;
                }
            }
        }
        linearLayout.setVisibility(z2 ? 0 : 8);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        DisplayCutoutCompat displayCutoutCompat = this.displayCutout;
        if ((displayCutoutCompat != null ? displayCutoutCompat.getSafeInsetTop() : 0) <= 0 || !this.canOverlapTopCutout) {
            TextView textView19 = this.binding.f920i;
            Intrinsics3.checkNotNullExpressionValue(textView19, "binding.participantLiveIndicator");
            constraintSet.connect(textView19.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
            TextView textView20 = this.binding.f920i;
            Intrinsics3.checkNotNullExpressionValue(textView20, "binding.participantLiveIndicator");
            constraintSet.connect(textView20.getId(), 3, 0, 3, DimenUtils.dpToPixels(8));
            TextView textView21 = this.binding.f920i;
            Intrinsics3.checkNotNullExpressionValue(textView21, "binding.participantLiveIndicator");
            constraintSet.clear(textView21.getId(), 4);
        } else {
            LinearLayout linearLayout3 = this.binding.f929r;
            Intrinsics3.checkNotNullExpressionValue(linearLayout3, "binding.participantVoiceIndicators");
            if (!(linearLayout3.getVisibility() == 0)) {
                TextView textView22 = this.binding.f920i;
                Intrinsics3.checkNotNullExpressionValue(textView22, "binding.participantLiveIndicator");
                constraintSet.connect(textView22.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
                TextView textView23 = this.binding.f920i;
                Intrinsics3.checkNotNullExpressionValue(textView23, "binding.participantLiveIndicator");
                constraintSet.connect(textView23.getId(), 4, 0, 4, DimenUtils.dpToPixels(8));
                TextView textView24 = this.binding.f920i;
                Intrinsics3.checkNotNullExpressionValue(textView24, "binding.participantLiveIndicator");
                constraintSet.clear(textView24.getId(), 3);
            }
        }
        AppVideoStreamRenderer appVideoStreamRenderer3 = this.binding.f928q;
        RendererCommon.ScalingType scalingType = data != null ? data.scalingType : null;
        RendererCommon.ScalingType scalingType2 = data != null ? data.scalingTypeMismatchOrientation : null;
        if (data != null) {
            z3 = data.mirrorVideo;
            num = num2;
        } else {
            num = num2;
            z3 = false;
        }
        appVideoStreamRenderer3.m8572c(num, scalingType, scalingType2, z3);
        Subscription subscription2 = this.frameRenderedSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        if (num != null) {
            BehaviorSubject<Point> behaviorSubject = this.binding.f928q.currentFrameResolutionSubject;
            Intrinsics3.checkNotNullExpressionValue(behaviorSubject, "currentFrameResolutionSubject");
            Observable<R> observableM11083G = behaviorSubject.m11118y(ObservableExtensionsKt.C68871.INSTANCE).m11083G(ObservableExtensionsKt.C68882.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableM11083G, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(observableM11083G, VideoCallParticipantView.class, (Context) null, new C13004r(0, this), (Function1) null, (Function0) null, (Function0) null, new VideoCallParticipantView7(this), 58, (Object) null);
        }
        ParticipantData participantData2 = this.data;
        ParticipantData.Type type3 = participantData2 != null ? participantData2.type : null;
        boolean z6 = data != null && data.isFocused;
        if (type3 != null && (type3 != type2 || z6 != z5)) {
            if (type3 != ParticipantData.Type.DEFAULT || z6) {
                ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                AppVideoStreamRenderer appVideoStreamRenderer4 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer4, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer4.setLayoutParams(layoutParams5);
                AppVideoStreamRenderer appVideoStreamRenderer5 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer5, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer5.getId(), 1);
                AppVideoStreamRenderer appVideoStreamRenderer6 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer6, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer6.getId(), 1);
            } else {
                ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(0, 0);
                AppVideoStreamRenderer appVideoStreamRenderer7 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer7, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer7.setLayoutParams(layoutParams6);
                AppVideoStreamRenderer appVideoStreamRenderer8 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer8, "binding.participantVideoStreamRenderer");
                constraintSet.constrainHeight(appVideoStreamRenderer8.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer9 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer9, "binding.participantVideoStreamRenderer");
                constraintSet.constrainWidth(appVideoStreamRenderer9.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer10 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer10, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer10.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer11 = this.binding.f928q;
                Intrinsics3.checkNotNullExpressionValue(appVideoStreamRenderer11, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer11.getId(), 0);
            }
        }
        constraintSet.applyTo(this);
        if (voiceUser != null) {
            TextView textView25 = this.binding.f926o;
            Intrinsics3.checkNotNullExpressionValue(textView25, "binding.participantVideoLabel");
            textView25.setText(voiceUser.getDisplayName());
            if (data.type == ParticipantData.Type.APPLICATION_STREAMING) {
                Context context = getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                i = 0;
                setContentDescription(FormatUtils.m216h(context, C5419R.string.go_live_tile_screen, new Object[]{voiceUser.getDisplayName()}, null, 4));
                this.binding.f926o.setCompoundDrawablesWithIntrinsicBounds(C5419R.drawable.ic_screen_14dp, 0, 0, 0);
            } else {
                i = 0;
                setContentDescription(voiceUser.getDisplayName());
                this.binding.f926o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (this.animateLabelFades) {
                ViewExtensions.fadeBy(this.binding.f926o, data.showLabel, 200L);
                return;
            }
            TextView textView26 = this.binding.f926o;
            Intrinsics3.checkNotNullExpressionValue(textView26, "binding.participantVideoLabel");
            if (!data.showLabel) {
                i = 8;
            }
            textView26.setVisibility(i);
            this.animateLabelFades = true;
        }
    }

    public final ParticipantData getData() {
        return this.data;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public String getDataId() {
        ParticipantData participantData = this.data;
        if (participantData != null) {
            return participantData.id;
        }
        return null;
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public void onBind(FrameGridLayout.Data data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        m8580d(this, (ParticipantData) data, null, false, null, false, 30);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.representativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.animateLabelFades = false;
        this.binding.f928q.m8572c(null, null, null, false);
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public void onRemove() {
        FrameGridLayout.DataView.DefaultImpls.onRemove(this);
    }

    public final void setData(ParticipantData participantData) {
        this.data = participantData;
    }

    public final void setOnWatchStreamClicked(Function1<? super String, Unit> onWatchStreamClicked) {
        Intrinsics3.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
        this.onWatchStreamClicked = onWatchStreamClicked;
    }

    /* compiled from: VideoCallParticipantView.kt */
    public static final /* data */ class ParticipantData implements FrameGridLayout.Data {

        /* renamed from: a, reason: from kotlin metadata */
        public final String id;

        /* renamed from: b, reason: from kotlin metadata */
        public final StoreVoiceParticipants.VoiceUser voiceParticipant;

        /* renamed from: c, reason: from kotlin metadata */
        public final boolean mirrorVideo;

        /* renamed from: d, reason: from kotlin metadata */
        public final RendererCommon.ScalingType scalingType;

        /* renamed from: e, reason: from kotlin metadata */
        public final RendererCommon.ScalingType scalingTypeMismatchOrientation;

        /* renamed from: f, reason: from kotlin metadata */
        public final ApplicationStreamState applicationStreamState;

        /* renamed from: g, reason: from kotlin metadata */
        public final Type type;

        /* renamed from: h, reason: from kotlin metadata */
        public final boolean showLabel;

        /* renamed from: i, reason: from kotlin metadata */
        public final boolean isFocused;

        /* renamed from: j, reason: from kotlin metadata */
        public final C7107a streamQualityIndicatorData;

        /* compiled from: VideoCallParticipantView.kt */
        public enum ApplicationStreamState {
            CONNECTING,
            ACTIVE,
            INACTIVE,
            PAUSED,
            ENDED
        }

        /* compiled from: VideoCallParticipantView.kt */
        public enum Type {
            DEFAULT,
            APPLICATION_STREAMING
        }

        /* compiled from: VideoCallParticipantView.kt */
        /* renamed from: com.discord.views.calls.VideoCallParticipantView$ParticipantData$a */
        public static final class C7107a {

            /* renamed from: a */
            public final boolean f19249a;

            /* renamed from: b */
            public final StreamResolution f19250b;

            /* renamed from: c */
            public final StreamFps f19251c;

            /* renamed from: d */
            public final boolean f19252d;

            public C7107a(boolean z2, StreamResolution streamResolution, StreamFps streamFps, boolean z3) {
                Intrinsics3.checkNotNullParameter(streamResolution, "resolution");
                this.f19249a = z2;
                this.f19250b = streamResolution;
                this.f19251c = streamFps;
                this.f19252d = z3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C7107a)) {
                    return false;
                }
                C7107a c7107a = (C7107a) obj;
                return this.f19249a == c7107a.f19249a && Intrinsics3.areEqual(this.f19250b, c7107a.f19250b) && Intrinsics3.areEqual(this.f19251c, c7107a.f19251c) && this.f19252d == c7107a.f19252d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            public int hashCode() {
                boolean z2 = this.f19249a;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                StreamResolution streamResolution = this.f19250b;
                int iHashCode = (i + (streamResolution != null ? streamResolution.hashCode() : 0)) * 31;
                StreamFps streamFps = this.f19251c;
                int fps = (iHashCode + (streamFps != null ? streamFps.getFps() : 0)) * 31;
                boolean z3 = this.f19252d;
                return fps + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbM833U = outline.m833U("StreamQualityIndicatorData(showPremiumIcon=");
                sbM833U.append(this.f19249a);
                sbM833U.append(", resolution=");
                sbM833U.append(this.f19250b);
                sbM833U.append(", fps=");
                sbM833U.append(this.f19251c);
                sbM833U.append(", isBadQuality=");
                return outline.m827O(sbM833U, this.f19252d, ")");
            }
        }

        public ParticipantData(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, C7107a c7107a) {
            Intrinsics3.checkNotNullParameter(voiceUser, "voiceParticipant");
            Intrinsics3.checkNotNullParameter(type, "type");
            this.voiceParticipant = voiceUser;
            this.mirrorVideo = z2;
            this.scalingType = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
            this.applicationStreamState = applicationStreamState;
            this.type = type;
            this.showLabel = z3;
            this.isFocused = z4;
            this.streamQualityIndicatorData = c7107a;
            StringBuilder sb = new StringBuilder();
            sb.append(voiceUser.getUser().getId());
            sb.append(type);
            this.id = sb.toString();
        }

        /* renamed from: a */
        public static ParticipantData m8584a(ParticipantData participantData, StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, C7107a c7107a, int i) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = (i & 1) != 0 ? participantData.voiceParticipant : null;
            boolean z5 = (i & 2) != 0 ? participantData.mirrorVideo : z2;
            RendererCommon.ScalingType scalingType3 = (i & 4) != 0 ? participantData.scalingType : scalingType;
            RendererCommon.ScalingType scalingType4 = (i & 8) != 0 ? participantData.scalingTypeMismatchOrientation : scalingType2;
            ApplicationStreamState applicationStreamState2 = (i & 16) != 0 ? participantData.applicationStreamState : null;
            Type type2 = (i & 32) != 0 ? participantData.type : null;
            boolean z6 = (i & 64) != 0 ? participantData.showLabel : z3;
            boolean z7 = (i & 128) != 0 ? participantData.isFocused : z4;
            C7107a c7107a2 = (i & 256) != 0 ? participantData.streamQualityIndicatorData : c7107a;
            Objects.requireNonNull(participantData);
            Intrinsics3.checkNotNullParameter(voiceUser2, "voiceParticipant");
            Intrinsics3.checkNotNullParameter(type2, "type");
            return new ParticipantData(voiceUser2, z5, scalingType3, scalingType4, applicationStreamState2, type2, z6, z7, c7107a2);
        }

        /* renamed from: b */
        public final Integer m8585b() {
            VoiceState voiceState;
            int iOrdinal = this.type.ordinal();
            if (iOrdinal == 0) {
                VoiceState voiceState2 = this.voiceParticipant.getVoiceState();
                if (voiceState2 == null || !voiceState2.getSelfVideo()) {
                    return null;
                }
                return this.voiceParticipant.getCallStreamId();
            }
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            ApplicationStreamState applicationStreamState = this.applicationStreamState;
            if ((applicationStreamState == ApplicationStreamState.CONNECTING || applicationStreamState == ApplicationStreamState.ACTIVE || applicationStreamState == ApplicationStreamState.PAUSED) && (voiceState = this.voiceParticipant.getVoiceState()) != null && voiceState.getSelfStream()) {
                return this.voiceParticipant.getApplicationStreamId();
            }
            return null;
        }

        @Override // com.discord.utilities.view.grid.FrameGridLayout.Data
        public View createView(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            return new VideoCallParticipantView(context, null, 0, 6);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParticipantData)) {
                return false;
            }
            ParticipantData participantData = (ParticipantData) other;
            return Intrinsics3.areEqual(this.voiceParticipant, participantData.voiceParticipant) && this.mirrorVideo == participantData.mirrorVideo && Intrinsics3.areEqual(this.scalingType, participantData.scalingType) && Intrinsics3.areEqual(this.scalingTypeMismatchOrientation, participantData.scalingTypeMismatchOrientation) && Intrinsics3.areEqual(this.applicationStreamState, participantData.applicationStreamState) && Intrinsics3.areEqual(this.type, participantData.type) && this.showLabel == participantData.showLabel && this.isFocused == participantData.isFocused && Intrinsics3.areEqual(this.streamQualityIndicatorData, participantData.streamQualityIndicatorData);
        }

        @Override // com.discord.utilities.view.grid.FrameGridLayout.Data
        public String getId() {
            return this.id;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            StoreVoiceParticipants.VoiceUser voiceUser = this.voiceParticipant;
            int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
            boolean z2 = this.mirrorVideo;
            int i = z2;
            if (z2 != 0) {
                i = 1;
            }
            int i2 = (iHashCode + i) * 31;
            RendererCommon.ScalingType scalingType = this.scalingType;
            int iHashCode2 = (i2 + (scalingType != null ? scalingType.hashCode() : 0)) * 31;
            RendererCommon.ScalingType scalingType2 = this.scalingTypeMismatchOrientation;
            int iHashCode3 = (iHashCode2 + (scalingType2 != null ? scalingType2.hashCode() : 0)) * 31;
            ApplicationStreamState applicationStreamState = this.applicationStreamState;
            int iHashCode4 = (iHashCode3 + (applicationStreamState != null ? applicationStreamState.hashCode() : 0)) * 31;
            Type type = this.type;
            int iHashCode5 = (iHashCode4 + (type != null ? type.hashCode() : 0)) * 31;
            boolean z3 = this.showLabel;
            int i3 = z3;
            if (z3 != 0) {
                i3 = 1;
            }
            int i4 = (iHashCode5 + i3) * 31;
            boolean z4 = this.isFocused;
            int i5 = (i4 + (z4 ? 1 : z4 ? 1 : 0)) * 31;
            C7107a c7107a = this.streamQualityIndicatorData;
            return i5 + (c7107a != null ? c7107a.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("ParticipantData(voiceParticipant=");
            sbM833U.append(this.voiceParticipant);
            sbM833U.append(", mirrorVideo=");
            sbM833U.append(this.mirrorVideo);
            sbM833U.append(", scalingType=");
            sbM833U.append(this.scalingType);
            sbM833U.append(", scalingTypeMismatchOrientation=");
            sbM833U.append(this.scalingTypeMismatchOrientation);
            sbM833U.append(", applicationStreamState=");
            sbM833U.append(this.applicationStreamState);
            sbM833U.append(", type=");
            sbM833U.append(this.type);
            sbM833U.append(", showLabel=");
            sbM833U.append(this.showLabel);
            sbM833U.append(", isFocused=");
            sbM833U.append(this.isFocused);
            sbM833U.append(", streamQualityIndicatorData=");
            sbM833U.append(this.streamQualityIndicatorData);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ParticipantData(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, C7107a c7107a, int i) {
            this(voiceUser, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? RendererCommon.ScalingType.SCALE_ASPECT_BALANCED : scalingType, (i & 8) != 0 ? RendererCommon.ScalingType.SCALE_ASPECT_FIT : scalingType2, (i & 16) != 0 ? null : applicationStreamState, (i & 32) != 0 ? Type.DEFAULT : type, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? false : z4, null);
            int i2 = i & 256;
        }
    }
}
