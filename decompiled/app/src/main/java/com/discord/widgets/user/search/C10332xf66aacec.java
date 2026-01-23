package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import java.util.HashSet;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2 */
/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10332xf66aacec extends Lambda implements Function1<Channel, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ HashSet $seenUsersIds;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10332xf66aacec(HashSet hashSet, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.UsersContext usersContext, String str, WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4) {
        super(1);
        this.$seenUsersIds = hashSet;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$usersContext = usersContext;
        this.$sanitizedFilter = str;
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel) {
        return invoke2(channel);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel.ItemDataPayload invoke2(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        User userM7677a = ChannelUtils.m7677a(channel);
        if (userM7677a != null) {
            this.$seenUsersIds.add(Long.valueOf(userM7677a.getId()));
            WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2 = this.$toItemUser$2;
            User user = (User) outline.m849f(userM7677a, this.$usersContext.getUsers());
            if (user != null) {
                userM7677a = user;
            }
            WidgetGlobalSearchModel.ItemUser itemUserInvoke2 = widgetGlobalSearchModel$Companion$create$2.invoke2(userM7677a, this.$sanitizedFilter, channel);
            if (itemUserInvoke2 != null) {
                return itemUserInvoke2;
            }
        }
        return this.$toItemChannel$4.invoke2(channel, this.$sanitizedFilter);
    }
}
