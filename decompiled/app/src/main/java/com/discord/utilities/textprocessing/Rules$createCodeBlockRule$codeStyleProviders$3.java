package com.discord.utilities.textprocessing;

import android.text.style.TextAppearanceSpan;
import androidx.exifinterface.media.ExifInterface;
import com.discord.C5419R;
import com.discord.simpleast.core.node.StyleNode;
import com.discord.utilities.textprocessing.node.BasicRenderContext;
import p507d0.p580t.CollectionsJVM;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: Rules.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Rules$createCodeBlockRule$codeStyleProviders$3<RC> implements StyleNode.InterfaceC5656a<RC> {
    public static final Rules$createCodeBlockRule$codeStyleProviders$3 INSTANCE = new Rules$createCodeBlockRule$codeStyleProviders$3();

    @Override // com.discord.simpleast.core.node.StyleNode.InterfaceC5656a
    public /* bridge */ /* synthetic */ Iterable get(Object obj) {
        return get((BasicRenderContext) obj);
    }

    /* JADX WARN: Incorrect types in method signature: (TRC;)Ljava/lang/Iterable<*>; */
    public final Iterable get(BasicRenderContext basicRenderContext) {
        Intrinsics3.checkNotNullParameter(basicRenderContext, "it");
        return CollectionsJVM.listOf(new TextAppearanceSpan(basicRenderContext.getContext(), C5419R.style.Code_TextAppearance_Literal));
    }
}
