package com.discord.widgets.voice.feedback.call;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.widgets.feedback.WidgetFeedbackSheet;
import com.discord.widgets.voice.feedback.call.CallFeedbackSheetViewModel;
import java.util.Random;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: CallFeedbackSheetNavigator.kt */
/* loaded from: classes.dex */
public final class CallFeedbackSheetNavigator {
    public static final CallFeedbackSheetNavigator INSTANCE = new CallFeedbackSheetNavigator();
    private static final Random random = new Random();
    private static final Clock clock = ClockFactory.get();

    private CallFeedbackSheetNavigator() {
    }

    public static final /* synthetic */ Clock access$getClock$p(CallFeedbackSheetNavigator callFeedbackSheetNavigator) {
        return clock;
    }

    public static final /* synthetic */ void access$show(CallFeedbackSheetNavigator callFeedbackSheetNavigator, FragmentManager fragmentManager, long j, String str, String str2, Long l) {
        callFeedbackSheetNavigator.show(fragmentManager, j, str, str2, l);
    }

    private final String getNoticeName(String rtcConnectionId) {
        return outline.m883w("Call feedback notice for rtcConnectionId: ", rtcConnectionId);
    }

    private final void show(FragmentManager fragmentManager, long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs) {
        CallFeedbackSheetViewModel.Config config = new CallFeedbackSheetViewModel.Config(channelId, rtcConnectionId, mediaSessionId, callDurationMs);
        WidgetFeedbackSheet widgetFeedbackSheetNewInstance = WidgetFeedbackSheet.INSTANCE.newInstance(WidgetFeedbackSheet.FeedbackType.CALL);
        Bundle arguments = widgetFeedbackSheetNewInstance.getArguments();
        Intrinsics3.checkNotNull(arguments);
        arguments.putParcelable(WidgetFeedbackSheet.ARG_CALL_FEEDBACK_CONFIG, config);
        widgetFeedbackSheetNewInstance.show(fragmentManager, WidgetFeedbackSheet.class.getName());
    }

    public final void enqueueNotice(long channelId, String rtcConnectionId, String mediaSessionId, Long callDurationMs, int triggerRateDenominator) {
        if (triggerRateDenominator < 1 || random.nextInt(triggerRateDenominator) != 0) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        StoreNotices notices = companion.getNotices();
        String noticeName = getNoticeName(rtcConnectionId);
        long jCurrentTimeMillis = clock.currentTimeMillis();
        companion.getNotices().requestToShow(new StoreNotices.Notice(noticeName, null, jCurrentTimeMillis, 0, false, null, 0L, false, 0L, new CallFeedbackSheetNavigator2(jCurrentTimeMillis, channelId, rtcConnectionId, mediaSessionId, callDurationMs, notices, noticeName), Opcodes.GETSTATIC, null));
    }
}
