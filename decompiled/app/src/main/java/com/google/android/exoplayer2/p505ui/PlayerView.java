package com.google.android.exoplayer2.p505ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.p505ui.AspectRatioFrameLayout;
import com.google.android.exoplayer2.p505ui.PlayerControlView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.DeviceInfo2;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.Player;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.Player3;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.TracksInfo;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p245b3.Cue;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p256d3.AdOverlayInfo;
import p007b.p225i.p226a.p242c.p259f3.ErrorMessageProvider;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p007b.p225i.p355b.p357b.ImmutableList2;

/* loaded from: classes3.dex */
public class PlayerView extends FrameLayout {

    /* renamed from: j */
    public static final /* synthetic */ int f20159j = 0;

    /* renamed from: A */
    @Nullable
    public Drawable f20160A;

    /* renamed from: B */
    public int f20161B;

    /* renamed from: C */
    public boolean f20162C;

    /* renamed from: D */
    @Nullable
    public ErrorMessageProvider<? super PlaybackException> f20163D;

    /* renamed from: E */
    @Nullable
    public CharSequence f20164E;

    /* renamed from: F */
    public int f20165F;

    /* renamed from: G */
    public boolean f20166G;

    /* renamed from: H */
    public boolean f20167H;

    /* renamed from: I */
    public boolean f20168I;

    /* renamed from: J */
    public int f20169J;

    /* renamed from: K */
    public boolean f20170K;

    /* renamed from: k */
    public final ViewOnLayoutChangeListenerC10758a f20171k;

    /* renamed from: l */
    @Nullable
    public final AspectRatioFrameLayout f20172l;

    /* renamed from: m */
    @Nullable
    public final View f20173m;

    /* renamed from: n */
    @Nullable
    public final View f20174n;

    /* renamed from: o */
    public final boolean f20175o;

    /* renamed from: p */
    @Nullable
    public final ImageView f20176p;

    /* renamed from: q */
    @Nullable
    public final SubtitleView f20177q;

    /* renamed from: r */
    @Nullable
    public final View f20178r;

    /* renamed from: s */
    @Nullable
    public final TextView f20179s;

    /* renamed from: t */
    @Nullable
    public final PlayerControlView f20180t;

    /* renamed from: u */
    @Nullable
    public final FrameLayout f20181u;

    /* renamed from: v */
    @Nullable
    public final FrameLayout f20182v;

    /* renamed from: w */
    @Nullable
    public Player2 f20183w;

    /* renamed from: x */
    public boolean f20184x;

    /* renamed from: y */
    @Nullable
    public PlayerControlView.InterfaceC10757e f20185y;

    /* renamed from: z */
    public boolean f20186z;

    /* renamed from: com.google.android.exoplayer2.ui.PlayerView$a */
    public final class ViewOnLayoutChangeListenerC10758a implements Player2.e, View.OnLayoutChangeListener, View.OnClickListener, PlayerControlView.InterfaceC10757e {

        /* renamed from: j */
        public final Timeline.b f20187j = new Timeline.b();

        /* renamed from: k */
        @Nullable
        public Object f20188k;

