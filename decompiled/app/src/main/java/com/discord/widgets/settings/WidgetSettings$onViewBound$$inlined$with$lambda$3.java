package com.discord.widgets.settings;

import android.view.View;
import com.discord.widgets.media.WidgetQRScanner;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: compiled from: WidgetSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$3 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettings this$0;

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$3$1 */
    /* JADX INFO: compiled from: WidgetSettings.kt */
    public static final class C96111 extends Lambda implements Function0<Unit> {
        public C96111() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetQRScanner.Companion.launch$default(WidgetQRScanner.INSTANCE, WidgetSettings$onViewBound$$inlined$with$lambda$3.this.this$0.requireContext(), false, 2, null);
        }
    }

    public WidgetSettings$onViewBound$$inlined$with$lambda$3(WidgetSettings widgetSettings) {
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.this$0.requestCameraQRScanner(new C96111());
    }
}
