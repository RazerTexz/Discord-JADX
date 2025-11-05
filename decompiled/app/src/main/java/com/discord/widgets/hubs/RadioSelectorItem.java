package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* compiled from: WidgetRadioSelectorBottomSheet.kt */
/* loaded from: classes2.dex */
public final /* data */ class RadioSelectorItem implements Parcelable {
    public static final Parcelable.Creator<RadioSelectorItem> CREATOR = new Creator();
    private final int id;
    private final boolean selected;
    private final String text;

    public static class Creator implements Parcelable.Creator<RadioSelectorItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RadioSelectorItem createFromParcel(Parcel parcel) {
            m.checkNotNullParameter(parcel, "in");
            return new RadioSelectorItem(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RadioSelectorItem createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final RadioSelectorItem[] newArray(int i) {
            return new RadioSelectorItem[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RadioSelectorItem[] newArray(int i) {
            return newArray(i);
        }
    }

    public RadioSelectorItem(int i, String str, boolean z2) {
        m.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.id = i;
        this.text = str;
        this.selected = z2;
    }

    public static /* synthetic */ RadioSelectorItem copy$default(RadioSelectorItem radioSelectorItem, int i, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = radioSelectorItem.id;
        }
        if ((i2 & 2) != 0) {
            str = radioSelectorItem.text;
        }
        if ((i2 & 4) != 0) {
            z2 = radioSelectorItem.selected;
        }
        return radioSelectorItem.copy(i, str, z2);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final RadioSelectorItem copy(int id2, String text, boolean selected) {
        m.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new RadioSelectorItem(id2, text, selected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RadioSelectorItem)) {
            return false;
        }
        RadioSelectorItem radioSelectorItem = (RadioSelectorItem) other;
        return this.id == radioSelectorItem.id && m.areEqual(this.text, radioSelectorItem.text) && this.selected == radioSelectorItem.selected;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    public final String getText() {
        return this.text;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i = this.id * 31;
        String str = this.text;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.selected;
        int i2 = z2;
        if (z2 != 0) {
            i2 = 1;
        }
        return iHashCode + i2;
    }

    public String toString() {
        StringBuilder sbU = a.U("RadioSelectorItem(id=");
        sbU.append(this.id);
        sbU.append(", text=");
        sbU.append(this.text);
        sbU.append(", selected=");
        return a.O(sbU, this.selected, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        m.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.text);
        parcel.writeInt(this.selected ? 1 : 0);
    }
}
