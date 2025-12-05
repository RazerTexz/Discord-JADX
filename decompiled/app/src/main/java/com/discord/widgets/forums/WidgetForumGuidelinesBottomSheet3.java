package com.discord.widgets.forums;

import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import com.discord.C5419R;
import com.discord.databinding.WidgetForumGuidelinesBottomSheetBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetForumGuidelinesBottomSheet3 extends FunctionReferenceImpl implements Function1<View, WidgetForumGuidelinesBottomSheetBinding> {
    public static final WidgetForumGuidelinesBottomSheet3 INSTANCE = new WidgetForumGuidelinesBottomSheet3();

    public WidgetForumGuidelinesBottomSheet3() {
        super(1, WidgetForumGuidelinesBottomSheetBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetForumGuidelinesBottomSheetBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetForumGuidelinesBottomSheetBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetForumGuidelinesBottomSheetBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.channel_topic;
        TextView textView = (TextView) view.findViewById(C5419R.id.channel_topic);
        if (textView != null) {
            i = C5419R.id.channel_topic_card;
            CardView cardView = (CardView) view.findViewById(C5419R.id.channel_topic_card);
            if (cardView != null) {
                i = C5419R.id.content;
                ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.content);
                if (constraintLayout != null) {
                    i = C5419R.id.got_it;
                    MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.got_it);
                    if (materialButton != null) {
                        i = C5419R.id.sparkle;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) view.findViewById(C5419R.id.sparkle);
                        if (appCompatImageView != null) {
                            i = C5419R.id.subtitle;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.subtitle);
                            if (textView2 != null) {
                                i = C5419R.id.title;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.title);
                                if (textView3 != null) {
                                    return new WidgetForumGuidelinesBottomSheetBinding((NestedScrollView) view, textView, cardView, constraintLayout, materialButton, appCompatImageView, textView2, textView3);
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
