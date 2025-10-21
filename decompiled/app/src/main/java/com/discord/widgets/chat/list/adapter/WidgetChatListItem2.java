package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.discord.widgets.chat.list.adapter.WidgetChatListItem;

/* compiled from: WidgetChatListItem.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListItem$1$tapGestureDetector$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListItem2 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ WidgetChatListItem.AnonymousClass1 this$0;

    public WidgetChatListItem2(WidgetChatListItem.AnonymousClass1 anonymousClass1) {
        this.this$0 = anonymousClass1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        this.this$0.$adapter.getEventHandler().onListClicked();
        return super.onSingleTapUp(e);
    }
}
