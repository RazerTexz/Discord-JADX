package com.discord.widgets.channels.threads.browser;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadBrowserArchivedBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p025i.ThreadBrowserEmptyBinding;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchived$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadBrowserArchived.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserArchived2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadBrowserArchivedBinding> {
    public static final WidgetThreadBrowserArchived2 INSTANCE = new WidgetThreadBrowserArchived2();

    public WidgetThreadBrowserArchived2() {
        super(1, WidgetThreadBrowserArchivedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadBrowserArchivedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadBrowserArchivedBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.empty_view;
        View viewFindViewById = view.findViewById(C5419R.id.empty_view);
        if (viewFindViewById != null) {
            ThreadBrowserEmptyBinding threadBrowserEmptyBindingM205a = ThreadBrowserEmptyBinding.m205a(viewFindViewById);
            i = C5419R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) view.findViewById(C5419R.id.recycler_view);
            if (recyclerView != null) {
                i = C5419R.id.thread_browser_error_msg;
                TextView textView = (TextView) view.findViewById(C5419R.id.thread_browser_error_msg);
                if (textView != null) {
                    i = C5419R.id.thread_browser_error_overlay;
                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.thread_browser_error_overlay);
                    if (constraintLayout != null) {
                        i = C5419R.id.thread_browser_try_again;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.thread_browser_try_again);
                        if (materialButton != null) {
                            return new WidgetThreadBrowserArchivedBinding((ConstraintLayout) view, threadBrowserEmptyBindingM205a, recyclerView, textView, constraintLayout, materialButton);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
