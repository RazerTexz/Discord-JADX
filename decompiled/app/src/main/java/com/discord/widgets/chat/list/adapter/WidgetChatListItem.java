package com.discord.widgets.chat.list.adapter;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.discord.C5419R;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.message.Message;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetChatListItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public class WidgetChatListItem extends MGRecyclerViewHolder<WidgetChatListAdapter, ChatListEntry> {
    private final Drawable backgroundBlockedExpanded;
    private Drawable defaultBackground;

    /* JADX INFO: renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListItem$1 */
    /* JADX INFO: compiled from: WidgetChatListItem.kt */
    public static final class ViewOnTouchListenerC81581 implements View.OnTouchListener {
        public final /* synthetic */ WidgetChatListAdapter $adapter;
        private final GestureDetector tapGestureDetector;

        public ViewOnTouchListenerC81581(WidgetChatListAdapter widgetChatListAdapter) {
            this.$adapter = widgetChatListAdapter;
            View view = WidgetChatListItem.this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            this.tapGestureDetector = new GestureDetector(view.getContext(), new WidgetChatListItem2(this));
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View v, MotionEvent event) {
            return this.tapGestureDetector.onTouchEvent(event);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListItem(int i, WidgetChatListAdapter widgetChatListAdapter) {
        super(i, widgetChatListAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        this.defaultBackground = view.getBackground();
        View view2 = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view2, "itemView");
        this.backgroundBlockedExpanded = new ColorDrawable(ColorCompat.getThemedColor(view2, C5419R.attr.theme_chat_blocked_bg));
        this.itemView.setOnTouchListener(new ViewOnTouchListenerC81581(widgetChatListAdapter));
    }

    public final void configureCellHighlight(Message message, View highlightView, View gutterView) {
        int themedColor;
        int themedColor2;
        Intrinsics3.checkNotNullParameter(message, "message");
        Intrinsics3.checkNotNullParameter(highlightView, "highlightView");
        Intrinsics3.checkNotNullParameter(gutterView, "gutterView");
        boolean z2 = true;
        if (message.isEphemeralMessage() || message.isFailed()) {
            themedColor = ColorCompat.getThemedColor(highlightView.getContext(), C5419R.attr.colorBackgroundModifierHover);
            themedColor2 = ColorCompat.getThemedColor(gutterView, C5419R.attr.color_brand);
        } else if (WidgetChatListItem3.isUserMentioned((WidgetChatListAdapter) this.adapter, message)) {
            themedColor = ColorCompat.getThemedColor(highlightView.getContext(), C5419R.attr.theme_chat_mentioned_me);
            themedColor2 = ColorCompat.getColor(gutterView, C5419R.color.status_yellow_500);
        } else {
            themedColor = 0;
            themedColor2 = 0;
            z2 = false;
        }
        highlightView.setVisibility(z2 ? 0 : 8);
        gutterView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            highlightView.setBackgroundColor(themedColor);
            gutterView.setBackgroundColor(themedColor2);
        }
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    public void onConfigure(int position, ChatListEntry data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        view.setBackground(data.isInExpandedBlockedMessageChunk() ? this.backgroundBlockedExpanded : this.defaultBackground);
    }
}
