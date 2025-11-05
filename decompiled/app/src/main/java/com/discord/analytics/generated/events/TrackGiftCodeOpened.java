package com.discord.analytics.generated.events;

import b.d.b.a.a;
import com.discord.analytics.generated.traits.TrackBase;
import com.discord.analytics.generated.traits.TrackBaseReceiver;
import com.discord.api.science.AnalyticsSchema;
import d0.z.d.m;

/* compiled from: TrackGiftCodeOpened.kt */
/* loaded from: classes.dex */
public final /* data */ class TrackGiftCodeOpened implements AnalyticsSchema, TrackBaseReceiver {
    private TrackBase trackBase;
    private final CharSequence giftCode = null;
    private final transient String analyticsSchemaTypeName = "gift_code_opened";

    @Override // com.discord.api.science.AnalyticsSchema
    /* renamed from: d, reason: from getter */
    public String getAnalyticsSchemaTypeName() {
        return this.analyticsSchemaTypeName;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof TrackGiftCodeOpened) && m.areEqual(this.giftCode, ((TrackGiftCodeOpened) other).giftCode);
        }
        return true;
    }

    public int hashCode() {
        CharSequence charSequence = this.giftCode;
        if (charSequence != null) {
            return charSequence.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.E(a.U("TrackGiftCodeOpened(giftCode="), this.giftCode, ")");
    }
}
