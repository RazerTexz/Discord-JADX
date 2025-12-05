package com.google.firebase.installations;

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
import p007b.p225i.p361c.p401u.FirebaseInstallations4;
import p007b.p225i.p361c.p401u.FirebaseInstallationsRegistrar2;
import p007b.p225i.p361c.p401u.InterfaceC4843g;
import p007b.p225i.p361c.p407x.UserAgentPublisher;

@Keep
/* loaded from: classes3.dex */
public class FirebaseInstallationsRegistrar implements ComponentRegistrar {
    public static /* synthetic */ InterfaceC4843g lambda$getComponents$0(ComponentContainer componentContainer) {
        return new FirebaseInstallations4((FirebaseApp2) componentContainer.mo6346a(FirebaseApp2.class), componentContainer.mo6355b(UserAgentPublisher.class), componentContainer.mo6355b(HeartBeatInfo.class));
    }

    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(InterfaceC4843g.class);
        bVarM6348a.m6351a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(HeartBeatInfo.class, 0, 1));
        bVarM6348a.m6351a(new Dependency2(UserAgentPublisher.class, 0, 1));
        bVarM6348a.m6353c(FirebaseInstallationsRegistrar2.f12942a);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-installations", "16.3.4"));
    }
}
