package com.discord.widgets.guilds.join;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.R;
import com.discord.databinding.WidgetGuildJoinBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetGuildJoin.kt */
/* renamed from: com.discord.widgets.guilds.join.WidgetGuildJoin$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetGuildJoin2 extends FunctionReferenceImpl implements Function1<View, WidgetGuildJoinBinding> {
    public static final WidgetGuildJoin2 INSTANCE = new WidgetGuildJoin2();

    public WidgetGuildJoin2() {
        super(1, WidgetGuildJoinBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetGuildJoinBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGuildJoinBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGuildJoinBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = R.id.guild_join_action_btn;
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.guild_join_action_btn);
        if (materialButton != null) {
            i = R.id.guild_join_invite;
            TextInputLayout textInputLayout = (TextInputLayout) view.findViewById(R.id.guild_join_invite);
            if (textInputLayout != null) {
                return new WidgetGuildJoinBinding((CoordinatorLayout) view, materialButton, textInputLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
