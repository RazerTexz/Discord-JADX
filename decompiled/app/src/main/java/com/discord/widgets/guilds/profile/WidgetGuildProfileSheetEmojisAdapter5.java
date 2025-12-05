package com.discord.widgets.guilds.profile;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGuildProfileEmojiExtraBinding;
import com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter3;
import p007b.p008a.p027k.FormatUtils;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* renamed from: com.discord.widgets.guilds.profile.MoreEmojiViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildProfileSheetEmojisAdapter5 extends WidgetGuildProfileSheetEmojisAdapter2 {
    private final WidgetGuildProfileEmojiExtraBinding binding;

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetGuildProfileSheetEmojisAdapter5(WidgetGuildProfileEmojiExtraBinding widgetGuildProfileEmojiExtraBinding) {
        Intrinsics3.checkNotNullParameter(widgetGuildProfileEmojiExtraBinding, "binding");
        TextView textView = widgetGuildProfileEmojiExtraBinding.f16886a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        super(textView);
        this.binding = widgetGuildProfileEmojiExtraBinding;
    }

    @Override // com.discord.widgets.guilds.profile.WidgetGuildProfileSheetEmojisAdapter2
    public void bind(WidgetGuildProfileSheetEmojisAdapter3 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.bind(data);
        TextView textView = this.binding.f16886a;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        Resources resources = view.getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "itemView.resources");
        textView.setText(FormatUtils.m217i(resources, C5419R.string.extra_emoji_count, new Object[]{String.valueOf(((WidgetGuildProfileSheetEmojisAdapter3.MoreEmoji) data).getExtraEmojiCount())}, null, 4));
    }
}
