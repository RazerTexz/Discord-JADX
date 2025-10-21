package com.discord.widgets.guildscheduledevent;

import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.fragment.app.Fragment;
import com.discord.api.channel.Channel;
import com.discord.app.AppBottomSheet;
import com.discord.app.AppFragment;
import com.discord.stores.StoreStream;
import com.discord.utilities.intent.IntentUtilsKt;
import com.discord.widgets.voice.VoiceUtils;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetPreviewGuildScheduledEvent.kt */
/* renamed from: com.discord.widgets.guildscheduledevent.WidgetPreviewGuildScheduledEvent$Companion$createJoinOnStartActivityRegistration$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPreviewGuildScheduledEvent2<O> implements ActivityResultCallback<ActivityResult> {
    public final /* synthetic */ Fragment $fragment;
    public final /* synthetic */ Function0 $onEventStarted;

    public WidgetPreviewGuildScheduledEvent2(Fragment fragment, Function0 function0) {
        this.$fragment = fragment;
        this.$onEventStarted = function0;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public /* bridge */ /* synthetic */ void onActivityResult(ActivityResult activityResult) {
        onActivityResult2(activityResult);
    }

    /* renamed from: onActivityResult, reason: avoid collision after fix types in other method */
    public final void onActivityResult2(ActivityResult activityResult) {
        Intent data;
        Long longExtraOrNull;
        Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
        if (activityResult.getResultCode() != -1 || (data = activityResult.getData()) == null || (longExtraOrNull = IntentUtilsKt.getLongExtraOrNull(data, "com.discord.intent.extra.EXTRA_CHANNEL_ID")) == null) {
            return;
        }
        Channel channel = StoreStream.INSTANCE.getChannels().getChannel(longExtraOrNull.longValue());
        if (channel != null) {
            Fragment fragment = this.$fragment;
            if (fragment instanceof AppFragment) {
                VoiceUtils.handleConnectToEventChannel(channel, (AppFragment) fragment, (Function0<Unit>) this.$onEventStarted);
            } else if (fragment instanceof AppBottomSheet) {
                VoiceUtils.handleConnectToEventChannel(channel, (AppBottomSheet) fragment, (Function0<Unit>) this.$onEventStarted);
            }
        }
    }
}
