package com.discord.widgets.tos;

import android.view.View;
import com.discord.restapi.RestAPIParams;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import p007b.p008a.p018d.C0879o;

/* compiled from: WidgetTos.kt */
/* renamed from: com.discord.widgets.tos.WidgetTos$configureAgreementUI$$inlined$with$lambda$1, reason: use source file name */
/* loaded from: classes.dex */
public final class WidgetTos3 implements View.OnClickListener {
    public final /* synthetic */ WidgetTos this$0;

    public WidgetTos3(WidgetTos widgetTos) {
        this.this$0 = widgetTos;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().userAgreements(RestAPIParams.UserAgreements.INSTANCE.agree()), false, 1, null), this.this$0, null, 2, null).m11108k(C0879o.f566a.m184g(this.this$0.getContext(), WidgetTos4.INSTANCE, null));
        this.this$0.requireActivity().finish();
    }
}
