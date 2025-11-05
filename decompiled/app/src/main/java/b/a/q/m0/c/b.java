package b.a.q.m0.c;

import co.discord.media_engine.Connection;
import co.discord.media_engine.StreamParameters;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: MediaEngineConnectionLegacy.kt */
/* loaded from: classes.dex */
public final class b implements Connection.OnVideoCallback {
    public final /* synthetic */ e a;

    /* compiled from: MediaEngineConnectionLegacy.kt */
    public static final class a extends d0.z.d.o implements Function0<Unit> {
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
            e eVar = b.this.a;
            long j = this.$userId;
            int i = this.$ssrc;
            String str = this.$streamIdentifier;
            StreamParameters[] streamParametersArr = this.$streams;
            eVar.e.put(Long.valueOf(j), Long.valueOf(i));
            eVar.y(new h(eVar, j, str, i, streamParametersArr));
            return Unit.a;
        }
    }

    public b(e eVar) {
        this.a = eVar;
    }

    @Override // co.discord.media_engine.Connection.OnVideoCallback
    public void onVideo(long j, int i, String str, StreamParameters[] streamParametersArr) {
        d0.z.d.m.checkNotNullParameter(str, "streamIdentifier");
        d0.z.d.m.checkNotNullParameter(streamParametersArr, "streams");
        e.x(this.a, new a(j, i, str, streamParametersArr));
    }
}
