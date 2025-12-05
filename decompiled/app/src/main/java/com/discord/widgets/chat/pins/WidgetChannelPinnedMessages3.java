package com.discord.widgets.chat.pins;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetChannelPinnedMessagesBinding;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetChannelPinnedMessages.kt */
/* renamed from: com.discord.widgets.chat.pins.WidgetChannelPinnedMessages$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelPinnedMessages3 extends FunctionReferenceImpl implements Function1<View, WidgetChannelPinnedMessagesBinding> {
    public static final WidgetChannelPinnedMessages3 INSTANCE = new WidgetChannelPinnedMessages3();

    public WidgetChannelPinnedMessages3() {
        super(1, WidgetChannelPinnedMessagesBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChannelPinnedMessagesBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChannelPinnedMessagesBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChannelPinnedMessagesBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.channel_pinned_messages_recycler);
        if (recyclerView != null) {
            return new WidgetChannelPinnedMessagesBinding((CoordinatorLayout) view, recyclerView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.channel_pinned_messages_recycler)));
    }
}
