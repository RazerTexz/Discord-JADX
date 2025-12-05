package com.google.firebase.dynamiclinks.internal;

import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p391o.AbstractC4767a;
import p007b.p225i.p361c.p391o.p392b.C4773f;

/* compiled from: com.google.firebase:firebase-dynamic-links@@19.1.1 */
@Keep
/* loaded from: classes3.dex */
public final class FirebaseDynamicLinkRegistrar implements ComponentRegistrar {
    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    @Keep
    public final List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(AbstractC4767a.class);
        bVarM6348a.m6351a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(InterfaceC4549a.class, 0, 0));
        bVarM6348a.m6353c(C4773f.f12810a);
        return Arrays.asList(bVarM6348a.m6352b());
    }
}
