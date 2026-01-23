package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.domain.ModelAuditLogEntry;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatInputMentionsTags.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetChatInputMentionsTags<T> {
    private final List<T> tags;
    private final String token;
    private final char tokenIdentifier;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChatInputMentionsTags(List<? extends T> list, char c, String str) {
        Intrinsics3.checkNotNullParameter(list, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        Intrinsics3.checkNotNullParameter(str, "token");
        this.tags = list;
        this.tokenIdentifier = c;
        this.token = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetChatInputMentionsTags copy$default(WidgetChatInputMentionsTags widgetChatInputMentionsTags, List list, char c, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = widgetChatInputMentionsTags.tags;
        }
        if ((i & 2) != 0) {
            c = widgetChatInputMentionsTags.tokenIdentifier;
        }
        if ((i & 4) != 0) {
            str = widgetChatInputMentionsTags.token;
        }
        return widgetChatInputMentionsTags.copy(list, c, str);
    }

    public final List<T> component1() {
        return this.tags;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final char getTokenIdentifier() {
        return this.tokenIdentifier;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final WidgetChatInputMentionsTags<T> copy(List<? extends T> tags, char tokenIdentifier, String token) {
        Intrinsics3.checkNotNullParameter(tags, ModelAuditLogEntry.CHANGE_KEY_TAGS);
        Intrinsics3.checkNotNullParameter(token, "token");
        return new WidgetChatInputMentionsTags<>(tags, tokenIdentifier, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetChatInputMentionsTags)) {
            return false;
        }
        WidgetChatInputMentionsTags widgetChatInputMentionsTags = (WidgetChatInputMentionsTags) other;
        return Intrinsics3.areEqual(this.tags, widgetChatInputMentionsTags.tags) && this.tokenIdentifier == widgetChatInputMentionsTags.tokenIdentifier && Intrinsics3.areEqual(this.token, widgetChatInputMentionsTags.token);
    }

    public final List<T> getTags() {
        return this.tags;
    }

    public final String getToken() {
        return this.token;
    }

    public final char getTokenIdentifier() {
        return this.tokenIdentifier;
    }

    public int hashCode() {
        List<T> list = this.tags;
        int iHashCode = (((list != null ? list.hashCode() : 0) * 31) + this.tokenIdentifier) * 31;
        String str = this.token;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("WidgetChatInputMentionsTags(tags=");
        sbM833U.append(this.tags);
        sbM833U.append(", tokenIdentifier=");
        sbM833U.append(this.tokenIdentifier);
        sbM833U.append(", token=");
        return outline.m822J(sbM833U, this.token, ")");
    }
}
