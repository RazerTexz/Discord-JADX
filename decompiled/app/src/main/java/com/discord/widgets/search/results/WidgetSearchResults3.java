package com.discord.widgets.search.results;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchResultsBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSearchResults.kt */
/* renamed from: com.discord.widgets.search.results.WidgetSearchResults$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchResults3 extends FunctionReferenceImpl implements Function1<View, WidgetSearchResultsBinding> {
    public static final WidgetSearchResults3 INSTANCE = new WidgetSearchResults3();

    public WidgetSearchResults3() {
        super(1, WidgetSearchResultsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchResultsBinding;", 0);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSearchResultsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchResultsBinding(recyclerView, recyclerView);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSearchResultsBinding invoke(View view) {
        return invoke2(view);
    }
}
