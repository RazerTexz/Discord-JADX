package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import java.util.Collections;
import java.util.List;
import p007b.p225i.p226a.p228b.TransportFactory;
import p007b.p225i.p226a.p228b.p229i.CCTDestination;
import p007b.p225i.p226a.p228b.p231j.TransportRuntime;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentContainer;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p390n.C4766a;

/* JADX INFO: compiled from: com.google.firebase:firebase-datatransport@@17.0.3 */
/* JADX INFO: loaded from: classes3.dex */
@Keep
public class TransportRegistrar implements ComponentRegistrar {
    public static /* synthetic */ TransportFactory lambda$getComponents$0(ComponentContainer componentContainer) {
        TransportRuntime.m2360b((Context) componentContainer.mo6346a(Context.class));
        return TransportRuntime.m2359a().m2361c(CCTDestination.f5127e);
    }

    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(TransportFactory.class);
        bVarM6348a.m6351a(new Dependency2(Context.class, 1, 0));
        bVarM6348a.m6353c(C4766a.f12804a);
        return Collections.singletonList(bVarM6348a.m6352b());
    }
}
