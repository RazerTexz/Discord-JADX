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
import androidx.core.view.ViewGroupKt;
import b.a.i.h4;
import b.a.k.b;
import b.a.y.j0.j;
import b.a.y.j0.k;
import b.a.y.j0.l;
import b.a.y.j0.n;
import b.a.y.j0.o;
import com.discord.R;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreApplicationStreamPreviews;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.colors.RepresentativeColorsKt;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.grid.FrameGridLayout;
import com.discord.views.VoiceUserView;
import com.discord.widgets.voice.fullscreen.grid.VideoCallGridAdapter;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.w;
import d0.z.d.m;
import defpackage.r;
import defpackage.t;
import java.util.Iterator;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.webrtc.RendererCommon;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;

/* compiled from: VideoCallParticipantView.kt */
/* loaded from: classes2.dex */
public final class VideoCallParticipantView extends ConstraintLayout implements FrameGridLayout.DataView {

    /* renamed from: j, reason: from kotlin metadata */
    public final h4 binding;

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

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean canOverlapTopCutout;

    /* renamed from: t, reason: from kotlin metadata */
    public VideoCallGridAdapter.CallUiInsets callUiInsets;

    /* renamed from: u, reason: from kotlin metadata */
    public boolean controlsVisible;

    /* renamed from: v, reason: from kotlin metadata */
    public Drawable livePillBg;

    /* renamed from: w, reason: from kotlin metadata */
    public Drawable liveSplitPillBg;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public Function2<? super StreamResolution, ? super StreamFps, Unit> onStreamQualityIndicatorClicked;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public Function2<? super StreamResolution, ? super StreamFps, Unit> onStreamQualityIndicatorShown;

    /* compiled from: VideoCallParticipantView.kt */
    public static final /* data */ class StreamFps {

        /* renamed from: a, reason: from kotlin metadata */
        public final int fps;

        public StreamFps(int i) {
            this.fps = i;
        }

        public final boolean a() {
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
            return b.d.b.a.a.B(b.d.b.a.a.U("StreamFps(fps="), this.fps, ")");
        }
    }

    /* compiled from: VideoCallParticipantView.kt */
    public static abstract class StreamResolution {

        /* compiled from: VideoCallParticipantView.kt */
        public static final class a extends StreamResolution {
            public final int a;

            public a(int i) {
                super(null);
                this.a = i;
            }

            @Override // com.discord.views.calls.VideoCallParticipantView.StreamResolution
            public CharSequence a(Context context) {
                m.checkNotNullParameter(context, "context");
                return b.a.k.b.h(context, R.string.screenshare_resolution_abbreviated, new Object[]{Integer.valueOf(this.a)}, null, 4);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof a) && this.a == ((a) obj).a;
                }
                return true;
            }

            public int hashCode() {
                return this.a;
            }

