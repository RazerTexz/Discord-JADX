package com.discord.widgets.settings;

import android.view.View;
import com.discord.widgets.media.WidgetQRScanner;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$3 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettings this$0;

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$3$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetQRScanner.Companion.launch$default(WidgetQRScanner.INSTANCE, WidgetSettings$onViewBound$$inlined$with$lambda$3.this.this$0.requireContext(), false, 2, null);
        }
    }

    public WidgetSettings$onViewBound$$inlined$with$lambda$3(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.requestCameraQRScanner(new AnonymousClass1());
    }
}
