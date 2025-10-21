package com.discord.widgets.hubs.events;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetHubEventsPageBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetHubEventsPage.kt */
/* renamed from: com.discord.widgets.hubs.events.WidgetHubEventsPage$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubEventsPage5 extends FunctionReferenceImpl implements Function1<View, WidgetHubEventsPageBinding> {
    public static final WidgetHubEventsPage5 INSTANCE = new WidgetHubEventsPage5();

    public WidgetHubEventsPage5() {
        super(1, WidgetHubEventsPageBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetHubEventsPageBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetHubEventsPageBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetHubEventsPageBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.recycler_view;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        if (recyclerView != null) {
            i = R.id.title;
            TextView textView = (TextView) view.findViewById(R.id.title);
            if (textView != null) {
                return new WidgetHubEventsPageBinding((LinearLayout) view, recyclerView, textView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
