package com.discord.widgets.user.usersheet;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p007b.p008a.p009a.ConnectedAccountActionsDialog;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetUserSheet.kt */
/* renamed from: com.discord.widgets.user.usersheet.WidgetUserSheet$configureConnectionsSection$onConnectedAccountClick$1 */
/* loaded from: classes.dex */
public final class C10344xa5617a90 extends Lambda implements Function3<String, Integer, String, Unit> {
    public final /* synthetic */ WidgetUserSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10344xa5617a90(WidgetUserSheet widgetUserSheet) {
        super(3);
        this.this$0 = widgetUserSheet;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(String str, Integer num, String str2) {
        invoke(str, num.intValue(), str2);
        return Unit.f27425a;
    }

    public final void invoke(String str, int i, String str2) {
        Intrinsics3.checkNotNullParameter(str, "username");
        ConnectedAccountActionsDialog.Companion companion = ConnectedAccountActionsDialog.INSTANCE;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(str, "username");
        ConnectedAccountActionsDialog connectedAccountActionsDialog = new ConnectedAccountActionsDialog();
        Bundle bundle = new Bundle();
        bundle.putString("ARG_USERNAME", str);
        bundle.putInt("ARG_THEMED_PLATFORM_IMAGE_RES", i);
        bundle.putString("ARG_PROFILE_URL", str2);
        connectedAccountActionsDialog.setArguments(bundle);
        connectedAccountActionsDialog.show(parentFragmentManager, ConnectedAccountActionsDialog.class.getName());
    }
}
