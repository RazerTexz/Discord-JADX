package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import kotlin.jvm.functions.Function1;

/* compiled from: GifViewHolder.kt */
/* loaded from: classes2.dex */
public final class GifViewHolder$Gif$configure$1 implements View.OnClickListener {
    public final /* synthetic */ GifAdapterItem.GifItem $gifItem;
    public final /* synthetic */ Function1 $onSelectGif;

    public GifViewHolder$Gif$configure$1(Function1 function1, GifAdapterItem.GifItem gifItem) {
        this.$onSelectGif = function1;
        this.$gifItem = gifItem;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Function1 function1 = this.$onSelectGif;
        if (function1 != null) {
        }
    }
}
