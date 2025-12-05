package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import java.util.Arrays;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p007b.p225i.p361c.p368l.Dependency2;
import p007b.p225i.p361c.p369m.p370d.CrashlyticsNativeComponent;
import p007b.p225i.p361c.p369m.p389e.CrashlyticsNdkRegistrar2;

/* loaded from: classes3.dex */
public class CrashlyticsNdkRegistrar implements ComponentRegistrar {
    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        Component4.b bVarM6348a = Component4.m6348a(CrashlyticsNativeComponent.class);
        bVarM6348a.m6351a(new Dependency2(Context.class, 1, 0));
        bVarM6348a.m6353c(new CrashlyticsNdkRegistrar2(this));
        bVarM6348a.m6354d(2);
        return Arrays.asList(bVarM6348a.m6352b(), C3404f.m4228N("fire-cls-ndk", "17.3.0"));
    }
}
