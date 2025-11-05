package com.discord.utilities.guildscheduledevent;

import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import java.util.Comparator;

/* compiled from: GuildScheduledEventUtilities.kt */
/* renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventsComparator, reason: use source file name */
/* loaded from: classes2.dex */
public final class GuildScheduledEventUtilities6 implements Comparator<GuildScheduledEvent> {
    public static final GuildScheduledEventUtilities6 INSTANCE = new GuildScheduledEventUtilities6();

    private GuildScheduledEventUtilities6() {
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(GuildScheduledEvent guildScheduledEvent, GuildScheduledEvent guildScheduledEvent2) {
        return compare2(guildScheduledEvent, guildScheduledEvent2);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* renamed from: compare, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int compare2(GuildScheduledEvent o1, GuildScheduledEvent o2) {
        GuildScheduledEventStatus status = o1 != null ? o1.getStatus() : null;
        GuildScheduledEventStatus guildScheduledEventStatus = GuildScheduledEventStatus.ACTIVE;
        if (status != guildScheduledEventStatus) {
            if ((o1 != null ? o1.getStatus() : null) != guildScheduledEventStatus) {
                if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
                    return 1;
                }
            }
            if (o1 != null && o2 != null) {
                return o1.getScheduledStartTime().f(o2.getScheduledStartTime());
            }
            if (o1 == null) {
                return 1;
            }
            if (o2 != null) {
                return 0;
            }
        } else {
            if ((o2 != null ? o2.getStatus() : null) == guildScheduledEventStatus) {
            }
        }
        return -1;
    }
}
