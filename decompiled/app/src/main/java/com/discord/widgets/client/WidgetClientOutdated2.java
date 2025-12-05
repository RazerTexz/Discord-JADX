package com.discord.widgets.client;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetClientOutdatedBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetClientOutdated.kt */
/* renamed from: com.discord.widgets.client.WidgetClientOutdated$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetClientOutdated2 extends FunctionReferenceImpl implements Function1<View, WidgetClientOutdatedBinding> {
    public static final WidgetClientOutdated2 INSTANCE = new WidgetClientOutdated2();

    public WidgetClientOutdated2() {
        super(1, WidgetClientOutdatedBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetClientOutdatedBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetClientOutdatedBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetClientOutdatedBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.client_outdated_anchor_wrap;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.client_outdated_anchor_wrap);
        if (linearLayout != null) {
            i = C5419R.id.client_outdated_update;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.client_outdated_update);
            if (materialButton != null) {
                return new WidgetClientOutdatedBinding((RelativeLayout) view, linearLayout, materialButton);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
