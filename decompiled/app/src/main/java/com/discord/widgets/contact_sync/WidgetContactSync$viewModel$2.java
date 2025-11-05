package com.discord.widgets.contact_sync;

import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.widgets.contact_sync.WidgetContactSync;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: WidgetContactSync.kt */
/* loaded from: classes2.dex */
public final class WidgetContactSync$viewModel$2 extends o implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ WidgetContactSync this$0;

    /* compiled from: WidgetContactSync.kt */
    /* renamed from: com.discord.widgets.contact_sync.WidgetContactSync$viewModel$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            m.checkNotNullParameter(error, "error");
            if (GrowthTeamFeatures.INSTANCE.isPhoneVerifyCaptchaEnabled()) {
                WidgetContactSync.access$launchCaptchaFlow(WidgetContactSync$viewModel$2.this.this$0, error);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetContactSync$viewModel$2(WidgetContactSync widgetContactSync) {
        super(0);
        this.this$0 = widgetContactSync;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        WidgetContactSync.Companion companion = WidgetContactSync.INSTANCE;
        return new WidgetContactSyncViewModel(companion.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), companion.getPhoneDiscoverableFromIntent(this.this$0.requireAppActivity()), companion.getEmailDiscoverableFromIntent(this.this$0.requireAppActivity()), null, null, null, false, new AnonymousClass1(), 120, null);
    }
}
