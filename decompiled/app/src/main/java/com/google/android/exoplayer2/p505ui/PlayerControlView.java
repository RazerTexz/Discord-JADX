package com.google.android.exoplayer2.p505ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.DeviceInfo2;
import p007b.p225i.p226a.p242c.ExoPlayerLibraryInfo;
import p007b.p225i.p226a.p242c.MediaItem2;
import p007b.p225i.p226a.p242c.MediaMetadata;
import p007b.p225i.p226a.p242c.PlaybackParameters;
import p007b.p225i.p226a.p242c.Player;
import p007b.p225i.p226a.p242c.Player2;
import p007b.p225i.p226a.p242c.Player3;
import p007b.p225i.p226a.p242c.Timeline;
import p007b.p225i.p226a.p242c.TracksInfo;
import p007b.p225i.p226a.p242c.p243a3.TrackGroupArray;
import p007b.p225i.p226a.p242c.p243a3.p244p0.AdPlaybackState;
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p256d3.RunnableC2657a;
import p007b.p225i.p226a.p242c.p256d3.RunnableC2660d;
import p007b.p225i.p226a.p242c.p256d3.TimeBar;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;

/* loaded from: classes3.dex */
public class PlayerControlView extends FrameLayout {

    /* renamed from: j */
    public static final /* synthetic */ int f20103j = 0;

    /* renamed from: A */
    public final Timeline.b f20104A;

    /* renamed from: B */
    public final Timeline.c f20105B;

    /* renamed from: C */
    public final Runnable f20106C;

    /* renamed from: D */
    public final Runnable f20107D;

    /* renamed from: E */
    public final Drawable f20108E;

    /* renamed from: F */
    public final Drawable f20109F;

    /* renamed from: G */
    public final Drawable f20110G;

    /* renamed from: H */
    public final String f20111H;

    /* renamed from: I */
    public final String f20112I;

    /* renamed from: J */
    public final String f20113J;

    /* renamed from: K */
    public final Drawable f20114K;

    /* renamed from: L */
    public final Drawable f20115L;

    /* renamed from: M */
    public final float f20116M;

    /* renamed from: N */
    public final float f20117N;

    /* renamed from: O */
    public final String f20118O;

    /* renamed from: P */
    public final String f20119P;

    /* renamed from: Q */
    @Nullable
    public Player2 f20120Q;

    /* renamed from: R */
    @Nullable
    public InterfaceC10756d f20121R;

    /* renamed from: S */
    public boolean f20122S;

    /* renamed from: T */
    public boolean f20123T;

    /* renamed from: U */
    public boolean f20124U;

    /* renamed from: V */
    public boolean f20125V;

    /* renamed from: W */
    public int f20126W;

    /* renamed from: a0 */
    public int f20127a0;

    /* renamed from: b0 */
    public int f20128b0;

    /* renamed from: c0 */
    public boolean f20129c0;

    /* renamed from: d0 */
    public boolean f20130d0;

    /* renamed from: e0 */
    public boolean f20131e0;

    /* renamed from: f0 */
    public boolean f20132f0;

    /* renamed from: g0 */
    public boolean f20133g0;

    /* renamed from: h0 */
    public long f20134h0;

    /* renamed from: i0 */
    public long[] f20135i0;

    /* renamed from: j0 */
    public boolean[] f20136j0;

    /* renamed from: k */
    public final ViewOnClickListenerC10755c f20137k;

    /* renamed from: k0 */
    public long[] f20138k0;

    /* renamed from: l */
    public final CopyOnWriteArrayList<InterfaceC10757e> f20139l;

    /* renamed from: l0 */
    public boolean[] f20140l0;

    /* renamed from: m */
    @Nullable
    public final View f20141m;

    /* renamed from: m0 */
    public long f20142m0;

    /* renamed from: n */
    @Nullable
    public final View f20143n;

    /* renamed from: n0 */
    public long f20144n0;

    /* renamed from: o */
    @Nullable
    public final View f20145o;

    /* renamed from: o0 */
    public long f20146o0;

    /* renamed from: p */
    @Nullable
    public final View f20147p;

    /* renamed from: q */
    @Nullable
    public final View f20148q;

    /* renamed from: r */
    @Nullable
    public final View f20149r;

    /* renamed from: s */
    @Nullable
    public final ImageView f20150s;

    /* renamed from: t */
    @Nullable
    public final ImageView f20151t;

    /* renamed from: u */
    @Nullable
    public final View f20152u;

    /* renamed from: v */
    @Nullable
    public final TextView f20153v;

    /* renamed from: w */
    @Nullable
    public final TextView f20154w;

    /* renamed from: x */
    @Nullable
    public final TimeBar f20155x;

