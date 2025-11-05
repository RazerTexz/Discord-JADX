package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import kotlin.jvm.functions.Function1;

/* compiled from: GifViewHolder.kt */
/* loaded from: classes2.dex */
public final class GifViewHolder$SuggestedTerms$configureSearchTerms$1 implements View.OnClickListener {
    public final /* synthetic */ Function1 $onTermSelected;
    public final /* synthetic */ String $suggestion;

    public GifViewHolder$SuggestedTerms$configureSearchTerms$1(Function1 function1, String str) {
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
