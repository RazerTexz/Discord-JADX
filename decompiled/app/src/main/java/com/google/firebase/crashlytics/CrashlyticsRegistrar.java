package com.google.firebase.crashlytics;

import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.j.a.a;
import b.i.c.l.d;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.m.b;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class CrashlyticsRegistrar implements g {
    @Override // b.i.c.l.g
    public List<d<?>> getComponents() {
        d.b bVarA = d.a(FirebaseCrashlytics.class);
        bVarA.a(new o(c.class, 1, 0));
        bVarA.a(new o(b.i.c.u.g.class, 1, 0));
        bVarA.a(new o(a.class, 0, 0));
        bVarA.a(new o(b.i.c.m.d.a.class, 0, 0));
        bVarA.c(new b(this));
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-cls", "17.3.0"));
    }
}
