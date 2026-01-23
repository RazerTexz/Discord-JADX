package com.discord.utilities.guildscheduledevent;

import android.content.Context;
import android.text.format.DateUtils;
import com.discord.C5419R;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventModel;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt, reason: use source file name */
/* JADX INFO: compiled from: GuildScheduledEventUtilities.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventUtilities5 {
    public static final int DATE_FORMAT_FLAGS = 101139;

    /* JADX INFO: renamed from: com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        static {
            GuildScheduledEventEntityType.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GuildScheduledEventEntityType.EXTERNAL.ordinal()] = 1;
            GuildScheduledEventUtilities2.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities2 = GuildScheduledEventUtilities2.LIVE;
            iArr2[guildScheduledEventUtilities2.ordinal()] = 1;
            iArr2[GuildScheduledEventUtilities2.EXPIRED.ordinal()] = 2;
            iArr2[GuildScheduledEventUtilities2.NOW.ordinal()] = 3;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities22 = GuildScheduledEventUtilities2.SOON;
            iArr2[guildScheduledEventUtilities22.ordinal()] = 4;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities23 = GuildScheduledEventUtilities2.TODAY;
            iArr2[guildScheduledEventUtilities23.ordinal()] = 5;
            GuildScheduledEventUtilities2 guildScheduledEventUtilities24 = GuildScheduledEventUtilities2.TOMORROW;
            iArr2[guildScheduledEventUtilities24.ordinal()] = 6;
            GuildScheduledEventUtilities2.values();
            int[] iArr3 = new int[7];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[guildScheduledEventUtilities2.ordinal()] = 1;
            iArr3[guildScheduledEventUtilities22.ordinal()] = 2;
            iArr3[guildScheduledEventUtilities23.ordinal()] = 3;
            GuildScheduledEventUtilities2.values();
            int[] iArr4 = new int[7];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[guildScheduledEventUtilities24.ordinal()] = 1;
            iArr4[GuildScheduledEventUtilities2.LATER.ordinal()] = 2;
        }
    }

    public static final boolean canRsvp(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "$this$canRsvp");
        return (getEventTiming(guildScheduledEvent) == GuildScheduledEventUtilities2.LIVE || guildScheduledEvent.getStatus() == GuildScheduledEventStatus.COMPLETED) ? false : true;
    }

    public static final UserGuildMember getCreatorUserGuildMember(GuildScheduledEvent guildScheduledEvent, StoreGuilds storeGuilds, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "$this$getCreatorUserGuildMember");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Long creatorId = guildScheduledEvent.getCreatorId();
        if (creatorId == null) {
            return null;
        }
        long jLongValue = creatorId.longValue();
        User user = storeUser.getUsers(CollectionsJVM.listOf(Long.valueOf(jLongValue)), false).get(Long.valueOf(jLongValue));
        if (user != null) {
            return new UserGuildMember(user, storeGuilds.getMember(guildScheduledEvent.getGuildId(), jLongValue));
        }
        return null;
    }

    public static /* synthetic */ UserGuildMember getCreatorUserGuildMember$default(GuildScheduledEvent guildScheduledEvent, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        if ((i & 2) != 0) {
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        return getCreatorUserGuildMember(guildScheduledEvent, storeGuilds, storeUser);
    }

    public static final CharSequence getEventEndingTimeString(Context context, long j, long j2, GuildScheduledEventStatus guildScheduledEventStatus) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guildScheduledEventStatus, "status");
        if (!isSameDay(j, j2)) {
            return null;
        }
        if (!DateUtils.isToday(j2)) {
            int iOrdinal = getEventTiming(j, guildScheduledEventStatus).ordinal();
            if (iOrdinal == 0 || iOrdinal == 1) {
                return DateUtils.formatDateTime(context, j2, DATE_FORMAT_FLAGS);
            }
            return null;
        }
        int iOrdinal2 = getEventTiming(j, guildScheduledEventStatus).ordinal();
        if (iOrdinal2 == 2 || iOrdinal2 == 3 || iOrdinal2 == 5) {
            return FormatUtils.m216h(context, C5419R.string.ending_on_date, new Object[]{DateUtils.formatDateTime(context, j2, DATE_FORMAT_FLAGS)}, null, 4);
        }
        return null;
    }

    public static final CharSequence getEventStartingTimeString(GuildScheduledEvent guildScheduledEvent, Context context) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "$this$getEventStartingTimeString");
        Intrinsics3.checkNotNullParameter(context, "context");
        return getEventStartingTimeString(context, guildScheduledEvent.getScheduledStartTime().getDateTimeMillis(), guildScheduledEvent.getEntityType(), guildScheduledEvent.getStatus());
    }

    public static final GuildScheduledEventUtilities2 getEventTiming(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "$this$getEventTiming");
        return getEventTiming(guildScheduledEvent.getScheduledStartTime().getDateTimeMillis(), guildScheduledEvent.getStatus());
    }

    public static final GuildScheduledEvent getLiveEvent(Collection<GuildScheduledEvent> collection) {
        Object next;
        Intrinsics3.checkNotNullParameter(collection, "$this$getLiveEvent");
        Iterator<T> it = collection.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (getEventTiming((GuildScheduledEvent) next) == GuildScheduledEventUtilities2.LIVE) {
                break;
            }
        }
        return (GuildScheduledEvent) next;
    }

    private static final CharSequence getNonRelativeTimeString(long j, Context context) {
        String dateTime = DateUtils.formatDateTime(context, j, DATE_FORMAT_FLAGS);
        Intrinsics3.checkNotNullExpressionValue(dateTime, "DateUtils.formatDateTime… this, DATE_FORMAT_FLAGS)");
        return dateTime;
    }

    public static final boolean hasLiveEvent(Collection<GuildScheduledEvent> collection) {
        Intrinsics3.checkNotNullParameter(collection, "$this$hasLiveEvent");
        return getLiveEvent(collection) != null;
    }

    private static final boolean isSameDay(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        Intrinsics3.checkNotNullExpressionValue(calendar, "eventCalendar");
        calendar.setTimeInMillis(j);
        Intrinsics3.checkNotNullExpressionValue(calendar2, "nowCalendar");
        calendar2.setTimeInMillis(j2);
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    public static final int minutesRelativeToTime(long j) {
        TimeUtils timeUtils = TimeUtils.INSTANCE;
        int minutesFromMillis = timeUtils.getMinutesFromMillis(j - ClockFactory.get().currentTimeMillis());
        return minutesFromMillis != 0 ? minutesFromMillis : timeUtils.getMinutesFromMillis(ClockFactory.get().currentTimeMillis() - j) * (-1);
    }

    public static final CharSequence getEventStartingTimeString(Context context, long j, GuildScheduledEventEntityType guildScheduledEventEntityType, GuildScheduledEventStatus guildScheduledEventStatus) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(guildScheduledEventEntityType, "entityType");
        Intrinsics3.checkNotNullParameter(guildScheduledEventStatus, "status");
        GuildScheduledEventUtilities2 eventTiming = getEventTiming(j, guildScheduledEventStatus);
        Objects.requireNonNull(GuildScheduledEventStatus.INSTANCE);
        if (GuildScheduledEventStatus.access$getDONE$cp().contains(guildScheduledEventStatus)) {
            return getNonRelativeTimeString(j, context);
        }
        switch (eventTiming.ordinal()) {
            case 1:
            case 2:
                return FormatUtils.m216h(context, C5419R.string.guild_event_date_at_time, new Object[]{DateUtils.getRelativeTimeSpanString(j, ClockFactory.get().currentTimeMillis(), 86400000L), DateUtils.formatDateTime(context, j, DATE_FORMAT_FLAGS)}, null, 4);
            case 3:
                return FormatUtils.m216h(context, C5419R.string.starting_in_minutes, new Object[]{Integer.valueOf(minutesRelativeToTime(j))}, null, 4);
            case 4:
            case 6:
                return FormatUtils.m216h(context, C5419R.string.starting_soon, new Object[0], null, 4);
            case 5:
                return guildScheduledEventEntityType.ordinal() != 3 ? FormatUtils.m216h(context, C5419R.string.stage_channel_live_now, new Object[0], null, 4) : FormatUtils.m216h(context, C5419R.string.active_now, new Object[0], null, 4);
            default:
                return getNonRelativeTimeString(j, context);
        }
    }

    public static final GuildScheduledEventUtilities2 getEventTiming(long j, GuildScheduledEventStatus guildScheduledEventStatus) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventStatus, "status");
        if (guildScheduledEventStatus == GuildScheduledEventStatus.ACTIVE) {
            return GuildScheduledEventUtilities2.LIVE;
        }
        int iMinutesRelativeToTime = minutesRelativeToTime(j);
        return iMinutesRelativeToTime <= -60 ? GuildScheduledEventUtilities2.EXPIRED : iMinutesRelativeToTime <= 0 ? GuildScheduledEventUtilities2.NOW : iMinutesRelativeToTime <= 15 ? GuildScheduledEventUtilities2.SOON : DateUtils.isToday(j) ? GuildScheduledEventUtilities2.TODAY : DateUtils.isToday(j - 86400000) ? GuildScheduledEventUtilities2.TOMORROW : GuildScheduledEventUtilities2.LATER;
    }

    public static /* synthetic */ UserGuildMember getCreatorUserGuildMember$default(GuildScheduledEventModel guildScheduledEventModel, StoreGuilds storeGuilds, StoreUser storeUser, int i, Object obj) {
        if ((i & 1) != 0) {
            storeGuilds = StoreStream.INSTANCE.getGuilds();
        }
        if ((i & 2) != 0) {
            storeUser = StoreStream.INSTANCE.getUsers();
        }
        return getCreatorUserGuildMember(guildScheduledEventModel, storeGuilds, storeUser);
    }

    public static final UserGuildMember getCreatorUserGuildMember(GuildScheduledEventModel guildScheduledEventModel, StoreGuilds storeGuilds, StoreUser storeUser) {
        Intrinsics3.checkNotNullParameter(guildScheduledEventModel, "$this$getCreatorUserGuildMember");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "usersStore");
        Long creatorId = guildScheduledEventModel.getCreatorId();
        if (creatorId == null) {
            return null;
        }
        long jLongValue = creatorId.longValue();
        User user = storeUser.getUsers(CollectionsJVM.listOf(Long.valueOf(jLongValue)), false).get(Long.valueOf(jLongValue));
        if (user != null) {
            return new UserGuildMember(user, storeGuilds.getMember(guildScheduledEventModel.getGuildId(), jLongValue));
        }
        return null;
    }
}
