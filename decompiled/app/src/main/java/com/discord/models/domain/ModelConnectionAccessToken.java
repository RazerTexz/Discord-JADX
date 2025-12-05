package com.discord.models.domain;

import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelConnectionAccessToken.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelConnectionAccessToken {
    private final String accessToken;

    public ModelConnectionAccessToken(String str) {
        Intrinsics3.checkNotNullParameter(str, "accessToken");
        this.accessToken = str;
    }

    public static /* synthetic */ ModelConnectionAccessToken copy$default(ModelConnectionAccessToken modelConnectionAccessToken, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelConnectionAccessToken.accessToken;
        }
        return modelConnectionAccessToken.copy(str);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAccessToken() {
        return this.accessToken;
    }

    public final ModelConnectionAccessToken copy(String accessToken) {
        Intrinsics3.checkNotNullParameter(accessToken, "accessToken");
        return new ModelConnectionAccessToken(accessToken);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ModelConnectionAccessToken) && Intrinsics3.areEqual(this.accessToken, ((ModelConnectionAccessToken) other).accessToken);
        }
        return true;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public int hashCode() {
        String str = this.accessToken;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return outline.m822J(outline.m833U("ModelConnectionAccessToken(accessToken="), this.accessToken, ")");
    }
}
