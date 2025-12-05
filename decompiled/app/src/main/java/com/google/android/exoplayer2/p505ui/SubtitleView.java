package com.google.android.exoplayer2.p505ui;

import android.content.Context;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.CaptioningManager;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import p007b.p225i.p226a.p242c.p256d3.C2663g;
import p007b.p225i.p226a.p242c.p256d3.CanvasSubtitleOutput;
import p007b.p225i.p226a.p242c.p256d3.CaptionStyleCompat;
import p007b.p225i.p226a.p242c.p256d3.WebViewSubtitleOutput2;
import p007b.p225i.p226a.p242c.p259f3.Util2;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;

/* loaded from: classes3.dex */
public final class SubtitleView extends FrameLayout implements Player2.e {

    /* renamed from: j */
    public List<Cue> f20190j;

    /* renamed from: k */
    public CaptionStyleCompat f20191k;

    /* renamed from: l */
    public int f20192l;

    /* renamed from: m */
    public float f20193m;

    /* renamed from: n */
    public float f20194n;

    /* renamed from: o */
    public boolean f20195o;

    /* renamed from: p */
    public boolean f20196p;

    /* renamed from: q */
    public int f20197q;

    /* renamed from: r */
    public InterfaceC10760a f20198r;

    /* renamed from: s */
    public View f20199s;

    /* renamed from: com.google.android.exoplayer2.ui.SubtitleView$a */
    public interface InterfaceC10760a {
        /* renamed from: a */
        void mo2758a(List<Cue> list, CaptionStyleCompat captionStyleCompat, float f, int i, float f2);
    }

    public SubtitleView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f20190j = Collections.emptyList();
        this.f20191k = CaptionStyleCompat.f6349a;
        this.f20192l = 0;
        this.f20193m = 0.0533f;
        this.f20194n = 0.08f;
        this.f20195o = true;
        this.f20196p = true;
        CanvasSubtitleOutput canvasSubtitleOutput = new CanvasSubtitleOutput(context, null);
        this.f20198r = canvasSubtitleOutput;
        this.f20199s = canvasSubtitleOutput;
        addView(canvasSubtitleOutput);
        this.f20197q = 1;
    }

    private List<Cue> getCuesWithStylingPreferencesApplied() {
        if (this.f20195o && this.f20196p) {
            return this.f20190j;
        }
        ArrayList arrayList = new ArrayList(this.f20190j.size());
        for (int i = 0; i < this.f20190j.size(); i++) {
            Cue.b bVarM2605a = this.f20190j.get(i).m2605a();
            if (!this.f20195o) {
                bVarM2605a.f5786n = false;
                CharSequence charSequence = bVarM2605a.f5773a;
                if (charSequence instanceof Spanned) {
                    if (!(charSequence instanceof Spannable)) {
                        bVarM2605a.f5773a = SpannableString.valueOf(charSequence);
                    }
                    CharSequence charSequence2 = bVarM2605a.f5773a;
                    Objects.requireNonNull(charSequence2);
                    AnimatableValueParser.m464P1((Spannable) charSequence2, C2663g.f6341a);
                }
                AnimatableValueParser.m461O1(bVarM2605a);
            } else if (!this.f20196p) {
                AnimatableValueParser.m461O1(bVarM2605a);
            }
            arrayList.add(bVarM2605a.m2606a());
        }
        return arrayList;
    }

    private float getUserCaptionFontScale() {
        CaptioningManager captioningManager;
        if (Util2.f6708a < 19 || isInEditMode() || (captioningManager = (CaptioningManager) getContext().getSystemService("captioning")) == null || !captioningManager.isEnabled()) {
            return 1.0f;
        }
        return captioningManager.getFontScale();
    }

    private CaptionStyleCompat getUserCaptionStyle() {
        int i = Util2.f6708a;
        if (i < 19 || isInEditMode()) {
            return CaptionStyleCompat.f6349a;
        }
        CaptioningManager captioningManager = (CaptioningManager) getContext().getSystemService("captioning");
        if (captioningManager == null || !captioningManager.isEnabled()) {
            return CaptionStyleCompat.f6349a;
        }
        CaptioningManager.CaptionStyle userStyle = captioningManager.getUserStyle();
        if (i < 21) {
            return new CaptionStyleCompat(userStyle.foregroundColor, userStyle.backgroundColor, 0, userStyle.edgeType, userStyle.edgeColor, userStyle.getTypeface());
        }
        return new CaptionStyleCompat(userStyle.hasForegroundColor() ? userStyle.foregroundColor : -1, userStyle.hasBackgroundColor() ? userStyle.backgroundColor : ViewCompat.MEASURED_STATE_MASK, userStyle.hasWindowColor() ? userStyle.windowColor : 0, userStyle.hasEdgeType() ? userStyle.edgeType : 0, userStyle.hasEdgeColor() ? userStyle.edgeColor : -1, userStyle.getTypeface());
    }

    private <T extends View & InterfaceC10760a> void setView(T t) {
        removeView(this.f20199s);
        View view = this.f20199s;
        if (view instanceof WebViewSubtitleOutput2) {
            ((WebViewSubtitleOutput2) view).f6403k.destroy();
        }
        this.f20199s = t;
        this.f20198r = t;
        addView(t);
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
    public void mo250e(List<Cue> list) {
        setCues(list);
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

    /* renamed from: k */
    public void m8929k() {
        setStyle(getUserCaptionStyle());
    }

    /* renamed from: l */
    public void m8930l() {
        setFractionalTextSize(getUserCaptionFontScale() * 0.0533f);
    }

    /* renamed from: m */
    public final void m8931m() {
        this.f20198r.mo2758a(getCuesWithStylingPreferencesApplied(), this.f20191k, this.f20193m, this.f20192l, this.f20194n);
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

    public void setApplyEmbeddedFontSizes(boolean z2) {
        this.f20196p = z2;
        m8931m();
    }

    public void setApplyEmbeddedStyles(boolean z2) {
        this.f20195o = z2;
        m8931m();
    }

    public void setBottomPaddingFraction(float f) {
        this.f20194n = f;
        m8931m();
    }

    public void setCues(@Nullable List<Cue> list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.f20190j = list;
        m8931m();
    }

    public void setFractionalTextSize(float f) {
        this.f20192l = 0;
        this.f20193m = f;
        m8931m();
    }

    public void setStyle(CaptionStyleCompat captionStyleCompat) {
        this.f20191k = captionStyleCompat;
        m8931m();
    }

    public void setViewType(int i) {
        if (this.f20197q == i) {
            return;
        }
        if (i == 1) {
            setView(new CanvasSubtitleOutput(getContext(), null));
        } else {
            if (i != 2) {
                throw new IllegalArgumentException();
            }
            setView(new WebViewSubtitleOutput2(getContext()));
        }
        this.f20197q = i;
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
