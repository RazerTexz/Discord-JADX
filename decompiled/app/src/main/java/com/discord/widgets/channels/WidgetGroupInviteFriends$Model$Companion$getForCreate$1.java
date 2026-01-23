package com.discord.widgets.channels;

import com.discord.models.user.User;
import com.discord.widgets.channels.WidgetGroupInviteFriends;
import java.util.Collection;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.FunctionReferenceImpl;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: compiled from: WidgetGroupInviteFriends.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetGroupInviteFriends$Model$Companion$getForCreate$1 extends FunctionReferenceImpl implements Function2<Collection<? extends User>, String, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput> {
    public static final WidgetGroupInviteFriends$Model$Companion$getForCreate$1 INSTANCE = new WidgetGroupInviteFriends$Model$Companion$getForCreate$1();

    public WidgetGroupInviteFriends$Model$Companion$getForCreate$1() {
        super(2, WidgetGroupInviteFriends.Model.Companion.AddedUsersInput.class, "<init>", "<init>(Ljava/util/Collection;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke(Collection<? extends User> collection, String str) {
        return invoke2(collection, str);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGroupInviteFriends.Model.Companion.AddedUsersInput invoke2(Collection<? extends User> collection, String str) {
        Intrinsics3.checkNotNullParameter(collection, "p1");
        Intrinsics3.checkNotNullParameter(str, "p2");
        return new WidgetGroupInviteFriends.Model.Companion.AddedUsersInput(collection, str);
    }
}
