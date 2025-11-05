package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.j.a.a;
import b.i.c.l.d;
import b.i.c.l.g;
import b.i.c.l.o;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
@Keep
/* loaded from: classes3.dex */
public class AnalyticsConnectorRegistrar implements g {
    @Override // b.i.c.l.g
    @Keep
    @SuppressLint({"MissingPermission"})
    public List<d<?>> getComponents() {
        d.b bVarA = d.a(a.class);
        bVarA.a(new o(c.class, 1, 0));
        bVarA.a(new o(Context.class, 1, 0));
        bVarA.a(new o(b.i.c.q.d.class, 1, 0));
        bVarA.c(b.i.c.j.a.c.a.a);
        bVarA.d(2);
        return Arrays.asList(bVarA.b(), f.N("fire-analytics", "18.0.0"));
    }
}
