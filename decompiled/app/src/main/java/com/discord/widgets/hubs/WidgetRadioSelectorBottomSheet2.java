package com.discord.widgets.hubs;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAuditLogEntry;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.hubs.RadioSelectorItem, reason: use source file name */
/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetRadioSelectorBottomSheet2 implements Parcelable {
    public static final Parcelable.Creator<WidgetRadioSelectorBottomSheet2> CREATOR = new Creator();
    private final int id;
    private final boolean selected;
    private final String text;

    /* JADX INFO: renamed from: com.discord.widgets.hubs.RadioSelectorItem$Creator */
    public static class Creator implements Parcelable.Creator<WidgetRadioSelectorBottomSheet2> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet2 createFromParcel(Parcel parcel) {
            Intrinsics3.checkNotNullParameter(parcel, "in");
            return new WidgetRadioSelectorBottomSheet2(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet2 createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WidgetRadioSelectorBottomSheet2[] newArray(int i) {
            return new WidgetRadioSelectorBottomSheet2[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WidgetRadioSelectorBottomSheet2[] newArray(int i) {
            return newArray(i);
        }
    }

    public WidgetRadioSelectorBottomSheet2(int i, String str, boolean z2) {
        Intrinsics3.checkNotNullParameter(str, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        this.id = i;
        this.text = str;
        this.selected = z2;
    }

    public static /* synthetic */ WidgetRadioSelectorBottomSheet2 copy$default(WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2, int i, String str, boolean z2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetRadioSelectorBottomSheet2.id;
        }
        if ((i2 & 2) != 0) {
            str = widgetRadioSelectorBottomSheet2.text;
        }
        if ((i2 & 4) != 0) {
            z2 = widgetRadioSelectorBottomSheet2.selected;
        }
        return widgetRadioSelectorBottomSheet2.copy(i, str, z2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getText() {
        return this.text;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getSelected() {
        return this.selected;
    }

    public final WidgetRadioSelectorBottomSheet2 copy(int id2, String text, boolean selected) {
        Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        return new WidgetRadioSelectorBottomSheet2(id2, text, selected);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetRadioSelectorBottomSheet2)) {
            return false;
        }
        WidgetRadioSelectorBottomSheet2 widgetRadioSelectorBottomSheet2 = (WidgetRadioSelectorBottomSheet2) other;
        return this.id == widgetRadioSelectorBottomSheet2.id && Intrinsics3.areEqual(this.text, widgetRadioSelectorBottomSheet2.text) && this.selected == widgetRadioSelectorBottomSheet2.selected;
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
    /* JADX WARN: Type inference failed for: r1v4, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public int hashCode() {
        int i = this.id * 31;
        String str = this.text;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z2 = this.selected;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("RadioSelectorItem(id=");
        sbM833U.append(this.id);
        sbM833U.append(", text=");
        sbM833U.append(this.text);
        sbM833U.append(", selected=");
        return outline.m827O(sbM833U, this.selected, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int flags) {
        Intrinsics3.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.text);
        parcel.writeInt(this.selected ? 1 : 0);
    }
}
