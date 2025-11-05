package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import b.i.a.f.e.o.f;
import b.i.c.l.d;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.m.d.a;
import b.i.c.m.e.b;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashlyticsNdkRegistrar implements g {
    @Override // b.i.c.l.g
    public List<d<?>> getComponents() {
        d.b bVarA = d.a(a.class);
        bVarA.a(new o(Context.class, 1, 0));
        bVarA.c(new b(this));
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-cls-ndk", "17.3.0"));
    }
}
