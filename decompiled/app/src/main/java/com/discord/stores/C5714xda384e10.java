package com.discord.stores;

import com.discord.api.commands.ApplicationCommandData3;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* compiled from: StoreApplicationCommands.kt */
/* renamed from: com.discord.stores.StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1 */
/* loaded from: classes2.dex */
public final class C5714xda384e10 extends Lambda implements Function1<ApplicationCommandData3, ApplicationCommandData3> {
    public static final C5714xda384e10 INSTANCE = new C5714xda384e10();

    public C5714xda384e10() {
        super(1);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandData3 invoke2(ApplicationCommandData3 applicationCommandData3) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
        return applicationCommandData3;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandData3 invoke(ApplicationCommandData3 applicationCommandData3) {
        return invoke2(applicationCommandData3);
    }
}
