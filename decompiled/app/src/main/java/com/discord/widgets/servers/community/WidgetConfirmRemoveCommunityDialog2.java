package com.discord.widgets.servers.community;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetConfirmRemoveCommunityDialogBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetConfirmRemoveCommunityDialog.kt */
/* renamed from: com.discord.widgets.servers.community.WidgetConfirmRemoveCommunityDialog$binding$2, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetConfirmRemoveCommunityDialog2 extends FunctionReferenceImpl implements Function1<View, WidgetConfirmRemoveCommunityDialogBinding> {
    public static final WidgetConfirmRemoveCommunityDialog2 INSTANCE = new WidgetConfirmRemoveCommunityDialog2();

    public WidgetConfirmRemoveCommunityDialog2() {
        super(1, WidgetConfirmRemoveCommunityDialogBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetConfirmRemoveCommunityDialogBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetConfirmRemoveCommunityDialogBinding invoke(View view) {
        return invoke2(view);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetConfirmRemoveCommunityDialogBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.confirm_deleting_community_body_text;
        TextView textView = (TextView) view.findViewById(C5419R.id.confirm_deleting_community_body_text);
        if (textView != null) {
            i = C5419R.id.confirm_deleting_community_cancel;
            MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.confirm_deleting_community_cancel);
            if (materialButton != null) {
                i = C5419R.id.confirm_deleting_community_header;
                TextView textView2 = (TextView) view.findViewById(C5419R.id.confirm_deleting_community_header);
                if (textView2 != null) {
                    i = C5419R.id.confirm_deleting_community_header_container;
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(C5419R.id.confirm_deleting_community_header_container);
                    if (linearLayout != null) {
                        i = C5419R.id.confirm_deleting_community_ok;
                        MaterialButton materialButton2 = (MaterialButton) view.findViewById(C5419R.id.confirm_deleting_community_ok);
                        if (materialButton2 != null) {
                            return new WidgetConfirmRemoveCommunityDialogBinding((LinearLayout) view, textView, materialButton, textView2, linearLayout, materialButton2);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
