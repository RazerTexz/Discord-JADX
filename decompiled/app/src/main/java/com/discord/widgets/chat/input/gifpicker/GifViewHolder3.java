package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.GifViewHolder$SuggestedTerms$configureSearchTerms$1, reason: use source file name */
/* JADX INFO: compiled from: GifViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifViewHolder3 implements View.OnClickListener {
    public final /* synthetic */ Function1 $onTermSelected;
    public final /* synthetic */ String $suggestion;

    public GifViewHolder3(Function1 function1, String str) {
        this.$onTermSelected = function1;
        this.$suggestion = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$onTermSelected;
        if (function1 != null) {
        }
    }
}
