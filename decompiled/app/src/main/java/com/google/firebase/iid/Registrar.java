package com.google.firebase.iid;

import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.c;
import b.i.c.l.d;
import b.i.c.l.e;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.r.d;
import b.i.c.s.r;
import b.i.c.s.s;
import b.i.c.x.h;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
@Keep
/* loaded from: classes3.dex */
public final class Registrar implements g {

    /* compiled from: com.google.firebase:firebase-iid@@21.0.0 */
    public static class a implements b.i.c.s.e0.a {
        public a(FirebaseInstanceId firebaseInstanceId) {
        }
    }

    public static final /* synthetic */ FirebaseInstanceId lambda$getComponents$0$Registrar(e eVar) {
        return new FirebaseInstanceId((c) eVar.a(c.class), eVar.b(h.class), eVar.b(d.class), (b.i.c.u.g) eVar.a(b.i.c.u.g.class));
    }

    public static final /* synthetic */ b.i.c.s.e0.a lambda$getComponents$1$Registrar(e eVar) {
        return new a((FirebaseInstanceId) eVar.a(FirebaseInstanceId.class));
    }

    @Override // b.i.c.l.g
    @Keep
    public final List<b.i.c.l.d<?>> getComponents() {
        d.b bVarA = b.i.c.l.d.a(FirebaseInstanceId.class);
        bVarA.a(new o(c.class, 1, 0));
        bVarA.a(new o(h.class, 0, 1));
        bVarA.a(new o(b.i.c.r.d.class, 0, 1));
        bVarA.a(new o(b.i.c.u.g.class, 1, 0));
        bVarA.c(r.a);
        bVarA.d(1);
        b.i.c.l.d dVarB = bVarA.b();
        d.b bVarA2 = b.i.c.l.d.a(b.i.c.s.e0.a.class);
        bVarA2.a(new o(FirebaseInstanceId.class, 1, 0));
        bVarA2.c(s.a);
        return Arrays.asList(dVarB, bVarA2.b(), f.N("fire-iid", "21.0.0"));
    }
}
