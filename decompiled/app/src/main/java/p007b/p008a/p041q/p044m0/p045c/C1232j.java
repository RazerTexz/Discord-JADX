package p007b.p008a.p041q.p044m0.p045c;

import com.discord.rtcconnection.mediaengine.MediaEngine;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: MediaEngineLegacy.kt */
/* renamed from: b.a.q.m0.c.j */
/* loaded from: classes.dex */
public final class C1232j extends Lambda implements Function1<MediaEngine.InterfaceC5642c, Unit> {

    /* renamed from: j */
    public static final C1232j f1720j = new C1232j();

    public C1232j() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(MediaEngine.InterfaceC5642c interfaceC5642c) {
        MediaEngine.InterfaceC5642c interfaceC5642c2 = interfaceC5642c;
        Intrinsics3.checkNotNullParameter(interfaceC5642c2, "it");
        interfaceC5642c2.onConnecting();
        return Unit.f27425a;
    }
}
