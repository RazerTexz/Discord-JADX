package com.discord.widgets.user.search;

import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.textfield.TextInputLayout;

/* compiled from: WidgetGlobalSearch.kt */
/* renamed from: com.discord.widgets.user.search.WidgetGlobalSearch$setSearchPrefix$1$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetGlobalSearch5 implements Runnable {
    public final /* synthetic */ TextInputLayout $this_apply;

    public WidgetGlobalSearch5(TextInputLayout textInputLayout) {
        this.$this_apply = textInputLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewExtensions.setSelectionEnd(this.$this_apply);
    }
}
