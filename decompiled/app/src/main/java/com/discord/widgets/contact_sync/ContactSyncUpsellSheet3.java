package com.discord.widgets.contact_sync;

import com.discord.app.AppLog;
import com.discord.utilities.error.Error;
import com.discord.utilities.logging.Logger;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: ContactSyncUpsellSheet.kt */
/* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$viewModel$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class ContactSyncUpsellSheet3 extends Lambda implements Function0<WidgetContactSyncViewModel> {
    public static final ContactSyncUpsellSheet3 INSTANCE = new ContactSyncUpsellSheet3();

    /* compiled from: ContactSyncUpsellSheet.kt */
    /* renamed from: com.discord.widgets.contact_sync.ContactSyncUpsellSheet$viewModel$2$1 */
    public static final class C82221 extends Lambda implements Function1<Error, Unit> {
        public static final C82221 INSTANCE = new C82221();

        public C82221() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            Logger.e$default(AppLog.f14950g, "Invalid CAPTCHA: We shouldn't be interacting with CAPTCHA on this screen.", null, null, 6, null);
        }
    }

    public ContactSyncUpsellSheet3() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetContactSyncViewModel invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetContactSyncViewModel invoke() {
        return new WidgetContactSyncViewModel(ContactSyncMode.DEFAULT, false, false, null, null, null, false, C82221.INSTANCE, 126, null);
    }
}
