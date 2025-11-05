package com.discord.widgets.media;

import com.discord.databinding.WidgetQrScannerBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetQRScanner.kt */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetQRScanner$binding$3 extends k implements Function1<WidgetQrScannerBinding, Unit> {
    public WidgetQRScanner$binding$3(WidgetQRScanner widgetQRScanner) {
        super(1, widgetQRScanner, WidgetQRScanner.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetQrScannerBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetQrScannerBinding widgetQrScannerBinding) {
        invoke2(widgetQrScannerBinding);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetQrScannerBinding widgetQrScannerBinding) {
        m.checkNotNullParameter(widgetQrScannerBinding, "p1");
        WidgetQRScanner.access$onViewBindingDestroy((WidgetQRScanner) this.receiver, widgetQrScannerBinding);
    }
}
