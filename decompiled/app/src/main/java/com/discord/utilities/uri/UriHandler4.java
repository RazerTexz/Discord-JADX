package com.discord.utilities.uri;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* JADX INFO: renamed from: com.discord.utilities.uri.UriHandler$showUnhandledUrlDialog$1$2, reason: use source file name */
/* JADX INFO: compiled from: UriHandler.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UriHandler4 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog $this_apply;

    public UriHandler4(AlertDialog alertDialog) {
        this.$this_apply = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$this_apply.dismiss();
    }
}
