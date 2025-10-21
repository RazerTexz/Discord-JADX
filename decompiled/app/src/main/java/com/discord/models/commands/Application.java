package com.discord.models.commands;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.user.User;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Application.kt */
/* loaded from: classes.dex */
public final /* data */ class Application {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final User bot;
    private final boolean builtIn;
    private final int commandCount;
    private final String icon;
    private final Integer iconRes;
    private final long id;
    private final String name;

    /* compiled from: Application.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Application fromApiApplication(com.discord.api.application.Application apiApplication) {
            Intrinsics3.checkNotNullParameter(apiApplication, "apiApplication");
            return new Application(apiApplication.getId(), apiApplication.getName(), apiApplication.getIcon(), null, 0, null, false, 104, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Application(long j, String str, String str2, Integer num, int i, User user, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.id = j;
        this.name = str;
        this.icon = str2;
        this.iconRes = num;
        this.commandCount = i;
        this.bot = user;
        this.builtIn = z2;
    }

    public static /* synthetic */ Application copy$default(Application application, long j, String str, String str2, Integer num, int i, User user, boolean z2, int i2, Object obj) {
        return application.copy((i2 & 1) != 0 ? application.id : j, (i2 & 2) != 0 ? application.name : str, (i2 & 4) != 0 ? application.icon : str2, (i2 & 8) != 0 ? application.iconRes : num, (i2 & 16) != 0 ? application.commandCount : i, (i2 & 32) != 0 ? application.bot : user, (i2 & 64) != 0 ? application.builtIn : z2);
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
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getIconRes() {
        return this.iconRes;
    }

    /* renamed from: component5, reason: from getter */
    public final int getCommandCount() {
        return this.commandCount;
    }

    /* renamed from: component6, reason: from getter */
    public final User getBot() {
        return this.bot;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final Application copy(long id2, String name, String icon, Integer iconRes, int commandCount, User bot, boolean builtIn) {
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new Application(id2, name, icon, iconRes, commandCount, bot, builtIn);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Application)) {
            return false;
        }
        Application application = (Application) other;
        return this.id == application.id && Intrinsics3.areEqual(this.name, application.name) && Intrinsics3.areEqual(this.icon, application.icon) && Intrinsics3.areEqual(this.iconRes, application.iconRes) && this.commandCount == application.commandCount && Intrinsics3.areEqual(this.bot, application.bot) && this.builtIn == application.builtIn;
    }

    public final User getBot() {
        return this.bot;
    }

    public final boolean getBuiltIn() {
        return this.builtIn;
    }

    public final int getCommandCount() {
        return this.commandCount;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final Integer getIconRes() {
        return this.iconRes;
    }

    public final long getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int iA = b.a(this.id) * 31;
        String str = this.name;
        int iHashCode = (iA + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.icon;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.iconRes;
        int iHashCode3 = (((iHashCode2 + (num != null ? num.hashCode() : 0)) * 31) + this.commandCount) * 31;
        User user = this.bot;
        int iHashCode4 = (iHashCode3 + (user != null ? user.hashCode() : 0)) * 31;
        boolean z2 = this.builtIn;
        int i = z2;
        if (z2 != 0) {
            i = 1;
        }
        return iHashCode4 + i;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Application(id=");
        sbU.append(this.id);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", icon=");
        sbU.append(this.icon);
        sbU.append(", iconRes=");
        sbU.append(this.iconRes);
        sbU.append(", commandCount=");
        sbU.append(this.commandCount);
        sbU.append(", bot=");
        sbU.append(this.bot);
        sbU.append(", builtIn=");
        return outline.O(sbU, this.builtIn, ")");
    }

    public /* synthetic */ Application(long j, String str, String str2, Integer num, int i, User user, boolean z2, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : num, i, (i2 & 32) != 0 ? null : user, (i2 & 64) != 0 ? false : z2);
    }
}
