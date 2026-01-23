package com.discord.widgets.status;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetThreadStatusBinding;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.views.LoadingButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatus$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadStatus2 extends FunctionReferenceImpl implements Function1<View, WidgetThreadStatusBinding> {
    public static final WidgetThreadStatus2 INSTANCE = new WidgetThreadStatus2();

    public WidgetThreadStatus2() {
        super(1, WidgetThreadStatusBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetThreadStatusBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetThreadStatusBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetThreadStatusBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i = C5419R.id.thread_status_button;
        LoadingButton loadingButton = (LoadingButton) view.findViewById(C5419R.id.thread_status_button);
        if (loadingButton != null) {
            i = C5419R.id.thread_status_text;
            LinkifiedTextView linkifiedTextView = (LinkifiedTextView) view.findViewById(C5419R.id.thread_status_text);
            if (linkifiedTextView != null) {
                return new WidgetThreadStatusBinding((ConstraintLayout) view, constraintLayout, loadingButton, linkifiedTextView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