    /* renamed from: y */
    public final StringBuilder f20156y;

    /* renamed from: z */
    public final Formatter f20157z;

    @RequiresApi(21)
    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$b */
    public static final class C10754b {
        @DoNotInline
        /* renamed from: a */
        public static boolean m8910a(View view) {
            return view.isAccessibilityFocused();
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$c */
    public final class ViewOnClickListenerC10755c implements Player2.e, TimeBar.a, View.OnClickListener {
        public ViewOnClickListenerC10755c(C10753a c10753a) {
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
        public void mo237E(Player2 player2, Player2.d dVar) {
            if (dVar.m3829a(4, 5)) {
                PlayerControlView playerControlView = PlayerControlView.this;
                int i = PlayerControlView.f20103j;
                playerControlView.m8905m();
            }
            if (dVar.m3829a(4, 5, 7)) {
                PlayerControlView playerControlView2 = PlayerControlView.this;
                int i2 = PlayerControlView.f20103j;
                playerControlView2.m8906n();
            }
            if (dVar.f9035a.f6733a.get(8)) {
                PlayerControlView playerControlView3 = PlayerControlView.this;
                int i3 = PlayerControlView.f20103j;
                playerControlView3.m8907o();
            }
            if (dVar.f9035a.f6733a.get(9)) {
                PlayerControlView playerControlView4 = PlayerControlView.this;
                int i4 = PlayerControlView.f20103j;
                playerControlView4.m8908p();
            }
            if (dVar.m3829a(8, 9, 11, 0, 13)) {
                PlayerControlView playerControlView5 = PlayerControlView.this;
                int i5 = PlayerControlView.f20103j;
                playerControlView5.m8904l();
            }
            if (dVar.m3829a(11, 0)) {
                PlayerControlView playerControlView6 = PlayerControlView.this;
                int i6 = PlayerControlView.f20103j;
                playerControlView6.m8909q();
            }
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
        public /* synthetic */ void mo242W(boolean z2, int i) {
            Player.m2429k(this, z2, i);
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
        public /* synthetic */ void mo248c() {
            Player.m2436r(this);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: d */
        public /* synthetic */ void mo249d(boolean z2) {
            Player.m2439u(this, z2);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: e */
        public /* synthetic */ void mo250e(List list) {
            Player.m2420b(this, list);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: f */
        public /* synthetic */ void mo251f(VideoSize videoSize) {
            Player.m2443y(this, videoSize);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: f0 */
        public /* synthetic */ void mo252f0(PlaybackException playbackException) {
            Player.m2434p(this, playbackException);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: g */
        public /* synthetic */ void mo253g(Player2.f fVar, Player2.f fVar2, int i) {
            Player.m2435q(this, fVar, fVar2, i);
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

        @Override // p007b.p225i.p226a.p242c.p256d3.TimeBar.a
        /* renamed from: k */
        public void mo2763k(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            TextView textView = playerControlView.f20154w;
            if (textView != null) {
                textView.setText(Util2.m3013u(playerControlView.f20156y, playerControlView.f20157z, j));
            }
        }

        @Override // p007b.p225i.p226a.p242c.p256d3.TimeBar.a
        /* renamed from: l */
        public void mo2764l(TimeBar timeBar, long j, boolean z2) {
            Player2 player2;
            PlayerControlView playerControlView = PlayerControlView.this;
            int iMo2881C = 0;
            playerControlView.f20125V = false;
            if (z2 || (player2 = playerControlView.f20120Q) == null) {
                return;
            }
            Timeline timelineMo2888K = player2.mo2888K();
            if (playerControlView.f20124U && !timelineMo2888K.m3331q()) {
                int iMo2557p = timelineMo2888K.mo2557p();
                while (true) {
                    long jM3340b = timelineMo2888K.m3330n(iMo2881C, playerControlView.f20105B).m3340b();
                    if (j < jM3340b) {
                        break;
                    }
                    if (iMo2881C == iMo2557p - 1) {
                        j = jM3340b;
                        break;
                    } else {
                        j -= jM3340b;
                        iMo2881C++;
                    }
                }
            } else {
                iMo2881C = player2.mo2881C();
            }
            player2.mo2904h(iMo2881C, j);
            playerControlView.m8906n();
        }

        @Override // p007b.p225i.p226a.p242c.p256d3.TimeBar.a
        /* renamed from: m */
        public void mo2765m(TimeBar timeBar, long j) {
            PlayerControlView playerControlView = PlayerControlView.this;
            playerControlView.f20125V = true;
            TextView textView = playerControlView.f20154w;
            if (textView != null) {
                textView.setText(Util2.m3013u(playerControlView.f20156y, playerControlView.f20157z, j));
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerControlView playerControlView = PlayerControlView.this;
            Player2 player2 = playerControlView.f20120Q;
            if (player2 == null) {
                return;
            }
            if (playerControlView.f20143n == view) {
                player2.mo3519O();
                return;
            }
            if (playerControlView.f20141m == view) {
                player2.mo3533s();
                return;
            }
            if (playerControlView.f20148q == view) {
                if (player2.mo2930y() != 4) {
                    player2.mo3520P();
                    return;
                }
                return;
            }
            if (playerControlView.f20149r == view) {
                player2.mo3521R();
                return;
            }
            if (playerControlView.f20145o == view) {
                playerControlView.m8894b(player2);
                return;
            }
            if (playerControlView.f20147p == view) {
                Objects.requireNonNull(playerControlView);
                player2.mo3531d();
                return;
            }
            if (playerControlView.f20150s != view) {
                if (playerControlView.f20151t == view) {
                    player2.mo2909k(!player2.mo2890M());
                    return;
                }
                return;
            }
            int iMo2886I = player2.mo2886I();
            int i = PlayerControlView.this.f20128b0;
            int i2 = 1;
            while (true) {
                if (i2 > 2) {
                    break;
                }
                int i3 = (iMo2886I + i2) % 3;
                boolean z2 = false;
                if (i3 == 0 || (i3 == 1 ? (i & 1) != 0 : !(i3 != 2 || (i & 2) == 0))) {
                    z2 = true;
                }
                if (z2) {
                    iMo2886I = i3;
                    break;
                }
                i2++;
            }
            player2.mo2882E(iMo2886I);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.c
        /* renamed from: p */
        public /* synthetic */ void mo258p(TracksInfo tracksInfo) {
            Player.m2442x(this, tracksInfo);
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
        public /* synthetic */ void mo264y(int i) {
            Player.m2431m(this, i);
        }

        @Override // p007b.p225i.p226a.p242c.Player2.e
        /* renamed from: z */
        public /* synthetic */ void mo265z(DeviceInfo2 deviceInfo2) {
            Player.m2421c(this, deviceInfo2);
        }
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$d */
    public interface InterfaceC10756d {
        /* renamed from: a */
        void m8911a(long j, long j2);
    }

    /* renamed from: com.google.android.exoplayer2.ui.PlayerControlView$e */
    public interface InterfaceC10757e {
        /* renamed from: k */
        void mo8912k(int i);
    }

    static {
        ExoPlayerLibraryInfo.m3272a("goog.exo.ui");
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, attributeSet);
    }

    /* renamed from: a */
    public boolean m8893a(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        Player2 player2 = this.f20120Q;
        if (player2 != null) {
            if (keyCode == 90 || keyCode == 89 || keyCode == 85 || keyCode == 79 || keyCode == 126 || keyCode == 127 || keyCode == 87 || keyCode == 88) {
                if (keyEvent.getAction() == 0) {
                    if (keyCode == 90) {
                        if (player2.mo2930y() != 4) {
                            player2.mo3520P();
                        }
                    } else if (keyCode == 89) {
                        player2.mo3521R();
                    } else if (keyEvent.getRepeatCount() == 0) {
                        if (keyCode == 79 || keyCode == 85) {
                            int iMo2930y = player2.mo2930y();
                            if (iMo2930y == 1 || iMo2930y == 4 || !player2.mo2908j()) {
                                m8894b(player2);
                            } else {
                                player2.mo3531d();
                            }
                        } else if (keyCode == 87) {
                            player2.mo3519O();
                        } else if (keyCode == 88) {
                            player2.mo3533s();
                        } else if (keyCode == 126) {
                            m8894b(player2);
                        } else if (keyCode == 127) {
                            player2.mo3531d();
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public final void m8894b(Player2 player2) {
        int iMo2930y = player2.mo2930y();
        if (iMo2930y == 1) {
            player2.mo2896a();
        } else if (iMo2930y == 4) {
            player2.mo2904h(player2.mo2881C(), -9223372036854775807L);
        }
        player2.mo3532e();
    }

    /* renamed from: c */
    public void m8895c() {
        if (m8897e()) {
            setVisibility(8);
            Iterator<InterfaceC10757e> it = this.f20139l.iterator();
            while (it.hasNext()) {
                it.next().mo8912k(getVisibility());
            }
            removeCallbacks(this.f20106C);
            removeCallbacks(this.f20107D);
            this.f20134h0 = -9223372036854775807L;
        }
    }

    /* renamed from: d */
    public final void m8896d() {
        removeCallbacks(this.f20107D);
        if (this.f20126W <= 0) {
            this.f20134h0 = -9223372036854775807L;
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        int i = this.f20126W;
        this.f20134h0 = jUptimeMillis + i;
        if (this.f20122S) {
            postDelayed(this.f20107D, i);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return m8893a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            removeCallbacks(this.f20107D);
        } else if (motionEvent.getAction() == 1) {
            m8896d();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* renamed from: e */
    public boolean m8897e() {
        return getVisibility() == 0;
    }

    /* renamed from: f */
    public final void m8898f() {
        View view;
        View view2;
        boolean zM8900h = m8900h();
        if (!zM8900h && (view2 = this.f20145o) != null) {
            view2.sendAccessibilityEvent(8);
        } else {
            if (!zM8900h || (view = this.f20147p) == null) {
                return;
            }
            view.sendAccessibilityEvent(8);
        }
    }

    /* renamed from: g */
    public final void m8899g() {
        View view;
        View view2;
        boolean zM8900h = m8900h();
        if (!zM8900h && (view2 = this.f20145o) != null) {
            view2.requestFocus();
        } else {
            if (!zM8900h || (view = this.f20147p) == null) {
                return;
            }
            view.requestFocus();
        }
    }

    @Nullable
    public Player2 getPlayer() {
        return this.f20120Q;
    }

    public int getRepeatToggleModes() {
        return this.f20128b0;
    }

    public boolean getShowShuffleButton() {
        return this.f20133g0;
    }

    public int getShowTimeoutMs() {
        return this.f20126W;
    }

    public boolean getShowVrButton() {
        View view = this.f20152u;
        return view != null && view.getVisibility() == 0;
    }

    /* renamed from: h */
    public final boolean m8900h() {
        Player2 player2 = this.f20120Q;
        return (player2 == null || player2.mo2930y() == 4 || this.f20120Q.mo2930y() == 1 || !this.f20120Q.mo2908j()) ? false : true;
    }

    /* renamed from: i */
    public void m8901i() {
        if (!m8897e()) {
            setVisibility(0);
            Iterator<InterfaceC10757e> it = this.f20139l.iterator();
            while (it.hasNext()) {
                it.next().mo8912k(getVisibility());
            }
            m8902j();
            m8899g();
            m8898f();
        }
        m8896d();
    }

    /* renamed from: j */
    public final void m8902j() {
        m8905m();
        m8904l();
        m8907o();
        m8908p();
        m8909q();
    }

    /* renamed from: k */
    public final void m8903k(boolean z2, boolean z3, @Nullable View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z3);
        view.setAlpha(z3 ? this.f20116M : this.f20117N);
        view.setVisibility(z2 ? 0 : 8);
    }

    /* renamed from: l */
    public final void m8904l() {
        boolean zMo3518D;
        boolean z2;
        boolean zMo3518D2;
        boolean zMo3518D3;
        if (m8897e() && this.f20122S) {
            Player2 player2 = this.f20120Q;
            boolean z3 = false;
            if (player2 != null) {
                boolean zMo3518D4 = player2.mo3518D(5);
                boolean zMo3518D5 = player2.mo3518D(7);
                zMo3518D2 = player2.mo3518D(11);
                zMo3518D3 = player2.mo3518D(12);
                zMo3518D = player2.mo3518D(9);
                z2 = zMo3518D4;
                z3 = zMo3518D5;
            } else {
                zMo3518D = false;
                z2 = false;
                zMo3518D2 = false;
                zMo3518D3 = false;
            }
            m8903k(this.f20131e0, z3, this.f20141m);
            m8903k(this.f20129c0, zMo3518D2, this.f20149r);
            m8903k(this.f20130d0, zMo3518D3, this.f20148q);
            m8903k(this.f20132f0, zMo3518D, this.f20143n);
            TimeBar timeBar = this.f20155x;
            if (timeBar != null) {
                timeBar.setEnabled(z2);
            }
        }
    }

    /* renamed from: m */
    public final void m8905m() {
        boolean z2;
        boolean z3;
        if (m8897e() && this.f20122S) {
            boolean zM8900h = m8900h();
            View view = this.f20145o;
            boolean z4 = true;
            if (view != null) {
                z2 = (zM8900h && view.isFocused()) | false;
                z3 = (Util2.f6708a < 21 ? z2 : zM8900h && C10754b.m8910a(this.f20145o)) | false;
                this.f20145o.setVisibility(zM8900h ? 8 : 0);
            } else {
                z2 = false;
                z3 = false;
            }
            View view2 = this.f20147p;
            if (view2 != null) {
                z2 |= !zM8900h && view2.isFocused();
                if (Util2.f6708a < 21) {
                    z4 = z2;
                } else if (zM8900h || !C10754b.m8910a(this.f20147p)) {
                    z4 = false;
                }
                z3 |= z4;
                this.f20147p.setVisibility(zM8900h ? 0 : 8);
            }
            if (z2) {
                m8899g();
            }
            if (z3) {
                m8898f();
            }
        }
    }

    /* renamed from: n */
    public final void m8906n() {
        long jMo2891N;
        if (m8897e() && this.f20122S) {
            Player2 player2 = this.f20120Q;
            long jMo2928w = 0;
            if (player2 != null) {
                jMo2928w = this.f20142m0 + player2.mo2928w();
                jMo2891N = this.f20142m0 + player2.mo2891N();
            } else {
                jMo2891N = 0;
            }
            boolean z2 = jMo2928w != this.f20144n0;
            boolean z3 = jMo2891N != this.f20146o0;
            this.f20144n0 = jMo2928w;
            this.f20146o0 = jMo2891N;
            TextView textView = this.f20154w;
            if (textView != null && !this.f20125V && z2) {
                textView.setText(Util2.m3013u(this.f20156y, this.f20157z, jMo2928w));
            }
            TimeBar timeBar = this.f20155x;
            if (timeBar != null) {
                timeBar.setPosition(jMo2928w);
                this.f20155x.setBufferedPosition(jMo2891N);
            }
            InterfaceC10756d interfaceC10756d = this.f20121R;
            if (interfaceC10756d != null && (z2 || z3)) {
                interfaceC10756d.m8911a(jMo2928w, jMo2891N);
            }
            removeCallbacks(this.f20106C);
            int iMo2930y = player2 == null ? 1 : player2.mo2930y();
            if (player2 == null || !player2.mo3534z()) {
                if (iMo2930y == 4 || iMo2930y == 1) {
                    return;
                }
                postDelayed(this.f20106C, 1000L);
                return;
            }
            TimeBar timeBar2 = this.f20155x;
            long jMin = Math.min(timeBar2 != null ? timeBar2.getPreferredUpdateDelay() : 1000L, 1000 - (jMo2928w % 1000));
            float f = player2.mo2897c().f8027k;
            postDelayed(this.f20106C, Util2.m3001i(f > 0.0f ? (long) (jMin / f) : 1000L, this.f20127a0, 1000L));
        }
    }

    /* renamed from: o */
    public final void m8907o() {
        ImageView imageView;
        if (m8897e() && this.f20122S && (imageView = this.f20150s) != null) {
            if (this.f20128b0 == 0) {
                m8903k(false, false, imageView);
                return;
            }
            Player2 player2 = this.f20120Q;
            if (player2 == null) {
                m8903k(true, false, imageView);
                this.f20150s.setImageDrawable(this.f20108E);
                this.f20150s.setContentDescription(this.f20111H);
                return;
            }
            m8903k(true, true, imageView);
            int iMo2886I = player2.mo2886I();
            if (iMo2886I == 0) {
                this.f20150s.setImageDrawable(this.f20108E);
                this.f20150s.setContentDescription(this.f20111H);
            } else if (iMo2886I == 1) {
                this.f20150s.setImageDrawable(this.f20109F);
                this.f20150s.setContentDescription(this.f20112I);
            } else if (iMo2886I == 2) {
                this.f20150s.setImageDrawable(this.f20110G);
                this.f20150s.setContentDescription(this.f20113J);
            }
            this.f20150s.setVisibility(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f20122S = true;
        long j = this.f20134h0;
        if (j != -9223372036854775807L) {
            long jUptimeMillis = j - SystemClock.uptimeMillis();
            if (jUptimeMillis <= 0) {
                m8895c();
            } else {
                postDelayed(this.f20107D, jUptimeMillis);
            }
        } else if (m8897e()) {
            m8896d();
        }
        m8902j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f20122S = false;
        removeCallbacks(this.f20106C);
        removeCallbacks(this.f20107D);
    }

    /* renamed from: p */
    public final void m8908p() {
        ImageView imageView;
        if (m8897e() && this.f20122S && (imageView = this.f20151t) != null) {
            Player2 player2 = this.f20120Q;
            if (!this.f20133g0) {
                m8903k(false, false, imageView);
                return;
            }
            if (player2 == null) {
                m8903k(true, false, imageView);
                this.f20151t.setImageDrawable(this.f20115L);
                this.f20151t.setContentDescription(this.f20119P);
            } else {
                m8903k(true, true, imageView);
                this.f20151t.setImageDrawable(player2.mo2890M() ? this.f20114K : this.f20115L);
                this.f20151t.setContentDescription(player2.mo2890M() ? this.f20118O : this.f20119P);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003b  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f4  */
    /* renamed from: q */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m8909q() {
        boolean z2;
        int i;
        Timeline.c cVar;
        long j;
        boolean z3;
        Player2 player2 = this.f20120Q;
        if (player2 == null) {
            return;
        }
        long j2 = -9223372036854775807L;
        boolean z4 = true;
        if (this.f20123T) {
            Timeline timelineMo2888K = player2.mo2888K();
            Timeline.c cVar2 = this.f20105B;
            if (timelineMo2888K.mo2557p() > 100) {
                z3 = false;
                z2 = !z3;
            } else {
                int iMo2557p = timelineMo2888K.mo2557p();
                for (int i2 = 0; i2 < iMo2557p; i2++) {
                    if (timelineMo2888K.m3330n(i2, cVar2).f7349A == -9223372036854775807L) {
                        z3 = false;
                        break;
                    }
                }
                z3 = true;
                if (!z3) {
                }
            }
        }
        this.f20124U = z2;
        long j3 = 0;
        this.f20142m0 = 0L;
        Timeline timelineMo2888K2 = player2.mo2888K();
        if (timelineMo2888K2.m3331q()) {
            i = 0;
        } else {
            int iMo2881C = player2.mo2881C();
            boolean z5 = this.f20124U;
            int i3 = z5 ? 0 : iMo2881C;
            int iMo2557p2 = z5 ? timelineMo2888K2.mo2557p() - 1 : iMo2881C;
            long j4 = 0;
            i = 0;
            while (true) {
                if (i3 > iMo2557p2) {
                    break;
                }
                if (i3 == iMo2881C) {
                    this.f20142m0 = Util2.m2992M(j4);
                }
                timelineMo2888K2.m3330n(i3, this.f20105B);
                Timeline.c cVar3 = this.f20105B;
                if (cVar3.f7349A == j2) {
                    AnimatableValueParser.m426D(this.f20124U ^ z4);
                    break;
                }
                int i4 = cVar3.f7350B;
                while (true) {
                    cVar = this.f20105B;
                    if (i4 <= cVar.f7351C) {
                        timelineMo2888K2.m3326f(i4, this.f20104A);
                        AdPlaybackState adPlaybackState = this.f20104A.f7344p;
                        int i5 = adPlaybackState.f5687q;
                        int i6 = adPlaybackState.f5684n;
                        while (i5 < i6) {
                            long jM3334c = this.f20104A.m3334c(i5);
                            if (jM3334c == Long.MIN_VALUE) {
                                long j5 = this.f20104A.f7341m;
                                if (j5 != j2) {
                                    jM3334c = j5;
                                    j = jM3334c + this.f20104A.f7342n;
                                    if (j < 0) {
                                        long[] jArr = this.f20135i0;
                                        if (i == jArr.length) {
                                            int length = jArr.length == 0 ? 1 : jArr.length * 2;
                                            this.f20135i0 = Arrays.copyOf(jArr, length);
                                            this.f20136j0 = Arrays.copyOf(this.f20136j0, length);
                                        }
                                        this.f20135i0[i] = Util2.m2992M(j + j4);
                                        this.f20136j0[i] = !this.f20104A.f7344p.m2578a(i5).m2581b();
                                        i++;
                                    }
                                }
                            } else {
                                j = jM3334c + this.f20104A.f7342n;
                                if (j < 0) {
                                }
                            }
                            i5++;
                            j2 = -9223372036854775807L;
                        }
                        i4++;
                        j2 = -9223372036854775807L;
                    }
                }
                j4 += cVar.f7349A;
                i3++;
                j2 = -9223372036854775807L;
                z4 = true;
            }
            j3 = j4;
        }
        long jM2992M = Util2.m2992M(j3);
        TextView textView = this.f20153v;
        if (textView != null) {
            textView.setText(Util2.m3013u(this.f20156y, this.f20157z, jM2992M));
        }
        TimeBar timeBar = this.f20155x;
        if (timeBar != null) {
            timeBar.setDuration(jM2992M);
            int length2 = this.f20138k0.length;
            int i7 = i + length2;
            long[] jArr2 = this.f20135i0;
            if (i7 > jArr2.length) {
                this.f20135i0 = Arrays.copyOf(jArr2, i7);
                this.f20136j0 = Arrays.copyOf(this.f20136j0, i7);
            }
            System.arraycopy(this.f20138k0, 0, this.f20135i0, i, length2);
            System.arraycopy(this.f20140l0, 0, this.f20136j0, i, length2);
            this.f20155x.mo2761a(this.f20135i0, this.f20136j0, i7);
        }
        m8906n();
    }

    public void setPlayer(@Nullable Player2 player2) {
        boolean z2 = true;
        AnimatableValueParser.m426D(Looper.myLooper() == Looper.getMainLooper());
        if (player2 != null && player2.mo2889L() != Looper.getMainLooper()) {
            z2 = false;
        }
        AnimatableValueParser.m531j(z2);
        Player2 player22 = this.f20120Q;
        if (player22 == player2) {
            return;
        }
        if (player22 != null) {
            player22.mo2918p(this.f20137k);
        }
        this.f20120Q = player2;
        if (player2 != null) {
            player2.mo2929x(this.f20137k);
        }
        m8902j();
    }

    public void setProgressUpdateListener(@Nullable InterfaceC10756d interfaceC10756d) {
        this.f20121R = interfaceC10756d;
    }

    public void setRepeatToggleModes(int i) {
        this.f20128b0 = i;
        Player2 player2 = this.f20120Q;
        if (player2 != null) {
            int iMo2886I = player2.mo2886I();
            if (i == 0 && iMo2886I != 0) {
                this.f20120Q.mo2882E(0);
            } else if (i == 1 && iMo2886I == 2) {
                this.f20120Q.mo2882E(1);
            } else if (i == 2 && iMo2886I == 1) {
                this.f20120Q.mo2882E(2);
            }
        }
        m8907o();
    }

    public void setShowFastForwardButton(boolean z2) {
        this.f20130d0 = z2;
        m8904l();
    }

    public void setShowMultiWindowTimeBar(boolean z2) {
        this.f20123T = z2;
        m8909q();
    }

    public void setShowNextButton(boolean z2) {
        this.f20132f0 = z2;
        m8904l();
    }

    public void setShowPreviousButton(boolean z2) {
        this.f20131e0 = z2;
        m8904l();
    }

    public void setShowRewindButton(boolean z2) {
        this.f20129c0 = z2;
        m8904l();
    }

    public void setShowShuffleButton(boolean z2) {
        this.f20133g0 = z2;
        m8908p();
    }

    public void setShowTimeoutMs(int i) {
        this.f20126W = i;
        if (m8897e()) {
            m8896d();
        }
    }

    public void setShowVrButton(boolean z2) {
        View view = this.f20152u;
        if (view != null) {
            view.setVisibility(z2 ? 0 : 8);
        }
    }

    public void setTimeBarMinUpdateInterval(int i) {
        this.f20127a0 = Util2.m3000h(i, 16, 1000);
    }

    public void setVrButtonListener(@Nullable View.OnClickListener onClickListener) {
        View view = this.f20152u;
        if (view != null) {
            view.setOnClickListener(onClickListener);
            m8903k(getShowVrButton(), onClickListener != null, this.f20152u);
        }
    }

    public PlayerControlView(Context context, @Nullable AttributeSet attributeSet, int i, @Nullable AttributeSet attributeSet2) {
        super(context, attributeSet, i);
        int resourceId = C10759R.e.exo_player_control_view;
        this.f20126W = 5000;
        this.f20128b0 = 0;
        this.f20127a0 = 200;
        this.f20134h0 = -9223372036854775807L;
        this.f20129c0 = true;
        this.f20130d0 = true;
        this.f20131e0 = true;
        this.f20132f0 = true;
        this.f20133g0 = false;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, C10759R.g.PlayerControlView, i, 0);
            try {
                this.f20126W = typedArrayObtainStyledAttributes.getInt(C10759R.g.PlayerControlView_show_timeout, this.f20126W);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(C10759R.g.PlayerControlView_controller_layout_id, resourceId);
                this.f20128b0 = typedArrayObtainStyledAttributes.getInt(C10759R.g.PlayerControlView_repeat_toggle_modes, this.f20128b0);
                this.f20129c0 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerControlView_show_rewind_button, this.f20129c0);
                this.f20130d0 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerControlView_show_fastforward_button, this.f20130d0);
                this.f20131e0 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerControlView_show_previous_button, this.f20131e0);
                this.f20132f0 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerControlView_show_next_button, this.f20132f0);
                this.f20133g0 = typedArrayObtainStyledAttributes.getBoolean(C10759R.g.PlayerControlView_show_shuffle_button, this.f20133g0);
                setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(C10759R.g.PlayerControlView_time_bar_min_update_interval, this.f20127a0));
            } finally {
                typedArrayObtainStyledAttributes.recycle();
            }
        }
        this.f20139l = new CopyOnWriteArrayList<>();
        this.f20104A = new Timeline.b();
        this.f20105B = new Timeline.c();
        StringBuilder sb = new StringBuilder();
        this.f20156y = sb;
        this.f20157z = new Formatter(sb, Locale.getDefault());
        this.f20135i0 = new long[0];
        this.f20136j0 = new boolean[0];
        this.f20138k0 = new long[0];
        this.f20140l0 = new boolean[0];
        ViewOnClickListenerC10755c viewOnClickListenerC10755c = new ViewOnClickListenerC10755c(null);
        this.f20137k = viewOnClickListenerC10755c;
        this.f20106C = new RunnableC2660d(this);
        this.f20107D = new RunnableC2657a(this);
        LayoutInflater.from(context).inflate(resourceId, this);
        setDescendantFocusability(262144);
        int i2 = C10759R.c.exo_progress;
        TimeBar timeBar = (TimeBar) findViewById(i2);
        View viewFindViewById = findViewById(C10759R.c.exo_progress_placeholder);
        if (timeBar != null) {
            this.f20155x = timeBar;
        } else if (viewFindViewById != null) {
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context, null, 0, attributeSet2);
            defaultTimeBar.setId(i2);
            defaultTimeBar.setLayoutParams(viewFindViewById.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById);
            viewGroup.removeView(viewFindViewById);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            this.f20155x = defaultTimeBar;
        } else {
            this.f20155x = null;
        }
        this.f20153v = (TextView) findViewById(C10759R.c.exo_duration);
        this.f20154w = (TextView) findViewById(C10759R.c.exo_position);
        TimeBar timeBar2 = this.f20155x;
        if (timeBar2 != null) {
            timeBar2.mo2762b(viewOnClickListenerC10755c);
        }
        View viewFindViewById2 = findViewById(C10759R.c.exo_play);
        this.f20145o = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(viewOnClickListenerC10755c);
        }
        View viewFindViewById3 = findViewById(C10759R.c.exo_pause);
        this.f20147p = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(viewOnClickListenerC10755c);
        }
        View viewFindViewById4 = findViewById(C10759R.c.exo_prev);
        this.f20141m = viewFindViewById4;
        if (viewFindViewById4 != null) {
            viewFindViewById4.setOnClickListener(viewOnClickListenerC10755c);
        }
        View viewFindViewById5 = findViewById(C10759R.c.exo_next);
        this.f20143n = viewFindViewById5;
        if (viewFindViewById5 != null) {
            viewFindViewById5.setOnClickListener(viewOnClickListenerC10755c);
        }
        View viewFindViewById6 = findViewById(C10759R.c.exo_rew);
        this.f20149r = viewFindViewById6;
        if (viewFindViewById6 != null) {
            viewFindViewById6.setOnClickListener(viewOnClickListenerC10755c);
        }
        View viewFindViewById7 = findViewById(C10759R.c.exo_ffwd);
        this.f20148q = viewFindViewById7;
        if (viewFindViewById7 != null) {
            viewFindViewById7.setOnClickListener(viewOnClickListenerC10755c);
        }
        ImageView imageView = (ImageView) findViewById(C10759R.c.exo_repeat_toggle);
        this.f20150s = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(viewOnClickListenerC10755c);
        }
        ImageView imageView2 = (ImageView) findViewById(C10759R.c.exo_shuffle);
        this.f20151t = imageView2;
        if (imageView2 != null) {
            imageView2.setOnClickListener(viewOnClickListenerC10755c);
        }
        View viewFindViewById8 = findViewById(C10759R.c.exo_vr);
        this.f20152u = viewFindViewById8;
        setShowVrButton(false);
        m8903k(false, false, viewFindViewById8);
        Resources resources = context.getResources();
        this.f20116M = resources.getInteger(C10759R.d.exo_media_button_opacity_percentage_enabled) / 100.0f;
        this.f20117N = resources.getInteger(C10759R.d.exo_media_button_opacity_percentage_disabled) / 100.0f;
        this.f20108E = resources.getDrawable(C10759R.b.exo_controls_repeat_off);
        this.f20109F = resources.getDrawable(C10759R.b.exo_controls_repeat_one);
        this.f20110G = resources.getDrawable(C10759R.b.exo_controls_repeat_all);
        this.f20114K = resources.getDrawable(C10759R.b.exo_controls_shuffle_on);
        this.f20115L = resources.getDrawable(C10759R.b.exo_controls_shuffle_off);
        this.f20111H = resources.getString(C10759R.f.exo_controls_repeat_off_description);
        this.f20112I = resources.getString(C10759R.f.exo_controls_repeat_one_description);
        this.f20113J = resources.getString(C10759R.f.exo_controls_repeat_all_description);
        this.f20118O = resources.getString(C10759R.f.exo_controls_shuffle_on_description);
        this.f20119P = resources.getString(C10759R.f.exo_controls_shuffle_off_description);
        this.f20144n0 = -9223372036854775807L;
        this.f20146o0 = -9223372036854775807L;
    }
}
