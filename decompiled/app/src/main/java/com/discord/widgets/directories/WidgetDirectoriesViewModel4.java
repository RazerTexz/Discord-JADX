package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.WidgetDirectoriesViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetDirectoriesViewModel.kt */
/* renamed from: com.discord.widgets.directories.WidgetDirectoriesViewModel$ViewState$directoryEntryData$2, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetDirectoriesViewModel4 extends Lambda implements Function0<Map<Integer, ? extends List<? extends DirectoryEntryData>>> {
    public final /* synthetic */ WidgetDirectoriesViewModel.ViewState this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetDirectoriesViewModel4(WidgetDirectoriesViewModel.ViewState viewState) {
        super(0);
        this.this$0 = viewState;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Integer, ? extends List<? extends DirectoryEntryData>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Integer, ? extends List<? extends DirectoryEntryData>> invoke2() {
        List<DirectoryEntryGuild> listInvoke = this.this$0.getDirectories().invoke();
        if (listInvoke == null) {
            listInvoke = Collections2.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (DirectoryEntryGuild directoryEntryGuild : listInvoke) {
            Integer numValueOf = Integer.valueOf(directoryEntryGuild.getPrimaryCategoryId());
            Object arrayList = linkedHashMap.get(numValueOf);
            if (arrayList == null) {
                arrayList = new ArrayList();
                linkedHashMap.put(numValueOf, arrayList);
            }
            ((List) arrayList).add(new DirectoryEntryData(directoryEntryGuild, this.this$0.getJoinedGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId())), this.this$0.getAdminGuildIds().contains(Long.valueOf(directoryEntryGuild.getGuild().getId()))));
        }
        return linkedHashMap;
    }
}
