package com.discord.widgets.settings.account.mfa;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetEnableMfaStepsBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.steps.StepsView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps$binding$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetEnableMFASteps.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetEnableMFASteps2 extends FunctionReferenceImpl implements Function1<View, WidgetEnableMfaStepsBinding> {
    public static final WidgetEnableMFASteps2 INSTANCE = new WidgetEnableMFASteps2();

    public WidgetEnableMFASteps2() {
        super(1, WidgetEnableMfaStepsBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetEnableMfaStepsBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetEnableMfaStepsBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetEnableMfaStepsBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.dimmer_view;
        DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
        if (dimmerView != null) {
            i = C5419R.id.enable_mfa_stepsview;
            StepsView stepsView = (StepsView) view.findViewById(C5419R.id.enable_mfa_stepsview);
            if (stepsView != null) {
                return new WidgetEnableMfaStepsBinding((FrameLayout) view, dimmerView, stepsView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
