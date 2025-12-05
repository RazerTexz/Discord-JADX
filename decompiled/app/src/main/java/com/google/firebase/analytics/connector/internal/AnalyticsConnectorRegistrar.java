package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.FirebaseApp2;
import p007b.p225i.p361c.p362j.p363a.InterfaceC4549a;
import p007b.p225i.p361c.p362j.p363a.p364c.C4551a;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p396q.Subscriber2;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
@Keep
/* loaded from: classes3.dex */
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(InterfaceC4549a.class);
        bVarM6348a.m6351a(new Dependency2(FirebaseApp2.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(Context.class, 1, 0));
        bVarM6348a.m6351a(new Dependency2(Subscriber2.class, 1, 0));
        bVarM6348a.m6353c(C4551a.f12144a);
        bVarM6348a.m6354d(2);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-analytics", "18.0.0"));
    }
}
