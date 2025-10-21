package com.discord.widgets.search.suggestions;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetSearchSuggestionsBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetSearchSuggestions.kt */
/* renamed from: com.discord.widgets.search.suggestions.WidgetSearchSuggestions$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSearchSuggestions3 extends FunctionReferenceImpl implements Function1<View, WidgetSearchSuggestionsBinding> {
    public static final WidgetSearchSuggestions3 INSTANCE = new WidgetSearchSuggestions3();

    public WidgetSearchSuggestions3() {
        super(1, WidgetSearchSuggestionsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetSearchSuggestionsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetSearchSuggestionsBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetSearchSuggestionsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetSearchSuggestionsBinding(recyclerView, recyclerView);
    }
}
