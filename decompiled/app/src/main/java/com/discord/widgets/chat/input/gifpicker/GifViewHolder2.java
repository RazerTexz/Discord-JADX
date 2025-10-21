package com.discord.widgets.chat.input.gifpicker;

import android.view.View;
import com.discord.widgets.chat.input.gifpicker.GifAdapterItem;
import kotlin.jvm.functions.Function1;

/* compiled from: GifViewHolder.kt */
/* renamed from: com.discord.widgets.chat.input.gifpicker.GifViewHolder$Gif$configure$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class GifViewHolder2 implements View.OnClickListener {
    public final /* synthetic */ GifAdapterItem.GifItem $gifItem;
    public final /* synthetic */ Function1 $onSelectGif;

    public GifViewHolder2(Function1 function1, GifAdapterItem.GifItem gifItem) {
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
