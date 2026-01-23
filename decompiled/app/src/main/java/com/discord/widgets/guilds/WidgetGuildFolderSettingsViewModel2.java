package com.discord.widgets.guilds;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.stores.StoreGuildsSorted;
import com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel;
import java.util.Iterator;
import java.util.List;
import p507d0.p592z.p594d.Intrinsics3;
import p658rx.functions.Func2;

/* JADX INFO: renamed from: com.discord.widgets.guilds.WidgetGuildFolderSettingsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetGuildFolderSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildFolderSettingsViewModel2<T1, T2, R> implements Func2<List<? extends ModelGuildFolder>, List<? extends StoreGuildsSorted.Entry>, WidgetGuildFolderSettingsViewModel.StoreState> {
    public final /* synthetic */ long $folderId;

    public WidgetGuildFolderSettingsViewModel2(long j) {
        this.$folderId = j;
    }

    @Override // p658rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGuildFolderSettingsViewModel.StoreState call(List<? extends ModelGuildFolder> list, List<? extends StoreGuildsSorted.Entry> list2) {
        return call2((List<ModelGuildFolder>) list, list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGuildFolderSettingsViewModel.StoreState call2(List<ModelGuildFolder> list, List<? extends StoreGuildsSorted.Entry> list2) {
        Object next;
        Intrinsics3.checkNotNullExpressionValue(list, "guildFolders");
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            Long id2 = ((ModelGuildFolder) next).getId();
            if (id2 != null && id2.longValue() == this.$folderId) {
                break;
            }
        }
        ModelGuildFolder modelGuildFolder = (ModelGuildFolder) next;
        if (modelGuildFolder == null) {
            return WidgetGuildFolderSettingsViewModel.StoreState.Invalid.INSTANCE;
        }
        Intrinsics3.checkNotNullExpressionValue(list2, "sortedGuilds");
        return new WidgetGuildFolderSettingsViewModel.StoreState.Valid(modelGuildFolder, list2);
    }
}
