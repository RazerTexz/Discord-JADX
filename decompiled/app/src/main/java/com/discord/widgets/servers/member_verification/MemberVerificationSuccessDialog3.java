package com.discord.widgets.servers.member_verification;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.discord.C5419R;
import com.discord.databinding.WidgetMemberVerificationSuccessBinding;
import com.google.android.material.button.MaterialButton;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.servers.member_verification.MemberVerificationSuccessDialog$binding$2, reason: use source file name */
/* JADX INFO: compiled from: MemberVerificationSuccessDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class MemberVerificationSuccessDialog3 extends FunctionReferenceImpl implements Function1<View, WidgetMemberVerificationSuccessBinding> {
    public static final MemberVerificationSuccessDialog3 INSTANCE = new MemberVerificationSuccessDialog3();

    public MemberVerificationSuccessDialog3() {
        super(1, WidgetMemberVerificationSuccessBinding.class, "bind", "bind(Landroid/view/View;)Lcom/discord/databinding/WidgetMemberVerificationSuccessBinding;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetMemberVerificationSuccessBinding invoke(View view) {
        return invoke2(view);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetMemberVerificationSuccessBinding invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "p1");
        int i = C5419R.id.member_verification_confirm;
        MaterialButton materialButton = (MaterialButton) view.findViewById(C5419R.id.member_verification_confirm);
        if (materialButton != null) {
            i = C5419R.id.member_verification_guild_name;
            TextView textView = (TextView) view.findViewById(C5419R.id.member_verification_guild_name);
            if (textView != null) {
                i = C5419R.id.member_verification_success_card;
                CardView cardView = (CardView) view.findViewById(C5419R.id.member_verification_success_card);
                if (cardView != null) {
                    return new WidgetMemberVerificationSuccessBinding((RelativeLayout) view, materialButton, textView, cardView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
