package com.discord.widgets.chat.list;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatListBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetChatList.kt */
/* renamed from: com.discord.widgets.chat.list.WidgetChatList$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatList2 extends FunctionReferenceImpl implements Function1<View, WidgetChatListBinding> {
    public static final WidgetChatList2 INSTANCE = new WidgetChatList2();

    public WidgetChatList2() {
        super(1, WidgetChatListBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetChatListBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetChatListBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetChatListBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetChatListBinding(recyclerView, recyclerView);
    }
}
