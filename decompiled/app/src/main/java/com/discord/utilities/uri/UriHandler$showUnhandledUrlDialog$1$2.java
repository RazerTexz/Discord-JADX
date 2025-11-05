package com.discord.utilities.uri;

import android.view.View;
import androidx.appcompat.app.AlertDialog;

/* compiled from: UriHandler.kt */
/* loaded from: classes2.dex */
public final class UriHandler$showUnhandledUrlDialog$1$2 implements View.OnClickListener {
    public final /* synthetic */ AlertDialog $this_apply;

    public UriHandler$showUnhandledUrlDialog$1$2(AlertDialog alertDialog) {
        this.$this_apply = alertDialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.$this_apply.dismiss();
    }
}
