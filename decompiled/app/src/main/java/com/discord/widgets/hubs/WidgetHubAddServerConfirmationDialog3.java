package com.discord.widgets.hubs;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.HubAddServerConfirmationDialogBinding;
import com.discord.views.GuildView;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubAddServerConfirmationDialog.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServerConfirmationDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubAddServerConfirmationDialog3 extends FunctionReferenceImpl implements Function1<View, HubAddServerConfirmationDialogBinding> {
    public static final WidgetHubAddServerConfirmationDialog3 INSTANCE = new WidgetHubAddServerConfirmationDialog3();

    public WidgetHubAddServerConfirmationDialog3() {
        super(1, HubAddServerConfirmationDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/HubAddServerConfirmationDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ HubAddServerConfirmationDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final HubAddServerConfirmationDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.add_server_confirmation_dialog_description;
        TextView textView = (TextView) view.findViewById(C5419R.id.add_server_confirmation_dialog_description);
        if (textView != null) {
            i = C5419R.id.add_server_confirmation_dialog_image;
            GuildView guildView = (GuildView) view.findViewById(C5419R.id.add_server_confirmation_dialog_image);
            if (guildView != null) {
                i = C5419R.id.add_server_confirmation_dialog_positive;
                MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.add_server_confirmation_dialog_positive);
                if (materialButton != null) {
                    return new HubAddServerConfirmationDialogBinding((LinearLayout) view, textView, guildView, materialButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
