package com.discord.widgets.guilds.contextmenu;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelGuildFolder;
import com.discord.widgets.guilds.contextmenu.FolderContextMenuViewModel;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import rx.functions.Func2;

/* compiled from: FolderContextMenuViewModel.kt */
/* loaded from: classes2.dex */
public final class FolderContextMenuViewModel$Companion$observeStoreState$1<T1, T2, R> implements Func2<List<? extends ModelGuildFolder>, Set<? extends Long>, FolderContextMenuViewModel.StoreState> {
    public final /* synthetic */ long $folderId;

    public FolderContextMenuViewModel$Companion$observeStoreState$1(long j) {
        this.$folderId = j;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ FolderContextMenuViewModel.StoreState call(List<? extends ModelGuildFolder> list, Set<? extends Long> set) {
        return call2((List<ModelGuildFolder>) list, (Set<Long>) set);
    }

    /* renamed from: call, reason: avoid collision after fix types in other method */
    public final FolderContextMenuViewModel.StoreState call2(List<ModelGuildFolder> list, Set<Long> set) {
        Object next;
        m.checkNotNullExpressionValue(list, "guildFolders");
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
            return FolderContextMenuViewModel.StoreState.Invalid.INSTANCE;
        }
        m.checkNotNullExpressionValue(set, "unreadGuildIds");
        return new FolderContextMenuViewModel.StoreState.Valid(modelGuildFolder, set);
    }
}
