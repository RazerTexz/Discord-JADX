package com.discord.models.store.dto;

import com.discord.models.domain.ModelAuditLogEntry;
import java.io.Serializable;
import p007b.p100d.p104b.p105a.outline;
import p507d0.p592z.p594d.Intrinsics3;

/* compiled from: ModelStoreAsset.kt */
/* loaded from: classes.dex */
public final /* data */ class ModelStoreAsset implements Serializable {
    private final String filename;
    private final Integer height;
    private final long id;
    private final String mimeType;
    private final int size;
    private final Integer width;

    public ModelStoreAsset(long j, int i, String str, String str2, Integer num, Integer num2) {
        Intrinsics3.checkNotNullParameter(str, "mimeType");
        this.id = j;
        this.size = i;
        this.mimeType = str;
        this.filename = str2;
        this.width = num;
        this.height = num2;
    }

    public static /* synthetic */ ModelStoreAsset copy$default(ModelStoreAsset modelStoreAsset, long j, int i, String str, String str2, Integer num, Integer num2, int i2, Object obj) {
        return modelStoreAsset.copy((i2 & 1) != 0 ? modelStoreAsset.id : j, (i2 & 2) != 0 ? modelStoreAsset.size : i, (i2 & 4) != 0 ? modelStoreAsset.mimeType : str, (i2 & 8) != 0 ? modelStoreAsset.filename : str2, (i2 & 16) != 0 ? modelStoreAsset.width : num, (i2 & 32) != 0 ? modelStoreAsset.height : num2);
    }

    /* renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getFilename() {
        return this.filename;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getWidth() {
        return this.width;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getHeight() {
        return this.height;
    }

    public final ModelStoreAsset copy(long id2, int size, String mimeType, String filename, Integer width, Integer height) {
        Intrinsics3.checkNotNullParameter(mimeType, "mimeType");
        return new ModelStoreAsset(id2, size, mimeType, filename, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelStoreAsset)) {
            return false;
        }
        ModelStoreAsset modelStoreAsset = (ModelStoreAsset) other;
        return this.id == modelStoreAsset.id && this.size == modelStoreAsset.size && Intrinsics3.areEqual(this.mimeType, modelStoreAsset.mimeType) && Intrinsics3.areEqual(this.filename, modelStoreAsset.filename) && Intrinsics3.areEqual(this.width, modelStoreAsset.width) && Intrinsics3.areEqual(this.height, modelStoreAsset.height);
    }

    public final String getFilename() {
        return this.filename;
    }

    public final Integer getHeight() {
        return this.height;
    }

    public final long getId() {
        return this.id;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    public final int getSize() {
        return this.size;
    }

    public final Integer getWidth() {
        return this.width;
    }

    public int hashCode() {
        long j = this.id;
        int i = ((((int) (j ^ (j >>> 32))) * 31) + this.size) * 31;
        String str = this.mimeType;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.width;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        Integer num2 = this.height;
        return iHashCode3 + (num2 != null ? num2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = outline.m833U("ModelStoreAsset(id=");
        sbM833U.append(this.id);
        sbM833U.append(", size=");
        sbM833U.append(this.size);
        sbM833U.append(", mimeType=");
        sbM833U.append(this.mimeType);
        sbM833U.append(", filename=");
        sbM833U.append(this.filename);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return outline.m818F(sbM833U, this.height, ")");
    }
}
