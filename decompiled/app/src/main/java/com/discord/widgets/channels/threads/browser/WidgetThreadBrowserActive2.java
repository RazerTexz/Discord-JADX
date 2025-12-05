package com.discord.widgets.channels.threads.browser;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadBrowserActiveBinding;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ThreadBrowserEmptyBinding;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetThreadBrowserActive.kt */
/* renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserActive$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserActive2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserActiveBinding> {
    public static final WidgetThreadBrowserActive2 INSTANCE = new WidgetThreadBrowserActive2();

    public WidgetThreadBrowserActive2() {
        super(1, WidgetThreadBrowserActiveBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserActiveBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserActiveBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserActiveBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.empty_view;
        View viewFindViewById = view.findViewById(C5419R.id.empty_view);
        if (viewFindViewById != null) {
            ThreadBrowserEmptyBinding threadBrowserEmptyBindingM205a = ThreadBrowserEmptyBinding.m205a(viewFindViewById);
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                return new WidgetThreadBrowserActiveBinding((ConstraintLayout) view, threadBrowserEmptyBindingM205a, recyclerView);
            }
            i = C5419R.id.recycler_view;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
