package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import p007b.p008a.p040p.RxPlayerEventListener;
import p658rx.functions.Action1;

/* JADX INFO: renamed from: b.a.p.a, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayer2<T> implements Action1<RxPlayerEventListener.a> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1579j;

    public AppMediaPlayer2(AppMediaPlayer appMediaPlayer) {
        this.f1579j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(RxPlayerEventListener.a aVar) {
        this.f1579j.eventSubject.f27650k.onNext(aVar.f1593a ? AppMediaPlayer.Event.C5588f.f18659a : AppMediaPlayer.Event.C5586d.f18657a);
    }
}
