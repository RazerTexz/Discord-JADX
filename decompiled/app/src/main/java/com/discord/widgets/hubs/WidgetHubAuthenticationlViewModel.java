package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import p001a0.p002a.p003a.C0002b;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.AuthenticationResult, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAuthenticationlViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHubAuthenticationlViewModel implements WidgetHubDomains5 {
    public static final Parcelable.Creator<WidgetHubAuthenticationlViewModel> CREATOR = new Creator();
    private final long guildId;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.AuthenticationResult$Creator */
    public static class Creator implements Parcelable.Creator<WidgetHubAuthenticationlViewModel> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetHubAuthenticationlViewModel(parcel.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAuthenticationlViewModel createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetHubAuthenticationlViewModel[] newArray(int i) {
            return new WidgetHubAuthenticationlViewModel[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetHubAuthenticationlViewModel[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetHubAuthenticationlViewModel(long j) {
        this.guildId = j;
    }

    public static /* synthetic */ WidgetHubAuthenticationlViewModel copy$default(WidgetHubAuthenticationlViewModel widgetHubAuthenticationlViewModel, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = widgetHubAuthenticationlViewModel.guildId;
        }
        return widgetHubAuthenticationlViewModel.copy(j);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    public final WidgetHubAuthenticationlViewModel copy(long guildId) {
        return new WidgetHubAuthenticationlViewModel(guildId);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetHubAuthenticationlViewModel) && this.guildId == ((WidgetHubAuthenticationlViewModel) other).guildId;
        }
        return true;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public int hashCode() {
        return C0002b.m3a(this.guildId);
    }

    public String toString() {
        return outline.m815C(outline.m833U("AuthenticationResult(guildId="), this.guildId, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeLong(this.guildId);
    }
}
