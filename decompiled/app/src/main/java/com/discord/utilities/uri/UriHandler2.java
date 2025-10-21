package com.discord.utilities.uri;

import android.os.Bundle;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import b.a.a.g.WidgetMaskedLinksDialog;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* compiled from: UriHandler.kt */
/* renamed from: com.discord.utilities.uri.UriHandler$handleOrUntrusted$notice$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class UriHandler2 extends Lambda implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ String $url;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UriHandler2(String str) {
        super(1);
        this.$url = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        WidgetMaskedLinksDialog.Companion companion = WidgetMaskedLinksDialog.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        String str = this.$url;
        Objects.requireNonNull(companion);
        Intrinsics3.checkNotNullParameter(supportFragmentManager, "fragmentManager");
        Intrinsics3.checkNotNullParameter(str, "url");
        WidgetMaskedLinksDialog widgetMaskedLinksDialog = new WidgetMaskedLinksDialog();
        Bundle bundle = new Bundle();
        bundle.putString("WIDGET_SPOOPY_LINKS_DIALOG_URL", str);
        widgetMaskedLinksDialog.setArguments(bundle);
        widgetMaskedLinksDialog.show(supportFragmentManager, "WIDGET_SPOOPY_LINKS_DIALOG");
        return true;
    }
}
