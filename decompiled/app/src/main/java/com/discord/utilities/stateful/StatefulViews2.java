package com.discord.utilities.stateful;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: renamed from: com.discord.utilities.stateful.StatefulViews$FragmentOnBackPressedHandler$onBackPressed$1, reason: use source file name */
/* JADX INFO: compiled from: StatefulViews.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StatefulViews2 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog $dialog;

    public StatefulViews2(AlertDialog alertDialog) {
        this.$dialog = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$dialog.dismiss();
    }
}
