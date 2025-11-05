package com.discord.widgets.guilds.profile;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* loaded from: classes2.dex */
public class BaseEmojiViewHolder extends RecyclerView.ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseEmojiViewHolder(View view) {
        super(view);
        m.checkNotNullParameter(view, "itemView");
    }

    public void bind(EmojiItem data) {
        m.checkNotNullParameter(data, "data");
    }
}
