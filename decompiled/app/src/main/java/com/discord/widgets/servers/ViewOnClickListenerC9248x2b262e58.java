package com.discord.widgets.servers;

import android.view.View;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.widgets.servers.WidgetServerSettingsEmojis;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetServerSettingsEmojis.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder$onConfigure$1 */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC9248x2b262e58 implements View.OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmojis.Item $data;
    public final /* synthetic */ WidgetServerSettingsEmojis.Adapter.EmojiItemViewHolder this$0;

    public ViewOnClickListenerC9248x2b262e58(WidgetServerSettingsEmojis.Adapter.EmojiItemViewHolder emojiItemViewHolder, WidgetServerSettingsEmojis.Item item) {
        this.this$0 = emojiItemViewHolder;
        this.$data = item;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function2<View, ModelEmojiGuild, Unit> onEmojiItemClicked = WidgetServerSettingsEmojis.Adapter.EmojiItemViewHolder.access$getAdapter$p(this.this$0).getOnEmojiItemClicked();
        Intrinsics3.checkNotNullExpressionValue(view, "it");
        onEmojiItemClicked.invoke(view, ((WidgetServerSettingsEmojis.Item.EmojiItem) this.$data).getEmoji());
    }
}
