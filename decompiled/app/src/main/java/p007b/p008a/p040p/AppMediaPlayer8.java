package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import p007b.p225i.p226a.p242c.SimpleExoPlayer;
import p658rx.functions.Action1;
import p658rx.subjects.PublishSubject;

/* JADX INFO: renamed from: b.a.p.g, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer8<T> implements Action1<Long> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1586j;

    public AppMediaPlayer8(AppMediaPlayer appMediaPlayer) {
        this.f1586j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(Long l) {
        AppMediaPlayer appMediaPlayer = this.f1586j;
        PublishSubject<AppMediaPlayer.Event> publishSubject = appMediaPlayer.eventSubject;
        publishSubject.f27650k.onNext(new AppMediaPlayer.Event.C5585c(((SimpleExoPlayer) appMediaPlayer.exoPlayer).mo2894T()));
    }
}
