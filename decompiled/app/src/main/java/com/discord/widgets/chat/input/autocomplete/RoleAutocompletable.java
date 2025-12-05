package com.discord.widgets.chat.input.autocomplete;

import com.discord.api.role.GuildRole;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Autocompletable.kt */
/* loaded from: classes2.dex */
public final /* data */ class RoleAutocompletable extends Autocompletable {
    private final boolean canMention;
    private final GuildRole role;
    private final List<String> textMatchers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoleAutocompletable(GuildRole guildRole, boolean z2) {
        super(null);
        Intrinsics3.checkNotNullParameter(guildRole, "role");
        this.role = guildRole;
        this.canMention = z2;
        this.textMatchers = CollectionsJVM.listOf(leadingIdentifier().getIdentifier() + guildRole.getName());
    }

    public static /* synthetic */ RoleAutocompletable copy$default(RoleAutocompletable roleAutocompletable, GuildRole guildRole, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            guildRole = roleAutocompletable.role;
        }
        if ((i & 2) != 0) {
            z2 = roleAutocompletable.canMention;
        }
        return roleAutocompletable.copy(guildRole, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final GuildRole getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanMention() {
        return this.canMention;
    }

    public final RoleAutocompletable copy(GuildRole role, boolean canMention) {
        Intrinsics3.checkNotNullParameter(role, "role");
        return new RoleAutocompletable(role, canMention);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleAutocompletable)) {
            return false;
        }
        RoleAutocompletable roleAutocompletable = (RoleAutocompletable) other;
        return Intrinsics3.areEqual(this.role, roleAutocompletable.role) && this.canMention == roleAutocompletable.canMention;
    }

    public final boolean getCanMention() {
        return this.canMention;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public String getInputReplacement() {
        StringBuilder sbM829Q = outline.m829Q('<');
        sbM829Q.append(leadingIdentifier().getIdentifier());
        sbM829Q.append('&');
        sbM829Q.append(this.role.getId());
        sbM829Q.append('>');
        return sbM829Q.toString();
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public List<String> getInputTextMatchers() {
        return this.textMatchers;
    }

    public final GuildRole getRole() {
        return this.role;
    }

    public final List<String> getTextMatchers() {
        return this.textMatchers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        GuildRole guildRole = this.role;
        int iHashCode = (guildRole != null ? guildRole.hashCode() : 0) * 31;
        boolean z2 = this.canMention;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode + i;
    }

    @Override // com.discord.widgets.chat.input.autocomplete.Autocompletable
    public LeadingIdentifier leadingIdentifier() {
        return LeadingIdentifier.MENTION;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("RoleAutocompletable(role=");
        sbM833U.append(this.role);
        sbM833U.append(", canMention=");
        return outline.m827O(sbM833U, this.canMention, ")");
    }
}
