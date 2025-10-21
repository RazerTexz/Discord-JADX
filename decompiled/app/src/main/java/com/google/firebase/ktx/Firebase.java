package com.google.firebase.ktx;

import androidx.annotation.Keep;
import b.i.a.f.e.o.f;
import b.i.c.l.Component4;
import b.i.c.l.ComponentRegistrar;
import d0.t.CollectionsJVM;
import java.util.List;

/* compiled from: Firebase.kt */
@Keep
/* renamed from: com.google.firebase.ktx.FirebaseCommonKtxRegistrar, reason: use source file name */
/* loaded from: classes3.dex */
public final class Firebase implements ComponentRegistrar {
    @Override // b.i.c.l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        return CollectionsJVM.listOf(f.N("fire-core-ktx", "19.4.0"));
    }
}
