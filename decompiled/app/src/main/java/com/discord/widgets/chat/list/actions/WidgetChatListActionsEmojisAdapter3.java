package com.discord.widgets.chat.list.actions;

import android.view.View;
import com.discord.C5419R;
import com.discord.databinding.ViewChatListActionsEmojiItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.Emoji;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.actions.WidgetChatListActionsEmojisAdapter2;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* renamed from: com.discord.widgets.chat.list.actions.EmojiViewHolder, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListActionsEmojisAdapter3 extends MGRecyclerViewHolder<WidgetChatListActionsEmojisAdapter, WidgetChatListActionsEmojisAdapter2> {
    private final ViewChatListActionsEmojiItemBinding binding;

    /* compiled from: WidgetChatListActionsEmojisAdapter.kt */
    /* renamed from: com.discord.widgets.chat.list.actions.EmojiViewHolder$onConfigure$1 */
    public static final class ViewOnClickListenerC79571 implements View.OnClickListener {
        public final /* synthetic */ WidgetChatListActionsEmojisAdapter2 $data;

        public ViewOnClickListenerC79571(WidgetChatListActionsEmojisAdapter2 widgetChatListActionsEmojisAdapter2) {
            this.$data = widgetChatListActionsEmojisAdapter2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            WidgetChatListActionsEmojisAdapter3.access$getAdapter$p(WidgetChatListActionsEmojisAdapter3.this).getOnClickEmoji().invoke(((WidgetChatListActionsEmojisAdapter2.EmojiData) this.$data).getEmoji());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListActionsEmojisAdapter3(WidgetChatListActionsEmojisAdapter widgetChatListActionsEmojisAdapter) {
        super(C5419R.layout.view_chat_list_actions_emoji_item, widgetChatListActionsEmojisAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListActionsEmojisAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view;
        ViewChatListActionsEmojiItemBinding viewChatListActionsEmojiItemBinding = new ViewChatListActionsEmojiItemBinding(simpleDraweeView, simpleDraweeView);
        Intrinsics3.checkNotNullExpressionValue(viewChatListActionsEmojiItemBinding, "ViewChatListActionsEmojiItemBinding.bind(itemView)");
        this.binding = viewChatListActionsEmojiItemBinding;
    }

    public static final /* synthetic */ WidgetChatListActionsEmojisAdapter access$getAdapter$p(WidgetChatListActionsEmojisAdapter3 widgetChatListActionsEmojisAdapter3) {
        return (WidgetChatListActionsEmojisAdapter) widgetChatListActionsEmojisAdapter3.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, WidgetChatListActionsEmojisAdapter2 widgetChatListActionsEmojisAdapter2) {
        onConfigure2(i, widgetChatListActionsEmojisAdapter2);
    }

    /* renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, WidgetChatListActionsEmojisAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        WidgetChatListActionsEmojisAdapter2.EmojiData emojiData = (WidgetChatListActionsEmojisAdapter2.EmojiData) data;
        SimpleDraweeView simpleDraweeView = this.binding.f15396b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.emojiIv");
        int i = simpleDraweeView.getLayoutParams().width;
        SimpleDraweeView simpleDraweeView2 = this.binding.f15396b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.emojiIv");
        int paddingStart = i - simpleDraweeView2.getPaddingStart();
        SimpleDraweeView simpleDraweeView3 = this.binding.f15396b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.emojiIv");
        int mediaProxySize = IconUtils.getMediaProxySize(DimenUtils.pixelsToDp(paddingStart - simpleDraweeView3.getPaddingEnd()) * 2);
        this.itemView.setOnClickListener(new ViewOnClickListenerC79571(data));
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        view.setContentDescription(emojiData.getEmoji().getFirstName());
        SimpleDraweeView simpleDraweeView4 = this.binding.f15396b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.emojiIv");
        Emoji emoji = emojiData.getEmoji();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        MGImages.setImage$default(simpleDraweeView4, emoji.getImageUri(true, mediaProxySize, view2.getContext()), 0, 0, false, null, null, 124, null);
    }
}
