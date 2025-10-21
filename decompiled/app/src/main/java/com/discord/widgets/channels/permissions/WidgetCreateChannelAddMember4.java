package com.discord.widgets.channels.permissions;

import com.discord.analytics.generated.events.impression.TrackImpressionChannelAddMembers;
import com.discord.analytics.generated.traits.TrackImpressionMetadata;
import com.discord.analytics.utils.ImpressionGroups;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetCreateChannelAddMember.kt */
/* renamed from: com.discord.widgets.channels.permissions.WidgetCreateChannelAddMember$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetCreateChannelAddMember4 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetCreateChannelAddMember4 INSTANCE = new WidgetCreateChannelAddMember4();

    public WidgetCreateChannelAddMember4() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        TrackImpressionChannelAddMembers trackImpressionChannelAddMembers = new TrackImpressionChannelAddMembers();
        trackImpressionChannelAddMembers.e(new TrackImpressionMetadata(null, null, null, ImpressionGroups.CHANNEL_ADD_FLOW, 7));
        return trackImpressionChannelAddMembers;
    }
}
