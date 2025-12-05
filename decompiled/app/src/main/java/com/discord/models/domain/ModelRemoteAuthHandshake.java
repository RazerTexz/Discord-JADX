package com.discord.models.domain;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelRemoteAuthHandshake.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelRemoteAuthHandshake {
    private final String handshakeToken;

    public ModelRemoteAuthHandshake(String str) {
        Intrinsics3.checkNotNullParameter(str, "handshakeToken");
        this.handshakeToken = str;
    }

    public static /* synthetic */ ModelRemoteAuthHandshake copy$default(ModelRemoteAuthHandshake modelRemoteAuthHandshake, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelRemoteAuthHandshake.handshakeToken;
        }
        return modelRemoteAuthHandshake.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public final ModelRemoteAuthHandshake copy(String handshakeToken) {
        Intrinsics3.checkNotNullParameter(handshakeToken, "handshakeToken");
        return new ModelRemoteAuthHandshake(handshakeToken);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelRemoteAuthHandshake) && Intrinsics3.areEqual(this.handshakeToken, ((ModelRemoteAuthHandshake) other).handshakeToken);
        }
        return true;
    }

    public final String getHandshakeToken() {
        return this.handshakeToken;
    }

    public int hashCode() {
        String str = this.handshakeToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("ModelRemoteAuthHandshake(handshakeToken="), this.handshakeToken, ")");
    }
}
