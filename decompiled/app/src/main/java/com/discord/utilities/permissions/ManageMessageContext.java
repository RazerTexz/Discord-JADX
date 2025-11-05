package com.discord.utilities.permissions;

import b.d.b.a.a;
import com.discord.api.permission.Permission;
import com.discord.api.sticker.Sticker;
import com.discord.api.sticker.StickerPartial;
import com.discord.api.user.User;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: PermissionsContexts.kt */
/* loaded from: classes2.dex */
public final /* data */ class ManageMessageContext {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final boolean canAddReactions;
    private final boolean canDelete;
    private final boolean canEdit;
    private final boolean canManageMessages;
    private final boolean canMarkUnread;
    private final boolean canTogglePinned;

    /* compiled from: PermissionsContexts.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Removed duplicated region for block: B:48:0x0082  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final ManageMessageContext from(Message message, Long myPermissions, MeUser meUser, Integer guildMfaLevel, boolean isPrivateChannel, boolean isSystemDM, boolean isArchivedThread) {
            boolean z2;
            m.checkNotNullParameter(message, "message");
            m.checkNotNullParameter(meUser, "meUser");
            boolean zIsUserMessage = message.isUserMessage();
            User author = message.getAuthor();
            boolean z3 = false;
            boolean z4 = author != null && author.getId() == meUser.getId();
            boolean z5 = isPrivateChannel && !isSystemDM;
            boolean z6 = (guildMfaLevel == null || !PermissionUtils.canAndIsElevated(Permission.MANAGE_MESSAGES, myPermissions, meUser.getMfaEnabled(), guildMfaLevel.intValue()) || isArchivedThread) ? false : true;
            boolean z7 = z6 || z5;
            boolean z8 = z6 || z4;
            if (z4 && zIsUserMessage) {
                List<Sticker> stickers = message.getStickers();
                if (stickers == null || stickers.isEmpty()) {
                    List<StickerPartial> stickerItems = message.getStickerItems();
                    if ((stickerItems == null || stickerItems.isEmpty()) && !isArchivedThread) {
                        z2 = true;
                    }
                }
            } else {
                z2 = false;
            }
            boolean z9 = z8 && !isArchivedThread && PermissionsContextsKt.isDeleteable(message);
            boolean z10 = !message.isLocal() && (z5 || PermissionUtils.can(64L, myPermissions)) && !isArchivedThread;
            if (z7 && zIsUserMessage && !isSystemDM && !isArchivedThread) {
                z3 = true;
            }
            return new ManageMessageContext(z6, z2, z9, z10, z3, !isArchivedThread);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ManageMessageContext(boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.canManageMessages = z2;
        this.canEdit = z3;
        this.canDelete = z4;
        this.canAddReactions = z5;
        this.canTogglePinned = z6;
        this.canMarkUnread = z7;
    }

    public static /* synthetic */ ManageMessageContext copy$default(ManageMessageContext manageMessageContext, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = manageMessageContext.canManageMessages;
        }
        if ((i & 2) != 0) {
            z3 = manageMessageContext.canEdit;
        }
        boolean z8 = z3;
        if ((i & 4) != 0) {
            z4 = manageMessageContext.canDelete;
        }
        boolean z9 = z4;
        if ((i & 8) != 0) {
            z5 = manageMessageContext.canAddReactions;
        }
        boolean z10 = z5;
        if ((i & 16) != 0) {
            z6 = manageMessageContext.canTogglePinned;
        }
        boolean z11 = z6;
        if ((i & 32) != 0) {
            z7 = manageMessageContext.canMarkUnread;
        }
        return manageMessageContext.copy(z2, z8, z9, z10, z11, z7);
    }

    public static final ManageMessageContext from(Message message, Long l, MeUser meUser, Integer num, boolean z2, boolean z3, boolean z4) {
        return INSTANCE.from(message, l, meUser, num, z2, z3, z4);
    }

    /* renamed from: component1, reason: from getter */
    public final boolean getCanManageMessages() {
        return this.canManageMessages;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanEdit() {
        return this.canEdit;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getCanDelete() {
        return this.canDelete;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getCanTogglePinned() {
        return this.canTogglePinned;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getCanMarkUnread() {
        return this.canMarkUnread;
    }

    public final ManageMessageContext copy(boolean canManageMessages, boolean canEdit, boolean canDelete, boolean canAddReactions, boolean canTogglePinned, boolean canMarkUnread) {
        return new ManageMessageContext(canManageMessages, canEdit, canDelete, canAddReactions, canTogglePinned, canMarkUnread);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ManageMessageContext)) {
            return false;
        }
        ManageMessageContext manageMessageContext = (ManageMessageContext) other;
        return this.canManageMessages == manageMessageContext.canManageMessages && this.canEdit == manageMessageContext.canEdit && this.canDelete == manageMessageContext.canDelete && this.canAddReactions == manageMessageContext.canAddReactions && this.canTogglePinned == manageMessageContext.canTogglePinned && this.canMarkUnread == manageMessageContext.canMarkUnread;
    }

    public final boolean getCanAddReactions() {
        return this.canAddReactions;
    }

    public final boolean getCanDelete() {
        return this.canDelete;
    }

    public final boolean getCanEdit() {
        return this.canEdit;
    }

    public final boolean getCanManageMessages() {
        return this.canManageMessages;
    }

    public final boolean getCanMarkUnread() {
        return this.canMarkUnread;
    }

    public final boolean getCanTogglePinned() {
        return this.canTogglePinned;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v2, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v6, types: [boolean] */
    public int hashCode() {
        boolean z2 = this.canManageMessages;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        ?? r2 = this.canEdit;
        int i2 = r2;
        if (r2 != 0) {
            i2 = 1;
        }
        int i3 = (i + i2) * 31;
        ?? r22 = this.canDelete;
        int i4 = r22;
        if (r22 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        ?? r23 = this.canAddReactions;
        int i6 = r23;
        if (r23 != 0) {
            i6 = 1;
        }
        int i7 = (i5 + i6) * 31;
        ?? r24 = this.canTogglePinned;
        int i8 = r24;
        if (r24 != 0) {
            i8 = 1;
        }
        int i9 = (i7 + i8) * 31;
        boolean z3 = this.canMarkUnread;
        return i9 + (z3 ? 1 : z3 ? 1 : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ManageMessageContext(canManageMessages=");
        sbU.append(this.canManageMessages);
        sbU.append(", canEdit=");
        sbU.append(this.canEdit);
        sbU.append(", canDelete=");
        sbU.append(this.canDelete);
        sbU.append(", canAddReactions=");
        sbU.append(this.canAddReactions);
        sbU.append(", canTogglePinned=");
        sbU.append(this.canTogglePinned);
        sbU.append(", canMarkUnread=");
        return a.O(sbU, this.canMarkUnread, ")");
    }
}
