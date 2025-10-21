package com.discord.utilities.stateful;

import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.discord.utilities.stateful.StatefulViews;

/* compiled from: StatefulViews.kt */
/* renamed from: com.discord.utilities.stateful.StatefulViews$FragmentOnBackPressedHandler$onBackPressed$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class StatefulViews3 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;
    public final /* synthetic */ StatefulViews.FragmentOnBackPressedHandler this$0;

    public StatefulViews3(StatefulViews.FragmentOnBackPressedHandler fragmentOnBackPressedHandler, AlertDialog alertDialog) {
        this.this$0 = fragmentOnBackPressedHandler;
        this.$dialog = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StatefulViews.FragmentOnBackPressedHandler.access$getDiscardConfirmed$p(this.this$0).set(true);
        this.$dialog.dismiss();
        this.this$0.getActivity().onBackPressed();
    }
}