            public String toString() {
                return b.d.b.a.a.B(b.d.b.a.a.U("Fixed(heightPx="), this.a, ")");
            }
        }

        /* compiled from: VideoCallParticipantView.kt */
        public static final class b extends StreamResolution {
            public static final b a = new b();

            public b() {
                super(null);
            }

            @Override // com.discord.views.calls.VideoCallParticipantView.StreamResolution
            public CharSequence a(Context context) {
                m.checkNotNullParameter(context, "context");
                return b.a.k.b.h(context, R.string.screenshare_source, new Object[0], null, 4);
            }
        }

        public StreamResolution() {
        }

        public abstract CharSequence a(Context context);

        public final boolean b() {
            return (this instanceof b) || ((this instanceof a) && ((a) this).a == 1080);
        }

        public StreamResolution(DefaultConstructorMarker defaultConstructorMarker) {
        }
    }

    /* compiled from: VideoCallParticipantView.kt */
    public static final class a implements View.OnClickListener {
        public final /* synthetic */ ParticipantData.a k;

        public a(ParticipantData.a aVar) {
            this.k = aVar;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function2<? super StreamResolution, ? super StreamFps, Unit> function2 = VideoCallParticipantView.this.onStreamQualityIndicatorClicked;
            ParticipantData.a aVar = this.k;
            function2.invoke(aVar.f2841b, aVar.c);
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
        m.checkNotNullParameter(context, "context");
        super(context, attributeSet2, i3);
        LayoutInflater.from(context).inflate(R.layout.view_video_call_participant, this);
        int i4 = R.id.participant_bg_avatar;
        View viewFindViewById = findViewById(R.id.participant_bg_avatar);
        if (viewFindViewById != null) {
            i4 = R.id.participant_bg_letterbox;
            View viewFindViewById2 = findViewById(R.id.participant_bg_letterbox);
            if (viewFindViewById2 != null) {
                i4 = R.id.participant_deafen_status_indicator;
                ImageView imageView = (ImageView) findViewById(R.id.participant_deafen_status_indicator);
                if (imageView != null) {
                    i4 = R.id.participant_fullscreen_streamqual_container;
                    ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.participant_fullscreen_streamqual_container);
                    if (constraintLayout != null) {
                        i4 = R.id.participant_fullscreen_streamqual_divider;
                        Space space = (Space) findViewById(R.id.participant_fullscreen_streamqual_divider);
                        if (space != null) {
                            i4 = R.id.participant_fullscreen_streamqual_icon;
                            ImageView imageView2 = (ImageView) findViewById(R.id.participant_fullscreen_streamqual_icon);
                            if (imageView2 != null) {
                                i4 = R.id.participant_fullscreen_streamqual_info;
                                TextView textView = (TextView) findViewById(R.id.participant_fullscreen_streamqual_info);
                                if (textView != null) {
                                    i4 = R.id.participant_fullscreen_streamqual_info_container;
                                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.participant_fullscreen_streamqual_info_container);
                                    if (linearLayout != null) {
                                        i4 = R.id.participant_fullscreen_streamqual_live_indicator;
                                        TextView textView2 = (TextView) findViewById(R.id.participant_fullscreen_streamqual_live_indicator);
                                        if (textView2 != null) {
                                            i4 = R.id.participant_live_indicator;
                                            TextView textView3 = (TextView) findViewById(R.id.participant_live_indicator);
                                            if (textView3 != null) {
                                                i4 = R.id.participant_mute_status_indicator;
                                                ImageView imageView3 = (ImageView) findViewById(R.id.participant_mute_status_indicator);
                                                if (imageView3 != null) {
                                                    i4 = R.id.participant_stream_ended;
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) findViewById(R.id.participant_stream_ended);
                                                    if (constraintLayout2 != null) {
                                                        i4 = R.id.participant_stream_ended_img;
                                                        ImageView imageView4 = (ImageView) findViewById(R.id.participant_stream_ended_img);
                                                        if (imageView4 != null) {
                                                            i4 = R.id.participant_stream_ended_label;
                                                            TextView textView4 = (TextView) findViewById(R.id.participant_stream_ended_label);
                                                            if (textView4 != null) {
                                                                i4 = R.id.participant_stream_paused;
                                                                TextView textView5 = (TextView) findViewById(R.id.participant_stream_paused);
                                                                if (textView5 != null) {
                                                                    i4 = R.id.participant_stream_preview_image;
                                                                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R.id.participant_stream_preview_image);
                                                                    if (simpleDraweeView != null) {
                                                                        i4 = R.id.participant_stream_preview_text;
                                                                        TextView textView6 = (TextView) findViewById(R.id.participant_stream_preview_text);
                                                                        if (textView6 != null) {
                                                                            i4 = R.id.participant_video_label;
                                                                            TextView textView7 = (TextView) findViewById(R.id.participant_video_label);
                                                                            if (textView7 != null) {
                                                                                i4 = R.id.participant_video_loading_indicator;
                                                                                ProgressBar progressBar = (ProgressBar) findViewById(R.id.participant_video_loading_indicator);
                                                                                if (progressBar != null) {
                                                                                    i4 = R.id.participant_video_stream_renderer;
                                                                                    AppVideoStreamRenderer appVideoStreamRenderer2 = (AppVideoStreamRenderer) findViewById(R.id.participant_video_stream_renderer);
                                                                                    if (appVideoStreamRenderer2 != null) {
                                                                                        i4 = R.id.participant_voice_indicators;
                                                                                        LinearLayout linearLayout2 = (LinearLayout) findViewById(R.id.participant_voice_indicators);
                                                                                        if (linearLayout2 != null) {
                                                                                            i4 = R.id.participant_voice_user_view;
                                                                                            VoiceUserView voiceUserView = (VoiceUserView) findViewById(R.id.participant_voice_user_view);
                                                                                            if (voiceUserView != null) {
                                                                                                AttributeSet attributeSet3 = attributeSet2;
                                                                                                h4 h4Var = new h4(this, viewFindViewById, viewFindViewById2, imageView, constraintLayout, space, imageView2, textView, linearLayout, textView2, textView3, imageView3, constraintLayout2, imageView4, textView4, textView5, simpleDraweeView, textView6, textView7, progressBar, appVideoStreamRenderer2, linearLayout2, voiceUserView);
                                                                                                m.checkNotNullExpressionValue(h4Var, "ViewVideoCallParticipant…ater.from(context), this)");
                                                                                                this.binding = h4Var;
                                                                                                this.onWatchStreamClicked = j.j;
                                                                                                this.callUiInsets = new VideoCallGridAdapter.CallUiInsets(0, 0, 0, 0);
                                                                                                this.livePillBg = ContextCompat.getDrawable(context, R.drawable.bg_stream_live_indicator);
                                                                                                this.liveSplitPillBg = ContextCompat.getDrawable(context, R.drawable.bg_stream_live_indicator_split_pill);
                                                                                                this.onStreamQualityIndicatorClicked = t.j;
                                                                                                this.onStreamQualityIndicatorShown = t.k;
                                                                                                if (attributeSet3 != null) {
                                                                                                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet3, R.a.VideoCallParticipantView, 0, 0);
                                                                                                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…            0\n          )");
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

    public static /* synthetic */ void d(VideoCallParticipantView videoCallParticipantView, ParticipantData participantData, DisplayCutoutCompat displayCutoutCompat, boolean z2, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean z3, int i) {
        DisplayCutoutCompat displayCutoutCompat2 = (i & 2) != 0 ? videoCallParticipantView.displayCutout : null;
        if ((i & 4) != 0) {
            z2 = videoCallParticipantView.canOverlapTopCutout;
        }
        boolean z4 = z2;
        VideoCallGridAdapter.CallUiInsets callUiInsets2 = (i & 8) != 0 ? videoCallParticipantView.callUiInsets : null;
        if ((i & 16) != 0) {
            z3 = videoCallParticipantView.controlsVisible;
        }
        videoCallParticipantView.c(participantData, displayCutoutCompat2, z4, callUiInsets2, z3);
    }

    public final void a(ParticipantData participantData) {
        CharSequence charSequenceH;
        ParticipantData.a aVar = participantData.streamQualityIndicatorData;
        if (!participantData.isFocused || !this.controlsVisible || aVar == null) {
            b(false);
            return;
        }
        ConstraintLayout constraintLayout = this.binding.e;
        constraintLayout.setTranslationX(-this.callUiInsets.getRight());
        constraintLayout.setTranslationY(this.callUiInsets.getTop());
        constraintLayout.setOnClickListener(new a(aVar));
        ImageView imageView = this.binding.f;
        m.checkNotNullExpressionValue(imageView, "binding.participantFullscreenStreamqualIcon");
        imageView.setVisibility(aVar.a ? 0 : 8);
        StreamResolution streamResolution = aVar.f2841b;
        Context context = getContext();
        m.checkNotNullExpressionValue(context, "context");
        CharSequence charSequenceA = streamResolution.a(context);
        StreamFps streamFps = aVar.c;
        if (streamFps != null) {
            Context context2 = getContext();
            m.checkNotNullExpressionValue(context2, "context");
            m.checkNotNullParameter(context2, "context");
            charSequenceH = b.h(context2, R.string.screenshare_fps_abbreviated, new Object[]{Integer.valueOf(streamFps.fps)}, null, 4);
        } else {
            charSequenceH = "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(charSequenceA);
        sb.append(' ');
        sb.append(charSequenceH);
        String string = sb.toString();
        Objects.requireNonNull(string, "null cannot be cast to non-null type kotlin.CharSequence");
        String string2 = w.trim(string).toString();
        Drawable drawable = (!(string2.length() == 0) || aVar.a) ? this.liveSplitPillBg : this.livePillBg;
        TextView textView = this.binding.h;
        m.checkNotNullExpressionValue(textView, "binding.participantFulls…enStreamqualLiveIndicator");
        textView.setBackground(drawable);
        int i = aVar.d ? R.color.primary_300 : R.color.white;
        TextView textView2 = this.binding.g;
        textView2.setText(string2);
        CharSequence text = textView2.getText();
        m.checkNotNullExpressionValue(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        textView2.setVisibility(text.length() > 0 ? 0 : 8);
        textView2.setTextColor(ContextCompat.getColor(textView2.getContext(), i));
        textView2.requestLayout();
        this.onStreamQualityIndicatorShown.invoke(aVar.f2841b, aVar.c);
        b(true);
    }

    public final void b(boolean visible) {
        ViewExtensions.fadeBy(this.binding.e, visible, 200L);
    }

    /* JADX WARN: Removed duplicated region for block: B:141:0x047e  */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void c(ParticipantData data, DisplayCutoutCompat displayCutout, boolean canOverlapTopCutout, VideoCallGridAdapter.CallUiInsets callUiInsets, boolean controlsVisible) {
        ParticipantData.Type type;
        boolean z2;
        Integer num;
        boolean z3;
        int i;
        m.checkNotNullParameter(callUiInsets, "callUiInsets");
        this.displayCutout = displayCutout;
        this.canOverlapTopCutout = canOverlapTopCutout;
        this.callUiInsets = callUiInsets;
        this.controlsVisible = controlsVisible;
        StoreVoiceParticipants.VoiceUser voiceUser = data != null ? data.voiceParticipant : null;
        if (voiceUser != null) {
            String colorId = RepresentativeColorsKt.getColorId(voiceUser.getUser());
            this.binding.f128s.setOnBitmapLoadedListener(new k(colorId));
            this.binding.f128s.a(voiceUser, R.dimen.avatar_size_hero);
            Subscription subscription = this.representativeColorSubscription;
            if (subscription != null) {
                subscription.unsubscribe();
            }
            Observable<Integer> observableB0 = RepresentativeColorsKt.getUserRepresentativeColors().observeRepresentativeColor(colorId).b0(l.j);
            m.checkNotNullExpressionValue(observableB0, "UserRepresentativeColors….takeUntil { it != null }");
            ObservableExtensionsKt.appSubscribe$default(observableB0, VideoCallParticipantView.class, (Context) null, new r(1, this), (Function1) null, (Function0) null, (Function0) null, new b.a.y.j0.m(this), 58, (Object) null);
        }
        String forUser$default = IconUtils.getForUser$default(voiceUser != null ? voiceUser.getUser() : null, false, null, 6, null);
        if (!m.areEqual(forUser$default, this.userAvatarUrl)) {
            this.userAvatarUrl = forUser$default;
        }
        ParticipantData participantData = this.data;
        if (participantData == null || (type = participantData.type) == null) {
            type = ParticipantData.Type.DEFAULT;
        }
        boolean z4 = participantData != null && participantData.isFocused;
        Integer numB = participantData != null ? participantData.b() : null;
        this.data = data;
        Integer numB2 = data != null ? data.b() : null;
        Integer numB3 = data != null ? data.b() : null;
        if (!m.areEqual(numB3, numB)) {
            if (numB3 != null) {
                AppVideoStreamRenderer appVideoStreamRenderer = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer.setVisibility(8);
                View view = this.binding.c;
                m.checkNotNullExpressionValue(view, "binding.participantBgLetterbox");
                SimpleDraweeView simpleDraweeView = this.binding.m;
                m.checkNotNullExpressionValue(simpleDraweeView, "binding.participantStreamPreviewImage");
                view.setVisibility((simpleDraweeView.getVisibility() == 0) ^ true ? 0 : 8);
                ProgressBar progressBar = this.binding.p;
                m.checkNotNullExpressionValue(progressBar, "binding.participantVideoLoadingIndicator");
                progressBar.setVisibility(0);
            } else {
                AppVideoStreamRenderer appVideoStreamRenderer2 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer2, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer2.setVisibility(8);
                View view2 = this.binding.c;
                m.checkNotNullExpressionValue(view2, "binding.participantBgLetterbox");
                view2.setVisibility(8);
                ProgressBar progressBar2 = this.binding.p;
                m.checkNotNullExpressionValue(progressBar2, "binding.participantVideoLoadingIndicator");
                progressBar2.setVisibility(8);
            }
        }
        boolean z5 = z4;
        ParticipantData.Type type2 = type;
        Integer num2 = numB2;
        if ((data != null ? data.type : null) == ParticipantData.Type.APPLICATION_STREAMING) {
            View view3 = this.binding.f127b;
            m.checkNotNullExpressionValue(view3, "binding.participantBgAvatar");
            view3.setVisibility(8);
            VoiceUserView voiceUserView = this.binding.f128s;
            m.checkNotNullExpressionValue(voiceUserView, "binding.participantVoiceUserView");
            voiceUserView.setVisibility(8);
            ImageView imageView = this.binding.j;
            m.checkNotNullExpressionValue(imageView, "binding.participantMuteStatusIndicator");
            imageView.setVisibility(8);
            ImageView imageView2 = this.binding.d;
            m.checkNotNullExpressionValue(imageView2, "binding.participantDeafenStatusIndicator");
            imageView2.setVisibility(8);
            ParticipantData.ApplicationStreamState applicationStreamState = data.applicationStreamState;
            if (applicationStreamState != null) {
                int iOrdinal = applicationStreamState.ordinal();
                if (iOrdinal == 0) {
                    ProgressBar progressBar3 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar3, "binding.participantVideoLoadingIndicator");
                    progressBar3.setVisibility(0);
                    TextView textView = this.binding.l;
                    m.checkNotNullExpressionValue(textView, "binding.participantStreamPaused");
                    textView.setVisibility(8);
                    ConstraintLayout constraintLayout = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout, "binding.participantStreamEnded");
                    constraintLayout.setVisibility(8);
                    SimpleDraweeView simpleDraweeView2 = this.binding.m;
                    m.checkNotNullExpressionValue(simpleDraweeView2, "binding.participantStreamPreviewImage");
                    simpleDraweeView2.setVisibility(0);
                    TextView textView2 = this.binding.n;
                    m.checkNotNullExpressionValue(textView2, "binding.participantStreamPreviewText");
                    textView2.setVisibility(8);
                    TextView textView3 = this.binding.i;
                    m.checkNotNullExpressionValue(textView3, "binding.participantLiveIndicator");
                    textView3.setVisibility(data.isFocused ^ true ? 0 : 8);
                    b(false);
                } else if (iOrdinal == 1) {
                    TextView textView4 = this.binding.n;
                    m.checkNotNullExpressionValue(textView4, "binding.participantStreamPreviewText");
                    textView4.setVisibility(8);
                    TextView textView5 = this.binding.l;
                    m.checkNotNullExpressionValue(textView5, "binding.participantStreamPaused");
                    textView5.setVisibility(8);
                    ConstraintLayout constraintLayout2 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout2, "binding.participantStreamEnded");
                    constraintLayout2.setVisibility(8);
                    TextView textView6 = this.binding.i;
                    m.checkNotNullExpressionValue(textView6, "binding.participantLiveIndicator");
                    textView6.setVisibility(data.isFocused ^ true ? 0 : 8);
                    a(data);
                } else if (iOrdinal == 2) {
                    ProgressBar progressBar4 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar4, "binding.participantVideoLoadingIndicator");
                    progressBar4.setVisibility(8);
                    SimpleDraweeView simpleDraweeView3 = this.binding.m;
                    m.checkNotNullExpressionValue(simpleDraweeView3, "binding.participantStreamPreviewImage");
                    simpleDraweeView3.setVisibility(0);
                    TextView textView7 = this.binding.n;
                    m.checkNotNullExpressionValue(textView7, "binding.participantStreamPreviewText");
                    textView7.setVisibility(0);
                    TextView textView8 = this.binding.l;
                    m.checkNotNullExpressionValue(textView8, "binding.participantStreamPaused");
                    textView8.setVisibility(8);
                    ConstraintLayout constraintLayout3 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout3, "binding.participantStreamEnded");
                    constraintLayout3.setVisibility(8);
                    TextView textView9 = this.binding.i;
                    m.checkNotNullExpressionValue(textView9, "binding.participantLiveIndicator");
                    textView9.setVisibility(8);
                    this.binding.n.setOnClickListener(new n(this, data));
                    StreamContext streamContext = data.voiceParticipant.getStreamContext();
                    StoreApplicationStreamPreviews.StreamPreview preview = streamContext != null ? streamContext.getPreview() : null;
                    if (preview instanceof StoreApplicationStreamPreviews.StreamPreview.Resolved) {
                        this.binding.m.setImageURI(((StoreApplicationStreamPreviews.StreamPreview.Resolved) preview).getUrl());
                        SimpleDraweeView simpleDraweeView4 = this.binding.m;
                        m.checkNotNullExpressionValue(simpleDraweeView4, "binding.participantStreamPreviewImage");
                        ViewGroup.LayoutParams layoutParams = simpleDraweeView4.getLayoutParams();
                        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                        layoutParams2.dimensionRatio = "16:9";
                        simpleDraweeView4.setLayoutParams(layoutParams2);
                    } else {
                        this.binding.m.setImageURI((String) null);
                        SimpleDraweeView simpleDraweeView5 = this.binding.m;
                        m.checkNotNullExpressionValue(simpleDraweeView5, "binding.participantStreamPreviewImage");
                        ViewGroup.LayoutParams layoutParams3 = simpleDraweeView5.getLayoutParams();
                        Objects.requireNonNull(layoutParams3, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                        ConstraintLayout.LayoutParams layoutParams4 = (ConstraintLayout.LayoutParams) layoutParams3;
                        layoutParams4.dimensionRatio = null;
                        simpleDraweeView5.setLayoutParams(layoutParams4);
                    }
                    b(false);
                } else if (iOrdinal == 3) {
                    ProgressBar progressBar5 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar5, "binding.participantVideoLoadingIndicator");
                    progressBar5.setVisibility(8);
                    SimpleDraweeView simpleDraweeView6 = this.binding.m;
                    m.checkNotNullExpressionValue(simpleDraweeView6, "binding.participantStreamPreviewImage");
                    simpleDraweeView6.setVisibility(0);
                    TextView textView10 = this.binding.n;
                    m.checkNotNullExpressionValue(textView10, "binding.participantStreamPreviewText");
                    textView10.setVisibility(8);
                    TextView textView11 = this.binding.l;
                    m.checkNotNullExpressionValue(textView11, "binding.participantStreamPaused");
                    textView11.setVisibility(0);
                    ConstraintLayout constraintLayout4 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout4, "binding.participantStreamEnded");
                    constraintLayout4.setVisibility(8);
                    TextView textView12 = this.binding.i;
                    m.checkNotNullExpressionValue(textView12, "binding.participantLiveIndicator");
                    textView12.setVisibility(data.isFocused ^ true ? 0 : 8);
                    a(data);
                } else if (iOrdinal == 4) {
                    ProgressBar progressBar6 = this.binding.p;
                    m.checkNotNullExpressionValue(progressBar6, "binding.participantVideoLoadingIndicator");
                    progressBar6.setVisibility(8);
                    TextView textView13 = this.binding.n;
                    m.checkNotNullExpressionValue(textView13, "binding.participantStreamPreviewText");
                    textView13.setVisibility(8);
                    TextView textView14 = this.binding.l;
                    m.checkNotNullExpressionValue(textView14, "binding.participantStreamPaused");
                    textView14.setVisibility(8);
                    ConstraintLayout constraintLayout5 = this.binding.k;
                    m.checkNotNullExpressionValue(constraintLayout5, "binding.participantStreamEnded");
                    constraintLayout5.setVisibility(0);
                    TextView textView15 = this.binding.i;
                    m.checkNotNullExpressionValue(textView15, "binding.participantLiveIndicator");
                    textView15.setVisibility(8);
                    b(false);
                }
            }
        } else {
            SimpleDraweeView simpleDraweeView7 = this.binding.m;
            m.checkNotNullExpressionValue(simpleDraweeView7, "binding.participantStreamPreviewImage");
            simpleDraweeView7.setVisibility(8);
            TextView textView16 = this.binding.n;
            m.checkNotNullExpressionValue(textView16, "binding.participantStreamPreviewText");
            textView16.setVisibility(8);
            TextView textView17 = this.binding.l;
            m.checkNotNullExpressionValue(textView17, "binding.participantStreamPaused");
            textView17.setVisibility(8);
            ConstraintLayout constraintLayout6 = this.binding.k;
            m.checkNotNullExpressionValue(constraintLayout6, "binding.participantStreamEnded");
            constraintLayout6.setVisibility(8);
            b(false);
            ImageView imageView3 = this.binding.j;
            m.checkNotNullExpressionValue(imageView3, "binding.participantMuteStatusIndicator");
            imageView3.setVisibility(voiceUser != null ? voiceUser.getIsMuted() : false ? 0 : 8);
            ImageView imageView4 = this.binding.d;
            m.checkNotNullExpressionValue(imageView4, "binding.participantDeafenStatusIndicator");
            imageView4.setVisibility(voiceUser != null ? voiceUser.getIsDeafened() : false ? 0 : 8);
            if (num2 != null) {
                View view4 = this.binding.f127b;
                m.checkNotNullExpressionValue(view4, "binding.participantBgAvatar");
                view4.setVisibility(8);
                VoiceUserView voiceUserView2 = this.binding.f128s;
                m.checkNotNullExpressionValue(voiceUserView2, "binding.participantVoiceUserView");
                voiceUserView2.setVisibility(8);
            } else {
                View view5 = this.binding.f127b;
                m.checkNotNullExpressionValue(view5, "binding.participantBgAvatar");
                view5.setVisibility(0);
                VoiceUserView voiceUserView3 = this.binding.f128s;
                m.checkNotNullExpressionValue(voiceUserView3, "binding.participantVoiceUserView");
                voiceUserView3.setVisibility(0);
            }
            TextView textView18 = this.binding.i;
            m.checkNotNullExpressionValue(textView18, "binding.participantLiveIndicator");
            textView18.setVisibility(8);
        }
        LinearLayout linearLayout = this.binding.r;
        m.checkNotNullExpressionValue(linearLayout, "binding.participantVoiceIndicators");
        LinearLayout linearLayout2 = this.binding.r;
        m.checkNotNullExpressionValue(linearLayout2, "binding.participantVoiceIndicators");
        Iterator<View> it = ViewGroupKt.getChildren(linearLayout2).iterator();
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
            TextView textView19 = this.binding.i;
            m.checkNotNullExpressionValue(textView19, "binding.participantLiveIndicator");
            constraintSet.connect(textView19.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
            TextView textView20 = this.binding.i;
            m.checkNotNullExpressionValue(textView20, "binding.participantLiveIndicator");
            constraintSet.connect(textView20.getId(), 3, 0, 3, DimenUtils.dpToPixels(8));
            TextView textView21 = this.binding.i;
            m.checkNotNullExpressionValue(textView21, "binding.participantLiveIndicator");
            constraintSet.clear(textView21.getId(), 4);
        } else {
            LinearLayout linearLayout3 = this.binding.r;
            m.checkNotNullExpressionValue(linearLayout3, "binding.participantVoiceIndicators");
            if (!(linearLayout3.getVisibility() == 0)) {
                TextView textView22 = this.binding.i;
                m.checkNotNullExpressionValue(textView22, "binding.participantLiveIndicator");
                constraintSet.connect(textView22.getId(), 2, 0, 2, DimenUtils.dpToPixels(8));
                TextView textView23 = this.binding.i;
                m.checkNotNullExpressionValue(textView23, "binding.participantLiveIndicator");
                constraintSet.connect(textView23.getId(), 4, 0, 4, DimenUtils.dpToPixels(8));
                TextView textView24 = this.binding.i;
                m.checkNotNullExpressionValue(textView24, "binding.participantLiveIndicator");
                constraintSet.clear(textView24.getId(), 3);
            }
        }
        AppVideoStreamRenderer appVideoStreamRenderer3 = this.binding.q;
        RendererCommon.ScalingType scalingType = data != null ? data.scalingType : null;
        RendererCommon.ScalingType scalingType2 = data != null ? data.scalingTypeMismatchOrientation : null;
        if (data != null) {
            z3 = data.mirrorVideo;
            num = num2;
        } else {
            num = num2;
            z3 = false;
        }
        appVideoStreamRenderer3.c(num, scalingType, scalingType2, z3);
        Subscription subscription2 = this.frameRenderedSubscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        if (num != null) {
            BehaviorSubject<Point> behaviorSubject = this.binding.q.currentFrameResolutionSubject;
            m.checkNotNullExpressionValue(behaviorSubject, "currentFrameResolutionSubject");
            Observable<R> observableG = behaviorSubject.y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            m.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            ObservableExtensionsKt.appSubscribe$default(observableG, VideoCallParticipantView.class, (Context) null, new r(0, this), (Function1) null, (Function0) null, (Function0) null, new o(this), 58, (Object) null);
        }
        ParticipantData participantData2 = this.data;
        ParticipantData.Type type3 = participantData2 != null ? participantData2.type : null;
        boolean z6 = data != null && data.isFocused;
        if (type3 != null && (type3 != type2 || z6 != z5)) {
            if (type3 != ParticipantData.Type.DEFAULT || z6) {
                ConstraintLayout.LayoutParams layoutParams5 = new ConstraintLayout.LayoutParams(-2, -2);
                AppVideoStreamRenderer appVideoStreamRenderer4 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer4, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer4.setLayoutParams(layoutParams5);
                AppVideoStreamRenderer appVideoStreamRenderer5 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer5, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer5.getId(), 1);
                AppVideoStreamRenderer appVideoStreamRenderer6 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer6, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer6.getId(), 1);
            } else {
                ConstraintLayout.LayoutParams layoutParams6 = new ConstraintLayout.LayoutParams(0, 0);
                AppVideoStreamRenderer appVideoStreamRenderer7 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer7, "binding.participantVideoStreamRenderer");
                appVideoStreamRenderer7.setLayoutParams(layoutParams6);
                AppVideoStreamRenderer appVideoStreamRenderer8 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer8, "binding.participantVideoStreamRenderer");
                constraintSet.constrainHeight(appVideoStreamRenderer8.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer9 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer9, "binding.participantVideoStreamRenderer");
                constraintSet.constrainWidth(appVideoStreamRenderer9.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer10 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer10, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultHeight(appVideoStreamRenderer10.getId(), 0);
                AppVideoStreamRenderer appVideoStreamRenderer11 = this.binding.q;
                m.checkNotNullExpressionValue(appVideoStreamRenderer11, "binding.participantVideoStreamRenderer");
                constraintSet.constrainDefaultWidth(appVideoStreamRenderer11.getId(), 0);
            }
        }
        constraintSet.applyTo(this);
        if (voiceUser != null) {
            TextView textView25 = this.binding.o;
            m.checkNotNullExpressionValue(textView25, "binding.participantVideoLabel");
            textView25.setText(voiceUser.getDisplayName());
            if (data.type == ParticipantData.Type.APPLICATION_STREAMING) {
                Context context = getContext();
                m.checkNotNullExpressionValue(context, "context");
                i = 0;
                setContentDescription(b.h(context, R.string.go_live_tile_screen, new Object[]{voiceUser.getDisplayName()}, null, 4));
                this.binding.o.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_screen_14dp, 0, 0, 0);
            } else {
                i = 0;
                setContentDescription(voiceUser.getDisplayName());
                this.binding.o.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (this.animateLabelFades) {
                ViewExtensions.fadeBy(this.binding.o, data.showLabel, 200L);
                return;
            }
            TextView textView26 = this.binding.o;
            m.checkNotNullExpressionValue(textView26, "binding.participantVideoLabel");
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
        m.checkNotNullParameter(data, "data");
        d(this, (ParticipantData) data, null, false, null, false, 30);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Subscription subscription = this.representativeColorSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.animateLabelFades = false;
        this.binding.q.c(null, null, null, false);
    }

    @Override // com.discord.utilities.view.grid.FrameGridLayout.DataView
    public void onRemove() {
        FrameGridLayout.DataView.DefaultImpls.onRemove(this);
    }

    public final void setData(ParticipantData participantData) {
        this.data = participantData;
    }

    public final void setOnWatchStreamClicked(Function1<? super String, Unit> onWatchStreamClicked) {
        m.checkNotNullParameter(onWatchStreamClicked, "onWatchStreamClicked");
        this.onWatchStreamClicked = onWatchStreamClicked;
    }

    /* compiled from: VideoCallParticipantView.kt */
    public static final /* data */ class ParticipantData implements FrameGridLayout.Data {

        /* renamed from: a, reason: from kotlin metadata */
        public final String id;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
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
        public final a streamQualityIndicatorData;

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
        public static final class a {
            public final boolean a;

            /* renamed from: b, reason: collision with root package name */
            public final StreamResolution f2841b;
            public final StreamFps c;
            public final boolean d;

            public a(boolean z2, StreamResolution streamResolution, StreamFps streamFps, boolean z3) {
                m.checkNotNullParameter(streamResolution, "resolution");
                this.a = z2;
                this.f2841b = streamResolution;
                this.c = streamFps;
                this.d = z3;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof a)) {
                    return false;
                }
                a aVar = (a) obj;
                return this.a == aVar.a && m.areEqual(this.f2841b, aVar.f2841b) && m.areEqual(this.c, aVar.c) && this.d == aVar.d;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8 */
            /* JADX WARN: Type inference failed for: r0v9 */
            public int hashCode() {
                boolean z2 = this.a;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                StreamResolution streamResolution = this.f2841b;
                int iHashCode = (i + (streamResolution != null ? streamResolution.hashCode() : 0)) * 31;
                StreamFps streamFps = this.c;
                int fps = (iHashCode + (streamFps != null ? streamFps.getFps() : 0)) * 31;
                boolean z3 = this.d;
                return fps + (z3 ? 1 : z3 ? 1 : 0);
            }

            public String toString() {
                StringBuilder sbU = b.d.b.a.a.U("StreamQualityIndicatorData(showPremiumIcon=");
                sbU.append(this.a);
                sbU.append(", resolution=");
                sbU.append(this.f2841b);
                sbU.append(", fps=");
                sbU.append(this.c);
                sbU.append(", isBadQuality=");
                return b.d.b.a.a.O(sbU, this.d, ")");
            }
        }

        public ParticipantData(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, a aVar) {
            m.checkNotNullParameter(voiceUser, "voiceParticipant");
            m.checkNotNullParameter(type, "type");
            this.voiceParticipant = voiceUser;
            this.mirrorVideo = z2;
            this.scalingType = scalingType;
            this.scalingTypeMismatchOrientation = scalingType2;
            this.applicationStreamState = applicationStreamState;
            this.type = type;
            this.showLabel = z3;
            this.isFocused = z4;
            this.streamQualityIndicatorData = aVar;
            StringBuilder sb = new StringBuilder();
            sb.append(voiceUser.getUser().getId());
            sb.append(type);
            this.id = sb.toString();
        }

        public static ParticipantData a(ParticipantData participantData, StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, a aVar, int i) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = (i & 1) != 0 ? participantData.voiceParticipant : null;
            boolean z5 = (i & 2) != 0 ? participantData.mirrorVideo : z2;
            RendererCommon.ScalingType scalingType3 = (i & 4) != 0 ? participantData.scalingType : scalingType;
            RendererCommon.ScalingType scalingType4 = (i & 8) != 0 ? participantData.scalingTypeMismatchOrientation : scalingType2;
            ApplicationStreamState applicationStreamState2 = (i & 16) != 0 ? participantData.applicationStreamState : null;
            Type type2 = (i & 32) != 0 ? participantData.type : null;
            boolean z6 = (i & 64) != 0 ? participantData.showLabel : z3;
            boolean z7 = (i & 128) != 0 ? participantData.isFocused : z4;
            a aVar2 = (i & 256) != 0 ? participantData.streamQualityIndicatorData : aVar;
            Objects.requireNonNull(participantData);
            m.checkNotNullParameter(voiceUser2, "voiceParticipant");
            m.checkNotNullParameter(type2, "type");
            return new ParticipantData(voiceUser2, z5, scalingType3, scalingType4, applicationStreamState2, type2, z6, z7, aVar2);
        }

        public final Integer b() {
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
            m.checkNotNullParameter(context, "context");
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
            return m.areEqual(this.voiceParticipant, participantData.voiceParticipant) && this.mirrorVideo == participantData.mirrorVideo && m.areEqual(this.scalingType, participantData.scalingType) && m.areEqual(this.scalingTypeMismatchOrientation, participantData.scalingTypeMismatchOrientation) && m.areEqual(this.applicationStreamState, participantData.applicationStreamState) && m.areEqual(this.type, participantData.type) && this.showLabel == participantData.showLabel && this.isFocused == participantData.isFocused && m.areEqual(this.streamQualityIndicatorData, participantData.streamQualityIndicatorData);
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
            a aVar = this.streamQualityIndicatorData;
            return i5 + (aVar != null ? aVar.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = b.d.b.a.a.U("ParticipantData(voiceParticipant=");
            sbU.append(this.voiceParticipant);
            sbU.append(", mirrorVideo=");
            sbU.append(this.mirrorVideo);
            sbU.append(", scalingType=");
            sbU.append(this.scalingType);
            sbU.append(", scalingTypeMismatchOrientation=");
            sbU.append(this.scalingTypeMismatchOrientation);
            sbU.append(", applicationStreamState=");
            sbU.append(this.applicationStreamState);
            sbU.append(", type=");
            sbU.append(this.type);
            sbU.append(", showLabel=");
            sbU.append(this.showLabel);
            sbU.append(", isFocused=");
            sbU.append(this.isFocused);
            sbU.append(", streamQualityIndicatorData=");
            sbU.append(this.streamQualityIndicatorData);
            sbU.append(")");
            return sbU.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ParticipantData(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, RendererCommon.ScalingType scalingType, RendererCommon.ScalingType scalingType2, ApplicationStreamState applicationStreamState, Type type, boolean z3, boolean z4, a aVar, int i) {
            this(voiceUser, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? RendererCommon.ScalingType.SCALE_ASPECT_BALANCED : scalingType, (i & 8) != 0 ? RendererCommon.ScalingType.SCALE_ASPECT_FIT : scalingType2, (i & 16) != 0 ? null : applicationStreamState, (i & 32) != 0 ? Type.DEFAULT : type, (i & 64) != 0 ? false : z3, (i & 128) != 0 ? false : z4, null);
            int i2 = i & 256;
        }
    }
}
