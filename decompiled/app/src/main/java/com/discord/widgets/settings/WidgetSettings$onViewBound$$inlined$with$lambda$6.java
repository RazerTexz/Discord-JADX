package com.discord.widgets.settings;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.databinding.WidgetSettingsBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* compiled from: WidgetSettings.kt */
/* loaded from: classes2.dex */
public final class WidgetSettings$onViewBound$$inlined$with$lambda$6 implements View.OnClickListener {
    public final /* synthetic */ WidgetSettingsBinding $this_with;
    public final /* synthetic */ WidgetSettings this$0;

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        public static /* synthetic */ void invoke$default(AnonymousClass1 anonymousClass1, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            anonymousClass1.invoke(z2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            WidgetSettings widgetSettings;
            int i;
            TextView textView = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.$this_with.J;
            Intrinsics3.checkNotNullExpressionValue(textView, "uploadDebugLogs");
            textView.setEnabled(z2);
            TextView textView2 = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.$this_with.J;
            Intrinsics3.checkNotNullExpressionValue(textView2, "uploadDebugLogs");
            if (z2) {
                widgetSettings = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0;
                i = R.string.upload_debug_logs;
            } else {
                widgetSettings = WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0;
                i = R.string.working;
            }
            textView2.setText(widgetSettings.getString(i));
        }
    }

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$2, reason: invalid class name */
    public static final class AnonymousClass2 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$updateUploadDebugLogsUI$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r4) {
            AppToast.i(WidgetSettings$onViewBound$$inlined$with$lambda$6.this.this$0, R.string.upload_debug_log_success, 0, 4);
            AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$3, reason: invalid class name */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(AnonymousClass1 anonymousClass1) {
            super(1);
            this.$updateUploadDebugLogsUI$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    /* compiled from: WidgetSettings.kt */
    /* renamed from: com.discord.widgets.settings.WidgetSettings$onViewBound$$inlined$with$lambda$6$4, reason: invalid class name */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AnonymousClass1 $updateUploadDebugLogsUI$1;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AnonymousClass1 anonymousClass1) {
            super(0);
            this.$updateUploadDebugLogsUI$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            AnonymousClass1.invoke$default(this.$updateUploadDebugLogsUI$1, false, 1, null);
        }
    }

    public WidgetSettings$onViewBound$$inlined$with$lambda$6(WidgetSettingsBinding widgetSettingsBinding, WidgetSettings widgetSettings) {
        this.$this_with = widgetSettingsBinding;
        this.this$0 = widgetSettings;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1();
        anonymousClass1.invoke(false);
        Observable observableUi$default = ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.uploadSystemLog(), this.this$0, null, 2, null);
        Context context = this.this$0.getContext();
        String name = this.$this_with.getClass().getName();
        Intrinsics3.checkNotNullExpressionValue(name, "javaClass.name");
        ObservableExtensionsKt.appSubscribe$default(observableUi$default, context, name, (Function1) null, new AnonymousClass2(anonymousClass1), new AnonymousClass3(anonymousClass1), new AnonymousClass4(anonymousClass1), (Function0) null, 68, (Object) null);
    }
}
