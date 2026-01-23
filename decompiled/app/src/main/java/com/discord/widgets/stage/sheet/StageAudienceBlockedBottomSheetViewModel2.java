package com.discord.widgets.stage.sheet;

import androidx.core.app.NotificationCompat;
import com.discord.widgets.stage.StageRoles;
import com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel;
import com.discord.widgets.voice.model.CallModel;
import java.util.Map;
import java.util.Set;
import p507d0.p580t.Maps6;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.StageAudienceBlockedBottomSheetViewModel$Companion$observeStores$1, reason: use source file name */
/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetViewModel2<T1, T2, T3, R> implements Func3<CallModel, Map<Long, ? extends Integer>, Map<Long, ? extends StageRoles>, StageAudienceBlockedBottomSheetViewModel.StoreState> {
    public final /* synthetic */ long $channelId;

    public StageAudienceBlockedBottomSheetViewModel2(long j) {
        this.$channelId = j;
    }

    @Override // p658rx.functions.Func3
    public /* bridge */ /* synthetic */ StageAudienceBlockedBottomSheetViewModel.StoreState call(CallModel callModel, Map<Long, ? extends Integer> map, Map<Long, ? extends StageRoles> map2) {
        return call2(callModel, (Map<Long, Integer>) map, (Map<Long, StageRoles>) map2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final StageAudienceBlockedBottomSheetViewModel.StoreState call2(CallModel callModel, Map<Long, Integer> map, Map<Long, StageRoles> map2) {
        long j = this.$channelId;
        Set<Long> setKeySet = map.keySet();
        if (map2 == null) {
            map2 = Maps6.emptyMap();
        }
        return new StageAudienceBlockedBottomSheetViewModel.StoreState(j, callModel, setKeySet, map2);
    }
}
