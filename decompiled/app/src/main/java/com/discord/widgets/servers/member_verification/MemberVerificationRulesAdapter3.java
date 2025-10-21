package com.discord.widgets.servers.member_verification;

import android.content.Context;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: MemberVerificationRulesAdapter.kt */
/* renamed from: com.discord.widgets.servers.member_verification.MemberVerificationRulesAdapter$MultipleChoiceItemHolder$createMultipleChoiceButtons$$inlined$forEach$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class MemberVerificationRulesAdapter3 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Context $context$inlined;
    public final /* synthetic */ Function1 $onItemSelected$inlined;
    public final /* synthetic */ RadioGroup $radioGroup$inlined;
    public final /* synthetic */ int $valueIndex;
    public final /* synthetic */ List $valueList$inlined;
    public final /* synthetic */ MemberVerificationRulesAdapter.MultipleChoiceItemHolder this$0;

    public MemberVerificationRulesAdapter3(int i, MemberVerificationRulesAdapter.MultipleChoiceItemHolder multipleChoiceItemHolder, List list, RadioGroup radioGroup, Context context, Function1 function1) {
        this.$valueIndex = i;
        this.this$0 = multipleChoiceItemHolder;
        this.$valueList$inlined = list;
        this.$radioGroup$inlined = radioGroup;
        this.$context$inlined = context;
        this.$onItemSelected$inlined = function1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
        if (z2) {
            this.$onItemSelected$inlined.invoke(Integer.valueOf(this.$valueIndex));
        }
    }
}
