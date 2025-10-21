package com.discord.widgets.chat.list.adapter;

import com.discord.api.user.User;
import com.discord.models.message.Message;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;

/* compiled from: WidgetChatListItem.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListItemKt, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListItem3 {
    /* JADX WARN: Removed duplicated region for block: B:27:0x007d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean isUserMentioned(WidgetChatListAdapter widgetChatListAdapter, Message message) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "$this$isUserMentioned");
        Intrinsics3.checkNotNullParameter(message, "message");
        if (widgetChatListAdapter.getMentionMeMessageLevelHighlighting()) {
            if (Intrinsics3.areEqual(message.getMentionEveryone(), Boolean.TRUE)) {
                return true;
            }
            List<User> mentions = message.getMentions();
            if (mentions != null) {
                Iterator<T> it = mentions.iterator();
                while (it.hasNext()) {
                    if (((User) it.next()).getId() == widgetChatListAdapter.getData().getUserId()) {
                        return true;
                    }
                }
            }
            List<Long> mentionRoles = message.getMentionRoles();
            if (mentionRoles != null) {
                if (mentionRoles.isEmpty()) {
                    z2 = false;
                    if (!z2) {
                        return true;
                    }
                } else {
                    Iterator<T> it2 = mentionRoles.iterator();
                    while (it2.hasNext()) {
                        if (widgetChatListAdapter.getData().getMyRoleIds().contains(Long.valueOf(((Number) it2.next()).longValue()))) {
                            z2 = true;
                            break;
                        }
                    }
                    z2 = false;
                    if (!z2) {
                    }
                }
            }
        }
        return false;
    }
}
