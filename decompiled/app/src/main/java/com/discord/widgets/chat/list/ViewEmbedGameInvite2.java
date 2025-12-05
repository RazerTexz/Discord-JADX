package com.discord.widgets.chat.list;

import com.discord.api.activity.Activity;
import com.discord.api.application.Application;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import java.util.Map;
import kotlin.jvm.functions.Function5;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ViewEmbedGameInvite.kt */
/* renamed from: com.discord.widgets.chat.list.ViewEmbedGameInvite$Model$Companion$get$1, reason: use source file name */
/* loaded from: classes2.dex */
public final /* synthetic */ class ViewEmbedGameInvite2 extends FunctionReferenceImpl implements Function5<GameInviteEntry, MeUser, Application, Activity, Map<Long, ? extends User>, ViewEmbedGameInvite.Model> {
    public ViewEmbedGameInvite2(ViewEmbedGameInvite.Model.Companion companion) {
        super(5, companion, ViewEmbedGameInvite.Model.Companion.class, "create", "create(Lcom/discord/widgets/chat/list/entries/GameInviteEntry;Lcom/discord/models/user/MeUser;Lcom/discord/api/application/Application;Lcom/discord/api/activity/Activity;Ljava/util/Map;)Lcom/discord/widgets/chat/list/ViewEmbedGameInvite$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ ViewEmbedGameInvite.Model invoke(GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map<Long, ? extends User> map) {
        return invoke2(gameInviteEntry, meUser, application, activity, map);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final ViewEmbedGameInvite.Model invoke2(GameInviteEntry gameInviteEntry, MeUser meUser, Application application, Activity activity, Map<Long, ? extends User> map) {
        Intrinsics3.checkNotNullParameter(gameInviteEntry, "p1");
        Intrinsics3.checkNotNullParameter(meUser, "p2");
        Intrinsics3.checkNotNullParameter(map, "p5");
        return ViewEmbedGameInvite.Model.Companion.access$create((ViewEmbedGameInvite.Model.Companion) this.receiver, gameInviteEntry, meUser, application, activity, map);
    }
}
