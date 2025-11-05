package b.a.p;

import b.a.p.k;
import com.discord.player.AppMediaPlayer;
import rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* loaded from: classes.dex */
public final class a<T> implements Action1<k.a> {
    public final /* synthetic */ AppMediaPlayer j;

    public a(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(k.a aVar) {
        this.j.eventSubject.k.onNext(aVar.a ? AppMediaPlayer.Event.f.a : AppMediaPlayer.Event.d.a);
    }
}
