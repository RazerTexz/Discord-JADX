package com.discord.widgets.media;

import com.discord.databinding.WidgetQrScannerBinding;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetQRScanner.kt */
/* renamed from: com.discord.widgets.media.WidgetQRScanner$binding$3, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner3 extends FunctionReferenceImpl implements Function1<WidgetQrScannerBinding, Unit> {
    public WidgetQRScanner3(WidgetQRScanner widgetQRScanner) {
        super(1, widgetQRScanner, WidgetQRScanner.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetQrScannerBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetQrScannerBinding widgetQrScannerBinding) {
        invoke2(widgetQrScannerBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetQrScannerBinding widgetQrScannerBinding) {
        Intrinsics3.checkNotNullParameter(widgetQrScannerBinding, "p1");
        WidgetQRScanner.access$onViewBindingDestroy((WidgetQRScanner) this.receiver, widgetQrScannerBinding);
    }
}
