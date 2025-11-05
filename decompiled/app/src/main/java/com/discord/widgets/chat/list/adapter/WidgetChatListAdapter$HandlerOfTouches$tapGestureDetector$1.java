package com.discord.widgets.chat.list.adapter;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;

/* compiled from: WidgetChatListAdapter.kt */
/* loaded from: classes2.dex */
public final class WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ WidgetChatListAdapter.HandlerOfTouches this$0;

    public WidgetChatListAdapter$HandlerOfTouches$tapGestureDetector$1(WidgetChatListAdapter.HandlerOfTouches handlerOfTouches) {
        this.this$0 = handlerOfTouches;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent e) {
        WidgetChatListAdapter.this.getEventHandler().onListClicked();
        return super.onSingleTapUp(e);
    }
}
