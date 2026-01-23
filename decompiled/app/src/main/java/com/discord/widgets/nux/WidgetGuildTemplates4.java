package com.discord.widgets.nux;

import com.discord.C5419R;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.widgets.guilds.create.StockGuildTemplate;
import com.discord.widgets.guilds.create.WidgetCreationIntent;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import com.discord.widgets.nux.GuildTemplatesAdapter;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.nux.WidgetGuildTemplates$adapter$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildTemplates.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildTemplates4 implements GuildTemplatesAdapter.Callbacks {
    public final /* synthetic */ WidgetGuildTemplates this$0;

    public WidgetGuildTemplates4(WidgetGuildTemplates widgetGuildTemplates) {
        this.this$0 = widgetGuildTemplates;
    }

    @Override // com.discord.widgets.nux.GuildTemplatesAdapter.Callbacks
    public void onTemplateClick(GuildTemplates guildTemplate) {
        Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
        WidgetGuildCreate.Options options = new WidgetGuildCreate.Options(WidgetGuildTemplates.access$getArgs$p(this.this$0).getLocation(), guildTemplate.getTemplateType(), guildTemplate.getTemplateType() == StockGuildTemplate.CREATE, this.this$0.getString(C5419R.string.guild_create_title), WidgetGuildTemplates.access$getArgs$p(this.this$0).getCloseWithResult());
        if (WidgetGuildTemplates.access$getArgs$p(this.this$0).getGuildTemplate().getSkipCreationIntent()) {
            AnalyticsTracker.openModal$default("Create Guild Step 2", options.getAnalyticsLocation(), null, 4, null);
            WidgetGuildCreate.INSTANCE.showFragment(this.this$0, options);
        } else {
            WidgetGuildTemplates.access$trackPostRegistrationTransition(this.this$0, GuildTemplateAnalytics.STEP_GUILD_TEMPLATE, GuildTemplateAnalytics.STEP_CREATION_INTENT);
            WidgetCreationIntent.Companion companion = WidgetCreationIntent.INSTANCE;
            WidgetGuildTemplates widgetGuildTemplates = this.this$0;
            companion.show(widgetGuildTemplates, WidgetGuildTemplates.access$getArgs$p(widgetGuildTemplates).getTrigger(), options);
        }
    }
}
