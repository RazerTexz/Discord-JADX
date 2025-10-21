package com.discord.widgets.tabs;

import androidx.core.app.NotificationCompat;
import com.discord.models.guild.Guild;
import com.discord.panels.PanelState;
import com.discord.widgets.tabs.TabsHostViewModel;
import d0.z.d.Intrinsics3;
import java.util.Map;
import rx.functions.Func6;

/* compiled from: TabsHostViewModel.kt */
/* renamed from: com.discord.widgets.tabs.TabsHostViewModel$Companion$observeStoreState$1, reason: use source file name */
/* loaded from: classes.dex */
public final class TabsHostViewModel2<T1, T2, T3, T4, T5, T6, R> implements Func6<PanelState, NavigationTab, Long, Map<Long, ? extends Guild>, Integer, Map<Long, ? extends Integer>, TabsHostViewModel.StoreState> {
    public static final TabsHostViewModel2 INSTANCE = new TabsHostViewModel2();

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ TabsHostViewModel.StoreState call(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, ? extends Guild> map, Integer num, Map<Long, ? extends Integer> map2) {
        return call2(panelState, navigationTab, l, (Map<Long, Guild>) map, num, (Map<Long, Integer>) map2);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final TabsHostViewModel.StoreState call2(PanelState panelState, NavigationTab navigationTab, Long l, Map<Long, Guild> map, Integer num, Map<Long, Integer> map2) {
        Intrinsics3.checkNotNullExpressionValue(panelState, "leftPanelState");
        Intrinsics3.checkNotNullExpressionValue(navigationTab, "selectedTab");
        Intrinsics3.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        Intrinsics3.checkNotNullExpressionValue(map, "guildIdToGuildMap");
        Intrinsics3.checkNotNullExpressionValue(num, "numTotalMentions");
        int iIntValue = num.intValue();
        Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
        return new TabsHostViewModel.StoreState(panelState, navigationTab, jLongValue, map, iIntValue, map2);
    }
}
