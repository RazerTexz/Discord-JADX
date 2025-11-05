package com.discord.widgets.contact_sync;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: ContactSyncPermissionsSheet.kt */
/* loaded from: classes2.dex */
public final class ContactSyncPermissionsSheet$viewModel$2 extends o implements Function0<WidgetContactSyncViewModel> {
    public final /* synthetic */ ContactSyncPermissionsSheet this$0;

    /* compiled from: ContactSyncPermissionsSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncPermissionsSheet$viewModel$2$1, reason: invalid class name */
    public static final class AnonymousClass1 extends o implements Function1<Error, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

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
            m.checkNotNullParameter(error, "it");
            Logger.e$default(AppLog.g, "Invalid CAPTCHA: We shouldn't be interacting with CAPTCHA on this screen.", null, null, 6, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncPermissionsSheet$viewModel$2(ContactSyncPermissionsSheet contactSyncPermissionsSheet) {
        super(0);
        this.this$0 = contactSyncPermissionsSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        return new WidgetContactSyncViewModel(WidgetContactSync.INSTANCE.getContactSyncModeFromIntent(this.this$0.requireAppActivity()), false, false, null, null, null, false, AnonymousClass1.INSTANCE, 126, null);
    }
}
