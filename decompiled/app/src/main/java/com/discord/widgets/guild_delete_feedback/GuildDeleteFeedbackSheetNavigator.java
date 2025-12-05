package com.discord.widgets.guild_delete_feedback;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: GuildDeleteFeedbackSheetNavigator.kt */
/* loaded from: classes2.dex */
public final class GuildDeleteFeedbackSheetNavigator {
    public static final GuildDeleteFeedbackSheetNavigator INSTANCE = new GuildDeleteFeedbackSheetNavigator();
    private static final Clock clock = ClockFactory.get();

    private GuildDeleteFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(GuildDeleteFeedbackSheetNavigator guildDeleteFeedbackSheetNavigator, FragmentManager fragmentManager, long j) {
        guildDeleteFeedbackSheetNavigator.show(fragmentManager, j);
    }

    private final void show(FragmentManager fragmentManager, long guildId) {
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.INSTANCE.newInstance(WidgetFeedbackSheet.FeedbackType.GUILD_DELETE);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        Intrinsics3.checkNotNull(arguments);
        arguments.putLong(WidgetFeedbackSheet.ARG_GUILD_DELETE_FEEDBACK_GUILD_ID, guildId);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long guildId) {
        StoreNotices notices = StoreStream.INSTANCE.getNotices();
        String strM877t = outline.m877t("Delete Guild Feedback for ", guildId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        notices.requestToShow(new StoreNotices.Notice(strM877t, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new GuildDeleteFeedbackSheetNavigator2(jCurrentTimeMillis, guildId, notices, strM877t), Opcodes.GETSTATIC, null));
    }
}
