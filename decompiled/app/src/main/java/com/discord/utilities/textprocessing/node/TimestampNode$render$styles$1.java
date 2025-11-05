package com.discord.utilities.textprocessing.node;

import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.textprocessing.node.TimestampNode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TimestampNode.kt */
/* loaded from: classes2.dex */
public final class TimestampNode$render$styles$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ TimestampNode.RenderContext $renderContext;
    public final /* synthetic */ TimestampNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimestampNode$render$styles$1(TimestampNode timestampNode, TimestampNode.RenderContext renderContext) {
        super(1);
        this.this$0 = timestampNode;
        this.$renderContext = renderContext;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        this.$renderContext.onTimestampClicked(this.this$0.getFull());
    }
}
