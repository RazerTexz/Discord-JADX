package com.discord.widgets.guilds.invite;

import com.discord.analytics.generated.events.impression.TrackImpressionGuildInviteLinkSettings;
import com.discord.api.science.AnalyticsSchema;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetGuildInviteSettings.kt */
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteSettings$loggingConfig$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteSettings5 extends Lambda implements Function0<AnalyticsSchema> {
    public static final WidgetGuildInviteSettings5 INSTANCE = new WidgetGuildInviteSettings5();

    public WidgetGuildInviteSettings5() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AnalyticsSchema invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AnalyticsSchema invoke() {
        return new TrackImpressionGuildInviteLinkSettings();
    }
}
