package com.discord.widgets.settings.guildboost;

import android.view.View;
import com.discord.widgets.settings.guildboost.SettingsGuildBoostSampleGuildAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsGuildBoostSampleGuildAdapter.kt */
/* renamed from: com.discord.widgets.settings.guildboost.SettingsGuildBoostSampleGuildAdapter$GuildListItem$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class SettingsGuildBoostSampleGuildAdapter2 implements View.OnClickListener {
    public final /* synthetic */ SettingsGuildBoostSampleGuildAdapter.Item $data;
    public final /* synthetic */ SettingsGuildBoostSampleGuildAdapter.GuildListItem this$0;

    public SettingsGuildBoostSampleGuildAdapter2(SettingsGuildBoostSampleGuildAdapter.GuildListItem guildListItem, SettingsGuildBoostSampleGuildAdapter.Item item) {
        this.this$0 = guildListItem;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1Access$getOnGuildClickedListener$p = SettingsGuildBoostSampleGuildAdapter.access$getOnGuildClickedListener$p(SettingsGuildBoostSampleGuildAdapter.GuildListItem.access$getAdapter$p(this.this$0));
        if (function1Access$getOnGuildClickedListener$p != null) {
        }
    }
}
