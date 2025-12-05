package p007b.p008a.p040p;

import com.discord.player.AppMediaPlayer;
import com.discord.utilities.logging.Logger;
import p007b.p008a.p040p.RxPlayerEventListener;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Action1;

/* compiled from: AppMediaPlayer.kt */
/* renamed from: b.a.p.c, reason: use source file name */
/* loaded from: classes.dex */
public final class AppMediaPlayer4<T> implements Action1<RxPlayerEventListener.b> {

    /* renamed from: j */
    public final /* synthetic */ AppMediaPlayer f1581j;

    /* renamed from: k */
    public final /* synthetic */ String f1582k;

    public AppMediaPlayer4(AppMediaPlayer appMediaPlayer, String str) {
        this.f1581j = appMediaPlayer;
        this.f1582k = str;
    }

    @Override // p658rx.functions.Action1
    public void call(RxPlayerEventListener.b bVar) {
        Logger logger = this.f1581j.logger;
        String simpleName = AppMediaPlayer.class.getSimpleName();
        Intrinsics3.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        Logger.e$default(logger, simpleName, "playback error for feature: " + this.f1582k, bVar.f1594a, null, 8, null);
    }
}
