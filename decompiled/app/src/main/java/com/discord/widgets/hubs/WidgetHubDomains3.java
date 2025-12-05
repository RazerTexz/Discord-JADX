package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: WidgetHubDomains.kt */
/* renamed from: com.discord.widgets.hubs.HubDomainArgs, reason: use source file name */
/* loaded from: classes2.dex */
public final /* data */ class WidgetHubDomains3 implements Parcelable {
    public static final Parcelable.Creator<WidgetHubDomains3> CREATOR = new Creator();
    private final String email;
    private final List<WidgetHubDomains2> guildInfos;

    /* renamed from: com.discord.widgets.hubs.HubDomainArgs$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubDomains3> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDomains3 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            String string = parcel.readString();
            int i = parcel.readInt();
            ArrayList arrayList = new ArrayList(i);
            while (i != 0) {
                arrayList.add(WidgetHubDomains2.CREATOR.createFromParcel(parcel));
                i--;
            }
            return new WidgetHubDomains3(string, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDomains3 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubDomains3[] newArray(int i) {
            return new WidgetHubDomains3[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubDomains3[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubDomains3(String str, List<WidgetHubDomains2> list) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(list, "guildInfos");
        this.email = str;
        this.guildInfos = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetHubDomains3 copy$default(WidgetHubDomains3 widgetHubDomains3, String str, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetHubDomains3.email;
        }
        if ((i & 2) != 0) {
            list = widgetHubDomains3.guildInfos;
        }
        return widgetHubDomains3.copy(str, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    public final List<WidgetHubDomains2> component2() {
        return this.guildInfos;
    }

    public final WidgetHubDomains3 copy(String email, List<WidgetHubDomains2> guildInfos) {
        Intrinsics3.checkNotNullParameter(email, NotificationCompat.CATEGORY_EMAIL);
        Intrinsics3.checkNotNullParameter(guildInfos, "guildInfos");
        return new WidgetHubDomains3(email, guildInfos);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHubDomains3)) {
            return false;
        }
        WidgetHubDomains3 widgetHubDomains3 = (WidgetHubDomains3) other;
        return Intrinsics3.areEqual(this.email, widgetHubDomains3.email) && Intrinsics3.areEqual(this.guildInfos, widgetHubDomains3.guildInfos);
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<WidgetHubDomains2> getGuildInfos() {
        return this.guildInfos;
    }

    public int hashCode() {
        String str = this.email;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        List<WidgetHubDomains2> list = this.guildInfos;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("HubDomainArgs(email=");
        sbM833U.append(this.email);
        sbM833U.append(", guildInfos=");
        return outline.m824L(sbM833U, this.guildInfos, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.email);
        List<WidgetHubDomains2> list = this.guildInfos;
        parcel.writeInt(list.size());
        Iterator<WidgetHubDomains2> it = list.iterator();
        while (it.hasNext()) {
            it.next().writeToParcel(parcel, 0);
        }
    }
}
