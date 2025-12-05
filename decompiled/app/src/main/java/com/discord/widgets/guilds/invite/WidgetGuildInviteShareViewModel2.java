package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import p007b.p100d.p104b.p105a.outline;
import p507d0.Tuples;
import p507d0.p579g0.Strings4;
import p507d0.p579g0.StringsJVM;
import p507d0.p580t.CollectionsJVM;
import p507d0.p580t.Iterables2;
import p507d0.p580t.Maps6;
import p507d0.p580t.Sets5;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func5;

/* compiled from: WidgetGuildInviteShareViewModel.kt */
/* renamed from: com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel$observeViewStateFromStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel2<T1, T2, T3, T4, T5, R> implements Func5<WidgetInviteModel, List<? extends InviteSuggestion>, String, Map<String, ? extends Set<? extends Long>>, Unit, WidgetGuildInviteShareViewModel.ViewState.Loaded> {
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    public WidgetGuildInviteShareViewModel2(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        this.this$0 = widgetGuildInviteShareViewModel;
    }

    @Override // p658rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetGuildInviteShareViewModel.ViewState.Loaded call(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<? extends Long>> map, Unit unit) {
        return call2(widgetInviteModel, list, str, (Map<String, ? extends Set<Long>>) map, unit);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00e0  */
    /* JADX WARN: Type inference failed for: r11v12, types: [java.util.List] */
    /* renamed from: call, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetGuildInviteShareViewModel.ViewState.Loaded call2(WidgetInviteModel widgetInviteModel, List<? extends InviteSuggestion> list, String str, Map<String, ? extends Set<Long>> map, Unit unit) {
        boolean zContains;
        ArrayList arrayListListOf;
        InviteSuggestionItem userItem;
        boolean z2;
        Intrinsics3.checkNotNullExpressionValue(map, "sentInvites");
        String strAccess$getInviteLink$p = WidgetGuildInviteShareViewModel.access$getInviteLink$p(this.this$0, widgetInviteModel.getInvite());
        Intrinsics3.checkNotNullExpressionValue(strAccess$getInviteLink$p, "widgetInviteModel.invite.inviteLink");
        Set<Long> setEmptySet = map.get(strAccess$getInviteLink$p);
        if (setEmptySet == null) {
            setEmptySet = Sets5.emptySet();
        }
        Set<Long> set = setEmptySet;
        boolean z3 = false;
        if (str == null || StringsJVM.isBlank(str)) {
            Intrinsics3.checkNotNullExpressionValue(list, "inviteSuggestions");
        } else {
            ArrayList arrayListM840a0 = outline.m840a0(list, "inviteSuggestions");
            for (Object obj : list) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                    zContains = Strings4.contains((CharSequence) ChannelUtils.m7679c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) str, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = Strings4.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) str, true);
                }
                if (zContains) {
                    arrayListM840a0.add(obj);
                }
            }
            list = arrayListM840a0;
        }
        List<Channel> dms = widgetInviteModel.getDms();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(dms, 10));
        for (Channel channel : dms) {
            User userM7677a = ChannelUtils.m7677a(channel);
            arrayList.add(Tuples.m10073to(userM7677a != null ? Long.valueOf(userM7677a.getId()) : null, Long.valueOf(channel.getId())));
        }
        Map map2 = Maps6.toMap(arrayList);
        if (true ^ list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(list, 10));
            for (InviteSuggestion inviteSuggestion2 : list) {
                if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                    InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                    userItem = new InviteSuggestionItem.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())));
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                    userItem = new InviteSuggestionItem.UserItem(userSuggestion.getUser(), _Collections.contains(set, map2.get(Long.valueOf(userSuggestion.getUser().getId()))));
                }
                arrayList2.add(userItem);
            }
            arrayListListOf = arrayList2;
        } else if (!(str == null || StringsJVM.isBlank(str))) {
            arrayListListOf = CollectionsJVM.listOf(InviteSuggestionItem.INSTANCE);
        }
        if (widgetInviteModel.getInvite() != null) {
            if (!widgetInviteModel.getInvite().isStatic() && !widgetInviteModel.isInviteFromStore()) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = true;
        }
        Intrinsics3.checkNotNullExpressionValue(widgetInviteModel, "widgetInviteModel");
        Intrinsics3.checkNotNullExpressionValue(str, "filter");
        return new WidgetGuildInviteShareViewModel.ViewState.Loaded(widgetInviteModel, arrayListListOf, str, map, z2);
    }
}
