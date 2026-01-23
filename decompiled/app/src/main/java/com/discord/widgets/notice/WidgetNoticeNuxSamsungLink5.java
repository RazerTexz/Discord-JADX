package com.discord.widgets.notice;

import android.view.View;
import android.widget.LinearLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetNoticeNuxSamsungLinkBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeNuxSamsungLink$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetNoticeNuxSamsungLink.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetNoticeNuxSamsungLink5 extends FunctionReferenceImpl implements Function1<View, WidgetNoticeNuxSamsungLinkBinding> {
    public static final WidgetNoticeNuxSamsungLink5 INSTANCE = new WidgetNoticeNuxSamsungLink5();

    public WidgetNoticeNuxSamsungLink5() {
        super(1, WidgetNoticeNuxSamsungLinkBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetNoticeNuxSamsungLinkBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetNoticeNuxSamsungLinkBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetNoticeNuxSamsungLinkBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.cancel_button;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.cancel_button);
        if (materialButton != null) {
            i = C5419R.id.enable_button;
            MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.enable_button);
            if (materialButton2 != null) {
                return new WidgetNoticeNuxSamsungLinkBinding((LinearLayout) view, materialButton, materialButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
