package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p658rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* renamed from: b.a.p.h, reason: use source file name */
/* loaded from: classes.dex */
public final class AppMediaPlayer9<T> implements Action1<Throwable> {

    /* renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1587j;

    public AppMediaPlayer9(AppMediaPlayer appMediaPlayer) {
        this.f1587j = appMediaPlayer;
    }

    @Override // p658rx.functions.Action1
    public void call(Throwable th) {
        Logger.e$default(this.f1587j.logger, "error while polling progress position", th, null, 4, null);
    }
}
