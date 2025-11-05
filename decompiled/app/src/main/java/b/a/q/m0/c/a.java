package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: MediaEngineConnectionLegacy.kt */
/* loaded from: classes.dex */
public final class a extends d0.z.d.o implements Function1<MediaEngineConnection.d, Unit> {
    public final /* synthetic */ MediaEngineConnection.ConnectionState $value;
    public final /* synthetic */ e this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(e eVar, MediaEngineConnection.ConnectionState connectionState) {
        super(1);
        this.this$0 = eVar;
        this.$value = connectionState;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection.d dVar) {
        MediaEngineConnection.d dVar2 = dVar;
        d0.z.d.m.checkNotNullParameter(dVar2, "it");
        dVar2.onConnectionStateChange(this.this$0, this.$value);
        return Unit.a;
    }
}
