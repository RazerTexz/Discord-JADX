package com.discord.widgets.stage.sheet;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetStageStartEventBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageStartEventBottomSheet$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageStartEventBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetStageStartEventBottomSheet2 extends FunctionReferenceImpl implements Function1<View, WidgetStageStartEventBottomSheetBinding> {
    public static final WidgetStageStartEventBottomSheet2 INSTANCE = new WidgetStageStartEventBottomSheet2();

    public WidgetStageStartEventBottomSheet2() {
        super(1, WidgetStageStartEventBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetStageStartEventBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetStageStartEventBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetStageStartEventBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.sparkle;
        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.sparkle);
        if (appCompatImageView != null) {
            i = C5419R.id.speaker_hint;
            TextView textView = (TextView) view.findViewById(C5419R.id.speaker_hint);
            if (textView != null) {
                i = C5419R.id.start_stage_button;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.start_stage_button);
                if (materialButton != null) {
                    i = C5419R.id.subtitle;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.subtitle);
                    if (textView2 != null) {
                        i = C5419R.id.title;
                        TextView textView3 = (TextView) view.findViewById(C5419R.id.title);
                        if (textView3 != null) {
                            i = C5419R.id.topic_input;
                            TextInputEditText textInputEditText = (TextInputEditText) view.findViewById(C5419R.id.topic_input);
                            if (textInputEditText != null) {
                                i = C5419R.id.topic_label;
                                TextView textView4 = (TextView) view.findViewById(C5419R.id.topic_label);
                                if (textView4 != null) {
                                    i = C5419R.id.topic_layout;
                                    TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(C5419R.id.topic_layout);
                                    if (textInputLayout != null) {
                                        return new WidgetStageStartEventBottomSheetBinding((CoordinatorLayout) view, appCompatImageView, textView, materialButton, textView2, textView3, textInputEditText, textView4, textInputLayout);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