        public ViewOnLayoutChangeListenerC10758a() {
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: A */
        public /* synthetic */ void mo235A(MediaMetadata mediaMetadata) {
            Player.m2427i(this, mediaMetadata);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: D */
        public /* synthetic */ void mo236D(boolean z2) {
            Player.m2438t(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: E */
        public /* synthetic */ void mo237E(Player2 player2, Player2.d dVar) {
            Player.m2423e(this, player2, dVar);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: G */
        public /* synthetic */ void mo238G(int i, boolean z2) {
            Player.m2422d(this, i, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: H */
        public /* synthetic */ void mo239H(boolean z2, int i) {
            Player3.m3883k(this, z2, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: L */
        public /* synthetic */ void mo240L(int i) {
            Player.m2437s(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: M */
        public /* synthetic */ void mo241M(MediaItem2 mediaItem2, int i) {
            Player.m2426h(this, mediaItem2, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: W */
        public void mo242W(boolean z2, int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.f20159j;
            playerView.m8924l();
            PlayerView playerView2 = PlayerView.this;
            if (playerView2.m8917e() && playerView2.f20167H) {
                playerView2.m8916d();
            } else {
                playerView2.m8918f(false);
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: Y */
        public /* synthetic */ void mo243Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
            Player3.m3890r(this, trackGroupArray, trackSelectionArray);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: a */
        public /* synthetic */ void mo244a() {
            Player3.m3887o(this);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: a0 */
        public /* synthetic */ void mo245a0(int i, int i2) {
            Player.m2440v(this, i, i2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: b */
        public /* synthetic */ void mo246b(Metadata metadata) {
            Player.m2428j(this, metadata);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: b0 */
        public /* synthetic */ void mo247b0(PlaybackParameters playbackParameters) {
            Player.m2430l(this, playbackParameters);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: c */
        public void mo248c() {
            View view = PlayerView.this.f20173m;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: d */
        public /* synthetic */ void mo249d(boolean z2) {
            Player.m2439u(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: e */
        public void mo250e(List<Cue> list) {
            SubtitleView subtitleView = PlayerView.this.f20177q;
            if (subtitleView != null) {
                subtitleView.setCues(list);
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: f */
        public void mo251f(VideoSize videoSize) {
            PlayerView playerView = PlayerView.this;
            int i = PlayerView.f20159j;
            playerView.m8923k();
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: f0 */
        public /* synthetic */ void mo252f0(PlaybackException playbackException) {
            Player.m2434p(this, playbackException);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: g */
        public void mo253g(Player2.f fVar, Player2.f fVar2, int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.f20159j;
            if (playerView.m8917e()) {
                PlayerView playerView2 = PlayerView.this;
                if (playerView2.f20167H) {
                    playerView2.m8916d();
                }
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: h */
        public /* synthetic */ void mo254h(int i) {
            Player.m2432n(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: i */
        public /* synthetic */ void mo255i(boolean z2) {
            Player3.m3876d(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: j */
        public /* synthetic */ void mo256j(int i) {
            Player3.m3884l(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: j0 */
        public /* synthetic */ void mo257j0(boolean z2) {
            Player.m2425g(this, z2);
        }

        @Override // com.google.android.exoplayer2.p505ui.PlayerControlView.InterfaceC10757e
        /* renamed from: k */
        public void mo8912k(int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.f20159j;
            playerView.m8925m();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView playerView = PlayerView.this;
            int i = PlayerView.f20159j;
            playerView.m8922j();
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            PlayerView.m8913a((TextureView) view, PlayerView.this.f20169J);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: p */
        public void mo258p(TracksInfo tracksInfo) {
            Player2 player2 = PlayerView.this.f20183w;
            Objects.requireNonNull(player2);
            Timeline timelineMo2888K = player2.mo2888K();
            if (timelineMo2888K.m3331q()) {
                this.f20188k = null;
            } else if (player2.mo2885H().f7434k.isEmpty()) {
                Object obj = this.f20188k;
                if (obj != null) {
                    int iMo2554b = timelineMo2888K.mo2554b(obj);
                    if (iMo2554b != -1) {
                        if (player2.mo2881C() == timelineMo2888K.m3326f(iMo2554b, this.f20187j).f7340l) {
                            return;
                        }
                    }
                    this.f20188k = null;
                }
            } else {
                this.f20188k = timelineMo2888K.mo2513g(player2.mo2912m(), this.f20187j, true).f7339k;
            }
            PlayerView.this.m8927o(false);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: r */
        public /* synthetic */ void mo259r(boolean z2) {
            Player.m2424f(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: s */
        public /* synthetic */ void mo260s(PlaybackException playbackException) {
            Player.m2433o(this, playbackException);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: t */
        public /* synthetic */ void mo261t(Player2.b bVar) {
            Player.m2419a(this, bVar);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: v */
        public /* synthetic */ void mo262v(Timeline timeline, int i) {
            Player.m2441w(this, timeline, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: w */
        public /* synthetic */ void mo263w(float f) {
            Player.m2444z(this, f);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: y */
        public void mo264y(int i) {
            PlayerView playerView = PlayerView.this;
            int i2 = PlayerView.f20159j;
            playerView.m8924l();
            PlayerView.this.m8926n();
            PlayerView playerView2 = PlayerView.this;
            if (playerView2.m8917e() && playerView2.f20167H) {
                playerView2.m8916d();
            } else {
                playerView2.m8918f(false);
            }
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: z */
        public /* synthetic */ void mo265z(DeviceInfo2 deviceInfo2) {
            Player.m2421c(this, deviceInfo2);
        }
    }

    public PlayerView(Context context, @Nullable AttributeSet attributeSet) {
        int i;
        int i2;
        boolean z2;
        boolean z3;
        boolean z4;
        int i3;
        int i4;
        int i5;
        boolean z5;
        boolean z6;
        int i6;
        int i7;
        boolean z7;
        boolean z8;
        super(context, attributeSet, 0);
        ViewOnLayoutChangeListenerC10758a viewOnLayoutChangeListenerC10758a = new ViewOnLayoutChangeListenerC10758a();
        this.f20171k = viewOnLayoutChangeListenerC10758a;
        if (isInEditMode()) {
            this.f20172l = null;
            this.f20173m = null;
            this.f20174n = null;
            this.f20175o = false;
            this.f20176p = null;
            this.f20177q = null;
            this.f20178r = null;
            this.f20179s = null;
            this.f20180t = null;
            this.f20181u = null;
            this.f20182v = null;
            ImageView imageView = new ImageView(context);
            if (Util2.f6708a >= 23) {
                Resources resources = getResources();
                imageView.setImageDrawable(resources.getDrawable(C10759R.b.exo_edit_mode_logo, null));
                imageView.setBackgroundColor(resources.getColor(C10759R.a.exo_edit_mode_background_color, null));
            } else {
                Resources resources2 = getResources();
                imageView.setImageDrawable(resources2.getDrawable(C10759R.b.exo_edit_mode_logo));
                imageView.setBackgroundColor(resources2.getColor(C10759R.a.exo_edit_mode_background_color));
            }
            addView(imageView);
            return;
        }
        int i8 = C10759R.e.exo_player_view;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C10759R.g.PlayerView, 0, 0);
            try {
                int i9 = C10759R.g.PlayerView_shutter_background_color;
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(i9);
                int color = typedArrayObtainStyledAttributes.getColor(i9, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(C10759R.g.PlayerView_player_layout_id, i8);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerView_use_artwork, true);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(C10759R.g.PlayerView_default_artwork, 0);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerView_use_controller, true);
                int i10 = typedArrayObtainStyledAttributes.getInt(C10759R.g.PlayerView_surface_type, 1);
                int i11 = typedArrayObtainStyledAttributes.getInt(C10759R.g.PlayerView_resize_mode, 0);
                int i12 = typedArrayObtainStyledAttributes.getInt(C10759R.g.PlayerView_show_timeout, 5000);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerView_hide_on_touch, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerView_auto_show, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(C10759R.g.PlayerView_show_buffering, 0);
                this.f20162C = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerView_keep_content_on_player_reset, this.f20162C);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerView_hide_during_ads, true);
                typedArrayObtainStyledAttributes.recycle();
                i3 = i11;
                z2 = z11;
                z3 = z12;
                i7 = i12;
                z7 = z10;
                i = resourceId;
                i6 = resourceId2;
                z6 = z9;
                z5 = zHasValue;
                i5 = color;
                i4 = i10;
                z4 = z13;
                i2 = integer;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            i = i8;
            i2 = 0;
            z2 = true;
            z3 = true;
            z4 = true;
            i3 = 0;
            i4 = 1;
            i5 = 0;
            z5 = false;
            z6 = true;
            i6 = 0;
            i7 = 5000;
            z7 = true;
        }
        LayoutInflater.from(context).inflate(i, this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(C10759R.c.exo_content_frame);
        this.f20172l = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setResizeMode(i3);
        }
        View viewFindViewById = findViewById(C10759R.c.exo_shutter);
        this.f20173m = viewFindViewById;
        if (viewFindViewById != null && z5) {
            viewFindViewById.setBackgroundColor(i5);
        }
        if (aspectRatioFrameLayout == null || i4 == 0) {
            this.f20174n = null;
            z8 = false;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i4 == 2) {
                this.f20174n = new TextureView(context);
            } else if (i4 == 3) {
                try {
                    this.f20174n = (View) Class.forName("b.i.a.c.g3.z.k").getConstructor(Context.class).newInstance(context);
                    z8 = true;
                    this.f20174n.setLayoutParams(layoutParams);
                    this.f20174n.setOnClickListener(viewOnLayoutChangeListenerC10758a);
                    this.f20174n.setClickable(false);
                    aspectRatioFrameLayout.addView(this.f20174n, 0);
                } catch (Exception e) {
                    throw new IllegalStateException("spherical_gl_surface_view requires an ExoPlayer dependency", e);
                }
            } else if (i4 != 4) {
                this.f20174n = new SurfaceView(context);
            } else {
                try {
                    this.f20174n = (View) Class.forName("b.i.a.c.g3.s").getConstructor(Context.class).newInstance(context);
                } catch (Exception e2) {
                    throw new IllegalStateException("video_decoder_gl_surface_view requires an ExoPlayer dependency", e2);
                }
            }
            z8 = false;
            this.f20174n.setLayoutParams(layoutParams);
            this.f20174n.setOnClickListener(viewOnLayoutChangeListenerC10758a);
            this.f20174n.setClickable(false);
            aspectRatioFrameLayout.addView(this.f20174n, 0);
        }
        this.f20175o = z8;
        this.f20181u = (FrameLayout) findViewById(C10759R.c.exo_ad_overlay);
        this.f20182v = (FrameLayout) findViewById(C10759R.c.exo_overlay);
        ImageView imageView2 = (ImageView) findViewById(C10759R.c.exo_artwork);
        this.f20176p = imageView2;
        this.f20186z = z6 && imageView2 != null;
        if (i6 != 0) {
            this.f20160A = ContextCompat.getDrawable(getContext(), i6);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(C10759R.c.exo_subtitles);
        this.f20177q = subtitleView;
        if (subtitleView != null) {
            subtitleView.m8929k();
            subtitleView.m8930l();
        }
        View viewFindViewById2 = findViewById(C10759R.c.exo_buffering);
        this.f20178r = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.f20161B = i2;
        TextView textView = (TextView) findViewById(C10759R.c.exo_error_message);
        this.f20179s = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        int i13 = C10759R.c.exo_controller;
        PlayerControlView playerControlView = (PlayerControlView) findViewById(i13);
        View viewFindViewById3 = findViewById(C10759R.c.exo_controller_placeholder);
        if (playerControlView != null) {
            this.f20180t = playerControlView;
        } else if (viewFindViewById3 != null) {
            PlayerControlView playerControlView2 = new PlayerControlView(context, null, 0, attributeSet);
            this.f20180t = playerControlView2;
            playerControlView2.setId(i13);
            playerControlView2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(playerControlView2, iIndexOfChild);
        } else {
            this.f20180t = null;
        }
        PlayerControlView playerControlView3 = this.f20180t;
        this.f20165F = playerControlView3 != null ? i7 : 0;
        this.f20168I = z2;
        this.f20166G = z3;
        this.f20167H = z4;
        this.f20184x = z7 && playerControlView3 != null;
        m8916d();
        m8925m();
        PlayerControlView playerControlView4 = this.f20180t;
        if (playerControlView4 != null) {
            playerControlView4.f20139l.add(viewOnLayoutChangeListenerC10758a);
        }
    }

    /* renamed from: a */
    public static void m8913a(TextureView textureView, int i) {
        Matrix matrix = new Matrix();
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width != 0.0f && height != 0.0f && i != 0) {
            float f = width / 2.0f;
            float f2 = height / 2.0f;
            matrix.postRotate(i, f, f2);
            RectF rectF = new RectF(0.0f, 0.0f, width, height);
            RectF rectF2 = new RectF();
            matrix.mapRect(rectF2, rectF);
            matrix.postScale(width / rectF2.width(), height / rectF2.height(), f, f2);
        }
        textureView.setTransform(matrix);
    }

    /* renamed from: b */
    public final void m8914b() {
        View view = this.f20173m;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    /* renamed from: c */
    public final void m8915c() {
        ImageView imageView = this.f20176p;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f20176p.setVisibility(4);
        }
    }

    /* renamed from: d */
    public void m8916d() {
        PlayerControlView playerControlView = this.f20180t;
        if (playerControlView != null) {
            playerControlView.m8895c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        Player2 player2 = this.f20183w;
        if (player2 != null && player2.mo2900f()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        int keyCode = keyEvent.getKeyCode();
        boolean z2 = keyCode == 19 || keyCode == 270 || keyCode == 22 || keyCode == 271 || keyCode == 20 || keyCode == 269 || keyCode == 21 || keyCode == 268 || keyCode == 23;
        if (z2 && m8928p() && !this.f20180t.m8897e()) {
            m8918f(true);
        } else {
            if (!(m8928p() && this.f20180t.m8893a(keyEvent)) && !super.dispatchKeyEvent(keyEvent)) {
                if (!z2 || !m8928p()) {
                    return false;
                }
                m8918f(true);
                return false;
            }
            m8918f(true);
        }
        return true;
    }

    /* renamed from: e */
    public final boolean m8917e() {
        Player2 player2 = this.f20183w;
        return player2 != null && player2.mo2900f() && this.f20183w.mo2908j();
    }

    /* renamed from: f */
    public final void m8918f(boolean z2) {
        if (!(m8917e() && this.f20167H) && m8928p()) {
            boolean z3 = this.f20180t.m8897e() && this.f20180t.getShowTimeoutMs() <= 0;
            boolean zM8920h = m8920h();
            if (z2 || z3 || zM8920h) {
                m8921i(zM8920h);
            }
        }
    }

    @RequiresNonNull({"artworkView"})
    /* renamed from: g */
    public final boolean m8919g(@Nullable Drawable drawable) {
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float f = intrinsicWidth / intrinsicHeight;
                AspectRatioFrameLayout aspectRatioFrameLayout = this.f20172l;
                if (aspectRatioFrameLayout != null) {
                    aspectRatioFrameLayout.setAspectRatio(f);
                }
                this.f20176p.setImageDrawable(drawable);
                this.f20176p.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public List<AdOverlayInfo> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.f20182v;
        if (frameLayout != null) {
            arrayList.add(new AdOverlayInfo(frameLayout, 3, "Transparent overlay does not impact viewability"));
        }
        PlayerControlView playerControlView = this.f20180t;
        if (playerControlView != null) {
            arrayList.add(new AdOverlayInfo(playerControlView, 0));
        }
        return ImmutableList2.m6264n(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        FrameLayout frameLayout = this.f20181u;
        if (frameLayout != null) {
            return frameLayout;
        }
        throw new IllegalStateException("exo_ad_overlay must be present for ad playback");
    }

    public boolean getControllerAutoShow() {
        return this.f20166G;
    }

    public boolean getControllerHideOnTouch() {
        return this.f20168I;
    }

    public int getControllerShowTimeoutMs() {
        return this.f20165F;
    }

    @Nullable
    public Drawable getDefaultArtwork() {
        return this.f20160A;
    }

    @Nullable
    public FrameLayout getOverlayFrameLayout() {
        return this.f20182v;
    }

    @Nullable
    public Player2 getPlayer() {
        return this.f20183w;
    }

    public int getResizeMode() {
        AnimatableValueParser.m438H(this.f20172l);
        return this.f20172l.getResizeMode();
    }

    @Nullable
    public SubtitleView getSubtitleView() {
        return this.f20177q;
    }

    public boolean getUseArtwork() {
        return this.f20186z;
    }

    public boolean getUseController() {
        return this.f20184x;
    }

    @Nullable
    public View getVideoSurfaceView() {
        return this.f20174n;
    }

    /* renamed from: h */
    public final boolean m8920h() {
        Player2 player2 = this.f20183w;
        if (player2 == null) {
            return true;
        }
        int iMo2930y = player2.mo2930y();
        return this.f20166G && (iMo2930y == 1 || iMo2930y == 4 || !this.f20183w.mo2908j());
    }

    /* renamed from: i */
    public final void m8921i(boolean z2) {
        if (m8928p()) {
            this.f20180t.setShowTimeoutMs(z2 ? 0 : this.f20165F);
            this.f20180t.m8901i();
        }
    }

    /* renamed from: j */
    public final boolean m8922j() {
        if (!m8928p() || this.f20183w == null) {
            return false;
        }
        if (!this.f20180t.m8897e()) {
            m8918f(true);
        } else if (this.f20168I) {
            this.f20180t.m8895c();
        }
        return true;
    }

    /* renamed from: k */
    public final void m8923k() {
        Player2 player2 = this.f20183w;
        VideoSize videoSizeMo2916o = player2 != null ? player2.mo2916o() : VideoSize.f6954j;
        int i = videoSizeMo2916o.f6955k;
        int i2 = videoSizeMo2916o.f6956l;
        int i3 = videoSizeMo2916o.f6957m;
        float f = (i2 == 0 || i == 0) ? 0.0f : (i * videoSizeMo2916o.f6958n) / i2;
        View view = this.f20174n;
        if (view instanceof TextureView) {
            if (f > 0.0f && (i3 == 90 || i3 == 270)) {
                f = 1.0f / f;
            }
            if (this.f20169J != 0) {
                view.removeOnLayoutChangeListener(this.f20171k);
            }
            this.f20169J = i3;
            if (i3 != 0) {
                this.f20174n.addOnLayoutChangeListener(this.f20171k);
            }
            m8913a((TextureView) this.f20174n, this.f20169J);
        }
        AspectRatioFrameLayout aspectRatioFrameLayout = this.f20172l;
        float f2 = this.f20175o ? 0.0f : f;
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    /* renamed from: l */
    public final void m8924l() {
        int i;
        if (this.f20178r != null) {
            Player2 player2 = this.f20183w;
            boolean z2 = true;
            if (player2 == null || player2.mo2930y() != 2 || ((i = this.f20161B) != 2 && (i != 1 || !this.f20183w.mo2908j()))) {
                z2 = false;
            }
            this.f20178r.setVisibility(z2 ? 0 : 8);
        }
    }

    /* renamed from: m */
    public final void m8925m() {
        PlayerControlView playerControlView = this.f20180t;
        if (playerControlView == null || !this.f20184x) {
            setContentDescription(null);
        } else if (playerControlView.getVisibility() == 0) {
            setContentDescription(this.f20168I ? getResources().getString(C10759R.f.exo_controls_hide) : null);
        } else {
            setContentDescription(getResources().getString(C10759R.f.exo_controls_show));
        }
    }

    /* renamed from: n */
    public final void m8926n() {
        ErrorMessageProvider<? super PlaybackException> errorMessageProvider;
        TextView textView = this.f20179s;
        if (textView != null) {
            CharSequence charSequence = this.f20164E;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.f20179s.setVisibility(0);
                return;
            }
            Player2 player2 = this.f20183w;
            PlaybackException playbackExceptionMo2925t = player2 != null ? player2.mo2925t() : null;
            if (playbackExceptionMo2925t == null || (errorMessageProvider = this.f20163D) == null) {
                this.f20179s.setVisibility(8);
            } else {
                this.f20179s.setText((CharSequence) errorMessageProvider.m3028a(playbackExceptionMo2925t).second);
                this.f20179s.setVisibility(0);
            }
        }
    }

    /* renamed from: o */
    public final void m8927o(boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        Player2 player2 = this.f20183w;
        if (player2 == null || !player2.mo3518D(30) || player2.mo2885H().f7434k.isEmpty()) {
            if (this.f20162C) {
                return;
            }
            m8915c();
            m8914b();
            return;
        }
        if (z2 && !this.f20162C) {
            m8914b();
        }
        TracksInfo tracksInfoMo2885H = player2.mo2885H();
        boolean zM8919g = false;
        int i = 0;
        while (true) {
            z3 = true;
            if (i >= tracksInfoMo2885H.f7434k.size()) {
                z4 = false;
                break;
            }
            TracksInfo.a aVar = tracksInfoMo2885H.f7434k.get(i);
            boolean[] zArr = aVar.f7438m;
            int length = zArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z5 = false;
                    break;
                } else {
                    if (zArr[i2]) {
                        z5 = true;
                        break;
                    }
                    i2++;
                }
            }
            if (z5 && aVar.f7437l == 2) {
                z4 = true;
                break;
            }
            i++;
        }
        if (z4) {
            m8915c();
            return;
        }
        m8914b();
        if (this.f20186z) {
            AnimatableValueParser.m438H(this.f20176p);
        } else {
            z3 = false;
        }
        if (z3) {
            byte[] bArr = player2.mo2893S().f7397v;
            if (bArr != null) {
                zM8919g = m8919g(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
            }
            if (zM8919g || m8919g(this.f20160A)) {
                return;
            }
        }
        m8915c();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!m8928p() || this.f20183w == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f20170K = true;
            return true;
        }
        if (action != 1 || !this.f20170K) {
            return false;
        }
        this.f20170K = false;
        performClick();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!m8928p() || this.f20183w == null) {
            return false;
        }
        m8918f(true);
        return true;
    }

    @EnsuresNonNullIf(expression = {"controller"}, result = GoogleSmartLockManager.SET_DISCORD_ACCOUNT_DETAILS)
    /* renamed from: p */
    public final boolean m8928p() {
        if (!this.f20184x) {
            return false;
        }
        AnimatableValueParser.m438H(this.f20180t);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        return m8922j();
    }

    public void setAspectRatioListener(@Nullable AspectRatioFrameLayout.InterfaceC10751b interfaceC10751b) {
        AnimatableValueParser.m438H(this.f20172l);
        this.f20172l.setAspectRatioListener(interfaceC10751b);
    }

    public void setControllerAutoShow(boolean z2) {
        this.f20166G = z2;
    }

    public void setControllerHideDuringAds(boolean z2) {
        this.f20167H = z2;
    }

    public void setControllerHideOnTouch(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20168I = z2;
        m8925m();
    }

    public void setControllerShowTimeoutMs(int i) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20165F = i;
        if (this.f20180t.m8897e()) {
            m8921i(m8920h());
        }
    }

    public void setControllerVisibilityListener(@Nullable PlayerControlView.InterfaceC10757e interfaceC10757e) {
        AnimatableValueParser.m438H(this.f20180t);
        PlayerControlView.InterfaceC10757e interfaceC10757e2 = this.f20185y;
        if (interfaceC10757e2 == interfaceC10757e) {
            return;
        }
        if (interfaceC10757e2 != null) {
            this.f20180t.f20139l.remove(interfaceC10757e2);
        }
        this.f20185y = interfaceC10757e;
        if (interfaceC10757e != null) {
            PlayerControlView playerControlView = this.f20180t;
            Objects.requireNonNull(playerControlView);
            playerControlView.f20139l.add(interfaceC10757e);
        }
    }

    public void setCustomErrorMessage(@Nullable CharSequence charSequence) {
        AnimatableValueParser.m426D(this.f20179s != null);
        this.f20164E = charSequence;
        m8926n();
    }

    public void setDefaultArtwork(@Nullable Drawable drawable) {
        if (this.f20160A != drawable) {
            this.f20160A = drawable;
            m8927o(false);
        }
    }

    public void setErrorMessageProvider(@Nullable ErrorMessageProvider<? super PlaybackException> errorMessageProvider) {
        if (this.f20163D != errorMessageProvider) {
            this.f20163D = errorMessageProvider;
            m8926n();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z2) {
        if (this.f20162C != z2) {
            this.f20162C = z2;
            m8927o(false);
        }
    }

    public void setPlayer(@Nullable Player2 player2) {
        AnimatableValueParser.m426D(Looper.myLooper() == Looper.getMainLooper());
        AnimatableValueParser.m531j(player2 == null || player2.mo2889L() == Looper.getMainLooper());
        Player2 player22 = this.f20183w;
        if (player22 == player2) {
            return;
        }
        if (player22 != null) {
            player22.mo2918p(this.f20171k);
            if (player22.mo3518D(27)) {
                View view = this.f20174n;
                if (view instanceof TextureView) {
                    player22.mo2914n((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    player22.mo2883F((SurfaceView) view);
                }
            }
        }
        SubtitleView subtitleView = this.f20177q;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.f20183w = player2;
        if (m8928p()) {
            this.f20180t.setPlayer(player2);
        }
        m8924l();
        m8926n();
        m8927o(true);
        if (player2 == null) {
            m8916d();
            return;
        }
        if (player2.mo3518D(27)) {
            View view2 = this.f20174n;
            if (view2 instanceof TextureView) {
                player2.mo2892Q((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                player2.mo2922r((SurfaceView) view2);
            }
            m8923k();
        }
        if (this.f20177q != null && player2.mo3518D(28)) {
            this.f20177q.setCues(player2.mo2879A());
        }
        player2.mo2929x(this.f20171k);
        m8918f(false);
    }

    public void setRepeatToggleModes(int i) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        AnimatableValueParser.m438H(this.f20172l);
        this.f20172l.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.f20161B != i) {
            this.f20161B = i;
            m8924l();
        }
    }

    public void setShowFastForwardButton(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setShowFastForwardButton(z2);
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setShowMultiWindowTimeBar(z2);
    }

    public void setShowNextButton(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setShowNextButton(z2);
    }

    public void setShowPreviousButton(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setShowPreviousButton(z2);
    }

    public void setShowRewindButton(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setShowRewindButton(z2);
    }

    public void setShowShuffleButton(boolean z2) {
        AnimatableValueParser.m438H(this.f20180t);
        this.f20180t.setShowShuffleButton(z2);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.f20173m;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setUseArtwork(boolean z2) {
        AnimatableValueParser.m426D((z2 && this.f20176p == null) ? false : true);
        if (this.f20186z != z2) {
            this.f20186z = z2;
            m8927o(false);
        }
    }

    public void setUseController(boolean z2) {
        AnimatableValueParser.m426D((z2 && this.f20180t == null) ? false : true);
        if (this.f20184x == z2) {
            return;
        }
        this.f20184x = z2;
        if (m8928p()) {
            this.f20180t.setPlayer(this.f20183w);
        } else {
            PlayerControlView playerControlView = this.f20180t;
            if (playerControlView != null) {
                playerControlView.m8895c();
                this.f20180t.setPlayer(null);
            }
        }
        m8925m();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.f20174n;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }
}
