package com.discord.api.message.allowedmentions;

import b.d.b.a.outline;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: MessageAllowedMentions.kt */
/* loaded from: classes.dex */
public final /* data */ class MessageAllowedMentions {
    private final List<MessageAllowedMentions2> parse;
    private final Boolean repliedUser;
    private final List<Long> roles;
    private final List<Long> users;

    public MessageAllowedMentions() {
        this(null, null, null, null, 15);
    }

    public MessageAllowedMentions(List list, List list2, List list3, Boolean bool, int i) {
        list = (i & 1) != 0 ? null : list;
        int i2 = i & 2;
        int i3 = i & 4;
        bool = (i & 8) != 0 ? null : bool;
        this.parse = list;
        this.users = null;
        this.roles = null;
        this.repliedUser = bool;
    }

    public final List<MessageAllowedMentions2> a() {
        return this.parse;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getRepliedUser() {
        return this.repliedUser;
    }

    public final List<Long> c() {
        return this.roles;
    }

    public final List<Long> d() {
        return this.users;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageAllowedMentions)) {
            return false;
        }
        MessageAllowedMentions messageAllowedMentions = (MessageAllowedMentions) other;
        return Intrinsics3.areEqual(this.parse, messageAllowedMentions.parse) && Intrinsics3.areEqual(this.users, messageAllowedMentions.users) && Intrinsics3.areEqual(this.roles, messageAllowedMentions.roles) && Intrinsics3.areEqual(this.repliedUser, messageAllowedMentions.repliedUser);
    }

    public int hashCode() {
        List<MessageAllowedMentions2> list = this.parse;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<Long> list2 = this.users;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<Long> list3 = this.roles;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        Boolean bool = this.repliedUser;
        return iHashCode3 + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("MessageAllowedMentions(parse=");
        sbU.append(this.parse);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", repliedUser=");
        return outline.D(sbU, this.repliedUser, ")");
    }
}
