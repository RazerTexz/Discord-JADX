package com.discord.widgets.botuikit;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.databinding.ViewInteractionModalBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModalComponent.kt */
/* renamed from: com.discord.widgets.botuikit.ModalComponent$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ModalComponent2 extends FunctionReferenceImpl implements Function1<View, ViewInteractionModalBinding> {
    public static final ModalComponent2 INSTANCE = new ModalComponent2();

    public ModalComponent2() {
        super(1, ViewInteractionModalBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/ViewInteractionModalBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ViewInteractionModalBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewInteractionModalBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.close;
        ImageView imageView = (ImageView) view.findViewById(C5419R.id.close);
        if (imageView != null) {
            i = C5419R.id.components;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.components);
            if (linearLayout != null) {
                i = C5419R.id.components_scroll;
                ScrollView scrollView = (ScrollView) view.findViewById(C5419R.id.components_scroll);
                if (scrollView != null) {
                    i = C5419R.id.error;
                    LinearLayout linearLayout2 = (LinearLayout) view.findViewById(C5419R.id.error);
                    if (linearLayout2 != null) {
                        i = C5419R.id.icon;
                        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.icon);
                        if (simpleDraweeView != null) {
                            i = C5419R.id.submit;
                            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.submit);
                            if (materialButton != null) {
                                i = C5419R.id.title;
                                TextView textView = (TextView) view.findViewById(C5419R.id.title);
                                if (textView != null) {
                                    i = C5419R.id.toolbar;
                                    ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(C5419R.id.toolbar);
                                    if (constraintLayout != null) {
                                        i = C5419R.id.warning;
                                        TextView textView2 = (TextView) view.findViewById(C5419R.id.warning);
                                        if (textView2 != null) {
                                            return new ViewInteractionModalBinding((LinearLayout) view, imageView, linearLayout, scrollView, linearLayout2, simpleDraweeView, materialButton, textView, constraintLayout, textView2);
                                        }
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
