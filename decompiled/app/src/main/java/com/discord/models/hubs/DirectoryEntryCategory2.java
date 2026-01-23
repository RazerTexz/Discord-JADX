package com.discord.models.hubs;

import java.util.List;
import p507d0.p580t.Collections2;

/* JADX INFO: renamed from: com.discord.models.hubs.DirectoryEntryCategoryKt, reason: use source file name */
/* JADX INFO: compiled from: DirectoryEntryCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DirectoryEntryCategory2 {
    private static final List<DirectoryEntryCategory> HUB_CATEGORIES = Collections2.listOf((Object[]) new DirectoryEntryCategory[]{DirectoryEntryCategory.SchoolClub, DirectoryEntryCategory.Class, DirectoryEntryCategory.StudySocial, DirectoryEntryCategory.Misc});
    private static final List<DirectoryEntryCategory> HQ_DIRECTORY_CATEGORIES = Collections2.listOf((Object[]) new DirectoryEntryCategory[]{DirectoryEntryCategory.HQSocial, DirectoryEntryCategory.HQErgs, DirectoryEntryCategory.HQMisc, DirectoryEntryCategory.HQArchives});

    public static final /* synthetic */ List access$getHQ_DIRECTORY_CATEGORIES$p() {
        return HQ_DIRECTORY_CATEGORIES;
    }

    public static final /* synthetic */ List access$getHUB_CATEGORIES$p() {
        return HUB_CATEGORIES;
    }
}
