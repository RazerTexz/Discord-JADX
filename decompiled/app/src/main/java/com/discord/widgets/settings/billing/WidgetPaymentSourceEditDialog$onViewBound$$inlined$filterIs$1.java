package com.discord.widgets.settings.billing;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.discord.widgets.settings.billing.SettingsBillingViewModel;
import p637j0.p641k.Func1;

/* compiled from: ObservableExtensions.kt */
/* loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1<T, R> implements Func1<Object, Boolean> {
    public static final WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1 INSTANCE = new WidgetPaymentSourceEditDialog$onViewBound$$inlined$filterIs$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p637j0.p641k.Func1
    public final Boolean call(Object obj) {
        return Boolean.valueOf(obj instanceof SettingsBillingViewModel.ViewState.Loaded);
    }

    @Override // p637j0.p641k.Func1
    public /* bridge */ /* synthetic */ Boolean call(Object obj) {
        return call(obj);
    }
}
