package com.discord.stores;

import com.discord.api.commands.ApplicationCommandData3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* compiled from: StoreApplicationCommands.kt */
/* loaded from: classes2.dex */
public final class StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1 extends Lambda implements Function1<ApplicationCommandData3, ApplicationCommandData3> {
    public static final StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1 INSTANCE = new StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1();

    public StoreApplicationCommands$requestApplicationCommandAutocompleteData$1$apiCommandData$1() {
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
