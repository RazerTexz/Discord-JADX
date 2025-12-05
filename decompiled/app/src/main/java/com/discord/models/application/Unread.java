package com.discord.models.application;

import com.discord.models.message.Message;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.ReversedViews3;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Unread.kt */
/* loaded from: classes.dex */
public final /* data */ class Unread {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int count;
    private final Marker marker;

    /* compiled from: Unread.kt */
    public static final class Companion {
        private Companion() {
        }

        public static final /* synthetic */ int access$getTotalMessages(Companion companion, Marker marker, List list) {
            return companion.getTotalMessages(marker, list);
        }

        private final int getTotalMessages(Marker marker, List<Message> messages) {
            int i = 0;
            if (!messages.isEmpty() && marker.getMessageId() != null) {
                Iterator it = ReversedViews3.asReversed(messages).iterator();
                while (it.hasNext()) {
                    long id2 = ((Message) it.next()).getId();
                    Long messageId = marker.getMessageId();
                    if (messageId != null && id2 == messageId.longValue()) {
                        return i;
                    }
                    i++;
                }
            }
            return i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Unread.kt */
    public static final /* data */ class Marker {
        private final long channelId;
        private final Long messageId;

        public Marker(long j, Long l) {
            this.channelId = j;
            this.messageId = l;
        }

        public static /* synthetic */ Marker copy$default(Marker marker, long j, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                j = marker.channelId;
            }
            if ((i & 2) != 0) {
                l = marker.messageId;
            }
            return marker.copy(j, l);
        }

        /* renamed from: component1, reason: from getter */
        public final long getChannelId() {
            return this.channelId;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getMessageId() {
            return this.messageId;
        }

        public final Marker copy(long channelId, Long messageId) {
            return new Marker(channelId, messageId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Marker)) {
                return false;
            }
            Marker marker = (Marker) other;
            return this.channelId == marker.channelId && Intrinsics3.areEqual(this.messageId, marker.messageId);
        }

        public final long getChannelId() {
            return this.channelId;
        }

        public final Long getMessageId() {
            return this.messageId;
        }

        public int hashCode() {
            int iM3a = C0002b.m3a(this.channelId) * 31;
            Long l = this.messageId;
            return iM3a + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = outline.m833U("Marker(channelId=");
            sbM833U.append(this.channelId);
            sbM833U.append(", messageId=");
            return outline.m819G(sbM833U, this.messageId, ")");
        }

        public Marker() {
            this(0L, 0L);
        }

        public Marker(long j, long j2, Long l) {
            this(j, (l == null || l.longValue() != j2) ? Long.valueOf(j2) : null);
        }
    }

    public Unread() {
        this(null, 0, 3, null);
    }

    public Unread(Marker marker) {
        this(marker, 0, 2, null);
    }

    public Unread(Marker marker, int i) {
        Intrinsics3.checkNotNullParameter(marker, "marker");
        this.marker = marker;
        this.count = i;
    }

    public static /* synthetic */ Unread copy$default(Unread unread, Marker marker, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            marker = unread.marker;
        }
        if ((i2 & 2) != 0) {
            i = unread.count;
        }
        return unread.copy(marker, i);
    }

    /* renamed from: component1, reason: from getter */
    public final Marker getMarker() {
        return this.marker;
    }

    /* renamed from: component2, reason: from getter */
    public final int getCount() {
        return this.count;
    }

    public final Unread copy(Marker marker, int count) {
        Intrinsics3.checkNotNullParameter(marker, "marker");
        return new Unread(marker, count);
    }

    public final Unread createWithEmptyCount() {
        return new Unread(this.marker, 0);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Unread)) {
            return false;
        }
        Unread unread = (Unread) other;
        return Intrinsics3.areEqual(this.marker, unread.marker) && this.count == unread.count;
    }

    public final int getCount() {
        return this.count;
    }

    public final Marker getMarker() {
        return this.marker;
    }

    public int hashCode() {
        Marker marker = this.marker;
        return ((marker != null ? marker.hashCode() : 0) * 31) + this.count;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Unread(marker=");
        sbM833U.append(this.marker);
        sbM833U.append(", count=");
        return outline.m814B(sbM833U, this.count, ")");
    }

    public /* synthetic */ Unread(Marker marker, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? new Marker() : marker, (i2 & 2) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Unread(Marker marker, List<Message> list) {
        this(marker, Companion.access$getTotalMessages(INSTANCE, marker, list));
        Intrinsics3.checkNotNullParameter(marker, "marker");
        Intrinsics3.checkNotNullParameter(list, "messages");
    }
}
