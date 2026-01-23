package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetGifCategoryBinding;
import com.discord.utilities.views.ContentResizingCoordinatorLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGifCategory2 extends FunctionReferenceImpl implements Function1<View, WidgetGifCategoryBinding> {
    public static final WidgetGifCategory2 INSTANCE = new WidgetGifCategory2();

    public WidgetGifCategory2() {
        super(1, WidgetGifCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGifCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGifCategoryBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGifCategoryBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ContentResizingCoordinatorLayout contentResizingCoordinatorLayout = (ContentResizingCoordinatorLayout) view;
        int i = C5419R.id.gif_category_gif_recycler;
        RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.gif_category_gif_recycler);
        if (recyclerView != null) {
            i = C5419R.id.gif_category_loading_view;
            GifLoadingView gifLoadingView = (GifLoadingView) view.findViewById(C5419R.id.gif_category_loading_view);
            if (gifLoadingView != null) {
                i = C5419R.id.gif_category_title;
                TextView textView = (TextView) view.findViewById(C5419R.id.gif_category_title);
                if (textView != null) {
                    return new WidgetGifCategoryBinding((ContentResizingCoordinatorLayout) view, contentResizingCoordinatorLayout, recyclerView, gifLoadingView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
