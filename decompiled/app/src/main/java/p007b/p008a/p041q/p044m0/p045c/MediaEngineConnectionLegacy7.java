package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngineConnection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: b.a.q.m0.c.g, reason: use source file name */
/* JADX INFO: compiled from: MediaEngineConnectionLegacy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class MediaEngineConnectionLegacy7 extends Lambda implements Function1<MediaEngineConnection.InterfaceC5648d, Unit> {
    public final /* synthetic */ int $audioSsrc;
    public final /* synthetic */ boolean $isSpeaking;
    public final /* synthetic */ long $userId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MediaEngineConnectionLegacy7(long j, int i, boolean z2) {
        super(1);
        this.$userId = j;
        this.$audioSsrc = i;
        this.$isSpeaking = z2;
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngineConnection.InterfaceC5648d interfaceC5648d) {
        MediaEngineConnection.InterfaceC5648d interfaceC5648d2 = interfaceC5648d;
        Intrinsics3.checkNotNullParameter(interfaceC5648d2, "it");
        interfaceC5648d2.onSpeaking(this.$userId, this.$audioSsrc, this.$isSpeaking);
        return Unit.f27425a;
    }
}
