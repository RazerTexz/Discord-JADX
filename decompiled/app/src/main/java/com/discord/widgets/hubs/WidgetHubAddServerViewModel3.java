package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.app.AppLog;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.utilities.RestCallState;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.hubs.WidgetHubAddServerViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p580t.Collections2;
import p507d0.p580t.Iterables2;
import p507d0.p580t._Collections;
import p507d0.p592z.p594d.Lambda;

/* compiled from: WidgetHubAddServerViewModel.kt */
/* renamed from: com.discord.widgets.hubs.WidgetHubAddServerViewModel$Companion$observeStores$1, reason: use source file name */
/* loaded from: classes2.dex */
public final class WidgetHubAddServerViewModel3 extends Lambda implements Function0<WidgetHubAddServerViewModel2> {
    public final /* synthetic */ StoreChannelsSelected $channelsSelectedStore;
    public final /* synthetic */ StoreChannels $channelsStore;
    public final /* synthetic */ StoreDirectories $directoriesStore;
    public final /* synthetic */ StoreGuildSelected $guildsSelected;
    public final /* synthetic */ StoreGuilds $guildsStore;
    public final /* synthetic */ StorePermissions $permissionsStore;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubAddServerViewModel3(StoreGuilds storeGuilds, StoreGuildSelected storeGuildSelected, StorePermissions storePermissions, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StoreDirectories storeDirectories) {
        super(0);
        this.$guildsStore = storeGuilds;
        this.$guildsSelected = storeGuildSelected;
        this.$permissionsStore = storePermissions;
        this.$channelsSelectedStore = storeChannelsSelected;
        this.$channelsStore = storeChannels;
        this.$directoriesStore = storeDirectories;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ WidgetHubAddServerViewModel2 invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00f2  */
    @Override // kotlin.jvm.functions.Function0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final WidgetHubAddServerViewModel2 invoke() {
        Object next;
        Object next2;
        List<DirectoryEntryGuild> listInvoke;
        Collection<Guild> collectionValues = this.$guildsStore.getGuilds().values();
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((Guild) next).getId() == this.$guildsSelected.getSelectedGuildId()) {
                break;
            }
        }
        Guild guild = (Guild) next;
        if (guild == null) {
            WidgetHubAddServerViewModel.Companion companion = WidgetHubAddServerViewModel.INSTANCE;
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = outline.m833U("Missing guild for guild id: ");
            sbM833U.append(this.$guildsSelected.getSelectedGuildId());
            Logger.e$default(appLog, sbM833U.toString(), null, null, 6, null);
            guild = null;
        }
        Map<Long, Long> guildPermissions = this.$permissionsStore.getGuildPermissions();
        Channel selectedChannel = this.$channelsSelectedStore.getSelectedChannel();
        if (selectedChannel == null) {
            Iterator<T> it2 = this.$channelsStore.getChannelsForGuild(guild != null ? guild.getId() : -1L).entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it2.next();
                if (((Channel) ((Map.Entry) next2).getValue()).getType() == 14) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next2;
            selectedChannel = entry != null ? (Channel) entry.getValue() : null;
        } else {
            if (!ChannelUtils.m7691o(selectedChannel)) {
                selectedChannel = null;
            }
            if (selectedChannel == null) {
            }
        }
        if (selectedChannel == null) {
            WidgetHubAddServerViewModel.Companion companion2 = WidgetHubAddServerViewModel.INSTANCE;
            AppLog appLog2 = AppLog.f14950g;
            StringBuilder sbM833U2 = outline.m833U("Guild has no directory channels for id: ");
            sbM833U2.append(guild != null ? Long.valueOf(guild.getId()) : null);
            Logger.e$default(appLog2, sbM833U2.toString(), null, null, 6, null);
            selectedChannel = null;
        }
        if (selectedChannel != null) {
            RestCallState<List<DirectoryEntryGuild>> directoriesForChannel = this.$directoriesStore.getDirectoriesForChannel(selectedChannel.getId());
            listInvoke = directoriesForChannel != null ? directoriesForChannel.invoke() : null;
        }
        if (listInvoke == null) {
            listInvoke = Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(listInvoke, 10));
        Iterator it3 = listInvoke.iterator();
        while (it3.hasNext()) {
            arrayList.add(Long.valueOf(((DirectoryEntryGuild) it3.next()).getGuild().getId()));
        }
        Set set = _Collections.toSet(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : collectionValues) {
            if (PermissionUtils.can(8L, (Long) outline.m847e((Guild) obj, guildPermissions))) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj2 : arrayList2) {
            if (!set.contains(Long.valueOf(((Guild) obj2).getId()))) {
                arrayList3.add(obj2);
            } else {
                arrayList4.add(obj2);
            }
        }
        Tuples2 tuples2 = new Tuples2(arrayList3, arrayList4);
        List list = (List) tuples2.component1();
        List list2 = (List) tuples2.component2();
        ArrayList arrayList5 = new ArrayList(Iterables2.collectionSizeOrDefault(list2, 10));
        Iterator it4 = list2.iterator();
        while (it4.hasNext()) {
            arrayList5.add(Long.valueOf(((Guild) it4.next()).getId()));
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object obj3 : listInvoke) {
            if (arrayList5.contains(Long.valueOf(((DirectoryEntryGuild) obj3).getGuild().getId()))) {
                arrayList6.add(obj3);
            }
        }
        String name = guild != null ? guild.getName() : null;
        if (name == null) {
            name = "";
        }
        return new WidgetHubAddServerViewModel2(name, selectedChannel != null ? Long.valueOf(selectedChannel.getId()) : null, 0, list, list2, arrayList6, 4, null);
    }
}
