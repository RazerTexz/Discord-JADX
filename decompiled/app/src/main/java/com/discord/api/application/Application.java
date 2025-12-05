package com.discord.api.application;

import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p579g0.Strings4;
import p507d0.p580t.Collections2;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: Application.kt */
/* loaded from: classes.dex */
public final /* data */ class Application {
    private final String coverImage;
    private final String deeplinkUri;
    private final String description;
    private final Long guildId;
    private final String icon;
    private final long id;
    private final String name;
    private final String splash;
    private final Team team;
    private final List<ThirdPartySku> thirdPartySkus;
    private final ApplicationType type;

    /* renamed from: a */
    public final String m7563a() {
        String strRemoveSuffix;
        String strM883w;
        String str = this.deeplinkUri;
        return (str == null || (strRemoveSuffix = Strings4.removeSuffix(str, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN)) == null || (strM883w = outline.m883w(strRemoveSuffix, "/_discord")) == null) ? outline.m815C(outline.m833U("dscd"), this.id, "://connect/_discord") : strM883w;
    }

    /* renamed from: b, reason: from getter */
    public final String getCoverImage() {
        return this.coverImage;
    }

    /* renamed from: c, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* renamed from: d */
    public final List<String> m7566d() {
        List<ThirdPartySku> list = this.thirdPartySkus;
        if (list == null) {
            return Collections2.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((ThirdPartySku) obj).getDistributor(), "google_play")) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String strM7581b = ((ThirdPartySku) it.next()).getSku();
            if (strM7581b != null) {
                arrayList2.add(strM7581b);
            }
        }
        return arrayList2;
    }

    /* renamed from: e, reason: from getter */
    public final Long getGuildId() {
        return this.guildId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Application)) {
            return false;
        }
        Application application = (Application) other;
        return this.id == application.id && Intrinsics3.areEqual(this.name, application.name) && Intrinsics3.areEqual(this.description, application.description) && Intrinsics3.areEqual(this.splash, application.splash) && Intrinsics3.areEqual(this.coverImage, application.coverImage) && Intrinsics3.areEqual(this.icon, application.icon) && Intrinsics3.areEqual(this.thirdPartySkus, application.thirdPartySkus) && Intrinsics3.areEqual(this.deeplinkUri, application.deeplinkUri) && Intrinsics3.areEqual(this.type, application.type) && Intrinsics3.areEqual(this.guildId, application.guildId) && Intrinsics3.areEqual(this.team, application.team);
    }

    /* renamed from: f, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: g, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((int) (j ^ (j >>> 32))) * 31;
        String str = this.name;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.splash;
        int iHashCode3 = (iHashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.coverImage;
        int iHashCode4 = (iHashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.icon;
        int iHashCode5 = (iHashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        List<ThirdPartySku> list = this.thirdPartySkus;
        int iHashCode6 = (iHashCode5 + (list != null ? list.hashCode() : 0)) * 31;
        String str6 = this.deeplinkUri;
        int iHashCode7 = (iHashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        ApplicationType applicationType = this.type;
        int iHashCode8 = (iHashCode7 + (applicationType != null ? applicationType.hashCode() : 0)) * 31;
        Long l = this.guildId;
        int iHashCode9 = (iHashCode8 + (l != null ? l.hashCode() : 0)) * 31;
        Team team = this.team;
        return iHashCode9 + (team != null ? team.hashCode() : 0);
    }

    /* renamed from: i, reason: from getter */
    public final String getSplash() {
        return this.splash;
    }

    /* renamed from: j, reason: from getter */
    public final ApplicationType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("Application(id=");
        sbM833U.append(this.id);
        sbM833U.append(", name=");
        sbM833U.append(this.name);
        sbM833U.append(", description=");
        sbM833U.append(this.description);
        sbM833U.append(", splash=");
        sbM833U.append(this.splash);
        sbM833U.append(", coverImage=");
        sbM833U.append(this.coverImage);
        sbM833U.append(", icon=");
        sbM833U.append(this.icon);
        sbM833U.append(", thirdPartySkus=");
        sbM833U.append(this.thirdPartySkus);
        sbM833U.append(", deeplinkUri=");
        sbM833U.append(this.deeplinkUri);
        sbM833U.append(", type=");
        sbM833U.append(this.type);
        sbM833U.append(", guildId=");
        sbM833U.append(this.guildId);
        sbM833U.append(", team=");
        sbM833U.append(this.team);
        sbM833U.append(")");
        return sbM833U.toString();
    }
}
