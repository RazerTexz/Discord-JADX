package com.discord.widgets.servers.guildboost;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetServerBoostConfirmationBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.guildboost.GuildBoostConfirmationView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetGuildBoostConfirmation.kt */
/* renamed from: com.discord.widgets.servers.guildboost.WidgetGuildBoostConfirmation$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildBoostConfirmation2 extends FunctionReferenceImpl implements Function1<View, WidgetServerBoostConfirmationBinding> {
    public static final WidgetGuildBoostConfirmation2 INSTANCE = new WidgetGuildBoostConfirmation2();

    public WidgetGuildBoostConfirmation2() {
        super(1, WidgetServerBoostConfirmationBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetServerBoostConfirmationBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetServerBoostConfirmationBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerBoostConfirmationBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.boost_confirmation_button_container;
        LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.boost_confirmation_button_container);
        if (linearLayout != null) {
            i = C5419R.id.boost_confirmation_confirmation_view;
            GuildBoostConfirmationView guildBoostConfirmationView = (GuildBoostConfirmationView) view.findViewById(C5419R.id.boost_confirmation_confirmation_view);
            if (guildBoostConfirmationView != null) {
                i = C5419R.id.boost_confirmation_cooldown_warning;
                TextView textView = (TextView) view.findViewById(C5419R.id.boost_confirmation_cooldown_warning);
                if (textView != null) {
                    i = C5419R.id.boost_confirmation_error;
                    TextView textView2 = (TextView) view.findViewById(C5419R.id.boost_confirmation_error);
                    if (textView2 != null) {
                        i = C5419R.id.boost_confirmation_select;
                        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.boost_confirmation_select);
                        if (materialButton != null) {
                            i = C5419R.id.dimmer_view;
                            DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                            if (dimmerView != null) {
                                return new WidgetServerBoostConfirmationBinding((CoordinatorLayout) view, linearLayout, guildBoostConfirmationView, textView, textView2, materialButton, dimmerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
