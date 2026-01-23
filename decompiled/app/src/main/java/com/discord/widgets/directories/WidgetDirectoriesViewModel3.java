package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p592z.p594d.Lambda;

/* JADX INFO: renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$ViewState$allDirectoryEntryData$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetDirectoriesViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel3 extends Lambda implements Function0<List<? extends DirectoryEntryData>> {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel3(WidgetDirectoriesViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends DirectoryEntryData> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends DirectoryEntryData> invoke2() {
        List<DirectoryEntryGuild> listInvoke = this.this$0.getDirectories().invoke();
        if (listInvoke == null) {
            listInvoke = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listInvoke, 10));
        for (DirectoryEntryGuild directoryEntryGuild : listInvoke) {
            arrayList.add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return arrayList;
    }
}
