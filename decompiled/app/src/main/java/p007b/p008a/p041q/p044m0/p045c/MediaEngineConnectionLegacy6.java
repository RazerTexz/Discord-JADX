package p007b.p008a.p041q.p044m0.p045c;

import co.discord.media_engine.Connection;
import co.discord.media_engine.Stats;
import com.discord.utilities.logging.Logger;
import p007b.p008a.p041q.p044m0.p045c.MediaEngineConnectionLegacy5;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: b.a.q.m0.c.f, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy6 implements Connection.GetStatsCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ MediaEngineConnectionLegacy5.f f1718a;

    public MediaEngineConnectionLegacy6(MediaEngineConnectionLegacy5.f fVar) {
        this.f1718a = fVar;
    }

    @Override // co.discord.media_engine.Connection.GetStatsCallback
    public void onStats(Stats stats) {
        Intrinsics3.checkNotNullParameter(stats, "stats");
        this.f1718a.$onStats.invoke(stats);
    }

    @Override // co.discord.media_engine.Connection.GetStatsCallback
    public void onStatsError(Throwable th) {
        Logger.e$default(MediaEngineConnectionLegacy5.this.f1709l, "MediaEngineConnectionLegacy", "error collecting stats", th, null, 8, null);
    }
}
