package com.discord.api.message.allowedmentions;

import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

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

    /* renamed from: a */
    public final List<MessageAllowedMentions2> m8060a() {
        return this.parse;
    }

    /* renamed from: b, reason: from getter */
    public final Boolean getRepliedUser() {
        return this.repliedUser;
    }

    /* renamed from: c */
    public final List<Long> m8062c() {
        return this.roles;
    }

    /* renamed from: d */
    public final List<Long> m8063d() {
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
        StringBuilder sbM833U = outline.m833U("MessageAllowedMentions(parse=");
        sbM833U.append(this.parse);
        sbM833U.append(", users=");
        sbM833U.append(this.users);
        sbM833U.append(", roles=");
        sbM833U.append(this.roles);
        sbM833U.append(", repliedUser=");
        return outline.m816D(sbM833U, this.repliedUser, ")");
    }
}
