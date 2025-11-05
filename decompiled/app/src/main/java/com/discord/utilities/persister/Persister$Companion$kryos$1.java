package com.discord.utilities.persister;

import com.esotericsoftware.kryo.Kryo;

/* compiled from: Persister.kt */
/* loaded from: classes2.dex */
public final class Persister$Companion$kryos$1 extends ThreadLocal<Kryo> {
    @Override // java.lang.ThreadLocal
    public /* bridge */ /* synthetic */ Kryo initialValue() {
        return initialValue();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.ThreadLocal
    public Kryo initialValue() {
        Kryo kryo = new Kryo();
        Persister.INSTANCE.getKryoConfig().invoke(kryo);
        return kryo;
    }
}
