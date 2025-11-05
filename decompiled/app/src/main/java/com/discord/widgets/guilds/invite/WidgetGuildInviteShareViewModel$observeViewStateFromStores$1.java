package com.discord.widgets.guilds.invite;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import com.discord.widgets.guilds.invite.InviteSuggestion;
import com.discord.widgets.guilds.invite.InviteSuggestionItem;
import com.discord.widgets.guilds.invite.WidgetGuildInviteShareViewModel;
import d0.g0.t;
import d0.g0.w;
import d0.t.h0;
import d0.t.n0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import rx.functions.Func5;

/* compiled from: WidgetGuildInviteShareViewModel.kt */
/* loaded from: classes2.dex */
public final class WidgetGuildInviteShareViewModel$observeViewStateFromStores$1<T1, T2, T3, T4, T5, R> implements Func5<WidgetInviteModel, List<? extends InviteSuggestion>, String, Map<String, ? extends Set<? extends Long>>, Unit, WidgetGuildInviteShareViewModel.ViewState.Loaded> {
    public final /* synthetic */ WidgetGuildInviteShareViewModel this$0;

    public WidgetGuildInviteShareViewModel$observeViewStateFromStores$1(WidgetGuildInviteShareViewModel widgetGuildInviteShareViewModel) {
        this.this$0 = widgetGuildInviteShareViewModel;
    }

    @Override // rx.functions.Func5
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
        m.checkNotNullExpressionValue(map, "sentInvites");
        String strAccess$getInviteLink$p = WidgetGuildInviteShareViewModel.access$getInviteLink$p(this.this$0, widgetInviteModel.getInvite());
        m.checkNotNullExpressionValue(strAccess$getInviteLink$p, "widgetInviteModel.invite.inviteLink");
        Set<Long> setEmptySet = map.get(strAccess$getInviteLink$p);
        if (setEmptySet == null) {
            setEmptySet = n0.emptySet();
        }
        Set<Long> set = setEmptySet;
        boolean z3 = false;
        if (str == null || t.isBlank(str)) {
            m.checkNotNullExpressionValue(list, "inviteSuggestions");
        } else {
            ArrayList arrayListA0 = a.a0(list, "inviteSuggestions");
            for (Object obj : list) {
                InviteSuggestion inviteSuggestion = (InviteSuggestion) obj;
                if (inviteSuggestion instanceof InviteSuggestion.ChannelItem) {
                    zContains = w.contains((CharSequence) ChannelUtils.c(((InviteSuggestion.ChannelItem) inviteSuggestion).getChannel()), (CharSequence) str, true);
                } else {
                    if (!(inviteSuggestion instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    zContains = w.contains((CharSequence) ((InviteSuggestion.UserSuggestion) inviteSuggestion).getUser().getUsername(), (CharSequence) str, true);
                }
                if (zContains) {
                    arrayListA0.add(obj);
                }
            }
            list = arrayListA0;
        }
        List<Channel> dms = widgetInviteModel.getDms();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(dms, 10));
        for (Channel channel : dms) {
            User userA = ChannelUtils.a(channel);
            arrayList.add(d0.o.to(userA != null ? Long.valueOf(userA.getId()) : null, Long.valueOf(channel.getId())));
        }
        Map map2 = h0.toMap(arrayList);
        if (true ^ list.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(list, 10));
            for (InviteSuggestion inviteSuggestion2 : list) {
                if (inviteSuggestion2 instanceof InviteSuggestion.ChannelItem) {
                    InviteSuggestion.ChannelItem channelItem = (InviteSuggestion.ChannelItem) inviteSuggestion2;
                    userItem = new InviteSuggestionItem.ChannelItem(channelItem.getChannel(), set.contains(Long.valueOf(channelItem.getChannel().getId())));
                } else {
                    if (!(inviteSuggestion2 instanceof InviteSuggestion.UserSuggestion)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    InviteSuggestion.UserSuggestion userSuggestion = (InviteSuggestion.UserSuggestion) inviteSuggestion2;
                    userItem = new InviteSuggestionItem.UserItem(userSuggestion.getUser(), u.contains(set, map2.get(Long.valueOf(userSuggestion.getUser().getId()))));
                }
                arrayList2.add(userItem);
            }
            arrayListListOf = arrayList2;
        } else if (!(str == null || t.isBlank(str))) {
            arrayListListOf = d0.t.m.listOf(InviteSuggestionItem.INSTANCE);
        }
        if (widgetInviteModel.getInvite() != null) {
            if (!widgetInviteModel.getInvite().isStatic() && !widgetInviteModel.isInviteFromStore()) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = true;
        }
        m.checkNotNullExpressionValue(widgetInviteModel, "widgetInviteModel");
        m.checkNotNullExpressionValue(str, "filter");
        return new WidgetGuildInviteShareViewModel.ViewState.Loaded(widgetInviteModel, arrayListListOf, str, map, z2);
    }
}
