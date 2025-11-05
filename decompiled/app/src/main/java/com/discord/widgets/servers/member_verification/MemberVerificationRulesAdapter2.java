package com.discord.widgets.servers.member_verification;

import android.view.View;
import com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter;
import com.discord.widgets.servers.member_verification.form_fields.MemberVerificationItemApproveTerms;

/* compiled from: MemberVerificationRulesAdapter.kt */
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$ApproveTermsItemHolder$onConfigure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter2 implements View.OnClickListener {
    public final /* synthetic */ MemberVerificationItemApproveTerms $approveTerms;
    public final /* synthetic */ MemberVerificationRulesAdapter.ApproveTermsItemHolder this$0;

    public MemberVerificationRulesAdapter2(MemberVerificationRulesAdapter.ApproveTermsItemHolder approveTermsItemHolder, MemberVerificationItemApproveTerms memberVerificationItemApproveTerms) {
        this.this$0 = approveTermsItemHolder;
        this.$approveTerms = memberVerificationItemApproveTerms;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MemberVerificationRulesAdapter.ApproveTermsItemHolder.access$getAdapter$p(this.this$0).getOnUpdateRulesApproval().invoke(Boolean.valueOf(!this.$approveTerms.isApproved()));
    }
}
