package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.ModelBan;
import com.discord.widgets.servers.WidgetServerSettingsBans;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.servers.WidgetServerSettingsBans$Adapter$BanListItem$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsBans2 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsBans.Model.BanItem $data;
    public final /* synthetic */ WidgetServerSettingsBans.Adapter.BanListItem this$0;

    public WidgetServerSettingsBans2(WidgetServerSettingsBans.Adapter.BanListItem banListItem, WidgetServerSettingsBans.Model.BanItem banItem) {
        this.this$0 = banListItem;
        this.$data = banItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1<ModelBan, Unit> onBanSelectedListener;
        ModelBan ban = this.$data.getBan();
        if (ban == null || (onBanSelectedListener = WidgetServerSettingsBans.Adapter.BanListItem.access$getAdapter$p(this.this$0).getOnBanSelectedListener()) == null) {
            return;
        }
        onBanSelectedListener.invoke(ban);
    }
}
