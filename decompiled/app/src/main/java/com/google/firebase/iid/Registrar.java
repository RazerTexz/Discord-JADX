package com.google.firebase.iid;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p397r.HeartBeatInfo;
import p007b.p225i.p361c.p398s.C4827r;
import p007b.p225i.p361c.p398s.C4828s;
import p007b.p225i.p361c.p398s.p399e0.InterfaceC4814a;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
@Keep
/* loaded from: classes3.dex */
public final class Registrar implements ComponentRegistrar {

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    /* renamed from: com.google.firebase.iid.Registrar$a */
    public static class C11079a implements InterfaceC4814a {
        public C11079a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(ComponentContainer componentContainer) {
        return new FirebaseInstanceId((FirebaseApp2) componentContainer.mo6346a(FirebaseApp2.class), componentContainer.mo6355b(UserAgentPublisher.class), componentContainer.mo6355b(HeartBeatInfo.class), (InterfaceC4843g) componentContainer.mo6346a(InterfaceC4843g.class));
    }

    public static final /* synthetic */ InterfaceC4814a lambda$getComponents$1$Registrar(ComponentContainer componentContainer) {
        return new C11079a((FirebaseInstanceId) componentContainer.mo6346a(FirebaseInstanceId.class));
    }

    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    @Keep
    public final List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(FirebaseInstanceId.class);
        bVarM6348a.m6351a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(UserAgentPublisher.class, 0, 1));
        bVarM6348a.m6351a(new Dependency2(HeartBeatInfo.class, 0, 1));
        bVarM6348a.m6351a(new Dependency2(InterfaceC4843g.class, 1, 0));
        bVarM6348a.m6353c(C4827r.f12890a);
        bVarM6348a.m6354d(1);
        Component4 component4M6352b = bVarM6348a.m6352b();
        Component4.b bVarM6348a2 = Component4.m6348a(InterfaceC4814a.class);
        bVarM6348a2.m6351a(new Dependency2(FirebaseInstanceId.class, 1, 0));
        bVarM6348a2.m6353c(C4828s.f12891a);
        return Arrays.asList(component4M6352b, bVarM6348a2.m6352b(), C3404f.m4228N("fire-iid", "21.0.0"));
    }
}
