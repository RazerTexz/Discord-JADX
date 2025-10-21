package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;

/* compiled from: WidgetChatListAdapter.kt */
/* renamed from: com.discord.widgets.chat.list.adapter.WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapter2 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ WidgetChatListAdapter.HandlerOfTouches this$0;

    public WidgetChatListAdapter2(WidgetChatListAdapter.HandlerOfTouches handlerOfTouches) {
        this.this$0 = handlerOfTouches;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        WidgetChatListAdapter.this.getEventHandler().onListClicked();
        return super.onSingleTapUp(e);
    }
}
