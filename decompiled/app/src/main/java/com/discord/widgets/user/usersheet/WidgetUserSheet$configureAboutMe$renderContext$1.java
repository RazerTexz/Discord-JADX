package com.discord.widgets.user.usersheet;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetUserSheet.kt */
/* loaded from: classes.dex */
public final /* synthetic */ class WidgetUserSheet$configureAboutMe$renderContext$1 extends FunctionReferenceImpl implements Function1<SpoilerNode<?>, Unit> {
    public WidgetUserSheet$configureAboutMe$renderContext$1(WidgetUserSheetViewModel widgetUserSheetViewModel) {
        super(1, widgetUserSheetViewModel, WidgetUserSheetViewModel.class, "handleBioIndexClicked", "handleBioIndexClicked(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        Intrinsics3.checkNotNullParameter(spoilerNode, "p1");
        ((WidgetUserSheetViewModel) this.receiver).handleBioIndexClicked(spoilerNode);
    }
}
