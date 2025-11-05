package com.discord.widgets.guilds.profile;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.widgets.guilds.profile.EmojiItem;
import d0.z.d.m;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* loaded from: classes2.dex */
public final class MoreEmojiViewHolder extends BaseEmojiViewHolder {
    private final WidgetGuildProfileEmojiExtraBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public MoreEmojiViewHolder(WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding) {
        m.checkNotNullParameter(widgetGuildProfileEmojiExtraBinding, "binding");
        TextView textView = widgetGuildProfileEmojiExtraBinding.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.binding = widgetGuildProfileEmojiExtraBinding;
    }

    @Override // com.discord.widgets.guilds.profile.BaseEmojiViewHolder
    public void bind(EmojiItem data) {
        m.checkNotNullParameter(data, "data");
        super.bind(data);
        TextView textView = this.binding.a;
        m.checkNotNullExpressionValue(textView, "binding.root");
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        m.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(b.i(resources, R.string.extra_emoji_count, new Object[]{String.valueOf(((EmojiItem.MoreEmoji) data).getExtraEmojiCount())}, null, 4));
    }
}
