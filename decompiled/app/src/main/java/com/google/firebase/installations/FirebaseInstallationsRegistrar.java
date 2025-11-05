package com.google.firebase.installations;

import androidx.annotation.Keep;
import b.i.c.c;
import b.i.c.l.d;
import b.i.c.l.e;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.r.d;
import b.i.c.u.f;
import b.i.c.x.h;
import java.util.Arrays;
import java.util.List;

@Keep
/* loaded from: classes3.dex */
public class FirebaseInstallationsRegistrar implements g {
    public static /* synthetic */ b.i.c.u.g lambda$getComponents$0(e eVar) {
        return new f((c) eVar.a(c.class), eVar.b(h.class), eVar.b(d.class));
    }

    @Override // b.i.c.l.g
    public List<b.i.c.l.d<?>> getComponents() {
        d.b bVarA = b.i.c.l.d.a(b.i.c.u.g.class);
        bVarA.a(new o(c.class, 1, 0));
        bVarA.a(new o(b.i.c.r.d.class, 0, 1));
        bVarA.a(new o(h.class, 0, 1));
        bVarA.c(b.i.c.u.h.a);
        return Arrays.asList(bVarA.b(), b.i.a.f.e.o.f.N("fire-installations", "16.3.4"));
    }
}
