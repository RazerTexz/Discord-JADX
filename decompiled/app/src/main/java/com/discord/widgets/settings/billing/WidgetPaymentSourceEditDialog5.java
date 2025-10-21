package com.discord.widgets.settings.billing;

import android.content.Context;
import android.content.res.AssetManager;
import com.adjust.sdk.Constants;
import com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog;
import com.google.gson.Gson;
import d0.y.Closeable;
import d0.z.d.Lambda;
import java.io.IOException;
import java.io.InputStreamReader;
import kotlin.jvm.functions.Function0;

/* compiled from: WidgetPaymentSourceEditDialog.kt */
/* renamed from: com.discord.widgets.settings.billing.WidgetPaymentSourceEditDialog$usStates$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetPaymentSourceEditDialog5 extends Lambda implements Function0<WidgetPaymentSourceEditDialog.StateEntry[]> {
    public final /* synthetic */ WidgetPaymentSourceEditDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPaymentSourceEditDialog5(WidgetPaymentSourceEditDialog widgetPaymentSourceEditDialog) {
        super(0);
        this.this$0 = widgetPaymentSourceEditDialog;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetPaymentSourceEditDialog.StateEntry[] invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetPaymentSourceEditDialog.StateEntry[] invoke2() throws IOException {
        AssetManager assets;
        Context context = this.this$0.getContext();
        InputStreamReader inputStreamReader = new InputStreamReader((context == null || (assets = context.getAssets()) == null) ? null : assets.open("data/states.json"), Constants.ENCODING);
        try {
            WidgetPaymentSourceEditDialog.StateEntry[] stateEntryArr = (WidgetPaymentSourceEditDialog.StateEntry[]) new Gson().e(inputStreamReader, WidgetPaymentSourceEditDialog.StateEntry[].class);
            Closeable.closeFinally(inputStreamReader, null);
            return stateEntryArr;
        } finally {
        }
    }
}
