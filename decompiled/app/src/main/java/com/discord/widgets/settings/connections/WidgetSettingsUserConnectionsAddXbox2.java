package com.discord.widgets.settings.connections;

import android.view.View;
import android.widget.LinearLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.discord.C5419R;
import com.discord.databinding.WidgetConnectionsAddXboxBinding;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.views.CodeVerificationView;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetSettingsUserConnectionsAddXbox.kt */
/* renamed from: com.discord.widgets.settings.connections.WidgetSettingsUserConnectionsAddXbox$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetSettingsUserConnectionsAddXbox2 extends FunctionReferenceImpl implements Function1<View, WidgetConnectionsAddXboxBinding> {
    public static final WidgetSettingsUserConnectionsAddXbox2 INSTANCE = new WidgetSettingsUserConnectionsAddXbox2();

    public WidgetSettingsUserConnectionsAddXbox2() {
        super(1, WidgetConnectionsAddXboxBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConnectionsAddXboxBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetConnectionsAddXboxBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetConnectionsAddXboxBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.connections_xbox_code;
        CodeVerificationView codeVerificationView = (CodeVerificationView) view.findViewById(C5419R.id.connections_xbox_code);
        if (codeVerificationView != null) {
            i = C5419R.id.connections_xbox_login;
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.connections_xbox_login);
            if (linearLayout != null) {
                i = C5419R.id.dimmer_view;
                DimmerView dimmerView = (DimmerView) view.findViewById(C5419R.id.dimmer_view);
                if (dimmerView != null) {
                    return new WidgetConnectionsAddXboxBinding((CoordinatorLayout) view, codeVerificationView, linearLayout, dimmerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
