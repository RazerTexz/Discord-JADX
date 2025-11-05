package com.google.firebase.messaging;

import androidx.annotation.Keep;
import androidx.annotation.VisibleForTesting;
import b.i.a.b.e;
import b.i.a.b.f;
import b.i.a.b.h;
import b.i.c.l.d;
import b.i.c.l.g;
import b.i.c.l.o;
import b.i.c.r.d;
import b.i.c.w.l;
import com.google.firebase.iid.FirebaseInstanceId;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
@Keep
/* loaded from: classes3.dex */
public class FirebaseMessagingRegistrar implements g {

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    public static class b<T> implements f<T> {
        public b(a aVar) {
        }

        @Override // b.i.a.b.f
        public void a(b.i.a.b.c<T> cVar) {
        }

        @Override // b.i.a.b.f
        public void b(b.i.a.b.c<T> cVar, h hVar) {
            ((b.i.c.m.d.r.a) hVar).a(null);
        }
    }

    /* compiled from: com.google.firebase:firebase-messaging@@21.0.0 */
    @VisibleForTesting
    public static class c implements b.i.a.b.g {
        @Override // b.i.a.b.g
        public <T> f<T> a(String str, Class<T> cls, b.i.a.b.b bVar, e<T, byte[]> eVar) {
            return new b(null);
        }
    }

    @VisibleForTesting
    public static b.i.a.b.g determineFactory(b.i.a.b.g gVar) {
        if (gVar != null) {
            Objects.requireNonNull(b.i.a.b.i.a.e);
            if (b.i.a.b.i.a.d.contains(new b.i.a.b.b("json"))) {
                return gVar;
            }
        }
        return new c();
    }

    public static final /* synthetic */ FirebaseMessaging lambda$getComponents$0$FirebaseMessagingRegistrar(b.i.c.l.e eVar) {
        return new FirebaseMessaging((b.i.c.c) eVar.a(b.i.c.c.class), (FirebaseInstanceId) eVar.a(FirebaseInstanceId.class), eVar.b(b.i.c.x.h.class), eVar.b(d.class), (b.i.c.u.g) eVar.a(b.i.c.u.g.class), determineFactory((b.i.a.b.g) eVar.a(b.i.a.b.g.class)), (b.i.c.q.d) eVar.a(b.i.c.q.d.class));
    }

    @Override // b.i.c.l.g
    @Keep
    public List<b.i.c.l.d<?>> getComponents() {
        d.b bVarA = b.i.c.l.d.a(FirebaseMessaging.class);
        bVarA.a(new o(b.i.c.c.class, 1, 0));
        bVarA.a(new o(FirebaseInstanceId.class, 1, 0));
        bVarA.a(new o(b.i.c.x.h.class, 0, 1));
        bVarA.a(new o(b.i.c.r.d.class, 0, 1));
        bVarA.a(new o(b.i.a.b.g.class, 0, 0));
        bVarA.a(new o(b.i.c.u.g.class, 1, 0));
        bVarA.a(new o(b.i.c.q.d.class, 1, 0));
        bVarA.c(l.a);
        bVarA.d(1);
        return Arrays.asList(bVarA.b(), b.i.a.f.e.o.f.N("fire-fcm", "20.1.7_1p"));
    }
}
