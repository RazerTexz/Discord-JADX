package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* renamed from: b.a.p.b, reason: use source file name */
/* loaded from: classes.dex */
public final class AppMediaPlayer3<T> implements Action1<Throwable> {

    /* renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1580j;

    public AppMediaPlayer3(AppMediaPlayer appMediaPlayer) {
        this.f1580j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1580j.logger, "error while listening to isPlayingChanges", th, null, 4, null);
    }
}
