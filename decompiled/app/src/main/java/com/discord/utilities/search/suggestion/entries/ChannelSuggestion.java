package com.discord.utilities.search.suggestion.entries;

import a0.a.a.b;
import b.d.b.a.a;
import com.discord.utilities.search.suggestion.entries.SearchSuggestion;
import d0.g0.w;
import d0.g0.y;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: ChannelSuggestion.kt */
/* loaded from: classes2.dex */
public final /* data */ class ChannelSuggestion implements SearchSuggestion {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final SearchSuggestion.Category category;
    private final long channelId;
    private final String channelName;

    /* compiled from: ChannelSuggestion.kt */
    public static final class Companion {
        private Companion() {
        }

        public final boolean canComplete(String channelName, CharSequence currentInput) {
            m.checkNotNullParameter(channelName, "channelName");
            m.checkNotNullParameter(currentInput, "currentInput");
            if ((currentInput.length() > 0) && currentInput.charAt(0) == '#') {
                currentInput = y.drop(currentInput, 1);
            }
            return w.contains((CharSequence) channelName, currentInput, true);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ChannelSuggestion(String str, long j) {
        m.checkNotNullParameter(str, "channelName");
        this.channelName = str;
        this.channelId = j;
        this.category = SearchSuggestion.Category.IN_CHANNEL;
    }

    public static /* synthetic */ ChannelSuggestion copy$default(ChannelSuggestion channelSuggestion, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelSuggestion.channelName;
        }
        if ((i & 2) != 0) {
            j = channelSuggestion.channelId;
        }
        return channelSuggestion.copy(str, j);
    }

    /* renamed from: component1, reason: from getter */
    public final String getChannelName() {
        return this.channelName;
    }

    /* renamed from: component2, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    public final ChannelSuggestion copy(String channelName, long channelId) {
        m.checkNotNullParameter(channelName, "channelName");
        return new ChannelSuggestion(channelName, channelId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelSuggestion)) {
            return false;
        }
        ChannelSuggestion channelSuggestion = (ChannelSuggestion) other;
        return m.areEqual(this.channelName, channelSuggestion.channelName) && this.channelId == channelSuggestion.channelId;
    }

    @Override // com.discord.utilities.search.suggestion.entries.SearchSuggestion
    public SearchSuggestion.Category getCategory() {
        return this.category;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final String getChannelName() {
        return this.channelName;
    }

    public int hashCode() {
        String str = this.channelName;
        return b.a(this.channelId) + ((str != null ? str.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("ChannelSuggestion(channelName=");
        sbU.append(this.channelName);
        sbU.append(", channelId=");
        return a.C(sbU, this.channelId, ")");
    }
}
