package b.a.p;

import b.a.p.k;
import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* loaded from: classes.dex */
public final class c<T> implements Action1<k.b> {
    public final /* synthetic */ AppMediaPlayer j;
    public final /* synthetic */ String k;

    public c(AppMediaPlayer appMediaPlayer, String str) {
        this.j = appMediaPlayer;
        this.k = str;
    }

    @Override // rx.functions.Action1
    public void call(k.b bVar) {
        Logger logger = this.j.logger;
        String simpleName = AppMediaPlayer.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.e$default(logger, simpleName, "playback error for feature: " + this.k, bVar.a, null, 8, null);
    }
}
