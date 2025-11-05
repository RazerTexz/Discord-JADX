package com.discord.widgets.guilds.join;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;

/* compiled from: WidgetGuildWelcomeSheetChannelAdapter.kt */
/* loaded from: classes2.dex */
public class BaseChannelViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseChannelViewHolder(View view) {
        super(view);
        m.checkNotNullParameter(view, "itemView");
    }

    public void bind(ChannelItem data) {
        m.checkNotNullParameter(data, "data");
    }
}
