package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p007b.p008a.p018d.AppToast;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;
import p658rx.Observable;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsBinding $this_with;
    public final /* synthetic */ WidgetSettings this$0;

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$1 */
    public static final class C96121 extends Lambda implements Function1<Boolean, Unit> {
        public C96121() {
            super(1);
        }

        public static /* synthetic */ void invoke$default(C96121 c96121, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            c96121.invoke(z2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            WidgetSettings widgetSettings;
            int i;
            TextView textView = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.$this_with.f17887J;
            Intrinsics3.checkNotNullExpressionValue(textView, "uploadDebugLogs");
            textView.setEnabled(z2);
            TextView textView2 = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.$this_with.f17887J;
            Intrinsics3.checkNotNullExpressionValue(textView2, "uploadDebugLogs");
            if (z2) {
                widgetSettings = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0;
                i = C5419R.string.upload_debug_logs;
            } else {
                widgetSettings = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0;
                i = C5419R.string.working;
            }
            textView2.setText(widgetSettings.getString(i));
        }
    }

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$2 */
    public static final class C96132 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ C96121 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96132(C96121 c96121) {
            super(1);
            this.$updateUploadDebugLogsUI$1 = c96121;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.m171i(WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0, C5419R.string.upload_debug_log_success, 0, 4);
            C96121.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$3 */
    public static final class C96143 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ C96121 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96143(C96121 c96121) {
            super(1);
            this.$updateUploadDebugLogsUI$1 = c96121;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            C96121.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$4 */
    public static final class C96154 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ C96121 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96154(C96121 c96121) {
            super(0);
            this.$updateUploadDebugLogsUI$1 = c96121;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            C96121.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    public WidgetSettings$onViewBound$$inlined$with$lambda$6(WidgetSettingsBinding widgetSettingsBinding, WidgetSettings widgetSettings) {
        this.$this_with = widgetSettingsBinding;
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C96121 c96121 = new C96121();
        c96121.invoke(false);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.uploadSystemLog(), this.this$0, null, 2, null);
        Context context = this.this$0.getContext();
        String name = this.$this_with.getClass().getName();
        Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, context, name, (Function1) null, new C96132(c96121), new C96143(c96121), new C96154(c96121), (Function0) null, 68, (Object) null);
    }
}
