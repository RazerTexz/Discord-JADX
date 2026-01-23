package com.discord.widgets.guilds.invite;

import android.content.res.Resources;
import com.discord.utilities.intent.IntentUtilsKt;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShare$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare7 extends Lambda implements Function0<WidgetGuildInviteShareViewModel> {
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShare7(WidgetGuildInviteShare widgetGuildInviteShare) {
        super(0);
        this.this$0 = widgetGuildInviteShare;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGuildInviteShareViewModel invoke() {
        long longExtra = this.this$0.getMostRecentIntent().getLongExtra("com.discord.intent.extra.EXTRA_GUILD_ID", 0L);
        Long longExtraOrNull = IntentUtilsKt.getLongExtraOrNull(this.this$0.getMostRecentIntent(), "com.discord.intent.extra.EXTRA_GUILD_SCHEDULED_EVENT_ID");
        String stringExtra = this.this$0.getMostRecentIntent().getStringExtra(WidgetGuildInviteShare.INTENT_INVITE_STORE_KEY);
        Resources resources = this.this$0.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        return new WidgetGuildInviteShareViewModel(null, null, null, null, null, null, null, null, null, resources, false, longExtra, longExtraOrNull, stringExtra, 1535, null);
    }
}
