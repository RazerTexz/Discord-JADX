package com.discord.utilities.uri;

import android.view.View;
import b.a.d.AppToast;
import b.d.b.a.outline;
import com.discord.databinding.LayoutUnhandledUriBinding;

/* compiled from: UriHandler.kt */
/* renamed from: com.discord.utilities.uri.UriHandler$showUnhandledUrlDialog$$inlined$apply$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class UriHandler3 implements View.OnClickListener {
    public final /* synthetic */ LayoutUnhandledUriBinding $binding$inlined;
    public final /* synthetic */ String $url$inlined;

    public UriHandler3(LayoutUnhandledUriBinding layoutUnhandledUriBinding, String str) {
        this.$binding$inlined = layoutUnhandledUriBinding;
        this.$url$inlined = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AppToast.c(outline.x(view, "v", "v.context"), this.$url$inlined, 0, 4);
    }
}
