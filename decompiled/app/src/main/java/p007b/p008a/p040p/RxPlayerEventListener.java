package p007b.p008a.p040p;

import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.metadata.Metadata;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
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
import p007b.p225i.p226a.p242c.p255c3.TrackSelectionArray;
import p007b.p225i.p226a.p242c.p260g3.VideoSize;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.k, reason: use source file name */
/* JADX INFO: compiled from: RxPlayerEventListener.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RxPlayerEventListener implements Player2.e {

    /* JADX INFO: renamed from: j */
    public final PublishSubject<c> f1590j = PublishSubject.m11133k0();

    /* JADX INFO: renamed from: k */
    public final PublishSubject<a> f1591k = PublishSubject.m11133k0();

    /* JADX INFO: renamed from: l */
    public final PublishSubject<b> f1592l = PublishSubject.m11133k0();

    /* JADX INFO: renamed from: b.a.p.k$a */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public final boolean f1593a;

        public a(boolean z2) {
            this.f1593a = z2;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof a) && this.f1593a == ((a) obj).f1593a;
            }
            return true;
        }

        public int hashCode() {
            boolean z2 = this.f1593a;
            if (z2) {
                return 1;
            }
            return z2 ? 1 : 0;
        }

        public String toString() {
            return outline.m827O(outline.m833U("IsPlayingChange(isPlaying="), this.f1593a, ")");
        }
    }

    /* JADX INFO: renamed from: b.a.p.k$b */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final PlaybackException f1594a;

        public b(PlaybackException playbackException) {
            Intrinsics3.checkNotNullParameter(playbackException, "exoPlaybackException");
            this.f1594a = playbackException;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof b) && Intrinsics3.areEqual(this.f1594a, ((b) obj).f1594a);
            }
            return true;
        }

        public int hashCode() {
            PlaybackException playbackException = this.f1594a;
            if (playbackException != null) {
                return playbackException.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("PlayerError(exoPlaybackException=");
            sbM833U.append(this.f1594a);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.a.p.k$c */
    /* JADX INFO: compiled from: RxPlayerEventListener.kt */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f1595a;

        public c(int i) {
            this.f1595a = i;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof c) && this.f1595a == ((c) obj).f1595a;
            }
            return true;
        }

        public int hashCode() {
            return this.f1595a;
        }

        public String toString() {
            return outline.m814B(outline.m833U("PlayerStateChange(playbackState="), this.f1595a, ")");
        }
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: A */
    public /* synthetic */ void mo235A(MediaMetadata mediaMetadata) {
        Player.m2427i(this, mediaMetadata);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: D */
    public /* synthetic */ void mo236D(boolean z2) {
        Player.m2438t(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: E */
    public /* synthetic */ void mo237E(Player2 player2, Player2.d dVar) {
        Player.m2423e(this, player2, dVar);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: G */
    public /* synthetic */ void mo238G(int i, boolean z2) {
        Player.m2422d(this, i, z2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: H */
    public /* synthetic */ void mo239H(boolean z2, int i) {
        Player3.m3883k(this, z2, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: L */
    public /* synthetic */ void mo240L(int i) {
        Player.m2437s(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: M */
    public /* synthetic */ void mo241M(MediaItem2 mediaItem2, int i) {
        Player.m2426h(this, mediaItem2, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: W */
    public /* synthetic */ void mo242W(boolean z2, int i) {
        Player.m2429k(this, z2, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: Y */
    public /* synthetic */ void mo243Y(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        Player3.m3890r(this, trackGroupArray, trackSelectionArray);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: a */
    public /* synthetic */ void mo244a() {
        Player3.m3887o(this);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: a0 */
    public /* synthetic */ void mo245a0(int i, int i2) {
        Player.m2440v(this, i, i2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: b */
    public /* synthetic */ void mo246b(Metadata metadata) {
        Player.m2428j(this, metadata);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: b0 */
    public /* synthetic */ void mo247b0(PlaybackParameters playbackParameters) {
        Player.m2430l(this, playbackParameters);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: c */
    public /* synthetic */ void mo248c() {
        Player.m2436r(this);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: d */
    public /* synthetic */ void mo249d(boolean z2) {
        Player.m2439u(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: e */
    public /* synthetic */ void mo250e(List list) {
        Player.m2420b(this, list);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: f */
    public /* synthetic */ void mo251f(VideoSize videoSize) {
        Player.m2443y(this, videoSize);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: f0 */
    public /* synthetic */ void mo252f0(PlaybackException playbackException) {
        Player.m2434p(this, playbackException);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: g */
    public /* synthetic */ void mo253g(Player2.f fVar, Player2.f fVar2, int i) {
        Player.m2435q(this, fVar, fVar2, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: h */
    public /* synthetic */ void mo254h(int i) {
        Player.m2432n(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: i */
    public /* synthetic */ void mo255i(boolean z2) {
        Player3.m3876d(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: j */
    public /* synthetic */ void mo256j(int i) {
        Player3.m3884l(this, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: j0 */
    public void mo257j0(boolean z2) {
        PublishSubject<a> publishSubject = this.f1591k;
        publishSubject.f27650k.onNext(new a(z2));
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: p */
    public /* synthetic */ void mo258p(TracksInfo tracksInfo) {
        Player.m2442x(this, tracksInfo);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: r */
    public /* synthetic */ void mo259r(boolean z2) {
        Player.m2424f(this, z2);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: s */
    public void mo260s(PlaybackException playbackException) {
        Intrinsics3.checkNotNullParameter(playbackException, "error");
        PublishSubject<b> publishSubject = this.f1592l;
        publishSubject.f27650k.onNext(new b(playbackException));
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: t */
    public /* synthetic */ void mo261t(Player2.b bVar) {
        Player.m2419a(this, bVar);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: v */
    public /* synthetic */ void mo262v(Timeline timeline, int i) {
        Player.m2441w(this, timeline, i);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: w */
    public /* synthetic */ void mo263w(float f) {
        Player.m2444z(this, f);
    }

    @Override // p007b.p225i.p226a.p242c.Player2.c
    /* JADX INFO: renamed from: y */
    public void mo264y(int i) {
        PublishSubject<c> publishSubject = this.f1590j;
        publishSubject.f27650k.onNext(new c(i));
    }

    @Override // p007b.p225i.p226a.p242c.Player2.e
    /* JADX INFO: renamed from: z */
    public /* synthetic */ void mo265z(DeviceInfo2 deviceInfo2) {
        Player.m2421c(this, deviceInfo2);
    }
}
