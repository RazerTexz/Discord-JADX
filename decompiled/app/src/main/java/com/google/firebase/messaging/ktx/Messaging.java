package com.google.firebase.messaging.ktx;

import java.util.List;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p225i.p361c.p368l.Component4;
import p007b.p225i.p361c.p368l.ComponentRegistrar;
import p507d0.p580t.CollectionsJVM;

/* compiled from: Messaging.kt */
/* renamed from: com.google.firebase.messaging.ktx.FirebaseMessagingKtxRegistrar, reason: use source file name */
/* loaded from: classes3.dex */
public final class Messaging implements ComponentRegistrar {
    @Override // p007b.p225i.p361c.p368l.ComponentRegistrar
    public List<Component4<?>> getComponents() {
        return CollectionsJVM.listOf(C3404f.m4228N("fire-fcm-ktx", "21.0.0"));
    }
}
