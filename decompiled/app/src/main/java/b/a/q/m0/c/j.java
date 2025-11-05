package b.a.q.m0.c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: MediaEngineLegacy.kt */
/* loaded from: classes.dex */
public final class j extends d0.z.d.o implements Function1<MediaEngine.c, Unit> {
    public static final j j = new j();

    public j() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngine.c cVar) {
        MediaEngine.c cVar2 = cVar;
        d0.z.d.m.checkNotNullParameter(cVar2, "it");
        cVar2.onConnecting();
        return Unit.a;
    }
}
