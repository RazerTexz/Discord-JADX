package com.discord.widgets.directories;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetDirectoryCategoryBinding;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoryCategory$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoryCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetDirectoryCategory5 extends FunctionReferenceImpl implements Function1<View, WidgetDirectoryCategoryBinding> {
    public static final WidgetDirectoryCategory5 INSTANCE = new WidgetDirectoryCategory5();

    public WidgetDirectoryCategory5() {
        super(1, WidgetDirectoryCategoryBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetDirectoryCategoryBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetDirectoryCategoryBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetDirectoryCategoryBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        Objects.requireNonNull(view, "rootView");
        RecyclerView recyclerView = (RecyclerView) view;
        return new WidgetDirectoryCategoryBinding(recyclerView, recyclerView);
    }
}
