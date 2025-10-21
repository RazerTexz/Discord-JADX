package com.discord.api.interaction;

import b.d.b.a.outline;
import com.discord.api.botuikit.Component;
import com.discord.api.commands.Application;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.io.Serializable;
import java.util.List;

/* compiled from: InteractionModalCreate.kt */
/* loaded from: classes.dex */
public final /* data */ class InteractionModalCreate implements Serializable {
    private final Application application;
    private final List<Component> components;
    private final String customId;
    private final long id;
    private final String nonce;
    private final String title;

    /* renamed from: a, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final List<Component> b() {
        return this.components;
    }

    /* renamed from: c, reason: from getter */
    public final String getCustomId() {
        return this.customId;
    }

    /* renamed from: d, reason: from getter */
    public final String getNonce() {
        return this.nonce;
    }

    /* renamed from: e, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InteractionModalCreate)) {
            return false;
        }
        InteractionModalCreate interactionModalCreate = (InteractionModalCreate) other;
        return this.id == interactionModalCreate.id && Intrinsics3.areEqual(this.customId, interactionModalCreate.customId) && Intrinsics3.areEqual(this.application, interactionModalCreate.application) && Intrinsics3.areEqual(this.title, interactionModalCreate.title) && Intrinsics3.areEqual(this.components, interactionModalCreate.components) && Intrinsics3.areEqual(this.nonce, interactionModalCreate.nonce);
    }

    public final long getId() {
        return this.id;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.customId;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode2 = (iHashCode + (application != null ? application.hashCode() : 0)) * 31;
        String str2 = this.title;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        List<Component> list = this.components;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        String str3 = this.nonce;
        return iHashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("InteractionModalCreate(id=");
        sbU.append(this.id);
        sbU.append(", customId=");
        sbU.append(this.customId);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", title=");
        sbU.append(this.title);
        sbU.append(", components=");
        sbU.append(this.components);
        sbU.append(", nonce=");
        return outline.J(sbU, this.nonce, ")");
    }
}
