package com.discord.widgets.servers;

import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.widgets.servers.WidgetServerDeleteDialog;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.jvm.functions.Function2;

/* compiled from: WidgetServerDeleteDialog.kt */
/* renamed from: com.discord.widgets.servers.WidgetServerDeleteDialog$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class WidgetServerDeleteDialog2 extends FunctionReferenceImpl implements Function2<MeUser, Guild, WidgetServerDeleteDialog.Model> {
    public static final WidgetServerDeleteDialog2 INSTANCE = new WidgetServerDeleteDialog2();

    public WidgetServerDeleteDialog2() {
        super(2, WidgetServerDeleteDialog.Model.class, "<init>", "<init>(Lcom/discord/models/user/MeUser;Lcom/discord/models/guild/Guild;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetServerDeleteDialog.Model invoke(MeUser meUser, Guild guild) {
        return invoke2(meUser, guild);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetServerDeleteDialog.Model invoke2(MeUser meUser, Guild guild) {
        Intrinsics3.checkNotNullParameter(meUser, "p1");
        return new WidgetServerDeleteDialog.Model(meUser, guild);
    }
}
