package com.discord.widgets.feedback;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetFeedbackSheetBinding;
import com.discord.widgets.voice.feedback.FeedbackView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.feedback.WidgetFeedbackSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetFeedbackSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetFeedbackSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetFeedbackSheetBinding> {
    public static final WidgetFeedbackSheet2 INSTANCE = new WidgetFeedbackSheet2();

    public WidgetFeedbackSheet2() {
        super(1, WidgetFeedbackSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetFeedbackSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetFeedbackSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetFeedbackSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.feedback_sheet_close_button;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.feedback_sheet_close_button);
        if (imageView != null) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            i = C5419R.id.feedback_sheet_feedback_view;
            FeedbackView feedbackView = (FeedbackView) view.findViewById(C5419R.id.feedback_sheet_feedback_view);
            if (feedbackView != null) {
                i = C5419R.id.feedback_sheet_title;
                TextView textView = (TextView) view.findViewById(C5419R.id.feedback_sheet_title);
                if (textView != null) {
                    return new WidgetFeedbackSheetBinding(nestedScrollView, imageView, nestedScrollView, feedbackView, textView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
