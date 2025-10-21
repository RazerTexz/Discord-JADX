package com.discord.models.commands;

import com.discord.api.commands.ApplicationCommandData3;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref$IntRef;

/* compiled from: ApplicationCommandLocalSendData.kt */
/* renamed from: com.discord.models.commands.ApplicationCommandLocalSendData$toRestApiApplicationCommandDataParam$attachmentConvertedOptions$1, reason: use source file name */
/* loaded from: classes.dex */
public final class ApplicationCommandLocalSendData2 extends Lambda implements Function1<ApplicationCommandData3, ApplicationCommandData3> {
    public final /* synthetic */ Ref$IntRef $attachmentCounter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandLocalSendData2(Ref$IntRef ref$IntRef) {
        super(1);
        this.$attachmentCounter = ref$IntRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ ApplicationCommandData3 invoke(ApplicationCommandData3 applicationCommandData3) {
        return invoke2(applicationCommandData3);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ApplicationCommandData3 invoke2(ApplicationCommandData3 applicationCommandData3) {
        Intrinsics3.checkNotNullParameter(applicationCommandData3, "it");
        if (applicationCommandData3.getType() != 11) {
            return applicationCommandData3;
        }
        ApplicationCommandData3 applicationCommandData3A = ApplicationCommandData3.a(applicationCommandData3, null, String.valueOf(this.$attachmentCounter.element), 0, null, null, 29);
        this.$attachmentCounter.element++;
        return applicationCommandData3A;
    }
}
