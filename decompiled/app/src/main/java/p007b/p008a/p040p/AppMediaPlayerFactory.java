package p007b.p008a.p040p;

import android.content.Context;
import com.discord.app.AppLog;
import com.discord.player.AppMediaPlayer;
import p007b.p085c.p086a.p087a0.AnimatableValueParser;
import p007b.p225i.p226a.p242c.C2653d;
import p007b.p225i.p226a.p242c.DefaultLoadControl;
import p007b.p225i.p226a.p242c.ExoPlayer2;
import p007b.p225i.p226a.p242c.SimpleExoPlayer;
import p007b.p225i.p226a.p242c.p257e3.DefaultAllocator;
import p007b.p225i.p226a.p242c.p257e3.DefaultDataSource;
import p507d0.p592z.p594d.Intrinsics3;
import p637j0.p653p.Schedulers2;
import p658rx.Scheduler;

/* JADX INFO: renamed from: b.a.p.i, reason: use source file name */
/* JADX INFO: compiled from: AppMediaPlayerFactory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppMediaPlayerFactory {
    /* JADX INFO: renamed from: a */
    public static final AppMediaPlayer m233a(Context context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        AppLog appLog = AppLog.f14950g;
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(appLog, "logger");
        CacheDataSourceFactory cacheDataSourceFactory = new CacheDataSourceFactory(new DefaultDataSource.a(context), 104857600);
        RxPlayerEventListener rxPlayerEventListener = new RxPlayerEventListener();
        AnimatableValueParser.m426D(true);
        DefaultLoadControl.m3871j(2500, 0, "bufferForPlaybackMs", "0");
        DefaultLoadControl.m3871j(5000, 0, "bufferForPlaybackAfterRebufferMs", "0");
        DefaultLoadControl.m3871j(10000, 2500, "minBufferMs", "bufferForPlaybackMs");
        DefaultLoadControl.m3871j(10000, 5000, "minBufferMs", "bufferForPlaybackAfterRebufferMs");
        DefaultLoadControl.m3871j(30000, 10000, "maxBufferMs", "minBufferMs");
        AnimatableValueParser.m426D(true);
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl(new DefaultAllocator(true, 65536), 10000, 30000, 2500, 5000, -1, false, 0, false);
        Intrinsics3.checkNotNullExpressionValue(defaultLoadControl, "DefaultLoadControl.Build…     )\n          .build()");
        ExoPlayer2.b bVar = new ExoPlayer2.b(context);
        AnimatableValueParser.m426D(!bVar.f6430s);
        bVar.f6417f = new C2653d(defaultLoadControl);
        AnimatableValueParser.m426D(!bVar.f6430s);
        bVar.f6430s = true;
        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer(bVar);
        Intrinsics3.checkNotNullExpressionValue(simpleExoPlayer, "ExoPlayer\n          .Bui…ntrol)\n          .build()");
        simpleExoPlayer.mo2929x(rxPlayerEventListener);
        Scheduler schedulerM10873a = Schedulers2.m10873a();
        Intrinsics3.checkNotNullExpressionValue(schedulerM10873a, "Schedulers.computation()");
        return new AppMediaPlayer(simpleExoPlayer, rxPlayerEventListener, cacheDataSourceFactory, schedulerM10873a, appLog);
    }
}
