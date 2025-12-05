package com.google.firebase.ktx;

import androidx.annotation.Keep;
import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p507d0.p580t.CollectionsJVM;

/* compiled from: Firebase.kt */
@Keep
/* renamed from: com.google.firebase.ktx.FirebaseCommonKtxRegistrar, reason: use source file name */
/* loaded from: classes3.dex */
public final class Firebase implements ComponentRegistrar {
    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        return CollectionsJVM.listOf(C3404f.m4228N("fire-core-ktx", "19.4.0"));
    }
}
