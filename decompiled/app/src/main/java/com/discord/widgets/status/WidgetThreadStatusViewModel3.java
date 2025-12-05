package com.discord.widgets.status;

import com.discord.utilities.error.Error;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetThreadStatusViewModel.kt */
/* renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$onJoinTapped$$inlined$let$lambda$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel3 extends Lambda implements Function1<Error, Unit> {
    public final /* synthetic */ WidgetThreadStatusViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadStatusViewModel3(WidgetThreadStatusViewModel widgetThreadStatusViewModel) {
        super(1);
        this.this$0 = widgetThreadStatusViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.f27425a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        Intrinsics3.checkNotNullParameter(error, "error");
        WidgetThreadStatusViewModel widgetThreadStatusViewModel = this.this$0;
        Error.Response response = error.getResponse();
        Intrinsics3.checkNotNullExpressionValue(response, "error.response");
        WidgetThreadStatusViewModel.access$emitError(widgetThreadStatusViewModel, response.getCode());
    }
}
