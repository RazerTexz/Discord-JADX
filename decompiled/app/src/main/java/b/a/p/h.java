package b.a.p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* loaded from: classes.dex */
public final class h<T> implements Action1<Throwable> {
    public final /* synthetic */ AppMediaPlayer j;

    public h(AppMediaPlayer appMediaPlayer) {
        this.j = appMediaPlayer;
    }

    @Override // rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.j.logger, "error while polling progress position", th, null, 4, null);
    }
}
