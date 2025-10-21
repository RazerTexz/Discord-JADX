package com.discord.utilities.intent;

import androidx.fragment.app.FragmentActivity;
import com.discord.stores.StoreInviteSettings;
import com.discord.widgets.guilds.create.WidgetGuildCreate;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: RouteHandlers.kt */
/* loaded from: classes2.dex */
public final class RouteHandlers$selectFeature$settingMap$4 extends Lambda implements Function1<FragmentActivity, Unit> {
    public static final RouteHandlers$selectFeature$settingMap$4 INSTANCE = new RouteHandlers$selectFeature$settingMap$4();

    public RouteHandlers$selectFeature$settingMap$4() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
        invoke2(fragmentActivity);
        return Unit.a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FragmentActivity fragmentActivity) {
        Intrinsics3.checkNotNullParameter(fragmentActivity, "ctx");
        WidgetGuildCreate.INSTANCE.show(fragmentActivity, new WidgetGuildCreate.Options(StoreInviteSettings.LOCATION_DEEPLINK, null, false, null, false, 30, null));
    }
}
