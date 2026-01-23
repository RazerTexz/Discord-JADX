package p007b.p008a.p041q.p044m0.p045c;

import co.discord.media_engine.Connection;
import co.discord.media_engine.StreamParameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.q.m0.c.b, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy2 implements Connection.OnVideoCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ MediaEngineConnectionLegacy5 f1695a;

    /* JADX INFO: renamed from: b.a.q.m0.c.b$a */
    /* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int $ssrc;
        public final /* synthetic */ String $streamIdentifier;
        public final /* synthetic */ StreamParameters[] $streams;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j, int i, String str, StreamParameters[] streamParametersArr) {
            super(0);
            this.$userId = j;
            this.$ssrc = i;
            this.$streamIdentifier = str;
            this.$streams = streamParametersArr;
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5 = MediaEngineConnectionLegacy2.this.f1695a;
            long j = this.$userId;
            int i = this.$ssrc;
            String str = this.$streamIdentifier;
            StreamParameters[] streamParametersArr = this.$streams;
            mediaEngineConnectionLegacy5.f1702e.put(Long.valueOf(j), Long.valueOf(i));
            mediaEngineConnectionLegacy5.m318y(new MediaEngineConnectionLegacy8(mediaEngineConnectionLegacy5, j, str, i, streamParametersArr));
            return Unit.f27425a;
        }
    }

    public MediaEngineConnectionLegacy2(MediaEngineConnectionLegacy5 mediaEngineConnectionLegacy5) {
        this.f1695a = mediaEngineConnectionLegacy5;
    }

    @Override // co.discord.media_engine.Connection.OnVideoCallback
    public void onVideo(long j, int i, String str, StreamParameters[] streamParametersArr) {
        Intrinsics3.checkNotNullParameter(str, "streamIdentifier");
        Intrinsics3.checkNotNullParameter(streamParametersArr, "streams");
        MediaEngineConnectionLegacy5.m294x(this.f1695a, new a(j, i, str, streamParametersArr));
    }
}
