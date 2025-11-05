package com.discord.widgets.servers;

import android.view.View;
import com.discord.widgets.servers.SettingsChannelListAdapter;
import kotlin.jvm.functions.Function1;

/* compiled from: SettingsChannelListAdapter.kt */
/* loaded from: classes2.dex */
public final class SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1 implements View.OnClickListener {
    public final /* synthetic */ SettingsChannelListAdapter.CategoryItem $it$inlined;
    public final /* synthetic */ Function1 $onClick;
    public final /* synthetic */ SettingsChannelListAdapter.CategoryListItem this$0;

    public SettingsChannelListAdapter$CategoryListItem$onConfigure$$inlined$let$lambda$1(Function1 function1, SettingsChannelListAdapter.CategoryItem categoryItem, SettingsChannelListAdapter.CategoryListItem categoryListItem) {
        this.$onClick = function1;
        this.$it$inlined = categoryItem;
        this.this$0 = categoryListItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$onClick.invoke(Long.valueOf(this.$it$inlined.getId()));
    }
}
