package com.discord.models.domain.emoji;

import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* compiled from: ModelEmojiGuild.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelEmojiGuild {
    private final boolean animated;
    private final boolean available;
    private final long id;
    private final boolean managed;
    private final String name;
    private final boolean requiredColons;
    private final List<Long> roles;
    private final User user;

    public ModelEmojiGuild(long j, String str, boolean z2, List<Long> list, boolean z3, User user, boolean z4, boolean z5) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(list, "roles");
        Intrinsics3.checkNotNullParameter(user, "user");
        this.id = j;
        this.name = str;
        this.managed = z2;
        this.roles = list;
        this.requiredColons = z3;
        this.user = user;
        this.animated = z4;
        this.available = z5;
    }

    public static /* synthetic */ ModelEmojiGuild copy$default(ModelEmojiGuild modelEmojiGuild, long j, String str, boolean z2, List list, boolean z3, User user, boolean z4, boolean z5, int i, Object obj) {
        return modelEmojiGuild.copy((i & 1) != 0 ? modelEmojiGuild.id : j, (i & 2) != 0 ? modelEmojiGuild.name : str, (i & 4) != 0 ? modelEmojiGuild.managed : z2, (i & 8) != 0 ? modelEmojiGuild.roles : list, (i & 16) != 0 ? modelEmojiGuild.requiredColons : z3, (i & 32) != 0 ? modelEmojiGuild.user : user, (i & 64) != 0 ? modelEmojiGuild.animated : z4, (i & 128) != 0 ? modelEmojiGuild.available : z5);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getManaged() {
        return this.managed;
    }

    public final List<Long> component4() {
        return this.roles;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getRequiredColons() {
        return this.requiredColons;
    }

    /* renamed from: component6, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getAnimated() {
        return this.animated;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getAvailable() {
        return this.available;
    }

    public final ModelEmojiGuild copy(long id2, String name, boolean managed, List<Long> roles, boolean requiredColons, User user, boolean animated, boolean available) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(user, "user");
        return new ModelEmojiGuild(id2, name, managed, roles, requiredColons, user, animated, available);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelEmojiGuild)) {
            return false;
        }
        ModelEmojiGuild modelEmojiGuild = (ModelEmojiGuild) other;
        return this.id == modelEmojiGuild.id && Intrinsics3.areEqual(this.name, modelEmojiGuild.name) && this.managed == modelEmojiGuild.managed && Intrinsics3.areEqual(this.roles, modelEmojiGuild.roles) && this.requiredColons == modelEmojiGuild.requiredColons && Intrinsics3.areEqual(this.user, modelEmojiGuild.user) && this.animated == modelEmojiGuild.animated && this.available == modelEmojiGuild.available;
    }

    public final boolean getAnimated() {
        return this.animated;
    }

    public final boolean getAvailable() {
        return this.available;
    }

    public final long getId() {
        return this.id;
    }

    public final boolean getManaged() {
        return this.managed;
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getRequiredColons() {
        return this.requiredColons;
    }

    public final List<Long> getRoles() {
        return this.roles;
    }

    public final User getUser() {
        return this.user;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.managed;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        int i3 = (iHashCode + i2) * 31;
        List<Long> list = this.roles;
        int iHashCode2 = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        boolean z3 = this.requiredColons;
        int i4 = z3;
        if (z3 != 0) {
            i4 = 1;
        }
        int i5 = (iHashCode2 + i4) * 31;
        User user = this.user;
        int iHashCode3 = (i5 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z4 = this.animated;
        int i6 = z4;
        if (z4 != 0) {
            i6 = 1;
        }
        int i7 = (iHashCode3 + i6) * 31;
        boolean z5 = this.available;
        return i7 + (z5 ? 1 : z5 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ModelEmojiGuild(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", managed=");
        sbU.append(this.managed);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", requiredColons=");
        sbU.append(this.requiredColons);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", animated=");
        sbU.append(this.animated);
        sbU.append(", available=");
        return outline.O(sbU, this.available, ")");
    }
}
